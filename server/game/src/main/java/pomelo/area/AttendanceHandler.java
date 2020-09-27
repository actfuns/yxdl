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
import pomelo.item.ItemOuterClass;


public final class AttendanceHandler {
    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static final class GetAttendanceInfoRequest
            extends GeneratedMessage
            implements GetAttendanceInfoRequestOrBuilder {
        private static final GetAttendanceInfoRequest defaultInstance = new GetAttendanceInfoRequest(true);
        private final UnknownFieldSet unknownFields;

        private GetAttendanceInfoRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetAttendanceInfoRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetAttendanceInfoRequest getDefaultInstance() {
            return defaultInstance;
        }

        public GetAttendanceInfoRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetAttendanceInfoRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return AttendanceHandler.internal_static_pomelo_area_GetAttendanceInfoRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return AttendanceHandler.internal_static_pomelo_area_GetAttendanceInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetAttendanceInfoRequest.class, Builder.class);
        }

        public static Parser<GetAttendanceInfoRequest> PARSER = (Parser<GetAttendanceInfoRequest>) new AbstractParser<GetAttendanceInfoRequest>() {
            public AttendanceHandler.GetAttendanceInfoRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AttendanceHandler.GetAttendanceInfoRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetAttendanceInfoRequest> getParserForType() {
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


        public static GetAttendanceInfoRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetAttendanceInfoRequest) PARSER.parseFrom(data);
        }


        public static GetAttendanceInfoRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetAttendanceInfoRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetAttendanceInfoRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetAttendanceInfoRequest) PARSER.parseFrom(data);
        }


        public static GetAttendanceInfoRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetAttendanceInfoRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetAttendanceInfoRequest parseFrom(InputStream input) throws IOException {
            return (GetAttendanceInfoRequest) PARSER.parseFrom(input);
        }


        public static GetAttendanceInfoRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetAttendanceInfoRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static GetAttendanceInfoRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (GetAttendanceInfoRequest) PARSER.parseDelimitedFrom(input);
        }


        public static GetAttendanceInfoRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetAttendanceInfoRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static GetAttendanceInfoRequest parseFrom(CodedInputStream input) throws IOException {
            return (GetAttendanceInfoRequest) PARSER.parseFrom(input);
        }


        public static GetAttendanceInfoRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetAttendanceInfoRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(GetAttendanceInfoRequest prototype) {
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
                implements AttendanceHandler.GetAttendanceInfoRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return AttendanceHandler.internal_static_pomelo_area_GetAttendanceInfoRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return AttendanceHandler.internal_static_pomelo_area_GetAttendanceInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(AttendanceHandler.GetAttendanceInfoRequest.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (AttendanceHandler.GetAttendanceInfoRequest.alwaysUseFieldBuilders) ;
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
                return AttendanceHandler.internal_static_pomelo_area_GetAttendanceInfoRequest_descriptor;
            }


            public AttendanceHandler.GetAttendanceInfoRequest getDefaultInstanceForType() {
                return AttendanceHandler.GetAttendanceInfoRequest.getDefaultInstance();
            }


            public AttendanceHandler.GetAttendanceInfoRequest build() {
                AttendanceHandler.GetAttendanceInfoRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public AttendanceHandler.GetAttendanceInfoRequest buildPartial() {
                AttendanceHandler.GetAttendanceInfoRequest result = new AttendanceHandler.GetAttendanceInfoRequest(this);
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof AttendanceHandler.GetAttendanceInfoRequest) {
                    return mergeFrom((AttendanceHandler.GetAttendanceInfoRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(AttendanceHandler.GetAttendanceInfoRequest other) {
                if (other == AttendanceHandler.GetAttendanceInfoRequest.getDefaultInstance()) {
                    return this;
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                AttendanceHandler.GetAttendanceInfoRequest parsedMessage = null;
                try {
                    parsedMessage = (AttendanceHandler.GetAttendanceInfoRequest) AttendanceHandler.GetAttendanceInfoRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (AttendanceHandler.GetAttendanceInfoRequest) e.getUnfinishedMessage();
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


    public static final class GetDailyRewardRequest
            extends GeneratedMessage
            implements GetDailyRewardRequestOrBuilder {
        private static final GetDailyRewardRequest defaultInstance = new GetDailyRewardRequest(true);
        private final UnknownFieldSet unknownFields;

        private GetDailyRewardRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetDailyRewardRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetDailyRewardRequest getDefaultInstance() {
            return defaultInstance;
        }

        public GetDailyRewardRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetDailyRewardRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return AttendanceHandler.internal_static_pomelo_area_GetDailyRewardRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return AttendanceHandler.internal_static_pomelo_area_GetDailyRewardRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetDailyRewardRequest.class, Builder.class);
        }

        public static Parser<GetDailyRewardRequest> PARSER = (Parser<GetDailyRewardRequest>) new AbstractParser<GetDailyRewardRequest>() {
            public AttendanceHandler.GetDailyRewardRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AttendanceHandler.GetDailyRewardRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetDailyRewardRequest> getParserForType() {
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


        public static GetDailyRewardRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetDailyRewardRequest) PARSER.parseFrom(data);
        }


        public static GetDailyRewardRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetDailyRewardRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetDailyRewardRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetDailyRewardRequest) PARSER.parseFrom(data);
        }


        public static GetDailyRewardRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetDailyRewardRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetDailyRewardRequest parseFrom(InputStream input) throws IOException {
            return (GetDailyRewardRequest) PARSER.parseFrom(input);
        }


        public static GetDailyRewardRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetDailyRewardRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static GetDailyRewardRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (GetDailyRewardRequest) PARSER.parseDelimitedFrom(input);
        }


        public static GetDailyRewardRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetDailyRewardRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static GetDailyRewardRequest parseFrom(CodedInputStream input) throws IOException {
            return (GetDailyRewardRequest) PARSER.parseFrom(input);
        }


        public static GetDailyRewardRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetDailyRewardRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(GetDailyRewardRequest prototype) {
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
                implements AttendanceHandler.GetDailyRewardRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return AttendanceHandler.internal_static_pomelo_area_GetDailyRewardRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return AttendanceHandler.internal_static_pomelo_area_GetDailyRewardRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(AttendanceHandler.GetDailyRewardRequest.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (AttendanceHandler.GetDailyRewardRequest.alwaysUseFieldBuilders) ;
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
                return AttendanceHandler.internal_static_pomelo_area_GetDailyRewardRequest_descriptor;
            }


            public AttendanceHandler.GetDailyRewardRequest getDefaultInstanceForType() {
                return AttendanceHandler.GetDailyRewardRequest.getDefaultInstance();
            }


            public AttendanceHandler.GetDailyRewardRequest build() {
                AttendanceHandler.GetDailyRewardRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public AttendanceHandler.GetDailyRewardRequest buildPartial() {
                AttendanceHandler.GetDailyRewardRequest result = new AttendanceHandler.GetDailyRewardRequest(this);
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof AttendanceHandler.GetDailyRewardRequest) {
                    return mergeFrom((AttendanceHandler.GetDailyRewardRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(AttendanceHandler.GetDailyRewardRequest other) {
                if (other == AttendanceHandler.GetDailyRewardRequest.getDefaultInstance()) {
                    return this;
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                AttendanceHandler.GetDailyRewardRequest parsedMessage = null;
                try {
                    parsedMessage = (AttendanceHandler.GetDailyRewardRequest) AttendanceHandler.GetDailyRewardRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (AttendanceHandler.GetDailyRewardRequest) e.getUnfinishedMessage();
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


    public static final class GetCumulativeRewardRequest
            extends GeneratedMessage
            implements GetCumulativeRewardRequestOrBuilder {
        private static final GetCumulativeRewardRequest defaultInstance = new GetCumulativeRewardRequest(true);
        private final UnknownFieldSet unknownFields;

        private GetCumulativeRewardRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetCumulativeRewardRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetCumulativeRewardRequest getDefaultInstance() {
            return defaultInstance;
        }

        public GetCumulativeRewardRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetCumulativeRewardRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return AttendanceHandler.internal_static_pomelo_area_GetCumulativeRewardRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return AttendanceHandler.internal_static_pomelo_area_GetCumulativeRewardRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetCumulativeRewardRequest.class, Builder.class);
        }

        public static Parser<GetCumulativeRewardRequest> PARSER = (Parser<GetCumulativeRewardRequest>) new AbstractParser<GetCumulativeRewardRequest>() {
            public AttendanceHandler.GetCumulativeRewardRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AttendanceHandler.GetCumulativeRewardRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int ID_FIELD_NUMBER = 1;
        private int id_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetCumulativeRewardRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getId() {
            return this.id_;
        }

        private void initFields() {
            this.id_ = 0;
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
            if (!hasId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeInt32(1, this.id_);
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
                size += CodedOutputStream.computeInt32Size(1, this.id_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static GetCumulativeRewardRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetCumulativeRewardRequest) PARSER.parseFrom(data);
        }


        public static GetCumulativeRewardRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetCumulativeRewardRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetCumulativeRewardRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetCumulativeRewardRequest) PARSER.parseFrom(data);
        }


        public static GetCumulativeRewardRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetCumulativeRewardRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetCumulativeRewardRequest parseFrom(InputStream input) throws IOException {
            return (GetCumulativeRewardRequest) PARSER.parseFrom(input);
        }


        public static GetCumulativeRewardRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetCumulativeRewardRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static GetCumulativeRewardRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (GetCumulativeRewardRequest) PARSER.parseDelimitedFrom(input);
        }


        public static GetCumulativeRewardRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetCumulativeRewardRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static GetCumulativeRewardRequest parseFrom(CodedInputStream input) throws IOException {
            return (GetCumulativeRewardRequest) PARSER.parseFrom(input);
        }


        public static GetCumulativeRewardRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetCumulativeRewardRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(GetCumulativeRewardRequest prototype) {
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
                implements AttendanceHandler.GetCumulativeRewardRequestOrBuilder {
            private int bitField0_;


            private int id_;


            public static final Descriptors.Descriptor getDescriptor() {
                return AttendanceHandler.internal_static_pomelo_area_GetCumulativeRewardRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return AttendanceHandler.internal_static_pomelo_area_GetCumulativeRewardRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(AttendanceHandler.GetCumulativeRewardRequest.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (AttendanceHandler.GetCumulativeRewardRequest.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.id_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return AttendanceHandler.internal_static_pomelo_area_GetCumulativeRewardRequest_descriptor;
            }


            public AttendanceHandler.GetCumulativeRewardRequest getDefaultInstanceForType() {
                return AttendanceHandler.GetCumulativeRewardRequest.getDefaultInstance();
            }


            public AttendanceHandler.GetCumulativeRewardRequest build() {
                AttendanceHandler.GetCumulativeRewardRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public AttendanceHandler.GetCumulativeRewardRequest buildPartial() {
                AttendanceHandler.GetCumulativeRewardRequest result = new AttendanceHandler.GetCumulativeRewardRequest(this);
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
                if (other instanceof AttendanceHandler.GetCumulativeRewardRequest) {
                    return mergeFrom((AttendanceHandler.GetCumulativeRewardRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(AttendanceHandler.GetCumulativeRewardRequest other) {
                if (other == AttendanceHandler.GetCumulativeRewardRequest.getDefaultInstance()) {
                    return this;
                }
                if (other.hasId()) {
                    setId(other.getId());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasId()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                AttendanceHandler.GetCumulativeRewardRequest parsedMessage = null;
                try {
                    parsedMessage = (AttendanceHandler.GetCumulativeRewardRequest) AttendanceHandler.GetCumulativeRewardRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (AttendanceHandler.GetCumulativeRewardRequest) e.getUnfinishedMessage();
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
        }
    }


    public static final class GetLuxuryRewardRequest
            extends GeneratedMessage
            implements GetLuxuryRewardRequestOrBuilder {
        private static final GetLuxuryRewardRequest defaultInstance = new GetLuxuryRewardRequest(true);
        private final UnknownFieldSet unknownFields;

        private GetLuxuryRewardRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetLuxuryRewardRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetLuxuryRewardRequest getDefaultInstance() {
            return defaultInstance;
        }

        public GetLuxuryRewardRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetLuxuryRewardRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return AttendanceHandler.internal_static_pomelo_area_GetLuxuryRewardRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return AttendanceHandler.internal_static_pomelo_area_GetLuxuryRewardRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetLuxuryRewardRequest.class, Builder.class);
        }

        public static Parser<GetLuxuryRewardRequest> PARSER = (Parser<GetLuxuryRewardRequest>) new AbstractParser<GetLuxuryRewardRequest>() {
            public AttendanceHandler.GetLuxuryRewardRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AttendanceHandler.GetLuxuryRewardRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetLuxuryRewardRequest> getParserForType() {
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


        public static GetLuxuryRewardRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetLuxuryRewardRequest) PARSER.parseFrom(data);
        }


        public static GetLuxuryRewardRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetLuxuryRewardRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetLuxuryRewardRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetLuxuryRewardRequest) PARSER.parseFrom(data);
        }


        public static GetLuxuryRewardRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetLuxuryRewardRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetLuxuryRewardRequest parseFrom(InputStream input) throws IOException {
            return (GetLuxuryRewardRequest) PARSER.parseFrom(input);
        }


        public static GetLuxuryRewardRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetLuxuryRewardRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static GetLuxuryRewardRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (GetLuxuryRewardRequest) PARSER.parseDelimitedFrom(input);
        }


        public static GetLuxuryRewardRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetLuxuryRewardRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static GetLuxuryRewardRequest parseFrom(CodedInputStream input) throws IOException {
            return (GetLuxuryRewardRequest) PARSER.parseFrom(input);
        }


        public static GetLuxuryRewardRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetLuxuryRewardRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(GetLuxuryRewardRequest prototype) {
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
                implements AttendanceHandler.GetLuxuryRewardRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return AttendanceHandler.internal_static_pomelo_area_GetLuxuryRewardRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return AttendanceHandler.internal_static_pomelo_area_GetLuxuryRewardRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(AttendanceHandler.GetLuxuryRewardRequest.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (AttendanceHandler.GetLuxuryRewardRequest.alwaysUseFieldBuilders) ;
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
                return AttendanceHandler.internal_static_pomelo_area_GetLuxuryRewardRequest_descriptor;
            }


            public AttendanceHandler.GetLuxuryRewardRequest getDefaultInstanceForType() {
                return AttendanceHandler.GetLuxuryRewardRequest.getDefaultInstance();
            }


            public AttendanceHandler.GetLuxuryRewardRequest build() {
                AttendanceHandler.GetLuxuryRewardRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public AttendanceHandler.GetLuxuryRewardRequest buildPartial() {
                AttendanceHandler.GetLuxuryRewardRequest result = new AttendanceHandler.GetLuxuryRewardRequest(this);
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof AttendanceHandler.GetLuxuryRewardRequest) {
                    return mergeFrom((AttendanceHandler.GetLuxuryRewardRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(AttendanceHandler.GetLuxuryRewardRequest other) {
                if (other == AttendanceHandler.GetLuxuryRewardRequest.getDefaultInstance()) {
                    return this;
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                AttendanceHandler.GetLuxuryRewardRequest parsedMessage = null;
                try {
                    parsedMessage = (AttendanceHandler.GetLuxuryRewardRequest) AttendanceHandler.GetLuxuryRewardRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (AttendanceHandler.GetLuxuryRewardRequest) e.getUnfinishedMessage();
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


    public static final class GetLeftVipRewardRequest
            extends GeneratedMessage
            implements GetLeftVipRewardRequestOrBuilder {
        private static final GetLeftVipRewardRequest defaultInstance = new GetLeftVipRewardRequest(true);
        private final UnknownFieldSet unknownFields;

        private GetLeftVipRewardRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetLeftVipRewardRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetLeftVipRewardRequest getDefaultInstance() {
            return defaultInstance;
        }

        public GetLeftVipRewardRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetLeftVipRewardRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return AttendanceHandler.internal_static_pomelo_area_GetLeftVipRewardRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return AttendanceHandler.internal_static_pomelo_area_GetLeftVipRewardRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetLeftVipRewardRequest.class, Builder.class);
        }

        public static Parser<GetLeftVipRewardRequest> PARSER = (Parser<GetLeftVipRewardRequest>) new AbstractParser<GetLeftVipRewardRequest>() {
            public AttendanceHandler.GetLeftVipRewardRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AttendanceHandler.GetLeftVipRewardRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int ID_FIELD_NUMBER = 1;
        private int id_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetLeftVipRewardRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getId() {
            return this.id_;
        }

        private void initFields() {
            this.id_ = 0;
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
            if (!hasId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeInt32(1, this.id_);
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
                size += CodedOutputStream.computeInt32Size(1, this.id_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static GetLeftVipRewardRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetLeftVipRewardRequest) PARSER.parseFrom(data);
        }


        public static GetLeftVipRewardRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetLeftVipRewardRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetLeftVipRewardRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetLeftVipRewardRequest) PARSER.parseFrom(data);
        }


        public static GetLeftVipRewardRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetLeftVipRewardRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetLeftVipRewardRequest parseFrom(InputStream input) throws IOException {
            return (GetLeftVipRewardRequest) PARSER.parseFrom(input);
        }


        public static GetLeftVipRewardRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetLeftVipRewardRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static GetLeftVipRewardRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (GetLeftVipRewardRequest) PARSER.parseDelimitedFrom(input);
        }


        public static GetLeftVipRewardRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetLeftVipRewardRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static GetLeftVipRewardRequest parseFrom(CodedInputStream input) throws IOException {
            return (GetLeftVipRewardRequest) PARSER.parseFrom(input);
        }


        public static GetLeftVipRewardRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetLeftVipRewardRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(GetLeftVipRewardRequest prototype) {
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
                implements AttendanceHandler.GetLeftVipRewardRequestOrBuilder {
            private int bitField0_;


            private int id_;


            public static final Descriptors.Descriptor getDescriptor() {
                return AttendanceHandler.internal_static_pomelo_area_GetLeftVipRewardRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return AttendanceHandler.internal_static_pomelo_area_GetLeftVipRewardRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(AttendanceHandler.GetLeftVipRewardRequest.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (AttendanceHandler.GetLeftVipRewardRequest.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.id_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return AttendanceHandler.internal_static_pomelo_area_GetLeftVipRewardRequest_descriptor;
            }


            public AttendanceHandler.GetLeftVipRewardRequest getDefaultInstanceForType() {
                return AttendanceHandler.GetLeftVipRewardRequest.getDefaultInstance();
            }


            public AttendanceHandler.GetLeftVipRewardRequest build() {
                AttendanceHandler.GetLeftVipRewardRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public AttendanceHandler.GetLeftVipRewardRequest buildPartial() {
                AttendanceHandler.GetLeftVipRewardRequest result = new AttendanceHandler.GetLeftVipRewardRequest(this);
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
                if (other instanceof AttendanceHandler.GetLeftVipRewardRequest) {
                    return mergeFrom((AttendanceHandler.GetLeftVipRewardRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(AttendanceHandler.GetLeftVipRewardRequest other) {
                if (other == AttendanceHandler.GetLeftVipRewardRequest.getDefaultInstance()) {
                    return this;
                }
                if (other.hasId()) {
                    setId(other.getId());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasId()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                AttendanceHandler.GetLeftVipRewardRequest parsedMessage = null;
                try {
                    parsedMessage = (AttendanceHandler.GetLeftVipRewardRequest) AttendanceHandler.GetLeftVipRewardRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (AttendanceHandler.GetLeftVipRewardRequest) e.getUnfinishedMessage();
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
        }
    }


    public static final class DailyInfo
            extends GeneratedMessage
            implements DailyInfoOrBuilder {
        private static final DailyInfo defaultInstance = new DailyInfo(true);
        private final UnknownFieldSet unknownFields;

        private DailyInfo(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private DailyInfo(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static DailyInfo getDefaultInstance() {
            return defaultInstance;
        }

        public DailyInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DailyInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ItemOuterClass.MiniItem.Builder subBuilder;
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        case 8:
                            this.bitField0_ |= 0x1;
                            this.id_ = input.readInt32();
                            break;
                        case 18:
                            subBuilder = null;
                            if ((this.bitField0_ & 0x2) == 2) subBuilder = this.itemList_.toBuilder();
                            this.itemList_ = (ItemOuterClass.MiniItem) input.readMessage(ItemOuterClass.MiniItem.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.itemList_);
                                this.itemList_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 0x2;
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.vipDoubleLevel_ = input.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.state_ = input.readInt32();
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
            return AttendanceHandler.internal_static_pomelo_area_DailyInfo_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return AttendanceHandler.internal_static_pomelo_area_DailyInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(DailyInfo.class, Builder.class);
        }

        public static Parser<DailyInfo> PARSER = (Parser<DailyInfo>) new AbstractParser<DailyInfo>() {
            public AttendanceHandler.DailyInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AttendanceHandler.DailyInfo(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int ID_FIELD_NUMBER = 1;
        private int id_;
        public static final int ITEMLIST_FIELD_NUMBER = 2;
        private ItemOuterClass.MiniItem itemList_;
        public static final int VIPDOUBLELEVEL_FIELD_NUMBER = 3;
        private int vipDoubleLevel_;
        public static final int STATE_FIELD_NUMBER = 4;
        private int state_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<DailyInfo> getParserForType() {
            return PARSER;
        }

        public boolean hasId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getId() {
            return this.id_;
        }

        public boolean hasItemList() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        static {
            defaultInstance.initFields();
        }


        public ItemOuterClass.MiniItem getItemList() {
            return this.itemList_;
        }


        public ItemOuterClass.MiniItemOrBuilder getItemListOrBuilder() {
            return (ItemOuterClass.MiniItemOrBuilder) this.itemList_;
        }


        public boolean hasVipDoubleLevel() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public int getVipDoubleLevel() {
            return this.vipDoubleLevel_;
        }


        public boolean hasState() {
            return ((this.bitField0_ & 0x8) == 8);
        }


        public int getState() {
            return this.state_;
        }


        private void initFields() {
            this.id_ = 0;
            this.itemList_ = ItemOuterClass.MiniItem.getDefaultInstance();
            this.vipDoubleLevel_ = 0;
            this.state_ = 0;
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
            if (hasItemList() && !getItemList().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeInt32(1, this.id_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeMessage(2, (MessageLite) this.itemList_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeInt32(3, this.vipDoubleLevel_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                output.writeInt32(4, this.state_);
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
                size += CodedOutputStream.computeInt32Size(1, this.id_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeMessageSize(2, (MessageLite) this.itemList_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                size += CodedOutputStream.computeInt32Size(3, this.vipDoubleLevel_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                size += CodedOutputStream.computeInt32Size(4, this.state_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static DailyInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (DailyInfo) PARSER.parseFrom(data);
        }


        public static DailyInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DailyInfo) PARSER.parseFrom(data, extensionRegistry);
        }


        public static DailyInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (DailyInfo) PARSER.parseFrom(data);
        }


        public static DailyInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DailyInfo) PARSER.parseFrom(data, extensionRegistry);
        }


        public static DailyInfo parseFrom(InputStream input) throws IOException {
            return (DailyInfo) PARSER.parseFrom(input);
        }


        public static DailyInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DailyInfo) PARSER.parseFrom(input, extensionRegistry);
        }


        public static DailyInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (DailyInfo) PARSER.parseDelimitedFrom(input);
        }


        public static DailyInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DailyInfo) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static DailyInfo parseFrom(CodedInputStream input) throws IOException {
            return (DailyInfo) PARSER.parseFrom(input);
        }


        public static DailyInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DailyInfo) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(DailyInfo prototype) {
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
                implements AttendanceHandler.DailyInfoOrBuilder {
            private int bitField0_;


            private int id_;


            private ItemOuterClass.MiniItem itemList_;


            private SingleFieldBuilder<ItemOuterClass.MiniItem, ItemOuterClass.MiniItem.Builder, ItemOuterClass.MiniItemOrBuilder> itemListBuilder_;


            private int vipDoubleLevel_;


            private int state_;


            public static final Descriptors.Descriptor getDescriptor() {
                return AttendanceHandler.internal_static_pomelo_area_DailyInfo_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return AttendanceHandler.internal_static_pomelo_area_DailyInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(AttendanceHandler.DailyInfo.class, Builder.class);
            }


            private Builder() {
                this.itemList_ = ItemOuterClass.MiniItem.getDefaultInstance();
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.itemList_ = ItemOuterClass.MiniItem.getDefaultInstance();
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (AttendanceHandler.DailyInfo.alwaysUseFieldBuilders) {
                    getItemListFieldBuilder();
                }
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.id_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                if (this.itemListBuilder_ == null) {
                    this.itemList_ = ItemOuterClass.MiniItem.getDefaultInstance();
                } else {
                    this.itemListBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFD;
                this.vipDoubleLevel_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.state_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return AttendanceHandler.internal_static_pomelo_area_DailyInfo_descriptor;
            }


            public AttendanceHandler.DailyInfo getDefaultInstanceForType() {
                return AttendanceHandler.DailyInfo.getDefaultInstance();
            }


            public AttendanceHandler.DailyInfo build() {
                AttendanceHandler.DailyInfo result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public AttendanceHandler.DailyInfo buildPartial() {
                AttendanceHandler.DailyInfo result = new AttendanceHandler.DailyInfo(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.id_ = this.id_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                if (this.itemListBuilder_ == null) {
                    result.itemList_ = this.itemList_;
                } else {
                    result.itemList_ = (ItemOuterClass.MiniItem) this.itemListBuilder_.build();
                }
                if ((from_bitField0_ & 0x4) == 4) {
                    to_bitField0_ |= 0x4;
                }
                result.vipDoubleLevel_ = this.vipDoubleLevel_;
                if ((from_bitField0_ & 0x8) == 8) {
                    to_bitField0_ |= 0x8;
                }
                result.state_ = this.state_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof AttendanceHandler.DailyInfo) {
                    return mergeFrom((AttendanceHandler.DailyInfo) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(AttendanceHandler.DailyInfo other) {
                if (other == AttendanceHandler.DailyInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.hasId()) {
                    setId(other.getId());
                }
                if (other.hasItemList()) {
                    mergeItemList(other.getItemList());
                }
                if (other.hasVipDoubleLevel()) {
                    setVipDoubleLevel(other.getVipDoubleLevel());
                }
                if (other.hasState()) {
                    setState(other.getState());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasId()) {
                    return false;
                }
                if (hasItemList() && !getItemList().isInitialized()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                AttendanceHandler.DailyInfo parsedMessage = null;
                try {
                    parsedMessage = (AttendanceHandler.DailyInfo) AttendanceHandler.DailyInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (AttendanceHandler.DailyInfo) e.getUnfinishedMessage();
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


            public boolean hasItemList() {
                return ((this.bitField0_ & 0x2) == 2);
            }


            public ItemOuterClass.MiniItem getItemList() {
                if (this.itemListBuilder_ == null) {
                    return this.itemList_;
                }
                return (ItemOuterClass.MiniItem) this.itemListBuilder_.getMessage();
            }


            public Builder setItemList(ItemOuterClass.MiniItem value) {
                if (this.itemListBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.itemList_ = value;
                    onChanged();
                } else {
                    this.itemListBuilder_.setMessage((GeneratedMessage) value);
                }
                this.bitField0_ |= 0x2;
                return this;
            }


            public Builder setItemList(ItemOuterClass.MiniItem.Builder builderForValue) {
                if (this.itemListBuilder_ == null) {
                    this.itemList_ = builderForValue.build();
                    onChanged();
                } else {
                    this.itemListBuilder_.setMessage((GeneratedMessage) builderForValue.build());
                }
                this.bitField0_ |= 0x2;
                return this;
            }


            public Builder mergeItemList(ItemOuterClass.MiniItem value) {
                if (this.itemListBuilder_ == null) {
                    if ((this.bitField0_ & 0x2) == 2 && this.itemList_ != ItemOuterClass.MiniItem.getDefaultInstance()) {
                        this.itemList_ = ItemOuterClass.MiniItem.newBuilder(this.itemList_).mergeFrom(value).buildPartial();
                    } else {
                        this.itemList_ = value;
                    }
                    onChanged();
                } else {
                    this.itemListBuilder_.mergeFrom((GeneratedMessage) value);
                }
                this.bitField0_ |= 0x2;
                return this;
            }


            public Builder clearItemList() {
                if (this.itemListBuilder_ == null) {
                    this.itemList_ = ItemOuterClass.MiniItem.getDefaultInstance();
                    onChanged();
                } else {
                    this.itemListBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }


            public ItemOuterClass.MiniItem.Builder getItemListBuilder() {
                this.bitField0_ |= 0x2;
                onChanged();
                return (ItemOuterClass.MiniItem.Builder) getItemListFieldBuilder().getBuilder();
            }


            public ItemOuterClass.MiniItemOrBuilder getItemListOrBuilder() {
                if (this.itemListBuilder_ != null) {
                    return (ItemOuterClass.MiniItemOrBuilder) this.itemListBuilder_.getMessageOrBuilder();
                }
                return (ItemOuterClass.MiniItemOrBuilder) this.itemList_;
            }


            private SingleFieldBuilder<ItemOuterClass.MiniItem, ItemOuterClass.MiniItem.Builder, ItemOuterClass.MiniItemOrBuilder> getItemListFieldBuilder() {
                if (this.itemListBuilder_ == null) {
                    this.itemListBuilder_ = new SingleFieldBuilder((GeneratedMessage) getItemList(), getParentForChildren(), isClean());
                    this.itemList_ = null;
                }
                return this.itemListBuilder_;
            }


            public boolean hasVipDoubleLevel() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public int getVipDoubleLevel() {
                return this.vipDoubleLevel_;
            }


            public Builder setVipDoubleLevel(int value) {
                this.bitField0_ |= 0x4;
                this.vipDoubleLevel_ = value;
                onChanged();
                return this;
            }


            public Builder clearVipDoubleLevel() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.vipDoubleLevel_ = 0;
                onChanged();
                return this;
            }


            public boolean hasState() {
                return ((this.bitField0_ & 0x8) == 8);
            }


            public int getState() {
                return this.state_;
            }


            public Builder setState(int value) {
                this.bitField0_ |= 0x8;
                this.state_ = value;
                onChanged();
                return this;
            }


            public Builder clearState() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.state_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class CumulativeInfo
            extends GeneratedMessage
            implements CumulativeInfoOrBuilder {
        private static final CumulativeInfo defaultInstance = new CumulativeInfo(true);
        private final UnknownFieldSet unknownFields;

        private CumulativeInfo(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private CumulativeInfo(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static CumulativeInfo getDefaultInstance() {
            return defaultInstance;
        }

        public CumulativeInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CumulativeInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.id_ = input.readInt32();
                            break;
                        case 18:
                            if ((mutable_bitField0_ & 0x2) != 2) {
                                this.itemList_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x2;
                            }
                            this.itemList_.add(input.readMessage(ItemOuterClass.MiniItem.PARSER, extensionRegistry));
                            break;
                        case 24:
                            this.bitField0_ |= 0x2;
                            this.needCountDay_ = input.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 0x4;
                            this.state_ = input.readInt32();
                            break;
                        case 42:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x8;
                            this.boxIcon_ = bs;
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x2) == 2) this.itemList_ = Collections.unmodifiableList(this.itemList_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AttendanceHandler.internal_static_pomelo_area_CumulativeInfo_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return AttendanceHandler.internal_static_pomelo_area_CumulativeInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(CumulativeInfo.class, Builder.class);
        }

        public static Parser<CumulativeInfo> PARSER = (Parser<CumulativeInfo>) new AbstractParser<CumulativeInfo>() {
            public AttendanceHandler.CumulativeInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AttendanceHandler.CumulativeInfo(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int ID_FIELD_NUMBER = 1;
        private int id_;
        public static final int ITEMLIST_FIELD_NUMBER = 2;
        private List<ItemOuterClass.MiniItem> itemList_;
        public static final int NEEDCOUNTDAY_FIELD_NUMBER = 3;
        private int needCountDay_;
        public static final int STATE_FIELD_NUMBER = 4;
        private int state_;
        public static final int BOXICON_FIELD_NUMBER = 5;
        private Object boxIcon_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<CumulativeInfo> getParserForType() {
            return PARSER;
        }

        public boolean hasId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getId() {
            return this.id_;
        }

        public List<ItemOuterClass.MiniItem> getItemListList() {
            return this.itemList_;
        }

        public List<? extends ItemOuterClass.MiniItemOrBuilder> getItemListOrBuilderList() {
            return (List) this.itemList_;
        }

        public int getItemListCount() {
            return this.itemList_.size();
        }

        static {
            defaultInstance.initFields();
        }


        public ItemOuterClass.MiniItem getItemList(int index) {
            return this.itemList_.get(index);
        }


        public ItemOuterClass.MiniItemOrBuilder getItemListOrBuilder(int index) {
            return (ItemOuterClass.MiniItemOrBuilder) this.itemList_.get(index);
        }


        public boolean hasNeedCountDay() {
            return ((this.bitField0_ & 0x2) == 2);
        }


        public int getNeedCountDay() {
            return this.needCountDay_;
        }


        public boolean hasState() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public int getState() {
            return this.state_;
        }


        public boolean hasBoxIcon() {
            return ((this.bitField0_ & 0x8) == 8);
        }


        public String getBoxIcon() {
            Object ref = this.boxIcon_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.boxIcon_ = s;
            }
            return s;
        }


        public ByteString getBoxIconBytes() {
            Object ref = this.boxIcon_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.boxIcon_ = b;
                return b;
            }
            return (ByteString) ref;
        }


        private void initFields() {
            this.id_ = 0;
            this.itemList_ = Collections.emptyList();
            this.needCountDay_ = 0;
            this.state_ = 0;
            this.boxIcon_ = "";
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
            for (int i = 0; i < getItemListCount(); i++) {
                if (!getItemList(i).isInitialized()) {
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
                output.writeInt32(1, this.id_);
            }
            for (int i = 0; i < this.itemList_.size(); i++) {
                output.writeMessage(2, (MessageLite) this.itemList_.get(i));
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeInt32(3, this.needCountDay_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeInt32(4, this.state_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                output.writeBytes(5, getBoxIconBytes());
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
                size += CodedOutputStream.computeInt32Size(1, this.id_);
            }
            for (int i = 0; i < this.itemList_.size(); i++) {
                size += CodedOutputStream.computeMessageSize(2, (MessageLite) this.itemList_.get(i));
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeInt32Size(3, this.needCountDay_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                size += CodedOutputStream.computeInt32Size(4, this.state_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                size += CodedOutputStream.computeBytesSize(5, getBoxIconBytes());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static CumulativeInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (CumulativeInfo) PARSER.parseFrom(data);
        }


        public static CumulativeInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (CumulativeInfo) PARSER.parseFrom(data, extensionRegistry);
        }


        public static CumulativeInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (CumulativeInfo) PARSER.parseFrom(data);
        }


        public static CumulativeInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (CumulativeInfo) PARSER.parseFrom(data, extensionRegistry);
        }


        public static CumulativeInfo parseFrom(InputStream input) throws IOException {
            return (CumulativeInfo) PARSER.parseFrom(input);
        }


        public static CumulativeInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CumulativeInfo) PARSER.parseFrom(input, extensionRegistry);
        }


        public static CumulativeInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (CumulativeInfo) PARSER.parseDelimitedFrom(input);
        }


        public static CumulativeInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CumulativeInfo) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static CumulativeInfo parseFrom(CodedInputStream input) throws IOException {
            return (CumulativeInfo) PARSER.parseFrom(input);
        }


        public static CumulativeInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CumulativeInfo) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(CumulativeInfo prototype) {
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
                implements AttendanceHandler.CumulativeInfoOrBuilder {
            private int bitField0_;


            private int id_;


            private List<ItemOuterClass.MiniItem> itemList_;


            private RepeatedFieldBuilder<ItemOuterClass.MiniItem, ItemOuterClass.MiniItem.Builder, ItemOuterClass.MiniItemOrBuilder> itemListBuilder_;


            private int needCountDay_;


            private int state_;


            private Object boxIcon_;


            public static final Descriptors.Descriptor getDescriptor() {
                return AttendanceHandler.internal_static_pomelo_area_CumulativeInfo_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return AttendanceHandler.internal_static_pomelo_area_CumulativeInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(AttendanceHandler.CumulativeInfo.class, Builder.class);
            }


            private Builder() {
                this.itemList_ = Collections.emptyList();
                this.boxIcon_ = "";
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.itemList_ = Collections.emptyList();
                this.boxIcon_ = "";
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (AttendanceHandler.CumulativeInfo.alwaysUseFieldBuilders) {
                    getItemListFieldBuilder();
                }
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.id_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                if (this.itemListBuilder_ == null) {
                    this.itemList_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFD;
                } else {
                    this.itemListBuilder_.clear();
                }
                this.needCountDay_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.state_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                this.boxIcon_ = "";
                this.bitField0_ &= 0xFFFFFFEF;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return AttendanceHandler.internal_static_pomelo_area_CumulativeInfo_descriptor;
            }


            public AttendanceHandler.CumulativeInfo getDefaultInstanceForType() {
                return AttendanceHandler.CumulativeInfo.getDefaultInstance();
            }


            public AttendanceHandler.CumulativeInfo build() {
                AttendanceHandler.CumulativeInfo result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public AttendanceHandler.CumulativeInfo buildPartial() {
                AttendanceHandler.CumulativeInfo result = new AttendanceHandler.CumulativeInfo(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.id_ = this.id_;
                if (this.itemListBuilder_ == null) {
                    if ((this.bitField0_ & 0x2) == 2) {
                        this.itemList_ = Collections.unmodifiableList(this.itemList_);
                        this.bitField0_ &= 0xFFFFFFFD;
                    }
                    result.itemList_ = this.itemList_;
                } else {
                    result.itemList_ = this.itemListBuilder_.build();
                }
                if ((from_bitField0_ & 0x4) == 4) {
                    to_bitField0_ |= 0x2;
                }
                result.needCountDay_ = this.needCountDay_;
                if ((from_bitField0_ & 0x8) == 8) {
                    to_bitField0_ |= 0x4;
                }
                result.state_ = this.state_;
                if ((from_bitField0_ & 0x10) == 16) {
                    to_bitField0_ |= 0x8;
                }
                result.boxIcon_ = this.boxIcon_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof AttendanceHandler.CumulativeInfo) {
                    return mergeFrom((AttendanceHandler.CumulativeInfo) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(AttendanceHandler.CumulativeInfo other) {
                if (other == AttendanceHandler.CumulativeInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.hasId()) {
                    setId(other.getId());
                }
                if (this.itemListBuilder_ == null) {
                    if (!other.itemList_.isEmpty()) {
                        if (this.itemList_.isEmpty()) {
                            this.itemList_ = other.itemList_;
                            this.bitField0_ &= 0xFFFFFFFD;
                        } else {
                            ensureItemListIsMutable();
                            this.itemList_.addAll(other.itemList_);
                        }
                        onChanged();
                    }
                } else if (!other.itemList_.isEmpty()) {
                    if (this.itemListBuilder_.isEmpty()) {
                        this.itemListBuilder_.dispose();
                        this.itemListBuilder_ = null;
                        this.itemList_ = other.itemList_;
                        this.bitField0_ &= 0xFFFFFFFD;
                        this.itemListBuilder_ = AttendanceHandler.CumulativeInfo.alwaysUseFieldBuilders ? getItemListFieldBuilder() : null;
                    } else {
                        this.itemListBuilder_.addAllMessages(other.itemList_);
                    }
                }
                if (other.hasNeedCountDay()) {
                    setNeedCountDay(other.getNeedCountDay());
                }
                if (other.hasState()) {
                    setState(other.getState());
                }
                if (other.hasBoxIcon()) {
                    this.bitField0_ |= 0x10;
                    this.boxIcon_ = other.boxIcon_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasId()) {
                    return false;
                }
                for (int i = 0; i < getItemListCount(); i++) {
                    if (!getItemList(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                AttendanceHandler.CumulativeInfo parsedMessage = null;
                try {
                    parsedMessage = (AttendanceHandler.CumulativeInfo) AttendanceHandler.CumulativeInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (AttendanceHandler.CumulativeInfo) e.getUnfinishedMessage();
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


            private void ensureItemListIsMutable() {
                if ((this.bitField0_ & 0x2) != 2) {
                    this.itemList_ = new ArrayList<>(this.itemList_);
                    this.bitField0_ |= 0x2;
                }
            }


            public List<ItemOuterClass.MiniItem> getItemListList() {
                if (this.itemListBuilder_ == null) {
                    return Collections.unmodifiableList(this.itemList_);
                }
                return this.itemListBuilder_.getMessageList();
            }


            public int getItemListCount() {
                if (this.itemListBuilder_ == null) {
                    return this.itemList_.size();
                }
                return this.itemListBuilder_.getCount();
            }


            public ItemOuterClass.MiniItem getItemList(int index) {
                if (this.itemListBuilder_ == null) {
                    return this.itemList_.get(index);
                }
                return (ItemOuterClass.MiniItem) this.itemListBuilder_.getMessage(index);
            }


            public Builder setItemList(int index, ItemOuterClass.MiniItem value) {
                if (this.itemListBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureItemListIsMutable();
                    this.itemList_.set(index, value);
                    onChanged();
                } else {
                    this.itemListBuilder_.setMessage(index, (GeneratedMessage) value);
                }
                return this;
            }


            public Builder setItemList(int index, ItemOuterClass.MiniItem.Builder builderForValue) {
                if (this.itemListBuilder_ == null) {
                    ensureItemListIsMutable();
                    this.itemList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.itemListBuilder_.setMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }


            public Builder addItemList(ItemOuterClass.MiniItem value) {
                if (this.itemListBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureItemListIsMutable();
                    this.itemList_.add(value);
                    onChanged();
                } else {
                    this.itemListBuilder_.addMessage((GeneratedMessage) value);
                }
                return this;
            }


            public Builder addItemList(int index, ItemOuterClass.MiniItem value) {
                if (this.itemListBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureItemListIsMutable();
                    this.itemList_.add(index, value);
                    onChanged();
                } else {
                    this.itemListBuilder_.addMessage(index, (GeneratedMessage) value);
                }
                return this;
            }


            public Builder addItemList(ItemOuterClass.MiniItem.Builder builderForValue) {
                if (this.itemListBuilder_ == null) {
                    ensureItemListIsMutable();
                    this.itemList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.itemListBuilder_.addMessage((GeneratedMessage) builderForValue.build());
                }
                return this;
            }


            public Builder addItemList(int index, ItemOuterClass.MiniItem.Builder builderForValue) {
                if (this.itemListBuilder_ == null) {
                    ensureItemListIsMutable();
                    this.itemList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.itemListBuilder_.addMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }


            public Builder addAllItemList(Iterable<? extends ItemOuterClass.MiniItem> values) {
                if (this.itemListBuilder_ == null) {
                    ensureItemListIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.itemList_);
                    onChanged();
                } else {
                    this.itemListBuilder_.addAllMessages(values);
                }
                return this;
            }


            public Builder clearItemList() {
                if (this.itemListBuilder_ == null) {
                    this.itemList_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFD;
                    onChanged();
                } else {
                    this.itemListBuilder_.clear();
                }
                return this;
            }


            public Builder removeItemList(int index) {
                if (this.itemListBuilder_ == null) {
                    ensureItemListIsMutable();
                    this.itemList_.remove(index);
                    onChanged();
                } else {
                    this.itemListBuilder_.remove(index);
                }
                return this;
            }


            public ItemOuterClass.MiniItem.Builder getItemListBuilder(int index) {
                return (ItemOuterClass.MiniItem.Builder) getItemListFieldBuilder().getBuilder(index);
            }


            public ItemOuterClass.MiniItemOrBuilder getItemListOrBuilder(int index) {
                if (this.itemListBuilder_ == null) {
                    return (ItemOuterClass.MiniItemOrBuilder) this.itemList_.get(index);
                }
                return (ItemOuterClass.MiniItemOrBuilder) this.itemListBuilder_.getMessageOrBuilder(index);
            }


            public List<? extends ItemOuterClass.MiniItemOrBuilder> getItemListOrBuilderList() {
                if (this.itemListBuilder_ != null) {
                    return this.itemListBuilder_.getMessageOrBuilderList();
                }
                return (List) Collections.unmodifiableList(this.itemList_);
            }


            public ItemOuterClass.MiniItem.Builder addItemListBuilder() {
                return (ItemOuterClass.MiniItem.Builder) getItemListFieldBuilder().addBuilder((GeneratedMessage) ItemOuterClass.MiniItem.getDefaultInstance());
            }


            public ItemOuterClass.MiniItem.Builder addItemListBuilder(int index) {
                return (ItemOuterClass.MiniItem.Builder) getItemListFieldBuilder().addBuilder(index, (GeneratedMessage) ItemOuterClass.MiniItem.getDefaultInstance());
            }


            public List<ItemOuterClass.MiniItem.Builder> getItemListBuilderList() {
                return getItemListFieldBuilder().getBuilderList();
            }


            private RepeatedFieldBuilder<ItemOuterClass.MiniItem, ItemOuterClass.MiniItem.Builder, ItemOuterClass.MiniItemOrBuilder> getItemListFieldBuilder() {
                if (this.itemListBuilder_ == null) {
                    this.itemListBuilder_ = new RepeatedFieldBuilder(this.itemList_, ((this.bitField0_ & 0x2) == 2), getParentForChildren(), isClean());
                    this.itemList_ = null;
                }
                return this.itemListBuilder_;
            }


            public boolean hasNeedCountDay() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public int getNeedCountDay() {
                return this.needCountDay_;
            }


            public Builder setNeedCountDay(int value) {
                this.bitField0_ |= 0x4;
                this.needCountDay_ = value;
                onChanged();
                return this;
            }


            public Builder clearNeedCountDay() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.needCountDay_ = 0;
                onChanged();
                return this;
            }


            public boolean hasState() {
                return ((this.bitField0_ & 0x8) == 8);
            }


            public int getState() {
                return this.state_;
            }


            public Builder setState(int value) {
                this.bitField0_ |= 0x8;
                this.state_ = value;
                onChanged();
                return this;
            }


            public Builder clearState() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.state_ = 0;
                onChanged();
                return this;
            }


            public boolean hasBoxIcon() {
                return ((this.bitField0_ & 0x10) == 16);
            }


            public String getBoxIcon() {
                Object ref = this.boxIcon_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.boxIcon_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }


            public ByteString getBoxIconBytes() {
                Object ref = this.boxIcon_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.boxIcon_ = b;
                    return b;
                }
                return (ByteString) ref;
            }


            public Builder setBoxIcon(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x10;
                this.boxIcon_ = value;
                onChanged();
                return this;
            }


            public Builder clearBoxIcon() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.boxIcon_ = AttendanceHandler.CumulativeInfo.getDefaultInstance().getBoxIcon();
                onChanged();
                return this;
            }


            public Builder setBoxIconBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x10;
                this.boxIcon_ = value;
                onChanged();
                return this;
            }
        }
    }


    public static final class AttendanceInfo
            extends GeneratedMessage
            implements AttendanceInfoOrBuilder {
        private static final AttendanceInfo defaultInstance = new AttendanceInfo(true);
        private final UnknownFieldSet unknownFields;

        private AttendanceInfo(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private AttendanceInfo(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static AttendanceInfo getDefaultInstance() {
            return defaultInstance;
        }

        public AttendanceInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AttendanceInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.todayState_ = input.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.signedCount_ = input.readInt32();
                            break;
                        case 26:
                            if ((mutable_bitField0_ & 0x4) != 4) {
                                this.dailyList_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x4;
                            }
                            this.dailyList_.add(input.readMessage(AttendanceHandler.DailyInfo.PARSER, extensionRegistry));
                            break;
                        case 34:
                            if ((mutable_bitField0_ & 0x8) != 8) {
                                this.cumulativeList_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x8;
                            }
                            this.cumulativeList_.add(input.readMessage(AttendanceHandler.CumulativeInfo.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x4) == 4) this.dailyList_ = Collections.unmodifiableList(this.dailyList_);
                if ((mutable_bitField0_ & 0x8) == 8)
                    this.cumulativeList_ = Collections.unmodifiableList(this.cumulativeList_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AttendanceHandler.internal_static_pomelo_area_AttendanceInfo_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return AttendanceHandler.internal_static_pomelo_area_AttendanceInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(AttendanceInfo.class, Builder.class);
        }

        public static Parser<AttendanceInfo> PARSER = (Parser<AttendanceInfo>) new AbstractParser<AttendanceInfo>() {
            public AttendanceHandler.AttendanceInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AttendanceHandler.AttendanceInfo(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int TODAYSTATE_FIELD_NUMBER = 1;
        private int todayState_;
        public static final int SIGNEDCOUNT_FIELD_NUMBER = 2;
        private int signedCount_;
        public static final int DAILYLIST_FIELD_NUMBER = 3;
        private List<AttendanceHandler.DailyInfo> dailyList_;
        public static final int CUMULATIVELIST_FIELD_NUMBER = 4;
        private List<AttendanceHandler.CumulativeInfo> cumulativeList_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<AttendanceInfo> getParserForType() {
            return PARSER;
        }

        public boolean hasTodayState() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getTodayState() {
            return this.todayState_;
        }

        public boolean hasSignedCount() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public int getSignedCount() {
            return this.signedCount_;
        }

        public List<AttendanceHandler.DailyInfo> getDailyListList() {
            return this.dailyList_;
        }

        public List<? extends AttendanceHandler.DailyInfoOrBuilder> getDailyListOrBuilderList() {
            return (List) this.dailyList_;
        }

        static {
            defaultInstance.initFields();
        }


        public int getDailyListCount() {
            return this.dailyList_.size();
        }


        public AttendanceHandler.DailyInfo getDailyList(int index) {
            return this.dailyList_.get(index);
        }


        public AttendanceHandler.DailyInfoOrBuilder getDailyListOrBuilder(int index) {
            return this.dailyList_.get(index);
        }


        public List<AttendanceHandler.CumulativeInfo> getCumulativeListList() {
            return this.cumulativeList_;
        }


        public List<? extends AttendanceHandler.CumulativeInfoOrBuilder> getCumulativeListOrBuilderList() {
            return (List) this.cumulativeList_;
        }


        public int getCumulativeListCount() {
            return this.cumulativeList_.size();
        }


        public AttendanceHandler.CumulativeInfo getCumulativeList(int index) {
            return this.cumulativeList_.get(index);
        }


        public AttendanceHandler.CumulativeInfoOrBuilder getCumulativeListOrBuilder(int index) {
            return this.cumulativeList_.get(index);
        }


        private void initFields() {
            this.todayState_ = 0;
            this.signedCount_ = 0;
            this.dailyList_ = Collections.emptyList();
            this.cumulativeList_ = Collections.emptyList();
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
            for (i = 0; i < getDailyListCount(); i++) {
                if (!getDailyList(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (i = 0; i < getCumulativeListCount(); i++) {
                if (!getCumulativeList(i).isInitialized()) {
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
                output.writeInt32(1, this.todayState_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeInt32(2, this.signedCount_);
            }
            int i;
            for (i = 0; i < this.dailyList_.size(); i++) {
                output.writeMessage(3, (MessageLite) this.dailyList_.get(i));
            }
            for (i = 0; i < this.cumulativeList_.size(); i++) {
                output.writeMessage(4, (MessageLite) this.cumulativeList_.get(i));
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
                size += CodedOutputStream.computeInt32Size(1, this.todayState_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeInt32Size(2, this.signedCount_);
            }
            int i;
            for (i = 0; i < this.dailyList_.size(); i++) {
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.dailyList_.get(i));
            }
            for (i = 0; i < this.cumulativeList_.size(); i++) {
                size += CodedOutputStream.computeMessageSize(4, (MessageLite) this.cumulativeList_.get(i));
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static AttendanceInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (AttendanceInfo) PARSER.parseFrom(data);
        }

        public static AttendanceInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AttendanceInfo) PARSER.parseFrom(data, extensionRegistry);
        }

        public static AttendanceInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (AttendanceInfo) PARSER.parseFrom(data);
        }

        public static AttendanceInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AttendanceInfo) PARSER.parseFrom(data, extensionRegistry);
        }

        public static AttendanceInfo parseFrom(InputStream input) throws IOException {
            return (AttendanceInfo) PARSER.parseFrom(input);
        }

        public static AttendanceInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AttendanceInfo) PARSER.parseFrom(input, extensionRegistry);
        }

        public static AttendanceInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (AttendanceInfo) PARSER.parseDelimitedFrom(input);
        }

        public static AttendanceInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AttendanceInfo) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static AttendanceInfo parseFrom(CodedInputStream input) throws IOException {
            return (AttendanceInfo) PARSER.parseFrom(input);
        }

        public static AttendanceInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AttendanceInfo) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(AttendanceInfo prototype) {
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
                implements AttendanceHandler.AttendanceInfoOrBuilder {
            private int bitField0_;
            private int todayState_;
            private int signedCount_;
            private List<AttendanceHandler.DailyInfo> dailyList_;
            private RepeatedFieldBuilder<AttendanceHandler.DailyInfo, AttendanceHandler.DailyInfo.Builder, AttendanceHandler.DailyInfoOrBuilder> dailyListBuilder_;
            private List<AttendanceHandler.CumulativeInfo> cumulativeList_;
            private RepeatedFieldBuilder<AttendanceHandler.CumulativeInfo, AttendanceHandler.CumulativeInfo.Builder, AttendanceHandler.CumulativeInfoOrBuilder> cumulativeListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AttendanceHandler.internal_static_pomelo_area_AttendanceInfo_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return AttendanceHandler.internal_static_pomelo_area_AttendanceInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(AttendanceHandler.AttendanceInfo.class, Builder.class);
            }

            private Builder() {
                this.dailyList_ = Collections.emptyList();
                this.cumulativeList_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.dailyList_ = Collections.emptyList();
                this.cumulativeList_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AttendanceHandler.AttendanceInfo.alwaysUseFieldBuilders) {
                    getDailyListFieldBuilder();
                    getCumulativeListFieldBuilder();
                }
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.todayState_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.signedCount_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                if (this.dailyListBuilder_ == null) {
                    this.dailyList_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                } else {
                    this.dailyListBuilder_.clear();
                }
                if (this.cumulativeListBuilder_ == null) {
                    this.cumulativeList_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFF7;
                } else {
                    this.cumulativeListBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return AttendanceHandler.internal_static_pomelo_area_AttendanceInfo_descriptor;
            }

            public AttendanceHandler.AttendanceInfo getDefaultInstanceForType() {
                return AttendanceHandler.AttendanceInfo.getDefaultInstance();
            }

            public AttendanceHandler.AttendanceInfo build() {
                AttendanceHandler.AttendanceInfo result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public AttendanceHandler.AttendanceInfo buildPartial() {
                AttendanceHandler.AttendanceInfo result = new AttendanceHandler.AttendanceInfo(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.todayState_ = this.todayState_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.signedCount_ = this.signedCount_;
                if (this.dailyListBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4) {
                        this.dailyList_ = Collections.unmodifiableList(this.dailyList_);
                        this.bitField0_ &= 0xFFFFFFFB;
                    }
                    result.dailyList_ = this.dailyList_;
                } else {
                    result.dailyList_ = this.dailyListBuilder_.build();
                }
                if (this.cumulativeListBuilder_ == null) {
                    if ((this.bitField0_ & 0x8) == 8) {
                        this.cumulativeList_ = Collections.unmodifiableList(this.cumulativeList_);
                        this.bitField0_ &= 0xFFFFFFF7;
                    }
                    result.cumulativeList_ = this.cumulativeList_;
                } else {
                    result.cumulativeList_ = this.cumulativeListBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof AttendanceHandler.AttendanceInfo) {
                    return mergeFrom((AttendanceHandler.AttendanceInfo) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AttendanceHandler.AttendanceInfo other) {
                if (other == AttendanceHandler.AttendanceInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.hasTodayState()) {
                    setTodayState(other.getTodayState());
                }
                if (other.hasSignedCount()) {
                    setSignedCount(other.getSignedCount());
                }
                if (this.dailyListBuilder_ == null) {
                    if (!other.dailyList_.isEmpty()) {
                        if (this.dailyList_.isEmpty()) {
                            this.dailyList_ = other.dailyList_;
                            this.bitField0_ &= 0xFFFFFFFB;
                        } else {
                            ensureDailyListIsMutable();
                            this.dailyList_.addAll(other.dailyList_);
                        }
                        onChanged();
                    }
                } else if (!other.dailyList_.isEmpty()) {
                    if (this.dailyListBuilder_.isEmpty()) {
                        this.dailyListBuilder_.dispose();
                        this.dailyListBuilder_ = null;
                        this.dailyList_ = other.dailyList_;
                        this.bitField0_ &= 0xFFFFFFFB;
                        this.dailyListBuilder_ = AttendanceHandler.AttendanceInfo.alwaysUseFieldBuilders ? getDailyListFieldBuilder() : null;
                    } else {
                        this.dailyListBuilder_.addAllMessages(other.dailyList_);
                    }
                }
                if (this.cumulativeListBuilder_ == null) {
                    if (!other.cumulativeList_.isEmpty()) {
                        if (this.cumulativeList_.isEmpty()) {
                            this.cumulativeList_ = other.cumulativeList_;
                            this.bitField0_ &= 0xFFFFFFF7;
                        } else {
                            ensureCumulativeListIsMutable();
                            this.cumulativeList_.addAll(other.cumulativeList_);
                        }
                        onChanged();
                    }
                } else if (!other.cumulativeList_.isEmpty()) {
                    if (this.cumulativeListBuilder_.isEmpty()) {
                        this.cumulativeListBuilder_.dispose();
                        this.cumulativeListBuilder_ = null;
                        this.cumulativeList_ = other.cumulativeList_;
                        this.bitField0_ &= 0xFFFFFFF7;
                        this.cumulativeListBuilder_ = AttendanceHandler.AttendanceInfo.alwaysUseFieldBuilders ? getCumulativeListFieldBuilder() : null;
                    } else {
                        this.cumulativeListBuilder_.addAllMessages(other.cumulativeList_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                int i;
                for (i = 0; i < getDailyListCount(); i++) {
                    if (!getDailyList(i).isInitialized()) {
                        return false;
                    }
                }
                for (i = 0; i < getCumulativeListCount(); i++) {
                    if (!getCumulativeList(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                AttendanceHandler.AttendanceInfo parsedMessage = null;
                try {
                    parsedMessage = (AttendanceHandler.AttendanceInfo) AttendanceHandler.AttendanceInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (AttendanceHandler.AttendanceInfo) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            public boolean hasTodayState() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getTodayState() {
                return this.todayState_;
            }

            public Builder setTodayState(int value) {
                this.bitField0_ |= 0x1;
                this.todayState_ = value;
                onChanged();
                return this;
            }

            public Builder clearTodayState() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.todayState_ = 0;
                onChanged();
                return this;
            }

            public boolean hasSignedCount() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getSignedCount() {
                return this.signedCount_;
            }

            public Builder setSignedCount(int value) {
                this.bitField0_ |= 0x2;
                this.signedCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearSignedCount() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.signedCount_ = 0;
                onChanged();
                return this;
            }

            private void ensureDailyListIsMutable() {
                if ((this.bitField0_ & 0x4) != 4) {
                    this.dailyList_ = new ArrayList<>(this.dailyList_);
                    this.bitField0_ |= 0x4;
                }
            }

            public List<AttendanceHandler.DailyInfo> getDailyListList() {
                if (this.dailyListBuilder_ == null) {
                    return Collections.unmodifiableList(this.dailyList_);
                }
                return this.dailyListBuilder_.getMessageList();
            }

            public int getDailyListCount() {
                if (this.dailyListBuilder_ == null) {
                    return this.dailyList_.size();
                }
                return this.dailyListBuilder_.getCount();
            }

            public AttendanceHandler.DailyInfo getDailyList(int index) {
                if (this.dailyListBuilder_ == null) {
                    return this.dailyList_.get(index);
                }
                return (AttendanceHandler.DailyInfo) this.dailyListBuilder_.getMessage(index);
            }

            public Builder setDailyList(int index, AttendanceHandler.DailyInfo value) {
                if (this.dailyListBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureDailyListIsMutable();
                    this.dailyList_.set(index, value);
                    onChanged();
                } else {
                    this.dailyListBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setDailyList(int index, AttendanceHandler.DailyInfo.Builder builderForValue) {
                if (this.dailyListBuilder_ == null) {
                    ensureDailyListIsMutable();
                    this.dailyList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.dailyListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addDailyList(AttendanceHandler.DailyInfo value) {
                if (this.dailyListBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureDailyListIsMutable();
                    this.dailyList_.add(value);
                    onChanged();
                } else {
                    this.dailyListBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addDailyList(int index, AttendanceHandler.DailyInfo value) {
                if (this.dailyListBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureDailyListIsMutable();
                    this.dailyList_.add(index, value);
                    onChanged();
                } else {
                    this.dailyListBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addDailyList(AttendanceHandler.DailyInfo.Builder builderForValue) {
                if (this.dailyListBuilder_ == null) {
                    ensureDailyListIsMutable();
                    this.dailyList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.dailyListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addDailyList(int index, AttendanceHandler.DailyInfo.Builder builderForValue) {
                if (this.dailyListBuilder_ == null) {
                    ensureDailyListIsMutable();
                    this.dailyList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.dailyListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllDailyList(Iterable<? extends AttendanceHandler.DailyInfo> values) {
                if (this.dailyListBuilder_ == null) {
                    ensureDailyListIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.dailyList_);
                    onChanged();
                } else {
                    this.dailyListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearDailyList() {
                if (this.dailyListBuilder_ == null) {
                    this.dailyList_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                    onChanged();
                } else {
                    this.dailyListBuilder_.clear();
                }
                return this;
            }

            public Builder removeDailyList(int index) {
                if (this.dailyListBuilder_ == null) {
                    ensureDailyListIsMutable();
                    this.dailyList_.remove(index);
                    onChanged();
                } else {
                    this.dailyListBuilder_.remove(index);
                }
                return this;
            }

            public AttendanceHandler.DailyInfo.Builder getDailyListBuilder(int index) {
                return (AttendanceHandler.DailyInfo.Builder) getDailyListFieldBuilder().getBuilder(index);
            }

            public AttendanceHandler.DailyInfoOrBuilder getDailyListOrBuilder(int index) {
                if (this.dailyListBuilder_ == null) {
                    return this.dailyList_.get(index);
                }
                return (AttendanceHandler.DailyInfoOrBuilder) this.dailyListBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends AttendanceHandler.DailyInfoOrBuilder> getDailyListOrBuilderList() {
                if (this.dailyListBuilder_ != null) {
                    return this.dailyListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList((List) this.dailyList_);
            }

            public AttendanceHandler.DailyInfo.Builder addDailyListBuilder() {
                return (AttendanceHandler.DailyInfo.Builder) getDailyListFieldBuilder().addBuilder(AttendanceHandler.DailyInfo.getDefaultInstance());
            }

            public AttendanceHandler.DailyInfo.Builder addDailyListBuilder(int index) {
                return (AttendanceHandler.DailyInfo.Builder) getDailyListFieldBuilder().addBuilder(index, AttendanceHandler.DailyInfo.getDefaultInstance());
            }

            public List<AttendanceHandler.DailyInfo.Builder> getDailyListBuilderList() {
                return getDailyListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<AttendanceHandler.DailyInfo, AttendanceHandler.DailyInfo.Builder, AttendanceHandler.DailyInfoOrBuilder> getDailyListFieldBuilder() {
                if (this.dailyListBuilder_ == null) {
                    this.dailyListBuilder_ = new RepeatedFieldBuilder(this.dailyList_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
                    this.dailyList_ = null;
                }
                return this.dailyListBuilder_;
            }

            private void ensureCumulativeListIsMutable() {
                if ((this.bitField0_ & 0x8) != 8) {
                    this.cumulativeList_ = new ArrayList<>(this.cumulativeList_);
                    this.bitField0_ |= 0x8;
                }
            }

            public List<AttendanceHandler.CumulativeInfo> getCumulativeListList() {
                if (this.cumulativeListBuilder_ == null) {
                    return Collections.unmodifiableList(this.cumulativeList_);
                }
                return this.cumulativeListBuilder_.getMessageList();
            }

            public int getCumulativeListCount() {
                if (this.cumulativeListBuilder_ == null) {
                    return this.cumulativeList_.size();
                }
                return this.cumulativeListBuilder_.getCount();
            }

            public AttendanceHandler.CumulativeInfo getCumulativeList(int index) {
                if (this.cumulativeListBuilder_ == null) {
                    return this.cumulativeList_.get(index);
                }
                return (AttendanceHandler.CumulativeInfo) this.cumulativeListBuilder_.getMessage(index);
            }

            public Builder setCumulativeList(int index, AttendanceHandler.CumulativeInfo value) {
                if (this.cumulativeListBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureCumulativeListIsMutable();
                    this.cumulativeList_.set(index, value);
                    onChanged();
                } else {
                    this.cumulativeListBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setCumulativeList(int index, AttendanceHandler.CumulativeInfo.Builder builderForValue) {
                if (this.cumulativeListBuilder_ == null) {
                    ensureCumulativeListIsMutable();
                    this.cumulativeList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.cumulativeListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addCumulativeList(AttendanceHandler.CumulativeInfo value) {
                if (this.cumulativeListBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureCumulativeListIsMutable();
                    this.cumulativeList_.add(value);
                    onChanged();
                } else {
                    this.cumulativeListBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addCumulativeList(int index, AttendanceHandler.CumulativeInfo value) {
                if (this.cumulativeListBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureCumulativeListIsMutable();
                    this.cumulativeList_.add(index, value);
                    onChanged();
                } else {
                    this.cumulativeListBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addCumulativeList(AttendanceHandler.CumulativeInfo.Builder builderForValue) {
                if (this.cumulativeListBuilder_ == null) {
                    ensureCumulativeListIsMutable();
                    this.cumulativeList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.cumulativeListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addCumulativeList(int index, AttendanceHandler.CumulativeInfo.Builder builderForValue) {
                if (this.cumulativeListBuilder_ == null) {
                    ensureCumulativeListIsMutable();
                    this.cumulativeList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.cumulativeListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllCumulativeList(Iterable<? extends AttendanceHandler.CumulativeInfo> values) {
                if (this.cumulativeListBuilder_ == null) {
                    ensureCumulativeListIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.cumulativeList_);
                    onChanged();
                } else {
                    this.cumulativeListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearCumulativeList() {
                if (this.cumulativeListBuilder_ == null) {
                    this.cumulativeList_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFF7;
                    onChanged();
                } else {
                    this.cumulativeListBuilder_.clear();
                }
                return this;
            }

            public Builder removeCumulativeList(int index) {
                if (this.cumulativeListBuilder_ == null) {
                    ensureCumulativeListIsMutable();
                    this.cumulativeList_.remove(index);
                    onChanged();
                } else {
                    this.cumulativeListBuilder_.remove(index);
                }
                return this;
            }

            public AttendanceHandler.CumulativeInfo.Builder getCumulativeListBuilder(int index) {
                return (AttendanceHandler.CumulativeInfo.Builder) getCumulativeListFieldBuilder().getBuilder(index);
            }

            public AttendanceHandler.CumulativeInfoOrBuilder getCumulativeListOrBuilder(int index) {
                if (this.cumulativeListBuilder_ == null) {
                    return this.cumulativeList_.get(index);
                }
                return (AttendanceHandler.CumulativeInfoOrBuilder) this.cumulativeListBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends AttendanceHandler.CumulativeInfoOrBuilder> getCumulativeListOrBuilderList() {
                if (this.cumulativeListBuilder_ != null) {
                    return this.cumulativeListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList((List) this.cumulativeList_);
            }

            public AttendanceHandler.CumulativeInfo.Builder addCumulativeListBuilder() {
                return (AttendanceHandler.CumulativeInfo.Builder) getCumulativeListFieldBuilder().addBuilder(AttendanceHandler.CumulativeInfo.getDefaultInstance());
            }

            public AttendanceHandler.CumulativeInfo.Builder addCumulativeListBuilder(int index) {
                return (AttendanceHandler.CumulativeInfo.Builder) getCumulativeListFieldBuilder().addBuilder(index, AttendanceHandler.CumulativeInfo.getDefaultInstance());
            }

            public List<AttendanceHandler.CumulativeInfo.Builder> getCumulativeListBuilderList() {
                return getCumulativeListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<AttendanceHandler.CumulativeInfo, AttendanceHandler.CumulativeInfo.Builder, AttendanceHandler.CumulativeInfoOrBuilder> getCumulativeListFieldBuilder() {
                if (this.cumulativeListBuilder_ == null) {
                    this.cumulativeListBuilder_ = new RepeatedFieldBuilder(this.cumulativeList_, ((this.bitField0_ & 0x8) == 8), getParentForChildren(), isClean());
                    this.cumulativeList_ = null;
                }
                return this.cumulativeListBuilder_;
            }
        }
    }

    public static final class LuxuryInfo
            extends GeneratedMessage
            implements LuxuryInfoOrBuilder {
        private static final LuxuryInfo defaultInstance = new LuxuryInfo(true);
        private final UnknownFieldSet unknownFields;

        private LuxuryInfo(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private LuxuryInfo(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static LuxuryInfo getDefaultInstance() {
            return defaultInstance;
        }

        public LuxuryInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private LuxuryInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.itemList_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x1;
                            }
                            this.itemList_.add(input.readMessage(ItemOuterClass.MiniItem.PARSER, extensionRegistry));
                            break;
                        case 16:
                            this.bitField0_ |= 0x1;
                            this.state_ = input.readInt32();
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x1) == 1) this.itemList_ = Collections.unmodifiableList(this.itemList_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AttendanceHandler.internal_static_pomelo_area_LuxuryInfo_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return AttendanceHandler.internal_static_pomelo_area_LuxuryInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(LuxuryInfo.class, Builder.class);
        }

        public static Parser<LuxuryInfo> PARSER = (Parser<LuxuryInfo>) new AbstractParser<LuxuryInfo>() {
            public AttendanceHandler.LuxuryInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AttendanceHandler.LuxuryInfo(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int ITEMLIST_FIELD_NUMBER = 1;
        private List<ItemOuterClass.MiniItem> itemList_;
        public static final int STATE_FIELD_NUMBER = 2;
        private int state_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<LuxuryInfo> getParserForType() {
            return PARSER;
        }

        public List<ItemOuterClass.MiniItem> getItemListList() {
            return this.itemList_;
        }

        public List<? extends ItemOuterClass.MiniItemOrBuilder> getItemListOrBuilderList() {
            return (List) this.itemList_;
        }

        public int getItemListCount() {
            return this.itemList_.size();
        }

        public ItemOuterClass.MiniItem getItemList(int index) {
            return this.itemList_.get(index);
        }

        static {
            defaultInstance.initFields();
        }


        public ItemOuterClass.MiniItemOrBuilder getItemListOrBuilder(int index) {
            return (ItemOuterClass.MiniItemOrBuilder) this.itemList_.get(index);
        }


        public boolean hasState() {
            return ((this.bitField0_ & 0x1) == 1);
        }


        public int getState() {
            return this.state_;
        }


        private void initFields() {
            this.itemList_ = Collections.emptyList();
            this.state_ = 0;
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            for (int i = 0; i < getItemListCount(); i++) {
                if (!getItemList(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            for (int i = 0; i < this.itemList_.size(); i++) {
                output.writeMessage(1, (MessageLite) this.itemList_.get(i));
            }
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeInt32(2, this.state_);
            }
            getUnknownFields().writeTo(output);
        }


        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            for (int i = 0; i < this.itemList_.size(); i++) {
                size += CodedOutputStream.computeMessageSize(1, (MessageLite) this.itemList_.get(i));
            }
            if ((this.bitField0_ & 0x1) == 1) {
                size += CodedOutputStream.computeInt32Size(2, this.state_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static LuxuryInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (LuxuryInfo) PARSER.parseFrom(data);
        }


        public static LuxuryInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (LuxuryInfo) PARSER.parseFrom(data, extensionRegistry);
        }


        public static LuxuryInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (LuxuryInfo) PARSER.parseFrom(data);
        }


        public static LuxuryInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (LuxuryInfo) PARSER.parseFrom(data, extensionRegistry);
        }


        public static LuxuryInfo parseFrom(InputStream input) throws IOException {
            return (LuxuryInfo) PARSER.parseFrom(input);
        }


        public static LuxuryInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LuxuryInfo) PARSER.parseFrom(input, extensionRegistry);
        }


        public static LuxuryInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (LuxuryInfo) PARSER.parseDelimitedFrom(input);
        }


        public static LuxuryInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LuxuryInfo) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static LuxuryInfo parseFrom(CodedInputStream input) throws IOException {
            return (LuxuryInfo) PARSER.parseFrom(input);
        }


        public static LuxuryInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LuxuryInfo) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(LuxuryInfo prototype) {
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
                implements AttendanceHandler.LuxuryInfoOrBuilder {
            private int bitField0_;


            private List<ItemOuterClass.MiniItem> itemList_;


            private RepeatedFieldBuilder<ItemOuterClass.MiniItem, ItemOuterClass.MiniItem.Builder, ItemOuterClass.MiniItemOrBuilder> itemListBuilder_;


            private int state_;


            public static final Descriptors.Descriptor getDescriptor() {
                return AttendanceHandler.internal_static_pomelo_area_LuxuryInfo_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return AttendanceHandler.internal_static_pomelo_area_LuxuryInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(AttendanceHandler.LuxuryInfo.class, Builder.class);
            }


            private Builder() {
                this.itemList_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.itemList_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (AttendanceHandler.LuxuryInfo.alwaysUseFieldBuilders) {
                    getItemListFieldBuilder();
                }
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                if (this.itemListBuilder_ == null) {
                    this.itemList_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFE;
                } else {
                    this.itemListBuilder_.clear();
                }
                this.state_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return AttendanceHandler.internal_static_pomelo_area_LuxuryInfo_descriptor;
            }


            public AttendanceHandler.LuxuryInfo getDefaultInstanceForType() {
                return AttendanceHandler.LuxuryInfo.getDefaultInstance();
            }


            public AttendanceHandler.LuxuryInfo build() {
                AttendanceHandler.LuxuryInfo result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public AttendanceHandler.LuxuryInfo buildPartial() {
                AttendanceHandler.LuxuryInfo result = new AttendanceHandler.LuxuryInfo(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if (this.itemListBuilder_ == null) {
                    if ((this.bitField0_ & 0x1) == 1) {
                        this.itemList_ = Collections.unmodifiableList(this.itemList_);
                        this.bitField0_ &= 0xFFFFFFFE;
                    }
                    result.itemList_ = this.itemList_;
                } else {
                    result.itemList_ = this.itemListBuilder_.build();
                }
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x1;
                }
                result.state_ = this.state_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof AttendanceHandler.LuxuryInfo) {
                    return mergeFrom((AttendanceHandler.LuxuryInfo) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(AttendanceHandler.LuxuryInfo other) {
                if (other == AttendanceHandler.LuxuryInfo.getDefaultInstance()) {
                    return this;
                }
                if (this.itemListBuilder_ == null) {
                    if (!other.itemList_.isEmpty()) {
                        if (this.itemList_.isEmpty()) {
                            this.itemList_ = other.itemList_;
                            this.bitField0_ &= 0xFFFFFFFE;
                        } else {
                            ensureItemListIsMutable();
                            this.itemList_.addAll(other.itemList_);
                        }
                        onChanged();
                    }
                } else if (!other.itemList_.isEmpty()) {
                    if (this.itemListBuilder_.isEmpty()) {
                        this.itemListBuilder_.dispose();
                        this.itemListBuilder_ = null;
                        this.itemList_ = other.itemList_;
                        this.bitField0_ &= 0xFFFFFFFE;
                        this.itemListBuilder_ = AttendanceHandler.LuxuryInfo.alwaysUseFieldBuilders ? getItemListFieldBuilder() : null;
                    } else {
                        this.itemListBuilder_.addAllMessages(other.itemList_);
                    }
                }
                if (other.hasState()) {
                    setState(other.getState());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                for (int i = 0; i < getItemListCount(); i++) {
                    if (!getItemList(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                AttendanceHandler.LuxuryInfo parsedMessage = null;
                try {
                    parsedMessage = (AttendanceHandler.LuxuryInfo) AttendanceHandler.LuxuryInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (AttendanceHandler.LuxuryInfo) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            private void ensureItemListIsMutable() {
                if ((this.bitField0_ & 0x1) != 1) {
                    this.itemList_ = new ArrayList<>(this.itemList_);
                    this.bitField0_ |= 0x1;
                }
            }


            public List<ItemOuterClass.MiniItem> getItemListList() {
                if (this.itemListBuilder_ == null) {
                    return Collections.unmodifiableList(this.itemList_);
                }
                return this.itemListBuilder_.getMessageList();
            }


            public int getItemListCount() {
                if (this.itemListBuilder_ == null) {
                    return this.itemList_.size();
                }
                return this.itemListBuilder_.getCount();
            }


            public ItemOuterClass.MiniItem getItemList(int index) {
                if (this.itemListBuilder_ == null) {
                    return this.itemList_.get(index);
                }
                return (ItemOuterClass.MiniItem) this.itemListBuilder_.getMessage(index);
            }


            public Builder setItemList(int index, ItemOuterClass.MiniItem value) {
                if (this.itemListBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureItemListIsMutable();
                    this.itemList_.set(index, value);
                    onChanged();
                } else {
                    this.itemListBuilder_.setMessage(index, (GeneratedMessage) value);
                }
                return this;
            }


            public Builder setItemList(int index, ItemOuterClass.MiniItem.Builder builderForValue) {
                if (this.itemListBuilder_ == null) {
                    ensureItemListIsMutable();
                    this.itemList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.itemListBuilder_.setMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }


            public Builder addItemList(ItemOuterClass.MiniItem value) {
                if (this.itemListBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureItemListIsMutable();
                    this.itemList_.add(value);
                    onChanged();
                } else {
                    this.itemListBuilder_.addMessage((GeneratedMessage) value);
                }
                return this;
            }


            public Builder addItemList(int index, ItemOuterClass.MiniItem value) {
                if (this.itemListBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureItemListIsMutable();
                    this.itemList_.add(index, value);
                    onChanged();
                } else {
                    this.itemListBuilder_.addMessage(index, (GeneratedMessage) value);
                }
                return this;
            }


            public Builder addItemList(ItemOuterClass.MiniItem.Builder builderForValue) {
                if (this.itemListBuilder_ == null) {
                    ensureItemListIsMutable();
                    this.itemList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.itemListBuilder_.addMessage((GeneratedMessage) builderForValue.build());
                }
                return this;
            }


            public Builder addItemList(int index, ItemOuterClass.MiniItem.Builder builderForValue) {
                if (this.itemListBuilder_ == null) {
                    ensureItemListIsMutable();
                    this.itemList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.itemListBuilder_.addMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }


            public Builder addAllItemList(Iterable<? extends ItemOuterClass.MiniItem> values) {
                if (this.itemListBuilder_ == null) {
                    ensureItemListIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.itemList_);
                    onChanged();
                } else {
                    this.itemListBuilder_.addAllMessages(values);
                }
                return this;
            }


            public Builder clearItemList() {
                if (this.itemListBuilder_ == null) {
                    this.itemList_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFE;
                    onChanged();
                } else {
                    this.itemListBuilder_.clear();
                }
                return this;
            }


            public Builder removeItemList(int index) {
                if (this.itemListBuilder_ == null) {
                    ensureItemListIsMutable();
                    this.itemList_.remove(index);
                    onChanged();
                } else {
                    this.itemListBuilder_.remove(index);
                }
                return this;
            }


            public ItemOuterClass.MiniItem.Builder getItemListBuilder(int index) {
                return (ItemOuterClass.MiniItem.Builder) getItemListFieldBuilder().getBuilder(index);
            }


            public ItemOuterClass.MiniItemOrBuilder getItemListOrBuilder(int index) {
                if (this.itemListBuilder_ == null) {
                    return (ItemOuterClass.MiniItemOrBuilder) this.itemList_.get(index);
                }
                return (ItemOuterClass.MiniItemOrBuilder) this.itemListBuilder_.getMessageOrBuilder(index);
            }


            public List<? extends ItemOuterClass.MiniItemOrBuilder> getItemListOrBuilderList() {
                if (this.itemListBuilder_ != null) {
                    return this.itemListBuilder_.getMessageOrBuilderList();
                }
                return (List) Collections.unmodifiableList(this.itemList_);
            }


            public ItemOuterClass.MiniItem.Builder addItemListBuilder() {
                return (ItemOuterClass.MiniItem.Builder) getItemListFieldBuilder().addBuilder((GeneratedMessage) ItemOuterClass.MiniItem.getDefaultInstance());
            }


            public ItemOuterClass.MiniItem.Builder addItemListBuilder(int index) {
                return (ItemOuterClass.MiniItem.Builder) getItemListFieldBuilder().addBuilder(index, (GeneratedMessage) ItemOuterClass.MiniItem.getDefaultInstance());
            }


            public List<ItemOuterClass.MiniItem.Builder> getItemListBuilderList() {
                return getItemListFieldBuilder().getBuilderList();
            }


            private RepeatedFieldBuilder<ItemOuterClass.MiniItem, ItemOuterClass.MiniItem.Builder, ItemOuterClass.MiniItemOrBuilder> getItemListFieldBuilder() {
                if (this.itemListBuilder_ == null) {
                    this.itemListBuilder_ = new RepeatedFieldBuilder(this.itemList_, ((this.bitField0_ & 0x1) == 1), getParentForChildren(), isClean());
                    this.itemList_ = null;
                }
                return this.itemListBuilder_;
            }


            public boolean hasState() {
                return ((this.bitField0_ & 0x2) == 2);
            }


            public int getState() {
                return this.state_;
            }


            public Builder setState(int value) {
                this.bitField0_ |= 0x2;
                this.state_ = value;
                onChanged();
                return this;
            }


            public Builder clearState() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.state_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class GetAttendanceInfoResponse
            extends GeneratedMessage
            implements GetAttendanceInfoResponseOrBuilder {
        private static final GetAttendanceInfoResponse defaultInstance = new GetAttendanceInfoResponse(true);
        private final UnknownFieldSet unknownFields;

        private GetAttendanceInfoResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetAttendanceInfoResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetAttendanceInfoResponse getDefaultInstance() {
            return defaultInstance;
        }

        public GetAttendanceInfoResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetAttendanceInfoResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString bs;
                    AttendanceHandler.AttendanceInfo.Builder builder;
                    AttendanceHandler.LuxuryInfo.Builder subBuilder;
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
                            builder = null;
                            if ((this.bitField0_ & 0x4) == 4) builder = this.s2CAttendance_.toBuilder();
                            this.s2CAttendance_ = (AttendanceHandler.AttendanceInfo) input.readMessage(AttendanceHandler.AttendanceInfo.PARSER, extensionRegistry);
                            if (builder != null) {
                                builder.mergeFrom(this.s2CAttendance_);
                                this.s2CAttendance_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 0x4;
                            break;
                        case 34:
                            subBuilder = null;
                            if ((this.bitField0_ & 0x8) == 8) subBuilder = this.s2CLuxury_.toBuilder();
                            this.s2CLuxury_ = (AttendanceHandler.LuxuryInfo) input.readMessage(AttendanceHandler.LuxuryInfo.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.s2CLuxury_);
                                this.s2CLuxury_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 0x8;
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
            return AttendanceHandler.internal_static_pomelo_area_GetAttendanceInfoResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return AttendanceHandler.internal_static_pomelo_area_GetAttendanceInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetAttendanceInfoResponse.class, Builder.class);
        }

        public static Parser<GetAttendanceInfoResponse> PARSER = (Parser<GetAttendanceInfoResponse>) new AbstractParser<GetAttendanceInfoResponse>() {
            public AttendanceHandler.GetAttendanceInfoResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AttendanceHandler.GetAttendanceInfoResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_ATTENDANCE_FIELD_NUMBER = 3;
        private AttendanceHandler.AttendanceInfo s2CAttendance_;
        public static final int S2C_LUXURY_FIELD_NUMBER = 4;
        private AttendanceHandler.LuxuryInfo s2CLuxury_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetAttendanceInfoResponse> getParserForType() {
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


        public boolean hasS2CAttendance() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public AttendanceHandler.AttendanceInfo getS2CAttendance() {
            return this.s2CAttendance_;
        }


        public AttendanceHandler.AttendanceInfoOrBuilder getS2CAttendanceOrBuilder() {
            return this.s2CAttendance_;
        }


        public boolean hasS2CLuxury() {
            return ((this.bitField0_ & 0x8) == 8);
        }


        public AttendanceHandler.LuxuryInfo getS2CLuxury() {
            return this.s2CLuxury_;
        }


        public AttendanceHandler.LuxuryInfoOrBuilder getS2CLuxuryOrBuilder() {
            return this.s2CLuxury_;
        }


        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CAttendance_ = AttendanceHandler.AttendanceInfo.getDefaultInstance();
            this.s2CLuxury_ = AttendanceHandler.LuxuryInfo.getDefaultInstance();
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
            if (hasS2CAttendance() && !getS2CAttendance().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (hasS2CLuxury() && !getS2CLuxury().isInitialized()) {
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
                output.writeMessage(3, (MessageLite) this.s2CAttendance_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                output.writeMessage(4, (MessageLite) this.s2CLuxury_);
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
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.s2CAttendance_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                size += CodedOutputStream.computeMessageSize(4, (MessageLite) this.s2CLuxury_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static GetAttendanceInfoResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetAttendanceInfoResponse) PARSER.parseFrom(data);
        }


        public static GetAttendanceInfoResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetAttendanceInfoResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetAttendanceInfoResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetAttendanceInfoResponse) PARSER.parseFrom(data);
        }


        public static GetAttendanceInfoResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetAttendanceInfoResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetAttendanceInfoResponse parseFrom(InputStream input) throws IOException {
            return (GetAttendanceInfoResponse) PARSER.parseFrom(input);
        }


        public static GetAttendanceInfoResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetAttendanceInfoResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static GetAttendanceInfoResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (GetAttendanceInfoResponse) PARSER.parseDelimitedFrom(input);
        }


        public static GetAttendanceInfoResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetAttendanceInfoResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static GetAttendanceInfoResponse parseFrom(CodedInputStream input) throws IOException {
            return (GetAttendanceInfoResponse) PARSER.parseFrom(input);
        }


        public static GetAttendanceInfoResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetAttendanceInfoResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(GetAttendanceInfoResponse prototype) {
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
                implements AttendanceHandler.GetAttendanceInfoResponseOrBuilder {
            private int bitField0_;


            private int s2CCode_;


            private Object s2CMsg_;


            private AttendanceHandler.AttendanceInfo s2CAttendance_;


            private SingleFieldBuilder<AttendanceHandler.AttendanceInfo, AttendanceHandler.AttendanceInfo.Builder, AttendanceHandler.AttendanceInfoOrBuilder> s2CAttendanceBuilder_;


            private AttendanceHandler.LuxuryInfo s2CLuxury_;


            private SingleFieldBuilder<AttendanceHandler.LuxuryInfo, AttendanceHandler.LuxuryInfo.Builder, AttendanceHandler.LuxuryInfoOrBuilder> s2CLuxuryBuilder_;


            public static final Descriptors.Descriptor getDescriptor() {
                return AttendanceHandler.internal_static_pomelo_area_GetAttendanceInfoResponse_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return AttendanceHandler.internal_static_pomelo_area_GetAttendanceInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(AttendanceHandler.GetAttendanceInfoResponse.class, Builder.class);
            }


            private Builder() {
                this.s2CMsg_ = "";
                this.s2CAttendance_ = AttendanceHandler.AttendanceInfo.getDefaultInstance();
                this.s2CLuxury_ = AttendanceHandler.LuxuryInfo.getDefaultInstance();
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CAttendance_ = AttendanceHandler.AttendanceInfo.getDefaultInstance();
                this.s2CLuxury_ = AttendanceHandler.LuxuryInfo.getDefaultInstance();
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (AttendanceHandler.GetAttendanceInfoResponse.alwaysUseFieldBuilders) {
                    getS2CAttendanceFieldBuilder();
                    getS2CLuxuryFieldBuilder();
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
                if (this.s2CAttendanceBuilder_ == null) {
                    this.s2CAttendance_ = AttendanceHandler.AttendanceInfo.getDefaultInstance();
                } else {
                    this.s2CAttendanceBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                if (this.s2CLuxuryBuilder_ == null) {
                    this.s2CLuxury_ = AttendanceHandler.LuxuryInfo.getDefaultInstance();
                } else {
                    this.s2CLuxuryBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return AttendanceHandler.internal_static_pomelo_area_GetAttendanceInfoResponse_descriptor;
            }


            public AttendanceHandler.GetAttendanceInfoResponse getDefaultInstanceForType() {
                return AttendanceHandler.GetAttendanceInfoResponse.getDefaultInstance();
            }


            public AttendanceHandler.GetAttendanceInfoResponse build() {
                AttendanceHandler.GetAttendanceInfoResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public AttendanceHandler.GetAttendanceInfoResponse buildPartial() {
                AttendanceHandler.GetAttendanceInfoResponse result = new AttendanceHandler.GetAttendanceInfoResponse(this);
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
                if (this.s2CAttendanceBuilder_ == null) {
                    result.s2CAttendance_ = this.s2CAttendance_;
                } else {
                    result.s2CAttendance_ = (AttendanceHandler.AttendanceInfo) this.s2CAttendanceBuilder_.build();
                }
                if ((from_bitField0_ & 0x8) == 8) {
                    to_bitField0_ |= 0x8;
                }
                if (this.s2CLuxuryBuilder_ == null) {
                    result.s2CLuxury_ = this.s2CLuxury_;
                } else {
                    result.s2CLuxury_ = (AttendanceHandler.LuxuryInfo) this.s2CLuxuryBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof AttendanceHandler.GetAttendanceInfoResponse) {
                    return mergeFrom((AttendanceHandler.GetAttendanceInfoResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(AttendanceHandler.GetAttendanceInfoResponse other) {
                if (other == AttendanceHandler.GetAttendanceInfoResponse.getDefaultInstance()) {
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
                if (other.hasS2CAttendance()) {
                    mergeS2CAttendance(other.getS2CAttendance());
                }
                if (other.hasS2CLuxury()) {
                    mergeS2CLuxury(other.getS2CLuxury());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasS2CCode()) {
                    return false;
                }
                if (hasS2CAttendance() && !getS2CAttendance().isInitialized()) {
                    return false;
                }
                if (hasS2CLuxury() && !getS2CLuxury().isInitialized()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                AttendanceHandler.GetAttendanceInfoResponse parsedMessage = null;
                try {
                    parsedMessage = (AttendanceHandler.GetAttendanceInfoResponse) AttendanceHandler.GetAttendanceInfoResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (AttendanceHandler.GetAttendanceInfoResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = AttendanceHandler.GetAttendanceInfoResponse.getDefaultInstance().getS2CMsg();
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


            public boolean hasS2CAttendance() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public AttendanceHandler.AttendanceInfo getS2CAttendance() {
                if (this.s2CAttendanceBuilder_ == null) {
                    return this.s2CAttendance_;
                }
                return (AttendanceHandler.AttendanceInfo) this.s2CAttendanceBuilder_.getMessage();
            }


            public Builder setS2CAttendance(AttendanceHandler.AttendanceInfo value) {
                if (this.s2CAttendanceBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.s2CAttendance_ = value;
                    onChanged();
                } else {
                    this.s2CAttendanceBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }


            public Builder setS2CAttendance(AttendanceHandler.AttendanceInfo.Builder builderForValue) {
                if (this.s2CAttendanceBuilder_ == null) {
                    this.s2CAttendance_ = builderForValue.build();
                    onChanged();
                } else {
                    this.s2CAttendanceBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x4;
                return this;
            }


            public Builder mergeS2CAttendance(AttendanceHandler.AttendanceInfo value) {
                if (this.s2CAttendanceBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4 && this.s2CAttendance_ != AttendanceHandler.AttendanceInfo.getDefaultInstance()) {
                        this.s2CAttendance_ = AttendanceHandler.AttendanceInfo.newBuilder(this.s2CAttendance_).mergeFrom(value).buildPartial();
                    } else {
                        this.s2CAttendance_ = value;
                    }
                    onChanged();
                } else {
                    this.s2CAttendanceBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }


            public Builder clearS2CAttendance() {
                if (this.s2CAttendanceBuilder_ == null) {
                    this.s2CAttendance_ = AttendanceHandler.AttendanceInfo.getDefaultInstance();
                    onChanged();
                } else {
                    this.s2CAttendanceBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }


            public AttendanceHandler.AttendanceInfo.Builder getS2CAttendanceBuilder() {
                this.bitField0_ |= 0x4;
                onChanged();
                return (AttendanceHandler.AttendanceInfo.Builder) getS2CAttendanceFieldBuilder().getBuilder();
            }


            public AttendanceHandler.AttendanceInfoOrBuilder getS2CAttendanceOrBuilder() {
                if (this.s2CAttendanceBuilder_ != null) {
                    return (AttendanceHandler.AttendanceInfoOrBuilder) this.s2CAttendanceBuilder_.getMessageOrBuilder();
                }
                return this.s2CAttendance_;
            }


            private SingleFieldBuilder<AttendanceHandler.AttendanceInfo, AttendanceHandler.AttendanceInfo.Builder, AttendanceHandler.AttendanceInfoOrBuilder> getS2CAttendanceFieldBuilder() {
                if (this.s2CAttendanceBuilder_ == null) {
                    this.s2CAttendanceBuilder_ = new SingleFieldBuilder(getS2CAttendance(), getParentForChildren(), isClean());
                    this.s2CAttendance_ = null;
                }
                return this.s2CAttendanceBuilder_;
            }


            public boolean hasS2CLuxury() {
                return ((this.bitField0_ & 0x8) == 8);
            }


            public AttendanceHandler.LuxuryInfo getS2CLuxury() {
                if (this.s2CLuxuryBuilder_ == null) {
                    return this.s2CLuxury_;
                }
                return (AttendanceHandler.LuxuryInfo) this.s2CLuxuryBuilder_.getMessage();
            }


            public Builder setS2CLuxury(AttendanceHandler.LuxuryInfo value) {
                if (this.s2CLuxuryBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.s2CLuxury_ = value;
                    onChanged();
                } else {
                    this.s2CLuxuryBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x8;
                return this;
            }


            public Builder setS2CLuxury(AttendanceHandler.LuxuryInfo.Builder builderForValue) {
                if (this.s2CLuxuryBuilder_ == null) {
                    this.s2CLuxury_ = builderForValue.build();
                    onChanged();
                } else {
                    this.s2CLuxuryBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x8;
                return this;
            }


            public Builder mergeS2CLuxury(AttendanceHandler.LuxuryInfo value) {
                if (this.s2CLuxuryBuilder_ == null) {
                    if ((this.bitField0_ & 0x8) == 8 && this.s2CLuxury_ != AttendanceHandler.LuxuryInfo.getDefaultInstance()) {
                        this.s2CLuxury_ = AttendanceHandler.LuxuryInfo.newBuilder(this.s2CLuxury_).mergeFrom(value).buildPartial();
                    } else {
                        this.s2CLuxury_ = value;
                    }
                    onChanged();
                } else {
                    this.s2CLuxuryBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x8;
                return this;
            }


            public Builder clearS2CLuxury() {
                if (this.s2CLuxuryBuilder_ == null) {
                    this.s2CLuxury_ = AttendanceHandler.LuxuryInfo.getDefaultInstance();
                    onChanged();
                } else {
                    this.s2CLuxuryBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }


            public AttendanceHandler.LuxuryInfo.Builder getS2CLuxuryBuilder() {
                this.bitField0_ |= 0x8;
                onChanged();
                return (AttendanceHandler.LuxuryInfo.Builder) getS2CLuxuryFieldBuilder().getBuilder();
            }


            public AttendanceHandler.LuxuryInfoOrBuilder getS2CLuxuryOrBuilder() {
                if (this.s2CLuxuryBuilder_ != null) {
                    return (AttendanceHandler.LuxuryInfoOrBuilder) this.s2CLuxuryBuilder_.getMessageOrBuilder();
                }
                return this.s2CLuxury_;
            }


            private SingleFieldBuilder<AttendanceHandler.LuxuryInfo, AttendanceHandler.LuxuryInfo.Builder, AttendanceHandler.LuxuryInfoOrBuilder> getS2CLuxuryFieldBuilder() {
                if (this.s2CLuxuryBuilder_ == null) {
                    this.s2CLuxuryBuilder_ = new SingleFieldBuilder(getS2CLuxury(), getParentForChildren(), isClean());
                    this.s2CLuxury_ = null;
                }
                return this.s2CLuxuryBuilder_;
            }
        }
    }


    public static final class GetDailyRewardResponse
            extends GeneratedMessage
            implements GetDailyRewardResponseOrBuilder {
        private static final GetDailyRewardResponse defaultInstance = new GetDailyRewardResponse(true);
        private final UnknownFieldSet unknownFields;

        private GetDailyRewardResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetDailyRewardResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetDailyRewardResponse getDefaultInstance() {
            return defaultInstance;
        }

        public GetDailyRewardResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetDailyRewardResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString bs;
                    AttendanceHandler.AttendanceInfo.Builder subBuilder;
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
                            if ((this.bitField0_ & 0x4) == 4) subBuilder = this.s2CAttendance_.toBuilder();
                            this.s2CAttendance_ = (AttendanceHandler.AttendanceInfo) input.readMessage(AttendanceHandler.AttendanceInfo.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.s2CAttendance_);
                                this.s2CAttendance_ = subBuilder.buildPartial();
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
            return AttendanceHandler.internal_static_pomelo_area_GetDailyRewardResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return AttendanceHandler.internal_static_pomelo_area_GetDailyRewardResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetDailyRewardResponse.class, Builder.class);
        }

        public static Parser<GetDailyRewardResponse> PARSER = (Parser<GetDailyRewardResponse>) new AbstractParser<GetDailyRewardResponse>() {
            public AttendanceHandler.GetDailyRewardResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AttendanceHandler.GetDailyRewardResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_ATTENDANCE_FIELD_NUMBER = 3;
        private AttendanceHandler.AttendanceInfo s2CAttendance_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetDailyRewardResponse> getParserForType() {
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


        public boolean hasS2CAttendance() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public AttendanceHandler.AttendanceInfo getS2CAttendance() {
            return this.s2CAttendance_;
        }


        public AttendanceHandler.AttendanceInfoOrBuilder getS2CAttendanceOrBuilder() {
            return this.s2CAttendance_;
        }


        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CAttendance_ = AttendanceHandler.AttendanceInfo.getDefaultInstance();
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
            if (hasS2CAttendance() && !getS2CAttendance().isInitialized()) {
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
                output.writeMessage(3, (MessageLite) this.s2CAttendance_);
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
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.s2CAttendance_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static GetDailyRewardResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetDailyRewardResponse) PARSER.parseFrom(data);
        }


        public static GetDailyRewardResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetDailyRewardResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetDailyRewardResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetDailyRewardResponse) PARSER.parseFrom(data);
        }


        public static GetDailyRewardResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetDailyRewardResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetDailyRewardResponse parseFrom(InputStream input) throws IOException {
            return (GetDailyRewardResponse) PARSER.parseFrom(input);
        }


        public static GetDailyRewardResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetDailyRewardResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static GetDailyRewardResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (GetDailyRewardResponse) PARSER.parseDelimitedFrom(input);
        }


        public static GetDailyRewardResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetDailyRewardResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static GetDailyRewardResponse parseFrom(CodedInputStream input) throws IOException {
            return (GetDailyRewardResponse) PARSER.parseFrom(input);
        }


        public static GetDailyRewardResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetDailyRewardResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(GetDailyRewardResponse prototype) {
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
                implements AttendanceHandler.GetDailyRewardResponseOrBuilder {
            private int bitField0_;


            private int s2CCode_;


            private Object s2CMsg_;


            private AttendanceHandler.AttendanceInfo s2CAttendance_;


            private SingleFieldBuilder<AttendanceHandler.AttendanceInfo, AttendanceHandler.AttendanceInfo.Builder, AttendanceHandler.AttendanceInfoOrBuilder> s2CAttendanceBuilder_;


            public static final Descriptors.Descriptor getDescriptor() {
                return AttendanceHandler.internal_static_pomelo_area_GetDailyRewardResponse_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return AttendanceHandler.internal_static_pomelo_area_GetDailyRewardResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(AttendanceHandler.GetDailyRewardResponse.class, Builder.class);
            }


            private Builder() {
                this.s2CMsg_ = "";
                this.s2CAttendance_ = AttendanceHandler.AttendanceInfo.getDefaultInstance();
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CAttendance_ = AttendanceHandler.AttendanceInfo.getDefaultInstance();
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (AttendanceHandler.GetDailyRewardResponse.alwaysUseFieldBuilders) {
                    getS2CAttendanceFieldBuilder();
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
                if (this.s2CAttendanceBuilder_ == null) {
                    this.s2CAttendance_ = AttendanceHandler.AttendanceInfo.getDefaultInstance();
                } else {
                    this.s2CAttendanceBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return AttendanceHandler.internal_static_pomelo_area_GetDailyRewardResponse_descriptor;
            }


            public AttendanceHandler.GetDailyRewardResponse getDefaultInstanceForType() {
                return AttendanceHandler.GetDailyRewardResponse.getDefaultInstance();
            }


            public AttendanceHandler.GetDailyRewardResponse build() {
                AttendanceHandler.GetDailyRewardResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public AttendanceHandler.GetDailyRewardResponse buildPartial() {
                AttendanceHandler.GetDailyRewardResponse result = new AttendanceHandler.GetDailyRewardResponse(this);
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
                if (this.s2CAttendanceBuilder_ == null) {
                    result.s2CAttendance_ = this.s2CAttendance_;
                } else {
                    result.s2CAttendance_ = (AttendanceHandler.AttendanceInfo) this.s2CAttendanceBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof AttendanceHandler.GetDailyRewardResponse) {
                    return mergeFrom((AttendanceHandler.GetDailyRewardResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(AttendanceHandler.GetDailyRewardResponse other) {
                if (other == AttendanceHandler.GetDailyRewardResponse.getDefaultInstance()) {
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
                if (other.hasS2CAttendance()) {
                    mergeS2CAttendance(other.getS2CAttendance());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasS2CCode()) {
                    return false;
                }
                if (hasS2CAttendance() && !getS2CAttendance().isInitialized()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                AttendanceHandler.GetDailyRewardResponse parsedMessage = null;
                try {
                    parsedMessage = (AttendanceHandler.GetDailyRewardResponse) AttendanceHandler.GetDailyRewardResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (AttendanceHandler.GetDailyRewardResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = AttendanceHandler.GetDailyRewardResponse.getDefaultInstance().getS2CMsg();
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


            public boolean hasS2CAttendance() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public AttendanceHandler.AttendanceInfo getS2CAttendance() {
                if (this.s2CAttendanceBuilder_ == null) {
                    return this.s2CAttendance_;
                }
                return (AttendanceHandler.AttendanceInfo) this.s2CAttendanceBuilder_.getMessage();
            }


            public Builder setS2CAttendance(AttendanceHandler.AttendanceInfo value) {
                if (this.s2CAttendanceBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.s2CAttendance_ = value;
                    onChanged();
                } else {
                    this.s2CAttendanceBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }


            public Builder setS2CAttendance(AttendanceHandler.AttendanceInfo.Builder builderForValue) {
                if (this.s2CAttendanceBuilder_ == null) {
                    this.s2CAttendance_ = builderForValue.build();
                    onChanged();
                } else {
                    this.s2CAttendanceBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x4;
                return this;
            }


            public Builder mergeS2CAttendance(AttendanceHandler.AttendanceInfo value) {
                if (this.s2CAttendanceBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4 && this.s2CAttendance_ != AttendanceHandler.AttendanceInfo.getDefaultInstance()) {
                        this.s2CAttendance_ = AttendanceHandler.AttendanceInfo.newBuilder(this.s2CAttendance_).mergeFrom(value).buildPartial();
                    } else {
                        this.s2CAttendance_ = value;
                    }
                    onChanged();
                } else {
                    this.s2CAttendanceBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }


            public Builder clearS2CAttendance() {
                if (this.s2CAttendanceBuilder_ == null) {
                    this.s2CAttendance_ = AttendanceHandler.AttendanceInfo.getDefaultInstance();
                    onChanged();
                } else {
                    this.s2CAttendanceBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }


            public AttendanceHandler.AttendanceInfo.Builder getS2CAttendanceBuilder() {
                this.bitField0_ |= 0x4;
                onChanged();
                return (AttendanceHandler.AttendanceInfo.Builder) getS2CAttendanceFieldBuilder().getBuilder();
            }


            public AttendanceHandler.AttendanceInfoOrBuilder getS2CAttendanceOrBuilder() {
                if (this.s2CAttendanceBuilder_ != null) {
                    return (AttendanceHandler.AttendanceInfoOrBuilder) this.s2CAttendanceBuilder_.getMessageOrBuilder();
                }
                return this.s2CAttendance_;
            }


            private SingleFieldBuilder<AttendanceHandler.AttendanceInfo, AttendanceHandler.AttendanceInfo.Builder, AttendanceHandler.AttendanceInfoOrBuilder> getS2CAttendanceFieldBuilder() {
                if (this.s2CAttendanceBuilder_ == null) {
                    this.s2CAttendanceBuilder_ = new SingleFieldBuilder(getS2CAttendance(), getParentForChildren(), isClean());
                    this.s2CAttendance_ = null;
                }
                return this.s2CAttendanceBuilder_;
            }
        }
    }


    public static final class GetCumulativeRewardResponse
            extends GeneratedMessage
            implements GetCumulativeRewardResponseOrBuilder {
        private static final GetCumulativeRewardResponse defaultInstance = new GetCumulativeRewardResponse(true);
        private final UnknownFieldSet unknownFields;

        private GetCumulativeRewardResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetCumulativeRewardResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetCumulativeRewardResponse getDefaultInstance() {
            return defaultInstance;
        }

        public GetCumulativeRewardResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetCumulativeRewardResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString bs;
                    AttendanceHandler.AttendanceInfo.Builder subBuilder;
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
                            if ((this.bitField0_ & 0x4) == 4) subBuilder = this.s2CAttendance_.toBuilder();
                            this.s2CAttendance_ = (AttendanceHandler.AttendanceInfo) input.readMessage(AttendanceHandler.AttendanceInfo.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.s2CAttendance_);
                                this.s2CAttendance_ = subBuilder.buildPartial();
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
            return AttendanceHandler.internal_static_pomelo_area_GetCumulativeRewardResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return AttendanceHandler.internal_static_pomelo_area_GetCumulativeRewardResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetCumulativeRewardResponse.class, Builder.class);
        }

        public static Parser<GetCumulativeRewardResponse> PARSER = (Parser<GetCumulativeRewardResponse>) new AbstractParser<GetCumulativeRewardResponse>() {
            public AttendanceHandler.GetCumulativeRewardResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AttendanceHandler.GetCumulativeRewardResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_ATTENDANCE_FIELD_NUMBER = 3;
        private AttendanceHandler.AttendanceInfo s2CAttendance_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetCumulativeRewardResponse> getParserForType() {
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


        public boolean hasS2CAttendance() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public AttendanceHandler.AttendanceInfo getS2CAttendance() {
            return this.s2CAttendance_;
        }


        public AttendanceHandler.AttendanceInfoOrBuilder getS2CAttendanceOrBuilder() {
            return this.s2CAttendance_;
        }


        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CAttendance_ = AttendanceHandler.AttendanceInfo.getDefaultInstance();
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
            if (hasS2CAttendance() && !getS2CAttendance().isInitialized()) {
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
                output.writeMessage(3, (MessageLite) this.s2CAttendance_);
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
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.s2CAttendance_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static GetCumulativeRewardResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetCumulativeRewardResponse) PARSER.parseFrom(data);
        }


        public static GetCumulativeRewardResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetCumulativeRewardResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetCumulativeRewardResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetCumulativeRewardResponse) PARSER.parseFrom(data);
        }


        public static GetCumulativeRewardResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetCumulativeRewardResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetCumulativeRewardResponse parseFrom(InputStream input) throws IOException {
            return (GetCumulativeRewardResponse) PARSER.parseFrom(input);
        }


        public static GetCumulativeRewardResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetCumulativeRewardResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static GetCumulativeRewardResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (GetCumulativeRewardResponse) PARSER.parseDelimitedFrom(input);
        }


        public static GetCumulativeRewardResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetCumulativeRewardResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static GetCumulativeRewardResponse parseFrom(CodedInputStream input) throws IOException {
            return (GetCumulativeRewardResponse) PARSER.parseFrom(input);
        }


        public static GetCumulativeRewardResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetCumulativeRewardResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(GetCumulativeRewardResponse prototype) {
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
                implements AttendanceHandler.GetCumulativeRewardResponseOrBuilder {
            private int bitField0_;


            private int s2CCode_;


            private Object s2CMsg_;


            private AttendanceHandler.AttendanceInfo s2CAttendance_;


            private SingleFieldBuilder<AttendanceHandler.AttendanceInfo, AttendanceHandler.AttendanceInfo.Builder, AttendanceHandler.AttendanceInfoOrBuilder> s2CAttendanceBuilder_;


            public static final Descriptors.Descriptor getDescriptor() {
                return AttendanceHandler.internal_static_pomelo_area_GetCumulativeRewardResponse_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return AttendanceHandler.internal_static_pomelo_area_GetCumulativeRewardResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(AttendanceHandler.GetCumulativeRewardResponse.class, Builder.class);
            }


            private Builder() {
                this.s2CMsg_ = "";
                this.s2CAttendance_ = AttendanceHandler.AttendanceInfo.getDefaultInstance();
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CAttendance_ = AttendanceHandler.AttendanceInfo.getDefaultInstance();
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (AttendanceHandler.GetCumulativeRewardResponse.alwaysUseFieldBuilders) {
                    getS2CAttendanceFieldBuilder();
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
                if (this.s2CAttendanceBuilder_ == null) {
                    this.s2CAttendance_ = AttendanceHandler.AttendanceInfo.getDefaultInstance();
                } else {
                    this.s2CAttendanceBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return AttendanceHandler.internal_static_pomelo_area_GetCumulativeRewardResponse_descriptor;
            }


            public AttendanceHandler.GetCumulativeRewardResponse getDefaultInstanceForType() {
                return AttendanceHandler.GetCumulativeRewardResponse.getDefaultInstance();
            }


            public AttendanceHandler.GetCumulativeRewardResponse build() {
                AttendanceHandler.GetCumulativeRewardResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public AttendanceHandler.GetCumulativeRewardResponse buildPartial() {
                AttendanceHandler.GetCumulativeRewardResponse result = new AttendanceHandler.GetCumulativeRewardResponse(this);
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
                if (this.s2CAttendanceBuilder_ == null) {
                    result.s2CAttendance_ = this.s2CAttendance_;
                } else {
                    result.s2CAttendance_ = (AttendanceHandler.AttendanceInfo) this.s2CAttendanceBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof AttendanceHandler.GetCumulativeRewardResponse) {
                    return mergeFrom((AttendanceHandler.GetCumulativeRewardResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(AttendanceHandler.GetCumulativeRewardResponse other) {
                if (other == AttendanceHandler.GetCumulativeRewardResponse.getDefaultInstance()) {
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
                if (other.hasS2CAttendance()) {
                    mergeS2CAttendance(other.getS2CAttendance());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasS2CCode()) {
                    return false;
                }
                if (hasS2CAttendance() && !getS2CAttendance().isInitialized()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                AttendanceHandler.GetCumulativeRewardResponse parsedMessage = null;
                try {
                    parsedMessage = (AttendanceHandler.GetCumulativeRewardResponse) AttendanceHandler.GetCumulativeRewardResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (AttendanceHandler.GetCumulativeRewardResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = AttendanceHandler.GetCumulativeRewardResponse.getDefaultInstance().getS2CMsg();
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


            public boolean hasS2CAttendance() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public AttendanceHandler.AttendanceInfo getS2CAttendance() {
                if (this.s2CAttendanceBuilder_ == null) {
                    return this.s2CAttendance_;
                }
                return (AttendanceHandler.AttendanceInfo) this.s2CAttendanceBuilder_.getMessage();
            }


            public Builder setS2CAttendance(AttendanceHandler.AttendanceInfo value) {
                if (this.s2CAttendanceBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.s2CAttendance_ = value;
                    onChanged();
                } else {
                    this.s2CAttendanceBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }


            public Builder setS2CAttendance(AttendanceHandler.AttendanceInfo.Builder builderForValue) {
                if (this.s2CAttendanceBuilder_ == null) {
                    this.s2CAttendance_ = builderForValue.build();
                    onChanged();
                } else {
                    this.s2CAttendanceBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x4;
                return this;
            }


            public Builder mergeS2CAttendance(AttendanceHandler.AttendanceInfo value) {
                if (this.s2CAttendanceBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4 && this.s2CAttendance_ != AttendanceHandler.AttendanceInfo.getDefaultInstance()) {
                        this.s2CAttendance_ = AttendanceHandler.AttendanceInfo.newBuilder(this.s2CAttendance_).mergeFrom(value).buildPartial();
                    } else {
                        this.s2CAttendance_ = value;
                    }
                    onChanged();
                } else {
                    this.s2CAttendanceBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }


            public Builder clearS2CAttendance() {
                if (this.s2CAttendanceBuilder_ == null) {
                    this.s2CAttendance_ = AttendanceHandler.AttendanceInfo.getDefaultInstance();
                    onChanged();
                } else {
                    this.s2CAttendanceBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }


            public AttendanceHandler.AttendanceInfo.Builder getS2CAttendanceBuilder() {
                this.bitField0_ |= 0x4;
                onChanged();
                return (AttendanceHandler.AttendanceInfo.Builder) getS2CAttendanceFieldBuilder().getBuilder();
            }


            public AttendanceHandler.AttendanceInfoOrBuilder getS2CAttendanceOrBuilder() {
                if (this.s2CAttendanceBuilder_ != null) {
                    return (AttendanceHandler.AttendanceInfoOrBuilder) this.s2CAttendanceBuilder_.getMessageOrBuilder();
                }
                return this.s2CAttendance_;
            }


            private SingleFieldBuilder<AttendanceHandler.AttendanceInfo, AttendanceHandler.AttendanceInfo.Builder, AttendanceHandler.AttendanceInfoOrBuilder> getS2CAttendanceFieldBuilder() {
                if (this.s2CAttendanceBuilder_ == null) {
                    this.s2CAttendanceBuilder_ = new SingleFieldBuilder(getS2CAttendance(), getParentForChildren(), isClean());
                    this.s2CAttendance_ = null;
                }
                return this.s2CAttendanceBuilder_;
            }
        }
    }


    public static final class GetLuxuryRewardResponse
            extends GeneratedMessage
            implements GetLuxuryRewardResponseOrBuilder {
        private static final GetLuxuryRewardResponse defaultInstance = new GetLuxuryRewardResponse(true);
        private final UnknownFieldSet unknownFields;

        private GetLuxuryRewardResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetLuxuryRewardResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetLuxuryRewardResponse getDefaultInstance() {
            return defaultInstance;
        }

        public GetLuxuryRewardResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetLuxuryRewardResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString bs;
                    AttendanceHandler.LuxuryInfo.Builder subBuilder;
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
                            if ((this.bitField0_ & 0x4) == 4) subBuilder = this.s2CLuxury_.toBuilder();
                            this.s2CLuxury_ = (AttendanceHandler.LuxuryInfo) input.readMessage(AttendanceHandler.LuxuryInfo.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.s2CLuxury_);
                                this.s2CLuxury_ = subBuilder.buildPartial();
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
            return AttendanceHandler.internal_static_pomelo_area_GetLuxuryRewardResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return AttendanceHandler.internal_static_pomelo_area_GetLuxuryRewardResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetLuxuryRewardResponse.class, Builder.class);
        }

        public static Parser<GetLuxuryRewardResponse> PARSER = (Parser<GetLuxuryRewardResponse>) new AbstractParser<GetLuxuryRewardResponse>() {
            public AttendanceHandler.GetLuxuryRewardResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AttendanceHandler.GetLuxuryRewardResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_LUXURY_FIELD_NUMBER = 3;
        private AttendanceHandler.LuxuryInfo s2CLuxury_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetLuxuryRewardResponse> getParserForType() {
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


        public boolean hasS2CLuxury() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public AttendanceHandler.LuxuryInfo getS2CLuxury() {
            return this.s2CLuxury_;
        }


        public AttendanceHandler.LuxuryInfoOrBuilder getS2CLuxuryOrBuilder() {
            return this.s2CLuxury_;
        }


        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CLuxury_ = AttendanceHandler.LuxuryInfo.getDefaultInstance();
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
            if (hasS2CLuxury() && !getS2CLuxury().isInitialized()) {
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
                output.writeMessage(3, (MessageLite) this.s2CLuxury_);
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
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.s2CLuxury_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static GetLuxuryRewardResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetLuxuryRewardResponse) PARSER.parseFrom(data);
        }


        public static GetLuxuryRewardResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetLuxuryRewardResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetLuxuryRewardResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetLuxuryRewardResponse) PARSER.parseFrom(data);
        }


        public static GetLuxuryRewardResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetLuxuryRewardResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetLuxuryRewardResponse parseFrom(InputStream input) throws IOException {
            return (GetLuxuryRewardResponse) PARSER.parseFrom(input);
        }


        public static GetLuxuryRewardResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetLuxuryRewardResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static GetLuxuryRewardResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (GetLuxuryRewardResponse) PARSER.parseDelimitedFrom(input);
        }


        public static GetLuxuryRewardResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetLuxuryRewardResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static GetLuxuryRewardResponse parseFrom(CodedInputStream input) throws IOException {
            return (GetLuxuryRewardResponse) PARSER.parseFrom(input);
        }


        public static GetLuxuryRewardResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetLuxuryRewardResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(GetLuxuryRewardResponse prototype) {
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
                implements AttendanceHandler.GetLuxuryRewardResponseOrBuilder {
            private int bitField0_;


            private int s2CCode_;


            private Object s2CMsg_;


            private AttendanceHandler.LuxuryInfo s2CLuxury_;


            private SingleFieldBuilder<AttendanceHandler.LuxuryInfo, AttendanceHandler.LuxuryInfo.Builder, AttendanceHandler.LuxuryInfoOrBuilder> s2CLuxuryBuilder_;


            public static final Descriptors.Descriptor getDescriptor() {
                return AttendanceHandler.internal_static_pomelo_area_GetLuxuryRewardResponse_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return AttendanceHandler.internal_static_pomelo_area_GetLuxuryRewardResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(AttendanceHandler.GetLuxuryRewardResponse.class, Builder.class);
            }


            private Builder() {
                this.s2CMsg_ = "";
                this.s2CLuxury_ = AttendanceHandler.LuxuryInfo.getDefaultInstance();
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CLuxury_ = AttendanceHandler.LuxuryInfo.getDefaultInstance();
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (AttendanceHandler.GetLuxuryRewardResponse.alwaysUseFieldBuilders) {
                    getS2CLuxuryFieldBuilder();
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
                if (this.s2CLuxuryBuilder_ == null) {
                    this.s2CLuxury_ = AttendanceHandler.LuxuryInfo.getDefaultInstance();
                } else {
                    this.s2CLuxuryBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return AttendanceHandler.internal_static_pomelo_area_GetLuxuryRewardResponse_descriptor;
            }


            public AttendanceHandler.GetLuxuryRewardResponse getDefaultInstanceForType() {
                return AttendanceHandler.GetLuxuryRewardResponse.getDefaultInstance();
            }


            public AttendanceHandler.GetLuxuryRewardResponse build() {
                AttendanceHandler.GetLuxuryRewardResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public AttendanceHandler.GetLuxuryRewardResponse buildPartial() {
                AttendanceHandler.GetLuxuryRewardResponse result = new AttendanceHandler.GetLuxuryRewardResponse(this);
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
                if (this.s2CLuxuryBuilder_ == null) {
                    result.s2CLuxury_ = this.s2CLuxury_;
                } else {
                    result.s2CLuxury_ = (AttendanceHandler.LuxuryInfo) this.s2CLuxuryBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof AttendanceHandler.GetLuxuryRewardResponse) {
                    return mergeFrom((AttendanceHandler.GetLuxuryRewardResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(AttendanceHandler.GetLuxuryRewardResponse other) {
                if (other == AttendanceHandler.GetLuxuryRewardResponse.getDefaultInstance()) {
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
                if (other.hasS2CLuxury()) {
                    mergeS2CLuxury(other.getS2CLuxury());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasS2CCode()) {
                    return false;
                }
                if (hasS2CLuxury() && !getS2CLuxury().isInitialized()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                AttendanceHandler.GetLuxuryRewardResponse parsedMessage = null;
                try {
                    parsedMessage = (AttendanceHandler.GetLuxuryRewardResponse) AttendanceHandler.GetLuxuryRewardResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (AttendanceHandler.GetLuxuryRewardResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = AttendanceHandler.GetLuxuryRewardResponse.getDefaultInstance().getS2CMsg();
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


            public boolean hasS2CLuxury() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public AttendanceHandler.LuxuryInfo getS2CLuxury() {
                if (this.s2CLuxuryBuilder_ == null) {
                    return this.s2CLuxury_;
                }
                return (AttendanceHandler.LuxuryInfo) this.s2CLuxuryBuilder_.getMessage();
            }


            public Builder setS2CLuxury(AttendanceHandler.LuxuryInfo value) {
                if (this.s2CLuxuryBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.s2CLuxury_ = value;
                    onChanged();
                } else {
                    this.s2CLuxuryBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }


            public Builder setS2CLuxury(AttendanceHandler.LuxuryInfo.Builder builderForValue) {
                if (this.s2CLuxuryBuilder_ == null) {
                    this.s2CLuxury_ = builderForValue.build();
                    onChanged();
                } else {
                    this.s2CLuxuryBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x4;
                return this;
            }


            public Builder mergeS2CLuxury(AttendanceHandler.LuxuryInfo value) {
                if (this.s2CLuxuryBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4 && this.s2CLuxury_ != AttendanceHandler.LuxuryInfo.getDefaultInstance()) {
                        this.s2CLuxury_ = AttendanceHandler.LuxuryInfo.newBuilder(this.s2CLuxury_).mergeFrom(value).buildPartial();
                    } else {
                        this.s2CLuxury_ = value;
                    }
                    onChanged();
                } else {
                    this.s2CLuxuryBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }


            public Builder clearS2CLuxury() {
                if (this.s2CLuxuryBuilder_ == null) {
                    this.s2CLuxury_ = AttendanceHandler.LuxuryInfo.getDefaultInstance();
                    onChanged();
                } else {
                    this.s2CLuxuryBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }


            public AttendanceHandler.LuxuryInfo.Builder getS2CLuxuryBuilder() {
                this.bitField0_ |= 0x4;
                onChanged();
                return (AttendanceHandler.LuxuryInfo.Builder) getS2CLuxuryFieldBuilder().getBuilder();
            }


            public AttendanceHandler.LuxuryInfoOrBuilder getS2CLuxuryOrBuilder() {
                if (this.s2CLuxuryBuilder_ != null) {
                    return (AttendanceHandler.LuxuryInfoOrBuilder) this.s2CLuxuryBuilder_.getMessageOrBuilder();
                }
                return this.s2CLuxury_;
            }


            private SingleFieldBuilder<AttendanceHandler.LuxuryInfo, AttendanceHandler.LuxuryInfo.Builder, AttendanceHandler.LuxuryInfoOrBuilder> getS2CLuxuryFieldBuilder() {
                if (this.s2CLuxuryBuilder_ == null) {
                    this.s2CLuxuryBuilder_ = new SingleFieldBuilder(getS2CLuxury(), getParentForChildren(), isClean());
                    this.s2CLuxury_ = null;
                }
                return this.s2CLuxuryBuilder_;
            }
        }
    }


    public static final class GetLeftVipRewardResponse
            extends GeneratedMessage
            implements GetLeftVipRewardResponseOrBuilder {
        private static final GetLeftVipRewardResponse defaultInstance = new GetLeftVipRewardResponse(true);
        private final UnknownFieldSet unknownFields;

        private GetLeftVipRewardResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetLeftVipRewardResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetLeftVipRewardResponse getDefaultInstance() {
            return defaultInstance;
        }

        public GetLeftVipRewardResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetLeftVipRewardResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString bs;
                    AttendanceHandler.AttendanceInfo.Builder subBuilder;
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
                            if ((this.bitField0_ & 0x4) == 4) subBuilder = this.s2CAttendance_.toBuilder();
                            this.s2CAttendance_ = (AttendanceHandler.AttendanceInfo) input.readMessage(AttendanceHandler.AttendanceInfo.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.s2CAttendance_);
                                this.s2CAttendance_ = subBuilder.buildPartial();
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
            return AttendanceHandler.internal_static_pomelo_area_GetLeftVipRewardResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return AttendanceHandler.internal_static_pomelo_area_GetLeftVipRewardResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetLeftVipRewardResponse.class, Builder.class);
        }

        public static Parser<GetLeftVipRewardResponse> PARSER = (Parser<GetLeftVipRewardResponse>) new AbstractParser<GetLeftVipRewardResponse>() {
            public AttendanceHandler.GetLeftVipRewardResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AttendanceHandler.GetLeftVipRewardResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_ATTENDANCE_FIELD_NUMBER = 3;
        private AttendanceHandler.AttendanceInfo s2CAttendance_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetLeftVipRewardResponse> getParserForType() {
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


        public boolean hasS2CAttendance() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public AttendanceHandler.AttendanceInfo getS2CAttendance() {
            return this.s2CAttendance_;
        }


        public AttendanceHandler.AttendanceInfoOrBuilder getS2CAttendanceOrBuilder() {
            return this.s2CAttendance_;
        }


        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CAttendance_ = AttendanceHandler.AttendanceInfo.getDefaultInstance();
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
            if (hasS2CAttendance() && !getS2CAttendance().isInitialized()) {
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
                output.writeMessage(3, (MessageLite) this.s2CAttendance_);
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
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.s2CAttendance_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static GetLeftVipRewardResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetLeftVipRewardResponse) PARSER.parseFrom(data);
        }


        public static GetLeftVipRewardResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetLeftVipRewardResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetLeftVipRewardResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetLeftVipRewardResponse) PARSER.parseFrom(data);
        }


        public static GetLeftVipRewardResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetLeftVipRewardResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetLeftVipRewardResponse parseFrom(InputStream input) throws IOException {
            return (GetLeftVipRewardResponse) PARSER.parseFrom(input);
        }


        public static GetLeftVipRewardResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetLeftVipRewardResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static GetLeftVipRewardResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (GetLeftVipRewardResponse) PARSER.parseDelimitedFrom(input);
        }


        public static GetLeftVipRewardResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetLeftVipRewardResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static GetLeftVipRewardResponse parseFrom(CodedInputStream input) throws IOException {
            return (GetLeftVipRewardResponse) PARSER.parseFrom(input);
        }


        public static GetLeftVipRewardResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetLeftVipRewardResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(GetLeftVipRewardResponse prototype) {
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
                implements AttendanceHandler.GetLeftVipRewardResponseOrBuilder {
            private int bitField0_;


            private int s2CCode_;


            private Object s2CMsg_;


            private AttendanceHandler.AttendanceInfo s2CAttendance_;


            private SingleFieldBuilder<AttendanceHandler.AttendanceInfo, AttendanceHandler.AttendanceInfo.Builder, AttendanceHandler.AttendanceInfoOrBuilder> s2CAttendanceBuilder_;


            public static final Descriptors.Descriptor getDescriptor() {
                return AttendanceHandler.internal_static_pomelo_area_GetLeftVipRewardResponse_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return AttendanceHandler.internal_static_pomelo_area_GetLeftVipRewardResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(AttendanceHandler.GetLeftVipRewardResponse.class, Builder.class);
            }


            private Builder() {
                this.s2CMsg_ = "";
                this.s2CAttendance_ = AttendanceHandler.AttendanceInfo.getDefaultInstance();
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CAttendance_ = AttendanceHandler.AttendanceInfo.getDefaultInstance();
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (AttendanceHandler.GetLeftVipRewardResponse.alwaysUseFieldBuilders) {
                    getS2CAttendanceFieldBuilder();
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
                if (this.s2CAttendanceBuilder_ == null) {
                    this.s2CAttendance_ = AttendanceHandler.AttendanceInfo.getDefaultInstance();
                } else {
                    this.s2CAttendanceBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return AttendanceHandler.internal_static_pomelo_area_GetLeftVipRewardResponse_descriptor;
            }


            public AttendanceHandler.GetLeftVipRewardResponse getDefaultInstanceForType() {
                return AttendanceHandler.GetLeftVipRewardResponse.getDefaultInstance();
            }


            public AttendanceHandler.GetLeftVipRewardResponse build() {
                AttendanceHandler.GetLeftVipRewardResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public AttendanceHandler.GetLeftVipRewardResponse buildPartial() {
                AttendanceHandler.GetLeftVipRewardResponse result = new AttendanceHandler.GetLeftVipRewardResponse(this);
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
                if (this.s2CAttendanceBuilder_ == null) {
                    result.s2CAttendance_ = this.s2CAttendance_;
                } else {
                    result.s2CAttendance_ = (AttendanceHandler.AttendanceInfo) this.s2CAttendanceBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof AttendanceHandler.GetLeftVipRewardResponse) {
                    return mergeFrom((AttendanceHandler.GetLeftVipRewardResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(AttendanceHandler.GetLeftVipRewardResponse other) {
                if (other == AttendanceHandler.GetLeftVipRewardResponse.getDefaultInstance()) {
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
                if (other.hasS2CAttendance()) {
                    mergeS2CAttendance(other.getS2CAttendance());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasS2CCode()) {
                    return false;
                }
                if (hasS2CAttendance() && !getS2CAttendance().isInitialized()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                AttendanceHandler.GetLeftVipRewardResponse parsedMessage = null;
                try {
                    parsedMessage = (AttendanceHandler.GetLeftVipRewardResponse) AttendanceHandler.GetLeftVipRewardResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (AttendanceHandler.GetLeftVipRewardResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = AttendanceHandler.GetLeftVipRewardResponse.getDefaultInstance().getS2CMsg();
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


            public boolean hasS2CAttendance() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public AttendanceHandler.AttendanceInfo getS2CAttendance() {
                if (this.s2CAttendanceBuilder_ == null) {
                    return this.s2CAttendance_;
                }
                return (AttendanceHandler.AttendanceInfo) this.s2CAttendanceBuilder_.getMessage();
            }


            public Builder setS2CAttendance(AttendanceHandler.AttendanceInfo value) {
                if (this.s2CAttendanceBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.s2CAttendance_ = value;
                    onChanged();
                } else {
                    this.s2CAttendanceBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }


            public Builder setS2CAttendance(AttendanceHandler.AttendanceInfo.Builder builderForValue) {
                if (this.s2CAttendanceBuilder_ == null) {
                    this.s2CAttendance_ = builderForValue.build();
                    onChanged();
                } else {
                    this.s2CAttendanceBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x4;
                return this;
            }


            public Builder mergeS2CAttendance(AttendanceHandler.AttendanceInfo value) {
                if (this.s2CAttendanceBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4 && this.s2CAttendance_ != AttendanceHandler.AttendanceInfo.getDefaultInstance()) {
                        this.s2CAttendance_ = AttendanceHandler.AttendanceInfo.newBuilder(this.s2CAttendance_).mergeFrom(value).buildPartial();
                    } else {
                        this.s2CAttendance_ = value;
                    }
                    onChanged();
                } else {
                    this.s2CAttendanceBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }


            public Builder clearS2CAttendance() {
                if (this.s2CAttendanceBuilder_ == null) {
                    this.s2CAttendance_ = AttendanceHandler.AttendanceInfo.getDefaultInstance();
                    onChanged();
                } else {
                    this.s2CAttendanceBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }


            public AttendanceHandler.AttendanceInfo.Builder getS2CAttendanceBuilder() {
                this.bitField0_ |= 0x4;
                onChanged();
                return (AttendanceHandler.AttendanceInfo.Builder) getS2CAttendanceFieldBuilder().getBuilder();
            }


            public AttendanceHandler.AttendanceInfoOrBuilder getS2CAttendanceOrBuilder() {
                if (this.s2CAttendanceBuilder_ != null) {
                    return (AttendanceHandler.AttendanceInfoOrBuilder) this.s2CAttendanceBuilder_.getMessageOrBuilder();
                }
                return this.s2CAttendance_;
            }


            private SingleFieldBuilder<AttendanceHandler.AttendanceInfo, AttendanceHandler.AttendanceInfo.Builder, AttendanceHandler.AttendanceInfoOrBuilder> getS2CAttendanceFieldBuilder() {
                if (this.s2CAttendanceBuilder_ == null) {
                    this.s2CAttendanceBuilder_ = new SingleFieldBuilder(getS2CAttendance(), getParentForChildren(), isClean());
                    this.s2CAttendance_ = null;
                }
                return this.s2CAttendanceBuilder_;
            }
        }
    }


    public static final class LuxuryRewardPush
            extends GeneratedMessage
            implements LuxuryRewardPushOrBuilder {
        private final UnknownFieldSet unknownFields;


        private LuxuryRewardPush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }


        private LuxuryRewardPush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }


        public static LuxuryRewardPush getDefaultInstance() {
            return defaultInstance;
        }


        public LuxuryRewardPush getDefaultInstanceForType() {
            return defaultInstance;
        }


        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }


        private LuxuryRewardPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString bs;
                    AttendanceHandler.LuxuryInfo.Builder subBuilder;
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
                            if ((this.bitField0_ & 0x4) == 4) {
                                subBuilder = this.s2CLuxury_.toBuilder();
                            }
                            this.s2CLuxury_ = (AttendanceHandler.LuxuryInfo) input.readMessage(AttendanceHandler.LuxuryInfo.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.s2CLuxury_);
                                this.s2CLuxury_ = subBuilder.buildPartial();
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
            return AttendanceHandler.internal_static_pomelo_area_LuxuryRewardPush_descriptor;
        }


        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return AttendanceHandler.internal_static_pomelo_area_LuxuryRewardPush_fieldAccessorTable.ensureFieldAccessorsInitialized(LuxuryRewardPush.class, Builder.class);
        }


        public static Parser<LuxuryRewardPush> PARSER = (Parser<LuxuryRewardPush>) new AbstractParser<LuxuryRewardPush>() {
            public AttendanceHandler.LuxuryRewardPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AttendanceHandler.LuxuryRewardPush(input, extensionRegistry);
            }
        };


        private int bitField0_;


        public static final int S2C_CODE_FIELD_NUMBER = 1;


        private int s2CCode_;


        public static final int S2C_MSG_FIELD_NUMBER = 2;


        private Object s2CMsg_;


        public static final int S2C_LUXURY_FIELD_NUMBER = 3;


        private AttendanceHandler.LuxuryInfo s2CLuxury_;


        private byte memoizedIsInitialized;


        private int memoizedSerializedSize;


        private static final long serialVersionUID = 0L;


        public Parser<LuxuryRewardPush> getParserForType() {
            return PARSER;
        }


        public boolean hasS2CCode() {
            return ((this.bitField0_ & 0x1) == 1);
        }


        private static final LuxuryRewardPush defaultInstance = new LuxuryRewardPush(true);

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

        public boolean hasS2CLuxury() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public AttendanceHandler.LuxuryInfo getS2CLuxury() {
            return this.s2CLuxury_;
        }

        public AttendanceHandler.LuxuryInfoOrBuilder getS2CLuxuryOrBuilder() {
            return this.s2CLuxury_;
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CLuxury_ = AttendanceHandler.LuxuryInfo.getDefaultInstance();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasS2CCode()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (hasS2CLuxury() && !getS2CLuxury().isInitialized()) {
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
            if ((this.bitField0_ & 0x4) == 4) output.writeMessage(3, (MessageLite) this.s2CLuxury_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());
            if ((this.bitField0_ & 0x4) == 4)
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.s2CLuxury_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static LuxuryRewardPush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (LuxuryRewardPush) PARSER.parseFrom(data);
        }

        public static LuxuryRewardPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (LuxuryRewardPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static LuxuryRewardPush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (LuxuryRewardPush) PARSER.parseFrom(data);
        }

        public static LuxuryRewardPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (LuxuryRewardPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static LuxuryRewardPush parseFrom(InputStream input) throws IOException {
            return (LuxuryRewardPush) PARSER.parseFrom(input);
        }

        public static LuxuryRewardPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LuxuryRewardPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static LuxuryRewardPush parseDelimitedFrom(InputStream input) throws IOException {
            return (LuxuryRewardPush) PARSER.parseDelimitedFrom(input);
        }

        public static LuxuryRewardPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LuxuryRewardPush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static LuxuryRewardPush parseFrom(CodedInputStream input) throws IOException {
            return (LuxuryRewardPush) PARSER.parseFrom(input);
        }

        public static LuxuryRewardPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LuxuryRewardPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(LuxuryRewardPush prototype) {
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

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements AttendanceHandler.LuxuryRewardPushOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private AttendanceHandler.LuxuryInfo s2CLuxury_;
            private SingleFieldBuilder<AttendanceHandler.LuxuryInfo, AttendanceHandler.LuxuryInfo.Builder, AttendanceHandler.LuxuryInfoOrBuilder> s2CLuxuryBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AttendanceHandler.internal_static_pomelo_area_LuxuryRewardPush_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return AttendanceHandler.internal_static_pomelo_area_LuxuryRewardPush_fieldAccessorTable.ensureFieldAccessorsInitialized(AttendanceHandler.LuxuryRewardPush.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.s2CLuxury_ = AttendanceHandler.LuxuryInfo.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CLuxury_ = AttendanceHandler.LuxuryInfo.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AttendanceHandler.LuxuryRewardPush.alwaysUseFieldBuilders)
                    getS2CLuxuryFieldBuilder();
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
                if (this.s2CLuxuryBuilder_ == null) {
                    this.s2CLuxury_ = AttendanceHandler.LuxuryInfo.getDefaultInstance();
                } else {
                    this.s2CLuxuryBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return AttendanceHandler.internal_static_pomelo_area_LuxuryRewardPush_descriptor;
            }

            public AttendanceHandler.LuxuryRewardPush getDefaultInstanceForType() {
                return AttendanceHandler.LuxuryRewardPush.getDefaultInstance();
            }

            public AttendanceHandler.LuxuryRewardPush build() {
                AttendanceHandler.LuxuryRewardPush result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public AttendanceHandler.LuxuryRewardPush buildPartial() {
                AttendanceHandler.LuxuryRewardPush result = new AttendanceHandler.LuxuryRewardPush(this);
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
                if (this.s2CLuxuryBuilder_ == null) {
                    result.s2CLuxury_ = this.s2CLuxury_;
                } else {
                    result.s2CLuxury_ = (AttendanceHandler.LuxuryInfo) this.s2CLuxuryBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof AttendanceHandler.LuxuryRewardPush)
                    return mergeFrom((AttendanceHandler.LuxuryRewardPush) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AttendanceHandler.LuxuryRewardPush other) {
                if (other == AttendanceHandler.LuxuryRewardPush.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (other.hasS2CLuxury())
                    mergeS2CLuxury(other.getS2CLuxury());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode())
                    return false;
                if (hasS2CLuxury() && !getS2CLuxury().isInitialized())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                AttendanceHandler.LuxuryRewardPush parsedMessage = null;
                try {
                    parsedMessage = (AttendanceHandler.LuxuryRewardPush) AttendanceHandler.LuxuryRewardPush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (AttendanceHandler.LuxuryRewardPush) e.getUnfinishedMessage();
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
                this.s2CMsg_ = AttendanceHandler.LuxuryRewardPush.getDefaultInstance().getS2CMsg();
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

            public boolean hasS2CLuxury() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public AttendanceHandler.LuxuryInfo getS2CLuxury() {
                if (this.s2CLuxuryBuilder_ == null)
                    return this.s2CLuxury_;
                return (AttendanceHandler.LuxuryInfo) this.s2CLuxuryBuilder_.getMessage();
            }

            public Builder setS2CLuxury(AttendanceHandler.LuxuryInfo value) {
                if (this.s2CLuxuryBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    this.s2CLuxury_ = value;
                    onChanged();
                } else {
                    this.s2CLuxuryBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder setS2CLuxury(AttendanceHandler.LuxuryInfo.Builder builderForValue) {
                if (this.s2CLuxuryBuilder_ == null) {
                    this.s2CLuxury_ = builderForValue.build();
                    onChanged();
                } else {
                    this.s2CLuxuryBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder mergeS2CLuxury(AttendanceHandler.LuxuryInfo value) {
                if (this.s2CLuxuryBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4 && this.s2CLuxury_ != AttendanceHandler.LuxuryInfo.getDefaultInstance()) {
                        this.s2CLuxury_ = AttendanceHandler.LuxuryInfo.newBuilder(this.s2CLuxury_).mergeFrom(value).buildPartial();
                    } else {
                        this.s2CLuxury_ = value;
                    }
                    onChanged();
                } else {
                    this.s2CLuxuryBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder clearS2CLuxury() {
                if (this.s2CLuxuryBuilder_ == null) {
                    this.s2CLuxury_ = AttendanceHandler.LuxuryInfo.getDefaultInstance();
                    onChanged();
                } else {
                    this.s2CLuxuryBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public AttendanceHandler.LuxuryInfo.Builder getS2CLuxuryBuilder() {
                this.bitField0_ |= 0x4;
                onChanged();
                return (AttendanceHandler.LuxuryInfo.Builder) getS2CLuxuryFieldBuilder().getBuilder();
            }

            public AttendanceHandler.LuxuryInfoOrBuilder getS2CLuxuryOrBuilder() {
                if (this.s2CLuxuryBuilder_ != null)
                    return (AttendanceHandler.LuxuryInfoOrBuilder) this.s2CLuxuryBuilder_.getMessageOrBuilder();
                return this.s2CLuxury_;
            }

            private SingleFieldBuilder<AttendanceHandler.LuxuryInfo, AttendanceHandler.LuxuryInfo.Builder, AttendanceHandler.LuxuryInfoOrBuilder> getS2CLuxuryFieldBuilder() {
                if (this.s2CLuxuryBuilder_ == null) {
                    this.s2CLuxuryBuilder_ = new SingleFieldBuilder(getS2CLuxury(), getParentForChildren(), isClean());
                    this.s2CLuxury_ = null;
                }
                return this.s2CLuxuryBuilder_;
            }
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }


    static {
        String[] descriptorData = {"\n\027attendanceHandler.proto\022\013pomelo.area\032\fcommon.proto\032\nitem.proto\"\032\n\030GetAttendanceInfoRequest\"\027\n\025GetDailyRewardRequest\"(\n\032GetCumulativeRewardRequest\022\n\n\002id\030\001 \002(\005\"\030\n\026GetLuxuryRewardRequest\"%\n\027GetLeftVipRewardRequest\022\n\n\002id\030\001 \002(\005\"g\n\tDailyInfo\022\n\n\002id\030\001 \002(\005\022'\n\bitemList\030\002 \001(\0132\025.pomelo.item.MiniItem\022\026\n\016vipDoubleLevel\030\003 \001(\005\022\r\n\005state\030\004 \001(\005\"{\n\016CumulativeInfo\022\n\n\002id\030\001 \002(\005\022'\n\bitemList\030\002 \003(\0132\025.pomelo.item.MiniItem", "\022\024\n\fneedCountDay\030\003 \001(\005\022\r\n\005state\030\004 \001(\005\022\017\n\007boxIcon\030\005 \001(\t\"\001\n\016AttendanceInfo\022\022\n\ntodayState\030\001 \001(\005\022\023\n\013signedCount\030\002 \001(\005\022)\n\tdailyList\030\003 \003(\0132\026.pomelo.area.DailyInfo\0223\n\016cumulativeList\030\004 \003(\0132\033.pomelo.area.CumulativeInfo\"D\n\nLuxuryInfo\022'\n\bitemList\030\001 \003(\0132\025.pomelo.item.MiniItem\022\r\n\005state\030\002 \001(\005\" \001\n\031GetAttendanceInfoResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\0223\n\016s2c_attendance\030\003 \001(\0132\033.pomelo.area.AttendanceInfo\022+", "\n\ns2c_luxury\030\004 \001(\0132\027.pomelo.area.LuxuryInfo\"p\n\026GetDailyRewardResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\0223\n\016s2c_attendance\030\003 \001(\0132\033.pomelo.area.AttendanceInfo\"u\n\033GetCumulativeRewardResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\0223\n\016s2c_attendance\030\003 \001(\0132\033.pomelo.area.AttendanceInfo\"i\n\027GetLuxuryRewardResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022+\n\ns2c_luxury\030\003 \001(\0132\027.pomelo.area.LuxuryInfo\"r\n\030GetLeftVipRew", "ardResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\0223\n\016s2c_attendance\030\003 \001(\0132\033.pomelo.area.AttendanceInfo\"b\n\020LuxuryRewardPush\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022+\n\ns2c_luxury\030\003 \001(\0132\027.pomelo.area.LuxuryInfo2\004\n\021attendanceHandler\022i\n\030getAttendanceInfoRequest\022%.pomelo.area.GetAttendanceInfoRequest\032&.pomelo.area.GetAttendanceInfoResponse\022`\n\025getDailyRewardRequest\022\".pomelo.area.GetDailyRewardRequest\032#.pomelo.a", "rea.GetDailyRewardResponse\022o\n\032getCumulativeRewardRequest\022'.pomelo.area.GetCumulativeRewardRequest\032(.pomelo.area.GetCumulativeRewardResponse\022c\n\026getLuxuryRewardRequest\022#.pomelo.area.GetLuxuryRewardRequest\032$.pomelo.area.GetLuxuryRewardResponse\022f\n\027getLeftVipRewardRequest\022$.pomelo.area.GetLeftVipRewardRequest\032%.pomelo.area.GetLeftVipRewardResponse2Q\n\016attendancePush\022?\n\020luxuryRewardPush\022\035.pomelo.area.Lux", "uryRewardPush\032\f.pomelo.Void"};


        Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root) {
                AttendanceHandler.descriptor = root;
                return null;
            }
        };

        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[]{

                Common.getDescriptor(),
                ItemOuterClass.getDescriptor()}, assigner);
    }

    private static final Descriptors.Descriptor internal_static_pomelo_area_GetAttendanceInfoRequest_descriptor = getDescriptor().getMessageTypes().get(0);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetAttendanceInfoRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetAttendanceInfoRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetDailyRewardRequest_descriptor = getDescriptor().getMessageTypes().get(1);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetDailyRewardRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetDailyRewardRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetCumulativeRewardRequest_descriptor = getDescriptor().getMessageTypes().get(2);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetCumulativeRewardRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetCumulativeRewardRequest_descriptor, new String[]{"Id"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetLuxuryRewardRequest_descriptor = getDescriptor().getMessageTypes().get(3);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetLuxuryRewardRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetLuxuryRewardRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetLeftVipRewardRequest_descriptor = getDescriptor().getMessageTypes().get(4);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetLeftVipRewardRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetLeftVipRewardRequest_descriptor, new String[]{"Id"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_DailyInfo_descriptor = getDescriptor().getMessageTypes().get(5);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_DailyInfo_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_DailyInfo_descriptor, new String[]{"Id", "ItemList", "VipDoubleLevel", "State"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_CumulativeInfo_descriptor = getDescriptor().getMessageTypes().get(6);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_CumulativeInfo_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_CumulativeInfo_descriptor, new String[]{"Id", "ItemList", "NeedCountDay", "State", "BoxIcon"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_AttendanceInfo_descriptor = getDescriptor().getMessageTypes().get(7);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_AttendanceInfo_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_AttendanceInfo_descriptor, new String[]{"TodayState", "SignedCount", "DailyList", "CumulativeList"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_LuxuryInfo_descriptor = getDescriptor().getMessageTypes().get(8);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_LuxuryInfo_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_LuxuryInfo_descriptor, new String[]{"ItemList", "State"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetAttendanceInfoResponse_descriptor = getDescriptor().getMessageTypes().get(9);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetAttendanceInfoResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetAttendanceInfoResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CAttendance", "S2CLuxury"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetDailyRewardResponse_descriptor = getDescriptor().getMessageTypes().get(10);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetDailyRewardResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetDailyRewardResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CAttendance"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetCumulativeRewardResponse_descriptor = getDescriptor().getMessageTypes().get(11);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetCumulativeRewardResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetCumulativeRewardResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CAttendance"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetLuxuryRewardResponse_descriptor = getDescriptor().getMessageTypes().get(12);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetLuxuryRewardResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetLuxuryRewardResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CLuxury"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetLeftVipRewardResponse_descriptor = getDescriptor().getMessageTypes().get(13);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetLeftVipRewardResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetLeftVipRewardResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CAttendance"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_LuxuryRewardPush_descriptor = getDescriptor().getMessageTypes().get(14);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_LuxuryRewardPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_LuxuryRewardPush_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CLuxury"});
    private static Descriptors.FileDescriptor descriptor;

    static {
        Common.getDescriptor();
        ItemOuterClass.getDescriptor();
    }

    public static interface LuxuryRewardPushOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasS2CLuxury();

        AttendanceHandler.LuxuryInfo getS2CLuxury();

        AttendanceHandler.LuxuryInfoOrBuilder getS2CLuxuryOrBuilder();
    }

    public static interface GetLeftVipRewardResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasS2CAttendance();

        AttendanceHandler.AttendanceInfo getS2CAttendance();

        AttendanceHandler.AttendanceInfoOrBuilder getS2CAttendanceOrBuilder();
    }

    public static interface GetLuxuryRewardResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasS2CLuxury();

        AttendanceHandler.LuxuryInfo getS2CLuxury();

        AttendanceHandler.LuxuryInfoOrBuilder getS2CLuxuryOrBuilder();
    }

    public static interface GetCumulativeRewardResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasS2CAttendance();

        AttendanceHandler.AttendanceInfo getS2CAttendance();

        AttendanceHandler.AttendanceInfoOrBuilder getS2CAttendanceOrBuilder();
    }

    public static interface GetDailyRewardResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasS2CAttendance();

        AttendanceHandler.AttendanceInfo getS2CAttendance();

        AttendanceHandler.AttendanceInfoOrBuilder getS2CAttendanceOrBuilder();
    }

    public static interface GetAttendanceInfoResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasS2CAttendance();

        AttendanceHandler.AttendanceInfo getS2CAttendance();

        AttendanceHandler.AttendanceInfoOrBuilder getS2CAttendanceOrBuilder();

        boolean hasS2CLuxury();

        AttendanceHandler.LuxuryInfo getS2CLuxury();

        AttendanceHandler.LuxuryInfoOrBuilder getS2CLuxuryOrBuilder();
    }

    public static interface LuxuryInfoOrBuilder extends MessageOrBuilder {
        List<ItemOuterClass.MiniItem> getItemListList();

        ItemOuterClass.MiniItem getItemList(int param1Int);

        int getItemListCount();

        List<? extends ItemOuterClass.MiniItemOrBuilder> getItemListOrBuilderList();

        ItemOuterClass.MiniItemOrBuilder getItemListOrBuilder(int param1Int);

        boolean hasState();

        int getState();
    }

    public static interface AttendanceInfoOrBuilder extends MessageOrBuilder {
        boolean hasTodayState();

        int getTodayState();

        boolean hasSignedCount();

        int getSignedCount();

        List<AttendanceHandler.DailyInfo> getDailyListList();

        AttendanceHandler.DailyInfo getDailyList(int param1Int);

        int getDailyListCount();

        List<? extends AttendanceHandler.DailyInfoOrBuilder> getDailyListOrBuilderList();

        AttendanceHandler.DailyInfoOrBuilder getDailyListOrBuilder(int param1Int);

        List<AttendanceHandler.CumulativeInfo> getCumulativeListList();

        AttendanceHandler.CumulativeInfo getCumulativeList(int param1Int);

        int getCumulativeListCount();

        List<? extends AttendanceHandler.CumulativeInfoOrBuilder> getCumulativeListOrBuilderList();

        AttendanceHandler.CumulativeInfoOrBuilder getCumulativeListOrBuilder(int param1Int);
    }

    public static interface CumulativeInfoOrBuilder extends MessageOrBuilder {
        boolean hasId();

        int getId();

        List<ItemOuterClass.MiniItem> getItemListList();

        ItemOuterClass.MiniItem getItemList(int param1Int);

        int getItemListCount();

        List<? extends ItemOuterClass.MiniItemOrBuilder> getItemListOrBuilderList();

        ItemOuterClass.MiniItemOrBuilder getItemListOrBuilder(int param1Int);

        boolean hasNeedCountDay();

        int getNeedCountDay();

        boolean hasState();

        int getState();

        boolean hasBoxIcon();

        String getBoxIcon();

        ByteString getBoxIconBytes();
    }

    public static interface DailyInfoOrBuilder extends MessageOrBuilder {
        boolean hasId();

        int getId();

        boolean hasItemList();

        ItemOuterClass.MiniItem getItemList();

        ItemOuterClass.MiniItemOrBuilder getItemListOrBuilder();

        boolean hasVipDoubleLevel();

        int getVipDoubleLevel();

        boolean hasState();

        int getState();
    }

    public static interface GetLeftVipRewardRequestOrBuilder extends MessageOrBuilder {
        boolean hasId();

        int getId();
    }

    public static interface GetLuxuryRewardRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface GetCumulativeRewardRequestOrBuilder extends MessageOrBuilder {
        boolean hasId();

        int getId();
    }

    public static interface GetDailyRewardRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface GetAttendanceInfoRequestOrBuilder extends MessageOrBuilder {
    }
}


