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


public final class BattleHandler {
    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static final class ItemNormal
            extends GeneratedMessage
            implements ItemNormalOrBuilder {
        private static final ItemNormal defaultInstance = new ItemNormal(true);
        private final UnknownFieldSet unknownFields;

        private ItemNormal(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private ItemNormal(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static ItemNormal getDefaultInstance() {
            return defaultInstance;
        }

        public ItemNormal getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ItemNormal(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.itemCode_ = bs;
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.itemNum_ = input.readInt32();
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
            return BattleHandler.internal_static_pomelo_area_ItemNormal_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return BattleHandler.internal_static_pomelo_area_ItemNormal_fieldAccessorTable.ensureFieldAccessorsInitialized(ItemNormal.class, Builder.class);
        }

        public static Parser<ItemNormal> PARSER = (Parser<ItemNormal>) new AbstractParser<ItemNormal>() {
            public BattleHandler.ItemNormal parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BattleHandler.ItemNormal(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int ITEMCODE_FIELD_NUMBER = 1;
        private Object itemCode_;
        public static final int ITEMNUM_FIELD_NUMBER = 2;
        private int itemNum_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<ItemNormal> getParserForType() {
            return PARSER;
        }

        public boolean hasItemCode() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public String getItemCode() {
            Object ref = this.itemCode_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.itemCode_ = s;
            return s;
        }

        public ByteString getItemCodeBytes() {
            Object ref = this.itemCode_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.itemCode_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        static {
            defaultInstance.initFields();
        }


        public boolean hasItemNum() {
            return ((this.bitField0_ & 0x2) == 2);
        }


        public int getItemNum() {
            return this.itemNum_;
        }


        private void initFields() {
            this.itemCode_ = "";
            this.itemNum_ = 0;
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasItemCode()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasItemNum()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeBytes(1, getItemCodeBytes());
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeInt32(2, this.itemNum_);
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
                size += CodedOutputStream.computeBytesSize(1, getItemCodeBytes());
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeInt32Size(2, this.itemNum_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static ItemNormal parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ItemNormal) PARSER.parseFrom(data);
        }


        public static ItemNormal parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ItemNormal) PARSER.parseFrom(data, extensionRegistry);
        }


        public static ItemNormal parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ItemNormal) PARSER.parseFrom(data);
        }


        public static ItemNormal parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ItemNormal) PARSER.parseFrom(data, extensionRegistry);
        }


        public static ItemNormal parseFrom(InputStream input) throws IOException {
            return (ItemNormal) PARSER.parseFrom(input);
        }


