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
import com.google.protobuf.SingleFieldBuilder;
import com.google.protobuf.UnknownFieldSet;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;

import pomelo.Common;


public final class WingHandler {
    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static final class WingData
            extends GeneratedMessage
            implements WingDataOrBuilder {
        private static final WingData defaultInstance = new WingData(true);
        private final UnknownFieldSet unknownFields;

        private WingData(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private WingData(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static WingData getDefaultInstance() {
            return defaultInstance;
        }

        public WingData getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private WingData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.currLevel_ = input.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.currStar_ = input.readInt32();
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.currExp_ = input.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.currReiki_ = input.readInt32();
                            break;
                        case 40:
                            this.bitField0_ |= 0x10;
                            this.fightPower_ = input.readInt32();
                            break;
                        case 48:
                            this.bitField0_ |= 0x20;
                            this.savedLevel_ = input.readInt32();
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
            return WingHandler.internal_static_pomelo_area_WingData_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return WingHandler.internal_static_pomelo_area_WingData_fieldAccessorTable.ensureFieldAccessorsInitialized(WingData.class, Builder.class);
        }

        public static Parser<WingData> PARSER = (Parser<WingData>) new AbstractParser<WingData>() {
            public WingHandler.WingData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new WingHandler.WingData(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int CURRLEVEL_FIELD_NUMBER = 1;
        private int currLevel_;
        public static final int CURRSTAR_FIELD_NUMBER = 2;
        private int currStar_;
        public static final int CURREXP_FIELD_NUMBER = 3;
        private int currExp_;
        public static final int CURRREIKI_FIELD_NUMBER = 4;
        private int currReiki_;
        public static final int FIGHTPOWER_FIELD_NUMBER = 5;
        private int fightPower_;
        public static final int SAVEDLEVEL_FIELD_NUMBER = 6;
        private int savedLevel_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<WingData> getParserForType() {
            return PARSER;
        }

        public boolean hasCurrLevel() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getCurrLevel() {
            return this.currLevel_;
        }

        public boolean hasCurrStar() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public int getCurrStar() {
            return this.currStar_;
        }

        public boolean hasCurrExp() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getCurrExp() {
            return this.currExp_;
        }

        public boolean hasCurrReiki() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public int getCurrReiki() {
            return this.currReiki_;
        }

        public boolean hasFightPower() {
            return ((this.bitField0_ & 0x10) == 16);
        }

        public int getFightPower() {
            return this.fightPower_;
        }

        public boolean hasSavedLevel() {
            return ((this.bitField0_ & 0x20) == 32);
        }

        public int getSavedLevel() {
            return this.savedLevel_;
        }

        private void initFields() {
            this.currLevel_ = 0;
            this.currStar_ = 0;
            this.currExp_ = 0;
            this.currReiki_ = 0;
            this.fightPower_ = 0;
            this.savedLevel_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasCurrLevel()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasCurrStar()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasCurrExp()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasCurrReiki()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasFightPower()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.currLevel_);
            if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.currStar_);
            if ((this.bitField0_ & 0x4) == 4) output.writeInt32(3, this.currExp_);
            if ((this.bitField0_ & 0x8) == 8) output.writeInt32(4, this.currReiki_);
            if ((this.bitField0_ & 0x10) == 16) output.writeInt32(5, this.fightPower_);
            if ((this.bitField0_ & 0x20) == 32) output.writeInt32(6, this.savedLevel_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.currLevel_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(2, this.currStar_);
            if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeInt32Size(3, this.currExp_);
            if ((this.bitField0_ & 0x8) == 8) size += CodedOutputStream.computeInt32Size(4, this.currReiki_);
            if ((this.bitField0_ & 0x10) == 16) size += CodedOutputStream.computeInt32Size(5, this.fightPower_);
            if ((this.bitField0_ & 0x20) == 32) size += CodedOutputStream.computeInt32Size(6, this.savedLevel_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static WingData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (WingData) PARSER.parseFrom(data);
        }

        static {
            defaultInstance.initFields();
        }

        public static WingData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (WingData) PARSER.parseFrom(data, extensionRegistry);
        }

        public static WingData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (WingData) PARSER.parseFrom(data);
        }

        public static WingData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (WingData) PARSER.parseFrom(data, extensionRegistry);
        }

        public static WingData parseFrom(InputStream input) throws IOException {
            return (WingData) PARSER.parseFrom(input);
        }

        public static WingData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WingData) PARSER.parseFrom(input, extensionRegistry);
        }

        public static WingData parseDelimitedFrom(InputStream input) throws IOException {
            return (WingData) PARSER.parseDelimitedFrom(input);
        }

        public static WingData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WingData) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static WingData parseFrom(CodedInputStream input) throws IOException {
            return (WingData) PARSER.parseFrom(input);
        }

        public static WingData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WingData) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(WingData prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements WingHandler.WingDataOrBuilder {
            private int bitField0_;
            private int currLevel_;
            private int currStar_;
            private int currExp_;
            private int currReiki_;
            private int fightPower_;
            private int savedLevel_;

            public static final Descriptors.Descriptor getDescriptor() {
                return WingHandler.internal_static_pomelo_area_WingData_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return WingHandler.internal_static_pomelo_area_WingData_fieldAccessorTable.ensureFieldAccessorsInitialized(WingHandler.WingData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (WingHandler.WingData.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.currLevel_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.currStar_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                this.currExp_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.currReiki_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                this.fightPower_ = 0;
                this.bitField0_ &= 0xFFFFFFEF;
                this.savedLevel_ = 0;
                this.bitField0_ &= 0xFFFFFFDF;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return WingHandler.internal_static_pomelo_area_WingData_descriptor;
            }

            public WingHandler.WingData getDefaultInstanceForType() {
                return WingHandler.WingData.getDefaultInstance();
            }

            public WingHandler.WingData build() {
                WingHandler.WingData result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public WingHandler.WingData buildPartial() {
                WingHandler.WingData result = new WingHandler.WingData(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.currLevel_ = this.currLevel_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.currStar_ = this.currStar_;
                if ((from_bitField0_ & 0x4) == 4)
                    to_bitField0_ |= 0x4;
                result.currExp_ = this.currExp_;
                if ((from_bitField0_ & 0x8) == 8)
                    to_bitField0_ |= 0x8;
                result.currReiki_ = this.currReiki_;
                if ((from_bitField0_ & 0x10) == 16)
                    to_bitField0_ |= 0x10;
                result.fightPower_ = this.fightPower_;
                if ((from_bitField0_ & 0x20) == 32)
                    to_bitField0_ |= 0x20;
                result.savedLevel_ = this.savedLevel_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof WingHandler.WingData)
                    return mergeFrom((WingHandler.WingData) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(WingHandler.WingData other) {
                if (other == WingHandler.WingData.getDefaultInstance())
                    return this;
                if (other.hasCurrLevel())
                    setCurrLevel(other.getCurrLevel());
                if (other.hasCurrStar())
                    setCurrStar(other.getCurrStar());
                if (other.hasCurrExp())
                    setCurrExp(other.getCurrExp());
                if (other.hasCurrReiki())
                    setCurrReiki(other.getCurrReiki());
                if (other.hasFightPower())
                    setFightPower(other.getFightPower());
                if (other.hasSavedLevel())
                    setSavedLevel(other.getSavedLevel());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasCurrLevel())
                    return false;
                if (!hasCurrStar())
                    return false;
                if (!hasCurrExp())
                    return false;
                if (!hasCurrReiki())
                    return false;
                if (!hasFightPower())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                WingHandler.WingData parsedMessage = null;
                try {
                    parsedMessage = (WingHandler.WingData) WingHandler.WingData.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (WingHandler.WingData) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null)
                        mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasCurrLevel() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getCurrLevel() {
                return this.currLevel_;
            }

            public Builder setCurrLevel(int value) {
                this.bitField0_ |= 0x1;
                this.currLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurrLevel() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.currLevel_ = 0;
                onChanged();
                return this;
            }

            public boolean hasCurrStar() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getCurrStar() {
                return this.currStar_;
            }

            public Builder setCurrStar(int value) {
                this.bitField0_ |= 0x2;
                this.currStar_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurrStar() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.currStar_ = 0;
                onChanged();
                return this;
            }

            public boolean hasCurrExp() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public int getCurrExp() {
                return this.currExp_;
            }

            public Builder setCurrExp(int value) {
                this.bitField0_ |= 0x4;
                this.currExp_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurrExp() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.currExp_ = 0;
                onChanged();
                return this;
            }

            public boolean hasCurrReiki() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public int getCurrReiki() {
                return this.currReiki_;
            }

            public Builder setCurrReiki(int value) {
                this.bitField0_ |= 0x8;
                this.currReiki_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurrReiki() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.currReiki_ = 0;
                onChanged();
                return this;
            }

            public boolean hasFightPower() {
                return ((this.bitField0_ & 0x10) == 16);
            }

            public int getFightPower() {
                return this.fightPower_;
            }

            public Builder setFightPower(int value) {
                this.bitField0_ |= 0x10;
                this.fightPower_ = value;
                onChanged();
                return this;
            }

            public Builder clearFightPower() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.fightPower_ = 0;
                onChanged();
                return this;
            }

            public boolean hasSavedLevel() {
                return ((this.bitField0_ & 0x20) == 32);
            }

            public int getSavedLevel() {
                return this.savedLevel_;
            }

            public Builder setSavedLevel(int value) {
                this.bitField0_ |= 0x20;
                this.savedLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearSavedLevel() {
                this.bitField0_ &= 0xFFFFFFDF;
                this.savedLevel_ = 0;
                onChanged();
                return this;
            }
        }
    }

    public static final class GetWingInfoRequest extends GeneratedMessage implements GetWingInfoRequestOrBuilder {
        private static final GetWingInfoRequest defaultInstance = new GetWingInfoRequest(true);
        private final UnknownFieldSet unknownFields;

        private GetWingInfoRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetWingInfoRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetWingInfoRequest getDefaultInstance() {
            return defaultInstance;
        }

        public GetWingInfoRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetWingInfoRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return WingHandler.internal_static_pomelo_area_GetWingInfoRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return WingHandler.internal_static_pomelo_area_GetWingInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetWingInfoRequest.class, Builder.class);
        }

        public static Parser<GetWingInfoRequest> PARSER = (Parser<GetWingInfoRequest>) new AbstractParser<GetWingInfoRequest>() {
            public WingHandler.GetWingInfoRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new WingHandler.GetWingInfoRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetWingInfoRequest> getParserForType() {
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


        public static GetWingInfoRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetWingInfoRequest) PARSER.parseFrom(data);
        }


        public static GetWingInfoRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetWingInfoRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetWingInfoRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetWingInfoRequest) PARSER.parseFrom(data);
        }


        public static GetWingInfoRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetWingInfoRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetWingInfoRequest parseFrom(InputStream input) throws IOException {
            return (GetWingInfoRequest) PARSER.parseFrom(input);
        }


        public static GetWingInfoRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetWingInfoRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static GetWingInfoRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (GetWingInfoRequest) PARSER.parseDelimitedFrom(input);
        }


        public static GetWingInfoRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetWingInfoRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static GetWingInfoRequest parseFrom(CodedInputStream input) throws IOException {
            return (GetWingInfoRequest) PARSER.parseFrom(input);
        }


        public static GetWingInfoRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetWingInfoRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(GetWingInfoRequest prototype) {
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
                implements WingHandler.GetWingInfoRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return WingHandler.internal_static_pomelo_area_GetWingInfoRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return WingHandler.internal_static_pomelo_area_GetWingInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(WingHandler.GetWingInfoRequest.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (WingHandler.GetWingInfoRequest.alwaysUseFieldBuilders) ;
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
                return WingHandler.internal_static_pomelo_area_GetWingInfoRequest_descriptor;
            }


            public WingHandler.GetWingInfoRequest getDefaultInstanceForType() {
                return WingHandler.GetWingInfoRequest.getDefaultInstance();
            }


            public WingHandler.GetWingInfoRequest build() {
                WingHandler.GetWingInfoRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public WingHandler.GetWingInfoRequest buildPartial() {
                WingHandler.GetWingInfoRequest result = new WingHandler.GetWingInfoRequest(this);
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof WingHandler.GetWingInfoRequest) {
                    return mergeFrom((WingHandler.GetWingInfoRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(WingHandler.GetWingInfoRequest other) {
                if (other == WingHandler.GetWingInfoRequest.getDefaultInstance()) {
                    return this;
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                WingHandler.GetWingInfoRequest parsedMessage = null;
                try {
                    parsedMessage = (WingHandler.GetWingInfoRequest) WingHandler.GetWingInfoRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (WingHandler.GetWingInfoRequest) e.getUnfinishedMessage();
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


    public static final class GetWingInfoResponse
            extends GeneratedMessage
            implements GetWingInfoResponseOrBuilder {
        private static final GetWingInfoResponse defaultInstance = new GetWingInfoResponse(true);
        private final UnknownFieldSet unknownFields;

        private GetWingInfoResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetWingInfoResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetWingInfoResponse getDefaultInstance() {
            return defaultInstance;
        }

        public GetWingInfoResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetWingInfoResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString bs;
                    WingHandler.WingData.Builder subBuilder;
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
                            if ((this.bitField0_ & 0x4) == 4) subBuilder = this.s2CWingData_.toBuilder();
                            this.s2CWingData_ = (WingHandler.WingData) input.readMessage(WingHandler.WingData.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.s2CWingData_);
                                this.s2CWingData_ = subBuilder.buildPartial();
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
            return WingHandler.internal_static_pomelo_area_GetWingInfoResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return WingHandler.internal_static_pomelo_area_GetWingInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetWingInfoResponse.class, Builder.class);
        }

        public static Parser<GetWingInfoResponse> PARSER = (Parser<GetWingInfoResponse>) new AbstractParser<GetWingInfoResponse>() {
            public WingHandler.GetWingInfoResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new WingHandler.GetWingInfoResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_WINGDATA_FIELD_NUMBER = 3;
        private WingHandler.WingData s2CWingData_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetWingInfoResponse> getParserForType() {
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

        public boolean hasS2CWingData() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public WingHandler.WingData getS2CWingData() {
            return this.s2CWingData_;
        }

        public WingHandler.WingDataOrBuilder getS2CWingDataOrBuilder() {
            return this.s2CWingData_;
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CWingData_ = WingHandler.WingData.getDefaultInstance();
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
            if (hasS2CWingData() && !getS2CWingData().isInitialized()) {
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
            if ((this.bitField0_ & 0x2) == 2)
                output.writeBytes(2, getS2CMsgBytes());
            if ((this.bitField0_ & 0x4) == 4)
                output.writeMessage(3, (MessageLite) this.s2CWingData_);
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
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.s2CWingData_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static GetWingInfoResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetWingInfoResponse) PARSER.parseFrom(data);
        }

        public static GetWingInfoResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetWingInfoResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetWingInfoResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetWingInfoResponse) PARSER.parseFrom(data);
        }

        public static GetWingInfoResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetWingInfoResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetWingInfoResponse parseFrom(InputStream input) throws IOException {
            return (GetWingInfoResponse) PARSER.parseFrom(input);
        }

        public static GetWingInfoResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetWingInfoResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static GetWingInfoResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (GetWingInfoResponse) PARSER.parseDelimitedFrom(input);
        }

        public static GetWingInfoResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetWingInfoResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static GetWingInfoResponse parseFrom(CodedInputStream input) throws IOException {
            return (GetWingInfoResponse) PARSER.parseFrom(input);
        }

        public static GetWingInfoResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetWingInfoResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(GetWingInfoResponse prototype) {
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
                implements WingHandler.GetWingInfoResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private WingHandler.WingData s2CWingData_;
            private SingleFieldBuilder<WingHandler.WingData, WingHandler.WingData.Builder, WingHandler.WingDataOrBuilder> s2CWingDataBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return WingHandler.internal_static_pomelo_area_GetWingInfoResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return WingHandler.internal_static_pomelo_area_GetWingInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(WingHandler.GetWingInfoResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.s2CWingData_ = WingHandler.WingData.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CWingData_ = WingHandler.WingData.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (WingHandler.GetWingInfoResponse.alwaysUseFieldBuilders)
                    getS2CWingDataFieldBuilder();
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
                if (this.s2CWingDataBuilder_ == null) {
                    this.s2CWingData_ = WingHandler.WingData.getDefaultInstance();
                } else {
                    this.s2CWingDataBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return WingHandler.internal_static_pomelo_area_GetWingInfoResponse_descriptor;
            }

            public WingHandler.GetWingInfoResponse getDefaultInstanceForType() {
                return WingHandler.GetWingInfoResponse.getDefaultInstance();
            }

            public WingHandler.GetWingInfoResponse build() {
                WingHandler.GetWingInfoResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public WingHandler.GetWingInfoResponse buildPartial() {
                WingHandler.GetWingInfoResponse result = new WingHandler.GetWingInfoResponse(this);
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
                if (this.s2CWingDataBuilder_ == null) {
                    result.s2CWingData_ = this.s2CWingData_;
                } else {
                    result.s2CWingData_ = (WingHandler.WingData) this.s2CWingDataBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof WingHandler.GetWingInfoResponse)
                    return mergeFrom((WingHandler.GetWingInfoResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(WingHandler.GetWingInfoResponse other) {
                if (other == WingHandler.GetWingInfoResponse.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (other.hasS2CWingData())
                    mergeS2CWingData(other.getS2CWingData());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode())
                    return false;
                if (hasS2CWingData() && !getS2CWingData().isInitialized())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                WingHandler.GetWingInfoResponse parsedMessage = null;
                try {
                    parsedMessage = (WingHandler.GetWingInfoResponse) WingHandler.GetWingInfoResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (WingHandler.GetWingInfoResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = WingHandler.GetWingInfoResponse.getDefaultInstance().getS2CMsg();
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

            public boolean hasS2CWingData() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public WingHandler.WingData getS2CWingData() {
                if (this.s2CWingDataBuilder_ == null)
                    return this.s2CWingData_;
                return (WingHandler.WingData) this.s2CWingDataBuilder_.getMessage();
            }

            public Builder setS2CWingData(WingHandler.WingData value) {
                if (this.s2CWingDataBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    this.s2CWingData_ = value;
                    onChanged();
                } else {
                    this.s2CWingDataBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder setS2CWingData(WingHandler.WingData.Builder builderForValue) {
                if (this.s2CWingDataBuilder_ == null) {
                    this.s2CWingData_ = builderForValue.build();
                    onChanged();
                } else {
                    this.s2CWingDataBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder mergeS2CWingData(WingHandler.WingData value) {
                if (this.s2CWingDataBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4 && this.s2CWingData_ != WingHandler.WingData.getDefaultInstance()) {
                        this.s2CWingData_ = WingHandler.WingData.newBuilder(this.s2CWingData_).mergeFrom(value).buildPartial();
                    } else {
                        this.s2CWingData_ = value;
                    }
                    onChanged();
                } else {
                    this.s2CWingDataBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder clearS2CWingData() {
                if (this.s2CWingDataBuilder_ == null) {
                    this.s2CWingData_ = WingHandler.WingData.getDefaultInstance();
                    onChanged();
                } else {
                    this.s2CWingDataBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public WingHandler.WingData.Builder getS2CWingDataBuilder() {
                this.bitField0_ |= 0x4;
                onChanged();
                return (WingHandler.WingData.Builder) getS2CWingDataFieldBuilder().getBuilder();
            }

            public WingHandler.WingDataOrBuilder getS2CWingDataOrBuilder() {
                if (this.s2CWingDataBuilder_ != null)
                    return (WingHandler.WingDataOrBuilder) this.s2CWingDataBuilder_.getMessageOrBuilder();
                return this.s2CWingData_;
            }

            private SingleFieldBuilder<WingHandler.WingData, WingHandler.WingData.Builder, WingHandler.WingDataOrBuilder> getS2CWingDataFieldBuilder() {
                if (this.s2CWingDataBuilder_ == null) {
                    this.s2CWingDataBuilder_ = new SingleFieldBuilder(getS2CWingData(), getParentForChildren(), isClean());
                    this.s2CWingData_ = null;
                }
                return this.s2CWingDataBuilder_;
            }
        }
    }

    public static final class TrainingWingRequest
            extends GeneratedMessage
            implements TrainingWingRequestOrBuilder {
        private static final TrainingWingRequest defaultInstance = new TrainingWingRequest(true);
        private final UnknownFieldSet unknownFields;

        private TrainingWingRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private TrainingWingRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static TrainingWingRequest getDefaultInstance() {
            return defaultInstance;
        }

        public TrainingWingRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private TrainingWingRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return WingHandler.internal_static_pomelo_area_TrainingWingRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return WingHandler.internal_static_pomelo_area_TrainingWingRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(TrainingWingRequest.class, Builder.class);
        }

        public static Parser<TrainingWingRequest> PARSER = (Parser<TrainingWingRequest>) new AbstractParser<TrainingWingRequest>() {
            public WingHandler.TrainingWingRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new WingHandler.TrainingWingRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_TYPE_FIELD_NUMBER = 1;
        private int c2SType_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<TrainingWingRequest> getParserForType() {
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


        public static TrainingWingRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (TrainingWingRequest) PARSER.parseFrom(data);
        }


        public static TrainingWingRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (TrainingWingRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static TrainingWingRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (TrainingWingRequest) PARSER.parseFrom(data);
        }


        public static TrainingWingRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (TrainingWingRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static TrainingWingRequest parseFrom(InputStream input) throws IOException {
            return (TrainingWingRequest) PARSER.parseFrom(input);
        }


        public static TrainingWingRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TrainingWingRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static TrainingWingRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (TrainingWingRequest) PARSER.parseDelimitedFrom(input);
        }


        public static TrainingWingRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TrainingWingRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static TrainingWingRequest parseFrom(CodedInputStream input) throws IOException {
            return (TrainingWingRequest) PARSER.parseFrom(input);
        }


        public static TrainingWingRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TrainingWingRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(TrainingWingRequest prototype) {
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
                implements WingHandler.TrainingWingRequestOrBuilder {
            private int bitField0_;


            private int c2SType_;


            public static final Descriptors.Descriptor getDescriptor() {
                return WingHandler.internal_static_pomelo_area_TrainingWingRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return WingHandler.internal_static_pomelo_area_TrainingWingRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(WingHandler.TrainingWingRequest.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (WingHandler.TrainingWingRequest.alwaysUseFieldBuilders) ;
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
                return WingHandler.internal_static_pomelo_area_TrainingWingRequest_descriptor;
            }


            public WingHandler.TrainingWingRequest getDefaultInstanceForType() {
                return WingHandler.TrainingWingRequest.getDefaultInstance();
            }


            public WingHandler.TrainingWingRequest build() {
                WingHandler.TrainingWingRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public WingHandler.TrainingWingRequest buildPartial() {
                WingHandler.TrainingWingRequest result = new WingHandler.TrainingWingRequest(this);
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
                if (other instanceof WingHandler.TrainingWingRequest) {
                    return mergeFrom((WingHandler.TrainingWingRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(WingHandler.TrainingWingRequest other) {
                if (other == WingHandler.TrainingWingRequest.getDefaultInstance()) {
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
                WingHandler.TrainingWingRequest parsedMessage = null;
                try {
                    parsedMessage = (WingHandler.TrainingWingRequest) WingHandler.TrainingWingRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (WingHandler.TrainingWingRequest) e.getUnfinishedMessage();
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


    public static final class TrainingWingResponse
            extends GeneratedMessage
            implements TrainingWingResponseOrBuilder {
        private static final TrainingWingResponse defaultInstance = new TrainingWingResponse(true);
        private final UnknownFieldSet unknownFields;

        private TrainingWingResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private TrainingWingResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static TrainingWingResponse getDefaultInstance() {
            return defaultInstance;
        }

        public TrainingWingResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private TrainingWingResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString bs;
                    WingHandler.WingData.Builder subBuilder;
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
                            if ((this.bitField0_ & 0x4) == 4) subBuilder = this.s2CWingData_.toBuilder();
                            this.s2CWingData_ = (WingHandler.WingData) input.readMessage(WingHandler.WingData.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.s2CWingData_);
                                this.s2CWingData_ = subBuilder.buildPartial();
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
            return WingHandler.internal_static_pomelo_area_TrainingWingResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return WingHandler.internal_static_pomelo_area_TrainingWingResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(TrainingWingResponse.class, Builder.class);
        }

        public static Parser<TrainingWingResponse> PARSER = (Parser<TrainingWingResponse>) new AbstractParser<TrainingWingResponse>() {
            public WingHandler.TrainingWingResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new WingHandler.TrainingWingResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_WINGDATA_FIELD_NUMBER = 3;
        private WingHandler.WingData s2CWingData_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<TrainingWingResponse> getParserForType() {
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

        public boolean hasS2CWingData() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public WingHandler.WingData getS2CWingData() {
            return this.s2CWingData_;
        }

        public WingHandler.WingDataOrBuilder getS2CWingDataOrBuilder() {
            return this.s2CWingData_;
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CWingData_ = WingHandler.WingData.getDefaultInstance();
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
            if (hasS2CWingData() && !getS2CWingData().isInitialized()) {
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
                output.writeMessage(3, (MessageLite) this.s2CWingData_);
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
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.s2CWingData_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static TrainingWingResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (TrainingWingResponse) PARSER.parseFrom(data);
        }

        public static TrainingWingResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (TrainingWingResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static TrainingWingResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (TrainingWingResponse) PARSER.parseFrom(data);
        }

        public static TrainingWingResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (TrainingWingResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static TrainingWingResponse parseFrom(InputStream input) throws IOException {
            return (TrainingWingResponse) PARSER.parseFrom(input);
        }

        public static TrainingWingResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TrainingWingResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static TrainingWingResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (TrainingWingResponse) PARSER.parseDelimitedFrom(input);
        }

        public static TrainingWingResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TrainingWingResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static TrainingWingResponse parseFrom(CodedInputStream input) throws IOException {
            return (TrainingWingResponse) PARSER.parseFrom(input);
        }

        public static TrainingWingResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TrainingWingResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(TrainingWingResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements WingHandler.TrainingWingResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private WingHandler.WingData s2CWingData_;
            private SingleFieldBuilder<WingHandler.WingData, WingHandler.WingData.Builder, WingHandler.WingDataOrBuilder> s2CWingDataBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return WingHandler.internal_static_pomelo_area_TrainingWingResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return WingHandler.internal_static_pomelo_area_TrainingWingResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(WingHandler.TrainingWingResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.s2CWingData_ = WingHandler.WingData.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CWingData_ = WingHandler.WingData.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (WingHandler.TrainingWingResponse.alwaysUseFieldBuilders)
                    getS2CWingDataFieldBuilder();
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
                if (this.s2CWingDataBuilder_ == null) {
                    this.s2CWingData_ = WingHandler.WingData.getDefaultInstance();
                } else {
                    this.s2CWingDataBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return WingHandler.internal_static_pomelo_area_TrainingWingResponse_descriptor;
            }

            public WingHandler.TrainingWingResponse getDefaultInstanceForType() {
                return WingHandler.TrainingWingResponse.getDefaultInstance();
            }

            public WingHandler.TrainingWingResponse build() {
                WingHandler.TrainingWingResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public WingHandler.TrainingWingResponse buildPartial() {
                WingHandler.TrainingWingResponse result = new WingHandler.TrainingWingResponse(this);
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
                if (this.s2CWingDataBuilder_ == null) {
                    result.s2CWingData_ = this.s2CWingData_;
                } else {
                    result.s2CWingData_ = (WingHandler.WingData) this.s2CWingDataBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof WingHandler.TrainingWingResponse)
                    return mergeFrom((WingHandler.TrainingWingResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(WingHandler.TrainingWingResponse other) {
                if (other == WingHandler.TrainingWingResponse.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (other.hasS2CWingData())
                    mergeS2CWingData(other.getS2CWingData());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode())
                    return false;
                if (hasS2CWingData() && !getS2CWingData().isInitialized())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                WingHandler.TrainingWingResponse parsedMessage = null;
                try {
                    parsedMessage = (WingHandler.TrainingWingResponse) WingHandler.TrainingWingResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (WingHandler.TrainingWingResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = WingHandler.TrainingWingResponse.getDefaultInstance().getS2CMsg();
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

            public boolean hasS2CWingData() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public WingHandler.WingData getS2CWingData() {
                if (this.s2CWingDataBuilder_ == null)
                    return this.s2CWingData_;
                return (WingHandler.WingData) this.s2CWingDataBuilder_.getMessage();
            }

            public Builder setS2CWingData(WingHandler.WingData value) {
                if (this.s2CWingDataBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    this.s2CWingData_ = value;
                    onChanged();
                } else {
                    this.s2CWingDataBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder setS2CWingData(WingHandler.WingData.Builder builderForValue) {
                if (this.s2CWingDataBuilder_ == null) {
                    this.s2CWingData_ = builderForValue.build();
                    onChanged();
                } else {
                    this.s2CWingDataBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder mergeS2CWingData(WingHandler.WingData value) {
                if (this.s2CWingDataBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4 && this.s2CWingData_ != WingHandler.WingData.getDefaultInstance()) {
                        this.s2CWingData_ = WingHandler.WingData.newBuilder(this.s2CWingData_).mergeFrom(value).buildPartial();
                    } else {
                        this.s2CWingData_ = value;
                    }
                    onChanged();
                } else {
                    this.s2CWingDataBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder clearS2CWingData() {
                if (this.s2CWingDataBuilder_ == null) {
                    this.s2CWingData_ = WingHandler.WingData.getDefaultInstance();
                    onChanged();
                } else {
                    this.s2CWingDataBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public WingHandler.WingData.Builder getS2CWingDataBuilder() {
                this.bitField0_ |= 0x4;
                onChanged();
                return (WingHandler.WingData.Builder) getS2CWingDataFieldBuilder().getBuilder();
            }

            public WingHandler.WingDataOrBuilder getS2CWingDataOrBuilder() {
                if (this.s2CWingDataBuilder_ != null)
                    return (WingHandler.WingDataOrBuilder) this.s2CWingDataBuilder_.getMessageOrBuilder();
                return this.s2CWingData_;
            }

            private SingleFieldBuilder<WingHandler.WingData, WingHandler.WingData.Builder, WingHandler.WingDataOrBuilder> getS2CWingDataFieldBuilder() {
                if (this.s2CWingDataBuilder_ == null) {
                    this.s2CWingDataBuilder_ = new SingleFieldBuilder(getS2CWingData(), getParentForChildren(), isClean());
                    this.s2CWingData_ = null;
                }
                return this.s2CWingDataBuilder_;
            }
        }
    }

    public static final class SaveWingNotify extends GeneratedMessage implements SaveWingNotifyOrBuilder {
        private final UnknownFieldSet unknownFields;

        private SaveWingNotify(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private SaveWingNotify(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static SaveWingNotify getDefaultInstance() {
            return defaultInstance;
        }

        public SaveWingNotify getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SaveWingNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.c2SWingLevel_ = input.readInt32();
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
            return WingHandler.internal_static_pomelo_area_SaveWingNotify_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return WingHandler.internal_static_pomelo_area_SaveWingNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(SaveWingNotify.class, Builder.class);
        }

        public static Parser<SaveWingNotify> PARSER = (Parser<SaveWingNotify>) new AbstractParser<SaveWingNotify>() {
            public WingHandler.SaveWingNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new WingHandler.SaveWingNotify(input, extensionRegistry);
            }
        };

        private int bitField0_;
        public static final int C2S_WINGLEVEL_FIELD_NUMBER = 1;
        private int c2SWingLevel_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final SaveWingNotify defaultInstance = new SaveWingNotify(true);
        private static final long serialVersionUID = 0L;

        public Parser<SaveWingNotify> getParserForType() {
            return PARSER;
        }

        public boolean hasC2SWingLevel() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getC2SWingLevel() {
            return this.c2SWingLevel_;
        }

        private void initFields() {
            this.c2SWingLevel_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasC2SWingLevel()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.c2SWingLevel_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.c2SWingLevel_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static SaveWingNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (SaveWingNotify) PARSER.parseFrom(data);
        }

        public static SaveWingNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SaveWingNotify) PARSER.parseFrom(data, extensionRegistry);
        }

        public static SaveWingNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (SaveWingNotify) PARSER.parseFrom(data);
        }

        public static SaveWingNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SaveWingNotify) PARSER.parseFrom(data, extensionRegistry);
        }

        public static SaveWingNotify parseFrom(InputStream input) throws IOException {
            return (SaveWingNotify) PARSER.parseFrom(input);
        }

        public static SaveWingNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SaveWingNotify) PARSER.parseFrom(input, extensionRegistry);
        }

        static {
            defaultInstance.initFields();
        }

        public static SaveWingNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (SaveWingNotify) PARSER.parseDelimitedFrom(input);
        }

        public static SaveWingNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SaveWingNotify) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static SaveWingNotify parseFrom(CodedInputStream input) throws IOException {
            return (SaveWingNotify) PARSER.parseFrom(input);
        }

        public static SaveWingNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SaveWingNotify) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(SaveWingNotify prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements WingHandler.SaveWingNotifyOrBuilder {
            private int bitField0_;
            private int c2SWingLevel_;

            public static final Descriptors.Descriptor getDescriptor() {
                return WingHandler.internal_static_pomelo_area_SaveWingNotify_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return WingHandler.internal_static_pomelo_area_SaveWingNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(WingHandler.SaveWingNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (WingHandler.SaveWingNotify.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.c2SWingLevel_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return WingHandler.internal_static_pomelo_area_SaveWingNotify_descriptor;
            }

            public WingHandler.SaveWingNotify getDefaultInstanceForType() {
                return WingHandler.SaveWingNotify.getDefaultInstance();
            }

            public WingHandler.SaveWingNotify build() {
                WingHandler.SaveWingNotify result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public WingHandler.SaveWingNotify buildPartial() {
                WingHandler.SaveWingNotify result = new WingHandler.SaveWingNotify(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.c2SWingLevel_ = this.c2SWingLevel_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof WingHandler.SaveWingNotify)
                    return mergeFrom((WingHandler.SaveWingNotify) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(WingHandler.SaveWingNotify other) {
                if (other == WingHandler.SaveWingNotify.getDefaultInstance())
                    return this;
                if (other.hasC2SWingLevel())
                    setC2SWingLevel(other.getC2SWingLevel());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasC2SWingLevel())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                WingHandler.SaveWingNotify parsedMessage = null;
                try {
                    parsedMessage = (WingHandler.SaveWingNotify) WingHandler.SaveWingNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (WingHandler.SaveWingNotify) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null)
                        mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasC2SWingLevel() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getC2SWingLevel() {
                return this.c2SWingLevel_;
            }

            public Builder setC2SWingLevel(int value) {
                this.bitField0_ |= 0x1;
                this.c2SWingLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearC2SWingLevel() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SWingLevel_ = 0;
                onChanged();
                return this;
            }
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }


    static {
        String[] descriptorData = {"\n\021wingHandler.proto\022\013pomelo.area\032\fcommon.proto\"{\n\bWingData\022\021\n\tcurrLevel\030\001 \002(\005\022\020\n\bcurrStar\030\002 \002(\005\022\017\n\007currExp\030\003 \002(\005\022\021\n\tcurrReiki\030\004 \002(\005\022\022\n\nfightPower\030\005 \002(\005\022\022\n\nsavedLevel\030\006 \001(\005\"\024\n\022GetWingInfoRequest\"e\n\023GetWingInfoResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022+\n\fs2c_wingData\030\003 \001(\0132\025.pomelo.area.WingData\"'\n\023TrainingWingRequest\022\020\n\bc2s_type\030\001 \002(\005\"f\n\024TrainingWingResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022+\n\f", "s2c_wingData\030\003 \001(\0132\025.pomelo.area.WingData\"'\n\016SaveWingNotify\022\025\n\rc2s_wingLevel\030\001 \002(\0052ÿ\001\n\013wingHandler\022W\n\022getWingInfoRequest\022\037.pomelo.area.GetWingInfoRequest\032 .pomelo.area.GetWingInfoResponse\022Z\n\023trainingWingRequest\022 .pomelo.area.TrainingWingRequest\032!.pomelo.area.TrainingWingResponse\022;\n\016saveWingNotify\022\033.pomelo.area.SaveWingNotify\032\f.pomelo.Void"};


        Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root) {
                WingHandler.descriptor = root;
                return null;
            }
        };

        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[]{

                Common.getDescriptor()}, assigner);
    }

    private static final Descriptors.Descriptor internal_static_pomelo_area_WingData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_WingData_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_WingData_descriptor, new String[]{"CurrLevel", "CurrStar", "CurrExp", "CurrReiki", "FightPower", "SavedLevel"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetWingInfoRequest_descriptor = getDescriptor().getMessageTypes().get(1);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetWingInfoRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetWingInfoRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetWingInfoResponse_descriptor = getDescriptor().getMessageTypes().get(2);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetWingInfoResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetWingInfoResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CWingData"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_TrainingWingRequest_descriptor = getDescriptor().getMessageTypes().get(3);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_TrainingWingRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_TrainingWingRequest_descriptor, new String[]{"C2SType"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_TrainingWingResponse_descriptor = getDescriptor().getMessageTypes().get(4);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_TrainingWingResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_TrainingWingResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CWingData"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_SaveWingNotify_descriptor = getDescriptor().getMessageTypes().get(5);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_SaveWingNotify_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_SaveWingNotify_descriptor, new String[]{"C2SWingLevel"});
    private static Descriptors.FileDescriptor descriptor;

    static {
        Common.getDescriptor();
    }

    public static interface SaveWingNotifyOrBuilder extends MessageOrBuilder {
        boolean hasC2SWingLevel();

        int getC2SWingLevel();
    }

    public static interface TrainingWingResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasS2CWingData();

        WingHandler.WingData getS2CWingData();

        WingHandler.WingDataOrBuilder getS2CWingDataOrBuilder();
    }

    public static interface TrainingWingRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2SType();

        int getC2SType();
    }

    public static interface GetWingInfoResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasS2CWingData();

        WingHandler.WingData getS2CWingData();

        WingHandler.WingDataOrBuilder getS2CWingDataOrBuilder();
    }

    public static interface GetWingInfoRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface WingDataOrBuilder extends MessageOrBuilder {
        boolean hasCurrLevel();

        int getCurrLevel();

        boolean hasCurrStar();

        int getCurrStar();

        boolean hasCurrExp();

        int getCurrExp();

        boolean hasCurrReiki();

        int getCurrReiki();

        boolean hasFightPower();

        int getFightPower();

        boolean hasSavedLevel();

        int getSavedLevel();
    }
}


