package pomelo.area;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.UnknownFieldSet;

import java.io.IOException;
import java.io.InputStream;

public final class TreasureHandler {
    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public enum OpenType implements ProtocolMessageEnum {
        OPEN_ONE(0, 1),


        OPEN_TEN(1, 2);


        public static final int OPEN_ONE_VALUE = 1;


        public static final int OPEN_TEN_VALUE = 2;


        private static Internal.EnumLiteMap<OpenType> internalValueMap = new Internal.EnumLiteMap<OpenType>() {
            public TreasureHandler.OpenType findValueByNumber(int number) {
                return TreasureHandler.OpenType.valueOf(number);
            }
        };


        private static final OpenType[] VALUES = values();
        private final int index;
        private final int value;

        public final int getNumber() {
            return this.value;
        }

        public static Internal.EnumLiteMap<OpenType> internalGetValueMap() {
            return internalValueMap;
        }

        static {

        }

        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            return getDescriptor().getValues().get(this.index);
        }

        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return TreasureHandler.getDescriptor().getEnumTypes().get(0);
        }

        OpenType(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }


    public static final class TreasureItem
            extends GeneratedMessage
            implements TreasureItemOrBuilder {
        private static final TreasureItem defaultInstance = new TreasureItem(true);
        private final UnknownFieldSet unknownFields;

        private TreasureItem(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private TreasureItem(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static TreasureItem getDefaultInstance() {
            return defaultInstance;
        }

        public TreasureItem getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private TreasureItem(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.isBind_ = input.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.score_ = input.readInt32();
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
            return TreasureHandler.internal_static_pomelo_area_TreasureItem_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TreasureHandler.internal_static_pomelo_area_TreasureItem_fieldAccessorTable.ensureFieldAccessorsInitialized(TreasureItem.class, Builder.class);
        }

        public static Parser<TreasureItem> PARSER = (Parser<TreasureItem>) new AbstractParser<TreasureItem>() {
            public TreasureHandler.TreasureItem parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TreasureHandler.TreasureItem(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int ITEMCODE_FIELD_NUMBER = 1;
        private Object itemCode_;
        public static final int ITEMNUM_FIELD_NUMBER = 2;
        private int itemNum_;
        public static final int ISBIND_FIELD_NUMBER = 3;
        private int isBind_;
        public static final int SCORE_FIELD_NUMBER = 4;
        private int score_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<TreasureItem> getParserForType() {
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

        public boolean hasIsBind() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getIsBind() {
            return this.isBind_;
        }

        public boolean hasScore() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public int getScore() {
            return this.score_;
        }

        private void initFields() {
            this.itemCode_ = "";
            this.itemNum_ = 0;
            this.isBind_ = 0;
            this.score_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1)
                return true;
            if (isInitialized == 0)
                return false;
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
            if ((this.bitField0_ & 0x1) == 1)
                output.writeBytes(1, getItemCodeBytes());
            if ((this.bitField0_ & 0x2) == 2)
                output.writeInt32(2, this.itemNum_);
            if ((this.bitField0_ & 0x4) == 4)
                output.writeInt32(3, this.isBind_);
            if ((this.bitField0_ & 0x8) == 8)
                output.writeInt32(4, this.score_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1)
                return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1)
                size += CodedOutputStream.computeBytesSize(1, getItemCodeBytes());
            if ((this.bitField0_ & 0x2) == 2)
                size += CodedOutputStream.computeInt32Size(2, this.itemNum_);
            if ((this.bitField0_ & 0x4) == 4)
                size += CodedOutputStream.computeInt32Size(3, this.isBind_);
            if ((this.bitField0_ & 0x8) == 8)
                size += CodedOutputStream.computeInt32Size(4, this.score_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static TreasureItem parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (TreasureItem) PARSER.parseFrom(data);
        }

        public static TreasureItem parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (TreasureItem) PARSER.parseFrom(data, extensionRegistry);
        }

        public static TreasureItem parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (TreasureItem) PARSER.parseFrom(data);
        }

        public static TreasureItem parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (TreasureItem) PARSER.parseFrom(data, extensionRegistry);
        }

        public static TreasureItem parseFrom(InputStream input) throws IOException {
            return (TreasureItem) PARSER.parseFrom(input);
        }

        public static TreasureItem parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TreasureItem) PARSER.parseFrom(input, extensionRegistry);
        }

        public static TreasureItem parseDelimitedFrom(InputStream input) throws IOException {
            return (TreasureItem) PARSER.parseDelimitedFrom(input);
        }

        public static TreasureItem parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TreasureItem) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static TreasureItem parseFrom(CodedInputStream input) throws IOException {
            return (TreasureItem) PARSER.parseFrom(input);
        }

        public static TreasureItem parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TreasureItem) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(TreasureItem prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements TreasureHandler.TreasureItemOrBuilder {
            private int bitField0_;
            private Object itemCode_;
            private int itemNum_;
            private int isBind_;
            private int score_;

            public static final Descriptors.Descriptor getDescriptor() {
                return TreasureHandler.internal_static_pomelo_area_TreasureItem_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return TreasureHandler.internal_static_pomelo_area_TreasureItem_fieldAccessorTable.ensureFieldAccessorsInitialized(TreasureHandler.TreasureItem.class, Builder.class);
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
                if (TreasureHandler.TreasureItem.alwaysUseFieldBuilders) ;
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
                this.isBind_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.score_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return TreasureHandler.internal_static_pomelo_area_TreasureItem_descriptor;
            }

            public TreasureHandler.TreasureItem getDefaultInstanceForType() {
                return TreasureHandler.TreasureItem.getDefaultInstance();
            }

            public TreasureHandler.TreasureItem build() {
                TreasureHandler.TreasureItem result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public TreasureHandler.TreasureItem buildPartial() {
                TreasureHandler.TreasureItem result = new TreasureHandler.TreasureItem(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.itemCode_ = this.itemCode_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.itemNum_ = this.itemNum_;
                if ((from_bitField0_ & 0x4) == 4)
                    to_bitField0_ |= 0x4;
                result.isBind_ = this.isBind_;
                if ((from_bitField0_ & 0x8) == 8)
                    to_bitField0_ |= 0x8;
                result.score_ = this.score_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof TreasureHandler.TreasureItem)
                    return mergeFrom((TreasureHandler.TreasureItem) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TreasureHandler.TreasureItem other) {
                if (other == TreasureHandler.TreasureItem.getDefaultInstance())
                    return this;
                if (other.hasItemCode()) {
                    this.bitField0_ |= 0x1;
                    this.itemCode_ = other.itemCode_;
                    onChanged();
                }
                if (other.hasItemNum())
                    setItemNum(other.getItemNum());
                if (other.hasIsBind())
                    setIsBind(other.getIsBind());
                if (other.hasScore())
                    setScore(other.getScore());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasItemCode())
                    return false;
                if (!hasItemNum())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                TreasureHandler.TreasureItem parsedMessage = null;
                try {
                    parsedMessage = (TreasureHandler.TreasureItem) TreasureHandler.TreasureItem.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (TreasureHandler.TreasureItem) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null)
                        mergeFrom(parsedMessage);
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
                    if (bs.isValidUtf8())
                        this.itemCode_ = s;
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
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.itemCode_ = value;
                onChanged();
                return this;
            }

            public Builder clearItemCode() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.itemCode_ = TreasureHandler.TreasureItem.getDefaultInstance().getItemCode();
                onChanged();
                return this;
            }

            public Builder setItemCodeBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
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

            public boolean hasIsBind() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public int getIsBind() {
                return this.isBind_;
            }

            public Builder setIsBind(int value) {
                this.bitField0_ |= 0x4;
                this.isBind_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsBind() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.isBind_ = 0;
                onChanged();
                return this;
            }

            public boolean hasScore() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public int getScore() {
                return this.score_;
            }

            public Builder setScore(int value) {
                this.bitField0_ |= 0x8;
                this.score_ = value;
                onChanged();
                return this;
            }

            public Builder clearScore() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.score_ = 0;
                onChanged();
                return this;
            }
        }
    }

    public static final class GetTreasureInfoRequest extends GeneratedMessage implements GetTreasureInfoRequestOrBuilder {
        private final UnknownFieldSet unknownFields;

        private GetTreasureInfoRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetTreasureInfoRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetTreasureInfoRequest getDefaultInstance() {
            return defaultInstance;
        }

        public GetTreasureInfoRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetTreasureInfoRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.c2STreasureMsg_ = input.readInt32();
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
            return TreasureHandler.internal_static_pomelo_area_GetTreasureInfoRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TreasureHandler.internal_static_pomelo_area_GetTreasureInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetTreasureInfoRequest.class, Builder.class);
        }

        public static Parser<GetTreasureInfoRequest> PARSER = (Parser<GetTreasureInfoRequest>) new AbstractParser<GetTreasureInfoRequest>() {
            public TreasureHandler.GetTreasureInfoRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TreasureHandler.GetTreasureInfoRequest(input, extensionRegistry);
            }
        };

        private int bitField0_;
        public static final int C2S_TREASUREMSG_FIELD_NUMBER = 1;
        private int c2STreasureMsg_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetTreasureInfoRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasC2STreasureMsg() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getC2STreasureMsg() {
            return this.c2STreasureMsg_;
        }

        private void initFields() {
            this.c2STreasureMsg_ = 0;
        }

        private static final GetTreasureInfoRequest defaultInstance = new GetTreasureInfoRequest(true);

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasC2STreasureMsg()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.c2STreasureMsg_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.c2STreasureMsg_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static GetTreasureInfoRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetTreasureInfoRequest) PARSER.parseFrom(data);
        }

        public static GetTreasureInfoRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetTreasureInfoRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetTreasureInfoRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetTreasureInfoRequest) PARSER.parseFrom(data);
        }

        public static GetTreasureInfoRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetTreasureInfoRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetTreasureInfoRequest parseFrom(InputStream input) throws IOException {
            return (GetTreasureInfoRequest) PARSER.parseFrom(input);
        }

        public static GetTreasureInfoRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetTreasureInfoRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        static {
            defaultInstance.initFields();
        }


        public static GetTreasureInfoRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (GetTreasureInfoRequest) PARSER.parseDelimitedFrom(input);
        }


        public static GetTreasureInfoRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetTreasureInfoRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static GetTreasureInfoRequest parseFrom(CodedInputStream input) throws IOException {
            return (GetTreasureInfoRequest) PARSER.parseFrom(input);
        }


        public static GetTreasureInfoRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetTreasureInfoRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(GetTreasureInfoRequest prototype) {
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
                implements TreasureHandler.GetTreasureInfoRequestOrBuilder {
            private int bitField0_;


            private int c2STreasureMsg_;


            public static final Descriptors.Descriptor getDescriptor() {
                return TreasureHandler.internal_static_pomelo_area_GetTreasureInfoRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return TreasureHandler.internal_static_pomelo_area_GetTreasureInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(TreasureHandler.GetTreasureInfoRequest.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (TreasureHandler.GetTreasureInfoRequest.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.c2STreasureMsg_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return TreasureHandler.internal_static_pomelo_area_GetTreasureInfoRequest_descriptor;
            }


            public TreasureHandler.GetTreasureInfoRequest getDefaultInstanceForType() {
                return TreasureHandler.GetTreasureInfoRequest.getDefaultInstance();
            }


            public TreasureHandler.GetTreasureInfoRequest build() {
                TreasureHandler.GetTreasureInfoRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public TreasureHandler.GetTreasureInfoRequest buildPartial() {
                TreasureHandler.GetTreasureInfoRequest result = new TreasureHandler.GetTreasureInfoRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.c2STreasureMsg_ = this.c2STreasureMsg_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof TreasureHandler.GetTreasureInfoRequest) {
                    return mergeFrom((TreasureHandler.GetTreasureInfoRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(TreasureHandler.GetTreasureInfoRequest other) {
                if (other == TreasureHandler.GetTreasureInfoRequest.getDefaultInstance()) {
                    return this;
                }
                if (other.hasC2STreasureMsg()) {
                    setC2STreasureMsg(other.getC2STreasureMsg());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasC2STreasureMsg()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                TreasureHandler.GetTreasureInfoRequest parsedMessage = null;
                try {
                    parsedMessage = (TreasureHandler.GetTreasureInfoRequest) TreasureHandler.GetTreasureInfoRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (TreasureHandler.GetTreasureInfoRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasC2STreasureMsg() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public int getC2STreasureMsg() {
                return this.c2STreasureMsg_;
            }


            public Builder setC2STreasureMsg(int value) {
                this.bitField0_ |= 0x1;
                this.c2STreasureMsg_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2STreasureMsg() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2STreasureMsg_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class GetTreasureInfoResponse
            extends GeneratedMessage
            implements GetTreasureInfoResponseOrBuilder {
        private static final GetTreasureInfoResponse defaultInstance = new GetTreasureInfoResponse(true);
        private final UnknownFieldSet unknownFields;

        private GetTreasureInfoResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetTreasureInfoResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetTreasureInfoResponse getDefaultInstance() {
            return defaultInstance;
        }

        public GetTreasureInfoResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetTreasureInfoResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.s2CTreasureBagSize_ = input.readInt32();
                            break;
                        case 34:
                            bs = input.readBytes();
                            if ((mutable_bitField0_ & 0x8) != 8) {
                                this.s2CTreasureMsg_ = (LazyStringList) new LazyStringArrayList();
                                mutable_bitField0_ |= 0x8;
                            }
                            this.s2CTreasureMsg_.add(bs);
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x8) == 8) this.s2CTreasureMsg_ = this.s2CTreasureMsg_.getUnmodifiableView();
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TreasureHandler.internal_static_pomelo_area_GetTreasureInfoResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TreasureHandler.internal_static_pomelo_area_GetTreasureInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetTreasureInfoResponse.class, Builder.class);
        }

        public static Parser<GetTreasureInfoResponse> PARSER = (Parser<GetTreasureInfoResponse>) new AbstractParser<GetTreasureInfoResponse>() {
            public TreasureHandler.GetTreasureInfoResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TreasureHandler.GetTreasureInfoResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_TREASUREBAGSIZE_FIELD_NUMBER = 3;
        private int s2CTreasureBagSize_;
        public static final int S2C_TREASUREMSG_FIELD_NUMBER = 4;
        private LazyStringList s2CTreasureMsg_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetTreasureInfoResponse> getParserForType() {
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

        public boolean hasS2CTreasureBagSize() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getS2CTreasureBagSize() {
            return this.s2CTreasureBagSize_;
        }

        public ProtocolStringList getS2CTreasureMsgList() {
            return (ProtocolStringList) this.s2CTreasureMsg_;
        }

        public int getS2CTreasureMsgCount() {
            return this.s2CTreasureMsg_.size();
        }

        public String getS2CTreasureMsg(int index) {
            return (String) this.s2CTreasureMsg_.get(index);
        }

        public ByteString getS2CTreasureMsgBytes(int index) {
            return this.s2CTreasureMsg_.getByteString(index);
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CTreasureBagSize_ = 0;
            this.s2CTreasureMsg_ = LazyStringArrayList.EMPTY;
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
            if (!hasS2CTreasureBagSize()) {
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
                output.writeInt32(3, this.s2CTreasureBagSize_);
            for (int i = 0; i < this.s2CTreasureMsg_.size(); i++)
                output.writeBytes(4, this.s2CTreasureMsg_.getByteString(i));
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
                size += CodedOutputStream.computeInt32Size(3, this.s2CTreasureBagSize_);
            int dataSize = 0;
            for (int i = 0; i < this.s2CTreasureMsg_.size(); i++)
                dataSize += CodedOutputStream.computeBytesSizeNoTag(this.s2CTreasureMsg_.getByteString(i));
            size += dataSize;
            size += 1 * getS2CTreasureMsgList().size();
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static GetTreasureInfoResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetTreasureInfoResponse) PARSER.parseFrom(data);
        }

        public static GetTreasureInfoResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetTreasureInfoResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetTreasureInfoResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetTreasureInfoResponse) PARSER.parseFrom(data);
        }

        public static GetTreasureInfoResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetTreasureInfoResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetTreasureInfoResponse parseFrom(InputStream input) throws IOException {
            return (GetTreasureInfoResponse) PARSER.parseFrom(input);
        }

        public static GetTreasureInfoResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetTreasureInfoResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static GetTreasureInfoResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (GetTreasureInfoResponse) PARSER.parseDelimitedFrom(input);
        }

        public static GetTreasureInfoResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetTreasureInfoResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static GetTreasureInfoResponse parseFrom(CodedInputStream input) throws IOException {
            return (GetTreasureInfoResponse) PARSER.parseFrom(input);
        }

        public static GetTreasureInfoResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetTreasureInfoResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(GetTreasureInfoResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements TreasureHandler.GetTreasureInfoResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private int s2CTreasureBagSize_;
            private LazyStringList s2CTreasureMsg_;

            public static final Descriptors.Descriptor getDescriptor() {
                return TreasureHandler.internal_static_pomelo_area_GetTreasureInfoResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return TreasureHandler.internal_static_pomelo_area_GetTreasureInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(TreasureHandler.GetTreasureInfoResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.s2CTreasureMsg_ = LazyStringArrayList.EMPTY;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CTreasureMsg_ = LazyStringArrayList.EMPTY;
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TreasureHandler.GetTreasureInfoResponse.alwaysUseFieldBuilders) ;
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
                this.s2CTreasureBagSize_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.s2CTreasureMsg_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return TreasureHandler.internal_static_pomelo_area_GetTreasureInfoResponse_descriptor;
            }

            public TreasureHandler.GetTreasureInfoResponse getDefaultInstanceForType() {
                return TreasureHandler.GetTreasureInfoResponse.getDefaultInstance();
            }

            public TreasureHandler.GetTreasureInfoResponse build() {
                TreasureHandler.GetTreasureInfoResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public TreasureHandler.GetTreasureInfoResponse buildPartial() {
                TreasureHandler.GetTreasureInfoResponse result = new TreasureHandler.GetTreasureInfoResponse(this);
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
                result.s2CTreasureBagSize_ = this.s2CTreasureBagSize_;
                if ((this.bitField0_ & 0x8) == 8) {
                    this.s2CTreasureMsg_ = this.s2CTreasureMsg_.getUnmodifiableView();
                    this.bitField0_ &= 0xFFFFFFF7;
                }
                result.s2CTreasureMsg_ = this.s2CTreasureMsg_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof TreasureHandler.GetTreasureInfoResponse)
                    return mergeFrom((TreasureHandler.GetTreasureInfoResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TreasureHandler.GetTreasureInfoResponse other) {
                if (other == TreasureHandler.GetTreasureInfoResponse.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (other.hasS2CTreasureBagSize())
                    setS2CTreasureBagSize(other.getS2CTreasureBagSize());
                if (!other.s2CTreasureMsg_.isEmpty()) {
                    if (this.s2CTreasureMsg_.isEmpty()) {
                        this.s2CTreasureMsg_ = other.s2CTreasureMsg_;
                        this.bitField0_ &= 0xFFFFFFF7;
                    } else {
                        ensureS2CTreasureMsgIsMutable();
                        this.s2CTreasureMsg_.addAll((Collection) other.s2CTreasureMsg_);
                    }
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode())
                    return false;
                if (!hasS2CTreasureBagSize())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                TreasureHandler.GetTreasureInfoResponse parsedMessage = null;
                try {
                    parsedMessage = (TreasureHandler.GetTreasureInfoResponse) TreasureHandler.GetTreasureInfoResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (TreasureHandler.GetTreasureInfoResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = TreasureHandler.GetTreasureInfoResponse.getDefaultInstance().getS2CMsg();
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

            public boolean hasS2CTreasureBagSize() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public int getS2CTreasureBagSize() {
                return this.s2CTreasureBagSize_;
            }

            public Builder setS2CTreasureBagSize(int value) {
                this.bitField0_ |= 0x4;
                this.s2CTreasureBagSize_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CTreasureBagSize() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.s2CTreasureBagSize_ = 0;
                onChanged();
                return this;
            }

            private void ensureS2CTreasureMsgIsMutable() {
                if ((this.bitField0_ & 0x8) != 8) {
                    this.s2CTreasureMsg_ = (LazyStringList) new LazyStringArrayList(this.s2CTreasureMsg_);
                    this.bitField0_ |= 0x8;
                }
            }

            public ProtocolStringList getS2CTreasureMsgList() {
                return (ProtocolStringList) this.s2CTreasureMsg_.getUnmodifiableView();
            }

            public int getS2CTreasureMsgCount() {
                return this.s2CTreasureMsg_.size();
            }

            public String getS2CTreasureMsg(int index) {
                return (String) this.s2CTreasureMsg_.get(index);
            }

            public ByteString getS2CTreasureMsgBytes(int index) {
                return this.s2CTreasureMsg_.getByteString(index);
            }

            public Builder setS2CTreasureMsg(int index, String value) {
                if (value == null)
                    throw new NullPointerException();
                ensureS2CTreasureMsgIsMutable();
                this.s2CTreasureMsg_.set(index, value);
                onChanged();
                return this;
            }

            public Builder addS2CTreasureMsg(String value) {
                if (value == null)
                    throw new NullPointerException();
                ensureS2CTreasureMsgIsMutable();
                this.s2CTreasureMsg_.add(value);
                onChanged();
                return this;
            }

            public Builder addAllS2CTreasureMsg(Iterable<String> values) {
                ensureS2CTreasureMsgIsMutable();
                AbstractMessageLite.Builder.addAll(values, (Collection) this.s2CTreasureMsg_);
                onChanged();
                return this;
            }

            public Builder clearS2CTreasureMsg() {
                this.s2CTreasureMsg_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= 0xFFFFFFF7;
                onChanged();
                return this;
            }

            public Builder addS2CTreasureMsgBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                ensureS2CTreasureMsgIsMutable();
                this.s2CTreasureMsg_.add(value);
                onChanged();
                return this;
            }
        }
    }

    public static final class GetTreasureBagInfoRequest extends GeneratedMessage implements GetTreasureBagInfoRequestOrBuilder {
        private static final GetTreasureBagInfoRequest defaultInstance = new GetTreasureBagInfoRequest(true);
        private final UnknownFieldSet unknownFields;

        private GetTreasureBagInfoRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetTreasureBagInfoRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetTreasureBagInfoRequest getDefaultInstance() {
            return defaultInstance;
        }

        public GetTreasureBagInfoRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetTreasureBagInfoRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return TreasureHandler.internal_static_pomelo_area_GetTreasureBagInfoRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TreasureHandler.internal_static_pomelo_area_GetTreasureBagInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetTreasureBagInfoRequest.class, Builder.class);
        }

        public static Parser<GetTreasureBagInfoRequest> PARSER = (Parser<GetTreasureBagInfoRequest>) new AbstractParser<GetTreasureBagInfoRequest>() {
            public TreasureHandler.GetTreasureBagInfoRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TreasureHandler.GetTreasureBagInfoRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetTreasureBagInfoRequest> getParserForType() {
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


        public static GetTreasureBagInfoRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetTreasureBagInfoRequest) PARSER.parseFrom(data);
        }


        public static GetTreasureBagInfoRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetTreasureBagInfoRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetTreasureBagInfoRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetTreasureBagInfoRequest) PARSER.parseFrom(data);
        }


        public static GetTreasureBagInfoRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetTreasureBagInfoRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetTreasureBagInfoRequest parseFrom(InputStream input) throws IOException {
            return (GetTreasureBagInfoRequest) PARSER.parseFrom(input);
        }


        public static GetTreasureBagInfoRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetTreasureBagInfoRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static GetTreasureBagInfoRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (GetTreasureBagInfoRequest) PARSER.parseDelimitedFrom(input);
        }


        public static GetTreasureBagInfoRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetTreasureBagInfoRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static GetTreasureBagInfoRequest parseFrom(CodedInputStream input) throws IOException {
            return (GetTreasureBagInfoRequest) PARSER.parseFrom(input);
        }


        public static GetTreasureBagInfoRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetTreasureBagInfoRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(GetTreasureBagInfoRequest prototype) {
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
                implements TreasureHandler.GetTreasureBagInfoRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return TreasureHandler.internal_static_pomelo_area_GetTreasureBagInfoRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return TreasureHandler.internal_static_pomelo_area_GetTreasureBagInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(TreasureHandler.GetTreasureBagInfoRequest.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (TreasureHandler.GetTreasureBagInfoRequest.alwaysUseFieldBuilders) ;
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
                return TreasureHandler.internal_static_pomelo_area_GetTreasureBagInfoRequest_descriptor;
            }


            public TreasureHandler.GetTreasureBagInfoRequest getDefaultInstanceForType() {
                return TreasureHandler.GetTreasureBagInfoRequest.getDefaultInstance();
            }


            public TreasureHandler.GetTreasureBagInfoRequest build() {
                TreasureHandler.GetTreasureBagInfoRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public TreasureHandler.GetTreasureBagInfoRequest buildPartial() {
                TreasureHandler.GetTreasureBagInfoRequest result = new TreasureHandler.GetTreasureBagInfoRequest(this);
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof TreasureHandler.GetTreasureBagInfoRequest) {
                    return mergeFrom((TreasureHandler.GetTreasureBagInfoRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(TreasureHandler.GetTreasureBagInfoRequest other) {
                if (other == TreasureHandler.GetTreasureBagInfoRequest.getDefaultInstance()) {
                    return this;
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                TreasureHandler.GetTreasureBagInfoRequest parsedMessage = null;
                try {
                    parsedMessage = (TreasureHandler.GetTreasureBagInfoRequest) TreasureHandler.GetTreasureBagInfoRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (TreasureHandler.GetTreasureBagInfoRequest) e.getUnfinishedMessage();
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


    public static final class GetTreasureBagInfoResponse
            extends GeneratedMessage
            implements GetTreasureBagInfoResponseOrBuilder {
        private static final GetTreasureBagInfoResponse defaultInstance = new GetTreasureBagInfoResponse(true);
        private final UnknownFieldSet unknownFields;

        private GetTreasureBagInfoResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetTreasureBagInfoResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetTreasureBagInfoResponse getDefaultInstance() {
            return defaultInstance;
        }

        public GetTreasureBagInfoResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetTreasureBagInfoResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.s2CTreasureBag_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x4;
                            }
                            this.s2CTreasureBag_.add(input.readMessage(TreasureHandler.TreasureItem.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x4) == 4)
                    this.s2CTreasureBag_ = Collections.unmodifiableList(this.s2CTreasureBag_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TreasureHandler.internal_static_pomelo_area_GetTreasureBagInfoResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TreasureHandler.internal_static_pomelo_area_GetTreasureBagInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetTreasureBagInfoResponse.class, Builder.class);
        }

        public static Parser<GetTreasureBagInfoResponse> PARSER = (Parser<GetTreasureBagInfoResponse>) new AbstractParser<GetTreasureBagInfoResponse>() {
            public TreasureHandler.GetTreasureBagInfoResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TreasureHandler.GetTreasureBagInfoResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_TREASUREBAG_FIELD_NUMBER = 3;
        private List<TreasureHandler.TreasureItem> s2CTreasureBag_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetTreasureBagInfoResponse> getParserForType() {
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

        public List<TreasureHandler.TreasureItem> getS2CTreasureBagList() {
            return this.s2CTreasureBag_;
        }

        public List<? extends TreasureHandler.TreasureItemOrBuilder> getS2CTreasureBagOrBuilderList() {
            return (List) this.s2CTreasureBag_;
        }

        public int getS2CTreasureBagCount() {
            return this.s2CTreasureBag_.size();
        }

        public TreasureHandler.TreasureItem getS2CTreasureBag(int index) {
            return this.s2CTreasureBag_.get(index);
        }

        public TreasureHandler.TreasureItemOrBuilder getS2CTreasureBagOrBuilder(int index) {
            return this.s2CTreasureBag_.get(index);
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CTreasureBag_ = Collections.emptyList();
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
            for (int i = 0; i < getS2CTreasureBagCount(); i++) {
                if (!getS2CTreasureBag(i).isInitialized()) {
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
            for (int i = 0; i < this.s2CTreasureBag_.size(); i++)
                output.writeMessage(3, (MessageLite) this.s2CTreasureBag_.get(i));
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
            for (int i = 0; i < this.s2CTreasureBag_.size(); i++)
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.s2CTreasureBag_.get(i));
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static GetTreasureBagInfoResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetTreasureBagInfoResponse) PARSER.parseFrom(data);
        }

        public static GetTreasureBagInfoResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetTreasureBagInfoResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetTreasureBagInfoResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetTreasureBagInfoResponse) PARSER.parseFrom(data);
        }

        public static GetTreasureBagInfoResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetTreasureBagInfoResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetTreasureBagInfoResponse parseFrom(InputStream input) throws IOException {
            return (GetTreasureBagInfoResponse) PARSER.parseFrom(input);
        }

        public static GetTreasureBagInfoResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetTreasureBagInfoResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static GetTreasureBagInfoResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (GetTreasureBagInfoResponse) PARSER.parseDelimitedFrom(input);
        }

        public static GetTreasureBagInfoResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetTreasureBagInfoResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static GetTreasureBagInfoResponse parseFrom(CodedInputStream input) throws IOException {
            return (GetTreasureBagInfoResponse) PARSER.parseFrom(input);
        }

        public static GetTreasureBagInfoResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetTreasureBagInfoResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(GetTreasureBagInfoResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements TreasureHandler.GetTreasureBagInfoResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private List<TreasureHandler.TreasureItem> s2CTreasureBag_;
            private RepeatedFieldBuilder<TreasureHandler.TreasureItem, TreasureHandler.TreasureItem.Builder, TreasureHandler.TreasureItemOrBuilder> s2CTreasureBagBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return TreasureHandler.internal_static_pomelo_area_GetTreasureBagInfoResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return TreasureHandler.internal_static_pomelo_area_GetTreasureBagInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(TreasureHandler.GetTreasureBagInfoResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.s2CTreasureBag_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CTreasureBag_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TreasureHandler.GetTreasureBagInfoResponse.alwaysUseFieldBuilders)
                    getS2CTreasureBagFieldBuilder();
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
                if (this.s2CTreasureBagBuilder_ == null) {
                    this.s2CTreasureBag_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                } else {
                    this.s2CTreasureBagBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return TreasureHandler.internal_static_pomelo_area_GetTreasureBagInfoResponse_descriptor;
            }

            public TreasureHandler.GetTreasureBagInfoResponse getDefaultInstanceForType() {
                return TreasureHandler.GetTreasureBagInfoResponse.getDefaultInstance();
            }

            public TreasureHandler.GetTreasureBagInfoResponse build() {
                TreasureHandler.GetTreasureBagInfoResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public TreasureHandler.GetTreasureBagInfoResponse buildPartial() {
                TreasureHandler.GetTreasureBagInfoResponse result = new TreasureHandler.GetTreasureBagInfoResponse(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.s2CMsg_ = this.s2CMsg_;
                if (this.s2CTreasureBagBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4) {
                        this.s2CTreasureBag_ = Collections.unmodifiableList(this.s2CTreasureBag_);
                        this.bitField0_ &= 0xFFFFFFFB;
                    }
                    result.s2CTreasureBag_ = this.s2CTreasureBag_;
                } else {
                    result.s2CTreasureBag_ = this.s2CTreasureBagBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof TreasureHandler.GetTreasureBagInfoResponse)
                    return mergeFrom((TreasureHandler.GetTreasureBagInfoResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TreasureHandler.GetTreasureBagInfoResponse other) {
                if (other == TreasureHandler.GetTreasureBagInfoResponse.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (this.s2CTreasureBagBuilder_ == null) {
                    if (!other.s2CTreasureBag_.isEmpty()) {
                        if (this.s2CTreasureBag_.isEmpty()) {
                            this.s2CTreasureBag_ = other.s2CTreasureBag_;
                            this.bitField0_ &= 0xFFFFFFFB;
                        } else {
                            ensureS2CTreasureBagIsMutable();
                            this.s2CTreasureBag_.addAll(other.s2CTreasureBag_);
                        }
                        onChanged();
                    }
                } else if (!other.s2CTreasureBag_.isEmpty()) {
                    if (this.s2CTreasureBagBuilder_.isEmpty()) {
                        this.s2CTreasureBagBuilder_.dispose();
                        this.s2CTreasureBagBuilder_ = null;
                        this.s2CTreasureBag_ = other.s2CTreasureBag_;
                        this.bitField0_ &= 0xFFFFFFFB;
                        this.s2CTreasureBagBuilder_ = TreasureHandler.GetTreasureBagInfoResponse.alwaysUseFieldBuilders ? getS2CTreasureBagFieldBuilder() : null;
                    } else {
                        this.s2CTreasureBagBuilder_.addAllMessages(other.s2CTreasureBag_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode())
                    return false;
                for (int i = 0; i < getS2CTreasureBagCount(); i++) {
                    if (!getS2CTreasureBag(i).isInitialized())
                        return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                TreasureHandler.GetTreasureBagInfoResponse parsedMessage = null;
                try {
                    parsedMessage = (TreasureHandler.GetTreasureBagInfoResponse) TreasureHandler.GetTreasureBagInfoResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (TreasureHandler.GetTreasureBagInfoResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = TreasureHandler.GetTreasureBagInfoResponse.getDefaultInstance().getS2CMsg();
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

            private void ensureS2CTreasureBagIsMutable() {
                if ((this.bitField0_ & 0x4) != 4) {
                    this.s2CTreasureBag_ = new ArrayList<>(this.s2CTreasureBag_);
                    this.bitField0_ |= 0x4;
                }
            }

            public List<TreasureHandler.TreasureItem> getS2CTreasureBagList() {
                if (this.s2CTreasureBagBuilder_ == null)
                    return Collections.unmodifiableList(this.s2CTreasureBag_);
                return this.s2CTreasureBagBuilder_.getMessageList();
            }

            public int getS2CTreasureBagCount() {
                if (this.s2CTreasureBagBuilder_ == null)
                    return this.s2CTreasureBag_.size();
                return this.s2CTreasureBagBuilder_.getCount();
            }

            public TreasureHandler.TreasureItem getS2CTreasureBag(int index) {
                if (this.s2CTreasureBagBuilder_ == null)
                    return this.s2CTreasureBag_.get(index);
                return (TreasureHandler.TreasureItem) this.s2CTreasureBagBuilder_.getMessage(index);
            }

            public Builder setS2CTreasureBag(int index, TreasureHandler.TreasureItem value) {
                if (this.s2CTreasureBagBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CTreasureBagIsMutable();
                    this.s2CTreasureBag_.set(index, value);
                    onChanged();
                } else {
                    this.s2CTreasureBagBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setS2CTreasureBag(int index, TreasureHandler.TreasureItem.Builder builderForValue) {
                if (this.s2CTreasureBagBuilder_ == null) {
                    ensureS2CTreasureBagIsMutable();
                    this.s2CTreasureBag_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CTreasureBagBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addS2CTreasureBag(TreasureHandler.TreasureItem value) {
                if (this.s2CTreasureBagBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CTreasureBagIsMutable();
                    this.s2CTreasureBag_.add(value);
                    onChanged();
                } else {
                    this.s2CTreasureBagBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addS2CTreasureBag(int index, TreasureHandler.TreasureItem value) {
                if (this.s2CTreasureBagBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CTreasureBagIsMutable();
                    this.s2CTreasureBag_.add(index, value);
                    onChanged();
                } else {
                    this.s2CTreasureBagBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addS2CTreasureBag(TreasureHandler.TreasureItem.Builder builderForValue) {
                if (this.s2CTreasureBagBuilder_ == null) {
                    ensureS2CTreasureBagIsMutable();
                    this.s2CTreasureBag_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.s2CTreasureBagBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addS2CTreasureBag(int index, TreasureHandler.TreasureItem.Builder builderForValue) {
                if (this.s2CTreasureBagBuilder_ == null) {
                    ensureS2CTreasureBagIsMutable();
                    this.s2CTreasureBag_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CTreasureBagBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllS2CTreasureBag(Iterable<? extends TreasureHandler.TreasureItem> values) {
                if (this.s2CTreasureBagBuilder_ == null) {
                    ensureS2CTreasureBagIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.s2CTreasureBag_);
                    onChanged();
                } else {
                    this.s2CTreasureBagBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearS2CTreasureBag() {
                if (this.s2CTreasureBagBuilder_ == null) {
                    this.s2CTreasureBag_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                    onChanged();
                } else {
                    this.s2CTreasureBagBuilder_.clear();
                }
                return this;
            }

            public Builder removeS2CTreasureBag(int index) {
                if (this.s2CTreasureBagBuilder_ == null) {
                    ensureS2CTreasureBagIsMutable();
                    this.s2CTreasureBag_.remove(index);
                    onChanged();
                } else {
                    this.s2CTreasureBagBuilder_.remove(index);
                }
                return this;
            }

            public TreasureHandler.TreasureItem.Builder getS2CTreasureBagBuilder(int index) {
                return (TreasureHandler.TreasureItem.Builder) getS2CTreasureBagFieldBuilder().getBuilder(index);
            }

            public TreasureHandler.TreasureItemOrBuilder getS2CTreasureBagOrBuilder(int index) {
                if (this.s2CTreasureBagBuilder_ == null)
                    return this.s2CTreasureBag_.get(index);
                return (TreasureHandler.TreasureItemOrBuilder) this.s2CTreasureBagBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends TreasureHandler.TreasureItemOrBuilder> getS2CTreasureBagOrBuilderList() {
                if (this.s2CTreasureBagBuilder_ != null)
                    return this.s2CTreasureBagBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.s2CTreasureBag_);
            }

            public TreasureHandler.TreasureItem.Builder addS2CTreasureBagBuilder() {
                return (TreasureHandler.TreasureItem.Builder) getS2CTreasureBagFieldBuilder().addBuilder(TreasureHandler.TreasureItem.getDefaultInstance());
            }

            public TreasureHandler.TreasureItem.Builder addS2CTreasureBagBuilder(int index) {
                return (TreasureHandler.TreasureItem.Builder) getS2CTreasureBagFieldBuilder().addBuilder(index, TreasureHandler.TreasureItem.getDefaultInstance());
            }

            public List<TreasureHandler.TreasureItem.Builder> getS2CTreasureBagBuilderList() {
                return getS2CTreasureBagFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<TreasureHandler.TreasureItem, TreasureHandler.TreasureItem.Builder, TreasureHandler.TreasureItemOrBuilder> getS2CTreasureBagFieldBuilder() {
                if (this.s2CTreasureBagBuilder_ == null) {
                    this.s2CTreasureBagBuilder_ = new RepeatedFieldBuilder(this.s2CTreasureBag_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
                    this.s2CTreasureBag_ = null;
                }
                return this.s2CTreasureBagBuilder_;
            }
        }
    }

    public static final class OpenTreasureRequest extends GeneratedMessage implements OpenTreasureRequestOrBuilder {
        private static final OpenTreasureRequest defaultInstance = new OpenTreasureRequest(true);
        private final UnknownFieldSet unknownFields;

        private OpenTreasureRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private OpenTreasureRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static OpenTreasureRequest getDefaultInstance() {
            return defaultInstance;
        }

        public OpenTreasureRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private OpenTreasureRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int rawValue;
                    TreasureHandler.OpenType value;
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        case 8:
                            rawValue = input.readEnum();
                            value = TreasureHandler.OpenType.valueOf(rawValue);
                            if (value == null) {
                                unknownFields.mergeVarintField(1, rawValue);
                                break;
                            }
                            this.bitField0_ |= 0x1;
                            this.c2SOpenType_ = value;
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.c2SUseDiamond_ = input.readInt32();
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
            return TreasureHandler.internal_static_pomelo_area_OpenTreasureRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TreasureHandler.internal_static_pomelo_area_OpenTreasureRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(OpenTreasureRequest.class, Builder.class);
        }

        public static Parser<OpenTreasureRequest> PARSER = (Parser<OpenTreasureRequest>) new AbstractParser<OpenTreasureRequest>() {
            public TreasureHandler.OpenTreasureRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TreasureHandler.OpenTreasureRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_OPENTYPE_FIELD_NUMBER = 1;
        private TreasureHandler.OpenType c2SOpenType_;
        public static final int C2S_USEDIAMOND_FIELD_NUMBER = 2;
        private int c2SUseDiamond_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<OpenTreasureRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasC2SOpenType() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public TreasureHandler.OpenType getC2SOpenType() {
            return this.c2SOpenType_;
        }

        public boolean hasC2SUseDiamond() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        static {
            defaultInstance.initFields();
        }


        public int getC2SUseDiamond() {
            return this.c2SUseDiamond_;
        }


        private void initFields() {
            this.c2SOpenType_ = TreasureHandler.OpenType.OPEN_ONE;
            this.c2SUseDiamond_ = 0;
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasC2SOpenType()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasC2SUseDiamond()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeEnum(1, this.c2SOpenType_.getNumber());
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeInt32(2, this.c2SUseDiamond_);
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
                size += CodedOutputStream.computeEnumSize(1, this.c2SOpenType_.getNumber());
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeInt32Size(2, this.c2SUseDiamond_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static OpenTreasureRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (OpenTreasureRequest) PARSER.parseFrom(data);
        }


        public static OpenTreasureRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (OpenTreasureRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static OpenTreasureRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (OpenTreasureRequest) PARSER.parseFrom(data);
        }


        public static OpenTreasureRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (OpenTreasureRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static OpenTreasureRequest parseFrom(InputStream input) throws IOException {
            return (OpenTreasureRequest) PARSER.parseFrom(input);
        }


        public static OpenTreasureRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OpenTreasureRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static OpenTreasureRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (OpenTreasureRequest) PARSER.parseDelimitedFrom(input);
        }


        public static OpenTreasureRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OpenTreasureRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static OpenTreasureRequest parseFrom(CodedInputStream input) throws IOException {
            return (OpenTreasureRequest) PARSER.parseFrom(input);
        }


        public static OpenTreasureRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OpenTreasureRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(OpenTreasureRequest prototype) {
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
                implements TreasureHandler.OpenTreasureRequestOrBuilder {
            private int bitField0_;


            private TreasureHandler.OpenType c2SOpenType_;


            private int c2SUseDiamond_;


            public static final Descriptors.Descriptor getDescriptor() {
                return TreasureHandler.internal_static_pomelo_area_OpenTreasureRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return TreasureHandler.internal_static_pomelo_area_OpenTreasureRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(TreasureHandler.OpenTreasureRequest.class, Builder.class);
            }


            private Builder() {
                this.c2SOpenType_ = TreasureHandler.OpenType.OPEN_ONE;
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.c2SOpenType_ = TreasureHandler.OpenType.OPEN_ONE;
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (TreasureHandler.OpenTreasureRequest.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.c2SOpenType_ = TreasureHandler.OpenType.OPEN_ONE;
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SUseDiamond_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return TreasureHandler.internal_static_pomelo_area_OpenTreasureRequest_descriptor;
            }


            public TreasureHandler.OpenTreasureRequest getDefaultInstanceForType() {
                return TreasureHandler.OpenTreasureRequest.getDefaultInstance();
            }


            public TreasureHandler.OpenTreasureRequest build() {
                TreasureHandler.OpenTreasureRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public TreasureHandler.OpenTreasureRequest buildPartial() {
                TreasureHandler.OpenTreasureRequest result = new TreasureHandler.OpenTreasureRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.c2SOpenType_ = this.c2SOpenType_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.c2SUseDiamond_ = this.c2SUseDiamond_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof TreasureHandler.OpenTreasureRequest) {
                    return mergeFrom((TreasureHandler.OpenTreasureRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(TreasureHandler.OpenTreasureRequest other) {
                if (other == TreasureHandler.OpenTreasureRequest.getDefaultInstance()) {
                    return this;
                }
                if (other.hasC2SOpenType()) {
                    setC2SOpenType(other.getC2SOpenType());
                }
                if (other.hasC2SUseDiamond()) {
                    setC2SUseDiamond(other.getC2SUseDiamond());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasC2SOpenType()) {
                    return false;
                }
                if (!hasC2SUseDiamond()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                TreasureHandler.OpenTreasureRequest parsedMessage = null;
                try {
                    parsedMessage = (TreasureHandler.OpenTreasureRequest) TreasureHandler.OpenTreasureRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (TreasureHandler.OpenTreasureRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasC2SOpenType() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public TreasureHandler.OpenType getC2SOpenType() {
                return this.c2SOpenType_;
            }


            public Builder setC2SOpenType(TreasureHandler.OpenType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x1;
                this.c2SOpenType_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SOpenType() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SOpenType_ = TreasureHandler.OpenType.OPEN_ONE;
                onChanged();
                return this;
            }


            public boolean hasC2SUseDiamond() {
                return ((this.bitField0_ & 0x2) == 2);
            }


            public int getC2SUseDiamond() {
                return this.c2SUseDiamond_;
            }


            public Builder setC2SUseDiamond(int value) {
                this.bitField0_ |= 0x2;
                this.c2SUseDiamond_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SUseDiamond() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.c2SUseDiamond_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class OpenTreasureResponse
            extends GeneratedMessage
            implements OpenTreasureResponseOrBuilder {
        private static final OpenTreasureResponse defaultInstance = new OpenTreasureResponse(true);
        private final UnknownFieldSet unknownFields;

        private OpenTreasureResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private OpenTreasureResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static OpenTreasureResponse getDefaultInstance() {
            return defaultInstance;
        }

        public OpenTreasureResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private OpenTreasureResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.s2CTreasureItem_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x4;
                            }
                            this.s2CTreasureItem_.add(input.readMessage(TreasureHandler.TreasureItem.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x4) == 4)
                    this.s2CTreasureItem_ = Collections.unmodifiableList(this.s2CTreasureItem_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TreasureHandler.internal_static_pomelo_area_OpenTreasureResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TreasureHandler.internal_static_pomelo_area_OpenTreasureResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(OpenTreasureResponse.class, Builder.class);
        }

        public static Parser<OpenTreasureResponse> PARSER = (Parser<OpenTreasureResponse>) new AbstractParser<OpenTreasureResponse>() {
            public TreasureHandler.OpenTreasureResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TreasureHandler.OpenTreasureResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_TREASUREITEM_FIELD_NUMBER = 3;
        private List<TreasureHandler.TreasureItem> s2CTreasureItem_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<OpenTreasureResponse> getParserForType() {
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

        public List<TreasureHandler.TreasureItem> getS2CTreasureItemList() {
            return this.s2CTreasureItem_;
        }

        public List<? extends TreasureHandler.TreasureItemOrBuilder> getS2CTreasureItemOrBuilderList() {
            return (List) this.s2CTreasureItem_;
        }

        public int getS2CTreasureItemCount() {
            return this.s2CTreasureItem_.size();
        }

        public TreasureHandler.TreasureItem getS2CTreasureItem(int index) {
            return this.s2CTreasureItem_.get(index);
        }

        public TreasureHandler.TreasureItemOrBuilder getS2CTreasureItemOrBuilder(int index) {
            return this.s2CTreasureItem_.get(index);
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CTreasureItem_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasS2CCode()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (int i = 0; i < getS2CTreasureItemCount(); i++) {
                if (!getS2CTreasureItem(i).isInitialized()) {
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
            for (int i = 0; i < this.s2CTreasureItem_.size(); i++)
                output.writeMessage(3, (MessageLite) this.s2CTreasureItem_.get(i));
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());
            for (int i = 0; i < this.s2CTreasureItem_.size(); i++)
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.s2CTreasureItem_.get(i));
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static OpenTreasureResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (OpenTreasureResponse) PARSER.parseFrom(data);
        }

        public static OpenTreasureResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (OpenTreasureResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static OpenTreasureResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (OpenTreasureResponse) PARSER.parseFrom(data);
        }

        static {
            defaultInstance.initFields();
        }

        public static OpenTreasureResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (OpenTreasureResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static OpenTreasureResponse parseFrom(InputStream input) throws IOException {
            return (OpenTreasureResponse) PARSER.parseFrom(input);
        }

        public static OpenTreasureResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OpenTreasureResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static OpenTreasureResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (OpenTreasureResponse) PARSER.parseDelimitedFrom(input);
        }

        public static OpenTreasureResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OpenTreasureResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static OpenTreasureResponse parseFrom(CodedInputStream input) throws IOException {
            return (OpenTreasureResponse) PARSER.parseFrom(input);
        }

        public static OpenTreasureResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OpenTreasureResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(OpenTreasureResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements TreasureHandler.OpenTreasureResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private List<TreasureHandler.TreasureItem> s2CTreasureItem_;
            private RepeatedFieldBuilder<TreasureHandler.TreasureItem, TreasureHandler.TreasureItem.Builder, TreasureHandler.TreasureItemOrBuilder> s2CTreasureItemBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return TreasureHandler.internal_static_pomelo_area_OpenTreasureResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return TreasureHandler.internal_static_pomelo_area_OpenTreasureResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(TreasureHandler.OpenTreasureResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.s2CTreasureItem_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CTreasureItem_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TreasureHandler.OpenTreasureResponse.alwaysUseFieldBuilders)
                    getS2CTreasureItemFieldBuilder();
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
                if (this.s2CTreasureItemBuilder_ == null) {
                    this.s2CTreasureItem_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                } else {
                    this.s2CTreasureItemBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return TreasureHandler.internal_static_pomelo_area_OpenTreasureResponse_descriptor;
            }

            public TreasureHandler.OpenTreasureResponse getDefaultInstanceForType() {
                return TreasureHandler.OpenTreasureResponse.getDefaultInstance();
            }

            public TreasureHandler.OpenTreasureResponse build() {
                TreasureHandler.OpenTreasureResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public TreasureHandler.OpenTreasureResponse buildPartial() {
                TreasureHandler.OpenTreasureResponse result = new TreasureHandler.OpenTreasureResponse(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.s2CMsg_ = this.s2CMsg_;
                if (this.s2CTreasureItemBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4) {
                        this.s2CTreasureItem_ = Collections.unmodifiableList(this.s2CTreasureItem_);
                        this.bitField0_ &= 0xFFFFFFFB;
                    }
                    result.s2CTreasureItem_ = this.s2CTreasureItem_;
                } else {
                    result.s2CTreasureItem_ = this.s2CTreasureItemBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof TreasureHandler.OpenTreasureResponse)
                    return mergeFrom((TreasureHandler.OpenTreasureResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TreasureHandler.OpenTreasureResponse other) {
                if (other == TreasureHandler.OpenTreasureResponse.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (this.s2CTreasureItemBuilder_ == null) {
                    if (!other.s2CTreasureItem_.isEmpty()) {
                        if (this.s2CTreasureItem_.isEmpty()) {
                            this.s2CTreasureItem_ = other.s2CTreasureItem_;
                            this.bitField0_ &= 0xFFFFFFFB;
                        } else {
                            ensureS2CTreasureItemIsMutable();
                            this.s2CTreasureItem_.addAll(other.s2CTreasureItem_);
                        }
                        onChanged();
                    }
                } else if (!other.s2CTreasureItem_.isEmpty()) {
                    if (this.s2CTreasureItemBuilder_.isEmpty()) {
                        this.s2CTreasureItemBuilder_.dispose();
                        this.s2CTreasureItemBuilder_ = null;
                        this.s2CTreasureItem_ = other.s2CTreasureItem_;
                        this.bitField0_ &= 0xFFFFFFFB;
                        this.s2CTreasureItemBuilder_ = TreasureHandler.OpenTreasureResponse.alwaysUseFieldBuilders ? getS2CTreasureItemFieldBuilder() : null;
                    } else {
                        this.s2CTreasureItemBuilder_.addAllMessages(other.s2CTreasureItem_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode())
                    return false;
                for (int i = 0; i < getS2CTreasureItemCount(); i++) {
                    if (!getS2CTreasureItem(i).isInitialized())
                        return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                TreasureHandler.OpenTreasureResponse parsedMessage = null;
                try {
                    parsedMessage = (TreasureHandler.OpenTreasureResponse) TreasureHandler.OpenTreasureResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (TreasureHandler.OpenTreasureResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = TreasureHandler.OpenTreasureResponse.getDefaultInstance().getS2CMsg();
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

            private void ensureS2CTreasureItemIsMutable() {
                if ((this.bitField0_ & 0x4) != 4) {
                    this.s2CTreasureItem_ = new ArrayList<>(this.s2CTreasureItem_);
                    this.bitField0_ |= 0x4;
                }
            }

            public List<TreasureHandler.TreasureItem> getS2CTreasureItemList() {
                if (this.s2CTreasureItemBuilder_ == null)
                    return Collections.unmodifiableList(this.s2CTreasureItem_);
                return this.s2CTreasureItemBuilder_.getMessageList();
            }

            public int getS2CTreasureItemCount() {
                if (this.s2CTreasureItemBuilder_ == null)
                    return this.s2CTreasureItem_.size();
                return this.s2CTreasureItemBuilder_.getCount();
            }

            public TreasureHandler.TreasureItem getS2CTreasureItem(int index) {
                if (this.s2CTreasureItemBuilder_ == null)
                    return this.s2CTreasureItem_.get(index);
                return (TreasureHandler.TreasureItem) this.s2CTreasureItemBuilder_.getMessage(index);
            }

            public Builder setS2CTreasureItem(int index, TreasureHandler.TreasureItem value) {
                if (this.s2CTreasureItemBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CTreasureItemIsMutable();
                    this.s2CTreasureItem_.set(index, value);
                    onChanged();
                } else {
                    this.s2CTreasureItemBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setS2CTreasureItem(int index, TreasureHandler.TreasureItem.Builder builderForValue) {
                if (this.s2CTreasureItemBuilder_ == null) {
                    ensureS2CTreasureItemIsMutable();
                    this.s2CTreasureItem_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CTreasureItemBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addS2CTreasureItem(TreasureHandler.TreasureItem value) {
                if (this.s2CTreasureItemBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CTreasureItemIsMutable();
                    this.s2CTreasureItem_.add(value);
                    onChanged();
                } else {
                    this.s2CTreasureItemBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addS2CTreasureItem(int index, TreasureHandler.TreasureItem value) {
                if (this.s2CTreasureItemBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CTreasureItemIsMutable();
                    this.s2CTreasureItem_.add(index, value);
                    onChanged();
                } else {
                    this.s2CTreasureItemBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addS2CTreasureItem(TreasureHandler.TreasureItem.Builder builderForValue) {
                if (this.s2CTreasureItemBuilder_ == null) {
                    ensureS2CTreasureItemIsMutable();
                    this.s2CTreasureItem_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.s2CTreasureItemBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addS2CTreasureItem(int index, TreasureHandler.TreasureItem.Builder builderForValue) {
                if (this.s2CTreasureItemBuilder_ == null) {
                    ensureS2CTreasureItemIsMutable();
                    this.s2CTreasureItem_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CTreasureItemBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllS2CTreasureItem(Iterable<? extends TreasureHandler.TreasureItem> values) {
                if (this.s2CTreasureItemBuilder_ == null) {
                    ensureS2CTreasureItemIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.s2CTreasureItem_);
                    onChanged();
                } else {
                    this.s2CTreasureItemBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearS2CTreasureItem() {
                if (this.s2CTreasureItemBuilder_ == null) {
                    this.s2CTreasureItem_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                    onChanged();
                } else {
                    this.s2CTreasureItemBuilder_.clear();
                }
                return this;
            }

            public Builder removeS2CTreasureItem(int index) {
                if (this.s2CTreasureItemBuilder_ == null) {
                    ensureS2CTreasureItemIsMutable();
                    this.s2CTreasureItem_.remove(index);
                    onChanged();
                } else {
                    this.s2CTreasureItemBuilder_.remove(index);
                }
                return this;
            }

            public TreasureHandler.TreasureItem.Builder getS2CTreasureItemBuilder(int index) {
                return (TreasureHandler.TreasureItem.Builder) getS2CTreasureItemFieldBuilder().getBuilder(index);
            }

            public TreasureHandler.TreasureItemOrBuilder getS2CTreasureItemOrBuilder(int index) {
                if (this.s2CTreasureItemBuilder_ == null)
                    return this.s2CTreasureItem_.get(index);
                return (TreasureHandler.TreasureItemOrBuilder) this.s2CTreasureItemBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends TreasureHandler.TreasureItemOrBuilder> getS2CTreasureItemOrBuilderList() {
                if (this.s2CTreasureItemBuilder_ != null)
                    return this.s2CTreasureItemBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.s2CTreasureItem_);
            }

            public TreasureHandler.TreasureItem.Builder addS2CTreasureItemBuilder() {
                return (TreasureHandler.TreasureItem.Builder) getS2CTreasureItemFieldBuilder().addBuilder(TreasureHandler.TreasureItem.getDefaultInstance());
            }

            public TreasureHandler.TreasureItem.Builder addS2CTreasureItemBuilder(int index) {
                return (TreasureHandler.TreasureItem.Builder) getS2CTreasureItemFieldBuilder().addBuilder(index, TreasureHandler.TreasureItem.getDefaultInstance());
            }

            public List<TreasureHandler.TreasureItem.Builder> getS2CTreasureItemBuilderList() {
                return getS2CTreasureItemFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<TreasureHandler.TreasureItem, TreasureHandler.TreasureItem.Builder, TreasureHandler.TreasureItemOrBuilder> getS2CTreasureItemFieldBuilder() {
                if (this.s2CTreasureItemBuilder_ == null) {
                    this.s2CTreasureItemBuilder_ = new RepeatedFieldBuilder(this.s2CTreasureItem_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
                    this.s2CTreasureItem_ = null;
                }
                return this.s2CTreasureItemBuilder_;
            }
        }
    }

    public static final class ReceiveTreasureBagRequest extends GeneratedMessage implements ReceiveTreasureBagRequestOrBuilder {
        private static final ReceiveTreasureBagRequest defaultInstance = new ReceiveTreasureBagRequest(true);
        private final UnknownFieldSet unknownFields;

        private ReceiveTreasureBagRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private ReceiveTreasureBagRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static ReceiveTreasureBagRequest getDefaultInstance() {
            return defaultInstance;
        }

        public ReceiveTreasureBagRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ReceiveTreasureBagRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return TreasureHandler.internal_static_pomelo_area_ReceiveTreasureBagRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TreasureHandler.internal_static_pomelo_area_ReceiveTreasureBagRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ReceiveTreasureBagRequest.class, Builder.class);
        }

        public static Parser<ReceiveTreasureBagRequest> PARSER = (Parser<ReceiveTreasureBagRequest>) new AbstractParser<ReceiveTreasureBagRequest>() {
            public TreasureHandler.ReceiveTreasureBagRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TreasureHandler.ReceiveTreasureBagRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<ReceiveTreasureBagRequest> getParserForType() {
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


        public static ReceiveTreasureBagRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ReceiveTreasureBagRequest) PARSER.parseFrom(data);
        }


        public static ReceiveTreasureBagRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ReceiveTreasureBagRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static ReceiveTreasureBagRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ReceiveTreasureBagRequest) PARSER.parseFrom(data);
        }


        public static ReceiveTreasureBagRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ReceiveTreasureBagRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static ReceiveTreasureBagRequest parseFrom(InputStream input) throws IOException {
            return (ReceiveTreasureBagRequest) PARSER.parseFrom(input);
        }


        public static ReceiveTreasureBagRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReceiveTreasureBagRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static ReceiveTreasureBagRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (ReceiveTreasureBagRequest) PARSER.parseDelimitedFrom(input);
        }


        public static ReceiveTreasureBagRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReceiveTreasureBagRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static ReceiveTreasureBagRequest parseFrom(CodedInputStream input) throws IOException {
            return (ReceiveTreasureBagRequest) PARSER.parseFrom(input);
        }


        public static ReceiveTreasureBagRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReceiveTreasureBagRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(ReceiveTreasureBagRequest prototype) {
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
                implements TreasureHandler.ReceiveTreasureBagRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return TreasureHandler.internal_static_pomelo_area_ReceiveTreasureBagRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return TreasureHandler.internal_static_pomelo_area_ReceiveTreasureBagRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(TreasureHandler.ReceiveTreasureBagRequest.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (TreasureHandler.ReceiveTreasureBagRequest.alwaysUseFieldBuilders) ;
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
                return TreasureHandler.internal_static_pomelo_area_ReceiveTreasureBagRequest_descriptor;
            }


            public TreasureHandler.ReceiveTreasureBagRequest getDefaultInstanceForType() {
                return TreasureHandler.ReceiveTreasureBagRequest.getDefaultInstance();
            }


            public TreasureHandler.ReceiveTreasureBagRequest build() {
                TreasureHandler.ReceiveTreasureBagRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public TreasureHandler.ReceiveTreasureBagRequest buildPartial() {
                TreasureHandler.ReceiveTreasureBagRequest result = new TreasureHandler.ReceiveTreasureBagRequest(this);
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof TreasureHandler.ReceiveTreasureBagRequest) {
                    return mergeFrom((TreasureHandler.ReceiveTreasureBagRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(TreasureHandler.ReceiveTreasureBagRequest other) {
                if (other == TreasureHandler.ReceiveTreasureBagRequest.getDefaultInstance()) {
                    return this;
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                TreasureHandler.ReceiveTreasureBagRequest parsedMessage = null;
                try {
                    parsedMessage = (TreasureHandler.ReceiveTreasureBagRequest) TreasureHandler.ReceiveTreasureBagRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (TreasureHandler.ReceiveTreasureBagRequest) e.getUnfinishedMessage();
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


    public static final class ReceiveTreasureBagResponse
            extends GeneratedMessage
            implements ReceiveTreasureBagResponseOrBuilder {
        private static final ReceiveTreasureBagResponse defaultInstance = new ReceiveTreasureBagResponse(true);
        private final UnknownFieldSet unknownFields;

        private ReceiveTreasureBagResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private ReceiveTreasureBagResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static ReceiveTreasureBagResponse getDefaultInstance() {
            return defaultInstance;
        }

        public ReceiveTreasureBagResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ReceiveTreasureBagResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return TreasureHandler.internal_static_pomelo_area_ReceiveTreasureBagResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TreasureHandler.internal_static_pomelo_area_ReceiveTreasureBagResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ReceiveTreasureBagResponse.class, Builder.class);
        }

        public static Parser<ReceiveTreasureBagResponse> PARSER = (Parser<ReceiveTreasureBagResponse>) new AbstractParser<ReceiveTreasureBagResponse>() {
            public TreasureHandler.ReceiveTreasureBagResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TreasureHandler.ReceiveTreasureBagResponse(input, extensionRegistry);
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

        public Parser<ReceiveTreasureBagResponse> getParserForType() {
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

        public static ReceiveTreasureBagResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ReceiveTreasureBagResponse) PARSER.parseFrom(data);
        }

        public static ReceiveTreasureBagResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ReceiveTreasureBagResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static ReceiveTreasureBagResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ReceiveTreasureBagResponse) PARSER.parseFrom(data);
        }

        public static ReceiveTreasureBagResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ReceiveTreasureBagResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static ReceiveTreasureBagResponse parseFrom(InputStream input) throws IOException {
            return (ReceiveTreasureBagResponse) PARSER.parseFrom(input);
        }

        static {
            defaultInstance.initFields();
        }

        public static ReceiveTreasureBagResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReceiveTreasureBagResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static ReceiveTreasureBagResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (ReceiveTreasureBagResponse) PARSER.parseDelimitedFrom(input);
        }

        public static ReceiveTreasureBagResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReceiveTreasureBagResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static ReceiveTreasureBagResponse parseFrom(CodedInputStream input) throws IOException {
            return (ReceiveTreasureBagResponse) PARSER.parseFrom(input);
        }

        public static ReceiveTreasureBagResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReceiveTreasureBagResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(ReceiveTreasureBagResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements TreasureHandler.ReceiveTreasureBagResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;

            public static final Descriptors.Descriptor getDescriptor() {
                return TreasureHandler.internal_static_pomelo_area_ReceiveTreasureBagResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return TreasureHandler.internal_static_pomelo_area_ReceiveTreasureBagResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(TreasureHandler.ReceiveTreasureBagResponse.class, Builder.class);
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
                if (TreasureHandler.ReceiveTreasureBagResponse.alwaysUseFieldBuilders) ;
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
                return TreasureHandler.internal_static_pomelo_area_ReceiveTreasureBagResponse_descriptor;
            }

            public TreasureHandler.ReceiveTreasureBagResponse getDefaultInstanceForType() {
                return TreasureHandler.ReceiveTreasureBagResponse.getDefaultInstance();
            }

            public TreasureHandler.ReceiveTreasureBagResponse build() {
                TreasureHandler.ReceiveTreasureBagResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public TreasureHandler.ReceiveTreasureBagResponse buildPartial() {
                TreasureHandler.ReceiveTreasureBagResponse result = new TreasureHandler.ReceiveTreasureBagResponse(this);
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
                if (other instanceof TreasureHandler.ReceiveTreasureBagResponse)
                    return mergeFrom((TreasureHandler.ReceiveTreasureBagResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TreasureHandler.ReceiveTreasureBagResponse other) {
                if (other == TreasureHandler.ReceiveTreasureBagResponse.getDefaultInstance())
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
                TreasureHandler.ReceiveTreasureBagResponse parsedMessage = null;
                try {
                    parsedMessage = (TreasureHandler.ReceiveTreasureBagResponse) TreasureHandler.ReceiveTreasureBagResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (TreasureHandler.ReceiveTreasureBagResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = TreasureHandler.ReceiveTreasureBagResponse.getDefaultInstance().getS2CMsg();
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

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }


    static {
        String[] descriptorData = {"\n\025treasureHandler.proto\022\013pomelo.area\"P\n\fTreasureItem\022\020\n\bitemCode\030\001 \002(\t\022\017\n\007itemNum\030\002 \002(\005\022\016\n\006isBind\030\003 \001(\005\022\r\n\005score\030\004 \001(\005\"1\n\026GetTreasureInfoRequest\022\027\n\017c2s_treasureMsg\030\001 \002(\005\"r\n\027GetTreasureInfoResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\033\n\023s2c_treasureBagSize\030\003 \002(\005\022\027\n\017s2c_treasureMsg\030\004 \003(\t\"\033\n\031GetTreasureBagInfoRequest\"s\n\032GetTreasureBagInfoResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\0222\n\017s2c_treasureBag\030\003", " \003(\0132\031.pomelo.area.TreasureItem\"Z\n\023OpenTreasureRequest\022+\n\fc2s_openType\030\001 \002(\0162\025.pomelo.area.OpenType\022\026\n\016c2s_useDiamond\030\002 \002(\005\"n\n\024OpenTreasureResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\0223\n\020s2c_treasureItem\030\003 \003(\0132\031.pomelo.area.TreasureItem\"\033\n\031ReceiveTreasureBagRequest\"?\n\032ReceiveTreasureBagResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t*&\n\bOpenType\022\f\n\bOPEN_ONE\020\001\022\f\n\bOPEN_TEN\020\0022®\003\n\017treasureHandler\022c\n\026getTrea", "sureInfoRequest\022#.pomelo.area.GetTreasureInfoRequest\032$.pomelo.area.GetTreasureInfoResponse\022l\n\031getTreasureBagInfoRequest\022&.pomelo.area.GetTreasureBagInfoRequest\032'.pomelo.area.GetTreasureBagInfoResponse\022Z\n\023openTreasureRequest\022 .pomelo.area.OpenTreasureRequest\032!.pomelo.area.OpenTreasureResponse\022l\n\031receiveTreasureBagRequest\022&.pomelo.area.ReceiveTreasureBagRequest\032'.pomelo.area.ReceiveTreasureBagRespon", "se"};


        Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root) {
                TreasureHandler.descriptor = root;
                return null;
            }
        };

        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[0], assigner);
    }


    private static final Descriptors.Descriptor internal_static_pomelo_area_TreasureItem_descriptor = getDescriptor().getMessageTypes().get(0);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_TreasureItem_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_TreasureItem_descriptor, new String[]{"ItemCode", "ItemNum", "IsBind", "Score"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetTreasureInfoRequest_descriptor = getDescriptor().getMessageTypes().get(1);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetTreasureInfoRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetTreasureInfoRequest_descriptor, new String[]{"C2STreasureMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetTreasureInfoResponse_descriptor = getDescriptor().getMessageTypes().get(2);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetTreasureInfoResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetTreasureInfoResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CTreasureBagSize", "S2CTreasureMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetTreasureBagInfoRequest_descriptor = getDescriptor().getMessageTypes().get(3);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetTreasureBagInfoRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetTreasureBagInfoRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetTreasureBagInfoResponse_descriptor = getDescriptor().getMessageTypes().get(4);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetTreasureBagInfoResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetTreasureBagInfoResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CTreasureBag"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_OpenTreasureRequest_descriptor = getDescriptor().getMessageTypes().get(5);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_OpenTreasureRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_OpenTreasureRequest_descriptor, new String[]{"C2SOpenType", "C2SUseDiamond"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_OpenTreasureResponse_descriptor = getDescriptor().getMessageTypes().get(6);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_OpenTreasureResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_OpenTreasureResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CTreasureItem"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_ReceiveTreasureBagRequest_descriptor = getDescriptor().getMessageTypes().get(7);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ReceiveTreasureBagRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ReceiveTreasureBagRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_area_ReceiveTreasureBagResponse_descriptor = getDescriptor().getMessageTypes().get(8);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ReceiveTreasureBagResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ReceiveTreasureBagResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});
    private static Descriptors.FileDescriptor descriptor;

    public static interface ReceiveTreasureBagResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface ReceiveTreasureBagRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface OpenTreasureResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        List<TreasureHandler.TreasureItem> getS2CTreasureItemList();

        TreasureHandler.TreasureItem getS2CTreasureItem(int param1Int);

        int getS2CTreasureItemCount();

        List<? extends TreasureHandler.TreasureItemOrBuilder> getS2CTreasureItemOrBuilderList();

        TreasureHandler.TreasureItemOrBuilder getS2CTreasureItemOrBuilder(int param1Int);
    }

    public static interface OpenTreasureRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2SOpenType();

        TreasureHandler.OpenType getC2SOpenType();

        boolean hasC2SUseDiamond();

        int getC2SUseDiamond();
    }

    public static interface GetTreasureBagInfoResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        List<TreasureHandler.TreasureItem> getS2CTreasureBagList();

        TreasureHandler.TreasureItem getS2CTreasureBag(int param1Int);

        int getS2CTreasureBagCount();

        List<? extends TreasureHandler.TreasureItemOrBuilder> getS2CTreasureBagOrBuilderList();

        TreasureHandler.TreasureItemOrBuilder getS2CTreasureBagOrBuilder(int param1Int);
    }

    public static interface GetTreasureBagInfoRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface GetTreasureInfoResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasS2CTreasureBagSize();

        int getS2CTreasureBagSize();

        ProtocolStringList getS2CTreasureMsgList();

        int getS2CTreasureMsgCount();

        String getS2CTreasureMsg(int param1Int);

        ByteString getS2CTreasureMsgBytes(int param1Int);
    }

    public static interface GetTreasureInfoRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2STreasureMsg();

        int getC2STreasureMsg();
    }

    public static interface TreasureItemOrBuilder extends MessageOrBuilder {
        boolean hasItemCode();

        String getItemCode();

        ByteString getItemCodeBytes();

        boolean hasItemNum();

        int getItemNum();

        boolean hasIsBind();

        int getIsBind();

        boolean hasScore();

        int getScore();
    }
}


