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


public final class PayGiftHandler {
    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static final class FirstPayGiftInfoRequest
            extends GeneratedMessage
            implements FirstPayGiftInfoRequestOrBuilder {
        private static final FirstPayGiftInfoRequest defaultInstance = new FirstPayGiftInfoRequest(true);
        private final UnknownFieldSet unknownFields;

        private FirstPayGiftInfoRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private FirstPayGiftInfoRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static FirstPayGiftInfoRequest getDefaultInstance() {
            return defaultInstance;
        }

        public FirstPayGiftInfoRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private FirstPayGiftInfoRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return PayGiftHandler.internal_static_pomelo_area_FirstPayGiftInfoRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return PayGiftHandler.internal_static_pomelo_area_FirstPayGiftInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(FirstPayGiftInfoRequest.class, Builder.class);
        }

        public static Parser<FirstPayGiftInfoRequest> PARSER = (Parser<FirstPayGiftInfoRequest>) new AbstractParser<FirstPayGiftInfoRequest>() {
            public PayGiftHandler.FirstPayGiftInfoRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PayGiftHandler.FirstPayGiftInfoRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<FirstPayGiftInfoRequest> getParserForType() {
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


        public static FirstPayGiftInfoRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (FirstPayGiftInfoRequest) PARSER.parseFrom(data);
        }


        public static FirstPayGiftInfoRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FirstPayGiftInfoRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static FirstPayGiftInfoRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (FirstPayGiftInfoRequest) PARSER.parseFrom(data);
        }


        public static FirstPayGiftInfoRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FirstPayGiftInfoRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static FirstPayGiftInfoRequest parseFrom(InputStream input) throws IOException {
            return (FirstPayGiftInfoRequest) PARSER.parseFrom(input);
        }


