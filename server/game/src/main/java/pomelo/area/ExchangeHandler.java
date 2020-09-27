package pomelo.area;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.UnknownFieldSet;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import pomelo.item.ItemOuterClass;

public final class ExchangeHandler {
    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public enum ConditionType implements ProtocolMessageEnum {
        CONDITION_LEVEL(0, 1),


        CONDITION_UP_REQ(1, 2),


        CONDITION_VIP_LEVEL(2, 3),


        CONDITION_RACE(3, 4),


        CONDITION_RACE_CLASS(4, 5),


        CONDITION_ARENA_SCORE(5, 6),


        CONDITION_GUILD_HONOR(6, 7);


        public static final int CONDITION_LEVEL_VALUE = 1;


        public static final int CONDITION_UP_REQ_VALUE = 2;


        public static final int CONDITION_VIP_LEVEL_VALUE = 3;


        public static final int CONDITION_RACE_VALUE = 4;


        public static final int CONDITION_RACE_CLASS_VALUE = 5;


        public static final int CONDITION_ARENA_SCORE_VALUE = 6;


        public static final int CONDITION_GUILD_HONOR_VALUE = 7;


        private static Internal.EnumLiteMap<ConditionType> internalValueMap = new Internal.EnumLiteMap<ConditionType>() {
            public ExchangeHandler.ConditionType findValueByNumber(int number) {
                return ExchangeHandler.ConditionType.valueOf(number);
            }
        };


        private static final ConditionType[] VALUES = values();
        private final int index;
        private final int value;

        public final int getNumber() {
            return this.value;
        }

        public static Internal.EnumLiteMap<ConditionType> internalGetValueMap() {
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
            return ExchangeHandler.getDescriptor().getEnumTypes().get(0);
        }

        ConditionType(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }


    public enum MoneyType
            implements ProtocolMessageEnum {
        MT_GOLD(0, 1),


        MT_DIAMOND(1, 2),


        MT_TICKET(2, 3),


        MT_FEE_POINT(3, 4),


        MT_TREASURE_POINT(4, 8);


        public static final int MT_GOLD_VALUE = 1;


        public static final int MT_DIAMOND_VALUE = 2;


        public static final int MT_TICKET_VALUE = 3;


        public static final int MT_FEE_POINT_VALUE = 4;


        public static final int MT_TREASURE_POINT_VALUE = 8;


        private static Internal.EnumLiteMap<MoneyType> internalValueMap = new Internal.EnumLiteMap<MoneyType>() {
            public ExchangeHandler.MoneyType findValueByNumber(int number) {
                return ExchangeHandler.MoneyType.valueOf(number);
            }
        };


        private static final MoneyType[] VALUES = values();
        private final int index;
        private final int value;

        public final int getNumber() {
            return this.value;
        }

        public static Internal.EnumLiteMap<MoneyType> internalGetValueMap() {
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
            return ExchangeHandler.getDescriptor().getEnumTypes().get(1);
        }

        MoneyType(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }


    public static final class GetExchangeLabelRequest
            extends GeneratedMessage
            implements GetExchangeLabelRequestOrBuilder {
        private static final GetExchangeLabelRequest defaultInstance = new GetExchangeLabelRequest(true);
        private final UnknownFieldSet unknownFields;

        private GetExchangeLabelRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetExchangeLabelRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetExchangeLabelRequest getDefaultInstance() {
            return defaultInstance;
        }

        public GetExchangeLabelRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetExchangeLabelRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.c2SNpcId_ = bs;
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
            return ExchangeHandler.internal_static_pomelo_area_GetExchangeLabelRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ExchangeHandler.internal_static_pomelo_area_GetExchangeLabelRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetExchangeLabelRequest.class, Builder.class);
        }

        public static Parser<GetExchangeLabelRequest> PARSER = (Parser<GetExchangeLabelRequest>) new AbstractParser<GetExchangeLabelRequest>() {
            public ExchangeHandler.GetExchangeLabelRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ExchangeHandler.GetExchangeLabelRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_NPCID_FIELD_NUMBER = 1;
        private Object c2SNpcId_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetExchangeLabelRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasC2SNpcId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public String getC2SNpcId() {
            Object ref = this.c2SNpcId_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.c2SNpcId_ = s;
            return s;
        }

        public ByteString getC2SNpcIdBytes() {
            Object ref = this.c2SNpcId_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.c2SNpcId_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        private void initFields() {
            this.c2SNpcId_ = "";
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasC2SNpcId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeBytes(1, getC2SNpcIdBytes());
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeBytesSize(1, getC2SNpcIdBytes());
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static GetExchangeLabelRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetExchangeLabelRequest) PARSER.parseFrom(data);
        }

        public static GetExchangeLabelRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetExchangeLabelRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetExchangeLabelRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetExchangeLabelRequest) PARSER.parseFrom(data);
        }

        public static GetExchangeLabelRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetExchangeLabelRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetExchangeLabelRequest parseFrom(InputStream input) throws IOException {
            return (GetExchangeLabelRequest) PARSER.parseFrom(input);
        }

