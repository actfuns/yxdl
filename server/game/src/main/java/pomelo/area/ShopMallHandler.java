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


public final class ShopMallHandler {
    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static final class MallItem
            extends GeneratedMessage
            implements MallItemOrBuilder {
        private static final MallItem defaultInstance = new MallItem(true);
        private final UnknownFieldSet unknownFields;

        private MallItem(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private MallItem(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static MallItem getDefaultInstance() {
            return defaultInstance;
        }

        public MallItem getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MallItem(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.code_ = bs;
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.groupCount_ = input.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.originPrice_ = input.readInt32();
                            break;
                        case 40:
                            this.bitField0_ |= 0x10;
                            this.nowPrice_ = input.readInt32();
                            break;
                        case 48:
                            this.bitField0_ |= 0x20;
                            this.disCount_ = input.readInt32();
                            break;
                        case 56:
                            this.bitField0_ |= 0x40;
                            this.endTime_ = input.readInt32();
                            break;
                        case 64:
                            this.bitField0_ |= 0x80;
                            this.remainNum_ = input.readInt32();
                            break;
                        case 72:
                            this.bitField0_ |= 0x100;
                            this.consumeScore_ = input.readInt32();
                            break;
                        case 80:
                            this.bitField0_ |= 0x200;
                            this.bindType_ = input.readInt32();
                            break;
                        case 88:
                            this.bitField0_ |= 0x400;
                            this.canSend_ = input.readInt32();
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
            return ShopMallHandler.internal_static_pomelo_area_MallItem_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ShopMallHandler.internal_static_pomelo_area_MallItem_fieldAccessorTable.ensureFieldAccessorsInitialized(MallItem.class, Builder.class);
        }

        public static Parser<MallItem> PARSER = (Parser<MallItem>) new AbstractParser<MallItem>() {
            public ShopMallHandler.MallItem parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ShopMallHandler.MallItem(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int ID_FIELD_NUMBER = 1;
        private Object id_;
        public static final int CODE_FIELD_NUMBER = 2;
        private Object code_;
        public static final int GROUPCOUNT_FIELD_NUMBER = 3;
        private int groupCount_;
        public static final int ORIGINPRICE_FIELD_NUMBER = 4;
        private int originPrice_;
        public static final int NOWPRICE_FIELD_NUMBER = 5;
        private int nowPrice_;
        public static final int DISCOUNT_FIELD_NUMBER = 6;
        private int disCount_;
        public static final int ENDTIME_FIELD_NUMBER = 7;
        private int endTime_;
        public static final int REMAINNUM_FIELD_NUMBER = 8;
        private int remainNum_;
        public static final int CONSUMESCORE_FIELD_NUMBER = 9;
        private int consumeScore_;
        public static final int BINDTYPE_FIELD_NUMBER = 10;
        private int bindType_;
        public static final int CANSEND_FIELD_NUMBER = 11;
        private int canSend_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<MallItem> getParserForType() {
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

        public boolean hasCode() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        static {
            defaultInstance.initFields();
        }


        public String getCode() {
            Object ref = this.code_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.code_ = s;
            }
            return s;
        }


        public ByteString getCodeBytes() {
            Object ref = this.code_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.code_ = b;
                return b;
            }
            return (ByteString) ref;
        }


        public boolean hasGroupCount() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public int getGroupCount() {
            return this.groupCount_;
        }


        public boolean hasOriginPrice() {
            return ((this.bitField0_ & 0x8) == 8);
        }


        public int getOriginPrice() {
            return this.originPrice_;
        }


        public boolean hasNowPrice() {
            return ((this.bitField0_ & 0x10) == 16);
        }


        public int getNowPrice() {
            return this.nowPrice_;
        }


        public boolean hasDisCount() {
            return ((this.bitField0_ & 0x20) == 32);
        }


        public int getDisCount() {
            return this.disCount_;
        }


        public boolean hasEndTime() {
            return ((this.bitField0_ & 0x40) == 64);
        }


        public int getEndTime() {
            return this.endTime_;
        }


        public boolean hasRemainNum() {
            return ((this.bitField0_ & 0x80) == 128);
        }


        public int getRemainNum() {
            return this.remainNum_;
        }


        public boolean hasConsumeScore() {
            return ((this.bitField0_ & 0x100) == 256);
        }


        public int getConsumeScore() {
            return this.consumeScore_;
        }


        public boolean hasBindType() {
            return ((this.bitField0_ & 0x200) == 512);
        }


        public int getBindType() {
            return this.bindType_;
        }


        public boolean hasCanSend() {
            return ((this.bitField0_ & 0x400) == 1024);
        }


        public int getCanSend() {
            return this.canSend_;
        }


        private void initFields() {
            this.id_ = "";
            this.code_ = "";
            this.groupCount_ = 0;
            this.originPrice_ = 0;
            this.nowPrice_ = 0;
            this.disCount_ = 0;
            this.endTime_ = 0;
            this.remainNum_ = 0;
            this.consumeScore_ = 0;
            this.bindType_ = 0;
            this.canSend_ = 0;
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
            if (!hasCode()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasGroupCount()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasOriginPrice()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasNowPrice()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasDisCount()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasEndTime()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasRemainNum()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasConsumeScore()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasBindType()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasCanSend()) {
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
                output.writeBytes(2, getCodeBytes());
            }
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeInt32(3, this.groupCount_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                output.writeInt32(4, this.originPrice_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                output.writeInt32(5, this.nowPrice_);
            }
            if ((this.bitField0_ & 0x20) == 32) {
                output.writeInt32(6, this.disCount_);
            }
            if ((this.bitField0_ & 0x40) == 64) {
                output.writeInt32(7, this.endTime_);
            }
            if ((this.bitField0_ & 0x80) == 128) {
                output.writeInt32(8, this.remainNum_);
            }
            if ((this.bitField0_ & 0x100) == 256) {
                output.writeInt32(9, this.consumeScore_);
            }
            if ((this.bitField0_ & 0x200) == 512) {
                output.writeInt32(10, this.bindType_);
            }
            if ((this.bitField0_ & 0x400) == 1024) {
                output.writeInt32(11, this.canSend_);
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
                size += CodedOutputStream.computeBytesSize(2, getCodeBytes());
            }
            if ((this.bitField0_ & 0x4) == 4) {
                size += CodedOutputStream.computeInt32Size(3, this.groupCount_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                size += CodedOutputStream.computeInt32Size(4, this.originPrice_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                size += CodedOutputStream.computeInt32Size(5, this.nowPrice_);
            }
            if ((this.bitField0_ & 0x20) == 32) {
                size += CodedOutputStream.computeInt32Size(6, this.disCount_);
            }
            if ((this.bitField0_ & 0x40) == 64) {
                size += CodedOutputStream.computeInt32Size(7, this.endTime_);
            }
            if ((this.bitField0_ & 0x80) == 128) {
                size += CodedOutputStream.computeInt32Size(8, this.remainNum_);
            }
            if ((this.bitField0_ & 0x100) == 256) {
                size += CodedOutputStream.computeInt32Size(9, this.consumeScore_);
            }
            if ((this.bitField0_ & 0x200) == 512) {
                size += CodedOutputStream.computeInt32Size(10, this.bindType_);
            }
            if ((this.bitField0_ & 0x400) == 1024) {
                size += CodedOutputStream.computeInt32Size(11, this.canSend_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static MallItem parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (MallItem) PARSER.parseFrom(data);
        }


        public static MallItem parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MallItem) PARSER.parseFrom(data, extensionRegistry);
        }


        public static MallItem parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (MallItem) PARSER.parseFrom(data);
        }


        public static MallItem parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MallItem) PARSER.parseFrom(data, extensionRegistry);
        }


        public static MallItem parseFrom(InputStream input) throws IOException {
            return (MallItem) PARSER.parseFrom(input);
        }


        public static MallItem parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MallItem) PARSER.parseFrom(input, extensionRegistry);
        }


        public static MallItem parseDelimitedFrom(InputStream input) throws IOException {
            return (MallItem) PARSER.parseDelimitedFrom(input);
        }


        public static MallItem parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MallItem) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static MallItem parseFrom(CodedInputStream input) throws IOException {
            return (MallItem) PARSER.parseFrom(input);
        }


        public static MallItem parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MallItem) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(MallItem prototype) {
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
                implements ShopMallHandler.MallItemOrBuilder {
            private int bitField0_;


            private Object id_;


            private Object code_;


            private int groupCount_;


            private int originPrice_;


            private int nowPrice_;


            private int disCount_;


            private int endTime_;


            private int remainNum_;


            private int consumeScore_;


            private int bindType_;


            private int canSend_;


            public static final Descriptors.Descriptor getDescriptor() {
                return ShopMallHandler.internal_static_pomelo_area_MallItem_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return ShopMallHandler.internal_static_pomelo_area_MallItem_fieldAccessorTable.ensureFieldAccessorsInitialized(ShopMallHandler.MallItem.class, Builder.class);
            }


            private Builder() {
                this.id_ = "";
                this.code_ = "";
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.id_ = "";
                this.code_ = "";
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (ShopMallHandler.MallItem.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.id_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                this.code_ = "";
                this.bitField0_ &= 0xFFFFFFFD;
                this.groupCount_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.originPrice_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                this.nowPrice_ = 0;
                this.bitField0_ &= 0xFFFFFFEF;
                this.disCount_ = 0;
                this.bitField0_ &= 0xFFFFFFDF;
                this.endTime_ = 0;
                this.bitField0_ &= 0xFFFFFFBF;
                this.remainNum_ = 0;
                this.bitField0_ &= 0xFFFFFF7F;
                this.consumeScore_ = 0;
                this.bitField0_ &= 0xFFFFFEFF;
                this.bindType_ = 0;
                this.bitField0_ &= 0xFFFFFDFF;
                this.canSend_ = 0;
                this.bitField0_ &= 0xFFFFFBFF;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return ShopMallHandler.internal_static_pomelo_area_MallItem_descriptor;
            }


            public ShopMallHandler.MallItem getDefaultInstanceForType() {
                return ShopMallHandler.MallItem.getDefaultInstance();
            }


            public ShopMallHandler.MallItem build() {
                ShopMallHandler.MallItem result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public ShopMallHandler.MallItem buildPartial() {
                ShopMallHandler.MallItem result = new ShopMallHandler.MallItem(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.id_ = this.id_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.code_ = this.code_;
                if ((from_bitField0_ & 0x4) == 4) {
                    to_bitField0_ |= 0x4;
                }
                result.groupCount_ = this.groupCount_;
                if ((from_bitField0_ & 0x8) == 8) {
                    to_bitField0_ |= 0x8;
                }
                result.originPrice_ = this.originPrice_;
                if ((from_bitField0_ & 0x10) == 16) {
                    to_bitField0_ |= 0x10;
                }
                result.nowPrice_ = this.nowPrice_;
                if ((from_bitField0_ & 0x20) == 32) {
                    to_bitField0_ |= 0x20;
                }
                result.disCount_ = this.disCount_;
                if ((from_bitField0_ & 0x40) == 64) {
                    to_bitField0_ |= 0x40;
                }
                result.endTime_ = this.endTime_;
                if ((from_bitField0_ & 0x80) == 128) {
                    to_bitField0_ |= 0x80;
                }
                result.remainNum_ = this.remainNum_;
                if ((from_bitField0_ & 0x100) == 256) {
                    to_bitField0_ |= 0x100;
                }
                result.consumeScore_ = this.consumeScore_;
                if ((from_bitField0_ & 0x200) == 512) {
                    to_bitField0_ |= 0x200;
                }
                result.bindType_ = this.bindType_;
                if ((from_bitField0_ & 0x400) == 1024) {
                    to_bitField0_ |= 0x400;
                }
                result.canSend_ = this.canSend_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof ShopMallHandler.MallItem) {
                    return mergeFrom((ShopMallHandler.MallItem) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(ShopMallHandler.MallItem other) {
                if (other == ShopMallHandler.MallItem.getDefaultInstance()) {
                    return this;
                }
                if (other.hasId()) {
                    this.bitField0_ |= 0x1;
                    this.id_ = other.id_;
                    onChanged();
                }
                if (other.hasCode()) {
                    this.bitField0_ |= 0x2;
                    this.code_ = other.code_;
                    onChanged();
                }
                if (other.hasGroupCount()) {
                    setGroupCount(other.getGroupCount());
                }
                if (other.hasOriginPrice()) {
                    setOriginPrice(other.getOriginPrice());
                }
                if (other.hasNowPrice()) {
                    setNowPrice(other.getNowPrice());
                }
                if (other.hasDisCount()) {
                    setDisCount(other.getDisCount());
                }
                if (other.hasEndTime()) {
                    setEndTime(other.getEndTime());
                }
                if (other.hasRemainNum()) {
                    setRemainNum(other.getRemainNum());
                }
                if (other.hasConsumeScore()) {
                    setConsumeScore(other.getConsumeScore());
                }
                if (other.hasBindType()) {
                    setBindType(other.getBindType());
                }
                if (other.hasCanSend()) {
                    setCanSend(other.getCanSend());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasId()) {
                    return false;
                }
                if (!hasCode()) {
                    return false;
                }
                if (!hasGroupCount()) {
                    return false;
                }
                if (!hasOriginPrice()) {
                    return false;
                }
                if (!hasNowPrice()) {
                    return false;
                }
                if (!hasDisCount()) {
                    return false;
                }
                if (!hasEndTime()) {
                    return false;
                }
                if (!hasRemainNum()) {
                    return false;
                }
                if (!hasConsumeScore()) {
                    return false;
                }
                if (!hasBindType()) {
                    return false;
                }
                if (!hasCanSend()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                ShopMallHandler.MallItem parsedMessage = null;
                try {
                    parsedMessage = (ShopMallHandler.MallItem) ShopMallHandler.MallItem.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (ShopMallHandler.MallItem) e.getUnfinishedMessage();
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
                this.id_ = ShopMallHandler.MallItem.getDefaultInstance().getId();
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


            public boolean hasCode() {
                return ((this.bitField0_ & 0x2) == 2);
            }


            public String getCode() {
                Object ref = this.code_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.code_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }


            public ByteString getCodeBytes() {
                Object ref = this.code_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.code_ = b;
                    return b;
                }
                return (ByteString) ref;
            }


            public Builder setCode(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x2;
                this.code_ = value;
                onChanged();
                return this;
            }


            public Builder clearCode() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.code_ = ShopMallHandler.MallItem.getDefaultInstance().getCode();
                onChanged();
                return this;
            }


            public Builder setCodeBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x2;
                this.code_ = value;
                onChanged();
                return this;
            }


            public boolean hasGroupCount() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public int getGroupCount() {
                return this.groupCount_;
            }


            public Builder setGroupCount(int value) {
                this.bitField0_ |= 0x4;
                this.groupCount_ = value;
                onChanged();
                return this;
            }


            public Builder clearGroupCount() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.groupCount_ = 0;
                onChanged();
                return this;
            }


            public boolean hasOriginPrice() {
                return ((this.bitField0_ & 0x8) == 8);
            }


            public int getOriginPrice() {
                return this.originPrice_;
            }


            public Builder setOriginPrice(int value) {
                this.bitField0_ |= 0x8;
                this.originPrice_ = value;
                onChanged();
                return this;
            }


            public Builder clearOriginPrice() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.originPrice_ = 0;
                onChanged();
                return this;
            }


            public boolean hasNowPrice() {
                return ((this.bitField0_ & 0x10) == 16);
            }


            public int getNowPrice() {
                return this.nowPrice_;
            }


            public Builder setNowPrice(int value) {
                this.bitField0_ |= 0x10;
                this.nowPrice_ = value;
                onChanged();
                return this;
            }


            public Builder clearNowPrice() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.nowPrice_ = 0;
                onChanged();
                return this;
            }


            public boolean hasDisCount() {
                return ((this.bitField0_ & 0x20) == 32);
            }


            public int getDisCount() {
                return this.disCount_;
            }


            public Builder setDisCount(int value) {
                this.bitField0_ |= 0x20;
                this.disCount_ = value;
                onChanged();
                return this;
            }


            public Builder clearDisCount() {
                this.bitField0_ &= 0xFFFFFFDF;
                this.disCount_ = 0;
                onChanged();
                return this;
            }


            public boolean hasEndTime() {
                return ((this.bitField0_ & 0x40) == 64);
            }


            public int getEndTime() {
                return this.endTime_;
            }


            public Builder setEndTime(int value) {
                this.bitField0_ |= 0x40;
                this.endTime_ = value;
                onChanged();
                return this;
            }


            public Builder clearEndTime() {
                this.bitField0_ &= 0xFFFFFFBF;
                this.endTime_ = 0;
                onChanged();
                return this;
            }


            public boolean hasRemainNum() {
                return ((this.bitField0_ & 0x80) == 128);
            }


            public int getRemainNum() {
                return this.remainNum_;
            }


            public Builder setRemainNum(int value) {
                this.bitField0_ |= 0x80;
                this.remainNum_ = value;
                onChanged();
                return this;
            }


            public Builder clearRemainNum() {
                this.bitField0_ &= 0xFFFFFF7F;
                this.remainNum_ = 0;
                onChanged();
                return this;
            }


            public boolean hasConsumeScore() {
                return ((this.bitField0_ & 0x100) == 256);
            }


            public int getConsumeScore() {
                return this.consumeScore_;
            }


            public Builder setConsumeScore(int value) {
                this.bitField0_ |= 0x100;
                this.consumeScore_ = value;
                onChanged();
                return this;
            }


            public Builder clearConsumeScore() {
                this.bitField0_ &= 0xFFFFFEFF;
                this.consumeScore_ = 0;
                onChanged();
                return this;
            }


            public boolean hasBindType() {
                return ((this.bitField0_ & 0x200) == 512);
            }


            public int getBindType() {
                return this.bindType_;
            }


            public Builder setBindType(int value) {
                this.bitField0_ |= 0x200;
                this.bindType_ = value;
                onChanged();
                return this;
            }


            public Builder clearBindType() {
                this.bitField0_ &= 0xFFFFFDFF;
                this.bindType_ = 0;
                onChanged();
                return this;
            }


            public boolean hasCanSend() {
                return ((this.bitField0_ & 0x400) == 1024);
            }


            public int getCanSend() {
                return this.canSend_;
            }


            public Builder setCanSend(int value) {
                this.bitField0_ |= 0x400;
                this.canSend_ = value;
                onChanged();
                return this;
            }


            public Builder clearCanSend() {
                this.bitField0_ &= 0xFFFFFBFF;
                this.canSend_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class MallScoreItem
            extends GeneratedMessage
            implements MallScoreItemOrBuilder {
        private static final MallScoreItem defaultInstance = new MallScoreItem(true);
        private final UnknownFieldSet unknownFields;

        private MallScoreItem(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private MallScoreItem(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static MallScoreItem getDefaultInstance() {
            return defaultInstance;
        }

        public MallScoreItem getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MallScoreItem(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.code_ = bs;
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.groupCount_ = input.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.consumeScore_ = input.readInt32();
                            break;
                        case 40:
                            this.bitField0_ |= 0x10;
                            this.isSellOut_ = input.readInt32();
                            break;
                        case 48:
                            this.bitField0_ |= 0x20;
                            this.bindType_ = input.readInt32();
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
            return ShopMallHandler.internal_static_pomelo_area_MallScoreItem_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ShopMallHandler.internal_static_pomelo_area_MallScoreItem_fieldAccessorTable.ensureFieldAccessorsInitialized(MallScoreItem.class, Builder.class);
        }

        public static Parser<MallScoreItem> PARSER = (Parser<MallScoreItem>) new AbstractParser<MallScoreItem>() {
            public ShopMallHandler.MallScoreItem parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ShopMallHandler.MallScoreItem(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int ID_FIELD_NUMBER = 1;
        private Object id_;
        public static final int CODE_FIELD_NUMBER = 2;
        private Object code_;
        public static final int GROUPCOUNT_FIELD_NUMBER = 3;
        private int groupCount_;
        public static final int CONSUMESCORE_FIELD_NUMBER = 4;
        private int consumeScore_;
        public static final int ISSELLOUT_FIELD_NUMBER = 5;
        private int isSellOut_;
        public static final int BINDTYPE_FIELD_NUMBER = 6;
        private int bindType_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<MallScoreItem> getParserForType() {
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

        public boolean hasCode() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        static {
            defaultInstance.initFields();
        }

        public String getCode() {
            Object ref = this.code_;
            if (ref instanceof String)
                return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8())
                this.code_ = s;
            return s;
        }

        public ByteString getCodeBytes() {
            Object ref = this.code_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.code_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasGroupCount() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getGroupCount() {
            return this.groupCount_;
        }

        public boolean hasConsumeScore() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public int getConsumeScore() {
            return this.consumeScore_;
        }

        public boolean hasIsSellOut() {
            return ((this.bitField0_ & 0x10) == 16);
        }

        public int getIsSellOut() {
            return this.isSellOut_;
        }

        public boolean hasBindType() {
            return ((this.bitField0_ & 0x20) == 32);
        }

        public int getBindType() {
            return this.bindType_;
        }

        private void initFields() {
            this.id_ = "";
            this.code_ = "";
            this.groupCount_ = 0;
            this.consumeScore_ = 0;
            this.isSellOut_ = 0;
            this.bindType_ = 0;
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
            if (!hasCode()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasGroupCount()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasConsumeScore()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasIsSellOut()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasBindType()) {
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
                output.writeBytes(2, getCodeBytes());
            if ((this.bitField0_ & 0x4) == 4)
                output.writeInt32(3, this.groupCount_);
            if ((this.bitField0_ & 0x8) == 8)
                output.writeInt32(4, this.consumeScore_);
            if ((this.bitField0_ & 0x10) == 16)
                output.writeInt32(5, this.isSellOut_);
            if ((this.bitField0_ & 0x20) == 32)
                output.writeInt32(6, this.bindType_);
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
                size += CodedOutputStream.computeBytesSize(2, getCodeBytes());
            if ((this.bitField0_ & 0x4) == 4)
                size += CodedOutputStream.computeInt32Size(3, this.groupCount_);
            if ((this.bitField0_ & 0x8) == 8)
                size += CodedOutputStream.computeInt32Size(4, this.consumeScore_);
            if ((this.bitField0_ & 0x10) == 16)
                size += CodedOutputStream.computeInt32Size(5, this.isSellOut_);
            if ((this.bitField0_ & 0x20) == 32)
                size += CodedOutputStream.computeInt32Size(6, this.bindType_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static MallScoreItem parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (MallScoreItem) PARSER.parseFrom(data);
        }

        public static MallScoreItem parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MallScoreItem) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MallScoreItem parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (MallScoreItem) PARSER.parseFrom(data);
        }

        public static MallScoreItem parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MallScoreItem) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MallScoreItem parseFrom(InputStream input) throws IOException {
            return (MallScoreItem) PARSER.parseFrom(input);
        }

        public static MallScoreItem parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MallScoreItem) PARSER.parseFrom(input, extensionRegistry);
        }

        public static MallScoreItem parseDelimitedFrom(InputStream input) throws IOException {
            return (MallScoreItem) PARSER.parseDelimitedFrom(input);
        }

        public static MallScoreItem parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MallScoreItem) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static MallScoreItem parseFrom(CodedInputStream input) throws IOException {
            return (MallScoreItem) PARSER.parseFrom(input);
        }

        public static MallScoreItem parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MallScoreItem) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(MallScoreItem prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements ShopMallHandler.MallScoreItemOrBuilder {
            private int bitField0_;
            private Object id_;
            private Object code_;
            private int groupCount_;
            private int consumeScore_;
            private int isSellOut_;
            private int bindType_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ShopMallHandler.internal_static_pomelo_area_MallScoreItem_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return ShopMallHandler.internal_static_pomelo_area_MallScoreItem_fieldAccessorTable.ensureFieldAccessorsInitialized(ShopMallHandler.MallScoreItem.class, Builder.class);
            }

            private Builder() {
                this.id_ = "";
                this.code_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.id_ = "";
                this.code_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ShopMallHandler.MallScoreItem.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.id_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                this.code_ = "";
                this.bitField0_ &= 0xFFFFFFFD;
                this.groupCount_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.consumeScore_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                this.isSellOut_ = 0;
                this.bitField0_ &= 0xFFFFFFEF;
                this.bindType_ = 0;
                this.bitField0_ &= 0xFFFFFFDF;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return ShopMallHandler.internal_static_pomelo_area_MallScoreItem_descriptor;
            }

            public ShopMallHandler.MallScoreItem getDefaultInstanceForType() {
                return ShopMallHandler.MallScoreItem.getDefaultInstance();
            }

            public ShopMallHandler.MallScoreItem build() {
                ShopMallHandler.MallScoreItem result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public ShopMallHandler.MallScoreItem buildPartial() {
                ShopMallHandler.MallScoreItem result = new ShopMallHandler.MallScoreItem(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.id_ = this.id_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.code_ = this.code_;
                if ((from_bitField0_ & 0x4) == 4)
                    to_bitField0_ |= 0x4;
                result.groupCount_ = this.groupCount_;
                if ((from_bitField0_ & 0x8) == 8)
                    to_bitField0_ |= 0x8;
                result.consumeScore_ = this.consumeScore_;
                if ((from_bitField0_ & 0x10) == 16)
                    to_bitField0_ |= 0x10;
                result.isSellOut_ = this.isSellOut_;
                if ((from_bitField0_ & 0x20) == 32)
                    to_bitField0_ |= 0x20;
                result.bindType_ = this.bindType_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof ShopMallHandler.MallScoreItem)
                    return mergeFrom((ShopMallHandler.MallScoreItem) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ShopMallHandler.MallScoreItem other) {
                if (other == ShopMallHandler.MallScoreItem.getDefaultInstance())
                    return this;
                if (other.hasId()) {
                    this.bitField0_ |= 0x1;
                    this.id_ = other.id_;
                    onChanged();
                }
                if (other.hasCode()) {
                    this.bitField0_ |= 0x2;
                    this.code_ = other.code_;
                    onChanged();
                }
                if (other.hasGroupCount())
                    setGroupCount(other.getGroupCount());
                if (other.hasConsumeScore())
                    setConsumeScore(other.getConsumeScore());
                if (other.hasIsSellOut())
                    setIsSellOut(other.getIsSellOut());
                if (other.hasBindType())
                    setBindType(other.getBindType());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasId())
                    return false;
                if (!hasCode())
                    return false;
                if (!hasGroupCount())
                    return false;
                if (!hasConsumeScore())
                    return false;
                if (!hasIsSellOut())
                    return false;
                if (!hasBindType())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                ShopMallHandler.MallScoreItem parsedMessage = null;
                try {
                    parsedMessage = (ShopMallHandler.MallScoreItem) ShopMallHandler.MallScoreItem.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (ShopMallHandler.MallScoreItem) e.getUnfinishedMessage();
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
                this.id_ = ShopMallHandler.MallScoreItem.getDefaultInstance().getId();
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

            public boolean hasCode() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public String getCode() {
                Object ref = this.code_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.code_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getCodeBytes() {
                Object ref = this.code_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.code_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setCode(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x2;
                this.code_ = value;
                onChanged();
                return this;
            }

            public Builder clearCode() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.code_ = ShopMallHandler.MallScoreItem.getDefaultInstance().getCode();
                onChanged();
                return this;
            }

            public Builder setCodeBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x2;
                this.code_ = value;
                onChanged();
                return this;
            }

            public boolean hasGroupCount() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public int getGroupCount() {
                return this.groupCount_;
            }

            public Builder setGroupCount(int value) {
                this.bitField0_ |= 0x4;
                this.groupCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearGroupCount() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.groupCount_ = 0;
                onChanged();
                return this;
            }

            public boolean hasConsumeScore() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public int getConsumeScore() {
                return this.consumeScore_;
            }

            public Builder setConsumeScore(int value) {
                this.bitField0_ |= 0x8;
                this.consumeScore_ = value;
                onChanged();
                return this;
            }

            public Builder clearConsumeScore() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.consumeScore_ = 0;
                onChanged();
                return this;
            }

            public boolean hasIsSellOut() {
                return ((this.bitField0_ & 0x10) == 16);
            }

            public int getIsSellOut() {
                return this.isSellOut_;
            }

            public Builder setIsSellOut(int value) {
                this.bitField0_ |= 0x10;
                this.isSellOut_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsSellOut() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.isSellOut_ = 0;
                onChanged();
                return this;
            }

            public boolean hasBindType() {
                return ((this.bitField0_ & 0x20) == 32);
            }

            public int getBindType() {
                return this.bindType_;
            }

            public Builder setBindType(int value) {
                this.bitField0_ |= 0x20;
                this.bindType_ = value;
                onChanged();
                return this;
            }

            public Builder clearBindType() {
                this.bitField0_ &= 0xFFFFFFDF;
                this.bindType_ = 0;
                onChanged();
                return this;
            }
        }
    }

    public static final class GetMallItemListRequest extends GeneratedMessage implements GetMallItemListRequestOrBuilder {
        private static final GetMallItemListRequest defaultInstance = new GetMallItemListRequest(true);
        private final UnknownFieldSet unknownFields;

        private GetMallItemListRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetMallItemListRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetMallItemListRequest getDefaultInstance() {
            return defaultInstance;
        }

        public GetMallItemListRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetMallItemListRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.c2SMoneyType_ = input.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.c2SItemType_ = input.readInt32();
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
            return ShopMallHandler.internal_static_pomelo_area_GetMallItemListRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ShopMallHandler.internal_static_pomelo_area_GetMallItemListRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetMallItemListRequest.class, Builder.class);
        }

        public static Parser<GetMallItemListRequest> PARSER = (Parser<GetMallItemListRequest>) new AbstractParser<GetMallItemListRequest>() {
            public ShopMallHandler.GetMallItemListRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ShopMallHandler.GetMallItemListRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_MONEYTYPE_FIELD_NUMBER = 1;
        private int c2SMoneyType_;
        public static final int C2S_ITEMTYPE_FIELD_NUMBER = 2;
        private int c2SItemType_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetMallItemListRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasC2SMoneyType() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getC2SMoneyType() {
            return this.c2SMoneyType_;
        }

        public boolean hasC2SItemType() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        static {
            defaultInstance.initFields();
        }


        public int getC2SItemType() {
            return this.c2SItemType_;
        }


        private void initFields() {
            this.c2SMoneyType_ = 0;
            this.c2SItemType_ = 0;
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasC2SItemType()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeInt32(1, this.c2SMoneyType_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeInt32(2, this.c2SItemType_);
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
                size += CodedOutputStream.computeInt32Size(1, this.c2SMoneyType_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeInt32Size(2, this.c2SItemType_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static GetMallItemListRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetMallItemListRequest) PARSER.parseFrom(data);
        }


        public static GetMallItemListRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetMallItemListRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetMallItemListRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetMallItemListRequest) PARSER.parseFrom(data);
        }


        public static GetMallItemListRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetMallItemListRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetMallItemListRequest parseFrom(InputStream input) throws IOException {
            return (GetMallItemListRequest) PARSER.parseFrom(input);
        }


        public static GetMallItemListRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetMallItemListRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static GetMallItemListRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (GetMallItemListRequest) PARSER.parseDelimitedFrom(input);
        }


        public static GetMallItemListRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetMallItemListRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static GetMallItemListRequest parseFrom(CodedInputStream input) throws IOException {
            return (GetMallItemListRequest) PARSER.parseFrom(input);
        }


        public static GetMallItemListRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetMallItemListRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(GetMallItemListRequest prototype) {
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
                implements ShopMallHandler.GetMallItemListRequestOrBuilder {
            private int bitField0_;


            private int c2SMoneyType_;


            private int c2SItemType_;


            public static final Descriptors.Descriptor getDescriptor() {
                return ShopMallHandler.internal_static_pomelo_area_GetMallItemListRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return ShopMallHandler.internal_static_pomelo_area_GetMallItemListRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ShopMallHandler.GetMallItemListRequest.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (ShopMallHandler.GetMallItemListRequest.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.c2SMoneyType_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SItemType_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return ShopMallHandler.internal_static_pomelo_area_GetMallItemListRequest_descriptor;
            }


            public ShopMallHandler.GetMallItemListRequest getDefaultInstanceForType() {
                return ShopMallHandler.GetMallItemListRequest.getDefaultInstance();
            }


            public ShopMallHandler.GetMallItemListRequest build() {
                ShopMallHandler.GetMallItemListRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public ShopMallHandler.GetMallItemListRequest buildPartial() {
                ShopMallHandler.GetMallItemListRequest result = new ShopMallHandler.GetMallItemListRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.c2SMoneyType_ = this.c2SMoneyType_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.c2SItemType_ = this.c2SItemType_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof ShopMallHandler.GetMallItemListRequest) {
                    return mergeFrom((ShopMallHandler.GetMallItemListRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(ShopMallHandler.GetMallItemListRequest other) {
                if (other == ShopMallHandler.GetMallItemListRequest.getDefaultInstance()) {
                    return this;
                }
                if (other.hasC2SMoneyType()) {
                    setC2SMoneyType(other.getC2SMoneyType());
                }
                if (other.hasC2SItemType()) {
                    setC2SItemType(other.getC2SItemType());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasC2SItemType()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                ShopMallHandler.GetMallItemListRequest parsedMessage = null;
                try {
                    parsedMessage = (ShopMallHandler.GetMallItemListRequest) ShopMallHandler.GetMallItemListRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (ShopMallHandler.GetMallItemListRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasC2SMoneyType() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public int getC2SMoneyType() {
                return this.c2SMoneyType_;
            }


            public Builder setC2SMoneyType(int value) {
                this.bitField0_ |= 0x1;
                this.c2SMoneyType_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SMoneyType() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SMoneyType_ = 0;
                onChanged();
                return this;
            }


            public boolean hasC2SItemType() {
                return ((this.bitField0_ & 0x2) == 2);
            }


            public int getC2SItemType() {
                return this.c2SItemType_;
            }


            public Builder setC2SItemType(int value) {
                this.bitField0_ |= 0x2;
                this.c2SItemType_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SItemType() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.c2SItemType_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class GetMallItemListResponse
            extends GeneratedMessage
            implements GetMallItemListResponseOrBuilder {
        private static final GetMallItemListResponse defaultInstance = new GetMallItemListResponse(true);
        private final UnknownFieldSet unknownFields;

        private GetMallItemListResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetMallItemListResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetMallItemListResponse getDefaultInstance() {
            return defaultInstance;
        }

        public GetMallItemListResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetMallItemListResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.s2CEndTime_ = input.readInt32();
                            break;
                        case 34:
                            if ((mutable_bitField0_ & 0x8) != 8) {
                                this.s2CItems_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x8;
                            }
                            this.s2CItems_.add(input.readMessage(ShopMallHandler.MallItem.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x8) == 8) this.s2CItems_ = Collections.unmodifiableList(this.s2CItems_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ShopMallHandler.internal_static_pomelo_area_GetMallItemListResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ShopMallHandler.internal_static_pomelo_area_GetMallItemListResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetMallItemListResponse.class, Builder.class);
        }

        public static Parser<GetMallItemListResponse> PARSER = (Parser<GetMallItemListResponse>) new AbstractParser<GetMallItemListResponse>() {
            public ShopMallHandler.GetMallItemListResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ShopMallHandler.GetMallItemListResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_ENDTIME_FIELD_NUMBER = 3;
        private int s2CEndTime_;
        public static final int S2C_ITEMS_FIELD_NUMBER = 4;
        private List<ShopMallHandler.MallItem> s2CItems_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetMallItemListResponse> getParserForType() {
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


        public boolean hasS2CEndTime() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public int getS2CEndTime() {
            return this.s2CEndTime_;
        }


        public List<ShopMallHandler.MallItem> getS2CItemsList() {
            return this.s2CItems_;
        }


        public List<? extends ShopMallHandler.MallItemOrBuilder> getS2CItemsOrBuilderList() {
            return (List) this.s2CItems_;
        }


        public int getS2CItemsCount() {
            return this.s2CItems_.size();
        }


        public ShopMallHandler.MallItem getS2CItems(int index) {
            return this.s2CItems_.get(index);
        }


        public ShopMallHandler.MallItemOrBuilder getS2CItemsOrBuilder(int index) {
            return this.s2CItems_.get(index);
        }


        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CEndTime_ = 0;
            this.s2CItems_ = Collections.emptyList();
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
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeInt32(1, this.s2CCode_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeBytes(2, getS2CMsgBytes());
            }
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeInt32(3, this.s2CEndTime_);
            }
            for (int i = 0; i < this.s2CItems_.size(); i++) {
                output.writeMessage(4, (MessageLite) this.s2CItems_.get(i));
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
                size += CodedOutputStream.computeInt32Size(3, this.s2CEndTime_);
            }
            for (int i = 0; i < this.s2CItems_.size(); i++) {
                size += CodedOutputStream.computeMessageSize(4, (MessageLite) this.s2CItems_.get(i));
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static GetMallItemListResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetMallItemListResponse) PARSER.parseFrom(data);
        }


        public static GetMallItemListResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetMallItemListResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetMallItemListResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetMallItemListResponse) PARSER.parseFrom(data);
        }


        public static GetMallItemListResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetMallItemListResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetMallItemListResponse parseFrom(InputStream input) throws IOException {
            return (GetMallItemListResponse) PARSER.parseFrom(input);
        }


        public static GetMallItemListResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetMallItemListResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static GetMallItemListResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (GetMallItemListResponse) PARSER.parseDelimitedFrom(input);
        }


        public static GetMallItemListResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetMallItemListResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static GetMallItemListResponse parseFrom(CodedInputStream input) throws IOException {
            return (GetMallItemListResponse) PARSER.parseFrom(input);
        }


        public static GetMallItemListResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetMallItemListResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(GetMallItemListResponse prototype) {
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
                implements ShopMallHandler.GetMallItemListResponseOrBuilder {
            private int bitField0_;


            private int s2CCode_;


            private Object s2CMsg_;


            private int s2CEndTime_;


            private List<ShopMallHandler.MallItem> s2CItems_;


            private RepeatedFieldBuilder<ShopMallHandler.MallItem, ShopMallHandler.MallItem.Builder, ShopMallHandler.MallItemOrBuilder> s2CItemsBuilder_;


            public static final Descriptors.Descriptor getDescriptor() {
                return ShopMallHandler.internal_static_pomelo_area_GetMallItemListResponse_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return ShopMallHandler.internal_static_pomelo_area_GetMallItemListResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ShopMallHandler.GetMallItemListResponse.class, Builder.class);
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
                if (ShopMallHandler.GetMallItemListResponse.alwaysUseFieldBuilders) {
                    getS2CItemsFieldBuilder();
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
                this.s2CEndTime_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                if (this.s2CItemsBuilder_ == null) {
                    this.s2CItems_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFF7;
                } else {
                    this.s2CItemsBuilder_.clear();
                }
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return ShopMallHandler.internal_static_pomelo_area_GetMallItemListResponse_descriptor;
            }


            public ShopMallHandler.GetMallItemListResponse getDefaultInstanceForType() {
                return ShopMallHandler.GetMallItemListResponse.getDefaultInstance();
            }


            public ShopMallHandler.GetMallItemListResponse build() {
                ShopMallHandler.GetMallItemListResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public ShopMallHandler.GetMallItemListResponse buildPartial() {
                ShopMallHandler.GetMallItemListResponse result = new ShopMallHandler.GetMallItemListResponse(this);
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
                result.s2CEndTime_ = this.s2CEndTime_;
                if (this.s2CItemsBuilder_ == null) {
                    if ((this.bitField0_ & 0x8) == 8) {
                        this.s2CItems_ = Collections.unmodifiableList(this.s2CItems_);
                        this.bitField0_ &= 0xFFFFFFF7;
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
                if (other instanceof ShopMallHandler.GetMallItemListResponse) {
                    return mergeFrom((ShopMallHandler.GetMallItemListResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(ShopMallHandler.GetMallItemListResponse other) {
                if (other == ShopMallHandler.GetMallItemListResponse.getDefaultInstance()) {
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
                if (other.hasS2CEndTime()) {
                    setS2CEndTime(other.getS2CEndTime());
                }
                if (this.s2CItemsBuilder_ == null) {
                    if (!other.s2CItems_.isEmpty()) {
                        if (this.s2CItems_.isEmpty()) {
                            this.s2CItems_ = other.s2CItems_;
                            this.bitField0_ &= 0xFFFFFFF7;
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
                        this.bitField0_ &= 0xFFFFFFF7;
                        this.s2CItemsBuilder_ = ShopMallHandler.GetMallItemListResponse.alwaysUseFieldBuilders ? getS2CItemsFieldBuilder() : null;
                    } else {
                        this.s2CItemsBuilder_.addAllMessages(other.s2CItems_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasS2CCode()) {
                    return false;
                }
                for (int i = 0; i < getS2CItemsCount(); i++) {
                    if (!getS2CItems(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                ShopMallHandler.GetMallItemListResponse parsedMessage = null;
                try {
                    parsedMessage = (ShopMallHandler.GetMallItemListResponse) ShopMallHandler.GetMallItemListResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (ShopMallHandler.GetMallItemListResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = ShopMallHandler.GetMallItemListResponse.getDefaultInstance().getS2CMsg();
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


            public boolean hasS2CEndTime() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public int getS2CEndTime() {
                return this.s2CEndTime_;
            }


            public Builder setS2CEndTime(int value) {
                this.bitField0_ |= 0x4;
                this.s2CEndTime_ = value;
                onChanged();
                return this;
            }


            public Builder clearS2CEndTime() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.s2CEndTime_ = 0;
                onChanged();
                return this;
            }


            private void ensureS2CItemsIsMutable() {
                if ((this.bitField0_ & 0x8) != 8) {
                    this.s2CItems_ = new ArrayList<>(this.s2CItems_);
                    this.bitField0_ |= 0x8;
                }
            }


            public List<ShopMallHandler.MallItem> getS2CItemsList() {
                if (this.s2CItemsBuilder_ == null) {
                    return Collections.unmodifiableList(this.s2CItems_);
                }
                return this.s2CItemsBuilder_.getMessageList();
            }


            public int getS2CItemsCount() {
                if (this.s2CItemsBuilder_ == null) {
                    return this.s2CItems_.size();
                }
                return this.s2CItemsBuilder_.getCount();
            }


            public ShopMallHandler.MallItem getS2CItems(int index) {
                if (this.s2CItemsBuilder_ == null) {
                    return this.s2CItems_.get(index);
                }
                return (ShopMallHandler.MallItem) this.s2CItemsBuilder_.getMessage(index);
            }


            public Builder setS2CItems(int index, ShopMallHandler.MallItem value) {
                if (this.s2CItemsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureS2CItemsIsMutable();
                    this.s2CItems_.set(index, value);
                    onChanged();
                } else {
                    this.s2CItemsBuilder_.setMessage(index, value);
                }
                return this;
            }


            public Builder setS2CItems(int index, ShopMallHandler.MallItem.Builder builderForValue) {
                if (this.s2CItemsBuilder_ == null) {
                    ensureS2CItemsIsMutable();
                    this.s2CItems_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CItemsBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }


            public Builder addS2CItems(ShopMallHandler.MallItem value) {
                if (this.s2CItemsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureS2CItemsIsMutable();
                    this.s2CItems_.add(value);
                    onChanged();
                } else {
                    this.s2CItemsBuilder_.addMessage(value);
                }
                return this;
            }


            public Builder addS2CItems(int index, ShopMallHandler.MallItem value) {
                if (this.s2CItemsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureS2CItemsIsMutable();
                    this.s2CItems_.add(index, value);
                    onChanged();
                } else {
                    this.s2CItemsBuilder_.addMessage(index, value);
                }
                return this;
            }


            public Builder addS2CItems(ShopMallHandler.MallItem.Builder builderForValue) {
                if (this.s2CItemsBuilder_ == null) {
                    ensureS2CItemsIsMutable();
                    this.s2CItems_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.s2CItemsBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }


            public Builder addS2CItems(int index, ShopMallHandler.MallItem.Builder builderForValue) {
                if (this.s2CItemsBuilder_ == null) {
                    ensureS2CItemsIsMutable();
                    this.s2CItems_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CItemsBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }


            public Builder addAllS2CItems(Iterable<? extends ShopMallHandler.MallItem> values) {
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
                    this.bitField0_ &= 0xFFFFFFF7;
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


            public ShopMallHandler.MallItem.Builder getS2CItemsBuilder(int index) {
                return (ShopMallHandler.MallItem.Builder) getS2CItemsFieldBuilder().getBuilder(index);
            }


            public ShopMallHandler.MallItemOrBuilder getS2CItemsOrBuilder(int index) {
                if (this.s2CItemsBuilder_ == null) {
                    return this.s2CItems_.get(index);
                }
                return (ShopMallHandler.MallItemOrBuilder) this.s2CItemsBuilder_.getMessageOrBuilder(index);
            }


            public List<? extends ShopMallHandler.MallItemOrBuilder> getS2CItemsOrBuilderList() {
                if (this.s2CItemsBuilder_ != null) {
                    return this.s2CItemsBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList((List) this.s2CItems_);
            }


            public ShopMallHandler.MallItem.Builder addS2CItemsBuilder() {
                return (ShopMallHandler.MallItem.Builder) getS2CItemsFieldBuilder().addBuilder(ShopMallHandler.MallItem.getDefaultInstance());
            }


            public ShopMallHandler.MallItem.Builder addS2CItemsBuilder(int index) {
                return (ShopMallHandler.MallItem.Builder) getS2CItemsFieldBuilder().addBuilder(index, ShopMallHandler.MallItem.getDefaultInstance());
            }


            public List<ShopMallHandler.MallItem.Builder> getS2CItemsBuilderList() {
                return getS2CItemsFieldBuilder().getBuilderList();
            }


            private RepeatedFieldBuilder<ShopMallHandler.MallItem, ShopMallHandler.MallItem.Builder, ShopMallHandler.MallItemOrBuilder> getS2CItemsFieldBuilder() {
                if (this.s2CItemsBuilder_ == null) {
                    this.s2CItemsBuilder_ = new RepeatedFieldBuilder(this.s2CItems_, ((this.bitField0_ & 0x8) == 8), getParentForChildren(), isClean());
                    this.s2CItems_ = null;
                }
                return this.s2CItemsBuilder_;
            }
        }
    }


    public static final class BuyMallItemRequest
            extends GeneratedMessage
            implements BuyMallItemRequestOrBuilder {
        private static final BuyMallItemRequest defaultInstance = new BuyMallItemRequest(true);
        private final UnknownFieldSet unknownFields;

        private BuyMallItemRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private BuyMallItemRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static BuyMallItemRequest getDefaultInstance() {
            return defaultInstance;
        }

        public BuyMallItemRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BuyMallItemRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.c2SItemId_ = bs;
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.c2SCount_ = input.readInt32();
                            break;
                        case 26:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x4;
                            this.c2SPlayerId_ = bs;
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.c2SBDiamond_ = input.readInt32();
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
            return ShopMallHandler.internal_static_pomelo_area_BuyMallItemRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ShopMallHandler.internal_static_pomelo_area_BuyMallItemRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(BuyMallItemRequest.class, Builder.class);
        }

        public static Parser<BuyMallItemRequest> PARSER = (Parser<BuyMallItemRequest>) new AbstractParser<BuyMallItemRequest>() {
            public ShopMallHandler.BuyMallItemRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ShopMallHandler.BuyMallItemRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_ITEMID_FIELD_NUMBER = 1;
        private Object c2SItemId_;
        public static final int C2S_COUNT_FIELD_NUMBER = 2;
        private int c2SCount_;
        public static final int C2S_PLAYERID_FIELD_NUMBER = 3;
        private Object c2SPlayerId_;
        public static final int C2S_BDIAMOND_FIELD_NUMBER = 4;
        private int c2SBDiamond_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<BuyMallItemRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasC2SItemId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public String getC2SItemId() {
            Object ref = this.c2SItemId_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.c2SItemId_ = s;
            return s;
        }

        public ByteString getC2SItemIdBytes() {
            Object ref = this.c2SItemId_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.c2SItemId_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasC2SCount() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        static {
            defaultInstance.initFields();
        }


        public int getC2SCount() {
            return this.c2SCount_;
        }


        public boolean hasC2SPlayerId() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public String getC2SPlayerId() {
            Object ref = this.c2SPlayerId_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.c2SPlayerId_ = s;
            }
            return s;
        }


        public ByteString getC2SPlayerIdBytes() {
            Object ref = this.c2SPlayerId_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.c2SPlayerId_ = b;
                return b;
            }
            return (ByteString) ref;
        }


        public boolean hasC2SBDiamond() {
            return ((this.bitField0_ & 0x8) == 8);
        }


        public int getC2SBDiamond() {
            return this.c2SBDiamond_;
        }


        private void initFields() {
            this.c2SItemId_ = "";
            this.c2SCount_ = 0;
            this.c2SPlayerId_ = "";
            this.c2SBDiamond_ = 0;
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasC2SItemId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasC2SCount()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasC2SPlayerId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasC2SBDiamond()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeBytes(1, getC2SItemIdBytes());
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeInt32(2, this.c2SCount_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeBytes(3, getC2SPlayerIdBytes());
            }
            if ((this.bitField0_ & 0x8) == 8) {
                output.writeInt32(4, this.c2SBDiamond_);
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
                size += CodedOutputStream.computeBytesSize(1, getC2SItemIdBytes());
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeInt32Size(2, this.c2SCount_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                size += CodedOutputStream.computeBytesSize(3, getC2SPlayerIdBytes());
            }
            if ((this.bitField0_ & 0x8) == 8) {
                size += CodedOutputStream.computeInt32Size(4, this.c2SBDiamond_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static BuyMallItemRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (BuyMallItemRequest) PARSER.parseFrom(data);
        }


        public static BuyMallItemRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BuyMallItemRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static BuyMallItemRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (BuyMallItemRequest) PARSER.parseFrom(data);
        }


        public static BuyMallItemRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BuyMallItemRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static BuyMallItemRequest parseFrom(InputStream input) throws IOException {
            return (BuyMallItemRequest) PARSER.parseFrom(input);
        }


        public static BuyMallItemRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuyMallItemRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static BuyMallItemRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (BuyMallItemRequest) PARSER.parseDelimitedFrom(input);
        }


        public static BuyMallItemRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuyMallItemRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static BuyMallItemRequest parseFrom(CodedInputStream input) throws IOException {
            return (BuyMallItemRequest) PARSER.parseFrom(input);
        }


        public static BuyMallItemRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuyMallItemRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(BuyMallItemRequest prototype) {
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
                implements ShopMallHandler.BuyMallItemRequestOrBuilder {
            private int bitField0_;


            private Object c2SItemId_;


            private int c2SCount_;


            private Object c2SPlayerId_;


            private int c2SBDiamond_;


            public static final Descriptors.Descriptor getDescriptor() {
                return ShopMallHandler.internal_static_pomelo_area_BuyMallItemRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return ShopMallHandler.internal_static_pomelo_area_BuyMallItemRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ShopMallHandler.BuyMallItemRequest.class, Builder.class);
            }


            private Builder() {
                this.c2SItemId_ = "";
                this.c2SPlayerId_ = "";
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.c2SItemId_ = "";
                this.c2SPlayerId_ = "";
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (ShopMallHandler.BuyMallItemRequest.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.c2SItemId_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SCount_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                this.c2SPlayerId_ = "";
                this.bitField0_ &= 0xFFFFFFFB;
                this.c2SBDiamond_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return ShopMallHandler.internal_static_pomelo_area_BuyMallItemRequest_descriptor;
            }


            public ShopMallHandler.BuyMallItemRequest getDefaultInstanceForType() {
                return ShopMallHandler.BuyMallItemRequest.getDefaultInstance();
            }


            public ShopMallHandler.BuyMallItemRequest build() {
                ShopMallHandler.BuyMallItemRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public ShopMallHandler.BuyMallItemRequest buildPartial() {
                ShopMallHandler.BuyMallItemRequest result = new ShopMallHandler.BuyMallItemRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.c2SItemId_ = this.c2SItemId_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.c2SCount_ = this.c2SCount_;
                if ((from_bitField0_ & 0x4) == 4) {
                    to_bitField0_ |= 0x4;
                }
                result.c2SPlayerId_ = this.c2SPlayerId_;
                if ((from_bitField0_ & 0x8) == 8) {
                    to_bitField0_ |= 0x8;
                }
                result.c2SBDiamond_ = this.c2SBDiamond_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof ShopMallHandler.BuyMallItemRequest) {
                    return mergeFrom((ShopMallHandler.BuyMallItemRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(ShopMallHandler.BuyMallItemRequest other) {
                if (other == ShopMallHandler.BuyMallItemRequest.getDefaultInstance()) {
                    return this;
                }
                if (other.hasC2SItemId()) {
                    this.bitField0_ |= 0x1;
                    this.c2SItemId_ = other.c2SItemId_;
                    onChanged();
                }
                if (other.hasC2SCount()) {
                    setC2SCount(other.getC2SCount());
                }
                if (other.hasC2SPlayerId()) {
                    this.bitField0_ |= 0x4;
                    this.c2SPlayerId_ = other.c2SPlayerId_;
                    onChanged();
                }
                if (other.hasC2SBDiamond()) {
                    setC2SBDiamond(other.getC2SBDiamond());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasC2SItemId()) {
                    return false;
                }
                if (!hasC2SCount()) {
                    return false;
                }
                if (!hasC2SPlayerId()) {
                    return false;
                }
                if (!hasC2SBDiamond()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                ShopMallHandler.BuyMallItemRequest parsedMessage = null;
                try {
                    parsedMessage = (ShopMallHandler.BuyMallItemRequest) ShopMallHandler.BuyMallItemRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (ShopMallHandler.BuyMallItemRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasC2SItemId() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public String getC2SItemId() {
                Object ref = this.c2SItemId_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.c2SItemId_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }


            public ByteString getC2SItemIdBytes() {
                Object ref = this.c2SItemId_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.c2SItemId_ = b;
                    return b;
                }
                return (ByteString) ref;
            }


            public Builder setC2SItemId(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x1;
                this.c2SItemId_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SItemId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SItemId_ = ShopMallHandler.BuyMallItemRequest.getDefaultInstance().getC2SItemId();
                onChanged();
                return this;
            }


            public Builder setC2SItemIdBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x1;
                this.c2SItemId_ = value;
                onChanged();
                return this;
            }


            public boolean hasC2SCount() {
                return ((this.bitField0_ & 0x2) == 2);
            }


            public int getC2SCount() {
                return this.c2SCount_;
            }


            public Builder setC2SCount(int value) {
                this.bitField0_ |= 0x2;
                this.c2SCount_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SCount() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.c2SCount_ = 0;
                onChanged();
                return this;
            }


            public boolean hasC2SPlayerId() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public String getC2SPlayerId() {
                Object ref = this.c2SPlayerId_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.c2SPlayerId_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }


            public ByteString getC2SPlayerIdBytes() {
                Object ref = this.c2SPlayerId_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.c2SPlayerId_ = b;
                    return b;
                }
                return (ByteString) ref;
            }


            public Builder setC2SPlayerId(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x4;
                this.c2SPlayerId_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SPlayerId() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.c2SPlayerId_ = ShopMallHandler.BuyMallItemRequest.getDefaultInstance().getC2SPlayerId();
                onChanged();
                return this;
            }


            public Builder setC2SPlayerIdBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x4;
                this.c2SPlayerId_ = value;
                onChanged();
                return this;
            }


            public boolean hasC2SBDiamond() {
                return ((this.bitField0_ & 0x8) == 8);
            }


            public int getC2SBDiamond() {
                return this.c2SBDiamond_;
            }


            public Builder setC2SBDiamond(int value) {
                this.bitField0_ |= 0x8;
                this.c2SBDiamond_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SBDiamond() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.c2SBDiamond_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class BuyMallItemResponse
            extends GeneratedMessage
            implements BuyMallItemResponseOrBuilder {
        private static final BuyMallItemResponse defaultInstance = new BuyMallItemResponse(true);
        private final UnknownFieldSet unknownFields;

        private BuyMallItemResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private BuyMallItemResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static BuyMallItemResponse getDefaultInstance() {
            return defaultInstance;
        }

        public BuyMallItemResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BuyMallItemResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.totalNum_ = input.readInt32();
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
            return ShopMallHandler.internal_static_pomelo_area_BuyMallItemResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ShopMallHandler.internal_static_pomelo_area_BuyMallItemResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(BuyMallItemResponse.class, Builder.class);
        }

        public static Parser<BuyMallItemResponse> PARSER = (Parser<BuyMallItemResponse>) new AbstractParser<BuyMallItemResponse>() {
            public ShopMallHandler.BuyMallItemResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ShopMallHandler.BuyMallItemResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int TOTAL_NUM_FIELD_NUMBER = 3;
        private int totalNum_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<BuyMallItemResponse> getParserForType() {
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

        public boolean hasTotalNum() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getTotalNum() {
            return this.totalNum_;
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.totalNum_ = 0;
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
                output.writeInt32(3, this.totalNum_);
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
                size += CodedOutputStream.computeInt32Size(3, this.totalNum_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static BuyMallItemResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (BuyMallItemResponse) PARSER.parseFrom(data);
        }

        public static BuyMallItemResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BuyMallItemResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static BuyMallItemResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (BuyMallItemResponse) PARSER.parseFrom(data);
        }

        public static BuyMallItemResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BuyMallItemResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static BuyMallItemResponse parseFrom(InputStream input) throws IOException {
            return (BuyMallItemResponse) PARSER.parseFrom(input);
        }

        public static BuyMallItemResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuyMallItemResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static BuyMallItemResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (BuyMallItemResponse) PARSER.parseDelimitedFrom(input);
        }

        public static BuyMallItemResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuyMallItemResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static BuyMallItemResponse parseFrom(CodedInputStream input) throws IOException {
            return (BuyMallItemResponse) PARSER.parseFrom(input);
        }

        public static BuyMallItemResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuyMallItemResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(BuyMallItemResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements ShopMallHandler.BuyMallItemResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private int totalNum_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ShopMallHandler.internal_static_pomelo_area_BuyMallItemResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return ShopMallHandler.internal_static_pomelo_area_BuyMallItemResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ShopMallHandler.BuyMallItemResponse.class, Builder.class);
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
                if (ShopMallHandler.BuyMallItemResponse.alwaysUseFieldBuilders) ;
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
                this.totalNum_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return ShopMallHandler.internal_static_pomelo_area_BuyMallItemResponse_descriptor;
            }

            public ShopMallHandler.BuyMallItemResponse getDefaultInstanceForType() {
                return ShopMallHandler.BuyMallItemResponse.getDefaultInstance();
            }

            public ShopMallHandler.BuyMallItemResponse build() {
                ShopMallHandler.BuyMallItemResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public ShopMallHandler.BuyMallItemResponse buildPartial() {
                ShopMallHandler.BuyMallItemResponse result = new ShopMallHandler.BuyMallItemResponse(this);
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
                result.totalNum_ = this.totalNum_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof ShopMallHandler.BuyMallItemResponse)
                    return mergeFrom((ShopMallHandler.BuyMallItemResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ShopMallHandler.BuyMallItemResponse other) {
                if (other == ShopMallHandler.BuyMallItemResponse.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (other.hasTotalNum())
                    setTotalNum(other.getTotalNum());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                ShopMallHandler.BuyMallItemResponse parsedMessage = null;
                try {
                    parsedMessage = (ShopMallHandler.BuyMallItemResponse) ShopMallHandler.BuyMallItemResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (ShopMallHandler.BuyMallItemResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = ShopMallHandler.BuyMallItemResponse.getDefaultInstance().getS2CMsg();
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

            public boolean hasTotalNum() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public int getTotalNum() {
                return this.totalNum_;
            }

            public Builder setTotalNum(int value) {
                this.bitField0_ |= 0x4;
                this.totalNum_ = value;
                onChanged();
                return this;
            }

            public Builder clearTotalNum() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.totalNum_ = 0;
                onChanged();
                return this;
            }
        }
    }

    public static final class GetMallScoreItemListRequest extends GeneratedMessage implements GetMallScoreItemListRequestOrBuilder {
        private static final GetMallScoreItemListRequest defaultInstance = new GetMallScoreItemListRequest(true);
        private final UnknownFieldSet unknownFields;

        private GetMallScoreItemListRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetMallScoreItemListRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetMallScoreItemListRequest getDefaultInstance() {
            return defaultInstance;
        }

        public GetMallScoreItemListRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetMallScoreItemListRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return ShopMallHandler.internal_static_pomelo_area_GetMallScoreItemListRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ShopMallHandler.internal_static_pomelo_area_GetMallScoreItemListRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetMallScoreItemListRequest.class, Builder.class);
        }

        public static Parser<GetMallScoreItemListRequest> PARSER = (Parser<GetMallScoreItemListRequest>) new AbstractParser<GetMallScoreItemListRequest>() {
            public ShopMallHandler.GetMallScoreItemListRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ShopMallHandler.GetMallScoreItemListRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetMallScoreItemListRequest> getParserForType() {
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

        public static GetMallScoreItemListRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetMallScoreItemListRequest) PARSER.parseFrom(data);
        }

        public static GetMallScoreItemListRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetMallScoreItemListRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetMallScoreItemListRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetMallScoreItemListRequest) PARSER.parseFrom(data);
        }

        public static GetMallScoreItemListRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetMallScoreItemListRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetMallScoreItemListRequest parseFrom(InputStream input) throws IOException {
            return (GetMallScoreItemListRequest) PARSER.parseFrom(input);
        }

        public static GetMallScoreItemListRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetMallScoreItemListRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static GetMallScoreItemListRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (GetMallScoreItemListRequest) PARSER.parseDelimitedFrom(input);
        }

        public static GetMallScoreItemListRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetMallScoreItemListRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static GetMallScoreItemListRequest parseFrom(CodedInputStream input) throws IOException {
            return (GetMallScoreItemListRequest) PARSER.parseFrom(input);
        }

        public static GetMallScoreItemListRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetMallScoreItemListRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(GetMallScoreItemListRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements ShopMallHandler.GetMallScoreItemListRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return ShopMallHandler.internal_static_pomelo_area_GetMallScoreItemListRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return ShopMallHandler.internal_static_pomelo_area_GetMallScoreItemListRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ShopMallHandler.GetMallScoreItemListRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ShopMallHandler.GetMallScoreItemListRequest.alwaysUseFieldBuilders) ;
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
                return ShopMallHandler.internal_static_pomelo_area_GetMallScoreItemListRequest_descriptor;
            }

            public ShopMallHandler.GetMallScoreItemListRequest getDefaultInstanceForType() {
                return ShopMallHandler.GetMallScoreItemListRequest.getDefaultInstance();
            }

            public ShopMallHandler.GetMallScoreItemListRequest build() {
                ShopMallHandler.GetMallScoreItemListRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public ShopMallHandler.GetMallScoreItemListRequest buildPartial() {
                ShopMallHandler.GetMallScoreItemListRequest result = new ShopMallHandler.GetMallScoreItemListRequest(this);
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof ShopMallHandler.GetMallScoreItemListRequest)
                    return mergeFrom((ShopMallHandler.GetMallScoreItemListRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ShopMallHandler.GetMallScoreItemListRequest other) {
                if (other == ShopMallHandler.GetMallScoreItemListRequest.getDefaultInstance()) return this;
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                ShopMallHandler.GetMallScoreItemListRequest parsedMessage = null;
                try {
                    parsedMessage = (ShopMallHandler.GetMallScoreItemListRequest) ShopMallHandler.GetMallScoreItemListRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (ShopMallHandler.GetMallScoreItemListRequest) e.getUnfinishedMessage();
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


    public static final class GetMallScoreItemListResponse
            extends GeneratedMessage
            implements GetMallScoreItemListResponseOrBuilder {
        private static final GetMallScoreItemListResponse defaultInstance = new GetMallScoreItemListResponse(true);
        private final UnknownFieldSet unknownFields;

        private GetMallScoreItemListResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetMallScoreItemListResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetMallScoreItemListResponse getDefaultInstance() {
            return defaultInstance;
        }

        public GetMallScoreItemListResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetMallScoreItemListResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.s2CItems_.add(input.readMessage(ShopMallHandler.MallScoreItem.PARSER, extensionRegistry));
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
            return ShopMallHandler.internal_static_pomelo_area_GetMallScoreItemListResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ShopMallHandler.internal_static_pomelo_area_GetMallScoreItemListResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetMallScoreItemListResponse.class, Builder.class);
        }

        public static Parser<GetMallScoreItemListResponse> PARSER = (Parser<GetMallScoreItemListResponse>) new AbstractParser<GetMallScoreItemListResponse>() {
            public ShopMallHandler.GetMallScoreItemListResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ShopMallHandler.GetMallScoreItemListResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_ITEMS_FIELD_NUMBER = 3;
        private List<ShopMallHandler.MallScoreItem> s2CItems_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetMallScoreItemListResponse> getParserForType() {
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

        public List<ShopMallHandler.MallScoreItem> getS2CItemsList() {
            return this.s2CItems_;
        }

        public List<? extends ShopMallHandler.MallScoreItemOrBuilder> getS2CItemsOrBuilderList() {
            return (List) this.s2CItems_;
        }

        public int getS2CItemsCount() {
            return this.s2CItems_.size();
        }

        public ShopMallHandler.MallScoreItem getS2CItems(int index) {
            return this.s2CItems_.get(index);
        }

        public ShopMallHandler.MallScoreItemOrBuilder getS2CItemsOrBuilder(int index) {
            return this.s2CItems_.get(index);
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

        public static GetMallScoreItemListResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetMallScoreItemListResponse) PARSER.parseFrom(data);
        }

        public static GetMallScoreItemListResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetMallScoreItemListResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetMallScoreItemListResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetMallScoreItemListResponse) PARSER.parseFrom(data);
        }

        public static GetMallScoreItemListResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetMallScoreItemListResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetMallScoreItemListResponse parseFrom(InputStream input) throws IOException {
            return (GetMallScoreItemListResponse) PARSER.parseFrom(input);
        }

        public static GetMallScoreItemListResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetMallScoreItemListResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static GetMallScoreItemListResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (GetMallScoreItemListResponse) PARSER.parseDelimitedFrom(input);
        }

        public static GetMallScoreItemListResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetMallScoreItemListResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static GetMallScoreItemListResponse parseFrom(CodedInputStream input) throws IOException {
            return (GetMallScoreItemListResponse) PARSER.parseFrom(input);
        }

        public static GetMallScoreItemListResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetMallScoreItemListResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(GetMallScoreItemListResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements ShopMallHandler.GetMallScoreItemListResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private List<ShopMallHandler.MallScoreItem> s2CItems_;
            private RepeatedFieldBuilder<ShopMallHandler.MallScoreItem, ShopMallHandler.MallScoreItem.Builder, ShopMallHandler.MallScoreItemOrBuilder> s2CItemsBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ShopMallHandler.internal_static_pomelo_area_GetMallScoreItemListResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return ShopMallHandler.internal_static_pomelo_area_GetMallScoreItemListResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ShopMallHandler.GetMallScoreItemListResponse.class, Builder.class);
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
                if (ShopMallHandler.GetMallScoreItemListResponse.alwaysUseFieldBuilders)
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
                return ShopMallHandler.internal_static_pomelo_area_GetMallScoreItemListResponse_descriptor;
            }

            public ShopMallHandler.GetMallScoreItemListResponse getDefaultInstanceForType() {
                return ShopMallHandler.GetMallScoreItemListResponse.getDefaultInstance();
            }

            public ShopMallHandler.GetMallScoreItemListResponse build() {
                ShopMallHandler.GetMallScoreItemListResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public ShopMallHandler.GetMallScoreItemListResponse buildPartial() {
                ShopMallHandler.GetMallScoreItemListResponse result = new ShopMallHandler.GetMallScoreItemListResponse(this);
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
                if (other instanceof ShopMallHandler.GetMallScoreItemListResponse)
                    return mergeFrom((ShopMallHandler.GetMallScoreItemListResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ShopMallHandler.GetMallScoreItemListResponse other) {
                if (other == ShopMallHandler.GetMallScoreItemListResponse.getDefaultInstance())
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
                        this.s2CItemsBuilder_ = ShopMallHandler.GetMallScoreItemListResponse.alwaysUseFieldBuilders ? getS2CItemsFieldBuilder() : null;
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
                ShopMallHandler.GetMallScoreItemListResponse parsedMessage = null;
                try {
                    parsedMessage = (ShopMallHandler.GetMallScoreItemListResponse) ShopMallHandler.GetMallScoreItemListResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (ShopMallHandler.GetMallScoreItemListResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = ShopMallHandler.GetMallScoreItemListResponse.getDefaultInstance().getS2CMsg();
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

            public List<ShopMallHandler.MallScoreItem> getS2CItemsList() {
                if (this.s2CItemsBuilder_ == null)
                    return Collections.unmodifiableList(this.s2CItems_);
                return this.s2CItemsBuilder_.getMessageList();
            }

            public int getS2CItemsCount() {
                if (this.s2CItemsBuilder_ == null)
                    return this.s2CItems_.size();
                return this.s2CItemsBuilder_.getCount();
            }

            public ShopMallHandler.MallScoreItem getS2CItems(int index) {
                if (this.s2CItemsBuilder_ == null)
                    return this.s2CItems_.get(index);
                return (ShopMallHandler.MallScoreItem) this.s2CItemsBuilder_.getMessage(index);
            }

            public Builder setS2CItems(int index, ShopMallHandler.MallScoreItem value) {
                if (this.s2CItemsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CItemsIsMutable();
                    this.s2CItems_.set(index, value);
                    onChanged();
                } else {
                    this.s2CItemsBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setS2CItems(int index, ShopMallHandler.MallScoreItem.Builder builderForValue) {
                if (this.s2CItemsBuilder_ == null) {
                    ensureS2CItemsIsMutable();
                    this.s2CItems_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CItemsBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addS2CItems(ShopMallHandler.MallScoreItem value) {
                if (this.s2CItemsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CItemsIsMutable();
                    this.s2CItems_.add(value);
                    onChanged();
                } else {
                    this.s2CItemsBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addS2CItems(int index, ShopMallHandler.MallScoreItem value) {
                if (this.s2CItemsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CItemsIsMutable();
                    this.s2CItems_.add(index, value);
                    onChanged();
                } else {
                    this.s2CItemsBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addS2CItems(ShopMallHandler.MallScoreItem.Builder builderForValue) {
                if (this.s2CItemsBuilder_ == null) {
                    ensureS2CItemsIsMutable();
                    this.s2CItems_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.s2CItemsBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addS2CItems(int index, ShopMallHandler.MallScoreItem.Builder builderForValue) {
                if (this.s2CItemsBuilder_ == null) {
                    ensureS2CItemsIsMutable();
                    this.s2CItems_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CItemsBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllS2CItems(Iterable<? extends ShopMallHandler.MallScoreItem> values) {
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

            public ShopMallHandler.MallScoreItem.Builder getS2CItemsBuilder(int index) {
                return (ShopMallHandler.MallScoreItem.Builder) getS2CItemsFieldBuilder().getBuilder(index);
            }

            public ShopMallHandler.MallScoreItemOrBuilder getS2CItemsOrBuilder(int index) {
                if (this.s2CItemsBuilder_ == null)
                    return this.s2CItems_.get(index);
                return (ShopMallHandler.MallScoreItemOrBuilder) this.s2CItemsBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends ShopMallHandler.MallScoreItemOrBuilder> getS2CItemsOrBuilderList() {
                if (this.s2CItemsBuilder_ != null)
                    return this.s2CItemsBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.s2CItems_);
            }

            public ShopMallHandler.MallScoreItem.Builder addS2CItemsBuilder() {
                return (ShopMallHandler.MallScoreItem.Builder) getS2CItemsFieldBuilder().addBuilder(ShopMallHandler.MallScoreItem.getDefaultInstance());
            }

            public ShopMallHandler.MallScoreItem.Builder addS2CItemsBuilder(int index) {
                return (ShopMallHandler.MallScoreItem.Builder) getS2CItemsFieldBuilder().addBuilder(index, ShopMallHandler.MallScoreItem.getDefaultInstance());
            }

            public List<ShopMallHandler.MallScoreItem.Builder> getS2CItemsBuilderList() {
                return getS2CItemsFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<ShopMallHandler.MallScoreItem, ShopMallHandler.MallScoreItem.Builder, ShopMallHandler.MallScoreItemOrBuilder> getS2CItemsFieldBuilder() {
                if (this.s2CItemsBuilder_ == null) {
                    this.s2CItemsBuilder_ = new RepeatedFieldBuilder(this.s2CItems_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
                    this.s2CItems_ = null;
                }
                return this.s2CItemsBuilder_;
            }
        }
    }

    public static final class BuyMallScoreItemRequest extends GeneratedMessage implements BuyMallScoreItemRequestOrBuilder {
        private static final BuyMallScoreItemRequest defaultInstance = new BuyMallScoreItemRequest(true);
        private final UnknownFieldSet unknownFields;

        private BuyMallScoreItemRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private BuyMallScoreItemRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static BuyMallScoreItemRequest getDefaultInstance() {
            return defaultInstance;
        }

        public BuyMallScoreItemRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BuyMallScoreItemRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.c2SItemId_ = bs;
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
            return ShopMallHandler.internal_static_pomelo_area_BuyMallScoreItemRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ShopMallHandler.internal_static_pomelo_area_BuyMallScoreItemRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(BuyMallScoreItemRequest.class, Builder.class);
        }

        public static Parser<BuyMallScoreItemRequest> PARSER = (Parser<BuyMallScoreItemRequest>) new AbstractParser<BuyMallScoreItemRequest>() {
            public ShopMallHandler.BuyMallScoreItemRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ShopMallHandler.BuyMallScoreItemRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_ITEMID_FIELD_NUMBER = 1;
        private Object c2SItemId_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<BuyMallScoreItemRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasC2SItemId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public String getC2SItemId() {
            Object ref = this.c2SItemId_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.c2SItemId_ = s;
            return s;
        }

        public ByteString getC2SItemIdBytes() {
            Object ref = this.c2SItemId_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.c2SItemId_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        static {
            defaultInstance.initFields();
        }


        private void initFields() {
            this.c2SItemId_ = "";
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasC2SItemId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeBytes(1, getC2SItemIdBytes());
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
                size += CodedOutputStream.computeBytesSize(1, getC2SItemIdBytes());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static BuyMallScoreItemRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (BuyMallScoreItemRequest) PARSER.parseFrom(data);
        }


        public static BuyMallScoreItemRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BuyMallScoreItemRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static BuyMallScoreItemRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (BuyMallScoreItemRequest) PARSER.parseFrom(data);
        }


        public static BuyMallScoreItemRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BuyMallScoreItemRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static BuyMallScoreItemRequest parseFrom(InputStream input) throws IOException {
            return (BuyMallScoreItemRequest) PARSER.parseFrom(input);
        }


        public static BuyMallScoreItemRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuyMallScoreItemRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static BuyMallScoreItemRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (BuyMallScoreItemRequest) PARSER.parseDelimitedFrom(input);
        }


        public static BuyMallScoreItemRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuyMallScoreItemRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static BuyMallScoreItemRequest parseFrom(CodedInputStream input) throws IOException {
            return (BuyMallScoreItemRequest) PARSER.parseFrom(input);
        }


        public static BuyMallScoreItemRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuyMallScoreItemRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(BuyMallScoreItemRequest prototype) {
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
                implements ShopMallHandler.BuyMallScoreItemRequestOrBuilder {
            private int bitField0_;


            private Object c2SItemId_;


            public static final Descriptors.Descriptor getDescriptor() {
                return ShopMallHandler.internal_static_pomelo_area_BuyMallScoreItemRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return ShopMallHandler.internal_static_pomelo_area_BuyMallScoreItemRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ShopMallHandler.BuyMallScoreItemRequest.class, Builder.class);
            }


            private Builder() {
                this.c2SItemId_ = "";
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.c2SItemId_ = "";
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (ShopMallHandler.BuyMallScoreItemRequest.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.c2SItemId_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return ShopMallHandler.internal_static_pomelo_area_BuyMallScoreItemRequest_descriptor;
            }


            public ShopMallHandler.BuyMallScoreItemRequest getDefaultInstanceForType() {
                return ShopMallHandler.BuyMallScoreItemRequest.getDefaultInstance();
            }


            public ShopMallHandler.BuyMallScoreItemRequest build() {
                ShopMallHandler.BuyMallScoreItemRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public ShopMallHandler.BuyMallScoreItemRequest buildPartial() {
                ShopMallHandler.BuyMallScoreItemRequest result = new ShopMallHandler.BuyMallScoreItemRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.c2SItemId_ = this.c2SItemId_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof ShopMallHandler.BuyMallScoreItemRequest) {
                    return mergeFrom((ShopMallHandler.BuyMallScoreItemRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(ShopMallHandler.BuyMallScoreItemRequest other) {
                if (other == ShopMallHandler.BuyMallScoreItemRequest.getDefaultInstance()) {
                    return this;
                }
                if (other.hasC2SItemId()) {
                    this.bitField0_ |= 0x1;
                    this.c2SItemId_ = other.c2SItemId_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasC2SItemId()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                ShopMallHandler.BuyMallScoreItemRequest parsedMessage = null;
                try {
                    parsedMessage = (ShopMallHandler.BuyMallScoreItemRequest) ShopMallHandler.BuyMallScoreItemRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (ShopMallHandler.BuyMallScoreItemRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasC2SItemId() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public String getC2SItemId() {
                Object ref = this.c2SItemId_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.c2SItemId_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }


            public ByteString getC2SItemIdBytes() {
                Object ref = this.c2SItemId_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.c2SItemId_ = b;
                    return b;
                }
                return (ByteString) ref;
            }


            public Builder setC2SItemId(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x1;
                this.c2SItemId_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SItemId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SItemId_ = ShopMallHandler.BuyMallScoreItemRequest.getDefaultInstance().getC2SItemId();
                onChanged();
                return this;
            }


            public Builder setC2SItemIdBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x1;
                this.c2SItemId_ = value;
                onChanged();
                return this;
            }
        }
    }


    public static final class BuyMallScoreItemResponse
            extends GeneratedMessage
            implements BuyMallScoreItemResponseOrBuilder {
        private final UnknownFieldSet unknownFields;


        private BuyMallScoreItemResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }


        private BuyMallScoreItemResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }


        public static BuyMallScoreItemResponse getDefaultInstance() {
            return defaultInstance;
        }


        public BuyMallScoreItemResponse getDefaultInstanceForType() {
            return defaultInstance;
        }


        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }


        private BuyMallScoreItemResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return ShopMallHandler.internal_static_pomelo_area_BuyMallScoreItemResponse_descriptor;
        }


        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ShopMallHandler.internal_static_pomelo_area_BuyMallScoreItemResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(BuyMallScoreItemResponse.class, Builder.class);
        }


        public static Parser<BuyMallScoreItemResponse> PARSER = (Parser<BuyMallScoreItemResponse>) new AbstractParser<BuyMallScoreItemResponse>() {
            public ShopMallHandler.BuyMallScoreItemResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ShopMallHandler.BuyMallScoreItemResponse(input, extensionRegistry);
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


        public Parser<BuyMallScoreItemResponse> getParserForType() {
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


        private static final BuyMallScoreItemResponse defaultInstance = new BuyMallScoreItemResponse(true);

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

        public static BuyMallScoreItemResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (BuyMallScoreItemResponse) PARSER.parseFrom(data);
        }

        public static BuyMallScoreItemResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BuyMallScoreItemResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static BuyMallScoreItemResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (BuyMallScoreItemResponse) PARSER.parseFrom(data);
        }

        public static BuyMallScoreItemResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BuyMallScoreItemResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static BuyMallScoreItemResponse parseFrom(InputStream input) throws IOException {
            return (BuyMallScoreItemResponse) PARSER.parseFrom(input);
        }

        public static BuyMallScoreItemResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuyMallScoreItemResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static BuyMallScoreItemResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (BuyMallScoreItemResponse) PARSER.parseDelimitedFrom(input);
        }

        public static BuyMallScoreItemResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuyMallScoreItemResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static BuyMallScoreItemResponse parseFrom(CodedInputStream input) throws IOException {
            return (BuyMallScoreItemResponse) PARSER.parseFrom(input);
        }

        public static BuyMallScoreItemResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuyMallScoreItemResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(BuyMallScoreItemResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements ShopMallHandler.BuyMallScoreItemResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ShopMallHandler.internal_static_pomelo_area_BuyMallScoreItemResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return ShopMallHandler.internal_static_pomelo_area_BuyMallScoreItemResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ShopMallHandler.BuyMallScoreItemResponse.class, Builder.class);
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
                if (ShopMallHandler.BuyMallScoreItemResponse.alwaysUseFieldBuilders) ;
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
                return ShopMallHandler.internal_static_pomelo_area_BuyMallScoreItemResponse_descriptor;
            }

            public ShopMallHandler.BuyMallScoreItemResponse getDefaultInstanceForType() {
                return ShopMallHandler.BuyMallScoreItemResponse.getDefaultInstance();
            }

            public ShopMallHandler.BuyMallScoreItemResponse build() {
                ShopMallHandler.BuyMallScoreItemResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public ShopMallHandler.BuyMallScoreItemResponse buildPartial() {
                ShopMallHandler.BuyMallScoreItemResponse result = new ShopMallHandler.BuyMallScoreItemResponse(this);
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
                if (other instanceof ShopMallHandler.BuyMallScoreItemResponse)
                    return mergeFrom((ShopMallHandler.BuyMallScoreItemResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ShopMallHandler.BuyMallScoreItemResponse other) {
                if (other == ShopMallHandler.BuyMallScoreItemResponse.getDefaultInstance()) return this;
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
                ShopMallHandler.BuyMallScoreItemResponse parsedMessage = null;
                try {
                    parsedMessage = (ShopMallHandler.BuyMallScoreItemResponse) ShopMallHandler.BuyMallScoreItemResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (ShopMallHandler.BuyMallScoreItemResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = ShopMallHandler.BuyMallScoreItemResponse.getDefaultInstance().getS2CMsg();
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


    public static final class MallTab
            extends GeneratedMessage
            implements MallTabOrBuilder {
        private static final MallTab defaultInstance = new MallTab(true);
        private final UnknownFieldSet unknownFields;

        private MallTab(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private MallTab(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static MallTab getDefaultInstance() {
            return defaultInstance;
        }

        public MallTab getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MallTab(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.moneyType_ = input.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.itemType_ = input.readInt32();
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.isOpen_ = input.readInt32();
                            break;
                        case 34:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x8;
                            this.name_ = bs;
                            break;
                        case 40:
                            this.bitField0_ |= 0x10;
                            this.scriptNum_ = input.readInt32();
                            break;
                        case 48:
                            this.bitField0_ |= 0x20;
                            this.isLimit_ = input.readInt32();
                            break;
                        case 58:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x40;
                            this.lastNumText_ = bs;
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
            return ShopMallHandler.internal_static_pomelo_area_MallTab_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ShopMallHandler.internal_static_pomelo_area_MallTab_fieldAccessorTable.ensureFieldAccessorsInitialized(MallTab.class, Builder.class);
        }

        public static Parser<MallTab> PARSER = (Parser<MallTab>) new AbstractParser<MallTab>() {
            public ShopMallHandler.MallTab parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ShopMallHandler.MallTab(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int MONEYTYPE_FIELD_NUMBER = 1;
        private int moneyType_;
        public static final int ITEMTYPE_FIELD_NUMBER = 2;
        private int itemType_;
        public static final int ISOPEN_FIELD_NUMBER = 3;
        private int isOpen_;
        public static final int NAME_FIELD_NUMBER = 4;
        private Object name_;
        public static final int SCRIPTNUM_FIELD_NUMBER = 5;
        private int scriptNum_;
        public static final int ISLIMIT_FIELD_NUMBER = 6;
        private int isLimit_;
        public static final int LASTNUMTEXT_FIELD_NUMBER = 7;
        private Object lastNumText_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<MallTab> getParserForType() {
            return PARSER;
        }

        public boolean hasMoneyType() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getMoneyType() {
            return this.moneyType_;
        }

        public boolean hasItemType() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public int getItemType() {
            return this.itemType_;
        }

        static {
            defaultInstance.initFields();
        }

        public boolean hasIsOpen() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getIsOpen() {
            return this.isOpen_;
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

        public boolean hasScriptNum() {
            return ((this.bitField0_ & 0x10) == 16);
        }

        public int getScriptNum() {
            return this.scriptNum_;
        }

        public boolean hasIsLimit() {
            return ((this.bitField0_ & 0x20) == 32);
        }

        public int getIsLimit() {
            return this.isLimit_;
        }

        public boolean hasLastNumText() {
            return ((this.bitField0_ & 0x40) == 64);
        }

        public String getLastNumText() {
            Object ref = this.lastNumText_;
            if (ref instanceof String)
                return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8())
                this.lastNumText_ = s;
            return s;
        }

        public ByteString getLastNumTextBytes() {
            Object ref = this.lastNumText_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.lastNumText_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        private void initFields() {
            this.moneyType_ = 0;
            this.itemType_ = 0;
            this.isOpen_ = 0;
            this.name_ = "";
            this.scriptNum_ = 0;
            this.isLimit_ = 0;
            this.lastNumText_ = "";
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1)
                return true;
            if (isInitialized == 0)
                return false;
            if (!hasMoneyType()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasItemType()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasIsOpen()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasName()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasScriptNum()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasIsLimit()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1)
                output.writeInt32(1, this.moneyType_);
            if ((this.bitField0_ & 0x2) == 2)
                output.writeInt32(2, this.itemType_);
            if ((this.bitField0_ & 0x4) == 4)
                output.writeInt32(3, this.isOpen_);
            if ((this.bitField0_ & 0x8) == 8)
                output.writeBytes(4, getNameBytes());
            if ((this.bitField0_ & 0x10) == 16)
                output.writeInt32(5, this.scriptNum_);
            if ((this.bitField0_ & 0x20) == 32)
                output.writeInt32(6, this.isLimit_);
            if ((this.bitField0_ & 0x40) == 64)
                output.writeBytes(7, getLastNumTextBytes());
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1)
                return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1)
                size += CodedOutputStream.computeInt32Size(1, this.moneyType_);
            if ((this.bitField0_ & 0x2) == 2)
                size += CodedOutputStream.computeInt32Size(2, this.itemType_);
            if ((this.bitField0_ & 0x4) == 4)
                size += CodedOutputStream.computeInt32Size(3, this.isOpen_);
            if ((this.bitField0_ & 0x8) == 8)
                size += CodedOutputStream.computeBytesSize(4, getNameBytes());
            if ((this.bitField0_ & 0x10) == 16)
                size += CodedOutputStream.computeInt32Size(5, this.scriptNum_);
            if ((this.bitField0_ & 0x20) == 32)
                size += CodedOutputStream.computeInt32Size(6, this.isLimit_);
            if ((this.bitField0_ & 0x40) == 64)
                size += CodedOutputStream.computeBytesSize(7, getLastNumTextBytes());
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static MallTab parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (MallTab) PARSER.parseFrom(data);
        }

        public static MallTab parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MallTab) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MallTab parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (MallTab) PARSER.parseFrom(data);
        }

        public static MallTab parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MallTab) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MallTab parseFrom(InputStream input) throws IOException {
            return (MallTab) PARSER.parseFrom(input);
        }

        public static MallTab parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MallTab) PARSER.parseFrom(input, extensionRegistry);
        }

        public static MallTab parseDelimitedFrom(InputStream input) throws IOException {
            return (MallTab) PARSER.parseDelimitedFrom(input);
        }

        public static MallTab parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MallTab) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static MallTab parseFrom(CodedInputStream input) throws IOException {
            return (MallTab) PARSER.parseFrom(input);
        }

        public static MallTab parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MallTab) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(MallTab prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements ShopMallHandler.MallTabOrBuilder {
            private int bitField0_;
            private int moneyType_;
            private int itemType_;
            private int isOpen_;
            private Object name_;
            private int scriptNum_;
            private int isLimit_;
            private Object lastNumText_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ShopMallHandler.internal_static_pomelo_area_MallTab_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return ShopMallHandler.internal_static_pomelo_area_MallTab_fieldAccessorTable.ensureFieldAccessorsInitialized(ShopMallHandler.MallTab.class, Builder.class);
            }

            private Builder() {
                this.name_ = "";
                this.lastNumText_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.name_ = "";
                this.lastNumText_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ShopMallHandler.MallTab.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.moneyType_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.itemType_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                this.isOpen_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.name_ = "";
                this.bitField0_ &= 0xFFFFFFF7;
                this.scriptNum_ = 0;
                this.bitField0_ &= 0xFFFFFFEF;
                this.isLimit_ = 0;
                this.bitField0_ &= 0xFFFFFFDF;
                this.lastNumText_ = "";
                this.bitField0_ &= 0xFFFFFFBF;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return ShopMallHandler.internal_static_pomelo_area_MallTab_descriptor;
            }

            public ShopMallHandler.MallTab getDefaultInstanceForType() {
                return ShopMallHandler.MallTab.getDefaultInstance();
            }

            public ShopMallHandler.MallTab build() {
                ShopMallHandler.MallTab result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public ShopMallHandler.MallTab buildPartial() {
                ShopMallHandler.MallTab result = new ShopMallHandler.MallTab(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.moneyType_ = this.moneyType_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.itemType_ = this.itemType_;
                if ((from_bitField0_ & 0x4) == 4)
                    to_bitField0_ |= 0x4;
                result.isOpen_ = this.isOpen_;
                if ((from_bitField0_ & 0x8) == 8)
                    to_bitField0_ |= 0x8;
                result.name_ = this.name_;
                if ((from_bitField0_ & 0x10) == 16)
                    to_bitField0_ |= 0x10;
                result.scriptNum_ = this.scriptNum_;
                if ((from_bitField0_ & 0x20) == 32)
                    to_bitField0_ |= 0x20;
                result.isLimit_ = this.isLimit_;
                if ((from_bitField0_ & 0x40) == 64)
                    to_bitField0_ |= 0x40;
                result.lastNumText_ = this.lastNumText_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof ShopMallHandler.MallTab)
                    return mergeFrom((ShopMallHandler.MallTab) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ShopMallHandler.MallTab other) {
                if (other == ShopMallHandler.MallTab.getDefaultInstance())
                    return this;
                if (other.hasMoneyType())
                    setMoneyType(other.getMoneyType());
                if (other.hasItemType())
                    setItemType(other.getItemType());
                if (other.hasIsOpen())
                    setIsOpen(other.getIsOpen());
                if (other.hasName()) {
                    this.bitField0_ |= 0x8;
                    this.name_ = other.name_;
                    onChanged();
                }
                if (other.hasScriptNum())
                    setScriptNum(other.getScriptNum());
                if (other.hasIsLimit())
                    setIsLimit(other.getIsLimit());
                if (other.hasLastNumText()) {
                    this.bitField0_ |= 0x40;
                    this.lastNumText_ = other.lastNumText_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasMoneyType())
                    return false;
                if (!hasItemType())
                    return false;
                if (!hasIsOpen())
                    return false;
                if (!hasName())
                    return false;
                if (!hasScriptNum())
                    return false;
                if (!hasIsLimit())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                ShopMallHandler.MallTab parsedMessage = null;
                try {
                    parsedMessage = (ShopMallHandler.MallTab) ShopMallHandler.MallTab.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (ShopMallHandler.MallTab) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null)
                        mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasMoneyType() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getMoneyType() {
                return this.moneyType_;
            }

            public Builder setMoneyType(int value) {
                this.bitField0_ |= 0x1;
                this.moneyType_ = value;
                onChanged();
                return this;
            }

            public Builder clearMoneyType() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.moneyType_ = 0;
                onChanged();
                return this;
            }

            public boolean hasItemType() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getItemType() {
                return this.itemType_;
            }

            public Builder setItemType(int value) {
                this.bitField0_ |= 0x2;
                this.itemType_ = value;
                onChanged();
                return this;
            }

            public Builder clearItemType() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.itemType_ = 0;
                onChanged();
                return this;
            }

            public boolean hasIsOpen() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public int getIsOpen() {
                return this.isOpen_;
            }

            public Builder setIsOpen(int value) {
                this.bitField0_ |= 0x4;
                this.isOpen_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsOpen() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.isOpen_ = 0;
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
                this.name_ = ShopMallHandler.MallTab.getDefaultInstance().getName();
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

            public boolean hasScriptNum() {
                return ((this.bitField0_ & 0x10) == 16);
            }

            public int getScriptNum() {
                return this.scriptNum_;
            }

            public Builder setScriptNum(int value) {
                this.bitField0_ |= 0x10;
                this.scriptNum_ = value;
                onChanged();
                return this;
            }

            public Builder clearScriptNum() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.scriptNum_ = 0;
                onChanged();
                return this;
            }

            public boolean hasIsLimit() {
                return ((this.bitField0_ & 0x20) == 32);
            }

            public int getIsLimit() {
                return this.isLimit_;
            }

            public Builder setIsLimit(int value) {
                this.bitField0_ |= 0x20;
                this.isLimit_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsLimit() {
                this.bitField0_ &= 0xFFFFFFDF;
                this.isLimit_ = 0;
                onChanged();
                return this;
            }

            public boolean hasLastNumText() {
                return ((this.bitField0_ & 0x40) == 64);
            }

            public String getLastNumText() {
                Object ref = this.lastNumText_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.lastNumText_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getLastNumTextBytes() {
                Object ref = this.lastNumText_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.lastNumText_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setLastNumText(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x40;
                this.lastNumText_ = value;
                onChanged();
                return this;
            }

            public Builder clearLastNumText() {
                this.bitField0_ &= 0xFFFFFFBF;
                this.lastNumText_ = ShopMallHandler.MallTab.getDefaultInstance().getLastNumText();
                onChanged();
                return this;
            }

            public Builder setLastNumTextBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x40;
                this.lastNumText_ = value;
                onChanged();
                return this;
            }
        }
    }

    public static final class GetMallTabsRequest extends GeneratedMessage implements GetMallTabsRequestOrBuilder {
        private static final GetMallTabsRequest defaultInstance = new GetMallTabsRequest(true);
        private final UnknownFieldSet unknownFields;

        private GetMallTabsRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetMallTabsRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetMallTabsRequest getDefaultInstance() {
            return defaultInstance;
        }

        public GetMallTabsRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetMallTabsRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return ShopMallHandler.internal_static_pomelo_area_GetMallTabsRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ShopMallHandler.internal_static_pomelo_area_GetMallTabsRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetMallTabsRequest.class, Builder.class);
        }

        public static Parser<GetMallTabsRequest> PARSER = (Parser<GetMallTabsRequest>) new AbstractParser<GetMallTabsRequest>() {
            public ShopMallHandler.GetMallTabsRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ShopMallHandler.GetMallTabsRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetMallTabsRequest> getParserForType() {
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

        public static GetMallTabsRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetMallTabsRequest) PARSER.parseFrom(data);
        }

        public static GetMallTabsRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetMallTabsRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetMallTabsRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetMallTabsRequest) PARSER.parseFrom(data);
        }

        public static GetMallTabsRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetMallTabsRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetMallTabsRequest parseFrom(InputStream input) throws IOException {
            return (GetMallTabsRequest) PARSER.parseFrom(input);
        }

        public static GetMallTabsRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetMallTabsRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static GetMallTabsRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (GetMallTabsRequest) PARSER.parseDelimitedFrom(input);
        }

        public static GetMallTabsRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetMallTabsRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static GetMallTabsRequest parseFrom(CodedInputStream input) throws IOException {
            return (GetMallTabsRequest) PARSER.parseFrom(input);
        }

        public static GetMallTabsRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetMallTabsRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(GetMallTabsRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements ShopMallHandler.GetMallTabsRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return ShopMallHandler.internal_static_pomelo_area_GetMallTabsRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return ShopMallHandler.internal_static_pomelo_area_GetMallTabsRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ShopMallHandler.GetMallTabsRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ShopMallHandler.GetMallTabsRequest.alwaysUseFieldBuilders) ;
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
                return ShopMallHandler.internal_static_pomelo_area_GetMallTabsRequest_descriptor;
            }

            public ShopMallHandler.GetMallTabsRequest getDefaultInstanceForType() {
                return ShopMallHandler.GetMallTabsRequest.getDefaultInstance();
            }

            public ShopMallHandler.GetMallTabsRequest build() {
                ShopMallHandler.GetMallTabsRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public ShopMallHandler.GetMallTabsRequest buildPartial() {
                ShopMallHandler.GetMallTabsRequest result = new ShopMallHandler.GetMallTabsRequest(this);
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof ShopMallHandler.GetMallTabsRequest)
                    return mergeFrom((ShopMallHandler.GetMallTabsRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ShopMallHandler.GetMallTabsRequest other) {
                if (other == ShopMallHandler.GetMallTabsRequest.getDefaultInstance()) return this;
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                ShopMallHandler.GetMallTabsRequest parsedMessage = null;
                try {
                    parsedMessage = (ShopMallHandler.GetMallTabsRequest) ShopMallHandler.GetMallTabsRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (ShopMallHandler.GetMallTabsRequest) e.getUnfinishedMessage();
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


    public static final class GetMallTabsResponse
            extends GeneratedMessage
            implements GetMallTabsResponseOrBuilder {
        private static final GetMallTabsResponse defaultInstance = new GetMallTabsResponse(true);
        private final UnknownFieldSet unknownFields;

        private GetMallTabsResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetMallTabsResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetMallTabsResponse getDefaultInstance() {
            return defaultInstance;
        }

        public GetMallTabsResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetMallTabsResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.s2CTabs_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x4;
                            }
                            this.s2CTabs_.add(input.readMessage(ShopMallHandler.MallTab.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x4) == 4) this.s2CTabs_ = Collections.unmodifiableList(this.s2CTabs_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ShopMallHandler.internal_static_pomelo_area_GetMallTabsResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ShopMallHandler.internal_static_pomelo_area_GetMallTabsResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetMallTabsResponse.class, Builder.class);
        }

        public static Parser<GetMallTabsResponse> PARSER = (Parser<GetMallTabsResponse>) new AbstractParser<GetMallTabsResponse>() {
            public ShopMallHandler.GetMallTabsResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ShopMallHandler.GetMallTabsResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_TABS_FIELD_NUMBER = 3;
        private List<ShopMallHandler.MallTab> s2CTabs_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetMallTabsResponse> getParserForType() {
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

        public List<ShopMallHandler.MallTab> getS2CTabsList() {
            return this.s2CTabs_;
        }

        public List<? extends ShopMallHandler.MallTabOrBuilder> getS2CTabsOrBuilderList() {
            return (List) this.s2CTabs_;
        }

        public int getS2CTabsCount() {
            return this.s2CTabs_.size();
        }

        public ShopMallHandler.MallTab getS2CTabs(int index) {
            return this.s2CTabs_.get(index);
        }

        public ShopMallHandler.MallTabOrBuilder getS2CTabsOrBuilder(int index) {
            return this.s2CTabs_.get(index);
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CTabs_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasS2CCode()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (int i = 0; i < getS2CTabsCount(); i++) {
                if (!getS2CTabs(i).isInitialized()) {
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
            for (int i = 0; i < this.s2CTabs_.size(); i++) output.writeMessage(3, (MessageLite) this.s2CTabs_.get(i));
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());
            for (int i = 0; i < this.s2CTabs_.size(); i++)
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.s2CTabs_.get(i));
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static GetMallTabsResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetMallTabsResponse) PARSER.parseFrom(data);
        }

        public static GetMallTabsResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetMallTabsResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetMallTabsResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetMallTabsResponse) PARSER.parseFrom(data);
        }

        public static GetMallTabsResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetMallTabsResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetMallTabsResponse parseFrom(InputStream input) throws IOException {
            return (GetMallTabsResponse) PARSER.parseFrom(input);
        }

        public static GetMallTabsResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetMallTabsResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static GetMallTabsResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (GetMallTabsResponse) PARSER.parseDelimitedFrom(input);
        }

        public static GetMallTabsResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetMallTabsResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static GetMallTabsResponse parseFrom(CodedInputStream input) throws IOException {
            return (GetMallTabsResponse) PARSER.parseFrom(input);
        }

        public static GetMallTabsResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetMallTabsResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(GetMallTabsResponse prototype) {
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

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements ShopMallHandler.GetMallTabsResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private List<ShopMallHandler.MallTab> s2CTabs_;
            private RepeatedFieldBuilder<ShopMallHandler.MallTab, ShopMallHandler.MallTab.Builder, ShopMallHandler.MallTabOrBuilder> s2CTabsBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ShopMallHandler.internal_static_pomelo_area_GetMallTabsResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return ShopMallHandler.internal_static_pomelo_area_GetMallTabsResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ShopMallHandler.GetMallTabsResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.s2CTabs_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CTabs_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ShopMallHandler.GetMallTabsResponse.alwaysUseFieldBuilders)
                    getS2CTabsFieldBuilder();
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
                if (this.s2CTabsBuilder_ == null) {
                    this.s2CTabs_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                } else {
                    this.s2CTabsBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return ShopMallHandler.internal_static_pomelo_area_GetMallTabsResponse_descriptor;
            }

            public ShopMallHandler.GetMallTabsResponse getDefaultInstanceForType() {
                return ShopMallHandler.GetMallTabsResponse.getDefaultInstance();
            }

            public ShopMallHandler.GetMallTabsResponse build() {
                ShopMallHandler.GetMallTabsResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public ShopMallHandler.GetMallTabsResponse buildPartial() {
                ShopMallHandler.GetMallTabsResponse result = new ShopMallHandler.GetMallTabsResponse(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.s2CMsg_ = this.s2CMsg_;
                if (this.s2CTabsBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4) {
                        this.s2CTabs_ = Collections.unmodifiableList(this.s2CTabs_);
                        this.bitField0_ &= 0xFFFFFFFB;
                    }
                    result.s2CTabs_ = this.s2CTabs_;
                } else {
                    result.s2CTabs_ = this.s2CTabsBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof ShopMallHandler.GetMallTabsResponse)
                    return mergeFrom((ShopMallHandler.GetMallTabsResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ShopMallHandler.GetMallTabsResponse other) {
                if (other == ShopMallHandler.GetMallTabsResponse.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (this.s2CTabsBuilder_ == null) {
                    if (!other.s2CTabs_.isEmpty()) {
                        if (this.s2CTabs_.isEmpty()) {
                            this.s2CTabs_ = other.s2CTabs_;
                            this.bitField0_ &= 0xFFFFFFFB;
                        } else {
                            ensureS2CTabsIsMutable();
                            this.s2CTabs_.addAll(other.s2CTabs_);
                        }
                        onChanged();
                    }
                } else if (!other.s2CTabs_.isEmpty()) {
                    if (this.s2CTabsBuilder_.isEmpty()) {
                        this.s2CTabsBuilder_.dispose();
                        this.s2CTabsBuilder_ = null;
                        this.s2CTabs_ = other.s2CTabs_;
                        this.bitField0_ &= 0xFFFFFFFB;
                        this.s2CTabsBuilder_ = ShopMallHandler.GetMallTabsResponse.alwaysUseFieldBuilders ? getS2CTabsFieldBuilder() : null;
                    } else {
                        this.s2CTabsBuilder_.addAllMessages(other.s2CTabs_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode())
                    return false;
                for (int i = 0; i < getS2CTabsCount(); i++) {
                    if (!getS2CTabs(i).isInitialized())
                        return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                ShopMallHandler.GetMallTabsResponse parsedMessage = null;
                try {
                    parsedMessage = (ShopMallHandler.GetMallTabsResponse) ShopMallHandler.GetMallTabsResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (ShopMallHandler.GetMallTabsResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = ShopMallHandler.GetMallTabsResponse.getDefaultInstance().getS2CMsg();
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

            private void ensureS2CTabsIsMutable() {
                if ((this.bitField0_ & 0x4) != 4) {
                    this.s2CTabs_ = new ArrayList<>(this.s2CTabs_);
                    this.bitField0_ |= 0x4;
                }
            }

            public List<ShopMallHandler.MallTab> getS2CTabsList() {
                if (this.s2CTabsBuilder_ == null)
                    return Collections.unmodifiableList(this.s2CTabs_);
                return this.s2CTabsBuilder_.getMessageList();
            }

            public int getS2CTabsCount() {
                if (this.s2CTabsBuilder_ == null)
                    return this.s2CTabs_.size();
                return this.s2CTabsBuilder_.getCount();
            }

            public ShopMallHandler.MallTab getS2CTabs(int index) {
                if (this.s2CTabsBuilder_ == null)
                    return this.s2CTabs_.get(index);
                return (ShopMallHandler.MallTab) this.s2CTabsBuilder_.getMessage(index);
            }

            public Builder setS2CTabs(int index, ShopMallHandler.MallTab value) {
                if (this.s2CTabsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CTabsIsMutable();
                    this.s2CTabs_.set(index, value);
                    onChanged();
                } else {
                    this.s2CTabsBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setS2CTabs(int index, ShopMallHandler.MallTab.Builder builderForValue) {
                if (this.s2CTabsBuilder_ == null) {
                    ensureS2CTabsIsMutable();
                    this.s2CTabs_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CTabsBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addS2CTabs(ShopMallHandler.MallTab value) {
                if (this.s2CTabsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CTabsIsMutable();
                    this.s2CTabs_.add(value);
                    onChanged();
                } else {
                    this.s2CTabsBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addS2CTabs(int index, ShopMallHandler.MallTab value) {
                if (this.s2CTabsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CTabsIsMutable();
                    this.s2CTabs_.add(index, value);
                    onChanged();
                } else {
                    this.s2CTabsBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addS2CTabs(ShopMallHandler.MallTab.Builder builderForValue) {
                if (this.s2CTabsBuilder_ == null) {
                    ensureS2CTabsIsMutable();
                    this.s2CTabs_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.s2CTabsBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addS2CTabs(int index, ShopMallHandler.MallTab.Builder builderForValue) {
                if (this.s2CTabsBuilder_ == null) {
                    ensureS2CTabsIsMutable();
                    this.s2CTabs_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CTabsBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllS2CTabs(Iterable<? extends ShopMallHandler.MallTab> values) {
                if (this.s2CTabsBuilder_ == null) {
                    ensureS2CTabsIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.s2CTabs_);
                    onChanged();
                } else {
                    this.s2CTabsBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearS2CTabs() {
                if (this.s2CTabsBuilder_ == null) {
                    this.s2CTabs_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                    onChanged();
                } else {
                    this.s2CTabsBuilder_.clear();
                }
                return this;
            }

            public Builder removeS2CTabs(int index) {
                if (this.s2CTabsBuilder_ == null) {
                    ensureS2CTabsIsMutable();
                    this.s2CTabs_.remove(index);
                    onChanged();
                } else {
                    this.s2CTabsBuilder_.remove(index);
                }
                return this;
            }

            public ShopMallHandler.MallTab.Builder getS2CTabsBuilder(int index) {
                return (ShopMallHandler.MallTab.Builder) getS2CTabsFieldBuilder().getBuilder(index);
            }

            public ShopMallHandler.MallTabOrBuilder getS2CTabsOrBuilder(int index) {
                if (this.s2CTabsBuilder_ == null)
                    return this.s2CTabs_.get(index);
                return (ShopMallHandler.MallTabOrBuilder) this.s2CTabsBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends ShopMallHandler.MallTabOrBuilder> getS2CTabsOrBuilderList() {
                if (this.s2CTabsBuilder_ != null)
                    return this.s2CTabsBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.s2CTabs_);
            }

            public ShopMallHandler.MallTab.Builder addS2CTabsBuilder() {
                return (ShopMallHandler.MallTab.Builder) getS2CTabsFieldBuilder().addBuilder(ShopMallHandler.MallTab.getDefaultInstance());
            }

            public ShopMallHandler.MallTab.Builder addS2CTabsBuilder(int index) {
                return (ShopMallHandler.MallTab.Builder) getS2CTabsFieldBuilder().addBuilder(index, ShopMallHandler.MallTab.getDefaultInstance());
            }

            public List<ShopMallHandler.MallTab.Builder> getS2CTabsBuilderList() {
                return getS2CTabsFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<ShopMallHandler.MallTab, ShopMallHandler.MallTab.Builder, ShopMallHandler.MallTabOrBuilder> getS2CTabsFieldBuilder() {
                if (this.s2CTabsBuilder_ == null) {
                    this.s2CTabsBuilder_ = new RepeatedFieldBuilder(this.s2CTabs_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
                    this.s2CTabs_ = null;
                }
                return this.s2CTabsBuilder_;
            }
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }


    static {
        String[] descriptorData = {"\n\025shopMallHandler.proto\022\013pomelo.area\"Î\001\n\bMallItem\022\n\n\002id\030\001 \002(\t\022\f\n\004code\030\002 \002(\t\022\022\n\ngroupCount\030\003 \002(\005\022\023\n\013originPrice\030\004 \002(\005\022\020\n\bnowPrice\030\005 \002(\005\022\020\n\bdisCount\030\006 \002(\005\022\017\n\007endTime\030\007 \002(\005\022\021\n\tremainNum\030\b \002(\005\022\024\n\fconsumeScore\030\t \002(\005\022\020\n\bbindType\030\n \002(\005\022\017\n\007canSend\030\013 \002(\005\"x\n\rMallScoreItem\022\n\n\002id\030\001 \002(\t\022\f\n\004code\030\002 \002(\t\022\022\n\ngroupCount\030\003 \002(\005\022\024\n\fconsumeScore\030\004 \002(\005\022\021\n\tisSellOut\030\005 \002(\005\022\020\n\bbindType\030\006 \002(\005\"E\n\026GetMallItemListRequest\022\025\n\rc2s", "_moneyType\030\001 \001(\005\022\024\n\fc2s_itemType\030\002 \002(\005\"{\n\027GetMallItemListResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\023\n\013s2c_endTime\030\003 \001(\005\022(\n\ts2c_items\030\004 \003(\0132\025.pomelo.area.MallItem\"g\n\022BuyMallItemRequest\022\022\n\nc2s_itemId\030\001 \002(\t\022\021\n\tc2s_count\030\002 \002(\005\022\024\n\fc2s_playerId\030\003 \002(\t\022\024\n\fc2s_bDiamond\030\004 \002(\005\"K\n\023BuyMallItemResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\021\n\ttotal_num\030\003 \001(\005\"\035\n\033GetMallScoreItemListRequest\"p\n\034GetMallScoreItemList", "Response\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022-\n\ts2c_items\030\003 \003(\0132\032.pomelo.area.MallScoreItem\"-\n\027BuyMallScoreItemRequest\022\022\n\nc2s_itemId\030\001 \002(\t\"=\n\030BuyMallScoreItemResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"\001\n\007MallTab\022\021\n\tmoneyType\030\001 \002(\005\022\020\n\bitemType\030\002 \002(\005\022\016\n\006isOpen\030\003 \002(\005\022\f\n\004name\030\004 \002(\t\022\021\n\tscriptNum\030\005 \002(\005\022\017\n\007isLimit\030\006 \002(\005\022\023\n\013lastNumText\030\007 \001(\t\"\024\n\022GetMallTabsRequest\"`\n\023GetMallTabsResponse\022\020\n\bs2c_code\030\001 \002(\005\022", "\017\n\007s2c_msg\030\002 \001(\t\022&\n\bs2c_tabs\030\003 \003(\0132\024.pomelo.area.MallTab2\004\n\017shopMallHandler\022W\n\022getMallTabsRequest\022\037.pomelo.area.GetMallTabsRequest\032 .pomelo.area.GetMallTabsResponse\022r\n\033getMallScoreItemListRequest\022(.pomelo.area.GetMallScoreItemListRequest\032).pomelo.area.GetMallScoreItemListResponse\022W\n\022buyMallItemRequest\022\037.pomelo.area.BuyMallItemRequest\032 .pomelo.area.BuyMallItemResponse\022c\n\026getMallItemListRequest\022#.p", "omelo.area.GetMallItemListRequest\032$.pomelo.area.GetMallItemListResponse\022f\n\027buyMallScoreItemRequest\022$.pomelo.area.BuyMallScoreItemRequest\032%.pomelo.area.BuyMallScoreItemResponse"};


        Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root) {
                ShopMallHandler.descriptor = root;
                return null;
            }
        };

        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[0], assigner);
    }


    private static final Descriptors.Descriptor internal_static_pomelo_area_MallItem_descriptor = getDescriptor().getMessageTypes().get(0);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_MallItem_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_MallItem_descriptor, new String[]{"Id", "Code", "GroupCount", "OriginPrice", "NowPrice", "DisCount", "EndTime", "RemainNum", "ConsumeScore", "BindType", "CanSend"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_MallScoreItem_descriptor = getDescriptor().getMessageTypes().get(1);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_MallScoreItem_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_MallScoreItem_descriptor, new String[]{"Id", "Code", "GroupCount", "ConsumeScore", "IsSellOut", "BindType"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetMallItemListRequest_descriptor = getDescriptor().getMessageTypes().get(2);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetMallItemListRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetMallItemListRequest_descriptor, new String[]{"C2SMoneyType", "C2SItemType"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetMallItemListResponse_descriptor = getDescriptor().getMessageTypes().get(3);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetMallItemListResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetMallItemListResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CEndTime", "S2CItems"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_BuyMallItemRequest_descriptor = getDescriptor().getMessageTypes().get(4);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_BuyMallItemRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_BuyMallItemRequest_descriptor, new String[]{"C2SItemId", "C2SCount", "C2SPlayerId", "C2SBDiamond"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_BuyMallItemResponse_descriptor = getDescriptor().getMessageTypes().get(5);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_BuyMallItemResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_BuyMallItemResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "TotalNum"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetMallScoreItemListRequest_descriptor = getDescriptor().getMessageTypes().get(6);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetMallScoreItemListRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetMallScoreItemListRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetMallScoreItemListResponse_descriptor = getDescriptor().getMessageTypes().get(7);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetMallScoreItemListResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetMallScoreItemListResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CItems"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_BuyMallScoreItemRequest_descriptor = getDescriptor().getMessageTypes().get(8);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_BuyMallScoreItemRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_BuyMallScoreItemRequest_descriptor, new String[]{"C2SItemId"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_BuyMallScoreItemResponse_descriptor = getDescriptor().getMessageTypes().get(9);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_BuyMallScoreItemResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_BuyMallScoreItemResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_MallTab_descriptor = getDescriptor().getMessageTypes().get(10);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_MallTab_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_MallTab_descriptor, new String[]{"MoneyType", "ItemType", "IsOpen", "Name", "ScriptNum", "IsLimit", "LastNumText"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetMallTabsRequest_descriptor = getDescriptor().getMessageTypes().get(11);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetMallTabsRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetMallTabsRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetMallTabsResponse_descriptor = getDescriptor().getMessageTypes().get(12);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetMallTabsResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetMallTabsResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CTabs"});
    private static Descriptors.FileDescriptor descriptor;

    public static interface GetMallTabsResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        List<ShopMallHandler.MallTab> getS2CTabsList();

        ShopMallHandler.MallTab getS2CTabs(int param1Int);

        int getS2CTabsCount();

        List<? extends ShopMallHandler.MallTabOrBuilder> getS2CTabsOrBuilderList();

        ShopMallHandler.MallTabOrBuilder getS2CTabsOrBuilder(int param1Int);
    }

    public static interface GetMallTabsRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface MallTabOrBuilder extends MessageOrBuilder {
        boolean hasMoneyType();

        int getMoneyType();

        boolean hasItemType();

        int getItemType();

        boolean hasIsOpen();

        int getIsOpen();

        boolean hasName();

        String getName();

        ByteString getNameBytes();

        boolean hasScriptNum();

        int getScriptNum();

        boolean hasIsLimit();

        int getIsLimit();

        boolean hasLastNumText();

        String getLastNumText();

        ByteString getLastNumTextBytes();
    }

    public static interface BuyMallScoreItemResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface BuyMallScoreItemRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2SItemId();

        String getC2SItemId();

        ByteString getC2SItemIdBytes();
    }

    public static interface GetMallScoreItemListResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        List<ShopMallHandler.MallScoreItem> getS2CItemsList();

        ShopMallHandler.MallScoreItem getS2CItems(int param1Int);

        int getS2CItemsCount();

        List<? extends ShopMallHandler.MallScoreItemOrBuilder> getS2CItemsOrBuilderList();

        ShopMallHandler.MallScoreItemOrBuilder getS2CItemsOrBuilder(int param1Int);
    }

    public static interface GetMallScoreItemListRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface BuyMallItemResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasTotalNum();

        int getTotalNum();
    }

    public static interface BuyMallItemRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2SItemId();

        String getC2SItemId();

        ByteString getC2SItemIdBytes();

        boolean hasC2SCount();

        int getC2SCount();

        boolean hasC2SPlayerId();

        String getC2SPlayerId();

        ByteString getC2SPlayerIdBytes();

        boolean hasC2SBDiamond();

        int getC2SBDiamond();
    }

    public static interface GetMallItemListResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasS2CEndTime();

        int getS2CEndTime();

        List<ShopMallHandler.MallItem> getS2CItemsList();

        ShopMallHandler.MallItem getS2CItems(int param1Int);

        int getS2CItemsCount();

        List<? extends ShopMallHandler.MallItemOrBuilder> getS2CItemsOrBuilderList();

        ShopMallHandler.MallItemOrBuilder getS2CItemsOrBuilder(int param1Int);
    }

    public static interface GetMallItemListRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2SMoneyType();

        int getC2SMoneyType();

        boolean hasC2SItemType();

        int getC2SItemType();
    }

    public static interface MallScoreItemOrBuilder extends MessageOrBuilder {
        boolean hasId();

        String getId();

        ByteString getIdBytes();

        boolean hasCode();

        String getCode();

        ByteString getCodeBytes();

        boolean hasGroupCount();

        int getGroupCount();

        boolean hasConsumeScore();

        int getConsumeScore();

        boolean hasIsSellOut();

        int getIsSellOut();

        boolean hasBindType();

        int getBindType();
    }

    public static interface MallItemOrBuilder extends MessageOrBuilder {
        boolean hasId();

        String getId();

        ByteString getIdBytes();

        boolean hasCode();

        String getCode();

        ByteString getCodeBytes();

        boolean hasGroupCount();

        int getGroupCount();

        boolean hasOriginPrice();

        int getOriginPrice();

        boolean hasNowPrice();

        int getNowPrice();

        boolean hasDisCount();

        int getDisCount();

        boolean hasEndTime();

        int getEndTime();

        boolean hasRemainNum();

        int getRemainNum();

        boolean hasConsumeScore();

        int getConsumeScore();

        boolean hasBindType();

        int getBindType();

        boolean hasCanSend();

        int getCanSend();
    }
}


