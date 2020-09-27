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


public final class PetNewHandler {
    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static final class GetAllPetsInfoRequest
            extends GeneratedMessage
            implements GetAllPetsInfoRequestOrBuilder {
        private static final GetAllPetsInfoRequest defaultInstance = new GetAllPetsInfoRequest(true);
        private final UnknownFieldSet unknownFields;

        private GetAllPetsInfoRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetAllPetsInfoRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetAllPetsInfoRequest getDefaultInstance() {
            return defaultInstance;
        }

        public GetAllPetsInfoRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetAllPetsInfoRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return PetNewHandler.internal_static_pomelo_area_GetAllPetsInfoRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return PetNewHandler.internal_static_pomelo_area_GetAllPetsInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetAllPetsInfoRequest.class, Builder.class);
        }

        public static Parser<GetAllPetsInfoRequest> PARSER = (Parser<GetAllPetsInfoRequest>) new AbstractParser<GetAllPetsInfoRequest>() {
            public PetNewHandler.GetAllPetsInfoRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PetNewHandler.GetAllPetsInfoRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetAllPetsInfoRequest> getParserForType() {
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

        public static GetAllPetsInfoRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetAllPetsInfoRequest) PARSER.parseFrom(data);
        }

        public static GetAllPetsInfoRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetAllPetsInfoRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetAllPetsInfoRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetAllPetsInfoRequest) PARSER.parseFrom(data);
        }

        public static GetAllPetsInfoRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetAllPetsInfoRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetAllPetsInfoRequest parseFrom(InputStream input) throws IOException {
            return (GetAllPetsInfoRequest) PARSER.parseFrom(input);
        }

        public static GetAllPetsInfoRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetAllPetsInfoRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static GetAllPetsInfoRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (GetAllPetsInfoRequest) PARSER.parseDelimitedFrom(input);
        }

        public static GetAllPetsInfoRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetAllPetsInfoRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static GetAllPetsInfoRequest parseFrom(CodedInputStream input) throws IOException {
            return (GetAllPetsInfoRequest) PARSER.parseFrom(input);
        }

        public static GetAllPetsInfoRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetAllPetsInfoRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(GetAllPetsInfoRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements PetNewHandler.GetAllPetsInfoRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return PetNewHandler.internal_static_pomelo_area_GetAllPetsInfoRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PetNewHandler.internal_static_pomelo_area_GetAllPetsInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(PetNewHandler.GetAllPetsInfoRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PetNewHandler.GetAllPetsInfoRequest.alwaysUseFieldBuilders) ;
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
                return PetNewHandler.internal_static_pomelo_area_GetAllPetsInfoRequest_descriptor;
            }

            public PetNewHandler.GetAllPetsInfoRequest getDefaultInstanceForType() {
                return PetNewHandler.GetAllPetsInfoRequest.getDefaultInstance();
            }

            public PetNewHandler.GetAllPetsInfoRequest build() {
                PetNewHandler.GetAllPetsInfoRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public PetNewHandler.GetAllPetsInfoRequest buildPartial() {
                PetNewHandler.GetAllPetsInfoRequest result = new PetNewHandler.GetAllPetsInfoRequest(this);
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof PetNewHandler.GetAllPetsInfoRequest)
                    return mergeFrom((PetNewHandler.GetAllPetsInfoRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PetNewHandler.GetAllPetsInfoRequest other) {
                if (other == PetNewHandler.GetAllPetsInfoRequest.getDefaultInstance()) return this;
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                PetNewHandler.GetAllPetsInfoRequest parsedMessage = null;
                try {
                    parsedMessage = (PetNewHandler.GetAllPetsInfoRequest) PetNewHandler.GetAllPetsInfoRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (PetNewHandler.GetAllPetsInfoRequest) e.getUnfinishedMessage();
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


    public static final class SkillDataInfo
            extends GeneratedMessage
            implements SkillDataInfoOrBuilder {
        private final UnknownFieldSet unknownFields;


        private SkillDataInfo(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }


        private SkillDataInfo(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }


        public static SkillDataInfo getDefaultInstance() {
            return defaultInstance;
        }


        public SkillDataInfo getDefaultInstanceForType() {
            return defaultInstance;
        }


        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }


        private SkillDataInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.level_ = input.readInt32();
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.pos_ = input.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.inborn_ = input.readInt32();
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
            return PetNewHandler.internal_static_pomelo_area_SkillDataInfo_descriptor;
        }


        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return PetNewHandler.internal_static_pomelo_area_SkillDataInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SkillDataInfo.class, Builder.class);
        }


        public static Parser<SkillDataInfo> PARSER = (Parser<SkillDataInfo>) new AbstractParser<SkillDataInfo>() {
            public PetNewHandler.SkillDataInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PetNewHandler.SkillDataInfo(input, extensionRegistry);
            }
        };


        private int bitField0_;


        public static final int ID_FIELD_NUMBER = 1;


        private int id_;


        public static final int LEVEL_FIELD_NUMBER = 2;


        private int level_;


        public static final int POS_FIELD_NUMBER = 3;


        private int pos_;


        public static final int INBORN_FIELD_NUMBER = 4;


        private int inborn_;


        private byte memoizedIsInitialized;


        private int memoizedSerializedSize;


        private static final long serialVersionUID = 0L;


        public Parser<SkillDataInfo> getParserForType() {
            return PARSER;
        }


        public boolean hasId() {
            return ((this.bitField0_ & 0x1) == 1);
        }


        public int getId() {
            return this.id_;
        }


        public boolean hasLevel() {
            return ((this.bitField0_ & 0x2) == 2);
        }


        public int getLevel() {
            return this.level_;
        }


        public boolean hasPos() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public int getPos() {
            return this.pos_;
        }


        public boolean hasInborn() {
            return ((this.bitField0_ & 0x8) == 8);
        }


        public int getInborn() {
            return this.inborn_;
        }


        private void initFields() {
            this.id_ = 0;
            this.level_ = 0;
            this.pos_ = 0;
            this.inborn_ = 0;
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
            if (!hasLevel()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasPos()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasInborn()) {
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
                output.writeInt32(2, this.level_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeInt32(3, this.pos_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                output.writeInt32(4, this.inborn_);
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
                size += CodedOutputStream.computeInt32Size(2, this.level_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                size += CodedOutputStream.computeInt32Size(3, this.pos_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                size += CodedOutputStream.computeInt32Size(4, this.inborn_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static SkillDataInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (SkillDataInfo) PARSER.parseFrom(data);
        }


        public static SkillDataInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SkillDataInfo) PARSER.parseFrom(data, extensionRegistry);
        }


        public static SkillDataInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (SkillDataInfo) PARSER.parseFrom(data);
        }


        private static final SkillDataInfo defaultInstance = new SkillDataInfo(true);

        public static SkillDataInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SkillDataInfo) PARSER.parseFrom(data, extensionRegistry);
        }

        public static SkillDataInfo parseFrom(InputStream input) throws IOException {
            return (SkillDataInfo) PARSER.parseFrom(input);
        }

        public static SkillDataInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SkillDataInfo) PARSER.parseFrom(input, extensionRegistry);
        }

        public static SkillDataInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (SkillDataInfo) PARSER.parseDelimitedFrom(input);
        }

        public static SkillDataInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SkillDataInfo) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static SkillDataInfo parseFrom(CodedInputStream input) throws IOException {
            return (SkillDataInfo) PARSER.parseFrom(input);
        }

        public static SkillDataInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SkillDataInfo) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(SkillDataInfo prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements PetNewHandler.SkillDataInfoOrBuilder {
            private int bitField0_;
            private int id_;
            private int level_;
            private int pos_;
            private int inborn_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PetNewHandler.internal_static_pomelo_area_SkillDataInfo_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PetNewHandler.internal_static_pomelo_area_SkillDataInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(PetNewHandler.SkillDataInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PetNewHandler.SkillDataInfo.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.id_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.level_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                this.pos_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.inborn_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return PetNewHandler.internal_static_pomelo_area_SkillDataInfo_descriptor;
            }

            public PetNewHandler.SkillDataInfo getDefaultInstanceForType() {
                return PetNewHandler.SkillDataInfo.getDefaultInstance();
            }

            public PetNewHandler.SkillDataInfo build() {
                PetNewHandler.SkillDataInfo result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public PetNewHandler.SkillDataInfo buildPartial() {
                PetNewHandler.SkillDataInfo result = new PetNewHandler.SkillDataInfo(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.id_ = this.id_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.level_ = this.level_;
                if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;
                result.pos_ = this.pos_;
                if ((from_bitField0_ & 0x8) == 8) to_bitField0_ |= 0x8;
                result.inborn_ = this.inborn_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof PetNewHandler.SkillDataInfo) return mergeFrom((PetNewHandler.SkillDataInfo) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PetNewHandler.SkillDataInfo other) {
                if (other == PetNewHandler.SkillDataInfo.getDefaultInstance()) return this;
                if (other.hasId()) setId(other.getId());
                if (other.hasLevel()) setLevel(other.getLevel());
                if (other.hasPos()) setPos(other.getPos());
                if (other.hasInborn()) setInborn(other.getInborn());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasId()) return false;
                if (!hasLevel()) return false;
                if (!hasPos()) return false;
                if (!hasInborn()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                PetNewHandler.SkillDataInfo parsedMessage = null;
                try {
                    parsedMessage = (PetNewHandler.SkillDataInfo) PetNewHandler.SkillDataInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (PetNewHandler.SkillDataInfo) e.getUnfinishedMessage();
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

            public boolean hasLevel() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getLevel() {
                return this.level_;
            }

            public Builder setLevel(int value) {
                this.bitField0_ |= 0x2;
                this.level_ = value;
                onChanged();
                return this;
            }

            public Builder clearLevel() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.level_ = 0;
                onChanged();
                return this;
            }

            public boolean hasPos() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public int getPos() {
                return this.pos_;
            }

            public Builder setPos(int value) {
                this.bitField0_ |= 0x4;
                this.pos_ = value;
                onChanged();
                return this;
            }

            public Builder clearPos() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.pos_ = 0;
                onChanged();
                return this;
            }

            public boolean hasInborn() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public int getInborn() {
                return this.inborn_;
            }

            public Builder setInborn(int value) {
                this.bitField0_ |= 0x8;
                this.inborn_ = value;
                onChanged();
                return this;
            }

            public Builder clearInborn() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.inborn_ = 0;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class PetDataInfo
            extends GeneratedMessage
            implements PetDataInfoOrBuilder {
        private static final PetDataInfo defaultInstance = new PetDataInfo(true);
        private final UnknownFieldSet unknownFields;

        private PetDataInfo(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private PetDataInfo(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static PetDataInfo getDefaultInstance() {
            return defaultInstance;
        }

        public PetDataInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PetDataInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.level_ = input.readInt32();
                            break;
                        case 26:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x4;
                            this.name_ = bs;
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.exp_ = input.readInt64();
                            break;
                        case 42:
                            if ((mutable_bitField0_ & 0x10) != 16) {
                                this.attrsFinal_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x10;
                            }
                            this.attrsFinal_.add(input.readMessage(Common.AttributeSimple.PARSER, extensionRegistry));
                            break;
                        case 58:
                            if ((mutable_bitField0_ & 0x20) != 32) {
                                this.skills_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x20;
                            }
                            this.skills_.add(input.readMessage(PetNewHandler.SkillDataInfo.PARSER, extensionRegistry));
                            break;
                        case 64:
                            this.bitField0_ |= 0x10;
                            this.upLevel_ = input.readInt32();
                            break;
                        case 72:
                            this.bitField0_ |= 0x20;
                            this.fightPower_ = input.readInt32();
                            break;
                        case 82:
                            if ((mutable_bitField0_ & 0x100) != 256) {
                                this.nextAttrsFinal_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x100;
                            }
                            this.nextAttrsFinal_.add(input.readMessage(Common.AttributeSimple.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x10) == 16)
                    this.attrsFinal_ = Collections.unmodifiableList(this.attrsFinal_);
                if ((mutable_bitField0_ & 0x20) == 32) this.skills_ = Collections.unmodifiableList(this.skills_);
                if ((mutable_bitField0_ & 0x100) == 256)
                    this.nextAttrsFinal_ = Collections.unmodifiableList(this.nextAttrsFinal_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return PetNewHandler.internal_static_pomelo_area_PetDataInfo_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return PetNewHandler.internal_static_pomelo_area_PetDataInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(PetDataInfo.class, Builder.class);
        }

        public static Parser<PetDataInfo> PARSER = (Parser<PetDataInfo>) new AbstractParser<PetDataInfo>() {
            public PetNewHandler.PetDataInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PetNewHandler.PetDataInfo(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int ID_FIELD_NUMBER = 1;
        private int id_;
        public static final int LEVEL_FIELD_NUMBER = 2;
        private int level_;
        public static final int NAME_FIELD_NUMBER = 3;
        private Object name_;
        public static final int EXP_FIELD_NUMBER = 4;
        private long exp_;
        public static final int ATTRS_FINAL_FIELD_NUMBER = 5;
        private List<Common.AttributeSimple> attrsFinal_;
        public static final int SKILLS_FIELD_NUMBER = 7;
        private List<PetNewHandler.SkillDataInfo> skills_;
        public static final int UPLEVEL_FIELD_NUMBER = 8;
        private int upLevel_;
        public static final int FIGHTPOWER_FIELD_NUMBER = 9;
        private int fightPower_;
        public static final int NEXT_ATTRS_FINAL_FIELD_NUMBER = 10;
        private List<Common.AttributeSimple> nextAttrsFinal_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<PetDataInfo> getParserForType() {
            return PARSER;
        }

        public boolean hasId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getId() {
            return this.id_;
        }

        public boolean hasLevel() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public int getLevel() {
            return this.level_;
        }

        public boolean hasName() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public String getName() {
            Object ref = this.name_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.name_ = s;
            return s;
        }

        public ByteString getNameBytes() {
            Object ref = this.name_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.name_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasExp() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        static {
            defaultInstance.initFields();
        }

        public long getExp() {
            return this.exp_;
        }

        public List<Common.AttributeSimple> getAttrsFinalList() {
            return this.attrsFinal_;
        }

        public List<? extends Common.AttributeSimpleOrBuilder> getAttrsFinalOrBuilderList() {
            return (List) this.attrsFinal_;
        }

        public int getAttrsFinalCount() {
            return this.attrsFinal_.size();
        }

        public Common.AttributeSimple getAttrsFinal(int index) {
            return this.attrsFinal_.get(index);
        }

        public Common.AttributeSimpleOrBuilder getAttrsFinalOrBuilder(int index) {
            return (Common.AttributeSimpleOrBuilder) this.attrsFinal_.get(index);
        }

        public List<PetNewHandler.SkillDataInfo> getSkillsList() {
            return this.skills_;
        }

        public List<? extends PetNewHandler.SkillDataInfoOrBuilder> getSkillsOrBuilderList() {
            return (List) this.skills_;
        }

        public int getSkillsCount() {
            return this.skills_.size();
        }

        public PetNewHandler.SkillDataInfo getSkills(int index) {
            return this.skills_.get(index);
        }

        public PetNewHandler.SkillDataInfoOrBuilder getSkillsOrBuilder(int index) {
            return this.skills_.get(index);
        }

        public boolean hasUpLevel() {
            return ((this.bitField0_ & 0x10) == 16);
        }

        public int getUpLevel() {
            return this.upLevel_;
        }

        public boolean hasFightPower() {
            return ((this.bitField0_ & 0x20) == 32);
        }

        public int getFightPower() {
            return this.fightPower_;
        }

        public List<Common.AttributeSimple> getNextAttrsFinalList() {
            return this.nextAttrsFinal_;
        }

        public List<? extends Common.AttributeSimpleOrBuilder> getNextAttrsFinalOrBuilderList() {
            return (List) this.nextAttrsFinal_;
        }

        public int getNextAttrsFinalCount() {
            return this.nextAttrsFinal_.size();
        }

        public Common.AttributeSimple getNextAttrsFinal(int index) {
            return this.nextAttrsFinal_.get(index);
        }

        public Common.AttributeSimpleOrBuilder getNextAttrsFinalOrBuilder(int index) {
            return (Common.AttributeSimpleOrBuilder) this.nextAttrsFinal_.get(index);
        }

        private void initFields() {
            this.id_ = 0;
            this.level_ = 0;
            this.name_ = "";
            this.exp_ = 0L;
            this.attrsFinal_ = Collections.emptyList();
            this.skills_ = Collections.emptyList();
            this.upLevel_ = 0;
            this.fightPower_ = 0;
            this.nextAttrsFinal_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1)
                return true;
            if (isInitialized == 0)
                return false;
            if (!hasId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasLevel()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasName()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasExp()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasUpLevel()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasFightPower()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            int i;
            for (i = 0; i < getAttrsFinalCount(); i++) {
                if (!getAttrsFinal(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (i = 0; i < getSkillsCount(); i++) {
                if (!getSkills(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (i = 0; i < getNextAttrsFinalCount(); i++) {
                if (!getNextAttrsFinal(i).isInitialized()) {
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
                output.writeInt32(1, this.id_);
            if ((this.bitField0_ & 0x2) == 2)
                output.writeInt32(2, this.level_);
            if ((this.bitField0_ & 0x4) == 4)
                output.writeBytes(3, getNameBytes());
            if ((this.bitField0_ & 0x8) == 8)
                output.writeInt64(4, this.exp_);
            int i;
            for (i = 0; i < this.attrsFinal_.size(); i++)
                output.writeMessage(5, (MessageLite) this.attrsFinal_.get(i));
            for (i = 0; i < this.skills_.size(); i++)
                output.writeMessage(7, (MessageLite) this.skills_.get(i));
            if ((this.bitField0_ & 0x10) == 16)
                output.writeInt32(8, this.upLevel_);
            if ((this.bitField0_ & 0x20) == 32)
                output.writeInt32(9, this.fightPower_);
            for (i = 0; i < this.nextAttrsFinal_.size(); i++)
                output.writeMessage(10, (MessageLite) this.nextAttrsFinal_.get(i));
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1)
                return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1)
                size += CodedOutputStream.computeInt32Size(1, this.id_);
            if ((this.bitField0_ & 0x2) == 2)
                size += CodedOutputStream.computeInt32Size(2, this.level_);
            if ((this.bitField0_ & 0x4) == 4)
                size += CodedOutputStream.computeBytesSize(3, getNameBytes());
            if ((this.bitField0_ & 0x8) == 8)
                size += CodedOutputStream.computeInt64Size(4, this.exp_);
            int i;
            for (i = 0; i < this.attrsFinal_.size(); i++)
                size += CodedOutputStream.computeMessageSize(5, (MessageLite) this.attrsFinal_.get(i));
            for (i = 0; i < this.skills_.size(); i++)
                size += CodedOutputStream.computeMessageSize(7, (MessageLite) this.skills_.get(i));
            if ((this.bitField0_ & 0x10) == 16)
                size += CodedOutputStream.computeInt32Size(8, this.upLevel_);
            if ((this.bitField0_ & 0x20) == 32)
                size += CodedOutputStream.computeInt32Size(9, this.fightPower_);
            for (i = 0; i < this.nextAttrsFinal_.size(); i++)
                size += CodedOutputStream.computeMessageSize(10, (MessageLite) this.nextAttrsFinal_.get(i));
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static PetDataInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (PetDataInfo) PARSER.parseFrom(data);
        }

        public static PetDataInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (PetDataInfo) PARSER.parseFrom(data, extensionRegistry);
        }

        public static PetDataInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (PetDataInfo) PARSER.parseFrom(data);
        }

        public static PetDataInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (PetDataInfo) PARSER.parseFrom(data, extensionRegistry);
        }

        public static PetDataInfo parseFrom(InputStream input) throws IOException {
            return (PetDataInfo) PARSER.parseFrom(input);
        }

        public static PetDataInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PetDataInfo) PARSER.parseFrom(input, extensionRegistry);
        }

        public static PetDataInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (PetDataInfo) PARSER.parseDelimitedFrom(input);
        }

        public static PetDataInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PetDataInfo) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static PetDataInfo parseFrom(CodedInputStream input) throws IOException {
            return (PetDataInfo) PARSER.parseFrom(input);
        }

        public static PetDataInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PetDataInfo) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(PetDataInfo prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements PetNewHandler.PetDataInfoOrBuilder {
            private int bitField0_;
            private int id_;
            private int level_;
            private Object name_;
            private long exp_;
            private List<Common.AttributeSimple> attrsFinal_;
            private RepeatedFieldBuilder<Common.AttributeSimple, Common.AttributeSimple.Builder, Common.AttributeSimpleOrBuilder> attrsFinalBuilder_;
            private List<PetNewHandler.SkillDataInfo> skills_;
            private RepeatedFieldBuilder<PetNewHandler.SkillDataInfo, PetNewHandler.SkillDataInfo.Builder, PetNewHandler.SkillDataInfoOrBuilder> skillsBuilder_;
            private int upLevel_;
            private int fightPower_;
            private List<Common.AttributeSimple> nextAttrsFinal_;
            private RepeatedFieldBuilder<Common.AttributeSimple, Common.AttributeSimple.Builder, Common.AttributeSimpleOrBuilder> nextAttrsFinalBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PetNewHandler.internal_static_pomelo_area_PetDataInfo_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PetNewHandler.internal_static_pomelo_area_PetDataInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(PetNewHandler.PetDataInfo.class, Builder.class);
            }

            private Builder() {
                this.name_ = "";
                this.attrsFinal_ = Collections.emptyList();
                this.skills_ = Collections.emptyList();
                this.nextAttrsFinal_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.name_ = "";
                this.attrsFinal_ = Collections.emptyList();
                this.skills_ = Collections.emptyList();
                this.nextAttrsFinal_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PetNewHandler.PetDataInfo.alwaysUseFieldBuilders) {
                    getAttrsFinalFieldBuilder();
                    getSkillsFieldBuilder();
                    getNextAttrsFinalFieldBuilder();
                }
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.id_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.level_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                this.name_ = "";
                this.bitField0_ &= 0xFFFFFFFB;
                this.exp_ = 0L;
                this.bitField0_ &= 0xFFFFFFF7;
                if (this.attrsFinalBuilder_ == null) {
                    this.attrsFinal_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFEF;
                } else {
                    this.attrsFinalBuilder_.clear();
                }
                if (this.skillsBuilder_ == null) {
                    this.skills_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFDF;
                } else {
                    this.skillsBuilder_.clear();
                }
                this.upLevel_ = 0;
                this.bitField0_ &= 0xFFFFFFBF;
                this.fightPower_ = 0;
                this.bitField0_ &= 0xFFFFFF7F;
                if (this.nextAttrsFinalBuilder_ == null) {
                    this.nextAttrsFinal_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFEFF;
                } else {
                    this.nextAttrsFinalBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return PetNewHandler.internal_static_pomelo_area_PetDataInfo_descriptor;
            }

            public PetNewHandler.PetDataInfo getDefaultInstanceForType() {
                return PetNewHandler.PetDataInfo.getDefaultInstance();
            }

            public PetNewHandler.PetDataInfo build() {
                PetNewHandler.PetDataInfo result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public PetNewHandler.PetDataInfo buildPartial() {
                PetNewHandler.PetDataInfo result = new PetNewHandler.PetDataInfo(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.id_ = this.id_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.level_ = this.level_;
                if ((from_bitField0_ & 0x4) == 4)
                    to_bitField0_ |= 0x4;
                result.name_ = this.name_;
                if ((from_bitField0_ & 0x8) == 8)
                    to_bitField0_ |= 0x8;
                result.exp_ = this.exp_;
                if (this.attrsFinalBuilder_ == null) {
                    if ((this.bitField0_ & 0x10) == 16) {
                        this.attrsFinal_ = Collections.unmodifiableList(this.attrsFinal_);
                        this.bitField0_ &= 0xFFFFFFEF;
                    }
                    result.attrsFinal_ = this.attrsFinal_;
                } else {
                    result.attrsFinal_ = this.attrsFinalBuilder_.build();
                }
                if (this.skillsBuilder_ == null) {
                    if ((this.bitField0_ & 0x20) == 32) {
                        this.skills_ = Collections.unmodifiableList(this.skills_);
                        this.bitField0_ &= 0xFFFFFFDF;
                    }
                    result.skills_ = this.skills_;
                } else {
                    result.skills_ = this.skillsBuilder_.build();
                }
                if ((from_bitField0_ & 0x40) == 64)
                    to_bitField0_ |= 0x10;
                result.upLevel_ = this.upLevel_;
                if ((from_bitField0_ & 0x80) == 128)
                    to_bitField0_ |= 0x20;
                result.fightPower_ = this.fightPower_;
                if (this.nextAttrsFinalBuilder_ == null) {
                    if ((this.bitField0_ & 0x100) == 256) {
                        this.nextAttrsFinal_ = Collections.unmodifiableList(this.nextAttrsFinal_);
                        this.bitField0_ &= 0xFFFFFEFF;
                    }
                    result.nextAttrsFinal_ = this.nextAttrsFinal_;
                } else {
                    result.nextAttrsFinal_ = this.nextAttrsFinalBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof PetNewHandler.PetDataInfo)
                    return mergeFrom((PetNewHandler.PetDataInfo) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PetNewHandler.PetDataInfo other) {
                if (other == PetNewHandler.PetDataInfo.getDefaultInstance())
                    return this;
                if (other.hasId())
                    setId(other.getId());
                if (other.hasLevel())
                    setLevel(other.getLevel());
                if (other.hasName()) {
                    this.bitField0_ |= 0x4;
                    this.name_ = other.name_;
                    onChanged();
                }
                if (other.hasExp())
                    setExp(other.getExp());
                if (this.attrsFinalBuilder_ == null) {
                    if (!other.attrsFinal_.isEmpty()) {
                        if (this.attrsFinal_.isEmpty()) {
                            this.attrsFinal_ = other.attrsFinal_;
                            this.bitField0_ &= 0xFFFFFFEF;
                        } else {
                            ensureAttrsFinalIsMutable();
                            this.attrsFinal_.addAll(other.attrsFinal_);
                        }
                        onChanged();
                    }
                } else if (!other.attrsFinal_.isEmpty()) {
                    if (this.attrsFinalBuilder_.isEmpty()) {
                        this.attrsFinalBuilder_.dispose();
                        this.attrsFinalBuilder_ = null;
                        this.attrsFinal_ = other.attrsFinal_;
                        this.bitField0_ &= 0xFFFFFFEF;
                        this.attrsFinalBuilder_ = PetNewHandler.PetDataInfo.alwaysUseFieldBuilders ? getAttrsFinalFieldBuilder() : null;
                    } else {
                        this.attrsFinalBuilder_.addAllMessages(other.attrsFinal_);
                    }
                }
                if (this.skillsBuilder_ == null) {
                    if (!other.skills_.isEmpty()) {
                        if (this.skills_.isEmpty()) {
                            this.skills_ = other.skills_;
                            this.bitField0_ &= 0xFFFFFFDF;
                        } else {
                            ensureSkillsIsMutable();
                            this.skills_.addAll(other.skills_);
                        }
                        onChanged();
                    }
                } else if (!other.skills_.isEmpty()) {
                    if (this.skillsBuilder_.isEmpty()) {
                        this.skillsBuilder_.dispose();
                        this.skillsBuilder_ = null;
                        this.skills_ = other.skills_;
                        this.bitField0_ &= 0xFFFFFFDF;
                        this.skillsBuilder_ = PetNewHandler.PetDataInfo.alwaysUseFieldBuilders ? getSkillsFieldBuilder() : null;
                    } else {
                        this.skillsBuilder_.addAllMessages(other.skills_);
                    }
                }
                if (other.hasUpLevel())
                    setUpLevel(other.getUpLevel());
                if (other.hasFightPower())
                    setFightPower(other.getFightPower());
                if (this.nextAttrsFinalBuilder_ == null) {
                    if (!other.nextAttrsFinal_.isEmpty()) {
                        if (this.nextAttrsFinal_.isEmpty()) {
                            this.nextAttrsFinal_ = other.nextAttrsFinal_;
                            this.bitField0_ &= 0xFFFFFEFF;
                        } else {
                            ensureNextAttrsFinalIsMutable();
                            this.nextAttrsFinal_.addAll(other.nextAttrsFinal_);
                        }
                        onChanged();
                    }
                } else if (!other.nextAttrsFinal_.isEmpty()) {
                    if (this.nextAttrsFinalBuilder_.isEmpty()) {
                        this.nextAttrsFinalBuilder_.dispose();
                        this.nextAttrsFinalBuilder_ = null;
                        this.nextAttrsFinal_ = other.nextAttrsFinal_;
                        this.bitField0_ &= 0xFFFFFEFF;
                        this.nextAttrsFinalBuilder_ = PetNewHandler.PetDataInfo.alwaysUseFieldBuilders ? getNextAttrsFinalFieldBuilder() : null;
                    } else {
                        this.nextAttrsFinalBuilder_.addAllMessages(other.nextAttrsFinal_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasId())
                    return false;
                if (!hasLevel())
                    return false;
                if (!hasName())
                    return false;
                if (!hasExp())
                    return false;
                if (!hasUpLevel())
                    return false;
                if (!hasFightPower())
                    return false;
                int i;
                for (i = 0; i < getAttrsFinalCount(); i++) {
                    if (!getAttrsFinal(i).isInitialized())
                        return false;
                }
                for (i = 0; i < getSkillsCount(); i++) {
                    if (!getSkills(i).isInitialized())
                        return false;
                }
                for (i = 0; i < getNextAttrsFinalCount(); i++) {
                    if (!getNextAttrsFinal(i).isInitialized())
                        return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                PetNewHandler.PetDataInfo parsedMessage = null;
                try {
                    parsedMessage = (PetNewHandler.PetDataInfo) PetNewHandler.PetDataInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (PetNewHandler.PetDataInfo) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null)
                        mergeFrom(parsedMessage);
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

            public boolean hasLevel() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getLevel() {
                return this.level_;
            }

            public Builder setLevel(int value) {
                this.bitField0_ |= 0x2;
                this.level_ = value;
                onChanged();
                return this;
            }

            public Builder clearLevel() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.level_ = 0;
                onChanged();
                return this;
            }

            public boolean hasName() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public String getName() {
                Object ref = this.name_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.name_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getNameBytes() {
                Object ref = this.name_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.name_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setName(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x4;
                this.name_ = value;
                onChanged();
                return this;
            }

            public Builder clearName() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.name_ = PetNewHandler.PetDataInfo.getDefaultInstance().getName();
                onChanged();
                return this;
            }

            public Builder setNameBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x4;
                this.name_ = value;
                onChanged();
                return this;
            }

            public boolean hasExp() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public long getExp() {
                return this.exp_;
            }

            public Builder setExp(long value) {
                this.bitField0_ |= 0x8;
                this.exp_ = value;
                onChanged();
                return this;
            }

            public Builder clearExp() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.exp_ = 0L;
                onChanged();
                return this;
            }

            private void ensureAttrsFinalIsMutable() {
                if ((this.bitField0_ & 0x10) != 16) {
                    this.attrsFinal_ = new ArrayList<>(this.attrsFinal_);
                    this.bitField0_ |= 0x10;
                }
            }

            public List<Common.AttributeSimple> getAttrsFinalList() {
                if (this.attrsFinalBuilder_ == null)
                    return Collections.unmodifiableList(this.attrsFinal_);
                return this.attrsFinalBuilder_.getMessageList();
            }

            public int getAttrsFinalCount() {
                if (this.attrsFinalBuilder_ == null)
                    return this.attrsFinal_.size();
                return this.attrsFinalBuilder_.getCount();
            }

            public Common.AttributeSimple getAttrsFinal(int index) {
                if (this.attrsFinalBuilder_ == null)
                    return this.attrsFinal_.get(index);
                return (Common.AttributeSimple) this.attrsFinalBuilder_.getMessage(index);
            }

            public Builder setAttrsFinal(int index, Common.AttributeSimple value) {
                if (this.attrsFinalBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureAttrsFinalIsMutable();
                    this.attrsFinal_.set(index, value);
                    onChanged();
                } else {
                    this.attrsFinalBuilder_.setMessage(index, (GeneratedMessage) value);
                }
                return this;
            }

            public Builder setAttrsFinal(int index, Common.AttributeSimple.Builder builderForValue) {
                if (this.attrsFinalBuilder_ == null) {
                    ensureAttrsFinalIsMutable();
                    this.attrsFinal_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.attrsFinalBuilder_.setMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addAttrsFinal(Common.AttributeSimple value) {
                if (this.attrsFinalBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureAttrsFinalIsMutable();
                    this.attrsFinal_.add(value);
                    onChanged();
                } else {
                    this.attrsFinalBuilder_.addMessage((GeneratedMessage) value);
                }
                return this;
            }

            public Builder addAttrsFinal(int index, Common.AttributeSimple value) {
                if (this.attrsFinalBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureAttrsFinalIsMutable();
                    this.attrsFinal_.add(index, value);
                    onChanged();
                } else {
                    this.attrsFinalBuilder_.addMessage(index, (GeneratedMessage) value);
                }
                return this;
            }

            public Builder addAttrsFinal(Common.AttributeSimple.Builder builderForValue) {
                if (this.attrsFinalBuilder_ == null) {
                    ensureAttrsFinalIsMutable();
                    this.attrsFinal_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.attrsFinalBuilder_.addMessage((GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addAttrsFinal(int index, Common.AttributeSimple.Builder builderForValue) {
                if (this.attrsFinalBuilder_ == null) {
                    ensureAttrsFinalIsMutable();
                    this.attrsFinal_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.attrsFinalBuilder_.addMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addAllAttrsFinal(Iterable<? extends Common.AttributeSimple> values) {
                if (this.attrsFinalBuilder_ == null) {
                    ensureAttrsFinalIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.attrsFinal_);
                    onChanged();
                } else {
                    this.attrsFinalBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearAttrsFinal() {
                if (this.attrsFinalBuilder_ == null) {
                    this.attrsFinal_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFEF;
                    onChanged();
                } else {
                    this.attrsFinalBuilder_.clear();
                }
                return this;
            }

            public Builder removeAttrsFinal(int index) {
                if (this.attrsFinalBuilder_ == null) {
                    ensureAttrsFinalIsMutable();
                    this.attrsFinal_.remove(index);
                    onChanged();
                } else {
                    this.attrsFinalBuilder_.remove(index);
                }
                return this;
            }

            public Common.AttributeSimple.Builder getAttrsFinalBuilder(int index) {
                return (Common.AttributeSimple.Builder) getAttrsFinalFieldBuilder().getBuilder(index);
            }

            public Common.AttributeSimpleOrBuilder getAttrsFinalOrBuilder(int index) {
                if (this.attrsFinalBuilder_ == null)
                    return (Common.AttributeSimpleOrBuilder) this.attrsFinal_.get(index);
                return (Common.AttributeSimpleOrBuilder) this.attrsFinalBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends Common.AttributeSimpleOrBuilder> getAttrsFinalOrBuilderList() {
                if (this.attrsFinalBuilder_ != null)
                    return this.attrsFinalBuilder_.getMessageOrBuilderList();
                return (List) Collections.unmodifiableList(this.attrsFinal_);
            }

            public Common.AttributeSimple.Builder addAttrsFinalBuilder() {
                return (Common.AttributeSimple.Builder) getAttrsFinalFieldBuilder().addBuilder((GeneratedMessage) Common.AttributeSimple.getDefaultInstance());
            }

            public Common.AttributeSimple.Builder addAttrsFinalBuilder(int index) {
                return (Common.AttributeSimple.Builder) getAttrsFinalFieldBuilder().addBuilder(index, (GeneratedMessage) Common.AttributeSimple.getDefaultInstance());
            }

            public List<Common.AttributeSimple.Builder> getAttrsFinalBuilderList() {
                return getAttrsFinalFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<Common.AttributeSimple, Common.AttributeSimple.Builder, Common.AttributeSimpleOrBuilder> getAttrsFinalFieldBuilder() {
                if (this.attrsFinalBuilder_ == null) {
                    this.attrsFinalBuilder_ = new RepeatedFieldBuilder(this.attrsFinal_, ((this.bitField0_ & 0x10) == 16), getParentForChildren(), isClean());
                    this.attrsFinal_ = null;
                }
                return this.attrsFinalBuilder_;
            }

            private void ensureSkillsIsMutable() {
                if ((this.bitField0_ & 0x20) != 32) {
                    this.skills_ = new ArrayList<>(this.skills_);
                    this.bitField0_ |= 0x20;
                }
            }

            public List<PetNewHandler.SkillDataInfo> getSkillsList() {
                if (this.skillsBuilder_ == null)
                    return Collections.unmodifiableList(this.skills_);
                return this.skillsBuilder_.getMessageList();
            }

            public int getSkillsCount() {
                if (this.skillsBuilder_ == null)
                    return this.skills_.size();
                return this.skillsBuilder_.getCount();
            }

            public PetNewHandler.SkillDataInfo getSkills(int index) {
                if (this.skillsBuilder_ == null)
                    return this.skills_.get(index);
                return (PetNewHandler.SkillDataInfo) this.skillsBuilder_.getMessage(index);
            }

            public Builder setSkills(int index, PetNewHandler.SkillDataInfo value) {
                if (this.skillsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureSkillsIsMutable();
                    this.skills_.set(index, value);
                    onChanged();
                } else {
                    this.skillsBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setSkills(int index, PetNewHandler.SkillDataInfo.Builder builderForValue) {
                if (this.skillsBuilder_ == null) {
                    ensureSkillsIsMutable();
                    this.skills_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.skillsBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addSkills(PetNewHandler.SkillDataInfo value) {
                if (this.skillsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureSkillsIsMutable();
                    this.skills_.add(value);
                    onChanged();
                } else {
                    this.skillsBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addSkills(int index, PetNewHandler.SkillDataInfo value) {
                if (this.skillsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureSkillsIsMutable();
                    this.skills_.add(index, value);
                    onChanged();
                } else {
                    this.skillsBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addSkills(PetNewHandler.SkillDataInfo.Builder builderForValue) {
                if (this.skillsBuilder_ == null) {
                    ensureSkillsIsMutable();
                    this.skills_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.skillsBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addSkills(int index, PetNewHandler.SkillDataInfo.Builder builderForValue) {
                if (this.skillsBuilder_ == null) {
                    ensureSkillsIsMutable();
                    this.skills_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.skillsBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllSkills(Iterable<? extends PetNewHandler.SkillDataInfo> values) {
                if (this.skillsBuilder_ == null) {
                    ensureSkillsIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.skills_);
                    onChanged();
                } else {
                    this.skillsBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearSkills() {
                if (this.skillsBuilder_ == null) {
                    this.skills_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFDF;
                    onChanged();
                } else {
                    this.skillsBuilder_.clear();
                }
                return this;
            }

            public Builder removeSkills(int index) {
                if (this.skillsBuilder_ == null) {
                    ensureSkillsIsMutable();
                    this.skills_.remove(index);
                    onChanged();
                } else {
                    this.skillsBuilder_.remove(index);
                }
                return this;
            }

            public PetNewHandler.SkillDataInfo.Builder getSkillsBuilder(int index) {
                return (PetNewHandler.SkillDataInfo.Builder) getSkillsFieldBuilder().getBuilder(index);
            }

            public PetNewHandler.SkillDataInfoOrBuilder getSkillsOrBuilder(int index) {
                if (this.skillsBuilder_ == null)
                    return this.skills_.get(index);
                return (PetNewHandler.SkillDataInfoOrBuilder) this.skillsBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends PetNewHandler.SkillDataInfoOrBuilder> getSkillsOrBuilderList() {
                if (this.skillsBuilder_ != null)
                    return this.skillsBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.skills_);
            }

            public PetNewHandler.SkillDataInfo.Builder addSkillsBuilder() {
                return (PetNewHandler.SkillDataInfo.Builder) getSkillsFieldBuilder().addBuilder(PetNewHandler.SkillDataInfo.getDefaultInstance());
            }

            public PetNewHandler.SkillDataInfo.Builder addSkillsBuilder(int index) {
                return (PetNewHandler.SkillDataInfo.Builder) getSkillsFieldBuilder().addBuilder(index, PetNewHandler.SkillDataInfo.getDefaultInstance());
            }

            public List<PetNewHandler.SkillDataInfo.Builder> getSkillsBuilderList() {
                return getSkillsFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<PetNewHandler.SkillDataInfo, PetNewHandler.SkillDataInfo.Builder, PetNewHandler.SkillDataInfoOrBuilder> getSkillsFieldBuilder() {
                if (this.skillsBuilder_ == null) {
                    this.skillsBuilder_ = new RepeatedFieldBuilder(this.skills_, ((this.bitField0_ & 0x20) == 32), getParentForChildren(), isClean());
                    this.skills_ = null;
                }
                return this.skillsBuilder_;
            }

            public boolean hasUpLevel() {
                return ((this.bitField0_ & 0x40) == 64);
            }

            public int getUpLevel() {
                return this.upLevel_;
            }

            public Builder setUpLevel(int value) {
                this.bitField0_ |= 0x40;
                this.upLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearUpLevel() {
                this.bitField0_ &= 0xFFFFFFBF;
                this.upLevel_ = 0;
                onChanged();
                return this;
            }

            public boolean hasFightPower() {
                return ((this.bitField0_ & 0x80) == 128);
            }

            public int getFightPower() {
                return this.fightPower_;
            }

            public Builder setFightPower(int value) {
                this.bitField0_ |= 0x80;
                this.fightPower_ = value;
                onChanged();
                return this;
            }

            public Builder clearFightPower() {
                this.bitField0_ &= 0xFFFFFF7F;
                this.fightPower_ = 0;
                onChanged();
                return this;
            }

            private void ensureNextAttrsFinalIsMutable() {
                if ((this.bitField0_ & 0x100) != 256) {
                    this.nextAttrsFinal_ = new ArrayList<>(this.nextAttrsFinal_);
                    this.bitField0_ |= 0x100;
                }
            }

            public List<Common.AttributeSimple> getNextAttrsFinalList() {
                if (this.nextAttrsFinalBuilder_ == null)
                    return Collections.unmodifiableList(this.nextAttrsFinal_);
                return this.nextAttrsFinalBuilder_.getMessageList();
            }

            public int getNextAttrsFinalCount() {
                if (this.nextAttrsFinalBuilder_ == null)
                    return this.nextAttrsFinal_.size();
                return this.nextAttrsFinalBuilder_.getCount();
            }

            public Common.AttributeSimple getNextAttrsFinal(int index) {
                if (this.nextAttrsFinalBuilder_ == null)
                    return this.nextAttrsFinal_.get(index);
                return (Common.AttributeSimple) this.nextAttrsFinalBuilder_.getMessage(index);
            }

            public Builder setNextAttrsFinal(int index, Common.AttributeSimple value) {
                if (this.nextAttrsFinalBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureNextAttrsFinalIsMutable();
                    this.nextAttrsFinal_.set(index, value);
                    onChanged();
                } else {
                    this.nextAttrsFinalBuilder_.setMessage(index, (GeneratedMessage) value);
                }
                return this;
            }

            public Builder setNextAttrsFinal(int index, Common.AttributeSimple.Builder builderForValue) {
                if (this.nextAttrsFinalBuilder_ == null) {
                    ensureNextAttrsFinalIsMutable();
                    this.nextAttrsFinal_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.nextAttrsFinalBuilder_.setMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addNextAttrsFinal(Common.AttributeSimple value) {
                if (this.nextAttrsFinalBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureNextAttrsFinalIsMutable();
                    this.nextAttrsFinal_.add(value);
                    onChanged();
                } else {
                    this.nextAttrsFinalBuilder_.addMessage((GeneratedMessage) value);
                }
                return this;
            }

            public Builder addNextAttrsFinal(int index, Common.AttributeSimple value) {
                if (this.nextAttrsFinalBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureNextAttrsFinalIsMutable();
                    this.nextAttrsFinal_.add(index, value);
                    onChanged();
                } else {
                    this.nextAttrsFinalBuilder_.addMessage(index, (GeneratedMessage) value);
                }
                return this;
            }

            public Builder addNextAttrsFinal(Common.AttributeSimple.Builder builderForValue) {
                if (this.nextAttrsFinalBuilder_ == null) {
                    ensureNextAttrsFinalIsMutable();
                    this.nextAttrsFinal_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.nextAttrsFinalBuilder_.addMessage((GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addNextAttrsFinal(int index, Common.AttributeSimple.Builder builderForValue) {
                if (this.nextAttrsFinalBuilder_ == null) {
                    ensureNextAttrsFinalIsMutable();
                    this.nextAttrsFinal_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.nextAttrsFinalBuilder_.addMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addAllNextAttrsFinal(Iterable<? extends Common.AttributeSimple> values) {
                if (this.nextAttrsFinalBuilder_ == null) {
                    ensureNextAttrsFinalIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.nextAttrsFinal_);
                    onChanged();
                } else {
                    this.nextAttrsFinalBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearNextAttrsFinal() {
                if (this.nextAttrsFinalBuilder_ == null) {
                    this.nextAttrsFinal_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFEFF;
                    onChanged();
                } else {
                    this.nextAttrsFinalBuilder_.clear();
                }
                return this;
            }

            public Builder removeNextAttrsFinal(int index) {
                if (this.nextAttrsFinalBuilder_ == null) {
                    ensureNextAttrsFinalIsMutable();
                    this.nextAttrsFinal_.remove(index);
                    onChanged();
                } else {
                    this.nextAttrsFinalBuilder_.remove(index);
                }
                return this;
            }

            public Common.AttributeSimple.Builder getNextAttrsFinalBuilder(int index) {
                return (Common.AttributeSimple.Builder) getNextAttrsFinalFieldBuilder().getBuilder(index);
            }

            public Common.AttributeSimpleOrBuilder getNextAttrsFinalOrBuilder(int index) {
                if (this.nextAttrsFinalBuilder_ == null)
                    return (Common.AttributeSimpleOrBuilder) this.nextAttrsFinal_.get(index);
                return (Common.AttributeSimpleOrBuilder) this.nextAttrsFinalBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends Common.AttributeSimpleOrBuilder> getNextAttrsFinalOrBuilderList() {
                if (this.nextAttrsFinalBuilder_ != null)
                    return this.nextAttrsFinalBuilder_.getMessageOrBuilderList();
                return (List) Collections.unmodifiableList(this.nextAttrsFinal_);
            }

            public Common.AttributeSimple.Builder addNextAttrsFinalBuilder() {
                return (Common.AttributeSimple.Builder) getNextAttrsFinalFieldBuilder().addBuilder((GeneratedMessage) Common.AttributeSimple.getDefaultInstance());
            }

            public Common.AttributeSimple.Builder addNextAttrsFinalBuilder(int index) {
                return (Common.AttributeSimple.Builder) getNextAttrsFinalFieldBuilder().addBuilder(index, (GeneratedMessage) Common.AttributeSimple.getDefaultInstance());
            }

            public List<Common.AttributeSimple.Builder> getNextAttrsFinalBuilderList() {
                return getNextAttrsFinalFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<Common.AttributeSimple, Common.AttributeSimple.Builder, Common.AttributeSimpleOrBuilder> getNextAttrsFinalFieldBuilder() {
                if (this.nextAttrsFinalBuilder_ == null) {
                    this.nextAttrsFinalBuilder_ = new RepeatedFieldBuilder(this.nextAttrsFinal_, ((this.bitField0_ & 0x100) == 256), getParentForChildren(), isClean());
                    this.nextAttrsFinal_ = null;
                }
                return this.nextAttrsFinalBuilder_;
            }
        }
    }

    public static final class GetAllPetsInfoResponse extends GeneratedMessage implements GetAllPetsInfoResponseOrBuilder {
        private static final GetAllPetsInfoResponse defaultInstance = new GetAllPetsInfoResponse(true);
        private final UnknownFieldSet unknownFields;

        private GetAllPetsInfoResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetAllPetsInfoResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetAllPetsInfoResponse getDefaultInstance() {
            return defaultInstance;
        }

        public GetAllPetsInfoResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetAllPetsInfoResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.s2CPetInfo_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x4;
                            }
                            this.s2CPetInfo_.add(input.readMessage(PetNewHandler.PetDataInfo.PARSER, extensionRegistry));
                            break;
                        case 32:
                            this.bitField0_ |= 0x4;
                            this.s2CFightingPetId_ = input.readInt32();
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x4) == 4) this.s2CPetInfo_ = Collections.unmodifiableList(this.s2CPetInfo_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return PetNewHandler.internal_static_pomelo_area_GetAllPetsInfoResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return PetNewHandler.internal_static_pomelo_area_GetAllPetsInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetAllPetsInfoResponse.class, Builder.class);
        }

        public static Parser<GetAllPetsInfoResponse> PARSER = (Parser<GetAllPetsInfoResponse>) new AbstractParser<GetAllPetsInfoResponse>() {
            public PetNewHandler.GetAllPetsInfoResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PetNewHandler.GetAllPetsInfoResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_PETINFO_FIELD_NUMBER = 3;
        private List<PetNewHandler.PetDataInfo> s2CPetInfo_;
        public static final int S2C_FIGHTINGPETID_FIELD_NUMBER = 4;
        private int s2CFightingPetId_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetAllPetsInfoResponse> getParserForType() {
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

        public List<PetNewHandler.PetDataInfo> getS2CPetInfoList() {
            return this.s2CPetInfo_;
        }

        public List<? extends PetNewHandler.PetDataInfoOrBuilder> getS2CPetInfoOrBuilderList() {
            return (List) this.s2CPetInfo_;
        }

        public int getS2CPetInfoCount() {
            return this.s2CPetInfo_.size();
        }

        public PetNewHandler.PetDataInfo getS2CPetInfo(int index) {
            return this.s2CPetInfo_.get(index);
        }

        public PetNewHandler.PetDataInfoOrBuilder getS2CPetInfoOrBuilder(int index) {
            return this.s2CPetInfo_.get(index);
        }

        public boolean hasS2CFightingPetId() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getS2CFightingPetId() {
            return this.s2CFightingPetId_;
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CPetInfo_ = Collections.emptyList();
            this.s2CFightingPetId_ = 0;
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
            if (!hasS2CFightingPetId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (int i = 0; i < getS2CPetInfoCount(); i++) {
                if (!getS2CPetInfo(i).isInitialized()) {
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
            for (int i = 0; i < this.s2CPetInfo_.size(); i++)
                output.writeMessage(3, (MessageLite) this.s2CPetInfo_.get(i));
            if ((this.bitField0_ & 0x4) == 4)
                output.writeInt32(4, this.s2CFightingPetId_);
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
            for (int i = 0; i < this.s2CPetInfo_.size(); i++)
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.s2CPetInfo_.get(i));
            if ((this.bitField0_ & 0x4) == 4)
                size += CodedOutputStream.computeInt32Size(4, this.s2CFightingPetId_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static GetAllPetsInfoResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetAllPetsInfoResponse) PARSER.parseFrom(data);
        }

        public static GetAllPetsInfoResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetAllPetsInfoResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetAllPetsInfoResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetAllPetsInfoResponse) PARSER.parseFrom(data);
        }

        public static GetAllPetsInfoResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetAllPetsInfoResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetAllPetsInfoResponse parseFrom(InputStream input) throws IOException {
            return (GetAllPetsInfoResponse) PARSER.parseFrom(input);
        }

        public static GetAllPetsInfoResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetAllPetsInfoResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static GetAllPetsInfoResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (GetAllPetsInfoResponse) PARSER.parseDelimitedFrom(input);
        }

        public static GetAllPetsInfoResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetAllPetsInfoResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static GetAllPetsInfoResponse parseFrom(CodedInputStream input) throws IOException {
            return (GetAllPetsInfoResponse) PARSER.parseFrom(input);
        }

        public static GetAllPetsInfoResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetAllPetsInfoResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(GetAllPetsInfoResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements PetNewHandler.GetAllPetsInfoResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private List<PetNewHandler.PetDataInfo> s2CPetInfo_;
            private RepeatedFieldBuilder<PetNewHandler.PetDataInfo, PetNewHandler.PetDataInfo.Builder, PetNewHandler.PetDataInfoOrBuilder> s2CPetInfoBuilder_;
            private int s2CFightingPetId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PetNewHandler.internal_static_pomelo_area_GetAllPetsInfoResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PetNewHandler.internal_static_pomelo_area_GetAllPetsInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(PetNewHandler.GetAllPetsInfoResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.s2CPetInfo_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CPetInfo_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PetNewHandler.GetAllPetsInfoResponse.alwaysUseFieldBuilders)
                    getS2CPetInfoFieldBuilder();
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
                if (this.s2CPetInfoBuilder_ == null) {
                    this.s2CPetInfo_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                } else {
                    this.s2CPetInfoBuilder_.clear();
                }
                this.s2CFightingPetId_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return PetNewHandler.internal_static_pomelo_area_GetAllPetsInfoResponse_descriptor;
            }

            public PetNewHandler.GetAllPetsInfoResponse getDefaultInstanceForType() {
                return PetNewHandler.GetAllPetsInfoResponse.getDefaultInstance();
            }

            public PetNewHandler.GetAllPetsInfoResponse build() {
                PetNewHandler.GetAllPetsInfoResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public PetNewHandler.GetAllPetsInfoResponse buildPartial() {
                PetNewHandler.GetAllPetsInfoResponse result = new PetNewHandler.GetAllPetsInfoResponse(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.s2CMsg_ = this.s2CMsg_;
                if (this.s2CPetInfoBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4) {
                        this.s2CPetInfo_ = Collections.unmodifiableList(this.s2CPetInfo_);
                        this.bitField0_ &= 0xFFFFFFFB;
                    }
                    result.s2CPetInfo_ = this.s2CPetInfo_;
                } else {
                    result.s2CPetInfo_ = this.s2CPetInfoBuilder_.build();
                }
                if ((from_bitField0_ & 0x8) == 8)
                    to_bitField0_ |= 0x4;
                result.s2CFightingPetId_ = this.s2CFightingPetId_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof PetNewHandler.GetAllPetsInfoResponse)
                    return mergeFrom((PetNewHandler.GetAllPetsInfoResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PetNewHandler.GetAllPetsInfoResponse other) {
                if (other == PetNewHandler.GetAllPetsInfoResponse.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (this.s2CPetInfoBuilder_ == null) {
                    if (!other.s2CPetInfo_.isEmpty()) {
                        if (this.s2CPetInfo_.isEmpty()) {
                            this.s2CPetInfo_ = other.s2CPetInfo_;
                            this.bitField0_ &= 0xFFFFFFFB;
                        } else {
                            ensureS2CPetInfoIsMutable();
                            this.s2CPetInfo_.addAll(other.s2CPetInfo_);
                        }
                        onChanged();
                    }
                } else if (!other.s2CPetInfo_.isEmpty()) {
                    if (this.s2CPetInfoBuilder_.isEmpty()) {
                        this.s2CPetInfoBuilder_.dispose();
                        this.s2CPetInfoBuilder_ = null;
                        this.s2CPetInfo_ = other.s2CPetInfo_;
                        this.bitField0_ &= 0xFFFFFFFB;
                        this.s2CPetInfoBuilder_ = PetNewHandler.GetAllPetsInfoResponse.alwaysUseFieldBuilders ? getS2CPetInfoFieldBuilder() : null;
                    } else {
                        this.s2CPetInfoBuilder_.addAllMessages(other.s2CPetInfo_);
                    }
                }
                if (other.hasS2CFightingPetId())
                    setS2CFightingPetId(other.getS2CFightingPetId());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode())
                    return false;
                if (!hasS2CFightingPetId())
                    return false;
                for (int i = 0; i < getS2CPetInfoCount(); i++) {
                    if (!getS2CPetInfo(i).isInitialized())
                        return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                PetNewHandler.GetAllPetsInfoResponse parsedMessage = null;
                try {
                    parsedMessage = (PetNewHandler.GetAllPetsInfoResponse) PetNewHandler.GetAllPetsInfoResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (PetNewHandler.GetAllPetsInfoResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = PetNewHandler.GetAllPetsInfoResponse.getDefaultInstance().getS2CMsg();
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

            private void ensureS2CPetInfoIsMutable() {
                if ((this.bitField0_ & 0x4) != 4) {
                    this.s2CPetInfo_ = new ArrayList<>(this.s2CPetInfo_);
                    this.bitField0_ |= 0x4;
                }
            }

            public List<PetNewHandler.PetDataInfo> getS2CPetInfoList() {
                if (this.s2CPetInfoBuilder_ == null)
                    return Collections.unmodifiableList(this.s2CPetInfo_);
                return this.s2CPetInfoBuilder_.getMessageList();
            }

            public int getS2CPetInfoCount() {
                if (this.s2CPetInfoBuilder_ == null)
                    return this.s2CPetInfo_.size();
                return this.s2CPetInfoBuilder_.getCount();
            }

            public PetNewHandler.PetDataInfo getS2CPetInfo(int index) {
                if (this.s2CPetInfoBuilder_ == null)
                    return this.s2CPetInfo_.get(index);
                return (PetNewHandler.PetDataInfo) this.s2CPetInfoBuilder_.getMessage(index);
            }

            public Builder setS2CPetInfo(int index, PetNewHandler.PetDataInfo value) {
                if (this.s2CPetInfoBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CPetInfoIsMutable();
                    this.s2CPetInfo_.set(index, value);
                    onChanged();
                } else {
                    this.s2CPetInfoBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setS2CPetInfo(int index, PetNewHandler.PetDataInfo.Builder builderForValue) {
                if (this.s2CPetInfoBuilder_ == null) {
                    ensureS2CPetInfoIsMutable();
                    this.s2CPetInfo_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CPetInfoBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addS2CPetInfo(PetNewHandler.PetDataInfo value) {
                if (this.s2CPetInfoBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CPetInfoIsMutable();
                    this.s2CPetInfo_.add(value);
                    onChanged();
                } else {
                    this.s2CPetInfoBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addS2CPetInfo(int index, PetNewHandler.PetDataInfo value) {
                if (this.s2CPetInfoBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CPetInfoIsMutable();
                    this.s2CPetInfo_.add(index, value);
                    onChanged();
                } else {
                    this.s2CPetInfoBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addS2CPetInfo(PetNewHandler.PetDataInfo.Builder builderForValue) {
                if (this.s2CPetInfoBuilder_ == null) {
                    ensureS2CPetInfoIsMutable();
                    this.s2CPetInfo_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.s2CPetInfoBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addS2CPetInfo(int index, PetNewHandler.PetDataInfo.Builder builderForValue) {
                if (this.s2CPetInfoBuilder_ == null) {
                    ensureS2CPetInfoIsMutable();
                    this.s2CPetInfo_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CPetInfoBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllS2CPetInfo(Iterable<? extends PetNewHandler.PetDataInfo> values) {
                if (this.s2CPetInfoBuilder_ == null) {
                    ensureS2CPetInfoIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.s2CPetInfo_);
                    onChanged();
                } else {
                    this.s2CPetInfoBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearS2CPetInfo() {
                if (this.s2CPetInfoBuilder_ == null) {
                    this.s2CPetInfo_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                    onChanged();
                } else {
                    this.s2CPetInfoBuilder_.clear();
                }
                return this;
            }

            public Builder removeS2CPetInfo(int index) {
                if (this.s2CPetInfoBuilder_ == null) {
                    ensureS2CPetInfoIsMutable();
                    this.s2CPetInfo_.remove(index);
                    onChanged();
                } else {
                    this.s2CPetInfoBuilder_.remove(index);
                }
                return this;
            }

            public PetNewHandler.PetDataInfo.Builder getS2CPetInfoBuilder(int index) {
                return (PetNewHandler.PetDataInfo.Builder) getS2CPetInfoFieldBuilder().getBuilder(index);
            }

            public PetNewHandler.PetDataInfoOrBuilder getS2CPetInfoOrBuilder(int index) {
                if (this.s2CPetInfoBuilder_ == null)
                    return this.s2CPetInfo_.get(index);
                return (PetNewHandler.PetDataInfoOrBuilder) this.s2CPetInfoBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends PetNewHandler.PetDataInfoOrBuilder> getS2CPetInfoOrBuilderList() {
                if (this.s2CPetInfoBuilder_ != null)
                    return this.s2CPetInfoBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.s2CPetInfo_);
            }

            public PetNewHandler.PetDataInfo.Builder addS2CPetInfoBuilder() {
                return (PetNewHandler.PetDataInfo.Builder) getS2CPetInfoFieldBuilder().addBuilder(PetNewHandler.PetDataInfo.getDefaultInstance());
            }

            public PetNewHandler.PetDataInfo.Builder addS2CPetInfoBuilder(int index) {
                return (PetNewHandler.PetDataInfo.Builder) getS2CPetInfoFieldBuilder().addBuilder(index, PetNewHandler.PetDataInfo.getDefaultInstance());
            }

            public List<PetNewHandler.PetDataInfo.Builder> getS2CPetInfoBuilderList() {
                return getS2CPetInfoFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<PetNewHandler.PetDataInfo, PetNewHandler.PetDataInfo.Builder, PetNewHandler.PetDataInfoOrBuilder> getS2CPetInfoFieldBuilder() {
                if (this.s2CPetInfoBuilder_ == null) {
                    this.s2CPetInfoBuilder_ = new RepeatedFieldBuilder(this.s2CPetInfo_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
                    this.s2CPetInfo_ = null;
                }
                return this.s2CPetInfoBuilder_;
            }

            public boolean hasS2CFightingPetId() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public int getS2CFightingPetId() {
                return this.s2CFightingPetId_;
            }

            public Builder setS2CFightingPetId(int value) {
                this.bitField0_ |= 0x8;
                this.s2CFightingPetId_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CFightingPetId() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.s2CFightingPetId_ = 0;
                onChanged();
                return this;
            }
        }
    }

    public static final class SummonPetRequest extends GeneratedMessage implements SummonPetRequestOrBuilder {
        private static final SummonPetRequest defaultInstance = new SummonPetRequest(true);
        private final UnknownFieldSet unknownFields;

        private SummonPetRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private SummonPetRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static SummonPetRequest getDefaultInstance() {
            return defaultInstance;
        }

        public SummonPetRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SummonPetRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return PetNewHandler.internal_static_pomelo_area_SummonPetRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return PetNewHandler.internal_static_pomelo_area_SummonPetRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(SummonPetRequest.class, Builder.class);
        }

        public static Parser<SummonPetRequest> PARSER = (Parser<SummonPetRequest>) new AbstractParser<SummonPetRequest>() {
            public PetNewHandler.SummonPetRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PetNewHandler.SummonPetRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_ID_FIELD_NUMBER = 1;
        private int c2SId_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<SummonPetRequest> getParserForType() {
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
            if (!hasC2SId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeInt32(1, this.c2SId_);
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
                size += CodedOutputStream.computeInt32Size(1, this.c2SId_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static SummonPetRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (SummonPetRequest) PARSER.parseFrom(data);
        }


        public static SummonPetRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SummonPetRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static SummonPetRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (SummonPetRequest) PARSER.parseFrom(data);
        }


        public static SummonPetRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SummonPetRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static SummonPetRequest parseFrom(InputStream input) throws IOException {
            return (SummonPetRequest) PARSER.parseFrom(input);
        }


        public static SummonPetRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SummonPetRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static SummonPetRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (SummonPetRequest) PARSER.parseDelimitedFrom(input);
        }


        public static SummonPetRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SummonPetRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static SummonPetRequest parseFrom(CodedInputStream input) throws IOException {
            return (SummonPetRequest) PARSER.parseFrom(input);
        }


        public static SummonPetRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SummonPetRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(SummonPetRequest prototype) {
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
                implements PetNewHandler.SummonPetRequestOrBuilder {
            private int bitField0_;


            private int c2SId_;


            public static final Descriptors.Descriptor getDescriptor() {
                return PetNewHandler.internal_static_pomelo_area_SummonPetRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PetNewHandler.internal_static_pomelo_area_SummonPetRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(PetNewHandler.SummonPetRequest.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (PetNewHandler.SummonPetRequest.alwaysUseFieldBuilders) ;
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
                return PetNewHandler.internal_static_pomelo_area_SummonPetRequest_descriptor;
            }


            public PetNewHandler.SummonPetRequest getDefaultInstanceForType() {
                return PetNewHandler.SummonPetRequest.getDefaultInstance();
            }


            public PetNewHandler.SummonPetRequest build() {
                PetNewHandler.SummonPetRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public PetNewHandler.SummonPetRequest buildPartial() {
                PetNewHandler.SummonPetRequest result = new PetNewHandler.SummonPetRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.c2SId_ = this.c2SId_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof PetNewHandler.SummonPetRequest) {
                    return mergeFrom((PetNewHandler.SummonPetRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(PetNewHandler.SummonPetRequest other) {
                if (other == PetNewHandler.SummonPetRequest.getDefaultInstance()) {
                    return this;
                }
                if (other.hasC2SId()) {
                    setC2SId(other.getC2SId());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasC2SId()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                PetNewHandler.SummonPetRequest parsedMessage = null;
                try {
                    parsedMessage = (PetNewHandler.SummonPetRequest) PetNewHandler.SummonPetRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (PetNewHandler.SummonPetRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
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
    }


    public static final class SummonPetResponse
            extends GeneratedMessage
            implements SummonPetResponseOrBuilder {
        private static final SummonPetResponse defaultInstance = new SummonPetResponse(true);
        private final UnknownFieldSet unknownFields;

        private SummonPetResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private SummonPetResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static SummonPetResponse getDefaultInstance() {
            return defaultInstance;
        }

        public SummonPetResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SummonPetResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.s2CFight_ = input.readInt32();
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
            return PetNewHandler.internal_static_pomelo_area_SummonPetResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return PetNewHandler.internal_static_pomelo_area_SummonPetResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(SummonPetResponse.class, Builder.class);
        }

        public static Parser<SummonPetResponse> PARSER = (Parser<SummonPetResponse>) new AbstractParser<SummonPetResponse>() {
            public PetNewHandler.SummonPetResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PetNewHandler.SummonPetResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_FIGHT_FIELD_NUMBER = 3;
        private int s2CFight_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<SummonPetResponse> getParserForType() {
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


        public boolean hasS2CFight() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public int getS2CFight() {
            return this.s2CFight_;
        }


        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CFight_ = 0;
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
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeInt32(3, this.s2CFight_);
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
                size += CodedOutputStream.computeInt32Size(3, this.s2CFight_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static SummonPetResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (SummonPetResponse) PARSER.parseFrom(data);
        }

        public static SummonPetResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SummonPetResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static SummonPetResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (SummonPetResponse) PARSER.parseFrom(data);
        }

        public static SummonPetResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SummonPetResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static SummonPetResponse parseFrom(InputStream input) throws IOException {
            return (SummonPetResponse) PARSER.parseFrom(input);
        }

        public static SummonPetResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SummonPetResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static SummonPetResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (SummonPetResponse) PARSER.parseDelimitedFrom(input);
        }

        public static SummonPetResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SummonPetResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static SummonPetResponse parseFrom(CodedInputStream input) throws IOException {
            return (SummonPetResponse) PARSER.parseFrom(input);
        }

        public static SummonPetResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SummonPetResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(SummonPetResponse prototype) {
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
                implements PetNewHandler.SummonPetResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private int s2CFight_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PetNewHandler.internal_static_pomelo_area_SummonPetResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PetNewHandler.internal_static_pomelo_area_SummonPetResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(PetNewHandler.SummonPetResponse.class, Builder.class);
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
                if (PetNewHandler.SummonPetResponse.alwaysUseFieldBuilders) ;
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
                this.s2CFight_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return PetNewHandler.internal_static_pomelo_area_SummonPetResponse_descriptor;
            }

            public PetNewHandler.SummonPetResponse getDefaultInstanceForType() {
                return PetNewHandler.SummonPetResponse.getDefaultInstance();
            }

            public PetNewHandler.SummonPetResponse build() {
                PetNewHandler.SummonPetResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public PetNewHandler.SummonPetResponse buildPartial() {
                PetNewHandler.SummonPetResponse result = new PetNewHandler.SummonPetResponse(this);
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
                result.s2CFight_ = this.s2CFight_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof PetNewHandler.SummonPetResponse) {
                    return mergeFrom((PetNewHandler.SummonPetResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PetNewHandler.SummonPetResponse other) {
                if (other == PetNewHandler.SummonPetResponse.getDefaultInstance()) {
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
                if (other.hasS2CFight()) {
                    setS2CFight(other.getS2CFight());
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
                PetNewHandler.SummonPetResponse parsedMessage = null;
                try {
                    parsedMessage = (PetNewHandler.SummonPetResponse) PetNewHandler.SummonPetResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (PetNewHandler.SummonPetResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = PetNewHandler.SummonPetResponse.getDefaultInstance().getS2CMsg();
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

            public boolean hasS2CFight() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public int getS2CFight() {
                return this.s2CFight_;
            }

            public Builder setS2CFight(int value) {
                this.bitField0_ |= 0x4;
                this.s2CFight_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CFight() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.s2CFight_ = 0;
                onChanged();
                return this;
            }
        }
    }

    public static final class UpGradeUpLevelRequest
            extends GeneratedMessage
            implements UpGradeUpLevelRequestOrBuilder {
        private static final UpGradeUpLevelRequest defaultInstance = new UpGradeUpLevelRequest(true);
        private final UnknownFieldSet unknownFields;

        private UpGradeUpLevelRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private UpGradeUpLevelRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static UpGradeUpLevelRequest getDefaultInstance() {
            return defaultInstance;
        }

        public UpGradeUpLevelRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private UpGradeUpLevelRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return PetNewHandler.internal_static_pomelo_area_UpGradeUpLevelRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return PetNewHandler.internal_static_pomelo_area_UpGradeUpLevelRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(UpGradeUpLevelRequest.class, Builder.class);
        }

        public static Parser<UpGradeUpLevelRequest> PARSER = (Parser<UpGradeUpLevelRequest>) new AbstractParser<UpGradeUpLevelRequest>() {
            public PetNewHandler.UpGradeUpLevelRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PetNewHandler.UpGradeUpLevelRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_ID_FIELD_NUMBER = 1;
        private int c2SId_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<UpGradeUpLevelRequest> getParserForType() {
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

        public static UpGradeUpLevelRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (UpGradeUpLevelRequest) PARSER.parseFrom(data);
        }

        public static UpGradeUpLevelRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (UpGradeUpLevelRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static UpGradeUpLevelRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (UpGradeUpLevelRequest) PARSER.parseFrom(data);
        }

        public static UpGradeUpLevelRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (UpGradeUpLevelRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static UpGradeUpLevelRequest parseFrom(InputStream input) throws IOException {
            return (UpGradeUpLevelRequest) PARSER.parseFrom(input);
        }

        public static UpGradeUpLevelRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpGradeUpLevelRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static UpGradeUpLevelRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (UpGradeUpLevelRequest) PARSER.parseDelimitedFrom(input);
        }

        public static UpGradeUpLevelRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpGradeUpLevelRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static UpGradeUpLevelRequest parseFrom(CodedInputStream input) throws IOException {
            return (UpGradeUpLevelRequest) PARSER.parseFrom(input);
        }

        public static UpGradeUpLevelRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpGradeUpLevelRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(UpGradeUpLevelRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements PetNewHandler.UpGradeUpLevelRequestOrBuilder {
            private int bitField0_;
            private int c2SId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PetNewHandler.internal_static_pomelo_area_UpGradeUpLevelRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PetNewHandler.internal_static_pomelo_area_UpGradeUpLevelRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(PetNewHandler.UpGradeUpLevelRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PetNewHandler.UpGradeUpLevelRequest.alwaysUseFieldBuilders) ;
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
                return PetNewHandler.internal_static_pomelo_area_UpGradeUpLevelRequest_descriptor;
            }

            public PetNewHandler.UpGradeUpLevelRequest getDefaultInstanceForType() {
                return PetNewHandler.UpGradeUpLevelRequest.getDefaultInstance();
            }

            public PetNewHandler.UpGradeUpLevelRequest build() {
                PetNewHandler.UpGradeUpLevelRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public PetNewHandler.UpGradeUpLevelRequest buildPartial() {
                PetNewHandler.UpGradeUpLevelRequest result = new PetNewHandler.UpGradeUpLevelRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.c2SId_ = this.c2SId_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof PetNewHandler.UpGradeUpLevelRequest)
                    return mergeFrom((PetNewHandler.UpGradeUpLevelRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PetNewHandler.UpGradeUpLevelRequest other) {
                if (other == PetNewHandler.UpGradeUpLevelRequest.getDefaultInstance()) return this;
                if (other.hasC2SId()) setC2SId(other.getC2SId());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasC2SId()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                PetNewHandler.UpGradeUpLevelRequest parsedMessage = null;
                try {
                    parsedMessage = (PetNewHandler.UpGradeUpLevelRequest) PetNewHandler.UpGradeUpLevelRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (PetNewHandler.UpGradeUpLevelRequest) e.getUnfinishedMessage();
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


    public static final class UpGradeUpLevelResponse
            extends GeneratedMessage
            implements UpGradeUpLevelResponseOrBuilder {
        private static final UpGradeUpLevelResponse defaultInstance = new UpGradeUpLevelResponse(true);
        private final UnknownFieldSet unknownFields;

        private UpGradeUpLevelResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private UpGradeUpLevelResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static UpGradeUpLevelResponse getDefaultInstance() {
            return defaultInstance;
        }

        public UpGradeUpLevelResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private UpGradeUpLevelResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString bs;
                    PetNewHandler.PetDataInfo.Builder subBuilder;
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
                            if ((this.bitField0_ & 0x4) == 4) subBuilder = this.petInfo_.toBuilder();
                            this.petInfo_ = (PetNewHandler.PetDataInfo) input.readMessage(PetNewHandler.PetDataInfo.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.petInfo_);
                                this.petInfo_ = subBuilder.buildPartial();
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
            return PetNewHandler.internal_static_pomelo_area_UpGradeUpLevelResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return PetNewHandler.internal_static_pomelo_area_UpGradeUpLevelResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(UpGradeUpLevelResponse.class, Builder.class);
        }

        public static Parser<UpGradeUpLevelResponse> PARSER = (Parser<UpGradeUpLevelResponse>) new AbstractParser<UpGradeUpLevelResponse>() {
            public PetNewHandler.UpGradeUpLevelResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PetNewHandler.UpGradeUpLevelResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int PETINFO_FIELD_NUMBER = 3;
        private PetNewHandler.PetDataInfo petInfo_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<UpGradeUpLevelResponse> getParserForType() {
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

        public boolean hasPetInfo() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public PetNewHandler.PetDataInfo getPetInfo() {
            return this.petInfo_;
        }

        public PetNewHandler.PetDataInfoOrBuilder getPetInfoOrBuilder() {
            return this.petInfo_;
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.petInfo_ = PetNewHandler.PetDataInfo.getDefaultInstance();
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
            if (hasPetInfo() && !getPetInfo().isInitialized()) {
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
                output.writeMessage(3, (MessageLite) this.petInfo_);
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
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.petInfo_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static UpGradeUpLevelResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (UpGradeUpLevelResponse) PARSER.parseFrom(data);
        }

        public static UpGradeUpLevelResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (UpGradeUpLevelResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static UpGradeUpLevelResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (UpGradeUpLevelResponse) PARSER.parseFrom(data);
        }

        public static UpGradeUpLevelResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (UpGradeUpLevelResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static UpGradeUpLevelResponse parseFrom(InputStream input) throws IOException {
            return (UpGradeUpLevelResponse) PARSER.parseFrom(input);
        }

        public static UpGradeUpLevelResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpGradeUpLevelResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static UpGradeUpLevelResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (UpGradeUpLevelResponse) PARSER.parseDelimitedFrom(input);
        }

        public static UpGradeUpLevelResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpGradeUpLevelResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static UpGradeUpLevelResponse parseFrom(CodedInputStream input) throws IOException {
            return (UpGradeUpLevelResponse) PARSER.parseFrom(input);
        }

        public static UpGradeUpLevelResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpGradeUpLevelResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(UpGradeUpLevelResponse prototype) {
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
                implements PetNewHandler.UpGradeUpLevelResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private PetNewHandler.PetDataInfo petInfo_;
            private SingleFieldBuilder<PetNewHandler.PetDataInfo, PetNewHandler.PetDataInfo.Builder, PetNewHandler.PetDataInfoOrBuilder> petInfoBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PetNewHandler.internal_static_pomelo_area_UpGradeUpLevelResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PetNewHandler.internal_static_pomelo_area_UpGradeUpLevelResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(PetNewHandler.UpGradeUpLevelResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.petInfo_ = PetNewHandler.PetDataInfo.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.petInfo_ = PetNewHandler.PetDataInfo.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PetNewHandler.UpGradeUpLevelResponse.alwaysUseFieldBuilders) {
                    getPetInfoFieldBuilder();
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
                if (this.petInfoBuilder_ == null) {
                    this.petInfo_ = PetNewHandler.PetDataInfo.getDefaultInstance();
                } else {
                    this.petInfoBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return PetNewHandler.internal_static_pomelo_area_UpGradeUpLevelResponse_descriptor;
            }

            public PetNewHandler.UpGradeUpLevelResponse getDefaultInstanceForType() {
                return PetNewHandler.UpGradeUpLevelResponse.getDefaultInstance();
            }

            public PetNewHandler.UpGradeUpLevelResponse build() {
                PetNewHandler.UpGradeUpLevelResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public PetNewHandler.UpGradeUpLevelResponse buildPartial() {
                PetNewHandler.UpGradeUpLevelResponse result = new PetNewHandler.UpGradeUpLevelResponse(this);
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
                if (this.petInfoBuilder_ == null) {
                    result.petInfo_ = this.petInfo_;
                } else {
                    result.petInfo_ = (PetNewHandler.PetDataInfo) this.petInfoBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof PetNewHandler.UpGradeUpLevelResponse)
                    return mergeFrom((PetNewHandler.UpGradeUpLevelResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PetNewHandler.UpGradeUpLevelResponse other) {
                if (other == PetNewHandler.UpGradeUpLevelResponse.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (other.hasPetInfo())
                    mergePetInfo(other.getPetInfo());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode())
                    return false;
                if (hasPetInfo() && !getPetInfo().isInitialized())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                PetNewHandler.UpGradeUpLevelResponse parsedMessage = null;
                try {
                    parsedMessage = (PetNewHandler.UpGradeUpLevelResponse) PetNewHandler.UpGradeUpLevelResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (PetNewHandler.UpGradeUpLevelResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = PetNewHandler.UpGradeUpLevelResponse.getDefaultInstance().getS2CMsg();
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

            public boolean hasPetInfo() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public PetNewHandler.PetDataInfo getPetInfo() {
                if (this.petInfoBuilder_ == null)
                    return this.petInfo_;
                return (PetNewHandler.PetDataInfo) this.petInfoBuilder_.getMessage();
            }

            public Builder setPetInfo(PetNewHandler.PetDataInfo value) {
                if (this.petInfoBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    this.petInfo_ = value;
                    onChanged();
                } else {
                    this.petInfoBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder setPetInfo(PetNewHandler.PetDataInfo.Builder builderForValue) {
                if (this.petInfoBuilder_ == null) {
                    this.petInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.petInfoBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder mergePetInfo(PetNewHandler.PetDataInfo value) {
                if (this.petInfoBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4 && this.petInfo_ != PetNewHandler.PetDataInfo.getDefaultInstance()) {
                        this.petInfo_ = PetNewHandler.PetDataInfo.newBuilder(this.petInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.petInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.petInfoBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder clearPetInfo() {
                if (this.petInfoBuilder_ == null) {
                    this.petInfo_ = PetNewHandler.PetDataInfo.getDefaultInstance();
                    onChanged();
                } else {
                    this.petInfoBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public PetNewHandler.PetDataInfo.Builder getPetInfoBuilder() {
                this.bitField0_ |= 0x4;
                onChanged();
                return (PetNewHandler.PetDataInfo.Builder) getPetInfoFieldBuilder().getBuilder();
            }

            public PetNewHandler.PetDataInfoOrBuilder getPetInfoOrBuilder() {
                if (this.petInfoBuilder_ != null)
                    return (PetNewHandler.PetDataInfoOrBuilder) this.petInfoBuilder_.getMessageOrBuilder();
                return this.petInfo_;
            }

            private SingleFieldBuilder<PetNewHandler.PetDataInfo, PetNewHandler.PetDataInfo.Builder, PetNewHandler.PetDataInfoOrBuilder> getPetInfoFieldBuilder() {
                if (this.petInfoBuilder_ == null) {
                    this.petInfoBuilder_ = new SingleFieldBuilder(getPetInfo(), getParentForChildren(), isClean());
                    this.petInfo_ = null;
                }
                return this.petInfoBuilder_;
            }
        }
    }

    public static final class AddExpByItemRequest
            extends GeneratedMessage
            implements AddExpByItemRequestOrBuilder {
        private final UnknownFieldSet unknownFields;

        private AddExpByItemRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private AddExpByItemRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static AddExpByItemRequest getDefaultInstance() {
            return defaultInstance;
        }

        public AddExpByItemRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AddExpByItemRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.c2SId_ = input.readInt32();
                            break;
                        case 18:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x2;
                            this.c2SItemCode_ = bs;
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
            return PetNewHandler.internal_static_pomelo_area_AddExpByItemRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return PetNewHandler.internal_static_pomelo_area_AddExpByItemRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(AddExpByItemRequest.class, Builder.class);
        }

        public static Parser<AddExpByItemRequest> PARSER = (Parser<AddExpByItemRequest>) new AbstractParser<AddExpByItemRequest>() {
            public PetNewHandler.AddExpByItemRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PetNewHandler.AddExpByItemRequest(input, extensionRegistry);
            }
        };

        private int bitField0_;
        public static final int C2S_ID_FIELD_NUMBER = 1;
        private int c2SId_;
        public static final int C2S_ITEMCODE_FIELD_NUMBER = 2;
        private Object c2SItemCode_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<AddExpByItemRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasC2SId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getC2SId() {
            return this.c2SId_;
        }

        public boolean hasC2SItemCode() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public String getC2SItemCode() {
            Object ref = this.c2SItemCode_;
            if (ref instanceof String)
                return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8())
                this.c2SItemCode_ = s;
            return s;
        }

        private static final AddExpByItemRequest defaultInstance = new AddExpByItemRequest(true);

        public ByteString getC2SItemCodeBytes() {
            Object ref = this.c2SItemCode_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.c2SItemCode_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        private void initFields() {
            this.c2SId_ = 0;
            this.c2SItemCode_ = "";
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasC2SId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasC2SItemCode()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.c2SId_);
            if ((this.bitField0_ & 0x2) == 2) output.writeBytes(2, getC2SItemCodeBytes());
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.c2SId_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getC2SItemCodeBytes());
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static AddExpByItemRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (AddExpByItemRequest) PARSER.parseFrom(data);
        }

        public static AddExpByItemRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AddExpByItemRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static AddExpByItemRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (AddExpByItemRequest) PARSER.parseFrom(data);
        }

        public static AddExpByItemRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AddExpByItemRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static AddExpByItemRequest parseFrom(InputStream input) throws IOException {
            return (AddExpByItemRequest) PARSER.parseFrom(input);
        }

        public static AddExpByItemRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AddExpByItemRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static AddExpByItemRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (AddExpByItemRequest) PARSER.parseDelimitedFrom(input);
        }

        public static AddExpByItemRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AddExpByItemRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static AddExpByItemRequest parseFrom(CodedInputStream input) throws IOException {
            return (AddExpByItemRequest) PARSER.parseFrom(input);
        }

        public static AddExpByItemRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AddExpByItemRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(AddExpByItemRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements PetNewHandler.AddExpByItemRequestOrBuilder {
            private int bitField0_;
            private int c2SId_;
            private Object c2SItemCode_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PetNewHandler.internal_static_pomelo_area_AddExpByItemRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PetNewHandler.internal_static_pomelo_area_AddExpByItemRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(PetNewHandler.AddExpByItemRequest.class, Builder.class);
            }

            private Builder() {
                this.c2SItemCode_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.c2SItemCode_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PetNewHandler.AddExpByItemRequest.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.c2SId_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SItemCode_ = "";
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return PetNewHandler.internal_static_pomelo_area_AddExpByItemRequest_descriptor;
            }

            public PetNewHandler.AddExpByItemRequest getDefaultInstanceForType() {
                return PetNewHandler.AddExpByItemRequest.getDefaultInstance();
            }

            public PetNewHandler.AddExpByItemRequest build() {
                PetNewHandler.AddExpByItemRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public PetNewHandler.AddExpByItemRequest buildPartial() {
                PetNewHandler.AddExpByItemRequest result = new PetNewHandler.AddExpByItemRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.c2SId_ = this.c2SId_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.c2SItemCode_ = this.c2SItemCode_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof PetNewHandler.AddExpByItemRequest)
                    return mergeFrom((PetNewHandler.AddExpByItemRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PetNewHandler.AddExpByItemRequest other) {
                if (other == PetNewHandler.AddExpByItemRequest.getDefaultInstance()) return this;
                if (other.hasC2SId()) setC2SId(other.getC2SId());
                if (other.hasC2SItemCode()) {
                    this.bitField0_ |= 0x2;
                    this.c2SItemCode_ = other.c2SItemCode_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasC2SId()) return false;
                if (!hasC2SItemCode()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                PetNewHandler.AddExpByItemRequest parsedMessage = null;
                try {
                    parsedMessage = (PetNewHandler.AddExpByItemRequest) PetNewHandler.AddExpByItemRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (PetNewHandler.AddExpByItemRequest) e.getUnfinishedMessage();
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

            public boolean hasC2SItemCode() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public String getC2SItemCode() {
                Object ref = this.c2SItemCode_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) this.c2SItemCode_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getC2SItemCodeBytes() {
                Object ref = this.c2SItemCode_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.c2SItemCode_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setC2SItemCode(String value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x2;
                this.c2SItemCode_ = value;
                onChanged();
                return this;
            }

            public Builder clearC2SItemCode() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.c2SItemCode_ = PetNewHandler.AddExpByItemRequest.getDefaultInstance().getC2SItemCode();
                onChanged();
                return this;
            }

            public Builder setC2SItemCodeBytes(ByteString value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x2;
                this.c2SItemCode_ = value;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class AddExpByItemResponse
            extends GeneratedMessage
            implements AddExpByItemResponseOrBuilder {
        private static final AddExpByItemResponse defaultInstance = new AddExpByItemResponse(true);
        private final UnknownFieldSet unknownFields;

        private AddExpByItemResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private AddExpByItemResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static AddExpByItemResponse getDefaultInstance() {
            return defaultInstance;
        }

        public AddExpByItemResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AddExpByItemResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString bs;
                    PetNewHandler.PetDataInfo.Builder subBuilder;
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
                            if ((this.bitField0_ & 0x4) == 4) subBuilder = this.petInfo_.toBuilder();
                            this.petInfo_ = (PetNewHandler.PetDataInfo) input.readMessage(PetNewHandler.PetDataInfo.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.petInfo_);
                                this.petInfo_ = subBuilder.buildPartial();
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
            return PetNewHandler.internal_static_pomelo_area_AddExpByItemResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return PetNewHandler.internal_static_pomelo_area_AddExpByItemResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(AddExpByItemResponse.class, Builder.class);
        }

        public static Parser<AddExpByItemResponse> PARSER = (Parser<AddExpByItemResponse>) new AbstractParser<AddExpByItemResponse>() {
            public PetNewHandler.AddExpByItemResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PetNewHandler.AddExpByItemResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int PETINFO_FIELD_NUMBER = 3;
        private PetNewHandler.PetDataInfo petInfo_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<AddExpByItemResponse> getParserForType() {
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

        public boolean hasPetInfo() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public PetNewHandler.PetDataInfo getPetInfo() {
            return this.petInfo_;
        }

        public PetNewHandler.PetDataInfoOrBuilder getPetInfoOrBuilder() {
            return this.petInfo_;
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.petInfo_ = PetNewHandler.PetDataInfo.getDefaultInstance();
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
            if (hasPetInfo() && !getPetInfo().isInitialized()) {
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
                output.writeMessage(3, (MessageLite) this.petInfo_);
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
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.petInfo_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static AddExpByItemResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (AddExpByItemResponse) PARSER.parseFrom(data);
        }

        public static AddExpByItemResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AddExpByItemResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static AddExpByItemResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (AddExpByItemResponse) PARSER.parseFrom(data);
        }

        public static AddExpByItemResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AddExpByItemResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static AddExpByItemResponse parseFrom(InputStream input) throws IOException {
            return (AddExpByItemResponse) PARSER.parseFrom(input);
        }

        public static AddExpByItemResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AddExpByItemResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static AddExpByItemResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (AddExpByItemResponse) PARSER.parseDelimitedFrom(input);
        }

        public static AddExpByItemResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AddExpByItemResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static AddExpByItemResponse parseFrom(CodedInputStream input) throws IOException {
            return (AddExpByItemResponse) PARSER.parseFrom(input);
        }

        public static AddExpByItemResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AddExpByItemResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(AddExpByItemResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements PetNewHandler.AddExpByItemResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private PetNewHandler.PetDataInfo petInfo_;
            private SingleFieldBuilder<PetNewHandler.PetDataInfo, PetNewHandler.PetDataInfo.Builder, PetNewHandler.PetDataInfoOrBuilder> petInfoBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PetNewHandler.internal_static_pomelo_area_AddExpByItemResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PetNewHandler.internal_static_pomelo_area_AddExpByItemResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(PetNewHandler.AddExpByItemResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.petInfo_ = PetNewHandler.PetDataInfo.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.petInfo_ = PetNewHandler.PetDataInfo.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PetNewHandler.AddExpByItemResponse.alwaysUseFieldBuilders)
                    getPetInfoFieldBuilder();
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
                if (this.petInfoBuilder_ == null) {
                    this.petInfo_ = PetNewHandler.PetDataInfo.getDefaultInstance();
                } else {
                    this.petInfoBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return PetNewHandler.internal_static_pomelo_area_AddExpByItemResponse_descriptor;
            }

            public PetNewHandler.AddExpByItemResponse getDefaultInstanceForType() {
                return PetNewHandler.AddExpByItemResponse.getDefaultInstance();
            }

            public PetNewHandler.AddExpByItemResponse build() {
                PetNewHandler.AddExpByItemResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public PetNewHandler.AddExpByItemResponse buildPartial() {
                PetNewHandler.AddExpByItemResponse result = new PetNewHandler.AddExpByItemResponse(this);
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
                if (this.petInfoBuilder_ == null) {
                    result.petInfo_ = this.petInfo_;
                } else {
                    result.petInfo_ = (PetNewHandler.PetDataInfo) this.petInfoBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof PetNewHandler.AddExpByItemResponse)
                    return mergeFrom((PetNewHandler.AddExpByItemResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PetNewHandler.AddExpByItemResponse other) {
                if (other == PetNewHandler.AddExpByItemResponse.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (other.hasPetInfo())
                    mergePetInfo(other.getPetInfo());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode())
                    return false;
                if (hasPetInfo() && !getPetInfo().isInitialized())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                PetNewHandler.AddExpByItemResponse parsedMessage = null;
                try {
                    parsedMessage = (PetNewHandler.AddExpByItemResponse) PetNewHandler.AddExpByItemResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (PetNewHandler.AddExpByItemResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = PetNewHandler.AddExpByItemResponse.getDefaultInstance().getS2CMsg();
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

            public boolean hasPetInfo() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public PetNewHandler.PetDataInfo getPetInfo() {
                if (this.petInfoBuilder_ == null)
                    return this.petInfo_;
                return (PetNewHandler.PetDataInfo) this.petInfoBuilder_.getMessage();
            }

            public Builder setPetInfo(PetNewHandler.PetDataInfo value) {
                if (this.petInfoBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    this.petInfo_ = value;
                    onChanged();
                } else {
                    this.petInfoBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder setPetInfo(PetNewHandler.PetDataInfo.Builder builderForValue) {
                if (this.petInfoBuilder_ == null) {
                    this.petInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.petInfoBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder mergePetInfo(PetNewHandler.PetDataInfo value) {
                if (this.petInfoBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4 && this.petInfo_ != PetNewHandler.PetDataInfo.getDefaultInstance()) {
                        this.petInfo_ = PetNewHandler.PetDataInfo.newBuilder(this.petInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.petInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.petInfoBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder clearPetInfo() {
                if (this.petInfoBuilder_ == null) {
                    this.petInfo_ = PetNewHandler.PetDataInfo.getDefaultInstance();
                    onChanged();
                } else {
                    this.petInfoBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public PetNewHandler.PetDataInfo.Builder getPetInfoBuilder() {
                this.bitField0_ |= 0x4;
                onChanged();
                return (PetNewHandler.PetDataInfo.Builder) getPetInfoFieldBuilder().getBuilder();
            }

            public PetNewHandler.PetDataInfoOrBuilder getPetInfoOrBuilder() {
                if (this.petInfoBuilder_ != null)
                    return (PetNewHandler.PetDataInfoOrBuilder) this.petInfoBuilder_.getMessageOrBuilder();
                return this.petInfo_;
            }

            private SingleFieldBuilder<PetNewHandler.PetDataInfo, PetNewHandler.PetDataInfo.Builder, PetNewHandler.PetDataInfoOrBuilder> getPetInfoFieldBuilder() {
                if (this.petInfoBuilder_ == null) {
                    this.petInfoBuilder_ = new SingleFieldBuilder(getPetInfo(), getParentForChildren(), isClean());
                    this.petInfo_ = null;
                }
                return this.petInfoBuilder_;
            }
        }
    }

    public static final class UpgradeOneLevelRequest extends GeneratedMessage implements UpgradeOneLevelRequestOrBuilder {
        private static final UpgradeOneLevelRequest defaultInstance = new UpgradeOneLevelRequest(true);
        private final UnknownFieldSet unknownFields;

        private UpgradeOneLevelRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private UpgradeOneLevelRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static UpgradeOneLevelRequest getDefaultInstance() {
            return defaultInstance;
        }

        public UpgradeOneLevelRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private UpgradeOneLevelRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return PetNewHandler.internal_static_pomelo_area_UpgradeOneLevelRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return PetNewHandler.internal_static_pomelo_area_UpgradeOneLevelRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(UpgradeOneLevelRequest.class, Builder.class);
        }

        public static Parser<UpgradeOneLevelRequest> PARSER = (Parser<UpgradeOneLevelRequest>) new AbstractParser<UpgradeOneLevelRequest>() {
            public PetNewHandler.UpgradeOneLevelRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PetNewHandler.UpgradeOneLevelRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_ID_FIELD_NUMBER = 1;
        private int c2SId_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<UpgradeOneLevelRequest> getParserForType() {
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

        public static UpgradeOneLevelRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (UpgradeOneLevelRequest) PARSER.parseFrom(data);
        }

        public static UpgradeOneLevelRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (UpgradeOneLevelRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static UpgradeOneLevelRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (UpgradeOneLevelRequest) PARSER.parseFrom(data);
        }

        public static UpgradeOneLevelRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (UpgradeOneLevelRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static UpgradeOneLevelRequest parseFrom(InputStream input) throws IOException {
            return (UpgradeOneLevelRequest) PARSER.parseFrom(input);
        }

        public static UpgradeOneLevelRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpgradeOneLevelRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static UpgradeOneLevelRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (UpgradeOneLevelRequest) PARSER.parseDelimitedFrom(input);
        }

        public static UpgradeOneLevelRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpgradeOneLevelRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static UpgradeOneLevelRequest parseFrom(CodedInputStream input) throws IOException {
            return (UpgradeOneLevelRequest) PARSER.parseFrom(input);
        }

        public static UpgradeOneLevelRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpgradeOneLevelRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(UpgradeOneLevelRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements PetNewHandler.UpgradeOneLevelRequestOrBuilder {
            private int bitField0_;
            private int c2SId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PetNewHandler.internal_static_pomelo_area_UpgradeOneLevelRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PetNewHandler.internal_static_pomelo_area_UpgradeOneLevelRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(PetNewHandler.UpgradeOneLevelRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PetNewHandler.UpgradeOneLevelRequest.alwaysUseFieldBuilders) ;
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
                return PetNewHandler.internal_static_pomelo_area_UpgradeOneLevelRequest_descriptor;
            }

            public PetNewHandler.UpgradeOneLevelRequest getDefaultInstanceForType() {
                return PetNewHandler.UpgradeOneLevelRequest.getDefaultInstance();
            }

            public PetNewHandler.UpgradeOneLevelRequest build() {
                PetNewHandler.UpgradeOneLevelRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public PetNewHandler.UpgradeOneLevelRequest buildPartial() {
                PetNewHandler.UpgradeOneLevelRequest result = new PetNewHandler.UpgradeOneLevelRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.c2SId_ = this.c2SId_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof PetNewHandler.UpgradeOneLevelRequest)
                    return mergeFrom((PetNewHandler.UpgradeOneLevelRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PetNewHandler.UpgradeOneLevelRequest other) {
                if (other == PetNewHandler.UpgradeOneLevelRequest.getDefaultInstance()) return this;
                if (other.hasC2SId()) setC2SId(other.getC2SId());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasC2SId()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                PetNewHandler.UpgradeOneLevelRequest parsedMessage = null;
                try {
                    parsedMessage = (PetNewHandler.UpgradeOneLevelRequest) PetNewHandler.UpgradeOneLevelRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (PetNewHandler.UpgradeOneLevelRequest) e.getUnfinishedMessage();
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


    public static final class UpgradeOneLevelResponse
            extends GeneratedMessage
            implements UpgradeOneLevelResponseOrBuilder {
        private static final UpgradeOneLevelResponse defaultInstance = new UpgradeOneLevelResponse(true);
        private final UnknownFieldSet unknownFields;

        private UpgradeOneLevelResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private UpgradeOneLevelResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static UpgradeOneLevelResponse getDefaultInstance() {
            return defaultInstance;
        }

        public UpgradeOneLevelResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private UpgradeOneLevelResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString bs;
                    PetNewHandler.PetDataInfo.Builder subBuilder;
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
                            if ((this.bitField0_ & 0x4) == 4) subBuilder = this.petInfo_.toBuilder();
                            this.petInfo_ = (PetNewHandler.PetDataInfo) input.readMessage(PetNewHandler.PetDataInfo.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.petInfo_);
                                this.petInfo_ = subBuilder.buildPartial();
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
            return PetNewHandler.internal_static_pomelo_area_UpgradeOneLevelResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return PetNewHandler.internal_static_pomelo_area_UpgradeOneLevelResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(UpgradeOneLevelResponse.class, Builder.class);
        }

        public static Parser<UpgradeOneLevelResponse> PARSER = (Parser<UpgradeOneLevelResponse>) new AbstractParser<UpgradeOneLevelResponse>() {
            public PetNewHandler.UpgradeOneLevelResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PetNewHandler.UpgradeOneLevelResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int PETINFO_FIELD_NUMBER = 3;
        private PetNewHandler.PetDataInfo petInfo_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<UpgradeOneLevelResponse> getParserForType() {
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

        public boolean hasPetInfo() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public PetNewHandler.PetDataInfo getPetInfo() {
            return this.petInfo_;
        }

        public PetNewHandler.PetDataInfoOrBuilder getPetInfoOrBuilder() {
            return this.petInfo_;
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.petInfo_ = PetNewHandler.PetDataInfo.getDefaultInstance();
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
            if (hasPetInfo() && !getPetInfo().isInitialized()) {
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
                output.writeMessage(3, (MessageLite) this.petInfo_);
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
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.petInfo_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static UpgradeOneLevelResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (UpgradeOneLevelResponse) PARSER.parseFrom(data);
        }

        public static UpgradeOneLevelResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (UpgradeOneLevelResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static UpgradeOneLevelResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (UpgradeOneLevelResponse) PARSER.parseFrom(data);
        }

        public static UpgradeOneLevelResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (UpgradeOneLevelResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static UpgradeOneLevelResponse parseFrom(InputStream input) throws IOException {
            return (UpgradeOneLevelResponse) PARSER.parseFrom(input);
        }

        public static UpgradeOneLevelResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpgradeOneLevelResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static UpgradeOneLevelResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (UpgradeOneLevelResponse) PARSER.parseDelimitedFrom(input);
        }

        public static UpgradeOneLevelResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpgradeOneLevelResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static UpgradeOneLevelResponse parseFrom(CodedInputStream input) throws IOException {
            return (UpgradeOneLevelResponse) PARSER.parseFrom(input);
        }

        public static UpgradeOneLevelResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpgradeOneLevelResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(UpgradeOneLevelResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements PetNewHandler.UpgradeOneLevelResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private PetNewHandler.PetDataInfo petInfo_;
            private SingleFieldBuilder<PetNewHandler.PetDataInfo, PetNewHandler.PetDataInfo.Builder, PetNewHandler.PetDataInfoOrBuilder> petInfoBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PetNewHandler.internal_static_pomelo_area_UpgradeOneLevelResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PetNewHandler.internal_static_pomelo_area_UpgradeOneLevelResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(PetNewHandler.UpgradeOneLevelResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.petInfo_ = PetNewHandler.PetDataInfo.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.petInfo_ = PetNewHandler.PetDataInfo.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PetNewHandler.UpgradeOneLevelResponse.alwaysUseFieldBuilders)
                    getPetInfoFieldBuilder();
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
                if (this.petInfoBuilder_ == null) {
                    this.petInfo_ = PetNewHandler.PetDataInfo.getDefaultInstance();
                } else {
                    this.petInfoBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return PetNewHandler.internal_static_pomelo_area_UpgradeOneLevelResponse_descriptor;
            }

            public PetNewHandler.UpgradeOneLevelResponse getDefaultInstanceForType() {
                return PetNewHandler.UpgradeOneLevelResponse.getDefaultInstance();
            }

            public PetNewHandler.UpgradeOneLevelResponse build() {
                PetNewHandler.UpgradeOneLevelResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public PetNewHandler.UpgradeOneLevelResponse buildPartial() {
                PetNewHandler.UpgradeOneLevelResponse result = new PetNewHandler.UpgradeOneLevelResponse(this);
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
                if (this.petInfoBuilder_ == null) {
                    result.petInfo_ = this.petInfo_;
                } else {
                    result.petInfo_ = (PetNewHandler.PetDataInfo) this.petInfoBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof PetNewHandler.UpgradeOneLevelResponse)
                    return mergeFrom((PetNewHandler.UpgradeOneLevelResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PetNewHandler.UpgradeOneLevelResponse other) {
                if (other == PetNewHandler.UpgradeOneLevelResponse.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (other.hasPetInfo())
                    mergePetInfo(other.getPetInfo());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode())
                    return false;
                if (hasPetInfo() && !getPetInfo().isInitialized())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                PetNewHandler.UpgradeOneLevelResponse parsedMessage = null;
                try {
                    parsedMessage = (PetNewHandler.UpgradeOneLevelResponse) PetNewHandler.UpgradeOneLevelResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (PetNewHandler.UpgradeOneLevelResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = PetNewHandler.UpgradeOneLevelResponse.getDefaultInstance().getS2CMsg();
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

            public boolean hasPetInfo() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public PetNewHandler.PetDataInfo getPetInfo() {
                if (this.petInfoBuilder_ == null)
                    return this.petInfo_;
                return (PetNewHandler.PetDataInfo) this.petInfoBuilder_.getMessage();
            }

            public Builder setPetInfo(PetNewHandler.PetDataInfo value) {
                if (this.petInfoBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    this.petInfo_ = value;
                    onChanged();
                } else {
                    this.petInfoBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder setPetInfo(PetNewHandler.PetDataInfo.Builder builderForValue) {
                if (this.petInfoBuilder_ == null) {
                    this.petInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.petInfoBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder mergePetInfo(PetNewHandler.PetDataInfo value) {
                if (this.petInfoBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4 && this.petInfo_ != PetNewHandler.PetDataInfo.getDefaultInstance()) {
                        this.petInfo_ = PetNewHandler.PetDataInfo.newBuilder(this.petInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.petInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.petInfoBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder clearPetInfo() {
                if (this.petInfoBuilder_ == null) {
                    this.petInfo_ = PetNewHandler.PetDataInfo.getDefaultInstance();
                    onChanged();
                } else {
                    this.petInfoBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public PetNewHandler.PetDataInfo.Builder getPetInfoBuilder() {
                this.bitField0_ |= 0x4;
                onChanged();
                return (PetNewHandler.PetDataInfo.Builder) getPetInfoFieldBuilder().getBuilder();
            }

            public PetNewHandler.PetDataInfoOrBuilder getPetInfoOrBuilder() {
                if (this.petInfoBuilder_ != null)
                    return (PetNewHandler.PetDataInfoOrBuilder) this.petInfoBuilder_.getMessageOrBuilder();
                return this.petInfo_;
            }

            private SingleFieldBuilder<PetNewHandler.PetDataInfo, PetNewHandler.PetDataInfo.Builder, PetNewHandler.PetDataInfoOrBuilder> getPetInfoFieldBuilder() {
                if (this.petInfoBuilder_ == null) {
                    this.petInfoBuilder_ = new SingleFieldBuilder(getPetInfo(), getParentForChildren(), isClean());
                    this.petInfo_ = null;
                }
                return this.petInfoBuilder_;
            }
        }
    }

    public static final class UpgradeToTopRequest extends GeneratedMessage implements UpgradeToTopRequestOrBuilder {
        private static final UpgradeToTopRequest defaultInstance = new UpgradeToTopRequest(true);
        private final UnknownFieldSet unknownFields;

        private UpgradeToTopRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private UpgradeToTopRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static UpgradeToTopRequest getDefaultInstance() {
            return defaultInstance;
        }

        public UpgradeToTopRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private UpgradeToTopRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return PetNewHandler.internal_static_pomelo_area_UpgradeToTopRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return PetNewHandler.internal_static_pomelo_area_UpgradeToTopRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(UpgradeToTopRequest.class, Builder.class);
        }

        public static Parser<UpgradeToTopRequest> PARSER = (Parser<UpgradeToTopRequest>) new AbstractParser<UpgradeToTopRequest>() {
            public PetNewHandler.UpgradeToTopRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PetNewHandler.UpgradeToTopRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_ID_FIELD_NUMBER = 1;
        private int c2SId_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<UpgradeToTopRequest> getParserForType() {
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

        public static UpgradeToTopRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (UpgradeToTopRequest) PARSER.parseFrom(data);
        }

        public static UpgradeToTopRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (UpgradeToTopRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static UpgradeToTopRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (UpgradeToTopRequest) PARSER.parseFrom(data);
        }

        public static UpgradeToTopRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (UpgradeToTopRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static UpgradeToTopRequest parseFrom(InputStream input) throws IOException {
            return (UpgradeToTopRequest) PARSER.parseFrom(input);
        }

        public static UpgradeToTopRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpgradeToTopRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static UpgradeToTopRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (UpgradeToTopRequest) PARSER.parseDelimitedFrom(input);
        }

        public static UpgradeToTopRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpgradeToTopRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static UpgradeToTopRequest parseFrom(CodedInputStream input) throws IOException {
            return (UpgradeToTopRequest) PARSER.parseFrom(input);
        }

        public static UpgradeToTopRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpgradeToTopRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(UpgradeToTopRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements PetNewHandler.UpgradeToTopRequestOrBuilder {
            private int bitField0_;
            private int c2SId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PetNewHandler.internal_static_pomelo_area_UpgradeToTopRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PetNewHandler.internal_static_pomelo_area_UpgradeToTopRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(PetNewHandler.UpgradeToTopRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PetNewHandler.UpgradeToTopRequest.alwaysUseFieldBuilders) ;
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
                return PetNewHandler.internal_static_pomelo_area_UpgradeToTopRequest_descriptor;
            }

            public PetNewHandler.UpgradeToTopRequest getDefaultInstanceForType() {
                return PetNewHandler.UpgradeToTopRequest.getDefaultInstance();
            }

            public PetNewHandler.UpgradeToTopRequest build() {
                PetNewHandler.UpgradeToTopRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public PetNewHandler.UpgradeToTopRequest buildPartial() {
                PetNewHandler.UpgradeToTopRequest result = new PetNewHandler.UpgradeToTopRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.c2SId_ = this.c2SId_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof PetNewHandler.UpgradeToTopRequest)
                    return mergeFrom((PetNewHandler.UpgradeToTopRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PetNewHandler.UpgradeToTopRequest other) {
                if (other == PetNewHandler.UpgradeToTopRequest.getDefaultInstance()) return this;
                if (other.hasC2SId()) setC2SId(other.getC2SId());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasC2SId()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                PetNewHandler.UpgradeToTopRequest parsedMessage = null;
                try {
                    parsedMessage = (PetNewHandler.UpgradeToTopRequest) PetNewHandler.UpgradeToTopRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (PetNewHandler.UpgradeToTopRequest) e.getUnfinishedMessage();
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


    public static final class UpgradeToTopResponse
            extends GeneratedMessage
            implements UpgradeToTopResponseOrBuilder {
        private static final UpgradeToTopResponse defaultInstance = new UpgradeToTopResponse(true);
        private final UnknownFieldSet unknownFields;

        private UpgradeToTopResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private UpgradeToTopResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static UpgradeToTopResponse getDefaultInstance() {
            return defaultInstance;
        }

        public UpgradeToTopResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private UpgradeToTopResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString bs;
                    PetNewHandler.PetDataInfo.Builder subBuilder;
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
                            if ((this.bitField0_ & 0x4) == 4) subBuilder = this.petInfo_.toBuilder();
                            this.petInfo_ = (PetNewHandler.PetDataInfo) input.readMessage(PetNewHandler.PetDataInfo.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.petInfo_);
                                this.petInfo_ = subBuilder.buildPartial();
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
            return PetNewHandler.internal_static_pomelo_area_UpgradeToTopResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return PetNewHandler.internal_static_pomelo_area_UpgradeToTopResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(UpgradeToTopResponse.class, Builder.class);
        }

        public static Parser<UpgradeToTopResponse> PARSER = (Parser<UpgradeToTopResponse>) new AbstractParser<UpgradeToTopResponse>() {
            public PetNewHandler.UpgradeToTopResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PetNewHandler.UpgradeToTopResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int PETINFO_FIELD_NUMBER = 3;
        private PetNewHandler.PetDataInfo petInfo_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<UpgradeToTopResponse> getParserForType() {
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


        public boolean hasPetInfo() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public PetNewHandler.PetDataInfo getPetInfo() {
            return this.petInfo_;
        }


        public PetNewHandler.PetDataInfoOrBuilder getPetInfoOrBuilder() {
            return this.petInfo_;
        }


        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.petInfo_ = PetNewHandler.PetDataInfo.getDefaultInstance();
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
            if (hasPetInfo() && !getPetInfo().isInitialized()) {
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
                output.writeMessage(3, (MessageLite) this.petInfo_);
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
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.petInfo_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static UpgradeToTopResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (UpgradeToTopResponse) PARSER.parseFrom(data);
        }


        public static UpgradeToTopResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (UpgradeToTopResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static UpgradeToTopResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (UpgradeToTopResponse) PARSER.parseFrom(data);
        }


        public static UpgradeToTopResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (UpgradeToTopResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static UpgradeToTopResponse parseFrom(InputStream input) throws IOException {
            return (UpgradeToTopResponse) PARSER.parseFrom(input);
        }


        public static UpgradeToTopResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpgradeToTopResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static UpgradeToTopResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (UpgradeToTopResponse) PARSER.parseDelimitedFrom(input);
        }


        public static UpgradeToTopResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpgradeToTopResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static UpgradeToTopResponse parseFrom(CodedInputStream input) throws IOException {
            return (UpgradeToTopResponse) PARSER.parseFrom(input);
        }


        public static UpgradeToTopResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpgradeToTopResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(UpgradeToTopResponse prototype) {
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
                implements PetNewHandler.UpgradeToTopResponseOrBuilder {
            private int bitField0_;


            private int s2CCode_;


            private Object s2CMsg_;


            private PetNewHandler.PetDataInfo petInfo_;


            private SingleFieldBuilder<PetNewHandler.PetDataInfo, PetNewHandler.PetDataInfo.Builder, PetNewHandler.PetDataInfoOrBuilder> petInfoBuilder_;


            public static final Descriptors.Descriptor getDescriptor() {
                return PetNewHandler.internal_static_pomelo_area_UpgradeToTopResponse_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PetNewHandler.internal_static_pomelo_area_UpgradeToTopResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(PetNewHandler.UpgradeToTopResponse.class, Builder.class);
            }


            private Builder() {
                this.s2CMsg_ = "";
                this.petInfo_ = PetNewHandler.PetDataInfo.getDefaultInstance();
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.petInfo_ = PetNewHandler.PetDataInfo.getDefaultInstance();
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (PetNewHandler.UpgradeToTopResponse.alwaysUseFieldBuilders) {
                    getPetInfoFieldBuilder();
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
                if (this.petInfoBuilder_ == null) {
                    this.petInfo_ = PetNewHandler.PetDataInfo.getDefaultInstance();
                } else {
                    this.petInfoBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return PetNewHandler.internal_static_pomelo_area_UpgradeToTopResponse_descriptor;
            }


            public PetNewHandler.UpgradeToTopResponse getDefaultInstanceForType() {
                return PetNewHandler.UpgradeToTopResponse.getDefaultInstance();
            }


            public PetNewHandler.UpgradeToTopResponse build() {
                PetNewHandler.UpgradeToTopResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public PetNewHandler.UpgradeToTopResponse buildPartial() {
                PetNewHandler.UpgradeToTopResponse result = new PetNewHandler.UpgradeToTopResponse(this);
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
                if (this.petInfoBuilder_ == null) {
                    result.petInfo_ = this.petInfo_;
                } else {
                    result.petInfo_ = (PetNewHandler.PetDataInfo) this.petInfoBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof PetNewHandler.UpgradeToTopResponse) {
                    return mergeFrom((PetNewHandler.UpgradeToTopResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(PetNewHandler.UpgradeToTopResponse other) {
                if (other == PetNewHandler.UpgradeToTopResponse.getDefaultInstance()) {
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
                if (other.hasPetInfo()) {
                    mergePetInfo(other.getPetInfo());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasS2CCode()) {
                    return false;
                }
                if (hasPetInfo() && !getPetInfo().isInitialized()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                PetNewHandler.UpgradeToTopResponse parsedMessage = null;
                try {
                    parsedMessage = (PetNewHandler.UpgradeToTopResponse) PetNewHandler.UpgradeToTopResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (PetNewHandler.UpgradeToTopResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = PetNewHandler.UpgradeToTopResponse.getDefaultInstance().getS2CMsg();
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


            public boolean hasPetInfo() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public PetNewHandler.PetDataInfo getPetInfo() {
                if (this.petInfoBuilder_ == null) {
                    return this.petInfo_;
                }
                return (PetNewHandler.PetDataInfo) this.petInfoBuilder_.getMessage();
            }


            public Builder setPetInfo(PetNewHandler.PetDataInfo value) {
                if (this.petInfoBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.petInfo_ = value;
                    onChanged();
                } else {
                    this.petInfoBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }


            public Builder setPetInfo(PetNewHandler.PetDataInfo.Builder builderForValue) {
                if (this.petInfoBuilder_ == null) {
                    this.petInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.petInfoBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x4;
                return this;
            }


            public Builder mergePetInfo(PetNewHandler.PetDataInfo value) {
                if (this.petInfoBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4 && this.petInfo_ != PetNewHandler.PetDataInfo.getDefaultInstance()) {
                        this.petInfo_ = PetNewHandler.PetDataInfo.newBuilder(this.petInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.petInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.petInfoBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }


            public Builder clearPetInfo() {
                if (this.petInfoBuilder_ == null) {
                    this.petInfo_ = PetNewHandler.PetDataInfo.getDefaultInstance();
                    onChanged();
                } else {
                    this.petInfoBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }


            public PetNewHandler.PetDataInfo.Builder getPetInfoBuilder() {
                this.bitField0_ |= 0x4;
                onChanged();
                return (PetNewHandler.PetDataInfo.Builder) getPetInfoFieldBuilder().getBuilder();
            }


            public PetNewHandler.PetDataInfoOrBuilder getPetInfoOrBuilder() {
                if (this.petInfoBuilder_ != null) {
                    return (PetNewHandler.PetDataInfoOrBuilder) this.petInfoBuilder_.getMessageOrBuilder();
                }
                return this.petInfo_;
            }


            private SingleFieldBuilder<PetNewHandler.PetDataInfo, PetNewHandler.PetDataInfo.Builder, PetNewHandler.PetDataInfoOrBuilder> getPetInfoFieldBuilder() {
                if (this.petInfoBuilder_ == null) {
                    this.petInfoBuilder_ = new SingleFieldBuilder(getPetInfo(), getParentForChildren(), isClean());
                    this.petInfo_ = null;
                }
                return this.petInfoBuilder_;
            }
        }
    }


    public static final class ChangePetNameNewRequest
            extends GeneratedMessage
            implements ChangePetNameNewRequestOrBuilder {
        private static final ChangePetNameNewRequest defaultInstance = new ChangePetNameNewRequest(true);
        private final UnknownFieldSet unknownFields;

        private ChangePetNameNewRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private ChangePetNameNewRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static ChangePetNameNewRequest getDefaultInstance() {
            return defaultInstance;
        }

        public ChangePetNameNewRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ChangePetNameNewRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.c2SId_ = input.readInt32();
                            break;
                        case 18:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x2;
                            this.c2SName_ = bs;
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
            return PetNewHandler.internal_static_pomelo_area_ChangePetNameNewRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return PetNewHandler.internal_static_pomelo_area_ChangePetNameNewRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ChangePetNameNewRequest.class, Builder.class);
        }

        public static Parser<ChangePetNameNewRequest> PARSER = (Parser<ChangePetNameNewRequest>) new AbstractParser<ChangePetNameNewRequest>() {
            public PetNewHandler.ChangePetNameNewRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PetNewHandler.ChangePetNameNewRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_ID_FIELD_NUMBER = 1;
        private int c2SId_;
        public static final int C2S_NAME_FIELD_NUMBER = 2;
        private Object c2SName_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<ChangePetNameNewRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasC2SId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getC2SId() {
            return this.c2SId_;
        }

        public boolean hasC2SName() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        static {
            defaultInstance.initFields();
        }


        public String getC2SName() {
            Object ref = this.c2SName_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.c2SName_ = s;
            }
            return s;
        }


        public ByteString getC2SNameBytes() {
            Object ref = this.c2SName_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.c2SName_ = b;
                return b;
            }
            return (ByteString) ref;
        }


        private void initFields() {
            this.c2SId_ = 0;
            this.c2SName_ = "";
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasC2SId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasC2SName()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeInt32(1, this.c2SId_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeBytes(2, getC2SNameBytes());
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
                size += CodedOutputStream.computeInt32Size(1, this.c2SId_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeBytesSize(2, getC2SNameBytes());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static ChangePetNameNewRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ChangePetNameNewRequest) PARSER.parseFrom(data);
        }


        public static ChangePetNameNewRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ChangePetNameNewRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static ChangePetNameNewRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ChangePetNameNewRequest) PARSER.parseFrom(data);
        }


        public static ChangePetNameNewRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ChangePetNameNewRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static ChangePetNameNewRequest parseFrom(InputStream input) throws IOException {
            return (ChangePetNameNewRequest) PARSER.parseFrom(input);
        }


        public static ChangePetNameNewRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChangePetNameNewRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static ChangePetNameNewRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (ChangePetNameNewRequest) PARSER.parseDelimitedFrom(input);
        }


        public static ChangePetNameNewRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChangePetNameNewRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static ChangePetNameNewRequest parseFrom(CodedInputStream input) throws IOException {
            return (ChangePetNameNewRequest) PARSER.parseFrom(input);
        }


        public static ChangePetNameNewRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChangePetNameNewRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(ChangePetNameNewRequest prototype) {
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
                implements PetNewHandler.ChangePetNameNewRequestOrBuilder {
            private int bitField0_;


            private int c2SId_;


            private Object c2SName_;


            public static final Descriptors.Descriptor getDescriptor() {
                return PetNewHandler.internal_static_pomelo_area_ChangePetNameNewRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PetNewHandler.internal_static_pomelo_area_ChangePetNameNewRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(PetNewHandler.ChangePetNameNewRequest.class, Builder.class);
            }


            private Builder() {
                this.c2SName_ = "";
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.c2SName_ = "";
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (PetNewHandler.ChangePetNameNewRequest.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.c2SId_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SName_ = "";
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return PetNewHandler.internal_static_pomelo_area_ChangePetNameNewRequest_descriptor;
            }


            public PetNewHandler.ChangePetNameNewRequest getDefaultInstanceForType() {
                return PetNewHandler.ChangePetNameNewRequest.getDefaultInstance();
            }


            public PetNewHandler.ChangePetNameNewRequest build() {
                PetNewHandler.ChangePetNameNewRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public PetNewHandler.ChangePetNameNewRequest buildPartial() {
                PetNewHandler.ChangePetNameNewRequest result = new PetNewHandler.ChangePetNameNewRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.c2SId_ = this.c2SId_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.c2SName_ = this.c2SName_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof PetNewHandler.ChangePetNameNewRequest) {
                    return mergeFrom((PetNewHandler.ChangePetNameNewRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(PetNewHandler.ChangePetNameNewRequest other) {
                if (other == PetNewHandler.ChangePetNameNewRequest.getDefaultInstance()) {
                    return this;
                }
                if (other.hasC2SId()) {
                    setC2SId(other.getC2SId());
                }
                if (other.hasC2SName()) {
                    this.bitField0_ |= 0x2;
                    this.c2SName_ = other.c2SName_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasC2SId()) {
                    return false;
                }
                if (!hasC2SName()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                PetNewHandler.ChangePetNameNewRequest parsedMessage = null;
                try {
                    parsedMessage = (PetNewHandler.ChangePetNameNewRequest) PetNewHandler.ChangePetNameNewRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (PetNewHandler.ChangePetNameNewRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
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


            public boolean hasC2SName() {
                return ((this.bitField0_ & 0x2) == 2);
            }


            public String getC2SName() {
                Object ref = this.c2SName_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.c2SName_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }


            public ByteString getC2SNameBytes() {
                Object ref = this.c2SName_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.c2SName_ = b;
                    return b;
                }
                return (ByteString) ref;
            }


            public Builder setC2SName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x2;
                this.c2SName_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SName() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.c2SName_ = PetNewHandler.ChangePetNameNewRequest.getDefaultInstance().getC2SName();
                onChanged();
                return this;
            }


            public Builder setC2SNameBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x2;
                this.c2SName_ = value;
                onChanged();
                return this;
            }
        }
    }


    public static final class ChangePetNameNewResponse
            extends GeneratedMessage
            implements ChangePetNameNewResponseOrBuilder {
        private static final ChangePetNameNewResponse defaultInstance = new ChangePetNameNewResponse(true);
        private final UnknownFieldSet unknownFields;

        private ChangePetNameNewResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private ChangePetNameNewResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static ChangePetNameNewResponse getDefaultInstance() {
            return defaultInstance;
        }

        public ChangePetNameNewResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ChangePetNameNewResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString bs;
                    PetNewHandler.PetDataInfo.Builder subBuilder;
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
                            if ((this.bitField0_ & 0x4) == 4) subBuilder = this.petInfo_.toBuilder();
                            this.petInfo_ = (PetNewHandler.PetDataInfo) input.readMessage(PetNewHandler.PetDataInfo.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.petInfo_);
                                this.petInfo_ = subBuilder.buildPartial();
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
            return PetNewHandler.internal_static_pomelo_area_ChangePetNameNewResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return PetNewHandler.internal_static_pomelo_area_ChangePetNameNewResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ChangePetNameNewResponse.class, Builder.class);
        }

        public static Parser<ChangePetNameNewResponse> PARSER = (Parser<ChangePetNameNewResponse>) new AbstractParser<ChangePetNameNewResponse>() {
            public PetNewHandler.ChangePetNameNewResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PetNewHandler.ChangePetNameNewResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int PETINFO_FIELD_NUMBER = 3;
        private PetNewHandler.PetDataInfo petInfo_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<ChangePetNameNewResponse> getParserForType() {
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


        public boolean hasPetInfo() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public PetNewHandler.PetDataInfo getPetInfo() {
            return this.petInfo_;
        }


        public PetNewHandler.PetDataInfoOrBuilder getPetInfoOrBuilder() {
            return this.petInfo_;
        }


        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.petInfo_ = PetNewHandler.PetDataInfo.getDefaultInstance();
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
            if (hasPetInfo() && !getPetInfo().isInitialized()) {
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
                output.writeMessage(3, (MessageLite) this.petInfo_);
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
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.petInfo_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static ChangePetNameNewResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ChangePetNameNewResponse) PARSER.parseFrom(data);
        }


        public static ChangePetNameNewResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ChangePetNameNewResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static ChangePetNameNewResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ChangePetNameNewResponse) PARSER.parseFrom(data);
        }


        public static ChangePetNameNewResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ChangePetNameNewResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static ChangePetNameNewResponse parseFrom(InputStream input) throws IOException {
            return (ChangePetNameNewResponse) PARSER.parseFrom(input);
        }


        public static ChangePetNameNewResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChangePetNameNewResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static ChangePetNameNewResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (ChangePetNameNewResponse) PARSER.parseDelimitedFrom(input);
        }


        public static ChangePetNameNewResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChangePetNameNewResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static ChangePetNameNewResponse parseFrom(CodedInputStream input) throws IOException {
            return (ChangePetNameNewResponse) PARSER.parseFrom(input);
        }


        public static ChangePetNameNewResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChangePetNameNewResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(ChangePetNameNewResponse prototype) {
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
                implements PetNewHandler.ChangePetNameNewResponseOrBuilder {
            private int bitField0_;

            private int s2CCode_;

            private Object s2CMsg_;

            private PetNewHandler.PetDataInfo petInfo_;

            private SingleFieldBuilder<PetNewHandler.PetDataInfo, PetNewHandler.PetDataInfo.Builder, PetNewHandler.PetDataInfoOrBuilder> petInfoBuilder_;


            public static final Descriptors.Descriptor getDescriptor() {
                return PetNewHandler.internal_static_pomelo_area_ChangePetNameNewResponse_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PetNewHandler.internal_static_pomelo_area_ChangePetNameNewResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(PetNewHandler.ChangePetNameNewResponse.class, Builder.class);
            }


            private Builder() {
                this.s2CMsg_ = "";
                this.petInfo_ = PetNewHandler.PetDataInfo.getDefaultInstance();
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.petInfo_ = PetNewHandler.PetDataInfo.getDefaultInstance();
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (PetNewHandler.ChangePetNameNewResponse.alwaysUseFieldBuilders) {
                    getPetInfoFieldBuilder();
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
                if (this.petInfoBuilder_ == null) {
                    this.petInfo_ = PetNewHandler.PetDataInfo.getDefaultInstance();
                } else {
                    this.petInfoBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return PetNewHandler.internal_static_pomelo_area_ChangePetNameNewResponse_descriptor;
            }


            public PetNewHandler.ChangePetNameNewResponse getDefaultInstanceForType() {
                return PetNewHandler.ChangePetNameNewResponse.getDefaultInstance();
            }


            public PetNewHandler.ChangePetNameNewResponse build() {
                PetNewHandler.ChangePetNameNewResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public PetNewHandler.ChangePetNameNewResponse buildPartial() {
                PetNewHandler.ChangePetNameNewResponse result = new PetNewHandler.ChangePetNameNewResponse(this);
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
                if (this.petInfoBuilder_ == null) {
                    result.petInfo_ = this.petInfo_;
                } else {
                    result.petInfo_ = (PetNewHandler.PetDataInfo) this.petInfoBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof PetNewHandler.ChangePetNameNewResponse) {
                    return mergeFrom((PetNewHandler.ChangePetNameNewResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(PetNewHandler.ChangePetNameNewResponse other) {
                if (other == PetNewHandler.ChangePetNameNewResponse.getDefaultInstance()) {
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
                if (other.hasPetInfo()) {
                    mergePetInfo(other.getPetInfo());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasS2CCode()) {
                    return false;
                }
                if (hasPetInfo() && !getPetInfo().isInitialized()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                PetNewHandler.ChangePetNameNewResponse parsedMessage = null;
                try {
                    parsedMessage = (PetNewHandler.ChangePetNameNewResponse) PetNewHandler.ChangePetNameNewResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (PetNewHandler.ChangePetNameNewResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = PetNewHandler.ChangePetNameNewResponse.getDefaultInstance().getS2CMsg();
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

            public boolean hasPetInfo() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public PetNewHandler.PetDataInfo getPetInfo() {
                if (this.petInfoBuilder_ == null) {
                    return this.petInfo_;
                }
                return (PetNewHandler.PetDataInfo) this.petInfoBuilder_.getMessage();
            }

            public Builder setPetInfo(PetNewHandler.PetDataInfo value) {
                if (this.petInfoBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.petInfo_ = value;
                    onChanged();
                } else {
                    this.petInfoBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder setPetInfo(PetNewHandler.PetDataInfo.Builder builderForValue) {
                if (this.petInfoBuilder_ == null) {
                    this.petInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.petInfoBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder mergePetInfo(PetNewHandler.PetDataInfo value) {
                if (this.petInfoBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4 && this.petInfo_ != PetNewHandler.PetDataInfo.getDefaultInstance()) {
                        this.petInfo_ = PetNewHandler.PetDataInfo.newBuilder(this.petInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.petInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.petInfoBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder clearPetInfo() {
                if (this.petInfoBuilder_ == null) {
                    this.petInfo_ = PetNewHandler.PetDataInfo.getDefaultInstance();
                    onChanged();
                } else {
                    this.petInfoBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public PetNewHandler.PetDataInfo.Builder getPetInfoBuilder() {
                this.bitField0_ |= 0x4;
                onChanged();
                return (PetNewHandler.PetDataInfo.Builder) getPetInfoFieldBuilder().getBuilder();
            }

            public PetNewHandler.PetDataInfoOrBuilder getPetInfoOrBuilder() {
                if (this.petInfoBuilder_ != null) {
                    return (PetNewHandler.PetDataInfoOrBuilder) this.petInfoBuilder_.getMessageOrBuilder();
                }
                return this.petInfo_;
            }

            private SingleFieldBuilder<PetNewHandler.PetDataInfo, PetNewHandler.PetDataInfo.Builder, PetNewHandler.PetDataInfoOrBuilder> getPetInfoFieldBuilder() {
                if (this.petInfoBuilder_ == null) {
                    this.petInfoBuilder_ = new SingleFieldBuilder(getPetInfo(), getParentForChildren(), isClean());
                    this.petInfo_ = null;
                }
                return this.petInfoBuilder_;
            }
        }
    }

    public static final class PetFightRequest
            extends GeneratedMessage
            implements PetFightRequestOrBuilder {
        private static final PetFightRequest defaultInstance = new PetFightRequest(true);
        private final UnknownFieldSet unknownFields;

        private PetFightRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private PetFightRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static PetFightRequest getDefaultInstance() {
            return defaultInstance;
        }

        public PetFightRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PetFightRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return PetNewHandler.internal_static_pomelo_area_PetFightRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return PetNewHandler.internal_static_pomelo_area_PetFightRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(PetFightRequest.class, Builder.class);
        }

        public static Parser<PetFightRequest> PARSER = (Parser<PetFightRequest>) new AbstractParser<PetFightRequest>() {
            public PetNewHandler.PetFightRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PetNewHandler.PetFightRequest(input, extensionRegistry);
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

        public Parser<PetFightRequest> getParserForType() {
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

        static {
            defaultInstance.initFields();
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
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
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
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeInt32(1, this.c2SId_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeInt32(2, this.c2SType_);
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
                size += CodedOutputStream.computeInt32Size(1, this.c2SId_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeInt32Size(2, this.c2SType_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static PetFightRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (PetFightRequest) PARSER.parseFrom(data);
        }


        public static PetFightRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (PetFightRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static PetFightRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (PetFightRequest) PARSER.parseFrom(data);
        }


        public static PetFightRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (PetFightRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static PetFightRequest parseFrom(InputStream input) throws IOException {
            return (PetFightRequest) PARSER.parseFrom(input);
        }


        public static PetFightRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PetFightRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static PetFightRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (PetFightRequest) PARSER.parseDelimitedFrom(input);
        }


        public static PetFightRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PetFightRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static PetFightRequest parseFrom(CodedInputStream input) throws IOException {
            return (PetFightRequest) PARSER.parseFrom(input);
        }


        public static PetFightRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PetFightRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(PetFightRequest prototype) {
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
                implements PetNewHandler.PetFightRequestOrBuilder {
            private int bitField0_;


            private int c2SId_;


            private int c2SType_;


            public static final Descriptors.Descriptor getDescriptor() {
                return PetNewHandler.internal_static_pomelo_area_PetFightRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PetNewHandler.internal_static_pomelo_area_PetFightRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(PetNewHandler.PetFightRequest.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (PetNewHandler.PetFightRequest.alwaysUseFieldBuilders) ;
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
                return PetNewHandler.internal_static_pomelo_area_PetFightRequest_descriptor;
            }


            public PetNewHandler.PetFightRequest getDefaultInstanceForType() {
                return PetNewHandler.PetFightRequest.getDefaultInstance();
            }


            public PetNewHandler.PetFightRequest build() {
                PetNewHandler.PetFightRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public PetNewHandler.PetFightRequest buildPartial() {
                PetNewHandler.PetFightRequest result = new PetNewHandler.PetFightRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.c2SId_ = this.c2SId_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.c2SType_ = this.c2SType_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof PetNewHandler.PetFightRequest) {
                    return mergeFrom((PetNewHandler.PetFightRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(PetNewHandler.PetFightRequest other) {
                if (other == PetNewHandler.PetFightRequest.getDefaultInstance()) {
                    return this;
                }
                if (other.hasC2SId()) {
                    setC2SId(other.getC2SId());
                }
                if (other.hasC2SType()) {
                    setC2SType(other.getC2SType());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasC2SId()) {
                    return false;
                }
                if (!hasC2SType()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                PetNewHandler.PetFightRequest parsedMessage = null;
                try {
                    parsedMessage = (PetNewHandler.PetFightRequest) PetNewHandler.PetFightRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (PetNewHandler.PetFightRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
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
    }


    public static final class PetFightResponse
            extends GeneratedMessage
            implements PetFightResponseOrBuilder {
        private static final PetFightResponse defaultInstance = new PetFightResponse(true);
        private final UnknownFieldSet unknownFields;

        private PetFightResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private PetFightResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static PetFightResponse getDefaultInstance() {
            return defaultInstance;
        }

        public PetFightResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PetFightResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return PetNewHandler.internal_static_pomelo_area_PetFightResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return PetNewHandler.internal_static_pomelo_area_PetFightResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(PetFightResponse.class, Builder.class);
        }

        public static Parser<PetFightResponse> PARSER = (Parser<PetFightResponse>) new AbstractParser<PetFightResponse>() {
            public PetNewHandler.PetFightResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PetNewHandler.PetFightResponse(input, extensionRegistry);
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

        public Parser<PetFightResponse> getParserForType() {
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


        public static PetFightResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (PetFightResponse) PARSER.parseFrom(data);
        }


        public static PetFightResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (PetFightResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static PetFightResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (PetFightResponse) PARSER.parseFrom(data);
        }


        public static PetFightResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (PetFightResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static PetFightResponse parseFrom(InputStream input) throws IOException {
            return (PetFightResponse) PARSER.parseFrom(input);
        }


        public static PetFightResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PetFightResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static PetFightResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (PetFightResponse) PARSER.parseDelimitedFrom(input);
        }


        public static PetFightResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PetFightResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static PetFightResponse parseFrom(CodedInputStream input) throws IOException {
            return (PetFightResponse) PARSER.parseFrom(input);
        }


        public static PetFightResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PetFightResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(PetFightResponse prototype) {
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
                implements PetNewHandler.PetFightResponseOrBuilder {
            private int bitField0_;


            private int s2CCode_;


            private Object s2CMsg_;


            public static final Descriptors.Descriptor getDescriptor() {
                return PetNewHandler.internal_static_pomelo_area_PetFightResponse_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PetNewHandler.internal_static_pomelo_area_PetFightResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(PetNewHandler.PetFightResponse.class, Builder.class);
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
                if (PetNewHandler.PetFightResponse.alwaysUseFieldBuilders) ;
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
                return PetNewHandler.internal_static_pomelo_area_PetFightResponse_descriptor;
            }


            public PetNewHandler.PetFightResponse getDefaultInstanceForType() {
                return PetNewHandler.PetFightResponse.getDefaultInstance();
            }


            public PetNewHandler.PetFightResponse build() {
                PetNewHandler.PetFightResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public PetNewHandler.PetFightResponse buildPartial() {
                PetNewHandler.PetFightResponse result = new PetNewHandler.PetFightResponse(this);
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
                if (other instanceof PetNewHandler.PetFightResponse) {
                    return mergeFrom((PetNewHandler.PetFightResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(PetNewHandler.PetFightResponse other) {
                if (other == PetNewHandler.PetFightResponse.getDefaultInstance()) {
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
                PetNewHandler.PetFightResponse parsedMessage = null;
                try {
                    parsedMessage = (PetNewHandler.PetFightResponse) PetNewHandler.PetFightResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (PetNewHandler.PetFightResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = PetNewHandler.PetFightResponse.getDefaultInstance().getS2CMsg();
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


    public static final class GetPetInfoNewRequest
            extends GeneratedMessage
            implements GetPetInfoNewRequestOrBuilder {
        private static final GetPetInfoNewRequest defaultInstance = new GetPetInfoNewRequest(true);
        private final UnknownFieldSet unknownFields;

        private GetPetInfoNewRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetPetInfoNewRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetPetInfoNewRequest getDefaultInstance() {
            return defaultInstance;
        }

        public GetPetInfoNewRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetPetInfoNewRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.c2SPetId_ = input.readInt32();
                            break;
                        case 18:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x2;
                            this.c2SOwnId_ = bs;
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
            return PetNewHandler.internal_static_pomelo_area_GetPetInfoNewRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return PetNewHandler.internal_static_pomelo_area_GetPetInfoNewRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetPetInfoNewRequest.class, Builder.class);
        }

        public static Parser<GetPetInfoNewRequest> PARSER = (Parser<GetPetInfoNewRequest>) new AbstractParser<GetPetInfoNewRequest>() {
            public PetNewHandler.GetPetInfoNewRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PetNewHandler.GetPetInfoNewRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_PETID_FIELD_NUMBER = 1;
        private int c2SPetId_;
        public static final int C2S_OWNID_FIELD_NUMBER = 2;
        private Object c2SOwnId_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetPetInfoNewRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasC2SPetId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getC2SPetId() {
            return this.c2SPetId_;
        }

        public boolean hasC2SOwnId() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        static {
            defaultInstance.initFields();
        }


        public String getC2SOwnId() {
            Object ref = this.c2SOwnId_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.c2SOwnId_ = s;
            }
            return s;
        }


        public ByteString getC2SOwnIdBytes() {
            Object ref = this.c2SOwnId_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.c2SOwnId_ = b;
                return b;
            }
            return (ByteString) ref;
        }


        private void initFields() {
            this.c2SPetId_ = 0;
            this.c2SOwnId_ = "";
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasC2SPetId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasC2SOwnId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeInt32(1, this.c2SPetId_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeBytes(2, getC2SOwnIdBytes());
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
                size += CodedOutputStream.computeInt32Size(1, this.c2SPetId_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeBytesSize(2, getC2SOwnIdBytes());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static GetPetInfoNewRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetPetInfoNewRequest) PARSER.parseFrom(data);
        }


        public static GetPetInfoNewRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetPetInfoNewRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetPetInfoNewRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetPetInfoNewRequest) PARSER.parseFrom(data);
        }


        public static GetPetInfoNewRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetPetInfoNewRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetPetInfoNewRequest parseFrom(InputStream input) throws IOException {
            return (GetPetInfoNewRequest) PARSER.parseFrom(input);
        }


        public static GetPetInfoNewRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetPetInfoNewRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static GetPetInfoNewRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (GetPetInfoNewRequest) PARSER.parseDelimitedFrom(input);
        }


        public static GetPetInfoNewRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetPetInfoNewRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static GetPetInfoNewRequest parseFrom(CodedInputStream input) throws IOException {
            return (GetPetInfoNewRequest) PARSER.parseFrom(input);
        }


        public static GetPetInfoNewRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetPetInfoNewRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(GetPetInfoNewRequest prototype) {
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
                implements PetNewHandler.GetPetInfoNewRequestOrBuilder {
            private int bitField0_;


            private int c2SPetId_;


            private Object c2SOwnId_;


            public static final Descriptors.Descriptor getDescriptor() {
                return PetNewHandler.internal_static_pomelo_area_GetPetInfoNewRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PetNewHandler.internal_static_pomelo_area_GetPetInfoNewRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(PetNewHandler.GetPetInfoNewRequest.class, Builder.class);
            }


            private Builder() {
                this.c2SOwnId_ = "";
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.c2SOwnId_ = "";
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (PetNewHandler.GetPetInfoNewRequest.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.c2SPetId_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SOwnId_ = "";
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return PetNewHandler.internal_static_pomelo_area_GetPetInfoNewRequest_descriptor;
            }


            public PetNewHandler.GetPetInfoNewRequest getDefaultInstanceForType() {
                return PetNewHandler.GetPetInfoNewRequest.getDefaultInstance();
            }


            public PetNewHandler.GetPetInfoNewRequest build() {
                PetNewHandler.GetPetInfoNewRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public PetNewHandler.GetPetInfoNewRequest buildPartial() {
                PetNewHandler.GetPetInfoNewRequest result = new PetNewHandler.GetPetInfoNewRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.c2SPetId_ = this.c2SPetId_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.c2SOwnId_ = this.c2SOwnId_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof PetNewHandler.GetPetInfoNewRequest) {
                    return mergeFrom((PetNewHandler.GetPetInfoNewRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(PetNewHandler.GetPetInfoNewRequest other) {
                if (other == PetNewHandler.GetPetInfoNewRequest.getDefaultInstance()) {
                    return this;
                }
                if (other.hasC2SPetId()) {
                    setC2SPetId(other.getC2SPetId());
                }
                if (other.hasC2SOwnId()) {
                    this.bitField0_ |= 0x2;
                    this.c2SOwnId_ = other.c2SOwnId_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasC2SPetId()) {
                    return false;
                }
                if (!hasC2SOwnId()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                PetNewHandler.GetPetInfoNewRequest parsedMessage = null;
                try {
                    parsedMessage = (PetNewHandler.GetPetInfoNewRequest) PetNewHandler.GetPetInfoNewRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (PetNewHandler.GetPetInfoNewRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasC2SPetId() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public int getC2SPetId() {
                return this.c2SPetId_;
            }


            public Builder setC2SPetId(int value) {
                this.bitField0_ |= 0x1;
                this.c2SPetId_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SPetId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SPetId_ = 0;
                onChanged();
                return this;
            }


            public boolean hasC2SOwnId() {
                return ((this.bitField0_ & 0x2) == 2);
            }


            public String getC2SOwnId() {
                Object ref = this.c2SOwnId_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.c2SOwnId_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }


            public ByteString getC2SOwnIdBytes() {
                Object ref = this.c2SOwnId_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.c2SOwnId_ = b;
                    return b;
                }
                return (ByteString) ref;
            }


            public Builder setC2SOwnId(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x2;
                this.c2SOwnId_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SOwnId() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.c2SOwnId_ = PetNewHandler.GetPetInfoNewRequest.getDefaultInstance().getC2SOwnId();
                onChanged();
                return this;
            }


            public Builder setC2SOwnIdBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x2;
                this.c2SOwnId_ = value;
                onChanged();
                return this;
            }
        }
    }


    public static final class GetPetInfoNewResponse
            extends GeneratedMessage
            implements GetPetInfoNewResponseOrBuilder {
        private static final GetPetInfoNewResponse defaultInstance = new GetPetInfoNewResponse(true);
        private final UnknownFieldSet unknownFields;

        private GetPetInfoNewResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetPetInfoNewResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetPetInfoNewResponse getDefaultInstance() {
            return defaultInstance;
        }

        public GetPetInfoNewResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetPetInfoNewResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString bs;
                    PetNewHandler.PetDataInfo.Builder subBuilder;
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
                            if ((this.bitField0_ & 0x4) == 4) subBuilder = this.s2CPet_.toBuilder();
                            this.s2CPet_ = (PetNewHandler.PetDataInfo) input.readMessage(PetNewHandler.PetDataInfo.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.s2CPet_);
                                this.s2CPet_ = subBuilder.buildPartial();
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
            return PetNewHandler.internal_static_pomelo_area_GetPetInfoNewResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return PetNewHandler.internal_static_pomelo_area_GetPetInfoNewResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetPetInfoNewResponse.class, Builder.class);
        }

        public static Parser<GetPetInfoNewResponse> PARSER = (Parser<GetPetInfoNewResponse>) new AbstractParser<GetPetInfoNewResponse>() {
            public PetNewHandler.GetPetInfoNewResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PetNewHandler.GetPetInfoNewResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_PET_FIELD_NUMBER = 3;
        private PetNewHandler.PetDataInfo s2CPet_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetPetInfoNewResponse> getParserForType() {
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


        public boolean hasS2CPet() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public PetNewHandler.PetDataInfo getS2CPet() {
            return this.s2CPet_;
        }


        public PetNewHandler.PetDataInfoOrBuilder getS2CPetOrBuilder() {
            return this.s2CPet_;
        }


        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CPet_ = PetNewHandler.PetDataInfo.getDefaultInstance();
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
            if (hasS2CPet() && !getS2CPet().isInitialized()) {
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
                output.writeMessage(3, (MessageLite) this.s2CPet_);
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
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.s2CPet_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static GetPetInfoNewResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetPetInfoNewResponse) PARSER.parseFrom(data);
        }


        public static GetPetInfoNewResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetPetInfoNewResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetPetInfoNewResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetPetInfoNewResponse) PARSER.parseFrom(data);
        }


        public static GetPetInfoNewResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetPetInfoNewResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetPetInfoNewResponse parseFrom(InputStream input) throws IOException {
            return (GetPetInfoNewResponse) PARSER.parseFrom(input);
        }


        public static GetPetInfoNewResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetPetInfoNewResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static GetPetInfoNewResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (GetPetInfoNewResponse) PARSER.parseDelimitedFrom(input);
        }


        public static GetPetInfoNewResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetPetInfoNewResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static GetPetInfoNewResponse parseFrom(CodedInputStream input) throws IOException {
            return (GetPetInfoNewResponse) PARSER.parseFrom(input);
        }


        public static GetPetInfoNewResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetPetInfoNewResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(GetPetInfoNewResponse prototype) {
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
                implements PetNewHandler.GetPetInfoNewResponseOrBuilder {
            private int bitField0_;


            private int s2CCode_;


            private Object s2CMsg_;


            private PetNewHandler.PetDataInfo s2CPet_;


            private SingleFieldBuilder<PetNewHandler.PetDataInfo, PetNewHandler.PetDataInfo.Builder, PetNewHandler.PetDataInfoOrBuilder> s2CPetBuilder_;


            public static final Descriptors.Descriptor getDescriptor() {
                return PetNewHandler.internal_static_pomelo_area_GetPetInfoNewResponse_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PetNewHandler.internal_static_pomelo_area_GetPetInfoNewResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(PetNewHandler.GetPetInfoNewResponse.class, Builder.class);
            }


            private Builder() {
                this.s2CMsg_ = "";
                this.s2CPet_ = PetNewHandler.PetDataInfo.getDefaultInstance();
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CPet_ = PetNewHandler.PetDataInfo.getDefaultInstance();
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (PetNewHandler.GetPetInfoNewResponse.alwaysUseFieldBuilders) {
                    getS2CPetFieldBuilder();
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
                if (this.s2CPetBuilder_ == null) {
                    this.s2CPet_ = PetNewHandler.PetDataInfo.getDefaultInstance();
                } else {
                    this.s2CPetBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return PetNewHandler.internal_static_pomelo_area_GetPetInfoNewResponse_descriptor;
            }


            public PetNewHandler.GetPetInfoNewResponse getDefaultInstanceForType() {
                return PetNewHandler.GetPetInfoNewResponse.getDefaultInstance();
            }


            public PetNewHandler.GetPetInfoNewResponse build() {
                PetNewHandler.GetPetInfoNewResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public PetNewHandler.GetPetInfoNewResponse buildPartial() {
                PetNewHandler.GetPetInfoNewResponse result = new PetNewHandler.GetPetInfoNewResponse(this);
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
                if (this.s2CPetBuilder_ == null) {
                    result.s2CPet_ = this.s2CPet_;
                } else {
                    result.s2CPet_ = (PetNewHandler.PetDataInfo) this.s2CPetBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof PetNewHandler.GetPetInfoNewResponse) {
                    return mergeFrom((PetNewHandler.GetPetInfoNewResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(PetNewHandler.GetPetInfoNewResponse other) {
                if (other == PetNewHandler.GetPetInfoNewResponse.getDefaultInstance()) {
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
                if (other.hasS2CPet()) {
                    mergeS2CPet(other.getS2CPet());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasS2CCode()) {
                    return false;
                }
                if (hasS2CPet() && !getS2CPet().isInitialized()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                PetNewHandler.GetPetInfoNewResponse parsedMessage = null;
                try {
                    parsedMessage = (PetNewHandler.GetPetInfoNewResponse) PetNewHandler.GetPetInfoNewResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (PetNewHandler.GetPetInfoNewResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = PetNewHandler.GetPetInfoNewResponse.getDefaultInstance().getS2CMsg();
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


            public boolean hasS2CPet() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public PetNewHandler.PetDataInfo getS2CPet() {
                if (this.s2CPetBuilder_ == null) {
                    return this.s2CPet_;
                }
                return (PetNewHandler.PetDataInfo) this.s2CPetBuilder_.getMessage();
            }


            public Builder setS2CPet(PetNewHandler.PetDataInfo value) {
                if (this.s2CPetBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.s2CPet_ = value;
                    onChanged();
                } else {
                    this.s2CPetBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }


            public Builder setS2CPet(PetNewHandler.PetDataInfo.Builder builderForValue) {
                if (this.s2CPetBuilder_ == null) {
                    this.s2CPet_ = builderForValue.build();
                    onChanged();
                } else {
                    this.s2CPetBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x4;
                return this;
            }


            public Builder mergeS2CPet(PetNewHandler.PetDataInfo value) {
                if (this.s2CPetBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4 && this.s2CPet_ != PetNewHandler.PetDataInfo.getDefaultInstance()) {
                        this.s2CPet_ = PetNewHandler.PetDataInfo.newBuilder(this.s2CPet_).mergeFrom(value).buildPartial();
                    } else {
                        this.s2CPet_ = value;
                    }
                    onChanged();
                } else {
                    this.s2CPetBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }


            public Builder clearS2CPet() {
                if (this.s2CPetBuilder_ == null) {
                    this.s2CPet_ = PetNewHandler.PetDataInfo.getDefaultInstance();
                    onChanged();
                } else {
                    this.s2CPetBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }


            public PetNewHandler.PetDataInfo.Builder getS2CPetBuilder() {
                this.bitField0_ |= 0x4;
                onChanged();
                return (PetNewHandler.PetDataInfo.Builder) getS2CPetFieldBuilder().getBuilder();
            }


            public PetNewHandler.PetDataInfoOrBuilder getS2CPetOrBuilder() {
                if (this.s2CPetBuilder_ != null) {
                    return (PetNewHandler.PetDataInfoOrBuilder) this.s2CPetBuilder_.getMessageOrBuilder();
                }
                return this.s2CPet_;
            }


            private SingleFieldBuilder<PetNewHandler.PetDataInfo, PetNewHandler.PetDataInfo.Builder, PetNewHandler.PetDataInfoOrBuilder> getS2CPetFieldBuilder() {
                if (this.s2CPetBuilder_ == null) {
                    this.s2CPetBuilder_ = new SingleFieldBuilder(getS2CPet(), getParentForChildren(), isClean());
                    this.s2CPet_ = null;
                }
                return this.s2CPetBuilder_;
            }
        }
    }


    public static final class OnNewPetDetailPush
            extends GeneratedMessage
            implements OnNewPetDetailPushOrBuilder {
        private static final OnNewPetDetailPush defaultInstance = new OnNewPetDetailPush(true);
        private final UnknownFieldSet unknownFields;

        private OnNewPetDetailPush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private OnNewPetDetailPush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static OnNewPetDetailPush getDefaultInstance() {
            return defaultInstance;
        }

        public OnNewPetDetailPush getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private OnNewPetDetailPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString bs;
                    PetNewHandler.PetDataInfo.Builder subBuilder;
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
                            if ((this.bitField0_ & 0x4) == 4) subBuilder = this.petInfo_.toBuilder();
                            this.petInfo_ = (PetNewHandler.PetDataInfo) input.readMessage(PetNewHandler.PetDataInfo.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.petInfo_);
                                this.petInfo_ = subBuilder.buildPartial();
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
            return PetNewHandler.internal_static_pomelo_area_OnNewPetDetailPush_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return PetNewHandler.internal_static_pomelo_area_OnNewPetDetailPush_fieldAccessorTable.ensureFieldAccessorsInitialized(OnNewPetDetailPush.class, Builder.class);
        }

        public static Parser<OnNewPetDetailPush> PARSER = (Parser<OnNewPetDetailPush>) new AbstractParser<OnNewPetDetailPush>() {
            public PetNewHandler.OnNewPetDetailPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PetNewHandler.OnNewPetDetailPush(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int PETINFO_FIELD_NUMBER = 3;
        private PetNewHandler.PetDataInfo petInfo_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<OnNewPetDetailPush> getParserForType() {
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


        public boolean hasPetInfo() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public PetNewHandler.PetDataInfo getPetInfo() {
            return this.petInfo_;
        }


        public PetNewHandler.PetDataInfoOrBuilder getPetInfoOrBuilder() {
            return this.petInfo_;
        }


        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.petInfo_ = PetNewHandler.PetDataInfo.getDefaultInstance();
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
            if (hasPetInfo() && !getPetInfo().isInitialized()) {
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
                output.writeMessage(3, (MessageLite) this.petInfo_);
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
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.petInfo_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static OnNewPetDetailPush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (OnNewPetDetailPush) PARSER.parseFrom(data);
        }


        public static OnNewPetDetailPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (OnNewPetDetailPush) PARSER.parseFrom(data, extensionRegistry);
        }


        public static OnNewPetDetailPush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (OnNewPetDetailPush) PARSER.parseFrom(data);
        }


        public static OnNewPetDetailPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (OnNewPetDetailPush) PARSER.parseFrom(data, extensionRegistry);
        }


        public static OnNewPetDetailPush parseFrom(InputStream input) throws IOException {
            return (OnNewPetDetailPush) PARSER.parseFrom(input);
        }


        public static OnNewPetDetailPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OnNewPetDetailPush) PARSER.parseFrom(input, extensionRegistry);
        }


        public static OnNewPetDetailPush parseDelimitedFrom(InputStream input) throws IOException {
            return (OnNewPetDetailPush) PARSER.parseDelimitedFrom(input);
        }


        public static OnNewPetDetailPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OnNewPetDetailPush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static OnNewPetDetailPush parseFrom(CodedInputStream input) throws IOException {
            return (OnNewPetDetailPush) PARSER.parseFrom(input);
        }


        public static OnNewPetDetailPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OnNewPetDetailPush) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(OnNewPetDetailPush prototype) {
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
                implements PetNewHandler.OnNewPetDetailPushOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private PetNewHandler.PetDataInfo petInfo_;
            private SingleFieldBuilder<PetNewHandler.PetDataInfo, PetNewHandler.PetDataInfo.Builder, PetNewHandler.PetDataInfoOrBuilder> petInfoBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PetNewHandler.internal_static_pomelo_area_OnNewPetDetailPush_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PetNewHandler.internal_static_pomelo_area_OnNewPetDetailPush_fieldAccessorTable.ensureFieldAccessorsInitialized(PetNewHandler.OnNewPetDetailPush.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.petInfo_ = PetNewHandler.PetDataInfo.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.petInfo_ = PetNewHandler.PetDataInfo.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PetNewHandler.OnNewPetDetailPush.alwaysUseFieldBuilders) {
                    getPetInfoFieldBuilder();
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
                if (this.petInfoBuilder_ == null) {
                    this.petInfo_ = PetNewHandler.PetDataInfo.getDefaultInstance();
                } else {
                    this.petInfoBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return PetNewHandler.internal_static_pomelo_area_OnNewPetDetailPush_descriptor;
            }

            public PetNewHandler.OnNewPetDetailPush getDefaultInstanceForType() {
                return PetNewHandler.OnNewPetDetailPush.getDefaultInstance();
            }

            public PetNewHandler.OnNewPetDetailPush build() {
                PetNewHandler.OnNewPetDetailPush result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public PetNewHandler.OnNewPetDetailPush buildPartial() {
                PetNewHandler.OnNewPetDetailPush result = new PetNewHandler.OnNewPetDetailPush(this);
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
                if (this.petInfoBuilder_ == null) {
                    result.petInfo_ = this.petInfo_;
                } else {
                    result.petInfo_ = (PetNewHandler.PetDataInfo) this.petInfoBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof PetNewHandler.OnNewPetDetailPush) {
                    return mergeFrom((PetNewHandler.OnNewPetDetailPush) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PetNewHandler.OnNewPetDetailPush other) {
                if (other == PetNewHandler.OnNewPetDetailPush.getDefaultInstance()) {
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
                if (other.hasPetInfo()) {
                    mergePetInfo(other.getPetInfo());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode()) {
                    return false;
                }
                if (hasPetInfo() && !getPetInfo().isInitialized()) {
                    return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                PetNewHandler.OnNewPetDetailPush parsedMessage = null;
                try {
                    parsedMessage = (PetNewHandler.OnNewPetDetailPush) PetNewHandler.OnNewPetDetailPush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (PetNewHandler.OnNewPetDetailPush) e.getUnfinishedMessage();
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
                this.s2CMsg_ = PetNewHandler.OnNewPetDetailPush.getDefaultInstance().getS2CMsg();
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

            public boolean hasPetInfo() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public PetNewHandler.PetDataInfo getPetInfo() {
                if (this.petInfoBuilder_ == null) {
                    return this.petInfo_;
                }
                return (PetNewHandler.PetDataInfo) this.petInfoBuilder_.getMessage();
            }

            public Builder setPetInfo(PetNewHandler.PetDataInfo value) {
                if (this.petInfoBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.petInfo_ = value;
                    onChanged();
                } else {
                    this.petInfoBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder setPetInfo(PetNewHandler.PetDataInfo.Builder builderForValue) {
                if (this.petInfoBuilder_ == null) {
                    this.petInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.petInfoBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder mergePetInfo(PetNewHandler.PetDataInfo value) {
                if (this.petInfoBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4 && this.petInfo_ != PetNewHandler.PetDataInfo.getDefaultInstance()) {
                        this.petInfo_ = PetNewHandler.PetDataInfo.newBuilder(this.petInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.petInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.petInfoBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder clearPetInfo() {
                if (this.petInfoBuilder_ == null) {
                    this.petInfo_ = PetNewHandler.PetDataInfo.getDefaultInstance();
                    onChanged();
                } else {
                    this.petInfoBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public PetNewHandler.PetDataInfo.Builder getPetInfoBuilder() {
                this.bitField0_ |= 0x4;
                onChanged();
                return (PetNewHandler.PetDataInfo.Builder) getPetInfoFieldBuilder().getBuilder();
            }

            public PetNewHandler.PetDataInfoOrBuilder getPetInfoOrBuilder() {
                if (this.petInfoBuilder_ != null) {
                    return (PetNewHandler.PetDataInfoOrBuilder) this.petInfoBuilder_.getMessageOrBuilder();
                }
                return this.petInfo_;
            }

            private SingleFieldBuilder<PetNewHandler.PetDataInfo, PetNewHandler.PetDataInfo.Builder, PetNewHandler.PetDataInfoOrBuilder> getPetInfoFieldBuilder() {
                if (this.petInfoBuilder_ == null) {
                    this.petInfoBuilder_ = new SingleFieldBuilder(getPetInfo(), getParentForChildren(), isClean());
                    this.petInfo_ = null;
                }
                return this.petInfoBuilder_;
            }
        }
    }

    public static final class PetExpUpdatePush
            extends GeneratedMessage
            implements PetExpUpdatePushOrBuilder {
        private static final PetExpUpdatePush defaultInstance = new PetExpUpdatePush(true);
        private final UnknownFieldSet unknownFields;

        private PetExpUpdatePush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private PetExpUpdatePush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static PetExpUpdatePush getDefaultInstance() {
            return defaultInstance;
        }

        public PetExpUpdatePush getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PetExpUpdatePush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.s2CPetId_ = input.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.s2CCurExp_ = input.readInt64();
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
            return PetNewHandler.internal_static_pomelo_area_PetExpUpdatePush_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return PetNewHandler.internal_static_pomelo_area_PetExpUpdatePush_fieldAccessorTable.ensureFieldAccessorsInitialized(PetExpUpdatePush.class, Builder.class);
        }

        public static Parser<PetExpUpdatePush> PARSER = (Parser<PetExpUpdatePush>) new AbstractParser<PetExpUpdatePush>() {
            public PetNewHandler.PetExpUpdatePush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PetNewHandler.PetExpUpdatePush(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_PETID_FIELD_NUMBER = 1;
        private int s2CPetId_;
        public static final int S2C_CUREXP_FIELD_NUMBER = 2;
        private long s2CCurExp_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<PetExpUpdatePush> getParserForType() {
            return PARSER;
        }

        public boolean hasS2CPetId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getS2CPetId() {
            return this.s2CPetId_;
        }

        public boolean hasS2CCurExp() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        static {
            defaultInstance.initFields();
        }


        public long getS2CCurExp() {
            return this.s2CCurExp_;
        }


        private void initFields() {
            this.s2CPetId_ = 0;
            this.s2CCurExp_ = 0L;
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasS2CPetId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasS2CCurExp()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeInt32(1, this.s2CPetId_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeInt64(2, this.s2CCurExp_);
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
                size += CodedOutputStream.computeInt32Size(1, this.s2CPetId_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeInt64Size(2, this.s2CCurExp_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static PetExpUpdatePush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (PetExpUpdatePush) PARSER.parseFrom(data);
        }


        public static PetExpUpdatePush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (PetExpUpdatePush) PARSER.parseFrom(data, extensionRegistry);
        }


        public static PetExpUpdatePush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (PetExpUpdatePush) PARSER.parseFrom(data);
        }


        public static PetExpUpdatePush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (PetExpUpdatePush) PARSER.parseFrom(data, extensionRegistry);
        }


        public static PetExpUpdatePush parseFrom(InputStream input) throws IOException {
            return (PetExpUpdatePush) PARSER.parseFrom(input);
        }


        public static PetExpUpdatePush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PetExpUpdatePush) PARSER.parseFrom(input, extensionRegistry);
        }


        public static PetExpUpdatePush parseDelimitedFrom(InputStream input) throws IOException {
            return (PetExpUpdatePush) PARSER.parseDelimitedFrom(input);
        }


        public static PetExpUpdatePush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PetExpUpdatePush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static PetExpUpdatePush parseFrom(CodedInputStream input) throws IOException {
            return (PetExpUpdatePush) PARSER.parseFrom(input);
        }


        public static PetExpUpdatePush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PetExpUpdatePush) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(PetExpUpdatePush prototype) {
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
                implements PetNewHandler.PetExpUpdatePushOrBuilder {
            private int bitField0_;


            private int s2CPetId_;


            private long s2CCurExp_;


            public static final Descriptors.Descriptor getDescriptor() {
                return PetNewHandler.internal_static_pomelo_area_PetExpUpdatePush_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PetNewHandler.internal_static_pomelo_area_PetExpUpdatePush_fieldAccessorTable.ensureFieldAccessorsInitialized(PetNewHandler.PetExpUpdatePush.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (PetNewHandler.PetExpUpdatePush.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.s2CPetId_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.s2CCurExp_ = 0L;
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return PetNewHandler.internal_static_pomelo_area_PetExpUpdatePush_descriptor;
            }


            public PetNewHandler.PetExpUpdatePush getDefaultInstanceForType() {
                return PetNewHandler.PetExpUpdatePush.getDefaultInstance();
            }


            public PetNewHandler.PetExpUpdatePush build() {
                PetNewHandler.PetExpUpdatePush result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public PetNewHandler.PetExpUpdatePush buildPartial() {
                PetNewHandler.PetExpUpdatePush result = new PetNewHandler.PetExpUpdatePush(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.s2CPetId_ = this.s2CPetId_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.s2CCurExp_ = this.s2CCurExp_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof PetNewHandler.PetExpUpdatePush) {
                    return mergeFrom((PetNewHandler.PetExpUpdatePush) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(PetNewHandler.PetExpUpdatePush other) {
                if (other == PetNewHandler.PetExpUpdatePush.getDefaultInstance()) {
                    return this;
                }
                if (other.hasS2CPetId()) {
                    setS2CPetId(other.getS2CPetId());
                }
                if (other.hasS2CCurExp()) {
                    setS2CCurExp(other.getS2CCurExp());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasS2CPetId()) {
                    return false;
                }
                if (!hasS2CCurExp()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                PetNewHandler.PetExpUpdatePush parsedMessage = null;
                try {
                    parsedMessage = (PetNewHandler.PetExpUpdatePush) PetNewHandler.PetExpUpdatePush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (PetNewHandler.PetExpUpdatePush) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasS2CPetId() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public int getS2CPetId() {
                return this.s2CPetId_;
            }


            public Builder setS2CPetId(int value) {
                this.bitField0_ |= 0x1;
                this.s2CPetId_ = value;
                onChanged();
                return this;
            }


            public Builder clearS2CPetId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.s2CPetId_ = 0;
                onChanged();
                return this;
            }


            public boolean hasS2CCurExp() {
                return ((this.bitField0_ & 0x2) == 2);
            }


            public long getS2CCurExp() {
                return this.s2CCurExp_;
            }


            public Builder setS2CCurExp(long value) {
                this.bitField0_ |= 0x2;
                this.s2CCurExp_ = value;
                onChanged();
                return this;
            }


            public Builder clearS2CCurExp() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.s2CCurExp_ = 0L;
                onChanged();
                return this;
            }
        }
    }


    public static final class PetInfoUpdatePush
            extends GeneratedMessage
            implements PetInfoUpdatePushOrBuilder {
        private static final PetInfoUpdatePush defaultInstance = new PetInfoUpdatePush(true);
        private final UnknownFieldSet unknownFields;

        private PetInfoUpdatePush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private PetInfoUpdatePush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static PetInfoUpdatePush getDefaultInstance() {
            return defaultInstance;
        }

        public PetInfoUpdatePush getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PetInfoUpdatePush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    PetNewHandler.PetDataInfo.Builder subBuilder;
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        case 10:
                            subBuilder = null;
                            if ((this.bitField0_ & 0x1) == 1) subBuilder = this.s2CPet_.toBuilder();
                            this.s2CPet_ = (PetNewHandler.PetDataInfo) input.readMessage(PetNewHandler.PetDataInfo.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.s2CPet_);
                                this.s2CPet_ = subBuilder.buildPartial();
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
            return PetNewHandler.internal_static_pomelo_area_PetInfoUpdatePush_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return PetNewHandler.internal_static_pomelo_area_PetInfoUpdatePush_fieldAccessorTable.ensureFieldAccessorsInitialized(PetInfoUpdatePush.class, Builder.class);
        }

        public static Parser<PetInfoUpdatePush> PARSER = (Parser<PetInfoUpdatePush>) new AbstractParser<PetInfoUpdatePush>() {
            public PetNewHandler.PetInfoUpdatePush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PetNewHandler.PetInfoUpdatePush(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_PET_FIELD_NUMBER = 1;
        private PetNewHandler.PetDataInfo s2CPet_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<PetInfoUpdatePush> getParserForType() {
            return PARSER;
        }

        public boolean hasS2CPet() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public PetNewHandler.PetDataInfo getS2CPet() {
            return this.s2CPet_;
        }

        public PetNewHandler.PetDataInfoOrBuilder getS2CPetOrBuilder() {
            return this.s2CPet_;
        }

        static {
            defaultInstance.initFields();
        }

        private void initFields() {
            this.s2CPet_ = PetNewHandler.PetDataInfo.getDefaultInstance();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1)
                return true;
            if (isInitialized == 0)
                return false;
            if (!hasS2CPet()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!getS2CPet().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1)
                output.writeMessage(1, (MessageLite) this.s2CPet_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1)
                return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1)
                size += CodedOutputStream.computeMessageSize(1, (MessageLite) this.s2CPet_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static PetInfoUpdatePush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (PetInfoUpdatePush) PARSER.parseFrom(data);
        }

        public static PetInfoUpdatePush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (PetInfoUpdatePush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static PetInfoUpdatePush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (PetInfoUpdatePush) PARSER.parseFrom(data);
        }

        public static PetInfoUpdatePush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (PetInfoUpdatePush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static PetInfoUpdatePush parseFrom(InputStream input) throws IOException {
            return (PetInfoUpdatePush) PARSER.parseFrom(input);
        }

        public static PetInfoUpdatePush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PetInfoUpdatePush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static PetInfoUpdatePush parseDelimitedFrom(InputStream input) throws IOException {
            return (PetInfoUpdatePush) PARSER.parseDelimitedFrom(input);
        }

        public static PetInfoUpdatePush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PetInfoUpdatePush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static PetInfoUpdatePush parseFrom(CodedInputStream input) throws IOException {
            return (PetInfoUpdatePush) PARSER.parseFrom(input);
        }

        public static PetInfoUpdatePush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PetInfoUpdatePush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(PetInfoUpdatePush prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements PetNewHandler.PetInfoUpdatePushOrBuilder {
            private int bitField0_;
            private PetNewHandler.PetDataInfo s2CPet_;
            private SingleFieldBuilder<PetNewHandler.PetDataInfo, PetNewHandler.PetDataInfo.Builder, PetNewHandler.PetDataInfoOrBuilder> s2CPetBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PetNewHandler.internal_static_pomelo_area_PetInfoUpdatePush_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PetNewHandler.internal_static_pomelo_area_PetInfoUpdatePush_fieldAccessorTable.ensureFieldAccessorsInitialized(PetNewHandler.PetInfoUpdatePush.class, Builder.class);
            }

            private Builder() {
                this.s2CPet_ = PetNewHandler.PetDataInfo.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CPet_ = PetNewHandler.PetDataInfo.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PetNewHandler.PetInfoUpdatePush.alwaysUseFieldBuilders)
                    getS2CPetFieldBuilder();
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                if (this.s2CPetBuilder_ == null) {
                    this.s2CPet_ = PetNewHandler.PetDataInfo.getDefaultInstance();
                } else {
                    this.s2CPetBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return PetNewHandler.internal_static_pomelo_area_PetInfoUpdatePush_descriptor;
            }

            public PetNewHandler.PetInfoUpdatePush getDefaultInstanceForType() {
                return PetNewHandler.PetInfoUpdatePush.getDefaultInstance();
            }

            public PetNewHandler.PetInfoUpdatePush build() {
                PetNewHandler.PetInfoUpdatePush result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public PetNewHandler.PetInfoUpdatePush buildPartial() {
                PetNewHandler.PetInfoUpdatePush result = new PetNewHandler.PetInfoUpdatePush(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                if (this.s2CPetBuilder_ == null) {
                    result.s2CPet_ = this.s2CPet_;
                } else {
                    result.s2CPet_ = (PetNewHandler.PetDataInfo) this.s2CPetBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof PetNewHandler.PetInfoUpdatePush)
                    return mergeFrom((PetNewHandler.PetInfoUpdatePush) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PetNewHandler.PetInfoUpdatePush other) {
                if (other == PetNewHandler.PetInfoUpdatePush.getDefaultInstance())
                    return this;
                if (other.hasS2CPet())
                    mergeS2CPet(other.getS2CPet());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CPet())
                    return false;
                if (!getS2CPet().isInitialized())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                PetNewHandler.PetInfoUpdatePush parsedMessage = null;
                try {
                    parsedMessage = (PetNewHandler.PetInfoUpdatePush) PetNewHandler.PetInfoUpdatePush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (PetNewHandler.PetInfoUpdatePush) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null)
                        mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasS2CPet() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public PetNewHandler.PetDataInfo getS2CPet() {
                if (this.s2CPetBuilder_ == null)
                    return this.s2CPet_;
                return (PetNewHandler.PetDataInfo) this.s2CPetBuilder_.getMessage();
            }

            public Builder setS2CPet(PetNewHandler.PetDataInfo value) {
                if (this.s2CPetBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    this.s2CPet_ = value;
                    onChanged();
                } else {
                    this.s2CPetBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x1;
                return this;
            }

            public Builder setS2CPet(PetNewHandler.PetDataInfo.Builder builderForValue) {
                if (this.s2CPetBuilder_ == null) {
                    this.s2CPet_ = builderForValue.build();
                    onChanged();
                } else {
                    this.s2CPetBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x1;
                return this;
            }

            public Builder mergeS2CPet(PetNewHandler.PetDataInfo value) {
                if (this.s2CPetBuilder_ == null) {
                    if ((this.bitField0_ & 0x1) == 1 && this.s2CPet_ != PetNewHandler.PetDataInfo.getDefaultInstance()) {
                        this.s2CPet_ = PetNewHandler.PetDataInfo.newBuilder(this.s2CPet_).mergeFrom(value).buildPartial();
                    } else {
                        this.s2CPet_ = value;
                    }
                    onChanged();
                } else {
                    this.s2CPetBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x1;
                return this;
            }

            public Builder clearS2CPet() {
                if (this.s2CPetBuilder_ == null) {
                    this.s2CPet_ = PetNewHandler.PetDataInfo.getDefaultInstance();
                    onChanged();
                } else {
                    this.s2CPetBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            public PetNewHandler.PetDataInfo.Builder getS2CPetBuilder() {
                this.bitField0_ |= 0x1;
                onChanged();
                return (PetNewHandler.PetDataInfo.Builder) getS2CPetFieldBuilder().getBuilder();
            }

            public PetNewHandler.PetDataInfoOrBuilder getS2CPetOrBuilder() {
                if (this.s2CPetBuilder_ != null)
                    return (PetNewHandler.PetDataInfoOrBuilder) this.s2CPetBuilder_.getMessageOrBuilder();
                return this.s2CPet_;
            }

            private SingleFieldBuilder<PetNewHandler.PetDataInfo, PetNewHandler.PetDataInfo.Builder, PetNewHandler.PetDataInfoOrBuilder> getS2CPetFieldBuilder() {
                if (this.s2CPetBuilder_ == null) {
                    this.s2CPetBuilder_ = new SingleFieldBuilder(getS2CPet(), getParentForChildren(), isClean());
                    this.s2CPet_ = null;
                }
                return this.s2CPetBuilder_;
            }
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }


    static {
        String[] descriptorData = {"\n\023petNewHandler.proto\022\013pomelo.area\032\fcommon.proto\"\027\n\025GetAllPetsInfoRequest\"G\n\rSkillDataInfo\022\n\n\002id\030\001 \002(\005\022\r\n\005level\030\002 \002(\005\022\013\n\003pos\030\003 \002(\005\022\016\n\006inborn\030\004 \002(\005\"õ\001\n\013PetDataInfo\022\n\n\002id\030\001 \002(\005\022\r\n\005level\030\002 \002(\005\022\f\n\004name\030\003 \002(\t\022\013\n\003exp\030\004 \002(\003\022,\n\013attrs_final\030\005 \003(\0132\027.pomelo.AttributeSimple\022*\n\006skills\030\007 \003(\0132\032.pomelo.area.SkillDataInfo\022\017\n\007upLevel\030\b \002(\005\022\022\n\nfightPower\030\t \002(\005\0221\n\020next_attrs_final\030\n \003(\0132\027.pomelo.AttributeSimple\"\001\n\026G", "etAllPetsInfoResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022-\n\013s2c_petInfo\030\003 \003(\0132\030.pomelo.area.PetDataInfo\022\031\n\021s2c_fightingPetId\030\004 \002(\005\"\"\n\020SummonPetRequest\022\016\n\006c2s_id\030\001 \002(\005\"I\n\021SummonPetResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\021\n\ts2c_fight\030\003 \001(\005\"'\n\025UpGradeUpLevelRequest\022\016\n\006c2s_id\030\001 \002(\005\"f\n\026UpGradeUpLevelResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022)\n\007petInfo\030\003 \001(\0132\030.pomelo.area.PetDataInfo\";\n\023AddExpByIt", "emRequest\022\016\n\006c2s_id\030\001 \002(\005\022\024\n\fc2s_itemCode\030\002 \002(\t\"d\n\024AddExpByItemResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022)\n\007petInfo\030\003 \001(\0132\030.pomelo.area.PetDataInfo\"(\n\026UpgradeOneLevelRequest\022\016\n\006c2s_id\030\001 \002(\005\"g\n\027UpgradeOneLevelResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022)\n\007petInfo\030\003 \001(\0132\030.pomelo.area.PetDataInfo\"%\n\023UpgradeToTopRequest\022\016\n\006c2s_id\030\001 \002(\005\"d\n\024UpgradeToTopResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022)\n\007pe", "tInfo\030\003 \001(\0132\030.pomelo.area.PetDataInfo\";\n\027ChangePetNameNewRequest\022\016\n\006c2s_id\030\001 \002(\005\022\020\n\bc2s_name\030\002 \002(\t\"h\n\030ChangePetNameNewResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022)\n\007petInfo\030\003 \001(\0132\030.pomelo.area.PetDataInfo\"3\n\017PetFightRequest\022\016\n\006c2s_id\030\001 \002(\005\022\020\n\bc2s_type\030\002 \002(\005\"5\n\020PetFightResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"<\n\024GetPetInfoNewRequest\022\021\n\tc2s_petId\030\001 \002(\005\022\021\n\tc2s_ownId\030\002 \002(\t\"e\n\025GetPetInfoNewResponse\022", "\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022)\n\007s2c_pet\030\003 \001(\0132\030.pomelo.area.PetDataInfo\"b\n\022OnNewPetDetailPush\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022)\n\007petInfo\030\003 \001(\0132\030.pomelo.area.PetDataInfo\"9\n\020PetExpUpdatePush\022\021\n\ts2c_petId\030\001 \002(\005\022\022\n\ns2c_curExp\030\002 \002(\003\">\n\021PetInfoUpdatePush\022)\n\007s2c_pet\030\001 \002(\0132\030.pomelo.area.PetDataInfo2Ú\006\n\rpetNewHandler\022`\n\025getAllPetsInfoRequest\022\".pomelo.area.GetAllPetsInfoRequest\032#.pomelo.area.GetAll", "PetsInfoResponse\022Q\n\020summonPetRequest\022\035.pomelo.area.SummonPetRequest\032\036.pomelo.area.SummonPetResponse\022`\n\025upGradeUpLevelRequest\022\".pomelo.area.UpGradeUpLevelRequest\032#.pomelo.area.UpGradeUpLevelResponse\022Z\n\023addExpByItemRequest\022 .pomelo.area.AddExpByItemRequest\032!.pomelo.area.AddExpByItemResponse\022c\n\026upgradeOneLevelRequest\022#.pomelo.area.UpgradeOneLevelRequest\032$.pomelo.area.UpgradeOneLevelResponse\022Z\n\023upgrad", "eToTopRequest\022 .pomelo.area.UpgradeToTopRequest\032!.pomelo.area.UpgradeToTopResponse\022f\n\027changePetNameNewRequest\022$.pomelo.area.ChangePetNameNewRequest\032%.pomelo.area.ChangePetNameNewResponse\022N\n\017petFightRequest\022\034.pomelo.area.PetFightRequest\032\035.pomelo.area.PetFightResponse\022]\n\024getPetInfoNewRequest\022!.pomelo.area.GetPetInfoNewRequest\032\".pomelo.area.GetPetInfoNewResponse2Õ\001\n\npetNewPush\022C\n\022onNewPetDetailPush\022\037", ".pomelo.area.OnNewPetDetailPush\032\f.pomelo.Void\022?\n\020petExpUpdatePush\022\035.pomelo.area.PetExpUpdatePush\032\f.pomelo.Void\022A\n\021petInfoUpdatePush\022\036.pomelo.area.PetInfoUpdatePush\032\f.pomelo.Void"};


        Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root) {
                PetNewHandler.descriptor = root;
                return null;
            }
        };

        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[]{

                Common.getDescriptor()}, assigner);
    }

    private static final Descriptors.Descriptor internal_static_pomelo_area_GetAllPetsInfoRequest_descriptor = getDescriptor().getMessageTypes().get(0);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetAllPetsInfoRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetAllPetsInfoRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_area_SkillDataInfo_descriptor = getDescriptor().getMessageTypes().get(1);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_SkillDataInfo_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_SkillDataInfo_descriptor, new String[]{"Id", "Level", "Pos", "Inborn"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_PetDataInfo_descriptor = getDescriptor().getMessageTypes().get(2);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_PetDataInfo_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_PetDataInfo_descriptor, new String[]{"Id", "Level", "Name", "Exp", "AttrsFinal", "Skills", "UpLevel", "FightPower", "NextAttrsFinal"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetAllPetsInfoResponse_descriptor = getDescriptor().getMessageTypes().get(3);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetAllPetsInfoResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetAllPetsInfoResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CPetInfo", "S2CFightingPetId"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_SummonPetRequest_descriptor = getDescriptor().getMessageTypes().get(4);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_SummonPetRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_SummonPetRequest_descriptor, new String[]{"C2SId"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_SummonPetResponse_descriptor = getDescriptor().getMessageTypes().get(5);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_SummonPetResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_SummonPetResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CFight"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_UpGradeUpLevelRequest_descriptor = getDescriptor().getMessageTypes().get(6);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_UpGradeUpLevelRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_UpGradeUpLevelRequest_descriptor, new String[]{"C2SId"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_UpGradeUpLevelResponse_descriptor = getDescriptor().getMessageTypes().get(7);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_UpGradeUpLevelResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_UpGradeUpLevelResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "PetInfo"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_AddExpByItemRequest_descriptor = getDescriptor().getMessageTypes().get(8);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_AddExpByItemRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_AddExpByItemRequest_descriptor, new String[]{"C2SId", "C2SItemCode"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_AddExpByItemResponse_descriptor = getDescriptor().getMessageTypes().get(9);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_AddExpByItemResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_AddExpByItemResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "PetInfo"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_UpgradeOneLevelRequest_descriptor = getDescriptor().getMessageTypes().get(10);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_UpgradeOneLevelRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_UpgradeOneLevelRequest_descriptor, new String[]{"C2SId"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_UpgradeOneLevelResponse_descriptor = getDescriptor().getMessageTypes().get(11);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_UpgradeOneLevelResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_UpgradeOneLevelResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "PetInfo"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_UpgradeToTopRequest_descriptor = getDescriptor().getMessageTypes().get(12);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_UpgradeToTopRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_UpgradeToTopRequest_descriptor, new String[]{"C2SId"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_UpgradeToTopResponse_descriptor = getDescriptor().getMessageTypes().get(13);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_UpgradeToTopResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_UpgradeToTopResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "PetInfo"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_ChangePetNameNewRequest_descriptor = getDescriptor().getMessageTypes().get(14);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ChangePetNameNewRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ChangePetNameNewRequest_descriptor, new String[]{"C2SId", "C2SName"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_ChangePetNameNewResponse_descriptor = getDescriptor().getMessageTypes().get(15);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ChangePetNameNewResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ChangePetNameNewResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "PetInfo"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_PetFightRequest_descriptor = getDescriptor().getMessageTypes().get(16);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_PetFightRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_PetFightRequest_descriptor, new String[]{"C2SId", "C2SType"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_PetFightResponse_descriptor = getDescriptor().getMessageTypes().get(17);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_PetFightResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_PetFightResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetPetInfoNewRequest_descriptor = getDescriptor().getMessageTypes().get(18);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetPetInfoNewRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetPetInfoNewRequest_descriptor, new String[]{"C2SPetId", "C2SOwnId"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetPetInfoNewResponse_descriptor = getDescriptor().getMessageTypes().get(19);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetPetInfoNewResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetPetInfoNewResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CPet"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_OnNewPetDetailPush_descriptor = getDescriptor().getMessageTypes().get(20);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_OnNewPetDetailPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_OnNewPetDetailPush_descriptor, new String[]{"S2CCode", "S2CMsg", "PetInfo"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_PetExpUpdatePush_descriptor = getDescriptor().getMessageTypes().get(21);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_PetExpUpdatePush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_PetExpUpdatePush_descriptor, new String[]{"S2CPetId", "S2CCurExp"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_PetInfoUpdatePush_descriptor = getDescriptor().getMessageTypes().get(22);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_PetInfoUpdatePush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_PetInfoUpdatePush_descriptor, new String[]{"S2CPet"});
    private static Descriptors.FileDescriptor descriptor;

    static {
        Common.getDescriptor();
    }

    public static interface PetInfoUpdatePushOrBuilder extends MessageOrBuilder {
        boolean hasS2CPet();

        PetNewHandler.PetDataInfo getS2CPet();

        PetNewHandler.PetDataInfoOrBuilder getS2CPetOrBuilder();
    }

    public static interface PetExpUpdatePushOrBuilder extends MessageOrBuilder {
        boolean hasS2CPetId();

        int getS2CPetId();

        boolean hasS2CCurExp();

        long getS2CCurExp();
    }

    public static interface OnNewPetDetailPushOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasPetInfo();

        PetNewHandler.PetDataInfo getPetInfo();

        PetNewHandler.PetDataInfoOrBuilder getPetInfoOrBuilder();
    }

    public static interface GetPetInfoNewResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasS2CPet();

        PetNewHandler.PetDataInfo getS2CPet();

        PetNewHandler.PetDataInfoOrBuilder getS2CPetOrBuilder();
    }

    public static interface GetPetInfoNewRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2SPetId();

        int getC2SPetId();

        boolean hasC2SOwnId();

        String getC2SOwnId();

        ByteString getC2SOwnIdBytes();
    }

    public static interface PetFightResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface PetFightRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2SId();

        int getC2SId();

        boolean hasC2SType();

        int getC2SType();
    }

    public static interface ChangePetNameNewResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasPetInfo();

        PetNewHandler.PetDataInfo getPetInfo();

        PetNewHandler.PetDataInfoOrBuilder getPetInfoOrBuilder();
    }

    public static interface ChangePetNameNewRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2SId();

        int getC2SId();

        boolean hasC2SName();

        String getC2SName();

        ByteString getC2SNameBytes();
    }

    public static interface UpgradeToTopResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasPetInfo();

        PetNewHandler.PetDataInfo getPetInfo();

        PetNewHandler.PetDataInfoOrBuilder getPetInfoOrBuilder();
    }

    public static interface UpgradeToTopRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2SId();

        int getC2SId();
    }

    public static interface UpgradeOneLevelResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasPetInfo();

        PetNewHandler.PetDataInfo getPetInfo();

        PetNewHandler.PetDataInfoOrBuilder getPetInfoOrBuilder();
    }

    public static interface UpgradeOneLevelRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2SId();

        int getC2SId();
    }

    public static interface AddExpByItemResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasPetInfo();

        PetNewHandler.PetDataInfo getPetInfo();

        PetNewHandler.PetDataInfoOrBuilder getPetInfoOrBuilder();
    }

    public static interface AddExpByItemRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2SId();

        int getC2SId();

        boolean hasC2SItemCode();

        String getC2SItemCode();

        ByteString getC2SItemCodeBytes();
    }

    public static interface UpGradeUpLevelResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasPetInfo();

        PetNewHandler.PetDataInfo getPetInfo();

        PetNewHandler.PetDataInfoOrBuilder getPetInfoOrBuilder();
    }

    public static interface UpGradeUpLevelRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2SId();

        int getC2SId();
    }

    public static interface SummonPetResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasS2CFight();

        int getS2CFight();
    }

    public static interface SummonPetRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2SId();

        int getC2SId();
    }

    public static interface GetAllPetsInfoResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        List<PetNewHandler.PetDataInfo> getS2CPetInfoList();

        PetNewHandler.PetDataInfo getS2CPetInfo(int param1Int);

        int getS2CPetInfoCount();

        List<? extends PetNewHandler.PetDataInfoOrBuilder> getS2CPetInfoOrBuilderList();

        PetNewHandler.PetDataInfoOrBuilder getS2CPetInfoOrBuilder(int param1Int);

        boolean hasS2CFightingPetId();

        int getS2CFightingPetId();
    }

    public static interface PetDataInfoOrBuilder extends MessageOrBuilder {
        boolean hasId();

        int getId();

        boolean hasLevel();

        int getLevel();

        boolean hasName();

        String getName();

        ByteString getNameBytes();

        boolean hasExp();

        long getExp();

        List<Common.AttributeSimple> getAttrsFinalList();

        Common.AttributeSimple getAttrsFinal(int param1Int);

        int getAttrsFinalCount();

        List<? extends Common.AttributeSimpleOrBuilder> getAttrsFinalOrBuilderList();

        Common.AttributeSimpleOrBuilder getAttrsFinalOrBuilder(int param1Int);

        List<PetNewHandler.SkillDataInfo> getSkillsList();

        PetNewHandler.SkillDataInfo getSkills(int param1Int);

        int getSkillsCount();

        List<? extends PetNewHandler.SkillDataInfoOrBuilder> getSkillsOrBuilderList();

        PetNewHandler.SkillDataInfoOrBuilder getSkillsOrBuilder(int param1Int);

        boolean hasUpLevel();

        int getUpLevel();

        boolean hasFightPower();

        int getFightPower();

        List<Common.AttributeSimple> getNextAttrsFinalList();

        Common.AttributeSimple getNextAttrsFinal(int param1Int);

        int getNextAttrsFinalCount();

        List<? extends Common.AttributeSimpleOrBuilder> getNextAttrsFinalOrBuilderList();

        Common.AttributeSimpleOrBuilder getNextAttrsFinalOrBuilder(int param1Int);
    }

    public static interface SkillDataInfoOrBuilder extends MessageOrBuilder {
        boolean hasId();

        int getId();

        boolean hasLevel();

        int getLevel();

        boolean hasPos();

        int getPos();

        boolean hasInborn();

        int getInborn();
    }

    public static interface GetAllPetsInfoRequestOrBuilder extends MessageOrBuilder {
    }
}


