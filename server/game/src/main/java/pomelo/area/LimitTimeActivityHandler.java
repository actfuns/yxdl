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

import pomelo.Common;


public final class LimitTimeActivityHandler {
    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static final class ActivityInfo
            extends GeneratedMessage
            implements ActivityInfoOrBuilder {
        private static final ActivityInfo defaultInstance = new ActivityInfo(true);
        private final UnknownFieldSet unknownFields;

        private ActivityInfo(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private ActivityInfo(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static ActivityInfo getDefaultInstance() {
            return defaultInstance;
        }

        public ActivityInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ActivityInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.isOpen_ = input.readInt32();
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
            return LimitTimeActivityHandler.internal_static_pomelo_area_ActivityInfo_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return LimitTimeActivityHandler.internal_static_pomelo_area_ActivityInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ActivityInfo.class, Builder.class);
        }

        public static Parser<ActivityInfo> PARSER = (Parser<ActivityInfo>) new AbstractParser<ActivityInfo>() {
            public LimitTimeActivityHandler.ActivityInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new LimitTimeActivityHandler.ActivityInfo(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int ID_FIELD_NUMBER = 1;
        private int id_;
        public static final int ISOPEN_FIELD_NUMBER = 2;
        private int isOpen_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<ActivityInfo> getParserForType() {
            return PARSER;
        }

        public boolean hasId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getId() {
            return this.id_;
        }

        public boolean hasIsOpen() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public int getIsOpen() {
            return this.isOpen_;
        }

        private void initFields() {
            this.id_ = 0;
            this.isOpen_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasIsOpen()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.id_);
            if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.isOpen_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.id_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(2, this.isOpen_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static ActivityInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ActivityInfo) PARSER.parseFrom(data);
        }

        public static ActivityInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ActivityInfo) PARSER.parseFrom(data, extensionRegistry);
        }

