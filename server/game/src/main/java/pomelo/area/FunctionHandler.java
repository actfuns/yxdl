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


public final class FunctionHandler {
    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static final class TipsParam
            extends GeneratedMessage
            implements TipsParamOrBuilder {
        private final UnknownFieldSet unknownFields;

        private TipsParam(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private TipsParam(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static TipsParam getDefaultInstance() {
            return defaultInstance;
        }

        public TipsParam getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private TipsParam(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.diamond_ = input.readInt32();
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
            return FunctionHandler.internal_static_pomelo_area_TipsParam_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return FunctionHandler.internal_static_pomelo_area_TipsParam_fieldAccessorTable.ensureFieldAccessorsInitialized(TipsParam.class, Builder.class);
        }

        public static Parser<TipsParam> PARSER = (Parser<TipsParam>) new AbstractParser<TipsParam>() {
            public FunctionHandler.TipsParam parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FunctionHandler.TipsParam(input, extensionRegistry);
            }
        };

        private int bitField0_;
        public static final int DIAMOND_FIELD_NUMBER = 1;
        private int diamond_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<TipsParam> getParserForType() {
            return PARSER;
        }

        public boolean hasDiamond() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getDiamond() {
            return this.diamond_;
        }

        private void initFields() {
            this.diamond_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1)
                return true;
            if (isInitialized == 0)
                return false;
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1)
                output.writeInt32(1, this.diamond_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1)
                return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1)
                size += CodedOutputStream.computeInt32Size(1, this.diamond_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static TipsParam parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (TipsParam) PARSER.parseFrom(data);
        }

