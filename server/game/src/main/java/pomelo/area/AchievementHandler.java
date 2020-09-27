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
import pomelo.item.ItemOuterClass;


public final class AchievementHandler {
    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static final class AchievementGetTypeElementRequest
            extends GeneratedMessage
            implements AchievementGetTypeElementRequestOrBuilder {
        private static final AchievementGetTypeElementRequest defaultInstance = new AchievementGetTypeElementRequest(true);
        private final UnknownFieldSet unknownFields;

        private AchievementGetTypeElementRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private AchievementGetTypeElementRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static AchievementGetTypeElementRequest getDefaultInstance() {
            return defaultInstance;
        }

        public AchievementGetTypeElementRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AchievementGetTypeElementRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.c2SId_ = input.readInt32();
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
            return AchievementHandler.internal_static_pomelo_area_AchievementGetTypeElementRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return AchievementHandler.internal_static_pomelo_area_AchievementGetTypeElementRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(AchievementGetTypeElementRequest.class, Builder.class);
        }

        public static Parser<AchievementGetTypeElementRequest> PARSER = (Parser<AchievementGetTypeElementRequest>) new AbstractParser<AchievementGetTypeElementRequest>() {
            public AchievementHandler.AchievementGetTypeElementRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AchievementHandler.AchievementGetTypeElementRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_ID_FIELD_NUMBER = 1;
        private int c2SId_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<AchievementGetTypeElementRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasC2SId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getC2SId() {
            return this.c2SId_;
        }

        private void initFields() {
            this.c2SId_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasC2SId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.c2SId_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.c2SId_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static AchievementGetTypeElementRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (AchievementGetTypeElementRequest) PARSER.parseFrom(data);
        }

        public static AchievementGetTypeElementRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AchievementGetTypeElementRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static AchievementGetTypeElementRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (AchievementGetTypeElementRequest) PARSER.parseFrom(data);
        }

        public static AchievementGetTypeElementRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AchievementGetTypeElementRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static AchievementGetTypeElementRequest parseFrom(InputStream input) throws IOException {
            return (AchievementGetTypeElementRequest) PARSER.parseFrom(input);
        }

