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


public final class GuildShopHandler {
    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static final class GetGuildShopInfoRequest
            extends GeneratedMessage
            implements GetGuildShopInfoRequestOrBuilder {
        private static final GetGuildShopInfoRequest defaultInstance = new GetGuildShopInfoRequest(true);
        private final UnknownFieldSet unknownFields;

        private GetGuildShopInfoRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetGuildShopInfoRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetGuildShopInfoRequest getDefaultInstance() {
            return defaultInstance;
        }

        public GetGuildShopInfoRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetGuildShopInfoRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return GuildShopHandler.internal_static_pomelo_area_GetGuildShopInfoRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return GuildShopHandler.internal_static_pomelo_area_GetGuildShopInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetGuildShopInfoRequest.class, Builder.class);
        }

        public static Parser<GetGuildShopInfoRequest> PARSER = (Parser<GetGuildShopInfoRequest>) new AbstractParser<GetGuildShopInfoRequest>() {
            public GuildShopHandler.GetGuildShopInfoRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GuildShopHandler.GetGuildShopInfoRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetGuildShopInfoRequest> getParserForType() {
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


        public static GetGuildShopInfoRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetGuildShopInfoRequest) PARSER.parseFrom(data);
        }


        public static GetGuildShopInfoRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetGuildShopInfoRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetGuildShopInfoRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetGuildShopInfoRequest) PARSER.parseFrom(data);
        }


        public static GetGuildShopInfoRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetGuildShopInfoRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetGuildShopInfoRequest parseFrom(InputStream input) throws IOException {
            return (GetGuildShopInfoRequest) PARSER.parseFrom(input);
        }


        public static GetGuildShopInfoRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetGuildShopInfoRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static GetGuildShopInfoRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (GetGuildShopInfoRequest) PARSER.parseDelimitedFrom(input);
        }


        public static GetGuildShopInfoRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetGuildShopInfoRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static GetGuildShopInfoRequest parseFrom(CodedInputStream input) throws IOException {
            return (GetGuildShopInfoRequest) PARSER.parseFrom(input);
        }


        public static GetGuildShopInfoRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetGuildShopInfoRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(GetGuildShopInfoRequest prototype) {
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
                implements GuildShopHandler.GetGuildShopInfoRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return GuildShopHandler.internal_static_pomelo_area_GetGuildShopInfoRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return GuildShopHandler.internal_static_pomelo_area_GetGuildShopInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildShopHandler.GetGuildShopInfoRequest.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (GuildShopHandler.GetGuildShopInfoRequest.alwaysUseFieldBuilders) ;
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
                return GuildShopHandler.internal_static_pomelo_area_GetGuildShopInfoRequest_descriptor;
            }


            public GuildShopHandler.GetGuildShopInfoRequest getDefaultInstanceForType() {
                return GuildShopHandler.GetGuildShopInfoRequest.getDefaultInstance();
            }


            public GuildShopHandler.GetGuildShopInfoRequest build() {
                GuildShopHandler.GetGuildShopInfoRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public GuildShopHandler.GetGuildShopInfoRequest buildPartial() {
                GuildShopHandler.GetGuildShopInfoRequest result = new GuildShopHandler.GetGuildShopInfoRequest(this);
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof GuildShopHandler.GetGuildShopInfoRequest) {
                    return mergeFrom((GuildShopHandler.GetGuildShopInfoRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(GuildShopHandler.GetGuildShopInfoRequest other) {
                if (other == GuildShopHandler.GetGuildShopInfoRequest.getDefaultInstance()) {
                    return this;
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                GuildShopHandler.GetGuildShopInfoRequest parsedMessage = null;
                try {
                    parsedMessage = (GuildShopHandler.GetGuildShopInfoRequest) GuildShopHandler.GetGuildShopInfoRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (GuildShopHandler.GetGuildShopInfoRequest) e.getUnfinishedMessage();
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


    public static final class ExchangeShopItemRequest
            extends GeneratedMessage
            implements ExchangeShopItemRequestOrBuilder {
        private static final ExchangeShopItemRequest defaultInstance = new ExchangeShopItemRequest(true);
        private final UnknownFieldSet unknownFields;

        private ExchangeShopItemRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private ExchangeShopItemRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static ExchangeShopItemRequest getDefaultInstance() {
            return defaultInstance;
        }

        public ExchangeShopItemRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ExchangeShopItemRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return GuildShopHandler.internal_static_pomelo_area_ExchangeShopItemRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return GuildShopHandler.internal_static_pomelo_area_ExchangeShopItemRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ExchangeShopItemRequest.class, Builder.class);
        }

        public static Parser<ExchangeShopItemRequest> PARSER = (Parser<ExchangeShopItemRequest>) new AbstractParser<ExchangeShopItemRequest>() {
            public GuildShopHandler.ExchangeShopItemRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GuildShopHandler.ExchangeShopItemRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int ID_FIELD_NUMBER = 1;
        private int id_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<ExchangeShopItemRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getId() {
            return this.id_;
        }

        private void initFields() {
            this.id_ = 0;
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
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeInt32(1, this.id_);
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
                size += CodedOutputStream.computeInt32Size(1, this.id_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static ExchangeShopItemRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ExchangeShopItemRequest) PARSER.parseFrom(data);
        }


        public static ExchangeShopItemRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ExchangeShopItemRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static ExchangeShopItemRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ExchangeShopItemRequest) PARSER.parseFrom(data);
        }


        public static ExchangeShopItemRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ExchangeShopItemRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static ExchangeShopItemRequest parseFrom(InputStream input) throws IOException {
            return (ExchangeShopItemRequest) PARSER.parseFrom(input);
        }


        public static ExchangeShopItemRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ExchangeShopItemRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static ExchangeShopItemRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (ExchangeShopItemRequest) PARSER.parseDelimitedFrom(input);
        }


        public static ExchangeShopItemRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ExchangeShopItemRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static ExchangeShopItemRequest parseFrom(CodedInputStream input) throws IOException {
            return (ExchangeShopItemRequest) PARSER.parseFrom(input);
        }


        public static ExchangeShopItemRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ExchangeShopItemRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(ExchangeShopItemRequest prototype) {
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
                implements GuildShopHandler.ExchangeShopItemRequestOrBuilder {
            private int bitField0_;


            private int id_;


            public static final Descriptors.Descriptor getDescriptor() {
                return GuildShopHandler.internal_static_pomelo_area_ExchangeShopItemRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return GuildShopHandler.internal_static_pomelo_area_ExchangeShopItemRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildShopHandler.ExchangeShopItemRequest.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (GuildShopHandler.ExchangeShopItemRequest.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.id_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return GuildShopHandler.internal_static_pomelo_area_ExchangeShopItemRequest_descriptor;
            }


            public GuildShopHandler.ExchangeShopItemRequest getDefaultInstanceForType() {
                return GuildShopHandler.ExchangeShopItemRequest.getDefaultInstance();
            }


            public GuildShopHandler.ExchangeShopItemRequest build() {
                GuildShopHandler.ExchangeShopItemRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public GuildShopHandler.ExchangeShopItemRequest buildPartial() {
                GuildShopHandler.ExchangeShopItemRequest result = new GuildShopHandler.ExchangeShopItemRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.id_ = this.id_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof GuildShopHandler.ExchangeShopItemRequest) {
                    return mergeFrom((GuildShopHandler.ExchangeShopItemRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(GuildShopHandler.ExchangeShopItemRequest other) {
                if (other == GuildShopHandler.ExchangeShopItemRequest.getDefaultInstance()) {
                    return this;
                }
                if (other.hasId()) {
                    setId(other.getId());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                GuildShopHandler.ExchangeShopItemRequest parsedMessage = null;
                try {
                    parsedMessage = (GuildShopHandler.ExchangeShopItemRequest) GuildShopHandler.ExchangeShopItemRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (GuildShopHandler.ExchangeShopItemRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
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
        }
    }


    public static final class ShopMoneyInfo
            extends GeneratedMessage
            implements ShopMoneyInfoOrBuilder {
        private static final ShopMoneyInfo defaultInstance = new ShopMoneyInfo(true);
        private final UnknownFieldSet unknownFields;

        private ShopMoneyInfo(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private ShopMoneyInfo(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static ShopMoneyInfo getDefaultInstance() {
            return defaultInstance;
        }

        public ShopMoneyInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ShopMoneyInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.type_ = input.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.value_ = input.readInt32();
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
            return GuildShopHandler.internal_static_pomelo_area_ShopMoneyInfo_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return GuildShopHandler.internal_static_pomelo_area_ShopMoneyInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ShopMoneyInfo.class, Builder.class);
        }

        public static Parser<ShopMoneyInfo> PARSER = (Parser<ShopMoneyInfo>) new AbstractParser<ShopMoneyInfo>() {
            public GuildShopHandler.ShopMoneyInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GuildShopHandler.ShopMoneyInfo(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int TYPE_FIELD_NUMBER = 1;
        private int type_;
        public static final int VALUE_FIELD_NUMBER = 2;
        private int value_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<ShopMoneyInfo> getParserForType() {
            return PARSER;
        }

        public boolean hasType() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getType() {
            return this.type_;
        }

        public boolean hasValue() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        static {
            defaultInstance.initFields();
        }


        public int getValue() {
            return this.value_;
        }


        private void initFields() {
            this.type_ = 0;
            this.value_ = 0;
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasType()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasValue()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeInt32(1, this.type_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeInt32(2, this.value_);
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
                size += CodedOutputStream.computeInt32Size(1, this.type_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeInt32Size(2, this.value_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static ShopMoneyInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ShopMoneyInfo) PARSER.parseFrom(data);
        }


        public static ShopMoneyInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ShopMoneyInfo) PARSER.parseFrom(data, extensionRegistry);
        }


        public static ShopMoneyInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ShopMoneyInfo) PARSER.parseFrom(data);
        }


        public static ShopMoneyInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ShopMoneyInfo) PARSER.parseFrom(data, extensionRegistry);
        }


        public static ShopMoneyInfo parseFrom(InputStream input) throws IOException {
            return (ShopMoneyInfo) PARSER.parseFrom(input);
        }


        public static ShopMoneyInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ShopMoneyInfo) PARSER.parseFrom(input, extensionRegistry);
        }


        public static ShopMoneyInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (ShopMoneyInfo) PARSER.parseDelimitedFrom(input);
        }


        public static ShopMoneyInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ShopMoneyInfo) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static ShopMoneyInfo parseFrom(CodedInputStream input) throws IOException {
            return (ShopMoneyInfo) PARSER.parseFrom(input);
        }


        public static ShopMoneyInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ShopMoneyInfo) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(ShopMoneyInfo prototype) {
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
                implements GuildShopHandler.ShopMoneyInfoOrBuilder {
            private int bitField0_;


            private int type_;


            private int value_;


            public static final Descriptors.Descriptor getDescriptor() {
                return GuildShopHandler.internal_static_pomelo_area_ShopMoneyInfo_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return GuildShopHandler.internal_static_pomelo_area_ShopMoneyInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildShopHandler.ShopMoneyInfo.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (GuildShopHandler.ShopMoneyInfo.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.type_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.value_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return GuildShopHandler.internal_static_pomelo_area_ShopMoneyInfo_descriptor;
            }


            public GuildShopHandler.ShopMoneyInfo getDefaultInstanceForType() {
                return GuildShopHandler.ShopMoneyInfo.getDefaultInstance();
            }


            public GuildShopHandler.ShopMoneyInfo build() {
                GuildShopHandler.ShopMoneyInfo result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public GuildShopHandler.ShopMoneyInfo buildPartial() {
                GuildShopHandler.ShopMoneyInfo result = new GuildShopHandler.ShopMoneyInfo(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.type_ = this.type_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.value_ = this.value_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof GuildShopHandler.ShopMoneyInfo) {
                    return mergeFrom((GuildShopHandler.ShopMoneyInfo) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(GuildShopHandler.ShopMoneyInfo other) {
                if (other == GuildShopHandler.ShopMoneyInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.hasType()) {
                    setType(other.getType());
                }
                if (other.hasValue()) {
                    setValue(other.getValue());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasType()) {
                    return false;
                }
                if (!hasValue()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                GuildShopHandler.ShopMoneyInfo parsedMessage = null;
                try {
                    parsedMessage = (GuildShopHandler.ShopMoneyInfo) GuildShopHandler.ShopMoneyInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (GuildShopHandler.ShopMoneyInfo) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasType() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public int getType() {
                return this.type_;
            }


            public Builder setType(int value) {
                this.bitField0_ |= 0x1;
                this.type_ = value;
                onChanged();
                return this;
            }


            public Builder clearType() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.type_ = 0;
                onChanged();
                return this;
            }


            public boolean hasValue() {
                return ((this.bitField0_ & 0x2) == 2);
            }


            public int getValue() {
                return this.value_;
            }


            public Builder setValue(int value) {
                this.bitField0_ |= 0x2;
                this.value_ = value;
                onChanged();
                return this;
            }


            public Builder clearValue() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.value_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class ShopCondition
            extends GeneratedMessage
            implements ShopConditionOrBuilder {
        private static final ShopCondition defaultInstance = new ShopCondition(true);
        private final UnknownFieldSet unknownFields;

        private ShopCondition(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private ShopCondition(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static ShopCondition getDefaultInstance() {
            return defaultInstance;
        }

        public ShopCondition getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ShopCondition(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.type_ = input.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.number_ = input.readInt32();
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
            return GuildShopHandler.internal_static_pomelo_area_ShopCondition_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return GuildShopHandler.internal_static_pomelo_area_ShopCondition_fieldAccessorTable.ensureFieldAccessorsInitialized(ShopCondition.class, Builder.class);
        }

        public static Parser<ShopCondition> PARSER = (Parser<ShopCondition>) new AbstractParser<ShopCondition>() {
            public GuildShopHandler.ShopCondition parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GuildShopHandler.ShopCondition(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int TYPE_FIELD_NUMBER = 1;
        private int type_;
        public static final int NUMBER_FIELD_NUMBER = 2;
        private int number_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<ShopCondition> getParserForType() {
            return PARSER;
        }

        public boolean hasType() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getType() {
            return this.type_;
        }

        public boolean hasNumber() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        static {
            defaultInstance.initFields();
        }


        public int getNumber() {
            return this.number_;
        }


        private void initFields() {
            this.type_ = 0;
            this.number_ = 0;
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
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeInt32(1, this.type_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeInt32(2, this.number_);
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
                size += CodedOutputStream.computeInt32Size(1, this.type_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeInt32Size(2, this.number_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static ShopCondition parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ShopCondition) PARSER.parseFrom(data);
        }


        public static ShopCondition parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ShopCondition) PARSER.parseFrom(data, extensionRegistry);
        }


        public static ShopCondition parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ShopCondition) PARSER.parseFrom(data);
        }


        public static ShopCondition parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ShopCondition) PARSER.parseFrom(data, extensionRegistry);
        }


        public static ShopCondition parseFrom(InputStream input) throws IOException {
            return (ShopCondition) PARSER.parseFrom(input);
        }


        public static ShopCondition parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ShopCondition) PARSER.parseFrom(input, extensionRegistry);
        }


        public static ShopCondition parseDelimitedFrom(InputStream input) throws IOException {
            return (ShopCondition) PARSER.parseDelimitedFrom(input);
        }


        public static ShopCondition parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ShopCondition) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static ShopCondition parseFrom(CodedInputStream input) throws IOException {
            return (ShopCondition) PARSER.parseFrom(input);
        }


        public static ShopCondition parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ShopCondition) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(ShopCondition prototype) {
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
                implements GuildShopHandler.ShopConditionOrBuilder {
            private int bitField0_;


            private int type_;


            private int number_;


            public static final Descriptors.Descriptor getDescriptor() {
                return GuildShopHandler.internal_static_pomelo_area_ShopCondition_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return GuildShopHandler.internal_static_pomelo_area_ShopCondition_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildShopHandler.ShopCondition.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (GuildShopHandler.ShopCondition.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.type_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.number_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return GuildShopHandler.internal_static_pomelo_area_ShopCondition_descriptor;
            }


            public GuildShopHandler.ShopCondition getDefaultInstanceForType() {
                return GuildShopHandler.ShopCondition.getDefaultInstance();
            }


            public GuildShopHandler.ShopCondition build() {
                GuildShopHandler.ShopCondition result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public GuildShopHandler.ShopCondition buildPartial() {
                GuildShopHandler.ShopCondition result = new GuildShopHandler.ShopCondition(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.type_ = this.type_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.number_ = this.number_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof GuildShopHandler.ShopCondition) {
                    return mergeFrom((GuildShopHandler.ShopCondition) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(GuildShopHandler.ShopCondition other) {
                if (other == GuildShopHandler.ShopCondition.getDefaultInstance()) {
                    return this;
                }
                if (other.hasType()) {
                    setType(other.getType());
                }
                if (other.hasNumber()) {
                    setNumber(other.getNumber());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                GuildShopHandler.ShopCondition parsedMessage = null;
                try {
                    parsedMessage = (GuildShopHandler.ShopCondition) GuildShopHandler.ShopCondition.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (GuildShopHandler.ShopCondition) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasType() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public int getType() {
                return this.type_;
            }


            public Builder setType(int value) {
                this.bitField0_ |= 0x1;
                this.type_ = value;
                onChanged();
                return this;
            }


            public Builder clearType() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.type_ = 0;
                onChanged();
                return this;
            }


            public boolean hasNumber() {
                return ((this.bitField0_ & 0x2) == 2);
            }


            public int getNumber() {
                return this.number_;
            }


            public Builder setNumber(int value) {
                this.bitField0_ |= 0x2;
                this.number_ = value;
                onChanged();
                return this;
            }


            public Builder clearNumber() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.number_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class ExchangeItem
            extends GeneratedMessage
            implements ExchangeItemOrBuilder {
        private static final ExchangeItem defaultInstance = new ExchangeItem(true);
        private final UnknownFieldSet unknownFields;

        private ExchangeItem(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private ExchangeItem(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static ExchangeItem getDefaultInstance() {
            return defaultInstance;
        }

        public ExchangeItem getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ExchangeItem(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString byteString1;
                    ItemOuterClass.MiniItem.Builder subBuilder;
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
                            byteString1 = input.readBytes();
                            this.bitField0_ |= 0x2;
                            this.itemShowName_ = byteString1;
                            break;
                        case 26:
                            subBuilder = null;
                            if ((this.bitField0_ & 0x4) == 4) subBuilder = this.item_.toBuilder();
                            this.item_ = (ItemOuterClass.MiniItem) input.readMessage(ItemOuterClass.MiniItem.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.item_);
                                this.item_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 0x4;
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.isBind_ = input.readInt32();
                            break;
                        case 42:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x10;
                            this.itemDes_ = bs;
                            break;
                        case 50:
                            if ((mutable_bitField0_ & 0x20) != 32) {
                                this.needMoney_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x20;
                            }
                            this.needMoney_.add(input.readMessage(GuildShopHandler.ShopMoneyInfo.PARSER, extensionRegistry));
                            break;
                        case 56:
                            this.bitField0_ |= 0x20;
                            this.state_ = input.readInt32();
                            break;
                        case 66:
                            if ((mutable_bitField0_ & 0x80) != 128) {
                                this.condition_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x80;
                            }
                            this.condition_.add(input.readMessage(GuildShopHandler.ShopCondition.PARSER, extensionRegistry));
                            break;
                        case 72:
                            this.bitField0_ |= 0x40;
                            this.meetCondition_ = input.readInt32();
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x20) == 32) this.needMoney_ = Collections.unmodifiableList(this.needMoney_);
                if ((mutable_bitField0_ & 0x80) == 128) this.condition_ = Collections.unmodifiableList(this.condition_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GuildShopHandler.internal_static_pomelo_area_ExchangeItem_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return GuildShopHandler.internal_static_pomelo_area_ExchangeItem_fieldAccessorTable.ensureFieldAccessorsInitialized(ExchangeItem.class, Builder.class);
        }

        public static Parser<ExchangeItem> PARSER = (Parser<ExchangeItem>) new AbstractParser<ExchangeItem>() {
            public GuildShopHandler.ExchangeItem parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GuildShopHandler.ExchangeItem(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int ID_FIELD_NUMBER = 1;
        private int id_;
        public static final int ITEMSHOWNAME_FIELD_NUMBER = 2;
        private Object itemShowName_;
        public static final int ITEM_FIELD_NUMBER = 3;
        private ItemOuterClass.MiniItem item_;
        public static final int ISBIND_FIELD_NUMBER = 4;
        private int isBind_;
        public static final int ITEMDES_FIELD_NUMBER = 5;

        static {
            defaultInstance.initFields();
        }


        private Object itemDes_;


        public static final int NEEDMONEY_FIELD_NUMBER = 6;


        private List<GuildShopHandler.ShopMoneyInfo> needMoney_;


        public static final int STATE_FIELD_NUMBER = 7;


        private int state_;


        public static final int CONDITION_FIELD_NUMBER = 8;


        private List<GuildShopHandler.ShopCondition> condition_;


        public static final int MEETCONDITION_FIELD_NUMBER = 9;


        private int meetCondition_;


        private byte memoizedIsInitialized;


        private int memoizedSerializedSize;


        private static final long serialVersionUID = 0L;


        public Parser<ExchangeItem> getParserForType() {
            return PARSER;
        }


        public boolean hasId() {
            return ((this.bitField0_ & 0x1) == 1);
        }


        public int getId() {
            return this.id_;
        }


        public boolean hasItemShowName() {
            return ((this.bitField0_ & 0x2) == 2);
        }


        public String getItemShowName() {
            Object ref = this.itemShowName_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.itemShowName_ = s;
            }
            return s;
        }


        public ByteString getItemShowNameBytes() {
            Object ref = this.itemShowName_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.itemShowName_ = b;
                return b;
            }
            return (ByteString) ref;
        }


        public boolean hasItem() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public ItemOuterClass.MiniItem getItem() {
            return this.item_;
        }


        public ItemOuterClass.MiniItemOrBuilder getItemOrBuilder() {
            return (ItemOuterClass.MiniItemOrBuilder) this.item_;
        }


        public boolean hasIsBind() {
            return ((this.bitField0_ & 0x8) == 8);
        }


        public int getIsBind() {
            return this.isBind_;
        }


        public boolean hasItemDes() {
            return ((this.bitField0_ & 0x10) == 16);
        }


        public String getItemDes() {
            Object ref = this.itemDes_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.itemDes_ = s;
            }
            return s;
        }


        public ByteString getItemDesBytes() {
            Object ref = this.itemDes_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.itemDes_ = b;
                return b;
            }
            return (ByteString) ref;
        }


        public List<GuildShopHandler.ShopMoneyInfo> getNeedMoneyList() {
            return this.needMoney_;
        }


        public List<? extends GuildShopHandler.ShopMoneyInfoOrBuilder> getNeedMoneyOrBuilderList() {
            return (List) this.needMoney_;
        }


        public int getNeedMoneyCount() {
            return this.needMoney_.size();
        }


        public GuildShopHandler.ShopMoneyInfo getNeedMoney(int index) {
            return this.needMoney_.get(index);
        }


        public GuildShopHandler.ShopMoneyInfoOrBuilder getNeedMoneyOrBuilder(int index) {
            return this.needMoney_.get(index);
        }


        public boolean hasState() {
            return ((this.bitField0_ & 0x20) == 32);
        }


        public int getState() {
            return this.state_;
        }


        public List<GuildShopHandler.ShopCondition> getConditionList() {
            return this.condition_;
        }


        public List<? extends GuildShopHandler.ShopConditionOrBuilder> getConditionOrBuilderList() {
            return (List) this.condition_;
        }


        public int getConditionCount() {
            return this.condition_.size();
        }


        public GuildShopHandler.ShopCondition getCondition(int index) {
            return this.condition_.get(index);
        }


        public GuildShopHandler.ShopConditionOrBuilder getConditionOrBuilder(int index) {
            return this.condition_.get(index);
        }


        public boolean hasMeetCondition() {
            return ((this.bitField0_ & 0x40) == 64);
        }


        public int getMeetCondition() {
            return this.meetCondition_;
        }


        private void initFields() {
            this.id_ = 0;
            this.itemShowName_ = "";
            this.item_ = ItemOuterClass.MiniItem.getDefaultInstance();
            this.isBind_ = 0;
            this.itemDes_ = "";
            this.needMoney_ = Collections.emptyList();
            this.state_ = 0;
            this.condition_ = Collections.emptyList();
            this.meetCondition_ = 0;
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (hasItem() && !getItem().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (int i = 0; i < getNeedMoneyCount(); i++) {
                if (!getNeedMoney(i).isInitialized()) {
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
                output.writeInt32(1, this.id_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeBytes(2, getItemShowNameBytes());
            }
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeMessage(3, (MessageLite) this.item_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                output.writeInt32(4, this.isBind_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                output.writeBytes(5, getItemDesBytes());
            }
            int i;
            for (i = 0; i < this.needMoney_.size(); i++) {
                output.writeMessage(6, (MessageLite) this.needMoney_.get(i));
            }
            if ((this.bitField0_ & 0x20) == 32) {
                output.writeInt32(7, this.state_);
            }
            for (i = 0; i < this.condition_.size(); i++) {
                output.writeMessage(8, (MessageLite) this.condition_.get(i));
            }
            if ((this.bitField0_ & 0x40) == 64) {
                output.writeInt32(9, this.meetCondition_);
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
                size += CodedOutputStream.computeInt32Size(1, this.id_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeBytesSize(2, getItemShowNameBytes());
            }
            if ((this.bitField0_ & 0x4) == 4) {
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.item_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                size += CodedOutputStream.computeInt32Size(4, this.isBind_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                size += CodedOutputStream.computeBytesSize(5, getItemDesBytes());
            }
            int i;
            for (i = 0; i < this.needMoney_.size(); i++) {
                size += CodedOutputStream.computeMessageSize(6, (MessageLite) this.needMoney_.get(i));
            }
            if ((this.bitField0_ & 0x20) == 32) {
                size += CodedOutputStream.computeInt32Size(7, this.state_);
            }
            for (i = 0; i < this.condition_.size(); i++) {
                size += CodedOutputStream.computeMessageSize(8, (MessageLite) this.condition_.get(i));
            }
            if ((this.bitField0_ & 0x40) == 64) {
                size += CodedOutputStream.computeInt32Size(9, this.meetCondition_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static ExchangeItem parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ExchangeItem) PARSER.parseFrom(data);
        }


        public static ExchangeItem parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ExchangeItem) PARSER.parseFrom(data, extensionRegistry);
        }


        public static ExchangeItem parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ExchangeItem) PARSER.parseFrom(data);
        }


        public static ExchangeItem parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ExchangeItem) PARSER.parseFrom(data, extensionRegistry);
        }


        public static ExchangeItem parseFrom(InputStream input) throws IOException {
            return (ExchangeItem) PARSER.parseFrom(input);
        }


        public static ExchangeItem parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ExchangeItem) PARSER.parseFrom(input, extensionRegistry);
        }


        public static ExchangeItem parseDelimitedFrom(InputStream input) throws IOException {
            return (ExchangeItem) PARSER.parseDelimitedFrom(input);
        }


        public static ExchangeItem parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ExchangeItem) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static ExchangeItem parseFrom(CodedInputStream input) throws IOException {
            return (ExchangeItem) PARSER.parseFrom(input);
        }


        public static ExchangeItem parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ExchangeItem) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(ExchangeItem prototype) {
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
                implements GuildShopHandler.ExchangeItemOrBuilder {
            private int bitField0_;


            private int id_;


            private Object itemShowName_;


            private ItemOuterClass.MiniItem item_;


            private SingleFieldBuilder<ItemOuterClass.MiniItem, ItemOuterClass.MiniItem.Builder, ItemOuterClass.MiniItemOrBuilder> itemBuilder_;


            private int isBind_;


            private Object itemDes_;


            private List<GuildShopHandler.ShopMoneyInfo> needMoney_;


            private RepeatedFieldBuilder<GuildShopHandler.ShopMoneyInfo, GuildShopHandler.ShopMoneyInfo.Builder, GuildShopHandler.ShopMoneyInfoOrBuilder> needMoneyBuilder_;


            private int state_;


            private List<GuildShopHandler.ShopCondition> condition_;


            private RepeatedFieldBuilder<GuildShopHandler.ShopCondition, GuildShopHandler.ShopCondition.Builder, GuildShopHandler.ShopConditionOrBuilder> conditionBuilder_;


            private int meetCondition_;


            public static final Descriptors.Descriptor getDescriptor() {
                return GuildShopHandler.internal_static_pomelo_area_ExchangeItem_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return GuildShopHandler.internal_static_pomelo_area_ExchangeItem_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildShopHandler.ExchangeItem.class, Builder.class);
            }


            private Builder() {
                this.itemShowName_ = "";
                this.item_ = ItemOuterClass.MiniItem.getDefaultInstance();
                this.itemDes_ = "";
                this.needMoney_ = Collections.emptyList();
                this.condition_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.itemShowName_ = "";
                this.item_ = ItemOuterClass.MiniItem.getDefaultInstance();
                this.itemDes_ = "";
                this.needMoney_ = Collections.emptyList();
                this.condition_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (GuildShopHandler.ExchangeItem.alwaysUseFieldBuilders) {
                    getItemFieldBuilder();
                    getNeedMoneyFieldBuilder();
                    getConditionFieldBuilder();
                }
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.id_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.itemShowName_ = "";
                this.bitField0_ &= 0xFFFFFFFD;
                if (this.itemBuilder_ == null) {
                    this.item_ = ItemOuterClass.MiniItem.getDefaultInstance();
                } else {
                    this.itemBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                this.isBind_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                this.itemDes_ = "";
                this.bitField0_ &= 0xFFFFFFEF;
                if (this.needMoneyBuilder_ == null) {
                    this.needMoney_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFDF;
                } else {
                    this.needMoneyBuilder_.clear();
                }
                this.state_ = 0;
                this.bitField0_ &= 0xFFFFFFBF;
                if (this.conditionBuilder_ == null) {
                    this.condition_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFF7F;
                } else {
                    this.conditionBuilder_.clear();
                }
                this.meetCondition_ = 0;
                this.bitField0_ &= 0xFFFFFEFF;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return GuildShopHandler.internal_static_pomelo_area_ExchangeItem_descriptor;
            }


            public GuildShopHandler.ExchangeItem getDefaultInstanceForType() {
                return GuildShopHandler.ExchangeItem.getDefaultInstance();
            }


            public GuildShopHandler.ExchangeItem build() {
                GuildShopHandler.ExchangeItem result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public GuildShopHandler.ExchangeItem buildPartial() {
                GuildShopHandler.ExchangeItem result = new GuildShopHandler.ExchangeItem(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.id_ = this.id_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.itemShowName_ = this.itemShowName_;
                if ((from_bitField0_ & 0x4) == 4) {
                    to_bitField0_ |= 0x4;
                }
                if (this.itemBuilder_ == null) {
                    result.item_ = this.item_;
                } else {
                    result.item_ = (ItemOuterClass.MiniItem) this.itemBuilder_.build();
                }
                if ((from_bitField0_ & 0x8) == 8) {
                    to_bitField0_ |= 0x8;
                }
                result.isBind_ = this.isBind_;
                if ((from_bitField0_ & 0x10) == 16) {
                    to_bitField0_ |= 0x10;
                }
                result.itemDes_ = this.itemDes_;
                if (this.needMoneyBuilder_ == null) {
                    if ((this.bitField0_ & 0x20) == 32) {
                        this.needMoney_ = Collections.unmodifiableList(this.needMoney_);
                        this.bitField0_ &= 0xFFFFFFDF;
                    }
                    result.needMoney_ = this.needMoney_;
                } else {
                    result.needMoney_ = this.needMoneyBuilder_.build();
                }
                if ((from_bitField0_ & 0x40) == 64) {
                    to_bitField0_ |= 0x20;
                }
                result.state_ = this.state_;
                if (this.conditionBuilder_ == null) {
                    if ((this.bitField0_ & 0x80) == 128) {
                        this.condition_ = Collections.unmodifiableList(this.condition_);
                        this.bitField0_ &= 0xFFFFFF7F;
                    }
                    result.condition_ = this.condition_;
                } else {
                    result.condition_ = this.conditionBuilder_.build();
                }
                if ((from_bitField0_ & 0x100) == 256) {
                    to_bitField0_ |= 0x40;
                }
                result.meetCondition_ = this.meetCondition_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof GuildShopHandler.ExchangeItem) {
                    return mergeFrom((GuildShopHandler.ExchangeItem) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(GuildShopHandler.ExchangeItem other) {
                if (other == GuildShopHandler.ExchangeItem.getDefaultInstance()) {
                    return this;
                }
                if (other.hasId()) {
                    setId(other.getId());
                }
                if (other.hasItemShowName()) {
                    this.bitField0_ |= 0x2;
                    this.itemShowName_ = other.itemShowName_;
                    onChanged();
                }
                if (other.hasItem()) {
                    mergeItem(other.getItem());
                }
                if (other.hasIsBind()) {
                    setIsBind(other.getIsBind());
                }
                if (other.hasItemDes()) {
                    this.bitField0_ |= 0x10;
                    this.itemDes_ = other.itemDes_;
                    onChanged();
                }
                if (this.needMoneyBuilder_ == null) {
                    if (!other.needMoney_.isEmpty()) {
                        if (this.needMoney_.isEmpty()) {
                            this.needMoney_ = other.needMoney_;
                            this.bitField0_ &= 0xFFFFFFDF;
                        } else {
                            ensureNeedMoneyIsMutable();
                            this.needMoney_.addAll(other.needMoney_);
                        }
                        onChanged();
                    }
                } else if (!other.needMoney_.isEmpty()) {
                    if (this.needMoneyBuilder_.isEmpty()) {
                        this.needMoneyBuilder_.dispose();
                        this.needMoneyBuilder_ = null;
                        this.needMoney_ = other.needMoney_;
                        this.bitField0_ &= 0xFFFFFFDF;
                        this.needMoneyBuilder_ = GuildShopHandler.ExchangeItem.alwaysUseFieldBuilders ? getNeedMoneyFieldBuilder() : null;
                    } else {
                        this.needMoneyBuilder_.addAllMessages(other.needMoney_);
                    }
                }
                if (other.hasState()) {
                    setState(other.getState());
                }
                if (this.conditionBuilder_ == null) {
                    if (!other.condition_.isEmpty()) {
                        if (this.condition_.isEmpty()) {
                            this.condition_ = other.condition_;
                            this.bitField0_ &= 0xFFFFFF7F;
                        } else {
                            ensureConditionIsMutable();
                            this.condition_.addAll(other.condition_);
                        }
                        onChanged();
                    }
                } else if (!other.condition_.isEmpty()) {
                    if (this.conditionBuilder_.isEmpty()) {
                        this.conditionBuilder_.dispose();
                        this.conditionBuilder_ = null;
                        this.condition_ = other.condition_;
                        this.bitField0_ &= 0xFFFFFF7F;
                        this.conditionBuilder_ = GuildShopHandler.ExchangeItem.alwaysUseFieldBuilders ? getConditionFieldBuilder() : null;
                    } else {
                        this.conditionBuilder_.addAllMessages(other.condition_);
                    }
                }
                if (other.hasMeetCondition()) {
                    setMeetCondition(other.getMeetCondition());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (hasItem() && !getItem().isInitialized()) {
                    return false;
                }
                for (int i = 0; i < getNeedMoneyCount(); i++) {
                    if (!getNeedMoney(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                GuildShopHandler.ExchangeItem parsedMessage = null;
                try {
                    parsedMessage = (GuildShopHandler.ExchangeItem) GuildShopHandler.ExchangeItem.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (GuildShopHandler.ExchangeItem) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
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


            public boolean hasItemShowName() {
                return ((this.bitField0_ & 0x2) == 2);
            }


            public String getItemShowName() {
                Object ref = this.itemShowName_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.itemShowName_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }


            public ByteString getItemShowNameBytes() {
                Object ref = this.itemShowName_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.itemShowName_ = b;
                    return b;
                }
                return (ByteString) ref;
            }


            public Builder setItemShowName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x2;
                this.itemShowName_ = value;
                onChanged();
                return this;
            }


            public Builder clearItemShowName() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.itemShowName_ = GuildShopHandler.ExchangeItem.getDefaultInstance().getItemShowName();
                onChanged();
                return this;
            }


            public Builder setItemShowNameBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x2;
                this.itemShowName_ = value;
                onChanged();
                return this;
            }


            public boolean hasItem() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public ItemOuterClass.MiniItem getItem() {
                if (this.itemBuilder_ == null) {
                    return this.item_;
                }
                return (ItemOuterClass.MiniItem) this.itemBuilder_.getMessage();
            }


            public Builder setItem(ItemOuterClass.MiniItem value) {
                if (this.itemBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.item_ = value;
                    onChanged();
                } else {
                    this.itemBuilder_.setMessage((GeneratedMessage) value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }


            public Builder setItem(ItemOuterClass.MiniItem.Builder builderForValue) {
                if (this.itemBuilder_ == null) {
                    this.item_ = builderForValue.build();
                    onChanged();
                } else {
                    this.itemBuilder_.setMessage((GeneratedMessage) builderForValue.build());
                }
                this.bitField0_ |= 0x4;
                return this;
            }


            public Builder mergeItem(ItemOuterClass.MiniItem value) {
                if (this.itemBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4 && this.item_ != ItemOuterClass.MiniItem.getDefaultInstance()) {
                        this.item_ = ItemOuterClass.MiniItem.newBuilder(this.item_).mergeFrom(value).buildPartial();
                    } else {
                        this.item_ = value;
                    }
                    onChanged();
                } else {
                    this.itemBuilder_.mergeFrom((GeneratedMessage) value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }


            public Builder clearItem() {
                if (this.itemBuilder_ == null) {
                    this.item_ = ItemOuterClass.MiniItem.getDefaultInstance();
                    onChanged();
                } else {
                    this.itemBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }


            public ItemOuterClass.MiniItem.Builder getItemBuilder() {
                this.bitField0_ |= 0x4;
                onChanged();
                return (ItemOuterClass.MiniItem.Builder) getItemFieldBuilder().getBuilder();
            }


            public ItemOuterClass.MiniItemOrBuilder getItemOrBuilder() {
                if (this.itemBuilder_ != null) {
                    return (ItemOuterClass.MiniItemOrBuilder) this.itemBuilder_.getMessageOrBuilder();
                }
                return (ItemOuterClass.MiniItemOrBuilder) this.item_;
            }


            private SingleFieldBuilder<ItemOuterClass.MiniItem, ItemOuterClass.MiniItem.Builder, ItemOuterClass.MiniItemOrBuilder> getItemFieldBuilder() {
                if (this.itemBuilder_ == null) {
                    this.itemBuilder_ = new SingleFieldBuilder((GeneratedMessage) getItem(), getParentForChildren(), isClean());
                    this.item_ = null;
                }
                return this.itemBuilder_;
            }


            public boolean hasIsBind() {
                return ((this.bitField0_ & 0x8) == 8);
            }


            public int getIsBind() {
                return this.isBind_;
            }


            public Builder setIsBind(int value) {
                this.bitField0_ |= 0x8;
                this.isBind_ = value;
                onChanged();
                return this;
            }


            public Builder clearIsBind() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.isBind_ = 0;
                onChanged();
                return this;
            }


            public boolean hasItemDes() {
                return ((this.bitField0_ & 0x10) == 16);
            }


            public String getItemDes() {
                Object ref = this.itemDes_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.itemDes_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }


            public ByteString getItemDesBytes() {
                Object ref = this.itemDes_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.itemDes_ = b;
                    return b;
                }
                return (ByteString) ref;
            }


            public Builder setItemDes(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x10;
                this.itemDes_ = value;
                onChanged();
                return this;
            }


            public Builder clearItemDes() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.itemDes_ = GuildShopHandler.ExchangeItem.getDefaultInstance().getItemDes();
                onChanged();
                return this;
            }


            public Builder setItemDesBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x10;
                this.itemDes_ = value;
                onChanged();
                return this;
            }


            private void ensureNeedMoneyIsMutable() {
                if ((this.bitField0_ & 0x20) != 32) {
                    this.needMoney_ = new ArrayList<>(this.needMoney_);
                    this.bitField0_ |= 0x20;
                }
            }


            public List<GuildShopHandler.ShopMoneyInfo> getNeedMoneyList() {
                if (this.needMoneyBuilder_ == null) {
                    return Collections.unmodifiableList(this.needMoney_);
                }
                return this.needMoneyBuilder_.getMessageList();
            }


            public int getNeedMoneyCount() {
                if (this.needMoneyBuilder_ == null) {
                    return this.needMoney_.size();
                }
                return this.needMoneyBuilder_.getCount();
            }


            public GuildShopHandler.ShopMoneyInfo getNeedMoney(int index) {
                if (this.needMoneyBuilder_ == null) {
                    return this.needMoney_.get(index);
                }
                return (GuildShopHandler.ShopMoneyInfo) this.needMoneyBuilder_.getMessage(index);
            }


            public Builder setNeedMoney(int index, GuildShopHandler.ShopMoneyInfo value) {
                if (this.needMoneyBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureNeedMoneyIsMutable();
                    this.needMoney_.set(index, value);
                    onChanged();
                } else {
                    this.needMoneyBuilder_.setMessage(index, value);
                }
                return this;
            }


            public Builder setNeedMoney(int index, GuildShopHandler.ShopMoneyInfo.Builder builderForValue) {
                if (this.needMoneyBuilder_ == null) {
                    ensureNeedMoneyIsMutable();
                    this.needMoney_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.needMoneyBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }


            public Builder addNeedMoney(GuildShopHandler.ShopMoneyInfo value) {
                if (this.needMoneyBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureNeedMoneyIsMutable();
                    this.needMoney_.add(value);
                    onChanged();
                } else {
                    this.needMoneyBuilder_.addMessage(value);
                }
                return this;
            }


            public Builder addNeedMoney(int index, GuildShopHandler.ShopMoneyInfo value) {
                if (this.needMoneyBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureNeedMoneyIsMutable();
                    this.needMoney_.add(index, value);
                    onChanged();
                } else {
                    this.needMoneyBuilder_.addMessage(index, value);
                }
                return this;
            }


            public Builder addNeedMoney(GuildShopHandler.ShopMoneyInfo.Builder builderForValue) {
                if (this.needMoneyBuilder_ == null) {
                    ensureNeedMoneyIsMutable();
                    this.needMoney_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.needMoneyBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }


            public Builder addNeedMoney(int index, GuildShopHandler.ShopMoneyInfo.Builder builderForValue) {
                if (this.needMoneyBuilder_ == null) {
                    ensureNeedMoneyIsMutable();
                    this.needMoney_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.needMoneyBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }


            public Builder addAllNeedMoney(Iterable<? extends GuildShopHandler.ShopMoneyInfo> values) {
                if (this.needMoneyBuilder_ == null) {
                    ensureNeedMoneyIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.needMoney_);
                    onChanged();
                } else {
                    this.needMoneyBuilder_.addAllMessages(values);
                }
                return this;
            }


            public Builder clearNeedMoney() {
                if (this.needMoneyBuilder_ == null) {
                    this.needMoney_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFDF;
                    onChanged();
                } else {
                    this.needMoneyBuilder_.clear();
                }
                return this;
            }


            public Builder removeNeedMoney(int index) {
                if (this.needMoneyBuilder_ == null) {
                    ensureNeedMoneyIsMutable();
                    this.needMoney_.remove(index);
                    onChanged();
                } else {
                    this.needMoneyBuilder_.remove(index);
                }
                return this;
            }


            public GuildShopHandler.ShopMoneyInfo.Builder getNeedMoneyBuilder(int index) {
                return (GuildShopHandler.ShopMoneyInfo.Builder) getNeedMoneyFieldBuilder().getBuilder(index);
            }


            public GuildShopHandler.ShopMoneyInfoOrBuilder getNeedMoneyOrBuilder(int index) {
                if (this.needMoneyBuilder_ == null) {
                    return this.needMoney_.get(index);
                }
                return (GuildShopHandler.ShopMoneyInfoOrBuilder) this.needMoneyBuilder_.getMessageOrBuilder(index);
            }


            public List<? extends GuildShopHandler.ShopMoneyInfoOrBuilder> getNeedMoneyOrBuilderList() {
                if (this.needMoneyBuilder_ != null) {
                    return this.needMoneyBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList((List) this.needMoney_);
            }


            public GuildShopHandler.ShopMoneyInfo.Builder addNeedMoneyBuilder() {
                return (GuildShopHandler.ShopMoneyInfo.Builder) getNeedMoneyFieldBuilder().addBuilder(GuildShopHandler.ShopMoneyInfo.getDefaultInstance());
            }


            public GuildShopHandler.ShopMoneyInfo.Builder addNeedMoneyBuilder(int index) {
                return (GuildShopHandler.ShopMoneyInfo.Builder) getNeedMoneyFieldBuilder().addBuilder(index, GuildShopHandler.ShopMoneyInfo.getDefaultInstance());
            }


            public List<GuildShopHandler.ShopMoneyInfo.Builder> getNeedMoneyBuilderList() {
                return getNeedMoneyFieldBuilder().getBuilderList();
            }


            private RepeatedFieldBuilder<GuildShopHandler.ShopMoneyInfo, GuildShopHandler.ShopMoneyInfo.Builder, GuildShopHandler.ShopMoneyInfoOrBuilder> getNeedMoneyFieldBuilder() {
                if (this.needMoneyBuilder_ == null) {
                    this.needMoneyBuilder_ = new RepeatedFieldBuilder(this.needMoney_, ((this.bitField0_ & 0x20) == 32), getParentForChildren(), isClean());
                    this.needMoney_ = null;
                }
                return this.needMoneyBuilder_;
            }


            public boolean hasState() {
                return ((this.bitField0_ & 0x40) == 64);
            }


            public int getState() {
                return this.state_;
            }


            public Builder setState(int value) {
                this.bitField0_ |= 0x40;
                this.state_ = value;
                onChanged();
                return this;
            }


            public Builder clearState() {
                this.bitField0_ &= 0xFFFFFFBF;
                this.state_ = 0;
                onChanged();
                return this;
            }


            private void ensureConditionIsMutable() {
                if ((this.bitField0_ & 0x80) != 128) {
                    this.condition_ = new ArrayList<>(this.condition_);
                    this.bitField0_ |= 0x80;
                }
            }


            public List<GuildShopHandler.ShopCondition> getConditionList() {
                if (this.conditionBuilder_ == null) {
                    return Collections.unmodifiableList(this.condition_);
                }
                return this.conditionBuilder_.getMessageList();
            }


            public int getConditionCount() {
                if (this.conditionBuilder_ == null) {
                    return this.condition_.size();
                }
                return this.conditionBuilder_.getCount();
            }


            public GuildShopHandler.ShopCondition getCondition(int index) {
                if (this.conditionBuilder_ == null) {
                    return this.condition_.get(index);
                }
                return (GuildShopHandler.ShopCondition) this.conditionBuilder_.getMessage(index);
            }


            public Builder setCondition(int index, GuildShopHandler.ShopCondition value) {
                if (this.conditionBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureConditionIsMutable();
                    this.condition_.set(index, value);
                    onChanged();
                } else {
                    this.conditionBuilder_.setMessage(index, value);
                }
                return this;
            }


            public Builder setCondition(int index, GuildShopHandler.ShopCondition.Builder builderForValue) {
                if (this.conditionBuilder_ == null) {
                    ensureConditionIsMutable();
                    this.condition_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.conditionBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }


            public Builder addCondition(GuildShopHandler.ShopCondition value) {
                if (this.conditionBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureConditionIsMutable();
                    this.condition_.add(value);
                    onChanged();
                } else {
                    this.conditionBuilder_.addMessage(value);
                }
                return this;
            }


            public Builder addCondition(int index, GuildShopHandler.ShopCondition value) {
                if (this.conditionBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureConditionIsMutable();
                    this.condition_.add(index, value);
                    onChanged();
                } else {
                    this.conditionBuilder_.addMessage(index, value);
                }
                return this;
            }


            public Builder addCondition(GuildShopHandler.ShopCondition.Builder builderForValue) {
                if (this.conditionBuilder_ == null) {
                    ensureConditionIsMutable();
                    this.condition_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.conditionBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }


            public Builder addCondition(int index, GuildShopHandler.ShopCondition.Builder builderForValue) {
                if (this.conditionBuilder_ == null) {
                    ensureConditionIsMutable();
                    this.condition_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.conditionBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }


            public Builder addAllCondition(Iterable<? extends GuildShopHandler.ShopCondition> values) {
                if (this.conditionBuilder_ == null) {
                    ensureConditionIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.condition_);
                    onChanged();
                } else {
                    this.conditionBuilder_.addAllMessages(values);
                }
                return this;
            }


            public Builder clearCondition() {
                if (this.conditionBuilder_ == null) {
                    this.condition_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFF7F;
                    onChanged();
                } else {
                    this.conditionBuilder_.clear();
                }
                return this;
            }


            public Builder removeCondition(int index) {
                if (this.conditionBuilder_ == null) {
                    ensureConditionIsMutable();
                    this.condition_.remove(index);
                    onChanged();
                } else {
                    this.conditionBuilder_.remove(index);
                }
                return this;
            }


            public GuildShopHandler.ShopCondition.Builder getConditionBuilder(int index) {
                return (GuildShopHandler.ShopCondition.Builder) getConditionFieldBuilder().getBuilder(index);
            }


            public GuildShopHandler.ShopConditionOrBuilder getConditionOrBuilder(int index) {
                if (this.conditionBuilder_ == null) {
                    return this.condition_.get(index);
                }
                return (GuildShopHandler.ShopConditionOrBuilder) this.conditionBuilder_.getMessageOrBuilder(index);
            }


            public List<? extends GuildShopHandler.ShopConditionOrBuilder> getConditionOrBuilderList() {
                if (this.conditionBuilder_ != null) {
                    return this.conditionBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList((List) this.condition_);
            }


            public GuildShopHandler.ShopCondition.Builder addConditionBuilder() {
                return (GuildShopHandler.ShopCondition.Builder) getConditionFieldBuilder().addBuilder(GuildShopHandler.ShopCondition.getDefaultInstance());
            }


            public GuildShopHandler.ShopCondition.Builder addConditionBuilder(int index) {
                return (GuildShopHandler.ShopCondition.Builder) getConditionFieldBuilder().addBuilder(index, GuildShopHandler.ShopCondition.getDefaultInstance());
            }


            public List<GuildShopHandler.ShopCondition.Builder> getConditionBuilderList() {
                return getConditionFieldBuilder().getBuilderList();
            }


            private RepeatedFieldBuilder<GuildShopHandler.ShopCondition, GuildShopHandler.ShopCondition.Builder, GuildShopHandler.ShopConditionOrBuilder> getConditionFieldBuilder() {
                if (this.conditionBuilder_ == null) {
                    this.conditionBuilder_ = new RepeatedFieldBuilder(this.condition_, ((this.bitField0_ & 0x80) == 128), getParentForChildren(), isClean());
                    this.condition_ = null;
                }
                return this.conditionBuilder_;
            }


            public boolean hasMeetCondition() {
                return ((this.bitField0_ & 0x100) == 256);
            }


            public int getMeetCondition() {
                return this.meetCondition_;
            }


            public Builder setMeetCondition(int value) {
                this.bitField0_ |= 0x100;
                this.meetCondition_ = value;
                onChanged();
                return this;
            }


            public Builder clearMeetCondition() {
                this.bitField0_ &= 0xFFFFFEFF;
                this.meetCondition_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class ShopInfo
            extends GeneratedMessage
            implements ShopInfoOrBuilder {
        private static final ShopInfo defaultInstance = new ShopInfo(true);
        private final UnknownFieldSet unknownFields;

        private ShopInfo(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private ShopInfo(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static ShopInfo getDefaultInstance() {
            return defaultInstance;
        }

        public ShopInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ShopInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int length, limit, tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        case 10:
                            if ((mutable_bitField0_ & 0x1) != 1) {
                                this.todayItems_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x1;
                            }
                            this.todayItems_.add(input.readMessage(GuildShopHandler.ExchangeItem.PARSER, extensionRegistry));
                            break;
                        case 18:
                            if ((mutable_bitField0_ & 0x2) != 2) {
                                this.nextItems_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x2;
                            }
                            this.nextItems_.add(input.readMessage(GuildShopHandler.ExchangeItem.PARSER, extensionRegistry));
                            break;
                        case 24:
                            if ((mutable_bitField0_ & 0x4) != 4) {
                                this.refreshTime_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x4;
                            }
                            this.refreshTime_.add(Integer.valueOf(input.readInt32()));
                            break;
                        case 26:
                            length = input.readRawVarint32();
                            limit = input.pushLimit(length);
                            if ((mutable_bitField0_ & 0x4) != 4 && input.getBytesUntilLimit() > 0) {
                                this.refreshTime_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x4;
                            }
                            while (input.getBytesUntilLimit() > 0)
                                this.refreshTime_.add(Integer.valueOf(input.readInt32()));
                            input.popLimit(limit);
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x1) == 1) this.todayItems_ = Collections.unmodifiableList(this.todayItems_);
                if ((mutable_bitField0_ & 0x2) == 2) this.nextItems_ = Collections.unmodifiableList(this.nextItems_);
                if ((mutable_bitField0_ & 0x4) == 4)
                    this.refreshTime_ = Collections.unmodifiableList(this.refreshTime_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GuildShopHandler.internal_static_pomelo_area_ShopInfo_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return GuildShopHandler.internal_static_pomelo_area_ShopInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ShopInfo.class, Builder.class);
        }

        public static Parser<ShopInfo> PARSER = (Parser<ShopInfo>) new AbstractParser<ShopInfo>() {
            public GuildShopHandler.ShopInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GuildShopHandler.ShopInfo(input, extensionRegistry);
            }
        };
        public static final int TODAYITEMS_FIELD_NUMBER = 1;
        private List<GuildShopHandler.ExchangeItem> todayItems_;
        public static final int NEXTITEMS_FIELD_NUMBER = 2;
        private List<GuildShopHandler.ExchangeItem> nextItems_;
        public static final int REFRESHTIME_FIELD_NUMBER = 3;
        private List<Integer> refreshTime_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<ShopInfo> getParserForType() {
            return PARSER;
        }

        public List<GuildShopHandler.ExchangeItem> getTodayItemsList() {
            return this.todayItems_;
        }

        public List<? extends GuildShopHandler.ExchangeItemOrBuilder> getTodayItemsOrBuilderList() {
            return (List) this.todayItems_;
        }

        public int getTodayItemsCount() {
            return this.todayItems_.size();
        }

        public GuildShopHandler.ExchangeItem getTodayItems(int index) {
            return this.todayItems_.get(index);
        }

        public GuildShopHandler.ExchangeItemOrBuilder getTodayItemsOrBuilder(int index) {
            return this.todayItems_.get(index);
        }

        public List<GuildShopHandler.ExchangeItem> getNextItemsList() {
            return this.nextItems_;
        }

        public List<? extends GuildShopHandler.ExchangeItemOrBuilder> getNextItemsOrBuilderList() {
            return (List) this.nextItems_;
        }

        static {
            defaultInstance.initFields();
        }


        public int getNextItemsCount() {
            return this.nextItems_.size();
        }

        public GuildShopHandler.ExchangeItem getNextItems(int index) {
            return this.nextItems_.get(index);
        }

        public GuildShopHandler.ExchangeItemOrBuilder getNextItemsOrBuilder(int index) {
            return this.nextItems_.get(index);
        }

        public List<Integer> getRefreshTimeList() {
            return this.refreshTime_;
        }

        public int getRefreshTimeCount() {
            return this.refreshTime_.size();
        }

        public int getRefreshTime(int index) {
            return ((Integer) this.refreshTime_.get(index)).intValue();
        }

        private void initFields() {
            this.todayItems_ = Collections.emptyList();
            this.nextItems_ = Collections.emptyList();
            this.refreshTime_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            int i;
            for (i = 0; i < getTodayItemsCount(); i++) {
                if (!getTodayItems(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (i = 0; i < getNextItemsCount(); i++) {
                if (!getNextItems(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            int i;
            for (i = 0; i < this.todayItems_.size(); i++) {
                output.writeMessage(1, (MessageLite) this.todayItems_.get(i));
            }
            for (i = 0; i < this.nextItems_.size(); i++) {
                output.writeMessage(2, (MessageLite) this.nextItems_.get(i));
            }
            for (i = 0; i < this.refreshTime_.size(); i++) {
                output.writeInt32(3, ((Integer) this.refreshTime_.get(i)).intValue());
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            int i;
            for (i = 0; i < this.todayItems_.size(); i++) {
                size += CodedOutputStream.computeMessageSize(1, (MessageLite) this.todayItems_.get(i));
            }
            for (i = 0; i < this.nextItems_.size(); i++) {
                size += CodedOutputStream.computeMessageSize(2, (MessageLite) this.nextItems_.get(i));
            }
            int dataSize = 0;
            for (int j = 0; j < this.refreshTime_.size(); j++) {
                dataSize += CodedOutputStream.computeInt32SizeNoTag(((Integer) this.refreshTime_.get(j)).intValue());
            }
            size += dataSize;
            size += 1 * getRefreshTimeList().size();
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static ShopInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ShopInfo) PARSER.parseFrom(data);
        }

        public static ShopInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ShopInfo) PARSER.parseFrom(data, extensionRegistry);
        }

        public static ShopInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ShopInfo) PARSER.parseFrom(data);
        }

        public static ShopInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ShopInfo) PARSER.parseFrom(data, extensionRegistry);
        }

        public static ShopInfo parseFrom(InputStream input) throws IOException {
            return (ShopInfo) PARSER.parseFrom(input);
        }

        public static ShopInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ShopInfo) PARSER.parseFrom(input, extensionRegistry);
        }

        public static ShopInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (ShopInfo) PARSER.parseDelimitedFrom(input);
        }

        public static ShopInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ShopInfo) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static ShopInfo parseFrom(CodedInputStream input) throws IOException {
            return (ShopInfo) PARSER.parseFrom(input);
        }

        public static ShopInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ShopInfo) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(ShopInfo prototype) {
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
                implements GuildShopHandler.ShopInfoOrBuilder {
            private int bitField0_;
            private List<GuildShopHandler.ExchangeItem> todayItems_;
            private RepeatedFieldBuilder<GuildShopHandler.ExchangeItem, GuildShopHandler.ExchangeItem.Builder, GuildShopHandler.ExchangeItemOrBuilder> todayItemsBuilder_;
            private List<GuildShopHandler.ExchangeItem> nextItems_;
            private RepeatedFieldBuilder<GuildShopHandler.ExchangeItem, GuildShopHandler.ExchangeItem.Builder, GuildShopHandler.ExchangeItemOrBuilder> nextItemsBuilder_;
            private List<Integer> refreshTime_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GuildShopHandler.internal_static_pomelo_area_ShopInfo_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return GuildShopHandler.internal_static_pomelo_area_ShopInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildShopHandler.ShopInfo.class, Builder.class);
            }

            private Builder() {
                this.todayItems_ = Collections.emptyList();
                this.nextItems_ = Collections.emptyList();
                this.refreshTime_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.todayItems_ = Collections.emptyList();
                this.nextItems_ = Collections.emptyList();
                this.refreshTime_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GuildShopHandler.ShopInfo.alwaysUseFieldBuilders) {
                    getTodayItemsFieldBuilder();
                    getNextItemsFieldBuilder();
                }
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                if (this.todayItemsBuilder_ == null) {
                    this.todayItems_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFE;
                } else {
                    this.todayItemsBuilder_.clear();
                }
                if (this.nextItemsBuilder_ == null) {
                    this.nextItems_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFD;
                } else {
                    this.nextItemsBuilder_.clear();
                }
                this.refreshTime_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return GuildShopHandler.internal_static_pomelo_area_ShopInfo_descriptor;
            }

            public GuildShopHandler.ShopInfo getDefaultInstanceForType() {
                return GuildShopHandler.ShopInfo.getDefaultInstance();
            }

            public GuildShopHandler.ShopInfo build() {
                GuildShopHandler.ShopInfo result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public GuildShopHandler.ShopInfo buildPartial() {
                GuildShopHandler.ShopInfo result = new GuildShopHandler.ShopInfo(this);
                int from_bitField0_ = this.bitField0_;
                if (this.todayItemsBuilder_ == null) {
                    if ((this.bitField0_ & 0x1) == 1) {
                        this.todayItems_ = Collections.unmodifiableList(this.todayItems_);
                        this.bitField0_ &= 0xFFFFFFFE;
                    }
                    result.todayItems_ = this.todayItems_;
                } else {
                    result.todayItems_ = this.todayItemsBuilder_.build();
                }
                if (this.nextItemsBuilder_ == null) {
                    if ((this.bitField0_ & 0x2) == 2) {
                        this.nextItems_ = Collections.unmodifiableList(this.nextItems_);
                        this.bitField0_ &= 0xFFFFFFFD;
                    }
                    result.nextItems_ = this.nextItems_;
                } else {
                    result.nextItems_ = this.nextItemsBuilder_.build();
                }
                if ((this.bitField0_ & 0x4) == 4) {
                    this.refreshTime_ = Collections.unmodifiableList(this.refreshTime_);
                    this.bitField0_ &= 0xFFFFFFFB;
                }
                result.refreshTime_ = this.refreshTime_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof GuildShopHandler.ShopInfo) {
                    return mergeFrom((GuildShopHandler.ShopInfo) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GuildShopHandler.ShopInfo other) {
                if (other == GuildShopHandler.ShopInfo.getDefaultInstance()) {
                    return this;
                }
                if (this.todayItemsBuilder_ == null) {
                    if (!other.todayItems_.isEmpty()) {
                        if (this.todayItems_.isEmpty()) {
                            this.todayItems_ = other.todayItems_;
                            this.bitField0_ &= 0xFFFFFFFE;
                        } else {
                            ensureTodayItemsIsMutable();
                            this.todayItems_.addAll(other.todayItems_);
                        }
                        onChanged();
                    }
                } else if (!other.todayItems_.isEmpty()) {
                    if (this.todayItemsBuilder_.isEmpty()) {
                        this.todayItemsBuilder_.dispose();
                        this.todayItemsBuilder_ = null;
                        this.todayItems_ = other.todayItems_;
                        this.bitField0_ &= 0xFFFFFFFE;
                        this.todayItemsBuilder_ = GuildShopHandler.ShopInfo.alwaysUseFieldBuilders ? getTodayItemsFieldBuilder() : null;
                    } else {
                        this.todayItemsBuilder_.addAllMessages(other.todayItems_);
                    }
                }
                if (this.nextItemsBuilder_ == null) {
                    if (!other.nextItems_.isEmpty()) {
                        if (this.nextItems_.isEmpty()) {
                            this.nextItems_ = other.nextItems_;
                            this.bitField0_ &= 0xFFFFFFFD;
                        } else {
                            ensureNextItemsIsMutable();
                            this.nextItems_.addAll(other.nextItems_);
                        }
                        onChanged();
                    }
                } else if (!other.nextItems_.isEmpty()) {
                    if (this.nextItemsBuilder_.isEmpty()) {
                        this.nextItemsBuilder_.dispose();
                        this.nextItemsBuilder_ = null;
                        this.nextItems_ = other.nextItems_;
                        this.bitField0_ &= 0xFFFFFFFD;
                        this.nextItemsBuilder_ = GuildShopHandler.ShopInfo.alwaysUseFieldBuilders ? getNextItemsFieldBuilder() : null;
                    } else {
                        this.nextItemsBuilder_.addAllMessages(other.nextItems_);
                    }
                }
                if (!other.refreshTime_.isEmpty()) {
                    if (this.refreshTime_.isEmpty()) {
                        this.refreshTime_ = other.refreshTime_;
                        this.bitField0_ &= 0xFFFFFFFB;
                    } else {
                        ensureRefreshTimeIsMutable();
                        this.refreshTime_.addAll(other.refreshTime_);
                    }
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                int i;
                for (i = 0; i < getTodayItemsCount(); i++) {
                    if (!getTodayItems(i).isInitialized()) {
                        return false;
                    }
                }
                for (i = 0; i < getNextItemsCount(); i++) {
                    if (!getNextItems(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                GuildShopHandler.ShopInfo parsedMessage = null;
                try {
                    parsedMessage = (GuildShopHandler.ShopInfo) GuildShopHandler.ShopInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (GuildShopHandler.ShopInfo) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private void ensureTodayItemsIsMutable() {
                if ((this.bitField0_ & 0x1) != 1) {
                    this.todayItems_ = new ArrayList<>(this.todayItems_);
                    this.bitField0_ |= 0x1;
                }
            }

            public List<GuildShopHandler.ExchangeItem> getTodayItemsList() {
                if (this.todayItemsBuilder_ == null) {
                    return Collections.unmodifiableList(this.todayItems_);
                }
                return this.todayItemsBuilder_.getMessageList();
            }

            public int getTodayItemsCount() {
                if (this.todayItemsBuilder_ == null)
                    return this.todayItems_.size();
                return this.todayItemsBuilder_.getCount();
            }

            public GuildShopHandler.ExchangeItem getTodayItems(int index) {
                if (this.todayItemsBuilder_ == null)
                    return this.todayItems_.get(index);
                return (GuildShopHandler.ExchangeItem) this.todayItemsBuilder_.getMessage(index);
            }

            public Builder setTodayItems(int index, GuildShopHandler.ExchangeItem value) {
                if (this.todayItemsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureTodayItemsIsMutable();
                    this.todayItems_.set(index, value);
                    onChanged();
                } else {
                    this.todayItemsBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setTodayItems(int index, GuildShopHandler.ExchangeItem.Builder builderForValue) {
                if (this.todayItemsBuilder_ == null) {
                    ensureTodayItemsIsMutable();
                    this.todayItems_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.todayItemsBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addTodayItems(GuildShopHandler.ExchangeItem value) {
                if (this.todayItemsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureTodayItemsIsMutable();
                    this.todayItems_.add(value);
                    onChanged();
                } else {
                    this.todayItemsBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addTodayItems(int index, GuildShopHandler.ExchangeItem value) {
                if (this.todayItemsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureTodayItemsIsMutable();
                    this.todayItems_.add(index, value);
                    onChanged();
                } else {
                    this.todayItemsBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addTodayItems(GuildShopHandler.ExchangeItem.Builder builderForValue) {
                if (this.todayItemsBuilder_ == null) {
                    ensureTodayItemsIsMutable();
                    this.todayItems_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.todayItemsBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addTodayItems(int index, GuildShopHandler.ExchangeItem.Builder builderForValue) {
                if (this.todayItemsBuilder_ == null) {
                    ensureTodayItemsIsMutable();
                    this.todayItems_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.todayItemsBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllTodayItems(Iterable<? extends GuildShopHandler.ExchangeItem> values) {
                if (this.todayItemsBuilder_ == null) {
                    ensureTodayItemsIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.todayItems_);
                    onChanged();
                } else {
                    this.todayItemsBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearTodayItems() {
                if (this.todayItemsBuilder_ == null) {
                    this.todayItems_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFE;
                    onChanged();
                } else {
                    this.todayItemsBuilder_.clear();
                }
                return this;
            }

            public Builder removeTodayItems(int index) {
                if (this.todayItemsBuilder_ == null) {
                    ensureTodayItemsIsMutable();
                    this.todayItems_.remove(index);
                    onChanged();
                } else {
                    this.todayItemsBuilder_.remove(index);
                }
                return this;
            }

            public GuildShopHandler.ExchangeItem.Builder getTodayItemsBuilder(int index) {
                return (GuildShopHandler.ExchangeItem.Builder) getTodayItemsFieldBuilder().getBuilder(index);
            }

            public GuildShopHandler.ExchangeItemOrBuilder getTodayItemsOrBuilder(int index) {
                if (this.todayItemsBuilder_ == null)
                    return this.todayItems_.get(index);
                return (GuildShopHandler.ExchangeItemOrBuilder) this.todayItemsBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends GuildShopHandler.ExchangeItemOrBuilder> getTodayItemsOrBuilderList() {
                if (this.todayItemsBuilder_ != null)
                    return this.todayItemsBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.todayItems_);
            }

            public GuildShopHandler.ExchangeItem.Builder addTodayItemsBuilder() {
                return (GuildShopHandler.ExchangeItem.Builder) getTodayItemsFieldBuilder().addBuilder(GuildShopHandler.ExchangeItem.getDefaultInstance());
            }

            public GuildShopHandler.ExchangeItem.Builder addTodayItemsBuilder(int index) {
                return (GuildShopHandler.ExchangeItem.Builder) getTodayItemsFieldBuilder().addBuilder(index, GuildShopHandler.ExchangeItem.getDefaultInstance());
            }

            public List<GuildShopHandler.ExchangeItem.Builder> getTodayItemsBuilderList() {
                return getTodayItemsFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<GuildShopHandler.ExchangeItem, GuildShopHandler.ExchangeItem.Builder, GuildShopHandler.ExchangeItemOrBuilder> getTodayItemsFieldBuilder() {
                if (this.todayItemsBuilder_ == null) {
                    this.todayItemsBuilder_ = new RepeatedFieldBuilder(this.todayItems_, ((this.bitField0_ & 0x1) == 1), getParentForChildren(), isClean());
                    this.todayItems_ = null;
                }
                return this.todayItemsBuilder_;
            }

            private void ensureNextItemsIsMutable() {
                if ((this.bitField0_ & 0x2) != 2) {
                    this.nextItems_ = new ArrayList<>(this.nextItems_);
                    this.bitField0_ |= 0x2;
                }
            }

            public List<GuildShopHandler.ExchangeItem> getNextItemsList() {
                if (this.nextItemsBuilder_ == null)
                    return Collections.unmodifiableList(this.nextItems_);
                return this.nextItemsBuilder_.getMessageList();
            }

            public int getNextItemsCount() {
                if (this.nextItemsBuilder_ == null)
                    return this.nextItems_.size();
                return this.nextItemsBuilder_.getCount();
            }

            public GuildShopHandler.ExchangeItem getNextItems(int index) {
                if (this.nextItemsBuilder_ == null)
                    return this.nextItems_.get(index);
                return (GuildShopHandler.ExchangeItem) this.nextItemsBuilder_.getMessage(index);
            }

            public Builder setNextItems(int index, GuildShopHandler.ExchangeItem value) {
                if (this.nextItemsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureNextItemsIsMutable();
                    this.nextItems_.set(index, value);
                    onChanged();
                } else {
                    this.nextItemsBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setNextItems(int index, GuildShopHandler.ExchangeItem.Builder builderForValue) {
                if (this.nextItemsBuilder_ == null) {
                    ensureNextItemsIsMutable();
                    this.nextItems_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.nextItemsBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addNextItems(GuildShopHandler.ExchangeItem value) {
                if (this.nextItemsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureNextItemsIsMutable();
                    this.nextItems_.add(value);
                    onChanged();
                } else {
                    this.nextItemsBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addNextItems(int index, GuildShopHandler.ExchangeItem value) {
                if (this.nextItemsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureNextItemsIsMutable();
                    this.nextItems_.add(index, value);
                    onChanged();
                } else {
                    this.nextItemsBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addNextItems(GuildShopHandler.ExchangeItem.Builder builderForValue) {
                if (this.nextItemsBuilder_ == null) {
                    ensureNextItemsIsMutable();
                    this.nextItems_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.nextItemsBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addNextItems(int index, GuildShopHandler.ExchangeItem.Builder builderForValue) {
                if (this.nextItemsBuilder_ == null) {
                    ensureNextItemsIsMutable();
                    this.nextItems_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.nextItemsBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllNextItems(Iterable<? extends GuildShopHandler.ExchangeItem> values) {
                if (this.nextItemsBuilder_ == null) {
                    ensureNextItemsIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.nextItems_);
                    onChanged();
                } else {
                    this.nextItemsBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearNextItems() {
                if (this.nextItemsBuilder_ == null) {
                    this.nextItems_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFD;
                    onChanged();
                } else {
                    this.nextItemsBuilder_.clear();
                }
                return this;
            }

            public Builder removeNextItems(int index) {
                if (this.nextItemsBuilder_ == null) {
                    ensureNextItemsIsMutable();
                    this.nextItems_.remove(index);
                    onChanged();
                } else {
                    this.nextItemsBuilder_.remove(index);
                }
                return this;
            }

            public GuildShopHandler.ExchangeItem.Builder getNextItemsBuilder(int index) {
                return (GuildShopHandler.ExchangeItem.Builder) getNextItemsFieldBuilder().getBuilder(index);
            }

            public GuildShopHandler.ExchangeItemOrBuilder getNextItemsOrBuilder(int index) {
                if (this.nextItemsBuilder_ == null)
                    return this.nextItems_.get(index);
                return (GuildShopHandler.ExchangeItemOrBuilder) this.nextItemsBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends GuildShopHandler.ExchangeItemOrBuilder> getNextItemsOrBuilderList() {
                if (this.nextItemsBuilder_ != null)
                    return this.nextItemsBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.nextItems_);
            }

            public GuildShopHandler.ExchangeItem.Builder addNextItemsBuilder() {
                return (GuildShopHandler.ExchangeItem.Builder) getNextItemsFieldBuilder().addBuilder(GuildShopHandler.ExchangeItem.getDefaultInstance());
            }

            public GuildShopHandler.ExchangeItem.Builder addNextItemsBuilder(int index) {
                return (GuildShopHandler.ExchangeItem.Builder) getNextItemsFieldBuilder().addBuilder(index, GuildShopHandler.ExchangeItem.getDefaultInstance());
            }

            public List<GuildShopHandler.ExchangeItem.Builder> getNextItemsBuilderList() {
                return getNextItemsFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<GuildShopHandler.ExchangeItem, GuildShopHandler.ExchangeItem.Builder, GuildShopHandler.ExchangeItemOrBuilder> getNextItemsFieldBuilder() {
                if (this.nextItemsBuilder_ == null) {
                    this.nextItemsBuilder_ = new RepeatedFieldBuilder(this.nextItems_, ((this.bitField0_ & 0x2) == 2), getParentForChildren(), isClean());
                    this.nextItems_ = null;
                }
                return this.nextItemsBuilder_;
            }

            private void ensureRefreshTimeIsMutable() {
                if ((this.bitField0_ & 0x4) != 4) {
                    this.refreshTime_ = new ArrayList<>(this.refreshTime_);
                    this.bitField0_ |= 0x4;
                }
            }

            public List<Integer> getRefreshTimeList() {
                return Collections.unmodifiableList(this.refreshTime_);
            }

            public int getRefreshTimeCount() {
                return this.refreshTime_.size();
            }

            public int getRefreshTime(int index) {
                return ((Integer) this.refreshTime_.get(index)).intValue();
            }

            public Builder setRefreshTime(int index, int value) {
                ensureRefreshTimeIsMutable();
                this.refreshTime_.set(index, Integer.valueOf(value));
                onChanged();
                return this;
            }

            public Builder addRefreshTime(int value) {
                ensureRefreshTimeIsMutable();
                this.refreshTime_.add(Integer.valueOf(value));
                onChanged();
                return this;
            }

            public Builder addAllRefreshTime(Iterable<? extends Integer> values) {
                ensureRefreshTimeIsMutable();
                AbstractMessageLite.Builder.addAll(values, this.refreshTime_);
                onChanged();
                return this;
            }

            public Builder clearRefreshTime() {
                this.refreshTime_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFFB;
                onChanged();
                return this;
            }
        }
    }

    public static final class GetGuildShopInfoResponse
            extends GeneratedMessage
            implements GetGuildShopInfoResponseOrBuilder {
        private static final GetGuildShopInfoResponse defaultInstance = new GetGuildShopInfoResponse(true);
        private final UnknownFieldSet unknownFields;

        private GetGuildShopInfoResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetGuildShopInfoResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetGuildShopInfoResponse getDefaultInstance() {
            return defaultInstance;
        }

        public GetGuildShopInfoResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetGuildShopInfoResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString bs;
                    GuildShopHandler.ShopInfo.Builder subBuilder;
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
                            if ((this.bitField0_ & 0x4) == 4) subBuilder = this.s2CShopInfo_.toBuilder();
                            this.s2CShopInfo_ = (GuildShopHandler.ShopInfo) input.readMessage(GuildShopHandler.ShopInfo.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.s2CShopInfo_);
                                this.s2CShopInfo_ = subBuilder.buildPartial();
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
            return GuildShopHandler.internal_static_pomelo_area_GetGuildShopInfoResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return GuildShopHandler.internal_static_pomelo_area_GetGuildShopInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetGuildShopInfoResponse.class, Builder.class);
        }

        public static Parser<GetGuildShopInfoResponse> PARSER = (Parser<GetGuildShopInfoResponse>) new AbstractParser<GetGuildShopInfoResponse>() {
            public GuildShopHandler.GetGuildShopInfoResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GuildShopHandler.GetGuildShopInfoResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_SHOPINFO_FIELD_NUMBER = 3;
        private GuildShopHandler.ShopInfo s2CShopInfo_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetGuildShopInfoResponse> getParserForType() {
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


        public boolean hasS2CShopInfo() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public GuildShopHandler.ShopInfo getS2CShopInfo() {
            return this.s2CShopInfo_;
        }


        public GuildShopHandler.ShopInfoOrBuilder getS2CShopInfoOrBuilder() {
            return this.s2CShopInfo_;
        }


        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CShopInfo_ = GuildShopHandler.ShopInfo.getDefaultInstance();
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
            if (hasS2CShopInfo() && !getS2CShopInfo().isInitialized()) {
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
                output.writeMessage(3, (MessageLite) this.s2CShopInfo_);
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
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.s2CShopInfo_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static GetGuildShopInfoResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetGuildShopInfoResponse) PARSER.parseFrom(data);
        }


        public static GetGuildShopInfoResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetGuildShopInfoResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetGuildShopInfoResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetGuildShopInfoResponse) PARSER.parseFrom(data);
        }


        public static GetGuildShopInfoResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetGuildShopInfoResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetGuildShopInfoResponse parseFrom(InputStream input) throws IOException {
            return (GetGuildShopInfoResponse) PARSER.parseFrom(input);
        }


        public static GetGuildShopInfoResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetGuildShopInfoResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static GetGuildShopInfoResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (GetGuildShopInfoResponse) PARSER.parseDelimitedFrom(input);
        }


        public static GetGuildShopInfoResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetGuildShopInfoResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static GetGuildShopInfoResponse parseFrom(CodedInputStream input) throws IOException {
            return (GetGuildShopInfoResponse) PARSER.parseFrom(input);
        }


        public static GetGuildShopInfoResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetGuildShopInfoResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(GetGuildShopInfoResponse prototype) {
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
                implements GuildShopHandler.GetGuildShopInfoResponseOrBuilder {
            private int bitField0_;


            private int s2CCode_;


            private Object s2CMsg_;


            private GuildShopHandler.ShopInfo s2CShopInfo_;


            private SingleFieldBuilder<GuildShopHandler.ShopInfo, GuildShopHandler.ShopInfo.Builder, GuildShopHandler.ShopInfoOrBuilder> s2CShopInfoBuilder_;


            public static final Descriptors.Descriptor getDescriptor() {
                return GuildShopHandler.internal_static_pomelo_area_GetGuildShopInfoResponse_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return GuildShopHandler.internal_static_pomelo_area_GetGuildShopInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildShopHandler.GetGuildShopInfoResponse.class, Builder.class);
            }


            private Builder() {
                this.s2CMsg_ = "";
                this.s2CShopInfo_ = GuildShopHandler.ShopInfo.getDefaultInstance();
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CShopInfo_ = GuildShopHandler.ShopInfo.getDefaultInstance();
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (GuildShopHandler.GetGuildShopInfoResponse.alwaysUseFieldBuilders) {
                    getS2CShopInfoFieldBuilder();
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
                if (this.s2CShopInfoBuilder_ == null) {
                    this.s2CShopInfo_ = GuildShopHandler.ShopInfo.getDefaultInstance();
                } else {
                    this.s2CShopInfoBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return GuildShopHandler.internal_static_pomelo_area_GetGuildShopInfoResponse_descriptor;
            }


            public GuildShopHandler.GetGuildShopInfoResponse getDefaultInstanceForType() {
                return GuildShopHandler.GetGuildShopInfoResponse.getDefaultInstance();
            }


            public GuildShopHandler.GetGuildShopInfoResponse build() {
                GuildShopHandler.GetGuildShopInfoResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public GuildShopHandler.GetGuildShopInfoResponse buildPartial() {
                GuildShopHandler.GetGuildShopInfoResponse result = new GuildShopHandler.GetGuildShopInfoResponse(this);
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
                if (this.s2CShopInfoBuilder_ == null) {
                    result.s2CShopInfo_ = this.s2CShopInfo_;
                } else {
                    result.s2CShopInfo_ = (GuildShopHandler.ShopInfo) this.s2CShopInfoBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof GuildShopHandler.GetGuildShopInfoResponse) {
                    return mergeFrom((GuildShopHandler.GetGuildShopInfoResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(GuildShopHandler.GetGuildShopInfoResponse other) {
                if (other == GuildShopHandler.GetGuildShopInfoResponse.getDefaultInstance()) {
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
                if (other.hasS2CShopInfo()) {
                    mergeS2CShopInfo(other.getS2CShopInfo());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasS2CCode()) {
                    return false;
                }
                if (hasS2CShopInfo() && !getS2CShopInfo().isInitialized()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                GuildShopHandler.GetGuildShopInfoResponse parsedMessage = null;
                try {
                    parsedMessage = (GuildShopHandler.GetGuildShopInfoResponse) GuildShopHandler.GetGuildShopInfoResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (GuildShopHandler.GetGuildShopInfoResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = GuildShopHandler.GetGuildShopInfoResponse.getDefaultInstance().getS2CMsg();
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


            public boolean hasS2CShopInfo() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public GuildShopHandler.ShopInfo getS2CShopInfo() {
                if (this.s2CShopInfoBuilder_ == null) {
                    return this.s2CShopInfo_;
                }
                return (GuildShopHandler.ShopInfo) this.s2CShopInfoBuilder_.getMessage();
            }


            public Builder setS2CShopInfo(GuildShopHandler.ShopInfo value) {
                if (this.s2CShopInfoBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.s2CShopInfo_ = value;
                    onChanged();
                } else {
                    this.s2CShopInfoBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }


            public Builder setS2CShopInfo(GuildShopHandler.ShopInfo.Builder builderForValue) {
                if (this.s2CShopInfoBuilder_ == null) {
                    this.s2CShopInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.s2CShopInfoBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x4;
                return this;
            }


            public Builder mergeS2CShopInfo(GuildShopHandler.ShopInfo value) {
                if (this.s2CShopInfoBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4 && this.s2CShopInfo_ != GuildShopHandler.ShopInfo.getDefaultInstance()) {
                        this.s2CShopInfo_ = GuildShopHandler.ShopInfo.newBuilder(this.s2CShopInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.s2CShopInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.s2CShopInfoBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }


            public Builder clearS2CShopInfo() {
                if (this.s2CShopInfoBuilder_ == null) {
                    this.s2CShopInfo_ = GuildShopHandler.ShopInfo.getDefaultInstance();
                    onChanged();
                } else {
                    this.s2CShopInfoBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }


            public GuildShopHandler.ShopInfo.Builder getS2CShopInfoBuilder() {
                this.bitField0_ |= 0x4;
                onChanged();
                return (GuildShopHandler.ShopInfo.Builder) getS2CShopInfoFieldBuilder().getBuilder();
            }


            public GuildShopHandler.ShopInfoOrBuilder getS2CShopInfoOrBuilder() {
                if (this.s2CShopInfoBuilder_ != null) {
                    return (GuildShopHandler.ShopInfoOrBuilder) this.s2CShopInfoBuilder_.getMessageOrBuilder();
                }
                return this.s2CShopInfo_;
            }


            private SingleFieldBuilder<GuildShopHandler.ShopInfo, GuildShopHandler.ShopInfo.Builder, GuildShopHandler.ShopInfoOrBuilder> getS2CShopInfoFieldBuilder() {
                if (this.s2CShopInfoBuilder_ == null) {
                    this.s2CShopInfoBuilder_ = new SingleFieldBuilder(getS2CShopInfo(), getParentForChildren(), isClean());
                    this.s2CShopInfo_ = null;
                }
                return this.s2CShopInfoBuilder_;
            }
        }
    }


    public static final class ExchangeShopItemResponse
            extends GeneratedMessage
            implements ExchangeShopItemResponseOrBuilder {
        private static final ExchangeShopItemResponse defaultInstance = new ExchangeShopItemResponse(true);
        private final UnknownFieldSet unknownFields;

        private ExchangeShopItemResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private ExchangeShopItemResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static ExchangeShopItemResponse getDefaultInstance() {
            return defaultInstance;
        }

        public ExchangeShopItemResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ExchangeShopItemResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.s2CId_ = input.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.s2CState_ = input.readInt32();
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
            return GuildShopHandler.internal_static_pomelo_area_ExchangeShopItemResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return GuildShopHandler.internal_static_pomelo_area_ExchangeShopItemResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ExchangeShopItemResponse.class, Builder.class);
        }

        public static Parser<ExchangeShopItemResponse> PARSER = (Parser<ExchangeShopItemResponse>) new AbstractParser<ExchangeShopItemResponse>() {
            public GuildShopHandler.ExchangeShopItemResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GuildShopHandler.ExchangeShopItemResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_ID_FIELD_NUMBER = 3;
        private int s2CId_;
        public static final int S2C_STATE_FIELD_NUMBER = 4;
        private int s2CState_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<ExchangeShopItemResponse> getParserForType() {
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


        public boolean hasS2CId() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public int getS2CId() {
            return this.s2CId_;
        }


        public boolean hasS2CState() {
            return ((this.bitField0_ & 0x8) == 8);
        }


        public int getS2CState() {
            return this.s2CState_;
        }


        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CId_ = 0;
            this.s2CState_ = 0;
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
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeInt32(3, this.s2CId_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                output.writeInt32(4, this.s2CState_);
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
                size += CodedOutputStream.computeInt32Size(3, this.s2CId_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                size += CodedOutputStream.computeInt32Size(4, this.s2CState_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static ExchangeShopItemResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ExchangeShopItemResponse) PARSER.parseFrom(data);
        }


        public static ExchangeShopItemResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ExchangeShopItemResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static ExchangeShopItemResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ExchangeShopItemResponse) PARSER.parseFrom(data);
        }


        public static ExchangeShopItemResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ExchangeShopItemResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static ExchangeShopItemResponse parseFrom(InputStream input) throws IOException {
            return (ExchangeShopItemResponse) PARSER.parseFrom(input);
        }


        public static ExchangeShopItemResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ExchangeShopItemResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static ExchangeShopItemResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (ExchangeShopItemResponse) PARSER.parseDelimitedFrom(input);
        }


        public static ExchangeShopItemResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ExchangeShopItemResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static ExchangeShopItemResponse parseFrom(CodedInputStream input) throws IOException {
            return (ExchangeShopItemResponse) PARSER.parseFrom(input);
        }


        public static ExchangeShopItemResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ExchangeShopItemResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(ExchangeShopItemResponse prototype) {
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
                implements GuildShopHandler.ExchangeShopItemResponseOrBuilder {
            private int bitField0_;


            private int s2CCode_;


            private Object s2CMsg_;


            private int s2CId_;


            private int s2CState_;


            public static final Descriptors.Descriptor getDescriptor() {
                return GuildShopHandler.internal_static_pomelo_area_ExchangeShopItemResponse_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return GuildShopHandler.internal_static_pomelo_area_ExchangeShopItemResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildShopHandler.ExchangeShopItemResponse.class, Builder.class);
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
                if (GuildShopHandler.ExchangeShopItemResponse.alwaysUseFieldBuilders) ;
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
                this.s2CId_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.s2CState_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return GuildShopHandler.internal_static_pomelo_area_ExchangeShopItemResponse_descriptor;
            }


            public GuildShopHandler.ExchangeShopItemResponse getDefaultInstanceForType() {
                return GuildShopHandler.ExchangeShopItemResponse.getDefaultInstance();
            }


            public GuildShopHandler.ExchangeShopItemResponse build() {
                GuildShopHandler.ExchangeShopItemResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public GuildShopHandler.ExchangeShopItemResponse buildPartial() {
                GuildShopHandler.ExchangeShopItemResponse result = new GuildShopHandler.ExchangeShopItemResponse(this);
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
                result.s2CId_ = this.s2CId_;
                if ((from_bitField0_ & 0x8) == 8) {
                    to_bitField0_ |= 0x8;
                }
                result.s2CState_ = this.s2CState_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof GuildShopHandler.ExchangeShopItemResponse) {
                    return mergeFrom((GuildShopHandler.ExchangeShopItemResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(GuildShopHandler.ExchangeShopItemResponse other) {
                if (other == GuildShopHandler.ExchangeShopItemResponse.getDefaultInstance()) {
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
                if (other.hasS2CId()) {
                    setS2CId(other.getS2CId());
                }
                if (other.hasS2CState()) {
                    setS2CState(other.getS2CState());
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
                GuildShopHandler.ExchangeShopItemResponse parsedMessage = null;
                try {
                    parsedMessage = (GuildShopHandler.ExchangeShopItemResponse) GuildShopHandler.ExchangeShopItemResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (GuildShopHandler.ExchangeShopItemResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = GuildShopHandler.ExchangeShopItemResponse.getDefaultInstance().getS2CMsg();
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


            public boolean hasS2CId() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public int getS2CId() {
                return this.s2CId_;
            }


            public Builder setS2CId(int value) {
                this.bitField0_ |= 0x4;
                this.s2CId_ = value;
                onChanged();
                return this;
            }


            public Builder clearS2CId() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.s2CId_ = 0;
                onChanged();
                return this;
            }


            public boolean hasS2CState() {
                return ((this.bitField0_ & 0x8) == 8);
            }


            public int getS2CState() {
                return this.s2CState_;
            }


            public Builder setS2CState(int value) {
                this.bitField0_ |= 0x8;
                this.s2CState_ = value;
                onChanged();
                return this;
            }


            public Builder clearS2CState() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.s2CState_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class ShopRefreshPush
            extends GeneratedMessage
            implements ShopRefreshPushOrBuilder {
        private final UnknownFieldSet unknownFields;


        private ShopRefreshPush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }


        private ShopRefreshPush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }


        public static ShopRefreshPush getDefaultInstance() {
            return defaultInstance;
        }


        public ShopRefreshPush getDefaultInstanceForType() {
            return defaultInstance;
        }


        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }


        private ShopRefreshPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.type_ = input.readInt32();
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
            return GuildShopHandler.internal_static_pomelo_area_ShopRefreshPush_descriptor;
        }


        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return GuildShopHandler.internal_static_pomelo_area_ShopRefreshPush_fieldAccessorTable.ensureFieldAccessorsInitialized(ShopRefreshPush.class, Builder.class);
        }


        public static Parser<ShopRefreshPush> PARSER = (Parser<ShopRefreshPush>) new AbstractParser<ShopRefreshPush>() {
            public GuildShopHandler.ShopRefreshPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GuildShopHandler.ShopRefreshPush(input, extensionRegistry);
            }
        };


        private int bitField0_;

        public static final int S2C_CODE_FIELD_NUMBER = 1;

        private int s2CCode_;

        public static final int S2C_MSG_FIELD_NUMBER = 2;

        private Object s2CMsg_;

        public static final int TYPE_FIELD_NUMBER = 3;

        private int type_;

        private byte memoizedIsInitialized;

        private int memoizedSerializedSize;

        private static final long serialVersionUID = 0L;


        public Parser<ShopRefreshPush> getParserForType() {
            return PARSER;
        }


        public boolean hasS2CCode() {
            return ((this.bitField0_ & 0x1) == 1);
        }


        private static final ShopRefreshPush defaultInstance = new ShopRefreshPush(true);

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

        public boolean hasType() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getType() {
            return this.type_;
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.type_ = 0;
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
            if ((this.bitField0_ & 0x4) == 4) output.writeInt32(3, this.type_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());
            if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeInt32Size(3, this.type_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static ShopRefreshPush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ShopRefreshPush) PARSER.parseFrom(data);
        }

        public static ShopRefreshPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ShopRefreshPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static ShopRefreshPush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ShopRefreshPush) PARSER.parseFrom(data);
        }

        public static ShopRefreshPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ShopRefreshPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static ShopRefreshPush parseFrom(InputStream input) throws IOException {
            return (ShopRefreshPush) PARSER.parseFrom(input);
        }

        public static ShopRefreshPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ShopRefreshPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static ShopRefreshPush parseDelimitedFrom(InputStream input) throws IOException {
            return (ShopRefreshPush) PARSER.parseDelimitedFrom(input);
        }

        public static ShopRefreshPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ShopRefreshPush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static ShopRefreshPush parseFrom(CodedInputStream input) throws IOException {
            return (ShopRefreshPush) PARSER.parseFrom(input);
        }

        public static ShopRefreshPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ShopRefreshPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(ShopRefreshPush prototype) {
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

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements GuildShopHandler.ShopRefreshPushOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private int type_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GuildShopHandler.internal_static_pomelo_area_ShopRefreshPush_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return GuildShopHandler.internal_static_pomelo_area_ShopRefreshPush_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildShopHandler.ShopRefreshPush.class, Builder.class);
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
                if (GuildShopHandler.ShopRefreshPush.alwaysUseFieldBuilders) ;
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
                this.type_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return GuildShopHandler.internal_static_pomelo_area_ShopRefreshPush_descriptor;
            }

            public GuildShopHandler.ShopRefreshPush getDefaultInstanceForType() {
                return GuildShopHandler.ShopRefreshPush.getDefaultInstance();
            }

            public GuildShopHandler.ShopRefreshPush build() {
                GuildShopHandler.ShopRefreshPush result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public GuildShopHandler.ShopRefreshPush buildPartial() {
                GuildShopHandler.ShopRefreshPush result = new GuildShopHandler.ShopRefreshPush(this);
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
                result.type_ = this.type_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof GuildShopHandler.ShopRefreshPush)
                    return mergeFrom((GuildShopHandler.ShopRefreshPush) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GuildShopHandler.ShopRefreshPush other) {
                if (other == GuildShopHandler.ShopRefreshPush.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (other.hasType())
                    setType(other.getType());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                GuildShopHandler.ShopRefreshPush parsedMessage = null;
                try {
                    parsedMessage = (GuildShopHandler.ShopRefreshPush) GuildShopHandler.ShopRefreshPush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (GuildShopHandler.ShopRefreshPush) e.getUnfinishedMessage();
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
                this.s2CMsg_ = GuildShopHandler.ShopRefreshPush.getDefaultInstance().getS2CMsg();
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

            public boolean hasType() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public int getType() {
                return this.type_;
            }

            public Builder setType(int value) {
                this.bitField0_ |= 0x4;
                this.type_ = value;
                onChanged();
                return this;
            }

            public Builder clearType() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.type_ = 0;
                onChanged();
                return this;
            }
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }


    static {
        String[] descriptorData = {"\n\026guildShopHandler.proto\022\013pomelo.area\032\nitem.proto\032\fcommon.proto\"\031\n\027GetGuildShopInfoRequest\"%\n\027ExchangeShopItemRequest\022\n\n\002id\030\001 \001(\005\",\n\rShopMoneyInfo\022\f\n\004type\030\001 \002(\005\022\r\n\005value\030\002 \002(\005\"-\n\rShopCondition\022\f\n\004type\030\001 \001(\005\022\016\n\006number\030\002 \001(\005\"ú\001\n\fExchangeItem\022\n\n\002id\030\001 \001(\005\022\024\n\fitemShowName\030\002 \001(\t\022#\n\004item\030\003 \001(\0132\025.pomelo.item.MiniItem\022\016\n\006isBind\030\004 \001(\005\022\017\n\007itemDes\030\005 \001(\t\022-\n\tneedMoney\030\006 \003(\0132\032.pomelo.area.ShopMoneyInfo\022\r\n\005state\030", "\007 \001(\005\022-\n\tcondition\030\b \003(\0132\032.pomelo.area.ShopCondition\022\025\n\rmeetCondition\030\t \001(\005\"|\n\bShopInfo\022-\n\ntodayItems\030\001 \003(\0132\031.pomelo.area.ExchangeItem\022,\n\tnextItems\030\002 \003(\0132\031.pomelo.area.ExchangeItem\022\023\n\013refreshTime\030\003 \003(\005\"j\n\030GetGuildShopInfoResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022+\n\fs2c_shopInfo\030\003 \001(\0132\025.pomelo.area.ShopInfo\"`\n\030ExchangeShopItemResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\016\n\006s2c_id\030\003 \001(\005\022\021\n\ts2c_stat", "e\030\004 \001(\005\"B\n\017ShopRefreshPush\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\f\n\004type\030\003 \001(\0052â\001\n\020guildShopHandler\022f\n\027getGuildShopInfoRequest\022$.pomelo.area.GetGuildShopInfoRequest\032%.pomelo.area.GetGuildShopInfoResponse\022f\n\027exchangeShopItemRequest\022$.pomelo.area.ExchangeShopItemRequest\032%.pomelo.area.ExchangeShopItemResponse2N\n\rguildShopPush\022=\n\017shopRefreshPush\022\034.pomelo.area.ShopRefreshPush\032\f.pomelo.Void"};


        Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root) {
                GuildShopHandler.descriptor = root;
                return null;
            }
        };

        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[]{

                ItemOuterClass.getDescriptor(),
                Common.getDescriptor()}, assigner);
    }

    private static final Descriptors.Descriptor internal_static_pomelo_area_GetGuildShopInfoRequest_descriptor = getDescriptor().getMessageTypes().get(0);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetGuildShopInfoRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetGuildShopInfoRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_area_ExchangeShopItemRequest_descriptor = getDescriptor().getMessageTypes().get(1);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ExchangeShopItemRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ExchangeShopItemRequest_descriptor, new String[]{"Id"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_ShopMoneyInfo_descriptor = getDescriptor().getMessageTypes().get(2);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ShopMoneyInfo_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ShopMoneyInfo_descriptor, new String[]{"Type", "Value"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_ShopCondition_descriptor = getDescriptor().getMessageTypes().get(3);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ShopCondition_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ShopCondition_descriptor, new String[]{"Type", "Number"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_ExchangeItem_descriptor = getDescriptor().getMessageTypes().get(4);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ExchangeItem_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ExchangeItem_descriptor, new String[]{"Id", "ItemShowName", "Item", "IsBind", "ItemDes", "NeedMoney", "State", "Condition", "MeetCondition"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_ShopInfo_descriptor = getDescriptor().getMessageTypes().get(5);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ShopInfo_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ShopInfo_descriptor, new String[]{"TodayItems", "NextItems", "RefreshTime"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetGuildShopInfoResponse_descriptor = getDescriptor().getMessageTypes().get(6);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetGuildShopInfoResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetGuildShopInfoResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CShopInfo"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_ExchangeShopItemResponse_descriptor = getDescriptor().getMessageTypes().get(7);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ExchangeShopItemResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ExchangeShopItemResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CId", "S2CState"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_ShopRefreshPush_descriptor = getDescriptor().getMessageTypes().get(8);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ShopRefreshPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ShopRefreshPush_descriptor, new String[]{"S2CCode", "S2CMsg", "Type"});
    private static Descriptors.FileDescriptor descriptor;

    static {
        ItemOuterClass.getDescriptor();
        Common.getDescriptor();
    }

    public static interface ShopRefreshPushOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasType();

        int getType();
    }

    public static interface ExchangeShopItemResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasS2CId();

        int getS2CId();

        boolean hasS2CState();

        int getS2CState();
    }

    public static interface GetGuildShopInfoResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasS2CShopInfo();

        GuildShopHandler.ShopInfo getS2CShopInfo();

        GuildShopHandler.ShopInfoOrBuilder getS2CShopInfoOrBuilder();
    }

    public static interface ShopInfoOrBuilder extends MessageOrBuilder {
        List<GuildShopHandler.ExchangeItem> getTodayItemsList();

        GuildShopHandler.ExchangeItem getTodayItems(int param1Int);

        int getTodayItemsCount();

        List<? extends GuildShopHandler.ExchangeItemOrBuilder> getTodayItemsOrBuilderList();

        GuildShopHandler.ExchangeItemOrBuilder getTodayItemsOrBuilder(int param1Int);

        List<GuildShopHandler.ExchangeItem> getNextItemsList();

        GuildShopHandler.ExchangeItem getNextItems(int param1Int);

        int getNextItemsCount();

        List<? extends GuildShopHandler.ExchangeItemOrBuilder> getNextItemsOrBuilderList();

        GuildShopHandler.ExchangeItemOrBuilder getNextItemsOrBuilder(int param1Int);

        List<Integer> getRefreshTimeList();

        int getRefreshTimeCount();

        int getRefreshTime(int param1Int);
    }

    public static interface ExchangeItemOrBuilder extends MessageOrBuilder {
        boolean hasId();

        int getId();

        boolean hasItemShowName();

        String getItemShowName();

        ByteString getItemShowNameBytes();

        boolean hasItem();

        ItemOuterClass.MiniItem getItem();

        ItemOuterClass.MiniItemOrBuilder getItemOrBuilder();

        boolean hasIsBind();

        int getIsBind();

        boolean hasItemDes();

        String getItemDes();

        ByteString getItemDesBytes();

        List<GuildShopHandler.ShopMoneyInfo> getNeedMoneyList();

        GuildShopHandler.ShopMoneyInfo getNeedMoney(int param1Int);

        int getNeedMoneyCount();

        List<? extends GuildShopHandler.ShopMoneyInfoOrBuilder> getNeedMoneyOrBuilderList();

        GuildShopHandler.ShopMoneyInfoOrBuilder getNeedMoneyOrBuilder(int param1Int);

        boolean hasState();

        int getState();

        List<GuildShopHandler.ShopCondition> getConditionList();

        GuildShopHandler.ShopCondition getCondition(int param1Int);

        int getConditionCount();

        List<? extends GuildShopHandler.ShopConditionOrBuilder> getConditionOrBuilderList();

        GuildShopHandler.ShopConditionOrBuilder getConditionOrBuilder(int param1Int);

        boolean hasMeetCondition();

        int getMeetCondition();
    }

    public static interface ShopConditionOrBuilder extends MessageOrBuilder {
        boolean hasType();

        int getType();

        boolean hasNumber();

        int getNumber();
    }

    public static interface ShopMoneyInfoOrBuilder extends MessageOrBuilder {
        boolean hasType();

        int getType();

        boolean hasValue();

        int getValue();
    }

    public static interface ExchangeShopItemRequestOrBuilder extends MessageOrBuilder {
        boolean hasId();

        int getId();
    }

    public static interface GetGuildShopInfoRequestOrBuilder extends MessageOrBuilder {
    }
}


