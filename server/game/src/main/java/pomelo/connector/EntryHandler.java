package pomelo.connector;

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
import pomelo.player.PlayerOuterClass;


public final class EntryHandler {
    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static final class GetSysTimeRequest
            extends GeneratedMessage
            implements GetSysTimeRequestOrBuilder {
        private static final GetSysTimeRequest defaultInstance = new GetSysTimeRequest(true);
        private final UnknownFieldSet unknownFields;

        private GetSysTimeRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetSysTimeRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetSysTimeRequest getDefaultInstance() {
            return defaultInstance;
        }

        public GetSysTimeRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetSysTimeRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return EntryHandler.internal_static_pomelo_connector_GetSysTimeRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return EntryHandler.internal_static_pomelo_connector_GetSysTimeRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetSysTimeRequest.class, Builder.class);
        }

        public static Parser<GetSysTimeRequest> PARSER = (Parser<GetSysTimeRequest>) new AbstractParser<GetSysTimeRequest>() {
            public EntryHandler.GetSysTimeRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new EntryHandler.GetSysTimeRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetSysTimeRequest> getParserForType() {
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


        public static GetSysTimeRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetSysTimeRequest) PARSER.parseFrom(data);
        }


        public static GetSysTimeRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetSysTimeRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetSysTimeRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetSysTimeRequest) PARSER.parseFrom(data);
        }


        public static GetSysTimeRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetSysTimeRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetSysTimeRequest parseFrom(InputStream input) throws IOException {
            return (GetSysTimeRequest) PARSER.parseFrom(input);
        }


        public static GetSysTimeRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetSysTimeRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static GetSysTimeRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (GetSysTimeRequest) PARSER.parseDelimitedFrom(input);
        }


        public static GetSysTimeRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetSysTimeRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static GetSysTimeRequest parseFrom(CodedInputStream input) throws IOException {
            return (GetSysTimeRequest) PARSER.parseFrom(input);
        }


        public static GetSysTimeRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetSysTimeRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(GetSysTimeRequest prototype) {
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
                implements EntryHandler.GetSysTimeRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return EntryHandler.internal_static_pomelo_connector_GetSysTimeRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return EntryHandler.internal_static_pomelo_connector_GetSysTimeRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(EntryHandler.GetSysTimeRequest.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (EntryHandler.GetSysTimeRequest.alwaysUseFieldBuilders) ;
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
                return EntryHandler.internal_static_pomelo_connector_GetSysTimeRequest_descriptor;
            }


            public EntryHandler.GetSysTimeRequest getDefaultInstanceForType() {
                return EntryHandler.GetSysTimeRequest.getDefaultInstance();
            }


            public EntryHandler.GetSysTimeRequest build() {
                EntryHandler.GetSysTimeRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public EntryHandler.GetSysTimeRequest buildPartial() {
                EntryHandler.GetSysTimeRequest result = new EntryHandler.GetSysTimeRequest(this);
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof EntryHandler.GetSysTimeRequest) {
                    return mergeFrom((EntryHandler.GetSysTimeRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(EntryHandler.GetSysTimeRequest other) {
                if (other == EntryHandler.GetSysTimeRequest.getDefaultInstance()) {
                    return this;
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                EntryHandler.GetSysTimeRequest parsedMessage = null;
                try {
                    parsedMessage = (EntryHandler.GetSysTimeRequest) EntryHandler.GetSysTimeRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (EntryHandler.GetSysTimeRequest) e.getUnfinishedMessage();
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


    public static final class GetSysTimeResponse
            extends GeneratedMessage
            implements GetSysTimeResponseOrBuilder {
        private static final GetSysTimeResponse defaultInstance = new GetSysTimeResponse(true);
        private final UnknownFieldSet unknownFields;

        private GetSysTimeResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetSysTimeResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetSysTimeResponse getDefaultInstance() {
            return defaultInstance;
        }

        public GetSysTimeResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetSysTimeResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.s2CTime_ = bs;
                            break;
                        case 26:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x4;
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
            return EntryHandler.internal_static_pomelo_connector_GetSysTimeResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return EntryHandler.internal_static_pomelo_connector_GetSysTimeResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetSysTimeResponse.class, Builder.class);
        }

        public static Parser<GetSysTimeResponse> PARSER = (Parser<GetSysTimeResponse>) new AbstractParser<GetSysTimeResponse>() {
            public EntryHandler.GetSysTimeResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new EntryHandler.GetSysTimeResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_TIME_FIELD_NUMBER = 2;
        private Object s2CTime_;
        public static final int S2C_MSG_FIELD_NUMBER = 3;
        private Object s2CMsg_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetSysTimeResponse> getParserForType() {
            return PARSER;
        }

        public boolean hasS2CCode() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getS2CCode() {
            return this.s2CCode_;
        }

        public boolean hasS2CTime() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public String getS2CTime() {
            Object ref = this.s2CTime_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.s2CTime_ = s;
            return s;
        }

        static {
            defaultInstance.initFields();
        }


        public ByteString getS2CTimeBytes() {
            Object ref = this.s2CTime_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.s2CTime_ = b;
                return b;
            }
            return (ByteString) ref;
        }


        public boolean hasS2CMsg() {
            return ((this.bitField0_ & 0x4) == 4);
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
            this.s2CTime_ = "";
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
            if (!hasS2CTime()) {
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
                output.writeBytes(2, getS2CTimeBytes());
            }
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeBytes(3, getS2CMsgBytes());
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
                size += CodedOutputStream.computeBytesSize(2, getS2CTimeBytes());
            }
            if ((this.bitField0_ & 0x4) == 4) {
                size += CodedOutputStream.computeBytesSize(3, getS2CMsgBytes());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static GetSysTimeResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetSysTimeResponse) PARSER.parseFrom(data);
        }


        public static GetSysTimeResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetSysTimeResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetSysTimeResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetSysTimeResponse) PARSER.parseFrom(data);
        }


        public static GetSysTimeResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetSysTimeResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetSysTimeResponse parseFrom(InputStream input) throws IOException {
            return (GetSysTimeResponse) PARSER.parseFrom(input);
        }


        public static GetSysTimeResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetSysTimeResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static GetSysTimeResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (GetSysTimeResponse) PARSER.parseDelimitedFrom(input);
        }


        public static GetSysTimeResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetSysTimeResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static GetSysTimeResponse parseFrom(CodedInputStream input) throws IOException {
            return (GetSysTimeResponse) PARSER.parseFrom(input);
        }


        public static GetSysTimeResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetSysTimeResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(GetSysTimeResponse prototype) {
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
                implements EntryHandler.GetSysTimeResponseOrBuilder {
            private int bitField0_;


            private int s2CCode_;


            private Object s2CTime_;


            private Object s2CMsg_;


            public static final Descriptors.Descriptor getDescriptor() {
                return EntryHandler.internal_static_pomelo_connector_GetSysTimeResponse_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return EntryHandler.internal_static_pomelo_connector_GetSysTimeResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(EntryHandler.GetSysTimeResponse.class, Builder.class);
            }


            private Builder() {
                this.s2CTime_ = "";
                this.s2CMsg_ = "";
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CTime_ = "";
                this.s2CMsg_ = "";
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (EntryHandler.GetSysTimeResponse.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.s2CCode_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.s2CTime_ = "";
                this.bitField0_ &= 0xFFFFFFFD;
                this.s2CMsg_ = "";
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return EntryHandler.internal_static_pomelo_connector_GetSysTimeResponse_descriptor;
            }


            public EntryHandler.GetSysTimeResponse getDefaultInstanceForType() {
                return EntryHandler.GetSysTimeResponse.getDefaultInstance();
            }


            public EntryHandler.GetSysTimeResponse build() {
                EntryHandler.GetSysTimeResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public EntryHandler.GetSysTimeResponse buildPartial() {
                EntryHandler.GetSysTimeResponse result = new EntryHandler.GetSysTimeResponse(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.s2CTime_ = this.s2CTime_;
                if ((from_bitField0_ & 0x4) == 4) {
                    to_bitField0_ |= 0x4;
                }
                result.s2CMsg_ = this.s2CMsg_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof EntryHandler.GetSysTimeResponse) {
                    return mergeFrom((EntryHandler.GetSysTimeResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(EntryHandler.GetSysTimeResponse other) {
                if (other == EntryHandler.GetSysTimeResponse.getDefaultInstance()) {
                    return this;
                }
                if (other.hasS2CCode()) {
                    setS2CCode(other.getS2CCode());
                }
                if (other.hasS2CTime()) {
                    this.bitField0_ |= 0x2;
                    this.s2CTime_ = other.s2CTime_;
                    onChanged();
                }
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x4;
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
                if (!hasS2CTime()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                EntryHandler.GetSysTimeResponse parsedMessage = null;
                try {
                    parsedMessage = (EntryHandler.GetSysTimeResponse) EntryHandler.GetSysTimeResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (EntryHandler.GetSysTimeResponse) e.getUnfinishedMessage();
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


            public boolean hasS2CTime() {
                return ((this.bitField0_ & 0x2) == 2);
            }


            public String getS2CTime() {
                Object ref = this.s2CTime_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.s2CTime_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }


            public ByteString getS2CTimeBytes() {
                Object ref = this.s2CTime_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.s2CTime_ = b;
                    return b;
                }
                return (ByteString) ref;
            }


            public Builder setS2CTime(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x2;
                this.s2CTime_ = value;
                onChanged();
                return this;
            }


            public Builder clearS2CTime() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.s2CTime_ = EntryHandler.GetSysTimeResponse.getDefaultInstance().getS2CTime();
                onChanged();
                return this;
            }


            public Builder setS2CTimeBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x2;
                this.s2CTime_ = value;
                onChanged();
                return this;
            }


            public boolean hasS2CMsg() {
                return ((this.bitField0_ & 0x4) == 4);
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
                this.bitField0_ |= 0x4;
                this.s2CMsg_ = value;
                onChanged();
                return this;
            }


            public Builder clearS2CMsg() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.s2CMsg_ = EntryHandler.GetSysTimeResponse.getDefaultInstance().getS2CMsg();
                onChanged();
                return this;
            }


            public Builder setS2CMsgBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x4;
                this.s2CMsg_ = value;
                onChanged();
                return this;
            }
        }
    }


    public static final class EntryRequest
            extends GeneratedMessage
            implements EntryRequestOrBuilder {
        private static final EntryRequest defaultInstance = new EntryRequest(true);
        private final UnknownFieldSet unknownFields;

        private EntryRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private EntryRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static EntryRequest getDefaultInstance() {
            return defaultInstance;
        }

        public EntryRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private EntryRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.c2SUid_ = bs;
                            break;
                        case 18:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x2;
                            this.c2SToken_ = bs;
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.c2SLogicServerId_ = input.readInt32();
                            break;
                        case 34:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x8;
                            this.c2SDeviceMac_ = bs;
                            break;
                        case 40:
                            this.bitField0_ |= 0x10;
                            this.c2SDeviceType_ = input.readInt32();
                            break;
                        case 50:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x20;
                            this.c2SClientRegion_ = bs;
                            break;
                        case 58:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x40;
                            this.c2SClientChannel_ = bs;
                            break;
                        case 66:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x80;
                            this.c2SClientVersion_ = bs;
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
            return EntryHandler.internal_static_pomelo_connector_EntryRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return EntryHandler.internal_static_pomelo_connector_EntryRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(EntryRequest.class, Builder.class);
        }

        public static Parser<EntryRequest> PARSER = (Parser<EntryRequest>) new AbstractParser<EntryRequest>() {
            public EntryHandler.EntryRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new EntryHandler.EntryRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_UID_FIELD_NUMBER = 1;
        private Object c2SUid_;
        public static final int C2S_TOKEN_FIELD_NUMBER = 2;
        private Object c2SToken_;
        public static final int C2S_LOGICSERVERID_FIELD_NUMBER = 3;
        private int c2SLogicServerId_;
        public static final int C2S_DEVICEMAC_FIELD_NUMBER = 4;
        private Object c2SDeviceMac_;
        public static final int C2S_DEVICETYPE_FIELD_NUMBER = 5;
        private int c2SDeviceType_;
        public static final int C2S_CLIENTREGION_FIELD_NUMBER = 6;
        private Object c2SClientRegion_;
        public static final int C2S_CLIENTCHANNEL_FIELD_NUMBER = 7;
        private Object c2SClientChannel_;
        public static final int C2S_CLIENTVERSION_FIELD_NUMBER = 8;
        private Object c2SClientVersion_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<EntryRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasC2SUid() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public String getC2SUid() {
            Object ref = this.c2SUid_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.c2SUid_ = s;
            return s;
        }

        public ByteString getC2SUidBytes() {
            Object ref = this.c2SUid_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.c2SUid_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasC2SToken() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public String getC2SToken() {
            Object ref = this.c2SToken_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.c2SToken_ = s;
            return s;
        }

        public ByteString getC2STokenBytes() {
            Object ref = this.c2SToken_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.c2SToken_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        static {
            defaultInstance.initFields();
        }


        public boolean hasC2SLogicServerId() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public int getC2SLogicServerId() {
            return this.c2SLogicServerId_;
        }


        public boolean hasC2SDeviceMac() {
            return ((this.bitField0_ & 0x8) == 8);
        }


        public String getC2SDeviceMac() {
            Object ref = this.c2SDeviceMac_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.c2SDeviceMac_ = s;
            }
            return s;
        }


        public ByteString getC2SDeviceMacBytes() {
            Object ref = this.c2SDeviceMac_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.c2SDeviceMac_ = b;
                return b;
            }
            return (ByteString) ref;
        }


        public boolean hasC2SDeviceType() {
            return ((this.bitField0_ & 0x10) == 16);
        }


        public int getC2SDeviceType() {
            return this.c2SDeviceType_;
        }


        public boolean hasC2SClientRegion() {
            return ((this.bitField0_ & 0x20) == 32);
        }


        public String getC2SClientRegion() {
            Object ref = this.c2SClientRegion_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.c2SClientRegion_ = s;
            }
            return s;
        }


        public ByteString getC2SClientRegionBytes() {
            Object ref = this.c2SClientRegion_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.c2SClientRegion_ = b;
                return b;
            }
            return (ByteString) ref;
        }


        public boolean hasC2SClientChannel() {
            return ((this.bitField0_ & 0x40) == 64);
        }


        public String getC2SClientChannel() {
            Object ref = this.c2SClientChannel_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.c2SClientChannel_ = s;
            }
            return s;
        }


        public ByteString getC2SClientChannelBytes() {
            Object ref = this.c2SClientChannel_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.c2SClientChannel_ = b;
                return b;
            }
            return (ByteString) ref;
        }


        public boolean hasC2SClientVersion() {
            return ((this.bitField0_ & 0x80) == 128);
        }


        public String getC2SClientVersion() {
            Object ref = this.c2SClientVersion_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.c2SClientVersion_ = s;
            }
            return s;
        }


        public ByteString getC2SClientVersionBytes() {
            Object ref = this.c2SClientVersion_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.c2SClientVersion_ = b;
                return b;
            }
            return (ByteString) ref;
        }


        private void initFields() {
            this.c2SUid_ = "";
            this.c2SToken_ = "";
            this.c2SLogicServerId_ = 0;
            this.c2SDeviceMac_ = "";
            this.c2SDeviceType_ = 0;
            this.c2SClientRegion_ = "";
            this.c2SClientChannel_ = "";
            this.c2SClientVersion_ = "";
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasC2SUid()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasC2SToken()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasC2SLogicServerId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeBytes(1, getC2SUidBytes());
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeBytes(2, getC2STokenBytes());
            }
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeInt32(3, this.c2SLogicServerId_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                output.writeBytes(4, getC2SDeviceMacBytes());
            }
            if ((this.bitField0_ & 0x10) == 16) {
                output.writeInt32(5, this.c2SDeviceType_);
            }
            if ((this.bitField0_ & 0x20) == 32) {
                output.writeBytes(6, getC2SClientRegionBytes());
            }
            if ((this.bitField0_ & 0x40) == 64) {
                output.writeBytes(7, getC2SClientChannelBytes());
            }
            if ((this.bitField0_ & 0x80) == 128) {
                output.writeBytes(8, getC2SClientVersionBytes());
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
                size += CodedOutputStream.computeBytesSize(1, getC2SUidBytes());
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeBytesSize(2, getC2STokenBytes());
            }
            if ((this.bitField0_ & 0x4) == 4) {
                size += CodedOutputStream.computeInt32Size(3, this.c2SLogicServerId_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                size += CodedOutputStream.computeBytesSize(4, getC2SDeviceMacBytes());
            }
            if ((this.bitField0_ & 0x10) == 16) {
                size += CodedOutputStream.computeInt32Size(5, this.c2SDeviceType_);
            }
            if ((this.bitField0_ & 0x20) == 32) {
                size += CodedOutputStream.computeBytesSize(6, getC2SClientRegionBytes());
            }
            if ((this.bitField0_ & 0x40) == 64) {
                size += CodedOutputStream.computeBytesSize(7, getC2SClientChannelBytes());
            }
            if ((this.bitField0_ & 0x80) == 128) {
                size += CodedOutputStream.computeBytesSize(8, getC2SClientVersionBytes());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static EntryRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (EntryRequest) PARSER.parseFrom(data);
        }


        public static EntryRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (EntryRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static EntryRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (EntryRequest) PARSER.parseFrom(data);
        }


        public static EntryRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (EntryRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static EntryRequest parseFrom(InputStream input) throws IOException {
            return (EntryRequest) PARSER.parseFrom(input);
        }


        public static EntryRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EntryRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static EntryRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (EntryRequest) PARSER.parseDelimitedFrom(input);
        }


        public static EntryRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EntryRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static EntryRequest parseFrom(CodedInputStream input) throws IOException {
            return (EntryRequest) PARSER.parseFrom(input);
        }


        public static EntryRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EntryRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(EntryRequest prototype) {
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
                implements EntryHandler.EntryRequestOrBuilder {
            private int bitField0_;

            private Object c2SUid_;

            private Object c2SToken_;

            private int c2SLogicServerId_;

            private Object c2SDeviceMac_;

            private int c2SDeviceType_;

            private Object c2SClientRegion_;

            private Object c2SClientChannel_;

            private Object c2SClientVersion_;


            public static final Descriptors.Descriptor getDescriptor() {
                return EntryHandler.internal_static_pomelo_connector_EntryRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return EntryHandler.internal_static_pomelo_connector_EntryRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(EntryHandler.EntryRequest.class, Builder.class);
            }


            private Builder() {
                this.c2SUid_ = "";
                this.c2SToken_ = "";
                this.c2SDeviceMac_ = "";
                this.c2SClientRegion_ = "";
                this.c2SClientChannel_ = "";
                this.c2SClientVersion_ = "";
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.c2SUid_ = "";
                this.c2SToken_ = "";
                this.c2SDeviceMac_ = "";
                this.c2SClientRegion_ = "";
                this.c2SClientChannel_ = "";
                this.c2SClientVersion_ = "";
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (EntryHandler.EntryRequest.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.c2SUid_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SToken_ = "";
                this.bitField0_ &= 0xFFFFFFFD;
                this.c2SLogicServerId_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.c2SDeviceMac_ = "";
                this.bitField0_ &= 0xFFFFFFF7;
                this.c2SDeviceType_ = 0;
                this.bitField0_ &= 0xFFFFFFEF;
                this.c2SClientRegion_ = "";
                this.bitField0_ &= 0xFFFFFFDF;
                this.c2SClientChannel_ = "";
                this.bitField0_ &= 0xFFFFFFBF;
                this.c2SClientVersion_ = "";
                this.bitField0_ &= 0xFFFFFF7F;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return EntryHandler.internal_static_pomelo_connector_EntryRequest_descriptor;
            }


            public EntryHandler.EntryRequest getDefaultInstanceForType() {
                return EntryHandler.EntryRequest.getDefaultInstance();
            }

            public EntryHandler.EntryRequest build() {
                EntryHandler.EntryRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public EntryHandler.EntryRequest buildPartial() {
                EntryHandler.EntryRequest result = new EntryHandler.EntryRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.c2SUid_ = this.c2SUid_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.c2SToken_ = this.c2SToken_;
                if ((from_bitField0_ & 0x4) == 4) {
                    to_bitField0_ |= 0x4;
                }
                result.c2SLogicServerId_ = this.c2SLogicServerId_;
                if ((from_bitField0_ & 0x8) == 8) {
                    to_bitField0_ |= 0x8;
                }
                result.c2SDeviceMac_ = this.c2SDeviceMac_;
                if ((from_bitField0_ & 0x10) == 16) {
                    to_bitField0_ |= 0x10;
                }
                result.c2SDeviceType_ = this.c2SDeviceType_;
                if ((from_bitField0_ & 0x20) == 32) {
                    to_bitField0_ |= 0x20;
                }
                result.c2SClientRegion_ = this.c2SClientRegion_;
                if ((from_bitField0_ & 0x40) == 64) {
                    to_bitField0_ |= 0x40;
                }
                result.c2SClientChannel_ = this.c2SClientChannel_;
                if ((from_bitField0_ & 0x80) == 128) {
                    to_bitField0_ |= 0x80;
                }
                result.c2SClientVersion_ = this.c2SClientVersion_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof EntryHandler.EntryRequest) {
                    return mergeFrom((EntryHandler.EntryRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(EntryHandler.EntryRequest other) {
                if (other == EntryHandler.EntryRequest.getDefaultInstance()) {
                    return this;
                }
                if (other.hasC2SUid()) {
                    this.bitField0_ |= 0x1;
                    this.c2SUid_ = other.c2SUid_;
                    onChanged();
                }
                if (other.hasC2SToken()) {
                    this.bitField0_ |= 0x2;
                    this.c2SToken_ = other.c2SToken_;
                    onChanged();
                }
                if (other.hasC2SLogicServerId()) {
                    setC2SLogicServerId(other.getC2SLogicServerId());
                }
                if (other.hasC2SDeviceMac()) {
                    this.bitField0_ |= 0x8;
                    this.c2SDeviceMac_ = other.c2SDeviceMac_;
                    onChanged();
                }
                if (other.hasC2SDeviceType()) {
                    setC2SDeviceType(other.getC2SDeviceType());
                }
                if (other.hasC2SClientRegion()) {
                    this.bitField0_ |= 0x20;
                    this.c2SClientRegion_ = other.c2SClientRegion_;
                    onChanged();
                }
                if (other.hasC2SClientChannel()) {
                    this.bitField0_ |= 0x40;
                    this.c2SClientChannel_ = other.c2SClientChannel_;
                    onChanged();
                }
                if (other.hasC2SClientVersion()) {
                    this.bitField0_ |= 0x80;
                    this.c2SClientVersion_ = other.c2SClientVersion_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasC2SUid()) {
                    return false;
                }
                if (!hasC2SToken()) {
                    return false;
                }
                if (!hasC2SLogicServerId()) {
                    return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                EntryHandler.EntryRequest parsedMessage = null;
                try {
                    parsedMessage = (EntryHandler.EntryRequest) EntryHandler.EntryRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (EntryHandler.EntryRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            public boolean hasC2SUid() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public String getC2SUid() {
                Object ref = this.c2SUid_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.c2SUid_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }

            public ByteString getC2SUidBytes() {
                Object ref = this.c2SUid_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.c2SUid_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setC2SUid(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x1;
                this.c2SUid_ = value;
                onChanged();
                return this;
            }

            public Builder clearC2SUid() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SUid_ = EntryHandler.EntryRequest.getDefaultInstance().getC2SUid();
                onChanged();
                return this;
            }

            public Builder setC2SUidBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x1;
                this.c2SUid_ = value;
                onChanged();
                return this;
            }

            public boolean hasC2SToken() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public String getC2SToken() {
                Object ref = this.c2SToken_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.c2SToken_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }

            public ByteString getC2STokenBytes() {
                Object ref = this.c2SToken_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.c2SToken_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setC2SToken(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x2;
                this.c2SToken_ = value;
                onChanged();
                return this;
            }

            public Builder clearC2SToken() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.c2SToken_ = EntryHandler.EntryRequest.getDefaultInstance().getC2SToken();
                onChanged();
                return this;
            }

            public Builder setC2STokenBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x2;
                this.c2SToken_ = value;
                onChanged();
                return this;
            }

            public boolean hasC2SLogicServerId() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public int getC2SLogicServerId() {
                return this.c2SLogicServerId_;
            }

            public Builder setC2SLogicServerId(int value) {
                this.bitField0_ |= 0x4;
                this.c2SLogicServerId_ = value;
                onChanged();
                return this;
            }

            public Builder clearC2SLogicServerId() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.c2SLogicServerId_ = 0;
                onChanged();
                return this;
            }

            public boolean hasC2SDeviceMac() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public String getC2SDeviceMac() {
                Object ref = this.c2SDeviceMac_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.c2SDeviceMac_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }

            public ByteString getC2SDeviceMacBytes() {
                Object ref = this.c2SDeviceMac_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.c2SDeviceMac_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setC2SDeviceMac(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x8;
                this.c2SDeviceMac_ = value;
                onChanged();
                return this;
            }

            public Builder clearC2SDeviceMac() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.c2SDeviceMac_ = EntryHandler.EntryRequest.getDefaultInstance().getC2SDeviceMac();
                onChanged();
                return this;
            }

            public Builder setC2SDeviceMacBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x8;
                this.c2SDeviceMac_ = value;
                onChanged();
                return this;
            }

            public boolean hasC2SDeviceType() {
                return ((this.bitField0_ & 0x10) == 16);
            }

            public int getC2SDeviceType() {
                return this.c2SDeviceType_;
            }

            public Builder setC2SDeviceType(int value) {
                this.bitField0_ |= 0x10;
                this.c2SDeviceType_ = value;
                onChanged();
                return this;
            }

            public Builder clearC2SDeviceType() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.c2SDeviceType_ = 0;
                onChanged();
                return this;
            }

            public boolean hasC2SClientRegion() {
                return ((this.bitField0_ & 0x20) == 32);
            }

            public String getC2SClientRegion() {
                Object ref = this.c2SClientRegion_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.c2SClientRegion_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }

            public ByteString getC2SClientRegionBytes() {
                Object ref = this.c2SClientRegion_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.c2SClientRegion_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setC2SClientRegion(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x20;
                this.c2SClientRegion_ = value;
                onChanged();
                return this;
            }

            public Builder clearC2SClientRegion() {
                this.bitField0_ &= 0xFFFFFFDF;
                this.c2SClientRegion_ = EntryHandler.EntryRequest.getDefaultInstance().getC2SClientRegion();
                onChanged();
                return this;
            }

            public Builder setC2SClientRegionBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x20;
                this.c2SClientRegion_ = value;
                onChanged();
                return this;
            }

            public boolean hasC2SClientChannel() {
                return ((this.bitField0_ & 0x40) == 64);
            }

            public String getC2SClientChannel() {
                Object ref = this.c2SClientChannel_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.c2SClientChannel_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }

            public ByteString getC2SClientChannelBytes() {
                Object ref = this.c2SClientChannel_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.c2SClientChannel_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setC2SClientChannel(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x40;
                this.c2SClientChannel_ = value;
                onChanged();
                return this;
            }

            public Builder clearC2SClientChannel() {
                this.bitField0_ &= 0xFFFFFFBF;
                this.c2SClientChannel_ = EntryHandler.EntryRequest.getDefaultInstance().getC2SClientChannel();
                onChanged();
                return this;
            }

            public Builder setC2SClientChannelBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x40;
                this.c2SClientChannel_ = value;
                onChanged();
                return this;
            }

            public boolean hasC2SClientVersion() {
                return ((this.bitField0_ & 0x80) == 128);
            }

            public String getC2SClientVersion() {
                Object ref = this.c2SClientVersion_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.c2SClientVersion_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }

            public ByteString getC2SClientVersionBytes() {
                Object ref = this.c2SClientVersion_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.c2SClientVersion_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setC2SClientVersion(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x80;
                this.c2SClientVersion_ = value;
                onChanged();
                return this;
            }

            public Builder clearC2SClientVersion() {
                this.bitField0_ &= 0xFFFFFF7F;
                this.c2SClientVersion_ = EntryHandler.EntryRequest.getDefaultInstance().getC2SClientVersion();
                onChanged();
                return this;
            }

            public Builder setC2SClientVersionBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x80;
                this.c2SClientVersion_ = value;
                onChanged();
                return this;
            }
        }
    }

    public static final class EntryResponse
            extends GeneratedMessage
            implements EntryResponseOrBuilder {
        private static final EntryResponse defaultInstance = new EntryResponse(true);
        private final UnknownFieldSet unknownFields;

        private EntryResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private EntryResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static EntryResponse getDefaultInstance() {
            return defaultInstance;
        }

        public EntryResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private EntryResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.s2CPlayers_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x4;
                            }
                            this.s2CPlayers_.add(input.readMessage(PlayerOuterClass.PlayerBasic.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x4) == 4) this.s2CPlayers_ = Collections.unmodifiableList(this.s2CPlayers_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return EntryHandler.internal_static_pomelo_connector_EntryResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return EntryHandler.internal_static_pomelo_connector_EntryResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(EntryResponse.class, Builder.class);
        }

        public static Parser<EntryResponse> PARSER = (Parser<EntryResponse>) new AbstractParser<EntryResponse>() {
            public EntryHandler.EntryResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new EntryHandler.EntryResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_PLAYERS_FIELD_NUMBER = 3;
        private List<PlayerOuterClass.PlayerBasic> s2CPlayers_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<EntryResponse> getParserForType() {
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

        public List<PlayerOuterClass.PlayerBasic> getS2CPlayersList() {
            return this.s2CPlayers_;
        }

        public List<? extends PlayerOuterClass.PlayerBasicOrBuilder> getS2CPlayersOrBuilderList() {
            return (List) this.s2CPlayers_;
        }

        public int getS2CPlayersCount() {
            return this.s2CPlayers_.size();
        }

        public PlayerOuterClass.PlayerBasic getS2CPlayers(int index) {
            return this.s2CPlayers_.get(index);
        }

        public PlayerOuterClass.PlayerBasicOrBuilder getS2CPlayersOrBuilder(int index) {
            return (PlayerOuterClass.PlayerBasicOrBuilder) this.s2CPlayers_.get(index);
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CPlayers_ = Collections.emptyList();
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
            for (int i = 0; i < getS2CPlayersCount(); i++) {
                if (!getS2CPlayers(i).isInitialized()) {
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
            for (int i = 0; i < this.s2CPlayers_.size(); i++)
                output.writeMessage(3, (MessageLite) this.s2CPlayers_.get(i));
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
            for (int i = 0; i < this.s2CPlayers_.size(); i++)
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.s2CPlayers_.get(i));
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static EntryResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (EntryResponse) PARSER.parseFrom(data);
        }

        public static EntryResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (EntryResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static EntryResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (EntryResponse) PARSER.parseFrom(data);
        }

        public static EntryResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (EntryResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static EntryResponse parseFrom(InputStream input) throws IOException {
            return (EntryResponse) PARSER.parseFrom(input);
        }

        public static EntryResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EntryResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static EntryResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (EntryResponse) PARSER.parseDelimitedFrom(input);
        }

        public static EntryResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EntryResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static EntryResponse parseFrom(CodedInputStream input) throws IOException {
            return (EntryResponse) PARSER.parseFrom(input);
        }

        public static EntryResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EntryResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(EntryResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements EntryHandler.EntryResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private List<PlayerOuterClass.PlayerBasic> s2CPlayers_;
            private RepeatedFieldBuilder<PlayerOuterClass.PlayerBasic, PlayerOuterClass.PlayerBasic.Builder, PlayerOuterClass.PlayerBasicOrBuilder> s2CPlayersBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return EntryHandler.internal_static_pomelo_connector_EntryResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return EntryHandler.internal_static_pomelo_connector_EntryResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(EntryHandler.EntryResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.s2CPlayers_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CPlayers_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (EntryHandler.EntryResponse.alwaysUseFieldBuilders)
                    getS2CPlayersFieldBuilder();
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
                if (this.s2CPlayersBuilder_ == null) {
                    this.s2CPlayers_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                } else {
                    this.s2CPlayersBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return EntryHandler.internal_static_pomelo_connector_EntryResponse_descriptor;
            }

            public EntryHandler.EntryResponse getDefaultInstanceForType() {
                return EntryHandler.EntryResponse.getDefaultInstance();
            }

            public EntryHandler.EntryResponse build() {
                EntryHandler.EntryResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public EntryHandler.EntryResponse buildPartial() {
                EntryHandler.EntryResponse result = new EntryHandler.EntryResponse(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.s2CMsg_ = this.s2CMsg_;
                if (this.s2CPlayersBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4) {
                        this.s2CPlayers_ = Collections.unmodifiableList(this.s2CPlayers_);
                        this.bitField0_ &= 0xFFFFFFFB;
                    }
                    result.s2CPlayers_ = this.s2CPlayers_;
                } else {
                    result.s2CPlayers_ = this.s2CPlayersBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof EntryHandler.EntryResponse)
                    return mergeFrom((EntryHandler.EntryResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(EntryHandler.EntryResponse other) {
                if (other == EntryHandler.EntryResponse.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (this.s2CPlayersBuilder_ == null) {
                    if (!other.s2CPlayers_.isEmpty()) {
                        if (this.s2CPlayers_.isEmpty()) {
                            this.s2CPlayers_ = other.s2CPlayers_;
                            this.bitField0_ &= 0xFFFFFFFB;
                        } else {
                            ensureS2CPlayersIsMutable();
                            this.s2CPlayers_.addAll(other.s2CPlayers_);
                        }
                        onChanged();
                    }
                } else if (!other.s2CPlayers_.isEmpty()) {
                    if (this.s2CPlayersBuilder_.isEmpty()) {
                        this.s2CPlayersBuilder_.dispose();
                        this.s2CPlayersBuilder_ = null;
                        this.s2CPlayers_ = other.s2CPlayers_;
                        this.bitField0_ &= 0xFFFFFFFB;
                        this.s2CPlayersBuilder_ = EntryHandler.EntryResponse.alwaysUseFieldBuilders ? getS2CPlayersFieldBuilder() : null;
                    } else {
                        this.s2CPlayersBuilder_.addAllMessages(other.s2CPlayers_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode())
                    return false;
                for (int i = 0; i < getS2CPlayersCount(); i++) {
                    if (!getS2CPlayers(i).isInitialized())
                        return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                EntryHandler.EntryResponse parsedMessage = null;
                try {
                    parsedMessage = (EntryHandler.EntryResponse) EntryHandler.EntryResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (EntryHandler.EntryResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = EntryHandler.EntryResponse.getDefaultInstance().getS2CMsg();
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

            private void ensureS2CPlayersIsMutable() {
                if ((this.bitField0_ & 0x4) != 4) {
                    this.s2CPlayers_ = new ArrayList<>(this.s2CPlayers_);
                    this.bitField0_ |= 0x4;
                }
            }

            public List<PlayerOuterClass.PlayerBasic> getS2CPlayersList() {
                if (this.s2CPlayersBuilder_ == null)
                    return Collections.unmodifiableList(this.s2CPlayers_);
                return this.s2CPlayersBuilder_.getMessageList();
            }

            public int getS2CPlayersCount() {
                if (this.s2CPlayersBuilder_ == null)
                    return this.s2CPlayers_.size();
                return this.s2CPlayersBuilder_.getCount();
            }

            public PlayerOuterClass.PlayerBasic getS2CPlayers(int index) {
                if (this.s2CPlayersBuilder_ == null)
                    return this.s2CPlayers_.get(index);
                return (PlayerOuterClass.PlayerBasic) this.s2CPlayersBuilder_.getMessage(index);
            }

            public Builder setS2CPlayers(int index, PlayerOuterClass.PlayerBasic value) {
                if (this.s2CPlayersBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CPlayersIsMutable();
                    this.s2CPlayers_.set(index, value);
                    onChanged();
                } else {
                    this.s2CPlayersBuilder_.setMessage(index, (GeneratedMessage) value);
                }
                return this;
            }

            public Builder setS2CPlayers(int index, PlayerOuterClass.PlayerBasic.Builder builderForValue) {
                if (this.s2CPlayersBuilder_ == null) {
                    ensureS2CPlayersIsMutable();
                    this.s2CPlayers_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CPlayersBuilder_.setMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addS2CPlayers(PlayerOuterClass.PlayerBasic value) {
                if (this.s2CPlayersBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CPlayersIsMutable();
                    this.s2CPlayers_.add(value);
                    onChanged();
                } else {
                    this.s2CPlayersBuilder_.addMessage((GeneratedMessage) value);
                }
                return this;
            }

            public Builder addS2CPlayers(int index, PlayerOuterClass.PlayerBasic value) {
                if (this.s2CPlayersBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CPlayersIsMutable();
                    this.s2CPlayers_.add(index, value);
                    onChanged();
                } else {
                    this.s2CPlayersBuilder_.addMessage(index, (GeneratedMessage) value);
                }
                return this;
            }

            public Builder addS2CPlayers(PlayerOuterClass.PlayerBasic.Builder builderForValue) {
                if (this.s2CPlayersBuilder_ == null) {
                    ensureS2CPlayersIsMutable();
                    this.s2CPlayers_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.s2CPlayersBuilder_.addMessage((GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addS2CPlayers(int index, PlayerOuterClass.PlayerBasic.Builder builderForValue) {
                if (this.s2CPlayersBuilder_ == null) {
                    ensureS2CPlayersIsMutable();
                    this.s2CPlayers_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CPlayersBuilder_.addMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addAllS2CPlayers(Iterable<? extends PlayerOuterClass.PlayerBasic> values) {
                if (this.s2CPlayersBuilder_ == null) {
                    ensureS2CPlayersIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.s2CPlayers_);
                    onChanged();
                } else {
                    this.s2CPlayersBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearS2CPlayers() {
                if (this.s2CPlayersBuilder_ == null) {
                    this.s2CPlayers_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                    onChanged();
                } else {
                    this.s2CPlayersBuilder_.clear();
                }
                return this;
            }

            public Builder removeS2CPlayers(int index) {
                if (this.s2CPlayersBuilder_ == null) {
                    ensureS2CPlayersIsMutable();
                    this.s2CPlayers_.remove(index);
                    onChanged();
                } else {
                    this.s2CPlayersBuilder_.remove(index);
                }
                return this;
            }

            public PlayerOuterClass.PlayerBasic.Builder getS2CPlayersBuilder(int index) {
                return (PlayerOuterClass.PlayerBasic.Builder) getS2CPlayersFieldBuilder().getBuilder(index);
            }

            public PlayerOuterClass.PlayerBasicOrBuilder getS2CPlayersOrBuilder(int index) {
                if (this.s2CPlayersBuilder_ == null)
                    return (PlayerOuterClass.PlayerBasicOrBuilder) this.s2CPlayers_.get(index);
                return (PlayerOuterClass.PlayerBasicOrBuilder) this.s2CPlayersBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends PlayerOuterClass.PlayerBasicOrBuilder> getS2CPlayersOrBuilderList() {
                if (this.s2CPlayersBuilder_ != null)
                    return this.s2CPlayersBuilder_.getMessageOrBuilderList();
                return (List) Collections.unmodifiableList(this.s2CPlayers_);
            }

            public PlayerOuterClass.PlayerBasic.Builder addS2CPlayersBuilder() {
                return (PlayerOuterClass.PlayerBasic.Builder) getS2CPlayersFieldBuilder().addBuilder((GeneratedMessage) PlayerOuterClass.PlayerBasic.getDefaultInstance());
            }

            public PlayerOuterClass.PlayerBasic.Builder addS2CPlayersBuilder(int index) {
                return (PlayerOuterClass.PlayerBasic.Builder) getS2CPlayersFieldBuilder().addBuilder(index, (GeneratedMessage) PlayerOuterClass.PlayerBasic.getDefaultInstance());
            }

            public List<PlayerOuterClass.PlayerBasic.Builder> getS2CPlayersBuilderList() {
                return getS2CPlayersFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<PlayerOuterClass.PlayerBasic, PlayerOuterClass.PlayerBasic.Builder, PlayerOuterClass.PlayerBasicOrBuilder> getS2CPlayersFieldBuilder() {
                if (this.s2CPlayersBuilder_ == null) {
                    this.s2CPlayersBuilder_ = new RepeatedFieldBuilder(this.s2CPlayers_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
                    this.s2CPlayers_ = null;
                }
                return this.s2CPlayersBuilder_;
            }
        }
    }

    public static final class BindPlayerRequest extends GeneratedMessage implements BindPlayerRequestOrBuilder {
        private static final BindPlayerRequest defaultInstance = new BindPlayerRequest(true);
        private final UnknownFieldSet unknownFields;

        private BindPlayerRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private BindPlayerRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static BindPlayerRequest getDefaultInstance() {
            return defaultInstance;
        }

        public BindPlayerRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BindPlayerRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.c2SPlayerId_ = bs;
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
            return EntryHandler.internal_static_pomelo_connector_BindPlayerRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return EntryHandler.internal_static_pomelo_connector_BindPlayerRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(BindPlayerRequest.class, Builder.class);
        }

        public static Parser<BindPlayerRequest> PARSER = (Parser<BindPlayerRequest>) new AbstractParser<BindPlayerRequest>() {
            public EntryHandler.BindPlayerRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new EntryHandler.BindPlayerRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_PLAYERID_FIELD_NUMBER = 1;
        private Object c2SPlayerId_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<BindPlayerRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasC2SPlayerId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public String getC2SPlayerId() {
            Object ref = this.c2SPlayerId_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.c2SPlayerId_ = s;
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

        static {
            defaultInstance.initFields();
        }


        private void initFields() {
            this.c2SPlayerId_ = "";
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasC2SPlayerId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeBytes(1, getC2SPlayerIdBytes());
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
                size += CodedOutputStream.computeBytesSize(1, getC2SPlayerIdBytes());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static BindPlayerRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (BindPlayerRequest) PARSER.parseFrom(data);
        }


        public static BindPlayerRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BindPlayerRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static BindPlayerRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (BindPlayerRequest) PARSER.parseFrom(data);
        }


        public static BindPlayerRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BindPlayerRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static BindPlayerRequest parseFrom(InputStream input) throws IOException {
            return (BindPlayerRequest) PARSER.parseFrom(input);
        }


        public static BindPlayerRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BindPlayerRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static BindPlayerRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (BindPlayerRequest) PARSER.parseDelimitedFrom(input);
        }


        public static BindPlayerRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BindPlayerRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static BindPlayerRequest parseFrom(CodedInputStream input) throws IOException {
            return (BindPlayerRequest) PARSER.parseFrom(input);
        }


        public static BindPlayerRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BindPlayerRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(BindPlayerRequest prototype) {
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
                implements EntryHandler.BindPlayerRequestOrBuilder {
            private int bitField0_;


            private Object c2SPlayerId_;


            public static final Descriptors.Descriptor getDescriptor() {
                return EntryHandler.internal_static_pomelo_connector_BindPlayerRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return EntryHandler.internal_static_pomelo_connector_BindPlayerRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(EntryHandler.BindPlayerRequest.class, Builder.class);
            }


            private Builder() {
                this.c2SPlayerId_ = "";
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.c2SPlayerId_ = "";
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (EntryHandler.BindPlayerRequest.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.c2SPlayerId_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return EntryHandler.internal_static_pomelo_connector_BindPlayerRequest_descriptor;
            }


            public EntryHandler.BindPlayerRequest getDefaultInstanceForType() {
                return EntryHandler.BindPlayerRequest.getDefaultInstance();
            }


            public EntryHandler.BindPlayerRequest build() {
                EntryHandler.BindPlayerRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public EntryHandler.BindPlayerRequest buildPartial() {
                EntryHandler.BindPlayerRequest result = new EntryHandler.BindPlayerRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.c2SPlayerId_ = this.c2SPlayerId_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof EntryHandler.BindPlayerRequest) {
                    return mergeFrom((EntryHandler.BindPlayerRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(EntryHandler.BindPlayerRequest other) {
                if (other == EntryHandler.BindPlayerRequest.getDefaultInstance()) {
                    return this;
                }
                if (other.hasC2SPlayerId()) {
                    this.bitField0_ |= 0x1;
                    this.c2SPlayerId_ = other.c2SPlayerId_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasC2SPlayerId()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                EntryHandler.BindPlayerRequest parsedMessage = null;
                try {
                    parsedMessage = (EntryHandler.BindPlayerRequest) EntryHandler.BindPlayerRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (EntryHandler.BindPlayerRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasC2SPlayerId() {
                return ((this.bitField0_ & 0x1) == 1);
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
                this.bitField0_ |= 0x1;
                this.c2SPlayerId_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SPlayerId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SPlayerId_ = EntryHandler.BindPlayerRequest.getDefaultInstance().getC2SPlayerId();
                onChanged();
                return this;
            }


            public Builder setC2SPlayerIdBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x1;
                this.c2SPlayerId_ = value;
                onChanged();
                return this;
            }
        }
    }


    public static final class BindPlayerResponse
            extends GeneratedMessage
            implements BindPlayerResponseOrBuilder {
        private static final BindPlayerResponse defaultInstance = new BindPlayerResponse(true);
        private final UnknownFieldSet unknownFields;

        private BindPlayerResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private BindPlayerResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static BindPlayerResponse getDefaultInstance() {
            return defaultInstance;
        }

        public BindPlayerResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BindPlayerResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString bs;
                    PlayerOuterClass.Player.Builder subBuilder;
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
                            if ((this.bitField0_ & 0x4) == 4) subBuilder = this.s2CPlayer_.toBuilder();
                            this.s2CPlayer_ = (PlayerOuterClass.Player) input.readMessage(PlayerOuterClass.Player.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.s2CPlayer_);
                                this.s2CPlayer_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 0x4;
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.s2CSceneType_ = input.readInt32();
                            break;
                        case 40:
                            this.bitField0_ |= 0x10;
                            this.s2CSceneUseAgent_ = input.readInt32();
                            break;
                        case 48:
                            this.bitField0_ |= 0x20;
                            this.s2CChangePkType_ = input.readInt32();
                            break;
                        case 56:
                            this.bitField0_ |= 0x40;
                            this.s2CRideMount_ = input.readInt32();
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
            return EntryHandler.internal_static_pomelo_connector_BindPlayerResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return EntryHandler.internal_static_pomelo_connector_BindPlayerResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(BindPlayerResponse.class, Builder.class);
        }

        public static Parser<BindPlayerResponse> PARSER = (Parser<BindPlayerResponse>) new AbstractParser<BindPlayerResponse>() {
            public EntryHandler.BindPlayerResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new EntryHandler.BindPlayerResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_PLAYER_FIELD_NUMBER = 3;
        private PlayerOuterClass.Player s2CPlayer_;
        public static final int S2C_SCENETYPE_FIELD_NUMBER = 4;
        private int s2CSceneType_;
        public static final int S2C_SCENEUSEAGENT_FIELD_NUMBER = 5;
        private int s2CSceneUseAgent_;
        public static final int S2C_CHANGEPKTYPE_FIELD_NUMBER = 6;
        private int s2CChangePkType_;
        public static final int S2C_RIDEMOUNT_FIELD_NUMBER = 7;
        private int s2CRideMount_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<BindPlayerResponse> getParserForType() {
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

        public boolean hasS2CPlayer() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public PlayerOuterClass.Player getS2CPlayer() {
            return this.s2CPlayer_;
        }

        public PlayerOuterClass.PlayerOrBuilder getS2CPlayerOrBuilder() {
            return (PlayerOuterClass.PlayerOrBuilder) this.s2CPlayer_;
        }

        public boolean hasS2CSceneType() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public int getS2CSceneType() {
            return this.s2CSceneType_;
        }

        public boolean hasS2CSceneUseAgent() {
            return ((this.bitField0_ & 0x10) == 16);
        }

        public int getS2CSceneUseAgent() {
            return this.s2CSceneUseAgent_;
        }

        public boolean hasS2CChangePkType() {
            return ((this.bitField0_ & 0x20) == 32);
        }

        public int getS2CChangePkType() {
            return this.s2CChangePkType_;
        }

        public boolean hasS2CRideMount() {
            return ((this.bitField0_ & 0x40) == 64);
        }

        public int getS2CRideMount() {
            return this.s2CRideMount_;
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CPlayer_ = PlayerOuterClass.Player.getDefaultInstance();
            this.s2CSceneType_ = 0;
            this.s2CSceneUseAgent_ = 0;
            this.s2CChangePkType_ = 0;
            this.s2CRideMount_ = 0;
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
            if (hasS2CPlayer() && !getS2CPlayer().isInitialized()) {
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
                output.writeMessage(3, (MessageLite) this.s2CPlayer_);
            if ((this.bitField0_ & 0x8) == 8)
                output.writeInt32(4, this.s2CSceneType_);
            if ((this.bitField0_ & 0x10) == 16)
                output.writeInt32(5, this.s2CSceneUseAgent_);
            if ((this.bitField0_ & 0x20) == 32)
                output.writeInt32(6, this.s2CChangePkType_);
            if ((this.bitField0_ & 0x40) == 64)
                output.writeInt32(7, this.s2CRideMount_);
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
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.s2CPlayer_);
            if ((this.bitField0_ & 0x8) == 8)
                size += CodedOutputStream.computeInt32Size(4, this.s2CSceneType_);
            if ((this.bitField0_ & 0x10) == 16)
                size += CodedOutputStream.computeInt32Size(5, this.s2CSceneUseAgent_);
            if ((this.bitField0_ & 0x20) == 32)
                size += CodedOutputStream.computeInt32Size(6, this.s2CChangePkType_);
            if ((this.bitField0_ & 0x40) == 64)
                size += CodedOutputStream.computeInt32Size(7, this.s2CRideMount_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static BindPlayerResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (BindPlayerResponse) PARSER.parseFrom(data);
        }

        public static BindPlayerResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BindPlayerResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static BindPlayerResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (BindPlayerResponse) PARSER.parseFrom(data);
        }

        public static BindPlayerResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BindPlayerResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static BindPlayerResponse parseFrom(InputStream input) throws IOException {
            return (BindPlayerResponse) PARSER.parseFrom(input);
        }

        public static BindPlayerResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BindPlayerResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static BindPlayerResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (BindPlayerResponse) PARSER.parseDelimitedFrom(input);
        }

        public static BindPlayerResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BindPlayerResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static BindPlayerResponse parseFrom(CodedInputStream input) throws IOException {
            return (BindPlayerResponse) PARSER.parseFrom(input);
        }

        public static BindPlayerResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BindPlayerResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(BindPlayerResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements EntryHandler.BindPlayerResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private PlayerOuterClass.Player s2CPlayer_;
            private SingleFieldBuilder<PlayerOuterClass.Player, PlayerOuterClass.Player.Builder, PlayerOuterClass.PlayerOrBuilder> s2CPlayerBuilder_;
            private int s2CSceneType_;
            private int s2CSceneUseAgent_;
            private int s2CChangePkType_;
            private int s2CRideMount_;

            public static final Descriptors.Descriptor getDescriptor() {
                return EntryHandler.internal_static_pomelo_connector_BindPlayerResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return EntryHandler.internal_static_pomelo_connector_BindPlayerResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(EntryHandler.BindPlayerResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.s2CPlayer_ = PlayerOuterClass.Player.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CPlayer_ = PlayerOuterClass.Player.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (EntryHandler.BindPlayerResponse.alwaysUseFieldBuilders)
                    getS2CPlayerFieldBuilder();
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
                if (this.s2CPlayerBuilder_ == null) {
                    this.s2CPlayer_ = PlayerOuterClass.Player.getDefaultInstance();
                } else {
                    this.s2CPlayerBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                this.s2CSceneType_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                this.s2CSceneUseAgent_ = 0;
                this.bitField0_ &= 0xFFFFFFEF;
                this.s2CChangePkType_ = 0;
                this.bitField0_ &= 0xFFFFFFDF;
                this.s2CRideMount_ = 0;
                this.bitField0_ &= 0xFFFFFFBF;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return EntryHandler.internal_static_pomelo_connector_BindPlayerResponse_descriptor;
            }

            public EntryHandler.BindPlayerResponse getDefaultInstanceForType() {
                return EntryHandler.BindPlayerResponse.getDefaultInstance();
            }

            public EntryHandler.BindPlayerResponse build() {
                EntryHandler.BindPlayerResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public EntryHandler.BindPlayerResponse buildPartial() {
                EntryHandler.BindPlayerResponse result = new EntryHandler.BindPlayerResponse(this);
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
                if (this.s2CPlayerBuilder_ == null) {
                    result.s2CPlayer_ = this.s2CPlayer_;
                } else {
                    result.s2CPlayer_ = (PlayerOuterClass.Player) this.s2CPlayerBuilder_.build();
                }
                if ((from_bitField0_ & 0x8) == 8)
                    to_bitField0_ |= 0x8;
                result.s2CSceneType_ = this.s2CSceneType_;
                if ((from_bitField0_ & 0x10) == 16)
                    to_bitField0_ |= 0x10;
                result.s2CSceneUseAgent_ = this.s2CSceneUseAgent_;
                if ((from_bitField0_ & 0x20) == 32)
                    to_bitField0_ |= 0x20;
                result.s2CChangePkType_ = this.s2CChangePkType_;
                if ((from_bitField0_ & 0x40) == 64)
                    to_bitField0_ |= 0x40;
                result.s2CRideMount_ = this.s2CRideMount_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof EntryHandler.BindPlayerResponse)
                    return mergeFrom((EntryHandler.BindPlayerResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(EntryHandler.BindPlayerResponse other) {
                if (other == EntryHandler.BindPlayerResponse.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (other.hasS2CPlayer())
                    mergeS2CPlayer(other.getS2CPlayer());
                if (other.hasS2CSceneType())
                    setS2CSceneType(other.getS2CSceneType());
                if (other.hasS2CSceneUseAgent())
                    setS2CSceneUseAgent(other.getS2CSceneUseAgent());
                if (other.hasS2CChangePkType())
                    setS2CChangePkType(other.getS2CChangePkType());
                if (other.hasS2CRideMount())
                    setS2CRideMount(other.getS2CRideMount());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode())
                    return false;
                if (hasS2CPlayer() && !getS2CPlayer().isInitialized())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                EntryHandler.BindPlayerResponse parsedMessage = null;
                try {
                    parsedMessage = (EntryHandler.BindPlayerResponse) EntryHandler.BindPlayerResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (EntryHandler.BindPlayerResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = EntryHandler.BindPlayerResponse.getDefaultInstance().getS2CMsg();
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

            public boolean hasS2CPlayer() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public PlayerOuterClass.Player getS2CPlayer() {
                if (this.s2CPlayerBuilder_ == null)
                    return this.s2CPlayer_;
                return (PlayerOuterClass.Player) this.s2CPlayerBuilder_.getMessage();
            }

            public Builder setS2CPlayer(PlayerOuterClass.Player value) {
                if (this.s2CPlayerBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    this.s2CPlayer_ = value;
                    onChanged();
                } else {
                    this.s2CPlayerBuilder_.setMessage((GeneratedMessage) value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder setS2CPlayer(PlayerOuterClass.Player.Builder builderForValue) {
                if (this.s2CPlayerBuilder_ == null) {
                    this.s2CPlayer_ = builderForValue.build();
                    onChanged();
                } else {
                    this.s2CPlayerBuilder_.setMessage((GeneratedMessage) builderForValue.build());
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder mergeS2CPlayer(PlayerOuterClass.Player value) {
                if (this.s2CPlayerBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4 && this.s2CPlayer_ != PlayerOuterClass.Player.getDefaultInstance()) {
                        this.s2CPlayer_ = PlayerOuterClass.Player.newBuilder(this.s2CPlayer_).mergeFrom(value).buildPartial();
                    } else {
                        this.s2CPlayer_ = value;
                    }
                    onChanged();
                } else {
                    this.s2CPlayerBuilder_.mergeFrom((GeneratedMessage) value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder clearS2CPlayer() {
                if (this.s2CPlayerBuilder_ == null) {
                    this.s2CPlayer_ = PlayerOuterClass.Player.getDefaultInstance();
                    onChanged();
                } else {
                    this.s2CPlayerBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public PlayerOuterClass.Player.Builder getS2CPlayerBuilder() {
                this.bitField0_ |= 0x4;
                onChanged();
                return (PlayerOuterClass.Player.Builder) getS2CPlayerFieldBuilder().getBuilder();
            }

            public PlayerOuterClass.PlayerOrBuilder getS2CPlayerOrBuilder() {
                if (this.s2CPlayerBuilder_ != null)
                    return (PlayerOuterClass.PlayerOrBuilder) this.s2CPlayerBuilder_.getMessageOrBuilder();
                return (PlayerOuterClass.PlayerOrBuilder) this.s2CPlayer_;
            }

            private SingleFieldBuilder<PlayerOuterClass.Player, PlayerOuterClass.Player.Builder, PlayerOuterClass.PlayerOrBuilder> getS2CPlayerFieldBuilder() {
                if (this.s2CPlayerBuilder_ == null) {
                    this.s2CPlayerBuilder_ = new SingleFieldBuilder((GeneratedMessage) getS2CPlayer(), getParentForChildren(), isClean());
                    this.s2CPlayer_ = null;
                }
                return this.s2CPlayerBuilder_;
            }

            public boolean hasS2CSceneType() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public int getS2CSceneType() {
                return this.s2CSceneType_;
            }

            public Builder setS2CSceneType(int value) {
                this.bitField0_ |= 0x8;
                this.s2CSceneType_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CSceneType() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.s2CSceneType_ = 0;
                onChanged();
                return this;
            }

            public boolean hasS2CSceneUseAgent() {
                return ((this.bitField0_ & 0x10) == 16);
            }

            public int getS2CSceneUseAgent() {
                return this.s2CSceneUseAgent_;
            }

            public Builder setS2CSceneUseAgent(int value) {
                this.bitField0_ |= 0x10;
                this.s2CSceneUseAgent_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CSceneUseAgent() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.s2CSceneUseAgent_ = 0;
                onChanged();
                return this;
            }

            public boolean hasS2CChangePkType() {
                return ((this.bitField0_ & 0x20) == 32);
            }

            public int getS2CChangePkType() {
                return this.s2CChangePkType_;
            }

            public Builder setS2CChangePkType(int value) {
                this.bitField0_ |= 0x20;
                this.s2CChangePkType_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CChangePkType() {
                this.bitField0_ &= 0xFFFFFFDF;
                this.s2CChangePkType_ = 0;
                onChanged();
                return this;
            }

            public boolean hasS2CRideMount() {
                return ((this.bitField0_ & 0x40) == 64);
            }

            public int getS2CRideMount() {
                return this.s2CRideMount_;
            }

            public Builder setS2CRideMount(int value) {
                this.bitField0_ |= 0x40;
                this.s2CRideMount_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CRideMount() {
                this.bitField0_ &= 0xFFFFFFBF;
                this.s2CRideMount_ = 0;
                onChanged();
                return this;
            }
        }
    }

    public static final class LoginQueuePush extends GeneratedMessage implements LoginQueuePushOrBuilder {
        private static final LoginQueuePush defaultInstance = new LoginQueuePush(true);
        private final UnknownFieldSet unknownFields;

        private LoginQueuePush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private LoginQueuePush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static LoginQueuePush getDefaultInstance() {
            return defaultInstance;
        }

        public LoginQueuePush getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private LoginQueuePush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.num_ = input.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.time_ = input.readInt32();
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
            return EntryHandler.internal_static_pomelo_connector_LoginQueuePush_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return EntryHandler.internal_static_pomelo_connector_LoginQueuePush_fieldAccessorTable.ensureFieldAccessorsInitialized(LoginQueuePush.class, Builder.class);
        }

        public static Parser<LoginQueuePush> PARSER = (Parser<LoginQueuePush>) new AbstractParser<LoginQueuePush>() {
            public EntryHandler.LoginQueuePush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new EntryHandler.LoginQueuePush(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int NUM_FIELD_NUMBER = 1;
        private int num_;
        public static final int TIME_FIELD_NUMBER = 2;
        private int time_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<LoginQueuePush> getParserForType() {
            return PARSER;
        }

        public boolean hasNum() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getNum() {
            return this.num_;
        }

        public boolean hasTime() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public int getTime() {
            return this.time_;
        }

        private void initFields() {
            this.num_ = 0;
            this.time_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasNum()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasTime()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.num_);
            if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.time_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.num_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(2, this.time_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static LoginQueuePush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (LoginQueuePush) PARSER.parseFrom(data);
        }

        public static LoginQueuePush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (LoginQueuePush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static LoginQueuePush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (LoginQueuePush) PARSER.parseFrom(data);
        }

        public static LoginQueuePush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (LoginQueuePush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static LoginQueuePush parseFrom(InputStream input) throws IOException {
            return (LoginQueuePush) PARSER.parseFrom(input);
        }

        static {
            defaultInstance.initFields();
        }

        public static LoginQueuePush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LoginQueuePush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static LoginQueuePush parseDelimitedFrom(InputStream input) throws IOException {
            return (LoginQueuePush) PARSER.parseDelimitedFrom(input);
        }

        public static LoginQueuePush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LoginQueuePush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static LoginQueuePush parseFrom(CodedInputStream input) throws IOException {
            return (LoginQueuePush) PARSER.parseFrom(input);
        }

        public static LoginQueuePush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LoginQueuePush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(LoginQueuePush prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements EntryHandler.LoginQueuePushOrBuilder {
            private int bitField0_;
            private int num_;
            private int time_;

            public static final Descriptors.Descriptor getDescriptor() {
                return EntryHandler.internal_static_pomelo_connector_LoginQueuePush_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return EntryHandler.internal_static_pomelo_connector_LoginQueuePush_fieldAccessorTable.ensureFieldAccessorsInitialized(EntryHandler.LoginQueuePush.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (EntryHandler.LoginQueuePush.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.num_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.time_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return EntryHandler.internal_static_pomelo_connector_LoginQueuePush_descriptor;
            }

            public EntryHandler.LoginQueuePush getDefaultInstanceForType() {
                return EntryHandler.LoginQueuePush.getDefaultInstance();
            }

            public EntryHandler.LoginQueuePush build() {
                EntryHandler.LoginQueuePush result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public EntryHandler.LoginQueuePush buildPartial() {
                EntryHandler.LoginQueuePush result = new EntryHandler.LoginQueuePush(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.num_ = this.num_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.time_ = this.time_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof EntryHandler.LoginQueuePush)
                    return mergeFrom((EntryHandler.LoginQueuePush) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(EntryHandler.LoginQueuePush other) {
                if (other == EntryHandler.LoginQueuePush.getDefaultInstance())
                    return this;
                if (other.hasNum())
                    setNum(other.getNum());
                if (other.hasTime())
                    setTime(other.getTime());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasNum())
                    return false;
                if (!hasTime())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                EntryHandler.LoginQueuePush parsedMessage = null;
                try {
                    parsedMessage = (EntryHandler.LoginQueuePush) EntryHandler.LoginQueuePush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (EntryHandler.LoginQueuePush) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null)
                        mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasNum() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getNum() {
                return this.num_;
            }

            public Builder setNum(int value) {
                this.bitField0_ |= 0x1;
                this.num_ = value;
                onChanged();
                return this;
            }

            public Builder clearNum() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.num_ = 0;
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
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }


    static {
        String[] descriptorData = {"\n\022entryHandler.proto\022\020pomelo.connector\032\fcommon.proto\032\fplayer.proto\"\023\n\021GetSysTimeRequest\"I\n\022GetSysTimeResponse\022\020\n\bs2c_code\030\001 \002(\005\022\020\n\bs2c_time\030\002 \002(\t\022\017\n\007s2c_msg\030\003 \001(\t\"Ì\001\n\fEntryRequest\022\017\n\007c2s_uid\030\001 \002(\t\022\021\n\tc2s_token\030\002 \002(\t\022\031\n\021c2s_logicServerId\030\003 \002(\005\022\025\n\rc2s_deviceMac\030\004 \001(\t\022\026\n\016c2s_deviceType\030\005 \001(\005\022\030\n\020c2s_clientRegion\030\006 \001(\t\022\031\n\021c2s_clientChannel\030\007 \001(\t\022\031\n\021c2s_clientVersion\030\b \001(\t\"c\n\rEntryResponse\022\020\n\bs2c_code\030\001", " \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022/\n\013s2c_players\030\003 \003(\0132\032.pomelo.player.PlayerBasic\")\n\021BindPlayerRequest\022\024\n\fc2s_playerId\030\001 \002(\t\"Å\001\n\022BindPlayerResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022)\n\ns2c_player\030\003 \001(\0132\025.pomelo.player.Player\022\025\n\rs2c_sceneType\030\004 \001(\005\022\031\n\021s2c_sceneUseAgent\030\005 \001(\005\022\030\n\020s2c_changePkType\030\006 \001(\005\022\025\n\rs2c_rideMount\030\007 \001(\005\"+\n\016LoginQueuePush\022\013\n\003num\030\001 \002(\005\022\f\n\004time\030\002 \002(\0052\002\n\fentryHandler\022O\n\fentryRequest\022\036.pomelo", ".connector.EntryRequest\032\037.pomelo.connector.EntryResponse\022^\n\021bindPlayerRequest\022#.pomelo.connector.BindPlayerRequest\032$.pomelo.connector.BindPlayerResponse\022^\n\021getSysTimeRequest\022#.pomelo.connector.GetSysTimeRequest\032$.pomelo.connector.GetSysTimeResponse2M\n\tentryPush\022@\n\016loginQueuePush\022 .pomelo.connector.LoginQueuePush\032\f.pomelo.Void"};


        Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root) {
                EntryHandler.descriptor = root;
                return null;
            }
        };

        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[]{

                Common.getDescriptor(),
                PlayerOuterClass.getDescriptor()}, assigner);
    }

    private static final Descriptors.Descriptor internal_static_pomelo_connector_GetSysTimeRequest_descriptor = getDescriptor().getMessageTypes().get(0);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_connector_GetSysTimeRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_connector_GetSysTimeRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_connector_GetSysTimeResponse_descriptor = getDescriptor().getMessageTypes().get(1);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_connector_GetSysTimeResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_connector_GetSysTimeResponse_descriptor, new String[]{"S2CCode", "S2CTime", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_connector_EntryRequest_descriptor = getDescriptor().getMessageTypes().get(2);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_connector_EntryRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_connector_EntryRequest_descriptor, new String[]{"C2SUid", "C2SToken", "C2SLogicServerId", "C2SDeviceMac", "C2SDeviceType", "C2SClientRegion", "C2SClientChannel", "C2SClientVersion"});


    private static final Descriptors.Descriptor internal_static_pomelo_connector_EntryResponse_descriptor = getDescriptor().getMessageTypes().get(3);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_connector_EntryResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_connector_EntryResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CPlayers"});


    private static final Descriptors.Descriptor internal_static_pomelo_connector_BindPlayerRequest_descriptor = getDescriptor().getMessageTypes().get(4);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_connector_BindPlayerRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_connector_BindPlayerRequest_descriptor, new String[]{"C2SPlayerId"});


    private static final Descriptors.Descriptor internal_static_pomelo_connector_BindPlayerResponse_descriptor = getDescriptor().getMessageTypes().get(5);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_connector_BindPlayerResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_connector_BindPlayerResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CPlayer", "S2CSceneType", "S2CSceneUseAgent", "S2CChangePkType", "S2CRideMount"});


    private static final Descriptors.Descriptor internal_static_pomelo_connector_LoginQueuePush_descriptor = getDescriptor().getMessageTypes().get(6);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_connector_LoginQueuePush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_connector_LoginQueuePush_descriptor, new String[]{"Num", "Time"});
    private static Descriptors.FileDescriptor descriptor;

    static {
        Common.getDescriptor();
        PlayerOuterClass.getDescriptor();
    }

    public static interface LoginQueuePushOrBuilder extends MessageOrBuilder {
        boolean hasNum();

        int getNum();

        boolean hasTime();

        int getTime();
    }

    public static interface BindPlayerResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasS2CPlayer();

        PlayerOuterClass.Player getS2CPlayer();

        PlayerOuterClass.PlayerOrBuilder getS2CPlayerOrBuilder();

        boolean hasS2CSceneType();

        int getS2CSceneType();

        boolean hasS2CSceneUseAgent();

        int getS2CSceneUseAgent();

        boolean hasS2CChangePkType();

        int getS2CChangePkType();

        boolean hasS2CRideMount();

        int getS2CRideMount();
    }

    public static interface BindPlayerRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2SPlayerId();

        String getC2SPlayerId();

        ByteString getC2SPlayerIdBytes();
    }

    public static interface EntryResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        List<PlayerOuterClass.PlayerBasic> getS2CPlayersList();

        PlayerOuterClass.PlayerBasic getS2CPlayers(int param1Int);

        int getS2CPlayersCount();

        List<? extends PlayerOuterClass.PlayerBasicOrBuilder> getS2CPlayersOrBuilderList();

        PlayerOuterClass.PlayerBasicOrBuilder getS2CPlayersOrBuilder(int param1Int);
    }

    public static interface EntryRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2SUid();

        String getC2SUid();

        ByteString getC2SUidBytes();

        boolean hasC2SToken();

        String getC2SToken();

        ByteString getC2STokenBytes();

        boolean hasC2SLogicServerId();

        int getC2SLogicServerId();

        boolean hasC2SDeviceMac();

        String getC2SDeviceMac();

        ByteString getC2SDeviceMacBytes();

        boolean hasC2SDeviceType();

        int getC2SDeviceType();

        boolean hasC2SClientRegion();

        String getC2SClientRegion();

        ByteString getC2SClientRegionBytes();

        boolean hasC2SClientChannel();

        String getC2SClientChannel();

        ByteString getC2SClientChannelBytes();

        boolean hasC2SClientVersion();

        String getC2SClientVersion();

        ByteString getC2SClientVersionBytes();
    }

    public static interface GetSysTimeResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CTime();

        String getS2CTime();

        ByteString getS2CTimeBytes();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface GetSysTimeRequestOrBuilder extends MessageOrBuilder {
    }
}