        public static AchievementGetTypeElementRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AchievementGetTypeElementRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static AchievementGetTypeElementRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (AchievementGetTypeElementRequest) PARSER.parseDelimitedFrom(input);
        }

        public static AchievementGetTypeElementRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AchievementGetTypeElementRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static AchievementGetTypeElementRequest parseFrom(CodedInputStream input) throws IOException {
            return (AchievementGetTypeElementRequest) PARSER.parseFrom(input);
        }

        public static AchievementGetTypeElementRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AchievementGetTypeElementRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(AchievementGetTypeElementRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements AchievementHandler.AchievementGetTypeElementRequestOrBuilder {
            private int bitField0_;
            private int c2SId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AchievementHandler.internal_static_pomelo_area_AchievementGetTypeElementRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return AchievementHandler.internal_static_pomelo_area_AchievementGetTypeElementRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(AchievementHandler.AchievementGetTypeElementRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AchievementHandler.AchievementGetTypeElementRequest.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.c2SId_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return AchievementHandler.internal_static_pomelo_area_AchievementGetTypeElementRequest_descriptor;
            }

            public AchievementHandler.AchievementGetTypeElementRequest getDefaultInstanceForType() {
                return AchievementHandler.AchievementGetTypeElementRequest.getDefaultInstance();
            }

            public AchievementHandler.AchievementGetTypeElementRequest build() {
                AchievementHandler.AchievementGetTypeElementRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public AchievementHandler.AchievementGetTypeElementRequest buildPartial() {
                AchievementHandler.AchievementGetTypeElementRequest result = new AchievementHandler.AchievementGetTypeElementRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.c2SId_ = this.c2SId_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof AchievementHandler.AchievementGetTypeElementRequest)
                    return mergeFrom((AchievementHandler.AchievementGetTypeElementRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AchievementHandler.AchievementGetTypeElementRequest other) {
                if (other == AchievementHandler.AchievementGetTypeElementRequest.getDefaultInstance()) return this;
                if (other.hasC2SId()) setC2SId(other.getC2SId());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasC2SId()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                AchievementHandler.AchievementGetTypeElementRequest parsedMessage = null;
                try {
                    parsedMessage = (AchievementHandler.AchievementGetTypeElementRequest) AchievementHandler.AchievementGetTypeElementRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (AchievementHandler.AchievementGetTypeElementRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasC2SId() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getC2SId() {
                return this.c2SId_;
            }

            public Builder setC2SId(int value) {
                this.bitField0_ |= 0x1;
                this.c2SId_ = value;
                onChanged();
                return this;
            }

            public Builder clearC2SId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SId_ = 0;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class AchievementGetAwardRequest
            extends GeneratedMessage
            implements AchievementGetAwardRequestOrBuilder {
        private static final AchievementGetAwardRequest defaultInstance = new AchievementGetAwardRequest(true);
        private final UnknownFieldSet unknownFields;

        private AchievementGetAwardRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private AchievementGetAwardRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static AchievementGetAwardRequest getDefaultInstance() {
            return defaultInstance;
        }

        public AchievementGetAwardRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AchievementGetAwardRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.c2SId_ = input.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
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
            return AchievementHandler.internal_static_pomelo_area_AchievementGetAwardRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return AchievementHandler.internal_static_pomelo_area_AchievementGetAwardRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(AchievementGetAwardRequest.class, Builder.class);
        }

        public static Parser<AchievementGetAwardRequest> PARSER = (Parser<AchievementGetAwardRequest>) new AbstractParser<AchievementGetAwardRequest>() {
            public AchievementHandler.AchievementGetAwardRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AchievementHandler.AchievementGetAwardRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_ID_FIELD_NUMBER = 1;
        private int c2SId_;
        public static final int C2S_TYPE_FIELD_NUMBER = 2;
        private int c2SType_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<AchievementGetAwardRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasC2SId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getC2SId() {
            return this.c2SId_;
        }

        public boolean hasC2SType() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public int getC2SType() {
            return this.c2SType_;
        }

        private void initFields() {
            this.c2SId_ = 0;
            this.c2SType_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasC2SId()) {
                this.memoizedIsInitialized = 0;
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
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.c2SId_);
            if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.c2SType_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.c2SId_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(2, this.c2SType_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static AchievementGetAwardRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (AchievementGetAwardRequest) PARSER.parseFrom(data);
        }

        public static AchievementGetAwardRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AchievementGetAwardRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static AchievementGetAwardRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (AchievementGetAwardRequest) PARSER.parseFrom(data);
        }

        public static AchievementGetAwardRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AchievementGetAwardRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static AchievementGetAwardRequest parseFrom(InputStream input) throws IOException {
            return (AchievementGetAwardRequest) PARSER.parseFrom(input);
        }

        public static AchievementGetAwardRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AchievementGetAwardRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static AchievementGetAwardRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (AchievementGetAwardRequest) PARSER.parseDelimitedFrom(input);
        }

        public static AchievementGetAwardRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AchievementGetAwardRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static AchievementGetAwardRequest parseFrom(CodedInputStream input) throws IOException {
            return (AchievementGetAwardRequest) PARSER.parseFrom(input);
        }

        public static AchievementGetAwardRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AchievementGetAwardRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(AchievementGetAwardRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements AchievementHandler.AchievementGetAwardRequestOrBuilder {
            private int bitField0_;
            private int c2SId_;
            private int c2SType_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AchievementHandler.internal_static_pomelo_area_AchievementGetAwardRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return AchievementHandler.internal_static_pomelo_area_AchievementGetAwardRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(AchievementHandler.AchievementGetAwardRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AchievementHandler.AchievementGetAwardRequest.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.c2SId_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SType_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return AchievementHandler.internal_static_pomelo_area_AchievementGetAwardRequest_descriptor;
            }

            public AchievementHandler.AchievementGetAwardRequest getDefaultInstanceForType() {
                return AchievementHandler.AchievementGetAwardRequest.getDefaultInstance();
            }

            public AchievementHandler.AchievementGetAwardRequest build() {
                AchievementHandler.AchievementGetAwardRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public AchievementHandler.AchievementGetAwardRequest buildPartial() {
                AchievementHandler.AchievementGetAwardRequest result = new AchievementHandler.AchievementGetAwardRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.c2SId_ = this.c2SId_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.c2SType_ = this.c2SType_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof AchievementHandler.AchievementGetAwardRequest)
                    return mergeFrom((AchievementHandler.AchievementGetAwardRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AchievementHandler.AchievementGetAwardRequest other) {
                if (other == AchievementHandler.AchievementGetAwardRequest.getDefaultInstance()) return this;
                if (other.hasC2SId()) setC2SId(other.getC2SId());
                if (other.hasC2SType()) setC2SType(other.getC2SType());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasC2SId()) return false;
                if (!hasC2SType()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                AchievementHandler.AchievementGetAwardRequest parsedMessage = null;
                try {
                    parsedMessage = (AchievementHandler.AchievementGetAwardRequest) AchievementHandler.AchievementGetAwardRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (AchievementHandler.AchievementGetAwardRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasC2SId() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getC2SId() {
                return this.c2SId_;
            }

            public Builder setC2SId(int value) {
                this.bitField0_ |= 0x1;
                this.c2SId_ = value;
                onChanged();
                return this;
            }

            public Builder clearC2SId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SId_ = 0;
                onChanged();
                return this;
            }

            public boolean hasC2SType() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getC2SType() {
                return this.c2SType_;
            }

            public Builder setC2SType(int value) {
                this.bitField0_ |= 0x2;
                this.c2SType_ = value;
                onChanged();
                return this;
            }

            public Builder clearC2SType() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.c2SType_ = 0;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class Achievement
            extends GeneratedMessage
            implements AchievementOrBuilder {
        private final UnknownFieldSet unknownFields;


        private Achievement(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }


        private Achievement(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }


        public static Achievement getDefaultInstance() {
            return defaultInstance;
        }


        public Achievement getDefaultInstanceForType() {
            return defaultInstance;
        }


        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }


        private Achievement(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.scheduleCurr_ = input.readInt32();
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.status_ = input.readInt32();
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
            return AchievementHandler.internal_static_pomelo_area_Achievement_descriptor;
        }


        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return AchievementHandler.internal_static_pomelo_area_Achievement_fieldAccessorTable.ensureFieldAccessorsInitialized(Achievement.class, Builder.class);
        }


        public static Parser<Achievement> PARSER = (Parser<Achievement>) new AbstractParser<Achievement>() {
            public AchievementHandler.Achievement parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AchievementHandler.Achievement(input, extensionRegistry);
            }
        };


        private int bitField0_;


        public static final int ID_FIELD_NUMBER = 1;


        private int id_;


        public static final int SCHEDULECURR_FIELD_NUMBER = 2;


        private int scheduleCurr_;


        public static final int STATUS_FIELD_NUMBER = 3;


        private int status_;


        private byte memoizedIsInitialized;


        private int memoizedSerializedSize;


        private static final long serialVersionUID = 0L;


        public Parser<Achievement> getParserForType() {
            return PARSER;
        }


        public boolean hasId() {
            return ((this.bitField0_ & 0x1) == 1);
        }


        public int getId() {
            return this.id_;
        }


        public boolean hasScheduleCurr() {
            return ((this.bitField0_ & 0x2) == 2);
        }


        private static final Achievement defaultInstance = new Achievement(true);

        public int getScheduleCurr() {
            return this.scheduleCurr_;
        }

        public boolean hasStatus() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getStatus() {
            return this.status_;
        }

        private void initFields() {
            this.id_ = 0;
            this.scheduleCurr_ = 0;
            this.status_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasScheduleCurr()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasStatus()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.id_);
            if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.scheduleCurr_);
            if ((this.bitField0_ & 0x4) == 4) output.writeInt32(3, this.status_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.id_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(2, this.scheduleCurr_);
            if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeInt32Size(3, this.status_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static Achievement parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Achievement) PARSER.parseFrom(data);
        }

        public static Achievement parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Achievement) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Achievement parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Achievement) PARSER.parseFrom(data);
        }

        public static Achievement parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Achievement) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Achievement parseFrom(InputStream input) throws IOException {
            return (Achievement) PARSER.parseFrom(input);
        }

        public static Achievement parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Achievement) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Achievement parseDelimitedFrom(InputStream input) throws IOException {
            return (Achievement) PARSER.parseDelimitedFrom(input);
        }

        public static Achievement parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Achievement) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Achievement parseFrom(CodedInputStream input) throws IOException {
            return (Achievement) PARSER.parseFrom(input);
        }

        public static Achievement parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Achievement) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Achievement prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements AchievementHandler.AchievementOrBuilder {
            private int bitField0_;
            private int id_;
            private int scheduleCurr_;
            private int status_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AchievementHandler.internal_static_pomelo_area_Achievement_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return AchievementHandler.internal_static_pomelo_area_Achievement_fieldAccessorTable.ensureFieldAccessorsInitialized(AchievementHandler.Achievement.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AchievementHandler.Achievement.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.id_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.scheduleCurr_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                this.status_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return AchievementHandler.internal_static_pomelo_area_Achievement_descriptor;
            }

            public AchievementHandler.Achievement getDefaultInstanceForType() {
                return AchievementHandler.Achievement.getDefaultInstance();
            }

            public AchievementHandler.Achievement build() {
                AchievementHandler.Achievement result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public AchievementHandler.Achievement buildPartial() {
                AchievementHandler.Achievement result = new AchievementHandler.Achievement(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.id_ = this.id_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.scheduleCurr_ = this.scheduleCurr_;
                if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;
                result.status_ = this.status_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof AchievementHandler.Achievement)
                    return mergeFrom((AchievementHandler.Achievement) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AchievementHandler.Achievement other) {
                if (other == AchievementHandler.Achievement.getDefaultInstance()) return this;
                if (other.hasId()) setId(other.getId());
                if (other.hasScheduleCurr()) setScheduleCurr(other.getScheduleCurr());
                if (other.hasStatus()) setStatus(other.getStatus());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasId()) return false;
                if (!hasScheduleCurr()) return false;
                if (!hasStatus()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                AchievementHandler.Achievement parsedMessage = null;
                try {
                    parsedMessage = (AchievementHandler.Achievement) AchievementHandler.Achievement.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (AchievementHandler.Achievement) e.getUnfinishedMessage();
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

            public boolean hasScheduleCurr() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getScheduleCurr() {
                return this.scheduleCurr_;
            }

            public Builder setScheduleCurr(int value) {
                this.bitField0_ |= 0x2;
                this.scheduleCurr_ = value;
                onChanged();
                return this;
            }

            public Builder clearScheduleCurr() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.scheduleCurr_ = 0;
                onChanged();
                return this;
            }

            public boolean hasStatus() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public int getStatus() {
                return this.status_;
            }

            public Builder setStatus(int value) {
                this.bitField0_ |= 0x4;
                this.status_ = value;
                onChanged();
                return this;
            }

            public Builder clearStatus() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.status_ = 0;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class AchievementGetTypeElementResponse
            extends GeneratedMessage
            implements AchievementGetTypeElementResponseOrBuilder {
        private static final AchievementGetTypeElementResponse defaultInstance = new AchievementGetTypeElementResponse(true);
        private final UnknownFieldSet unknownFields;

        private AchievementGetTypeElementResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private AchievementGetTypeElementResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static AchievementGetTypeElementResponse getDefaultInstance() {
            return defaultInstance;
        }

        public AchievementGetTypeElementResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AchievementGetTypeElementResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString bs;
                    int length, limit, tag = input.readTag();
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
                                this.s2CAchievements_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x4;
                            }
                            this.s2CAchievements_.add(input.readMessage(AchievementHandler.Achievement.PARSER, extensionRegistry));
                            break;
                        case 32:
                            this.bitField0_ |= 0x4;
                            this.s2CRewardCount_ = input.readInt32();
                            break;
                        case 40:
                            this.bitField0_ |= 0x8;
                            this.s2CRewardStatus_ = input.readInt32();
                            break;
                        case 48:
                            if ((mutable_bitField0_ & 0x20) != 32) {
                                this.s2COpenedChapter_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x20;
                            }
                            this.s2COpenedChapter_.add(Integer.valueOf(input.readInt32()));
                            break;
                        case 50:
                            length = input.readRawVarint32();
                            limit = input.pushLimit(length);
                            if ((mutable_bitField0_ & 0x20) != 32 && input.getBytesUntilLimit() > 0) {
                                this.s2COpenedChapter_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x20;
                            }
                            while (input.getBytesUntilLimit() > 0)
                                this.s2COpenedChapter_.add(Integer.valueOf(input.readInt32()));
                            input.popLimit(limit);
                            break;
                        case 58:
                            if ((mutable_bitField0_ & 0x40) != 64) {
                                this.s2CChestView_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x40;
                            }
                            this.s2CChestView_.add(input.readMessage(ItemOuterClass.MiniItem.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x4) == 4)
                    this.s2CAchievements_ = Collections.unmodifiableList(this.s2CAchievements_);
                if ((mutable_bitField0_ & 0x20) == 32)
                    this.s2COpenedChapter_ = Collections.unmodifiableList(this.s2COpenedChapter_);
                if ((mutable_bitField0_ & 0x40) == 64)
                    this.s2CChestView_ = Collections.unmodifiableList(this.s2CChestView_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AchievementHandler.internal_static_pomelo_area_AchievementGetTypeElementResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return AchievementHandler.internal_static_pomelo_area_AchievementGetTypeElementResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(AchievementGetTypeElementResponse.class, Builder.class);
        }

        public static Parser<AchievementGetTypeElementResponse> PARSER = (Parser<AchievementGetTypeElementResponse>) new AbstractParser<AchievementGetTypeElementResponse>() {
            public AchievementHandler.AchievementGetTypeElementResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AchievementHandler.AchievementGetTypeElementResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_ACHIEVEMENTS_FIELD_NUMBER = 3;
        private List<AchievementHandler.Achievement> s2CAchievements_;
        public static final int S2C_REWARDCOUNT_FIELD_NUMBER = 4;
        private int s2CRewardCount_;
        public static final int S2C_REWARD_STATUS_FIELD_NUMBER = 5;
        private int s2CRewardStatus_;
        public static final int S2C_OPENED_CHAPTER_FIELD_NUMBER = 6;
        private List<Integer> s2COpenedChapter_;
        public static final int S2C_CHEST_VIEW_FIELD_NUMBER = 7;
        private List<ItemOuterClass.MiniItem> s2CChestView_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<AchievementGetTypeElementResponse> getParserForType() {
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

        public List<AchievementHandler.Achievement> getS2CAchievementsList() {
            return this.s2CAchievements_;
        }

        public List<? extends AchievementHandler.AchievementOrBuilder> getS2CAchievementsOrBuilderList() {
            return (List) this.s2CAchievements_;
        }

        public int getS2CAchievementsCount() {
            return this.s2CAchievements_.size();
        }

        public AchievementHandler.Achievement getS2CAchievements(int index) {
            return this.s2CAchievements_.get(index);
        }

        public AchievementHandler.AchievementOrBuilder getS2CAchievementsOrBuilder(int index) {
            return this.s2CAchievements_.get(index);
        }

        public boolean hasS2CRewardCount() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getS2CRewardCount() {
            return this.s2CRewardCount_;
        }

        public boolean hasS2CRewardStatus() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public int getS2CRewardStatus() {
            return this.s2CRewardStatus_;
        }

        public List<Integer> getS2COpenedChapterList() {
            return this.s2COpenedChapter_;
        }

        public int getS2COpenedChapterCount() {
            return this.s2COpenedChapter_.size();
        }

        public int getS2COpenedChapter(int index) {
            return ((Integer) this.s2COpenedChapter_.get(index)).intValue();
        }

        public List<ItemOuterClass.MiniItem> getS2CChestViewList() {
            return this.s2CChestView_;
        }

        public List<? extends ItemOuterClass.MiniItemOrBuilder> getS2CChestViewOrBuilderList() {
            return (List) this.s2CChestView_;
        }

        public int getS2CChestViewCount() {
            return this.s2CChestView_.size();
        }

        public ItemOuterClass.MiniItem getS2CChestView(int index) {
            return this.s2CChestView_.get(index);
        }

        public ItemOuterClass.MiniItemOrBuilder getS2CChestViewOrBuilder(int index) {
            return (ItemOuterClass.MiniItemOrBuilder) this.s2CChestView_.get(index);
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CAchievements_ = Collections.emptyList();
            this.s2CRewardCount_ = 0;
            this.s2CRewardStatus_ = 0;
            this.s2COpenedChapter_ = Collections.emptyList();
            this.s2CChestView_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasS2CCode()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            int i;
            for (i = 0; i < getS2CAchievementsCount(); i++) {
                if (!getS2CAchievements(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (i = 0; i < getS2CChestViewCount(); i++) {
                if (!getS2CChestView(i).isInitialized()) {
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
            int i;
            for (i = 0; i < this.s2CAchievements_.size(); i++)
                output.writeMessage(3, (MessageLite) this.s2CAchievements_.get(i));
            if ((this.bitField0_ & 0x4) == 4) output.writeInt32(4, this.s2CRewardCount_);
            if ((this.bitField0_ & 0x8) == 8) output.writeInt32(5, this.s2CRewardStatus_);
            for (i = 0; i < this.s2COpenedChapter_.size(); i++)
                output.writeInt32(6, ((Integer) this.s2COpenedChapter_.get(i)).intValue());
            for (i = 0; i < this.s2CChestView_.size(); i++)
                output.writeMessage(7, (MessageLite) this.s2CChestView_.get(i));
            getUnknownFields().writeTo(output);
        }

        static {
            defaultInstance.initFields();
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
            for (int j = 0; j < this.s2CAchievements_.size(); j++)
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.s2CAchievements_.get(j));
            if ((this.bitField0_ & 0x4) == 4)
                size += CodedOutputStream.computeInt32Size(4, this.s2CRewardCount_);
            if ((this.bitField0_ & 0x8) == 8)
                size += CodedOutputStream.computeInt32Size(5, this.s2CRewardStatus_);
            int dataSize = 0;
            for (int k = 0; k < this.s2COpenedChapter_.size(); k++)
                dataSize += CodedOutputStream.computeInt32SizeNoTag(((Integer) this.s2COpenedChapter_.get(k)).intValue());
            size += dataSize;
            size += 1 * getS2COpenedChapterList().size();
            for (int i = 0; i < this.s2CChestView_.size(); i++)
                size += CodedOutputStream.computeMessageSize(7, (MessageLite) this.s2CChestView_.get(i));
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static AchievementGetTypeElementResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (AchievementGetTypeElementResponse) PARSER.parseFrom(data);
        }

        public static AchievementGetTypeElementResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AchievementGetTypeElementResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static AchievementGetTypeElementResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (AchievementGetTypeElementResponse) PARSER.parseFrom(data);
        }

        public static AchievementGetTypeElementResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AchievementGetTypeElementResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static AchievementGetTypeElementResponse parseFrom(InputStream input) throws IOException {
            return (AchievementGetTypeElementResponse) PARSER.parseFrom(input);
        }

        public static AchievementGetTypeElementResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AchievementGetTypeElementResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static AchievementGetTypeElementResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (AchievementGetTypeElementResponse) PARSER.parseDelimitedFrom(input);
        }

        public static AchievementGetTypeElementResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AchievementGetTypeElementResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static AchievementGetTypeElementResponse parseFrom(CodedInputStream input) throws IOException {
            return (AchievementGetTypeElementResponse) PARSER.parseFrom(input);
        }

        public static AchievementGetTypeElementResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AchievementGetTypeElementResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(AchievementGetTypeElementResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements AchievementHandler.AchievementGetTypeElementResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private List<AchievementHandler.Achievement> s2CAchievements_;
            private RepeatedFieldBuilder<AchievementHandler.Achievement, AchievementHandler.Achievement.Builder, AchievementHandler.AchievementOrBuilder> s2CAchievementsBuilder_;
            private int s2CRewardCount_;
            private int s2CRewardStatus_;
            private List<Integer> s2COpenedChapter_;
            private List<ItemOuterClass.MiniItem> s2CChestView_;
            private RepeatedFieldBuilder<ItemOuterClass.MiniItem, ItemOuterClass.MiniItem.Builder, ItemOuterClass.MiniItemOrBuilder> s2CChestViewBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AchievementHandler.internal_static_pomelo_area_AchievementGetTypeElementResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return AchievementHandler.internal_static_pomelo_area_AchievementGetTypeElementResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(AchievementHandler.AchievementGetTypeElementResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.s2CAchievements_ = Collections.emptyList();
                this.s2COpenedChapter_ = Collections.emptyList();
                this.s2CChestView_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CAchievements_ = Collections.emptyList();
                this.s2COpenedChapter_ = Collections.emptyList();
                this.s2CChestView_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AchievementHandler.AchievementGetTypeElementResponse.alwaysUseFieldBuilders) {
                    getS2CAchievementsFieldBuilder();
                    getS2CChestViewFieldBuilder();
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
                if (this.s2CAchievementsBuilder_ == null) {
                    this.s2CAchievements_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                } else {
                    this.s2CAchievementsBuilder_.clear();
                }
                this.s2CRewardCount_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                this.s2CRewardStatus_ = 0;
                this.bitField0_ &= 0xFFFFFFEF;
                this.s2COpenedChapter_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFDF;
                if (this.s2CChestViewBuilder_ == null) {
                    this.s2CChestView_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFBF;
                } else {
                    this.s2CChestViewBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return AchievementHandler.internal_static_pomelo_area_AchievementGetTypeElementResponse_descriptor;
            }

            public AchievementHandler.AchievementGetTypeElementResponse getDefaultInstanceForType() {
                return AchievementHandler.AchievementGetTypeElementResponse.getDefaultInstance();
            }

            public AchievementHandler.AchievementGetTypeElementResponse build() {
                AchievementHandler.AchievementGetTypeElementResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public AchievementHandler.AchievementGetTypeElementResponse buildPartial() {
                AchievementHandler.AchievementGetTypeElementResponse result = new AchievementHandler.AchievementGetTypeElementResponse(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.s2CMsg_ = this.s2CMsg_;
                if (this.s2CAchievementsBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4) {
                        this.s2CAchievements_ = Collections.unmodifiableList(this.s2CAchievements_);
                        this.bitField0_ &= 0xFFFFFFFB;
                    }
                    result.s2CAchievements_ = this.s2CAchievements_;
                } else {
                    result.s2CAchievements_ = this.s2CAchievementsBuilder_.build();
                }
                if ((from_bitField0_ & 0x8) == 8)
                    to_bitField0_ |= 0x4;
                result.s2CRewardCount_ = this.s2CRewardCount_;
                if ((from_bitField0_ & 0x10) == 16)
                    to_bitField0_ |= 0x8;
                result.s2CRewardStatus_ = this.s2CRewardStatus_;
                if ((this.bitField0_ & 0x20) == 32) {
                    this.s2COpenedChapter_ = Collections.unmodifiableList(this.s2COpenedChapter_);
                    this.bitField0_ &= 0xFFFFFFDF;
                }
                result.s2COpenedChapter_ = this.s2COpenedChapter_;
                if (this.s2CChestViewBuilder_ == null) {
                    if ((this.bitField0_ & 0x40) == 64) {
                        this.s2CChestView_ = Collections.unmodifiableList(this.s2CChestView_);
                        this.bitField0_ &= 0xFFFFFFBF;
                    }
                    result.s2CChestView_ = this.s2CChestView_;
                } else {
                    result.s2CChestView_ = this.s2CChestViewBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof AchievementHandler.AchievementGetTypeElementResponse)
                    return mergeFrom((AchievementHandler.AchievementGetTypeElementResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AchievementHandler.AchievementGetTypeElementResponse other) {
                if (other == AchievementHandler.AchievementGetTypeElementResponse.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (this.s2CAchievementsBuilder_ == null) {
                    if (!other.s2CAchievements_.isEmpty()) {
                        if (this.s2CAchievements_.isEmpty()) {
                            this.s2CAchievements_ = other.s2CAchievements_;
                            this.bitField0_ &= 0xFFFFFFFB;
                        } else {
                            ensureS2CAchievementsIsMutable();
                            this.s2CAchievements_.addAll(other.s2CAchievements_);
                        }
                        onChanged();
                    }
                } else if (!other.s2CAchievements_.isEmpty()) {
                    if (this.s2CAchievementsBuilder_.isEmpty()) {
                        this.s2CAchievementsBuilder_.dispose();
                        this.s2CAchievementsBuilder_ = null;
                        this.s2CAchievements_ = other.s2CAchievements_;
                        this.bitField0_ &= 0xFFFFFFFB;
                        this.s2CAchievementsBuilder_ = AchievementHandler.AchievementGetTypeElementResponse.alwaysUseFieldBuilders ? getS2CAchievementsFieldBuilder() : null;
                    } else {
                        this.s2CAchievementsBuilder_.addAllMessages(other.s2CAchievements_);
                    }
                }
                if (other.hasS2CRewardCount())
                    setS2CRewardCount(other.getS2CRewardCount());
                if (other.hasS2CRewardStatus())
                    setS2CRewardStatus(other.getS2CRewardStatus());
                if (!other.s2COpenedChapter_.isEmpty()) {
                    if (this.s2COpenedChapter_.isEmpty()) {
                        this.s2COpenedChapter_ = other.s2COpenedChapter_;
                        this.bitField0_ &= 0xFFFFFFDF;
                    } else {
                        ensureS2COpenedChapterIsMutable();
                        this.s2COpenedChapter_.addAll(other.s2COpenedChapter_);
                    }
                    onChanged();
                }
                if (this.s2CChestViewBuilder_ == null) {
                    if (!other.s2CChestView_.isEmpty()) {
                        if (this.s2CChestView_.isEmpty()) {
                            this.s2CChestView_ = other.s2CChestView_;
                            this.bitField0_ &= 0xFFFFFFBF;
                        } else {
                            ensureS2CChestViewIsMutable();
                            this.s2CChestView_.addAll(other.s2CChestView_);
                        }
                        onChanged();
                    }
                } else if (!other.s2CChestView_.isEmpty()) {
                    if (this.s2CChestViewBuilder_.isEmpty()) {
                        this.s2CChestViewBuilder_.dispose();
                        this.s2CChestViewBuilder_ = null;
                        this.s2CChestView_ = other.s2CChestView_;
                        this.bitField0_ &= 0xFFFFFFBF;
                        this.s2CChestViewBuilder_ = AchievementHandler.AchievementGetTypeElementResponse.alwaysUseFieldBuilders ? getS2CChestViewFieldBuilder() : null;
                    } else {
                        this.s2CChestViewBuilder_.addAllMessages(other.s2CChestView_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode())
                    return false;
                int i;
                for (i = 0; i < getS2CAchievementsCount(); i++) {
                    if (!getS2CAchievements(i).isInitialized())
                        return false;
                }
                for (i = 0; i < getS2CChestViewCount(); i++) {
                    if (!getS2CChestView(i).isInitialized())
                        return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                AchievementHandler.AchievementGetTypeElementResponse parsedMessage = null;
                try {
                    parsedMessage = (AchievementHandler.AchievementGetTypeElementResponse) AchievementHandler.AchievementGetTypeElementResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (AchievementHandler.AchievementGetTypeElementResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = AchievementHandler.AchievementGetTypeElementResponse.getDefaultInstance().getS2CMsg();
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

            private void ensureS2CAchievementsIsMutable() {
                if ((this.bitField0_ & 0x4) != 4) {
                    this.s2CAchievements_ = new ArrayList<>(this.s2CAchievements_);
                    this.bitField0_ |= 0x4;
                }
            }

            public List<AchievementHandler.Achievement> getS2CAchievementsList() {
                if (this.s2CAchievementsBuilder_ == null)
                    return Collections.unmodifiableList(this.s2CAchievements_);
                return this.s2CAchievementsBuilder_.getMessageList();
            }

            public int getS2CAchievementsCount() {
                if (this.s2CAchievementsBuilder_ == null)
                    return this.s2CAchievements_.size();
                return this.s2CAchievementsBuilder_.getCount();
            }

            public AchievementHandler.Achievement getS2CAchievements(int index) {
                if (this.s2CAchievementsBuilder_ == null)
                    return this.s2CAchievements_.get(index);
                return (AchievementHandler.Achievement) this.s2CAchievementsBuilder_.getMessage(index);
            }

            public Builder setS2CAchievements(int index, AchievementHandler.Achievement value) {
                if (this.s2CAchievementsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CAchievementsIsMutable();
                    this.s2CAchievements_.set(index, value);
                    onChanged();
                } else {
                    this.s2CAchievementsBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setS2CAchievements(int index, AchievementHandler.Achievement.Builder builderForValue) {
                if (this.s2CAchievementsBuilder_ == null) {
                    ensureS2CAchievementsIsMutable();
                    this.s2CAchievements_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CAchievementsBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addS2CAchievements(AchievementHandler.Achievement value) {
                if (this.s2CAchievementsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CAchievementsIsMutable();
                    this.s2CAchievements_.add(value);
                    onChanged();
                } else {
                    this.s2CAchievementsBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addS2CAchievements(int index, AchievementHandler.Achievement value) {
                if (this.s2CAchievementsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CAchievementsIsMutable();
                    this.s2CAchievements_.add(index, value);
                    onChanged();
                } else {
                    this.s2CAchievementsBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addS2CAchievements(AchievementHandler.Achievement.Builder builderForValue) {
                if (this.s2CAchievementsBuilder_ == null) {
                    ensureS2CAchievementsIsMutable();
                    this.s2CAchievements_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.s2CAchievementsBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addS2CAchievements(int index, AchievementHandler.Achievement.Builder builderForValue) {
                if (this.s2CAchievementsBuilder_ == null) {
                    ensureS2CAchievementsIsMutable();
                    this.s2CAchievements_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CAchievementsBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllS2CAchievements(Iterable<? extends AchievementHandler.Achievement> values) {
                if (this.s2CAchievementsBuilder_ == null) {
                    ensureS2CAchievementsIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.s2CAchievements_);
                    onChanged();
                } else {
                    this.s2CAchievementsBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearS2CAchievements() {
                if (this.s2CAchievementsBuilder_ == null) {
                    this.s2CAchievements_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                    onChanged();
                } else {
                    this.s2CAchievementsBuilder_.clear();
                }
                return this;
            }

            public Builder removeS2CAchievements(int index) {
                if (this.s2CAchievementsBuilder_ == null) {
                    ensureS2CAchievementsIsMutable();
                    this.s2CAchievements_.remove(index);
                    onChanged();
                } else {
                    this.s2CAchievementsBuilder_.remove(index);
                }
                return this;
            }

            public AchievementHandler.Achievement.Builder getS2CAchievementsBuilder(int index) {
                return (AchievementHandler.Achievement.Builder) getS2CAchievementsFieldBuilder().getBuilder(index);
            }

            public AchievementHandler.AchievementOrBuilder getS2CAchievementsOrBuilder(int index) {
                if (this.s2CAchievementsBuilder_ == null)
                    return this.s2CAchievements_.get(index);
                return (AchievementHandler.AchievementOrBuilder) this.s2CAchievementsBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends AchievementHandler.AchievementOrBuilder> getS2CAchievementsOrBuilderList() {
                if (this.s2CAchievementsBuilder_ != null)
                    return this.s2CAchievementsBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.s2CAchievements_);
            }

            public AchievementHandler.Achievement.Builder addS2CAchievementsBuilder() {
                return (AchievementHandler.Achievement.Builder) getS2CAchievementsFieldBuilder().addBuilder(AchievementHandler.Achievement.getDefaultInstance());
            }

            public AchievementHandler.Achievement.Builder addS2CAchievementsBuilder(int index) {
                return (AchievementHandler.Achievement.Builder) getS2CAchievementsFieldBuilder().addBuilder(index, AchievementHandler.Achievement.getDefaultInstance());
            }

            public List<AchievementHandler.Achievement.Builder> getS2CAchievementsBuilderList() {
                return getS2CAchievementsFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<AchievementHandler.Achievement, AchievementHandler.Achievement.Builder, AchievementHandler.AchievementOrBuilder> getS2CAchievementsFieldBuilder() {
                if (this.s2CAchievementsBuilder_ == null) {
                    this.s2CAchievementsBuilder_ = new RepeatedFieldBuilder(this.s2CAchievements_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
                    this.s2CAchievements_ = null;
                }
                return this.s2CAchievementsBuilder_;
            }

            public boolean hasS2CRewardCount() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public int getS2CRewardCount() {
                return this.s2CRewardCount_;
            }

            public Builder setS2CRewardCount(int value) {
                this.bitField0_ |= 0x8;
                this.s2CRewardCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CRewardCount() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.s2CRewardCount_ = 0;
                onChanged();
                return this;
            }

            public boolean hasS2CRewardStatus() {
                return ((this.bitField0_ & 0x10) == 16);
            }

            public int getS2CRewardStatus() {
                return this.s2CRewardStatus_;
            }

            public Builder setS2CRewardStatus(int value) {
                this.bitField0_ |= 0x10;
                this.s2CRewardStatus_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CRewardStatus() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.s2CRewardStatus_ = 0;
                onChanged();
                return this;
            }

            private void ensureS2COpenedChapterIsMutable() {
                if ((this.bitField0_ & 0x20) != 32) {
                    this.s2COpenedChapter_ = new ArrayList<>(this.s2COpenedChapter_);
                    this.bitField0_ |= 0x20;
                }
            }

            public List<Integer> getS2COpenedChapterList() {
                return Collections.unmodifiableList(this.s2COpenedChapter_);
            }

            public int getS2COpenedChapterCount() {
                return this.s2COpenedChapter_.size();
            }

            public int getS2COpenedChapter(int index) {
                return ((Integer) this.s2COpenedChapter_.get(index)).intValue();
            }

            public Builder setS2COpenedChapter(int index, int value) {
                ensureS2COpenedChapterIsMutable();
                this.s2COpenedChapter_.set(index, Integer.valueOf(value));
                onChanged();
                return this;
            }

            public Builder addS2COpenedChapter(int value) {
                ensureS2COpenedChapterIsMutable();
                this.s2COpenedChapter_.add(Integer.valueOf(value));
                onChanged();
                return this;
            }

            public Builder addAllS2COpenedChapter(Iterable<? extends Integer> values) {
                ensureS2COpenedChapterIsMutable();
                AbstractMessageLite.Builder.addAll(values, this.s2COpenedChapter_);
                onChanged();
                return this;
            }

            public Builder clearS2COpenedChapter() {
                this.s2COpenedChapter_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFDF;
                onChanged();
                return this;
            }

            private void ensureS2CChestViewIsMutable() {
                if ((this.bitField0_ & 0x40) != 64) {
                    this.s2CChestView_ = new ArrayList<>(this.s2CChestView_);
                    this.bitField0_ |= 0x40;
                }
            }

            public List<ItemOuterClass.MiniItem> getS2CChestViewList() {
                if (this.s2CChestViewBuilder_ == null)
                    return Collections.unmodifiableList(this.s2CChestView_);
                return this.s2CChestViewBuilder_.getMessageList();
            }

            public int getS2CChestViewCount() {
                if (this.s2CChestViewBuilder_ == null)
                    return this.s2CChestView_.size();
                return this.s2CChestViewBuilder_.getCount();
            }

            public ItemOuterClass.MiniItem getS2CChestView(int index) {
                if (this.s2CChestViewBuilder_ == null)
                    return this.s2CChestView_.get(index);
                return (ItemOuterClass.MiniItem) this.s2CChestViewBuilder_.getMessage(index);
            }

            public Builder setS2CChestView(int index, ItemOuterClass.MiniItem value) {
                if (this.s2CChestViewBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CChestViewIsMutable();
                    this.s2CChestView_.set(index, value);
                    onChanged();
                } else {
                    this.s2CChestViewBuilder_.setMessage(index, (GeneratedMessage) value);
                }
                return this;
            }

            public Builder setS2CChestView(int index, ItemOuterClass.MiniItem.Builder builderForValue) {
                if (this.s2CChestViewBuilder_ == null) {
                    ensureS2CChestViewIsMutable();
                    this.s2CChestView_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CChestViewBuilder_.setMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addS2CChestView(ItemOuterClass.MiniItem value) {
                if (this.s2CChestViewBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CChestViewIsMutable();
                    this.s2CChestView_.add(value);
                    onChanged();
                } else {
                    this.s2CChestViewBuilder_.addMessage((GeneratedMessage) value);
                }
                return this;
            }

            public Builder addS2CChestView(int index, ItemOuterClass.MiniItem value) {
                if (this.s2CChestViewBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CChestViewIsMutable();
                    this.s2CChestView_.add(index, value);
                    onChanged();
                } else {
                    this.s2CChestViewBuilder_.addMessage(index, (GeneratedMessage) value);
                }
                return this;
            }

            public Builder addS2CChestView(ItemOuterClass.MiniItem.Builder builderForValue) {
                if (this.s2CChestViewBuilder_ == null) {
                    ensureS2CChestViewIsMutable();
                    this.s2CChestView_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.s2CChestViewBuilder_.addMessage((GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addS2CChestView(int index, ItemOuterClass.MiniItem.Builder builderForValue) {
                if (this.s2CChestViewBuilder_ == null) {
                    ensureS2CChestViewIsMutable();
                    this.s2CChestView_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CChestViewBuilder_.addMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addAllS2CChestView(Iterable<? extends ItemOuterClass.MiniItem> values) {
                if (this.s2CChestViewBuilder_ == null) {
                    ensureS2CChestViewIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.s2CChestView_);
                    onChanged();
                } else {
                    this.s2CChestViewBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearS2CChestView() {
                if (this.s2CChestViewBuilder_ == null) {
                    this.s2CChestView_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFBF;
                    onChanged();
                } else {
                    this.s2CChestViewBuilder_.clear();
                }
                return this;
            }

            public Builder removeS2CChestView(int index) {
                if (this.s2CChestViewBuilder_ == null) {
                    ensureS2CChestViewIsMutable();
                    this.s2CChestView_.remove(index);
                    onChanged();
                } else {
                    this.s2CChestViewBuilder_.remove(index);
                }
                return this;
            }

            public ItemOuterClass.MiniItem.Builder getS2CChestViewBuilder(int index) {
                return (ItemOuterClass.MiniItem.Builder) getS2CChestViewFieldBuilder().getBuilder(index);
            }

            public ItemOuterClass.MiniItemOrBuilder getS2CChestViewOrBuilder(int index) {
                if (this.s2CChestViewBuilder_ == null)
                    return (ItemOuterClass.MiniItemOrBuilder) this.s2CChestView_.get(index);
                return (ItemOuterClass.MiniItemOrBuilder) this.s2CChestViewBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends ItemOuterClass.MiniItemOrBuilder> getS2CChestViewOrBuilderList() {
                if (this.s2CChestViewBuilder_ != null)
                    return this.s2CChestViewBuilder_.getMessageOrBuilderList();
                return (List) Collections.unmodifiableList(this.s2CChestView_);
            }

            public ItemOuterClass.MiniItem.Builder addS2CChestViewBuilder() {
                return (ItemOuterClass.MiniItem.Builder) getS2CChestViewFieldBuilder().addBuilder((GeneratedMessage) ItemOuterClass.MiniItem.getDefaultInstance());
            }

            public ItemOuterClass.MiniItem.Builder addS2CChestViewBuilder(int index) {
                return (ItemOuterClass.MiniItem.Builder) getS2CChestViewFieldBuilder().addBuilder(index, (GeneratedMessage) ItemOuterClass.MiniItem.getDefaultInstance());
            }

            public List<ItemOuterClass.MiniItem.Builder> getS2CChestViewBuilderList() {
                return getS2CChestViewFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<ItemOuterClass.MiniItem, ItemOuterClass.MiniItem.Builder, ItemOuterClass.MiniItemOrBuilder> getS2CChestViewFieldBuilder() {
                if (this.s2CChestViewBuilder_ == null) {
                    this.s2CChestViewBuilder_ = new RepeatedFieldBuilder(this.s2CChestView_, ((this.bitField0_ & 0x40) == 64), getParentForChildren(), isClean());
                    this.s2CChestView_ = null;
                }
                return this.s2CChestViewBuilder_;
            }
        }
    }

    public static final class AchievementGetAwardResponse extends GeneratedMessage implements AchievementGetAwardResponseOrBuilder {
        private static final AchievementGetAwardResponse defaultInstance = new AchievementGetAwardResponse(true);
        private final UnknownFieldSet unknownFields;

        private AchievementGetAwardResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private AchievementGetAwardResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static AchievementGetAwardResponse getDefaultInstance() {
            return defaultInstance;
        }

        public AchievementGetAwardResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AchievementGetAwardResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return AchievementHandler.internal_static_pomelo_area_AchievementGetAwardResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return AchievementHandler.internal_static_pomelo_area_AchievementGetAwardResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(AchievementGetAwardResponse.class, Builder.class);
        }

        public static Parser<AchievementGetAwardResponse> PARSER = (Parser<AchievementGetAwardResponse>) new AbstractParser<AchievementGetAwardResponse>() {
            public AchievementHandler.AchievementGetAwardResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AchievementHandler.AchievementGetAwardResponse(input, extensionRegistry);
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

        public Parser<AchievementGetAwardResponse> getParserForType() {
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


        public static AchievementGetAwardResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (AchievementGetAwardResponse) PARSER.parseFrom(data);
        }


        public static AchievementGetAwardResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AchievementGetAwardResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static AchievementGetAwardResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (AchievementGetAwardResponse) PARSER.parseFrom(data);
        }


        public static AchievementGetAwardResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AchievementGetAwardResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static AchievementGetAwardResponse parseFrom(InputStream input) throws IOException {
            return (AchievementGetAwardResponse) PARSER.parseFrom(input);
        }


        public static AchievementGetAwardResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AchievementGetAwardResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static AchievementGetAwardResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (AchievementGetAwardResponse) PARSER.parseDelimitedFrom(input);
        }


        public static AchievementGetAwardResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AchievementGetAwardResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static AchievementGetAwardResponse parseFrom(CodedInputStream input) throws IOException {
            return (AchievementGetAwardResponse) PARSER.parseFrom(input);
        }


        public static AchievementGetAwardResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AchievementGetAwardResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(AchievementGetAwardResponse prototype) {
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
                implements AchievementHandler.AchievementGetAwardResponseOrBuilder {
            private int bitField0_;


            private int s2CCode_;


            private Object s2CMsg_;


            public static final Descriptors.Descriptor getDescriptor() {
                return AchievementHandler.internal_static_pomelo_area_AchievementGetAwardResponse_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return AchievementHandler.internal_static_pomelo_area_AchievementGetAwardResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(AchievementHandler.AchievementGetAwardResponse.class, Builder.class);
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
                if (AchievementHandler.AchievementGetAwardResponse.alwaysUseFieldBuilders) ;
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
                return AchievementHandler.internal_static_pomelo_area_AchievementGetAwardResponse_descriptor;
            }


            public AchievementHandler.AchievementGetAwardResponse getDefaultInstanceForType() {
                return AchievementHandler.AchievementGetAwardResponse.getDefaultInstance();
            }


            public AchievementHandler.AchievementGetAwardResponse build() {
                AchievementHandler.AchievementGetAwardResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public AchievementHandler.AchievementGetAwardResponse buildPartial() {
                AchievementHandler.AchievementGetAwardResponse result = new AchievementHandler.AchievementGetAwardResponse(this);
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
                if (other instanceof AchievementHandler.AchievementGetAwardResponse) {
                    return mergeFrom((AchievementHandler.AchievementGetAwardResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(AchievementHandler.AchievementGetAwardResponse other) {
                if (other == AchievementHandler.AchievementGetAwardResponse.getDefaultInstance()) {
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
                AchievementHandler.AchievementGetAwardResponse parsedMessage = null;
                try {
                    parsedMessage = (AchievementHandler.AchievementGetAwardResponse) AchievementHandler.AchievementGetAwardResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (AchievementHandler.AchievementGetAwardResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = AchievementHandler.AchievementGetAwardResponse.getDefaultInstance().getS2CMsg();
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


    public static final class OnAchievementPush
            extends GeneratedMessage
            implements OnAchievementPushOrBuilder {
        private static final OnAchievementPush defaultInstance = new OnAchievementPush(true);
        private final UnknownFieldSet unknownFields;

        private OnAchievementPush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private OnAchievementPush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static OnAchievementPush getDefaultInstance() {
            return defaultInstance;
        }

        public OnAchievementPush getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private OnAchievementPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.s2CId_ = input.readInt32();
                            break;
                        case 26:
                            if ((mutable_bitField0_ & 0x4) != 4) {
                                this.s2CAchievements_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x4;
                            }
                            this.s2CAchievements_.add(input.readMessage(AchievementHandler.Achievement.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x4) == 4)
                    this.s2CAchievements_ = Collections.unmodifiableList(this.s2CAchievements_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AchievementHandler.internal_static_pomelo_area_OnAchievementPush_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return AchievementHandler.internal_static_pomelo_area_OnAchievementPush_fieldAccessorTable.ensureFieldAccessorsInitialized(OnAchievementPush.class, Builder.class);
        }

        public static Parser<OnAchievementPush> PARSER = (Parser<OnAchievementPush>) new AbstractParser<OnAchievementPush>() {
            public AchievementHandler.OnAchievementPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AchievementHandler.OnAchievementPush(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_ID_FIELD_NUMBER = 2;
        private int s2CId_;
        public static final int S2C_ACHIEVEMENTS_FIELD_NUMBER = 3;
        private List<AchievementHandler.Achievement> s2CAchievements_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<OnAchievementPush> getParserForType() {
            return PARSER;
        }

        public boolean hasS2CCode() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getS2CCode() {
            return this.s2CCode_;
        }

        public boolean hasS2CId() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public int getS2CId() {
            return this.s2CId_;
        }

        static {
            defaultInstance.initFields();
        }


        public List<AchievementHandler.Achievement> getS2CAchievementsList() {
            return this.s2CAchievements_;
        }


        public List<? extends AchievementHandler.AchievementOrBuilder> getS2CAchievementsOrBuilderList() {
            return (List) this.s2CAchievements_;
        }


        public int getS2CAchievementsCount() {
            return this.s2CAchievements_.size();
        }


        public AchievementHandler.Achievement getS2CAchievements(int index) {
            return this.s2CAchievements_.get(index);
        }


        public AchievementHandler.AchievementOrBuilder getS2CAchievementsOrBuilder(int index) {
            return this.s2CAchievements_.get(index);
        }


        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CId_ = 0;
            this.s2CAchievements_ = Collections.emptyList();
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
            for (int i = 0; i < getS2CAchievementsCount(); i++) {
                if (!getS2CAchievements(i).isInitialized()) {
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
                output.writeInt32(2, this.s2CId_);
            }
            for (int i = 0; i < this.s2CAchievements_.size(); i++) {
                output.writeMessage(3, (MessageLite) this.s2CAchievements_.get(i));
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
                size += CodedOutputStream.computeInt32Size(2, this.s2CId_);
            }
            for (int i = 0; i < this.s2CAchievements_.size(); i++) {
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.s2CAchievements_.get(i));
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static OnAchievementPush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (OnAchievementPush) PARSER.parseFrom(data);
        }


        public static OnAchievementPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (OnAchievementPush) PARSER.parseFrom(data, extensionRegistry);
        }


        public static OnAchievementPush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (OnAchievementPush) PARSER.parseFrom(data);
        }


        public static OnAchievementPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (OnAchievementPush) PARSER.parseFrom(data, extensionRegistry);
        }


        public static OnAchievementPush parseFrom(InputStream input) throws IOException {
            return (OnAchievementPush) PARSER.parseFrom(input);
        }


        public static OnAchievementPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OnAchievementPush) PARSER.parseFrom(input, extensionRegistry);
        }


        public static OnAchievementPush parseDelimitedFrom(InputStream input) throws IOException {
            return (OnAchievementPush) PARSER.parseDelimitedFrom(input);
        }

        public static OnAchievementPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OnAchievementPush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static OnAchievementPush parseFrom(CodedInputStream input) throws IOException {
            return (OnAchievementPush) PARSER.parseFrom(input);
        }

        public static OnAchievementPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OnAchievementPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(OnAchievementPush prototype) {
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
                implements AchievementHandler.OnAchievementPushOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private int s2CId_;
            private List<AchievementHandler.Achievement> s2CAchievements_;
            private RepeatedFieldBuilder<AchievementHandler.Achievement, AchievementHandler.Achievement.Builder, AchievementHandler.AchievementOrBuilder> s2CAchievementsBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AchievementHandler.internal_static_pomelo_area_OnAchievementPush_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return AchievementHandler.internal_static_pomelo_area_OnAchievementPush_fieldAccessorTable.ensureFieldAccessorsInitialized(AchievementHandler.OnAchievementPush.class, Builder.class);
            }

            private Builder() {
                this.s2CAchievements_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CAchievements_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AchievementHandler.OnAchievementPush.alwaysUseFieldBuilders) {
                    getS2CAchievementsFieldBuilder();
                }
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.s2CCode_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.s2CId_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                if (this.s2CAchievementsBuilder_ == null) {
                    this.s2CAchievements_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                } else {
                    this.s2CAchievementsBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return AchievementHandler.internal_static_pomelo_area_OnAchievementPush_descriptor;
            }

            public AchievementHandler.OnAchievementPush getDefaultInstanceForType() {
                return AchievementHandler.OnAchievementPush.getDefaultInstance();
            }

            public AchievementHandler.OnAchievementPush build() {
                AchievementHandler.OnAchievementPush result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public AchievementHandler.OnAchievementPush buildPartial() {
                AchievementHandler.OnAchievementPush result = new AchievementHandler.OnAchievementPush(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.s2CId_ = this.s2CId_;
                if (this.s2CAchievementsBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4) {
                        this.s2CAchievements_ = Collections.unmodifiableList(this.s2CAchievements_);
                        this.bitField0_ &= 0xFFFFFFFB;
                    }
                    result.s2CAchievements_ = this.s2CAchievements_;
                } else {
                    result.s2CAchievements_ = this.s2CAchievementsBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof AchievementHandler.OnAchievementPush) {
                    return mergeFrom((AchievementHandler.OnAchievementPush) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AchievementHandler.OnAchievementPush other) {
                if (other == AchievementHandler.OnAchievementPush.getDefaultInstance()) {
                    return this;
                }
                if (other.hasS2CCode()) {
                    setS2CCode(other.getS2CCode());
                }
                if (other.hasS2CId()) {
                    setS2CId(other.getS2CId());
                }
                if (this.s2CAchievementsBuilder_ == null) {
                    if (!other.s2CAchievements_.isEmpty()) {
                        if (this.s2CAchievements_.isEmpty()) {
                            this.s2CAchievements_ = other.s2CAchievements_;
                            this.bitField0_ &= 0xFFFFFFFB;
                        } else {
                            ensureS2CAchievementsIsMutable();
                            this.s2CAchievements_.addAll(other.s2CAchievements_);
                        }
                        onChanged();
                    }
                } else if (!other.s2CAchievements_.isEmpty()) {
                    if (this.s2CAchievementsBuilder_.isEmpty()) {
                        this.s2CAchievementsBuilder_.dispose();
                        this.s2CAchievementsBuilder_ = null;
                        this.s2CAchievements_ = other.s2CAchievements_;
                        this.bitField0_ &= 0xFFFFFFFB;
                        this.s2CAchievementsBuilder_ = AchievementHandler.OnAchievementPush.alwaysUseFieldBuilders ? getS2CAchievementsFieldBuilder() : null;
                    } else {
                        this.s2CAchievementsBuilder_.addAllMessages(other.s2CAchievements_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode()) {
                    return false;
                }
                for (int i = 0; i < getS2CAchievementsCount(); i++) {
                    if (!getS2CAchievements(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                AchievementHandler.OnAchievementPush parsedMessage = null;
                try {
                    parsedMessage = (AchievementHandler.OnAchievementPush) AchievementHandler.OnAchievementPush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (AchievementHandler.OnAchievementPush) e.getUnfinishedMessage();
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

            public boolean hasS2CId() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getS2CId() {
                return this.s2CId_;
            }

            public Builder setS2CId(int value) {
                this.bitField0_ |= 0x2;
                this.s2CId_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CId() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.s2CId_ = 0;
                onChanged();
                return this;
            }

            private void ensureS2CAchievementsIsMutable() {
                if ((this.bitField0_ & 0x4) != 4) {
                    this.s2CAchievements_ = new ArrayList<>(this.s2CAchievements_);
                    this.bitField0_ |= 0x4;
                }
            }

            public List<AchievementHandler.Achievement> getS2CAchievementsList() {
                if (this.s2CAchievementsBuilder_ == null) {
                    return Collections.unmodifiableList(this.s2CAchievements_);
                }
                return this.s2CAchievementsBuilder_.getMessageList();
            }

            public int getS2CAchievementsCount() {
                if (this.s2CAchievementsBuilder_ == null) {
                    return this.s2CAchievements_.size();
                }
                return this.s2CAchievementsBuilder_.getCount();
            }

            public AchievementHandler.Achievement getS2CAchievements(int index) {
                if (this.s2CAchievementsBuilder_ == null) {
                    return this.s2CAchievements_.get(index);
                }
                return (AchievementHandler.Achievement) this.s2CAchievementsBuilder_.getMessage(index);
            }

            public Builder setS2CAchievements(int index, AchievementHandler.Achievement value) {
                if (this.s2CAchievementsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureS2CAchievementsIsMutable();
                    this.s2CAchievements_.set(index, value);
                    onChanged();
                } else {
                    this.s2CAchievementsBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setS2CAchievements(int index, AchievementHandler.Achievement.Builder builderForValue) {
                if (this.s2CAchievementsBuilder_ == null) {
                    ensureS2CAchievementsIsMutable();
                    this.s2CAchievements_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CAchievementsBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addS2CAchievements(AchievementHandler.Achievement value) {
                if (this.s2CAchievementsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureS2CAchievementsIsMutable();
                    this.s2CAchievements_.add(value);
                    onChanged();
                } else {
                    this.s2CAchievementsBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addS2CAchievements(int index, AchievementHandler.Achievement value) {
                if (this.s2CAchievementsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureS2CAchievementsIsMutable();
                    this.s2CAchievements_.add(index, value);
                    onChanged();
                } else {
                    this.s2CAchievementsBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addS2CAchievements(AchievementHandler.Achievement.Builder builderForValue) {
                if (this.s2CAchievementsBuilder_ == null) {
                    ensureS2CAchievementsIsMutable();
                    this.s2CAchievements_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.s2CAchievementsBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addS2CAchievements(int index, AchievementHandler.Achievement.Builder builderForValue) {
                if (this.s2CAchievementsBuilder_ == null) {
                    ensureS2CAchievementsIsMutable();
                    this.s2CAchievements_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CAchievementsBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllS2CAchievements(Iterable<? extends AchievementHandler.Achievement> values) {
                if (this.s2CAchievementsBuilder_ == null) {
                    ensureS2CAchievementsIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.s2CAchievements_);
                    onChanged();
                } else {
                    this.s2CAchievementsBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearS2CAchievements() {
                if (this.s2CAchievementsBuilder_ == null) {
                    this.s2CAchievements_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                    onChanged();
                } else {
                    this.s2CAchievementsBuilder_.clear();
                }
                return this;
            }

            public Builder removeS2CAchievements(int index) {
                if (this.s2CAchievementsBuilder_ == null) {
                    ensureS2CAchievementsIsMutable();
                    this.s2CAchievements_.remove(index);
                    onChanged();
                } else {
                    this.s2CAchievementsBuilder_.remove(index);
                }
                return this;
            }

            public AchievementHandler.Achievement.Builder getS2CAchievementsBuilder(int index) {
                return (AchievementHandler.Achievement.Builder) getS2CAchievementsFieldBuilder().getBuilder(index);
            }

            public AchievementHandler.AchievementOrBuilder getS2CAchievementsOrBuilder(int index) {
                if (this.s2CAchievementsBuilder_ == null) {
                    return this.s2CAchievements_.get(index);
                }
                return (AchievementHandler.AchievementOrBuilder) this.s2CAchievementsBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends AchievementHandler.AchievementOrBuilder> getS2CAchievementsOrBuilderList() {
                if (this.s2CAchievementsBuilder_ != null) {
                    return this.s2CAchievementsBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList((List) this.s2CAchievements_);
            }

            public AchievementHandler.Achievement.Builder addS2CAchievementsBuilder() {
                return (AchievementHandler.Achievement.Builder) getS2CAchievementsFieldBuilder().addBuilder(AchievementHandler.Achievement.getDefaultInstance());
            }

            public AchievementHandler.Achievement.Builder addS2CAchievementsBuilder(int index) {
                return (AchievementHandler.Achievement.Builder) getS2CAchievementsFieldBuilder().addBuilder(index, AchievementHandler.Achievement.getDefaultInstance());
            }

            public List<AchievementHandler.Achievement.Builder> getS2CAchievementsBuilderList() {
                return getS2CAchievementsFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<AchievementHandler.Achievement, AchievementHandler.Achievement.Builder, AchievementHandler.AchievementOrBuilder> getS2CAchievementsFieldBuilder() {
                if (this.s2CAchievementsBuilder_ == null) {
                    this.s2CAchievementsBuilder_ = new RepeatedFieldBuilder(this.s2CAchievements_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
                    this.s2CAchievements_ = null;
                }
                return this.s2CAchievementsBuilder_;
            }
        }
    }

    public static final class HolyArmor
            extends GeneratedMessage
            implements HolyArmorOrBuilder {
        private static final HolyArmor defaultInstance = new HolyArmor(true);
        private final UnknownFieldSet unknownFields;

        private HolyArmor(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private HolyArmor(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static HolyArmor getDefaultInstance() {
            return defaultInstance;
        }

        public HolyArmor getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private HolyArmor(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.states_ = input.readInt32();
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
            return AchievementHandler.internal_static_pomelo_area_HolyArmor_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return AchievementHandler.internal_static_pomelo_area_HolyArmor_fieldAccessorTable.ensureFieldAccessorsInitialized(HolyArmor.class, Builder.class);
        }

        public static Parser<HolyArmor> PARSER = (Parser<HolyArmor>) new AbstractParser<HolyArmor>() {
            public AchievementHandler.HolyArmor parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AchievementHandler.HolyArmor(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int ID_FIELD_NUMBER = 1;
        private int id_;
        public static final int STATES_FIELD_NUMBER = 2;
        private int states_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<HolyArmor> getParserForType() {
            return PARSER;
        }

        public boolean hasId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getId() {
            return this.id_;
        }

        public boolean hasStates() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public int getStates() {
            return this.states_;
        }

        private void initFields() {
            this.id_ = 0;
            this.states_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasStates()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.id_);
            if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.states_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.id_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(2, this.states_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static HolyArmor parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (HolyArmor) PARSER.parseFrom(data);
        }

        public static HolyArmor parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (HolyArmor) PARSER.parseFrom(data, extensionRegistry);
        }

        public static HolyArmor parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (HolyArmor) PARSER.parseFrom(data);
        }

        public static HolyArmor parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (HolyArmor) PARSER.parseFrom(data, extensionRegistry);
        }

        public static HolyArmor parseFrom(InputStream input) throws IOException {
            return (HolyArmor) PARSER.parseFrom(input);
        }

        public static HolyArmor parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HolyArmor) PARSER.parseFrom(input, extensionRegistry);
        }

        public static HolyArmor parseDelimitedFrom(InputStream input) throws IOException {
            return (HolyArmor) PARSER.parseDelimitedFrom(input);
        }

        public static HolyArmor parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HolyArmor) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static HolyArmor parseFrom(CodedInputStream input) throws IOException {
            return (HolyArmor) PARSER.parseFrom(input);
        }

        public static HolyArmor parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HolyArmor) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(HolyArmor prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements AchievementHandler.HolyArmorOrBuilder {
            private int bitField0_;
            private int id_;
            private int states_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AchievementHandler.internal_static_pomelo_area_HolyArmor_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return AchievementHandler.internal_static_pomelo_area_HolyArmor_fieldAccessorTable.ensureFieldAccessorsInitialized(AchievementHandler.HolyArmor.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AchievementHandler.HolyArmor.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.id_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.states_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return AchievementHandler.internal_static_pomelo_area_HolyArmor_descriptor;
            }

            public AchievementHandler.HolyArmor getDefaultInstanceForType() {
                return AchievementHandler.HolyArmor.getDefaultInstance();
            }

            public AchievementHandler.HolyArmor build() {
                AchievementHandler.HolyArmor result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public AchievementHandler.HolyArmor buildPartial() {
                AchievementHandler.HolyArmor result = new AchievementHandler.HolyArmor(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.id_ = this.id_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.states_ = this.states_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof AchievementHandler.HolyArmor)
                    return mergeFrom((AchievementHandler.HolyArmor) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AchievementHandler.HolyArmor other) {
                if (other == AchievementHandler.HolyArmor.getDefaultInstance()) return this;
                if (other.hasId()) setId(other.getId());
                if (other.hasStates()) setStates(other.getStates());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasId()) return false;
                if (!hasStates()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                AchievementHandler.HolyArmor parsedMessage = null;
                try {
                    parsedMessage = (AchievementHandler.HolyArmor) AchievementHandler.HolyArmor.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (AchievementHandler.HolyArmor) e.getUnfinishedMessage();
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

            public boolean hasStates() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getStates() {
                return this.states_;
            }

            public Builder setStates(int value) {
                this.bitField0_ |= 0x2;
                this.states_ = value;
                onChanged();
                return this;
            }

            public Builder clearStates() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.states_ = 0;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class GetHolyArmorsRequest
            extends GeneratedMessage
            implements GetHolyArmorsRequestOrBuilder {
        private static final GetHolyArmorsRequest defaultInstance = new GetHolyArmorsRequest(true);
        private final UnknownFieldSet unknownFields;

        private GetHolyArmorsRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetHolyArmorsRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetHolyArmorsRequest getDefaultInstance() {
            return defaultInstance;
        }

        public GetHolyArmorsRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetHolyArmorsRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return AchievementHandler.internal_static_pomelo_area_GetHolyArmorsRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return AchievementHandler.internal_static_pomelo_area_GetHolyArmorsRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetHolyArmorsRequest.class, Builder.class);
        }

        public static Parser<GetHolyArmorsRequest> PARSER = (Parser<GetHolyArmorsRequest>) new AbstractParser<GetHolyArmorsRequest>() {
            public AchievementHandler.GetHolyArmorsRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AchievementHandler.GetHolyArmorsRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetHolyArmorsRequest> getParserForType() {
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

        public static GetHolyArmorsRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetHolyArmorsRequest) PARSER.parseFrom(data);
        }

        public static GetHolyArmorsRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetHolyArmorsRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetHolyArmorsRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetHolyArmorsRequest) PARSER.parseFrom(data);
        }

        public static GetHolyArmorsRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetHolyArmorsRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetHolyArmorsRequest parseFrom(InputStream input) throws IOException {
            return (GetHolyArmorsRequest) PARSER.parseFrom(input);
        }

        public static GetHolyArmorsRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetHolyArmorsRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static GetHolyArmorsRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (GetHolyArmorsRequest) PARSER.parseDelimitedFrom(input);
        }

        public static GetHolyArmorsRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetHolyArmorsRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static GetHolyArmorsRequest parseFrom(CodedInputStream input) throws IOException {
            return (GetHolyArmorsRequest) PARSER.parseFrom(input);
        }

        public static GetHolyArmorsRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetHolyArmorsRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(GetHolyArmorsRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements AchievementHandler.GetHolyArmorsRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return AchievementHandler.internal_static_pomelo_area_GetHolyArmorsRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return AchievementHandler.internal_static_pomelo_area_GetHolyArmorsRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(AchievementHandler.GetHolyArmorsRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AchievementHandler.GetHolyArmorsRequest.alwaysUseFieldBuilders) ;
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
                return AchievementHandler.internal_static_pomelo_area_GetHolyArmorsRequest_descriptor;
            }

            public AchievementHandler.GetHolyArmorsRequest getDefaultInstanceForType() {
                return AchievementHandler.GetHolyArmorsRequest.getDefaultInstance();
            }

            public AchievementHandler.GetHolyArmorsRequest build() {
                AchievementHandler.GetHolyArmorsRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public AchievementHandler.GetHolyArmorsRequest buildPartial() {
                AchievementHandler.GetHolyArmorsRequest result = new AchievementHandler.GetHolyArmorsRequest(this);
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof AchievementHandler.GetHolyArmorsRequest)
                    return mergeFrom((AchievementHandler.GetHolyArmorsRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AchievementHandler.GetHolyArmorsRequest other) {
                if (other == AchievementHandler.GetHolyArmorsRequest.getDefaultInstance()) return this;
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                AchievementHandler.GetHolyArmorsRequest parsedMessage = null;
                try {
                    parsedMessage = (AchievementHandler.GetHolyArmorsRequest) AchievementHandler.GetHolyArmorsRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (AchievementHandler.GetHolyArmorsRequest) e.getUnfinishedMessage();
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


    public static final class GetHolyArmorsResponse
            extends GeneratedMessage
            implements GetHolyArmorsResponseOrBuilder {
        private static final GetHolyArmorsResponse defaultInstance = new GetHolyArmorsResponse(true);
        private final UnknownFieldSet unknownFields;

        private GetHolyArmorsResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetHolyArmorsResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetHolyArmorsResponse getDefaultInstance() {
            return defaultInstance;
        }

        public GetHolyArmorsResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetHolyArmorsResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.holyArmors_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x4;
                            }
                            this.holyArmors_.add(input.readMessage(AchievementHandler.HolyArmor.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x4) == 4) this.holyArmors_ = Collections.unmodifiableList(this.holyArmors_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AchievementHandler.internal_static_pomelo_area_GetHolyArmorsResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return AchievementHandler.internal_static_pomelo_area_GetHolyArmorsResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetHolyArmorsResponse.class, Builder.class);
        }

        public static Parser<GetHolyArmorsResponse> PARSER = (Parser<GetHolyArmorsResponse>) new AbstractParser<GetHolyArmorsResponse>() {
            public AchievementHandler.GetHolyArmorsResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AchievementHandler.GetHolyArmorsResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int HOLYARMORS_FIELD_NUMBER = 3;
        private List<AchievementHandler.HolyArmor> holyArmors_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetHolyArmorsResponse> getParserForType() {
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

        public List<AchievementHandler.HolyArmor> getHolyArmorsList() {
            return this.holyArmors_;
        }

        public List<? extends AchievementHandler.HolyArmorOrBuilder> getHolyArmorsOrBuilderList() {
            return (List) this.holyArmors_;
        }

        public int getHolyArmorsCount() {
            return this.holyArmors_.size();
        }

        public AchievementHandler.HolyArmor getHolyArmors(int index) {
            return this.holyArmors_.get(index);
        }

        public AchievementHandler.HolyArmorOrBuilder getHolyArmorsOrBuilder(int index) {
            return this.holyArmors_.get(index);
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.holyArmors_ = Collections.emptyList();
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
            for (int i = 0; i < getHolyArmorsCount(); i++) {
                if (!getHolyArmors(i).isInitialized()) {
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
            for (int i = 0; i < this.holyArmors_.size(); i++)
                output.writeMessage(3, (MessageLite) this.holyArmors_.get(i));
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
            for (int i = 0; i < this.holyArmors_.size(); i++)
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.holyArmors_.get(i));
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static GetHolyArmorsResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetHolyArmorsResponse) PARSER.parseFrom(data);
        }

        public static GetHolyArmorsResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetHolyArmorsResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetHolyArmorsResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetHolyArmorsResponse) PARSER.parseFrom(data);
        }

        public static GetHolyArmorsResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetHolyArmorsResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetHolyArmorsResponse parseFrom(InputStream input) throws IOException {
            return (GetHolyArmorsResponse) PARSER.parseFrom(input);
        }

        public static GetHolyArmorsResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetHolyArmorsResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static GetHolyArmorsResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (GetHolyArmorsResponse) PARSER.parseDelimitedFrom(input);
        }

        public static GetHolyArmorsResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetHolyArmorsResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static GetHolyArmorsResponse parseFrom(CodedInputStream input) throws IOException {
            return (GetHolyArmorsResponse) PARSER.parseFrom(input);
        }

        public static GetHolyArmorsResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetHolyArmorsResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(GetHolyArmorsResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements AchievementHandler.GetHolyArmorsResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private List<AchievementHandler.HolyArmor> holyArmors_;
            private RepeatedFieldBuilder<AchievementHandler.HolyArmor, AchievementHandler.HolyArmor.Builder, AchievementHandler.HolyArmorOrBuilder> holyArmorsBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AchievementHandler.internal_static_pomelo_area_GetHolyArmorsResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return AchievementHandler.internal_static_pomelo_area_GetHolyArmorsResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(AchievementHandler.GetHolyArmorsResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.holyArmors_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.holyArmors_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AchievementHandler.GetHolyArmorsResponse.alwaysUseFieldBuilders)
                    getHolyArmorsFieldBuilder();
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
                if (this.holyArmorsBuilder_ == null) {
                    this.holyArmors_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                } else {
                    this.holyArmorsBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return AchievementHandler.internal_static_pomelo_area_GetHolyArmorsResponse_descriptor;
            }

            public AchievementHandler.GetHolyArmorsResponse getDefaultInstanceForType() {
                return AchievementHandler.GetHolyArmorsResponse.getDefaultInstance();
            }

            public AchievementHandler.GetHolyArmorsResponse build() {
                AchievementHandler.GetHolyArmorsResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public AchievementHandler.GetHolyArmorsResponse buildPartial() {
                AchievementHandler.GetHolyArmorsResponse result = new AchievementHandler.GetHolyArmorsResponse(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.s2CMsg_ = this.s2CMsg_;
                if (this.holyArmorsBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4) {
                        this.holyArmors_ = Collections.unmodifiableList(this.holyArmors_);
                        this.bitField0_ &= 0xFFFFFFFB;
                    }
                    result.holyArmors_ = this.holyArmors_;
                } else {
                    result.holyArmors_ = this.holyArmorsBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof AchievementHandler.GetHolyArmorsResponse)
                    return mergeFrom((AchievementHandler.GetHolyArmorsResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AchievementHandler.GetHolyArmorsResponse other) {
                if (other == AchievementHandler.GetHolyArmorsResponse.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (this.holyArmorsBuilder_ == null) {
                    if (!other.holyArmors_.isEmpty()) {
                        if (this.holyArmors_.isEmpty()) {
                            this.holyArmors_ = other.holyArmors_;
                            this.bitField0_ &= 0xFFFFFFFB;
                        } else {
                            ensureHolyArmorsIsMutable();
                            this.holyArmors_.addAll(other.holyArmors_);
                        }
                        onChanged();
                    }
                } else if (!other.holyArmors_.isEmpty()) {
                    if (this.holyArmorsBuilder_.isEmpty()) {
                        this.holyArmorsBuilder_.dispose();
                        this.holyArmorsBuilder_ = null;
                        this.holyArmors_ = other.holyArmors_;
                        this.bitField0_ &= 0xFFFFFFFB;
                        this.holyArmorsBuilder_ = AchievementHandler.GetHolyArmorsResponse.alwaysUseFieldBuilders ? getHolyArmorsFieldBuilder() : null;
                    } else {
                        this.holyArmorsBuilder_.addAllMessages(other.holyArmors_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode())
                    return false;
                for (int i = 0; i < getHolyArmorsCount(); i++) {
                    if (!getHolyArmors(i).isInitialized())
                        return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                AchievementHandler.GetHolyArmorsResponse parsedMessage = null;
                try {
                    parsedMessage = (AchievementHandler.GetHolyArmorsResponse) AchievementHandler.GetHolyArmorsResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (AchievementHandler.GetHolyArmorsResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = AchievementHandler.GetHolyArmorsResponse.getDefaultInstance().getS2CMsg();
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

            private void ensureHolyArmorsIsMutable() {
                if ((this.bitField0_ & 0x4) != 4) {
                    this.holyArmors_ = new ArrayList<>(this.holyArmors_);
                    this.bitField0_ |= 0x4;
                }
            }

            public List<AchievementHandler.HolyArmor> getHolyArmorsList() {
                if (this.holyArmorsBuilder_ == null)
                    return Collections.unmodifiableList(this.holyArmors_);
                return this.holyArmorsBuilder_.getMessageList();
            }

            public int getHolyArmorsCount() {
                if (this.holyArmorsBuilder_ == null)
                    return this.holyArmors_.size();
                return this.holyArmorsBuilder_.getCount();
            }

            public AchievementHandler.HolyArmor getHolyArmors(int index) {
                if (this.holyArmorsBuilder_ == null)
                    return this.holyArmors_.get(index);
                return (AchievementHandler.HolyArmor) this.holyArmorsBuilder_.getMessage(index);
            }

            public Builder setHolyArmors(int index, AchievementHandler.HolyArmor value) {
                if (this.holyArmorsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureHolyArmorsIsMutable();
                    this.holyArmors_.set(index, value);
                    onChanged();
                } else {
                    this.holyArmorsBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setHolyArmors(int index, AchievementHandler.HolyArmor.Builder builderForValue) {
                if (this.holyArmorsBuilder_ == null) {
                    ensureHolyArmorsIsMutable();
                    this.holyArmors_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.holyArmorsBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addHolyArmors(AchievementHandler.HolyArmor value) {
                if (this.holyArmorsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureHolyArmorsIsMutable();
                    this.holyArmors_.add(value);
                    onChanged();
                } else {
                    this.holyArmorsBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addHolyArmors(int index, AchievementHandler.HolyArmor value) {
                if (this.holyArmorsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureHolyArmorsIsMutable();
                    this.holyArmors_.add(index, value);
                    onChanged();
                } else {
                    this.holyArmorsBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addHolyArmors(AchievementHandler.HolyArmor.Builder builderForValue) {
                if (this.holyArmorsBuilder_ == null) {
                    ensureHolyArmorsIsMutable();
                    this.holyArmors_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.holyArmorsBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addHolyArmors(int index, AchievementHandler.HolyArmor.Builder builderForValue) {
                if (this.holyArmorsBuilder_ == null) {
                    ensureHolyArmorsIsMutable();
                    this.holyArmors_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.holyArmorsBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllHolyArmors(Iterable<? extends AchievementHandler.HolyArmor> values) {
                if (this.holyArmorsBuilder_ == null) {
                    ensureHolyArmorsIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.holyArmors_);
                    onChanged();
                } else {
                    this.holyArmorsBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearHolyArmors() {
                if (this.holyArmorsBuilder_ == null) {
                    this.holyArmors_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                    onChanged();
                } else {
                    this.holyArmorsBuilder_.clear();
                }
                return this;
            }

            public Builder removeHolyArmors(int index) {
                if (this.holyArmorsBuilder_ == null) {
                    ensureHolyArmorsIsMutable();
                    this.holyArmors_.remove(index);
                    onChanged();
                } else {
                    this.holyArmorsBuilder_.remove(index);
                }
                return this;
            }

            public AchievementHandler.HolyArmor.Builder getHolyArmorsBuilder(int index) {
                return (AchievementHandler.HolyArmor.Builder) getHolyArmorsFieldBuilder().getBuilder(index);
            }

            public AchievementHandler.HolyArmorOrBuilder getHolyArmorsOrBuilder(int index) {
                if (this.holyArmorsBuilder_ == null)
                    return this.holyArmors_.get(index);
                return (AchievementHandler.HolyArmorOrBuilder) this.holyArmorsBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends AchievementHandler.HolyArmorOrBuilder> getHolyArmorsOrBuilderList() {
                if (this.holyArmorsBuilder_ != null)
                    return this.holyArmorsBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.holyArmors_);
            }

            public AchievementHandler.HolyArmor.Builder addHolyArmorsBuilder() {
                return (AchievementHandler.HolyArmor.Builder) getHolyArmorsFieldBuilder().addBuilder(AchievementHandler.HolyArmor.getDefaultInstance());
            }

            public AchievementHandler.HolyArmor.Builder addHolyArmorsBuilder(int index) {
                return (AchievementHandler.HolyArmor.Builder) getHolyArmorsFieldBuilder().addBuilder(index, AchievementHandler.HolyArmor.getDefaultInstance());
            }

            public List<AchievementHandler.HolyArmor.Builder> getHolyArmorsBuilderList() {
                return getHolyArmorsFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<AchievementHandler.HolyArmor, AchievementHandler.HolyArmor.Builder, AchievementHandler.HolyArmorOrBuilder> getHolyArmorsFieldBuilder() {
                if (this.holyArmorsBuilder_ == null) {
                    this.holyArmorsBuilder_ = new RepeatedFieldBuilder(this.holyArmors_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
                    this.holyArmors_ = null;
                }
                return this.holyArmorsBuilder_;
            }
        }
    }

    public static final class ActivateHolyArmorRequest extends GeneratedMessage implements ActivateHolyArmorRequestOrBuilder {
        private static final ActivateHolyArmorRequest defaultInstance = new ActivateHolyArmorRequest(true);
        private final UnknownFieldSet unknownFields;

        private ActivateHolyArmorRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private ActivateHolyArmorRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static ActivateHolyArmorRequest getDefaultInstance() {
            return defaultInstance;
        }

        public ActivateHolyArmorRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ActivateHolyArmorRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return AchievementHandler.internal_static_pomelo_area_ActivateHolyArmorRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return AchievementHandler.internal_static_pomelo_area_ActivateHolyArmorRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ActivateHolyArmorRequest.class, Builder.class);
        }

        public static Parser<ActivateHolyArmorRequest> PARSER = (Parser<ActivateHolyArmorRequest>) new AbstractParser<ActivateHolyArmorRequest>() {
            public AchievementHandler.ActivateHolyArmorRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AchievementHandler.ActivateHolyArmorRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int ID_FIELD_NUMBER = 1;
        private int id_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<ActivateHolyArmorRequest> getParserForType() {
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

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.id_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.id_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static ActivateHolyArmorRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ActivateHolyArmorRequest) PARSER.parseFrom(data);
        }

        public static ActivateHolyArmorRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ActivateHolyArmorRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static ActivateHolyArmorRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ActivateHolyArmorRequest) PARSER.parseFrom(data);
        }

        public static ActivateHolyArmorRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ActivateHolyArmorRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static ActivateHolyArmorRequest parseFrom(InputStream input) throws IOException {
            return (ActivateHolyArmorRequest) PARSER.parseFrom(input);
        }

        public static ActivateHolyArmorRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ActivateHolyArmorRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static ActivateHolyArmorRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (ActivateHolyArmorRequest) PARSER.parseDelimitedFrom(input);
        }

        public static ActivateHolyArmorRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ActivateHolyArmorRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static ActivateHolyArmorRequest parseFrom(CodedInputStream input) throws IOException {
            return (ActivateHolyArmorRequest) PARSER.parseFrom(input);
        }

        public static ActivateHolyArmorRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ActivateHolyArmorRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(ActivateHolyArmorRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements AchievementHandler.ActivateHolyArmorRequestOrBuilder {
            private int bitField0_;
            private int id_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AchievementHandler.internal_static_pomelo_area_ActivateHolyArmorRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return AchievementHandler.internal_static_pomelo_area_ActivateHolyArmorRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(AchievementHandler.ActivateHolyArmorRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AchievementHandler.ActivateHolyArmorRequest.alwaysUseFieldBuilders) ;
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
                return AchievementHandler.internal_static_pomelo_area_ActivateHolyArmorRequest_descriptor;
            }

            public AchievementHandler.ActivateHolyArmorRequest getDefaultInstanceForType() {
                return AchievementHandler.ActivateHolyArmorRequest.getDefaultInstance();
            }

            public AchievementHandler.ActivateHolyArmorRequest build() {
                AchievementHandler.ActivateHolyArmorRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public AchievementHandler.ActivateHolyArmorRequest buildPartial() {
                AchievementHandler.ActivateHolyArmorRequest result = new AchievementHandler.ActivateHolyArmorRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.id_ = this.id_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof AchievementHandler.ActivateHolyArmorRequest)
                    return mergeFrom((AchievementHandler.ActivateHolyArmorRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AchievementHandler.ActivateHolyArmorRequest other) {
                if (other == AchievementHandler.ActivateHolyArmorRequest.getDefaultInstance()) return this;
                if (other.hasId()) setId(other.getId());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasId()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                AchievementHandler.ActivateHolyArmorRequest parsedMessage = null;
                try {
                    parsedMessage = (AchievementHandler.ActivateHolyArmorRequest) AchievementHandler.ActivateHolyArmorRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (AchievementHandler.ActivateHolyArmorRequest) e.getUnfinishedMessage();
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
        }

        static {
            defaultInstance.initFields();
        }
    }


    public static final class ActivateHolyArmorResponse
            extends GeneratedMessage
            implements ActivateHolyArmorResponseOrBuilder {
        private static final ActivateHolyArmorResponse defaultInstance = new ActivateHolyArmorResponse(true);
        private final UnknownFieldSet unknownFields;

        private ActivateHolyArmorResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private ActivateHolyArmorResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static ActivateHolyArmorResponse getDefaultInstance() {
            return defaultInstance;
        }

        public ActivateHolyArmorResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ActivateHolyArmorResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return AchievementHandler.internal_static_pomelo_area_ActivateHolyArmorResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return AchievementHandler.internal_static_pomelo_area_ActivateHolyArmorResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ActivateHolyArmorResponse.class, Builder.class);
        }

        public static Parser<ActivateHolyArmorResponse> PARSER = (Parser<ActivateHolyArmorResponse>) new AbstractParser<ActivateHolyArmorResponse>() {
            public AchievementHandler.ActivateHolyArmorResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AchievementHandler.ActivateHolyArmorResponse(input, extensionRegistry);
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

        public Parser<ActivateHolyArmorResponse> getParserForType() {
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

        public static ActivateHolyArmorResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ActivateHolyArmorResponse) PARSER.parseFrom(data);
        }

        public static ActivateHolyArmorResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ActivateHolyArmorResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static ActivateHolyArmorResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ActivateHolyArmorResponse) PARSER.parseFrom(data);
        }

        public static ActivateHolyArmorResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ActivateHolyArmorResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static ActivateHolyArmorResponse parseFrom(InputStream input) throws IOException {
            return (ActivateHolyArmorResponse) PARSER.parseFrom(input);
        }

        public static ActivateHolyArmorResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ActivateHolyArmorResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static ActivateHolyArmorResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (ActivateHolyArmorResponse) PARSER.parseDelimitedFrom(input);
        }

        public static ActivateHolyArmorResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ActivateHolyArmorResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static ActivateHolyArmorResponse parseFrom(CodedInputStream input) throws IOException {
            return (ActivateHolyArmorResponse) PARSER.parseFrom(input);
        }

        public static ActivateHolyArmorResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ActivateHolyArmorResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(ActivateHolyArmorResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements AchievementHandler.ActivateHolyArmorResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AchievementHandler.internal_static_pomelo_area_ActivateHolyArmorResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return AchievementHandler.internal_static_pomelo_area_ActivateHolyArmorResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(AchievementHandler.ActivateHolyArmorResponse.class, Builder.class);
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
                if (AchievementHandler.ActivateHolyArmorResponse.alwaysUseFieldBuilders) ;
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
                return AchievementHandler.internal_static_pomelo_area_ActivateHolyArmorResponse_descriptor;
            }

            public AchievementHandler.ActivateHolyArmorResponse getDefaultInstanceForType() {
                return AchievementHandler.ActivateHolyArmorResponse.getDefaultInstance();
            }

            public AchievementHandler.ActivateHolyArmorResponse build() {
                AchievementHandler.ActivateHolyArmorResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public AchievementHandler.ActivateHolyArmorResponse buildPartial() {
                AchievementHandler.ActivateHolyArmorResponse result = new AchievementHandler.ActivateHolyArmorResponse(this);
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
                if (other instanceof AchievementHandler.ActivateHolyArmorResponse)
                    return mergeFrom((AchievementHandler.ActivateHolyArmorResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AchievementHandler.ActivateHolyArmorResponse other) {
                if (other == AchievementHandler.ActivateHolyArmorResponse.getDefaultInstance())
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
                AchievementHandler.ActivateHolyArmorResponse parsedMessage = null;
                try {
                    parsedMessage = (AchievementHandler.ActivateHolyArmorResponse) AchievementHandler.ActivateHolyArmorResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (AchievementHandler.ActivateHolyArmorResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = AchievementHandler.ActivateHolyArmorResponse.getDefaultInstance().getS2CMsg();
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
        String[] descriptorData = {"\n\030achievementHandler.proto\022\013pomelo.area\032\fcommon.proto\032\nitem.proto\"2\n AchievementGetTypeElementRequest\022\016\n\006c2s_id\030\001 \002(\005\">\n\032AchievementGetAwardRequest\022\016\n\006c2s_id\030\001 \002(\005\022\020\n\bc2s_type\030\002 \002(\005\"?\n\013Achievement\022\n\n\002id\030\001 \002(\005\022\024\n\fscheduleCurr\030\002 \002(\005\022\016\n\006status\030\003 \002(\005\"ù\001\n!AchievementGetTypeElementResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\0222\n\020s2c_achievements\030\003 \003(\0132\030.pomelo.area.Achievement\022\027\n\017s2c_rewardCount\030\004 \001(\005\022\031\n\021", "s2c_reward_status\030\005 \001(\005\022\032\n\022s2c_opened_chapter\030\006 \003(\005\022-\n\016s2c_chest_view\030\007 \003(\0132\025.pomelo.item.MiniItem\"@\n\033AchievementGetAwardResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"i\n\021OnAchievementPush\022\020\n\bs2c_code\030\001 \002(\005\022\016\n\006s2c_id\030\002 \001(\005\0222\n\020s2c_achievements\030\003 \003(\0132\030.pomelo.area.Achievement\"'\n\tHolyArmor\022\n\n\002id\030\001 \002(\005\022\016\n\006states\030\002 \002(\005\"\026\n\024GetHolyArmorsRequest\"f\n\025GetHolyArmorsResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022*\n\n", "holyArmors\030\003 \003(\0132\026.pomelo.area.HolyArmor\"&\n\030ActivateHolyArmorRequest\022\n\n\002id\030\001 \002(\005\">\n\031ActivateHolyArmorResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t2Ó\003\n\022achievementHandler\022\001\n achievementGetTypeElementRequest\022-.pomelo.area.AchievementGetTypeElementRequest\032..pomelo.area.AchievementGetTypeElementResponse\022o\n\032achievementGetAwardRequest\022'.pomelo.area.AchievementGetAwardRequest\032(.pomelo.area.AchievementGetA", "wardResponse\022]\n\024getHolyArmorsRequest\022!.pomelo.area.GetHolyArmorsRequest\032\".pomelo.area.GetHolyArmorsResponse\022i\n\030activateHolyArmorRequest\022%.pomelo.area.ActivateHolyArmorRequest\032&.pomelo.area.ActivateHolyArmorResponse2T\n\017achievementPush\022A\n\021onAchievementPush\022\036.pomelo.area.OnAchievementPush\032\f.pomelo.Void"};


        Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root) {
                AchievementHandler.descriptor = root;
                return null;
            }
        };

        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[]{

                Common.getDescriptor(),
                ItemOuterClass.getDescriptor()}, assigner);
    }

    private static final Descriptors.Descriptor internal_static_pomelo_area_AchievementGetTypeElementRequest_descriptor = getDescriptor().getMessageTypes().get(0);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_AchievementGetTypeElementRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_AchievementGetTypeElementRequest_descriptor, new String[]{"C2SId"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_AchievementGetAwardRequest_descriptor = getDescriptor().getMessageTypes().get(1);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_AchievementGetAwardRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_AchievementGetAwardRequest_descriptor, new String[]{"C2SId", "C2SType"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_Achievement_descriptor = getDescriptor().getMessageTypes().get(2);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_Achievement_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_Achievement_descriptor, new String[]{"Id", "ScheduleCurr", "Status"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_AchievementGetTypeElementResponse_descriptor = getDescriptor().getMessageTypes().get(3);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_AchievementGetTypeElementResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_AchievementGetTypeElementResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CAchievements", "S2CRewardCount", "S2CRewardStatus", "S2COpenedChapter", "S2CChestView"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_AchievementGetAwardResponse_descriptor = getDescriptor().getMessageTypes().get(4);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_AchievementGetAwardResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_AchievementGetAwardResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_OnAchievementPush_descriptor = getDescriptor().getMessageTypes().get(5);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_OnAchievementPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_OnAchievementPush_descriptor, new String[]{"S2CCode", "S2CId", "S2CAchievements"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_HolyArmor_descriptor = getDescriptor().getMessageTypes().get(6);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_HolyArmor_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_HolyArmor_descriptor, new String[]{"Id", "States"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetHolyArmorsRequest_descriptor = getDescriptor().getMessageTypes().get(7);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetHolyArmorsRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetHolyArmorsRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetHolyArmorsResponse_descriptor = getDescriptor().getMessageTypes().get(8);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetHolyArmorsResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetHolyArmorsResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "HolyArmors"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_ActivateHolyArmorRequest_descriptor = getDescriptor().getMessageTypes().get(9);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ActivateHolyArmorRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ActivateHolyArmorRequest_descriptor, new String[]{"Id"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_ActivateHolyArmorResponse_descriptor = getDescriptor().getMessageTypes().get(10);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ActivateHolyArmorResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ActivateHolyArmorResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});
    private static Descriptors.FileDescriptor descriptor;

    static {
        Common.getDescriptor();
        ItemOuterClass.getDescriptor();
    }

    public static interface ActivateHolyArmorResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface ActivateHolyArmorRequestOrBuilder extends MessageOrBuilder {
        boolean hasId();

        int getId();
    }

    public static interface GetHolyArmorsResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        List<AchievementHandler.HolyArmor> getHolyArmorsList();

        AchievementHandler.HolyArmor getHolyArmors(int param1Int);

        int getHolyArmorsCount();

        List<? extends AchievementHandler.HolyArmorOrBuilder> getHolyArmorsOrBuilderList();

        AchievementHandler.HolyArmorOrBuilder getHolyArmorsOrBuilder(int param1Int);
    }

    public static interface GetHolyArmorsRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface HolyArmorOrBuilder extends MessageOrBuilder {
        boolean hasId();

        int getId();

        boolean hasStates();

        int getStates();
    }

    public static interface OnAchievementPushOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CId();

        int getS2CId();

        List<AchievementHandler.Achievement> getS2CAchievementsList();

        AchievementHandler.Achievement getS2CAchievements(int param1Int);

        int getS2CAchievementsCount();

        List<? extends AchievementHandler.AchievementOrBuilder> getS2CAchievementsOrBuilderList();

        AchievementHandler.AchievementOrBuilder getS2CAchievementsOrBuilder(int param1Int);
    }

    public static interface AchievementGetAwardResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface AchievementGetTypeElementResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        List<AchievementHandler.Achievement> getS2CAchievementsList();

        AchievementHandler.Achievement getS2CAchievements(int param1Int);

        int getS2CAchievementsCount();

        List<? extends AchievementHandler.AchievementOrBuilder> getS2CAchievementsOrBuilderList();

        AchievementHandler.AchievementOrBuilder getS2CAchievementsOrBuilder(int param1Int);

        boolean hasS2CRewardCount();

        int getS2CRewardCount();

        boolean hasS2CRewardStatus();

        int getS2CRewardStatus();

        List<Integer> getS2COpenedChapterList();

        int getS2COpenedChapterCount();

        int getS2COpenedChapter(int param1Int);

        List<ItemOuterClass.MiniItem> getS2CChestViewList();

        ItemOuterClass.MiniItem getS2CChestView(int param1Int);

        int getS2CChestViewCount();

        List<? extends ItemOuterClass.MiniItemOrBuilder> getS2CChestViewOrBuilderList();

        ItemOuterClass.MiniItemOrBuilder getS2CChestViewOrBuilder(int param1Int);
    }

    public static interface AchievementOrBuilder extends MessageOrBuilder {
        boolean hasId();

        int getId();

        boolean hasScheduleCurr();

        int getScheduleCurr();

        boolean hasStatus();

        int getStatus();
    }

    public static interface AchievementGetAwardRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2SId();

        int getC2SId();

        boolean hasC2SType();

        int getC2SType();
    }

    public static interface AchievementGetTypeElementRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2SId();

        int getC2SId();
    }
}