        public static ActivityInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ActivityInfo) PARSER.parseFrom(data);
        }

        public static ActivityInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ActivityInfo) PARSER.parseFrom(data, extensionRegistry);
        }

        public static ActivityInfo parseFrom(InputStream input) throws IOException {
            return (ActivityInfo) PARSER.parseFrom(input);
        }

        public static ActivityInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ActivityInfo) PARSER.parseFrom(input, extensionRegistry);
        }

        public static ActivityInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (ActivityInfo) PARSER.parseDelimitedFrom(input);
        }

        public static ActivityInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ActivityInfo) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static ActivityInfo parseFrom(CodedInputStream input) throws IOException {
            return (ActivityInfo) PARSER.parseFrom(input);
        }

        public static ActivityInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ActivityInfo) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(ActivityInfo prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements LimitTimeActivityHandler.ActivityInfoOrBuilder {
            private int bitField0_;
            private int id_;
            private int isOpen_;

            public static final Descriptors.Descriptor getDescriptor() {
                return LimitTimeActivityHandler.internal_static_pomelo_area_ActivityInfo_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return LimitTimeActivityHandler.internal_static_pomelo_area_ActivityInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(LimitTimeActivityHandler.ActivityInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (LimitTimeActivityHandler.ActivityInfo.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.id_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.isOpen_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return LimitTimeActivityHandler.internal_static_pomelo_area_ActivityInfo_descriptor;
            }

            public LimitTimeActivityHandler.ActivityInfo getDefaultInstanceForType() {
                return LimitTimeActivityHandler.ActivityInfo.getDefaultInstance();
            }

            public LimitTimeActivityHandler.ActivityInfo build() {
                LimitTimeActivityHandler.ActivityInfo result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public LimitTimeActivityHandler.ActivityInfo buildPartial() {
                LimitTimeActivityHandler.ActivityInfo result = new LimitTimeActivityHandler.ActivityInfo(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.id_ = this.id_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.isOpen_ = this.isOpen_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof LimitTimeActivityHandler.ActivityInfo)
                    return mergeFrom((LimitTimeActivityHandler.ActivityInfo) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(LimitTimeActivityHandler.ActivityInfo other) {
                if (other == LimitTimeActivityHandler.ActivityInfo.getDefaultInstance()) return this;
                if (other.hasId()) setId(other.getId());
                if (other.hasIsOpen()) setIsOpen(other.getIsOpen());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasId()) return false;
                if (!hasIsOpen()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                LimitTimeActivityHandler.ActivityInfo parsedMessage = null;
                try {
                    parsedMessage = (LimitTimeActivityHandler.ActivityInfo) LimitTimeActivityHandler.ActivityInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (LimitTimeActivityHandler.ActivityInfo) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
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

            public boolean hasIsOpen() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getIsOpen() {
                return this.isOpen_;
            }

            public Builder setIsOpen(int value) {
                this.bitField0_ |= 0x2;
                this.isOpen_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsOpen() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.isOpen_ = 0;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class GetLimitTimeActivityInfoRequest
            extends GeneratedMessage
            implements GetLimitTimeActivityInfoRequestOrBuilder {
        private static final GetLimitTimeActivityInfoRequest defaultInstance = new GetLimitTimeActivityInfoRequest(true);
        private final UnknownFieldSet unknownFields;

        private GetLimitTimeActivityInfoRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetLimitTimeActivityInfoRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetLimitTimeActivityInfoRequest getDefaultInstance() {
            return defaultInstance;
        }

        public GetLimitTimeActivityInfoRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetLimitTimeActivityInfoRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return LimitTimeActivityHandler.internal_static_pomelo_area_GetLimitTimeActivityInfoRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return LimitTimeActivityHandler.internal_static_pomelo_area_GetLimitTimeActivityInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetLimitTimeActivityInfoRequest.class, Builder.class);
        }

        public static Parser<GetLimitTimeActivityInfoRequest> PARSER = (Parser<GetLimitTimeActivityInfoRequest>) new AbstractParser<GetLimitTimeActivityInfoRequest>() {
            public LimitTimeActivityHandler.GetLimitTimeActivityInfoRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new LimitTimeActivityHandler.GetLimitTimeActivityInfoRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetLimitTimeActivityInfoRequest> getParserForType() {
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

        public static GetLimitTimeActivityInfoRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetLimitTimeActivityInfoRequest) PARSER.parseFrom(data);
        }

        public static GetLimitTimeActivityInfoRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetLimitTimeActivityInfoRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetLimitTimeActivityInfoRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetLimitTimeActivityInfoRequest) PARSER.parseFrom(data);
        }

        public static GetLimitTimeActivityInfoRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetLimitTimeActivityInfoRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetLimitTimeActivityInfoRequest parseFrom(InputStream input) throws IOException {
            return (GetLimitTimeActivityInfoRequest) PARSER.parseFrom(input);
        }

        public static GetLimitTimeActivityInfoRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetLimitTimeActivityInfoRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static GetLimitTimeActivityInfoRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (GetLimitTimeActivityInfoRequest) PARSER.parseDelimitedFrom(input);
        }

        public static GetLimitTimeActivityInfoRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetLimitTimeActivityInfoRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static GetLimitTimeActivityInfoRequest parseFrom(CodedInputStream input) throws IOException {
            return (GetLimitTimeActivityInfoRequest) PARSER.parseFrom(input);
        }

        public static GetLimitTimeActivityInfoRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetLimitTimeActivityInfoRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(GetLimitTimeActivityInfoRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements LimitTimeActivityHandler.GetLimitTimeActivityInfoRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return LimitTimeActivityHandler.internal_static_pomelo_area_GetLimitTimeActivityInfoRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return LimitTimeActivityHandler.internal_static_pomelo_area_GetLimitTimeActivityInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(LimitTimeActivityHandler.GetLimitTimeActivityInfoRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (LimitTimeActivityHandler.GetLimitTimeActivityInfoRequest.alwaysUseFieldBuilders) ;
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
                return LimitTimeActivityHandler.internal_static_pomelo_area_GetLimitTimeActivityInfoRequest_descriptor;
            }

            public LimitTimeActivityHandler.GetLimitTimeActivityInfoRequest getDefaultInstanceForType() {
                return LimitTimeActivityHandler.GetLimitTimeActivityInfoRequest.getDefaultInstance();
            }

            public LimitTimeActivityHandler.GetLimitTimeActivityInfoRequest build() {
                LimitTimeActivityHandler.GetLimitTimeActivityInfoRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public LimitTimeActivityHandler.GetLimitTimeActivityInfoRequest buildPartial() {
                LimitTimeActivityHandler.GetLimitTimeActivityInfoRequest result = new LimitTimeActivityHandler.GetLimitTimeActivityInfoRequest(this);
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof LimitTimeActivityHandler.GetLimitTimeActivityInfoRequest)
                    return mergeFrom((LimitTimeActivityHandler.GetLimitTimeActivityInfoRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(LimitTimeActivityHandler.GetLimitTimeActivityInfoRequest other) {
                if (other == LimitTimeActivityHandler.GetLimitTimeActivityInfoRequest.getDefaultInstance()) return this;
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                LimitTimeActivityHandler.GetLimitTimeActivityInfoRequest parsedMessage = null;
                try {
                    parsedMessage = (LimitTimeActivityHandler.GetLimitTimeActivityInfoRequest) LimitTimeActivityHandler.GetLimitTimeActivityInfoRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (LimitTimeActivityHandler.GetLimitTimeActivityInfoRequest) e.getUnfinishedMessage();
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


    public static final class GetLimitTimeActivityInfoResponse
            extends GeneratedMessage
            implements GetLimitTimeActivityInfoResponseOrBuilder {
        private static final GetLimitTimeActivityInfoResponse defaultInstance = new GetLimitTimeActivityInfoResponse(true);
        private final UnknownFieldSet unknownFields;

        private GetLimitTimeActivityInfoResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetLimitTimeActivityInfoResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetLimitTimeActivityInfoResponse getDefaultInstance() {
            return defaultInstance;
        }

        public GetLimitTimeActivityInfoResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetLimitTimeActivityInfoResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.s2CLtActivity_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x4;
                            }
                            this.s2CLtActivity_.add(input.readMessage(LimitTimeActivityHandler.ActivityInfo.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x4) == 4)
                    this.s2CLtActivity_ = Collections.unmodifiableList(this.s2CLtActivity_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LimitTimeActivityHandler.internal_static_pomelo_area_GetLimitTimeActivityInfoResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return LimitTimeActivityHandler.internal_static_pomelo_area_GetLimitTimeActivityInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetLimitTimeActivityInfoResponse.class, Builder.class);
        }

        public static Parser<GetLimitTimeActivityInfoResponse> PARSER = (Parser<GetLimitTimeActivityInfoResponse>) new AbstractParser<GetLimitTimeActivityInfoResponse>() {
            public LimitTimeActivityHandler.GetLimitTimeActivityInfoResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new LimitTimeActivityHandler.GetLimitTimeActivityInfoResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_LTACTIVITY_FIELD_NUMBER = 3;
        private List<LimitTimeActivityHandler.ActivityInfo> s2CLtActivity_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetLimitTimeActivityInfoResponse> getParserForType() {
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


        public List<LimitTimeActivityHandler.ActivityInfo> getS2CLtActivityList() {
            return this.s2CLtActivity_;
        }


        public List<? extends LimitTimeActivityHandler.ActivityInfoOrBuilder> getS2CLtActivityOrBuilderList() {
            return (List) this.s2CLtActivity_;
        }


        public int getS2CLtActivityCount() {
            return this.s2CLtActivity_.size();
        }


        public LimitTimeActivityHandler.ActivityInfo getS2CLtActivity(int index) {
            return this.s2CLtActivity_.get(index);
        }


        public LimitTimeActivityHandler.ActivityInfoOrBuilder getS2CLtActivityOrBuilder(int index) {
            return this.s2CLtActivity_.get(index);
        }


        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CLtActivity_ = Collections.emptyList();
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
            for (int i = 0; i < getS2CLtActivityCount(); i++) {
                if (!getS2CLtActivity(i).isInitialized()) {
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
            for (int i = 0; i < this.s2CLtActivity_.size(); i++) {
                output.writeMessage(3, (MessageLite) this.s2CLtActivity_.get(i));
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
            for (int i = 0; i < this.s2CLtActivity_.size(); i++) {
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.s2CLtActivity_.get(i));
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static GetLimitTimeActivityInfoResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetLimitTimeActivityInfoResponse) PARSER.parseFrom(data);
        }


        public static GetLimitTimeActivityInfoResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetLimitTimeActivityInfoResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetLimitTimeActivityInfoResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetLimitTimeActivityInfoResponse) PARSER.parseFrom(data);
        }


        public static GetLimitTimeActivityInfoResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetLimitTimeActivityInfoResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetLimitTimeActivityInfoResponse parseFrom(InputStream input) throws IOException {
            return (GetLimitTimeActivityInfoResponse) PARSER.parseFrom(input);
        }


        public static GetLimitTimeActivityInfoResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetLimitTimeActivityInfoResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static GetLimitTimeActivityInfoResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (GetLimitTimeActivityInfoResponse) PARSER.parseDelimitedFrom(input);
        }


        public static GetLimitTimeActivityInfoResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetLimitTimeActivityInfoResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static GetLimitTimeActivityInfoResponse parseFrom(CodedInputStream input) throws IOException {
            return (GetLimitTimeActivityInfoResponse) PARSER.parseFrom(input);
        }


        public static GetLimitTimeActivityInfoResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetLimitTimeActivityInfoResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(GetLimitTimeActivityInfoResponse prototype) {
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
                implements LimitTimeActivityHandler.GetLimitTimeActivityInfoResponseOrBuilder {
            private int bitField0_;


            private int s2CCode_;


            private Object s2CMsg_;


            private List<LimitTimeActivityHandler.ActivityInfo> s2CLtActivity_;


            private RepeatedFieldBuilder<LimitTimeActivityHandler.ActivityInfo, LimitTimeActivityHandler.ActivityInfo.Builder, LimitTimeActivityHandler.ActivityInfoOrBuilder> s2CLtActivityBuilder_;


            public static final Descriptors.Descriptor getDescriptor() {
                return LimitTimeActivityHandler.internal_static_pomelo_area_GetLimitTimeActivityInfoResponse_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return LimitTimeActivityHandler.internal_static_pomelo_area_GetLimitTimeActivityInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(LimitTimeActivityHandler.GetLimitTimeActivityInfoResponse.class, Builder.class);
            }


            private Builder() {
                this.s2CMsg_ = "";
                this.s2CLtActivity_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CLtActivity_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (LimitTimeActivityHandler.GetLimitTimeActivityInfoResponse.alwaysUseFieldBuilders) {
                    getS2CLtActivityFieldBuilder();
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
                if (this.s2CLtActivityBuilder_ == null) {
                    this.s2CLtActivity_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                } else {
                    this.s2CLtActivityBuilder_.clear();
                }
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return LimitTimeActivityHandler.internal_static_pomelo_area_GetLimitTimeActivityInfoResponse_descriptor;
            }


            public LimitTimeActivityHandler.GetLimitTimeActivityInfoResponse getDefaultInstanceForType() {
                return LimitTimeActivityHandler.GetLimitTimeActivityInfoResponse.getDefaultInstance();
            }


            public LimitTimeActivityHandler.GetLimitTimeActivityInfoResponse build() {
                LimitTimeActivityHandler.GetLimitTimeActivityInfoResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public LimitTimeActivityHandler.GetLimitTimeActivityInfoResponse buildPartial() {
                LimitTimeActivityHandler.GetLimitTimeActivityInfoResponse result = new LimitTimeActivityHandler.GetLimitTimeActivityInfoResponse(this);
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
                if (this.s2CLtActivityBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4) {
                        this.s2CLtActivity_ = Collections.unmodifiableList(this.s2CLtActivity_);
                        this.bitField0_ &= 0xFFFFFFFB;
                    }
                    result.s2CLtActivity_ = this.s2CLtActivity_;
                } else {
                    result.s2CLtActivity_ = this.s2CLtActivityBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof LimitTimeActivityHandler.GetLimitTimeActivityInfoResponse) {
                    return mergeFrom((LimitTimeActivityHandler.GetLimitTimeActivityInfoResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(LimitTimeActivityHandler.GetLimitTimeActivityInfoResponse other) {
                if (other == LimitTimeActivityHandler.GetLimitTimeActivityInfoResponse.getDefaultInstance()) {
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
                if (this.s2CLtActivityBuilder_ == null) {
                    if (!other.s2CLtActivity_.isEmpty()) {
                        if (this.s2CLtActivity_.isEmpty()) {
                            this.s2CLtActivity_ = other.s2CLtActivity_;
                            this.bitField0_ &= 0xFFFFFFFB;
                        } else {
                            ensureS2CLtActivityIsMutable();
                            this.s2CLtActivity_.addAll(other.s2CLtActivity_);
                        }
                        onChanged();
                    }
                } else if (!other.s2CLtActivity_.isEmpty()) {
                    if (this.s2CLtActivityBuilder_.isEmpty()) {
                        this.s2CLtActivityBuilder_.dispose();
                        this.s2CLtActivityBuilder_ = null;
                        this.s2CLtActivity_ = other.s2CLtActivity_;
                        this.bitField0_ &= 0xFFFFFFFB;
                        this.s2CLtActivityBuilder_ = LimitTimeActivityHandler.GetLimitTimeActivityInfoResponse.alwaysUseFieldBuilders ? getS2CLtActivityFieldBuilder() : null;
                    } else {
                        this.s2CLtActivityBuilder_.addAllMessages(other.s2CLtActivity_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasS2CCode()) {
                    return false;
                }
                for (int i = 0; i < getS2CLtActivityCount(); i++) {
                    if (!getS2CLtActivity(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                LimitTimeActivityHandler.GetLimitTimeActivityInfoResponse parsedMessage = null;
                try {
                    parsedMessage = (LimitTimeActivityHandler.GetLimitTimeActivityInfoResponse) LimitTimeActivityHandler.GetLimitTimeActivityInfoResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (LimitTimeActivityHandler.GetLimitTimeActivityInfoResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = LimitTimeActivityHandler.GetLimitTimeActivityInfoResponse.getDefaultInstance().getS2CMsg();
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


            private void ensureS2CLtActivityIsMutable() {
                if ((this.bitField0_ & 0x4) != 4) {
                    this.s2CLtActivity_ = new ArrayList<>(this.s2CLtActivity_);
                    this.bitField0_ |= 0x4;
                }
            }


            public List<LimitTimeActivityHandler.ActivityInfo> getS2CLtActivityList() {
                if (this.s2CLtActivityBuilder_ == null) {
                    return Collections.unmodifiableList(this.s2CLtActivity_);
                }
                return this.s2CLtActivityBuilder_.getMessageList();
            }


            public int getS2CLtActivityCount() {
                if (this.s2CLtActivityBuilder_ == null) {
                    return this.s2CLtActivity_.size();
                }
                return this.s2CLtActivityBuilder_.getCount();
            }


            public LimitTimeActivityHandler.ActivityInfo getS2CLtActivity(int index) {
                if (this.s2CLtActivityBuilder_ == null) {
                    return this.s2CLtActivity_.get(index);
                }
                return (LimitTimeActivityHandler.ActivityInfo) this.s2CLtActivityBuilder_.getMessage(index);
            }


            public Builder setS2CLtActivity(int index, LimitTimeActivityHandler.ActivityInfo value) {
                if (this.s2CLtActivityBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureS2CLtActivityIsMutable();
                    this.s2CLtActivity_.set(index, value);
                    onChanged();
                } else {
                    this.s2CLtActivityBuilder_.setMessage(index, value);
                }
                return this;
            }


            public Builder setS2CLtActivity(int index, LimitTimeActivityHandler.ActivityInfo.Builder builderForValue) {
                if (this.s2CLtActivityBuilder_ == null) {
                    ensureS2CLtActivityIsMutable();
                    this.s2CLtActivity_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CLtActivityBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }


            public Builder addS2CLtActivity(LimitTimeActivityHandler.ActivityInfo value) {
                if (this.s2CLtActivityBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureS2CLtActivityIsMutable();
                    this.s2CLtActivity_.add(value);
                    onChanged();
                } else {
                    this.s2CLtActivityBuilder_.addMessage(value);
                }
                return this;
            }


            public Builder addS2CLtActivity(int index, LimitTimeActivityHandler.ActivityInfo value) {
                if (this.s2CLtActivityBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureS2CLtActivityIsMutable();
                    this.s2CLtActivity_.add(index, value);
                    onChanged();
                } else {
                    this.s2CLtActivityBuilder_.addMessage(index, value);
                }
                return this;
            }


            public Builder addS2CLtActivity(LimitTimeActivityHandler.ActivityInfo.Builder builderForValue) {
                if (this.s2CLtActivityBuilder_ == null) {
                    ensureS2CLtActivityIsMutable();
                    this.s2CLtActivity_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.s2CLtActivityBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }


            public Builder addS2CLtActivity(int index, LimitTimeActivityHandler.ActivityInfo.Builder builderForValue) {
                if (this.s2CLtActivityBuilder_ == null) {
                    ensureS2CLtActivityIsMutable();
                    this.s2CLtActivity_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CLtActivityBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }


            public Builder addAllS2CLtActivity(Iterable<? extends LimitTimeActivityHandler.ActivityInfo> values) {
                if (this.s2CLtActivityBuilder_ == null) {
                    ensureS2CLtActivityIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.s2CLtActivity_);
                    onChanged();
                } else {
                    this.s2CLtActivityBuilder_.addAllMessages(values);
                }
                return this;
            }


            public Builder clearS2CLtActivity() {
                if (this.s2CLtActivityBuilder_ == null) {
                    this.s2CLtActivity_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                    onChanged();
                } else {
                    this.s2CLtActivityBuilder_.clear();
                }
                return this;
            }


            public Builder removeS2CLtActivity(int index) {
                if (this.s2CLtActivityBuilder_ == null) {
                    ensureS2CLtActivityIsMutable();
                    this.s2CLtActivity_.remove(index);
                    onChanged();
                } else {
                    this.s2CLtActivityBuilder_.remove(index);
                }
                return this;
            }


            public LimitTimeActivityHandler.ActivityInfo.Builder getS2CLtActivityBuilder(int index) {
                return (LimitTimeActivityHandler.ActivityInfo.Builder) getS2CLtActivityFieldBuilder().getBuilder(index);
            }


            public LimitTimeActivityHandler.ActivityInfoOrBuilder getS2CLtActivityOrBuilder(int index) {
                if (this.s2CLtActivityBuilder_ == null) {
                    return this.s2CLtActivity_.get(index);
                }
                return (LimitTimeActivityHandler.ActivityInfoOrBuilder) this.s2CLtActivityBuilder_.getMessageOrBuilder(index);
            }


            public List<? extends LimitTimeActivityHandler.ActivityInfoOrBuilder> getS2CLtActivityOrBuilderList() {
                if (this.s2CLtActivityBuilder_ != null) {
                    return this.s2CLtActivityBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList((List) this.s2CLtActivity_);
            }


            public LimitTimeActivityHandler.ActivityInfo.Builder addS2CLtActivityBuilder() {
                return (LimitTimeActivityHandler.ActivityInfo.Builder) getS2CLtActivityFieldBuilder().addBuilder(LimitTimeActivityHandler.ActivityInfo.getDefaultInstance());
            }


            public LimitTimeActivityHandler.ActivityInfo.Builder addS2CLtActivityBuilder(int index) {
                return (LimitTimeActivityHandler.ActivityInfo.Builder) getS2CLtActivityFieldBuilder().addBuilder(index, LimitTimeActivityHandler.ActivityInfo.getDefaultInstance());
            }


            public List<LimitTimeActivityHandler.ActivityInfo.Builder> getS2CLtActivityBuilderList() {
                return getS2CLtActivityFieldBuilder().getBuilderList();
            }


            private RepeatedFieldBuilder<LimitTimeActivityHandler.ActivityInfo, LimitTimeActivityHandler.ActivityInfo.Builder, LimitTimeActivityHandler.ActivityInfoOrBuilder> getS2CLtActivityFieldBuilder() {
                if (this.s2CLtActivityBuilder_ == null) {
                    this.s2CLtActivityBuilder_ = new RepeatedFieldBuilder(this.s2CLtActivity_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
                    this.s2CLtActivity_ = null;
                }
                return this.s2CLtActivityBuilder_;
            }
        }
    }


    public static final class LTActivityInfoPush
            extends GeneratedMessage
            implements LTActivityInfoPushOrBuilder {
        private static final LTActivityInfoPush defaultInstance = new LTActivityInfoPush(true);
        private final UnknownFieldSet unknownFields;

        private LTActivityInfoPush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private LTActivityInfoPush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static LTActivityInfoPush getDefaultInstance() {
            return defaultInstance;
        }

        public LTActivityInfoPush getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private LTActivityInfoPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.s2CLtActivity_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x2;
                            }
                            this.s2CLtActivity_.add(input.readMessage(LimitTimeActivityHandler.ActivityInfo.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x2) == 2)
                    this.s2CLtActivity_ = Collections.unmodifiableList(this.s2CLtActivity_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LimitTimeActivityHandler.internal_static_pomelo_area_LTActivityInfoPush_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return LimitTimeActivityHandler.internal_static_pomelo_area_LTActivityInfoPush_fieldAccessorTable.ensureFieldAccessorsInitialized(LTActivityInfoPush.class, Builder.class);
        }

        public static Parser<LTActivityInfoPush> PARSER = (Parser<LTActivityInfoPush>) new AbstractParser<LTActivityInfoPush>() {
            public LimitTimeActivityHandler.LTActivityInfoPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new LimitTimeActivityHandler.LTActivityInfoPush(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_LTACTIVITY_FIELD_NUMBER = 2;
        private List<LimitTimeActivityHandler.ActivityInfo> s2CLtActivity_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<LTActivityInfoPush> getParserForType() {
            return PARSER;
        }

        public boolean hasS2CCode() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getS2CCode() {
            return this.s2CCode_;
        }

        public List<LimitTimeActivityHandler.ActivityInfo> getS2CLtActivityList() {
            return this.s2CLtActivity_;
        }

        public List<? extends LimitTimeActivityHandler.ActivityInfoOrBuilder> getS2CLtActivityOrBuilderList() {
            return (List) this.s2CLtActivity_;
        }

        public int getS2CLtActivityCount() {
            return this.s2CLtActivity_.size();
        }

        public LimitTimeActivityHandler.ActivityInfo getS2CLtActivity(int index) {
            return this.s2CLtActivity_.get(index);
        }

        public LimitTimeActivityHandler.ActivityInfoOrBuilder getS2CLtActivityOrBuilder(int index) {
            return this.s2CLtActivity_.get(index);
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CLtActivity_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasS2CCode()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (int i = 0; i < getS2CLtActivityCount(); i++) {
                if (!getS2CLtActivity(i).isInitialized()) {
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
            for (int i = 0; i < this.s2CLtActivity_.size(); i++)
                output.writeMessage(2, (MessageLite) this.s2CLtActivity_.get(i));
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            for (int i = 0; i < this.s2CLtActivity_.size(); i++)
                size += CodedOutputStream.computeMessageSize(2, (MessageLite) this.s2CLtActivity_.get(i));
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static LTActivityInfoPush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (LTActivityInfoPush) PARSER.parseFrom(data);
        }

        public static LTActivityInfoPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (LTActivityInfoPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static LTActivityInfoPush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (LTActivityInfoPush) PARSER.parseFrom(data);
        }

        public static LTActivityInfoPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (LTActivityInfoPush) PARSER.parseFrom(data, extensionRegistry);
        }

        static {
            defaultInstance.initFields();
        }

        public static LTActivityInfoPush parseFrom(InputStream input) throws IOException {
            return (LTActivityInfoPush) PARSER.parseFrom(input);
        }

        public static LTActivityInfoPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LTActivityInfoPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static LTActivityInfoPush parseDelimitedFrom(InputStream input) throws IOException {
            return (LTActivityInfoPush) PARSER.parseDelimitedFrom(input);
        }

        public static LTActivityInfoPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LTActivityInfoPush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static LTActivityInfoPush parseFrom(CodedInputStream input) throws IOException {
            return (LTActivityInfoPush) PARSER.parseFrom(input);
        }

        public static LTActivityInfoPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LTActivityInfoPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(LTActivityInfoPush prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements LimitTimeActivityHandler.LTActivityInfoPushOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private List<LimitTimeActivityHandler.ActivityInfo> s2CLtActivity_;
            private RepeatedFieldBuilder<LimitTimeActivityHandler.ActivityInfo, LimitTimeActivityHandler.ActivityInfo.Builder, LimitTimeActivityHandler.ActivityInfoOrBuilder> s2CLtActivityBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return LimitTimeActivityHandler.internal_static_pomelo_area_LTActivityInfoPush_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return LimitTimeActivityHandler.internal_static_pomelo_area_LTActivityInfoPush_fieldAccessorTable.ensureFieldAccessorsInitialized(LimitTimeActivityHandler.LTActivityInfoPush.class, Builder.class);
            }

            private Builder() {
                this.s2CLtActivity_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CLtActivity_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (LimitTimeActivityHandler.LTActivityInfoPush.alwaysUseFieldBuilders) getS2CLtActivityFieldBuilder();
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.s2CCode_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                if (this.s2CLtActivityBuilder_ == null) {
                    this.s2CLtActivity_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFD;
                } else {
                    this.s2CLtActivityBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return LimitTimeActivityHandler.internal_static_pomelo_area_LTActivityInfoPush_descriptor;
            }

            public LimitTimeActivityHandler.LTActivityInfoPush getDefaultInstanceForType() {
                return LimitTimeActivityHandler.LTActivityInfoPush.getDefaultInstance();
            }

            public LimitTimeActivityHandler.LTActivityInfoPush build() {
                LimitTimeActivityHandler.LTActivityInfoPush result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public LimitTimeActivityHandler.LTActivityInfoPush buildPartial() {
                LimitTimeActivityHandler.LTActivityInfoPush result = new LimitTimeActivityHandler.LTActivityInfoPush(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if (this.s2CLtActivityBuilder_ == null) {
                    if ((this.bitField0_ & 0x2) == 2) {
                        this.s2CLtActivity_ = Collections.unmodifiableList(this.s2CLtActivity_);
                        this.bitField0_ &= 0xFFFFFFFD;
                    }
                    result.s2CLtActivity_ = this.s2CLtActivity_;
                } else {
                    result.s2CLtActivity_ = this.s2CLtActivityBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof LimitTimeActivityHandler.LTActivityInfoPush)
                    return mergeFrom((LimitTimeActivityHandler.LTActivityInfoPush) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(LimitTimeActivityHandler.LTActivityInfoPush other) {
                if (other == LimitTimeActivityHandler.LTActivityInfoPush.getDefaultInstance()) return this;
                if (other.hasS2CCode()) setS2CCode(other.getS2CCode());
                if (this.s2CLtActivityBuilder_ == null) {
                    if (!other.s2CLtActivity_.isEmpty()) {
                        if (this.s2CLtActivity_.isEmpty()) {
                            this.s2CLtActivity_ = other.s2CLtActivity_;
                            this.bitField0_ &= 0xFFFFFFFD;
                        } else {
                            ensureS2CLtActivityIsMutable();
                            this.s2CLtActivity_.addAll(other.s2CLtActivity_);
                        }
                        onChanged();
                    }
                } else if (!other.s2CLtActivity_.isEmpty()) {
                    if (this.s2CLtActivityBuilder_.isEmpty()) {
                        this.s2CLtActivityBuilder_.dispose();
                        this.s2CLtActivityBuilder_ = null;
                        this.s2CLtActivity_ = other.s2CLtActivity_;
                        this.bitField0_ &= 0xFFFFFFFD;
                        this.s2CLtActivityBuilder_ = LimitTimeActivityHandler.LTActivityInfoPush.alwaysUseFieldBuilders ? getS2CLtActivityFieldBuilder() : null;
                    } else {
                        this.s2CLtActivityBuilder_.addAllMessages(other.s2CLtActivity_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode()) return false;
                for (int i = 0; i < getS2CLtActivityCount(); i++) {
                    if (!getS2CLtActivity(i).isInitialized()) return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                LimitTimeActivityHandler.LTActivityInfoPush parsedMessage = null;
                try {
                    parsedMessage = (LimitTimeActivityHandler.LTActivityInfoPush) LimitTimeActivityHandler.LTActivityInfoPush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (LimitTimeActivityHandler.LTActivityInfoPush) e.getUnfinishedMessage();
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

            private void ensureS2CLtActivityIsMutable() {
                if ((this.bitField0_ & 0x2) != 2) {
                    this.s2CLtActivity_ = new ArrayList<>(this.s2CLtActivity_);
                    this.bitField0_ |= 0x2;
                }
            }

            public List<LimitTimeActivityHandler.ActivityInfo> getS2CLtActivityList() {
                if (this.s2CLtActivityBuilder_ == null) return Collections.unmodifiableList(this.s2CLtActivity_);
                return this.s2CLtActivityBuilder_.getMessageList();
            }

            public int getS2CLtActivityCount() {
                if (this.s2CLtActivityBuilder_ == null) return this.s2CLtActivity_.size();
                return this.s2CLtActivityBuilder_.getCount();
            }

            public LimitTimeActivityHandler.ActivityInfo getS2CLtActivity(int index) {
                if (this.s2CLtActivityBuilder_ == null) return this.s2CLtActivity_.get(index);
                return (LimitTimeActivityHandler.ActivityInfo) this.s2CLtActivityBuilder_.getMessage(index);
            }

            public Builder setS2CLtActivity(int index, LimitTimeActivityHandler.ActivityInfo value) {
                if (this.s2CLtActivityBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureS2CLtActivityIsMutable();
                    this.s2CLtActivity_.set(index, value);
                    onChanged();
                } else {
                    this.s2CLtActivityBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setS2CLtActivity(int index, LimitTimeActivityHandler.ActivityInfo.Builder builderForValue) {
                if (this.s2CLtActivityBuilder_ == null) {
                    ensureS2CLtActivityIsMutable();
                    this.s2CLtActivity_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CLtActivityBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addS2CLtActivity(LimitTimeActivityHandler.ActivityInfo value) {
                if (this.s2CLtActivityBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureS2CLtActivityIsMutable();
                    this.s2CLtActivity_.add(value);
                    onChanged();
                } else {
                    this.s2CLtActivityBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addS2CLtActivity(int index, LimitTimeActivityHandler.ActivityInfo value) {
                if (this.s2CLtActivityBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureS2CLtActivityIsMutable();
                    this.s2CLtActivity_.add(index, value);
                    onChanged();
                } else {
                    this.s2CLtActivityBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addS2CLtActivity(LimitTimeActivityHandler.ActivityInfo.Builder builderForValue) {
                if (this.s2CLtActivityBuilder_ == null) {
                    ensureS2CLtActivityIsMutable();
                    this.s2CLtActivity_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.s2CLtActivityBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addS2CLtActivity(int index, LimitTimeActivityHandler.ActivityInfo.Builder builderForValue) {
                if (this.s2CLtActivityBuilder_ == null) {
                    ensureS2CLtActivityIsMutable();
                    this.s2CLtActivity_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CLtActivityBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllS2CLtActivity(Iterable<? extends LimitTimeActivityHandler.ActivityInfo> values) {
                if (this.s2CLtActivityBuilder_ == null) {
                    ensureS2CLtActivityIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.s2CLtActivity_);
                    onChanged();
                } else {
                    this.s2CLtActivityBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearS2CLtActivity() {
                if (this.s2CLtActivityBuilder_ == null) {
                    this.s2CLtActivity_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFD;
                    onChanged();
                } else {
                    this.s2CLtActivityBuilder_.clear();
                }
                return this;
            }

            public Builder removeS2CLtActivity(int index) {
                if (this.s2CLtActivityBuilder_ == null) {
                    ensureS2CLtActivityIsMutable();
                    this.s2CLtActivity_.remove(index);
                    onChanged();
                } else {
                    this.s2CLtActivityBuilder_.remove(index);
                }
                return this;
            }

            public LimitTimeActivityHandler.ActivityInfo.Builder getS2CLtActivityBuilder(int index) {
                return (LimitTimeActivityHandler.ActivityInfo.Builder) getS2CLtActivityFieldBuilder().getBuilder(index);
            }

            public LimitTimeActivityHandler.ActivityInfoOrBuilder getS2CLtActivityOrBuilder(int index) {
                if (this.s2CLtActivityBuilder_ == null) return this.s2CLtActivity_.get(index);
                return (LimitTimeActivityHandler.ActivityInfoOrBuilder) this.s2CLtActivityBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends LimitTimeActivityHandler.ActivityInfoOrBuilder> getS2CLtActivityOrBuilderList() {
                if (this.s2CLtActivityBuilder_ != null) return this.s2CLtActivityBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.s2CLtActivity_);
            }

            public LimitTimeActivityHandler.ActivityInfo.Builder addS2CLtActivityBuilder() {
                return (LimitTimeActivityHandler.ActivityInfo.Builder) getS2CLtActivityFieldBuilder().addBuilder(LimitTimeActivityHandler.ActivityInfo.getDefaultInstance());
            }

            public LimitTimeActivityHandler.ActivityInfo.Builder addS2CLtActivityBuilder(int index) {
                return (LimitTimeActivityHandler.ActivityInfo.Builder) getS2CLtActivityFieldBuilder().addBuilder(index, LimitTimeActivityHandler.ActivityInfo.getDefaultInstance());
            }

            public List<LimitTimeActivityHandler.ActivityInfo.Builder> getS2CLtActivityBuilderList() {
                return getS2CLtActivityFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<LimitTimeActivityHandler.ActivityInfo, LimitTimeActivityHandler.ActivityInfo.Builder, LimitTimeActivityHandler.ActivityInfoOrBuilder> getS2CLtActivityFieldBuilder() {
                if (this.s2CLtActivityBuilder_ == null) {
                    this.s2CLtActivityBuilder_ = new RepeatedFieldBuilder(this.s2CLtActivity_, ((this.bitField0_ & 0x2) == 2), getParentForChildren(), isClean());
                    this.s2CLtActivity_ = null;
                }
                return this.s2CLtActivityBuilder_;
            }
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }


    static {
        String[] descriptorData = {"\n\036limitTimeActivityHandler.proto\022\013pomelo.area\032\fcommon.proto\"*\n\fActivityInfo\022\n\n\002id\030\001 \002(\005\022\016\n\006isOpen\030\002 \002(\005\"!\n\037GetLimitTimeActivityInfoRequest\"x\n GetLimitTimeActivityInfoResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\0221\n\016s2c_ltActivity\030\003 \003(\0132\031.pomelo.area.ActivityInfo\"Y\n\022LTActivityInfoPush\022\020\n\bs2c_code\030\001 \002(\005\0221\n\016s2c_ltActivity\030\002 \003(\0132\031.pomelo.area.ActivityInfo2\001\n\030limitTimeActivityHandler\022~\n\037getLimitTimeActi", "vityInfoRequest\022,.pomelo.area.GetLimitTimeActivityInfoRequest\032-.pomelo.area.GetLimitTimeActivityInfoResponse2\\\n\025limitTimeActivityPush\022C\n\022ltActivityInfoPush\022\037.pomelo.area.LTActivityInfoPush\032\f.pomelo.Void"};


        Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root) {
                LimitTimeActivityHandler.descriptor = root;
                return null;
            }
        };

        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[]{

                Common.getDescriptor()}, assigner);
    }

    private static final Descriptors.Descriptor internal_static_pomelo_area_ActivityInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ActivityInfo_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ActivityInfo_descriptor, new String[]{"Id", "IsOpen"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetLimitTimeActivityInfoRequest_descriptor = getDescriptor().getMessageTypes().get(1);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetLimitTimeActivityInfoRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetLimitTimeActivityInfoRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetLimitTimeActivityInfoResponse_descriptor = getDescriptor().getMessageTypes().get(2);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetLimitTimeActivityInfoResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetLimitTimeActivityInfoResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CLtActivity"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_LTActivityInfoPush_descriptor = getDescriptor().getMessageTypes().get(3);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_LTActivityInfoPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_LTActivityInfoPush_descriptor, new String[]{"S2CCode", "S2CLtActivity"});
    private static Descriptors.FileDescriptor descriptor;

    static {
        Common.getDescriptor();
    }

    public static interface LTActivityInfoPushOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        List<LimitTimeActivityHandler.ActivityInfo> getS2CLtActivityList();

        LimitTimeActivityHandler.ActivityInfo getS2CLtActivity(int param1Int);

        int getS2CLtActivityCount();

        List<? extends LimitTimeActivityHandler.ActivityInfoOrBuilder> getS2CLtActivityOrBuilderList();

        LimitTimeActivityHandler.ActivityInfoOrBuilder getS2CLtActivityOrBuilder(int param1Int);
    }

    public static interface GetLimitTimeActivityInfoResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        List<LimitTimeActivityHandler.ActivityInfo> getS2CLtActivityList();

        LimitTimeActivityHandler.ActivityInfo getS2CLtActivity(int param1Int);

        int getS2CLtActivityCount();

        List<? extends LimitTimeActivityHandler.ActivityInfoOrBuilder> getS2CLtActivityOrBuilderList();

        LimitTimeActivityHandler.ActivityInfoOrBuilder getS2CLtActivityOrBuilder(int param1Int);
    }

    public static interface GetLimitTimeActivityInfoRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface ActivityInfoOrBuilder extends MessageOrBuilder {
        boolean hasId();

        int getId();

        boolean hasIsOpen();

        int getIsOpen();
    }
}