        public static TipsParam parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (TipsParam) PARSER.parseFrom(data, extensionRegistry);
        }

        public static TipsParam parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (TipsParam) PARSER.parseFrom(data);
        }

        public static TipsParam parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (TipsParam) PARSER.parseFrom(data, extensionRegistry);
        }

        public static TipsParam parseFrom(InputStream input) throws IOException {
            return (TipsParam) PARSER.parseFrom(input);
        }

        public static TipsParam parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TipsParam) PARSER.parseFrom(input, extensionRegistry);
        }

        private static final TipsParam defaultInstance = new TipsParam(true);

        public static TipsParam parseDelimitedFrom(InputStream input) throws IOException {
            return (TipsParam) PARSER.parseDelimitedFrom(input);
        }

        public static TipsParam parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TipsParam) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static TipsParam parseFrom(CodedInputStream input) throws IOException {
            return (TipsParam) PARSER.parseFrom(input);
        }

        public static TipsParam parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TipsParam) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(TipsParam prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements FunctionHandler.TipsParamOrBuilder {
            private int bitField0_;
            private int diamond_;

            public static final Descriptors.Descriptor getDescriptor() {
                return FunctionHandler.internal_static_pomelo_area_TipsParam_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return FunctionHandler.internal_static_pomelo_area_TipsParam_fieldAccessorTable.ensureFieldAccessorsInitialized(FunctionHandler.TipsParam.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FunctionHandler.TipsParam.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.diamond_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return FunctionHandler.internal_static_pomelo_area_TipsParam_descriptor;
            }

            public FunctionHandler.TipsParam getDefaultInstanceForType() {
                return FunctionHandler.TipsParam.getDefaultInstance();
            }

            public FunctionHandler.TipsParam build() {
                FunctionHandler.TipsParam result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public FunctionHandler.TipsParam buildPartial() {
                FunctionHandler.TipsParam result = new FunctionHandler.TipsParam(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.diamond_ = this.diamond_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof FunctionHandler.TipsParam) return mergeFrom((FunctionHandler.TipsParam) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FunctionHandler.TipsParam other) {
                if (other == FunctionHandler.TipsParam.getDefaultInstance()) return this;
                if (other.hasDiamond()) setDiamond(other.getDiamond());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                FunctionHandler.TipsParam parsedMessage = null;
                try {
                    parsedMessage = (FunctionHandler.TipsParam) FunctionHandler.TipsParam.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (FunctionHandler.TipsParam) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasDiamond() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getDiamond() {
                return this.diamond_;
            }

            public Builder setDiamond(int value) {
                this.bitField0_ |= 0x1;
                this.diamond_ = value;
                onChanged();
                return this;
            }

            public Builder clearDiamond() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.diamond_ = 0;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class FunctionGoToPush
            extends GeneratedMessage
            implements FunctionGoToPushOrBuilder {
        private static final FunctionGoToPush defaultInstance = new FunctionGoToPush(true);
        private final UnknownFieldSet unknownFields;

        private FunctionGoToPush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private FunctionGoToPush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static FunctionGoToPush getDefaultInstance() {
            return defaultInstance;
        }

        public FunctionGoToPush getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private FunctionGoToPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString bs;
                    FunctionHandler.TipsParam.Builder subBuilder;
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
                            this.s2CFunGoId_ = input.readInt32();
                            break;
                        case 26:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x4;
                            this.s2CItemCode_ = bs;
                            break;
                        case 34:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x8;
                            this.s2CId_ = bs;
                            break;
                        case 42:
                            subBuilder = null;
                            if ((this.bitField0_ & 0x10) == 16) subBuilder = this.s2CParam_.toBuilder();
                            this.s2CParam_ = (FunctionHandler.TipsParam) input.readMessage(FunctionHandler.TipsParam.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.s2CParam_);
                                this.s2CParam_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 0x10;
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
            return FunctionHandler.internal_static_pomelo_area_FunctionGoToPush_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return FunctionHandler.internal_static_pomelo_area_FunctionGoToPush_fieldAccessorTable.ensureFieldAccessorsInitialized(FunctionGoToPush.class, Builder.class);
        }

        public static Parser<FunctionGoToPush> PARSER = (Parser<FunctionGoToPush>) new AbstractParser<FunctionGoToPush>() {
            public FunctionHandler.FunctionGoToPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FunctionHandler.FunctionGoToPush(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_FUNGOID_FIELD_NUMBER = 2;
        private int s2CFunGoId_;
        public static final int S2C_ITEMCODE_FIELD_NUMBER = 3;
        private Object s2CItemCode_;
        public static final int S2C_ID_FIELD_NUMBER = 4;
        private Object s2CId_;
        public static final int S2C_PARAM_FIELD_NUMBER = 5;
        private FunctionHandler.TipsParam s2CParam_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<FunctionGoToPush> getParserForType() {
            return PARSER;
        }

        public boolean hasS2CCode() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getS2CCode() {
            return this.s2CCode_;
        }

        public boolean hasS2CFunGoId() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public int getS2CFunGoId() {
            return this.s2CFunGoId_;
        }

        static {
            defaultInstance.initFields();
        }

        public boolean hasS2CItemCode() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public String getS2CItemCode() {
            Object ref = this.s2CItemCode_;
            if (ref instanceof String)
                return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8())
                this.s2CItemCode_ = s;
            return s;
        }

        public ByteString getS2CItemCodeBytes() {
            Object ref = this.s2CItemCode_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.s2CItemCode_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasS2CId() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public String getS2CId() {
            Object ref = this.s2CId_;
            if (ref instanceof String)
                return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8())
                this.s2CId_ = s;
            return s;
        }

        public ByteString getS2CIdBytes() {
            Object ref = this.s2CId_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.s2CId_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasS2CParam() {
            return ((this.bitField0_ & 0x10) == 16);
        }

        public FunctionHandler.TipsParam getS2CParam() {
            return this.s2CParam_;
        }

        public FunctionHandler.TipsParamOrBuilder getS2CParamOrBuilder() {
            return this.s2CParam_;
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CFunGoId_ = 0;
            this.s2CItemCode_ = "";
            this.s2CId_ = "";
            this.s2CParam_ = FunctionHandler.TipsParam.getDefaultInstance();
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
            if (!hasS2CFunGoId()) {
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
                output.writeInt32(2, this.s2CFunGoId_);
            if ((this.bitField0_ & 0x4) == 4)
                output.writeBytes(3, getS2CItemCodeBytes());
            if ((this.bitField0_ & 0x8) == 8)
                output.writeBytes(4, getS2CIdBytes());
            if ((this.bitField0_ & 0x10) == 16)
                output.writeMessage(5, (MessageLite) this.s2CParam_);
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
                size += CodedOutputStream.computeInt32Size(2, this.s2CFunGoId_);
            if ((this.bitField0_ & 0x4) == 4)
                size += CodedOutputStream.computeBytesSize(3, getS2CItemCodeBytes());
            if ((this.bitField0_ & 0x8) == 8)
                size += CodedOutputStream.computeBytesSize(4, getS2CIdBytes());
            if ((this.bitField0_ & 0x10) == 16)
                size += CodedOutputStream.computeMessageSize(5, (MessageLite) this.s2CParam_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static FunctionGoToPush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (FunctionGoToPush) PARSER.parseFrom(data);
        }

        public static FunctionGoToPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FunctionGoToPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static FunctionGoToPush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (FunctionGoToPush) PARSER.parseFrom(data);
        }

        public static FunctionGoToPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FunctionGoToPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static FunctionGoToPush parseFrom(InputStream input) throws IOException {
            return (FunctionGoToPush) PARSER.parseFrom(input);
        }

        public static FunctionGoToPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FunctionGoToPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static FunctionGoToPush parseDelimitedFrom(InputStream input) throws IOException {
            return (FunctionGoToPush) PARSER.parseDelimitedFrom(input);
        }

        public static FunctionGoToPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FunctionGoToPush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static FunctionGoToPush parseFrom(CodedInputStream input) throws IOException {
            return (FunctionGoToPush) PARSER.parseFrom(input);
        }

        public static FunctionGoToPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FunctionGoToPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(FunctionGoToPush prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements FunctionHandler.FunctionGoToPushOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private int s2CFunGoId_;
            private Object s2CItemCode_;
            private Object s2CId_;
            private FunctionHandler.TipsParam s2CParam_;
            private SingleFieldBuilder<FunctionHandler.TipsParam, FunctionHandler.TipsParam.Builder, FunctionHandler.TipsParamOrBuilder> s2CParamBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return FunctionHandler.internal_static_pomelo_area_FunctionGoToPush_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return FunctionHandler.internal_static_pomelo_area_FunctionGoToPush_fieldAccessorTable.ensureFieldAccessorsInitialized(FunctionHandler.FunctionGoToPush.class, Builder.class);
            }

            private Builder() {
                this.s2CItemCode_ = "";
                this.s2CId_ = "";
                this.s2CParam_ = FunctionHandler.TipsParam.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CItemCode_ = "";
                this.s2CId_ = "";
                this.s2CParam_ = FunctionHandler.TipsParam.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FunctionHandler.FunctionGoToPush.alwaysUseFieldBuilders)
                    getS2CParamFieldBuilder();
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.s2CCode_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.s2CFunGoId_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                this.s2CItemCode_ = "";
                this.bitField0_ &= 0xFFFFFFFB;
                this.s2CId_ = "";
                this.bitField0_ &= 0xFFFFFFF7;
                if (this.s2CParamBuilder_ == null) {
                    this.s2CParam_ = FunctionHandler.TipsParam.getDefaultInstance();
                } else {
                    this.s2CParamBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFEF;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return FunctionHandler.internal_static_pomelo_area_FunctionGoToPush_descriptor;
            }

            public FunctionHandler.FunctionGoToPush getDefaultInstanceForType() {
                return FunctionHandler.FunctionGoToPush.getDefaultInstance();
            }

            public FunctionHandler.FunctionGoToPush build() {
                FunctionHandler.FunctionGoToPush result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public FunctionHandler.FunctionGoToPush buildPartial() {
                FunctionHandler.FunctionGoToPush result = new FunctionHandler.FunctionGoToPush(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.s2CFunGoId_ = this.s2CFunGoId_;
                if ((from_bitField0_ & 0x4) == 4)
                    to_bitField0_ |= 0x4;
                result.s2CItemCode_ = this.s2CItemCode_;
                if ((from_bitField0_ & 0x8) == 8)
                    to_bitField0_ |= 0x8;
                result.s2CId_ = this.s2CId_;
                if ((from_bitField0_ & 0x10) == 16)
                    to_bitField0_ |= 0x10;
                if (this.s2CParamBuilder_ == null) {
                    result.s2CParam_ = this.s2CParam_;
                } else {
                    result.s2CParam_ = (FunctionHandler.TipsParam) this.s2CParamBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof FunctionHandler.FunctionGoToPush)
                    return mergeFrom((FunctionHandler.FunctionGoToPush) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FunctionHandler.FunctionGoToPush other) {
                if (other == FunctionHandler.FunctionGoToPush.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CFunGoId())
                    setS2CFunGoId(other.getS2CFunGoId());
                if (other.hasS2CItemCode()) {
                    this.bitField0_ |= 0x4;
                    this.s2CItemCode_ = other.s2CItemCode_;
                    onChanged();
                }
                if (other.hasS2CId()) {
                    this.bitField0_ |= 0x8;
                    this.s2CId_ = other.s2CId_;
                    onChanged();
                }
                if (other.hasS2CParam())
                    mergeS2CParam(other.getS2CParam());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode())
                    return false;
                if (!hasS2CFunGoId())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                FunctionHandler.FunctionGoToPush parsedMessage = null;
                try {
                    parsedMessage = (FunctionHandler.FunctionGoToPush) FunctionHandler.FunctionGoToPush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (FunctionHandler.FunctionGoToPush) e.getUnfinishedMessage();
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

            public boolean hasS2CFunGoId() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getS2CFunGoId() {
                return this.s2CFunGoId_;
            }

            public Builder setS2CFunGoId(int value) {
                this.bitField0_ |= 0x2;
                this.s2CFunGoId_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CFunGoId() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.s2CFunGoId_ = 0;
                onChanged();
                return this;
            }

            public boolean hasS2CItemCode() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public String getS2CItemCode() {
                Object ref = this.s2CItemCode_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.s2CItemCode_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getS2CItemCodeBytes() {
                Object ref = this.s2CItemCode_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.s2CItemCode_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setS2CItemCode(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x4;
                this.s2CItemCode_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CItemCode() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.s2CItemCode_ = FunctionHandler.FunctionGoToPush.getDefaultInstance().getS2CItemCode();
                onChanged();
                return this;
            }

            public Builder setS2CItemCodeBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x4;
                this.s2CItemCode_ = value;
                onChanged();
                return this;
            }

            public boolean hasS2CId() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public String getS2CId() {
                Object ref = this.s2CId_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.s2CId_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getS2CIdBytes() {
                Object ref = this.s2CId_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.s2CId_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setS2CId(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x8;
                this.s2CId_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CId() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.s2CId_ = FunctionHandler.FunctionGoToPush.getDefaultInstance().getS2CId();
                onChanged();
                return this;
            }

            public Builder setS2CIdBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x8;
                this.s2CId_ = value;
                onChanged();
                return this;
            }

            public boolean hasS2CParam() {
                return ((this.bitField0_ & 0x10) == 16);
            }

            public FunctionHandler.TipsParam getS2CParam() {
                if (this.s2CParamBuilder_ == null)
                    return this.s2CParam_;
                return (FunctionHandler.TipsParam) this.s2CParamBuilder_.getMessage();
            }

            public Builder setS2CParam(FunctionHandler.TipsParam value) {
                if (this.s2CParamBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    this.s2CParam_ = value;
                    onChanged();
                } else {
                    this.s2CParamBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x10;
                return this;
            }

            public Builder setS2CParam(FunctionHandler.TipsParam.Builder builderForValue) {
                if (this.s2CParamBuilder_ == null) {
                    this.s2CParam_ = builderForValue.build();
                    onChanged();
                } else {
                    this.s2CParamBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x10;
                return this;
            }

            public Builder mergeS2CParam(FunctionHandler.TipsParam value) {
                if (this.s2CParamBuilder_ == null) {
                    if ((this.bitField0_ & 0x10) == 16 && this.s2CParam_ != FunctionHandler.TipsParam.getDefaultInstance()) {
                        this.s2CParam_ = FunctionHandler.TipsParam.newBuilder(this.s2CParam_).mergeFrom(value).buildPartial();
                    } else {
                        this.s2CParam_ = value;
                    }
                    onChanged();
                } else {
                    this.s2CParamBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x10;
                return this;
            }

            public Builder clearS2CParam() {
                if (this.s2CParamBuilder_ == null) {
                    this.s2CParam_ = FunctionHandler.TipsParam.getDefaultInstance();
                    onChanged();
                } else {
                    this.s2CParamBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFEF;
                return this;
            }

            public FunctionHandler.TipsParam.Builder getS2CParamBuilder() {
                this.bitField0_ |= 0x10;
                onChanged();
                return (FunctionHandler.TipsParam.Builder) getS2CParamFieldBuilder().getBuilder();
            }

            public FunctionHandler.TipsParamOrBuilder getS2CParamOrBuilder() {
                if (this.s2CParamBuilder_ != null)
                    return (FunctionHandler.TipsParamOrBuilder) this.s2CParamBuilder_.getMessageOrBuilder();
                return this.s2CParam_;
            }

            private SingleFieldBuilder<FunctionHandler.TipsParam, FunctionHandler.TipsParam.Builder, FunctionHandler.TipsParamOrBuilder> getS2CParamFieldBuilder() {
                if (this.s2CParamBuilder_ == null) {
                    this.s2CParamBuilder_ = new SingleFieldBuilder(getS2CParam(), getParentForChildren(), isClean());
                    this.s2CParam_ = null;
                }
                return this.s2CParamBuilder_;
            }
        }
    }

    public static final class TaskGuideFuncPush extends GeneratedMessage implements TaskGuideFuncPushOrBuilder {
        private final UnknownFieldSet unknownFields;

        private TaskGuideFuncPush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private TaskGuideFuncPush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static TaskGuideFuncPush getDefaultInstance() {
            return defaultInstance;
        }

        public TaskGuideFuncPush getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private TaskGuideFuncPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.s2CTaskFuncId_ = input.readInt32();
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
            return FunctionHandler.internal_static_pomelo_area_TaskGuideFuncPush_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return FunctionHandler.internal_static_pomelo_area_TaskGuideFuncPush_fieldAccessorTable.ensureFieldAccessorsInitialized(TaskGuideFuncPush.class, Builder.class);
        }

        public static Parser<TaskGuideFuncPush> PARSER = (Parser<TaskGuideFuncPush>) new AbstractParser<TaskGuideFuncPush>() {
            public FunctionHandler.TaskGuideFuncPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FunctionHandler.TaskGuideFuncPush(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_TASKFUNCID_FIELD_NUMBER = 2;
        private int s2CTaskFuncId_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<TaskGuideFuncPush> getParserForType() {
            return PARSER;
        }

        public boolean hasS2CCode() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        private static final TaskGuideFuncPush defaultInstance = new TaskGuideFuncPush(true);

        public int getS2CCode() {
            return this.s2CCode_;
        }

        public boolean hasS2CTaskFuncId() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public int getS2CTaskFuncId() {
            return this.s2CTaskFuncId_;
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CTaskFuncId_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasS2CCode()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasS2CTaskFuncId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.s2CTaskFuncId_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(2, this.s2CTaskFuncId_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static TaskGuideFuncPush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (TaskGuideFuncPush) PARSER.parseFrom(data);
        }

        public static TaskGuideFuncPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (TaskGuideFuncPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static TaskGuideFuncPush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (TaskGuideFuncPush) PARSER.parseFrom(data);
        }

        public static TaskGuideFuncPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (TaskGuideFuncPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static TaskGuideFuncPush parseFrom(InputStream input) throws IOException {
            return (TaskGuideFuncPush) PARSER.parseFrom(input);
        }

        public static TaskGuideFuncPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TaskGuideFuncPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static TaskGuideFuncPush parseDelimitedFrom(InputStream input) throws IOException {
            return (TaskGuideFuncPush) PARSER.parseDelimitedFrom(input);
        }

        public static TaskGuideFuncPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TaskGuideFuncPush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static TaskGuideFuncPush parseFrom(CodedInputStream input) throws IOException {
            return (TaskGuideFuncPush) PARSER.parseFrom(input);
        }

        public static TaskGuideFuncPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TaskGuideFuncPush) PARSER.parseFrom(input, extensionRegistry);
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

        public static Builder newBuilder(TaskGuideFuncPush prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements FunctionHandler.TaskGuideFuncPushOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private int s2CTaskFuncId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return FunctionHandler.internal_static_pomelo_area_TaskGuideFuncPush_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return FunctionHandler.internal_static_pomelo_area_TaskGuideFuncPush_fieldAccessorTable.ensureFieldAccessorsInitialized(FunctionHandler.TaskGuideFuncPush.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FunctionHandler.TaskGuideFuncPush.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.s2CCode_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.s2CTaskFuncId_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return FunctionHandler.internal_static_pomelo_area_TaskGuideFuncPush_descriptor;
            }

            public FunctionHandler.TaskGuideFuncPush getDefaultInstanceForType() {
                return FunctionHandler.TaskGuideFuncPush.getDefaultInstance();
            }

            public FunctionHandler.TaskGuideFuncPush build() {
                FunctionHandler.TaskGuideFuncPush result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public FunctionHandler.TaskGuideFuncPush buildPartial() {
                FunctionHandler.TaskGuideFuncPush result = new FunctionHandler.TaskGuideFuncPush(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.s2CTaskFuncId_ = this.s2CTaskFuncId_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof FunctionHandler.TaskGuideFuncPush)
                    return mergeFrom((FunctionHandler.TaskGuideFuncPush) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FunctionHandler.TaskGuideFuncPush other) {
                if (other == FunctionHandler.TaskGuideFuncPush.getDefaultInstance()) return this;
                if (other.hasS2CCode()) setS2CCode(other.getS2CCode());
                if (other.hasS2CTaskFuncId()) setS2CTaskFuncId(other.getS2CTaskFuncId());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode()) return false;
                if (!hasS2CTaskFuncId()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                FunctionHandler.TaskGuideFuncPush parsedMessage = null;
                try {
                    parsedMessage = (FunctionHandler.TaskGuideFuncPush) FunctionHandler.TaskGuideFuncPush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (FunctionHandler.TaskGuideFuncPush) e.getUnfinishedMessage();
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

            public boolean hasS2CTaskFuncId() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getS2CTaskFuncId() {
                return this.s2CTaskFuncId_;
            }

            public Builder setS2CTaskFuncId(int value) {
                this.bitField0_ |= 0x2;
                this.s2CTaskFuncId_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CTaskFuncId() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.s2CTaskFuncId_ = 0;
                onChanged();
                return this;
            }
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }


    static {
        String[] descriptorData = {"\n\025functionHandler.proto\022\013pomelo.area\032\fcommon.proto\"\034\n\tTipsParam\022\017\n\007diamond\030\001 \001(\005\"\001\n\020FunctionGoToPush\022\020\n\bs2c_code\030\001 \002(\005\022\023\n\013s2c_funGoId\030\002 \002(\005\022\024\n\fs2c_itemCode\030\003 \001(\t\022\016\n\006s2c_id\030\004 \001(\t\022)\n\ts2c_param\030\005 \001(\0132\026.pomelo.area.TipsParam\"=\n\021TaskGuideFuncPush\022\020\n\bs2c_code\030\001 \002(\005\022\026\n\016s2c_taskFuncId\030\002 \002(\0052\021\n\017functionHandler2\001\n\ffunctionPush\022?\n\020functionGoToPush\022\035.pomelo.area.FunctionGoToPush\032\f.pomelo.Void\022A\n\021taskGuideFu", "ncPush\022\036.pomelo.area.TaskGuideFuncPush\032\f.pomelo.Void"};


        Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root) {
                FunctionHandler.descriptor = root;
                return null;
            }
        };

        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[]{

                Common.getDescriptor()}, assigner);
    }

    private static final Descriptors.Descriptor internal_static_pomelo_area_TipsParam_descriptor = getDescriptor().getMessageTypes().get(0);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_TipsParam_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_TipsParam_descriptor, new String[]{"Diamond"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_FunctionGoToPush_descriptor = getDescriptor().getMessageTypes().get(1);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_FunctionGoToPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_FunctionGoToPush_descriptor, new String[]{"S2CCode", "S2CFunGoId", "S2CItemCode", "S2CId", "S2CParam"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_TaskGuideFuncPush_descriptor = getDescriptor().getMessageTypes().get(2);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_TaskGuideFuncPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_TaskGuideFuncPush_descriptor, new String[]{"S2CCode", "S2CTaskFuncId"});
    private static Descriptors.FileDescriptor descriptor;

    static {
        Common.getDescriptor();
    }

    public static interface TaskGuideFuncPushOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CTaskFuncId();

        int getS2CTaskFuncId();
    }

    public static interface FunctionGoToPushOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CFunGoId();

        int getS2CFunGoId();

        boolean hasS2CItemCode();

        String getS2CItemCode();

        ByteString getS2CItemCodeBytes();

        boolean hasS2CId();

        String getS2CId();

        ByteString getS2CIdBytes();

        boolean hasS2CParam();

        FunctionHandler.TipsParam getS2CParam();

        FunctionHandler.TipsParamOrBuilder getS2CParamOrBuilder();
    }

    public static interface TipsParamOrBuilder extends MessageOrBuilder {
        boolean hasDiamond();

        int getDiamond();
    }
}


