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
import pomelo.task.TaskOuterClass;


public final class TaskHandler {
    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static final class AcceptTaskRequest
            extends GeneratedMessage
            implements AcceptTaskRequestOrBuilder {
        private static final AcceptTaskRequest defaultInstance = new AcceptTaskRequest(true);
        private final UnknownFieldSet unknownFields;

        private AcceptTaskRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private AcceptTaskRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static AcceptTaskRequest getDefaultInstance() {
            return defaultInstance;
        }

        public AcceptTaskRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AcceptTaskRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.c2STemplateId_ = input.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.c2SKind_ = input.readInt32();
                            break;
                        case 26:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x4;
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
            return TaskHandler.internal_static_pomelo_area_AcceptTaskRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TaskHandler.internal_static_pomelo_area_AcceptTaskRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(AcceptTaskRequest.class, Builder.class);
        }

        public static Parser<AcceptTaskRequest> PARSER = (Parser<AcceptTaskRequest>) new AbstractParser<AcceptTaskRequest>() {
            public TaskHandler.AcceptTaskRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TaskHandler.AcceptTaskRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_TEMPLATEID_FIELD_NUMBER = 1;
        private int c2STemplateId_;
        public static final int C2S_KIND_FIELD_NUMBER = 2;
        private int c2SKind_;
        public static final int C2S_NPCID_FIELD_NUMBER = 3;
        private Object c2SNpcId_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<AcceptTaskRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasC2STemplateId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getC2STemplateId() {
            return this.c2STemplateId_;
        }

        public boolean hasC2SKind() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        static {
            defaultInstance.initFields();
        }


        public int getC2SKind() {
            return this.c2SKind_;
        }


        public boolean hasC2SNpcId() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public String getC2SNpcId() {
            Object ref = this.c2SNpcId_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.c2SNpcId_ = s;
            }
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
            this.c2STemplateId_ = 0;
            this.c2SKind_ = 0;
            this.c2SNpcId_ = "";
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasC2STemplateId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasC2SKind()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasC2SNpcId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeInt32(1, this.c2STemplateId_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeInt32(2, this.c2SKind_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeBytes(3, getC2SNpcIdBytes());
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
                size += CodedOutputStream.computeInt32Size(1, this.c2STemplateId_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeInt32Size(2, this.c2SKind_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                size += CodedOutputStream.computeBytesSize(3, getC2SNpcIdBytes());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static AcceptTaskRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (AcceptTaskRequest) PARSER.parseFrom(data);
        }


        public static AcceptTaskRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AcceptTaskRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static AcceptTaskRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (AcceptTaskRequest) PARSER.parseFrom(data);
        }


        public static AcceptTaskRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AcceptTaskRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static AcceptTaskRequest parseFrom(InputStream input) throws IOException {
            return (AcceptTaskRequest) PARSER.parseFrom(input);
        }


        public static AcceptTaskRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AcceptTaskRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static AcceptTaskRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (AcceptTaskRequest) PARSER.parseDelimitedFrom(input);
        }


        public static AcceptTaskRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AcceptTaskRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static AcceptTaskRequest parseFrom(CodedInputStream input) throws IOException {
            return (AcceptTaskRequest) PARSER.parseFrom(input);
        }


        public static AcceptTaskRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AcceptTaskRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(AcceptTaskRequest prototype) {
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
                implements TaskHandler.AcceptTaskRequestOrBuilder {
            private int bitField0_;


            private int c2STemplateId_;


            private int c2SKind_;


            private Object c2SNpcId_;


            public static final Descriptors.Descriptor getDescriptor() {
                return TaskHandler.internal_static_pomelo_area_AcceptTaskRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return TaskHandler.internal_static_pomelo_area_AcceptTaskRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(TaskHandler.AcceptTaskRequest.class, Builder.class);
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
                if (TaskHandler.AcceptTaskRequest.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.c2STemplateId_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SKind_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                this.c2SNpcId_ = "";
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return TaskHandler.internal_static_pomelo_area_AcceptTaskRequest_descriptor;
            }


            public TaskHandler.AcceptTaskRequest getDefaultInstanceForType() {
                return TaskHandler.AcceptTaskRequest.getDefaultInstance();
            }


            public TaskHandler.AcceptTaskRequest build() {
                TaskHandler.AcceptTaskRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public TaskHandler.AcceptTaskRequest buildPartial() {
                TaskHandler.AcceptTaskRequest result = new TaskHandler.AcceptTaskRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.c2STemplateId_ = this.c2STemplateId_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.c2SKind_ = this.c2SKind_;
                if ((from_bitField0_ & 0x4) == 4) {
                    to_bitField0_ |= 0x4;
                }
                result.c2SNpcId_ = this.c2SNpcId_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof TaskHandler.AcceptTaskRequest) {
                    return mergeFrom((TaskHandler.AcceptTaskRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(TaskHandler.AcceptTaskRequest other) {
                if (other == TaskHandler.AcceptTaskRequest.getDefaultInstance()) {
                    return this;
                }
                if (other.hasC2STemplateId()) {
                    setC2STemplateId(other.getC2STemplateId());
                }
                if (other.hasC2SKind()) {
                    setC2SKind(other.getC2SKind());
                }
                if (other.hasC2SNpcId()) {
                    this.bitField0_ |= 0x4;
                    this.c2SNpcId_ = other.c2SNpcId_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasC2STemplateId()) {
                    return false;
                }
                if (!hasC2SKind()) {
                    return false;
                }
                if (!hasC2SNpcId()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                TaskHandler.AcceptTaskRequest parsedMessage = null;
                try {
                    parsedMessage = (TaskHandler.AcceptTaskRequest) TaskHandler.AcceptTaskRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (TaskHandler.AcceptTaskRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasC2STemplateId() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public int getC2STemplateId() {
                return this.c2STemplateId_;
            }


            public Builder setC2STemplateId(int value) {
                this.bitField0_ |= 0x1;
                this.c2STemplateId_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2STemplateId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2STemplateId_ = 0;
                onChanged();
                return this;
            }


            public boolean hasC2SKind() {
                return ((this.bitField0_ & 0x2) == 2);
            }


            public int getC2SKind() {
                return this.c2SKind_;
            }


            public Builder setC2SKind(int value) {
                this.bitField0_ |= 0x2;
                this.c2SKind_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SKind() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.c2SKind_ = 0;
                onChanged();
                return this;
            }


            public boolean hasC2SNpcId() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public String getC2SNpcId() {
                Object ref = this.c2SNpcId_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.c2SNpcId_ = s;
                    }
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
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x4;
                this.c2SNpcId_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SNpcId() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.c2SNpcId_ = TaskHandler.AcceptTaskRequest.getDefaultInstance().getC2SNpcId();
                onChanged();
                return this;
            }


            public Builder setC2SNpcIdBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x4;
                this.c2SNpcId_ = value;
                onChanged();
                return this;
            }
        }
    }


    public static final class AcceptTaskResponse
            extends GeneratedMessage
            implements AcceptTaskResponseOrBuilder {
        private static final AcceptTaskResponse defaultInstance = new AcceptTaskResponse(true);
        private final UnknownFieldSet unknownFields;

        private AcceptTaskResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private AcceptTaskResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static AcceptTaskResponse getDefaultInstance() {
            return defaultInstance;
        }

        public AcceptTaskResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AcceptTaskResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return TaskHandler.internal_static_pomelo_area_AcceptTaskResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TaskHandler.internal_static_pomelo_area_AcceptTaskResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(AcceptTaskResponse.class, Builder.class);
        }

        public static Parser<AcceptTaskResponse> PARSER = (Parser<AcceptTaskResponse>) new AbstractParser<AcceptTaskResponse>() {
            public TaskHandler.AcceptTaskResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TaskHandler.AcceptTaskResponse(input, extensionRegistry);
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

        public Parser<AcceptTaskResponse> getParserForType() {
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


        private void initFields() {
            this.s2CCode_ = 0;
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
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static AcceptTaskResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (AcceptTaskResponse) PARSER.parseFrom(data);
        }


        public static AcceptTaskResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AcceptTaskResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static AcceptTaskResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (AcceptTaskResponse) PARSER.parseFrom(data);
        }


        public static AcceptTaskResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AcceptTaskResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static AcceptTaskResponse parseFrom(InputStream input) throws IOException {
            return (AcceptTaskResponse) PARSER.parseFrom(input);
        }


        public static AcceptTaskResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AcceptTaskResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static AcceptTaskResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (AcceptTaskResponse) PARSER.parseDelimitedFrom(input);
        }


        public static AcceptTaskResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AcceptTaskResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static AcceptTaskResponse parseFrom(CodedInputStream input) throws IOException {
            return (AcceptTaskResponse) PARSER.parseFrom(input);
        }


        public static AcceptTaskResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AcceptTaskResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(AcceptTaskResponse prototype) {
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
                implements TaskHandler.AcceptTaskResponseOrBuilder {
            private int bitField0_;


            private int s2CCode_;


            private Object s2CMsg_;


            public static final Descriptors.Descriptor getDescriptor() {
                return TaskHandler.internal_static_pomelo_area_AcceptTaskResponse_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return TaskHandler.internal_static_pomelo_area_AcceptTaskResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(TaskHandler.AcceptTaskResponse.class, Builder.class);
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
                if (TaskHandler.AcceptTaskResponse.alwaysUseFieldBuilders) ;
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
                return TaskHandler.internal_static_pomelo_area_AcceptTaskResponse_descriptor;
            }


            public TaskHandler.AcceptTaskResponse getDefaultInstanceForType() {
                return TaskHandler.AcceptTaskResponse.getDefaultInstance();
            }


            public TaskHandler.AcceptTaskResponse build() {
                TaskHandler.AcceptTaskResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public TaskHandler.AcceptTaskResponse buildPartial() {
                TaskHandler.AcceptTaskResponse result = new TaskHandler.AcceptTaskResponse(this);
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
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof TaskHandler.AcceptTaskResponse) {
                    return mergeFrom((TaskHandler.AcceptTaskResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(TaskHandler.AcceptTaskResponse other) {
                if (other == TaskHandler.AcceptTaskResponse.getDefaultInstance()) {
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
                TaskHandler.AcceptTaskResponse parsedMessage = null;
                try {
                    parsedMessage = (TaskHandler.AcceptTaskResponse) TaskHandler.AcceptTaskResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (TaskHandler.AcceptTaskResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = TaskHandler.AcceptTaskResponse.getDefaultInstance().getS2CMsg();
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
        }
    }


    public static final class QuickFinishRequest
            extends GeneratedMessage
            implements QuickFinishRequestOrBuilder {
        private static final QuickFinishRequest defaultInstance = new QuickFinishRequest(true);
        private final UnknownFieldSet unknownFields;

        private QuickFinishRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private QuickFinishRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static QuickFinishRequest getDefaultInstance() {
            return defaultInstance;
        }

        public QuickFinishRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private QuickFinishRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.c2STemplateId_ = input.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.c2SKind_ = input.readInt32();
                            break;
                        case 26:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x4;
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
            return TaskHandler.internal_static_pomelo_area_QuickFinishRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TaskHandler.internal_static_pomelo_area_QuickFinishRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(QuickFinishRequest.class, Builder.class);
        }

        public static Parser<QuickFinishRequest> PARSER = (Parser<QuickFinishRequest>) new AbstractParser<QuickFinishRequest>() {
            public TaskHandler.QuickFinishRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TaskHandler.QuickFinishRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_TEMPLATEID_FIELD_NUMBER = 1;
        private int c2STemplateId_;
        public static final int C2S_KIND_FIELD_NUMBER = 2;
        private int c2SKind_;
        public static final int C2S_NPCID_FIELD_NUMBER = 3;
        private Object c2SNpcId_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<QuickFinishRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasC2STemplateId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getC2STemplateId() {
            return this.c2STemplateId_;
        }

        public boolean hasC2SKind() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        static {
            defaultInstance.initFields();
        }


        public int getC2SKind() {
            return this.c2SKind_;
        }


        public boolean hasC2SNpcId() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public String getC2SNpcId() {
            Object ref = this.c2SNpcId_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.c2SNpcId_ = s;
            }
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
            this.c2STemplateId_ = 0;
            this.c2SKind_ = 0;
            this.c2SNpcId_ = "";
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasC2STemplateId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasC2SKind()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasC2SNpcId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeInt32(1, this.c2STemplateId_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeInt32(2, this.c2SKind_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeBytes(3, getC2SNpcIdBytes());
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
                size += CodedOutputStream.computeInt32Size(1, this.c2STemplateId_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeInt32Size(2, this.c2SKind_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                size += CodedOutputStream.computeBytesSize(3, getC2SNpcIdBytes());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static QuickFinishRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (QuickFinishRequest) PARSER.parseFrom(data);
        }


        public static QuickFinishRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (QuickFinishRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static QuickFinishRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (QuickFinishRequest) PARSER.parseFrom(data);
        }


        public static QuickFinishRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (QuickFinishRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static QuickFinishRequest parseFrom(InputStream input) throws IOException {
            return (QuickFinishRequest) PARSER.parseFrom(input);
        }


        public static QuickFinishRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QuickFinishRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static QuickFinishRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (QuickFinishRequest) PARSER.parseDelimitedFrom(input);
        }


        public static QuickFinishRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QuickFinishRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static QuickFinishRequest parseFrom(CodedInputStream input) throws IOException {
            return (QuickFinishRequest) PARSER.parseFrom(input);
        }


        public static QuickFinishRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QuickFinishRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(QuickFinishRequest prototype) {
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
                implements TaskHandler.QuickFinishRequestOrBuilder {
            private int bitField0_;


            private int c2STemplateId_;


            private int c2SKind_;


            private Object c2SNpcId_;


            public static final Descriptors.Descriptor getDescriptor() {
                return TaskHandler.internal_static_pomelo_area_QuickFinishRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return TaskHandler.internal_static_pomelo_area_QuickFinishRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(TaskHandler.QuickFinishRequest.class, Builder.class);
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
                if (TaskHandler.QuickFinishRequest.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.c2STemplateId_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SKind_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                this.c2SNpcId_ = "";
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return TaskHandler.internal_static_pomelo_area_QuickFinishRequest_descriptor;
            }


            public TaskHandler.QuickFinishRequest getDefaultInstanceForType() {
                return TaskHandler.QuickFinishRequest.getDefaultInstance();
            }


            public TaskHandler.QuickFinishRequest build() {
                TaskHandler.QuickFinishRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public TaskHandler.QuickFinishRequest buildPartial() {
                TaskHandler.QuickFinishRequest result = new TaskHandler.QuickFinishRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.c2STemplateId_ = this.c2STemplateId_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.c2SKind_ = this.c2SKind_;
                if ((from_bitField0_ & 0x4) == 4) {
                    to_bitField0_ |= 0x4;
                }
                result.c2SNpcId_ = this.c2SNpcId_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof TaskHandler.QuickFinishRequest) {
                    return mergeFrom((TaskHandler.QuickFinishRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(TaskHandler.QuickFinishRequest other) {
                if (other == TaskHandler.QuickFinishRequest.getDefaultInstance()) {
                    return this;
                }
                if (other.hasC2STemplateId()) {
                    setC2STemplateId(other.getC2STemplateId());
                }
                if (other.hasC2SKind()) {
                    setC2SKind(other.getC2SKind());
                }
                if (other.hasC2SNpcId()) {
                    this.bitField0_ |= 0x4;
                    this.c2SNpcId_ = other.c2SNpcId_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasC2STemplateId()) {
                    return false;
                }
                if (!hasC2SKind()) {
                    return false;
                }
                if (!hasC2SNpcId()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                TaskHandler.QuickFinishRequest parsedMessage = null;
                try {
                    parsedMessage = (TaskHandler.QuickFinishRequest) TaskHandler.QuickFinishRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (TaskHandler.QuickFinishRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasC2STemplateId() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public int getC2STemplateId() {
                return this.c2STemplateId_;
            }


            public Builder setC2STemplateId(int value) {
                this.bitField0_ |= 0x1;
                this.c2STemplateId_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2STemplateId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2STemplateId_ = 0;
                onChanged();
                return this;
            }


            public boolean hasC2SKind() {
                return ((this.bitField0_ & 0x2) == 2);
            }


            public int getC2SKind() {
                return this.c2SKind_;
            }


            public Builder setC2SKind(int value) {
                this.bitField0_ |= 0x2;
                this.c2SKind_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SKind() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.c2SKind_ = 0;
                onChanged();
                return this;
            }


            public boolean hasC2SNpcId() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public String getC2SNpcId() {
                Object ref = this.c2SNpcId_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.c2SNpcId_ = s;
                    }
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
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x4;
                this.c2SNpcId_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SNpcId() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.c2SNpcId_ = TaskHandler.QuickFinishRequest.getDefaultInstance().getC2SNpcId();
                onChanged();
                return this;
            }


            public Builder setC2SNpcIdBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x4;
                this.c2SNpcId_ = value;
                onChanged();
                return this;
            }
        }
    }


    public static final class QuickFinishResponse
            extends GeneratedMessage
            implements QuickFinishResponseOrBuilder {
        private static final QuickFinishResponse defaultInstance = new QuickFinishResponse(true);
        private final UnknownFieldSet unknownFields;

        private QuickFinishResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private QuickFinishResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static QuickFinishResponse getDefaultInstance() {
            return defaultInstance;
        }

        public QuickFinishResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private QuickFinishResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return TaskHandler.internal_static_pomelo_area_QuickFinishResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TaskHandler.internal_static_pomelo_area_QuickFinishResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(QuickFinishResponse.class, Builder.class);
        }

        public static Parser<QuickFinishResponse> PARSER = (Parser<QuickFinishResponse>) new AbstractParser<QuickFinishResponse>() {
            public TaskHandler.QuickFinishResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TaskHandler.QuickFinishResponse(input, extensionRegistry);
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

        public Parser<QuickFinishResponse> getParserForType() {
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


        private void initFields() {
            this.s2CCode_ = 0;
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
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static QuickFinishResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (QuickFinishResponse) PARSER.parseFrom(data);
        }


        public static QuickFinishResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (QuickFinishResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static QuickFinishResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (QuickFinishResponse) PARSER.parseFrom(data);
        }


        public static QuickFinishResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (QuickFinishResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static QuickFinishResponse parseFrom(InputStream input) throws IOException {
            return (QuickFinishResponse) PARSER.parseFrom(input);
        }


        public static QuickFinishResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QuickFinishResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static QuickFinishResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (QuickFinishResponse) PARSER.parseDelimitedFrom(input);
        }


        public static QuickFinishResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QuickFinishResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static QuickFinishResponse parseFrom(CodedInputStream input) throws IOException {
            return (QuickFinishResponse) PARSER.parseFrom(input);
        }


        public static QuickFinishResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QuickFinishResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(QuickFinishResponse prototype) {
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
                implements TaskHandler.QuickFinishResponseOrBuilder {
            private int bitField0_;


            private int s2CCode_;


            private Object s2CMsg_;


            public static final Descriptors.Descriptor getDescriptor() {
                return TaskHandler.internal_static_pomelo_area_QuickFinishResponse_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return TaskHandler.internal_static_pomelo_area_QuickFinishResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(TaskHandler.QuickFinishResponse.class, Builder.class);
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
                if (TaskHandler.QuickFinishResponse.alwaysUseFieldBuilders) ;
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
                return TaskHandler.internal_static_pomelo_area_QuickFinishResponse_descriptor;
            }


            public TaskHandler.QuickFinishResponse getDefaultInstanceForType() {
                return TaskHandler.QuickFinishResponse.getDefaultInstance();
            }


            public TaskHandler.QuickFinishResponse build() {
                TaskHandler.QuickFinishResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public TaskHandler.QuickFinishResponse buildPartial() {
                TaskHandler.QuickFinishResponse result = new TaskHandler.QuickFinishResponse(this);
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
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof TaskHandler.QuickFinishResponse) {
                    return mergeFrom((TaskHandler.QuickFinishResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(TaskHandler.QuickFinishResponse other) {
                if (other == TaskHandler.QuickFinishResponse.getDefaultInstance()) {
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
                TaskHandler.QuickFinishResponse parsedMessage = null;
                try {
                    parsedMessage = (TaskHandler.QuickFinishResponse) TaskHandler.QuickFinishResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (TaskHandler.QuickFinishResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = TaskHandler.QuickFinishResponse.getDefaultInstance().getS2CMsg();
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
        }
    }


    public static final class DiscardTaskRequest
            extends GeneratedMessage
            implements DiscardTaskRequestOrBuilder {
        private static final DiscardTaskRequest defaultInstance = new DiscardTaskRequest(true);
        private final UnknownFieldSet unknownFields;

        private DiscardTaskRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private DiscardTaskRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static DiscardTaskRequest getDefaultInstance() {
            return defaultInstance;
        }

        public DiscardTaskRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DiscardTaskRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.c2STemplateId_ = input.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.c2SKind_ = input.readInt32();
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
            return TaskHandler.internal_static_pomelo_area_DiscardTaskRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TaskHandler.internal_static_pomelo_area_DiscardTaskRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(DiscardTaskRequest.class, Builder.class);
        }

        public static Parser<DiscardTaskRequest> PARSER = (Parser<DiscardTaskRequest>) new AbstractParser<DiscardTaskRequest>() {
            public TaskHandler.DiscardTaskRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TaskHandler.DiscardTaskRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_TEMPLATEID_FIELD_NUMBER = 1;
        private int c2STemplateId_;
        public static final int C2S_KIND_FIELD_NUMBER = 2;
        private int c2SKind_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<DiscardTaskRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasC2STemplateId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getC2STemplateId() {
            return this.c2STemplateId_;
        }

        public boolean hasC2SKind() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        static {
            defaultInstance.initFields();
        }


        public int getC2SKind() {
            return this.c2SKind_;
        }


        private void initFields() {
            this.c2STemplateId_ = 0;
            this.c2SKind_ = 0;
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasC2STemplateId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasC2SKind()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeInt32(1, this.c2STemplateId_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeInt32(2, this.c2SKind_);
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
                size += CodedOutputStream.computeInt32Size(1, this.c2STemplateId_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeInt32Size(2, this.c2SKind_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static DiscardTaskRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (DiscardTaskRequest) PARSER.parseFrom(data);
        }


        public static DiscardTaskRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DiscardTaskRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static DiscardTaskRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (DiscardTaskRequest) PARSER.parseFrom(data);
        }


        public static DiscardTaskRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DiscardTaskRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static DiscardTaskRequest parseFrom(InputStream input) throws IOException {
            return (DiscardTaskRequest) PARSER.parseFrom(input);
        }


        public static DiscardTaskRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DiscardTaskRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static DiscardTaskRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (DiscardTaskRequest) PARSER.parseDelimitedFrom(input);
        }


        public static DiscardTaskRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DiscardTaskRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static DiscardTaskRequest parseFrom(CodedInputStream input) throws IOException {
            return (DiscardTaskRequest) PARSER.parseFrom(input);
        }


        public static DiscardTaskRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DiscardTaskRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(DiscardTaskRequest prototype) {
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
                implements TaskHandler.DiscardTaskRequestOrBuilder {
            private int bitField0_;


            private int c2STemplateId_;


            private int c2SKind_;


            public static final Descriptors.Descriptor getDescriptor() {
                return TaskHandler.internal_static_pomelo_area_DiscardTaskRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return TaskHandler.internal_static_pomelo_area_DiscardTaskRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(TaskHandler.DiscardTaskRequest.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (TaskHandler.DiscardTaskRequest.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.c2STemplateId_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SKind_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return TaskHandler.internal_static_pomelo_area_DiscardTaskRequest_descriptor;
            }


            public TaskHandler.DiscardTaskRequest getDefaultInstanceForType() {
                return TaskHandler.DiscardTaskRequest.getDefaultInstance();
            }


            public TaskHandler.DiscardTaskRequest build() {
                TaskHandler.DiscardTaskRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public TaskHandler.DiscardTaskRequest buildPartial() {
                TaskHandler.DiscardTaskRequest result = new TaskHandler.DiscardTaskRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.c2STemplateId_ = this.c2STemplateId_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.c2SKind_ = this.c2SKind_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof TaskHandler.DiscardTaskRequest) {
                    return mergeFrom((TaskHandler.DiscardTaskRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(TaskHandler.DiscardTaskRequest other) {
                if (other == TaskHandler.DiscardTaskRequest.getDefaultInstance()) {
                    return this;
                }
                if (other.hasC2STemplateId()) {
                    setC2STemplateId(other.getC2STemplateId());
                }
                if (other.hasC2SKind()) {
                    setC2SKind(other.getC2SKind());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasC2STemplateId()) {
                    return false;
                }
                if (!hasC2SKind()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                TaskHandler.DiscardTaskRequest parsedMessage = null;
                try {
                    parsedMessage = (TaskHandler.DiscardTaskRequest) TaskHandler.DiscardTaskRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (TaskHandler.DiscardTaskRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasC2STemplateId() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public int getC2STemplateId() {
                return this.c2STemplateId_;
            }


            public Builder setC2STemplateId(int value) {
                this.bitField0_ |= 0x1;
                this.c2STemplateId_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2STemplateId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2STemplateId_ = 0;
                onChanged();
                return this;
            }


            public boolean hasC2SKind() {
                return ((this.bitField0_ & 0x2) == 2);
            }


            public int getC2SKind() {
                return this.c2SKind_;
            }


            public Builder setC2SKind(int value) {
                this.bitField0_ |= 0x2;
                this.c2SKind_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SKind() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.c2SKind_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class DiscardTaskResponse
            extends GeneratedMessage
            implements DiscardTaskResponseOrBuilder {
        private static final DiscardTaskResponse defaultInstance = new DiscardTaskResponse(true);
        private final UnknownFieldSet unknownFields;

        private DiscardTaskResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private DiscardTaskResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static DiscardTaskResponse getDefaultInstance() {
            return defaultInstance;
        }

        public DiscardTaskResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DiscardTaskResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return TaskHandler.internal_static_pomelo_area_DiscardTaskResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TaskHandler.internal_static_pomelo_area_DiscardTaskResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(DiscardTaskResponse.class, Builder.class);
        }

        public static Parser<DiscardTaskResponse> PARSER = (Parser<DiscardTaskResponse>) new AbstractParser<DiscardTaskResponse>() {
            public TaskHandler.DiscardTaskResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TaskHandler.DiscardTaskResponse(input, extensionRegistry);
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

        public Parser<DiscardTaskResponse> getParserForType() {
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


        private void initFields() {
            this.s2CCode_ = 0;
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
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static DiscardTaskResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (DiscardTaskResponse) PARSER.parseFrom(data);
        }


        public static DiscardTaskResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DiscardTaskResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static DiscardTaskResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (DiscardTaskResponse) PARSER.parseFrom(data);
        }


        public static DiscardTaskResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DiscardTaskResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static DiscardTaskResponse parseFrom(InputStream input) throws IOException {
            return (DiscardTaskResponse) PARSER.parseFrom(input);
        }


        public static DiscardTaskResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DiscardTaskResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static DiscardTaskResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (DiscardTaskResponse) PARSER.parseDelimitedFrom(input);
        }


        public static DiscardTaskResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DiscardTaskResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static DiscardTaskResponse parseFrom(CodedInputStream input) throws IOException {
            return (DiscardTaskResponse) PARSER.parseFrom(input);
        }


        public static DiscardTaskResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DiscardTaskResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(DiscardTaskResponse prototype) {
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
                implements TaskHandler.DiscardTaskResponseOrBuilder {
            private int bitField0_;


            private int s2CCode_;


            private Object s2CMsg_;


            public static final Descriptors.Descriptor getDescriptor() {
                return TaskHandler.internal_static_pomelo_area_DiscardTaskResponse_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return TaskHandler.internal_static_pomelo_area_DiscardTaskResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(TaskHandler.DiscardTaskResponse.class, Builder.class);
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
                if (TaskHandler.DiscardTaskResponse.alwaysUseFieldBuilders) ;
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
                return TaskHandler.internal_static_pomelo_area_DiscardTaskResponse_descriptor;
            }


            public TaskHandler.DiscardTaskResponse getDefaultInstanceForType() {
                return TaskHandler.DiscardTaskResponse.getDefaultInstance();
            }


            public TaskHandler.DiscardTaskResponse build() {
                TaskHandler.DiscardTaskResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public TaskHandler.DiscardTaskResponse buildPartial() {
                TaskHandler.DiscardTaskResponse result = new TaskHandler.DiscardTaskResponse(this);
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
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof TaskHandler.DiscardTaskResponse) {
                    return mergeFrom((TaskHandler.DiscardTaskResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(TaskHandler.DiscardTaskResponse other) {
                if (other == TaskHandler.DiscardTaskResponse.getDefaultInstance()) {
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
                TaskHandler.DiscardTaskResponse parsedMessage = null;
                try {
                    parsedMessage = (TaskHandler.DiscardTaskResponse) TaskHandler.DiscardTaskResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (TaskHandler.DiscardTaskResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = TaskHandler.DiscardTaskResponse.getDefaultInstance().getS2CMsg();
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
        }
    }


    public static final class SubmitTaskRequest
            extends GeneratedMessage
            implements SubmitTaskRequestOrBuilder {
        private static final SubmitTaskRequest defaultInstance = new SubmitTaskRequest(true);
        private final UnknownFieldSet unknownFields;

        private SubmitTaskRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private SubmitTaskRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static SubmitTaskRequest getDefaultInstance() {
            return defaultInstance;
        }

        public SubmitTaskRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SubmitTaskRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.c2STemplateId_ = input.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.c2SKind_ = input.readInt32();
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.c2SDouble_ = input.readInt32();
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
            return TaskHandler.internal_static_pomelo_area_SubmitTaskRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TaskHandler.internal_static_pomelo_area_SubmitTaskRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(SubmitTaskRequest.class, Builder.class);
        }

        public static Parser<SubmitTaskRequest> PARSER = (Parser<SubmitTaskRequest>) new AbstractParser<SubmitTaskRequest>() {
            public TaskHandler.SubmitTaskRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TaskHandler.SubmitTaskRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_TEMPLATEID_FIELD_NUMBER = 1;
        private int c2STemplateId_;
        public static final int C2S_KIND_FIELD_NUMBER = 2;
        private int c2SKind_;
        public static final int C2S_DOUBLE_FIELD_NUMBER = 3;
        private int c2SDouble_;
        public static final int C2S_NPCID_FIELD_NUMBER = 4;
        private Object c2SNpcId_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<SubmitTaskRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasC2STemplateId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getC2STemplateId() {
            return this.c2STemplateId_;
        }

        public boolean hasC2SKind() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        static {
            defaultInstance.initFields();
        }


        public int getC2SKind() {
            return this.c2SKind_;
        }


        public boolean hasC2SDouble() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public int getC2SDouble() {
            return this.c2SDouble_;
        }


        public boolean hasC2SNpcId() {
            return ((this.bitField0_ & 0x8) == 8);
        }


        public String getC2SNpcId() {
            Object ref = this.c2SNpcId_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.c2SNpcId_ = s;
            }
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
            this.c2STemplateId_ = 0;
            this.c2SKind_ = 0;
            this.c2SDouble_ = 0;
            this.c2SNpcId_ = "";
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasC2STemplateId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasC2SKind()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasC2SDouble()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasC2SNpcId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeInt32(1, this.c2STemplateId_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeInt32(2, this.c2SKind_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeInt32(3, this.c2SDouble_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                output.writeBytes(4, getC2SNpcIdBytes());
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
                size += CodedOutputStream.computeInt32Size(1, this.c2STemplateId_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeInt32Size(2, this.c2SKind_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                size += CodedOutputStream.computeInt32Size(3, this.c2SDouble_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                size += CodedOutputStream.computeBytesSize(4, getC2SNpcIdBytes());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static SubmitTaskRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (SubmitTaskRequest) PARSER.parseFrom(data);
        }


        public static SubmitTaskRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SubmitTaskRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static SubmitTaskRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (SubmitTaskRequest) PARSER.parseFrom(data);
        }


        public static SubmitTaskRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SubmitTaskRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static SubmitTaskRequest parseFrom(InputStream input) throws IOException {
            return (SubmitTaskRequest) PARSER.parseFrom(input);
        }


        public static SubmitTaskRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SubmitTaskRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static SubmitTaskRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (SubmitTaskRequest) PARSER.parseDelimitedFrom(input);
        }


        public static SubmitTaskRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SubmitTaskRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static SubmitTaskRequest parseFrom(CodedInputStream input) throws IOException {
            return (SubmitTaskRequest) PARSER.parseFrom(input);
        }


        public static SubmitTaskRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SubmitTaskRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(SubmitTaskRequest prototype) {
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
                implements TaskHandler.SubmitTaskRequestOrBuilder {
            private int bitField0_;


            private int c2STemplateId_;


            private int c2SKind_;


            private int c2SDouble_;


            private Object c2SNpcId_;


            public static final Descriptors.Descriptor getDescriptor() {
                return TaskHandler.internal_static_pomelo_area_SubmitTaskRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return TaskHandler.internal_static_pomelo_area_SubmitTaskRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(TaskHandler.SubmitTaskRequest.class, Builder.class);
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
                if (TaskHandler.SubmitTaskRequest.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.c2STemplateId_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SKind_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                this.c2SDouble_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.c2SNpcId_ = "";
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return TaskHandler.internal_static_pomelo_area_SubmitTaskRequest_descriptor;
            }


            public TaskHandler.SubmitTaskRequest getDefaultInstanceForType() {
                return TaskHandler.SubmitTaskRequest.getDefaultInstance();
            }


            public TaskHandler.SubmitTaskRequest build() {
                TaskHandler.SubmitTaskRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public TaskHandler.SubmitTaskRequest buildPartial() {
                TaskHandler.SubmitTaskRequest result = new TaskHandler.SubmitTaskRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.c2STemplateId_ = this.c2STemplateId_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.c2SKind_ = this.c2SKind_;
                if ((from_bitField0_ & 0x4) == 4) {
                    to_bitField0_ |= 0x4;
                }
                result.c2SDouble_ = this.c2SDouble_;
                if ((from_bitField0_ & 0x8) == 8) {
                    to_bitField0_ |= 0x8;
                }
                result.c2SNpcId_ = this.c2SNpcId_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof TaskHandler.SubmitTaskRequest) {
                    return mergeFrom((TaskHandler.SubmitTaskRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(TaskHandler.SubmitTaskRequest other) {
                if (other == TaskHandler.SubmitTaskRequest.getDefaultInstance()) {
                    return this;
                }
                if (other.hasC2STemplateId()) {
                    setC2STemplateId(other.getC2STemplateId());
                }
                if (other.hasC2SKind()) {
                    setC2SKind(other.getC2SKind());
                }
                if (other.hasC2SDouble()) {
                    setC2SDouble(other.getC2SDouble());
                }
                if (other.hasC2SNpcId()) {
                    this.bitField0_ |= 0x8;
                    this.c2SNpcId_ = other.c2SNpcId_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasC2STemplateId()) {
                    return false;
                }
                if (!hasC2SKind()) {
                    return false;
                }
                if (!hasC2SDouble()) {
                    return false;
                }
                if (!hasC2SNpcId()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                TaskHandler.SubmitTaskRequest parsedMessage = null;
                try {
                    parsedMessage = (TaskHandler.SubmitTaskRequest) TaskHandler.SubmitTaskRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (TaskHandler.SubmitTaskRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasC2STemplateId() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public int getC2STemplateId() {
                return this.c2STemplateId_;
            }


            public Builder setC2STemplateId(int value) {
                this.bitField0_ |= 0x1;
                this.c2STemplateId_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2STemplateId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2STemplateId_ = 0;
                onChanged();
                return this;
            }


            public boolean hasC2SKind() {
                return ((this.bitField0_ & 0x2) == 2);
            }


            public int getC2SKind() {
                return this.c2SKind_;
            }


            public Builder setC2SKind(int value) {
                this.bitField0_ |= 0x2;
                this.c2SKind_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SKind() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.c2SKind_ = 0;
                onChanged();
                return this;
            }


            public boolean hasC2SDouble() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public int getC2SDouble() {
                return this.c2SDouble_;
            }


            public Builder setC2SDouble(int value) {
                this.bitField0_ |= 0x4;
                this.c2SDouble_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SDouble() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.c2SDouble_ = 0;
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
                    if (bs.isValidUtf8()) {
                        this.c2SNpcId_ = s;
                    }
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
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x8;
                this.c2SNpcId_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SNpcId() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.c2SNpcId_ = TaskHandler.SubmitTaskRequest.getDefaultInstance().getC2SNpcId();
                onChanged();
                return this;
            }


            public Builder setC2SNpcIdBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x8;
                this.c2SNpcId_ = value;
                onChanged();
                return this;
            }
        }
    }


    public static final class SubmitTaskResponse
            extends GeneratedMessage
            implements SubmitTaskResponseOrBuilder {
        private static final SubmitTaskResponse defaultInstance = new SubmitTaskResponse(true);
        private final UnknownFieldSet unknownFields;

        private SubmitTaskResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private SubmitTaskResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static SubmitTaskResponse getDefaultInstance() {
            return defaultInstance;
        }

        public SubmitTaskResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SubmitTaskResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return TaskHandler.internal_static_pomelo_area_SubmitTaskResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TaskHandler.internal_static_pomelo_area_SubmitTaskResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(SubmitTaskResponse.class, Builder.class);
        }

        public static Parser<SubmitTaskResponse> PARSER = (Parser<SubmitTaskResponse>) new AbstractParser<SubmitTaskResponse>() {
            public TaskHandler.SubmitTaskResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TaskHandler.SubmitTaskResponse(input, extensionRegistry);
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

        public Parser<SubmitTaskResponse> getParserForType() {
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


        private void initFields() {
            this.s2CCode_ = 0;
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
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static SubmitTaskResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (SubmitTaskResponse) PARSER.parseFrom(data);
        }


        public static SubmitTaskResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SubmitTaskResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static SubmitTaskResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (SubmitTaskResponse) PARSER.parseFrom(data);
        }


        public static SubmitTaskResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SubmitTaskResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static SubmitTaskResponse parseFrom(InputStream input) throws IOException {
            return (SubmitTaskResponse) PARSER.parseFrom(input);
        }


        public static SubmitTaskResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SubmitTaskResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static SubmitTaskResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (SubmitTaskResponse) PARSER.parseDelimitedFrom(input);
        }


        public static SubmitTaskResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SubmitTaskResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static SubmitTaskResponse parseFrom(CodedInputStream input) throws IOException {
            return (SubmitTaskResponse) PARSER.parseFrom(input);
        }


        public static SubmitTaskResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SubmitTaskResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(SubmitTaskResponse prototype) {
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
                implements TaskHandler.SubmitTaskResponseOrBuilder {
            private int bitField0_;


            private int s2CCode_;


            private Object s2CMsg_;


            public static final Descriptors.Descriptor getDescriptor() {
                return TaskHandler.internal_static_pomelo_area_SubmitTaskResponse_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return TaskHandler.internal_static_pomelo_area_SubmitTaskResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(TaskHandler.SubmitTaskResponse.class, Builder.class);
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
                if (TaskHandler.SubmitTaskResponse.alwaysUseFieldBuilders) ;
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
                return TaskHandler.internal_static_pomelo_area_SubmitTaskResponse_descriptor;
            }


            public TaskHandler.SubmitTaskResponse getDefaultInstanceForType() {
                return TaskHandler.SubmitTaskResponse.getDefaultInstance();
            }


            public TaskHandler.SubmitTaskResponse build() {
                TaskHandler.SubmitTaskResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public TaskHandler.SubmitTaskResponse buildPartial() {
                TaskHandler.SubmitTaskResponse result = new TaskHandler.SubmitTaskResponse(this);
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
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof TaskHandler.SubmitTaskResponse) {
                    return mergeFrom((TaskHandler.SubmitTaskResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(TaskHandler.SubmitTaskResponse other) {
                if (other == TaskHandler.SubmitTaskResponse.getDefaultInstance()) {
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
                TaskHandler.SubmitTaskResponse parsedMessage = null;
                try {
                    parsedMessage = (TaskHandler.SubmitTaskResponse) TaskHandler.SubmitTaskResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (TaskHandler.SubmitTaskResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = TaskHandler.SubmitTaskResponse.getDefaultInstance().getS2CMsg();
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
        }
    }


    public static final class UpdateTaskStatusRequest
            extends GeneratedMessage
            implements UpdateTaskStatusRequestOrBuilder {
        private static final UpdateTaskStatusRequest defaultInstance = new UpdateTaskStatusRequest(true);
        private final UnknownFieldSet unknownFields;

        private UpdateTaskStatusRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private UpdateTaskStatusRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static UpdateTaskStatusRequest getDefaultInstance() {
            return defaultInstance;
        }

        public UpdateTaskStatusRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private UpdateTaskStatusRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.c2STemplateId_ = input.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.c2SKind_ = input.readInt32();
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
            return TaskHandler.internal_static_pomelo_area_UpdateTaskStatusRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TaskHandler.internal_static_pomelo_area_UpdateTaskStatusRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(UpdateTaskStatusRequest.class, Builder.class);
        }

        public static Parser<UpdateTaskStatusRequest> PARSER = (Parser<UpdateTaskStatusRequest>) new AbstractParser<UpdateTaskStatusRequest>() {
            public TaskHandler.UpdateTaskStatusRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TaskHandler.UpdateTaskStatusRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_TEMPLATEID_FIELD_NUMBER = 1;
        private int c2STemplateId_;
        public static final int C2S_KIND_FIELD_NUMBER = 2;
        private int c2SKind_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<UpdateTaskStatusRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasC2STemplateId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getC2STemplateId() {
            return this.c2STemplateId_;
        }

        public boolean hasC2SKind() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        static {
            defaultInstance.initFields();
        }


        public int getC2SKind() {
            return this.c2SKind_;
        }


        private void initFields() {
            this.c2STemplateId_ = 0;
            this.c2SKind_ = 0;
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasC2STemplateId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasC2SKind()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeInt32(1, this.c2STemplateId_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeInt32(2, this.c2SKind_);
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
                size += CodedOutputStream.computeInt32Size(1, this.c2STemplateId_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeInt32Size(2, this.c2SKind_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static UpdateTaskStatusRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (UpdateTaskStatusRequest) PARSER.parseFrom(data);
        }


        public static UpdateTaskStatusRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (UpdateTaskStatusRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static UpdateTaskStatusRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (UpdateTaskStatusRequest) PARSER.parseFrom(data);
        }


        public static UpdateTaskStatusRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (UpdateTaskStatusRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static UpdateTaskStatusRequest parseFrom(InputStream input) throws IOException {
            return (UpdateTaskStatusRequest) PARSER.parseFrom(input);
        }


        public static UpdateTaskStatusRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpdateTaskStatusRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static UpdateTaskStatusRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (UpdateTaskStatusRequest) PARSER.parseDelimitedFrom(input);
        }


        public static UpdateTaskStatusRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpdateTaskStatusRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static UpdateTaskStatusRequest parseFrom(CodedInputStream input) throws IOException {
            return (UpdateTaskStatusRequest) PARSER.parseFrom(input);
        }


        public static UpdateTaskStatusRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpdateTaskStatusRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(UpdateTaskStatusRequest prototype) {
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
                implements TaskHandler.UpdateTaskStatusRequestOrBuilder {
            private int bitField0_;


            private int c2STemplateId_;


            private int c2SKind_;


            public static final Descriptors.Descriptor getDescriptor() {
                return TaskHandler.internal_static_pomelo_area_UpdateTaskStatusRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return TaskHandler.internal_static_pomelo_area_UpdateTaskStatusRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(TaskHandler.UpdateTaskStatusRequest.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (TaskHandler.UpdateTaskStatusRequest.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.c2STemplateId_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SKind_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return TaskHandler.internal_static_pomelo_area_UpdateTaskStatusRequest_descriptor;
            }


            public TaskHandler.UpdateTaskStatusRequest getDefaultInstanceForType() {
                return TaskHandler.UpdateTaskStatusRequest.getDefaultInstance();
            }


            public TaskHandler.UpdateTaskStatusRequest build() {
                TaskHandler.UpdateTaskStatusRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public TaskHandler.UpdateTaskStatusRequest buildPartial() {
                TaskHandler.UpdateTaskStatusRequest result = new TaskHandler.UpdateTaskStatusRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.c2STemplateId_ = this.c2STemplateId_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.c2SKind_ = this.c2SKind_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof TaskHandler.UpdateTaskStatusRequest) {
                    return mergeFrom((TaskHandler.UpdateTaskStatusRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(TaskHandler.UpdateTaskStatusRequest other) {
                if (other == TaskHandler.UpdateTaskStatusRequest.getDefaultInstance()) {
                    return this;
                }
                if (other.hasC2STemplateId()) {
                    setC2STemplateId(other.getC2STemplateId());
                }
                if (other.hasC2SKind()) {
                    setC2SKind(other.getC2SKind());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasC2STemplateId()) {
                    return false;
                }
                if (!hasC2SKind()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                TaskHandler.UpdateTaskStatusRequest parsedMessage = null;
                try {
                    parsedMessage = (TaskHandler.UpdateTaskStatusRequest) TaskHandler.UpdateTaskStatusRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (TaskHandler.UpdateTaskStatusRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasC2STemplateId() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public int getC2STemplateId() {
                return this.c2STemplateId_;
            }


            public Builder setC2STemplateId(int value) {
                this.bitField0_ |= 0x1;
                this.c2STemplateId_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2STemplateId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2STemplateId_ = 0;
                onChanged();
                return this;
            }


            public boolean hasC2SKind() {
                return ((this.bitField0_ & 0x2) == 2);
            }


            public int getC2SKind() {
                return this.c2SKind_;
            }


            public Builder setC2SKind(int value) {
                this.bitField0_ |= 0x2;
                this.c2SKind_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SKind() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.c2SKind_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class UpdateTaskStatusResponse
            extends GeneratedMessage
            implements UpdateTaskStatusResponseOrBuilder {
        private static final UpdateTaskStatusResponse defaultInstance = new UpdateTaskStatusResponse(true);
        private final UnknownFieldSet unknownFields;

        private UpdateTaskStatusResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private UpdateTaskStatusResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static UpdateTaskStatusResponse getDefaultInstance() {
            return defaultInstance;
        }

        public UpdateTaskStatusResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private UpdateTaskStatusResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return TaskHandler.internal_static_pomelo_area_UpdateTaskStatusResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TaskHandler.internal_static_pomelo_area_UpdateTaskStatusResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(UpdateTaskStatusResponse.class, Builder.class);
        }

        public static Parser<UpdateTaskStatusResponse> PARSER = (Parser<UpdateTaskStatusResponse>) new AbstractParser<UpdateTaskStatusResponse>() {
            public TaskHandler.UpdateTaskStatusResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TaskHandler.UpdateTaskStatusResponse(input, extensionRegistry);
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

        public Parser<UpdateTaskStatusResponse> getParserForType() {
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


        private void initFields() {
            this.s2CCode_ = 0;
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
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static UpdateTaskStatusResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (UpdateTaskStatusResponse) PARSER.parseFrom(data);
        }


        public static UpdateTaskStatusResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (UpdateTaskStatusResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static UpdateTaskStatusResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (UpdateTaskStatusResponse) PARSER.parseFrom(data);
        }


        public static UpdateTaskStatusResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (UpdateTaskStatusResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static UpdateTaskStatusResponse parseFrom(InputStream input) throws IOException {
            return (UpdateTaskStatusResponse) PARSER.parseFrom(input);
        }


        public static UpdateTaskStatusResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpdateTaskStatusResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static UpdateTaskStatusResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (UpdateTaskStatusResponse) PARSER.parseDelimitedFrom(input);
        }


        public static UpdateTaskStatusResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpdateTaskStatusResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static UpdateTaskStatusResponse parseFrom(CodedInputStream input) throws IOException {
            return (UpdateTaskStatusResponse) PARSER.parseFrom(input);
        }


        public static UpdateTaskStatusResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpdateTaskStatusResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(UpdateTaskStatusResponse prototype) {
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
                implements TaskHandler.UpdateTaskStatusResponseOrBuilder {
            private int bitField0_;

            private int s2CCode_;

            private Object s2CMsg_;


            public static final Descriptors.Descriptor getDescriptor() {
                return TaskHandler.internal_static_pomelo_area_UpdateTaskStatusResponse_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return TaskHandler.internal_static_pomelo_area_UpdateTaskStatusResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(TaskHandler.UpdateTaskStatusResponse.class, Builder.class);
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
                if (TaskHandler.UpdateTaskStatusResponse.alwaysUseFieldBuilders) ;
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
                return TaskHandler.internal_static_pomelo_area_UpdateTaskStatusResponse_descriptor;
            }


            public TaskHandler.UpdateTaskStatusResponse getDefaultInstanceForType() {
                return TaskHandler.UpdateTaskStatusResponse.getDefaultInstance();
            }


            public TaskHandler.UpdateTaskStatusResponse build() {
                TaskHandler.UpdateTaskStatusResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public TaskHandler.UpdateTaskStatusResponse buildPartial() {
                TaskHandler.UpdateTaskStatusResponse result = new TaskHandler.UpdateTaskStatusResponse(this);
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
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof TaskHandler.UpdateTaskStatusResponse) {
                    return mergeFrom((TaskHandler.UpdateTaskStatusResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(TaskHandler.UpdateTaskStatusResponse other) {
                if (other == TaskHandler.UpdateTaskStatusResponse.getDefaultInstance()) {
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
                TaskHandler.UpdateTaskStatusResponse parsedMessage = null;
                try {
                    parsedMessage = (TaskHandler.UpdateTaskStatusResponse) TaskHandler.UpdateTaskStatusResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (TaskHandler.UpdateTaskStatusResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = TaskHandler.UpdateTaskStatusResponse.getDefaultInstance().getS2CMsg();
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
        }
    }


    public static final class RefreshSoulTaskRequest
            extends GeneratedMessage
            implements RefreshSoulTaskRequestOrBuilder {
        private static final RefreshSoulTaskRequest defaultInstance = new RefreshSoulTaskRequest(true);
        private final UnknownFieldSet unknownFields;

        private RefreshSoulTaskRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private RefreshSoulTaskRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static RefreshSoulTaskRequest getDefaultInstance() {
            return defaultInstance;
        }

        public RefreshSoulTaskRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private RefreshSoulTaskRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.c2STaskId_ = input.readInt32();
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
            return TaskHandler.internal_static_pomelo_area_RefreshSoulTaskRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TaskHandler.internal_static_pomelo_area_RefreshSoulTaskRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(RefreshSoulTaskRequest.class, Builder.class);
        }

        public static Parser<RefreshSoulTaskRequest> PARSER = (Parser<RefreshSoulTaskRequest>) new AbstractParser<RefreshSoulTaskRequest>() {
            public TaskHandler.RefreshSoulTaskRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TaskHandler.RefreshSoulTaskRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_TASKID_FIELD_NUMBER = 1;
        private int c2STaskId_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<RefreshSoulTaskRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasC2STaskId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getC2STaskId() {
            return this.c2STaskId_;
        }

        private void initFields() {
            this.c2STaskId_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasC2STaskId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.c2STaskId_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.c2STaskId_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static RefreshSoulTaskRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (RefreshSoulTaskRequest) PARSER.parseFrom(data);
        }

        public static RefreshSoulTaskRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (RefreshSoulTaskRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static RefreshSoulTaskRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (RefreshSoulTaskRequest) PARSER.parseFrom(data);
        }

        public static RefreshSoulTaskRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (RefreshSoulTaskRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static RefreshSoulTaskRequest parseFrom(InputStream input) throws IOException {
            return (RefreshSoulTaskRequest) PARSER.parseFrom(input);
        }

        public static RefreshSoulTaskRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RefreshSoulTaskRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static RefreshSoulTaskRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (RefreshSoulTaskRequest) PARSER.parseDelimitedFrom(input);
        }

        public static RefreshSoulTaskRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RefreshSoulTaskRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static RefreshSoulTaskRequest parseFrom(CodedInputStream input) throws IOException {
            return (RefreshSoulTaskRequest) PARSER.parseFrom(input);
        }

        public static RefreshSoulTaskRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RefreshSoulTaskRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(RefreshSoulTaskRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements TaskHandler.RefreshSoulTaskRequestOrBuilder {
            private int bitField0_;
            private int c2STaskId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return TaskHandler.internal_static_pomelo_area_RefreshSoulTaskRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return TaskHandler.internal_static_pomelo_area_RefreshSoulTaskRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(TaskHandler.RefreshSoulTaskRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TaskHandler.RefreshSoulTaskRequest.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.c2STaskId_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return TaskHandler.internal_static_pomelo_area_RefreshSoulTaskRequest_descriptor;
            }

            public TaskHandler.RefreshSoulTaskRequest getDefaultInstanceForType() {
                return TaskHandler.RefreshSoulTaskRequest.getDefaultInstance();
            }

            public TaskHandler.RefreshSoulTaskRequest build() {
                TaskHandler.RefreshSoulTaskRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public TaskHandler.RefreshSoulTaskRequest buildPartial() {
                TaskHandler.RefreshSoulTaskRequest result = new TaskHandler.RefreshSoulTaskRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.c2STaskId_ = this.c2STaskId_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof TaskHandler.RefreshSoulTaskRequest)
                    return mergeFrom((TaskHandler.RefreshSoulTaskRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TaskHandler.RefreshSoulTaskRequest other) {
                if (other == TaskHandler.RefreshSoulTaskRequest.getDefaultInstance()) return this;
                if (other.hasC2STaskId()) setC2STaskId(other.getC2STaskId());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasC2STaskId()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                TaskHandler.RefreshSoulTaskRequest parsedMessage = null;
                try {
                    parsedMessage = (TaskHandler.RefreshSoulTaskRequest) TaskHandler.RefreshSoulTaskRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (TaskHandler.RefreshSoulTaskRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasC2STaskId() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getC2STaskId() {
                return this.c2STaskId_;
            }

            public Builder setC2STaskId(int value) {
                this.bitField0_ |= 0x1;
                this.c2STaskId_ = value;
                onChanged();
                return this;
            }

            public Builder clearC2STaskId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2STaskId_ = 0;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class RefreshSoulTaskResponse
            extends GeneratedMessage
            implements RefreshSoulTaskResponseOrBuilder {
        private static final RefreshSoulTaskResponse defaultInstance = new RefreshSoulTaskResponse(true);
        private final UnknownFieldSet unknownFields;

        private RefreshSoulTaskResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private RefreshSoulTaskResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static RefreshSoulTaskResponse getDefaultInstance() {
            return defaultInstance;
        }

        public RefreshSoulTaskResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private RefreshSoulTaskResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return TaskHandler.internal_static_pomelo_area_RefreshSoulTaskResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TaskHandler.internal_static_pomelo_area_RefreshSoulTaskResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(RefreshSoulTaskResponse.class, Builder.class);
        }

        public static Parser<RefreshSoulTaskResponse> PARSER = (Parser<RefreshSoulTaskResponse>) new AbstractParser<RefreshSoulTaskResponse>() {
            public TaskHandler.RefreshSoulTaskResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TaskHandler.RefreshSoulTaskResponse(input, extensionRegistry);
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

        public Parser<RefreshSoulTaskResponse> getParserForType() {
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

        public static RefreshSoulTaskResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (RefreshSoulTaskResponse) PARSER.parseFrom(data);
        }

        public static RefreshSoulTaskResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (RefreshSoulTaskResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static RefreshSoulTaskResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (RefreshSoulTaskResponse) PARSER.parseFrom(data);
        }

        public static RefreshSoulTaskResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (RefreshSoulTaskResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static RefreshSoulTaskResponse parseFrom(InputStream input) throws IOException {
            return (RefreshSoulTaskResponse) PARSER.parseFrom(input);
        }

        public static RefreshSoulTaskResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RefreshSoulTaskResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static RefreshSoulTaskResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (RefreshSoulTaskResponse) PARSER.parseDelimitedFrom(input);
        }

        public static RefreshSoulTaskResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RefreshSoulTaskResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static RefreshSoulTaskResponse parseFrom(CodedInputStream input) throws IOException {
            return (RefreshSoulTaskResponse) PARSER.parseFrom(input);
        }

        public static RefreshSoulTaskResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RefreshSoulTaskResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(RefreshSoulTaskResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements TaskHandler.RefreshSoulTaskResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;

            public static final Descriptors.Descriptor getDescriptor() {
                return TaskHandler.internal_static_pomelo_area_RefreshSoulTaskResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return TaskHandler.internal_static_pomelo_area_RefreshSoulTaskResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(TaskHandler.RefreshSoulTaskResponse.class, Builder.class);
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
                if (TaskHandler.RefreshSoulTaskResponse.alwaysUseFieldBuilders) ;
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
                return TaskHandler.internal_static_pomelo_area_RefreshSoulTaskResponse_descriptor;
            }

            public TaskHandler.RefreshSoulTaskResponse getDefaultInstanceForType() {
                return TaskHandler.RefreshSoulTaskResponse.getDefaultInstance();
            }

            public TaskHandler.RefreshSoulTaskResponse build() {
                TaskHandler.RefreshSoulTaskResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public TaskHandler.RefreshSoulTaskResponse buildPartial() {
                TaskHandler.RefreshSoulTaskResponse result = new TaskHandler.RefreshSoulTaskResponse(this);
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
                if (other instanceof TaskHandler.RefreshSoulTaskResponse)
                    return mergeFrom((TaskHandler.RefreshSoulTaskResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TaskHandler.RefreshSoulTaskResponse other) {
                if (other == TaskHandler.RefreshSoulTaskResponse.getDefaultInstance())
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
                TaskHandler.RefreshSoulTaskResponse parsedMessage = null;
                try {
                    parsedMessage = (TaskHandler.RefreshSoulTaskResponse) TaskHandler.RefreshSoulTaskResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (TaskHandler.RefreshSoulTaskResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = TaskHandler.RefreshSoulTaskResponse.getDefaultInstance().getS2CMsg();
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

    public static final class GetDailySoulFinNumRequest extends GeneratedMessage implements GetDailySoulFinNumRequestOrBuilder {
        private static final GetDailySoulFinNumRequest defaultInstance = new GetDailySoulFinNumRequest(true);
        private final UnknownFieldSet unknownFields;

        private GetDailySoulFinNumRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetDailySoulFinNumRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetDailySoulFinNumRequest getDefaultInstance() {
            return defaultInstance;
        }

        public GetDailySoulFinNumRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetDailySoulFinNumRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return TaskHandler.internal_static_pomelo_area_GetDailySoulFinNumRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TaskHandler.internal_static_pomelo_area_GetDailySoulFinNumRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetDailySoulFinNumRequest.class, Builder.class);
        }

        public static Parser<GetDailySoulFinNumRequest> PARSER = (Parser<GetDailySoulFinNumRequest>) new AbstractParser<GetDailySoulFinNumRequest>() {
            public TaskHandler.GetDailySoulFinNumRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TaskHandler.GetDailySoulFinNumRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetDailySoulFinNumRequest> getParserForType() {
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

        public static GetDailySoulFinNumRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetDailySoulFinNumRequest) PARSER.parseFrom(data);
        }

        public static GetDailySoulFinNumRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetDailySoulFinNumRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetDailySoulFinNumRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetDailySoulFinNumRequest) PARSER.parseFrom(data);
        }

        public static GetDailySoulFinNumRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetDailySoulFinNumRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetDailySoulFinNumRequest parseFrom(InputStream input) throws IOException {
            return (GetDailySoulFinNumRequest) PARSER.parseFrom(input);
        }

        public static GetDailySoulFinNumRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetDailySoulFinNumRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static GetDailySoulFinNumRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (GetDailySoulFinNumRequest) PARSER.parseDelimitedFrom(input);
        }

        public static GetDailySoulFinNumRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetDailySoulFinNumRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static GetDailySoulFinNumRequest parseFrom(CodedInputStream input) throws IOException {
            return (GetDailySoulFinNumRequest) PARSER.parseFrom(input);
        }

        public static GetDailySoulFinNumRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetDailySoulFinNumRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(GetDailySoulFinNumRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements TaskHandler.GetDailySoulFinNumRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return TaskHandler.internal_static_pomelo_area_GetDailySoulFinNumRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return TaskHandler.internal_static_pomelo_area_GetDailySoulFinNumRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(TaskHandler.GetDailySoulFinNumRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TaskHandler.GetDailySoulFinNumRequest.alwaysUseFieldBuilders) ;
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
                return TaskHandler.internal_static_pomelo_area_GetDailySoulFinNumRequest_descriptor;
            }

            public TaskHandler.GetDailySoulFinNumRequest getDefaultInstanceForType() {
                return TaskHandler.GetDailySoulFinNumRequest.getDefaultInstance();
            }

            public TaskHandler.GetDailySoulFinNumRequest build() {
                TaskHandler.GetDailySoulFinNumRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public TaskHandler.GetDailySoulFinNumRequest buildPartial() {
                TaskHandler.GetDailySoulFinNumRequest result = new TaskHandler.GetDailySoulFinNumRequest(this);
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof TaskHandler.GetDailySoulFinNumRequest)
                    return mergeFrom((TaskHandler.GetDailySoulFinNumRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TaskHandler.GetDailySoulFinNumRequest other) {
                if (other == TaskHandler.GetDailySoulFinNumRequest.getDefaultInstance()) return this;
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                TaskHandler.GetDailySoulFinNumRequest parsedMessage = null;
                try {
                    parsedMessage = (TaskHandler.GetDailySoulFinNumRequest) TaskHandler.GetDailySoulFinNumRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (TaskHandler.GetDailySoulFinNumRequest) e.getUnfinishedMessage();
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


    public static final class GetDailySoulFinNumResponse
            extends GeneratedMessage
            implements GetDailySoulFinNumResponseOrBuilder {
        private static final GetDailySoulFinNumResponse defaultInstance = new GetDailySoulFinNumResponse(true);
        private final UnknownFieldSet unknownFields;

        private GetDailySoulFinNumResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetDailySoulFinNumResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetDailySoulFinNumResponse getDefaultInstance() {
            return defaultInstance;
        }

        public GetDailySoulFinNumResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetDailySoulFinNumResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.s2CNum_ = input.readInt32();
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
            return TaskHandler.internal_static_pomelo_area_GetDailySoulFinNumResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TaskHandler.internal_static_pomelo_area_GetDailySoulFinNumResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetDailySoulFinNumResponse.class, Builder.class);
        }

        public static Parser<GetDailySoulFinNumResponse> PARSER = (Parser<GetDailySoulFinNumResponse>) new AbstractParser<GetDailySoulFinNumResponse>() {
            public TaskHandler.GetDailySoulFinNumResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TaskHandler.GetDailySoulFinNumResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_NUM_FIELD_NUMBER = 3;
        private int s2CNum_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetDailySoulFinNumResponse> getParserForType() {
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


        public boolean hasS2CNum() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public int getS2CNum() {
            return this.s2CNum_;
        }


        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CNum_ = 0;
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
            if (!hasS2CNum()) {
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
                output.writeInt32(3, this.s2CNum_);
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
                size += CodedOutputStream.computeInt32Size(3, this.s2CNum_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static GetDailySoulFinNumResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetDailySoulFinNumResponse) PARSER.parseFrom(data);
        }


        public static GetDailySoulFinNumResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetDailySoulFinNumResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetDailySoulFinNumResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetDailySoulFinNumResponse) PARSER.parseFrom(data);
        }


        public static GetDailySoulFinNumResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetDailySoulFinNumResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetDailySoulFinNumResponse parseFrom(InputStream input) throws IOException {
            return (GetDailySoulFinNumResponse) PARSER.parseFrom(input);
        }


        public static GetDailySoulFinNumResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetDailySoulFinNumResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static GetDailySoulFinNumResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (GetDailySoulFinNumResponse) PARSER.parseDelimitedFrom(input);
        }


        public static GetDailySoulFinNumResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetDailySoulFinNumResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static GetDailySoulFinNumResponse parseFrom(CodedInputStream input) throws IOException {
            return (GetDailySoulFinNumResponse) PARSER.parseFrom(input);
        }


        public static GetDailySoulFinNumResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetDailySoulFinNumResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(GetDailySoulFinNumResponse prototype) {
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
                implements TaskHandler.GetDailySoulFinNumResponseOrBuilder {
            private int bitField0_;

            private int s2CCode_;

            private Object s2CMsg_;

            private int s2CNum_;


            public static final Descriptors.Descriptor getDescriptor() {
                return TaskHandler.internal_static_pomelo_area_GetDailySoulFinNumResponse_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return TaskHandler.internal_static_pomelo_area_GetDailySoulFinNumResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(TaskHandler.GetDailySoulFinNumResponse.class, Builder.class);
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
                if (TaskHandler.GetDailySoulFinNumResponse.alwaysUseFieldBuilders) ;
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
                this.s2CNum_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return TaskHandler.internal_static_pomelo_area_GetDailySoulFinNumResponse_descriptor;
            }


            public TaskHandler.GetDailySoulFinNumResponse getDefaultInstanceForType() {
                return TaskHandler.GetDailySoulFinNumResponse.getDefaultInstance();
            }


            public TaskHandler.GetDailySoulFinNumResponse build() {
                TaskHandler.GetDailySoulFinNumResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public TaskHandler.GetDailySoulFinNumResponse buildPartial() {
                TaskHandler.GetDailySoulFinNumResponse result = new TaskHandler.GetDailySoulFinNumResponse(this);
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
                result.s2CNum_ = this.s2CNum_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof TaskHandler.GetDailySoulFinNumResponse) {
                    return mergeFrom((TaskHandler.GetDailySoulFinNumResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(TaskHandler.GetDailySoulFinNumResponse other) {
                if (other == TaskHandler.GetDailySoulFinNumResponse.getDefaultInstance()) {
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
                if (other.hasS2CNum()) {
                    setS2CNum(other.getS2CNum());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasS2CCode()) {
                    return false;
                }
                if (!hasS2CNum()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                TaskHandler.GetDailySoulFinNumResponse parsedMessage = null;
                try {
                    parsedMessage = (TaskHandler.GetDailySoulFinNumResponse) TaskHandler.GetDailySoulFinNumResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (TaskHandler.GetDailySoulFinNumResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = TaskHandler.GetDailySoulFinNumResponse.getDefaultInstance().getS2CMsg();
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


            public boolean hasS2CNum() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public int getS2CNum() {
                return this.s2CNum_;
            }


            public Builder setS2CNum(int value) {
                this.bitField0_ |= 0x4;
                this.s2CNum_ = value;
                onChanged();
                return this;
            }


            public Builder clearS2CNum() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.s2CNum_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class TaskFuncDeskRequest
            extends GeneratedMessage
            implements TaskFuncDeskRequestOrBuilder {
        private static final TaskFuncDeskRequest defaultInstance = new TaskFuncDeskRequest(true);
        private final UnknownFieldSet unknownFields;

        private TaskFuncDeskRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private TaskFuncDeskRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static TaskFuncDeskRequest getDefaultInstance() {
            return defaultInstance;
        }

        public TaskFuncDeskRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private TaskFuncDeskRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.c2SNcpId_ = bs;
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
            return TaskHandler.internal_static_pomelo_area_TaskFuncDeskRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TaskHandler.internal_static_pomelo_area_TaskFuncDeskRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(TaskFuncDeskRequest.class, Builder.class);
        }

        public static Parser<TaskFuncDeskRequest> PARSER = (Parser<TaskFuncDeskRequest>) new AbstractParser<TaskFuncDeskRequest>() {
            public TaskHandler.TaskFuncDeskRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TaskHandler.TaskFuncDeskRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_NCPID_FIELD_NUMBER = 1;
        private Object c2SNcpId_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<TaskFuncDeskRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasC2SNcpId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public String getC2SNcpId() {
            Object ref = this.c2SNcpId_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8())
                this.c2SNcpId_ = s;
            return s;
        }

        public ByteString getC2SNcpIdBytes() {
            Object ref = this.c2SNcpId_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.c2SNcpId_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        static {
            defaultInstance.initFields();
        }


        private void initFields() {
            this.c2SNcpId_ = "";
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasC2SNcpId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeBytes(1, getC2SNcpIdBytes());
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
                size += CodedOutputStream.computeBytesSize(1, getC2SNcpIdBytes());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static TaskFuncDeskRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (TaskFuncDeskRequest) PARSER.parseFrom(data);
        }


        public static TaskFuncDeskRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (TaskFuncDeskRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static TaskFuncDeskRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (TaskFuncDeskRequest) PARSER.parseFrom(data);
        }


        public static TaskFuncDeskRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (TaskFuncDeskRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static TaskFuncDeskRequest parseFrom(InputStream input) throws IOException {
            return (TaskFuncDeskRequest) PARSER.parseFrom(input);
        }


        public static TaskFuncDeskRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TaskFuncDeskRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static TaskFuncDeskRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (TaskFuncDeskRequest) PARSER.parseDelimitedFrom(input);
        }


        public static TaskFuncDeskRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TaskFuncDeskRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static TaskFuncDeskRequest parseFrom(CodedInputStream input) throws IOException {
            return (TaskFuncDeskRequest) PARSER.parseFrom(input);
        }


        public static TaskFuncDeskRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TaskFuncDeskRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(TaskFuncDeskRequest prototype) {
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
                implements TaskHandler.TaskFuncDeskRequestOrBuilder {
            private int bitField0_;


            private Object c2SNcpId_;


            public static final Descriptors.Descriptor getDescriptor() {
                return TaskHandler.internal_static_pomelo_area_TaskFuncDeskRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return TaskHandler.internal_static_pomelo_area_TaskFuncDeskRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(TaskHandler.TaskFuncDeskRequest.class, Builder.class);
            }


            private Builder() {
                this.c2SNcpId_ = "";
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.c2SNcpId_ = "";
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (TaskHandler.TaskFuncDeskRequest.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.c2SNcpId_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return TaskHandler.internal_static_pomelo_area_TaskFuncDeskRequest_descriptor;
            }


            public TaskHandler.TaskFuncDeskRequest getDefaultInstanceForType() {
                return TaskHandler.TaskFuncDeskRequest.getDefaultInstance();
            }


            public TaskHandler.TaskFuncDeskRequest build() {
                TaskHandler.TaskFuncDeskRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public TaskHandler.TaskFuncDeskRequest buildPartial() {
                TaskHandler.TaskFuncDeskRequest result = new TaskHandler.TaskFuncDeskRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.c2SNcpId_ = this.c2SNcpId_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof TaskHandler.TaskFuncDeskRequest) {
                    return mergeFrom((TaskHandler.TaskFuncDeskRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(TaskHandler.TaskFuncDeskRequest other) {
                if (other == TaskHandler.TaskFuncDeskRequest.getDefaultInstance()) {
                    return this;
                }
                if (other.hasC2SNcpId()) {
                    this.bitField0_ |= 0x1;
                    this.c2SNcpId_ = other.c2SNcpId_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasC2SNcpId()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                TaskHandler.TaskFuncDeskRequest parsedMessage = null;
                try {
                    parsedMessage = (TaskHandler.TaskFuncDeskRequest) TaskHandler.TaskFuncDeskRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (TaskHandler.TaskFuncDeskRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasC2SNcpId() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public String getC2SNcpId() {
                Object ref = this.c2SNcpId_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.c2SNcpId_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }


            public ByteString getC2SNcpIdBytes() {
                Object ref = this.c2SNcpId_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.c2SNcpId_ = b;
                    return b;
                }
                return (ByteString) ref;
            }


            public Builder setC2SNcpId(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x1;
                this.c2SNcpId_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SNcpId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SNcpId_ = TaskHandler.TaskFuncDeskRequest.getDefaultInstance().getC2SNcpId();
                onChanged();
                return this;
            }


            public Builder setC2SNcpIdBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x1;
                this.c2SNcpId_ = value;
                onChanged();
                return this;
            }
        }
    }


    public static final class TaskFuncDeskResponse
            extends GeneratedMessage
            implements TaskFuncDeskResponseOrBuilder {
        private static final TaskFuncDeskResponse defaultInstance = new TaskFuncDeskResponse(true);
        private final UnknownFieldSet unknownFields;

        private TaskFuncDeskResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private TaskFuncDeskResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static TaskFuncDeskResponse getDefaultInstance() {
            return defaultInstance;
        }

        public TaskFuncDeskResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private TaskFuncDeskResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return TaskHandler.internal_static_pomelo_area_TaskFuncDeskResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TaskHandler.internal_static_pomelo_area_TaskFuncDeskResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(TaskFuncDeskResponse.class, Builder.class);
        }

        public static Parser<TaskFuncDeskResponse> PARSER = (Parser<TaskFuncDeskResponse>) new AbstractParser<TaskFuncDeskResponse>() {
            public TaskHandler.TaskFuncDeskResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TaskHandler.TaskFuncDeskResponse(input, extensionRegistry);
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

        public Parser<TaskFuncDeskResponse> getParserForType() {
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


        private void initFields() {
            this.s2CCode_ = 0;
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
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static TaskFuncDeskResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (TaskFuncDeskResponse) PARSER.parseFrom(data);
        }


        public static TaskFuncDeskResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (TaskFuncDeskResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static TaskFuncDeskResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (TaskFuncDeskResponse) PARSER.parseFrom(data);
        }


        public static TaskFuncDeskResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (TaskFuncDeskResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static TaskFuncDeskResponse parseFrom(InputStream input) throws IOException {
            return (TaskFuncDeskResponse) PARSER.parseFrom(input);
        }


        public static TaskFuncDeskResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TaskFuncDeskResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static TaskFuncDeskResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (TaskFuncDeskResponse) PARSER.parseDelimitedFrom(input);
        }


        public static TaskFuncDeskResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TaskFuncDeskResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static TaskFuncDeskResponse parseFrom(CodedInputStream input) throws IOException {
            return (TaskFuncDeskResponse) PARSER.parseFrom(input);
        }


        public static TaskFuncDeskResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TaskFuncDeskResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(TaskFuncDeskResponse prototype) {
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
                implements TaskHandler.TaskFuncDeskResponseOrBuilder {
            private int bitField0_;


            private int s2CCode_;


            private Object s2CMsg_;


            public static final Descriptors.Descriptor getDescriptor() {
                return TaskHandler.internal_static_pomelo_area_TaskFuncDeskResponse_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return TaskHandler.internal_static_pomelo_area_TaskFuncDeskResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(TaskHandler.TaskFuncDeskResponse.class, Builder.class);
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
                if (TaskHandler.TaskFuncDeskResponse.alwaysUseFieldBuilders) ;
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
                return TaskHandler.internal_static_pomelo_area_TaskFuncDeskResponse_descriptor;
            }


            public TaskHandler.TaskFuncDeskResponse getDefaultInstanceForType() {
                return TaskHandler.TaskFuncDeskResponse.getDefaultInstance();
            }


            public TaskHandler.TaskFuncDeskResponse build() {
                TaskHandler.TaskFuncDeskResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public TaskHandler.TaskFuncDeskResponse buildPartial() {
                TaskHandler.TaskFuncDeskResponse result = new TaskHandler.TaskFuncDeskResponse(this);
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
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof TaskHandler.TaskFuncDeskResponse) {
                    return mergeFrom((TaskHandler.TaskFuncDeskResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(TaskHandler.TaskFuncDeskResponse other) {
                if (other == TaskHandler.TaskFuncDeskResponse.getDefaultInstance()) {
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
                TaskHandler.TaskFuncDeskResponse parsedMessage = null;
                try {
                    parsedMessage = (TaskHandler.TaskFuncDeskResponse) TaskHandler.TaskFuncDeskResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (TaskHandler.TaskFuncDeskResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = TaskHandler.TaskFuncDeskResponse.getDefaultInstance().getS2CMsg();
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
        }
    }


    public static final class AcceptLoopTaskRequest
            extends GeneratedMessage
            implements AcceptLoopTaskRequestOrBuilder {
        private static final AcceptLoopTaskRequest defaultInstance = new AcceptLoopTaskRequest(true);
        private final UnknownFieldSet unknownFields;

        private AcceptLoopTaskRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private AcceptLoopTaskRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static AcceptLoopTaskRequest getDefaultInstance() {
            return defaultInstance;
        }

        public AcceptLoopTaskRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AcceptLoopTaskRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return TaskHandler.internal_static_pomelo_area_AcceptLoopTaskRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TaskHandler.internal_static_pomelo_area_AcceptLoopTaskRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(AcceptLoopTaskRequest.class, Builder.class);
        }

        public static Parser<AcceptLoopTaskRequest> PARSER = (Parser<AcceptLoopTaskRequest>) new AbstractParser<AcceptLoopTaskRequest>() {
            public TaskHandler.AcceptLoopTaskRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TaskHandler.AcceptLoopTaskRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_NPCID_FIELD_NUMBER = 1;
        private Object c2SNpcId_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<AcceptLoopTaskRequest> getParserForType() {
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

        public static AcceptLoopTaskRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (AcceptLoopTaskRequest) PARSER.parseFrom(data);
        }

        public static AcceptLoopTaskRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AcceptLoopTaskRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static AcceptLoopTaskRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (AcceptLoopTaskRequest) PARSER.parseFrom(data);
        }

        public static AcceptLoopTaskRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AcceptLoopTaskRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static AcceptLoopTaskRequest parseFrom(InputStream input) throws IOException {
            return (AcceptLoopTaskRequest) PARSER.parseFrom(input);
        }

        public static AcceptLoopTaskRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AcceptLoopTaskRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static AcceptLoopTaskRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (AcceptLoopTaskRequest) PARSER.parseDelimitedFrom(input);
        }

        public static AcceptLoopTaskRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AcceptLoopTaskRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static AcceptLoopTaskRequest parseFrom(CodedInputStream input) throws IOException {
            return (AcceptLoopTaskRequest) PARSER.parseFrom(input);
        }

        public static AcceptLoopTaskRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AcceptLoopTaskRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(AcceptLoopTaskRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements TaskHandler.AcceptLoopTaskRequestOrBuilder {
            private int bitField0_;
            private Object c2SNpcId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return TaskHandler.internal_static_pomelo_area_AcceptLoopTaskRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return TaskHandler.internal_static_pomelo_area_AcceptLoopTaskRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(TaskHandler.AcceptLoopTaskRequest.class, Builder.class);
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
                if (TaskHandler.AcceptLoopTaskRequest.alwaysUseFieldBuilders) ;
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
                return TaskHandler.internal_static_pomelo_area_AcceptLoopTaskRequest_descriptor;
            }

            public TaskHandler.AcceptLoopTaskRequest getDefaultInstanceForType() {
                return TaskHandler.AcceptLoopTaskRequest.getDefaultInstance();
            }

            public TaskHandler.AcceptLoopTaskRequest build() {
                TaskHandler.AcceptLoopTaskRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public TaskHandler.AcceptLoopTaskRequest buildPartial() {
                TaskHandler.AcceptLoopTaskRequest result = new TaskHandler.AcceptLoopTaskRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.c2SNpcId_ = this.c2SNpcId_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof TaskHandler.AcceptLoopTaskRequest)
                    return mergeFrom((TaskHandler.AcceptLoopTaskRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TaskHandler.AcceptLoopTaskRequest other) {
                if (other == TaskHandler.AcceptLoopTaskRequest.getDefaultInstance()) return this;
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
                TaskHandler.AcceptLoopTaskRequest parsedMessage = null;
                try {
                    parsedMessage = (TaskHandler.AcceptLoopTaskRequest) TaskHandler.AcceptLoopTaskRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (TaskHandler.AcceptLoopTaskRequest) e.getUnfinishedMessage();
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
                this.c2SNpcId_ = TaskHandler.AcceptLoopTaskRequest.getDefaultInstance().getC2SNpcId();
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


    public static final class AcceptLoopTaskResponse
            extends GeneratedMessage
            implements AcceptLoopTaskResponseOrBuilder {
        private static final AcceptLoopTaskResponse defaultInstance = new AcceptLoopTaskResponse(true);
        private final UnknownFieldSet unknownFields;

        private AcceptLoopTaskResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private AcceptLoopTaskResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static AcceptLoopTaskResponse getDefaultInstance() {
            return defaultInstance;
        }

        public AcceptLoopTaskResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AcceptLoopTaskResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return TaskHandler.internal_static_pomelo_area_AcceptLoopTaskResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TaskHandler.internal_static_pomelo_area_AcceptLoopTaskResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(AcceptLoopTaskResponse.class, Builder.class);
        }

        public static Parser<AcceptLoopTaskResponse> PARSER = (Parser<AcceptLoopTaskResponse>) new AbstractParser<AcceptLoopTaskResponse>() {
            public TaskHandler.AcceptLoopTaskResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TaskHandler.AcceptLoopTaskResponse(input, extensionRegistry);
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

        public Parser<AcceptLoopTaskResponse> getParserForType() {
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


        private void initFields() {
            this.s2CCode_ = 0;
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
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static AcceptLoopTaskResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (AcceptLoopTaskResponse) PARSER.parseFrom(data);
        }


        public static AcceptLoopTaskResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AcceptLoopTaskResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static AcceptLoopTaskResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (AcceptLoopTaskResponse) PARSER.parseFrom(data);
        }


        public static AcceptLoopTaskResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AcceptLoopTaskResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static AcceptLoopTaskResponse parseFrom(InputStream input) throws IOException {
            return (AcceptLoopTaskResponse) PARSER.parseFrom(input);
        }


        public static AcceptLoopTaskResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AcceptLoopTaskResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static AcceptLoopTaskResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (AcceptLoopTaskResponse) PARSER.parseDelimitedFrom(input);
        }


        public static AcceptLoopTaskResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AcceptLoopTaskResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static AcceptLoopTaskResponse parseFrom(CodedInputStream input) throws IOException {
            return (AcceptLoopTaskResponse) PARSER.parseFrom(input);
        }


        public static AcceptLoopTaskResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AcceptLoopTaskResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(AcceptLoopTaskResponse prototype) {
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
                implements TaskHandler.AcceptLoopTaskResponseOrBuilder {
            private int bitField0_;


            private int s2CCode_;


            private Object s2CMsg_;


            public static final Descriptors.Descriptor getDescriptor() {
                return TaskHandler.internal_static_pomelo_area_AcceptLoopTaskResponse_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return TaskHandler.internal_static_pomelo_area_AcceptLoopTaskResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(TaskHandler.AcceptLoopTaskResponse.class, Builder.class);
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
                if (TaskHandler.AcceptLoopTaskResponse.alwaysUseFieldBuilders) ;
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
                return TaskHandler.internal_static_pomelo_area_AcceptLoopTaskResponse_descriptor;
            }


            public TaskHandler.AcceptLoopTaskResponse getDefaultInstanceForType() {
                return TaskHandler.AcceptLoopTaskResponse.getDefaultInstance();
            }


            public TaskHandler.AcceptLoopTaskResponse build() {
                TaskHandler.AcceptLoopTaskResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public TaskHandler.AcceptLoopTaskResponse buildPartial() {
                TaskHandler.AcceptLoopTaskResponse result = new TaskHandler.AcceptLoopTaskResponse(this);
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
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof TaskHandler.AcceptLoopTaskResponse) {
                    return mergeFrom((TaskHandler.AcceptLoopTaskResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(TaskHandler.AcceptLoopTaskResponse other) {
                if (other == TaskHandler.AcceptLoopTaskResponse.getDefaultInstance()) {
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
                TaskHandler.AcceptLoopTaskResponse parsedMessage = null;
                try {
                    parsedMessage = (TaskHandler.AcceptLoopTaskResponse) TaskHandler.AcceptLoopTaskResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (TaskHandler.AcceptLoopTaskResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = TaskHandler.AcceptLoopTaskResponse.getDefaultInstance().getS2CMsg();
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
        }
    }


    public static final class AcceptDailyTaskRequest
            extends GeneratedMessage
            implements AcceptDailyTaskRequestOrBuilder {
        private static final AcceptDailyTaskRequest defaultInstance = new AcceptDailyTaskRequest(true);
        private final UnknownFieldSet unknownFields;

        private AcceptDailyTaskRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private AcceptDailyTaskRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static AcceptDailyTaskRequest getDefaultInstance() {
            return defaultInstance;
        }

        public AcceptDailyTaskRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AcceptDailyTaskRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return TaskHandler.internal_static_pomelo_area_AcceptDailyTaskRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TaskHandler.internal_static_pomelo_area_AcceptDailyTaskRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(AcceptDailyTaskRequest.class, Builder.class);
        }

        public static Parser<AcceptDailyTaskRequest> PARSER = (Parser<AcceptDailyTaskRequest>) new AbstractParser<AcceptDailyTaskRequest>() {
            public TaskHandler.AcceptDailyTaskRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TaskHandler.AcceptDailyTaskRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_NPCID_FIELD_NUMBER = 1;
        private Object c2SNpcId_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<AcceptDailyTaskRequest> getParserForType() {
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

        public static AcceptDailyTaskRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (AcceptDailyTaskRequest) PARSER.parseFrom(data);
        }

        public static AcceptDailyTaskRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AcceptDailyTaskRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static AcceptDailyTaskRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (AcceptDailyTaskRequest) PARSER.parseFrom(data);
        }

        public static AcceptDailyTaskRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AcceptDailyTaskRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static AcceptDailyTaskRequest parseFrom(InputStream input) throws IOException {
            return (AcceptDailyTaskRequest) PARSER.parseFrom(input);
        }

        public static AcceptDailyTaskRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AcceptDailyTaskRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static AcceptDailyTaskRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (AcceptDailyTaskRequest) PARSER.parseDelimitedFrom(input);
        }

        public static AcceptDailyTaskRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AcceptDailyTaskRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static AcceptDailyTaskRequest parseFrom(CodedInputStream input) throws IOException {
            return (AcceptDailyTaskRequest) PARSER.parseFrom(input);
        }

        public static AcceptDailyTaskRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AcceptDailyTaskRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(AcceptDailyTaskRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements TaskHandler.AcceptDailyTaskRequestOrBuilder {
            private int bitField0_;
            private Object c2SNpcId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return TaskHandler.internal_static_pomelo_area_AcceptDailyTaskRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return TaskHandler.internal_static_pomelo_area_AcceptDailyTaskRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(TaskHandler.AcceptDailyTaskRequest.class, Builder.class);
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
                if (TaskHandler.AcceptDailyTaskRequest.alwaysUseFieldBuilders) ;
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
                return TaskHandler.internal_static_pomelo_area_AcceptDailyTaskRequest_descriptor;
            }

            public TaskHandler.AcceptDailyTaskRequest getDefaultInstanceForType() {
                return TaskHandler.AcceptDailyTaskRequest.getDefaultInstance();
            }

            public TaskHandler.AcceptDailyTaskRequest build() {
                TaskHandler.AcceptDailyTaskRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public TaskHandler.AcceptDailyTaskRequest buildPartial() {
                TaskHandler.AcceptDailyTaskRequest result = new TaskHandler.AcceptDailyTaskRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.c2SNpcId_ = this.c2SNpcId_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof TaskHandler.AcceptDailyTaskRequest)
                    return mergeFrom((TaskHandler.AcceptDailyTaskRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TaskHandler.AcceptDailyTaskRequest other) {
                if (other == TaskHandler.AcceptDailyTaskRequest.getDefaultInstance()) return this;
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
                TaskHandler.AcceptDailyTaskRequest parsedMessage = null;
                try {
                    parsedMessage = (TaskHandler.AcceptDailyTaskRequest) TaskHandler.AcceptDailyTaskRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (TaskHandler.AcceptDailyTaskRequest) e.getUnfinishedMessage();
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
                this.c2SNpcId_ = TaskHandler.AcceptDailyTaskRequest.getDefaultInstance().getC2SNpcId();
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


    public static final class AcceptDailyTaskResponse
            extends GeneratedMessage
            implements AcceptDailyTaskResponseOrBuilder {
        private static final AcceptDailyTaskResponse defaultInstance = new AcceptDailyTaskResponse(true);
        private final UnknownFieldSet unknownFields;

        private AcceptDailyTaskResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private AcceptDailyTaskResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static AcceptDailyTaskResponse getDefaultInstance() {
            return defaultInstance;
        }

        public AcceptDailyTaskResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AcceptDailyTaskResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return TaskHandler.internal_static_pomelo_area_AcceptDailyTaskResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TaskHandler.internal_static_pomelo_area_AcceptDailyTaskResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(AcceptDailyTaskResponse.class, Builder.class);
        }

        public static Parser<AcceptDailyTaskResponse> PARSER = (Parser<AcceptDailyTaskResponse>) new AbstractParser<AcceptDailyTaskResponse>() {
            public TaskHandler.AcceptDailyTaskResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TaskHandler.AcceptDailyTaskResponse(input, extensionRegistry);
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

        public Parser<AcceptDailyTaskResponse> getParserForType() {
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


        private void initFields() {
            this.s2CCode_ = 0;
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
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static AcceptDailyTaskResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (AcceptDailyTaskResponse) PARSER.parseFrom(data);
        }


        public static AcceptDailyTaskResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AcceptDailyTaskResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static AcceptDailyTaskResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (AcceptDailyTaskResponse) PARSER.parseFrom(data);
        }


        public static AcceptDailyTaskResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AcceptDailyTaskResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static AcceptDailyTaskResponse parseFrom(InputStream input) throws IOException {
            return (AcceptDailyTaskResponse) PARSER.parseFrom(input);
        }


        public static AcceptDailyTaskResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AcceptDailyTaskResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static AcceptDailyTaskResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (AcceptDailyTaskResponse) PARSER.parseDelimitedFrom(input);
        }


        public static AcceptDailyTaskResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AcceptDailyTaskResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static AcceptDailyTaskResponse parseFrom(CodedInputStream input) throws IOException {
            return (AcceptDailyTaskResponse) PARSER.parseFrom(input);
        }


        public static AcceptDailyTaskResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AcceptDailyTaskResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(AcceptDailyTaskResponse prototype) {
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
                implements TaskHandler.AcceptDailyTaskResponseOrBuilder {
            private int bitField0_;


            private int s2CCode_;


            private Object s2CMsg_;


            public static final Descriptors.Descriptor getDescriptor() {
                return TaskHandler.internal_static_pomelo_area_AcceptDailyTaskResponse_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return TaskHandler.internal_static_pomelo_area_AcceptDailyTaskResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(TaskHandler.AcceptDailyTaskResponse.class, Builder.class);
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
                if (TaskHandler.AcceptDailyTaskResponse.alwaysUseFieldBuilders) ;
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
                return TaskHandler.internal_static_pomelo_area_AcceptDailyTaskResponse_descriptor;
            }


            public TaskHandler.AcceptDailyTaskResponse getDefaultInstanceForType() {
                return TaskHandler.AcceptDailyTaskResponse.getDefaultInstance();
            }


            public TaskHandler.AcceptDailyTaskResponse build() {
                TaskHandler.AcceptDailyTaskResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public TaskHandler.AcceptDailyTaskResponse buildPartial() {
                TaskHandler.AcceptDailyTaskResponse result = new TaskHandler.AcceptDailyTaskResponse(this);
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
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof TaskHandler.AcceptDailyTaskResponse) {
                    return mergeFrom((TaskHandler.AcceptDailyTaskResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(TaskHandler.AcceptDailyTaskResponse other) {
                if (other == TaskHandler.AcceptDailyTaskResponse.getDefaultInstance()) {
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
                TaskHandler.AcceptDailyTaskResponse parsedMessage = null;
                try {
                    parsedMessage = (TaskHandler.AcceptDailyTaskResponse) TaskHandler.AcceptDailyTaskResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (TaskHandler.AcceptDailyTaskResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = TaskHandler.AcceptDailyTaskResponse.getDefaultInstance().getS2CMsg();
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
        }
    }


    public static final class CjPlayEndNotify
            extends GeneratedMessage
            implements CjPlayEndNotifyOrBuilder {
        private static final CjPlayEndNotify defaultInstance = new CjPlayEndNotify(true);
        private final UnknownFieldSet unknownFields;

        private CjPlayEndNotify(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private CjPlayEndNotify(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static CjPlayEndNotify getDefaultInstance() {
            return defaultInstance;
        }

        public CjPlayEndNotify getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CjPlayEndNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return TaskHandler.internal_static_pomelo_area_CjPlayEndNotify_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TaskHandler.internal_static_pomelo_area_CjPlayEndNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(CjPlayEndNotify.class, Builder.class);
        }

        public static Parser<CjPlayEndNotify> PARSER = (Parser<CjPlayEndNotify>) new AbstractParser<CjPlayEndNotify>() {
            public TaskHandler.CjPlayEndNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TaskHandler.CjPlayEndNotify(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_MSG_FIELD_NUMBER = 1;
        private Object s2CMsg_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<CjPlayEndNotify> getParserForType() {
            return PARSER;
        }

        public boolean hasS2CMsg() {
            return ((this.bitField0_ & 0x1) == 1);
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
            this.s2CMsg_ = "";
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
            if ((this.bitField0_ & 0x1) == 1) output.writeBytes(1, getS2CMsgBytes());
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeBytesSize(1, getS2CMsgBytes());
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static CjPlayEndNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (CjPlayEndNotify) PARSER.parseFrom(data);
        }

        public static CjPlayEndNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (CjPlayEndNotify) PARSER.parseFrom(data, extensionRegistry);
        }

        public static CjPlayEndNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (CjPlayEndNotify) PARSER.parseFrom(data);
        }

        public static CjPlayEndNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (CjPlayEndNotify) PARSER.parseFrom(data, extensionRegistry);
        }

        public static CjPlayEndNotify parseFrom(InputStream input) throws IOException {
            return (CjPlayEndNotify) PARSER.parseFrom(input);
        }

        public static CjPlayEndNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CjPlayEndNotify) PARSER.parseFrom(input, extensionRegistry);
        }

        public static CjPlayEndNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (CjPlayEndNotify) PARSER.parseDelimitedFrom(input);
        }

        public static CjPlayEndNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CjPlayEndNotify) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static CjPlayEndNotify parseFrom(CodedInputStream input) throws IOException {
            return (CjPlayEndNotify) PARSER.parseFrom(input);
        }

        public static CjPlayEndNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CjPlayEndNotify) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CjPlayEndNotify prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements TaskHandler.CjPlayEndNotifyOrBuilder {
            private int bitField0_;
            private Object s2CMsg_;

            public static final Descriptors.Descriptor getDescriptor() {
                return TaskHandler.internal_static_pomelo_area_CjPlayEndNotify_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return TaskHandler.internal_static_pomelo_area_CjPlayEndNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(TaskHandler.CjPlayEndNotify.class, Builder.class);
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
                if (TaskHandler.CjPlayEndNotify.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.s2CMsg_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return TaskHandler.internal_static_pomelo_area_CjPlayEndNotify_descriptor;
            }

            public TaskHandler.CjPlayEndNotify getDefaultInstanceForType() {
                return TaskHandler.CjPlayEndNotify.getDefaultInstance();
            }

            public TaskHandler.CjPlayEndNotify build() {
                TaskHandler.CjPlayEndNotify result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public TaskHandler.CjPlayEndNotify buildPartial() {
                TaskHandler.CjPlayEndNotify result = new TaskHandler.CjPlayEndNotify(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.s2CMsg_ = this.s2CMsg_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof TaskHandler.CjPlayEndNotify) return mergeFrom((TaskHandler.CjPlayEndNotify) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TaskHandler.CjPlayEndNotify other) {
                if (other == TaskHandler.CjPlayEndNotify.getDefaultInstance()) return this;
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x1;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                TaskHandler.CjPlayEndNotify parsedMessage = null;
                try {
                    parsedMessage = (TaskHandler.CjPlayEndNotify) TaskHandler.CjPlayEndNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (TaskHandler.CjPlayEndNotify) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasS2CMsg() {
                return ((this.bitField0_ & 0x1) == 1);
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
                this.bitField0_ |= 0x1;
                this.s2CMsg_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CMsg() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.s2CMsg_ = TaskHandler.CjPlayEndNotify.getDefaultInstance().getS2CMsg();
                onChanged();
                return this;
            }

            public Builder setS2CMsgBytes(ByteString value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.s2CMsg_ = value;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class ReachTreasurePointRequest
            extends GeneratedMessage
            implements ReachTreasurePointRequestOrBuilder {
        private static final ReachTreasurePointRequest defaultInstance = new ReachTreasurePointRequest(true);
        private final UnknownFieldSet unknownFields;

        private ReachTreasurePointRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private ReachTreasurePointRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static ReachTreasurePointRequest getDefaultInstance() {
            return defaultInstance;
        }

        public ReachTreasurePointRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ReachTreasurePointRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return TaskHandler.internal_static_pomelo_area_ReachTreasurePointRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TaskHandler.internal_static_pomelo_area_ReachTreasurePointRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ReachTreasurePointRequest.class, Builder.class);
        }

        public static Parser<ReachTreasurePointRequest> PARSER = (Parser<ReachTreasurePointRequest>) new AbstractParser<ReachTreasurePointRequest>() {
            public TaskHandler.ReachTreasurePointRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TaskHandler.ReachTreasurePointRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int POINT_FIELD_NUMBER = 1;
        private int point_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<ReachTreasurePointRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasPoint() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getPoint() {
            return this.point_;
        }

        private void initFields() {
            this.point_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasPoint()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.point_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.point_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static ReachTreasurePointRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ReachTreasurePointRequest) PARSER.parseFrom(data);
        }

        public static ReachTreasurePointRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ReachTreasurePointRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static ReachTreasurePointRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ReachTreasurePointRequest) PARSER.parseFrom(data);
        }

        public static ReachTreasurePointRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ReachTreasurePointRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static ReachTreasurePointRequest parseFrom(InputStream input) throws IOException {
            return (ReachTreasurePointRequest) PARSER.parseFrom(input);
        }

        public static ReachTreasurePointRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReachTreasurePointRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static ReachTreasurePointRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (ReachTreasurePointRequest) PARSER.parseDelimitedFrom(input);
        }

        public static ReachTreasurePointRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReachTreasurePointRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static ReachTreasurePointRequest parseFrom(CodedInputStream input) throws IOException {
            return (ReachTreasurePointRequest) PARSER.parseFrom(input);
        }

        public static ReachTreasurePointRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReachTreasurePointRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(ReachTreasurePointRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements TaskHandler.ReachTreasurePointRequestOrBuilder {
            private int bitField0_;
            private int point_;

            public static final Descriptors.Descriptor getDescriptor() {
                return TaskHandler.internal_static_pomelo_area_ReachTreasurePointRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return TaskHandler.internal_static_pomelo_area_ReachTreasurePointRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(TaskHandler.ReachTreasurePointRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TaskHandler.ReachTreasurePointRequest.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.point_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return TaskHandler.internal_static_pomelo_area_ReachTreasurePointRequest_descriptor;
            }

            public TaskHandler.ReachTreasurePointRequest getDefaultInstanceForType() {
                return TaskHandler.ReachTreasurePointRequest.getDefaultInstance();
            }

            public TaskHandler.ReachTreasurePointRequest build() {
                TaskHandler.ReachTreasurePointRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public TaskHandler.ReachTreasurePointRequest buildPartial() {
                TaskHandler.ReachTreasurePointRequest result = new TaskHandler.ReachTreasurePointRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.point_ = this.point_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof TaskHandler.ReachTreasurePointRequest)
                    return mergeFrom((TaskHandler.ReachTreasurePointRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TaskHandler.ReachTreasurePointRequest other) {
                if (other == TaskHandler.ReachTreasurePointRequest.getDefaultInstance()) return this;
                if (other.hasPoint()) setPoint(other.getPoint());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasPoint()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                TaskHandler.ReachTreasurePointRequest parsedMessage = null;
                try {
                    parsedMessage = (TaskHandler.ReachTreasurePointRequest) TaskHandler.ReachTreasurePointRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (TaskHandler.ReachTreasurePointRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasPoint() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getPoint() {
                return this.point_;
            }

            public Builder setPoint(int value) {
                this.bitField0_ |= 0x1;
                this.point_ = value;
                onChanged();
                return this;
            }

            public Builder clearPoint() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.point_ = 0;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class ReachTreasurePointResponse
            extends GeneratedMessage
            implements ReachTreasurePointResponseOrBuilder {
        private static final ReachTreasurePointResponse defaultInstance = new ReachTreasurePointResponse(true);
        private final UnknownFieldSet unknownFields;

        private ReachTreasurePointResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private ReachTreasurePointResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static ReachTreasurePointResponse getDefaultInstance() {
            return defaultInstance;
        }

        public ReachTreasurePointResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ReachTreasurePointResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return TaskHandler.internal_static_pomelo_area_ReachTreasurePointResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TaskHandler.internal_static_pomelo_area_ReachTreasurePointResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ReachTreasurePointResponse.class, Builder.class);
        }

        public static Parser<ReachTreasurePointResponse> PARSER = (Parser<ReachTreasurePointResponse>) new AbstractParser<ReachTreasurePointResponse>() {
            public TaskHandler.ReachTreasurePointResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TaskHandler.ReachTreasurePointResponse(input, extensionRegistry);
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

        public Parser<ReachTreasurePointResponse> getParserForType() {
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


        private void initFields() {
            this.s2CCode_ = 0;
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
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static ReachTreasurePointResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ReachTreasurePointResponse) PARSER.parseFrom(data);
        }


        public static ReachTreasurePointResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ReachTreasurePointResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static ReachTreasurePointResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ReachTreasurePointResponse) PARSER.parseFrom(data);
        }


        public static ReachTreasurePointResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ReachTreasurePointResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static ReachTreasurePointResponse parseFrom(InputStream input) throws IOException {
            return (ReachTreasurePointResponse) PARSER.parseFrom(input);
        }


        public static ReachTreasurePointResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReachTreasurePointResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static ReachTreasurePointResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (ReachTreasurePointResponse) PARSER.parseDelimitedFrom(input);
        }


        public static ReachTreasurePointResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReachTreasurePointResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static ReachTreasurePointResponse parseFrom(CodedInputStream input) throws IOException {
            return (ReachTreasurePointResponse) PARSER.parseFrom(input);
        }


        public static ReachTreasurePointResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReachTreasurePointResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(ReachTreasurePointResponse prototype) {
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
                implements TaskHandler.ReachTreasurePointResponseOrBuilder {
            private int bitField0_;


            private int s2CCode_;


            private Object s2CMsg_;


            public static final Descriptors.Descriptor getDescriptor() {
                return TaskHandler.internal_static_pomelo_area_ReachTreasurePointResponse_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return TaskHandler.internal_static_pomelo_area_ReachTreasurePointResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(TaskHandler.ReachTreasurePointResponse.class, Builder.class);
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
                if (TaskHandler.ReachTreasurePointResponse.alwaysUseFieldBuilders) ;
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
                return TaskHandler.internal_static_pomelo_area_ReachTreasurePointResponse_descriptor;
            }


            public TaskHandler.ReachTreasurePointResponse getDefaultInstanceForType() {
                return TaskHandler.ReachTreasurePointResponse.getDefaultInstance();
            }


            public TaskHandler.ReachTreasurePointResponse build() {
                TaskHandler.ReachTreasurePointResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public TaskHandler.ReachTreasurePointResponse buildPartial() {
                TaskHandler.ReachTreasurePointResponse result = new TaskHandler.ReachTreasurePointResponse(this);
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
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof TaskHandler.ReachTreasurePointResponse) {
                    return mergeFrom((TaskHandler.ReachTreasurePointResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(TaskHandler.ReachTreasurePointResponse other) {
                if (other == TaskHandler.ReachTreasurePointResponse.getDefaultInstance()) {
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
                TaskHandler.ReachTreasurePointResponse parsedMessage = null;
                try {
                    parsedMessage = (TaskHandler.ReachTreasurePointResponse) TaskHandler.ReachTreasurePointResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (TaskHandler.ReachTreasurePointResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = TaskHandler.ReachTreasurePointResponse.getDefaultInstance().getS2CMsg();
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
        }
    }


    public static final class TaskUpdatePush
            extends GeneratedMessage
            implements TaskUpdatePushOrBuilder {
        private static final TaskUpdatePush defaultInstance = new TaskUpdatePush(true);
        private final UnknownFieldSet unknownFields;

        private TaskUpdatePush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private TaskUpdatePush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static TaskUpdatePush getDefaultInstance() {
            return defaultInstance;
        }

        public TaskUpdatePush getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private TaskUpdatePush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    TaskOuterClass.Tasks.Builder subBuilder;
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        case 18:
                            subBuilder = null;
                            if ((this.bitField0_ & 0x1) == 1) subBuilder = this.s2CData_.toBuilder();
                            this.s2CData_ = (TaskOuterClass.Tasks) input.readMessage(TaskOuterClass.Tasks.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.s2CData_);
                                this.s2CData_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 0x1;
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
            return TaskHandler.internal_static_pomelo_area_TaskUpdatePush_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TaskHandler.internal_static_pomelo_area_TaskUpdatePush_fieldAccessorTable.ensureFieldAccessorsInitialized(TaskUpdatePush.class, Builder.class);
        }

        public static Parser<TaskUpdatePush> PARSER = (Parser<TaskUpdatePush>) new AbstractParser<TaskUpdatePush>() {
            public TaskHandler.TaskUpdatePush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TaskHandler.TaskUpdatePush(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_DATA_FIELD_NUMBER = 2;
        private TaskOuterClass.Tasks s2CData_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<TaskUpdatePush> getParserForType() {
            return PARSER;
        }

        public boolean hasS2CData() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public TaskOuterClass.Tasks getS2CData() {
            return this.s2CData_;
        }

        public TaskOuterClass.TasksOrBuilder getS2CDataOrBuilder() {
            return (TaskOuterClass.TasksOrBuilder) this.s2CData_;
        }

        static {
            defaultInstance.initFields();
        }


        private void initFields() {
            this.s2CData_ = TaskOuterClass.Tasks.getDefaultInstance();
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
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
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeMessage(2, (MessageLite) this.s2CData_);
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
                size += CodedOutputStream.computeMessageSize(2, (MessageLite) this.s2CData_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static TaskUpdatePush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (TaskUpdatePush) PARSER.parseFrom(data);
        }


        public static TaskUpdatePush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (TaskUpdatePush) PARSER.parseFrom(data, extensionRegistry);
        }


        public static TaskUpdatePush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (TaskUpdatePush) PARSER.parseFrom(data);
        }


        public static TaskUpdatePush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (TaskUpdatePush) PARSER.parseFrom(data, extensionRegistry);
        }


        public static TaskUpdatePush parseFrom(InputStream input) throws IOException {
            return (TaskUpdatePush) PARSER.parseFrom(input);
        }


        public static TaskUpdatePush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TaskUpdatePush) PARSER.parseFrom(input, extensionRegistry);
        }


        public static TaskUpdatePush parseDelimitedFrom(InputStream input) throws IOException {
            return (TaskUpdatePush) PARSER.parseDelimitedFrom(input);
        }


        public static TaskUpdatePush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TaskUpdatePush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static TaskUpdatePush parseFrom(CodedInputStream input) throws IOException {
            return (TaskUpdatePush) PARSER.parseFrom(input);
        }


        public static TaskUpdatePush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TaskUpdatePush) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(TaskUpdatePush prototype) {
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
                implements TaskHandler.TaskUpdatePushOrBuilder {
            private int bitField0_;


            private TaskOuterClass.Tasks s2CData_;


            private SingleFieldBuilder<TaskOuterClass.Tasks, TaskOuterClass.Tasks.Builder, TaskOuterClass.TasksOrBuilder> s2CDataBuilder_;


            public static final Descriptors.Descriptor getDescriptor() {
                return TaskHandler.internal_static_pomelo_area_TaskUpdatePush_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return TaskHandler.internal_static_pomelo_area_TaskUpdatePush_fieldAccessorTable.ensureFieldAccessorsInitialized(TaskHandler.TaskUpdatePush.class, Builder.class);
            }


            private Builder() {
                this.s2CData_ = TaskOuterClass.Tasks.getDefaultInstance();
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CData_ = TaskOuterClass.Tasks.getDefaultInstance();
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (TaskHandler.TaskUpdatePush.alwaysUseFieldBuilders) {
                    getS2CDataFieldBuilder();
                }
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                if (this.s2CDataBuilder_ == null) {
                    this.s2CData_ = TaskOuterClass.Tasks.getDefaultInstance();
                } else {
                    this.s2CDataBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return TaskHandler.internal_static_pomelo_area_TaskUpdatePush_descriptor;
            }


            public TaskHandler.TaskUpdatePush getDefaultInstanceForType() {
                return TaskHandler.TaskUpdatePush.getDefaultInstance();
            }


            public TaskHandler.TaskUpdatePush build() {
                TaskHandler.TaskUpdatePush result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public TaskHandler.TaskUpdatePush buildPartial() {
                TaskHandler.TaskUpdatePush result = new TaskHandler.TaskUpdatePush(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                if (this.s2CDataBuilder_ == null) {
                    result.s2CData_ = this.s2CData_;
                } else {
                    result.s2CData_ = (TaskOuterClass.Tasks) this.s2CDataBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof TaskHandler.TaskUpdatePush) {
                    return mergeFrom((TaskHandler.TaskUpdatePush) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(TaskHandler.TaskUpdatePush other) {
                if (other == TaskHandler.TaskUpdatePush.getDefaultInstance()) {
                    return this;
                }
                if (other.hasS2CData()) {
                    mergeS2CData(other.getS2CData());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (hasS2CData() && !getS2CData().isInitialized()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                TaskHandler.TaskUpdatePush parsedMessage = null;
                try {
                    parsedMessage = (TaskHandler.TaskUpdatePush) TaskHandler.TaskUpdatePush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (TaskHandler.TaskUpdatePush) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasS2CData() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public TaskOuterClass.Tasks getS2CData() {
                if (this.s2CDataBuilder_ == null) {
                    return this.s2CData_;
                }
                return (TaskOuterClass.Tasks) this.s2CDataBuilder_.getMessage();
            }


            public Builder setS2CData(TaskOuterClass.Tasks value) {
                if (this.s2CDataBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.s2CData_ = value;
                    onChanged();
                } else {
                    this.s2CDataBuilder_.setMessage((GeneratedMessage) value);
                }
                this.bitField0_ |= 0x1;
                return this;
            }


            public Builder setS2CData(TaskOuterClass.Tasks.Builder builderForValue) {
                if (this.s2CDataBuilder_ == null) {
                    this.s2CData_ = builderForValue.build();
                    onChanged();
                } else {
                    this.s2CDataBuilder_.setMessage((GeneratedMessage) builderForValue.build());
                }
                this.bitField0_ |= 0x1;
                return this;
            }


            public Builder mergeS2CData(TaskOuterClass.Tasks value) {
                if (this.s2CDataBuilder_ == null) {
                    if ((this.bitField0_ & 0x1) == 1 && this.s2CData_ != TaskOuterClass.Tasks.getDefaultInstance()) {
                        this.s2CData_ = TaskOuterClass.Tasks.newBuilder(this.s2CData_).mergeFrom(value).buildPartial();
                    } else {
                        this.s2CData_ = value;
                    }
                    onChanged();
                } else {
                    this.s2CDataBuilder_.mergeFrom((GeneratedMessage) value);
                }
                this.bitField0_ |= 0x1;
                return this;
            }


            public Builder clearS2CData() {
                if (this.s2CDataBuilder_ == null) {
                    this.s2CData_ = TaskOuterClass.Tasks.getDefaultInstance();
                    onChanged();
                } else {
                    this.s2CDataBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }


            public TaskOuterClass.Tasks.Builder getS2CDataBuilder() {
                this.bitField0_ |= 0x1;
                onChanged();
                return (TaskOuterClass.Tasks.Builder) getS2CDataFieldBuilder().getBuilder();
            }


            public TaskOuterClass.TasksOrBuilder getS2CDataOrBuilder() {
                if (this.s2CDataBuilder_ != null) {
                    return (TaskOuterClass.TasksOrBuilder) this.s2CDataBuilder_.getMessageOrBuilder();
                }
                return (TaskOuterClass.TasksOrBuilder) this.s2CData_;
            }


            private SingleFieldBuilder<TaskOuterClass.Tasks, TaskOuterClass.Tasks.Builder, TaskOuterClass.TasksOrBuilder> getS2CDataFieldBuilder() {
                if (this.s2CDataBuilder_ == null) {
                    this.s2CDataBuilder_ = new SingleFieldBuilder((GeneratedMessage) getS2CData(), getParentForChildren(), isClean());
                    this.s2CData_ = null;
                }
                return this.s2CDataBuilder_;
            }
        }
    }


    public static final class TaskAutoPush
            extends GeneratedMessage
            implements TaskAutoPushOrBuilder {
        private static final TaskAutoPush defaultInstance = new TaskAutoPush(true);
        private final UnknownFieldSet unknownFields;

        private TaskAutoPush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private TaskAutoPush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static TaskAutoPush getDefaultInstance() {
            return defaultInstance;
        }

        public TaskAutoPush getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private TaskAutoPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.auto_ = input.readInt32();
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
            return TaskHandler.internal_static_pomelo_area_TaskAutoPush_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TaskHandler.internal_static_pomelo_area_TaskAutoPush_fieldAccessorTable.ensureFieldAccessorsInitialized(TaskAutoPush.class, Builder.class);
        }

        public static Parser<TaskAutoPush> PARSER = (Parser<TaskAutoPush>) new AbstractParser<TaskAutoPush>() {
            public TaskHandler.TaskAutoPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TaskHandler.TaskAutoPush(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int AUTO_FIELD_NUMBER = 1;
        private int auto_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<TaskAutoPush> getParserForType() {
            return PARSER;
        }

        public boolean hasAuto() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getAuto() {
            return this.auto_;
        }

        private void initFields() {
            this.auto_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasAuto()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.auto_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.auto_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static TaskAutoPush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (TaskAutoPush) PARSER.parseFrom(data);
        }

        public static TaskAutoPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (TaskAutoPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static TaskAutoPush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (TaskAutoPush) PARSER.parseFrom(data);
        }

        public static TaskAutoPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (TaskAutoPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static TaskAutoPush parseFrom(InputStream input) throws IOException {
            return (TaskAutoPush) PARSER.parseFrom(input);
        }

        public static TaskAutoPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TaskAutoPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static TaskAutoPush parseDelimitedFrom(InputStream input) throws IOException {
            return (TaskAutoPush) PARSER.parseDelimitedFrom(input);
        }

        public static TaskAutoPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TaskAutoPush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static TaskAutoPush parseFrom(CodedInputStream input) throws IOException {
            return (TaskAutoPush) PARSER.parseFrom(input);
        }

        public static TaskAutoPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TaskAutoPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(TaskAutoPush prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements TaskHandler.TaskAutoPushOrBuilder {
            private int bitField0_;
            private int auto_;

            public static final Descriptors.Descriptor getDescriptor() {
                return TaskHandler.internal_static_pomelo_area_TaskAutoPush_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return TaskHandler.internal_static_pomelo_area_TaskAutoPush_fieldAccessorTable.ensureFieldAccessorsInitialized(TaskHandler.TaskAutoPush.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TaskHandler.TaskAutoPush.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.auto_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return TaskHandler.internal_static_pomelo_area_TaskAutoPush_descriptor;
            }

            public TaskHandler.TaskAutoPush getDefaultInstanceForType() {
                return TaskHandler.TaskAutoPush.getDefaultInstance();
            }

            public TaskHandler.TaskAutoPush build() {
                TaskHandler.TaskAutoPush result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public TaskHandler.TaskAutoPush buildPartial() {
                TaskHandler.TaskAutoPush result = new TaskHandler.TaskAutoPush(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.auto_ = this.auto_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof TaskHandler.TaskAutoPush) return mergeFrom((TaskHandler.TaskAutoPush) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TaskHandler.TaskAutoPush other) {
                if (other == TaskHandler.TaskAutoPush.getDefaultInstance()) return this;
                if (other.hasAuto()) setAuto(other.getAuto());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasAuto()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                TaskHandler.TaskAutoPush parsedMessage = null;
                try {
                    parsedMessage = (TaskHandler.TaskAutoPush) TaskHandler.TaskAutoPush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (TaskHandler.TaskAutoPush) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasAuto() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getAuto() {
                return this.auto_;
            }

            public Builder setAuto(int value) {
                this.bitField0_ |= 0x1;
                this.auto_ = value;
                onChanged();
                return this;
            }

            public Builder clearAuto() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.auto_ = 0;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class TreasureScenePointPush
            extends GeneratedMessage
            implements TreasureScenePointPushOrBuilder {
        private final UnknownFieldSet unknownFields;


        private TreasureScenePointPush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }


        private TreasureScenePointPush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }


        public static TreasureScenePointPush getDefaultInstance() {
            return defaultInstance;
        }


        public TreasureScenePointPush getDefaultInstanceForType() {
            return defaultInstance;
        }


        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }


        private TreasureScenePointPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.sceneId_ = input.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.point_ = input.readInt32();
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.taskId_ = input.readInt32();
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
            return TaskHandler.internal_static_pomelo_area_TreasureScenePointPush_descriptor;
        }


        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TaskHandler.internal_static_pomelo_area_TreasureScenePointPush_fieldAccessorTable.ensureFieldAccessorsInitialized(TreasureScenePointPush.class, Builder.class);
        }


        public static Parser<TreasureScenePointPush> PARSER = (Parser<TreasureScenePointPush>) new AbstractParser<TreasureScenePointPush>() {
            public TaskHandler.TreasureScenePointPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TaskHandler.TreasureScenePointPush(input, extensionRegistry);
            }
        };


        private int bitField0_;


        public static final int SCENEID_FIELD_NUMBER = 1;


        private int sceneId_;


        public static final int POINT_FIELD_NUMBER = 2;


        private int point_;


        public static final int TASKID_FIELD_NUMBER = 3;


        private int taskId_;


        private byte memoizedIsInitialized;


        private int memoizedSerializedSize;


        private static final long serialVersionUID = 0L;


        public Parser<TreasureScenePointPush> getParserForType() {
            return PARSER;
        }


        public boolean hasSceneId() {
            return ((this.bitField0_ & 0x1) == 1);
        }


        public int getSceneId() {
            return this.sceneId_;
        }


        public boolean hasPoint() {
            return ((this.bitField0_ & 0x2) == 2);
        }


        private static final TreasureScenePointPush defaultInstance = new TreasureScenePointPush(true);

        public int getPoint() {
            return this.point_;
        }

        public boolean hasTaskId() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getTaskId() {
            return this.taskId_;
        }

        private void initFields() {
            this.sceneId_ = 0;
            this.point_ = 0;
            this.taskId_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasSceneId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasPoint()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasTaskId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.sceneId_);
            if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.point_);
            if ((this.bitField0_ & 0x4) == 4) output.writeInt32(3, this.taskId_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.sceneId_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(2, this.point_);
            if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeInt32Size(3, this.taskId_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static TreasureScenePointPush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (TreasureScenePointPush) PARSER.parseFrom(data);
        }

        public static TreasureScenePointPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (TreasureScenePointPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static TreasureScenePointPush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (TreasureScenePointPush) PARSER.parseFrom(data);
        }

        public static TreasureScenePointPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (TreasureScenePointPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static TreasureScenePointPush parseFrom(InputStream input) throws IOException {
            return (TreasureScenePointPush) PARSER.parseFrom(input);
        }

        public static TreasureScenePointPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TreasureScenePointPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static TreasureScenePointPush parseDelimitedFrom(InputStream input) throws IOException {
            return (TreasureScenePointPush) PARSER.parseDelimitedFrom(input);
        }

        public static TreasureScenePointPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TreasureScenePointPush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static TreasureScenePointPush parseFrom(CodedInputStream input) throws IOException {
            return (TreasureScenePointPush) PARSER.parseFrom(input);
        }

        public static TreasureScenePointPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TreasureScenePointPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(TreasureScenePointPush prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements TaskHandler.TreasureScenePointPushOrBuilder {
            private int bitField0_;
            private int sceneId_;
            private int point_;
            private int taskId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return TaskHandler.internal_static_pomelo_area_TreasureScenePointPush_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return TaskHandler.internal_static_pomelo_area_TreasureScenePointPush_fieldAccessorTable.ensureFieldAccessorsInitialized(TaskHandler.TreasureScenePointPush.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TaskHandler.TreasureScenePointPush.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.sceneId_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.point_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                this.taskId_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return TaskHandler.internal_static_pomelo_area_TreasureScenePointPush_descriptor;
            }

            public TaskHandler.TreasureScenePointPush getDefaultInstanceForType() {
                return TaskHandler.TreasureScenePointPush.getDefaultInstance();
            }

            public TaskHandler.TreasureScenePointPush build() {
                TaskHandler.TreasureScenePointPush result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public TaskHandler.TreasureScenePointPush buildPartial() {
                TaskHandler.TreasureScenePointPush result = new TaskHandler.TreasureScenePointPush(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.sceneId_ = this.sceneId_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.point_ = this.point_;
                if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;
                result.taskId_ = this.taskId_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof TaskHandler.TreasureScenePointPush)
                    return mergeFrom((TaskHandler.TreasureScenePointPush) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TaskHandler.TreasureScenePointPush other) {
                if (other == TaskHandler.TreasureScenePointPush.getDefaultInstance()) return this;
                if (other.hasSceneId()) setSceneId(other.getSceneId());
                if (other.hasPoint()) setPoint(other.getPoint());
                if (other.hasTaskId()) setTaskId(other.getTaskId());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasSceneId()) return false;
                if (!hasPoint()) return false;
                if (!hasTaskId()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                TaskHandler.TreasureScenePointPush parsedMessage = null;
                try {
                    parsedMessage = (TaskHandler.TreasureScenePointPush) TaskHandler.TreasureScenePointPush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (TaskHandler.TreasureScenePointPush) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasSceneId() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getSceneId() {
                return this.sceneId_;
            }

            public Builder setSceneId(int value) {
                this.bitField0_ |= 0x1;
                this.sceneId_ = value;
                onChanged();
                return this;
            }

            public Builder clearSceneId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.sceneId_ = 0;
                onChanged();
                return this;
            }

            public boolean hasPoint() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getPoint() {
                return this.point_;
            }

            public Builder setPoint(int value) {
                this.bitField0_ |= 0x2;
                this.point_ = value;
                onChanged();
                return this;
            }

            public Builder clearPoint() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.point_ = 0;
                onChanged();
                return this;
            }

            public boolean hasTaskId() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public int getTaskId() {
                return this.taskId_;
            }

            public Builder setTaskId(int value) {
                this.bitField0_ |= 0x4;
                this.taskId_ = value;
                onChanged();
                return this;
            }

            public Builder clearTaskId() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.taskId_ = 0;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class LoopResultPush
            extends GeneratedMessage
            implements LoopResultPushOrBuilder {
        private static final LoopResultPush defaultInstance = new LoopResultPush(true);
        private final UnknownFieldSet unknownFields;

        private LoopResultPush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private LoopResultPush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static LoopResultPush getDefaultInstance() {
            return defaultInstance;
        }

        public LoopResultPush getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private LoopResultPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.times_ = input.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.exp_ = input.readInt32();
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.gold_ = input.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.upexp_ = input.readInt32();
                            break;
                        case 40:
                            this.bitField0_ |= 0x10;
                            this.xianyuan_ = input.readInt32();
                            break;
                        case 48:
                            this.bitField0_ |= 0x20;
                            this.chestCount_ = input.readInt32();
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
            return TaskHandler.internal_static_pomelo_area_LoopResultPush_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TaskHandler.internal_static_pomelo_area_LoopResultPush_fieldAccessorTable.ensureFieldAccessorsInitialized(LoopResultPush.class, Builder.class);
        }

        public static Parser<LoopResultPush> PARSER = (Parser<LoopResultPush>) new AbstractParser<LoopResultPush>() {
            public TaskHandler.LoopResultPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TaskHandler.LoopResultPush(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int TIMES_FIELD_NUMBER = 1;
        private int times_;
        public static final int EXP_FIELD_NUMBER = 2;
        private int exp_;
        public static final int GOLD_FIELD_NUMBER = 3;
        private int gold_;
        public static final int UPEXP_FIELD_NUMBER = 4;
        private int upexp_;
        public static final int XIANYUAN_FIELD_NUMBER = 5;
        private int xianyuan_;
        public static final int CHEST_COUNT_FIELD_NUMBER = 6;
        private int chestCount_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<LoopResultPush> getParserForType() {
            return PARSER;
        }

        public boolean hasTimes() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getTimes() {
            return this.times_;
        }

        public boolean hasExp() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        static {
            defaultInstance.initFields();
        }

        public int getExp() {
            return this.exp_;
        }

        public boolean hasGold() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getGold() {
            return this.gold_;
        }

        public boolean hasUpexp() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public int getUpexp() {
            return this.upexp_;
        }

        public boolean hasXianyuan() {
            return ((this.bitField0_ & 0x10) == 16);
        }

        public int getXianyuan() {
            return this.xianyuan_;
        }

        public boolean hasChestCount() {
            return ((this.bitField0_ & 0x20) == 32);
        }

        public int getChestCount() {
            return this.chestCount_;
        }

        private void initFields() {
            this.times_ = 0;
            this.exp_ = 0;
            this.gold_ = 0;
            this.upexp_ = 0;
            this.xianyuan_ = 0;
            this.chestCount_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1)
                return true;
            if (isInitialized == 0)
                return false;
            if (!hasTimes()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasExp()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasGold()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasUpexp()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasXianyuan()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasChestCount()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1)
                output.writeInt32(1, this.times_);
            if ((this.bitField0_ & 0x2) == 2)
                output.writeInt32(2, this.exp_);
            if ((this.bitField0_ & 0x4) == 4)
                output.writeInt32(3, this.gold_);
            if ((this.bitField0_ & 0x8) == 8)
                output.writeInt32(4, this.upexp_);
            if ((this.bitField0_ & 0x10) == 16)
                output.writeInt32(5, this.xianyuan_);
            if ((this.bitField0_ & 0x20) == 32)
                output.writeInt32(6, this.chestCount_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1)
                return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1)
                size += CodedOutputStream.computeInt32Size(1, this.times_);
            if ((this.bitField0_ & 0x2) == 2)
                size += CodedOutputStream.computeInt32Size(2, this.exp_);
            if ((this.bitField0_ & 0x4) == 4)
                size += CodedOutputStream.computeInt32Size(3, this.gold_);
            if ((this.bitField0_ & 0x8) == 8)
                size += CodedOutputStream.computeInt32Size(4, this.upexp_);
            if ((this.bitField0_ & 0x10) == 16)
                size += CodedOutputStream.computeInt32Size(5, this.xianyuan_);
            if ((this.bitField0_ & 0x20) == 32)
                size += CodedOutputStream.computeInt32Size(6, this.chestCount_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static LoopResultPush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (LoopResultPush) PARSER.parseFrom(data);
        }

        public static LoopResultPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (LoopResultPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static LoopResultPush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (LoopResultPush) PARSER.parseFrom(data);
        }

        public static LoopResultPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (LoopResultPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static LoopResultPush parseFrom(InputStream input) throws IOException {
            return (LoopResultPush) PARSER.parseFrom(input);
        }

        public static LoopResultPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LoopResultPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static LoopResultPush parseDelimitedFrom(InputStream input) throws IOException {
            return (LoopResultPush) PARSER.parseDelimitedFrom(input);
        }

        public static LoopResultPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LoopResultPush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static LoopResultPush parseFrom(CodedInputStream input) throws IOException {
            return (LoopResultPush) PARSER.parseFrom(input);
        }

        public static LoopResultPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LoopResultPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(LoopResultPush prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements TaskHandler.LoopResultPushOrBuilder {
            private int bitField0_;
            private int times_;
            private int exp_;
            private int gold_;
            private int upexp_;
            private int xianyuan_;
            private int chestCount_;

            public static final Descriptors.Descriptor getDescriptor() {
                return TaskHandler.internal_static_pomelo_area_LoopResultPush_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return TaskHandler.internal_static_pomelo_area_LoopResultPush_fieldAccessorTable.ensureFieldAccessorsInitialized(TaskHandler.LoopResultPush.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TaskHandler.LoopResultPush.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.times_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.exp_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                this.gold_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.upexp_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                this.xianyuan_ = 0;
                this.bitField0_ &= 0xFFFFFFEF;
                this.chestCount_ = 0;
                this.bitField0_ &= 0xFFFFFFDF;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return TaskHandler.internal_static_pomelo_area_LoopResultPush_descriptor;
            }

            public TaskHandler.LoopResultPush getDefaultInstanceForType() {
                return TaskHandler.LoopResultPush.getDefaultInstance();
            }

            public TaskHandler.LoopResultPush build() {
                TaskHandler.LoopResultPush result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public TaskHandler.LoopResultPush buildPartial() {
                TaskHandler.LoopResultPush result = new TaskHandler.LoopResultPush(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.times_ = this.times_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.exp_ = this.exp_;
                if ((from_bitField0_ & 0x4) == 4)
                    to_bitField0_ |= 0x4;
                result.gold_ = this.gold_;
                if ((from_bitField0_ & 0x8) == 8)
                    to_bitField0_ |= 0x8;
                result.upexp_ = this.upexp_;
                if ((from_bitField0_ & 0x10) == 16)
                    to_bitField0_ |= 0x10;
                result.xianyuan_ = this.xianyuan_;
                if ((from_bitField0_ & 0x20) == 32)
                    to_bitField0_ |= 0x20;
                result.chestCount_ = this.chestCount_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof TaskHandler.LoopResultPush)
                    return mergeFrom((TaskHandler.LoopResultPush) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TaskHandler.LoopResultPush other) {
                if (other == TaskHandler.LoopResultPush.getDefaultInstance())
                    return this;
                if (other.hasTimes())
                    setTimes(other.getTimes());
                if (other.hasExp())
                    setExp(other.getExp());
                if (other.hasGold())
                    setGold(other.getGold());
                if (other.hasUpexp())
                    setUpexp(other.getUpexp());
                if (other.hasXianyuan())
                    setXianyuan(other.getXianyuan());
                if (other.hasChestCount())
                    setChestCount(other.getChestCount());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasTimes())
                    return false;
                if (!hasExp())
                    return false;
                if (!hasGold())
                    return false;
                if (!hasUpexp())
                    return false;
                if (!hasXianyuan())
                    return false;
                if (!hasChestCount())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                TaskHandler.LoopResultPush parsedMessage = null;
                try {
                    parsedMessage = (TaskHandler.LoopResultPush) TaskHandler.LoopResultPush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (TaskHandler.LoopResultPush) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null)
                        mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasTimes() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getTimes() {
                return this.times_;
            }

            public Builder setTimes(int value) {
                this.bitField0_ |= 0x1;
                this.times_ = value;
                onChanged();
                return this;
            }

            public Builder clearTimes() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.times_ = 0;
                onChanged();
                return this;
            }

            public boolean hasExp() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getExp() {
                return this.exp_;
            }

            public Builder setExp(int value) {
                this.bitField0_ |= 0x2;
                this.exp_ = value;
                onChanged();
                return this;
            }

            public Builder clearExp() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.exp_ = 0;
                onChanged();
                return this;
            }

            public boolean hasGold() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public int getGold() {
                return this.gold_;
            }

            public Builder setGold(int value) {
                this.bitField0_ |= 0x4;
                this.gold_ = value;
                onChanged();
                return this;
            }

            public Builder clearGold() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.gold_ = 0;
                onChanged();
                return this;
            }

            public boolean hasUpexp() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public int getUpexp() {
                return this.upexp_;
            }

            public Builder setUpexp(int value) {
                this.bitField0_ |= 0x8;
                this.upexp_ = value;
                onChanged();
                return this;
            }

            public Builder clearUpexp() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.upexp_ = 0;
                onChanged();
                return this;
            }

            public boolean hasXianyuan() {
                return ((this.bitField0_ & 0x10) == 16);
            }

            public int getXianyuan() {
                return this.xianyuan_;
            }

            public Builder setXianyuan(int value) {
                this.bitField0_ |= 0x10;
                this.xianyuan_ = value;
                onChanged();
                return this;
            }

            public Builder clearXianyuan() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.xianyuan_ = 0;
                onChanged();
                return this;
            }

            public boolean hasChestCount() {
                return ((this.bitField0_ & 0x20) == 32);
            }

            public int getChestCount() {
                return this.chestCount_;
            }

            public Builder setChestCount(int value) {
                this.bitField0_ |= 0x20;
                this.chestCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearChestCount() {
                this.bitField0_ &= 0xFFFFFFDF;
                this.chestCount_ = 0;
                onChanged();
                return this;
            }
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }


    static {
        String[] descriptorData = {"\n\021taskHandler.proto\022\013pomelo.area\032\ntask.proto\032\fcommon.proto\"P\n\021AcceptTaskRequest\022\026\n\016c2s_templateId\030\001 \002(\005\022\020\n\bc2s_kind\030\002 \002(\005\022\021\n\tc2s_npcId\030\003 \002(\t\"7\n\022AcceptTaskResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"Q\n\022QuickFinishRequest\022\026\n\016c2s_templateId\030\001 \002(\005\022\020\n\bc2s_kind\030\002 \002(\005\022\021\n\tc2s_npcId\030\003 \002(\t\"8\n\023QuickFinishResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\">\n\022DiscardTaskRequest\022\026\n\016c2s_templateId\030\001 \002(\005\022\020\n\bc2s_kind\030\002 \002", "(\005\"8\n\023DiscardTaskResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"d\n\021SubmitTaskRequest\022\026\n\016c2s_templateId\030\001 \002(\005\022\020\n\bc2s_kind\030\002 \002(\005\022\022\n\nc2s_double\030\003 \002(\005\022\021\n\tc2s_npcId\030\004 \002(\t\"7\n\022SubmitTaskResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"C\n\027UpdateTaskStatusRequest\022\026\n\016c2s_templateId\030\001 \002(\005\022\020\n\bc2s_kind\030\002 \002(\005\"=\n\030UpdateTaskStatusResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\",\n\026RefreshSoulTaskRequest\022\022\n\nc2s_taskId\030\001 \002(\005\"<\n", "\027RefreshSoulTaskResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"\033\n\031GetDailySoulFinNumRequest\"P\n\032GetDailySoulFinNumResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\017\n\007s2c_num\030\003 \002(\005\"(\n\023TaskFuncDeskRequest\022\021\n\tc2s_ncpId\030\001 \002(\t\"9\n\024TaskFuncDeskResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"*\n\025AcceptLoopTaskRequest\022\021\n\tc2s_npcId\030\001 \002(\t\";\n\026AcceptLoopTaskResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"+\n\026AcceptDailyTaskReque", "st\022\021\n\tc2s_npcId\030\001 \002(\t\"<\n\027AcceptDailyTaskResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"\"\n\017CjPlayEndNotify\022\017\n\007s2c_msg\030\001 \001(\t\"*\n\031ReachTreasurePointRequest\022\r\n\005point\030\001 \002(\005\"?\n\032ReachTreasurePointResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"6\n\016TaskUpdatePush\022$\n\bs2c_data\030\002 \001(\0132\022.pomelo.task.Tasks\"\034\n\fTaskAutoPush\022\f\n\004auto\030\001 \002(\005\"H\n\026TreasureScenePointPush\022\017\n\007sceneId\030\001 \002(\005\022\r\n\005point\030\002 \002(\005\022\016\n\006taskId\030\003 \002(\005\"p\n\016LoopResu", "ltPush\022\r\n\005times\030\001 \002(\005\022\013\n\003exp\030\002 \002(\005\022\f\n\004gold\030\003 \002(\005\022\r\n\005upexp\030\004 \002(\005\022\020\n\bxianyuan\030\005 \002(\005\022\023\n\013chest_count\030\006 \002(\0052ö\b\n\013taskHandler\022T\n\021acceptTaskRequest\022\036.pomelo.area.AcceptTaskRequest\032\037.pomelo.area.AcceptTaskResponse\022W\n\022quickFinishRequest\022\037.pomelo.area.QuickFinishRequest\032 .pomelo.area.QuickFinishResponse\022W\n\022discardTaskRequest\022\037.pomelo.area.DiscardTaskRequest\032 .pomelo.area.DiscardTaskResponse\022T\n\021submitTaskRequ", "est\022\036.pomelo.area.SubmitTaskRequest\032\037.pomelo.area.SubmitTaskResponse\022f\n\027updateTaskStatusRequest\022$.pomelo.area.UpdateTaskStatusRequest\032%.pomelo.area.UpdateTaskStatusResponse\022c\n\026refreshSoulTaskRequest\022#.pomelo.area.RefreshSoulTaskRequest\032$.pomelo.area.RefreshSoulTaskResponse\022l\n\031getDailySoulFinNumRequest\022&.pomelo.area.GetDailySoulFinNumRequest\032'.pomelo.area.GetDailySoulFinNumResponse\022Z\n\023taskFuncDeskR", "equest\022 .pomelo.area.TaskFuncDeskRequest\032!.pomelo.area.TaskFuncDeskResponse\022`\n\025acceptLoopTaskRequest\022\".pomelo.area.AcceptLoopTaskRequest\032#.pomelo.area.AcceptLoopTaskResponse\022c\n\026acceptDailyTaskRequest\022#.pomelo.area.AcceptDailyTaskRequest\032$.pomelo.area.AcceptDailyTaskResponse\022=\n\017cjPlayEndNotify\022\034.pomelo.area.CjPlayEndNotify\032\f.pomelo.Void\022l\n\031reachTreasurePointRequest\022&.pomelo.area.ReachTreasurePointR", "equest\032'.pomelo.area.ReachTreasurePointResponse2\002\n\btaskPush\022;\n\016taskUpdatePush\022\033.pomelo.area.TaskUpdatePush\032\f.pomelo.Void\0227\n\ftaskAutoPush\022\031.pomelo.area.TaskAutoPush\032\f.pomelo.Void\022K\n\026treasureScenePointPush\022#.pomelo.area.TreasureScenePointPush\032\f.pomelo.Void\022;\n\016loopResultPush\022\033.pomelo.area.LoopResultPush\032\f.pomelo.Void"};


        Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root) {
                TaskHandler.descriptor = root;
                return null;
            }
        };

        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[]{

                TaskOuterClass.getDescriptor(),
                Common.getDescriptor()}, assigner);
    }

    private static final Descriptors.Descriptor internal_static_pomelo_area_AcceptTaskRequest_descriptor = getDescriptor().getMessageTypes().get(0);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_AcceptTaskRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_AcceptTaskRequest_descriptor, new String[]{"C2STemplateId", "C2SKind", "C2SNpcId"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_AcceptTaskResponse_descriptor = getDescriptor().getMessageTypes().get(1);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_AcceptTaskResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_AcceptTaskResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_QuickFinishRequest_descriptor = getDescriptor().getMessageTypes().get(2);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_QuickFinishRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_QuickFinishRequest_descriptor, new String[]{"C2STemplateId", "C2SKind", "C2SNpcId"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_QuickFinishResponse_descriptor = getDescriptor().getMessageTypes().get(3);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_QuickFinishResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_QuickFinishResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_DiscardTaskRequest_descriptor = getDescriptor().getMessageTypes().get(4);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_DiscardTaskRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_DiscardTaskRequest_descriptor, new String[]{"C2STemplateId", "C2SKind"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_DiscardTaskResponse_descriptor = getDescriptor().getMessageTypes().get(5);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_DiscardTaskResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_DiscardTaskResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_SubmitTaskRequest_descriptor = getDescriptor().getMessageTypes().get(6);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_SubmitTaskRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_SubmitTaskRequest_descriptor, new String[]{"C2STemplateId", "C2SKind", "C2SDouble", "C2SNpcId"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_SubmitTaskResponse_descriptor = getDescriptor().getMessageTypes().get(7);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_SubmitTaskResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_SubmitTaskResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_UpdateTaskStatusRequest_descriptor = getDescriptor().getMessageTypes().get(8);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_UpdateTaskStatusRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_UpdateTaskStatusRequest_descriptor, new String[]{"C2STemplateId", "C2SKind"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_UpdateTaskStatusResponse_descriptor = getDescriptor().getMessageTypes().get(9);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_UpdateTaskStatusResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_UpdateTaskStatusResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_RefreshSoulTaskRequest_descriptor = getDescriptor().getMessageTypes().get(10);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_RefreshSoulTaskRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_RefreshSoulTaskRequest_descriptor, new String[]{"C2STaskId"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_RefreshSoulTaskResponse_descriptor = getDescriptor().getMessageTypes().get(11);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_RefreshSoulTaskResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_RefreshSoulTaskResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetDailySoulFinNumRequest_descriptor = getDescriptor().getMessageTypes().get(12);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetDailySoulFinNumRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetDailySoulFinNumRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetDailySoulFinNumResponse_descriptor = getDescriptor().getMessageTypes().get(13);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetDailySoulFinNumResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetDailySoulFinNumResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CNum"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_TaskFuncDeskRequest_descriptor = getDescriptor().getMessageTypes().get(14);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_TaskFuncDeskRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_TaskFuncDeskRequest_descriptor, new String[]{"C2SNcpId"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_TaskFuncDeskResponse_descriptor = getDescriptor().getMessageTypes().get(15);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_TaskFuncDeskResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_TaskFuncDeskResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_AcceptLoopTaskRequest_descriptor = getDescriptor().getMessageTypes().get(16);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_AcceptLoopTaskRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_AcceptLoopTaskRequest_descriptor, new String[]{"C2SNpcId"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_AcceptLoopTaskResponse_descriptor = getDescriptor().getMessageTypes().get(17);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_AcceptLoopTaskResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_AcceptLoopTaskResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_AcceptDailyTaskRequest_descriptor = getDescriptor().getMessageTypes().get(18);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_AcceptDailyTaskRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_AcceptDailyTaskRequest_descriptor, new String[]{"C2SNpcId"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_AcceptDailyTaskResponse_descriptor = getDescriptor().getMessageTypes().get(19);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_AcceptDailyTaskResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_AcceptDailyTaskResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_CjPlayEndNotify_descriptor = getDescriptor().getMessageTypes().get(20);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_CjPlayEndNotify_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_CjPlayEndNotify_descriptor, new String[]{"S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_ReachTreasurePointRequest_descriptor = getDescriptor().getMessageTypes().get(21);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ReachTreasurePointRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ReachTreasurePointRequest_descriptor, new String[]{"Point"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_ReachTreasurePointResponse_descriptor = getDescriptor().getMessageTypes().get(22);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ReachTreasurePointResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ReachTreasurePointResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_TaskUpdatePush_descriptor = getDescriptor().getMessageTypes().get(23);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_TaskUpdatePush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_TaskUpdatePush_descriptor, new String[]{"S2CData"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_TaskAutoPush_descriptor = getDescriptor().getMessageTypes().get(24);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_TaskAutoPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_TaskAutoPush_descriptor, new String[]{"Auto"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_TreasureScenePointPush_descriptor = getDescriptor().getMessageTypes().get(25);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_TreasureScenePointPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_TreasureScenePointPush_descriptor, new String[]{"SceneId", "Point", "TaskId"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_LoopResultPush_descriptor = getDescriptor().getMessageTypes().get(26);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_LoopResultPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_LoopResultPush_descriptor, new String[]{"Times", "Exp", "Gold", "Upexp", "Xianyuan", "ChestCount"});
    private static Descriptors.FileDescriptor descriptor;

    static {
        TaskOuterClass.getDescriptor();
        Common.getDescriptor();
    }

    public static interface LoopResultPushOrBuilder extends MessageOrBuilder {
        boolean hasTimes();

        int getTimes();

        boolean hasExp();

        int getExp();

        boolean hasGold();

        int getGold();

        boolean hasUpexp();

        int getUpexp();

        boolean hasXianyuan();

        int getXianyuan();

        boolean hasChestCount();

        int getChestCount();
    }

    public static interface TreasureScenePointPushOrBuilder extends MessageOrBuilder {
        boolean hasSceneId();

        int getSceneId();

        boolean hasPoint();

        int getPoint();

        boolean hasTaskId();

        int getTaskId();
    }

    public static interface TaskAutoPushOrBuilder extends MessageOrBuilder {
        boolean hasAuto();

        int getAuto();
    }

    public static interface TaskUpdatePushOrBuilder extends MessageOrBuilder {
        boolean hasS2CData();

        TaskOuterClass.Tasks getS2CData();

        TaskOuterClass.TasksOrBuilder getS2CDataOrBuilder();
    }

    public static interface ReachTreasurePointResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface ReachTreasurePointRequestOrBuilder extends MessageOrBuilder {
        boolean hasPoint();

        int getPoint();
    }

    public static interface CjPlayEndNotifyOrBuilder extends MessageOrBuilder {
        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface AcceptDailyTaskResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface AcceptDailyTaskRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2SNpcId();

        String getC2SNpcId();

        ByteString getC2SNpcIdBytes();
    }

    public static interface AcceptLoopTaskResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface AcceptLoopTaskRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2SNpcId();

        String getC2SNpcId();

        ByteString getC2SNpcIdBytes();
    }

    public static interface TaskFuncDeskResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface TaskFuncDeskRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2SNcpId();

        String getC2SNcpId();

        ByteString getC2SNcpIdBytes();
    }

    public static interface GetDailySoulFinNumResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasS2CNum();

        int getS2CNum();
    }

    public static interface GetDailySoulFinNumRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface RefreshSoulTaskResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface RefreshSoulTaskRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2STaskId();

        int getC2STaskId();
    }

    public static interface UpdateTaskStatusResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface UpdateTaskStatusRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2STemplateId();

        int getC2STemplateId();

        boolean hasC2SKind();

        int getC2SKind();
    }

    public static interface SubmitTaskResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface SubmitTaskRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2STemplateId();

        int getC2STemplateId();

        boolean hasC2SKind();

        int getC2SKind();

        boolean hasC2SDouble();

        int getC2SDouble();

        boolean hasC2SNpcId();

        String getC2SNpcId();

        ByteString getC2SNpcIdBytes();
    }

    public static interface DiscardTaskResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface DiscardTaskRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2STemplateId();

        int getC2STemplateId();

        boolean hasC2SKind();

        int getC2SKind();
    }

    public static interface QuickFinishResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface QuickFinishRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2STemplateId();

        int getC2STemplateId();

        boolean hasC2SKind();

        int getC2SKind();

        boolean hasC2SNpcId();

        String getC2SNpcId();

        ByteString getC2SNpcIdBytes();
    }

    public static interface AcceptTaskResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface AcceptTaskRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2STemplateId();

        int getC2STemplateId();

        boolean hasC2SKind();

        int getC2SKind();

        boolean hasC2SNpcId();

        String getC2SNpcId();

        ByteString getC2SNpcIdBytes();
    }
}