        public static FirstPayGiftInfoRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FirstPayGiftInfoRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static FirstPayGiftInfoRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (FirstPayGiftInfoRequest) PARSER.parseDelimitedFrom(input);
        }


        public static FirstPayGiftInfoRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FirstPayGiftInfoRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static FirstPayGiftInfoRequest parseFrom(CodedInputStream input) throws IOException {
            return (FirstPayGiftInfoRequest) PARSER.parseFrom(input);
        }


        public static FirstPayGiftInfoRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FirstPayGiftInfoRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(FirstPayGiftInfoRequest prototype) {
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
                implements PayGiftHandler.FirstPayGiftInfoRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return PayGiftHandler.internal_static_pomelo_area_FirstPayGiftInfoRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PayGiftHandler.internal_static_pomelo_area_FirstPayGiftInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(PayGiftHandler.FirstPayGiftInfoRequest.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (PayGiftHandler.FirstPayGiftInfoRequest.alwaysUseFieldBuilders) ;
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
                return PayGiftHandler.internal_static_pomelo_area_FirstPayGiftInfoRequest_descriptor;
            }


            public PayGiftHandler.FirstPayGiftInfoRequest getDefaultInstanceForType() {
                return PayGiftHandler.FirstPayGiftInfoRequest.getDefaultInstance();
            }


            public PayGiftHandler.FirstPayGiftInfoRequest build() {
                PayGiftHandler.FirstPayGiftInfoRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public PayGiftHandler.FirstPayGiftInfoRequest buildPartial() {
                PayGiftHandler.FirstPayGiftInfoRequest result = new PayGiftHandler.FirstPayGiftInfoRequest(this);
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof PayGiftHandler.FirstPayGiftInfoRequest) {
                    return mergeFrom((PayGiftHandler.FirstPayGiftInfoRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(PayGiftHandler.FirstPayGiftInfoRequest other) {
                if (other == PayGiftHandler.FirstPayGiftInfoRequest.getDefaultInstance()) {
                    return this;
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                PayGiftHandler.FirstPayGiftInfoRequest parsedMessage = null;
                try {
                    parsedMessage = (PayGiftHandler.FirstPayGiftInfoRequest) PayGiftHandler.FirstPayGiftInfoRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (PayGiftHandler.FirstPayGiftInfoRequest) e.getUnfinishedMessage();
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


    public static final class FirstPayGiftData
            extends GeneratedMessage
            implements FirstPayGiftDataOrBuilder {
        private final UnknownFieldSet unknownFields;


        private FirstPayGiftData(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }


        private FirstPayGiftData(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }


        public static FirstPayGiftData getDefaultInstance() {
            return defaultInstance;
        }


        public FirstPayGiftData getDefaultInstanceForType() {
            return defaultInstance;
        }


        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }


        private FirstPayGiftData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.isGet_ = input.readInt32();
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
            return PayGiftHandler.internal_static_pomelo_area_FirstPayGiftData_descriptor;
        }


        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return PayGiftHandler.internal_static_pomelo_area_FirstPayGiftData_fieldAccessorTable.ensureFieldAccessorsInitialized(FirstPayGiftData.class, Builder.class);
        }


        public static Parser<FirstPayGiftData> PARSER = (Parser<FirstPayGiftData>) new AbstractParser<FirstPayGiftData>() {
            public PayGiftHandler.FirstPayGiftData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PayGiftHandler.FirstPayGiftData(input, extensionRegistry);
            }
        };


        private int bitField0_;

        public static final int ISGET_FIELD_NUMBER = 1;

        private int isGet_;

        private byte memoizedIsInitialized;

        private int memoizedSerializedSize;

        private static final long serialVersionUID = 0L;


        public Parser<FirstPayGiftData> getParserForType() {
            return PARSER;
        }


        public boolean hasIsGet() {
            return ((this.bitField0_ & 0x1) == 1);
        }


        public int getIsGet() {
            return this.isGet_;
        }


        private void initFields() {
            this.isGet_ = 0;
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasIsGet()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeInt32(1, this.isGet_);
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
                size += CodedOutputStream.computeInt32Size(1, this.isGet_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static FirstPayGiftData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (FirstPayGiftData) PARSER.parseFrom(data);
        }


        public static FirstPayGiftData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FirstPayGiftData) PARSER.parseFrom(data, extensionRegistry);
        }


        public static FirstPayGiftData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (FirstPayGiftData) PARSER.parseFrom(data);
        }


        public static FirstPayGiftData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FirstPayGiftData) PARSER.parseFrom(data, extensionRegistry);
        }


        public static FirstPayGiftData parseFrom(InputStream input) throws IOException {
            return (FirstPayGiftData) PARSER.parseFrom(input);
        }


        public static FirstPayGiftData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FirstPayGiftData) PARSER.parseFrom(input, extensionRegistry);
        }


        public static FirstPayGiftData parseDelimitedFrom(InputStream input) throws IOException {
            return (FirstPayGiftData) PARSER.parseDelimitedFrom(input);
        }


        public static FirstPayGiftData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FirstPayGiftData) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static FirstPayGiftData parseFrom(CodedInputStream input) throws IOException {
            return (FirstPayGiftData) PARSER.parseFrom(input);
        }


        public static FirstPayGiftData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FirstPayGiftData) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        private static final FirstPayGiftData defaultInstance = new FirstPayGiftData(true);

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(FirstPayGiftData prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements PayGiftHandler.FirstPayGiftDataOrBuilder {
            private int bitField0_;
            private int isGet_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PayGiftHandler.internal_static_pomelo_area_FirstPayGiftData_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PayGiftHandler.internal_static_pomelo_area_FirstPayGiftData_fieldAccessorTable.ensureFieldAccessorsInitialized(PayGiftHandler.FirstPayGiftData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PayGiftHandler.FirstPayGiftData.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.isGet_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return PayGiftHandler.internal_static_pomelo_area_FirstPayGiftData_descriptor;
            }

            public PayGiftHandler.FirstPayGiftData getDefaultInstanceForType() {
                return PayGiftHandler.FirstPayGiftData.getDefaultInstance();
            }

            public PayGiftHandler.FirstPayGiftData build() {
                PayGiftHandler.FirstPayGiftData result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public PayGiftHandler.FirstPayGiftData buildPartial() {
                PayGiftHandler.FirstPayGiftData result = new PayGiftHandler.FirstPayGiftData(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.isGet_ = this.isGet_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof PayGiftHandler.FirstPayGiftData)
                    return mergeFrom((PayGiftHandler.FirstPayGiftData) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PayGiftHandler.FirstPayGiftData other) {
                if (other == PayGiftHandler.FirstPayGiftData.getDefaultInstance()) return this;
                if (other.hasIsGet()) setIsGet(other.getIsGet());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasIsGet()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                PayGiftHandler.FirstPayGiftData parsedMessage = null;
                try {
                    parsedMessage = (PayGiftHandler.FirstPayGiftData) PayGiftHandler.FirstPayGiftData.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (PayGiftHandler.FirstPayGiftData) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null)
                        mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasIsGet() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getIsGet() {
                return this.isGet_;
            }

            public Builder setIsGet(int value) {
                this.bitField0_ |= 0x1;
                this.isGet_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsGet() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.isGet_ = 0;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class FirstPayGiftInfoResponse
            extends GeneratedMessage
            implements FirstPayGiftInfoResponseOrBuilder {
        private static final FirstPayGiftInfoResponse defaultInstance = new FirstPayGiftInfoResponse(true);
        private final UnknownFieldSet unknownFields;

        private FirstPayGiftInfoResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private FirstPayGiftInfoResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static FirstPayGiftInfoResponse getDefaultInstance() {
            return defaultInstance;
        }

        public FirstPayGiftInfoResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private FirstPayGiftInfoResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString bs;
                    PayGiftHandler.FirstPayGiftData.Builder subBuilder;
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
                            this.s2CData_ = (PayGiftHandler.FirstPayGiftData) input.readMessage(PayGiftHandler.FirstPayGiftData.PARSER, extensionRegistry);
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
            return PayGiftHandler.internal_static_pomelo_area_FirstPayGiftInfoResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return PayGiftHandler.internal_static_pomelo_area_FirstPayGiftInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(FirstPayGiftInfoResponse.class, Builder.class);
        }

        public static Parser<FirstPayGiftInfoResponse> PARSER = (Parser<FirstPayGiftInfoResponse>) new AbstractParser<FirstPayGiftInfoResponse>() {
            public PayGiftHandler.FirstPayGiftInfoResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PayGiftHandler.FirstPayGiftInfoResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_DATA_FIELD_NUMBER = 3;
        private PayGiftHandler.FirstPayGiftData s2CData_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<FirstPayGiftInfoResponse> getParserForType() {
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

        public PayGiftHandler.FirstPayGiftData getS2CData() {
            return this.s2CData_;
        }

        public PayGiftHandler.FirstPayGiftDataOrBuilder getS2CDataOrBuilder() {
            return this.s2CData_;
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CData_ = PayGiftHandler.FirstPayGiftData.getDefaultInstance();
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
            if (hasS2CData() && !getS2CData().isInitialized()) {
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
                output.writeMessage(3, (MessageLite) this.s2CData_);
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
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.s2CData_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static FirstPayGiftInfoResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (FirstPayGiftInfoResponse) PARSER.parseFrom(data);
        }

        public static FirstPayGiftInfoResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FirstPayGiftInfoResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static FirstPayGiftInfoResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (FirstPayGiftInfoResponse) PARSER.parseFrom(data);
        }

        public static FirstPayGiftInfoResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FirstPayGiftInfoResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static FirstPayGiftInfoResponse parseFrom(InputStream input) throws IOException {
            return (FirstPayGiftInfoResponse) PARSER.parseFrom(input);
        }

        public static FirstPayGiftInfoResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FirstPayGiftInfoResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static FirstPayGiftInfoResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (FirstPayGiftInfoResponse) PARSER.parseDelimitedFrom(input);
        }

        public static FirstPayGiftInfoResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FirstPayGiftInfoResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static FirstPayGiftInfoResponse parseFrom(CodedInputStream input) throws IOException {
            return (FirstPayGiftInfoResponse) PARSER.parseFrom(input);
        }

        public static FirstPayGiftInfoResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FirstPayGiftInfoResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(FirstPayGiftInfoResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements PayGiftHandler.FirstPayGiftInfoResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private PayGiftHandler.FirstPayGiftData s2CData_;
            private SingleFieldBuilder<PayGiftHandler.FirstPayGiftData, PayGiftHandler.FirstPayGiftData.Builder, PayGiftHandler.FirstPayGiftDataOrBuilder> s2CDataBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PayGiftHandler.internal_static_pomelo_area_FirstPayGiftInfoResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PayGiftHandler.internal_static_pomelo_area_FirstPayGiftInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(PayGiftHandler.FirstPayGiftInfoResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.s2CData_ = PayGiftHandler.FirstPayGiftData.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CData_ = PayGiftHandler.FirstPayGiftData.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PayGiftHandler.FirstPayGiftInfoResponse.alwaysUseFieldBuilders)
                    getS2CDataFieldBuilder();
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
                    this.s2CData_ = PayGiftHandler.FirstPayGiftData.getDefaultInstance();
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
                return PayGiftHandler.internal_static_pomelo_area_FirstPayGiftInfoResponse_descriptor;
            }

            public PayGiftHandler.FirstPayGiftInfoResponse getDefaultInstanceForType() {
                return PayGiftHandler.FirstPayGiftInfoResponse.getDefaultInstance();
            }

            public PayGiftHandler.FirstPayGiftInfoResponse build() {
                PayGiftHandler.FirstPayGiftInfoResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public PayGiftHandler.FirstPayGiftInfoResponse buildPartial() {
                PayGiftHandler.FirstPayGiftInfoResponse result = new PayGiftHandler.FirstPayGiftInfoResponse(this);
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
                if (this.s2CDataBuilder_ == null) {
                    result.s2CData_ = this.s2CData_;
                } else {
                    result.s2CData_ = (PayGiftHandler.FirstPayGiftData) this.s2CDataBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof PayGiftHandler.FirstPayGiftInfoResponse)
                    return mergeFrom((PayGiftHandler.FirstPayGiftInfoResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PayGiftHandler.FirstPayGiftInfoResponse other) {
                if (other == PayGiftHandler.FirstPayGiftInfoResponse.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (other.hasS2CData())
                    mergeS2CData(other.getS2CData());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode())
                    return false;
                if (hasS2CData() && !getS2CData().isInitialized())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                PayGiftHandler.FirstPayGiftInfoResponse parsedMessage = null;
                try {
                    parsedMessage = (PayGiftHandler.FirstPayGiftInfoResponse) PayGiftHandler.FirstPayGiftInfoResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (PayGiftHandler.FirstPayGiftInfoResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = PayGiftHandler.FirstPayGiftInfoResponse.getDefaultInstance().getS2CMsg();
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

            public boolean hasS2CData() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public PayGiftHandler.FirstPayGiftData getS2CData() {
                if (this.s2CDataBuilder_ == null)
                    return this.s2CData_;
                return (PayGiftHandler.FirstPayGiftData) this.s2CDataBuilder_.getMessage();
            }

            public Builder setS2CData(PayGiftHandler.FirstPayGiftData value) {
                if (this.s2CDataBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    this.s2CData_ = value;
                    onChanged();
                } else {
                    this.s2CDataBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder setS2CData(PayGiftHandler.FirstPayGiftData.Builder builderForValue) {
                if (this.s2CDataBuilder_ == null) {
                    this.s2CData_ = builderForValue.build();
                    onChanged();
                } else {
                    this.s2CDataBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder mergeS2CData(PayGiftHandler.FirstPayGiftData value) {
                if (this.s2CDataBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4 && this.s2CData_ != PayGiftHandler.FirstPayGiftData.getDefaultInstance()) {
                        this.s2CData_ = PayGiftHandler.FirstPayGiftData.newBuilder(this.s2CData_).mergeFrom(value).buildPartial();
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
                    this.s2CData_ = PayGiftHandler.FirstPayGiftData.getDefaultInstance();
                    onChanged();
                } else {
                    this.s2CDataBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public PayGiftHandler.FirstPayGiftData.Builder getS2CDataBuilder() {
                this.bitField0_ |= 0x4;
                onChanged();
                return (PayGiftHandler.FirstPayGiftData.Builder) getS2CDataFieldBuilder().getBuilder();
            }

            public PayGiftHandler.FirstPayGiftDataOrBuilder getS2CDataOrBuilder() {
                if (this.s2CDataBuilder_ != null)
                    return (PayGiftHandler.FirstPayGiftDataOrBuilder) this.s2CDataBuilder_.getMessageOrBuilder();
                return this.s2CData_;
            }

            private SingleFieldBuilder<PayGiftHandler.FirstPayGiftData, PayGiftHandler.FirstPayGiftData.Builder, PayGiftHandler.FirstPayGiftDataOrBuilder> getS2CDataFieldBuilder() {
                if (this.s2CDataBuilder_ == null) {
                    this.s2CDataBuilder_ = new SingleFieldBuilder(getS2CData(), getParentForChildren(), isClean());
                    this.s2CData_ = null;
                }
                return this.s2CDataBuilder_;
            }
        }
    }

    public static final class GetFirstPayGiftRequest extends GeneratedMessage implements GetFirstPayGiftRequestOrBuilder {
        private static final GetFirstPayGiftRequest defaultInstance = new GetFirstPayGiftRequest(true);
        private final UnknownFieldSet unknownFields;

        private GetFirstPayGiftRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetFirstPayGiftRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetFirstPayGiftRequest getDefaultInstance() {
            return defaultInstance;
        }

        public GetFirstPayGiftRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetFirstPayGiftRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return PayGiftHandler.internal_static_pomelo_area_GetFirstPayGiftRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return PayGiftHandler.internal_static_pomelo_area_GetFirstPayGiftRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetFirstPayGiftRequest.class, Builder.class);
        }

        public static Parser<GetFirstPayGiftRequest> PARSER = (Parser<GetFirstPayGiftRequest>) new AbstractParser<GetFirstPayGiftRequest>() {
            public PayGiftHandler.GetFirstPayGiftRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PayGiftHandler.GetFirstPayGiftRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetFirstPayGiftRequest> getParserForType() {
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


        public static GetFirstPayGiftRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetFirstPayGiftRequest) PARSER.parseFrom(data);
        }


        public static GetFirstPayGiftRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetFirstPayGiftRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetFirstPayGiftRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetFirstPayGiftRequest) PARSER.parseFrom(data);
        }


        public static GetFirstPayGiftRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetFirstPayGiftRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetFirstPayGiftRequest parseFrom(InputStream input) throws IOException {
            return (GetFirstPayGiftRequest) PARSER.parseFrom(input);
        }


        public static GetFirstPayGiftRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetFirstPayGiftRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static GetFirstPayGiftRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (GetFirstPayGiftRequest) PARSER.parseDelimitedFrom(input);
        }


        public static GetFirstPayGiftRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetFirstPayGiftRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static GetFirstPayGiftRequest parseFrom(CodedInputStream input) throws IOException {
            return (GetFirstPayGiftRequest) PARSER.parseFrom(input);
        }


        public static GetFirstPayGiftRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetFirstPayGiftRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(GetFirstPayGiftRequest prototype) {
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
                implements PayGiftHandler.GetFirstPayGiftRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return PayGiftHandler.internal_static_pomelo_area_GetFirstPayGiftRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PayGiftHandler.internal_static_pomelo_area_GetFirstPayGiftRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(PayGiftHandler.GetFirstPayGiftRequest.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (PayGiftHandler.GetFirstPayGiftRequest.alwaysUseFieldBuilders) ;
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
                return PayGiftHandler.internal_static_pomelo_area_GetFirstPayGiftRequest_descriptor;
            }


            public PayGiftHandler.GetFirstPayGiftRequest getDefaultInstanceForType() {
                return PayGiftHandler.GetFirstPayGiftRequest.getDefaultInstance();
            }


            public PayGiftHandler.GetFirstPayGiftRequest build() {
                PayGiftHandler.GetFirstPayGiftRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public PayGiftHandler.GetFirstPayGiftRequest buildPartial() {
                PayGiftHandler.GetFirstPayGiftRequest result = new PayGiftHandler.GetFirstPayGiftRequest(this);
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof PayGiftHandler.GetFirstPayGiftRequest) {
                    return mergeFrom((PayGiftHandler.GetFirstPayGiftRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(PayGiftHandler.GetFirstPayGiftRequest other) {
                if (other == PayGiftHandler.GetFirstPayGiftRequest.getDefaultInstance()) {
                    return this;
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                PayGiftHandler.GetFirstPayGiftRequest parsedMessage = null;
                try {
                    parsedMessage = (PayGiftHandler.GetFirstPayGiftRequest) PayGiftHandler.GetFirstPayGiftRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (PayGiftHandler.GetFirstPayGiftRequest) e.getUnfinishedMessage();
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


    public static final class GetFirstPayGiftResponse
            extends GeneratedMessage
            implements GetFirstPayGiftResponseOrBuilder {
        private static final GetFirstPayGiftResponse defaultInstance = new GetFirstPayGiftResponse(true);
        private final UnknownFieldSet unknownFields;

        private GetFirstPayGiftResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetFirstPayGiftResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetFirstPayGiftResponse getDefaultInstance() {
            return defaultInstance;
        }

        public GetFirstPayGiftResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetFirstPayGiftResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return PayGiftHandler.internal_static_pomelo_area_GetFirstPayGiftResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return PayGiftHandler.internal_static_pomelo_area_GetFirstPayGiftResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetFirstPayGiftResponse.class, Builder.class);
        }

        public static Parser<GetFirstPayGiftResponse> PARSER = (Parser<GetFirstPayGiftResponse>) new AbstractParser<GetFirstPayGiftResponse>() {
            public PayGiftHandler.GetFirstPayGiftResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PayGiftHandler.GetFirstPayGiftResponse(input, extensionRegistry);
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

        public Parser<GetFirstPayGiftResponse> getParserForType() {
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

        public static GetFirstPayGiftResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetFirstPayGiftResponse) PARSER.parseFrom(data);
        }

        public static GetFirstPayGiftResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetFirstPayGiftResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetFirstPayGiftResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetFirstPayGiftResponse) PARSER.parseFrom(data);
        }

        public static GetFirstPayGiftResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetFirstPayGiftResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetFirstPayGiftResponse parseFrom(InputStream input) throws IOException {
            return (GetFirstPayGiftResponse) PARSER.parseFrom(input);
        }

        public static GetFirstPayGiftResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetFirstPayGiftResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static GetFirstPayGiftResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (GetFirstPayGiftResponse) PARSER.parseDelimitedFrom(input);
        }

        public static GetFirstPayGiftResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetFirstPayGiftResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static GetFirstPayGiftResponse parseFrom(CodedInputStream input) throws IOException {
            return (GetFirstPayGiftResponse) PARSER.parseFrom(input);
        }

        public static GetFirstPayGiftResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetFirstPayGiftResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(GetFirstPayGiftResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements PayGiftHandler.GetFirstPayGiftResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PayGiftHandler.internal_static_pomelo_area_GetFirstPayGiftResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PayGiftHandler.internal_static_pomelo_area_GetFirstPayGiftResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(PayGiftHandler.GetFirstPayGiftResponse.class, Builder.class);
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
                if (PayGiftHandler.GetFirstPayGiftResponse.alwaysUseFieldBuilders) ;
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
                return PayGiftHandler.internal_static_pomelo_area_GetFirstPayGiftResponse_descriptor;
            }

            public PayGiftHandler.GetFirstPayGiftResponse getDefaultInstanceForType() {
                return PayGiftHandler.GetFirstPayGiftResponse.getDefaultInstance();
            }

            public PayGiftHandler.GetFirstPayGiftResponse build() {
                PayGiftHandler.GetFirstPayGiftResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public PayGiftHandler.GetFirstPayGiftResponse buildPartial() {
                PayGiftHandler.GetFirstPayGiftResponse result = new PayGiftHandler.GetFirstPayGiftResponse(this);
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
                if (other instanceof PayGiftHandler.GetFirstPayGiftResponse)
                    return mergeFrom((PayGiftHandler.GetFirstPayGiftResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PayGiftHandler.GetFirstPayGiftResponse other) {
                if (other == PayGiftHandler.GetFirstPayGiftResponse.getDefaultInstance())
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
                PayGiftHandler.GetFirstPayGiftResponse parsedMessage = null;
                try {
                    parsedMessage = (PayGiftHandler.GetFirstPayGiftResponse) PayGiftHandler.GetFirstPayGiftResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (PayGiftHandler.GetFirstPayGiftResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = PayGiftHandler.GetFirstPayGiftResponse.getDefaultInstance().getS2CMsg();
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

    public static final class DailyPayGiftInfoRequest extends GeneratedMessage implements DailyPayGiftInfoRequestOrBuilder {
        private static final DailyPayGiftInfoRequest defaultInstance = new DailyPayGiftInfoRequest(true);
        private final UnknownFieldSet unknownFields;

        private DailyPayGiftInfoRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private DailyPayGiftInfoRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static DailyPayGiftInfoRequest getDefaultInstance() {
            return defaultInstance;
        }

        public DailyPayGiftInfoRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DailyPayGiftInfoRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return PayGiftHandler.internal_static_pomelo_area_DailyPayGiftInfoRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return PayGiftHandler.internal_static_pomelo_area_DailyPayGiftInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(DailyPayGiftInfoRequest.class, Builder.class);
        }

        public static Parser<DailyPayGiftInfoRequest> PARSER = (Parser<DailyPayGiftInfoRequest>) new AbstractParser<DailyPayGiftInfoRequest>() {
            public PayGiftHandler.DailyPayGiftInfoRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PayGiftHandler.DailyPayGiftInfoRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<DailyPayGiftInfoRequest> getParserForType() {
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


        public static DailyPayGiftInfoRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (DailyPayGiftInfoRequest) PARSER.parseFrom(data);
        }


        public static DailyPayGiftInfoRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DailyPayGiftInfoRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static DailyPayGiftInfoRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (DailyPayGiftInfoRequest) PARSER.parseFrom(data);
        }


        public static DailyPayGiftInfoRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DailyPayGiftInfoRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static DailyPayGiftInfoRequest parseFrom(InputStream input) throws IOException {
            return (DailyPayGiftInfoRequest) PARSER.parseFrom(input);
        }


        public static DailyPayGiftInfoRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DailyPayGiftInfoRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static DailyPayGiftInfoRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (DailyPayGiftInfoRequest) PARSER.parseDelimitedFrom(input);
        }


        public static DailyPayGiftInfoRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DailyPayGiftInfoRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static DailyPayGiftInfoRequest parseFrom(CodedInputStream input) throws IOException {
            return (DailyPayGiftInfoRequest) PARSER.parseFrom(input);
        }


        public static DailyPayGiftInfoRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DailyPayGiftInfoRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(DailyPayGiftInfoRequest prototype) {
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
                implements PayGiftHandler.DailyPayGiftInfoRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return PayGiftHandler.internal_static_pomelo_area_DailyPayGiftInfoRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PayGiftHandler.internal_static_pomelo_area_DailyPayGiftInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(PayGiftHandler.DailyPayGiftInfoRequest.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (PayGiftHandler.DailyPayGiftInfoRequest.alwaysUseFieldBuilders) ;
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
                return PayGiftHandler.internal_static_pomelo_area_DailyPayGiftInfoRequest_descriptor;
            }


            public PayGiftHandler.DailyPayGiftInfoRequest getDefaultInstanceForType() {
                return PayGiftHandler.DailyPayGiftInfoRequest.getDefaultInstance();
            }


            public PayGiftHandler.DailyPayGiftInfoRequest build() {
                PayGiftHandler.DailyPayGiftInfoRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public PayGiftHandler.DailyPayGiftInfoRequest buildPartial() {
                PayGiftHandler.DailyPayGiftInfoRequest result = new PayGiftHandler.DailyPayGiftInfoRequest(this);
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof PayGiftHandler.DailyPayGiftInfoRequest) {
                    return mergeFrom((PayGiftHandler.DailyPayGiftInfoRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(PayGiftHandler.DailyPayGiftInfoRequest other) {
                if (other == PayGiftHandler.DailyPayGiftInfoRequest.getDefaultInstance()) {
                    return this;
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                PayGiftHandler.DailyPayGiftInfoRequest parsedMessage = null;
                try {
                    parsedMessage = (PayGiftHandler.DailyPayGiftInfoRequest) PayGiftHandler.DailyPayGiftInfoRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (PayGiftHandler.DailyPayGiftInfoRequest) e.getUnfinishedMessage();
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


    public static final class DailyPayGiftData
            extends GeneratedMessage
            implements DailyPayGiftDataOrBuilder {
        private final UnknownFieldSet unknownFields;


        private DailyPayGiftData(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }


        private DailyPayGiftData(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }


        public static DailyPayGiftData getDefaultInstance() {
            return defaultInstance;
        }


        public DailyPayGiftData getDefaultInstanceForType() {
            return defaultInstance;
        }


        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }


        private DailyPayGiftData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.giftId_ = input.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.isGet_ = input.readInt32();
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
            return PayGiftHandler.internal_static_pomelo_area_DailyPayGiftData_descriptor;
        }


        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return PayGiftHandler.internal_static_pomelo_area_DailyPayGiftData_fieldAccessorTable.ensureFieldAccessorsInitialized(DailyPayGiftData.class, Builder.class);
        }


        public static Parser<DailyPayGiftData> PARSER = (Parser<DailyPayGiftData>) new AbstractParser<DailyPayGiftData>() {
            public PayGiftHandler.DailyPayGiftData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PayGiftHandler.DailyPayGiftData(input, extensionRegistry);
            }
        };


        private int bitField0_;


        public static final int GIFTID_FIELD_NUMBER = 1;


        private int giftId_;


        public static final int ISGET_FIELD_NUMBER = 2;


        private int isGet_;


        private byte memoizedIsInitialized;


        private int memoizedSerializedSize;


        private static final long serialVersionUID = 0L;


        public Parser<DailyPayGiftData> getParserForType() {
            return PARSER;
        }


        public boolean hasGiftId() {
            return ((this.bitField0_ & 0x1) == 1);
        }


        public int getGiftId() {
            return this.giftId_;
        }


        public boolean hasIsGet() {
            return ((this.bitField0_ & 0x2) == 2);
        }


        public int getIsGet() {
            return this.isGet_;
        }


        private void initFields() {
            this.giftId_ = 0;
            this.isGet_ = 0;
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasGiftId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasIsGet()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeInt32(1, this.giftId_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeInt32(2, this.isGet_);
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
                size += CodedOutputStream.computeInt32Size(1, this.giftId_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeInt32Size(2, this.isGet_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static DailyPayGiftData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (DailyPayGiftData) PARSER.parseFrom(data);
        }


        public static DailyPayGiftData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DailyPayGiftData) PARSER.parseFrom(data, extensionRegistry);
        }


        public static DailyPayGiftData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (DailyPayGiftData) PARSER.parseFrom(data);
        }


        public static DailyPayGiftData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DailyPayGiftData) PARSER.parseFrom(data, extensionRegistry);
        }


        public static DailyPayGiftData parseFrom(InputStream input) throws IOException {
            return (DailyPayGiftData) PARSER.parseFrom(input);
        }


        public static DailyPayGiftData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DailyPayGiftData) PARSER.parseFrom(input, extensionRegistry);
        }


        public static DailyPayGiftData parseDelimitedFrom(InputStream input) throws IOException {
            return (DailyPayGiftData) PARSER.parseDelimitedFrom(input);
        }


        public static DailyPayGiftData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DailyPayGiftData) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static DailyPayGiftData parseFrom(CodedInputStream input) throws IOException {
            return (DailyPayGiftData) PARSER.parseFrom(input);
        }


        public static DailyPayGiftData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DailyPayGiftData) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(DailyPayGiftData prototype) {
            return newBuilder().mergeFrom(prototype);
        }


        public Builder toBuilder() {
            return newBuilder(this);
        }


        private static final DailyPayGiftData defaultInstance = new DailyPayGiftData(true);

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements PayGiftHandler.DailyPayGiftDataOrBuilder {
            private int bitField0_;
            private int giftId_;
            private int isGet_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PayGiftHandler.internal_static_pomelo_area_DailyPayGiftData_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PayGiftHandler.internal_static_pomelo_area_DailyPayGiftData_fieldAccessorTable.ensureFieldAccessorsInitialized(PayGiftHandler.DailyPayGiftData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PayGiftHandler.DailyPayGiftData.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.giftId_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.isGet_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return PayGiftHandler.internal_static_pomelo_area_DailyPayGiftData_descriptor;
            }

            public PayGiftHandler.DailyPayGiftData getDefaultInstanceForType() {
                return PayGiftHandler.DailyPayGiftData.getDefaultInstance();
            }

            public PayGiftHandler.DailyPayGiftData build() {
                PayGiftHandler.DailyPayGiftData result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public PayGiftHandler.DailyPayGiftData buildPartial() {
                PayGiftHandler.DailyPayGiftData result = new PayGiftHandler.DailyPayGiftData(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.giftId_ = this.giftId_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.isGet_ = this.isGet_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof PayGiftHandler.DailyPayGiftData)
                    return mergeFrom((PayGiftHandler.DailyPayGiftData) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PayGiftHandler.DailyPayGiftData other) {
                if (other == PayGiftHandler.DailyPayGiftData.getDefaultInstance()) return this;
                if (other.hasGiftId()) setGiftId(other.getGiftId());
                if (other.hasIsGet()) setIsGet(other.getIsGet());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasGiftId()) return false;
                if (!hasIsGet()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                PayGiftHandler.DailyPayGiftData parsedMessage = null;
                try {
                    parsedMessage = (PayGiftHandler.DailyPayGiftData) PayGiftHandler.DailyPayGiftData.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (PayGiftHandler.DailyPayGiftData) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasGiftId() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getGiftId() {
                return this.giftId_;
            }

            public Builder setGiftId(int value) {
                this.bitField0_ |= 0x1;
                this.giftId_ = value;
                onChanged();
                return this;
            }

            public Builder clearGiftId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.giftId_ = 0;
                onChanged();
                return this;
            }

            public boolean hasIsGet() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getIsGet() {
                return this.isGet_;
            }

            public Builder setIsGet(int value) {
                this.bitField0_ |= 0x2;
                this.isGet_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsGet() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.isGet_ = 0;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class DailyPayGiftInfoResponse
            extends GeneratedMessage
            implements DailyPayGiftInfoResponseOrBuilder {
        private final UnknownFieldSet unknownFields;


        private DailyPayGiftInfoResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }


        private DailyPayGiftInfoResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }


        public static DailyPayGiftInfoResponse getDefaultInstance() {
            return defaultInstance;
        }


        public DailyPayGiftInfoResponse getDefaultInstanceForType() {
            return defaultInstance;
        }


        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }


        private DailyPayGiftInfoResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.s2CDayIndex_ = input.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.s2CDailyDiamondCount_ = input.readInt32();
                            break;
                        case 40:
                            this.bitField0_ |= 0x10;
                            this.s2CDailyMoneyCount_ = input.readInt32();
                            break;
                        case 50:
                            if ((mutable_bitField0_ & 0x20) != 32) {
                                this.s2CData_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x20;
                            }
                            this.s2CData_.add(input.readMessage(PayGiftHandler.DailyPayGiftData.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x20) == 32) {
                    this.s2CData_ = Collections.unmodifiableList(this.s2CData_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }


        public static final Descriptors.Descriptor getDescriptor() {
            return PayGiftHandler.internal_static_pomelo_area_DailyPayGiftInfoResponse_descriptor;
        }


        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return PayGiftHandler.internal_static_pomelo_area_DailyPayGiftInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(DailyPayGiftInfoResponse.class, Builder.class);
        }


        public static Parser<DailyPayGiftInfoResponse> PARSER = (Parser<DailyPayGiftInfoResponse>) new AbstractParser<DailyPayGiftInfoResponse>() {
            public PayGiftHandler.DailyPayGiftInfoResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PayGiftHandler.DailyPayGiftInfoResponse(input, extensionRegistry);
            }
        };


        private int bitField0_;


        public static final int S2C_CODE_FIELD_NUMBER = 1;


        private int s2CCode_;


        public static final int S2C_MSG_FIELD_NUMBER = 2;


        private Object s2CMsg_;


        public static final int S2C_DAYINDEX_FIELD_NUMBER = 3;


        private int s2CDayIndex_;


        public static final int S2C_DAILYDIAMONDCOUNT_FIELD_NUMBER = 4;


        private int s2CDailyDiamondCount_;


        public static final int S2C_DAILYMONEYCOUNT_FIELD_NUMBER = 5;


        private int s2CDailyMoneyCount_;


        public static final int S2C_DATA_FIELD_NUMBER = 6;


        private List<PayGiftHandler.DailyPayGiftData> s2CData_;


        private byte memoizedIsInitialized;


        private static final DailyPayGiftInfoResponse defaultInstance = new DailyPayGiftInfoResponse(true);
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<DailyPayGiftInfoResponse> getParserForType() {
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

        public boolean hasS2CDayIndex() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getS2CDayIndex() {
            return this.s2CDayIndex_;
        }

        public boolean hasS2CDailyDiamondCount() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public int getS2CDailyDiamondCount() {
            return this.s2CDailyDiamondCount_;
        }

        public boolean hasS2CDailyMoneyCount() {
            return ((this.bitField0_ & 0x10) == 16);
        }

        public int getS2CDailyMoneyCount() {
            return this.s2CDailyMoneyCount_;
        }

        public List<PayGiftHandler.DailyPayGiftData> getS2CDataList() {
            return this.s2CData_;
        }

        public List<? extends PayGiftHandler.DailyPayGiftDataOrBuilder> getS2CDataOrBuilderList() {
            return (List) this.s2CData_;
        }

        public int getS2CDataCount() {
            return this.s2CData_.size();
        }

        public PayGiftHandler.DailyPayGiftData getS2CData(int index) {
            return this.s2CData_.get(index);
        }

        public PayGiftHandler.DailyPayGiftDataOrBuilder getS2CDataOrBuilder(int index) {
            return this.s2CData_.get(index);
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CDayIndex_ = 0;
            this.s2CDailyDiamondCount_ = 0;
            this.s2CDailyMoneyCount_ = 0;
            this.s2CData_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
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
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2) output.writeBytes(2, getS2CMsgBytes());
            if ((this.bitField0_ & 0x4) == 4) output.writeInt32(3, this.s2CDayIndex_);
            if ((this.bitField0_ & 0x8) == 8) output.writeInt32(4, this.s2CDailyDiamondCount_);
            if ((this.bitField0_ & 0x10) == 16) output.writeInt32(5, this.s2CDailyMoneyCount_);
            for (int i = 0; i < this.s2CData_.size(); i++) output.writeMessage(6, (MessageLite) this.s2CData_.get(i));
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());
            if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeInt32Size(3, this.s2CDayIndex_);
            if ((this.bitField0_ & 0x8) == 8) size += CodedOutputStream.computeInt32Size(4, this.s2CDailyDiamondCount_);
            if ((this.bitField0_ & 0x10) == 16) size += CodedOutputStream.computeInt32Size(5, this.s2CDailyMoneyCount_);
            for (int i = 0; i < this.s2CData_.size(); i++)
                size += CodedOutputStream.computeMessageSize(6, (MessageLite) this.s2CData_.get(i));
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        static {
            defaultInstance.initFields();
        }

        public static DailyPayGiftInfoResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (DailyPayGiftInfoResponse) PARSER.parseFrom(data);
        }

        public static DailyPayGiftInfoResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DailyPayGiftInfoResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DailyPayGiftInfoResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (DailyPayGiftInfoResponse) PARSER.parseFrom(data);
        }

        public static DailyPayGiftInfoResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DailyPayGiftInfoResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DailyPayGiftInfoResponse parseFrom(InputStream input) throws IOException {
            return (DailyPayGiftInfoResponse) PARSER.parseFrom(input);
        }

        public static DailyPayGiftInfoResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DailyPayGiftInfoResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static DailyPayGiftInfoResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (DailyPayGiftInfoResponse) PARSER.parseDelimitedFrom(input);
        }

        public static DailyPayGiftInfoResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DailyPayGiftInfoResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static DailyPayGiftInfoResponse parseFrom(CodedInputStream input) throws IOException {
            return (DailyPayGiftInfoResponse) PARSER.parseFrom(input);
        }

        public static DailyPayGiftInfoResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DailyPayGiftInfoResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(DailyPayGiftInfoResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements PayGiftHandler.DailyPayGiftInfoResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private int s2CDayIndex_;
            private int s2CDailyDiamondCount_;
            private int s2CDailyMoneyCount_;
            private List<PayGiftHandler.DailyPayGiftData> s2CData_;
            private RepeatedFieldBuilder<PayGiftHandler.DailyPayGiftData, PayGiftHandler.DailyPayGiftData.Builder, PayGiftHandler.DailyPayGiftDataOrBuilder> s2CDataBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PayGiftHandler.internal_static_pomelo_area_DailyPayGiftInfoResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PayGiftHandler.internal_static_pomelo_area_DailyPayGiftInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(PayGiftHandler.DailyPayGiftInfoResponse.class, Builder.class);
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
                if (PayGiftHandler.DailyPayGiftInfoResponse.alwaysUseFieldBuilders)
                    getS2CDataFieldBuilder();
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
                this.s2CDayIndex_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.s2CDailyDiamondCount_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                this.s2CDailyMoneyCount_ = 0;
                this.bitField0_ &= 0xFFFFFFEF;
                if (this.s2CDataBuilder_ == null) {
                    this.s2CData_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFDF;
                } else {
                    this.s2CDataBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return PayGiftHandler.internal_static_pomelo_area_DailyPayGiftInfoResponse_descriptor;
            }

            public PayGiftHandler.DailyPayGiftInfoResponse getDefaultInstanceForType() {
                return PayGiftHandler.DailyPayGiftInfoResponse.getDefaultInstance();
            }

            public PayGiftHandler.DailyPayGiftInfoResponse build() {
                PayGiftHandler.DailyPayGiftInfoResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public PayGiftHandler.DailyPayGiftInfoResponse buildPartial() {
                PayGiftHandler.DailyPayGiftInfoResponse result = new PayGiftHandler.DailyPayGiftInfoResponse(this);
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
                result.s2CDayIndex_ = this.s2CDayIndex_;
                if ((from_bitField0_ & 0x8) == 8)
                    to_bitField0_ |= 0x8;
                result.s2CDailyDiamondCount_ = this.s2CDailyDiamondCount_;
                if ((from_bitField0_ & 0x10) == 16)
                    to_bitField0_ |= 0x10;
                result.s2CDailyMoneyCount_ = this.s2CDailyMoneyCount_;
                if (this.s2CDataBuilder_ == null) {
                    if ((this.bitField0_ & 0x20) == 32) {
                        this.s2CData_ = Collections.unmodifiableList(this.s2CData_);
                        this.bitField0_ &= 0xFFFFFFDF;
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
                if (other instanceof PayGiftHandler.DailyPayGiftInfoResponse)
                    return mergeFrom((PayGiftHandler.DailyPayGiftInfoResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PayGiftHandler.DailyPayGiftInfoResponse other) {
                if (other == PayGiftHandler.DailyPayGiftInfoResponse.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (other.hasS2CDayIndex())
                    setS2CDayIndex(other.getS2CDayIndex());
                if (other.hasS2CDailyDiamondCount())
                    setS2CDailyDiamondCount(other.getS2CDailyDiamondCount());
                if (other.hasS2CDailyMoneyCount())
                    setS2CDailyMoneyCount(other.getS2CDailyMoneyCount());
                if (this.s2CDataBuilder_ == null) {
                    if (!other.s2CData_.isEmpty()) {
                        if (this.s2CData_.isEmpty()) {
                            this.s2CData_ = other.s2CData_;
                            this.bitField0_ &= 0xFFFFFFDF;
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
                        this.bitField0_ &= 0xFFFFFFDF;
                        this.s2CDataBuilder_ = PayGiftHandler.DailyPayGiftInfoResponse.alwaysUseFieldBuilders ? getS2CDataFieldBuilder() : null;
                    } else {
                        this.s2CDataBuilder_.addAllMessages(other.s2CData_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode())
                    return false;
                for (int i = 0; i < getS2CDataCount(); i++) {
                    if (!getS2CData(i).isInitialized())
                        return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                PayGiftHandler.DailyPayGiftInfoResponse parsedMessage = null;
                try {
                    parsedMessage = (PayGiftHandler.DailyPayGiftInfoResponse) PayGiftHandler.DailyPayGiftInfoResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (PayGiftHandler.DailyPayGiftInfoResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = PayGiftHandler.DailyPayGiftInfoResponse.getDefaultInstance().getS2CMsg();
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

            public boolean hasS2CDayIndex() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public int getS2CDayIndex() {
                return this.s2CDayIndex_;
            }

            public Builder setS2CDayIndex(int value) {
                this.bitField0_ |= 0x4;
                this.s2CDayIndex_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CDayIndex() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.s2CDayIndex_ = 0;
                onChanged();
                return this;
            }

            public boolean hasS2CDailyDiamondCount() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public int getS2CDailyDiamondCount() {
                return this.s2CDailyDiamondCount_;
            }

            public Builder setS2CDailyDiamondCount(int value) {
                this.bitField0_ |= 0x8;
                this.s2CDailyDiamondCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CDailyDiamondCount() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.s2CDailyDiamondCount_ = 0;
                onChanged();
                return this;
            }

            public boolean hasS2CDailyMoneyCount() {
                return ((this.bitField0_ & 0x10) == 16);
            }

            public int getS2CDailyMoneyCount() {
                return this.s2CDailyMoneyCount_;
            }

            public Builder setS2CDailyMoneyCount(int value) {
                this.bitField0_ |= 0x10;
                this.s2CDailyMoneyCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CDailyMoneyCount() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.s2CDailyMoneyCount_ = 0;
                onChanged();
                return this;
            }

            private void ensureS2CDataIsMutable() {
                if ((this.bitField0_ & 0x20) != 32) {
                    this.s2CData_ = new ArrayList<>(this.s2CData_);
                    this.bitField0_ |= 0x20;
                }
            }

            public List<PayGiftHandler.DailyPayGiftData> getS2CDataList() {
                if (this.s2CDataBuilder_ == null)
                    return Collections.unmodifiableList(this.s2CData_);
                return this.s2CDataBuilder_.getMessageList();
            }

            public int getS2CDataCount() {
                if (this.s2CDataBuilder_ == null)
                    return this.s2CData_.size();
                return this.s2CDataBuilder_.getCount();
            }

            public PayGiftHandler.DailyPayGiftData getS2CData(int index) {
                if (this.s2CDataBuilder_ == null)
                    return this.s2CData_.get(index);
                return (PayGiftHandler.DailyPayGiftData) this.s2CDataBuilder_.getMessage(index);
            }

            public Builder setS2CData(int index, PayGiftHandler.DailyPayGiftData value) {
                if (this.s2CDataBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CDataIsMutable();
                    this.s2CData_.set(index, value);
                    onChanged();
                } else {
                    this.s2CDataBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setS2CData(int index, PayGiftHandler.DailyPayGiftData.Builder builderForValue) {
                if (this.s2CDataBuilder_ == null) {
                    ensureS2CDataIsMutable();
                    this.s2CData_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CDataBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addS2CData(PayGiftHandler.DailyPayGiftData value) {
                if (this.s2CDataBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CDataIsMutable();
                    this.s2CData_.add(value);
                    onChanged();
                } else {
                    this.s2CDataBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addS2CData(int index, PayGiftHandler.DailyPayGiftData value) {
                if (this.s2CDataBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CDataIsMutable();
                    this.s2CData_.add(index, value);
                    onChanged();
                } else {
                    this.s2CDataBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addS2CData(PayGiftHandler.DailyPayGiftData.Builder builderForValue) {
                if (this.s2CDataBuilder_ == null) {
                    ensureS2CDataIsMutable();
                    this.s2CData_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.s2CDataBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addS2CData(int index, PayGiftHandler.DailyPayGiftData.Builder builderForValue) {
                if (this.s2CDataBuilder_ == null) {
                    ensureS2CDataIsMutable();
                    this.s2CData_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CDataBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllS2CData(Iterable<? extends PayGiftHandler.DailyPayGiftData> values) {
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
                    this.bitField0_ &= 0xFFFFFFDF;
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

            public PayGiftHandler.DailyPayGiftData.Builder getS2CDataBuilder(int index) {
                return (PayGiftHandler.DailyPayGiftData.Builder) getS2CDataFieldBuilder().getBuilder(index);
            }

            public PayGiftHandler.DailyPayGiftDataOrBuilder getS2CDataOrBuilder(int index) {
                if (this.s2CDataBuilder_ == null)
                    return this.s2CData_.get(index);
                return (PayGiftHandler.DailyPayGiftDataOrBuilder) this.s2CDataBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends PayGiftHandler.DailyPayGiftDataOrBuilder> getS2CDataOrBuilderList() {
                if (this.s2CDataBuilder_ != null)
                    return this.s2CDataBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.s2CData_);
            }

            public PayGiftHandler.DailyPayGiftData.Builder addS2CDataBuilder() {
                return (PayGiftHandler.DailyPayGiftData.Builder) getS2CDataFieldBuilder().addBuilder(PayGiftHandler.DailyPayGiftData.getDefaultInstance());
            }

            public PayGiftHandler.DailyPayGiftData.Builder addS2CDataBuilder(int index) {
                return (PayGiftHandler.DailyPayGiftData.Builder) getS2CDataFieldBuilder().addBuilder(index, PayGiftHandler.DailyPayGiftData.getDefaultInstance());
            }

            public List<PayGiftHandler.DailyPayGiftData.Builder> getS2CDataBuilderList() {
                return getS2CDataFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<PayGiftHandler.DailyPayGiftData, PayGiftHandler.DailyPayGiftData.Builder, PayGiftHandler.DailyPayGiftDataOrBuilder> getS2CDataFieldBuilder() {
                if (this.s2CDataBuilder_ == null) {
                    this.s2CDataBuilder_ = new RepeatedFieldBuilder(this.s2CData_, ((this.bitField0_ & 0x20) == 32), getParentForChildren(), isClean());
                    this.s2CData_ = null;
                }
                return this.s2CDataBuilder_;
            }
        }
    }

    public static final class GetDailyPayGiftRequest extends GeneratedMessage implements GetDailyPayGiftRequestOrBuilder {
        private static final GetDailyPayGiftRequest defaultInstance = new GetDailyPayGiftRequest(true);
        private final UnknownFieldSet unknownFields;

        private GetDailyPayGiftRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetDailyPayGiftRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetDailyPayGiftRequest getDefaultInstance() {
            return defaultInstance;
        }

        public GetDailyPayGiftRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetDailyPayGiftRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.c2SGiftId_ = input.readInt32();
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
            return PayGiftHandler.internal_static_pomelo_area_GetDailyPayGiftRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return PayGiftHandler.internal_static_pomelo_area_GetDailyPayGiftRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetDailyPayGiftRequest.class, Builder.class);
        }

        public static Parser<GetDailyPayGiftRequest> PARSER = (Parser<GetDailyPayGiftRequest>) new AbstractParser<GetDailyPayGiftRequest>() {
            public PayGiftHandler.GetDailyPayGiftRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PayGiftHandler.GetDailyPayGiftRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_GIFTID_FIELD_NUMBER = 1;
        private int c2SGiftId_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetDailyPayGiftRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasC2SGiftId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getC2SGiftId() {
            return this.c2SGiftId_;
        }

        private void initFields() {
            this.c2SGiftId_ = 0;
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
            if (!hasC2SGiftId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeInt32(1, this.c2SGiftId_);
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
                size += CodedOutputStream.computeInt32Size(1, this.c2SGiftId_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static GetDailyPayGiftRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetDailyPayGiftRequest) PARSER.parseFrom(data);
        }


        public static GetDailyPayGiftRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetDailyPayGiftRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetDailyPayGiftRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetDailyPayGiftRequest) PARSER.parseFrom(data);
        }


        public static GetDailyPayGiftRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetDailyPayGiftRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetDailyPayGiftRequest parseFrom(InputStream input) throws IOException {
            return (GetDailyPayGiftRequest) PARSER.parseFrom(input);
        }


        public static GetDailyPayGiftRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetDailyPayGiftRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static GetDailyPayGiftRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (GetDailyPayGiftRequest) PARSER.parseDelimitedFrom(input);
        }


        public static GetDailyPayGiftRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetDailyPayGiftRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static GetDailyPayGiftRequest parseFrom(CodedInputStream input) throws IOException {
            return (GetDailyPayGiftRequest) PARSER.parseFrom(input);
        }


        public static GetDailyPayGiftRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetDailyPayGiftRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(GetDailyPayGiftRequest prototype) {
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
                implements PayGiftHandler.GetDailyPayGiftRequestOrBuilder {
            private int bitField0_;


            private int c2SGiftId_;


            public static final Descriptors.Descriptor getDescriptor() {
                return PayGiftHandler.internal_static_pomelo_area_GetDailyPayGiftRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PayGiftHandler.internal_static_pomelo_area_GetDailyPayGiftRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(PayGiftHandler.GetDailyPayGiftRequest.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (PayGiftHandler.GetDailyPayGiftRequest.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.c2SGiftId_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return PayGiftHandler.internal_static_pomelo_area_GetDailyPayGiftRequest_descriptor;
            }


            public PayGiftHandler.GetDailyPayGiftRequest getDefaultInstanceForType() {
                return PayGiftHandler.GetDailyPayGiftRequest.getDefaultInstance();
            }


            public PayGiftHandler.GetDailyPayGiftRequest build() {
                PayGiftHandler.GetDailyPayGiftRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public PayGiftHandler.GetDailyPayGiftRequest buildPartial() {
                PayGiftHandler.GetDailyPayGiftRequest result = new PayGiftHandler.GetDailyPayGiftRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.c2SGiftId_ = this.c2SGiftId_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof PayGiftHandler.GetDailyPayGiftRequest) {
                    return mergeFrom((PayGiftHandler.GetDailyPayGiftRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(PayGiftHandler.GetDailyPayGiftRequest other) {
                if (other == PayGiftHandler.GetDailyPayGiftRequest.getDefaultInstance()) {
                    return this;
                }
                if (other.hasC2SGiftId()) {
                    setC2SGiftId(other.getC2SGiftId());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasC2SGiftId()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                PayGiftHandler.GetDailyPayGiftRequest parsedMessage = null;
                try {
                    parsedMessage = (PayGiftHandler.GetDailyPayGiftRequest) PayGiftHandler.GetDailyPayGiftRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (PayGiftHandler.GetDailyPayGiftRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasC2SGiftId() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public int getC2SGiftId() {
                return this.c2SGiftId_;
            }


            public Builder setC2SGiftId(int value) {
                this.bitField0_ |= 0x1;
                this.c2SGiftId_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SGiftId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SGiftId_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class GetDailyPayGiftResponse
            extends GeneratedMessage
            implements GetDailyPayGiftResponseOrBuilder {
        private final UnknownFieldSet unknownFields;


        private GetDailyPayGiftResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }


        private GetDailyPayGiftResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }


        public static GetDailyPayGiftResponse getDefaultInstance() {
            return defaultInstance;
        }


        public GetDailyPayGiftResponse getDefaultInstanceForType() {
            return defaultInstance;
        }


        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }


        private GetDailyPayGiftResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return PayGiftHandler.internal_static_pomelo_area_GetDailyPayGiftResponse_descriptor;
        }


        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return PayGiftHandler.internal_static_pomelo_area_GetDailyPayGiftResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetDailyPayGiftResponse.class, Builder.class);
        }


        public static Parser<GetDailyPayGiftResponse> PARSER = (Parser<GetDailyPayGiftResponse>) new AbstractParser<GetDailyPayGiftResponse>() {
            public PayGiftHandler.GetDailyPayGiftResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PayGiftHandler.GetDailyPayGiftResponse(input, extensionRegistry);
            }
        };


        private int bitField0_;


        public static final int S2C_CODE_FIELD_NUMBER = 1;


        private int s2CCode_;


        public static final int S2C_MSG_FIELD_NUMBER = 2;


        private Object s2CMsg_;


        private byte memoizedIsInitialized;


        private int memoizedSerializedSize;


        private static final GetDailyPayGiftResponse defaultInstance = new GetDailyPayGiftResponse(true);
        private static final long serialVersionUID = 0L;

        public Parser<GetDailyPayGiftResponse> getParserForType() {
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

        public static GetDailyPayGiftResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetDailyPayGiftResponse) PARSER.parseFrom(data);
        }

        public static GetDailyPayGiftResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetDailyPayGiftResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetDailyPayGiftResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetDailyPayGiftResponse) PARSER.parseFrom(data);
        }

        public static GetDailyPayGiftResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetDailyPayGiftResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetDailyPayGiftResponse parseFrom(InputStream input) throws IOException {
            return (GetDailyPayGiftResponse) PARSER.parseFrom(input);
        }

        public static GetDailyPayGiftResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetDailyPayGiftResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static GetDailyPayGiftResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (GetDailyPayGiftResponse) PARSER.parseDelimitedFrom(input);
        }

        public static GetDailyPayGiftResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetDailyPayGiftResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static GetDailyPayGiftResponse parseFrom(CodedInputStream input) throws IOException {
            return (GetDailyPayGiftResponse) PARSER.parseFrom(input);
        }

        public static GetDailyPayGiftResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetDailyPayGiftResponse) PARSER.parseFrom(input, extensionRegistry);
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

        public static Builder newBuilder(GetDailyPayGiftResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements PayGiftHandler.GetDailyPayGiftResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PayGiftHandler.internal_static_pomelo_area_GetDailyPayGiftResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PayGiftHandler.internal_static_pomelo_area_GetDailyPayGiftResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(PayGiftHandler.GetDailyPayGiftResponse.class, Builder.class);
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
                if (PayGiftHandler.GetDailyPayGiftResponse.alwaysUseFieldBuilders) ;
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
                return PayGiftHandler.internal_static_pomelo_area_GetDailyPayGiftResponse_descriptor;
            }

            public PayGiftHandler.GetDailyPayGiftResponse getDefaultInstanceForType() {
                return PayGiftHandler.GetDailyPayGiftResponse.getDefaultInstance();
            }

            public PayGiftHandler.GetDailyPayGiftResponse build() {
                PayGiftHandler.GetDailyPayGiftResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public PayGiftHandler.GetDailyPayGiftResponse buildPartial() {
                PayGiftHandler.GetDailyPayGiftResponse result = new PayGiftHandler.GetDailyPayGiftResponse(this);
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
                if (other instanceof PayGiftHandler.GetDailyPayGiftResponse)
                    return mergeFrom((PayGiftHandler.GetDailyPayGiftResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PayGiftHandler.GetDailyPayGiftResponse other) {
                if (other == PayGiftHandler.GetDailyPayGiftResponse.getDefaultInstance())
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
                PayGiftHandler.GetDailyPayGiftResponse parsedMessage = null;
                try {
                    parsedMessage = (PayGiftHandler.GetDailyPayGiftResponse) PayGiftHandler.GetDailyPayGiftResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (PayGiftHandler.GetDailyPayGiftResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = PayGiftHandler.GetDailyPayGiftResponse.getDefaultInstance().getS2CMsg();
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
        String[] descriptorData = {"\n\024payGiftHandler.proto\022\013pomelo.area\"\031\n\027FirstPayGiftInfoRequest\"!\n\020FirstPayGiftData\022\r\n\005isGet\030\001 \002(\005\"n\n\030FirstPayGiftInfoResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022/\n\bs2c_data\030\003 \001(\0132\035.pomelo.area.FirstPayGiftData\"\030\n\026GetFirstPayGiftRequest\"<\n\027GetFirstPayGiftResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"\031\n\027DailyPayGiftInfoRequest\"1\n\020DailyPayGiftData\022\016\n\006giftId\030\001 \002(\005\022\r\n\005isGet\030\002 \002(\005\"À\001\n\030DailyPayGiftInfoResp", "onse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\024\n\fs2c_dayIndex\030\003 \001(\005\022\035\n\025s2c_dailyDiamondCount\030\004 \001(\005\022\033\n\023s2c_dailyMoneyCount\030\005 \001(\005\022/\n\bs2c_data\030\006 \003(\0132\035.pomelo.area.DailyPayGiftData\",\n\026GetDailyPayGiftRequest\022\022\n\nc2s_giftId\030\001 \002(\005\"<\n\027GetDailyPayGiftResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t2ª\003\n\016payGiftHandler\022f\n\027firstPayGiftInfoRequest\022$.pomelo.area.FirstPayGiftInfoRequest\032%.pomelo.area.FirstPayGiftInfoRespons", "e\022c\n\026getFirstPayGiftRequest\022#.pomelo.area.GetFirstPayGiftRequest\032$.pomelo.area.GetFirstPayGiftResponse\022f\n\027dailyPayGiftInfoRequest\022$.pomelo.area.DailyPayGiftInfoRequest\032%.pomelo.area.DailyPayGiftInfoResponse\022c\n\026getDailyPayGiftRequest\022#.pomelo.area.GetDailyPayGiftRequest\032$.pomelo.area.GetDailyPayGiftResponse"};


        Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root) {
                PayGiftHandler.descriptor = root;
                return null;
            }
        };

        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[0], assigner);
    }


    private static final Descriptors.Descriptor internal_static_pomelo_area_FirstPayGiftInfoRequest_descriptor = getDescriptor().getMessageTypes().get(0);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_FirstPayGiftInfoRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_FirstPayGiftInfoRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_area_FirstPayGiftData_descriptor = getDescriptor().getMessageTypes().get(1);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_FirstPayGiftData_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_FirstPayGiftData_descriptor, new String[]{"IsGet"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_FirstPayGiftInfoResponse_descriptor = getDescriptor().getMessageTypes().get(2);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_FirstPayGiftInfoResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_FirstPayGiftInfoResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CData"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetFirstPayGiftRequest_descriptor = getDescriptor().getMessageTypes().get(3);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetFirstPayGiftRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetFirstPayGiftRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetFirstPayGiftResponse_descriptor = getDescriptor().getMessageTypes().get(4);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetFirstPayGiftResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetFirstPayGiftResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_DailyPayGiftInfoRequest_descriptor = getDescriptor().getMessageTypes().get(5);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_DailyPayGiftInfoRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_DailyPayGiftInfoRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_area_DailyPayGiftData_descriptor = getDescriptor().getMessageTypes().get(6);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_DailyPayGiftData_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_DailyPayGiftData_descriptor, new String[]{"GiftId", "IsGet"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_DailyPayGiftInfoResponse_descriptor = getDescriptor().getMessageTypes().get(7);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_DailyPayGiftInfoResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_DailyPayGiftInfoResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CDayIndex", "S2CDailyDiamondCount", "S2CDailyMoneyCount", "S2CData"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetDailyPayGiftRequest_descriptor = getDescriptor().getMessageTypes().get(8);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetDailyPayGiftRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetDailyPayGiftRequest_descriptor, new String[]{"C2SGiftId"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetDailyPayGiftResponse_descriptor = getDescriptor().getMessageTypes().get(9);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetDailyPayGiftResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetDailyPayGiftResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});
    private static Descriptors.FileDescriptor descriptor;

    public static interface GetDailyPayGiftResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface GetDailyPayGiftRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2SGiftId();

        int getC2SGiftId();
    }

    public static interface DailyPayGiftInfoResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasS2CDayIndex();

        int getS2CDayIndex();

        boolean hasS2CDailyDiamondCount();

        int getS2CDailyDiamondCount();

        boolean hasS2CDailyMoneyCount();

        int getS2CDailyMoneyCount();

        List<PayGiftHandler.DailyPayGiftData> getS2CDataList();

        PayGiftHandler.DailyPayGiftData getS2CData(int param1Int);

        int getS2CDataCount();

        List<? extends PayGiftHandler.DailyPayGiftDataOrBuilder> getS2CDataOrBuilderList();

        PayGiftHandler.DailyPayGiftDataOrBuilder getS2CDataOrBuilder(int param1Int);
    }

    public static interface DailyPayGiftDataOrBuilder extends MessageOrBuilder {
        boolean hasGiftId();

        int getGiftId();

        boolean hasIsGet();

        int getIsGet();
    }

    public static interface DailyPayGiftInfoRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface GetFirstPayGiftResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface GetFirstPayGiftRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface FirstPayGiftInfoResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasS2CData();

        PayGiftHandler.FirstPayGiftData getS2CData();

        PayGiftHandler.FirstPayGiftDataOrBuilder getS2CDataOrBuilder();
    }

    public static interface FirstPayGiftDataOrBuilder extends MessageOrBuilder {
        boolean hasIsGet();

        int getIsGet();
    }

    public static interface FirstPayGiftInfoRequestOrBuilder extends MessageOrBuilder {
    }
}