        public static ItemNormal parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ItemNormal) PARSER.parseFrom(input, extensionRegistry);
        }


        public static ItemNormal parseDelimitedFrom(InputStream input) throws IOException {
            return (ItemNormal) PARSER.parseDelimitedFrom(input);
        }


        public static ItemNormal parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ItemNormal) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static ItemNormal parseFrom(CodedInputStream input) throws IOException {
            return (ItemNormal) PARSER.parseFrom(input);
        }


        public static ItemNormal parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ItemNormal) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(ItemNormal prototype) {
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
                implements BattleHandler.ItemNormalOrBuilder {
            private int bitField0_;


            private Object itemCode_;


            private int itemNum_;


            public static final Descriptors.Descriptor getDescriptor() {
                return BattleHandler.internal_static_pomelo_area_ItemNormal_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return BattleHandler.internal_static_pomelo_area_ItemNormal_fieldAccessorTable.ensureFieldAccessorsInitialized(BattleHandler.ItemNormal.class, Builder.class);
            }


            private Builder() {
                this.itemCode_ = "";
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.itemCode_ = "";
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (BattleHandler.ItemNormal.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.itemCode_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                this.itemNum_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return BattleHandler.internal_static_pomelo_area_ItemNormal_descriptor;
            }


            public BattleHandler.ItemNormal getDefaultInstanceForType() {
                return BattleHandler.ItemNormal.getDefaultInstance();
            }


            public BattleHandler.ItemNormal build() {
                BattleHandler.ItemNormal result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public BattleHandler.ItemNormal buildPartial() {
                BattleHandler.ItemNormal result = new BattleHandler.ItemNormal(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.itemCode_ = this.itemCode_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.itemNum_ = this.itemNum_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof BattleHandler.ItemNormal) {
                    return mergeFrom((BattleHandler.ItemNormal) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(BattleHandler.ItemNormal other) {
                if (other == BattleHandler.ItemNormal.getDefaultInstance()) {
                    return this;
                }
                if (other.hasItemCode()) {
                    this.bitField0_ |= 0x1;
                    this.itemCode_ = other.itemCode_;
                    onChanged();
                }
                if (other.hasItemNum()) {
                    setItemNum(other.getItemNum());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasItemCode()) {
                    return false;
                }
                if (!hasItemNum()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                BattleHandler.ItemNormal parsedMessage = null;
                try {
                    parsedMessage = (BattleHandler.ItemNormal) BattleHandler.ItemNormal.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (BattleHandler.ItemNormal) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasItemCode() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public String getItemCode() {
                Object ref = this.itemCode_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.itemCode_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }


            public ByteString getItemCodeBytes() {
                Object ref = this.itemCode_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.itemCode_ = b;
                    return b;
                }
                return (ByteString) ref;
            }


            public Builder setItemCode(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x1;
                this.itemCode_ = value;
                onChanged();
                return this;
            }


            public Builder clearItemCode() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.itemCode_ = BattleHandler.ItemNormal.getDefaultInstance().getItemCode();
                onChanged();
                return this;
            }


            public Builder setItemCodeBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x1;
                this.itemCode_ = value;
                onChanged();
                return this;
            }


            public boolean hasItemNum() {
                return ((this.bitField0_ & 0x2) == 2);
            }


            public int getItemNum() {
                return this.itemNum_;
            }


            public Builder setItemNum(int value) {
                this.bitField0_ |= 0x2;
                this.itemNum_ = value;
                onChanged();
                return this;
            }


            public Builder clearItemNum() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.itemNum_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class ThrowPointRequest
            extends GeneratedMessage
            implements ThrowPointRequestOrBuilder {
        private static final ThrowPointRequest defaultInstance = new ThrowPointRequest(true);
        private final UnknownFieldSet unknownFields;

        private ThrowPointRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private ThrowPointRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static ThrowPointRequest getDefaultInstance() {
            return defaultInstance;
        }

        public ThrowPointRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ThrowPointRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return BattleHandler.internal_static_pomelo_area_ThrowPointRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return BattleHandler.internal_static_pomelo_area_ThrowPointRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ThrowPointRequest.class, Builder.class);
        }

        public static Parser<ThrowPointRequest> PARSER = (Parser<ThrowPointRequest>) new AbstractParser<ThrowPointRequest>() {
            public BattleHandler.ThrowPointRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BattleHandler.ThrowPointRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int ID_FIELD_NUMBER = 1;
        private Object id_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<ThrowPointRequest> getParserForType() {
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
                output.writeBytes(1, getIdBytes());
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
                size += CodedOutputStream.computeBytesSize(1, getIdBytes());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static ThrowPointRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ThrowPointRequest) PARSER.parseFrom(data);
        }


        public static ThrowPointRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ThrowPointRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static ThrowPointRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ThrowPointRequest) PARSER.parseFrom(data);
        }


        public static ThrowPointRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ThrowPointRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static ThrowPointRequest parseFrom(InputStream input) throws IOException {
            return (ThrowPointRequest) PARSER.parseFrom(input);
        }


        public static ThrowPointRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ThrowPointRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static ThrowPointRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (ThrowPointRequest) PARSER.parseDelimitedFrom(input);
        }


        public static ThrowPointRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ThrowPointRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static ThrowPointRequest parseFrom(CodedInputStream input) throws IOException {
            return (ThrowPointRequest) PARSER.parseFrom(input);
        }


        public static ThrowPointRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ThrowPointRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(ThrowPointRequest prototype) {
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
                implements BattleHandler.ThrowPointRequestOrBuilder {
            private int bitField0_;


            private Object id_;


            public static final Descriptors.Descriptor getDescriptor() {
                return BattleHandler.internal_static_pomelo_area_ThrowPointRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return BattleHandler.internal_static_pomelo_area_ThrowPointRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(BattleHandler.ThrowPointRequest.class, Builder.class);
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
                if (BattleHandler.ThrowPointRequest.alwaysUseFieldBuilders) ;
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
                return BattleHandler.internal_static_pomelo_area_ThrowPointRequest_descriptor;
            }


            public BattleHandler.ThrowPointRequest getDefaultInstanceForType() {
                return BattleHandler.ThrowPointRequest.getDefaultInstance();
            }


            public BattleHandler.ThrowPointRequest build() {
                BattleHandler.ThrowPointRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public BattleHandler.ThrowPointRequest buildPartial() {
                BattleHandler.ThrowPointRequest result = new BattleHandler.ThrowPointRequest(this);
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
                if (other instanceof BattleHandler.ThrowPointRequest) {
                    return mergeFrom((BattleHandler.ThrowPointRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(BattleHandler.ThrowPointRequest other) {
                if (other == BattleHandler.ThrowPointRequest.getDefaultInstance()) {
                    return this;
                }
                if (other.hasId()) {
                    this.bitField0_ |= 0x1;
                    this.id_ = other.id_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                BattleHandler.ThrowPointRequest parsedMessage = null;
                try {
                    parsedMessage = (BattleHandler.ThrowPointRequest) BattleHandler.ThrowPointRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (BattleHandler.ThrowPointRequest) e.getUnfinishedMessage();
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
                this.bitField0_ |= 0x1;
                this.id_ = value;
                onChanged();
                return this;
            }


            public Builder clearId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.id_ = BattleHandler.ThrowPointRequest.getDefaultInstance().getId();
                onChanged();
                return this;
            }


            public Builder setIdBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x1;
                this.id_ = value;
                onChanged();
                return this;
            }
        }
    }


    public static final class ThrowPointResponse
            extends GeneratedMessage
            implements ThrowPointResponseOrBuilder {
        private static final ThrowPointResponse defaultInstance = new ThrowPointResponse(true);
        private final UnknownFieldSet unknownFields;

        private ThrowPointResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private ThrowPointResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static ThrowPointResponse getDefaultInstance() {
            return defaultInstance;
        }

        public ThrowPointResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ThrowPointResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.point_ = input.readInt32();
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
            return BattleHandler.internal_static_pomelo_area_ThrowPointResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return BattleHandler.internal_static_pomelo_area_ThrowPointResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ThrowPointResponse.class, Builder.class);
        }

        public static Parser<ThrowPointResponse> PARSER = (Parser<ThrowPointResponse>) new AbstractParser<ThrowPointResponse>() {
            public BattleHandler.ThrowPointResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BattleHandler.ThrowPointResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int POINT_FIELD_NUMBER = 3;
        private int point_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<ThrowPointResponse> getParserForType() {
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


        public boolean hasPoint() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public int getPoint() {
            return this.point_;
        }


        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.point_ = 0;
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
                output.writeInt32(3, this.point_);
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
                size += CodedOutputStream.computeInt32Size(3, this.point_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static ThrowPointResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ThrowPointResponse) PARSER.parseFrom(data);
        }


        public static ThrowPointResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ThrowPointResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static ThrowPointResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ThrowPointResponse) PARSER.parseFrom(data);
        }


        public static ThrowPointResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ThrowPointResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static ThrowPointResponse parseFrom(InputStream input) throws IOException {
            return (ThrowPointResponse) PARSER.parseFrom(input);
        }


        public static ThrowPointResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ThrowPointResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static ThrowPointResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (ThrowPointResponse) PARSER.parseDelimitedFrom(input);
        }


        public static ThrowPointResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ThrowPointResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static ThrowPointResponse parseFrom(CodedInputStream input) throws IOException {
            return (ThrowPointResponse) PARSER.parseFrom(input);
        }


        public static ThrowPointResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ThrowPointResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(ThrowPointResponse prototype) {
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
                implements BattleHandler.ThrowPointResponseOrBuilder {
            private int bitField0_;


            private int s2CCode_;


            private Object s2CMsg_;


            private int point_;


            public static final Descriptors.Descriptor getDescriptor() {
                return BattleHandler.internal_static_pomelo_area_ThrowPointResponse_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return BattleHandler.internal_static_pomelo_area_ThrowPointResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(BattleHandler.ThrowPointResponse.class, Builder.class);
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
                if (BattleHandler.ThrowPointResponse.alwaysUseFieldBuilders) ;
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
                this.point_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return BattleHandler.internal_static_pomelo_area_ThrowPointResponse_descriptor;
            }


            public BattleHandler.ThrowPointResponse getDefaultInstanceForType() {
                return BattleHandler.ThrowPointResponse.getDefaultInstance();
            }


            public BattleHandler.ThrowPointResponse build() {
                BattleHandler.ThrowPointResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public BattleHandler.ThrowPointResponse buildPartial() {
                BattleHandler.ThrowPointResponse result = new BattleHandler.ThrowPointResponse(this);
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
                result.point_ = this.point_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof BattleHandler.ThrowPointResponse) {
                    return mergeFrom((BattleHandler.ThrowPointResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(BattleHandler.ThrowPointResponse other) {
                if (other == BattleHandler.ThrowPointResponse.getDefaultInstance()) {
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
                if (other.hasPoint()) {
                    setPoint(other.getPoint());
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
                BattleHandler.ThrowPointResponse parsedMessage = null;
                try {
                    parsedMessage = (BattleHandler.ThrowPointResponse) BattleHandler.ThrowPointResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (BattleHandler.ThrowPointResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = BattleHandler.ThrowPointResponse.getDefaultInstance().getS2CMsg();
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


            public boolean hasPoint() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public int getPoint() {
                return this.point_;
            }


            public Builder setPoint(int value) {
                this.bitField0_ |= 0x4;
                this.point_ = value;
                onChanged();
                return this;
            }


            public Builder clearPoint() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.point_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class ThrowPointResultPush
            extends GeneratedMessage
            implements ThrowPointResultPushOrBuilder {
        private static final ThrowPointResultPush defaultInstance = new ThrowPointResultPush(true);
        private final UnknownFieldSet unknownFields;

        private ThrowPointResultPush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private ThrowPointResultPush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static ThrowPointResultPush getDefaultInstance() {
            return defaultInstance;
        }

        public ThrowPointResultPush getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ThrowPointResultPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        case 18:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x2;
                            this.name_ = bs;
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.point_ = input.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.s2CCode_ = input.readInt32();
                            break;
                        case 42:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x10;
                            this.itemCode_ = bs;
                            break;
                        case 48:
                            this.bitField0_ |= 0x20;
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
            return BattleHandler.internal_static_pomelo_area_ThrowPointResultPush_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return BattleHandler.internal_static_pomelo_area_ThrowPointResultPush_fieldAccessorTable.ensureFieldAccessorsInitialized(ThrowPointResultPush.class, Builder.class);
        }

        public static Parser<ThrowPointResultPush> PARSER = (Parser<ThrowPointResultPush>) new AbstractParser<ThrowPointResultPush>() {
            public BattleHandler.ThrowPointResultPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BattleHandler.ThrowPointResultPush(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int ID_FIELD_NUMBER = 1;
        private Object id_;
        public static final int NAME_FIELD_NUMBER = 2;
        private Object name_;
        public static final int POINT_FIELD_NUMBER = 3;
        private int point_;
        public static final int S2C_CODE_FIELD_NUMBER = 4;
        private int s2CCode_;
        public static final int ITEMCODE_FIELD_NUMBER = 5;
        private Object itemCode_;
        public static final int NUM_FIELD_NUMBER = 6;
        private int num_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<ThrowPointResultPush> getParserForType() {
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

        public boolean hasName() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        static {
            defaultInstance.initFields();
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


        public boolean hasPoint() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public int getPoint() {
            return this.point_;
        }


        public boolean hasS2CCode() {
            return ((this.bitField0_ & 0x8) == 8);
        }


        public int getS2CCode() {
            return this.s2CCode_;
        }


        public boolean hasItemCode() {
            return ((this.bitField0_ & 0x10) == 16);
        }


        public String getItemCode() {
            Object ref = this.itemCode_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.itemCode_ = s;
            }
            return s;
        }


        public ByteString getItemCodeBytes() {
            Object ref = this.itemCode_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.itemCode_ = b;
                return b;
            }
            return (ByteString) ref;
        }


        public boolean hasNum() {
            return ((this.bitField0_ & 0x20) == 32);
        }


        public int getNum() {
            return this.num_;
        }


        private void initFields() {
            this.id_ = "";
            this.name_ = "";
            this.point_ = 0;
            this.s2CCode_ = 0;
            this.itemCode_ = "";
            this.num_ = 0;
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
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
            if (!hasPoint()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasS2CCode()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasItemCode()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasNum()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeBytes(1, getIdBytes());
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeBytes(2, getNameBytes());
            }
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeInt32(3, this.point_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                output.writeInt32(4, this.s2CCode_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                output.writeBytes(5, getItemCodeBytes());
            }
            if ((this.bitField0_ & 0x20) == 32) {
                output.writeInt32(6, this.num_);
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
                size += CodedOutputStream.computeBytesSize(1, getIdBytes());
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeBytesSize(2, getNameBytes());
            }
            if ((this.bitField0_ & 0x4) == 4) {
                size += CodedOutputStream.computeInt32Size(3, this.point_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                size += CodedOutputStream.computeInt32Size(4, this.s2CCode_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                size += CodedOutputStream.computeBytesSize(5, getItemCodeBytes());
            }
            if ((this.bitField0_ & 0x20) == 32) {
                size += CodedOutputStream.computeInt32Size(6, this.num_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static ThrowPointResultPush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ThrowPointResultPush) PARSER.parseFrom(data);
        }


        public static ThrowPointResultPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ThrowPointResultPush) PARSER.parseFrom(data, extensionRegistry);
        }


        public static ThrowPointResultPush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ThrowPointResultPush) PARSER.parseFrom(data);
        }


        public static ThrowPointResultPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ThrowPointResultPush) PARSER.parseFrom(data, extensionRegistry);
        }


        public static ThrowPointResultPush parseFrom(InputStream input) throws IOException {
            return (ThrowPointResultPush) PARSER.parseFrom(input);
        }


        public static ThrowPointResultPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ThrowPointResultPush) PARSER.parseFrom(input, extensionRegistry);
        }


        public static ThrowPointResultPush parseDelimitedFrom(InputStream input) throws IOException {
            return (ThrowPointResultPush) PARSER.parseDelimitedFrom(input);
        }


        public static ThrowPointResultPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ThrowPointResultPush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static ThrowPointResultPush parseFrom(CodedInputStream input) throws IOException {
            return (ThrowPointResultPush) PARSER.parseFrom(input);
        }


        public static ThrowPointResultPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ThrowPointResultPush) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(ThrowPointResultPush prototype) {
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
                implements BattleHandler.ThrowPointResultPushOrBuilder {
            private int bitField0_;


            private Object id_;


            private Object name_;


            private int point_;


            private int s2CCode_;


            private Object itemCode_;


            private int num_;


            public static final Descriptors.Descriptor getDescriptor() {
                return BattleHandler.internal_static_pomelo_area_ThrowPointResultPush_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return BattleHandler.internal_static_pomelo_area_ThrowPointResultPush_fieldAccessorTable.ensureFieldAccessorsInitialized(BattleHandler.ThrowPointResultPush.class, Builder.class);
            }


            private Builder() {
                this.id_ = "";
                this.name_ = "";
                this.itemCode_ = "";
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.id_ = "";
                this.name_ = "";
                this.itemCode_ = "";
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (BattleHandler.ThrowPointResultPush.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.id_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                this.name_ = "";
                this.bitField0_ &= 0xFFFFFFFD;
                this.point_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.s2CCode_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                this.itemCode_ = "";
                this.bitField0_ &= 0xFFFFFFEF;
                this.num_ = 0;
                this.bitField0_ &= 0xFFFFFFDF;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return BattleHandler.internal_static_pomelo_area_ThrowPointResultPush_descriptor;
            }


            public BattleHandler.ThrowPointResultPush getDefaultInstanceForType() {
                return BattleHandler.ThrowPointResultPush.getDefaultInstance();
            }


            public BattleHandler.ThrowPointResultPush build() {
                BattleHandler.ThrowPointResultPush result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public BattleHandler.ThrowPointResultPush buildPartial() {
                BattleHandler.ThrowPointResultPush result = new BattleHandler.ThrowPointResultPush(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.id_ = this.id_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.name_ = this.name_;
                if ((from_bitField0_ & 0x4) == 4) {
                    to_bitField0_ |= 0x4;
                }
                result.point_ = this.point_;
                if ((from_bitField0_ & 0x8) == 8) {
                    to_bitField0_ |= 0x8;
                }
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x10) == 16) {
                    to_bitField0_ |= 0x10;
                }
                result.itemCode_ = this.itemCode_;
                if ((from_bitField0_ & 0x20) == 32) {
                    to_bitField0_ |= 0x20;
                }
                result.num_ = this.num_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof BattleHandler.ThrowPointResultPush) {
                    return mergeFrom((BattleHandler.ThrowPointResultPush) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(BattleHandler.ThrowPointResultPush other) {
                if (other == BattleHandler.ThrowPointResultPush.getDefaultInstance()) {
                    return this;
                }
                if (other.hasId()) {
                    this.bitField0_ |= 0x1;
                    this.id_ = other.id_;
                    onChanged();
                }
                if (other.hasName()) {
                    this.bitField0_ |= 0x2;
                    this.name_ = other.name_;
                    onChanged();
                }
                if (other.hasPoint()) {
                    setPoint(other.getPoint());
                }
                if (other.hasS2CCode()) {
                    setS2CCode(other.getS2CCode());
                }
                if (other.hasItemCode()) {
                    this.bitField0_ |= 0x10;
                    this.itemCode_ = other.itemCode_;
                    onChanged();
                }
                if (other.hasNum()) {
                    setNum(other.getNum());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasId()) {
                    return false;
                }
                if (!hasName()) {
                    return false;
                }
                if (!hasPoint()) {
                    return false;
                }
                if (!hasS2CCode()) {
                    return false;
                }
                if (!hasItemCode()) {
                    return false;
                }
                if (!hasNum()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                BattleHandler.ThrowPointResultPush parsedMessage = null;
                try {
                    parsedMessage = (BattleHandler.ThrowPointResultPush) BattleHandler.ThrowPointResultPush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (BattleHandler.ThrowPointResultPush) e.getUnfinishedMessage();
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
                this.bitField0_ |= 0x1;
                this.id_ = value;
                onChanged();
                return this;
            }


            public Builder clearId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.id_ = BattleHandler.ThrowPointResultPush.getDefaultInstance().getId();
                onChanged();
                return this;
            }


            public Builder setIdBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x1;
                this.id_ = value;
                onChanged();
                return this;
            }


            public boolean hasName() {
                return ((this.bitField0_ & 0x2) == 2);
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
                this.bitField0_ |= 0x2;
                this.name_ = value;
                onChanged();
                return this;
            }


            public Builder clearName() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.name_ = BattleHandler.ThrowPointResultPush.getDefaultInstance().getName();
                onChanged();
                return this;
            }


            public Builder setNameBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x2;
                this.name_ = value;
                onChanged();
                return this;
            }


            public boolean hasPoint() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public int getPoint() {
                return this.point_;
            }


            public Builder setPoint(int value) {
                this.bitField0_ |= 0x4;
                this.point_ = value;
                onChanged();
                return this;
            }


            public Builder clearPoint() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.point_ = 0;
                onChanged();
                return this;
            }


            public boolean hasS2CCode() {
                return ((this.bitField0_ & 0x8) == 8);
            }


            public int getS2CCode() {
                return this.s2CCode_;
            }


            public Builder setS2CCode(int value) {
                this.bitField0_ |= 0x8;
                this.s2CCode_ = value;
                onChanged();
                return this;
            }


            public Builder clearS2CCode() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.s2CCode_ = 0;
                onChanged();
                return this;
            }


            public boolean hasItemCode() {
                return ((this.bitField0_ & 0x10) == 16);
            }


            public String getItemCode() {
                Object ref = this.itemCode_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.itemCode_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }


            public ByteString getItemCodeBytes() {
                Object ref = this.itemCode_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.itemCode_ = b;
                    return b;
                }
                return (ByteString) ref;
            }


            public Builder setItemCode(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x10;
                this.itemCode_ = value;
                onChanged();
                return this;
            }


            public Builder clearItemCode() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.itemCode_ = BattleHandler.ThrowPointResultPush.getDefaultInstance().getItemCode();
                onChanged();
                return this;
            }


            public Builder setItemCodeBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x10;
                this.itemCode_ = value;
                onChanged();
                return this;
            }


            public boolean hasNum() {
                return ((this.bitField0_ & 0x20) == 32);
            }


            public int getNum() {
                return this.num_;
            }


            public Builder setNum(int value) {
                this.bitField0_ |= 0x20;
                this.num_ = value;
                onChanged();
                return this;
            }


            public Builder clearNum() {
                this.bitField0_ &= 0xFFFFFFDF;
                this.num_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class FightLevelResultPush
            extends GeneratedMessage
            implements FightLevelResultPushOrBuilder {
        private static final FightLevelResultPush defaultInstance = new FightLevelResultPush(true);
        private final UnknownFieldSet unknownFields;

        private FightLevelResultPush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private FightLevelResultPush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static FightLevelResultPush getDefaultInstance() {
            return defaultInstance;
        }

        public FightLevelResultPush getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private FightLevelResultPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    Common.DemonTowerFloorInfo.Builder subBuilder;
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        case 8:
                            this.bitField0_ |= 0x1;
                            this.time_ = input.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.level_ = input.readInt32();
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.type_ = input.readInt32();
                            break;
                        case 34:
                            if ((mutable_bitField0_ & 0x8) != 8) {
                                this.itemLine1_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x8;
                            }
                            this.itemLine1_.add(input.readMessage(BattleHandler.ItemNormal.PARSER, extensionRegistry));
                            break;
                        case 50:
                            if ((mutable_bitField0_ & 0x10) != 16) {
                                this.itemLine2_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x10;
                            }
                            this.itemLine2_.add(input.readMessage(BattleHandler.ItemNormal.PARSER, extensionRegistry));
                            break;
                        case 56:
                            this.bitField0_ |= 0x8;
                            this.isMax_ = input.readInt32();
                            break;
                        case 66:
                            subBuilder = null;
                            if ((this.bitField0_ & 0x10) == 16) subBuilder = this.demonTowerFloorInfo_.toBuilder();
                            this.demonTowerFloorInfo_ = (Common.DemonTowerFloorInfo) input.readMessage(Common.DemonTowerFloorInfo.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.demonTowerFloorInfo_);
                                this.demonTowerFloorInfo_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 0x10;
                            break;
                        case 72:
                            this.bitField0_ |= 0x20;
                            this.currentTime_ = input.readInt32();
                            break;
                        case 80:
                            this.bitField0_ |= 0x40;
                            this.newRecordFloor_ = input.readBool();
                            break;
                        case 88:
                            this.bitField0_ |= 0x80;
                            this.newRecordTime_ = input.readBool();
                            break;
                        case 96:
                            this.bitField0_ |= 0x100;
                            this.myMaxFloorId_ = input.readInt32();
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x8) == 8) this.itemLine1_ = Collections.unmodifiableList(this.itemLine1_);
                if ((mutable_bitField0_ & 0x10) == 16) this.itemLine2_ = Collections.unmodifiableList(this.itemLine2_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return BattleHandler.internal_static_pomelo_area_FightLevelResultPush_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return BattleHandler.internal_static_pomelo_area_FightLevelResultPush_fieldAccessorTable.ensureFieldAccessorsInitialized(FightLevelResultPush.class, Builder.class);
        }

        public static Parser<FightLevelResultPush> PARSER = (Parser<FightLevelResultPush>) new AbstractParser<FightLevelResultPush>() {
            public BattleHandler.FightLevelResultPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BattleHandler.FightLevelResultPush(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int TIME_FIELD_NUMBER = 1;
        private int time_;
        public static final int LEVEL_FIELD_NUMBER = 2;
        private int level_;
        public static final int TYPE_FIELD_NUMBER = 3;
        private int type_;
        public static final int ITEMLINE1_FIELD_NUMBER = 4;
        private List<BattleHandler.ItemNormal> itemLine1_;
        public static final int ITEMLINE2_FIELD_NUMBER = 6;
        private List<BattleHandler.ItemNormal> itemLine2_;

        static {
            defaultInstance.initFields();
        }


        public static final int ISMAX_FIELD_NUMBER = 7;


        private int isMax_;


        public static final int DEMONTOWERFLOORINFO_FIELD_NUMBER = 8;


        private Common.DemonTowerFloorInfo demonTowerFloorInfo_;


        public static final int CURRENTTIME_FIELD_NUMBER = 9;


        private int currentTime_;


        public static final int NEWRECORDFLOOR_FIELD_NUMBER = 10;


        private boolean newRecordFloor_;


        public static final int NEWRECORDTIME_FIELD_NUMBER = 11;


        private boolean newRecordTime_;


        public static final int MYMAXFLOORID_FIELD_NUMBER = 12;


        private int myMaxFloorId_;


        private byte memoizedIsInitialized;


        private int memoizedSerializedSize;


        private static final long serialVersionUID = 0L;


        public Parser<FightLevelResultPush> getParserForType() {
            return PARSER;
        }


        public boolean hasTime() {
            return ((this.bitField0_ & 0x1) == 1);
        }


        public int getTime() {
            return this.time_;
        }


        public boolean hasLevel() {
            return ((this.bitField0_ & 0x2) == 2);
        }


        public int getLevel() {
            return this.level_;
        }


        public boolean hasType() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public int getType() {
            return this.type_;
        }


        public List<BattleHandler.ItemNormal> getItemLine1List() {
            return this.itemLine1_;
        }


        public List<? extends BattleHandler.ItemNormalOrBuilder> getItemLine1OrBuilderList() {
            return (List) this.itemLine1_;
        }


        public int getItemLine1Count() {
            return this.itemLine1_.size();
        }


        public BattleHandler.ItemNormal getItemLine1(int index) {
            return this.itemLine1_.get(index);
        }


        public BattleHandler.ItemNormalOrBuilder getItemLine1OrBuilder(int index) {
            return this.itemLine1_.get(index);
        }


        public List<BattleHandler.ItemNormal> getItemLine2List() {
            return this.itemLine2_;
        }


        public List<? extends BattleHandler.ItemNormalOrBuilder> getItemLine2OrBuilderList() {
            return (List) this.itemLine2_;
        }


        public int getItemLine2Count() {
            return this.itemLine2_.size();
        }


        public BattleHandler.ItemNormal getItemLine2(int index) {
            return this.itemLine2_.get(index);
        }


        public BattleHandler.ItemNormalOrBuilder getItemLine2OrBuilder(int index) {
            return this.itemLine2_.get(index);
        }


        public boolean hasIsMax() {
            return ((this.bitField0_ & 0x8) == 8);
        }


        public int getIsMax() {
            return this.isMax_;
        }


        public boolean hasDemonTowerFloorInfo() {
            return ((this.bitField0_ & 0x10) == 16);
        }


        public Common.DemonTowerFloorInfo getDemonTowerFloorInfo() {
            return this.demonTowerFloorInfo_;
        }


        public Common.DemonTowerFloorInfoOrBuilder getDemonTowerFloorInfoOrBuilder() {
            return (Common.DemonTowerFloorInfoOrBuilder) this.demonTowerFloorInfo_;
        }


        public boolean hasCurrentTime() {
            return ((this.bitField0_ & 0x20) == 32);
        }


        public int getCurrentTime() {
            return this.currentTime_;
        }


        public boolean hasNewRecordFloor() {
            return ((this.bitField0_ & 0x40) == 64);
        }


        public boolean getNewRecordFloor() {
            return this.newRecordFloor_;
        }


        public boolean hasNewRecordTime() {
            return ((this.bitField0_ & 0x80) == 128);
        }


        public boolean getNewRecordTime() {
            return this.newRecordTime_;
        }


        public boolean hasMyMaxFloorId() {
            return ((this.bitField0_ & 0x100) == 256);
        }


        public int getMyMaxFloorId() {
            return this.myMaxFloorId_;
        }


        private void initFields() {
            this.time_ = 0;
            this.level_ = 0;
            this.type_ = 0;
            this.itemLine1_ = Collections.emptyList();
            this.itemLine2_ = Collections.emptyList();
            this.isMax_ = 0;
            this.demonTowerFloorInfo_ = Common.DemonTowerFloorInfo.getDefaultInstance();
            this.currentTime_ = 0;
            this.newRecordFloor_ = false;
            this.newRecordTime_ = false;
            this.myMaxFloorId_ = 0;
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
            for (i = 0; i < getItemLine1Count(); i++) {
                if (!getItemLine1(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (i = 0; i < getItemLine2Count(); i++) {
                if (!getItemLine2(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            if (hasDemonTowerFloorInfo() && !getDemonTowerFloorInfo().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeInt32(1, this.time_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeInt32(2, this.level_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeInt32(3, this.type_);
            }
            int i;
            for (i = 0; i < this.itemLine1_.size(); i++) {
                output.writeMessage(4, (MessageLite) this.itemLine1_.get(i));
            }
            for (i = 0; i < this.itemLine2_.size(); i++) {
                output.writeMessage(6, (MessageLite) this.itemLine2_.get(i));
            }
            if ((this.bitField0_ & 0x8) == 8) {
                output.writeInt32(7, this.isMax_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                output.writeMessage(8, (MessageLite) this.demonTowerFloorInfo_);
            }
            if ((this.bitField0_ & 0x20) == 32) {
                output.writeInt32(9, this.currentTime_);
            }
            if ((this.bitField0_ & 0x40) == 64) {
                output.writeBool(10, this.newRecordFloor_);
            }
            if ((this.bitField0_ & 0x80) == 128) {
                output.writeBool(11, this.newRecordTime_);
            }
            if ((this.bitField0_ & 0x100) == 256) {
                output.writeInt32(12, this.myMaxFloorId_);
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
                size += CodedOutputStream.computeInt32Size(1, this.time_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeInt32Size(2, this.level_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                size += CodedOutputStream.computeInt32Size(3, this.type_);
            }
            int i;
            for (i = 0; i < this.itemLine1_.size(); i++) {
                size += CodedOutputStream.computeMessageSize(4, (MessageLite) this.itemLine1_.get(i));
            }
            for (i = 0; i < this.itemLine2_.size(); i++) {
                size += CodedOutputStream.computeMessageSize(6, (MessageLite) this.itemLine2_.get(i));
            }
            if ((this.bitField0_ & 0x8) == 8) {
                size += CodedOutputStream.computeInt32Size(7, this.isMax_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                size += CodedOutputStream.computeMessageSize(8, (MessageLite) this.demonTowerFloorInfo_);
            }
            if ((this.bitField0_ & 0x20) == 32) {
                size += CodedOutputStream.computeInt32Size(9, this.currentTime_);
            }
            if ((this.bitField0_ & 0x40) == 64) {
                size += CodedOutputStream.computeBoolSize(10, this.newRecordFloor_);
            }
            if ((this.bitField0_ & 0x80) == 128) {
                size += CodedOutputStream.computeBoolSize(11, this.newRecordTime_);
            }
            if ((this.bitField0_ & 0x100) == 256) {
                size += CodedOutputStream.computeInt32Size(12, this.myMaxFloorId_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static FightLevelResultPush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (FightLevelResultPush) PARSER.parseFrom(data);
        }


        public static FightLevelResultPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FightLevelResultPush) PARSER.parseFrom(data, extensionRegistry);
        }


        public static FightLevelResultPush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (FightLevelResultPush) PARSER.parseFrom(data);
        }


        public static FightLevelResultPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FightLevelResultPush) PARSER.parseFrom(data, extensionRegistry);
        }


        public static FightLevelResultPush parseFrom(InputStream input) throws IOException {
            return (FightLevelResultPush) PARSER.parseFrom(input);
        }


        public static FightLevelResultPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FightLevelResultPush) PARSER.parseFrom(input, extensionRegistry);
        }


        public static FightLevelResultPush parseDelimitedFrom(InputStream input) throws IOException {
            return (FightLevelResultPush) PARSER.parseDelimitedFrom(input);
        }


        public static FightLevelResultPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FightLevelResultPush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static FightLevelResultPush parseFrom(CodedInputStream input) throws IOException {
            return (FightLevelResultPush) PARSER.parseFrom(input);
        }


        public static FightLevelResultPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FightLevelResultPush) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(FightLevelResultPush prototype) {
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
                implements BattleHandler.FightLevelResultPushOrBuilder {
            private int bitField0_;

            private int time_;

            private int level_;

            private int type_;

            private List<BattleHandler.ItemNormal> itemLine1_;

            private RepeatedFieldBuilder<BattleHandler.ItemNormal, BattleHandler.ItemNormal.Builder, BattleHandler.ItemNormalOrBuilder> itemLine1Builder_;

            private List<BattleHandler.ItemNormal> itemLine2_;

            private RepeatedFieldBuilder<BattleHandler.ItemNormal, BattleHandler.ItemNormal.Builder, BattleHandler.ItemNormalOrBuilder> itemLine2Builder_;

            private int isMax_;

            private Common.DemonTowerFloorInfo demonTowerFloorInfo_;

            private SingleFieldBuilder<Common.DemonTowerFloorInfo, Common.DemonTowerFloorInfo.Builder, Common.DemonTowerFloorInfoOrBuilder> demonTowerFloorInfoBuilder_;

            private int currentTime_;

            private boolean newRecordFloor_;

            private boolean newRecordTime_;

            private int myMaxFloorId_;


            public static final Descriptors.Descriptor getDescriptor() {
                return BattleHandler.internal_static_pomelo_area_FightLevelResultPush_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return BattleHandler.internal_static_pomelo_area_FightLevelResultPush_fieldAccessorTable.ensureFieldAccessorsInitialized(BattleHandler.FightLevelResultPush.class, Builder.class);
            }


            private Builder() {
                this.itemLine1_ = Collections.emptyList();
                this.itemLine2_ = Collections.emptyList();
                this.demonTowerFloorInfo_ = Common.DemonTowerFloorInfo.getDefaultInstance();
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.itemLine1_ = Collections.emptyList();
                this.itemLine2_ = Collections.emptyList();
                this.demonTowerFloorInfo_ = Common.DemonTowerFloorInfo.getDefaultInstance();
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (BattleHandler.FightLevelResultPush.alwaysUseFieldBuilders) {
                    getItemLine1FieldBuilder();
                    getItemLine2FieldBuilder();
                    getDemonTowerFloorInfoFieldBuilder();
                }
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.time_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.level_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                this.type_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                if (this.itemLine1Builder_ == null) {
                    this.itemLine1_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFF7;
                } else {
                    this.itemLine1Builder_.clear();
                }
                if (this.itemLine2Builder_ == null) {
                    this.itemLine2_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFEF;
                } else {
                    this.itemLine2Builder_.clear();
                }
                this.isMax_ = 0;
                this.bitField0_ &= 0xFFFFFFDF;
                if (this.demonTowerFloorInfoBuilder_ == null) {
                    this.demonTowerFloorInfo_ = Common.DemonTowerFloorInfo.getDefaultInstance();
                } else {
                    this.demonTowerFloorInfoBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFBF;
                this.currentTime_ = 0;
                this.bitField0_ &= 0xFFFFFF7F;
                this.newRecordFloor_ = false;
                this.bitField0_ &= 0xFFFFFEFF;
                this.newRecordTime_ = false;
                this.bitField0_ &= 0xFFFFFDFF;
                this.myMaxFloorId_ = 0;
                this.bitField0_ &= 0xFFFFFBFF;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return BattleHandler.internal_static_pomelo_area_FightLevelResultPush_descriptor;
            }


            public BattleHandler.FightLevelResultPush getDefaultInstanceForType() {
                return BattleHandler.FightLevelResultPush.getDefaultInstance();
            }


            public BattleHandler.FightLevelResultPush build() {
                BattleHandler.FightLevelResultPush result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public BattleHandler.FightLevelResultPush buildPartial() {
                BattleHandler.FightLevelResultPush result = new BattleHandler.FightLevelResultPush(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.time_ = this.time_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.level_ = this.level_;
                if ((from_bitField0_ & 0x4) == 4) {
                    to_bitField0_ |= 0x4;
                }
                result.type_ = this.type_;
                if (this.itemLine1Builder_ == null) {
                    if ((this.bitField0_ & 0x8) == 8) {
                        this.itemLine1_ = Collections.unmodifiableList(this.itemLine1_);
                        this.bitField0_ &= 0xFFFFFFF7;
                    }
                    result.itemLine1_ = this.itemLine1_;
                } else {
                    result.itemLine1_ = this.itemLine1Builder_.build();
                }
                if (this.itemLine2Builder_ == null) {
                    if ((this.bitField0_ & 0x10) == 16) {
                        this.itemLine2_ = Collections.unmodifiableList(this.itemLine2_);
                        this.bitField0_ &= 0xFFFFFFEF;
                    }
                    result.itemLine2_ = this.itemLine2_;
                } else {
                    result.itemLine2_ = this.itemLine2Builder_.build();
                }
                if ((from_bitField0_ & 0x20) == 32) {
                    to_bitField0_ |= 0x8;
                }
                result.isMax_ = this.isMax_;
                if ((from_bitField0_ & 0x40) == 64) {
                    to_bitField0_ |= 0x10;
                }
                if (this.demonTowerFloorInfoBuilder_ == null) {
                    result.demonTowerFloorInfo_ = this.demonTowerFloorInfo_;
                } else {
                    result.demonTowerFloorInfo_ = (Common.DemonTowerFloorInfo) this.demonTowerFloorInfoBuilder_.build();
                }
                if ((from_bitField0_ & 0x80) == 128) {
                    to_bitField0_ |= 0x20;
                }
                result.currentTime_ = this.currentTime_;
                if ((from_bitField0_ & 0x100) == 256) {
                    to_bitField0_ |= 0x40;
                }
                result.newRecordFloor_ = this.newRecordFloor_;
                if ((from_bitField0_ & 0x200) == 512) {
                    to_bitField0_ |= 0x80;
                }
                result.newRecordTime_ = this.newRecordTime_;
                if ((from_bitField0_ & 0x400) == 1024) {
                    to_bitField0_ |= 0x100;
                }
                result.myMaxFloorId_ = this.myMaxFloorId_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof BattleHandler.FightLevelResultPush) {
                    return mergeFrom((BattleHandler.FightLevelResultPush) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(BattleHandler.FightLevelResultPush other) {
                if (other == BattleHandler.FightLevelResultPush.getDefaultInstance()) {
                    return this;
                }
                if (other.hasTime()) {
                    setTime(other.getTime());
                }
                if (other.hasLevel()) {
                    setLevel(other.getLevel());
                }
                if (other.hasType()) {
                    setType(other.getType());
                }
                if (this.itemLine1Builder_ == null) {
                    if (!other.itemLine1_.isEmpty()) {
                        if (this.itemLine1_.isEmpty()) {
                            this.itemLine1_ = other.itemLine1_;
                            this.bitField0_ &= 0xFFFFFFF7;
                        } else {
                            ensureItemLine1IsMutable();
                            this.itemLine1_.addAll(other.itemLine1_);
                        }
                        onChanged();
                    }
                } else if (!other.itemLine1_.isEmpty()) {
                    if (this.itemLine1Builder_.isEmpty()) {
                        this.itemLine1Builder_.dispose();
                        this.itemLine1Builder_ = null;
                        this.itemLine1_ = other.itemLine1_;
                        this.bitField0_ &= 0xFFFFFFF7;
                        this.itemLine1Builder_ = BattleHandler.FightLevelResultPush.alwaysUseFieldBuilders ? getItemLine1FieldBuilder() : null;
                    } else {
                        this.itemLine1Builder_.addAllMessages(other.itemLine1_);
                    }
                }
                if (this.itemLine2Builder_ == null) {
                    if (!other.itemLine2_.isEmpty()) {
                        if (this.itemLine2_.isEmpty()) {
                            this.itemLine2_ = other.itemLine2_;
                            this.bitField0_ &= 0xFFFFFFEF;
                        } else {
                            ensureItemLine2IsMutable();
                            this.itemLine2_.addAll(other.itemLine2_);
                        }
                        onChanged();
                    }
                } else if (!other.itemLine2_.isEmpty()) {
                    if (this.itemLine2Builder_.isEmpty()) {
                        this.itemLine2Builder_.dispose();
                        this.itemLine2Builder_ = null;
                        this.itemLine2_ = other.itemLine2_;
                        this.bitField0_ &= 0xFFFFFFEF;
                        this.itemLine2Builder_ = BattleHandler.FightLevelResultPush.alwaysUseFieldBuilders ? getItemLine2FieldBuilder() : null;
                    } else {
                        this.itemLine2Builder_.addAllMessages(other.itemLine2_);
                    }
                }
                if (other.hasIsMax()) {
                    setIsMax(other.getIsMax());
                }
                if (other.hasDemonTowerFloorInfo()) {
                    mergeDemonTowerFloorInfo(other.getDemonTowerFloorInfo());
                }
                if (other.hasCurrentTime()) {
                    setCurrentTime(other.getCurrentTime());
                }
                if (other.hasNewRecordFloor()) {
                    setNewRecordFloor(other.getNewRecordFloor());
                }
                if (other.hasNewRecordTime()) {
                    setNewRecordTime(other.getNewRecordTime());
                }
                if (other.hasMyMaxFloorId()) {
                    setMyMaxFloorId(other.getMyMaxFloorId());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                int i;
                for (i = 0; i < getItemLine1Count(); i++) {
                    if (!getItemLine1(i).isInitialized()) {
                        return false;
                    }
                }
                for (i = 0; i < getItemLine2Count(); i++) {
                    if (!getItemLine2(i).isInitialized()) {
                        return false;
                    }
                }
                if (hasDemonTowerFloorInfo() && !getDemonTowerFloorInfo().isInitialized()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                BattleHandler.FightLevelResultPush parsedMessage = null;
                try {
                    parsedMessage = (BattleHandler.FightLevelResultPush) BattleHandler.FightLevelResultPush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (BattleHandler.FightLevelResultPush) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasTime() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public int getTime() {
                return this.time_;
            }


            public Builder setTime(int value) {
                this.bitField0_ |= 0x1;
                this.time_ = value;
                onChanged();
                return this;
            }


            public Builder clearTime() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.time_ = 0;
                onChanged();
                return this;
            }


            public boolean hasLevel() {
                return ((this.bitField0_ & 0x2) == 2);
            }


            public int getLevel() {
                return this.level_;
            }


            public Builder setLevel(int value) {
                this.bitField0_ |= 0x2;
                this.level_ = value;
                onChanged();
                return this;
            }


            public Builder clearLevel() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.level_ = 0;
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


            private void ensureItemLine1IsMutable() {
                if ((this.bitField0_ & 0x8) != 8) {
                    this.itemLine1_ = new ArrayList<>(this.itemLine1_);
                    this.bitField0_ |= 0x8;
                }
            }


            public List<BattleHandler.ItemNormal> getItemLine1List() {
                if (this.itemLine1Builder_ == null) {
                    return Collections.unmodifiableList(this.itemLine1_);
                }
                return this.itemLine1Builder_.getMessageList();
            }


            public int getItemLine1Count() {
                if (this.itemLine1Builder_ == null) {
                    return this.itemLine1_.size();
                }
                return this.itemLine1Builder_.getCount();
            }


            public BattleHandler.ItemNormal getItemLine1(int index) {
                if (this.itemLine1Builder_ == null) {
                    return this.itemLine1_.get(index);
                }
                return (BattleHandler.ItemNormal) this.itemLine1Builder_.getMessage(index);
            }


            public Builder setItemLine1(int index, BattleHandler.ItemNormal value) {
                if (this.itemLine1Builder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureItemLine1IsMutable();
                    this.itemLine1_.set(index, value);
                    onChanged();
                } else {
                    this.itemLine1Builder_.setMessage(index, value);
                }
                return this;
            }


            public Builder setItemLine1(int index, BattleHandler.ItemNormal.Builder builderForValue) {
                if (this.itemLine1Builder_ == null) {
                    ensureItemLine1IsMutable();
                    this.itemLine1_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.itemLine1Builder_.setMessage(index, builderForValue.build());
                }
                return this;
            }


            public Builder addItemLine1(BattleHandler.ItemNormal value) {
                if (this.itemLine1Builder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureItemLine1IsMutable();
                    this.itemLine1_.add(value);
                    onChanged();
                } else {
                    this.itemLine1Builder_.addMessage(value);
                }
                return this;
            }


            public Builder addItemLine1(int index, BattleHandler.ItemNormal value) {
                if (this.itemLine1Builder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureItemLine1IsMutable();
                    this.itemLine1_.add(index, value);
                    onChanged();
                } else {
                    this.itemLine1Builder_.addMessage(index, value);
                }
                return this;
            }


            public Builder addItemLine1(BattleHandler.ItemNormal.Builder builderForValue) {
                if (this.itemLine1Builder_ == null) {
                    ensureItemLine1IsMutable();
                    this.itemLine1_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.itemLine1Builder_.addMessage(builderForValue.build());
                }
                return this;
            }


            public Builder addItemLine1(int index, BattleHandler.ItemNormal.Builder builderForValue) {
                if (this.itemLine1Builder_ == null) {
                    ensureItemLine1IsMutable();
                    this.itemLine1_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.itemLine1Builder_.addMessage(index, builderForValue.build());
                }
                return this;
            }


            public Builder addAllItemLine1(Iterable<? extends BattleHandler.ItemNormal> values) {
                if (this.itemLine1Builder_ == null) {
                    ensureItemLine1IsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.itemLine1_);
                    onChanged();
                } else {
                    this.itemLine1Builder_.addAllMessages(values);
                }
                return this;
            }


            public Builder clearItemLine1() {
                if (this.itemLine1Builder_ == null) {
                    this.itemLine1_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFF7;
                    onChanged();
                } else {
                    this.itemLine1Builder_.clear();
                }
                return this;
            }


            public Builder removeItemLine1(int index) {
                if (this.itemLine1Builder_ == null) {
                    ensureItemLine1IsMutable();
                    this.itemLine1_.remove(index);
                    onChanged();
                } else {
                    this.itemLine1Builder_.remove(index);
                }
                return this;
            }


            public BattleHandler.ItemNormal.Builder getItemLine1Builder(int index) {
                return (BattleHandler.ItemNormal.Builder) getItemLine1FieldBuilder().getBuilder(index);
            }


            public BattleHandler.ItemNormalOrBuilder getItemLine1OrBuilder(int index) {
                if (this.itemLine1Builder_ == null) {
                    return this.itemLine1_.get(index);
                }
                return (BattleHandler.ItemNormalOrBuilder) this.itemLine1Builder_.getMessageOrBuilder(index);
            }


            public List<? extends BattleHandler.ItemNormalOrBuilder> getItemLine1OrBuilderList() {
                if (this.itemLine1Builder_ != null) {
                    return this.itemLine1Builder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList((List) this.itemLine1_);
            }


            public BattleHandler.ItemNormal.Builder addItemLine1Builder() {
                return (BattleHandler.ItemNormal.Builder) getItemLine1FieldBuilder().addBuilder(BattleHandler.ItemNormal.getDefaultInstance());
            }


            public BattleHandler.ItemNormal.Builder addItemLine1Builder(int index) {
                return (BattleHandler.ItemNormal.Builder) getItemLine1FieldBuilder().addBuilder(index, BattleHandler.ItemNormal.getDefaultInstance());
            }


            public List<BattleHandler.ItemNormal.Builder> getItemLine1BuilderList() {
                return getItemLine1FieldBuilder().getBuilderList();
            }


            private RepeatedFieldBuilder<BattleHandler.ItemNormal, BattleHandler.ItemNormal.Builder, BattleHandler.ItemNormalOrBuilder> getItemLine1FieldBuilder() {
                if (this.itemLine1Builder_ == null) {
                    this.itemLine1Builder_ = new RepeatedFieldBuilder(this.itemLine1_, ((this.bitField0_ & 0x8) == 8), getParentForChildren(), isClean());
                    this.itemLine1_ = null;
                }
                return this.itemLine1Builder_;
            }


            private void ensureItemLine2IsMutable() {
                if ((this.bitField0_ & 0x10) != 16) {
                    this.itemLine2_ = new ArrayList<>(this.itemLine2_);
                    this.bitField0_ |= 0x10;
                }
            }


            public List<BattleHandler.ItemNormal> getItemLine2List() {
                if (this.itemLine2Builder_ == null) {
                    return Collections.unmodifiableList(this.itemLine2_);
                }
                return this.itemLine2Builder_.getMessageList();
            }


            public int getItemLine2Count() {
                if (this.itemLine2Builder_ == null) {
                    return this.itemLine2_.size();
                }
                return this.itemLine2Builder_.getCount();
            }


            public BattleHandler.ItemNormal getItemLine2(int index) {
                if (this.itemLine2Builder_ == null) {
                    return this.itemLine2_.get(index);
                }
                return (BattleHandler.ItemNormal) this.itemLine2Builder_.getMessage(index);
            }


            public Builder setItemLine2(int index, BattleHandler.ItemNormal value) {
                if (this.itemLine2Builder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureItemLine2IsMutable();
                    this.itemLine2_.set(index, value);
                    onChanged();
                } else {
                    this.itemLine2Builder_.setMessage(index, value);
                }
                return this;
            }


            public Builder setItemLine2(int index, BattleHandler.ItemNormal.Builder builderForValue) {
                if (this.itemLine2Builder_ == null) {
                    ensureItemLine2IsMutable();
                    this.itemLine2_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.itemLine2Builder_.setMessage(index, builderForValue.build());
                }
                return this;
            }


            public Builder addItemLine2(BattleHandler.ItemNormal value) {
                if (this.itemLine2Builder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureItemLine2IsMutable();
                    this.itemLine2_.add(value);
                    onChanged();
                } else {
                    this.itemLine2Builder_.addMessage(value);
                }
                return this;
            }


            public Builder addItemLine2(int index, BattleHandler.ItemNormal value) {
                if (this.itemLine2Builder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureItemLine2IsMutable();
                    this.itemLine2_.add(index, value);
                    onChanged();
                } else {
                    this.itemLine2Builder_.addMessage(index, value);
                }
                return this;
            }


            public Builder addItemLine2(BattleHandler.ItemNormal.Builder builderForValue) {
                if (this.itemLine2Builder_ == null) {
                    ensureItemLine2IsMutable();
                    this.itemLine2_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.itemLine2Builder_.addMessage(builderForValue.build());
                }
                return this;
            }


            public Builder addItemLine2(int index, BattleHandler.ItemNormal.Builder builderForValue) {
                if (this.itemLine2Builder_ == null) {
                    ensureItemLine2IsMutable();
                    this.itemLine2_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.itemLine2Builder_.addMessage(index, builderForValue.build());
                }
                return this;
            }


            public Builder addAllItemLine2(Iterable<? extends BattleHandler.ItemNormal> values) {
                if (this.itemLine2Builder_ == null) {
                    ensureItemLine2IsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.itemLine2_);
                    onChanged();
                } else {
                    this.itemLine2Builder_.addAllMessages(values);
                }
                return this;
            }


            public Builder clearItemLine2() {
                if (this.itemLine2Builder_ == null) {
                    this.itemLine2_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFEF;
                    onChanged();
                } else {
                    this.itemLine2Builder_.clear();
                }
                return this;
            }


            public Builder removeItemLine2(int index) {
                if (this.itemLine2Builder_ == null) {
                    ensureItemLine2IsMutable();
                    this.itemLine2_.remove(index);
                    onChanged();
                } else {
                    this.itemLine2Builder_.remove(index);
                }
                return this;
            }


            public BattleHandler.ItemNormal.Builder getItemLine2Builder(int index) {
                return (BattleHandler.ItemNormal.Builder) getItemLine2FieldBuilder().getBuilder(index);
            }


            public BattleHandler.ItemNormalOrBuilder getItemLine2OrBuilder(int index) {
                if (this.itemLine2Builder_ == null) {
                    return this.itemLine2_.get(index);
                }
                return (BattleHandler.ItemNormalOrBuilder) this.itemLine2Builder_.getMessageOrBuilder(index);
            }


            public List<? extends BattleHandler.ItemNormalOrBuilder> getItemLine2OrBuilderList() {
                if (this.itemLine2Builder_ != null) {
                    return this.itemLine2Builder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList((List) this.itemLine2_);
            }


            public BattleHandler.ItemNormal.Builder addItemLine2Builder() {
                return (BattleHandler.ItemNormal.Builder) getItemLine2FieldBuilder().addBuilder(BattleHandler.ItemNormal.getDefaultInstance());
            }


            public BattleHandler.ItemNormal.Builder addItemLine2Builder(int index) {
                return (BattleHandler.ItemNormal.Builder) getItemLine2FieldBuilder().addBuilder(index, BattleHandler.ItemNormal.getDefaultInstance());
            }


            public List<BattleHandler.ItemNormal.Builder> getItemLine2BuilderList() {
                return getItemLine2FieldBuilder().getBuilderList();
            }


            private RepeatedFieldBuilder<BattleHandler.ItemNormal, BattleHandler.ItemNormal.Builder, BattleHandler.ItemNormalOrBuilder> getItemLine2FieldBuilder() {
                if (this.itemLine2Builder_ == null) {
                    this.itemLine2Builder_ = new RepeatedFieldBuilder(this.itemLine2_, ((this.bitField0_ & 0x10) == 16), getParentForChildren(), isClean());
                    this.itemLine2_ = null;
                }
                return this.itemLine2Builder_;
            }


            public boolean hasIsMax() {
                return ((this.bitField0_ & 0x20) == 32);
            }


            public int getIsMax() {
                return this.isMax_;
            }


            public Builder setIsMax(int value) {
                this.bitField0_ |= 0x20;
                this.isMax_ = value;
                onChanged();
                return this;
            }


            public Builder clearIsMax() {
                this.bitField0_ &= 0xFFFFFFDF;
                this.isMax_ = 0;
                onChanged();
                return this;
            }


            public boolean hasDemonTowerFloorInfo() {
                return ((this.bitField0_ & 0x40) == 64);
            }


            public Common.DemonTowerFloorInfo getDemonTowerFloorInfo() {
                if (this.demonTowerFloorInfoBuilder_ == null) {
                    return this.demonTowerFloorInfo_;
                }
                return (Common.DemonTowerFloorInfo) this.demonTowerFloorInfoBuilder_.getMessage();
            }


            public Builder setDemonTowerFloorInfo(Common.DemonTowerFloorInfo value) {
                if (this.demonTowerFloorInfoBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.demonTowerFloorInfo_ = value;
                    onChanged();
                } else {
                    this.demonTowerFloorInfoBuilder_.setMessage((GeneratedMessage) value);
                }
                this.bitField0_ |= 0x40;
                return this;
            }


            public Builder setDemonTowerFloorInfo(Common.DemonTowerFloorInfo.Builder builderForValue) {
                if (this.demonTowerFloorInfoBuilder_ == null) {
                    this.demonTowerFloorInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.demonTowerFloorInfoBuilder_.setMessage((GeneratedMessage) builderForValue.build());
                }
                this.bitField0_ |= 0x40;
                return this;
            }


            public Builder mergeDemonTowerFloorInfo(Common.DemonTowerFloorInfo value) {
                if (this.demonTowerFloorInfoBuilder_ == null) {
                    if ((this.bitField0_ & 0x40) == 64 && this.demonTowerFloorInfo_ != Common.DemonTowerFloorInfo.getDefaultInstance()) {
                        this.demonTowerFloorInfo_ = Common.DemonTowerFloorInfo.newBuilder(this.demonTowerFloorInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.demonTowerFloorInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.demonTowerFloorInfoBuilder_.mergeFrom((GeneratedMessage) value);
                }
                this.bitField0_ |= 0x40;
                return this;
            }


            public Builder clearDemonTowerFloorInfo() {
                if (this.demonTowerFloorInfoBuilder_ == null) {
                    this.demonTowerFloorInfo_ = Common.DemonTowerFloorInfo.getDefaultInstance();
                    onChanged();
                } else {
                    this.demonTowerFloorInfoBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFBF;
                return this;
            }


            public Common.DemonTowerFloorInfo.Builder getDemonTowerFloorInfoBuilder() {
                this.bitField0_ |= 0x40;
                onChanged();
                return (Common.DemonTowerFloorInfo.Builder) getDemonTowerFloorInfoFieldBuilder().getBuilder();
            }


            public Common.DemonTowerFloorInfoOrBuilder getDemonTowerFloorInfoOrBuilder() {
                if (this.demonTowerFloorInfoBuilder_ != null) {
                    return (Common.DemonTowerFloorInfoOrBuilder) this.demonTowerFloorInfoBuilder_.getMessageOrBuilder();
                }
                return (Common.DemonTowerFloorInfoOrBuilder) this.demonTowerFloorInfo_;
            }


            private SingleFieldBuilder<Common.DemonTowerFloorInfo, Common.DemonTowerFloorInfo.Builder, Common.DemonTowerFloorInfoOrBuilder> getDemonTowerFloorInfoFieldBuilder() {
                if (this.demonTowerFloorInfoBuilder_ == null) {
                    this.demonTowerFloorInfoBuilder_ = new SingleFieldBuilder((GeneratedMessage) getDemonTowerFloorInfo(), getParentForChildren(), isClean());
                    this.demonTowerFloorInfo_ = null;
                }
                return this.demonTowerFloorInfoBuilder_;
            }


            public boolean hasCurrentTime() {
                return ((this.bitField0_ & 0x80) == 128);
            }


            public int getCurrentTime() {
                return this.currentTime_;
            }


            public Builder setCurrentTime(int value) {
                this.bitField0_ |= 0x80;
                this.currentTime_ = value;
                onChanged();
                return this;
            }


            public Builder clearCurrentTime() {
                this.bitField0_ &= 0xFFFFFF7F;
                this.currentTime_ = 0;
                onChanged();
                return this;
            }


            public boolean hasNewRecordFloor() {
                return ((this.bitField0_ & 0x100) == 256);
            }


            public boolean getNewRecordFloor() {
                return this.newRecordFloor_;
            }


            public Builder setNewRecordFloor(boolean value) {
                this.bitField0_ |= 0x100;
                this.newRecordFloor_ = value;
                onChanged();
                return this;
            }


            public Builder clearNewRecordFloor() {
                this.bitField0_ &= 0xFFFFFEFF;
                this.newRecordFloor_ = false;
                onChanged();
                return this;
            }


            public boolean hasNewRecordTime() {
                return ((this.bitField0_ & 0x200) == 512);
            }


            public boolean getNewRecordTime() {
                return this.newRecordTime_;
            }


            public Builder setNewRecordTime(boolean value) {
                this.bitField0_ |= 0x200;
                this.newRecordTime_ = value;
                onChanged();
                return this;
            }


            public Builder clearNewRecordTime() {
                this.bitField0_ &= 0xFFFFFDFF;
                this.newRecordTime_ = false;
                onChanged();
                return this;
            }


            public boolean hasMyMaxFloorId() {
                return ((this.bitField0_ & 0x400) == 1024);
            }


            public int getMyMaxFloorId() {
                return this.myMaxFloorId_;
            }


            public Builder setMyMaxFloorId(int value) {
                this.bitField0_ |= 0x400;
                this.myMaxFloorId_ = value;
                onChanged();
                return this;
            }


            public Builder clearMyMaxFloorId() {
                this.bitField0_ &= 0xFFFFFBFF;
                this.myMaxFloorId_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class ResourceDungeonResultPush
            extends GeneratedMessage
            implements ResourceDungeonResultPushOrBuilder {
        private static final ResourceDungeonResultPush defaultInstance = new ResourceDungeonResultPush(true);
        private final UnknownFieldSet unknownFields;

        private ResourceDungeonResultPush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private ResourceDungeonResultPush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static ResourceDungeonResultPush getDefaultInstance() {
            return defaultInstance;
        }

        public ResourceDungeonResultPush getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ResourceDungeonResultPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.dungeonId_ = input.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.killMonster_ = input.readInt32();
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.doubleCost_ = input.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.exp_ = input.readInt32();
                            break;
                        case 40:
                            this.bitField0_ |= 0x10;
                            this.gold_ = input.readInt32();
                            break;
                        case 50:
                            if ((mutable_bitField0_ & 0x20) != 32) {
                                this.itemLine1_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x20;
                            }
                            this.itemLine1_.add(input.readMessage(BattleHandler.ItemNormal.PARSER, extensionRegistry));
                            break;
                        case 56:
                            this.bitField0_ |= 0x20;
                            this.succ_ = input.readInt32();
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x20) == 32) this.itemLine1_ = Collections.unmodifiableList(this.itemLine1_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return BattleHandler.internal_static_pomelo_area_ResourceDungeonResultPush_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return BattleHandler.internal_static_pomelo_area_ResourceDungeonResultPush_fieldAccessorTable.ensureFieldAccessorsInitialized(ResourceDungeonResultPush.class, Builder.class);
        }

        public static Parser<ResourceDungeonResultPush> PARSER = (Parser<ResourceDungeonResultPush>) new AbstractParser<ResourceDungeonResultPush>() {
            public BattleHandler.ResourceDungeonResultPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BattleHandler.ResourceDungeonResultPush(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int DUNGEONID_FIELD_NUMBER = 1;
        private int dungeonId_;
        public static final int KILLMONSTER_FIELD_NUMBER = 2;
        private int killMonster_;
        public static final int DOUBLECOST_FIELD_NUMBER = 3;
        private int doubleCost_;
        public static final int EXP_FIELD_NUMBER = 4;
        private int exp_;
        public static final int GOLD_FIELD_NUMBER = 5;
        private int gold_;
        public static final int ITEMLINE1_FIELD_NUMBER = 6;
        private List<BattleHandler.ItemNormal> itemLine1_;
        public static final int SUCC_FIELD_NUMBER = 7;
        private int succ_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<ResourceDungeonResultPush> getParserForType() {
            return PARSER;
        }

        public boolean hasDungeonId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getDungeonId() {
            return this.dungeonId_;
        }

        public boolean hasKillMonster() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public int getKillMonster() {
            return this.killMonster_;
        }

        static {
            defaultInstance.initFields();
        }


        public boolean hasDoubleCost() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public int getDoubleCost() {
            return this.doubleCost_;
        }


        public boolean hasExp() {
            return ((this.bitField0_ & 0x8) == 8);
        }


        public int getExp() {
            return this.exp_;
        }


        public boolean hasGold() {
            return ((this.bitField0_ & 0x10) == 16);
        }


        public int getGold() {
            return this.gold_;
        }


        public List<BattleHandler.ItemNormal> getItemLine1List() {
            return this.itemLine1_;
        }


        public List<? extends BattleHandler.ItemNormalOrBuilder> getItemLine1OrBuilderList() {
            return (List) this.itemLine1_;
        }


        public int getItemLine1Count() {
            return this.itemLine1_.size();
        }


        public BattleHandler.ItemNormal getItemLine1(int index) {
            return this.itemLine1_.get(index);
        }


        public BattleHandler.ItemNormalOrBuilder getItemLine1OrBuilder(int index) {
            return this.itemLine1_.get(index);
        }


        public boolean hasSucc() {
            return ((this.bitField0_ & 0x20) == 32);
        }


        public int getSucc() {
            return this.succ_;
        }


        private void initFields() {
            this.dungeonId_ = 0;
            this.killMonster_ = 0;
            this.doubleCost_ = 0;
            this.exp_ = 0;
            this.gold_ = 0;
            this.itemLine1_ = Collections.emptyList();
            this.succ_ = 0;
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasDungeonId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (int i = 0; i < getItemLine1Count(); i++) {
                if (!getItemLine1(i).isInitialized()) {
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
                output.writeInt32(1, this.dungeonId_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeInt32(2, this.killMonster_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeInt32(3, this.doubleCost_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                output.writeInt32(4, this.exp_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                output.writeInt32(5, this.gold_);
            }
            for (int i = 0; i < this.itemLine1_.size(); i++) {
                output.writeMessage(6, (MessageLite) this.itemLine1_.get(i));
            }
            if ((this.bitField0_ & 0x20) == 32) {
                output.writeInt32(7, this.succ_);
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
                size += CodedOutputStream.computeInt32Size(1, this.dungeonId_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeInt32Size(2, this.killMonster_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                size += CodedOutputStream.computeInt32Size(3, this.doubleCost_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                size += CodedOutputStream.computeInt32Size(4, this.exp_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                size += CodedOutputStream.computeInt32Size(5, this.gold_);
            }
            for (int i = 0; i < this.itemLine1_.size(); i++) {
                size += CodedOutputStream.computeMessageSize(6, (MessageLite) this.itemLine1_.get(i));
            }
            if ((this.bitField0_ & 0x20) == 32) {
                size += CodedOutputStream.computeInt32Size(7, this.succ_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static ResourceDungeonResultPush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ResourceDungeonResultPush) PARSER.parseFrom(data);
        }


        public static ResourceDungeonResultPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ResourceDungeonResultPush) PARSER.parseFrom(data, extensionRegistry);
        }


        public static ResourceDungeonResultPush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ResourceDungeonResultPush) PARSER.parseFrom(data);
        }


        public static ResourceDungeonResultPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ResourceDungeonResultPush) PARSER.parseFrom(data, extensionRegistry);
        }


        public static ResourceDungeonResultPush parseFrom(InputStream input) throws IOException {
            return (ResourceDungeonResultPush) PARSER.parseFrom(input);
        }


        public static ResourceDungeonResultPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ResourceDungeonResultPush) PARSER.parseFrom(input, extensionRegistry);
        }


        public static ResourceDungeonResultPush parseDelimitedFrom(InputStream input) throws IOException {
            return (ResourceDungeonResultPush) PARSER.parseDelimitedFrom(input);
        }


        public static ResourceDungeonResultPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ResourceDungeonResultPush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static ResourceDungeonResultPush parseFrom(CodedInputStream input) throws IOException {
            return (ResourceDungeonResultPush) PARSER.parseFrom(input);
        }


        public static ResourceDungeonResultPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ResourceDungeonResultPush) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(ResourceDungeonResultPush prototype) {
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
                implements BattleHandler.ResourceDungeonResultPushOrBuilder {
            private int bitField0_;


            private int dungeonId_;


            private int killMonster_;


            private int doubleCost_;


            private int exp_;


            private int gold_;


            private List<BattleHandler.ItemNormal> itemLine1_;


            private RepeatedFieldBuilder<BattleHandler.ItemNormal, BattleHandler.ItemNormal.Builder, BattleHandler.ItemNormalOrBuilder> itemLine1Builder_;


            private int succ_;


            public static final Descriptors.Descriptor getDescriptor() {
                return BattleHandler.internal_static_pomelo_area_ResourceDungeonResultPush_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return BattleHandler.internal_static_pomelo_area_ResourceDungeonResultPush_fieldAccessorTable.ensureFieldAccessorsInitialized(BattleHandler.ResourceDungeonResultPush.class, Builder.class);
            }


            private Builder() {
                this.itemLine1_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.itemLine1_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (BattleHandler.ResourceDungeonResultPush.alwaysUseFieldBuilders) {
                    getItemLine1FieldBuilder();
                }
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.dungeonId_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.killMonster_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                this.doubleCost_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.exp_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                this.gold_ = 0;
                this.bitField0_ &= 0xFFFFFFEF;
                if (this.itemLine1Builder_ == null) {
                    this.itemLine1_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFDF;
                } else {
                    this.itemLine1Builder_.clear();
                }
                this.succ_ = 0;
                this.bitField0_ &= 0xFFFFFFBF;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return BattleHandler.internal_static_pomelo_area_ResourceDungeonResultPush_descriptor;
            }


            public BattleHandler.ResourceDungeonResultPush getDefaultInstanceForType() {
                return BattleHandler.ResourceDungeonResultPush.getDefaultInstance();
            }


            public BattleHandler.ResourceDungeonResultPush build() {
                BattleHandler.ResourceDungeonResultPush result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public BattleHandler.ResourceDungeonResultPush buildPartial() {
                BattleHandler.ResourceDungeonResultPush result = new BattleHandler.ResourceDungeonResultPush(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.dungeonId_ = this.dungeonId_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.killMonster_ = this.killMonster_;
                if ((from_bitField0_ & 0x4) == 4) {
                    to_bitField0_ |= 0x4;
                }
                result.doubleCost_ = this.doubleCost_;
                if ((from_bitField0_ & 0x8) == 8) {
                    to_bitField0_ |= 0x8;
                }
                result.exp_ = this.exp_;
                if ((from_bitField0_ & 0x10) == 16) {
                    to_bitField0_ |= 0x10;
                }
                result.gold_ = this.gold_;
                if (this.itemLine1Builder_ == null) {
                    if ((this.bitField0_ & 0x20) == 32) {
                        this.itemLine1_ = Collections.unmodifiableList(this.itemLine1_);
                        this.bitField0_ &= 0xFFFFFFDF;
                    }
                    result.itemLine1_ = this.itemLine1_;
                } else {
                    result.itemLine1_ = this.itemLine1Builder_.build();
                }
                if ((from_bitField0_ & 0x40) == 64) {
                    to_bitField0_ |= 0x20;
                }
                result.succ_ = this.succ_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof BattleHandler.ResourceDungeonResultPush) {
                    return mergeFrom((BattleHandler.ResourceDungeonResultPush) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(BattleHandler.ResourceDungeonResultPush other) {
                if (other == BattleHandler.ResourceDungeonResultPush.getDefaultInstance()) {
                    return this;
                }
                if (other.hasDungeonId()) {
                    setDungeonId(other.getDungeonId());
                }
                if (other.hasKillMonster()) {
                    setKillMonster(other.getKillMonster());
                }
                if (other.hasDoubleCost()) {
                    setDoubleCost(other.getDoubleCost());
                }
                if (other.hasExp()) {
                    setExp(other.getExp());
                }
                if (other.hasGold()) {
                    setGold(other.getGold());
                }
                if (this.itemLine1Builder_ == null) {
                    if (!other.itemLine1_.isEmpty()) {
                        if (this.itemLine1_.isEmpty()) {
                            this.itemLine1_ = other.itemLine1_;
                            this.bitField0_ &= 0xFFFFFFDF;
                        } else {
                            ensureItemLine1IsMutable();
                            this.itemLine1_.addAll(other.itemLine1_);
                        }
                        onChanged();
                    }
                } else if (!other.itemLine1_.isEmpty()) {
                    if (this.itemLine1Builder_.isEmpty()) {
                        this.itemLine1Builder_.dispose();
                        this.itemLine1Builder_ = null;
                        this.itemLine1_ = other.itemLine1_;
                        this.bitField0_ &= 0xFFFFFFDF;
                        this.itemLine1Builder_ = BattleHandler.ResourceDungeonResultPush.alwaysUseFieldBuilders ? getItemLine1FieldBuilder() : null;
                    } else {
                        this.itemLine1Builder_.addAllMessages(other.itemLine1_);
                    }
                }
                if (other.hasSucc()) {
                    setSucc(other.getSucc());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasDungeonId()) {
                    return false;
                }
                for (int i = 0; i < getItemLine1Count(); i++) {
                    if (!getItemLine1(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                BattleHandler.ResourceDungeonResultPush parsedMessage = null;
                try {
                    parsedMessage = (BattleHandler.ResourceDungeonResultPush) BattleHandler.ResourceDungeonResultPush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (BattleHandler.ResourceDungeonResultPush) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasDungeonId() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public int getDungeonId() {
                return this.dungeonId_;
            }


            public Builder setDungeonId(int value) {
                this.bitField0_ |= 0x1;
                this.dungeonId_ = value;
                onChanged();
                return this;
            }


            public Builder clearDungeonId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.dungeonId_ = 0;
                onChanged();
                return this;
            }


            public boolean hasKillMonster() {
                return ((this.bitField0_ & 0x2) == 2);
            }


            public int getKillMonster() {
                return this.killMonster_;
            }


            public Builder setKillMonster(int value) {
                this.bitField0_ |= 0x2;
                this.killMonster_ = value;
                onChanged();
                return this;
            }


            public Builder clearKillMonster() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.killMonster_ = 0;
                onChanged();
                return this;
            }


            public boolean hasDoubleCost() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public int getDoubleCost() {
                return this.doubleCost_;
            }


            public Builder setDoubleCost(int value) {
                this.bitField0_ |= 0x4;
                this.doubleCost_ = value;
                onChanged();
                return this;
            }


            public Builder clearDoubleCost() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.doubleCost_ = 0;
                onChanged();
                return this;
            }


            public boolean hasExp() {
                return ((this.bitField0_ & 0x8) == 8);
            }


            public int getExp() {
                return this.exp_;
            }


            public Builder setExp(int value) {
                this.bitField0_ |= 0x8;
                this.exp_ = value;
                onChanged();
                return this;
            }


            public Builder clearExp() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.exp_ = 0;
                onChanged();
                return this;
            }


            public boolean hasGold() {
                return ((this.bitField0_ & 0x10) == 16);
            }


            public int getGold() {
                return this.gold_;
            }


            public Builder setGold(int value) {
                this.bitField0_ |= 0x10;
                this.gold_ = value;
                onChanged();
                return this;
            }


            public Builder clearGold() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.gold_ = 0;
                onChanged();
                return this;
            }


            private void ensureItemLine1IsMutable() {
                if ((this.bitField0_ & 0x20) != 32) {
                    this.itemLine1_ = new ArrayList<>(this.itemLine1_);
                    this.bitField0_ |= 0x20;
                }
            }


            public List<BattleHandler.ItemNormal> getItemLine1List() {
                if (this.itemLine1Builder_ == null) {
                    return Collections.unmodifiableList(this.itemLine1_);
                }
                return this.itemLine1Builder_.getMessageList();
            }


            public int getItemLine1Count() {
                if (this.itemLine1Builder_ == null) {
                    return this.itemLine1_.size();
                }
                return this.itemLine1Builder_.getCount();
            }


            public BattleHandler.ItemNormal getItemLine1(int index) {
                if (this.itemLine1Builder_ == null) {
                    return this.itemLine1_.get(index);
                }
                return (BattleHandler.ItemNormal) this.itemLine1Builder_.getMessage(index);
            }


            public Builder setItemLine1(int index, BattleHandler.ItemNormal value) {
                if (this.itemLine1Builder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureItemLine1IsMutable();
                    this.itemLine1_.set(index, value);
                    onChanged();
                } else {
                    this.itemLine1Builder_.setMessage(index, value);
                }
                return this;
            }


            public Builder setItemLine1(int index, BattleHandler.ItemNormal.Builder builderForValue) {
                if (this.itemLine1Builder_ == null) {
                    ensureItemLine1IsMutable();
                    this.itemLine1_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.itemLine1Builder_.setMessage(index, builderForValue.build());
                }
                return this;
            }


            public Builder addItemLine1(BattleHandler.ItemNormal value) {
                if (this.itemLine1Builder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureItemLine1IsMutable();
                    this.itemLine1_.add(value);
                    onChanged();
                } else {
                    this.itemLine1Builder_.addMessage(value);
                }
                return this;
            }


            public Builder addItemLine1(int index, BattleHandler.ItemNormal value) {
                if (this.itemLine1Builder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureItemLine1IsMutable();
                    this.itemLine1_.add(index, value);
                    onChanged();
                } else {
                    this.itemLine1Builder_.addMessage(index, value);
                }
                return this;
            }


            public Builder addItemLine1(BattleHandler.ItemNormal.Builder builderForValue) {
                if (this.itemLine1Builder_ == null) {
                    ensureItemLine1IsMutable();
                    this.itemLine1_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.itemLine1Builder_.addMessage(builderForValue.build());
                }
                return this;
            }


            public Builder addItemLine1(int index, BattleHandler.ItemNormal.Builder builderForValue) {
                if (this.itemLine1Builder_ == null) {
                    ensureItemLine1IsMutable();
                    this.itemLine1_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.itemLine1Builder_.addMessage(index, builderForValue.build());
                }
                return this;
            }


            public Builder addAllItemLine1(Iterable<? extends BattleHandler.ItemNormal> values) {
                if (this.itemLine1Builder_ == null) {
                    ensureItemLine1IsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.itemLine1_);
                    onChanged();
                } else {
                    this.itemLine1Builder_.addAllMessages(values);
                }
                return this;
            }


            public Builder clearItemLine1() {
                if (this.itemLine1Builder_ == null) {
                    this.itemLine1_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFDF;
                    onChanged();
                } else {
                    this.itemLine1Builder_.clear();
                }
                return this;
            }


            public Builder removeItemLine1(int index) {
                if (this.itemLine1Builder_ == null) {
                    ensureItemLine1IsMutable();
                    this.itemLine1_.remove(index);
                    onChanged();
                } else {
                    this.itemLine1Builder_.remove(index);
                }
                return this;
            }


            public BattleHandler.ItemNormal.Builder getItemLine1Builder(int index) {
                return (BattleHandler.ItemNormal.Builder) getItemLine1FieldBuilder().getBuilder(index);
            }


            public BattleHandler.ItemNormalOrBuilder getItemLine1OrBuilder(int index) {
                if (this.itemLine1Builder_ == null) {
                    return this.itemLine1_.get(index);
                }
                return (BattleHandler.ItemNormalOrBuilder) this.itemLine1Builder_.getMessageOrBuilder(index);
            }


            public List<? extends BattleHandler.ItemNormalOrBuilder> getItemLine1OrBuilderList() {
                if (this.itemLine1Builder_ != null) {
                    return this.itemLine1Builder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList((List) this.itemLine1_);
            }


            public BattleHandler.ItemNormal.Builder addItemLine1Builder() {
                return (BattleHandler.ItemNormal.Builder) getItemLine1FieldBuilder().addBuilder(BattleHandler.ItemNormal.getDefaultInstance());
            }


            public BattleHandler.ItemNormal.Builder addItemLine1Builder(int index) {
                return (BattleHandler.ItemNormal.Builder) getItemLine1FieldBuilder().addBuilder(index, BattleHandler.ItemNormal.getDefaultInstance());
            }


            public List<BattleHandler.ItemNormal.Builder> getItemLine1BuilderList() {
                return getItemLine1FieldBuilder().getBuilderList();
            }


            private RepeatedFieldBuilder<BattleHandler.ItemNormal, BattleHandler.ItemNormal.Builder, BattleHandler.ItemNormalOrBuilder> getItemLine1FieldBuilder() {
                if (this.itemLine1Builder_ == null) {
                    this.itemLine1Builder_ = new RepeatedFieldBuilder(this.itemLine1_, ((this.bitField0_ & 0x20) == 32), getParentForChildren(), isClean());
                    this.itemLine1_ = null;
                }
                return this.itemLine1Builder_;
            }


            public boolean hasSucc() {
                return ((this.bitField0_ & 0x40) == 64);
            }


            public int getSucc() {
                return this.succ_;
            }


            public Builder setSucc(int value) {
                this.bitField0_ |= 0x40;
                this.succ_ = value;
                onChanged();
                return this;
            }


            public Builder clearSucc() {
                this.bitField0_ &= 0xFFFFFFBF;
                this.succ_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class ItemDrop
            extends GeneratedMessage
            implements ItemDropOrBuilder {
        private static final ItemDrop defaultInstance = new ItemDrop(true);
        private final UnknownFieldSet unknownFields;

        private ItemDrop(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private ItemDrop(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static ItemDrop getDefaultInstance() {
            return defaultInstance;
        }

        public ItemDrop getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ItemDrop(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        case 18:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x2;
                            this.name_ = bs;
                            break;
                        case 26:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x4;
                            this.showId_ = bs;
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.groupCount_ = input.readInt32();
                            break;
                        case 40:
                            this.bitField0_ |= 0x10;
                            this.qColor_ = input.readInt32();
                            break;
                        case 48:
                            this.bitField0_ |= 0x20;
                            this.itemTypeId_ = input.readInt32();
                            break;
                        case 58:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x40;
                            this.iconName_ = bs;
                            break;
                        case 64:
                            this.bitField0_ |= 0x80;
                            this.freezeTime_ = input.readInt32();
                            break;
                        case 72:
                            this.bitField0_ |= 0x100;
                            this.protectTime_ = input.readInt32();
                            break;
                        case 80:
                            this.bitField0_ |= 0x200;
                            this.lifeTime_ = input.readInt32();
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
            return BattleHandler.internal_static_pomelo_area_ItemDrop_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return BattleHandler.internal_static_pomelo_area_ItemDrop_fieldAccessorTable.ensureFieldAccessorsInitialized(ItemDrop.class, Builder.class);
        }

        public static Parser<ItemDrop> PARSER = (Parser<ItemDrop>) new AbstractParser<ItemDrop>() {
            public BattleHandler.ItemDrop parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BattleHandler.ItemDrop(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int ID_FIELD_NUMBER = 1;
        private Object id_;
        public static final int NAME_FIELD_NUMBER = 2;
        private Object name_;
        public static final int SHOWID_FIELD_NUMBER = 3;
        private Object showId_;
        public static final int GROUPCOUNT_FIELD_NUMBER = 4;
        private int groupCount_;
        public static final int QCOLOR_FIELD_NUMBER = 5;

        static {
            defaultInstance.initFields();
        }

        private int qColor_;
        public static final int ITEMTYPEID_FIELD_NUMBER = 6;
        private int itemTypeId_;
        public static final int ICONNAME_FIELD_NUMBER = 7;
        private Object iconName_;
        public static final int FREEZETIME_FIELD_NUMBER = 8;
        private int freezeTime_;
        public static final int PROTECTTIME_FIELD_NUMBER = 9;
        private int protectTime_;
        public static final int LIFETIME_FIELD_NUMBER = 10;
        private int lifeTime_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<ItemDrop> getParserForType() {
            return PARSER;
        }

        public boolean hasId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public String getId() {
            Object ref = this.id_;
            if (ref instanceof String)
                return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8())
                this.id_ = s;
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

        public boolean hasName() {
            return ((this.bitField0_ & 0x2) == 2);
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

        public boolean hasShowId() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public String getShowId() {
            Object ref = this.showId_;
            if (ref instanceof String)
                return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8())
                this.showId_ = s;
            return s;
        }

        public ByteString getShowIdBytes() {
            Object ref = this.showId_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.showId_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasGroupCount() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public int getGroupCount() {
            return this.groupCount_;
        }

        public boolean hasQColor() {
            return ((this.bitField0_ & 0x10) == 16);
        }

        public int getQColor() {
            return this.qColor_;
        }

        public boolean hasItemTypeId() {
            return ((this.bitField0_ & 0x20) == 32);
        }

        public int getItemTypeId() {
            return this.itemTypeId_;
        }

        public boolean hasIconName() {
            return ((this.bitField0_ & 0x40) == 64);
        }

        public String getIconName() {
            Object ref = this.iconName_;
            if (ref instanceof String)
                return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8())
                this.iconName_ = s;
            return s;
        }

        public ByteString getIconNameBytes() {
            Object ref = this.iconName_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.iconName_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasFreezeTime() {
            return ((this.bitField0_ & 0x80) == 128);
        }

        public int getFreezeTime() {
            return this.freezeTime_;
        }

        public boolean hasProtectTime() {
            return ((this.bitField0_ & 0x100) == 256);
        }

        public int getProtectTime() {
            return this.protectTime_;
        }

        public boolean hasLifeTime() {
            return ((this.bitField0_ & 0x200) == 512);
        }

        public int getLifeTime() {
            return this.lifeTime_;
        }

        private void initFields() {
            this.id_ = "";
            this.name_ = "";
            this.showId_ = "";
            this.groupCount_ = 0;
            this.qColor_ = 0;
            this.itemTypeId_ = 0;
            this.iconName_ = "";
            this.freezeTime_ = 0;
            this.protectTime_ = 0;
            this.lifeTime_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1)
                return true;
            if (isInitialized == 0)
                return false;
            if (!hasName()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasShowId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasQColor()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasItemTypeId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasIconName()) {
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
            if ((this.bitField0_ & 0x2) == 2)
                output.writeBytes(2, getNameBytes());
            if ((this.bitField0_ & 0x4) == 4)
                output.writeBytes(3, getShowIdBytes());
            if ((this.bitField0_ & 0x8) == 8)
                output.writeInt32(4, this.groupCount_);
            if ((this.bitField0_ & 0x10) == 16)
                output.writeInt32(5, this.qColor_);
            if ((this.bitField0_ & 0x20) == 32)
                output.writeInt32(6, this.itemTypeId_);
            if ((this.bitField0_ & 0x40) == 64)
                output.writeBytes(7, getIconNameBytes());
            if ((this.bitField0_ & 0x80) == 128)
                output.writeInt32(8, this.freezeTime_);
            if ((this.bitField0_ & 0x100) == 256)
                output.writeInt32(9, this.protectTime_);
            if ((this.bitField0_ & 0x200) == 512)
                output.writeInt32(10, this.lifeTime_);
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
                size += CodedOutputStream.computeBytesSize(2, getNameBytes());
            if ((this.bitField0_ & 0x4) == 4)
                size += CodedOutputStream.computeBytesSize(3, getShowIdBytes());
            if ((this.bitField0_ & 0x8) == 8)
                size += CodedOutputStream.computeInt32Size(4, this.groupCount_);
            if ((this.bitField0_ & 0x10) == 16)
                size += CodedOutputStream.computeInt32Size(5, this.qColor_);
            if ((this.bitField0_ & 0x20) == 32)
                size += CodedOutputStream.computeInt32Size(6, this.itemTypeId_);
            if ((this.bitField0_ & 0x40) == 64)
                size += CodedOutputStream.computeBytesSize(7, getIconNameBytes());
            if ((this.bitField0_ & 0x80) == 128)
                size += CodedOutputStream.computeInt32Size(8, this.freezeTime_);
            if ((this.bitField0_ & 0x100) == 256)
                size += CodedOutputStream.computeInt32Size(9, this.protectTime_);
            if ((this.bitField0_ & 0x200) == 512)
                size += CodedOutputStream.computeInt32Size(10, this.lifeTime_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static ItemDrop parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ItemDrop) PARSER.parseFrom(data);
        }

        public static ItemDrop parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ItemDrop) PARSER.parseFrom(data, extensionRegistry);
        }

        public static ItemDrop parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ItemDrop) PARSER.parseFrom(data);
        }

        public static ItemDrop parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ItemDrop) PARSER.parseFrom(data, extensionRegistry);
        }

        public static ItemDrop parseFrom(InputStream input) throws IOException {
            return (ItemDrop) PARSER.parseFrom(input);
        }

        public static ItemDrop parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ItemDrop) PARSER.parseFrom(input, extensionRegistry);
        }

        public static ItemDrop parseDelimitedFrom(InputStream input) throws IOException {
            return (ItemDrop) PARSER.parseDelimitedFrom(input);
        }

        public static ItemDrop parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ItemDrop) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static ItemDrop parseFrom(CodedInputStream input) throws IOException {
            return (ItemDrop) PARSER.parseFrom(input);
        }

        public static ItemDrop parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ItemDrop) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(ItemDrop prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements BattleHandler.ItemDropOrBuilder {
            private int bitField0_;
            private Object id_;
            private Object name_;
            private Object showId_;
            private int groupCount_;
            private int qColor_;
            private int itemTypeId_;
            private Object iconName_;
            private int freezeTime_;
            private int protectTime_;
            private int lifeTime_;

            public static final Descriptors.Descriptor getDescriptor() {
                return BattleHandler.internal_static_pomelo_area_ItemDrop_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return BattleHandler.internal_static_pomelo_area_ItemDrop_fieldAccessorTable.ensureFieldAccessorsInitialized(BattleHandler.ItemDrop.class, Builder.class);
            }

            private Builder() {
                this.id_ = "";
                this.name_ = "";
                this.showId_ = "";
                this.iconName_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.id_ = "";
                this.name_ = "";
                this.showId_ = "";
                this.iconName_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (BattleHandler.ItemDrop.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.id_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                this.name_ = "";
                this.bitField0_ &= 0xFFFFFFFD;
                this.showId_ = "";
                this.bitField0_ &= 0xFFFFFFFB;
                this.groupCount_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                this.qColor_ = 0;
                this.bitField0_ &= 0xFFFFFFEF;
                this.itemTypeId_ = 0;
                this.bitField0_ &= 0xFFFFFFDF;
                this.iconName_ = "";
                this.bitField0_ &= 0xFFFFFFBF;
                this.freezeTime_ = 0;
                this.bitField0_ &= 0xFFFFFF7F;
                this.protectTime_ = 0;
                this.bitField0_ &= 0xFFFFFEFF;
                this.lifeTime_ = 0;
                this.bitField0_ &= 0xFFFFFDFF;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return BattleHandler.internal_static_pomelo_area_ItemDrop_descriptor;
            }

            public BattleHandler.ItemDrop getDefaultInstanceForType() {
                return BattleHandler.ItemDrop.getDefaultInstance();
            }

            public BattleHandler.ItemDrop build() {
                BattleHandler.ItemDrop result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public BattleHandler.ItemDrop buildPartial() {
                BattleHandler.ItemDrop result = new BattleHandler.ItemDrop(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.id_ = this.id_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.name_ = this.name_;
                if ((from_bitField0_ & 0x4) == 4)
                    to_bitField0_ |= 0x4;
                result.showId_ = this.showId_;
                if ((from_bitField0_ & 0x8) == 8)
                    to_bitField0_ |= 0x8;
                result.groupCount_ = this.groupCount_;
                if ((from_bitField0_ & 0x10) == 16)
                    to_bitField0_ |= 0x10;
                result.qColor_ = this.qColor_;
                if ((from_bitField0_ & 0x20) == 32)
                    to_bitField0_ |= 0x20;
                result.itemTypeId_ = this.itemTypeId_;
                if ((from_bitField0_ & 0x40) == 64)
                    to_bitField0_ |= 0x40;
                result.iconName_ = this.iconName_;
                if ((from_bitField0_ & 0x80) == 128)
                    to_bitField0_ |= 0x80;
                result.freezeTime_ = this.freezeTime_;
                if ((from_bitField0_ & 0x100) == 256)
                    to_bitField0_ |= 0x100;
                result.protectTime_ = this.protectTime_;
                if ((from_bitField0_ & 0x200) == 512)
                    to_bitField0_ |= 0x200;
                result.lifeTime_ = this.lifeTime_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof BattleHandler.ItemDrop)
                    return mergeFrom((BattleHandler.ItemDrop) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(BattleHandler.ItemDrop other) {
                if (other == BattleHandler.ItemDrop.getDefaultInstance())
                    return this;
                if (other.hasId()) {
                    this.bitField0_ |= 0x1;
                    this.id_ = other.id_;
                    onChanged();
                }
                if (other.hasName()) {
                    this.bitField0_ |= 0x2;
                    this.name_ = other.name_;
                    onChanged();
                }
                if (other.hasShowId()) {
                    this.bitField0_ |= 0x4;
                    this.showId_ = other.showId_;
                    onChanged();
                }
                if (other.hasGroupCount())
                    setGroupCount(other.getGroupCount());
                if (other.hasQColor())
                    setQColor(other.getQColor());
                if (other.hasItemTypeId())
                    setItemTypeId(other.getItemTypeId());
                if (other.hasIconName()) {
                    this.bitField0_ |= 0x40;
                    this.iconName_ = other.iconName_;
                    onChanged();
                }
                if (other.hasFreezeTime())
                    setFreezeTime(other.getFreezeTime());
                if (other.hasProtectTime())
                    setProtectTime(other.getProtectTime());
                if (other.hasLifeTime())
                    setLifeTime(other.getLifeTime());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasName())
                    return false;
                if (!hasShowId())
                    return false;
                if (!hasQColor())
                    return false;
                if (!hasItemTypeId())
                    return false;
                if (!hasIconName())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                BattleHandler.ItemDrop parsedMessage = null;
                try {
                    parsedMessage = (BattleHandler.ItemDrop) BattleHandler.ItemDrop.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (BattleHandler.ItemDrop) e.getUnfinishedMessage();
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
                this.id_ = BattleHandler.ItemDrop.getDefaultInstance().getId();
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

            public boolean hasName() {
                return ((this.bitField0_ & 0x2) == 2);
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
                this.bitField0_ |= 0x2;
                this.name_ = value;
                onChanged();
                return this;
            }

            public Builder clearName() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.name_ = BattleHandler.ItemDrop.getDefaultInstance().getName();
                onChanged();
                return this;
            }

            public Builder setNameBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x2;
                this.name_ = value;
                onChanged();
                return this;
            }

            public boolean hasShowId() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public String getShowId() {
                Object ref = this.showId_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.showId_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getShowIdBytes() {
                Object ref = this.showId_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.showId_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setShowId(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x4;
                this.showId_ = value;
                onChanged();
                return this;
            }

            public Builder clearShowId() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.showId_ = BattleHandler.ItemDrop.getDefaultInstance().getShowId();
                onChanged();
                return this;
            }

            public Builder setShowIdBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x4;
                this.showId_ = value;
                onChanged();
                return this;
            }

            public boolean hasGroupCount() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public int getGroupCount() {
                return this.groupCount_;
            }

            public Builder setGroupCount(int value) {
                this.bitField0_ |= 0x8;
                this.groupCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearGroupCount() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.groupCount_ = 0;
                onChanged();
                return this;
            }

            public boolean hasQColor() {
                return ((this.bitField0_ & 0x10) == 16);
            }

            public int getQColor() {
                return this.qColor_;
            }

            public Builder setQColor(int value) {
                this.bitField0_ |= 0x10;
                this.qColor_ = value;
                onChanged();
                return this;
            }

            public Builder clearQColor() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.qColor_ = 0;
                onChanged();
                return this;
            }

            public boolean hasItemTypeId() {
                return ((this.bitField0_ & 0x20) == 32);
            }

            public int getItemTypeId() {
                return this.itemTypeId_;
            }

            public Builder setItemTypeId(int value) {
                this.bitField0_ |= 0x20;
                this.itemTypeId_ = value;
                onChanged();
                return this;
            }

            public Builder clearItemTypeId() {
                this.bitField0_ &= 0xFFFFFFDF;
                this.itemTypeId_ = 0;
                onChanged();
                return this;
            }

            public boolean hasIconName() {
                return ((this.bitField0_ & 0x40) == 64);
            }

            public String getIconName() {
                Object ref = this.iconName_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.iconName_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getIconNameBytes() {
                Object ref = this.iconName_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.iconName_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setIconName(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x40;
                this.iconName_ = value;
                onChanged();
                return this;
            }

            public Builder clearIconName() {
                this.bitField0_ &= 0xFFFFFFBF;
                this.iconName_ = BattleHandler.ItemDrop.getDefaultInstance().getIconName();
                onChanged();
                return this;
            }

            public Builder setIconNameBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x40;
                this.iconName_ = value;
                onChanged();
                return this;
            }

            public boolean hasFreezeTime() {
                return ((this.bitField0_ & 0x80) == 128);
            }

            public int getFreezeTime() {
                return this.freezeTime_;
            }

            public Builder setFreezeTime(int value) {
                this.bitField0_ |= 0x80;
                this.freezeTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearFreezeTime() {
                this.bitField0_ &= 0xFFFFFF7F;
                this.freezeTime_ = 0;
                onChanged();
                return this;
            }

            public boolean hasProtectTime() {
                return ((this.bitField0_ & 0x100) == 256);
            }

            public int getProtectTime() {
                return this.protectTime_;
            }

            public Builder setProtectTime(int value) {
                this.bitField0_ |= 0x100;
                this.protectTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearProtectTime() {
                this.bitField0_ &= 0xFFFFFEFF;
                this.protectTime_ = 0;
                onChanged();
                return this;
            }

            public boolean hasLifeTime() {
                return ((this.bitField0_ & 0x200) == 512);
            }

            public int getLifeTime() {
                return this.lifeTime_;
            }

            public Builder setLifeTime(int value) {
                this.bitField0_ |= 0x200;
                this.lifeTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearLifeTime() {
                this.bitField0_ &= 0xFFFFFDFF;
                this.lifeTime_ = 0;
                onChanged();
                return this;
            }
        }
    }

    public static final class ItemDropPush extends GeneratedMessage implements ItemDropPushOrBuilder {
        private static final ItemDropPush defaultInstance = new ItemDropPush(true);
        private final UnknownFieldSet unknownFields;

        private ItemDropPush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private ItemDropPush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static ItemDropPush getDefaultInstance() {
            return defaultInstance;
        }

        public ItemDropPush getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ItemDropPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.x_ = input.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.y_ = input.readInt32();
                            break;
                        case 26:
                            if ((mutable_bitField0_ & 0x4) != 4) {
                                this.items_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x4;
                            }
                            this.items_.add(input.readMessage(BattleHandler.ItemDrop.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x4) == 4) this.items_ = Collections.unmodifiableList(this.items_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return BattleHandler.internal_static_pomelo_area_ItemDropPush_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return BattleHandler.internal_static_pomelo_area_ItemDropPush_fieldAccessorTable.ensureFieldAccessorsInitialized(ItemDropPush.class, Builder.class);
        }

        public static Parser<ItemDropPush> PARSER = (Parser<ItemDropPush>) new AbstractParser<ItemDropPush>() {
            public BattleHandler.ItemDropPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BattleHandler.ItemDropPush(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int X_FIELD_NUMBER = 1;
        private int x_;
        public static final int Y_FIELD_NUMBER = 2;
        private int y_;
        public static final int ITEMS_FIELD_NUMBER = 3;
        private List<BattleHandler.ItemDrop> items_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<ItemDropPush> getParserForType() {
            return PARSER;
        }

        public boolean hasX() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getX() {
            return this.x_;
        }

        public boolean hasY() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public int getY() {
            return this.y_;
        }

        static {
            defaultInstance.initFields();
        }


        public List<BattleHandler.ItemDrop> getItemsList() {
            return this.items_;
        }


        public List<? extends BattleHandler.ItemDropOrBuilder> getItemsOrBuilderList() {
            return (List) this.items_;
        }


        public int getItemsCount() {
            return this.items_.size();
        }


        public BattleHandler.ItemDrop getItems(int index) {
            return this.items_.get(index);
        }


        public BattleHandler.ItemDropOrBuilder getItemsOrBuilder(int index) {
            return this.items_.get(index);
        }


        private void initFields() {
            this.x_ = 0;
            this.y_ = 0;
            this.items_ = Collections.emptyList();
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasY()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (int i = 0; i < getItemsCount(); i++) {
                if (!getItems(i).isInitialized()) {
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
                output.writeInt32(1, this.x_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeInt32(2, this.y_);
            }
            for (int i = 0; i < this.items_.size(); i++) {
                output.writeMessage(3, (MessageLite) this.items_.get(i));
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
                size += CodedOutputStream.computeInt32Size(1, this.x_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeInt32Size(2, this.y_);
            }
            for (int i = 0; i < this.items_.size(); i++) {
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.items_.get(i));
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static ItemDropPush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ItemDropPush) PARSER.parseFrom(data);
        }


        public static ItemDropPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ItemDropPush) PARSER.parseFrom(data, extensionRegistry);
        }


        public static ItemDropPush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ItemDropPush) PARSER.parseFrom(data);
        }


        public static ItemDropPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ItemDropPush) PARSER.parseFrom(data, extensionRegistry);
        }


        public static ItemDropPush parseFrom(InputStream input) throws IOException {
            return (ItemDropPush) PARSER.parseFrom(input);
        }


        public static ItemDropPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ItemDropPush) PARSER.parseFrom(input, extensionRegistry);
        }


        public static ItemDropPush parseDelimitedFrom(InputStream input) throws IOException {
            return (ItemDropPush) PARSER.parseDelimitedFrom(input);
        }


        public static ItemDropPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ItemDropPush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static ItemDropPush parseFrom(CodedInputStream input) throws IOException {
            return (ItemDropPush) PARSER.parseFrom(input);
        }


        public static ItemDropPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ItemDropPush) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(ItemDropPush prototype) {
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
                implements BattleHandler.ItemDropPushOrBuilder {
            private int bitField0_;


            private int x_;


            private int y_;


            private List<BattleHandler.ItemDrop> items_;


            private RepeatedFieldBuilder<BattleHandler.ItemDrop, BattleHandler.ItemDrop.Builder, BattleHandler.ItemDropOrBuilder> itemsBuilder_;


            public static final Descriptors.Descriptor getDescriptor() {
                return BattleHandler.internal_static_pomelo_area_ItemDropPush_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return BattleHandler.internal_static_pomelo_area_ItemDropPush_fieldAccessorTable.ensureFieldAccessorsInitialized(BattleHandler.ItemDropPush.class, Builder.class);
            }


            private Builder() {
                this.items_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.items_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (BattleHandler.ItemDropPush.alwaysUseFieldBuilders) {
                    getItemsFieldBuilder();
                }
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.x_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.y_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                if (this.itemsBuilder_ == null) {
                    this.items_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                } else {
                    this.itemsBuilder_.clear();
                }
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return BattleHandler.internal_static_pomelo_area_ItemDropPush_descriptor;
            }


            public BattleHandler.ItemDropPush getDefaultInstanceForType() {
                return BattleHandler.ItemDropPush.getDefaultInstance();
            }


            public BattleHandler.ItemDropPush build() {
                BattleHandler.ItemDropPush result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public BattleHandler.ItemDropPush buildPartial() {
                BattleHandler.ItemDropPush result = new BattleHandler.ItemDropPush(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.x_ = this.x_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.y_ = this.y_;
                if (this.itemsBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4) {
                        this.items_ = Collections.unmodifiableList(this.items_);
                        this.bitField0_ &= 0xFFFFFFFB;
                    }
                    result.items_ = this.items_;
                } else {
                    result.items_ = this.itemsBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof BattleHandler.ItemDropPush) {
                    return mergeFrom((BattleHandler.ItemDropPush) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(BattleHandler.ItemDropPush other) {
                if (other == BattleHandler.ItemDropPush.getDefaultInstance()) {
                    return this;
                }
                if (other.hasX()) {
                    setX(other.getX());
                }
                if (other.hasY()) {
                    setY(other.getY());
                }
                if (this.itemsBuilder_ == null) {
                    if (!other.items_.isEmpty()) {
                        if (this.items_.isEmpty()) {
                            this.items_ = other.items_;
                            this.bitField0_ &= 0xFFFFFFFB;
                        } else {
                            ensureItemsIsMutable();
                            this.items_.addAll(other.items_);
                        }
                        onChanged();
                    }
                } else if (!other.items_.isEmpty()) {
                    if (this.itemsBuilder_.isEmpty()) {
                        this.itemsBuilder_.dispose();
                        this.itemsBuilder_ = null;
                        this.items_ = other.items_;
                        this.bitField0_ &= 0xFFFFFFFB;
                        this.itemsBuilder_ = BattleHandler.ItemDropPush.alwaysUseFieldBuilders ? getItemsFieldBuilder() : null;
                    } else {
                        this.itemsBuilder_.addAllMessages(other.items_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasY()) {
                    return false;
                }
                for (int i = 0; i < getItemsCount(); i++) {
                    if (!getItems(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                BattleHandler.ItemDropPush parsedMessage = null;
                try {
                    parsedMessage = (BattleHandler.ItemDropPush) BattleHandler.ItemDropPush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (BattleHandler.ItemDropPush) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasX() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public int getX() {
                return this.x_;
            }


            public Builder setX(int value) {
                this.bitField0_ |= 0x1;
                this.x_ = value;
                onChanged();
                return this;
            }


            public Builder clearX() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.x_ = 0;
                onChanged();
                return this;
            }


            public boolean hasY() {
                return ((this.bitField0_ & 0x2) == 2);
            }


            public int getY() {
                return this.y_;
            }


            public Builder setY(int value) {
                this.bitField0_ |= 0x2;
                this.y_ = value;
                onChanged();
                return this;
            }


            public Builder clearY() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.y_ = 0;
                onChanged();
                return this;
            }


            private void ensureItemsIsMutable() {
                if ((this.bitField0_ & 0x4) != 4) {
                    this.items_ = new ArrayList<>(this.items_);
                    this.bitField0_ |= 0x4;
                }
            }


            public List<BattleHandler.ItemDrop> getItemsList() {
                if (this.itemsBuilder_ == null) {
                    return Collections.unmodifiableList(this.items_);
                }
                return this.itemsBuilder_.getMessageList();
            }


            public int getItemsCount() {
                if (this.itemsBuilder_ == null) {
                    return this.items_.size();
                }
                return this.itemsBuilder_.getCount();
            }


            public BattleHandler.ItemDrop getItems(int index) {
                if (this.itemsBuilder_ == null) {
                    return this.items_.get(index);
                }
                return (BattleHandler.ItemDrop) this.itemsBuilder_.getMessage(index);
            }


            public Builder setItems(int index, BattleHandler.ItemDrop value) {
                if (this.itemsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureItemsIsMutable();
                    this.items_.set(index, value);
                    onChanged();
                } else {
                    this.itemsBuilder_.setMessage(index, value);
                }
                return this;
            }


            public Builder setItems(int index, BattleHandler.ItemDrop.Builder builderForValue) {
                if (this.itemsBuilder_ == null) {
                    ensureItemsIsMutable();
                    this.items_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.itemsBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }


            public Builder addItems(BattleHandler.ItemDrop value) {
                if (this.itemsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureItemsIsMutable();
                    this.items_.add(value);
                    onChanged();
                } else {
                    this.itemsBuilder_.addMessage(value);
                }
                return this;
            }


            public Builder addItems(int index, BattleHandler.ItemDrop value) {
                if (this.itemsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureItemsIsMutable();
                    this.items_.add(index, value);
                    onChanged();
                } else {
                    this.itemsBuilder_.addMessage(index, value);
                }
                return this;
            }


            public Builder addItems(BattleHandler.ItemDrop.Builder builderForValue) {
                if (this.itemsBuilder_ == null) {
                    ensureItemsIsMutable();
                    this.items_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.itemsBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }


            public Builder addItems(int index, BattleHandler.ItemDrop.Builder builderForValue) {
                if (this.itemsBuilder_ == null) {
                    ensureItemsIsMutable();
                    this.items_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.itemsBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }


            public Builder addAllItems(Iterable<? extends BattleHandler.ItemDrop> values) {
                if (this.itemsBuilder_ == null) {
                    ensureItemsIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.items_);
                    onChanged();
                } else {
                    this.itemsBuilder_.addAllMessages(values);
                }
                return this;
            }


            public Builder clearItems() {
                if (this.itemsBuilder_ == null) {
                    this.items_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                    onChanged();
                } else {
                    this.itemsBuilder_.clear();
                }
                return this;
            }


            public Builder removeItems(int index) {
                if (this.itemsBuilder_ == null) {
                    ensureItemsIsMutable();
                    this.items_.remove(index);
                    onChanged();
                } else {
                    this.itemsBuilder_.remove(index);
                }
                return this;
            }


            public BattleHandler.ItemDrop.Builder getItemsBuilder(int index) {
                return (BattleHandler.ItemDrop.Builder) getItemsFieldBuilder().getBuilder(index);
            }


            public BattleHandler.ItemDropOrBuilder getItemsOrBuilder(int index) {
                if (this.itemsBuilder_ == null) {
                    return this.items_.get(index);
                }
                return (BattleHandler.ItemDropOrBuilder) this.itemsBuilder_.getMessageOrBuilder(index);
            }


            public List<? extends BattleHandler.ItemDropOrBuilder> getItemsOrBuilderList() {
                if (this.itemsBuilder_ != null) {
                    return this.itemsBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList((List) this.items_);
            }


            public BattleHandler.ItemDrop.Builder addItemsBuilder() {
                return (BattleHandler.ItemDrop.Builder) getItemsFieldBuilder().addBuilder(BattleHandler.ItemDrop.getDefaultInstance());
            }


            public BattleHandler.ItemDrop.Builder addItemsBuilder(int index) {
                return (BattleHandler.ItemDrop.Builder) getItemsFieldBuilder().addBuilder(index, BattleHandler.ItemDrop.getDefaultInstance());
            }


            public List<BattleHandler.ItemDrop.Builder> getItemsBuilderList() {
                return getItemsFieldBuilder().getBuilderList();
            }


            private RepeatedFieldBuilder<BattleHandler.ItemDrop, BattleHandler.ItemDrop.Builder, BattleHandler.ItemDropOrBuilder> getItemsFieldBuilder() {
                if (this.itemsBuilder_ == null) {
                    this.itemsBuilder_ = new RepeatedFieldBuilder(this.items_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
                    this.items_ = null;
                }
                return this.itemsBuilder_;
            }
        }
    }


    public static final class PointItemView
            extends GeneratedMessage
            implements PointItemViewOrBuilder {
        private static final PointItemView defaultInstance = new PointItemView(true);
        private final UnknownFieldSet unknownFields;

        private PointItemView(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private PointItemView(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static PointItemView getDefaultInstance() {
            return defaultInstance;
        }

        public PointItemView getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PointItemView(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        case 18:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x2;
                            this.itemCode_ = bs;
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
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
            return BattleHandler.internal_static_pomelo_area_PointItemView_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return BattleHandler.internal_static_pomelo_area_PointItemView_fieldAccessorTable.ensureFieldAccessorsInitialized(PointItemView.class, Builder.class);
        }

        public static Parser<PointItemView> PARSER = (Parser<PointItemView>) new AbstractParser<PointItemView>() {
            public BattleHandler.PointItemView parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BattleHandler.PointItemView(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int ID_FIELD_NUMBER = 1;
        private Object id_;
        public static final int ITEMCODE_FIELD_NUMBER = 2;
        private Object itemCode_;
        public static final int NUM_FIELD_NUMBER = 3;
        private int num_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<PointItemView> getParserForType() {
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

        public boolean hasItemCode() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        static {
            defaultInstance.initFields();
        }


        public String getItemCode() {
            Object ref = this.itemCode_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.itemCode_ = s;
            }
            return s;
        }


        public ByteString getItemCodeBytes() {
            Object ref = this.itemCode_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.itemCode_ = b;
                return b;
            }
            return (ByteString) ref;
        }


        public boolean hasNum() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public int getNum() {
            return this.num_;
        }


        private void initFields() {
            this.id_ = "";
            this.itemCode_ = "";
            this.num_ = 0;
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasItemCode()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasNum()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeBytes(1, getIdBytes());
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeBytes(2, getItemCodeBytes());
            }
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeInt32(3, this.num_);
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
                size += CodedOutputStream.computeBytesSize(1, getIdBytes());
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeBytesSize(2, getItemCodeBytes());
            }
            if ((this.bitField0_ & 0x4) == 4) {
                size += CodedOutputStream.computeInt32Size(3, this.num_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static PointItemView parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (PointItemView) PARSER.parseFrom(data);
        }


        public static PointItemView parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (PointItemView) PARSER.parseFrom(data, extensionRegistry);
        }


        public static PointItemView parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (PointItemView) PARSER.parseFrom(data);
        }


        public static PointItemView parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (PointItemView) PARSER.parseFrom(data, extensionRegistry);
        }


        public static PointItemView parseFrom(InputStream input) throws IOException {
            return (PointItemView) PARSER.parseFrom(input);
        }


        public static PointItemView parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PointItemView) PARSER.parseFrom(input, extensionRegistry);
        }


        public static PointItemView parseDelimitedFrom(InputStream input) throws IOException {
            return (PointItemView) PARSER.parseDelimitedFrom(input);
        }


        public static PointItemView parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PointItemView) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static PointItemView parseFrom(CodedInputStream input) throws IOException {
            return (PointItemView) PARSER.parseFrom(input);
        }


        public static PointItemView parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PointItemView) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(PointItemView prototype) {
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
                implements BattleHandler.PointItemViewOrBuilder {
            private int bitField0_;


            private Object id_;


            private Object itemCode_;


            private int num_;


            public static final Descriptors.Descriptor getDescriptor() {
                return BattleHandler.internal_static_pomelo_area_PointItemView_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return BattleHandler.internal_static_pomelo_area_PointItemView_fieldAccessorTable.ensureFieldAccessorsInitialized(BattleHandler.PointItemView.class, Builder.class);
            }


            private Builder() {
                this.id_ = "";
                this.itemCode_ = "";
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.id_ = "";
                this.itemCode_ = "";
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (BattleHandler.PointItemView.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.id_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                this.itemCode_ = "";
                this.bitField0_ &= 0xFFFFFFFD;
                this.num_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return BattleHandler.internal_static_pomelo_area_PointItemView_descriptor;
            }


            public BattleHandler.PointItemView getDefaultInstanceForType() {
                return BattleHandler.PointItemView.getDefaultInstance();
            }


            public BattleHandler.PointItemView build() {
                BattleHandler.PointItemView result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public BattleHandler.PointItemView buildPartial() {
                BattleHandler.PointItemView result = new BattleHandler.PointItemView(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.id_ = this.id_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.itemCode_ = this.itemCode_;
                if ((from_bitField0_ & 0x4) == 4) {
                    to_bitField0_ |= 0x4;
                }
                result.num_ = this.num_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof BattleHandler.PointItemView) {
                    return mergeFrom((BattleHandler.PointItemView) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(BattleHandler.PointItemView other) {
                if (other == BattleHandler.PointItemView.getDefaultInstance()) {
                    return this;
                }
                if (other.hasId()) {
                    this.bitField0_ |= 0x1;
                    this.id_ = other.id_;
                    onChanged();
                }
                if (other.hasItemCode()) {
                    this.bitField0_ |= 0x2;
                    this.itemCode_ = other.itemCode_;
                    onChanged();
                }
                if (other.hasNum()) {
                    setNum(other.getNum());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasId()) {
                    return false;
                }
                if (!hasItemCode()) {
                    return false;
                }
                if (!hasNum()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                BattleHandler.PointItemView parsedMessage = null;
                try {
                    parsedMessage = (BattleHandler.PointItemView) BattleHandler.PointItemView.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (BattleHandler.PointItemView) e.getUnfinishedMessage();
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
                this.bitField0_ |= 0x1;
                this.id_ = value;
                onChanged();
                return this;
            }


            public Builder clearId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.id_ = BattleHandler.PointItemView.getDefaultInstance().getId();
                onChanged();
                return this;
            }


            public Builder setIdBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x1;
                this.id_ = value;
                onChanged();
                return this;
            }


            public boolean hasItemCode() {
                return ((this.bitField0_ & 0x2) == 2);
            }


            public String getItemCode() {
                Object ref = this.itemCode_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.itemCode_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }


            public ByteString getItemCodeBytes() {
                Object ref = this.itemCode_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.itemCode_ = b;
                    return b;
                }
                return (ByteString) ref;
            }


            public Builder setItemCode(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x2;
                this.itemCode_ = value;
                onChanged();
                return this;
            }


            public Builder clearItemCode() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.itemCode_ = BattleHandler.PointItemView.getDefaultInstance().getItemCode();
                onChanged();
                return this;
            }


            public Builder setItemCodeBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x2;
                this.itemCode_ = value;
                onChanged();
                return this;
            }


            public boolean hasNum() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public int getNum() {
                return this.num_;
            }


            public Builder setNum(int value) {
                this.bitField0_ |= 0x4;
                this.num_ = value;
                onChanged();
                return this;
            }


            public Builder clearNum() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.num_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class ThrowPointItemListPush
            extends GeneratedMessage
            implements ThrowPointItemListPushOrBuilder {
        private static final ThrowPointItemListPush defaultInstance = new ThrowPointItemListPush(true);
        private final UnknownFieldSet unknownFields;

        private ThrowPointItemListPush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private ThrowPointItemListPush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static ThrowPointItemListPush getDefaultInstance() {
            return defaultInstance;
        }

        public ThrowPointItemListPush getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ThrowPointItemListPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.time_ = input.readInt32();
                            break;
                        case 26:
                            if ((mutable_bitField0_ & 0x4) != 4) {
                                this.items_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x4;
                            }
                            this.items_.add(input.readMessage(BattleHandler.PointItemView.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x4) == 4) this.items_ = Collections.unmodifiableList(this.items_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return BattleHandler.internal_static_pomelo_area_ThrowPointItemListPush_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return BattleHandler.internal_static_pomelo_area_ThrowPointItemListPush_fieldAccessorTable.ensureFieldAccessorsInitialized(ThrowPointItemListPush.class, Builder.class);
        }

        public static Parser<ThrowPointItemListPush> PARSER = (Parser<ThrowPointItemListPush>) new AbstractParser<ThrowPointItemListPush>() {
            public BattleHandler.ThrowPointItemListPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BattleHandler.ThrowPointItemListPush(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int TIME_FIELD_NUMBER = 2;
        private int time_;
        public static final int ITEMS_FIELD_NUMBER = 3;
        private List<BattleHandler.PointItemView> items_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<ThrowPointItemListPush> getParserForType() {
            return PARSER;
        }

        public boolean hasS2CCode() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getS2CCode() {
            return this.s2CCode_;
        }

        public boolean hasTime() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public int getTime() {
            return this.time_;
        }

        static {
            defaultInstance.initFields();
        }

        public List<BattleHandler.PointItemView> getItemsList() {
            return this.items_;
        }

        public List<? extends BattleHandler.PointItemViewOrBuilder> getItemsOrBuilderList() {
            return (List) this.items_;
        }

        public int getItemsCount() {
            return this.items_.size();
        }

        public BattleHandler.PointItemView getItems(int index) {
            return this.items_.get(index);
        }

        public BattleHandler.PointItemViewOrBuilder getItemsOrBuilder(int index) {
            return this.items_.get(index);
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.time_ = 0;
            this.items_ = Collections.emptyList();
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
            for (int i = 0; i < getItemsCount(); i++) {
                if (!getItems(i).isInitialized()) {
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
                output.writeInt32(2, this.time_);
            for (int i = 0; i < this.items_.size(); i++)
                output.writeMessage(3, (MessageLite) this.items_.get(i));
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
                size += CodedOutputStream.computeInt32Size(2, this.time_);
            for (int i = 0; i < this.items_.size(); i++)
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.items_.get(i));
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static ThrowPointItemListPush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ThrowPointItemListPush) PARSER.parseFrom(data);
        }

        public static ThrowPointItemListPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ThrowPointItemListPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static ThrowPointItemListPush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ThrowPointItemListPush) PARSER.parseFrom(data);
        }

        public static ThrowPointItemListPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ThrowPointItemListPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static ThrowPointItemListPush parseFrom(InputStream input) throws IOException {
            return (ThrowPointItemListPush) PARSER.parseFrom(input);
        }

        public static ThrowPointItemListPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ThrowPointItemListPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static ThrowPointItemListPush parseDelimitedFrom(InputStream input) throws IOException {
            return (ThrowPointItemListPush) PARSER.parseDelimitedFrom(input);
        }

        public static ThrowPointItemListPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ThrowPointItemListPush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static ThrowPointItemListPush parseFrom(CodedInputStream input) throws IOException {
            return (ThrowPointItemListPush) PARSER.parseFrom(input);
        }

        public static ThrowPointItemListPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ThrowPointItemListPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(ThrowPointItemListPush prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements BattleHandler.ThrowPointItemListPushOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private int time_;
            private List<BattleHandler.PointItemView> items_;
            private RepeatedFieldBuilder<BattleHandler.PointItemView, BattleHandler.PointItemView.Builder, BattleHandler.PointItemViewOrBuilder> itemsBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return BattleHandler.internal_static_pomelo_area_ThrowPointItemListPush_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return BattleHandler.internal_static_pomelo_area_ThrowPointItemListPush_fieldAccessorTable.ensureFieldAccessorsInitialized(BattleHandler.ThrowPointItemListPush.class, Builder.class);
            }

            private Builder() {
                this.items_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.items_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (BattleHandler.ThrowPointItemListPush.alwaysUseFieldBuilders)
                    getItemsFieldBuilder();
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.s2CCode_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.time_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                if (this.itemsBuilder_ == null) {
                    this.items_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                } else {
                    this.itemsBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return BattleHandler.internal_static_pomelo_area_ThrowPointItemListPush_descriptor;
            }

            public BattleHandler.ThrowPointItemListPush getDefaultInstanceForType() {
                return BattleHandler.ThrowPointItemListPush.getDefaultInstance();
            }

            public BattleHandler.ThrowPointItemListPush build() {
                BattleHandler.ThrowPointItemListPush result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public BattleHandler.ThrowPointItemListPush buildPartial() {
                BattleHandler.ThrowPointItemListPush result = new BattleHandler.ThrowPointItemListPush(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.time_ = this.time_;
                if (this.itemsBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4) {
                        this.items_ = Collections.unmodifiableList(this.items_);
                        this.bitField0_ &= 0xFFFFFFFB;
                    }
                    result.items_ = this.items_;
                } else {
                    result.items_ = this.itemsBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof BattleHandler.ThrowPointItemListPush)
                    return mergeFrom((BattleHandler.ThrowPointItemListPush) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(BattleHandler.ThrowPointItemListPush other) {
                if (other == BattleHandler.ThrowPointItemListPush.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasTime())
                    setTime(other.getTime());
                if (this.itemsBuilder_ == null) {
                    if (!other.items_.isEmpty()) {
                        if (this.items_.isEmpty()) {
                            this.items_ = other.items_;
                            this.bitField0_ &= 0xFFFFFFFB;
                        } else {
                            ensureItemsIsMutable();
                            this.items_.addAll(other.items_);
                        }
                        onChanged();
                    }
                } else if (!other.items_.isEmpty()) {
                    if (this.itemsBuilder_.isEmpty()) {
                        this.itemsBuilder_.dispose();
                        this.itemsBuilder_ = null;
                        this.items_ = other.items_;
                        this.bitField0_ &= 0xFFFFFFFB;
                        this.itemsBuilder_ = BattleHandler.ThrowPointItemListPush.alwaysUseFieldBuilders ? getItemsFieldBuilder() : null;
                    } else {
                        this.itemsBuilder_.addAllMessages(other.items_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode())
                    return false;
                for (int i = 0; i < getItemsCount(); i++) {
                    if (!getItems(i).isInitialized())
                        return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                BattleHandler.ThrowPointItemListPush parsedMessage = null;
                try {
                    parsedMessage = (BattleHandler.ThrowPointItemListPush) BattleHandler.ThrowPointItemListPush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (BattleHandler.ThrowPointItemListPush) e.getUnfinishedMessage();
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

            public boolean hasTime() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getTime() {
                return this.time_;
            }

            public Builder setTime(int value) {
                this.bitField0_ |= 0x2;
                this.time_ = value;
                onChanged();
                return this;
            }

            public Builder clearTime() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.time_ = 0;
                onChanged();
                return this;
            }

            private void ensureItemsIsMutable() {
                if ((this.bitField0_ & 0x4) != 4) {
                    this.items_ = new ArrayList<>(this.items_);
                    this.bitField0_ |= 0x4;
                }
            }

            public List<BattleHandler.PointItemView> getItemsList() {
                if (this.itemsBuilder_ == null)
                    return Collections.unmodifiableList(this.items_);
                return this.itemsBuilder_.getMessageList();
            }

            public int getItemsCount() {
                if (this.itemsBuilder_ == null)
                    return this.items_.size();
                return this.itemsBuilder_.getCount();
            }

            public BattleHandler.PointItemView getItems(int index) {
                if (this.itemsBuilder_ == null)
                    return this.items_.get(index);
                return (BattleHandler.PointItemView) this.itemsBuilder_.getMessage(index);
            }

            public Builder setItems(int index, BattleHandler.PointItemView value) {
                if (this.itemsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureItemsIsMutable();
                    this.items_.set(index, value);
                    onChanged();
                } else {
                    this.itemsBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setItems(int index, BattleHandler.PointItemView.Builder builderForValue) {
                if (this.itemsBuilder_ == null) {
                    ensureItemsIsMutable();
                    this.items_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.itemsBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addItems(BattleHandler.PointItemView value) {
                if (this.itemsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureItemsIsMutable();
                    this.items_.add(value);
                    onChanged();
                } else {
                    this.itemsBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addItems(int index, BattleHandler.PointItemView value) {
                if (this.itemsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureItemsIsMutable();
                    this.items_.add(index, value);
                    onChanged();
                } else {
                    this.itemsBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addItems(BattleHandler.PointItemView.Builder builderForValue) {
                if (this.itemsBuilder_ == null) {
                    ensureItemsIsMutable();
                    this.items_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.itemsBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addItems(int index, BattleHandler.PointItemView.Builder builderForValue) {
                if (this.itemsBuilder_ == null) {
                    ensureItemsIsMutable();
                    this.items_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.itemsBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllItems(Iterable<? extends BattleHandler.PointItemView> values) {
                if (this.itemsBuilder_ == null) {
                    ensureItemsIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.items_);
                    onChanged();
                } else {
                    this.itemsBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearItems() {
                if (this.itemsBuilder_ == null) {
                    this.items_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                    onChanged();
                } else {
                    this.itemsBuilder_.clear();
                }
                return this;
            }

            public Builder removeItems(int index) {
                if (this.itemsBuilder_ == null) {
                    ensureItemsIsMutable();
                    this.items_.remove(index);
                    onChanged();
                } else {
                    this.itemsBuilder_.remove(index);
                }
                return this;
            }

            public BattleHandler.PointItemView.Builder getItemsBuilder(int index) {
                return (BattleHandler.PointItemView.Builder) getItemsFieldBuilder().getBuilder(index);
            }

            public BattleHandler.PointItemViewOrBuilder getItemsOrBuilder(int index) {
                if (this.itemsBuilder_ == null)
                    return this.items_.get(index);
                return (BattleHandler.PointItemViewOrBuilder) this.itemsBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends BattleHandler.PointItemViewOrBuilder> getItemsOrBuilderList() {
                if (this.itemsBuilder_ != null)
                    return this.itemsBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.items_);
            }

            public BattleHandler.PointItemView.Builder addItemsBuilder() {
                return (BattleHandler.PointItemView.Builder) getItemsFieldBuilder().addBuilder(BattleHandler.PointItemView.getDefaultInstance());
            }

            public BattleHandler.PointItemView.Builder addItemsBuilder(int index) {
                return (BattleHandler.PointItemView.Builder) getItemsFieldBuilder().addBuilder(index, BattleHandler.PointItemView.getDefaultInstance());
            }

            public List<BattleHandler.PointItemView.Builder> getItemsBuilderList() {
                return getItemsFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<BattleHandler.PointItemView, BattleHandler.PointItemView.Builder, BattleHandler.PointItemViewOrBuilder> getItemsFieldBuilder() {
                if (this.itemsBuilder_ == null) {
                    this.itemsBuilder_ = new RepeatedFieldBuilder(this.items_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
                    this.items_ = null;
                }
                return this.itemsBuilder_;
            }
        }
    }

    public static final class SceneNamePush extends GeneratedMessage implements SceneNamePushOrBuilder {
        private final UnknownFieldSet unknownFields;

        private SceneNamePush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private SceneNamePush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static SceneNamePush getDefaultInstance() {
            return defaultInstance;
        }

        public SceneNamePush getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SceneNamePush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.sceneName_ = bs;
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
            return BattleHandler.internal_static_pomelo_area_SceneNamePush_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return BattleHandler.internal_static_pomelo_area_SceneNamePush_fieldAccessorTable.ensureFieldAccessorsInitialized(SceneNamePush.class, Builder.class);
        }

        public static Parser<SceneNamePush> PARSER = (Parser<SceneNamePush>) new AbstractParser<SceneNamePush>() {
            public BattleHandler.SceneNamePush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BattleHandler.SceneNamePush(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int SCENE_NAME_FIELD_NUMBER = 1;
        private Object sceneName_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;
        private static final SceneNamePush defaultInstance = new SceneNamePush(true);

        public Parser<SceneNamePush> getParserForType() {
            return PARSER;
        }

        public boolean hasSceneName() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public String getSceneName() {
            Object ref = this.sceneName_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.sceneName_ = s;
            return s;
        }

        public ByteString getSceneNameBytes() {
            Object ref = this.sceneName_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.sceneName_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        private void initFields() {
            this.sceneName_ = "";
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasSceneName()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeBytes(1, getSceneNameBytes());
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeBytesSize(1, getSceneNameBytes());
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static SceneNamePush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (SceneNamePush) PARSER.parseFrom(data);
        }

        public static SceneNamePush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SceneNamePush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneNamePush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (SceneNamePush) PARSER.parseFrom(data);
        }

        public static SceneNamePush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SceneNamePush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneNamePush parseFrom(InputStream input) throws IOException {
            return (SceneNamePush) PARSER.parseFrom(input);
        }

        public static SceneNamePush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneNamePush) PARSER.parseFrom(input, extensionRegistry);
        }

        static {
            defaultInstance.initFields();
        }

        public static SceneNamePush parseDelimitedFrom(InputStream input) throws IOException {
            return (SceneNamePush) PARSER.parseDelimitedFrom(input);
        }

        public static SceneNamePush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneNamePush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static SceneNamePush parseFrom(CodedInputStream input) throws IOException {
            return (SceneNamePush) PARSER.parseFrom(input);
        }

        public static SceneNamePush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneNamePush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(SceneNamePush prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements BattleHandler.SceneNamePushOrBuilder {
            private int bitField0_;
            private Object sceneName_;

            public static final Descriptors.Descriptor getDescriptor() {
                return BattleHandler.internal_static_pomelo_area_SceneNamePush_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return BattleHandler.internal_static_pomelo_area_SceneNamePush_fieldAccessorTable.ensureFieldAccessorsInitialized(BattleHandler.SceneNamePush.class, Builder.class);
            }

            private Builder() {
                this.sceneName_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.sceneName_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (BattleHandler.SceneNamePush.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.sceneName_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return BattleHandler.internal_static_pomelo_area_SceneNamePush_descriptor;
            }

            public BattleHandler.SceneNamePush getDefaultInstanceForType() {
                return BattleHandler.SceneNamePush.getDefaultInstance();
            }

            public BattleHandler.SceneNamePush build() {
                BattleHandler.SceneNamePush result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public BattleHandler.SceneNamePush buildPartial() {
                BattleHandler.SceneNamePush result = new BattleHandler.SceneNamePush(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.sceneName_ = this.sceneName_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof BattleHandler.SceneNamePush)
                    return mergeFrom((BattleHandler.SceneNamePush) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(BattleHandler.SceneNamePush other) {
                if (other == BattleHandler.SceneNamePush.getDefaultInstance())
                    return this;
                if (other.hasSceneName()) {
                    this.bitField0_ |= 0x1;
                    this.sceneName_ = other.sceneName_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasSceneName())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                BattleHandler.SceneNamePush parsedMessage = null;
                try {
                    parsedMessage = (BattleHandler.SceneNamePush) BattleHandler.SceneNamePush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (BattleHandler.SceneNamePush) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null)
                        mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasSceneName() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public String getSceneName() {
                Object ref = this.sceneName_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.sceneName_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getSceneNameBytes() {
                Object ref = this.sceneName_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.sceneName_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setSceneName(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.sceneName_ = value;
                onChanged();
                return this;
            }

            public Builder clearSceneName() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.sceneName_ = BattleHandler.SceneNamePush.getDefaultInstance().getSceneName();
                onChanged();
                return this;
            }

            public Builder setSceneNameBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.sceneName_ = value;
                onChanged();
                return this;
            }
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }


    static {
        String[] descriptorData = {"\n\023battleHandler.proto\022\013pomelo.area\032\fcommon.proto\"/\n\nItemNormal\022\020\n\bitemCode\030\001 \002(\t\022\017\n\007itemNum\030\002 \002(\005\"\037\n\021ThrowPointRequest\022\n\n\002id\030\001 \001(\t\"F\n\022ThrowPointResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\r\n\005point\030\003 \001(\005\"p\n\024ThrowPointResultPush\022\n\n\002id\030\001 \002(\t\022\f\n\004name\030\002 \002(\t\022\r\n\005point\030\003 \002(\005\022\020\n\bs2c_code\030\004 \002(\005\022\020\n\bitemCode\030\005 \002(\t\022\013\n\003num\030\006 \002(\005\"¼\002\n\024FightLevelResultPush\022\f\n\004time\030\001 \001(\005\022\r\n\005level\030\002 \001(\005\022\f\n\004type\030\003 \001(\005\022*\n\titemLine1\030\004 ", "\003(\0132\027.pomelo.area.ItemNormal\022*\n\titemLine2\030\006 \003(\0132\027.pomelo.area.ItemNormal\022\r\n\005isMax\030\007 \001(\005\0228\n\023demonTowerFloorInfo\030\b \001(\0132\033.pomelo.DemonTowerFloorInfo\022\023\n\013currentTime\030\t \001(\005\022\026\n\016newRecordFloor\030\n \001(\b\022\025\n\rnewRecordTime\030\013 \001(\b\022\024\n\fmyMaxFloorId\030\f \001(\005\"¬\001\n\031ResourceDungeonResultPush\022\021\n\tdungeonId\030\001 \002(\005\022\023\n\013killMonster\030\002 \001(\005\022\022\n\ndoubleCost\030\003 \001(\005\022\013\n\003exp\030\004 \001(\005\022\f\n\004gold\030\005 \001(\005\022*\n\titemLine1\030\006 \003(\0132\027.pomelo.area.ItemNormal\022\f\n\004", "succ\030\007 \001(\005\"¹\001\n\bItemDrop\022\n\n\002id\030\001 \001(\t\022\f\n\004name\030\002 \002(\t\022\016\n\006showId\030\003 \002(\t\022\022\n\ngroupCount\030\004 \001(\005\022\016\n\006qColor\030\005 \002(\005\022\022\n\nitemTypeId\030\006 \002(\005\022\020\n\biconName\030\007 \002(\t\022\022\n\nfreezeTime\030\b \001(\005\022\023\n\013protectTime\030\t \001(\005\022\020\n\blifeTime\030\n \001(\005\"J\n\fItemDropPush\022\t\n\001x\030\001 \001(\005\022\t\n\001y\030\002 \002(\005\022$\n\005items\030\003 \003(\0132\025.pomelo.area.ItemDrop\":\n\rPointItemView\022\n\n\002id\030\001 \002(\t\022\020\n\bitemCode\030\002 \002(\t\022\013\n\003num\030\003 \002(\005\"c\n\026ThrowPointItemListPush\022\020\n\bs2c_code\030\001 \002(\005\022\f\n\004time\030\002 \001(\005\022)\n\005item", "s\030\003 \003(\0132\032.pomelo.area.PointItemView\"#\n\rSceneNamePush\022\022\n\nscene_name\030\001 \002(\t2e\n\rbattleHandler\022T\n\021throwPointRequest\022\036.pomelo.area.ThrowPointRequest\032\037.pomelo.area.ThrowPointResponse2²\003\n\nbattlePush\022K\n\026throwPointItemListPush\022#.pomelo.area.ThrowPointItemListPush\032\f.pomelo.Void\022G\n\024throwPointResultPush\022!.pomelo.area.ThrowPointResultPush\032\f.pomelo.Void\022G\n\024fightLevelResultPush\022!.pomelo.area.FightLevelResultPush\032", "\f.pomelo.Void\0227\n\fitemDropPush\022\031.pomelo.area.ItemDropPush\032\f.pomelo.Void\0229\n\rsceneNamePush\022\032.pomelo.area.SceneNamePush\032\f.pomelo.Void\022Q\n\031resourceDungeonResultPush\022&.pomelo.area.ResourceDungeonResultPush\032\f.pomelo.Void"};


        Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root) {
                BattleHandler.descriptor = root;
                return null;
            }
        };

        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[]{

                Common.getDescriptor()}, assigner);
    }

    private static final Descriptors.Descriptor internal_static_pomelo_area_ItemNormal_descriptor = getDescriptor().getMessageTypes().get(0);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ItemNormal_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ItemNormal_descriptor, new String[]{"ItemCode", "ItemNum"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_ThrowPointRequest_descriptor = getDescriptor().getMessageTypes().get(1);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ThrowPointRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ThrowPointRequest_descriptor, new String[]{"Id"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_ThrowPointResponse_descriptor = getDescriptor().getMessageTypes().get(2);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ThrowPointResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ThrowPointResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "Point"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_ThrowPointResultPush_descriptor = getDescriptor().getMessageTypes().get(3);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ThrowPointResultPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ThrowPointResultPush_descriptor, new String[]{"Id", "Name", "Point", "S2CCode", "ItemCode", "Num"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_FightLevelResultPush_descriptor = getDescriptor().getMessageTypes().get(4);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_FightLevelResultPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_FightLevelResultPush_descriptor, new String[]{"Time", "Level", "Type", "ItemLine1", "ItemLine2", "IsMax", "DemonTowerFloorInfo", "CurrentTime", "NewRecordFloor", "NewRecordTime", "MyMaxFloorId"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_ResourceDungeonResultPush_descriptor = getDescriptor().getMessageTypes().get(5);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ResourceDungeonResultPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ResourceDungeonResultPush_descriptor, new String[]{"DungeonId", "KillMonster", "DoubleCost", "Exp", "Gold", "ItemLine1", "Succ"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_ItemDrop_descriptor = getDescriptor().getMessageTypes().get(6);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ItemDrop_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ItemDrop_descriptor, new String[]{"Id", "Name", "ShowId", "GroupCount", "QColor", "ItemTypeId", "IconName", "FreezeTime", "ProtectTime", "LifeTime"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_ItemDropPush_descriptor = getDescriptor().getMessageTypes().get(7);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ItemDropPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ItemDropPush_descriptor, new String[]{"X", "Y", "Items"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_PointItemView_descriptor = getDescriptor().getMessageTypes().get(8);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_PointItemView_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_PointItemView_descriptor, new String[]{"Id", "ItemCode", "Num"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_ThrowPointItemListPush_descriptor = getDescriptor().getMessageTypes().get(9);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ThrowPointItemListPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ThrowPointItemListPush_descriptor, new String[]{"S2CCode", "Time", "Items"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_SceneNamePush_descriptor = getDescriptor().getMessageTypes().get(10);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_SceneNamePush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_SceneNamePush_descriptor, new String[]{"SceneName"});
    private static Descriptors.FileDescriptor descriptor;

    static {
        Common.getDescriptor();
    }

    public static interface SceneNamePushOrBuilder extends MessageOrBuilder {
        boolean hasSceneName();

        String getSceneName();

        ByteString getSceneNameBytes();
    }

    public static interface ThrowPointItemListPushOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasTime();

        int getTime();

        List<BattleHandler.PointItemView> getItemsList();

        BattleHandler.PointItemView getItems(int param1Int);

        int getItemsCount();

        List<? extends BattleHandler.PointItemViewOrBuilder> getItemsOrBuilderList();

        BattleHandler.PointItemViewOrBuilder getItemsOrBuilder(int param1Int);
    }

    public static interface PointItemViewOrBuilder extends MessageOrBuilder {
        boolean hasId();

        String getId();

        ByteString getIdBytes();

        boolean hasItemCode();

        String getItemCode();

        ByteString getItemCodeBytes();

        boolean hasNum();

        int getNum();
    }

    public static interface ItemDropPushOrBuilder extends MessageOrBuilder {
        boolean hasX();

        int getX();

        boolean hasY();

        int getY();

        List<BattleHandler.ItemDrop> getItemsList();

        BattleHandler.ItemDrop getItems(int param1Int);

        int getItemsCount();

        List<? extends BattleHandler.ItemDropOrBuilder> getItemsOrBuilderList();

        BattleHandler.ItemDropOrBuilder getItemsOrBuilder(int param1Int);
    }

    public static interface ItemDropOrBuilder extends MessageOrBuilder {
        boolean hasId();

        String getId();

        ByteString getIdBytes();

        boolean hasName();

        String getName();

        ByteString getNameBytes();

        boolean hasShowId();

        String getShowId();

        ByteString getShowIdBytes();

        boolean hasGroupCount();

        int getGroupCount();

        boolean hasQColor();

        int getQColor();

        boolean hasItemTypeId();

        int getItemTypeId();

        boolean hasIconName();

        String getIconName();

        ByteString getIconNameBytes();

        boolean hasFreezeTime();

        int getFreezeTime();

        boolean hasProtectTime();

        int getProtectTime();

        boolean hasLifeTime();

        int getLifeTime();
    }

    public static interface ResourceDungeonResultPushOrBuilder extends MessageOrBuilder {
        boolean hasDungeonId();

        int getDungeonId();

        boolean hasKillMonster();

        int getKillMonster();

        boolean hasDoubleCost();

        int getDoubleCost();

        boolean hasExp();

        int getExp();

        boolean hasGold();

        int getGold();

        List<BattleHandler.ItemNormal> getItemLine1List();

        BattleHandler.ItemNormal getItemLine1(int param1Int);

        int getItemLine1Count();

        List<? extends BattleHandler.ItemNormalOrBuilder> getItemLine1OrBuilderList();

        BattleHandler.ItemNormalOrBuilder getItemLine1OrBuilder(int param1Int);

        boolean hasSucc();

        int getSucc();
    }

    public static interface FightLevelResultPushOrBuilder extends MessageOrBuilder {
        boolean hasTime();

        int getTime();

        boolean hasLevel();

        int getLevel();

        boolean hasType();

        int getType();

        List<BattleHandler.ItemNormal> getItemLine1List();

        BattleHandler.ItemNormal getItemLine1(int param1Int);

        int getItemLine1Count();

        List<? extends BattleHandler.ItemNormalOrBuilder> getItemLine1OrBuilderList();

        BattleHandler.ItemNormalOrBuilder getItemLine1OrBuilder(int param1Int);

        List<BattleHandler.ItemNormal> getItemLine2List();

        BattleHandler.ItemNormal getItemLine2(int param1Int);

        int getItemLine2Count();

        List<? extends BattleHandler.ItemNormalOrBuilder> getItemLine2OrBuilderList();

        BattleHandler.ItemNormalOrBuilder getItemLine2OrBuilder(int param1Int);

        boolean hasIsMax();

        int getIsMax();

        boolean hasDemonTowerFloorInfo();

        Common.DemonTowerFloorInfo getDemonTowerFloorInfo();

        Common.DemonTowerFloorInfoOrBuilder getDemonTowerFloorInfoOrBuilder();

        boolean hasCurrentTime();

        int getCurrentTime();

        boolean hasNewRecordFloor();

        boolean getNewRecordFloor();

        boolean hasNewRecordTime();

        boolean getNewRecordTime();

        boolean hasMyMaxFloorId();

        int getMyMaxFloorId();
    }

    public static interface ThrowPointResultPushOrBuilder extends MessageOrBuilder {
        boolean hasId();

        String getId();

        ByteString getIdBytes();

        boolean hasName();

        String getName();

        ByteString getNameBytes();

        boolean hasPoint();

        int getPoint();

        boolean hasS2CCode();

        int getS2CCode();

        boolean hasItemCode();

        String getItemCode();

        ByteString getItemCodeBytes();

        boolean hasNum();

        int getNum();
    }

    public static interface ThrowPointResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasPoint();

        int getPoint();
    }

    public static interface ThrowPointRequestOrBuilder extends MessageOrBuilder {
        boolean hasId();

        String getId();

        ByteString getIdBytes();
    }

    public static interface ItemNormalOrBuilder extends MessageOrBuilder {
        boolean hasItemCode();

        String getItemCode();

        ByteString getItemCodeBytes();

        boolean hasItemNum();

        int getItemNum();
    }
}