        public static GetExchangeLabelRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetExchangeLabelRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static GetExchangeLabelRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (GetExchangeLabelRequest) PARSER.parseDelimitedFrom(input);
        }

        public static GetExchangeLabelRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetExchangeLabelRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static GetExchangeLabelRequest parseFrom(CodedInputStream input) throws IOException {
            return (GetExchangeLabelRequest) PARSER.parseFrom(input);
        }

        public static GetExchangeLabelRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetExchangeLabelRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(GetExchangeLabelRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements ExchangeHandler.GetExchangeLabelRequestOrBuilder {
            private int bitField0_;
            private Object c2SNpcId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ExchangeHandler.internal_static_pomelo_area_GetExchangeLabelRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return ExchangeHandler.internal_static_pomelo_area_GetExchangeLabelRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ExchangeHandler.GetExchangeLabelRequest.class, Builder.class);
            }

            private Builder() {
                this.c2SNpcId_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.c2SNpcId_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ExchangeHandler.GetExchangeLabelRequest.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.c2SNpcId_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return ExchangeHandler.internal_static_pomelo_area_GetExchangeLabelRequest_descriptor;
            }

            public ExchangeHandler.GetExchangeLabelRequest getDefaultInstanceForType() {
                return ExchangeHandler.GetExchangeLabelRequest.getDefaultInstance();
            }

            public ExchangeHandler.GetExchangeLabelRequest build() {
                ExchangeHandler.GetExchangeLabelRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public ExchangeHandler.GetExchangeLabelRequest buildPartial() {
                ExchangeHandler.GetExchangeLabelRequest result = new ExchangeHandler.GetExchangeLabelRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.c2SNpcId_ = this.c2SNpcId_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof ExchangeHandler.GetExchangeLabelRequest)
                    return mergeFrom((ExchangeHandler.GetExchangeLabelRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ExchangeHandler.GetExchangeLabelRequest other) {
                if (other == ExchangeHandler.GetExchangeLabelRequest.getDefaultInstance()) return this;
                if (other.hasC2SNpcId()) {
                    this.bitField0_ |= 0x1;
                    this.c2SNpcId_ = other.c2SNpcId_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasC2SNpcId()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                ExchangeHandler.GetExchangeLabelRequest parsedMessage = null;
                try {
                    parsedMessage = (ExchangeHandler.GetExchangeLabelRequest) ExchangeHandler.GetExchangeLabelRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (ExchangeHandler.GetExchangeLabelRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasC2SNpcId() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public String getC2SNpcId() {
                Object ref = this.c2SNpcId_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) this.c2SNpcId_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getC2SNpcIdBytes() {
                Object ref = this.c2SNpcId_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.c2SNpcId_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setC2SNpcId(String value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.c2SNpcId_ = value;
                onChanged();
                return this;
            }

            public Builder clearC2SNpcId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SNpcId_ = ExchangeHandler.GetExchangeLabelRequest.getDefaultInstance().getC2SNpcId();
                onChanged();
                return this;
            }

            public Builder setC2SNpcIdBytes(ByteString value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.c2SNpcId_ = value;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class GetExchangeListRequest
            extends GeneratedMessage
            implements GetExchangeListRequestOrBuilder {
        private static final GetExchangeListRequest defaultInstance = new GetExchangeListRequest(true);
        private final UnknownFieldSet unknownFields;

        private GetExchangeListRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetExchangeListRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetExchangeListRequest getDefaultInstance() {
            return defaultInstance;
        }

        public GetExchangeListRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetExchangeListRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.c2SNpcId_ = bs;
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.c2STypeId_ = input.readInt32();
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
            return ExchangeHandler.internal_static_pomelo_area_GetExchangeListRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ExchangeHandler.internal_static_pomelo_area_GetExchangeListRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetExchangeListRequest.class, Builder.class);
        }

        public static Parser<GetExchangeListRequest> PARSER = (Parser<GetExchangeListRequest>) new AbstractParser<GetExchangeListRequest>() {
            public ExchangeHandler.GetExchangeListRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ExchangeHandler.GetExchangeListRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_NPCID_FIELD_NUMBER = 1;
        private Object c2SNpcId_;
        public static final int C2S_TYPEID_FIELD_NUMBER = 2;
        private int c2STypeId_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetExchangeListRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasC2SNpcId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public String getC2SNpcId() {
            Object ref = this.c2SNpcId_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.c2SNpcId_ = s;
            return s;
        }

        public ByteString getC2SNpcIdBytes() {
            Object ref = this.c2SNpcId_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.c2SNpcId_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasC2STypeId() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public int getC2STypeId() {
            return this.c2STypeId_;
        }

        private void initFields() {
            this.c2SNpcId_ = "";
            this.c2STypeId_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasC2SNpcId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasC2STypeId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeBytes(1, getC2SNpcIdBytes());
            if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.c2STypeId_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeBytesSize(1, getC2SNpcIdBytes());
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(2, this.c2STypeId_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static GetExchangeListRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetExchangeListRequest) PARSER.parseFrom(data);
        }

        public static GetExchangeListRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetExchangeListRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetExchangeListRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetExchangeListRequest) PARSER.parseFrom(data);
        }

        public static GetExchangeListRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetExchangeListRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetExchangeListRequest parseFrom(InputStream input) throws IOException {
            return (GetExchangeListRequest) PARSER.parseFrom(input);
        }

        public static GetExchangeListRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetExchangeListRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static GetExchangeListRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (GetExchangeListRequest) PARSER.parseDelimitedFrom(input);
        }

        public static GetExchangeListRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetExchangeListRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static GetExchangeListRequest parseFrom(CodedInputStream input) throws IOException {
            return (GetExchangeListRequest) PARSER.parseFrom(input);
        }

        public static GetExchangeListRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetExchangeListRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(GetExchangeListRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements ExchangeHandler.GetExchangeListRequestOrBuilder {
            private int bitField0_;
            private Object c2SNpcId_;
            private int c2STypeId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ExchangeHandler.internal_static_pomelo_area_GetExchangeListRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return ExchangeHandler.internal_static_pomelo_area_GetExchangeListRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ExchangeHandler.GetExchangeListRequest.class, Builder.class);
            }

            private Builder() {
                this.c2SNpcId_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.c2SNpcId_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ExchangeHandler.GetExchangeListRequest.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.c2SNpcId_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2STypeId_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return ExchangeHandler.internal_static_pomelo_area_GetExchangeListRequest_descriptor;
            }

            public ExchangeHandler.GetExchangeListRequest getDefaultInstanceForType() {
                return ExchangeHandler.GetExchangeListRequest.getDefaultInstance();
            }

            public ExchangeHandler.GetExchangeListRequest build() {
                ExchangeHandler.GetExchangeListRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public ExchangeHandler.GetExchangeListRequest buildPartial() {
                ExchangeHandler.GetExchangeListRequest result = new ExchangeHandler.GetExchangeListRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.c2SNpcId_ = this.c2SNpcId_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.c2STypeId_ = this.c2STypeId_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof ExchangeHandler.GetExchangeListRequest)
                    return mergeFrom((ExchangeHandler.GetExchangeListRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ExchangeHandler.GetExchangeListRequest other) {
                if (other == ExchangeHandler.GetExchangeListRequest.getDefaultInstance()) return this;
                if (other.hasC2SNpcId()) {
                    this.bitField0_ |= 0x1;
                    this.c2SNpcId_ = other.c2SNpcId_;
                    onChanged();
                }
                if (other.hasC2STypeId()) setC2STypeId(other.getC2STypeId());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasC2SNpcId()) return false;
                if (!hasC2STypeId()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                ExchangeHandler.GetExchangeListRequest parsedMessage = null;
                try {
                    parsedMessage = (ExchangeHandler.GetExchangeListRequest) ExchangeHandler.GetExchangeListRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (ExchangeHandler.GetExchangeListRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasC2SNpcId() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public String getC2SNpcId() {
                Object ref = this.c2SNpcId_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) this.c2SNpcId_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getC2SNpcIdBytes() {
                Object ref = this.c2SNpcId_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.c2SNpcId_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setC2SNpcId(String value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.c2SNpcId_ = value;
                onChanged();
                return this;
            }

            public Builder clearC2SNpcId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SNpcId_ = ExchangeHandler.GetExchangeListRequest.getDefaultInstance().getC2SNpcId();
                onChanged();
                return this;
            }

            public Builder setC2SNpcIdBytes(ByteString value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.c2SNpcId_ = value;
                onChanged();
                return this;
            }

            public boolean hasC2STypeId() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getC2STypeId() {
                return this.c2STypeId_;
            }

            public Builder setC2STypeId(int value) {
                this.bitField0_ |= 0x2;
                this.c2STypeId_ = value;
                onChanged();
                return this;
            }

            public Builder clearC2STypeId() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.c2STypeId_ = 0;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class ExchangeItemRequest
            extends GeneratedMessage
            implements ExchangeItemRequestOrBuilder {
        private static final ExchangeItemRequest defaultInstance = new ExchangeItemRequest(true);
        private final UnknownFieldSet unknownFields;

        private ExchangeItemRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private ExchangeItemRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static ExchangeItemRequest getDefaultInstance() {
            return defaultInstance;
        }

        public ExchangeItemRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ExchangeItemRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.c2STypeId_ = input.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.c2SItemId_ = input.readInt32();
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.c2SNum_ = input.readInt32();
                            break;
                        case 34:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x8;
                            this.c2SNpcId_ = bs;
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
            return ExchangeHandler.internal_static_pomelo_area_ExchangeItemRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ExchangeHandler.internal_static_pomelo_area_ExchangeItemRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ExchangeItemRequest.class, Builder.class);
        }

        public static Parser<ExchangeItemRequest> PARSER = (Parser<ExchangeItemRequest>) new AbstractParser<ExchangeItemRequest>() {
            public ExchangeHandler.ExchangeItemRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ExchangeHandler.ExchangeItemRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_TYPEID_FIELD_NUMBER = 1;
        private int c2STypeId_;
        public static final int C2S_ITEMID_FIELD_NUMBER = 2;
        private int c2SItemId_;
        public static final int C2S_NUM_FIELD_NUMBER = 3;
        private int c2SNum_;
        public static final int C2S_NPCID_FIELD_NUMBER = 4;
        private Object c2SNpcId_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<ExchangeItemRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasC2STypeId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getC2STypeId() {
            return this.c2STypeId_;
        }

        public boolean hasC2SItemId() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public int getC2SItemId() {
            return this.c2SItemId_;
        }

        public boolean hasC2SNum() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getC2SNum() {
            return this.c2SNum_;
        }

        public boolean hasC2SNpcId() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public String getC2SNpcId() {
            Object ref = this.c2SNpcId_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.c2SNpcId_ = s;
            return s;
        }

        public ByteString getC2SNpcIdBytes() {
            Object ref = this.c2SNpcId_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.c2SNpcId_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        private void initFields() {
            this.c2STypeId_ = 0;
            this.c2SItemId_ = 0;
            this.c2SNum_ = 0;
            this.c2SNpcId_ = "";
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasC2STypeId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasC2SItemId()) {
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
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.c2STypeId_);
            if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.c2SItemId_);
            if ((this.bitField0_ & 0x4) == 4) output.writeInt32(3, this.c2SNum_);
            if ((this.bitField0_ & 0x8) == 8) output.writeBytes(4, getC2SNpcIdBytes());
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.c2STypeId_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(2, this.c2SItemId_);
            if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeInt32Size(3, this.c2SNum_);
            if ((this.bitField0_ & 0x8) == 8) size += CodedOutputStream.computeBytesSize(4, getC2SNpcIdBytes());
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static ExchangeItemRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ExchangeItemRequest) PARSER.parseFrom(data);
        }

        public static ExchangeItemRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ExchangeItemRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static ExchangeItemRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ExchangeItemRequest) PARSER.parseFrom(data);
        }

        public static ExchangeItemRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ExchangeItemRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static ExchangeItemRequest parseFrom(InputStream input) throws IOException {
            return (ExchangeItemRequest) PARSER.parseFrom(input);
        }

        public static ExchangeItemRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ExchangeItemRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static ExchangeItemRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (ExchangeItemRequest) PARSER.parseDelimitedFrom(input);
        }

        public static ExchangeItemRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ExchangeItemRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static ExchangeItemRequest parseFrom(CodedInputStream input) throws IOException {
            return (ExchangeItemRequest) PARSER.parseFrom(input);
        }

        public static ExchangeItemRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ExchangeItemRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(ExchangeItemRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements ExchangeHandler.ExchangeItemRequestOrBuilder {
            private int bitField0_;
            private int c2STypeId_;
            private int c2SItemId_;
            private int c2SNum_;
            private Object c2SNpcId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ExchangeHandler.internal_static_pomelo_area_ExchangeItemRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return ExchangeHandler.internal_static_pomelo_area_ExchangeItemRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ExchangeHandler.ExchangeItemRequest.class, Builder.class);
            }

            private Builder() {
                this.c2SNpcId_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.c2SNpcId_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ExchangeHandler.ExchangeItemRequest.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.c2STypeId_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SItemId_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                this.c2SNum_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.c2SNpcId_ = "";
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return ExchangeHandler.internal_static_pomelo_area_ExchangeItemRequest_descriptor;
            }

            public ExchangeHandler.ExchangeItemRequest getDefaultInstanceForType() {
                return ExchangeHandler.ExchangeItemRequest.getDefaultInstance();
            }

            public ExchangeHandler.ExchangeItemRequest build() {
                ExchangeHandler.ExchangeItemRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public ExchangeHandler.ExchangeItemRequest buildPartial() {
                ExchangeHandler.ExchangeItemRequest result = new ExchangeHandler.ExchangeItemRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.c2STypeId_ = this.c2STypeId_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.c2SItemId_ = this.c2SItemId_;
                if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;
                result.c2SNum_ = this.c2SNum_;
                if ((from_bitField0_ & 0x8) == 8) to_bitField0_ |= 0x8;
                result.c2SNpcId_ = this.c2SNpcId_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof ExchangeHandler.ExchangeItemRequest)
                    return mergeFrom((ExchangeHandler.ExchangeItemRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ExchangeHandler.ExchangeItemRequest other) {
                if (other == ExchangeHandler.ExchangeItemRequest.getDefaultInstance()) return this;
                if (other.hasC2STypeId()) setC2STypeId(other.getC2STypeId());
                if (other.hasC2SItemId()) setC2SItemId(other.getC2SItemId());
                if (other.hasC2SNum()) setC2SNum(other.getC2SNum());
                if (other.hasC2SNpcId()) {
                    this.bitField0_ |= 0x8;
                    this.c2SNpcId_ = other.c2SNpcId_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasC2STypeId()) return false;
                if (!hasC2SItemId()) return false;
                if (!hasC2SNum()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                ExchangeHandler.ExchangeItemRequest parsedMessage = null;
                try {
                    parsedMessage = (ExchangeHandler.ExchangeItemRequest) ExchangeHandler.ExchangeItemRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (ExchangeHandler.ExchangeItemRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasC2STypeId() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getC2STypeId() {
                return this.c2STypeId_;
            }

            public Builder setC2STypeId(int value) {
                this.bitField0_ |= 0x1;
                this.c2STypeId_ = value;
                onChanged();
                return this;
            }

            public Builder clearC2STypeId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2STypeId_ = 0;
                onChanged();
                return this;
            }

            public boolean hasC2SItemId() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getC2SItemId() {
                return this.c2SItemId_;
            }

            public Builder setC2SItemId(int value) {
                this.bitField0_ |= 0x2;
                this.c2SItemId_ = value;
                onChanged();
                return this;
            }

            public Builder clearC2SItemId() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.c2SItemId_ = 0;
                onChanged();
                return this;
            }

            public boolean hasC2SNum() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public int getC2SNum() {
                return this.c2SNum_;
            }

            public Builder setC2SNum(int value) {
                this.bitField0_ |= 0x4;
                this.c2SNum_ = value;
                onChanged();
                return this;
            }

            public Builder clearC2SNum() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.c2SNum_ = 0;
                onChanged();
                return this;
            }

            public boolean hasC2SNpcId() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public String getC2SNpcId() {
                Object ref = this.c2SNpcId_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) this.c2SNpcId_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getC2SNpcIdBytes() {
                Object ref = this.c2SNpcId_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.c2SNpcId_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setC2SNpcId(String value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x8;
                this.c2SNpcId_ = value;
                onChanged();
                return this;
            }

            public Builder clearC2SNpcId() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.c2SNpcId_ = ExchangeHandler.ExchangeItemRequest.getDefaultInstance().getC2SNpcId();
                onChanged();
                return this;
            }

            public Builder setC2SNpcIdBytes(ByteString value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x8;
                this.c2SNpcId_ = value;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class Condition
            extends GeneratedMessage
            implements ConditionOrBuilder {
        private static final Condition defaultInstance = new Condition(true);
        private final UnknownFieldSet unknownFields;

        private Condition(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Condition(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Condition getDefaultInstance() {
            return defaultInstance;
        }

        public Condition getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Condition(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int rawValue;
                    ExchangeHandler.ConditionType value;
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        case 8:
                            rawValue = input.readEnum();
                            value = ExchangeHandler.ConditionType.valueOf(rawValue);
                            if (value == null) {
                                unknownFields.mergeVarintField(1, rawValue);
                                break;
                            }
                            this.bitField0_ |= 0x1;
                            this.type_ = value;
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
            return ExchangeHandler.internal_static_pomelo_area_Condition_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ExchangeHandler.internal_static_pomelo_area_Condition_fieldAccessorTable.ensureFieldAccessorsInitialized(Condition.class, Builder.class);
        }

        public static Parser<Condition> PARSER = (Parser<Condition>) new AbstractParser<Condition>() {
            public ExchangeHandler.Condition parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ExchangeHandler.Condition(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int TYPE_FIELD_NUMBER = 1;
        private ExchangeHandler.ConditionType type_;
        public static final int NUMBER_FIELD_NUMBER = 2;
        private int number_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<Condition> getParserForType() {
            return PARSER;
        }

        public boolean hasType() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public ExchangeHandler.ConditionType getType() {
            return this.type_;
        }

        public boolean hasNumber() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public int getNumber() {
            return this.number_;
        }

        private void initFields() {
            this.type_ = ExchangeHandler.ConditionType.CONDITION_LEVEL;
            this.number_ = 0;
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
            if ((this.bitField0_ & 0x1) == 1) output.writeEnum(1, this.type_.getNumber());
            if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.number_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeEnumSize(1, this.type_.getNumber());
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(2, this.number_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static Condition parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Condition) PARSER.parseFrom(data);
        }

        public static Condition parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Condition) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Condition parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Condition) PARSER.parseFrom(data);
        }

        public static Condition parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Condition) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Condition parseFrom(InputStream input) throws IOException {
            return (Condition) PARSER.parseFrom(input);
        }

        public static Condition parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Condition) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Condition parseDelimitedFrom(InputStream input) throws IOException {
            return (Condition) PARSER.parseDelimitedFrom(input);
        }

        public static Condition parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Condition) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Condition parseFrom(CodedInputStream input) throws IOException {
            return (Condition) PARSER.parseFrom(input);
        }

        public static Condition parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Condition) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Condition prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements ExchangeHandler.ConditionOrBuilder {
            private int bitField0_;
            private ExchangeHandler.ConditionType type_;
            private int number_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ExchangeHandler.internal_static_pomelo_area_Condition_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return ExchangeHandler.internal_static_pomelo_area_Condition_fieldAccessorTable.ensureFieldAccessorsInitialized(ExchangeHandler.Condition.class, Builder.class);
            }

            private Builder() {
                this.type_ = ExchangeHandler.ConditionType.CONDITION_LEVEL;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.type_ = ExchangeHandler.ConditionType.CONDITION_LEVEL;
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ExchangeHandler.Condition.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.type_ = ExchangeHandler.ConditionType.CONDITION_LEVEL;
                this.bitField0_ &= 0xFFFFFFFE;
                this.number_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return ExchangeHandler.internal_static_pomelo_area_Condition_descriptor;
            }

            public ExchangeHandler.Condition getDefaultInstanceForType() {
                return ExchangeHandler.Condition.getDefaultInstance();
            }

            public ExchangeHandler.Condition build() {
                ExchangeHandler.Condition result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public ExchangeHandler.Condition buildPartial() {
                ExchangeHandler.Condition result = new ExchangeHandler.Condition(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.type_ = this.type_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.number_ = this.number_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof ExchangeHandler.Condition) return mergeFrom((ExchangeHandler.Condition) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ExchangeHandler.Condition other) {
                if (other == ExchangeHandler.Condition.getDefaultInstance()) return this;
                if (other.hasType()) setType(other.getType());
                if (other.hasNumber()) setNumber(other.getNumber());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                ExchangeHandler.Condition parsedMessage = null;
                try {
                    parsedMessage = (ExchangeHandler.Condition) ExchangeHandler.Condition.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (ExchangeHandler.Condition) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasType() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public ExchangeHandler.ConditionType getType() {
                return this.type_;
            }

            public Builder setType(ExchangeHandler.ConditionType value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.type_ = value;
                onChanged();
                return this;
            }

            public Builder clearType() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.type_ = ExchangeHandler.ConditionType.CONDITION_LEVEL;
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

        static {
            defaultInstance.initFields();
        }

    }


    public static final class MoneyInfo
            extends GeneratedMessage
            implements MoneyInfoOrBuilder {
        private static final MoneyInfo defaultInstance = new MoneyInfo(true);
        private final UnknownFieldSet unknownFields;

        private MoneyInfo(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private MoneyInfo(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static MoneyInfo getDefaultInstance() {
            return defaultInstance;
        }

        public MoneyInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MoneyInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int rawValue;
                    ExchangeHandler.MoneyType value;
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        case 8:
                            rawValue = input.readEnum();
                            value = ExchangeHandler.MoneyType.valueOf(rawValue);
                            if (value == null) {
                                unknownFields.mergeVarintField(1, rawValue);
                                break;
                            }
                            this.bitField0_ |= 0x1;
                            this.type_ = value;
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
            return ExchangeHandler.internal_static_pomelo_area_MoneyInfo_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ExchangeHandler.internal_static_pomelo_area_MoneyInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(MoneyInfo.class, Builder.class);
        }

        public static Parser<MoneyInfo> PARSER = (Parser<MoneyInfo>) new AbstractParser<MoneyInfo>() {
            public ExchangeHandler.MoneyInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ExchangeHandler.MoneyInfo(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int TYPE_FIELD_NUMBER = 1;
        private ExchangeHandler.MoneyType type_;
        public static final int VALUE_FIELD_NUMBER = 2;
        private int value_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<MoneyInfo> getParserForType() {
            return PARSER;
        }

        public boolean hasType() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public ExchangeHandler.MoneyType getType() {
            return this.type_;
        }

        public boolean hasValue() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public int getValue() {
            return this.value_;
        }

        private void initFields() {
            this.type_ = ExchangeHandler.MoneyType.MT_GOLD;
            this.value_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
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
            if ((this.bitField0_ & 0x1) == 1) output.writeEnum(1, this.type_.getNumber());
            if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.value_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeEnumSize(1, this.type_.getNumber());
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(2, this.value_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static MoneyInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (MoneyInfo) PARSER.parseFrom(data);
        }

        public static MoneyInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MoneyInfo) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MoneyInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (MoneyInfo) PARSER.parseFrom(data);
        }

        public static MoneyInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MoneyInfo) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MoneyInfo parseFrom(InputStream input) throws IOException {
            return (MoneyInfo) PARSER.parseFrom(input);
        }

        public static MoneyInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MoneyInfo) PARSER.parseFrom(input, extensionRegistry);
        }

        public static MoneyInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (MoneyInfo) PARSER.parseDelimitedFrom(input);
        }

        public static MoneyInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MoneyInfo) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static MoneyInfo parseFrom(CodedInputStream input) throws IOException {
            return (MoneyInfo) PARSER.parseFrom(input);
        }

        public static MoneyInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MoneyInfo) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(MoneyInfo prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements ExchangeHandler.MoneyInfoOrBuilder {
            private int bitField0_;
            private ExchangeHandler.MoneyType type_;
            private int value_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ExchangeHandler.internal_static_pomelo_area_MoneyInfo_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return ExchangeHandler.internal_static_pomelo_area_MoneyInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ExchangeHandler.MoneyInfo.class, Builder.class);
            }

            private Builder() {
                this.type_ = ExchangeHandler.MoneyType.MT_GOLD;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.type_ = ExchangeHandler.MoneyType.MT_GOLD;
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ExchangeHandler.MoneyInfo.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.type_ = ExchangeHandler.MoneyType.MT_GOLD;
                this.bitField0_ &= 0xFFFFFFFE;
                this.value_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return ExchangeHandler.internal_static_pomelo_area_MoneyInfo_descriptor;
            }

            public ExchangeHandler.MoneyInfo getDefaultInstanceForType() {
                return ExchangeHandler.MoneyInfo.getDefaultInstance();
            }

            public ExchangeHandler.MoneyInfo build() {
                ExchangeHandler.MoneyInfo result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public ExchangeHandler.MoneyInfo buildPartial() {
                ExchangeHandler.MoneyInfo result = new ExchangeHandler.MoneyInfo(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.type_ = this.type_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.value_ = this.value_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof ExchangeHandler.MoneyInfo) return mergeFrom((ExchangeHandler.MoneyInfo) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ExchangeHandler.MoneyInfo other) {
                if (other == ExchangeHandler.MoneyInfo.getDefaultInstance()) return this;
                if (other.hasType()) setType(other.getType());
                if (other.hasValue()) setValue(other.getValue());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasType()) return false;
                if (!hasValue()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                ExchangeHandler.MoneyInfo parsedMessage = null;
                try {
                    parsedMessage = (ExchangeHandler.MoneyInfo) ExchangeHandler.MoneyInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (ExchangeHandler.MoneyInfo) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasType() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public ExchangeHandler.MoneyType getType() {
                return this.type_;
            }

            public Builder setType(ExchangeHandler.MoneyType value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.type_ = value;
                onChanged();
                return this;
            }

            public Builder clearType() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.type_ = ExchangeHandler.MoneyType.MT_GOLD;
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

        static {
            defaultInstance.initFields();
        }

    }


    public static final class ExchangeInfo
            extends GeneratedMessage
            implements ExchangeInfoOrBuilder {
        private static final ExchangeInfo defaultInstance = new ExchangeInfo(true);
        private final UnknownFieldSet unknownFields;

        private ExchangeInfo(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private ExchangeInfo(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static ExchangeInfo getDefaultInstance() {
            return defaultInstance;
        }

        public ExchangeInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ExchangeInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.typeId_ = input.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.itemId_ = input.readInt32();
                            break;
                        case 26:
                            byteString1 = input.readBytes();
                            this.bitField0_ |= 0x4;
                            this.itemShowName_ = byteString1;
                            break;
                        case 34:
                            subBuilder = null;
                            if ((this.bitField0_ & 0x8) == 8) subBuilder = this.item_.toBuilder();
                            this.item_ = (ItemOuterClass.MiniItem) input.readMessage(ItemOuterClass.MiniItem.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.item_);
                                this.item_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 0x8;
                            break;
                        case 40:
                            this.bitField0_ |= 0x10;
                            this.scoreRatio_ = input.readInt32();
                            break;
                        case 50:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x20;
                            this.itemDes_ = bs;
                            break;
                        case 58:
                            if ((mutable_bitField0_ & 0x40) != 64) {
                                this.condition_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x40;
                            }
                            this.condition_.add(input.readMessage(ExchangeHandler.Condition.PARSER, extensionRegistry));
                            break;
                        case 66:
                            if ((mutable_bitField0_ & 0x80) != 128) {
                                this.needMoney_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x80;
                            }
                            this.needMoney_.add(input.readMessage(ExchangeHandler.MoneyInfo.PARSER, extensionRegistry));
                            break;
                        case 74:
                            if ((mutable_bitField0_ & 0x100) != 256) {
                                this.needItem_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x100;
                            }
                            this.needItem_.add(input.readMessage(ItemOuterClass.MiniItem.PARSER, extensionRegistry));
                            break;
                        case 80:
                            this.bitField0_ |= 0x40;
                            this.meetCondition_ = input.readInt32();
                            break;
                        case 88:
                            this.bitField0_ |= 0x80;
                            this.maxExchangeNum_ = input.readInt32();
                            break;
                        case 96:
                            this.bitField0_ |= 0x100;
                            this.state_ = input.readInt32();
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x40) == 64) this.condition_ = Collections.unmodifiableList(this.condition_);
                if ((mutable_bitField0_ & 0x80) == 128) this.needMoney_ = Collections.unmodifiableList(this.needMoney_);
                if ((mutable_bitField0_ & 0x100) == 256) this.needItem_ = Collections.unmodifiableList(this.needItem_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ExchangeHandler.internal_static_pomelo_area_ExchangeInfo_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ExchangeHandler.internal_static_pomelo_area_ExchangeInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ExchangeInfo.class, Builder.class);
        }

        public static Parser<ExchangeInfo> PARSER = (Parser<ExchangeInfo>) new AbstractParser<ExchangeInfo>() {
            public ExchangeHandler.ExchangeInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ExchangeHandler.ExchangeInfo(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int TYPEID_FIELD_NUMBER = 1;
        private int typeId_;
        public static final int ITEMID_FIELD_NUMBER = 2;
        private int itemId_;
        public static final int ITEMSHOWNAME_FIELD_NUMBER = 3;
        private Object itemShowName_;
        public static final int ITEM_FIELD_NUMBER = 4;
        private ItemOuterClass.MiniItem item_;
        public static final int SCORERATIO_FIELD_NUMBER = 5;
        private int scoreRatio_;
        public static final int ITEMDES_FIELD_NUMBER = 6;
        private Object itemDes_;
        public static final int CONDITION_FIELD_NUMBER = 7;
        private List<ExchangeHandler.Condition> condition_;
        public static final int NEEDMONEY_FIELD_NUMBER = 8;
        private List<ExchangeHandler.MoneyInfo> needMoney_;
        public static final int NEEDITEM_FIELD_NUMBER = 9;
        private List<ItemOuterClass.MiniItem> needItem_;
        public static final int MEETCONDITION_FIELD_NUMBER = 10;
        private int meetCondition_;
        public static final int MAXEXCHANGENUM_FIELD_NUMBER = 11;
        private int maxExchangeNum_;
        public static final int STATE_FIELD_NUMBER = 12;
        private int state_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<ExchangeInfo> getParserForType() {
            return PARSER;
        }

        public boolean hasTypeId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getTypeId() {
            return this.typeId_;
        }

        public boolean hasItemId() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public int getItemId() {
            return this.itemId_;
        }

        public boolean hasItemShowName() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public String getItemShowName() {
            Object ref = this.itemShowName_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.itemShowName_ = s;
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
            return ((this.bitField0_ & 0x8) == 8);
        }

        public ItemOuterClass.MiniItem getItem() {
            return this.item_;
        }

        public ItemOuterClass.MiniItemOrBuilder getItemOrBuilder() {
            return (ItemOuterClass.MiniItemOrBuilder) this.item_;
        }

        public boolean hasScoreRatio() {
            return ((this.bitField0_ & 0x10) == 16);
        }

        public int getScoreRatio() {
            return this.scoreRatio_;
        }

        public boolean hasItemDes() {
            return ((this.bitField0_ & 0x20) == 32);
        }

        public String getItemDes() {
            Object ref = this.itemDes_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.itemDes_ = s;
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

        public List<ExchangeHandler.Condition> getConditionList() {
            return this.condition_;
        }

        public List<? extends ExchangeHandler.ConditionOrBuilder> getConditionOrBuilderList() {
            return (List) this.condition_;
        }

        public int getConditionCount() {
            return this.condition_.size();
        }

        public ExchangeHandler.Condition getCondition(int index) {
            return this.condition_.get(index);
        }

        public ExchangeHandler.ConditionOrBuilder getConditionOrBuilder(int index) {
            return this.condition_.get(index);
        }

        public List<ExchangeHandler.MoneyInfo> getNeedMoneyList() {
            return this.needMoney_;
        }

        public List<? extends ExchangeHandler.MoneyInfoOrBuilder> getNeedMoneyOrBuilderList() {
            return (List) this.needMoney_;
        }

        public int getNeedMoneyCount() {
            return this.needMoney_.size();
        }

        public ExchangeHandler.MoneyInfo getNeedMoney(int index) {
            return this.needMoney_.get(index);
        }

        public ExchangeHandler.MoneyInfoOrBuilder getNeedMoneyOrBuilder(int index) {
            return this.needMoney_.get(index);
        }

        public List<ItemOuterClass.MiniItem> getNeedItemList() {
            return this.needItem_;
        }

        public List<? extends ItemOuterClass.MiniItemOrBuilder> getNeedItemOrBuilderList() {
            return (List) this.needItem_;
        }

        public int getNeedItemCount() {
            return this.needItem_.size();
        }

        public ItemOuterClass.MiniItem getNeedItem(int index) {
            return this.needItem_.get(index);
        }

        public ItemOuterClass.MiniItemOrBuilder getNeedItemOrBuilder(int index) {
            return (ItemOuterClass.MiniItemOrBuilder) this.needItem_.get(index);
        }

        public boolean hasMeetCondition() {
            return ((this.bitField0_ & 0x40) == 64);
        }

        public int getMeetCondition() {
            return this.meetCondition_;
        }

        public boolean hasMaxExchangeNum() {
            return ((this.bitField0_ & 0x80) == 128);
        }

        static {
            defaultInstance.initFields();
        }

        public int getMaxExchangeNum() {
            return this.maxExchangeNum_;
        }

        public boolean hasState() {
            return ((this.bitField0_ & 0x100) == 256);
        }

        public int getState() {
            return this.state_;
        }

        private void initFields() {
            this.typeId_ = 0;
            this.itemId_ = 0;
            this.itemShowName_ = "";
            this.item_ = ItemOuterClass.MiniItem.getDefaultInstance();
            this.scoreRatio_ = 0;
            this.itemDes_ = "";
            this.condition_ = Collections.emptyList();
            this.needMoney_ = Collections.emptyList();
            this.needItem_ = Collections.emptyList();
            this.meetCondition_ = 0;
            this.maxExchangeNum_ = 0;
            this.state_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1)
                return true;
            if (isInitialized == 0)
                return false;
            if (hasItem() && !getItem().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            int i;
            for (i = 0; i < getNeedMoneyCount(); i++) {
                if (!getNeedMoney(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (i = 0; i < getNeedItemCount(); i++) {
                if (!getNeedItem(i).isInitialized()) {
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
                output.writeInt32(1, this.typeId_);
            if ((this.bitField0_ & 0x2) == 2)
                output.writeInt32(2, this.itemId_);
            if ((this.bitField0_ & 0x4) == 4)
                output.writeBytes(3, getItemShowNameBytes());
            if ((this.bitField0_ & 0x8) == 8)
                output.writeMessage(4, (MessageLite) this.item_);
            if ((this.bitField0_ & 0x10) == 16)
                output.writeInt32(5, this.scoreRatio_);
            if ((this.bitField0_ & 0x20) == 32)
                output.writeBytes(6, getItemDesBytes());
            int i;
            for (i = 0; i < this.condition_.size(); i++)
                output.writeMessage(7, (MessageLite) this.condition_.get(i));
            for (i = 0; i < this.needMoney_.size(); i++)
                output.writeMessage(8, (MessageLite) this.needMoney_.get(i));
            for (i = 0; i < this.needItem_.size(); i++)
                output.writeMessage(9, (MessageLite) this.needItem_.get(i));
            if ((this.bitField0_ & 0x40) == 64)
                output.writeInt32(10, this.meetCondition_);
            if ((this.bitField0_ & 0x80) == 128)
                output.writeInt32(11, this.maxExchangeNum_);
            if ((this.bitField0_ & 0x100) == 256)
                output.writeInt32(12, this.state_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1)
                return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1)
                size += CodedOutputStream.computeInt32Size(1, this.typeId_);
            if ((this.bitField0_ & 0x2) == 2)
                size += CodedOutputStream.computeInt32Size(2, this.itemId_);
            if ((this.bitField0_ & 0x4) == 4)
                size += CodedOutputStream.computeBytesSize(3, getItemShowNameBytes());
            if ((this.bitField0_ & 0x8) == 8)
                size += CodedOutputStream.computeMessageSize(4, (MessageLite) this.item_);
            if ((this.bitField0_ & 0x10) == 16)
                size += CodedOutputStream.computeInt32Size(5, this.scoreRatio_);
            if ((this.bitField0_ & 0x20) == 32)
                size += CodedOutputStream.computeBytesSize(6, getItemDesBytes());
            int i;
            for (i = 0; i < this.condition_.size(); i++)
                size += CodedOutputStream.computeMessageSize(7, (MessageLite) this.condition_.get(i));
            for (i = 0; i < this.needMoney_.size(); i++)
                size += CodedOutputStream.computeMessageSize(8, (MessageLite) this.needMoney_.get(i));
            for (i = 0; i < this.needItem_.size(); i++)
                size += CodedOutputStream.computeMessageSize(9, (MessageLite) this.needItem_.get(i));
            if ((this.bitField0_ & 0x40) == 64)
                size += CodedOutputStream.computeInt32Size(10, this.meetCondition_);
            if ((this.bitField0_ & 0x80) == 128)
                size += CodedOutputStream.computeInt32Size(11, this.maxExchangeNum_);
            if ((this.bitField0_ & 0x100) == 256)
                size += CodedOutputStream.computeInt32Size(12, this.state_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static ExchangeInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ExchangeInfo) PARSER.parseFrom(data);
        }

        public static ExchangeInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ExchangeInfo) PARSER.parseFrom(data, extensionRegistry);
        }

        public static ExchangeInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ExchangeInfo) PARSER.parseFrom(data);
        }

        public static ExchangeInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ExchangeInfo) PARSER.parseFrom(data, extensionRegistry);
        }

        public static ExchangeInfo parseFrom(InputStream input) throws IOException {
            return (ExchangeInfo) PARSER.parseFrom(input);
        }

        public static ExchangeInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ExchangeInfo) PARSER.parseFrom(input, extensionRegistry);
        }

        public static ExchangeInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (ExchangeInfo) PARSER.parseDelimitedFrom(input);
        }

        public static ExchangeInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ExchangeInfo) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static ExchangeInfo parseFrom(CodedInputStream input) throws IOException {
            return (ExchangeInfo) PARSER.parseFrom(input);
        }

        public static ExchangeInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ExchangeInfo) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(ExchangeInfo prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements ExchangeHandler.ExchangeInfoOrBuilder {
            private int bitField0_;
            private int typeId_;
            private int itemId_;
            private Object itemShowName_;
            private ItemOuterClass.MiniItem item_;
            private SingleFieldBuilder<ItemOuterClass.MiniItem, ItemOuterClass.MiniItem.Builder, ItemOuterClass.MiniItemOrBuilder> itemBuilder_;
            private int scoreRatio_;
            private Object itemDes_;
            private List<ExchangeHandler.Condition> condition_;
            private RepeatedFieldBuilder<ExchangeHandler.Condition, ExchangeHandler.Condition.Builder, ExchangeHandler.ConditionOrBuilder> conditionBuilder_;
            private List<ExchangeHandler.MoneyInfo> needMoney_;
            private RepeatedFieldBuilder<ExchangeHandler.MoneyInfo, ExchangeHandler.MoneyInfo.Builder, ExchangeHandler.MoneyInfoOrBuilder> needMoneyBuilder_;
            private List<ItemOuterClass.MiniItem> needItem_;
            private RepeatedFieldBuilder<ItemOuterClass.MiniItem, ItemOuterClass.MiniItem.Builder, ItemOuterClass.MiniItemOrBuilder> needItemBuilder_;
            private int meetCondition_;
            private int maxExchangeNum_;
            private int state_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ExchangeHandler.internal_static_pomelo_area_ExchangeInfo_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return ExchangeHandler.internal_static_pomelo_area_ExchangeInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ExchangeHandler.ExchangeInfo.class, Builder.class);
            }

            private Builder() {
                this.itemShowName_ = "";
                this.item_ = ItemOuterClass.MiniItem.getDefaultInstance();
                this.itemDes_ = "";
                this.condition_ = Collections.emptyList();
                this.needMoney_ = Collections.emptyList();
                this.needItem_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.itemShowName_ = "";
                this.item_ = ItemOuterClass.MiniItem.getDefaultInstance();
                this.itemDes_ = "";
                this.condition_ = Collections.emptyList();
                this.needMoney_ = Collections.emptyList();
                this.needItem_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ExchangeHandler.ExchangeInfo.alwaysUseFieldBuilders) {
                    getItemFieldBuilder();
                    getConditionFieldBuilder();
                    getNeedMoneyFieldBuilder();
                    getNeedItemFieldBuilder();
                }
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.typeId_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.itemId_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                this.itemShowName_ = "";
                this.bitField0_ &= 0xFFFFFFFB;
                if (this.itemBuilder_ == null) {
                    this.item_ = ItemOuterClass.MiniItem.getDefaultInstance();
                } else {
                    this.itemBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFF7;
                this.scoreRatio_ = 0;
                this.bitField0_ &= 0xFFFFFFEF;
                this.itemDes_ = "";
                this.bitField0_ &= 0xFFFFFFDF;
                if (this.conditionBuilder_ == null) {
                    this.condition_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFBF;
                } else {
                    this.conditionBuilder_.clear();
                }
                if (this.needMoneyBuilder_ == null) {
                    this.needMoney_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFF7F;
                } else {
                    this.needMoneyBuilder_.clear();
                }
                if (this.needItemBuilder_ == null) {
                    this.needItem_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFEFF;
                } else {
                    this.needItemBuilder_.clear();
                }
                this.meetCondition_ = 0;
                this.bitField0_ &= 0xFFFFFDFF;
                this.maxExchangeNum_ = 0;
                this.bitField0_ &= 0xFFFFFBFF;
                this.state_ = 0;
                this.bitField0_ &= 0xFFFFF7FF;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return ExchangeHandler.internal_static_pomelo_area_ExchangeInfo_descriptor;
            }

            public ExchangeHandler.ExchangeInfo getDefaultInstanceForType() {
                return ExchangeHandler.ExchangeInfo.getDefaultInstance();
            }

            public ExchangeHandler.ExchangeInfo build() {
                ExchangeHandler.ExchangeInfo result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public ExchangeHandler.ExchangeInfo buildPartial() {
                ExchangeHandler.ExchangeInfo result = new ExchangeHandler.ExchangeInfo(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.typeId_ = this.typeId_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.itemId_ = this.itemId_;
                if ((from_bitField0_ & 0x4) == 4)
                    to_bitField0_ |= 0x4;
                result.itemShowName_ = this.itemShowName_;
                if ((from_bitField0_ & 0x8) == 8)
                    to_bitField0_ |= 0x8;
                if (this.itemBuilder_ == null) {
                    result.item_ = this.item_;
                } else {
                    result.item_ = (ItemOuterClass.MiniItem) this.itemBuilder_.build();
                }
                if ((from_bitField0_ & 0x10) == 16)
                    to_bitField0_ |= 0x10;
                result.scoreRatio_ = this.scoreRatio_;
                if ((from_bitField0_ & 0x20) == 32)
                    to_bitField0_ |= 0x20;
                result.itemDes_ = this.itemDes_;
                if (this.conditionBuilder_ == null) {
                    if ((this.bitField0_ & 0x40) == 64) {
                        this.condition_ = Collections.unmodifiableList(this.condition_);
                        this.bitField0_ &= 0xFFFFFFBF;
                    }
                    result.condition_ = this.condition_;
                } else {
                    result.condition_ = this.conditionBuilder_.build();
                }
                if (this.needMoneyBuilder_ == null) {
                    if ((this.bitField0_ & 0x80) == 128) {
                        this.needMoney_ = Collections.unmodifiableList(this.needMoney_);
                        this.bitField0_ &= 0xFFFFFF7F;
                    }
                    result.needMoney_ = this.needMoney_;
                } else {
                    result.needMoney_ = this.needMoneyBuilder_.build();
                }
                if (this.needItemBuilder_ == null) {
                    if ((this.bitField0_ & 0x100) == 256) {
                        this.needItem_ = Collections.unmodifiableList(this.needItem_);
                        this.bitField0_ &= 0xFFFFFEFF;
                    }
                    result.needItem_ = this.needItem_;
                } else {
                    result.needItem_ = this.needItemBuilder_.build();
                }
                if ((from_bitField0_ & 0x200) == 512)
                    to_bitField0_ |= 0x40;
                result.meetCondition_ = this.meetCondition_;
                if ((from_bitField0_ & 0x400) == 1024)
                    to_bitField0_ |= 0x80;
                result.maxExchangeNum_ = this.maxExchangeNum_;
                if ((from_bitField0_ & 0x800) == 2048)
                    to_bitField0_ |= 0x100;
                result.state_ = this.state_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof ExchangeHandler.ExchangeInfo)
                    return mergeFrom((ExchangeHandler.ExchangeInfo) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ExchangeHandler.ExchangeInfo other) {
                if (other == ExchangeHandler.ExchangeInfo.getDefaultInstance())
                    return this;
                if (other.hasTypeId())
                    setTypeId(other.getTypeId());
                if (other.hasItemId())
                    setItemId(other.getItemId());
                if (other.hasItemShowName()) {
                    this.bitField0_ |= 0x4;
                    this.itemShowName_ = other.itemShowName_;
                    onChanged();
                }
                if (other.hasItem())
                    mergeItem(other.getItem());
                if (other.hasScoreRatio())
                    setScoreRatio(other.getScoreRatio());
                if (other.hasItemDes()) {
                    this.bitField0_ |= 0x20;
                    this.itemDes_ = other.itemDes_;
                    onChanged();
                }
                if (this.conditionBuilder_ == null) {
                    if (!other.condition_.isEmpty()) {
                        if (this.condition_.isEmpty()) {
                            this.condition_ = other.condition_;
                            this.bitField0_ &= 0xFFFFFFBF;
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
                        this.bitField0_ &= 0xFFFFFFBF;
                        this.conditionBuilder_ = ExchangeHandler.ExchangeInfo.alwaysUseFieldBuilders ? getConditionFieldBuilder() : null;
                    } else {
                        this.conditionBuilder_.addAllMessages(other.condition_);
                    }
                }
                if (this.needMoneyBuilder_ == null) {
                    if (!other.needMoney_.isEmpty()) {
                        if (this.needMoney_.isEmpty()) {
                            this.needMoney_ = other.needMoney_;
                            this.bitField0_ &= 0xFFFFFF7F;
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
                        this.bitField0_ &= 0xFFFFFF7F;
                        this.needMoneyBuilder_ = ExchangeHandler.ExchangeInfo.alwaysUseFieldBuilders ? getNeedMoneyFieldBuilder() : null;
                    } else {
                        this.needMoneyBuilder_.addAllMessages(other.needMoney_);
                    }
                }
                if (this.needItemBuilder_ == null) {
                    if (!other.needItem_.isEmpty()) {
                        if (this.needItem_.isEmpty()) {
                            this.needItem_ = other.needItem_;
                            this.bitField0_ &= 0xFFFFFEFF;
                        } else {
                            ensureNeedItemIsMutable();
                            this.needItem_.addAll(other.needItem_);
                        }
                        onChanged();
                    }
                } else if (!other.needItem_.isEmpty()) {
                    if (this.needItemBuilder_.isEmpty()) {
                        this.needItemBuilder_.dispose();
                        this.needItemBuilder_ = null;
                        this.needItem_ = other.needItem_;
                        this.bitField0_ &= 0xFFFFFEFF;
                        this.needItemBuilder_ = ExchangeHandler.ExchangeInfo.alwaysUseFieldBuilders ? getNeedItemFieldBuilder() : null;
                    } else {
                        this.needItemBuilder_.addAllMessages(other.needItem_);
                    }
                }
                if (other.hasMeetCondition())
                    setMeetCondition(other.getMeetCondition());
                if (other.hasMaxExchangeNum())
                    setMaxExchangeNum(other.getMaxExchangeNum());
                if (other.hasState())
                    setState(other.getState());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (hasItem() && !getItem().isInitialized())
                    return false;
                int i;
                for (i = 0; i < getNeedMoneyCount(); i++) {
                    if (!getNeedMoney(i).isInitialized())
                        return false;
                }
                for (i = 0; i < getNeedItemCount(); i++) {
                    if (!getNeedItem(i).isInitialized())
                        return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                ExchangeHandler.ExchangeInfo parsedMessage = null;
                try {
                    parsedMessage = (ExchangeHandler.ExchangeInfo) ExchangeHandler.ExchangeInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (ExchangeHandler.ExchangeInfo) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null)
                        mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasTypeId() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getTypeId() {
                return this.typeId_;
            }

            public Builder setTypeId(int value) {
                this.bitField0_ |= 0x1;
                this.typeId_ = value;
                onChanged();
                return this;
            }

            public Builder clearTypeId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.typeId_ = 0;
                onChanged();
                return this;
            }

            public boolean hasItemId() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getItemId() {
                return this.itemId_;
            }

            public Builder setItemId(int value) {
                this.bitField0_ |= 0x2;
                this.itemId_ = value;
                onChanged();
                return this;
            }

            public Builder clearItemId() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.itemId_ = 0;
                onChanged();
                return this;
            }

            public boolean hasItemShowName() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public String getItemShowName() {
                Object ref = this.itemShowName_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.itemShowName_ = s;
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
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x4;
                this.itemShowName_ = value;
                onChanged();
                return this;
            }

            public Builder clearItemShowName() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.itemShowName_ = ExchangeHandler.ExchangeInfo.getDefaultInstance().getItemShowName();
                onChanged();
                return this;
            }

            public Builder setItemShowNameBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x4;
                this.itemShowName_ = value;
                onChanged();
                return this;
            }

            public boolean hasItem() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public ItemOuterClass.MiniItem getItem() {
                if (this.itemBuilder_ == null)
                    return this.item_;
                return (ItemOuterClass.MiniItem) this.itemBuilder_.getMessage();
            }

            public Builder setItem(ItemOuterClass.MiniItem value) {
                if (this.itemBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    this.item_ = value;
                    onChanged();
                } else {
                    this.itemBuilder_.setMessage((GeneratedMessage) value);
                }
                this.bitField0_ |= 0x8;
                return this;
            }

            public Builder setItem(ItemOuterClass.MiniItem.Builder builderForValue) {
                if (this.itemBuilder_ == null) {
                    this.item_ = builderForValue.build();
                    onChanged();
                } else {
                    this.itemBuilder_.setMessage((GeneratedMessage) builderForValue.build());
                }
                this.bitField0_ |= 0x8;
                return this;
            }

            public Builder mergeItem(ItemOuterClass.MiniItem value) {
                if (this.itemBuilder_ == null) {
                    if ((this.bitField0_ & 0x8) == 8 && this.item_ != ItemOuterClass.MiniItem.getDefaultInstance()) {
                        this.item_ = ItemOuterClass.MiniItem.newBuilder(this.item_).mergeFrom(value).buildPartial();
                    } else {
                        this.item_ = value;
                    }
                    onChanged();
                } else {
                    this.itemBuilder_.mergeFrom((GeneratedMessage) value);
                }
                this.bitField0_ |= 0x8;
                return this;
            }

            public Builder clearItem() {
                if (this.itemBuilder_ == null) {
                    this.item_ = ItemOuterClass.MiniItem.getDefaultInstance();
                    onChanged();
                } else {
                    this.itemBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }

            public ItemOuterClass.MiniItem.Builder getItemBuilder() {
                this.bitField0_ |= 0x8;
                onChanged();
                return (ItemOuterClass.MiniItem.Builder) getItemFieldBuilder().getBuilder();
            }

            public ItemOuterClass.MiniItemOrBuilder getItemOrBuilder() {
                if (this.itemBuilder_ != null)
                    return (ItemOuterClass.MiniItemOrBuilder) this.itemBuilder_.getMessageOrBuilder();
                return (ItemOuterClass.MiniItemOrBuilder) this.item_;
            }

            private SingleFieldBuilder<ItemOuterClass.MiniItem, ItemOuterClass.MiniItem.Builder, ItemOuterClass.MiniItemOrBuilder> getItemFieldBuilder() {
                if (this.itemBuilder_ == null) {
                    this.itemBuilder_ = new SingleFieldBuilder((GeneratedMessage) getItem(), getParentForChildren(), isClean());
                    this.item_ = null;
                }
                return this.itemBuilder_;
            }

            public boolean hasScoreRatio() {
                return ((this.bitField0_ & 0x10) == 16);
            }

            public int getScoreRatio() {
                return this.scoreRatio_;
            }

            public Builder setScoreRatio(int value) {
                this.bitField0_ |= 0x10;
                this.scoreRatio_ = value;
                onChanged();
                return this;
            }

            public Builder clearScoreRatio() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.scoreRatio_ = 0;
                onChanged();
                return this;
            }

            public boolean hasItemDes() {
                return ((this.bitField0_ & 0x20) == 32);
            }

            public String getItemDes() {
                Object ref = this.itemDes_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.itemDes_ = s;
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
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x20;
                this.itemDes_ = value;
                onChanged();
                return this;
            }

            public Builder clearItemDes() {
                this.bitField0_ &= 0xFFFFFFDF;
                this.itemDes_ = ExchangeHandler.ExchangeInfo.getDefaultInstance().getItemDes();
                onChanged();
                return this;
            }

            public Builder setItemDesBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x20;
                this.itemDes_ = value;
                onChanged();
                return this;
            }

            private void ensureConditionIsMutable() {
                if ((this.bitField0_ & 0x40) != 64) {
                    this.condition_ = new ArrayList<>(this.condition_);
                    this.bitField0_ |= 0x40;
                }
            }

            public List<ExchangeHandler.Condition> getConditionList() {
                if (this.conditionBuilder_ == null)
                    return Collections.unmodifiableList(this.condition_);
                return this.conditionBuilder_.getMessageList();
            }

            public int getConditionCount() {
                if (this.conditionBuilder_ == null)
                    return this.condition_.size();
                return this.conditionBuilder_.getCount();
            }

            public ExchangeHandler.Condition getCondition(int index) {
                if (this.conditionBuilder_ == null)
                    return this.condition_.get(index);
                return (ExchangeHandler.Condition) this.conditionBuilder_.getMessage(index);
            }

            public Builder setCondition(int index, ExchangeHandler.Condition value) {
                if (this.conditionBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureConditionIsMutable();
                    this.condition_.set(index, value);
                    onChanged();
                } else {
                    this.conditionBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setCondition(int index, ExchangeHandler.Condition.Builder builderForValue) {
                if (this.conditionBuilder_ == null) {
                    ensureConditionIsMutable();
                    this.condition_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.conditionBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addCondition(ExchangeHandler.Condition value) {
                if (this.conditionBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureConditionIsMutable();
                    this.condition_.add(value);
                    onChanged();
                } else {
                    this.conditionBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addCondition(int index, ExchangeHandler.Condition value) {
                if (this.conditionBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureConditionIsMutable();
                    this.condition_.add(index, value);
                    onChanged();
                } else {
                    this.conditionBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addCondition(ExchangeHandler.Condition.Builder builderForValue) {
                if (this.conditionBuilder_ == null) {
                    ensureConditionIsMutable();
                    this.condition_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.conditionBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addCondition(int index, ExchangeHandler.Condition.Builder builderForValue) {
                if (this.conditionBuilder_ == null) {
                    ensureConditionIsMutable();
                    this.condition_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.conditionBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllCondition(Iterable<? extends ExchangeHandler.Condition> values) {
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
                    this.bitField0_ &= 0xFFFFFFBF;
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

            public ExchangeHandler.Condition.Builder getConditionBuilder(int index) {
                return (ExchangeHandler.Condition.Builder) getConditionFieldBuilder().getBuilder(index);
            }

            public ExchangeHandler.ConditionOrBuilder getConditionOrBuilder(int index) {
                if (this.conditionBuilder_ == null)
                    return this.condition_.get(index);
                return (ExchangeHandler.ConditionOrBuilder) this.conditionBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends ExchangeHandler.ConditionOrBuilder> getConditionOrBuilderList() {
                if (this.conditionBuilder_ != null)
                    return this.conditionBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.condition_);
            }

            public ExchangeHandler.Condition.Builder addConditionBuilder() {
                return (ExchangeHandler.Condition.Builder) getConditionFieldBuilder().addBuilder(ExchangeHandler.Condition.getDefaultInstance());
            }

            public ExchangeHandler.Condition.Builder addConditionBuilder(int index) {
                return (ExchangeHandler.Condition.Builder) getConditionFieldBuilder().addBuilder(index, ExchangeHandler.Condition.getDefaultInstance());
            }

            public List<ExchangeHandler.Condition.Builder> getConditionBuilderList() {
                return getConditionFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<ExchangeHandler.Condition, ExchangeHandler.Condition.Builder, ExchangeHandler.ConditionOrBuilder> getConditionFieldBuilder() {
                if (this.conditionBuilder_ == null) {
                    this.conditionBuilder_ = new RepeatedFieldBuilder(this.condition_, ((this.bitField0_ & 0x40) == 64), getParentForChildren(), isClean());
                    this.condition_ = null;
                }
                return this.conditionBuilder_;
            }

            private void ensureNeedMoneyIsMutable() {
                if ((this.bitField0_ & 0x80) != 128) {
                    this.needMoney_ = new ArrayList<>(this.needMoney_);
                    this.bitField0_ |= 0x80;
                }
            }

            public List<ExchangeHandler.MoneyInfo> getNeedMoneyList() {
                if (this.needMoneyBuilder_ == null)
                    return Collections.unmodifiableList(this.needMoney_);
                return this.needMoneyBuilder_.getMessageList();
            }

            public int getNeedMoneyCount() {
                if (this.needMoneyBuilder_ == null)
                    return this.needMoney_.size();
                return this.needMoneyBuilder_.getCount();
            }

            public ExchangeHandler.MoneyInfo getNeedMoney(int index) {
                if (this.needMoneyBuilder_ == null)
                    return this.needMoney_.get(index);
                return (ExchangeHandler.MoneyInfo) this.needMoneyBuilder_.getMessage(index);
            }

            public Builder setNeedMoney(int index, ExchangeHandler.MoneyInfo value) {
                if (this.needMoneyBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureNeedMoneyIsMutable();
                    this.needMoney_.set(index, value);
                    onChanged();
                } else {
                    this.needMoneyBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setNeedMoney(int index, ExchangeHandler.MoneyInfo.Builder builderForValue) {
                if (this.needMoneyBuilder_ == null) {
                    ensureNeedMoneyIsMutable();
                    this.needMoney_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.needMoneyBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addNeedMoney(ExchangeHandler.MoneyInfo value) {
                if (this.needMoneyBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureNeedMoneyIsMutable();
                    this.needMoney_.add(value);
                    onChanged();
                } else {
                    this.needMoneyBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addNeedMoney(int index, ExchangeHandler.MoneyInfo value) {
                if (this.needMoneyBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureNeedMoneyIsMutable();
                    this.needMoney_.add(index, value);
                    onChanged();
                } else {
                    this.needMoneyBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addNeedMoney(ExchangeHandler.MoneyInfo.Builder builderForValue) {
                if (this.needMoneyBuilder_ == null) {
                    ensureNeedMoneyIsMutable();
                    this.needMoney_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.needMoneyBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addNeedMoney(int index, ExchangeHandler.MoneyInfo.Builder builderForValue) {
                if (this.needMoneyBuilder_ == null) {
                    ensureNeedMoneyIsMutable();
                    this.needMoney_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.needMoneyBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllNeedMoney(Iterable<? extends ExchangeHandler.MoneyInfo> values) {
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
                    this.bitField0_ &= 0xFFFFFF7F;
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

            public ExchangeHandler.MoneyInfo.Builder getNeedMoneyBuilder(int index) {
                return (ExchangeHandler.MoneyInfo.Builder) getNeedMoneyFieldBuilder().getBuilder(index);
            }

            public ExchangeHandler.MoneyInfoOrBuilder getNeedMoneyOrBuilder(int index) {
                if (this.needMoneyBuilder_ == null)
                    return this.needMoney_.get(index);
                return (ExchangeHandler.MoneyInfoOrBuilder) this.needMoneyBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends ExchangeHandler.MoneyInfoOrBuilder> getNeedMoneyOrBuilderList() {
                if (this.needMoneyBuilder_ != null)
                    return this.needMoneyBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.needMoney_);
            }

            public ExchangeHandler.MoneyInfo.Builder addNeedMoneyBuilder() {
                return (ExchangeHandler.MoneyInfo.Builder) getNeedMoneyFieldBuilder().addBuilder(ExchangeHandler.MoneyInfo.getDefaultInstance());
            }

            public ExchangeHandler.MoneyInfo.Builder addNeedMoneyBuilder(int index) {
                return (ExchangeHandler.MoneyInfo.Builder) getNeedMoneyFieldBuilder().addBuilder(index, ExchangeHandler.MoneyInfo.getDefaultInstance());
            }

            public List<ExchangeHandler.MoneyInfo.Builder> getNeedMoneyBuilderList() {
                return getNeedMoneyFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<ExchangeHandler.MoneyInfo, ExchangeHandler.MoneyInfo.Builder, ExchangeHandler.MoneyInfoOrBuilder> getNeedMoneyFieldBuilder() {
                if (this.needMoneyBuilder_ == null) {
                    this.needMoneyBuilder_ = new RepeatedFieldBuilder(this.needMoney_, ((this.bitField0_ & 0x80) == 128), getParentForChildren(), isClean());
                    this.needMoney_ = null;
                }
                return this.needMoneyBuilder_;
            }

            private void ensureNeedItemIsMutable() {
                if ((this.bitField0_ & 0x100) != 256) {
                    this.needItem_ = new ArrayList<>(this.needItem_);
                    this.bitField0_ |= 0x100;
                }
            }

            public List<ItemOuterClass.MiniItem> getNeedItemList() {
                if (this.needItemBuilder_ == null)
                    return Collections.unmodifiableList(this.needItem_);
                return this.needItemBuilder_.getMessageList();
            }

            public int getNeedItemCount() {
                if (this.needItemBuilder_ == null)
                    return this.needItem_.size();
                return this.needItemBuilder_.getCount();
            }

            public ItemOuterClass.MiniItem getNeedItem(int index) {
                if (this.needItemBuilder_ == null)
                    return this.needItem_.get(index);
                return (ItemOuterClass.MiniItem) this.needItemBuilder_.getMessage(index);
            }

            public Builder setNeedItem(int index, ItemOuterClass.MiniItem value) {
                if (this.needItemBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureNeedItemIsMutable();
                    this.needItem_.set(index, value);
                    onChanged();
                } else {
                    this.needItemBuilder_.setMessage(index, (GeneratedMessage) value);
                }
                return this;
            }

            public Builder setNeedItem(int index, ItemOuterClass.MiniItem.Builder builderForValue) {
                if (this.needItemBuilder_ == null) {
                    ensureNeedItemIsMutable();
                    this.needItem_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.needItemBuilder_.setMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addNeedItem(ItemOuterClass.MiniItem value) {
                if (this.needItemBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureNeedItemIsMutable();
                    this.needItem_.add(value);
                    onChanged();
                } else {
                    this.needItemBuilder_.addMessage((GeneratedMessage) value);
                }
                return this;
            }

            public Builder addNeedItem(int index, ItemOuterClass.MiniItem value) {
                if (this.needItemBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureNeedItemIsMutable();
                    this.needItem_.add(index, value);
                    onChanged();
                } else {
                    this.needItemBuilder_.addMessage(index, (GeneratedMessage) value);
                }
                return this;
            }

            public Builder addNeedItem(ItemOuterClass.MiniItem.Builder builderForValue) {
                if (this.needItemBuilder_ == null) {
                    ensureNeedItemIsMutable();
                    this.needItem_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.needItemBuilder_.addMessage((GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addNeedItem(int index, ItemOuterClass.MiniItem.Builder builderForValue) {
                if (this.needItemBuilder_ == null) {
                    ensureNeedItemIsMutable();
                    this.needItem_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.needItemBuilder_.addMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addAllNeedItem(Iterable<? extends ItemOuterClass.MiniItem> values) {
                if (this.needItemBuilder_ == null) {
                    ensureNeedItemIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.needItem_);
                    onChanged();
                } else {
                    this.needItemBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearNeedItem() {
                if (this.needItemBuilder_ == null) {
                    this.needItem_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFEFF;
                    onChanged();
                } else {
                    this.needItemBuilder_.clear();
                }
                return this;
            }

            public Builder removeNeedItem(int index) {
                if (this.needItemBuilder_ == null) {
                    ensureNeedItemIsMutable();
                    this.needItem_.remove(index);
                    onChanged();
                } else {
                    this.needItemBuilder_.remove(index);
                }
                return this;
            }

            public ItemOuterClass.MiniItem.Builder getNeedItemBuilder(int index) {
                return (ItemOuterClass.MiniItem.Builder) getNeedItemFieldBuilder().getBuilder(index);
            }

            public ItemOuterClass.MiniItemOrBuilder getNeedItemOrBuilder(int index) {
                if (this.needItemBuilder_ == null)
                    return (ItemOuterClass.MiniItemOrBuilder) this.needItem_.get(index);
                return (ItemOuterClass.MiniItemOrBuilder) this.needItemBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends ItemOuterClass.MiniItemOrBuilder> getNeedItemOrBuilderList() {
                if (this.needItemBuilder_ != null)
                    return this.needItemBuilder_.getMessageOrBuilderList();
                return (List) Collections.unmodifiableList(this.needItem_);
            }

            public ItemOuterClass.MiniItem.Builder addNeedItemBuilder() {
                return (ItemOuterClass.MiniItem.Builder) getNeedItemFieldBuilder().addBuilder((GeneratedMessage) ItemOuterClass.MiniItem.getDefaultInstance());
            }

            public ItemOuterClass.MiniItem.Builder addNeedItemBuilder(int index) {
                return (ItemOuterClass.MiniItem.Builder) getNeedItemFieldBuilder().addBuilder(index, (GeneratedMessage) ItemOuterClass.MiniItem.getDefaultInstance());
            }

            public List<ItemOuterClass.MiniItem.Builder> getNeedItemBuilderList() {
                return getNeedItemFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<ItemOuterClass.MiniItem, ItemOuterClass.MiniItem.Builder, ItemOuterClass.MiniItemOrBuilder> getNeedItemFieldBuilder() {
                if (this.needItemBuilder_ == null) {
                    this.needItemBuilder_ = new RepeatedFieldBuilder(this.needItem_, ((this.bitField0_ & 0x100) == 256), getParentForChildren(), isClean());
                    this.needItem_ = null;
                }
                return this.needItemBuilder_;
            }

            public boolean hasMeetCondition() {
                return ((this.bitField0_ & 0x200) == 512);
            }

            public int getMeetCondition() {
                return this.meetCondition_;
            }

            public Builder setMeetCondition(int value) {
                this.bitField0_ |= 0x200;
                this.meetCondition_ = value;
                onChanged();
                return this;
            }

            public Builder clearMeetCondition() {
                this.bitField0_ &= 0xFFFFFDFF;
                this.meetCondition_ = 0;
                onChanged();
                return this;
            }

            public boolean hasMaxExchangeNum() {
                return ((this.bitField0_ & 0x400) == 1024);
            }

            public int getMaxExchangeNum() {
                return this.maxExchangeNum_;
            }

            public Builder setMaxExchangeNum(int value) {
                this.bitField0_ |= 0x400;
                this.maxExchangeNum_ = value;
                onChanged();
                return this;
            }

            public Builder clearMaxExchangeNum() {
                this.bitField0_ &= 0xFFFFFBFF;
                this.maxExchangeNum_ = 0;
                onChanged();
                return this;
            }

            public boolean hasState() {
                return ((this.bitField0_ & 0x800) == 2048);
            }

            public int getState() {
                return this.state_;
            }

            public Builder setState(int value) {
                this.bitField0_ |= 0x800;
                this.state_ = value;
                onChanged();
                return this;
            }

            public Builder clearState() {
                this.bitField0_ &= 0xFFFFF7FF;
                this.state_ = 0;
                onChanged();
                return this;
            }
        }
    }

    public static final class label extends GeneratedMessage implements labelOrBuilder {
        private static final label defaultInstance = new label(true);
        private final UnknownFieldSet unknownFields;

        private label(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private label(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static label getDefaultInstance() {
            return defaultInstance;
        }

        public label getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private label(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.typeId_ = input.readInt32();
                            break;
                        case 18:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x2;
                            this.typeName_ = bs;
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
            return ExchangeHandler.internal_static_pomelo_area_label_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ExchangeHandler.internal_static_pomelo_area_label_fieldAccessorTable.ensureFieldAccessorsInitialized(label.class, Builder.class);
        }

        public static Parser<label> PARSER = (Parser<label>) new AbstractParser<label>() {
            public ExchangeHandler.label parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ExchangeHandler.label(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int TYPEID_FIELD_NUMBER = 1;
        private int typeId_;
        public static final int TYPENAME_FIELD_NUMBER = 2;
        private Object typeName_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<label> getParserForType() {
            return PARSER;
        }

        public boolean hasTypeId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getTypeId() {
            return this.typeId_;
        }

        public boolean hasTypeName() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public String getTypeName() {
            Object ref = this.typeName_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.typeName_ = s;
            return s;
        }

        public ByteString getTypeNameBytes() {
            Object ref = this.typeName_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.typeName_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        private void initFields() {
            this.typeId_ = 0;
            this.typeName_ = "";
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
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.typeId_);
            if ((this.bitField0_ & 0x2) == 2) output.writeBytes(2, getTypeNameBytes());
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.typeId_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getTypeNameBytes());
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static label parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (label) PARSER.parseFrom(data);
        }

        public static label parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (label) PARSER.parseFrom(data, extensionRegistry);
        }

        public static label parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (label) PARSER.parseFrom(data);
        }

        public static label parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (label) PARSER.parseFrom(data, extensionRegistry);
        }

        public static label parseFrom(InputStream input) throws IOException {
            return (label) PARSER.parseFrom(input);
        }

        public static label parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (label) PARSER.parseFrom(input, extensionRegistry);
        }

        public static label parseDelimitedFrom(InputStream input) throws IOException {
            return (label) PARSER.parseDelimitedFrom(input);
        }

        public static label parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (label) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static label parseFrom(CodedInputStream input) throws IOException {
            return (label) PARSER.parseFrom(input);
        }

        public static label parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (label) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(label prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements ExchangeHandler.labelOrBuilder {
            private int bitField0_;
            private int typeId_;
            private Object typeName_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ExchangeHandler.internal_static_pomelo_area_label_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return ExchangeHandler.internal_static_pomelo_area_label_fieldAccessorTable.ensureFieldAccessorsInitialized(ExchangeHandler.label.class, Builder.class);
            }

            private Builder() {
                this.typeName_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.typeName_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ExchangeHandler.label.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.typeId_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.typeName_ = "";
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return ExchangeHandler.internal_static_pomelo_area_label_descriptor;
            }

            public ExchangeHandler.label getDefaultInstanceForType() {
                return ExchangeHandler.label.getDefaultInstance();
            }

            public ExchangeHandler.label build() {
                ExchangeHandler.label result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public ExchangeHandler.label buildPartial() {
                ExchangeHandler.label result = new ExchangeHandler.label(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.typeId_ = this.typeId_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.typeName_ = this.typeName_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof ExchangeHandler.label) return mergeFrom((ExchangeHandler.label) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ExchangeHandler.label other) {
                if (other == ExchangeHandler.label.getDefaultInstance()) return this;
                if (other.hasTypeId()) setTypeId(other.getTypeId());
                if (other.hasTypeName()) {
                    this.bitField0_ |= 0x2;
                    this.typeName_ = other.typeName_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                ExchangeHandler.label parsedMessage = null;
                try {
                    parsedMessage = (ExchangeHandler.label) ExchangeHandler.label.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (ExchangeHandler.label) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasTypeId() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getTypeId() {
                return this.typeId_;
            }

            public Builder setTypeId(int value) {
                this.bitField0_ |= 0x1;
                this.typeId_ = value;
                onChanged();
                return this;
            }

            public Builder clearTypeId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.typeId_ = 0;
                onChanged();
                return this;
            }

            public boolean hasTypeName() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public String getTypeName() {
                Object ref = this.typeName_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) this.typeName_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getTypeNameBytes() {
                Object ref = this.typeName_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.typeName_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setTypeName(String value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x2;
                this.typeName_ = value;
                onChanged();
                return this;
            }

            public Builder clearTypeName() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.typeName_ = ExchangeHandler.label.getDefaultInstance().getTypeName();
                onChanged();
                return this;
            }

            public Builder setTypeNameBytes(ByteString value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x2;
                this.typeName_ = value;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class ExchangeData
            extends GeneratedMessage
            implements ExchangeDataOrBuilder {
        private static final ExchangeData defaultInstance = new ExchangeData(true);
        private final UnknownFieldSet unknownFields;

        private ExchangeData(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private ExchangeData(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static ExchangeData getDefaultInstance() {
            return defaultInstance;
        }

        public ExchangeData getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ExchangeData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.exchangeList_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x1;
                            }
                            this.exchangeList_.add(input.readMessage(ExchangeHandler.ExchangeInfo.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x1) == 1)
                    this.exchangeList_ = Collections.unmodifiableList(this.exchangeList_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ExchangeHandler.internal_static_pomelo_area_ExchangeData_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ExchangeHandler.internal_static_pomelo_area_ExchangeData_fieldAccessorTable.ensureFieldAccessorsInitialized(ExchangeData.class, Builder.class);
        }

        public static Parser<ExchangeData> PARSER = (Parser<ExchangeData>) new AbstractParser<ExchangeData>() {
            public ExchangeHandler.ExchangeData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ExchangeHandler.ExchangeData(input, extensionRegistry);
            }
        };
        public static final int EXCHANGELIST_FIELD_NUMBER = 1;
        private List<ExchangeHandler.ExchangeInfo> exchangeList_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<ExchangeData> getParserForType() {
            return PARSER;
        }

        public List<ExchangeHandler.ExchangeInfo> getExchangeListList() {
            return this.exchangeList_;
        }

        public List<? extends ExchangeHandler.ExchangeInfoOrBuilder> getExchangeListOrBuilderList() {
            return (List) this.exchangeList_;
        }

        public int getExchangeListCount() {
            return this.exchangeList_.size();
        }

        public ExchangeHandler.ExchangeInfo getExchangeList(int index) {
            return this.exchangeList_.get(index);
        }

        public ExchangeHandler.ExchangeInfoOrBuilder getExchangeListOrBuilder(int index) {
            return this.exchangeList_.get(index);
        }

        private void initFields() {
            this.exchangeList_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            for (int i = 0; i < getExchangeListCount(); i++) {
                if (!getExchangeList(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            for (int i = 0; i < this.exchangeList_.size(); i++)
                output.writeMessage(1, (MessageLite) this.exchangeList_.get(i));
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            for (int i = 0; i < this.exchangeList_.size(); i++)
                size += CodedOutputStream.computeMessageSize(1, (MessageLite) this.exchangeList_.get(i));
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static ExchangeData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ExchangeData) PARSER.parseFrom(data);
        }

        public static ExchangeData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ExchangeData) PARSER.parseFrom(data, extensionRegistry);
        }

        public static ExchangeData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ExchangeData) PARSER.parseFrom(data);
        }

        public static ExchangeData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ExchangeData) PARSER.parseFrom(data, extensionRegistry);
        }

        public static ExchangeData parseFrom(InputStream input) throws IOException {
            return (ExchangeData) PARSER.parseFrom(input);
        }

        public static ExchangeData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ExchangeData) PARSER.parseFrom(input, extensionRegistry);
        }

        public static ExchangeData parseDelimitedFrom(InputStream input) throws IOException {
            return (ExchangeData) PARSER.parseDelimitedFrom(input);
        }

        public static ExchangeData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ExchangeData) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static ExchangeData parseFrom(CodedInputStream input) throws IOException {
            return (ExchangeData) PARSER.parseFrom(input);
        }

        public static ExchangeData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ExchangeData) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(ExchangeData prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements ExchangeHandler.ExchangeDataOrBuilder {
            private int bitField0_;
            private List<ExchangeHandler.ExchangeInfo> exchangeList_;
            private RepeatedFieldBuilder<ExchangeHandler.ExchangeInfo, ExchangeHandler.ExchangeInfo.Builder, ExchangeHandler.ExchangeInfoOrBuilder> exchangeListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ExchangeHandler.internal_static_pomelo_area_ExchangeData_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return ExchangeHandler.internal_static_pomelo_area_ExchangeData_fieldAccessorTable.ensureFieldAccessorsInitialized(ExchangeHandler.ExchangeData.class, Builder.class);
            }

            private Builder() {
                this.exchangeList_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.exchangeList_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ExchangeHandler.ExchangeData.alwaysUseFieldBuilders) getExchangeListFieldBuilder();
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                if (this.exchangeListBuilder_ == null) {
                    this.exchangeList_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFE;
                } else {
                    this.exchangeListBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return ExchangeHandler.internal_static_pomelo_area_ExchangeData_descriptor;
            }

            public ExchangeHandler.ExchangeData getDefaultInstanceForType() {
                return ExchangeHandler.ExchangeData.getDefaultInstance();
            }

            public ExchangeHandler.ExchangeData build() {
                ExchangeHandler.ExchangeData result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public ExchangeHandler.ExchangeData buildPartial() {
                ExchangeHandler.ExchangeData result = new ExchangeHandler.ExchangeData(this);
                int from_bitField0_ = this.bitField0_;
                if (this.exchangeListBuilder_ == null) {
                    if ((this.bitField0_ & 0x1) == 1) {
                        this.exchangeList_ = Collections.unmodifiableList(this.exchangeList_);
                        this.bitField0_ &= 0xFFFFFFFE;
                    }
                    result.exchangeList_ = this.exchangeList_;
                } else {
                    result.exchangeList_ = this.exchangeListBuilder_.build();
                }
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof ExchangeHandler.ExchangeData)
                    return mergeFrom((ExchangeHandler.ExchangeData) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ExchangeHandler.ExchangeData other) {
                if (other == ExchangeHandler.ExchangeData.getDefaultInstance()) return this;
                if (this.exchangeListBuilder_ == null) {
                    if (!other.exchangeList_.isEmpty()) {
                        if (this.exchangeList_.isEmpty()) {
                            this.exchangeList_ = other.exchangeList_;
                            this.bitField0_ &= 0xFFFFFFFE;
                        } else {
                            ensureExchangeListIsMutable();
                            this.exchangeList_.addAll(other.exchangeList_);
                        }
                        onChanged();
                    }
                } else if (!other.exchangeList_.isEmpty()) {
                    if (this.exchangeListBuilder_.isEmpty()) {
                        this.exchangeListBuilder_.dispose();
                        this.exchangeListBuilder_ = null;
                        this.exchangeList_ = other.exchangeList_;
                        this.bitField0_ &= 0xFFFFFFFE;
                        this.exchangeListBuilder_ = ExchangeHandler.ExchangeData.alwaysUseFieldBuilders ? getExchangeListFieldBuilder() : null;
                    } else {
                        this.exchangeListBuilder_.addAllMessages(other.exchangeList_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                for (int i = 0; i < getExchangeListCount(); i++) {
                    if (!getExchangeList(i).isInitialized()) return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                ExchangeHandler.ExchangeData parsedMessage = null;
                try {
                    parsedMessage = (ExchangeHandler.ExchangeData) ExchangeHandler.ExchangeData.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (ExchangeHandler.ExchangeData) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            private void ensureExchangeListIsMutable() {
                if ((this.bitField0_ & 0x1) != 1) {
                    this.exchangeList_ = new ArrayList<>(this.exchangeList_);
                    this.bitField0_ |= 0x1;
                }
            }

            public List<ExchangeHandler.ExchangeInfo> getExchangeListList() {
                if (this.exchangeListBuilder_ == null) return Collections.unmodifiableList(this.exchangeList_);
                return this.exchangeListBuilder_.getMessageList();
            }

            public int getExchangeListCount() {
                if (this.exchangeListBuilder_ == null) return this.exchangeList_.size();
                return this.exchangeListBuilder_.getCount();
            }

            public ExchangeHandler.ExchangeInfo getExchangeList(int index) {
                if (this.exchangeListBuilder_ == null) return this.exchangeList_.get(index);
                return (ExchangeHandler.ExchangeInfo) this.exchangeListBuilder_.getMessage(index);
            }

            public Builder setExchangeList(int index, ExchangeHandler.ExchangeInfo value) {
                if (this.exchangeListBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureExchangeListIsMutable();
                    this.exchangeList_.set(index, value);
                    onChanged();
                } else {
                    this.exchangeListBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setExchangeList(int index, ExchangeHandler.ExchangeInfo.Builder builderForValue) {
                if (this.exchangeListBuilder_ == null) {
                    ensureExchangeListIsMutable();
                    this.exchangeList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.exchangeListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addExchangeList(ExchangeHandler.ExchangeInfo value) {
                if (this.exchangeListBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureExchangeListIsMutable();
                    this.exchangeList_.add(value);
                    onChanged();
                } else {
                    this.exchangeListBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addExchangeList(int index, ExchangeHandler.ExchangeInfo value) {
                if (this.exchangeListBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureExchangeListIsMutable();
                    this.exchangeList_.add(index, value);
                    onChanged();
                } else {
                    this.exchangeListBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addExchangeList(ExchangeHandler.ExchangeInfo.Builder builderForValue) {
                if (this.exchangeListBuilder_ == null) {
                    ensureExchangeListIsMutable();
                    this.exchangeList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.exchangeListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addExchangeList(int index, ExchangeHandler.ExchangeInfo.Builder builderForValue) {
                if (this.exchangeListBuilder_ == null) {
                    ensureExchangeListIsMutable();
                    this.exchangeList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.exchangeListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllExchangeList(Iterable<? extends ExchangeHandler.ExchangeInfo> values) {
                if (this.exchangeListBuilder_ == null) {
                    ensureExchangeListIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.exchangeList_);
                    onChanged();
                } else {
                    this.exchangeListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearExchangeList() {
                if (this.exchangeListBuilder_ == null) {
                    this.exchangeList_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFE;
                    onChanged();
                } else {
                    this.exchangeListBuilder_.clear();
                }
                return this;
            }

            public Builder removeExchangeList(int index) {
                if (this.exchangeListBuilder_ == null) {
                    ensureExchangeListIsMutable();
                    this.exchangeList_.remove(index);
                    onChanged();
                } else {
                    this.exchangeListBuilder_.remove(index);
                }
                return this;
            }

            public ExchangeHandler.ExchangeInfo.Builder getExchangeListBuilder(int index) {
                return (ExchangeHandler.ExchangeInfo.Builder) getExchangeListFieldBuilder().getBuilder(index);
            }

            public ExchangeHandler.ExchangeInfoOrBuilder getExchangeListOrBuilder(int index) {
                if (this.exchangeListBuilder_ == null) return this.exchangeList_.get(index);
                return (ExchangeHandler.ExchangeInfoOrBuilder) this.exchangeListBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends ExchangeHandler.ExchangeInfoOrBuilder> getExchangeListOrBuilderList() {
                if (this.exchangeListBuilder_ != null) return this.exchangeListBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.exchangeList_);
            }

            public ExchangeHandler.ExchangeInfo.Builder addExchangeListBuilder() {
                return (ExchangeHandler.ExchangeInfo.Builder) getExchangeListFieldBuilder().addBuilder(ExchangeHandler.ExchangeInfo.getDefaultInstance());
            }

            public ExchangeHandler.ExchangeInfo.Builder addExchangeListBuilder(int index) {
                return (ExchangeHandler.ExchangeInfo.Builder) getExchangeListFieldBuilder().addBuilder(index, ExchangeHandler.ExchangeInfo.getDefaultInstance());
            }

            public List<ExchangeHandler.ExchangeInfo.Builder> getExchangeListBuilderList() {
                return getExchangeListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<ExchangeHandler.ExchangeInfo, ExchangeHandler.ExchangeInfo.Builder, ExchangeHandler.ExchangeInfoOrBuilder> getExchangeListFieldBuilder() {
                if (this.exchangeListBuilder_ == null) {
                    this.exchangeListBuilder_ = new RepeatedFieldBuilder(this.exchangeList_, ((this.bitField0_ & 0x1) == 1), getParentForChildren(), isClean());
                    this.exchangeList_ = null;
                }
                return this.exchangeListBuilder_;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class GetExchangeLabelResponse
            extends GeneratedMessage
            implements GetExchangeLabelResponseOrBuilder {
        private static final GetExchangeLabelResponse defaultInstance = new GetExchangeLabelResponse(true);
        private final UnknownFieldSet unknownFields;

        private GetExchangeLabelResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetExchangeLabelResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetExchangeLabelResponse getDefaultInstance() {
            return defaultInstance;
        }

        public GetExchangeLabelResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetExchangeLabelResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.s2CLabelList_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x4;
                            }
                            this.s2CLabelList_.add(input.readMessage(ExchangeHandler.label.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x4) == 4)
                    this.s2CLabelList_ = Collections.unmodifiableList(this.s2CLabelList_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ExchangeHandler.internal_static_pomelo_area_GetExchangeLabelResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ExchangeHandler.internal_static_pomelo_area_GetExchangeLabelResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetExchangeLabelResponse.class, Builder.class);
        }

        public static Parser<GetExchangeLabelResponse> PARSER = (Parser<GetExchangeLabelResponse>) new AbstractParser<GetExchangeLabelResponse>() {
            public ExchangeHandler.GetExchangeLabelResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ExchangeHandler.GetExchangeLabelResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_LABELLIST_FIELD_NUMBER = 3;
        private List<ExchangeHandler.label> s2CLabelList_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetExchangeLabelResponse> getParserForType() {
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

        public List<ExchangeHandler.label> getS2CLabelListList() {
            return this.s2CLabelList_;
        }

        public List<? extends ExchangeHandler.labelOrBuilder> getS2CLabelListOrBuilderList() {
            return (List) this.s2CLabelList_;
        }

        public int getS2CLabelListCount() {
            return this.s2CLabelList_.size();
        }

        public ExchangeHandler.label getS2CLabelList(int index) {
            return this.s2CLabelList_.get(index);
        }

        public ExchangeHandler.labelOrBuilder getS2CLabelListOrBuilder(int index) {
            return this.s2CLabelList_.get(index);
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CLabelList_ = Collections.emptyList();
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
            for (int i = 0; i < this.s2CLabelList_.size(); i++)
                output.writeMessage(3, (MessageLite) this.s2CLabelList_.get(i));
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());
            for (int i = 0; i < this.s2CLabelList_.size(); i++)
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.s2CLabelList_.get(i));
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static GetExchangeLabelResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetExchangeLabelResponse) PARSER.parseFrom(data);
        }

        public static GetExchangeLabelResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetExchangeLabelResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetExchangeLabelResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetExchangeLabelResponse) PARSER.parseFrom(data);
        }

        public static GetExchangeLabelResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetExchangeLabelResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetExchangeLabelResponse parseFrom(InputStream input) throws IOException {
            return (GetExchangeLabelResponse) PARSER.parseFrom(input);
        }

        public static GetExchangeLabelResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetExchangeLabelResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static GetExchangeLabelResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (GetExchangeLabelResponse) PARSER.parseDelimitedFrom(input);
        }

        public static GetExchangeLabelResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetExchangeLabelResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static GetExchangeLabelResponse parseFrom(CodedInputStream input) throws IOException {
            return (GetExchangeLabelResponse) PARSER.parseFrom(input);
        }

        public static GetExchangeLabelResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetExchangeLabelResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(GetExchangeLabelResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements ExchangeHandler.GetExchangeLabelResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private List<ExchangeHandler.label> s2CLabelList_;
            private RepeatedFieldBuilder<ExchangeHandler.label, ExchangeHandler.label.Builder, ExchangeHandler.labelOrBuilder> s2CLabelListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ExchangeHandler.internal_static_pomelo_area_GetExchangeLabelResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return ExchangeHandler.internal_static_pomelo_area_GetExchangeLabelResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ExchangeHandler.GetExchangeLabelResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.s2CLabelList_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CLabelList_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ExchangeHandler.GetExchangeLabelResponse.alwaysUseFieldBuilders) getS2CLabelListFieldBuilder();
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
                if (this.s2CLabelListBuilder_ == null) {
                    this.s2CLabelList_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                } else {
                    this.s2CLabelListBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return ExchangeHandler.internal_static_pomelo_area_GetExchangeLabelResponse_descriptor;
            }

            public ExchangeHandler.GetExchangeLabelResponse getDefaultInstanceForType() {
                return ExchangeHandler.GetExchangeLabelResponse.getDefaultInstance();
            }

            public ExchangeHandler.GetExchangeLabelResponse build() {
                ExchangeHandler.GetExchangeLabelResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public ExchangeHandler.GetExchangeLabelResponse buildPartial() {
                ExchangeHandler.GetExchangeLabelResponse result = new ExchangeHandler.GetExchangeLabelResponse(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.s2CMsg_ = this.s2CMsg_;
                if (this.s2CLabelListBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4) {
                        this.s2CLabelList_ = Collections.unmodifiableList(this.s2CLabelList_);
                        this.bitField0_ &= 0xFFFFFFFB;
                    }
                    result.s2CLabelList_ = this.s2CLabelList_;
                } else {
                    result.s2CLabelList_ = this.s2CLabelListBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof ExchangeHandler.GetExchangeLabelResponse)
                    return mergeFrom((ExchangeHandler.GetExchangeLabelResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ExchangeHandler.GetExchangeLabelResponse other) {
                if (other == ExchangeHandler.GetExchangeLabelResponse.getDefaultInstance()) return this;
                if (other.hasS2CCode()) setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (this.s2CLabelListBuilder_ == null) {
                    if (!other.s2CLabelList_.isEmpty()) {
                        if (this.s2CLabelList_.isEmpty()) {
                            this.s2CLabelList_ = other.s2CLabelList_;
                            this.bitField0_ &= 0xFFFFFFFB;
                        } else {
                            ensureS2CLabelListIsMutable();
                            this.s2CLabelList_.addAll(other.s2CLabelList_);
                        }
                        onChanged();
                    }
                } else if (!other.s2CLabelList_.isEmpty()) {
                    if (this.s2CLabelListBuilder_.isEmpty()) {
                        this.s2CLabelListBuilder_.dispose();
                        this.s2CLabelListBuilder_ = null;
                        this.s2CLabelList_ = other.s2CLabelList_;
                        this.bitField0_ &= 0xFFFFFFFB;
                        this.s2CLabelListBuilder_ = ExchangeHandler.GetExchangeLabelResponse.alwaysUseFieldBuilders ? getS2CLabelListFieldBuilder() : null;
                    } else {
                        this.s2CLabelListBuilder_.addAllMessages(other.s2CLabelList_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                ExchangeHandler.GetExchangeLabelResponse parsedMessage = null;
                try {
                    parsedMessage = (ExchangeHandler.GetExchangeLabelResponse) ExchangeHandler.GetExchangeLabelResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (ExchangeHandler.GetExchangeLabelResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = ExchangeHandler.GetExchangeLabelResponse.getDefaultInstance().getS2CMsg();
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

            private void ensureS2CLabelListIsMutable() {
                if ((this.bitField0_ & 0x4) != 4) {
                    this.s2CLabelList_ = new ArrayList<>(this.s2CLabelList_);
                    this.bitField0_ |= 0x4;
                }
            }

            public List<ExchangeHandler.label> getS2CLabelListList() {
                if (this.s2CLabelListBuilder_ == null) return Collections.unmodifiableList(this.s2CLabelList_);
                return this.s2CLabelListBuilder_.getMessageList();
            }

            public int getS2CLabelListCount() {
                if (this.s2CLabelListBuilder_ == null) return this.s2CLabelList_.size();
                return this.s2CLabelListBuilder_.getCount();
            }

            public ExchangeHandler.label getS2CLabelList(int index) {
                if (this.s2CLabelListBuilder_ == null) return this.s2CLabelList_.get(index);
                return (ExchangeHandler.label) this.s2CLabelListBuilder_.getMessage(index);
            }

            public Builder setS2CLabelList(int index, ExchangeHandler.label value) {
                if (this.s2CLabelListBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureS2CLabelListIsMutable();
                    this.s2CLabelList_.set(index, value);
                    onChanged();
                } else {
                    this.s2CLabelListBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setS2CLabelList(int index, ExchangeHandler.label.Builder builderForValue) {
                if (this.s2CLabelListBuilder_ == null) {
                    ensureS2CLabelListIsMutable();
                    this.s2CLabelList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CLabelListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addS2CLabelList(ExchangeHandler.label value) {
                if (this.s2CLabelListBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureS2CLabelListIsMutable();
                    this.s2CLabelList_.add(value);
                    onChanged();
                } else {
                    this.s2CLabelListBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addS2CLabelList(int index, ExchangeHandler.label value) {
                if (this.s2CLabelListBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureS2CLabelListIsMutable();
                    this.s2CLabelList_.add(index, value);
                    onChanged();
                } else {
                    this.s2CLabelListBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addS2CLabelList(ExchangeHandler.label.Builder builderForValue) {
                if (this.s2CLabelListBuilder_ == null) {
                    ensureS2CLabelListIsMutable();
                    this.s2CLabelList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.s2CLabelListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addS2CLabelList(int index, ExchangeHandler.label.Builder builderForValue) {
                if (this.s2CLabelListBuilder_ == null) {
                    ensureS2CLabelListIsMutable();
                    this.s2CLabelList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CLabelListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllS2CLabelList(Iterable<? extends ExchangeHandler.label> values) {
                if (this.s2CLabelListBuilder_ == null) {
                    ensureS2CLabelListIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.s2CLabelList_);
                    onChanged();
                } else {
                    this.s2CLabelListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearS2CLabelList() {
                if (this.s2CLabelListBuilder_ == null) {
                    this.s2CLabelList_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                    onChanged();
                } else {
                    this.s2CLabelListBuilder_.clear();
                }
                return this;
            }

            public Builder removeS2CLabelList(int index) {
                if (this.s2CLabelListBuilder_ == null) {
                    ensureS2CLabelListIsMutable();
                    this.s2CLabelList_.remove(index);
                    onChanged();
                } else {
                    this.s2CLabelListBuilder_.remove(index);
                }
                return this;
            }

            public ExchangeHandler.label.Builder getS2CLabelListBuilder(int index) {
                return (ExchangeHandler.label.Builder) getS2CLabelListFieldBuilder().getBuilder(index);
            }

            public ExchangeHandler.labelOrBuilder getS2CLabelListOrBuilder(int index) {
                if (this.s2CLabelListBuilder_ == null) return this.s2CLabelList_.get(index);
                return (ExchangeHandler.labelOrBuilder) this.s2CLabelListBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends ExchangeHandler.labelOrBuilder> getS2CLabelListOrBuilderList() {
                if (this.s2CLabelListBuilder_ != null) return this.s2CLabelListBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.s2CLabelList_);
            }

            public ExchangeHandler.label.Builder addS2CLabelListBuilder() {
                return (ExchangeHandler.label.Builder) getS2CLabelListFieldBuilder().addBuilder(ExchangeHandler.label.getDefaultInstance());
            }

            public ExchangeHandler.label.Builder addS2CLabelListBuilder(int index) {
                return (ExchangeHandler.label.Builder) getS2CLabelListFieldBuilder().addBuilder(index, ExchangeHandler.label.getDefaultInstance());
            }

            public List<ExchangeHandler.label.Builder> getS2CLabelListBuilderList() {
                return getS2CLabelListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<ExchangeHandler.label, ExchangeHandler.label.Builder, ExchangeHandler.labelOrBuilder> getS2CLabelListFieldBuilder() {
                if (this.s2CLabelListBuilder_ == null) {
                    this.s2CLabelListBuilder_ = new RepeatedFieldBuilder(this.s2CLabelList_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
                    this.s2CLabelList_ = null;
                }
                return this.s2CLabelListBuilder_;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class GetExchangeListResponse
            extends GeneratedMessage
            implements GetExchangeListResponseOrBuilder {
        private static final GetExchangeListResponse defaultInstance = new GetExchangeListResponse(true);
        private final UnknownFieldSet unknownFields;

        private GetExchangeListResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetExchangeListResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetExchangeListResponse getDefaultInstance() {
            return defaultInstance;
        }

        public GetExchangeListResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetExchangeListResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString bs;
                    ExchangeHandler.ExchangeData.Builder subBuilder;
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
                            this.s2CData_ = (ExchangeHandler.ExchangeData) input.readMessage(ExchangeHandler.ExchangeData.PARSER, extensionRegistry);
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
            return ExchangeHandler.internal_static_pomelo_area_GetExchangeListResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ExchangeHandler.internal_static_pomelo_area_GetExchangeListResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetExchangeListResponse.class, Builder.class);
        }

        public static Parser<GetExchangeListResponse> PARSER = (Parser<GetExchangeListResponse>) new AbstractParser<GetExchangeListResponse>() {
            public ExchangeHandler.GetExchangeListResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ExchangeHandler.GetExchangeListResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_DATA_FIELD_NUMBER = 3;
        private ExchangeHandler.ExchangeData s2CData_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetExchangeListResponse> getParserForType() {
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

        public boolean hasS2CData() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public ExchangeHandler.ExchangeData getS2CData() {
            return this.s2CData_;
        }

        public ExchangeHandler.ExchangeDataOrBuilder getS2CDataOrBuilder() {
            return this.s2CData_;
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CData_ = ExchangeHandler.ExchangeData.getDefaultInstance();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
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
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2) output.writeBytes(2, getS2CMsgBytes());
            if ((this.bitField0_ & 0x4) == 4) output.writeMessage(3, (MessageLite) this.s2CData_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());
            if ((this.bitField0_ & 0x4) == 4)
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.s2CData_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static GetExchangeListResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetExchangeListResponse) PARSER.parseFrom(data);
        }

        public static GetExchangeListResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetExchangeListResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetExchangeListResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetExchangeListResponse) PARSER.parseFrom(data);
        }

        public static GetExchangeListResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetExchangeListResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetExchangeListResponse parseFrom(InputStream input) throws IOException {
            return (GetExchangeListResponse) PARSER.parseFrom(input);
        }

        public static GetExchangeListResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetExchangeListResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static GetExchangeListResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (GetExchangeListResponse) PARSER.parseDelimitedFrom(input);
        }

        public static GetExchangeListResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetExchangeListResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static GetExchangeListResponse parseFrom(CodedInputStream input) throws IOException {
            return (GetExchangeListResponse) PARSER.parseFrom(input);
        }

        public static GetExchangeListResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetExchangeListResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(GetExchangeListResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements ExchangeHandler.GetExchangeListResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private ExchangeHandler.ExchangeData s2CData_;
            private SingleFieldBuilder<ExchangeHandler.ExchangeData, ExchangeHandler.ExchangeData.Builder, ExchangeHandler.ExchangeDataOrBuilder> s2CDataBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ExchangeHandler.internal_static_pomelo_area_GetExchangeListResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return ExchangeHandler.internal_static_pomelo_area_GetExchangeListResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ExchangeHandler.GetExchangeListResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.s2CData_ = ExchangeHandler.ExchangeData.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CData_ = ExchangeHandler.ExchangeData.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ExchangeHandler.GetExchangeListResponse.alwaysUseFieldBuilders) getS2CDataFieldBuilder();
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
                    this.s2CData_ = ExchangeHandler.ExchangeData.getDefaultInstance();
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
                return ExchangeHandler.internal_static_pomelo_area_GetExchangeListResponse_descriptor;
            }

            public ExchangeHandler.GetExchangeListResponse getDefaultInstanceForType() {
                return ExchangeHandler.GetExchangeListResponse.getDefaultInstance();
            }

            public ExchangeHandler.GetExchangeListResponse build() {
                ExchangeHandler.GetExchangeListResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public ExchangeHandler.GetExchangeListResponse buildPartial() {
                ExchangeHandler.GetExchangeListResponse result = new ExchangeHandler.GetExchangeListResponse(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.s2CMsg_ = this.s2CMsg_;
                if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;
                if (this.s2CDataBuilder_ == null) {
                    result.s2CData_ = this.s2CData_;
                } else {
                    result.s2CData_ = (ExchangeHandler.ExchangeData) this.s2CDataBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof ExchangeHandler.GetExchangeListResponse)
                    return mergeFrom((ExchangeHandler.GetExchangeListResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ExchangeHandler.GetExchangeListResponse other) {
                if (other == ExchangeHandler.GetExchangeListResponse.getDefaultInstance()) return this;
                if (other.hasS2CCode()) setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (other.hasS2CData()) mergeS2CData(other.getS2CData());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode()) return false;
                if (hasS2CData() && !getS2CData().isInitialized()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                ExchangeHandler.GetExchangeListResponse parsedMessage = null;
                try {
                    parsedMessage = (ExchangeHandler.GetExchangeListResponse) ExchangeHandler.GetExchangeListResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (ExchangeHandler.GetExchangeListResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = ExchangeHandler.GetExchangeListResponse.getDefaultInstance().getS2CMsg();
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

            public boolean hasS2CData() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public ExchangeHandler.ExchangeData getS2CData() {
                if (this.s2CDataBuilder_ == null) return this.s2CData_;
                return (ExchangeHandler.ExchangeData) this.s2CDataBuilder_.getMessage();
            }

            public Builder setS2CData(ExchangeHandler.ExchangeData value) {
                if (this.s2CDataBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    this.s2CData_ = value;
                    onChanged();
                } else {
                    this.s2CDataBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder setS2CData(ExchangeHandler.ExchangeData.Builder builderForValue) {
                if (this.s2CDataBuilder_ == null) {
                    this.s2CData_ = builderForValue.build();
                    onChanged();
                } else {
                    this.s2CDataBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder mergeS2CData(ExchangeHandler.ExchangeData value) {
                if (this.s2CDataBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4 && this.s2CData_ != ExchangeHandler.ExchangeData.getDefaultInstance()) {
                        this.s2CData_ = ExchangeHandler.ExchangeData.newBuilder(this.s2CData_).mergeFrom(value).buildPartial();
                    } else {
                        this.s2CData_ = value;
                    }
                    onChanged();
                } else {
                    this.s2CDataBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder clearS2CData() {
                if (this.s2CDataBuilder_ == null) {
                    this.s2CData_ = ExchangeHandler.ExchangeData.getDefaultInstance();
                    onChanged();
                } else {
                    this.s2CDataBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public ExchangeHandler.ExchangeData.Builder getS2CDataBuilder() {
                this.bitField0_ |= 0x4;
                onChanged();
                return (ExchangeHandler.ExchangeData.Builder) getS2CDataFieldBuilder().getBuilder();
            }

            public ExchangeHandler.ExchangeDataOrBuilder getS2CDataOrBuilder() {
                if (this.s2CDataBuilder_ != null)
                    return (ExchangeHandler.ExchangeDataOrBuilder) this.s2CDataBuilder_.getMessageOrBuilder();
                return this.s2CData_;
            }

            private SingleFieldBuilder<ExchangeHandler.ExchangeData, ExchangeHandler.ExchangeData.Builder, ExchangeHandler.ExchangeDataOrBuilder> getS2CDataFieldBuilder() {
                if (this.s2CDataBuilder_ == null) {
                    this.s2CDataBuilder_ = new SingleFieldBuilder(getS2CData(), getParentForChildren(), isClean());
                    this.s2CData_ = null;
                }
                return this.s2CDataBuilder_;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class ExchangeItemResponse
            extends GeneratedMessage
            implements ExchangeItemResponseOrBuilder {
        private static final ExchangeItemResponse defaultInstance = new ExchangeItemResponse(true);
        private final UnknownFieldSet unknownFields;

        private ExchangeItemResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private ExchangeItemResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static ExchangeItemResponse getDefaultInstance() {
            return defaultInstance;
        }

        public ExchangeItemResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ExchangeItemResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString bs;
                    ExchangeHandler.ExchangeData.Builder subBuilder;
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
                            this.s2CData_ = (ExchangeHandler.ExchangeData) input.readMessage(ExchangeHandler.ExchangeData.PARSER, extensionRegistry);
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
            return ExchangeHandler.internal_static_pomelo_area_ExchangeItemResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ExchangeHandler.internal_static_pomelo_area_ExchangeItemResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ExchangeItemResponse.class, Builder.class);
        }

        public static Parser<ExchangeItemResponse> PARSER = (Parser<ExchangeItemResponse>) new AbstractParser<ExchangeItemResponse>() {
            public ExchangeHandler.ExchangeItemResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ExchangeHandler.ExchangeItemResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_DATA_FIELD_NUMBER = 3;
        private ExchangeHandler.ExchangeData s2CData_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<ExchangeItemResponse> getParserForType() {
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

        public boolean hasS2CData() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public ExchangeHandler.ExchangeData getS2CData() {
            return this.s2CData_;
        }

        public ExchangeHandler.ExchangeDataOrBuilder getS2CDataOrBuilder() {
            return this.s2CData_;
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CData_ = ExchangeHandler.ExchangeData.getDefaultInstance();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
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
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2) output.writeBytes(2, getS2CMsgBytes());
            if ((this.bitField0_ & 0x4) == 4) output.writeMessage(3, (MessageLite) this.s2CData_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());
            if ((this.bitField0_ & 0x4) == 4)
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.s2CData_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static ExchangeItemResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ExchangeItemResponse) PARSER.parseFrom(data);
        }

        public static ExchangeItemResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ExchangeItemResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static ExchangeItemResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ExchangeItemResponse) PARSER.parseFrom(data);
        }

        public static ExchangeItemResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ExchangeItemResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static ExchangeItemResponse parseFrom(InputStream input) throws IOException {
            return (ExchangeItemResponse) PARSER.parseFrom(input);
        }

        public static ExchangeItemResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ExchangeItemResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static ExchangeItemResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (ExchangeItemResponse) PARSER.parseDelimitedFrom(input);
        }

        public static ExchangeItemResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ExchangeItemResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static ExchangeItemResponse parseFrom(CodedInputStream input) throws IOException {
            return (ExchangeItemResponse) PARSER.parseFrom(input);
        }

        public static ExchangeItemResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ExchangeItemResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(ExchangeItemResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements ExchangeHandler.ExchangeItemResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private ExchangeHandler.ExchangeData s2CData_;
            private SingleFieldBuilder<ExchangeHandler.ExchangeData, ExchangeHandler.ExchangeData.Builder, ExchangeHandler.ExchangeDataOrBuilder> s2CDataBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ExchangeHandler.internal_static_pomelo_area_ExchangeItemResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return ExchangeHandler.internal_static_pomelo_area_ExchangeItemResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ExchangeHandler.ExchangeItemResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.s2CData_ = ExchangeHandler.ExchangeData.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CData_ = ExchangeHandler.ExchangeData.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ExchangeHandler.ExchangeItemResponse.alwaysUseFieldBuilders) getS2CDataFieldBuilder();
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
                    this.s2CData_ = ExchangeHandler.ExchangeData.getDefaultInstance();
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
                return ExchangeHandler.internal_static_pomelo_area_ExchangeItemResponse_descriptor;
            }

            public ExchangeHandler.ExchangeItemResponse getDefaultInstanceForType() {
                return ExchangeHandler.ExchangeItemResponse.getDefaultInstance();
            }

            public ExchangeHandler.ExchangeItemResponse build() {
                ExchangeHandler.ExchangeItemResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public ExchangeHandler.ExchangeItemResponse buildPartial() {
                ExchangeHandler.ExchangeItemResponse result = new ExchangeHandler.ExchangeItemResponse(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.s2CMsg_ = this.s2CMsg_;
                if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;
                if (this.s2CDataBuilder_ == null) {
                    result.s2CData_ = this.s2CData_;
                } else {
                    result.s2CData_ = (ExchangeHandler.ExchangeData) this.s2CDataBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof ExchangeHandler.ExchangeItemResponse)
                    return mergeFrom((ExchangeHandler.ExchangeItemResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ExchangeHandler.ExchangeItemResponse other) {
                if (other == ExchangeHandler.ExchangeItemResponse.getDefaultInstance()) return this;
                if (other.hasS2CCode()) setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (other.hasS2CData()) mergeS2CData(other.getS2CData());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode()) return false;
                if (hasS2CData() && !getS2CData().isInitialized()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                ExchangeHandler.ExchangeItemResponse parsedMessage = null;
                try {
                    parsedMessage = (ExchangeHandler.ExchangeItemResponse) ExchangeHandler.ExchangeItemResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (ExchangeHandler.ExchangeItemResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = ExchangeHandler.ExchangeItemResponse.getDefaultInstance().getS2CMsg();
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

            public boolean hasS2CData() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public ExchangeHandler.ExchangeData getS2CData() {
                if (this.s2CDataBuilder_ == null) return this.s2CData_;
                return (ExchangeHandler.ExchangeData) this.s2CDataBuilder_.getMessage();
            }

            public Builder setS2CData(ExchangeHandler.ExchangeData value) {
                if (this.s2CDataBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    this.s2CData_ = value;
                    onChanged();
                } else {
                    this.s2CDataBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder setS2CData(ExchangeHandler.ExchangeData.Builder builderForValue) {
                if (this.s2CDataBuilder_ == null) {
                    this.s2CData_ = builderForValue.build();
                    onChanged();
                } else {
                    this.s2CDataBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder mergeS2CData(ExchangeHandler.ExchangeData value) {
                if (this.s2CDataBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4 && this.s2CData_ != ExchangeHandler.ExchangeData.getDefaultInstance()) {
                        this.s2CData_ = ExchangeHandler.ExchangeData.newBuilder(this.s2CData_).mergeFrom(value).buildPartial();
                    } else {
                        this.s2CData_ = value;
                    }
                    onChanged();
                } else {
                    this.s2CDataBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder clearS2CData() {
                if (this.s2CDataBuilder_ == null) {
                    this.s2CData_ = ExchangeHandler.ExchangeData.getDefaultInstance();
                    onChanged();
                } else {
                    this.s2CDataBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public ExchangeHandler.ExchangeData.Builder getS2CDataBuilder() {
                this.bitField0_ |= 0x4;
                onChanged();
                return (ExchangeHandler.ExchangeData.Builder) getS2CDataFieldBuilder().getBuilder();
            }

            public ExchangeHandler.ExchangeDataOrBuilder getS2CDataOrBuilder() {
                if (this.s2CDataBuilder_ != null)
                    return (ExchangeHandler.ExchangeDataOrBuilder) this.s2CDataBuilder_.getMessageOrBuilder();
                return this.s2CData_;
            }

            private SingleFieldBuilder<ExchangeHandler.ExchangeData, ExchangeHandler.ExchangeData.Builder, ExchangeHandler.ExchangeDataOrBuilder> getS2CDataFieldBuilder() {
                if (this.s2CDataBuilder_ == null) {
                    this.s2CDataBuilder_ = new SingleFieldBuilder(getS2CData(), getParentForChildren(), isClean());
                    this.s2CData_ = null;
                }
                return this.s2CDataBuilder_;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class AllyFightExchangeRequest
            extends GeneratedMessage
            implements AllyFightExchangeRequestOrBuilder {
        private static final AllyFightExchangeRequest defaultInstance = new AllyFightExchangeRequest(true);
        private final UnknownFieldSet unknownFields;

        private AllyFightExchangeRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private AllyFightExchangeRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static AllyFightExchangeRequest getDefaultInstance() {
            return defaultInstance;
        }

        public AllyFightExchangeRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AllyFightExchangeRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.c2SNpcId_ = bs;
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.c2STypeId_ = input.readInt32();
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
            return ExchangeHandler.internal_static_pomelo_area_AllyFightExchangeRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ExchangeHandler.internal_static_pomelo_area_AllyFightExchangeRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(AllyFightExchangeRequest.class, Builder.class);
        }

        public static Parser<AllyFightExchangeRequest> PARSER = (Parser<AllyFightExchangeRequest>) new AbstractParser<AllyFightExchangeRequest>() {
            public ExchangeHandler.AllyFightExchangeRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ExchangeHandler.AllyFightExchangeRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_NPCID_FIELD_NUMBER = 1;
        private Object c2SNpcId_;
        public static final int C2S_TYPEID_FIELD_NUMBER = 2;
        private int c2STypeId_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<AllyFightExchangeRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasC2SNpcId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public String getC2SNpcId() {
            Object ref = this.c2SNpcId_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.c2SNpcId_ = s;
            return s;
        }

        public ByteString getC2SNpcIdBytes() {
            Object ref = this.c2SNpcId_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.c2SNpcId_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasC2STypeId() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public int getC2STypeId() {
            return this.c2STypeId_;
        }

        private void initFields() {
            this.c2SNpcId_ = "";
            this.c2STypeId_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasC2SNpcId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasC2STypeId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeBytes(1, getC2SNpcIdBytes());
            if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.c2STypeId_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeBytesSize(1, getC2SNpcIdBytes());
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(2, this.c2STypeId_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static AllyFightExchangeRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (AllyFightExchangeRequest) PARSER.parseFrom(data);
        }

        public static AllyFightExchangeRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AllyFightExchangeRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static AllyFightExchangeRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (AllyFightExchangeRequest) PARSER.parseFrom(data);
        }

        public static AllyFightExchangeRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AllyFightExchangeRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static AllyFightExchangeRequest parseFrom(InputStream input) throws IOException {
            return (AllyFightExchangeRequest) PARSER.parseFrom(input);
        }

        public static AllyFightExchangeRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AllyFightExchangeRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static AllyFightExchangeRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (AllyFightExchangeRequest) PARSER.parseDelimitedFrom(input);
        }

        public static AllyFightExchangeRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AllyFightExchangeRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static AllyFightExchangeRequest parseFrom(CodedInputStream input) throws IOException {
            return (AllyFightExchangeRequest) PARSER.parseFrom(input);
        }

        public static AllyFightExchangeRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AllyFightExchangeRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(AllyFightExchangeRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements ExchangeHandler.AllyFightExchangeRequestOrBuilder {
            private int bitField0_;
            private Object c2SNpcId_;
            private int c2STypeId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ExchangeHandler.internal_static_pomelo_area_AllyFightExchangeRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return ExchangeHandler.internal_static_pomelo_area_AllyFightExchangeRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ExchangeHandler.AllyFightExchangeRequest.class, Builder.class);
            }

            private Builder() {
                this.c2SNpcId_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.c2SNpcId_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ExchangeHandler.AllyFightExchangeRequest.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.c2SNpcId_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2STypeId_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return ExchangeHandler.internal_static_pomelo_area_AllyFightExchangeRequest_descriptor;
            }

            public ExchangeHandler.AllyFightExchangeRequest getDefaultInstanceForType() {
                return ExchangeHandler.AllyFightExchangeRequest.getDefaultInstance();
            }

            public ExchangeHandler.AllyFightExchangeRequest build() {
                ExchangeHandler.AllyFightExchangeRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public ExchangeHandler.AllyFightExchangeRequest buildPartial() {
                ExchangeHandler.AllyFightExchangeRequest result = new ExchangeHandler.AllyFightExchangeRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.c2SNpcId_ = this.c2SNpcId_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.c2STypeId_ = this.c2STypeId_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof ExchangeHandler.AllyFightExchangeRequest)
                    return mergeFrom((ExchangeHandler.AllyFightExchangeRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ExchangeHandler.AllyFightExchangeRequest other) {
                if (other == ExchangeHandler.AllyFightExchangeRequest.getDefaultInstance()) return this;
                if (other.hasC2SNpcId()) {
                    this.bitField0_ |= 0x1;
                    this.c2SNpcId_ = other.c2SNpcId_;
                    onChanged();
                }
                if (other.hasC2STypeId()) setC2STypeId(other.getC2STypeId());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasC2SNpcId()) return false;
                if (!hasC2STypeId()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                ExchangeHandler.AllyFightExchangeRequest parsedMessage = null;
                try {
                    parsedMessage = (ExchangeHandler.AllyFightExchangeRequest) ExchangeHandler.AllyFightExchangeRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (ExchangeHandler.AllyFightExchangeRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasC2SNpcId() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public String getC2SNpcId() {
                Object ref = this.c2SNpcId_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) this.c2SNpcId_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getC2SNpcIdBytes() {
                Object ref = this.c2SNpcId_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.c2SNpcId_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setC2SNpcId(String value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.c2SNpcId_ = value;
                onChanged();
                return this;
            }

            public Builder clearC2SNpcId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SNpcId_ = ExchangeHandler.AllyFightExchangeRequest.getDefaultInstance().getC2SNpcId();
                onChanged();
                return this;
            }

            public Builder setC2SNpcIdBytes(ByteString value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.c2SNpcId_ = value;
                onChanged();
                return this;
            }

            public boolean hasC2STypeId() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getC2STypeId() {
                return this.c2STypeId_;
            }

            public Builder setC2STypeId(int value) {
                this.bitField0_ |= 0x2;
                this.c2STypeId_ = value;
                onChanged();
                return this;
            }

            public Builder clearC2STypeId() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.c2STypeId_ = 0;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class AllyFightExchangeResponse
            extends GeneratedMessage
            implements AllyFightExchangeResponseOrBuilder {
        private static final AllyFightExchangeResponse defaultInstance = new AllyFightExchangeResponse(true);
        private final UnknownFieldSet unknownFields;

        private AllyFightExchangeResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private AllyFightExchangeResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static AllyFightExchangeResponse getDefaultInstance() {
            return defaultInstance;
        }

        public AllyFightExchangeResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AllyFightExchangeResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString bs;
                    ExchangeHandler.ExchangeData.Builder subBuilder;
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
                            this.s2CData_ = (ExchangeHandler.ExchangeData) input.readMessage(ExchangeHandler.ExchangeData.PARSER, extensionRegistry);
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
            return ExchangeHandler.internal_static_pomelo_area_AllyFightExchangeResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ExchangeHandler.internal_static_pomelo_area_AllyFightExchangeResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(AllyFightExchangeResponse.class, Builder.class);
        }

        public static Parser<AllyFightExchangeResponse> PARSER = (Parser<AllyFightExchangeResponse>) new AbstractParser<AllyFightExchangeResponse>() {
            public ExchangeHandler.AllyFightExchangeResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ExchangeHandler.AllyFightExchangeResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_DATA_FIELD_NUMBER = 3;
        private ExchangeHandler.ExchangeData s2CData_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<AllyFightExchangeResponse> getParserForType() {
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

        public boolean hasS2CData() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public ExchangeHandler.ExchangeData getS2CData() {
            return this.s2CData_;
        }

        public ExchangeHandler.ExchangeDataOrBuilder getS2CDataOrBuilder() {
            return this.s2CData_;
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CData_ = ExchangeHandler.ExchangeData.getDefaultInstance();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
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
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2) output.writeBytes(2, getS2CMsgBytes());
            if ((this.bitField0_ & 0x4) == 4) output.writeMessage(3, (MessageLite) this.s2CData_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());
            if ((this.bitField0_ & 0x4) == 4)
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.s2CData_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static AllyFightExchangeResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (AllyFightExchangeResponse) PARSER.parseFrom(data);
        }

        public static AllyFightExchangeResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AllyFightExchangeResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static AllyFightExchangeResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (AllyFightExchangeResponse) PARSER.parseFrom(data);
        }

        public static AllyFightExchangeResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AllyFightExchangeResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static AllyFightExchangeResponse parseFrom(InputStream input) throws IOException {
            return (AllyFightExchangeResponse) PARSER.parseFrom(input);
        }

        public static AllyFightExchangeResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AllyFightExchangeResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static AllyFightExchangeResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (AllyFightExchangeResponse) PARSER.parseDelimitedFrom(input);
        }

        public static AllyFightExchangeResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AllyFightExchangeResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static AllyFightExchangeResponse parseFrom(CodedInputStream input) throws IOException {
            return (AllyFightExchangeResponse) PARSER.parseFrom(input);
        }

        public static AllyFightExchangeResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AllyFightExchangeResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(AllyFightExchangeResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements ExchangeHandler.AllyFightExchangeResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private ExchangeHandler.ExchangeData s2CData_;
            private SingleFieldBuilder<ExchangeHandler.ExchangeData, ExchangeHandler.ExchangeData.Builder, ExchangeHandler.ExchangeDataOrBuilder> s2CDataBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ExchangeHandler.internal_static_pomelo_area_AllyFightExchangeResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return ExchangeHandler.internal_static_pomelo_area_AllyFightExchangeResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ExchangeHandler.AllyFightExchangeResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.s2CData_ = ExchangeHandler.ExchangeData.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CData_ = ExchangeHandler.ExchangeData.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ExchangeHandler.AllyFightExchangeResponse.alwaysUseFieldBuilders) getS2CDataFieldBuilder();
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
                    this.s2CData_ = ExchangeHandler.ExchangeData.getDefaultInstance();
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
                return ExchangeHandler.internal_static_pomelo_area_AllyFightExchangeResponse_descriptor;
            }

            public ExchangeHandler.AllyFightExchangeResponse getDefaultInstanceForType() {
                return ExchangeHandler.AllyFightExchangeResponse.getDefaultInstance();
            }

            public ExchangeHandler.AllyFightExchangeResponse build() {
                ExchangeHandler.AllyFightExchangeResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public ExchangeHandler.AllyFightExchangeResponse buildPartial() {
                ExchangeHandler.AllyFightExchangeResponse result = new ExchangeHandler.AllyFightExchangeResponse(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.s2CMsg_ = this.s2CMsg_;
                if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;
                if (this.s2CDataBuilder_ == null) {
                    result.s2CData_ = this.s2CData_;
                } else {
                    result.s2CData_ = (ExchangeHandler.ExchangeData) this.s2CDataBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof ExchangeHandler.AllyFightExchangeResponse)
                    return mergeFrom((ExchangeHandler.AllyFightExchangeResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ExchangeHandler.AllyFightExchangeResponse other) {
                if (other == ExchangeHandler.AllyFightExchangeResponse.getDefaultInstance()) return this;
                if (other.hasS2CCode()) setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (other.hasS2CData()) mergeS2CData(other.getS2CData());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode()) return false;
                if (hasS2CData() && !getS2CData().isInitialized()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                ExchangeHandler.AllyFightExchangeResponse parsedMessage = null;
                try {
                    parsedMessage = (ExchangeHandler.AllyFightExchangeResponse) ExchangeHandler.AllyFightExchangeResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (ExchangeHandler.AllyFightExchangeResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = ExchangeHandler.AllyFightExchangeResponse.getDefaultInstance().getS2CMsg();
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

            public boolean hasS2CData() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public ExchangeHandler.ExchangeData getS2CData() {
                if (this.s2CDataBuilder_ == null) return this.s2CData_;
                return (ExchangeHandler.ExchangeData) this.s2CDataBuilder_.getMessage();
            }

            public Builder setS2CData(ExchangeHandler.ExchangeData value) {
                if (this.s2CDataBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    this.s2CData_ = value;
                    onChanged();
                } else {
                    this.s2CDataBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder setS2CData(ExchangeHandler.ExchangeData.Builder builderForValue) {
                if (this.s2CDataBuilder_ == null) {
                    this.s2CData_ = builderForValue.build();
                    onChanged();
                } else {
                    this.s2CDataBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder mergeS2CData(ExchangeHandler.ExchangeData value) {
                if (this.s2CDataBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4 && this.s2CData_ != ExchangeHandler.ExchangeData.getDefaultInstance()) {
                        this.s2CData_ = ExchangeHandler.ExchangeData.newBuilder(this.s2CData_).mergeFrom(value).buildPartial();
                    } else {
                        this.s2CData_ = value;
                    }
                    onChanged();
                } else {
                    this.s2CDataBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder clearS2CData() {
                if (this.s2CDataBuilder_ == null) {
                    this.s2CData_ = ExchangeHandler.ExchangeData.getDefaultInstance();
                    onChanged();
                } else {
                    this.s2CDataBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public ExchangeHandler.ExchangeData.Builder getS2CDataBuilder() {
                this.bitField0_ |= 0x4;
                onChanged();
                return (ExchangeHandler.ExchangeData.Builder) getS2CDataFieldBuilder().getBuilder();
            }

            public ExchangeHandler.ExchangeDataOrBuilder getS2CDataOrBuilder() {
                if (this.s2CDataBuilder_ != null)
                    return (ExchangeHandler.ExchangeDataOrBuilder) this.s2CDataBuilder_.getMessageOrBuilder();
                return this.s2CData_;
            }

            private SingleFieldBuilder<ExchangeHandler.ExchangeData, ExchangeHandler.ExchangeData.Builder, ExchangeHandler.ExchangeDataOrBuilder> getS2CDataFieldBuilder() {
                if (this.s2CDataBuilder_ == null) {
                    this.s2CDataBuilder_ = new SingleFieldBuilder(getS2CData(), getParentForChildren(), isClean());
                    this.s2CData_ = null;
                }
                return this.s2CDataBuilder_;
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
        String[] descriptorData = {"\n\025exchangeHandler.proto\022\013pomelo.area\032\nitem.proto\",\n\027GetExchangeLabelRequest\022\021\n\tc2s_npcId\030\001 \002(\t\"?\n\026GetExchangeListRequest\022\021\n\tc2s_npcId\030\001 \002(\t\022\022\n\nc2s_typeId\030\002 \002(\005\"a\n\023ExchangeItemRequest\022\022\n\nc2s_typeId\030\001 \002(\005\022\022\n\nc2s_itemId\030\002 \002(\005\022\017\n\007c2s_num\030\003 \002(\005\022\021\n\tc2s_npcId\030\004 \001(\t\"E\n\tCondition\022(\n\004type\030\001 \001(\0162\032.pomelo.area.ConditionType\022\016\n\006number\030\002 \001(\005\"@\n\tMoneyInfo\022$\n\004type\030\001 \002(\0162\026.pomelo.area.MoneyType\022\r\n\005value\030\002 \002(\005\"Ë\002\n\f", "ExchangeInfo\022\016\n\006typeId\030\001 \001(\005\022\016\n\006itemId\030\002 \001(\005\022\024\n\fitemShowName\030\003 \001(\t\022#\n\004item\030\004 \001(\0132\025.pomelo.item.MiniItem\022\022\n\nscoreRatio\030\005 \001(\005\022\017\n\007itemDes\030\006 \001(\t\022)\n\tcondition\030\007 \003(\0132\026.pomelo.area.Condition\022)\n\tneedMoney\030\b \003(\0132\026.pomelo.area.MoneyInfo\022'\n\bneedItem\030\t \003(\0132\025.pomelo.item.MiniItem\022\025\n\rmeetCondition\030\n \001(\005\022\026\n\016maxExchangeNum\030\013 \001(\005\022\r\n\005state\030\f \001(\005\")\n\005label\022\016\n\006typeId\030\001 \001(\005\022\020\n\btypeName\030\002 \001(\t\"?\n\fExchangeData\022/\n\fexchange", "List\030\001 \003(\0132\031.pomelo.area.ExchangeInfo\"h\n\030GetExchangeLabelResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022)\n\rs2c_labelList\030\003 \003(\0132\022.pomelo.area.label\"i\n\027GetExchangeListResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022+\n\bs2c_data\030\003 \001(\0132\031.pomelo.area.ExchangeData\"f\n\024ExchangeItemResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022+\n\bs2c_data\030\003 \001(\0132\031.pomelo.area.ExchangeData\"A\n\030AllyFightExchangeRequest\022\021\n\tc2s_npcId\030\001 \002(", "\t\022\022\n\nc2s_typeId\030\002 \002(\005\"k\n\031AllyFightExchangeResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022+\n\bs2c_data\030\003 \001(\0132\031.pomelo.area.ExchangeData*·\001\n\rConditionType\022\023\n\017CONDITION_LEVEL\020\001\022\024\n\020CONDITION_UP_REQ\020\002\022\027\n\023CONDITION_VIP_LEVEL\020\003\022\022\n\016CONDITION_RACE\020\004\022\030\n\024CONDITION_RACE_CLASS\020\005\022\031\n\025CONDITION_ARENA_SCORE\020\006\022\031\n\025CONDITION_GUILD_HONOR\020\007*`\n\tMoneyType\022\013\n\007MT_GOLD\020\001\022\016\n\nMT_DIAMOND\020\002\022\r\n\tMT_TICKET\020\003\022\020\n\fMT_FEE_POINT\020\004\022\025\n\021MT_TR", "EASURE_POINT\020\b2¥\003\n\017exchangeHandler\022f\n\027getExchangeLabelRequest\022$.pomelo.area.GetExchangeLabelRequest\032%.pomelo.area.GetExchangeLabelResponse\022c\n\026getExchangeListRequest\022#.pomelo.area.GetExchangeListRequest\032$.pomelo.area.GetExchangeListResponse\022Z\n\023exchangeItemRequest\022 .pomelo.area.ExchangeItemRequest\032!.pomelo.area.ExchangeItemResponse\022i\n\030allyFightExchangeRequest\022%.pomelo.area.AllyFightExchangeRequest\032&", ".pomelo.area.AllyFightExchangeResponse"};


        Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root) {
                ExchangeHandler.descriptor = root;
                return null;
            }
        };

        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[]{

                ItemOuterClass.getDescriptor()}, assigner);
    }

    private static final Descriptors.Descriptor internal_static_pomelo_area_GetExchangeLabelRequest_descriptor = getDescriptor().getMessageTypes().get(0);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetExchangeLabelRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetExchangeLabelRequest_descriptor, new String[]{"C2SNpcId"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetExchangeListRequest_descriptor = getDescriptor().getMessageTypes().get(1);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetExchangeListRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetExchangeListRequest_descriptor, new String[]{"C2SNpcId", "C2STypeId"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_ExchangeItemRequest_descriptor = getDescriptor().getMessageTypes().get(2);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ExchangeItemRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ExchangeItemRequest_descriptor, new String[]{"C2STypeId", "C2SItemId", "C2SNum", "C2SNpcId"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_Condition_descriptor = getDescriptor().getMessageTypes().get(3);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_Condition_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_Condition_descriptor, new String[]{"Type", "Number"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_MoneyInfo_descriptor = getDescriptor().getMessageTypes().get(4);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_MoneyInfo_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_MoneyInfo_descriptor, new String[]{"Type", "Value"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_ExchangeInfo_descriptor = getDescriptor().getMessageTypes().get(5);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ExchangeInfo_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ExchangeInfo_descriptor, new String[]{"TypeId", "ItemId", "ItemShowName", "Item", "ScoreRatio", "ItemDes", "Condition", "NeedMoney", "NeedItem", "MeetCondition", "MaxExchangeNum", "State"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_label_descriptor = getDescriptor().getMessageTypes().get(6);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_label_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_label_descriptor, new String[]{"TypeId", "TypeName"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_ExchangeData_descriptor = getDescriptor().getMessageTypes().get(7);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ExchangeData_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ExchangeData_descriptor, new String[]{"ExchangeList"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetExchangeLabelResponse_descriptor = getDescriptor().getMessageTypes().get(8);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetExchangeLabelResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetExchangeLabelResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CLabelList"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetExchangeListResponse_descriptor = getDescriptor().getMessageTypes().get(9);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetExchangeListResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetExchangeListResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CData"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_ExchangeItemResponse_descriptor = getDescriptor().getMessageTypes().get(10);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ExchangeItemResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ExchangeItemResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CData"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_AllyFightExchangeRequest_descriptor = getDescriptor().getMessageTypes().get(11);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_AllyFightExchangeRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_AllyFightExchangeRequest_descriptor, new String[]{"C2SNpcId", "C2STypeId"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_AllyFightExchangeResponse_descriptor = getDescriptor().getMessageTypes().get(12);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_AllyFightExchangeResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_AllyFightExchangeResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CData"});
    private static Descriptors.FileDescriptor descriptor;

    static {
        ItemOuterClass.getDescriptor();
    }

    public static interface AllyFightExchangeResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasS2CData();

        ExchangeHandler.ExchangeData getS2CData();

        ExchangeHandler.ExchangeDataOrBuilder getS2CDataOrBuilder();
    }

    public static interface AllyFightExchangeRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2SNpcId();

        String getC2SNpcId();

        ByteString getC2SNpcIdBytes();

        boolean hasC2STypeId();

        int getC2STypeId();
    }

    public static interface ExchangeItemResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasS2CData();

        ExchangeHandler.ExchangeData getS2CData();

        ExchangeHandler.ExchangeDataOrBuilder getS2CDataOrBuilder();
    }

    public static interface GetExchangeListResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasS2CData();

        ExchangeHandler.ExchangeData getS2CData();

        ExchangeHandler.ExchangeDataOrBuilder getS2CDataOrBuilder();
    }

    public static interface GetExchangeLabelResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        List<ExchangeHandler.label> getS2CLabelListList();

        ExchangeHandler.label getS2CLabelList(int param1Int);

        int getS2CLabelListCount();

        List<? extends ExchangeHandler.labelOrBuilder> getS2CLabelListOrBuilderList();

        ExchangeHandler.labelOrBuilder getS2CLabelListOrBuilder(int param1Int);
    }

    public static interface ExchangeDataOrBuilder extends MessageOrBuilder {
        List<ExchangeHandler.ExchangeInfo> getExchangeListList();

        ExchangeHandler.ExchangeInfo getExchangeList(int param1Int);

        int getExchangeListCount();

        List<? extends ExchangeHandler.ExchangeInfoOrBuilder> getExchangeListOrBuilderList();

        ExchangeHandler.ExchangeInfoOrBuilder getExchangeListOrBuilder(int param1Int);
    }

    public static interface labelOrBuilder extends MessageOrBuilder {
        boolean hasTypeId();

        int getTypeId();

        boolean hasTypeName();

        String getTypeName();

        ByteString getTypeNameBytes();
    }

    public static interface ExchangeInfoOrBuilder extends MessageOrBuilder {
        boolean hasTypeId();

        int getTypeId();

        boolean hasItemId();

        int getItemId();

        boolean hasItemShowName();

        String getItemShowName();

        ByteString getItemShowNameBytes();

        boolean hasItem();

        ItemOuterClass.MiniItem getItem();

        ItemOuterClass.MiniItemOrBuilder getItemOrBuilder();

        boolean hasScoreRatio();

        int getScoreRatio();

        boolean hasItemDes();

        String getItemDes();

        ByteString getItemDesBytes();

        List<ExchangeHandler.Condition> getConditionList();

        ExchangeHandler.Condition getCondition(int param1Int);

        int getConditionCount();

        List<? extends ExchangeHandler.ConditionOrBuilder> getConditionOrBuilderList();

        ExchangeHandler.ConditionOrBuilder getConditionOrBuilder(int param1Int);

        List<ExchangeHandler.MoneyInfo> getNeedMoneyList();

        ExchangeHandler.MoneyInfo getNeedMoney(int param1Int);

        int getNeedMoneyCount();

        List<? extends ExchangeHandler.MoneyInfoOrBuilder> getNeedMoneyOrBuilderList();

        ExchangeHandler.MoneyInfoOrBuilder getNeedMoneyOrBuilder(int param1Int);

        List<ItemOuterClass.MiniItem> getNeedItemList();

        ItemOuterClass.MiniItem getNeedItem(int param1Int);

        int getNeedItemCount();

        List<? extends ItemOuterClass.MiniItemOrBuilder> getNeedItemOrBuilderList();

        ItemOuterClass.MiniItemOrBuilder getNeedItemOrBuilder(int param1Int);

        boolean hasMeetCondition();

        int getMeetCondition();

        boolean hasMaxExchangeNum();

        int getMaxExchangeNum();

        boolean hasState();

        int getState();
    }

    public static interface MoneyInfoOrBuilder extends MessageOrBuilder {
        boolean hasType();

        ExchangeHandler.MoneyType getType();

        boolean hasValue();

        int getValue();
    }

    public static interface ConditionOrBuilder extends MessageOrBuilder {
        boolean hasType();

        ExchangeHandler.ConditionType getType();

        boolean hasNumber();

        int getNumber();
    }

    public static interface ExchangeItemRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2STypeId();

        int getC2STypeId();

        boolean hasC2SItemId();

        int getC2SItemId();

        boolean hasC2SNum();

        int getC2SNum();

        boolean hasC2SNpcId();

        String getC2SNpcId();

        ByteString getC2SNpcIdBytes();
    }

    public static interface GetExchangeListRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2SNpcId();

        String getC2SNpcId();

        ByteString getC2SNpcIdBytes();

        boolean hasC2STypeId();

        int getC2STypeId();
    }

    public static interface GetExchangeLabelRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2SNpcId();

        String getC2SNpcId();

        ByteString getC2SNpcIdBytes();
    }
}


