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


public final class VipHandler {
    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static final class VipRequest
            extends GeneratedMessage
            implements VipRequestOrBuilder {
        private static final VipRequest defaultInstance = new VipRequest(true);
        private final UnknownFieldSet unknownFields;

        private VipRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private VipRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static VipRequest getDefaultInstance() {
            return defaultInstance;
        }

        public VipRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private VipRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return VipHandler.internal_static_pomelo_area_VipRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return VipHandler.internal_static_pomelo_area_VipRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(VipRequest.class, Builder.class);
        }

        public static Parser<VipRequest> PARSER = (Parser<VipRequest>) new AbstractParser<VipRequest>() {
            public VipHandler.VipRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new VipHandler.VipRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<VipRequest> getParserForType() {
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

        public static VipRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (VipRequest) PARSER.parseFrom(data);
        }

        public static VipRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (VipRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static VipRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (VipRequest) PARSER.parseFrom(data);
        }

        public static VipRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (VipRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static VipRequest parseFrom(InputStream input) throws IOException {
            return (VipRequest) PARSER.parseFrom(input);
        }

        public static VipRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (VipRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static VipRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (VipRequest) PARSER.parseDelimitedFrom(input);
        }

        public static VipRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (VipRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static VipRequest parseFrom(CodedInputStream input) throws IOException {
            return (VipRequest) PARSER.parseFrom(input);
        }

        public static VipRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (VipRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(VipRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements VipHandler.VipRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return VipHandler.internal_static_pomelo_area_VipRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return VipHandler.internal_static_pomelo_area_VipRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(VipHandler.VipRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (VipHandler.VipRequest.alwaysUseFieldBuilders) ;
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
                return VipHandler.internal_static_pomelo_area_VipRequest_descriptor;
            }

            public VipHandler.VipRequest getDefaultInstanceForType() {
                return VipHandler.VipRequest.getDefaultInstance();
            }

            public VipHandler.VipRequest build() {
                VipHandler.VipRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public VipHandler.VipRequest buildPartial() {
                VipHandler.VipRequest result = new VipHandler.VipRequest(this);
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof VipHandler.VipRequest) return mergeFrom((VipHandler.VipRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(VipHandler.VipRequest other) {
                if (other == VipHandler.VipRequest.getDefaultInstance()) return this;
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                VipHandler.VipRequest parsedMessage = null;
                try {
                    parsedMessage = (VipHandler.VipRequest) VipHandler.VipRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (VipHandler.VipRequest) e.getUnfinishedMessage();
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


    public static final class VipGiftInfo
            extends GeneratedMessage
            implements VipGiftInfoOrBuilder {
        private static final VipGiftInfo defaultInstance = new VipGiftInfo(true);
        private final UnknownFieldSet unknownFields;

        private VipGiftInfo(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private VipGiftInfo(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static VipGiftInfo getDefaultInstance() {
            return defaultInstance;
        }

        public VipGiftInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private VipGiftInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.type_ = input.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.flag_ = input.readInt32();
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
            return VipHandler.internal_static_pomelo_area_VipGiftInfo_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return VipHandler.internal_static_pomelo_area_VipGiftInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(VipGiftInfo.class, Builder.class);
        }

        public static Parser<VipGiftInfo> PARSER = (Parser<VipGiftInfo>) new AbstractParser<VipGiftInfo>() {
            public VipHandler.VipGiftInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new VipHandler.VipGiftInfo(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int TYPE_FIELD_NUMBER = 1;
        private int type_;
        public static final int FLAG_FIELD_NUMBER = 2;
        private int flag_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<VipGiftInfo> getParserForType() {
            return PARSER;
        }

        public boolean hasType() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getType() {
            return this.type_;
        }

        public boolean hasFlag() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public int getFlag() {
            return this.flag_;
        }

        private void initFields() {
            this.type_ = 0;
            this.flag_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasType()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasFlag()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.type_);
            if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.flag_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.type_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(2, this.flag_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static VipGiftInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (VipGiftInfo) PARSER.parseFrom(data);
        }

        public static VipGiftInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (VipGiftInfo) PARSER.parseFrom(data, extensionRegistry);
        }

        public static VipGiftInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (VipGiftInfo) PARSER.parseFrom(data);
        }

        public static VipGiftInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (VipGiftInfo) PARSER.parseFrom(data, extensionRegistry);
        }

        public static VipGiftInfo parseFrom(InputStream input) throws IOException {
            return (VipGiftInfo) PARSER.parseFrom(input);
        }

        public static VipGiftInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (VipGiftInfo) PARSER.parseFrom(input, extensionRegistry);
        }

        public static VipGiftInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (VipGiftInfo) PARSER.parseDelimitedFrom(input);
        }

        public static VipGiftInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (VipGiftInfo) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static VipGiftInfo parseFrom(CodedInputStream input) throws IOException {
            return (VipGiftInfo) PARSER.parseFrom(input);
        }

        public static VipGiftInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (VipGiftInfo) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(VipGiftInfo prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements VipHandler.VipGiftInfoOrBuilder {
            private int bitField0_;
            private int type_;
            private int flag_;

            public static final Descriptors.Descriptor getDescriptor() {
                return VipHandler.internal_static_pomelo_area_VipGiftInfo_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return VipHandler.internal_static_pomelo_area_VipGiftInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(VipHandler.VipGiftInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (VipHandler.VipGiftInfo.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.type_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.flag_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return VipHandler.internal_static_pomelo_area_VipGiftInfo_descriptor;
            }

            public VipHandler.VipGiftInfo getDefaultInstanceForType() {
                return VipHandler.VipGiftInfo.getDefaultInstance();
            }

            public VipHandler.VipGiftInfo build() {
                VipHandler.VipGiftInfo result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public VipHandler.VipGiftInfo buildPartial() {
                VipHandler.VipGiftInfo result = new VipHandler.VipGiftInfo(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.type_ = this.type_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.flag_ = this.flag_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof VipHandler.VipGiftInfo) return mergeFrom((VipHandler.VipGiftInfo) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(VipHandler.VipGiftInfo other) {
                if (other == VipHandler.VipGiftInfo.getDefaultInstance()) return this;
                if (other.hasType()) setType(other.getType());
                if (other.hasFlag()) setFlag(other.getFlag());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasType()) return false;
                if (!hasFlag()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                VipHandler.VipGiftInfo parsedMessage = null;
                try {
                    parsedMessage = (VipHandler.VipGiftInfo) VipHandler.VipGiftInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (VipHandler.VipGiftInfo) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasType() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getType() {
                return this.type_;
            }

            public Builder setType(int value) {
                this.bitField0_ |= 0x1;
                this.type_ = value;
                onChanged();
                return this;
            }

            public Builder clearType() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.type_ = 0;
                onChanged();
                return this;
            }

            public boolean hasFlag() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getFlag() {
                return this.flag_;
            }

            public Builder setFlag(int value) {
                this.bitField0_ |= 0x2;
                this.flag_ = value;
                onChanged();
                return this;
            }

            public Builder clearFlag() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.flag_ = 0;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class VipGetGiftData
            extends GeneratedMessage
            implements VipGetGiftDataOrBuilder {
        private static final VipGetGiftData defaultInstance = new VipGetGiftData(true);
        private final UnknownFieldSet unknownFields;

        private VipGetGiftData(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private VipGetGiftData(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static VipGetGiftData getDefaultInstance() {
            return defaultInstance;
        }

        public VipGetGiftData getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private VipGetGiftData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.datas_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x1;
                            }
                            this.datas_.add(input.readMessage(VipHandler.VipGiftInfo.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x1) == 1) this.datas_ = Collections.unmodifiableList(this.datas_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return VipHandler.internal_static_pomelo_area_VipGetGiftData_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return VipHandler.internal_static_pomelo_area_VipGetGiftData_fieldAccessorTable.ensureFieldAccessorsInitialized(VipGetGiftData.class, Builder.class);
        }

        public static Parser<VipGetGiftData> PARSER = (Parser<VipGetGiftData>) new AbstractParser<VipGetGiftData>() {
            public VipHandler.VipGetGiftData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new VipHandler.VipGetGiftData(input, extensionRegistry);
            }
        };
        public static final int DATAS_FIELD_NUMBER = 1;
        private List<VipHandler.VipGiftInfo> datas_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<VipGetGiftData> getParserForType() {
            return PARSER;
        }

        public List<VipHandler.VipGiftInfo> getDatasList() {
            return this.datas_;
        }

        public List<? extends VipHandler.VipGiftInfoOrBuilder> getDatasOrBuilderList() {
            return (List) this.datas_;
        }

        public int getDatasCount() {
            return this.datas_.size();
        }

        public VipHandler.VipGiftInfo getDatas(int index) {
            return this.datas_.get(index);
        }

        public VipHandler.VipGiftInfoOrBuilder getDatasOrBuilder(int index) {
            return this.datas_.get(index);
        }

        private void initFields() {
            this.datas_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            for (int i = 0; i < getDatasCount(); i++) {
                if (!getDatas(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            for (int i = 0; i < this.datas_.size(); i++) output.writeMessage(1, (MessageLite) this.datas_.get(i));
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            for (int i = 0; i < this.datas_.size(); i++)
                size += CodedOutputStream.computeMessageSize(1, (MessageLite) this.datas_.get(i));
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static VipGetGiftData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (VipGetGiftData) PARSER.parseFrom(data);
        }

        public static VipGetGiftData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (VipGetGiftData) PARSER.parseFrom(data, extensionRegistry);
        }

        public static VipGetGiftData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (VipGetGiftData) PARSER.parseFrom(data);
        }

        public static VipGetGiftData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (VipGetGiftData) PARSER.parseFrom(data, extensionRegistry);
        }

        public static VipGetGiftData parseFrom(InputStream input) throws IOException {
            return (VipGetGiftData) PARSER.parseFrom(input);
        }

        public static VipGetGiftData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (VipGetGiftData) PARSER.parseFrom(input, extensionRegistry);
        }

        public static VipGetGiftData parseDelimitedFrom(InputStream input) throws IOException {
            return (VipGetGiftData) PARSER.parseDelimitedFrom(input);
        }

        public static VipGetGiftData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (VipGetGiftData) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static VipGetGiftData parseFrom(CodedInputStream input) throws IOException {
            return (VipGetGiftData) PARSER.parseFrom(input);
        }

        public static VipGetGiftData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (VipGetGiftData) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(VipGetGiftData prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements VipHandler.VipGetGiftDataOrBuilder {
            private int bitField0_;
            private List<VipHandler.VipGiftInfo> datas_;
            private RepeatedFieldBuilder<VipHandler.VipGiftInfo, VipHandler.VipGiftInfo.Builder, VipHandler.VipGiftInfoOrBuilder> datasBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return VipHandler.internal_static_pomelo_area_VipGetGiftData_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return VipHandler.internal_static_pomelo_area_VipGetGiftData_fieldAccessorTable.ensureFieldAccessorsInitialized(VipHandler.VipGetGiftData.class, Builder.class);
            }

            private Builder() {
                this.datas_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.datas_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (VipHandler.VipGetGiftData.alwaysUseFieldBuilders) getDatasFieldBuilder();
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                if (this.datasBuilder_ == null) {
                    this.datas_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFE;
                } else {
                    this.datasBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return VipHandler.internal_static_pomelo_area_VipGetGiftData_descriptor;
            }

            public VipHandler.VipGetGiftData getDefaultInstanceForType() {
                return VipHandler.VipGetGiftData.getDefaultInstance();
            }

            public VipHandler.VipGetGiftData build() {
                VipHandler.VipGetGiftData result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public VipHandler.VipGetGiftData buildPartial() {
                VipHandler.VipGetGiftData result = new VipHandler.VipGetGiftData(this);
                int from_bitField0_ = this.bitField0_;
                if (this.datasBuilder_ == null) {
                    if ((this.bitField0_ & 0x1) == 1) {
                        this.datas_ = Collections.unmodifiableList(this.datas_);
                        this.bitField0_ &= 0xFFFFFFFE;
                    }
                    result.datas_ = this.datas_;
                } else {
                    result.datas_ = this.datasBuilder_.build();
                }
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof VipHandler.VipGetGiftData) return mergeFrom((VipHandler.VipGetGiftData) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(VipHandler.VipGetGiftData other) {
                if (other == VipHandler.VipGetGiftData.getDefaultInstance()) return this;
                if (this.datasBuilder_ == null) {
                    if (!other.datas_.isEmpty()) {
                        if (this.datas_.isEmpty()) {
                            this.datas_ = other.datas_;
                            this.bitField0_ &= 0xFFFFFFFE;
                        } else {
                            ensureDatasIsMutable();
                            this.datas_.addAll(other.datas_);
                        }
                        onChanged();
                    }
                } else if (!other.datas_.isEmpty()) {
                    if (this.datasBuilder_.isEmpty()) {
                        this.datasBuilder_.dispose();
                        this.datasBuilder_ = null;
                        this.datas_ = other.datas_;
                        this.bitField0_ &= 0xFFFFFFFE;
                        this.datasBuilder_ = VipHandler.VipGetGiftData.alwaysUseFieldBuilders ? getDatasFieldBuilder() : null;
                    } else {
                        this.datasBuilder_.addAllMessages(other.datas_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                for (int i = 0; i < getDatasCount(); i++) {
                    if (!getDatas(i).isInitialized()) return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                VipHandler.VipGetGiftData parsedMessage = null;
                try {
                    parsedMessage = (VipHandler.VipGetGiftData) VipHandler.VipGetGiftData.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (VipHandler.VipGetGiftData) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            private void ensureDatasIsMutable() {
                if ((this.bitField0_ & 0x1) != 1) {
                    this.datas_ = new ArrayList<>(this.datas_);
                    this.bitField0_ |= 0x1;
                }
            }

            public List<VipHandler.VipGiftInfo> getDatasList() {
                if (this.datasBuilder_ == null) return Collections.unmodifiableList(this.datas_);
                return this.datasBuilder_.getMessageList();
            }

            public int getDatasCount() {
                if (this.datasBuilder_ == null) return this.datas_.size();
                return this.datasBuilder_.getCount();
            }

            public VipHandler.VipGiftInfo getDatas(int index) {
                if (this.datasBuilder_ == null) return this.datas_.get(index);
                return (VipHandler.VipGiftInfo) this.datasBuilder_.getMessage(index);
            }

            public Builder setDatas(int index, VipHandler.VipGiftInfo value) {
                if (this.datasBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureDatasIsMutable();
                    this.datas_.set(index, value);
                    onChanged();
                } else {
                    this.datasBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setDatas(int index, VipHandler.VipGiftInfo.Builder builderForValue) {
                if (this.datasBuilder_ == null) {
                    ensureDatasIsMutable();
                    this.datas_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.datasBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addDatas(VipHandler.VipGiftInfo value) {
                if (this.datasBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureDatasIsMutable();
                    this.datas_.add(value);
                    onChanged();
                } else {
                    this.datasBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addDatas(int index, VipHandler.VipGiftInfo value) {
                if (this.datasBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureDatasIsMutable();
                    this.datas_.add(index, value);
                    onChanged();
                } else {
                    this.datasBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addDatas(VipHandler.VipGiftInfo.Builder builderForValue) {
                if (this.datasBuilder_ == null) {
                    ensureDatasIsMutable();
                    this.datas_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.datasBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addDatas(int index, VipHandler.VipGiftInfo.Builder builderForValue) {
                if (this.datasBuilder_ == null) {
                    ensureDatasIsMutable();
                    this.datas_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.datasBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllDatas(Iterable<? extends VipHandler.VipGiftInfo> values) {
                if (this.datasBuilder_ == null) {
                    ensureDatasIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.datas_);
                    onChanged();
                } else {
                    this.datasBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearDatas() {
                if (this.datasBuilder_ == null) {
                    this.datas_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFE;
                    onChanged();
                } else {
                    this.datasBuilder_.clear();
                }
                return this;
            }

            public Builder removeDatas(int index) {
                if (this.datasBuilder_ == null) {
                    ensureDatasIsMutable();
                    this.datas_.remove(index);
                    onChanged();
                } else {
                    this.datasBuilder_.remove(index);
                }
                return this;
            }

            public VipHandler.VipGiftInfo.Builder getDatasBuilder(int index) {
                return (VipHandler.VipGiftInfo.Builder) getDatasFieldBuilder().getBuilder(index);
            }

            public VipHandler.VipGiftInfoOrBuilder getDatasOrBuilder(int index) {
                if (this.datasBuilder_ == null) return this.datas_.get(index);
                return (VipHandler.VipGiftInfoOrBuilder) this.datasBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends VipHandler.VipGiftInfoOrBuilder> getDatasOrBuilderList() {
                if (this.datasBuilder_ != null) return this.datasBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.datas_);
            }

            public VipHandler.VipGiftInfo.Builder addDatasBuilder() {
                return (VipHandler.VipGiftInfo.Builder) getDatasFieldBuilder().addBuilder(VipHandler.VipGiftInfo.getDefaultInstance());
            }

            public VipHandler.VipGiftInfo.Builder addDatasBuilder(int index) {
                return (VipHandler.VipGiftInfo.Builder) getDatasFieldBuilder().addBuilder(index, VipHandler.VipGiftInfo.getDefaultInstance());
            }

            public List<VipHandler.VipGiftInfo.Builder> getDatasBuilderList() {
                return getDatasFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<VipHandler.VipGiftInfo, VipHandler.VipGiftInfo.Builder, VipHandler.VipGiftInfoOrBuilder> getDatasFieldBuilder() {
                if (this.datasBuilder_ == null) {
                    this.datasBuilder_ = new RepeatedFieldBuilder(this.datas_, ((this.bitField0_ & 0x1) == 1), getParentForChildren(), isClean());
                    this.datas_ = null;
                }
                return this.datasBuilder_;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class VipBuyGiftData
            extends GeneratedMessage
            implements VipBuyGiftDataOrBuilder {
        private static final VipBuyGiftData defaultInstance = new VipBuyGiftData(true);
        private final UnknownFieldSet unknownFields;

        private VipBuyGiftData(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private VipBuyGiftData(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static VipBuyGiftData getDefaultInstance() {
            return defaultInstance;
        }

        public VipBuyGiftData getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private VipBuyGiftData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.vipLevel_ = input.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.dailyBuyCount_ = input.readInt32();
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
            return VipHandler.internal_static_pomelo_area_VipBuyGiftData_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return VipHandler.internal_static_pomelo_area_VipBuyGiftData_fieldAccessorTable.ensureFieldAccessorsInitialized(VipBuyGiftData.class, Builder.class);
        }

        public static Parser<VipBuyGiftData> PARSER = (Parser<VipBuyGiftData>) new AbstractParser<VipBuyGiftData>() {
            public VipHandler.VipBuyGiftData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new VipHandler.VipBuyGiftData(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int VIPLEVEL_FIELD_NUMBER = 1;
        private int vipLevel_;
        public static final int DAILYBUYCOUNT_FIELD_NUMBER = 2;
        private int dailyBuyCount_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<VipBuyGiftData> getParserForType() {
            return PARSER;
        }

        public boolean hasVipLevel() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getVipLevel() {
            return this.vipLevel_;
        }

        public boolean hasDailyBuyCount() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public int getDailyBuyCount() {
            return this.dailyBuyCount_;
        }

        private void initFields() {
            this.vipLevel_ = 0;
            this.dailyBuyCount_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasVipLevel()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasDailyBuyCount()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.vipLevel_);
            if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.dailyBuyCount_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.vipLevel_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(2, this.dailyBuyCount_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static VipBuyGiftData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (VipBuyGiftData) PARSER.parseFrom(data);
        }

        public static VipBuyGiftData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (VipBuyGiftData) PARSER.parseFrom(data, extensionRegistry);
        }

        public static VipBuyGiftData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (VipBuyGiftData) PARSER.parseFrom(data);
        }

        public static VipBuyGiftData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (VipBuyGiftData) PARSER.parseFrom(data, extensionRegistry);
        }

        public static VipBuyGiftData parseFrom(InputStream input) throws IOException {
            return (VipBuyGiftData) PARSER.parseFrom(input);
        }

        public static VipBuyGiftData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (VipBuyGiftData) PARSER.parseFrom(input, extensionRegistry);
        }

        public static VipBuyGiftData parseDelimitedFrom(InputStream input) throws IOException {
            return (VipBuyGiftData) PARSER.parseDelimitedFrom(input);
        }

        public static VipBuyGiftData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (VipBuyGiftData) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static VipBuyGiftData parseFrom(CodedInputStream input) throws IOException {
            return (VipBuyGiftData) PARSER.parseFrom(input);
        }

        public static VipBuyGiftData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (VipBuyGiftData) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(VipBuyGiftData prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements VipHandler.VipBuyGiftDataOrBuilder {
            private int bitField0_;
            private int vipLevel_;
            private int dailyBuyCount_;

            public static final Descriptors.Descriptor getDescriptor() {
                return VipHandler.internal_static_pomelo_area_VipBuyGiftData_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return VipHandler.internal_static_pomelo_area_VipBuyGiftData_fieldAccessorTable.ensureFieldAccessorsInitialized(VipHandler.VipBuyGiftData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (VipHandler.VipBuyGiftData.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.vipLevel_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.dailyBuyCount_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return VipHandler.internal_static_pomelo_area_VipBuyGiftData_descriptor;
            }

            public VipHandler.VipBuyGiftData getDefaultInstanceForType() {
                return VipHandler.VipBuyGiftData.getDefaultInstance();
            }

            public VipHandler.VipBuyGiftData build() {
                VipHandler.VipBuyGiftData result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public VipHandler.VipBuyGiftData buildPartial() {
                VipHandler.VipBuyGiftData result = new VipHandler.VipBuyGiftData(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.vipLevel_ = this.vipLevel_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.dailyBuyCount_ = this.dailyBuyCount_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof VipHandler.VipBuyGiftData) return mergeFrom((VipHandler.VipBuyGiftData) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(VipHandler.VipBuyGiftData other) {
                if (other == VipHandler.VipBuyGiftData.getDefaultInstance()) return this;
                if (other.hasVipLevel()) setVipLevel(other.getVipLevel());
                if (other.hasDailyBuyCount()) setDailyBuyCount(other.getDailyBuyCount());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasVipLevel()) return false;
                if (!hasDailyBuyCount()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                VipHandler.VipBuyGiftData parsedMessage = null;
                try {
                    parsedMessage = (VipHandler.VipBuyGiftData) VipHandler.VipBuyGiftData.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (VipHandler.VipBuyGiftData) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasVipLevel() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getVipLevel() {
                return this.vipLevel_;
            }

            public Builder setVipLevel(int value) {
                this.bitField0_ |= 0x1;
                this.vipLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearVipLevel() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.vipLevel_ = 0;
                onChanged();
                return this;
            }

            public boolean hasDailyBuyCount() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getDailyBuyCount() {
                return this.dailyBuyCount_;
            }

            public Builder setDailyBuyCount(int value) {
                this.bitField0_ |= 0x2;
                this.dailyBuyCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearDailyBuyCount() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.dailyBuyCount_ = 0;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class VipResponse
            extends GeneratedMessage
            implements VipResponseOrBuilder {
        private static final VipResponse defaultInstance = new VipResponse(true);
        private final UnknownFieldSet unknownFields;

        private VipResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private VipResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static VipResponse getDefaultInstance() {
            return defaultInstance;
        }

        public VipResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private VipResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.datas_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x4;
                            }
                            this.datas_.add(input.readMessage(VipHandler.VipGiftInfo.PARSER, extensionRegistry));
                            break;
                        case 32:
                            this.bitField0_ |= 0x4;
                            this.s2CRemainTime_ = input.readInt64();
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x4) == 4) this.datas_ = Collections.unmodifiableList(this.datas_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return VipHandler.internal_static_pomelo_area_VipResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return VipHandler.internal_static_pomelo_area_VipResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(VipResponse.class, Builder.class);
        }

        public static Parser<VipResponse> PARSER = (Parser<VipResponse>) new AbstractParser<VipResponse>() {
            public VipHandler.VipResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new VipHandler.VipResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int DATAS_FIELD_NUMBER = 3;
        private List<VipHandler.VipGiftInfo> datas_;
        public static final int S2C_REMAINTIME_FIELD_NUMBER = 4;
        private long s2CRemainTime_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<VipResponse> getParserForType() {
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

        public List<VipHandler.VipGiftInfo> getDatasList() {
            return this.datas_;
        }

        public List<? extends VipHandler.VipGiftInfoOrBuilder> getDatasOrBuilderList() {
            return (List) this.datas_;
        }

        public int getDatasCount() {
            return this.datas_.size();
        }

        public VipHandler.VipGiftInfo getDatas(int index) {
            return this.datas_.get(index);
        }

        public VipHandler.VipGiftInfoOrBuilder getDatasOrBuilder(int index) {
            return this.datas_.get(index);
        }

        public boolean hasS2CRemainTime() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public long getS2CRemainTime() {
            return this.s2CRemainTime_;
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.datas_ = Collections.emptyList();
            this.s2CRemainTime_ = 0L;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasS2CCode()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (int i = 0; i < getDatasCount(); i++) {
                if (!getDatas(i).isInitialized()) {
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
            for (int i = 0; i < this.datas_.size(); i++) output.writeMessage(3, (MessageLite) this.datas_.get(i));
            if ((this.bitField0_ & 0x4) == 4) output.writeInt64(4, this.s2CRemainTime_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());
            for (int i = 0; i < this.datas_.size(); i++)
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.datas_.get(i));
            if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeInt64Size(4, this.s2CRemainTime_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static VipResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (VipResponse) PARSER.parseFrom(data);
        }

        public static VipResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (VipResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static VipResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (VipResponse) PARSER.parseFrom(data);
        }

        public static VipResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (VipResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static VipResponse parseFrom(InputStream input) throws IOException {
            return (VipResponse) PARSER.parseFrom(input);
        }

        public static VipResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (VipResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static VipResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (VipResponse) PARSER.parseDelimitedFrom(input);
        }

        public static VipResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (VipResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static VipResponse parseFrom(CodedInputStream input) throws IOException {
            return (VipResponse) PARSER.parseFrom(input);
        }

        public static VipResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (VipResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(VipResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements VipHandler.VipResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private List<VipHandler.VipGiftInfo> datas_;
            private RepeatedFieldBuilder<VipHandler.VipGiftInfo, VipHandler.VipGiftInfo.Builder, VipHandler.VipGiftInfoOrBuilder> datasBuilder_;
            private long s2CRemainTime_;
            private long s2CRemainTime_quarter_;

            public static final Descriptors.Descriptor getDescriptor() {
                return VipHandler.internal_static_pomelo_area_VipResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return VipHandler.internal_static_pomelo_area_VipResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(VipHandler.VipResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.datas_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.datas_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (VipHandler.VipResponse.alwaysUseFieldBuilders) getDatasFieldBuilder();
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
                if (this.datasBuilder_ == null) {
                    this.datas_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                } else {
                    this.datasBuilder_.clear();
                }
                this.s2CRemainTime_ = 0L;
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return VipHandler.internal_static_pomelo_area_VipResponse_descriptor;
            }

            public VipHandler.VipResponse getDefaultInstanceForType() {
                return VipHandler.VipResponse.getDefaultInstance();
            }

            public VipHandler.VipResponse build() {
                VipHandler.VipResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public VipHandler.VipResponse buildPartial() {
                VipHandler.VipResponse result = new VipHandler.VipResponse(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.s2CMsg_ = this.s2CMsg_;
                if (this.datasBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4) {
                        this.datas_ = Collections.unmodifiableList(this.datas_);
                        this.bitField0_ &= 0xFFFFFFFB;
                    }
                    result.datas_ = this.datas_;
                } else {
                    result.datas_ = this.datasBuilder_.build();
                }
                if ((from_bitField0_ & 0x8) == 8) to_bitField0_ |= 0x4;
                result.s2CRemainTime_ = this.s2CRemainTime_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof VipHandler.VipResponse) return mergeFrom((VipHandler.VipResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(VipHandler.VipResponse other) {
                if (other == VipHandler.VipResponse.getDefaultInstance()) return this;
                if (other.hasS2CCode()) setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (this.datasBuilder_ == null) {
                    if (!other.datas_.isEmpty()) {
                        if (this.datas_.isEmpty()) {
                            this.datas_ = other.datas_;
                            this.bitField0_ &= 0xFFFFFFFB;
                        } else {
                            ensureDatasIsMutable();
                            this.datas_.addAll(other.datas_);
                        }
                        onChanged();
                    }
                } else if (!other.datas_.isEmpty()) {
                    if (this.datasBuilder_.isEmpty()) {
                        this.datasBuilder_.dispose();
                        this.datasBuilder_ = null;
                        this.datas_ = other.datas_;
                        this.bitField0_ &= 0xFFFFFFFB;
                        this.datasBuilder_ = VipHandler.VipResponse.alwaysUseFieldBuilders ? getDatasFieldBuilder() : null;
                    } else {
                        this.datasBuilder_.addAllMessages(other.datas_);
                    }
                }
                if (other.hasS2CRemainTime()) setS2CRemainTime(other.getS2CRemainTime());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode()) return false;
                for (int i = 0; i < getDatasCount(); i++) {
                    if (!getDatas(i).isInitialized()) return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                VipHandler.VipResponse parsedMessage = null;
                try {
                    parsedMessage = (VipHandler.VipResponse) VipHandler.VipResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (VipHandler.VipResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = VipHandler.VipResponse.getDefaultInstance().getS2CMsg();
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

            private void ensureDatasIsMutable() {
                if ((this.bitField0_ & 0x4) != 4) {
                    this.datas_ = new ArrayList<>(this.datas_);
                    this.bitField0_ |= 0x4;
                }
            }

            public List<VipHandler.VipGiftInfo> getDatasList() {
                if (this.datasBuilder_ == null) return Collections.unmodifiableList(this.datas_);
                return this.datasBuilder_.getMessageList();
            }

            public int getDatasCount() {
                if (this.datasBuilder_ == null) return this.datas_.size();
                return this.datasBuilder_.getCount();
            }

            public VipHandler.VipGiftInfo getDatas(int index) {
                if (this.datasBuilder_ == null) return this.datas_.get(index);
                return (VipHandler.VipGiftInfo) this.datasBuilder_.getMessage(index);
            }

            public Builder setDatas(int index, VipHandler.VipGiftInfo value) {
                if (this.datasBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureDatasIsMutable();
                    this.datas_.set(index, value);
                    onChanged();
                } else {
                    this.datasBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setDatas(int index, VipHandler.VipGiftInfo.Builder builderForValue) {
                if (this.datasBuilder_ == null) {
                    ensureDatasIsMutable();
                    this.datas_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.datasBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addDatas(VipHandler.VipGiftInfo value) {
                if (this.datasBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureDatasIsMutable();
                    this.datas_.add(value);
                    onChanged();
                } else {
                    this.datasBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addDatas(int index, VipHandler.VipGiftInfo value) {
                if (this.datasBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureDatasIsMutable();
                    this.datas_.add(index, value);
                    onChanged();
                } else {
                    this.datasBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addDatas(VipHandler.VipGiftInfo.Builder builderForValue) {
                if (this.datasBuilder_ == null) {
                    ensureDatasIsMutable();
                    this.datas_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.datasBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addDatas(int index, VipHandler.VipGiftInfo.Builder builderForValue) {
                if (this.datasBuilder_ == null) {
                    ensureDatasIsMutable();
                    this.datas_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.datasBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllDatas(Iterable<? extends VipHandler.VipGiftInfo> values) {
                if (this.datasBuilder_ == null) {
                    ensureDatasIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.datas_);
                    onChanged();
                } else {
                    this.datasBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearDatas() {
                if (this.datasBuilder_ == null) {
                    this.datas_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                    onChanged();
                } else {
                    this.datasBuilder_.clear();
                }
                return this;
            }

            public Builder removeDatas(int index) {
                if (this.datasBuilder_ == null) {
                    ensureDatasIsMutable();
                    this.datas_.remove(index);
                    onChanged();
                } else {
                    this.datasBuilder_.remove(index);
                }
                return this;
            }

            public VipHandler.VipGiftInfo.Builder getDatasBuilder(int index) {
                return (VipHandler.VipGiftInfo.Builder) getDatasFieldBuilder().getBuilder(index);
            }

            public VipHandler.VipGiftInfoOrBuilder getDatasOrBuilder(int index) {
                if (this.datasBuilder_ == null) return this.datas_.get(index);
                return (VipHandler.VipGiftInfoOrBuilder) this.datasBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends VipHandler.VipGiftInfoOrBuilder> getDatasOrBuilderList() {
                if (this.datasBuilder_ != null) return this.datasBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.datas_);
            }

            public VipHandler.VipGiftInfo.Builder addDatasBuilder() {
                return (VipHandler.VipGiftInfo.Builder) getDatasFieldBuilder().addBuilder(VipHandler.VipGiftInfo.getDefaultInstance());
            }

            public VipHandler.VipGiftInfo.Builder addDatasBuilder(int index) {
                return (VipHandler.VipGiftInfo.Builder) getDatasFieldBuilder().addBuilder(index, VipHandler.VipGiftInfo.getDefaultInstance());
            }

            public List<VipHandler.VipGiftInfo.Builder> getDatasBuilderList() {
                return getDatasFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<VipHandler.VipGiftInfo, VipHandler.VipGiftInfo.Builder, VipHandler.VipGiftInfoOrBuilder> getDatasFieldBuilder() {
                if (this.datasBuilder_ == null) {
                    this.datasBuilder_ = new RepeatedFieldBuilder(this.datas_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
                    this.datas_ = null;
                }
                return this.datasBuilder_;
            }

            public boolean hasS2CRemainTime() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public long getS2CRemainTime() {
                return this.s2CRemainTime_;
            }

            public Builder setS2CRemainTime(long value) {
                this.bitField0_ |= 0x8;
                this.s2CRemainTime_ = value;
                onChanged();
                return this;
            }

            public Builder setS2CRemainTime_quarter(long value) {
                this.bitField0_ |= 0x8;
                this.s2CRemainTime_quarter_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CRemainTime() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.s2CRemainTime_ = 0L;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class GetEveryDayGiftRequest
            extends GeneratedMessage
            implements GetEveryDayGiftRequestOrBuilder {
        private static final GetEveryDayGiftRequest defaultInstance = new GetEveryDayGiftRequest(true);
        private final UnknownFieldSet unknownFields;

        private GetEveryDayGiftRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetEveryDayGiftRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetEveryDayGiftRequest getDefaultInstance() {
            return defaultInstance;
        }

        public GetEveryDayGiftRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetEveryDayGiftRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return VipHandler.internal_static_pomelo_area_GetEveryDayGiftRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return VipHandler.internal_static_pomelo_area_GetEveryDayGiftRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetEveryDayGiftRequest.class, Builder.class);
        }

        public static Parser<GetEveryDayGiftRequest> PARSER = (Parser<GetEveryDayGiftRequest>) new AbstractParser<GetEveryDayGiftRequest>() {
            public VipHandler.GetEveryDayGiftRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new VipHandler.GetEveryDayGiftRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_TYPE_FIELD_NUMBER = 1;
        private int c2SType_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetEveryDayGiftRequest> getParserForType() {
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

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasC2SType()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.c2SType_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.c2SType_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static GetEveryDayGiftRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetEveryDayGiftRequest) PARSER.parseFrom(data);
        }

        public static GetEveryDayGiftRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetEveryDayGiftRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetEveryDayGiftRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetEveryDayGiftRequest) PARSER.parseFrom(data);
        }

        public static GetEveryDayGiftRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetEveryDayGiftRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetEveryDayGiftRequest parseFrom(InputStream input) throws IOException {
            return (GetEveryDayGiftRequest) PARSER.parseFrom(input);
        }

        public static GetEveryDayGiftRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetEveryDayGiftRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static GetEveryDayGiftRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (GetEveryDayGiftRequest) PARSER.parseDelimitedFrom(input);
        }

        public static GetEveryDayGiftRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetEveryDayGiftRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static GetEveryDayGiftRequest parseFrom(CodedInputStream input) throws IOException {
            return (GetEveryDayGiftRequest) PARSER.parseFrom(input);
        }

        public static GetEveryDayGiftRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetEveryDayGiftRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(GetEveryDayGiftRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements VipHandler.GetEveryDayGiftRequestOrBuilder {
            private int bitField0_;
            private int c2SType_;

            public static final Descriptors.Descriptor getDescriptor() {
                return VipHandler.internal_static_pomelo_area_GetEveryDayGiftRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return VipHandler.internal_static_pomelo_area_GetEveryDayGiftRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(VipHandler.GetEveryDayGiftRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (VipHandler.GetEveryDayGiftRequest.alwaysUseFieldBuilders) ;
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
                return VipHandler.internal_static_pomelo_area_GetEveryDayGiftRequest_descriptor;
            }

            public VipHandler.GetEveryDayGiftRequest getDefaultInstanceForType() {
                return VipHandler.GetEveryDayGiftRequest.getDefaultInstance();
            }

            public VipHandler.GetEveryDayGiftRequest build() {
                VipHandler.GetEveryDayGiftRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public VipHandler.GetEveryDayGiftRequest buildPartial() {
                VipHandler.GetEveryDayGiftRequest result = new VipHandler.GetEveryDayGiftRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.c2SType_ = this.c2SType_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof VipHandler.GetEveryDayGiftRequest)
                    return mergeFrom((VipHandler.GetEveryDayGiftRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(VipHandler.GetEveryDayGiftRequest other) {
                if (other == VipHandler.GetEveryDayGiftRequest.getDefaultInstance()) return this;
                if (other.hasC2SType()) setC2SType(other.getC2SType());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasC2SType()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                VipHandler.GetEveryDayGiftRequest parsedMessage = null;
                try {
                    parsedMessage = (VipHandler.GetEveryDayGiftRequest) VipHandler.GetEveryDayGiftRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (VipHandler.GetEveryDayGiftRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
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

        static {
            defaultInstance.initFields();
        }

    }


    public static final class GetEveryDayGiftResponse
            extends GeneratedMessage
            implements GetEveryDayGiftResponseOrBuilder {
        private static final GetEveryDayGiftResponse defaultInstance = new GetEveryDayGiftResponse(true);
        private final UnknownFieldSet unknownFields;

        private GetEveryDayGiftResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetEveryDayGiftResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetEveryDayGiftResponse getDefaultInstance() {
            return defaultInstance;
        }

        public GetEveryDayGiftResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetEveryDayGiftResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return VipHandler.internal_static_pomelo_area_GetEveryDayGiftResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return VipHandler.internal_static_pomelo_area_GetEveryDayGiftResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetEveryDayGiftResponse.class, Builder.class);
        }

        public static Parser<GetEveryDayGiftResponse> PARSER = (Parser<GetEveryDayGiftResponse>) new AbstractParser<GetEveryDayGiftResponse>() {
            public VipHandler.GetEveryDayGiftResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new VipHandler.GetEveryDayGiftResponse(input, extensionRegistry);
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

        public Parser<GetEveryDayGiftResponse> getParserForType() {
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

        public static GetEveryDayGiftResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetEveryDayGiftResponse) PARSER.parseFrom(data);
        }

        public static GetEveryDayGiftResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetEveryDayGiftResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetEveryDayGiftResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetEveryDayGiftResponse) PARSER.parseFrom(data);
        }

        public static GetEveryDayGiftResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetEveryDayGiftResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetEveryDayGiftResponse parseFrom(InputStream input) throws IOException {
            return (GetEveryDayGiftResponse) PARSER.parseFrom(input);
        }

        public static GetEveryDayGiftResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetEveryDayGiftResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static GetEveryDayGiftResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (GetEveryDayGiftResponse) PARSER.parseDelimitedFrom(input);
        }

        public static GetEveryDayGiftResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetEveryDayGiftResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static GetEveryDayGiftResponse parseFrom(CodedInputStream input) throws IOException {
            return (GetEveryDayGiftResponse) PARSER.parseFrom(input);
        }

        public static GetEveryDayGiftResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetEveryDayGiftResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(GetEveryDayGiftResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements VipHandler.GetEveryDayGiftResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;

            public static final Descriptors.Descriptor getDescriptor() {
                return VipHandler.internal_static_pomelo_area_GetEveryDayGiftResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return VipHandler.internal_static_pomelo_area_GetEveryDayGiftResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(VipHandler.GetEveryDayGiftResponse.class, Builder.class);
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
                if (VipHandler.GetEveryDayGiftResponse.alwaysUseFieldBuilders) ;
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
                return VipHandler.internal_static_pomelo_area_GetEveryDayGiftResponse_descriptor;
            }

            public VipHandler.GetEveryDayGiftResponse getDefaultInstanceForType() {
                return VipHandler.GetEveryDayGiftResponse.getDefaultInstance();
            }

            public VipHandler.GetEveryDayGiftResponse build() {
                VipHandler.GetEveryDayGiftResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public VipHandler.GetEveryDayGiftResponse buildPartial() {
                VipHandler.GetEveryDayGiftResponse result = new VipHandler.GetEveryDayGiftResponse(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.s2CMsg_ = this.s2CMsg_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof VipHandler.GetEveryDayGiftResponse)
                    return mergeFrom((VipHandler.GetEveryDayGiftResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(VipHandler.GetEveryDayGiftResponse other) {
                if (other == VipHandler.GetEveryDayGiftResponse.getDefaultInstance()) return this;
                if (other.hasS2CCode()) setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                VipHandler.GetEveryDayGiftResponse parsedMessage = null;
                try {
                    parsedMessage = (VipHandler.GetEveryDayGiftResponse) VipHandler.GetEveryDayGiftResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (VipHandler.GetEveryDayGiftResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = VipHandler.GetEveryDayGiftResponse.getDefaultInstance().getS2CMsg();
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
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class BuyEveryDayGiftRequest
            extends GeneratedMessage
            implements BuyEveryDayGiftRequestOrBuilder {
        private static final BuyEveryDayGiftRequest defaultInstance = new BuyEveryDayGiftRequest(true);
        private final UnknownFieldSet unknownFields;

        private BuyEveryDayGiftRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private BuyEveryDayGiftRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static BuyEveryDayGiftRequest getDefaultInstance() {
            return defaultInstance;
        }

        public BuyEveryDayGiftRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BuyEveryDayGiftRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.c2SVipLevel_ = input.readInt32();
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
            return VipHandler.internal_static_pomelo_area_BuyEveryDayGiftRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return VipHandler.internal_static_pomelo_area_BuyEveryDayGiftRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(BuyEveryDayGiftRequest.class, Builder.class);
        }

        public static Parser<BuyEveryDayGiftRequest> PARSER = (Parser<BuyEveryDayGiftRequest>) new AbstractParser<BuyEveryDayGiftRequest>() {
            public VipHandler.BuyEveryDayGiftRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new VipHandler.BuyEveryDayGiftRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_VIPLEVEL_FIELD_NUMBER = 1;
        private int c2SVipLevel_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<BuyEveryDayGiftRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasC2SVipLevel() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getC2SVipLevel() {
            return this.c2SVipLevel_;
        }

        private void initFields() {
            this.c2SVipLevel_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasC2SVipLevel()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.c2SVipLevel_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.c2SVipLevel_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static BuyEveryDayGiftRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (BuyEveryDayGiftRequest) PARSER.parseFrom(data);
        }

        public static BuyEveryDayGiftRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BuyEveryDayGiftRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static BuyEveryDayGiftRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (BuyEveryDayGiftRequest) PARSER.parseFrom(data);
        }

        public static BuyEveryDayGiftRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BuyEveryDayGiftRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static BuyEveryDayGiftRequest parseFrom(InputStream input) throws IOException {
            return (BuyEveryDayGiftRequest) PARSER.parseFrom(input);
        }

        public static BuyEveryDayGiftRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuyEveryDayGiftRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static BuyEveryDayGiftRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (BuyEveryDayGiftRequest) PARSER.parseDelimitedFrom(input);
        }

        public static BuyEveryDayGiftRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuyEveryDayGiftRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static BuyEveryDayGiftRequest parseFrom(CodedInputStream input) throws IOException {
            return (BuyEveryDayGiftRequest) PARSER.parseFrom(input);
        }

        public static BuyEveryDayGiftRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuyEveryDayGiftRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(BuyEveryDayGiftRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements VipHandler.BuyEveryDayGiftRequestOrBuilder {
            private int bitField0_;
            private int c2SVipLevel_;

            public static final Descriptors.Descriptor getDescriptor() {
                return VipHandler.internal_static_pomelo_area_BuyEveryDayGiftRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return VipHandler.internal_static_pomelo_area_BuyEveryDayGiftRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(VipHandler.BuyEveryDayGiftRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (VipHandler.BuyEveryDayGiftRequest.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.c2SVipLevel_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return VipHandler.internal_static_pomelo_area_BuyEveryDayGiftRequest_descriptor;
            }

            public VipHandler.BuyEveryDayGiftRequest getDefaultInstanceForType() {
                return VipHandler.BuyEveryDayGiftRequest.getDefaultInstance();
            }

            public VipHandler.BuyEveryDayGiftRequest build() {
                VipHandler.BuyEveryDayGiftRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public VipHandler.BuyEveryDayGiftRequest buildPartial() {
                VipHandler.BuyEveryDayGiftRequest result = new VipHandler.BuyEveryDayGiftRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.c2SVipLevel_ = this.c2SVipLevel_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof VipHandler.BuyEveryDayGiftRequest)
                    return mergeFrom((VipHandler.BuyEveryDayGiftRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(VipHandler.BuyEveryDayGiftRequest other) {
                if (other == VipHandler.BuyEveryDayGiftRequest.getDefaultInstance()) return this;
                if (other.hasC2SVipLevel()) setC2SVipLevel(other.getC2SVipLevel());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasC2SVipLevel()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                VipHandler.BuyEveryDayGiftRequest parsedMessage = null;
                try {
                    parsedMessage = (VipHandler.BuyEveryDayGiftRequest) VipHandler.BuyEveryDayGiftRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (VipHandler.BuyEveryDayGiftRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasC2SVipLevel() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getC2SVipLevel() {
                return this.c2SVipLevel_;
            }

            public Builder setC2SVipLevel(int value) {
                this.bitField0_ |= 0x1;
                this.c2SVipLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearC2SVipLevel() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SVipLevel_ = 0;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class BuyEveryDayGiftResponse
            extends GeneratedMessage
            implements BuyEveryDayGiftResponseOrBuilder {
        private static final BuyEveryDayGiftResponse defaultInstance = new BuyEveryDayGiftResponse(true);
        private final UnknownFieldSet unknownFields;

        private BuyEveryDayGiftResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private BuyEveryDayGiftResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static BuyEveryDayGiftResponse getDefaultInstance() {
            return defaultInstance;
        }

        public BuyEveryDayGiftResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BuyEveryDayGiftResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return VipHandler.internal_static_pomelo_area_BuyEveryDayGiftResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return VipHandler.internal_static_pomelo_area_BuyEveryDayGiftResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(BuyEveryDayGiftResponse.class, Builder.class);
        }

        public static Parser<BuyEveryDayGiftResponse> PARSER = (Parser<BuyEveryDayGiftResponse>) new AbstractParser<BuyEveryDayGiftResponse>() {
            public VipHandler.BuyEveryDayGiftResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new VipHandler.BuyEveryDayGiftResponse(input, extensionRegistry);
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

        public Parser<BuyEveryDayGiftResponse> getParserForType() {
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

        public static BuyEveryDayGiftResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (BuyEveryDayGiftResponse) PARSER.parseFrom(data);
        }

        public static BuyEveryDayGiftResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BuyEveryDayGiftResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static BuyEveryDayGiftResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (BuyEveryDayGiftResponse) PARSER.parseFrom(data);
        }

        public static BuyEveryDayGiftResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BuyEveryDayGiftResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static BuyEveryDayGiftResponse parseFrom(InputStream input) throws IOException {
            return (BuyEveryDayGiftResponse) PARSER.parseFrom(input);
        }

        public static BuyEveryDayGiftResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuyEveryDayGiftResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static BuyEveryDayGiftResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (BuyEveryDayGiftResponse) PARSER.parseDelimitedFrom(input);
        }

        public static BuyEveryDayGiftResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuyEveryDayGiftResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static BuyEveryDayGiftResponse parseFrom(CodedInputStream input) throws IOException {
            return (BuyEveryDayGiftResponse) PARSER.parseFrom(input);
        }

        public static BuyEveryDayGiftResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuyEveryDayGiftResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(BuyEveryDayGiftResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements VipHandler.BuyEveryDayGiftResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;

            public static final Descriptors.Descriptor getDescriptor() {
                return VipHandler.internal_static_pomelo_area_BuyEveryDayGiftResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return VipHandler.internal_static_pomelo_area_BuyEveryDayGiftResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(VipHandler.BuyEveryDayGiftResponse.class, Builder.class);
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
                if (VipHandler.BuyEveryDayGiftResponse.alwaysUseFieldBuilders) ;
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
                return VipHandler.internal_static_pomelo_area_BuyEveryDayGiftResponse_descriptor;
            }

            public VipHandler.BuyEveryDayGiftResponse getDefaultInstanceForType() {
                return VipHandler.BuyEveryDayGiftResponse.getDefaultInstance();
            }

            public VipHandler.BuyEveryDayGiftResponse build() {
                VipHandler.BuyEveryDayGiftResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public VipHandler.BuyEveryDayGiftResponse buildPartial() {
                VipHandler.BuyEveryDayGiftResponse result = new VipHandler.BuyEveryDayGiftResponse(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.s2CMsg_ = this.s2CMsg_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof VipHandler.BuyEveryDayGiftResponse)
                    return mergeFrom((VipHandler.BuyEveryDayGiftResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(VipHandler.BuyEveryDayGiftResponse other) {
                if (other == VipHandler.BuyEveryDayGiftResponse.getDefaultInstance()) return this;
                if (other.hasS2CCode()) setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                VipHandler.BuyEveryDayGiftResponse parsedMessage = null;
                try {
                    parsedMessage = (VipHandler.BuyEveryDayGiftResponse) VipHandler.BuyEveryDayGiftResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (VipHandler.BuyEveryDayGiftResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = VipHandler.BuyEveryDayGiftResponse.getDefaultInstance().getS2CMsg();
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
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class BuyVipCardRequest
            extends GeneratedMessage
            implements BuyVipCardRequestOrBuilder {
        private static final BuyVipCardRequest defaultInstance = new BuyVipCardRequest(true);
        private final UnknownFieldSet unknownFields;

        private BuyVipCardRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private BuyVipCardRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static BuyVipCardRequest getDefaultInstance() {
            return defaultInstance;
        }

        public BuyVipCardRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BuyVipCardRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.c2STypeId_ = input.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.c2SItemId_ = input.readInt32();
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
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
            return VipHandler.internal_static_pomelo_area_BuyVipCardRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return VipHandler.internal_static_pomelo_area_BuyVipCardRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(BuyVipCardRequest.class, Builder.class);
        }

        public static Parser<BuyVipCardRequest> PARSER = (Parser<BuyVipCardRequest>) new AbstractParser<BuyVipCardRequest>() {
            public VipHandler.BuyVipCardRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new VipHandler.BuyVipCardRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_TYPEID_FIELD_NUMBER = 1;
        private int c2STypeId_;
        public static final int C2S_ITEMID_FIELD_NUMBER = 2;
        private int c2SItemId_;
        public static final int C2S_TYPE_FIELD_NUMBER = 3;
        private int c2SType_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<BuyVipCardRequest> getParserForType() {
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

        public boolean hasC2SType() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getC2SType() {
            return this.c2SType_;
        }

        private void initFields() {
            this.c2STypeId_ = 0;
            this.c2SItemId_ = 0;
            this.c2SType_ = 0;
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
            if (!hasC2SType()) {
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
            if ((this.bitField0_ & 0x4) == 4) output.writeInt32(3, this.c2SType_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.c2STypeId_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(2, this.c2SItemId_);
            if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeInt32Size(3, this.c2SType_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static BuyVipCardRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (BuyVipCardRequest) PARSER.parseFrom(data);
        }

        public static BuyVipCardRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BuyVipCardRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static BuyVipCardRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (BuyVipCardRequest) PARSER.parseFrom(data);
        }

        public static BuyVipCardRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BuyVipCardRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static BuyVipCardRequest parseFrom(InputStream input) throws IOException {
            return (BuyVipCardRequest) PARSER.parseFrom(input);
        }

        public static BuyVipCardRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuyVipCardRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static BuyVipCardRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (BuyVipCardRequest) PARSER.parseDelimitedFrom(input);
        }

        public static BuyVipCardRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuyVipCardRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static BuyVipCardRequest parseFrom(CodedInputStream input) throws IOException {
            return (BuyVipCardRequest) PARSER.parseFrom(input);
        }

        public static BuyVipCardRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuyVipCardRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(BuyVipCardRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements VipHandler.BuyVipCardRequestOrBuilder {
            private int bitField0_;
            private int c2STypeId_;
            private int c2SItemId_;
            private int c2SType_;

            public static final Descriptors.Descriptor getDescriptor() {
                return VipHandler.internal_static_pomelo_area_BuyVipCardRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return VipHandler.internal_static_pomelo_area_BuyVipCardRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(VipHandler.BuyVipCardRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (VipHandler.BuyVipCardRequest.alwaysUseFieldBuilders) ;
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
                this.c2SType_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return VipHandler.internal_static_pomelo_area_BuyVipCardRequest_descriptor;
            }

            public VipHandler.BuyVipCardRequest getDefaultInstanceForType() {
                return VipHandler.BuyVipCardRequest.getDefaultInstance();
            }

            public VipHandler.BuyVipCardRequest build() {
                VipHandler.BuyVipCardRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public VipHandler.BuyVipCardRequest buildPartial() {
                VipHandler.BuyVipCardRequest result = new VipHandler.BuyVipCardRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.c2STypeId_ = this.c2STypeId_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.c2SItemId_ = this.c2SItemId_;
                if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;
                result.c2SType_ = this.c2SType_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof VipHandler.BuyVipCardRequest)
                    return mergeFrom((VipHandler.BuyVipCardRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(VipHandler.BuyVipCardRequest other) {
                if (other == VipHandler.BuyVipCardRequest.getDefaultInstance()) return this;
                if (other.hasC2STypeId()) setC2STypeId(other.getC2STypeId());
                if (other.hasC2SItemId()) setC2SItemId(other.getC2SItemId());
                if (other.hasC2SType()) setC2SType(other.getC2SType());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasC2STypeId()) return false;
                if (!hasC2SItemId()) return false;
                if (!hasC2SType()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                VipHandler.BuyVipCardRequest parsedMessage = null;
                try {
                    parsedMessage = (VipHandler.BuyVipCardRequest) VipHandler.BuyVipCardRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (VipHandler.BuyVipCardRequest) e.getUnfinishedMessage();
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

            public boolean hasC2SType() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public int getC2SType() {
                return this.c2SType_;
            }

            public Builder setC2SType(int value) {
                this.bitField0_ |= 0x4;
                this.c2SType_ = value;
                onChanged();
                return this;
            }

            public Builder clearC2SType() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.c2SType_ = 0;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class BuyVipCardResponse
            extends GeneratedMessage
            implements BuyVipCardResponseOrBuilder {
        private static final BuyVipCardResponse defaultInstance = new BuyVipCardResponse(true);
        private final UnknownFieldSet unknownFields;

        private BuyVipCardResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private BuyVipCardResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static BuyVipCardResponse getDefaultInstance() {
            return defaultInstance;
        }

        public BuyVipCardResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BuyVipCardResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            bs = input.readBytes();
                            this.bitField0_ |= 0x4;
                            this.s2CVipTime_ = bs;
                            break;
                        case 34:
                            if ((mutable_bitField0_ & 0x8) != 8) {
                                this.s2CGetData_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x8;
                            }
                            this.s2CGetData_.add(input.readMessage(VipHandler.VipGetGiftData.PARSER, extensionRegistry));
                            break;
                        case 42:
                            if ((mutable_bitField0_ & 0x10) != 16) {
                                this.s2CBuyData_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x10;
                            }
                            this.s2CBuyData_.add(input.readMessage(VipHandler.VipBuyGiftData.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x8) == 8) this.s2CGetData_ = Collections.unmodifiableList(this.s2CGetData_);
                if ((mutable_bitField0_ & 0x10) == 16)
                    this.s2CBuyData_ = Collections.unmodifiableList(this.s2CBuyData_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return VipHandler.internal_static_pomelo_area_BuyVipCardResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return VipHandler.internal_static_pomelo_area_BuyVipCardResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(BuyVipCardResponse.class, Builder.class);
        }

        public static Parser<BuyVipCardResponse> PARSER = (Parser<BuyVipCardResponse>) new AbstractParser<BuyVipCardResponse>() {
            public VipHandler.BuyVipCardResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new VipHandler.BuyVipCardResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_VIPTIME_FIELD_NUMBER = 3;
        private Object s2CVipTime_;
        public static final int S2C_GETDATA_FIELD_NUMBER = 4;
        private List<VipHandler.VipGetGiftData> s2CGetData_;
        public static final int S2C_BUYDATA_FIELD_NUMBER = 5;
        private List<VipHandler.VipBuyGiftData> s2CBuyData_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<BuyVipCardResponse> getParserForType() {
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

        public boolean hasS2CVipTime() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public String getS2CVipTime() {
            Object ref = this.s2CVipTime_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.s2CVipTime_ = s;
            return s;
        }

        public ByteString getS2CVipTimeBytes() {
            Object ref = this.s2CVipTime_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.s2CVipTime_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public List<VipHandler.VipGetGiftData> getS2CGetDataList() {
            return this.s2CGetData_;
        }

        public List<? extends VipHandler.VipGetGiftDataOrBuilder> getS2CGetDataOrBuilderList() {
            return (List) this.s2CGetData_;
        }

        public int getS2CGetDataCount() {
            return this.s2CGetData_.size();
        }

        public VipHandler.VipGetGiftData getS2CGetData(int index) {
            return this.s2CGetData_.get(index);
        }

        public VipHandler.VipGetGiftDataOrBuilder getS2CGetDataOrBuilder(int index) {
            return this.s2CGetData_.get(index);
        }

        public List<VipHandler.VipBuyGiftData> getS2CBuyDataList() {
            return this.s2CBuyData_;
        }

        public List<? extends VipHandler.VipBuyGiftDataOrBuilder> getS2CBuyDataOrBuilderList() {
            return (List) this.s2CBuyData_;
        }

        public int getS2CBuyDataCount() {
            return this.s2CBuyData_.size();
        }

        public VipHandler.VipBuyGiftData getS2CBuyData(int index) {
            return this.s2CBuyData_.get(index);
        }

        public VipHandler.VipBuyGiftDataOrBuilder getS2CBuyDataOrBuilder(int index) {
            return this.s2CBuyData_.get(index);
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CVipTime_ = "";
            this.s2CGetData_ = Collections.emptyList();
            this.s2CBuyData_ = Collections.emptyList();
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
            for (i = 0; i < getS2CGetDataCount(); i++) {
                if (!getS2CGetData(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (i = 0; i < getS2CBuyDataCount(); i++) {
                if (!getS2CBuyData(i).isInitialized()) {
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
            if ((this.bitField0_ & 0x4) == 4) output.writeBytes(3, getS2CVipTimeBytes());
            int i;
            for (i = 0; i < this.s2CGetData_.size(); i++) output.writeMessage(4, (MessageLite) this.s2CGetData_.get(i));
            for (i = 0; i < this.s2CBuyData_.size(); i++) output.writeMessage(5, (MessageLite) this.s2CBuyData_.get(i));
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());
            if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeBytesSize(3, getS2CVipTimeBytes());
            int i;
            for (i = 0; i < this.s2CGetData_.size(); i++)
                size += CodedOutputStream.computeMessageSize(4, (MessageLite) this.s2CGetData_.get(i));
            for (i = 0; i < this.s2CBuyData_.size(); i++)
                size += CodedOutputStream.computeMessageSize(5, (MessageLite) this.s2CBuyData_.get(i));
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

        public static BuyVipCardResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (BuyVipCardResponse) PARSER.parseFrom(data);
        }

        public static BuyVipCardResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BuyVipCardResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static BuyVipCardResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (BuyVipCardResponse) PARSER.parseFrom(data);
        }

        public static BuyVipCardResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BuyVipCardResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static BuyVipCardResponse parseFrom(InputStream input) throws IOException {
            return (BuyVipCardResponse) PARSER.parseFrom(input);
        }

        public static BuyVipCardResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuyVipCardResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static BuyVipCardResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (BuyVipCardResponse) PARSER.parseDelimitedFrom(input);
        }

        public static BuyVipCardResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuyVipCardResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static BuyVipCardResponse parseFrom(CodedInputStream input) throws IOException {
            return (BuyVipCardResponse) PARSER.parseFrom(input);
        }

        public static BuyVipCardResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuyVipCardResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(BuyVipCardResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements VipHandler.BuyVipCardResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private Object s2CVipTime_;
            private List<VipHandler.VipGetGiftData> s2CGetData_;
            private RepeatedFieldBuilder<VipHandler.VipGetGiftData, VipHandler.VipGetGiftData.Builder, VipHandler.VipGetGiftDataOrBuilder> s2CGetDataBuilder_;
            private List<VipHandler.VipBuyGiftData> s2CBuyData_;
            private RepeatedFieldBuilder<VipHandler.VipBuyGiftData, VipHandler.VipBuyGiftData.Builder, VipHandler.VipBuyGiftDataOrBuilder> s2CBuyDataBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return VipHandler.internal_static_pomelo_area_BuyVipCardResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return VipHandler.internal_static_pomelo_area_BuyVipCardResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(VipHandler.BuyVipCardResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.s2CVipTime_ = "";
                this.s2CGetData_ = Collections.emptyList();
                this.s2CBuyData_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CVipTime_ = "";
                this.s2CGetData_ = Collections.emptyList();
                this.s2CBuyData_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (VipHandler.BuyVipCardResponse.alwaysUseFieldBuilders) {
                    getS2CGetDataFieldBuilder();
                    getS2CBuyDataFieldBuilder();
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
                this.s2CVipTime_ = "";
                this.bitField0_ &= 0xFFFFFFFB;
                if (this.s2CGetDataBuilder_ == null) {
                    this.s2CGetData_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFF7;
                } else {
                    this.s2CGetDataBuilder_.clear();
                }
                if (this.s2CBuyDataBuilder_ == null) {
                    this.s2CBuyData_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFEF;
                } else {
                    this.s2CBuyDataBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return VipHandler.internal_static_pomelo_area_BuyVipCardResponse_descriptor;
            }

            public VipHandler.BuyVipCardResponse getDefaultInstanceForType() {
                return VipHandler.BuyVipCardResponse.getDefaultInstance();
            }

            public VipHandler.BuyVipCardResponse build() {
                VipHandler.BuyVipCardResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public VipHandler.BuyVipCardResponse buildPartial() {
                VipHandler.BuyVipCardResponse result = new VipHandler.BuyVipCardResponse(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.s2CMsg_ = this.s2CMsg_;
                if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;
                result.s2CVipTime_ = this.s2CVipTime_;
                if (this.s2CGetDataBuilder_ == null) {
                    if ((this.bitField0_ & 0x8) == 8) {
                        this.s2CGetData_ = Collections.unmodifiableList(this.s2CGetData_);
                        this.bitField0_ &= 0xFFFFFFF7;
                    }
                    result.s2CGetData_ = this.s2CGetData_;
                } else {
                    result.s2CGetData_ = this.s2CGetDataBuilder_.build();
                }
                if (this.s2CBuyDataBuilder_ == null) {
                    if ((this.bitField0_ & 0x10) == 16) {
                        this.s2CBuyData_ = Collections.unmodifiableList(this.s2CBuyData_);
                        this.bitField0_ &= 0xFFFFFFEF;
                    }
                    result.s2CBuyData_ = this.s2CBuyData_;
                } else {
                    result.s2CBuyData_ = this.s2CBuyDataBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof VipHandler.BuyVipCardResponse)
                    return mergeFrom((VipHandler.BuyVipCardResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(VipHandler.BuyVipCardResponse other) {
                if (other == VipHandler.BuyVipCardResponse.getDefaultInstance()) return this;
                if (other.hasS2CCode()) setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (other.hasS2CVipTime()) {
                    this.bitField0_ |= 0x4;
                    this.s2CVipTime_ = other.s2CVipTime_;
                    onChanged();
                }
                if (this.s2CGetDataBuilder_ == null) {
                    if (!other.s2CGetData_.isEmpty()) {
                        if (this.s2CGetData_.isEmpty()) {
                            this.s2CGetData_ = other.s2CGetData_;
                            this.bitField0_ &= 0xFFFFFFF7;
                        } else {
                            ensureS2CGetDataIsMutable();
                            this.s2CGetData_.addAll(other.s2CGetData_);
                        }
                        onChanged();
                    }
                } else if (!other.s2CGetData_.isEmpty()) {
                    if (this.s2CGetDataBuilder_.isEmpty()) {
                        this.s2CGetDataBuilder_.dispose();
                        this.s2CGetDataBuilder_ = null;
                        this.s2CGetData_ = other.s2CGetData_;
                        this.bitField0_ &= 0xFFFFFFF7;
                        this.s2CGetDataBuilder_ = VipHandler.BuyVipCardResponse.alwaysUseFieldBuilders ? getS2CGetDataFieldBuilder() : null;
                    } else {
                        this.s2CGetDataBuilder_.addAllMessages(other.s2CGetData_);
                    }
                }
                if (this.s2CBuyDataBuilder_ == null) {
                    if (!other.s2CBuyData_.isEmpty()) {
                        if (this.s2CBuyData_.isEmpty()) {
                            this.s2CBuyData_ = other.s2CBuyData_;
                            this.bitField0_ &= 0xFFFFFFEF;
                        } else {
                            ensureS2CBuyDataIsMutable();
                            this.s2CBuyData_.addAll(other.s2CBuyData_);
                        }
                        onChanged();
                    }
                } else if (!other.s2CBuyData_.isEmpty()) {
                    if (this.s2CBuyDataBuilder_.isEmpty()) {
                        this.s2CBuyDataBuilder_.dispose();
                        this.s2CBuyDataBuilder_ = null;
                        this.s2CBuyData_ = other.s2CBuyData_;
                        this.bitField0_ &= 0xFFFFFFEF;
                        this.s2CBuyDataBuilder_ = VipHandler.BuyVipCardResponse.alwaysUseFieldBuilders ? getS2CBuyDataFieldBuilder() : null;
                    } else {
                        this.s2CBuyDataBuilder_.addAllMessages(other.s2CBuyData_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode()) return false;
                int i;
                for (i = 0; i < getS2CGetDataCount(); i++) {
                    if (!getS2CGetData(i).isInitialized()) return false;
                }
                for (i = 0; i < getS2CBuyDataCount(); i++) {
                    if (!getS2CBuyData(i).isInitialized()) return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                VipHandler.BuyVipCardResponse parsedMessage = null;
                try {
                    parsedMessage = (VipHandler.BuyVipCardResponse) VipHandler.BuyVipCardResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (VipHandler.BuyVipCardResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = VipHandler.BuyVipCardResponse.getDefaultInstance().getS2CMsg();
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

            public boolean hasS2CVipTime() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public String getS2CVipTime() {
                Object ref = this.s2CVipTime_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) this.s2CVipTime_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getS2CVipTimeBytes() {
                Object ref = this.s2CVipTime_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.s2CVipTime_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setS2CVipTime(String value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x4;
                this.s2CVipTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CVipTime() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.s2CVipTime_ = VipHandler.BuyVipCardResponse.getDefaultInstance().getS2CVipTime();
                onChanged();
                return this;
            }

            public Builder setS2CVipTimeBytes(ByteString value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x4;
                this.s2CVipTime_ = value;
                onChanged();
                return this;
            }

            private void ensureS2CGetDataIsMutable() {
                if ((this.bitField0_ & 0x8) != 8) {
                    this.s2CGetData_ = new ArrayList<>(this.s2CGetData_);
                    this.bitField0_ |= 0x8;
                }
            }

            public List<VipHandler.VipGetGiftData> getS2CGetDataList() {
                if (this.s2CGetDataBuilder_ == null) return Collections.unmodifiableList(this.s2CGetData_);
                return this.s2CGetDataBuilder_.getMessageList();
            }

            public int getS2CGetDataCount() {
                if (this.s2CGetDataBuilder_ == null) return this.s2CGetData_.size();
                return this.s2CGetDataBuilder_.getCount();
            }

            public VipHandler.VipGetGiftData getS2CGetData(int index) {
                if (this.s2CGetDataBuilder_ == null) return this.s2CGetData_.get(index);
                return (VipHandler.VipGetGiftData) this.s2CGetDataBuilder_.getMessage(index);
            }

            public Builder setS2CGetData(int index, VipHandler.VipGetGiftData value) {
                if (this.s2CGetDataBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureS2CGetDataIsMutable();
                    this.s2CGetData_.set(index, value);
                    onChanged();
                } else {
                    this.s2CGetDataBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setS2CGetData(int index, VipHandler.VipGetGiftData.Builder builderForValue) {
                if (this.s2CGetDataBuilder_ == null) {
                    ensureS2CGetDataIsMutable();
                    this.s2CGetData_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CGetDataBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addS2CGetData(VipHandler.VipGetGiftData value) {
                if (this.s2CGetDataBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureS2CGetDataIsMutable();
                    this.s2CGetData_.add(value);
                    onChanged();
                } else {
                    this.s2CGetDataBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addS2CGetData(int index, VipHandler.VipGetGiftData value) {
                if (this.s2CGetDataBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureS2CGetDataIsMutable();
                    this.s2CGetData_.add(index, value);
                    onChanged();
                } else {
                    this.s2CGetDataBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addS2CGetData(VipHandler.VipGetGiftData.Builder builderForValue) {
                if (this.s2CGetDataBuilder_ == null) {
                    ensureS2CGetDataIsMutable();
                    this.s2CGetData_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.s2CGetDataBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addS2CGetData(int index, VipHandler.VipGetGiftData.Builder builderForValue) {
                if (this.s2CGetDataBuilder_ == null) {
                    ensureS2CGetDataIsMutable();
                    this.s2CGetData_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CGetDataBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllS2CGetData(Iterable<? extends VipHandler.VipGetGiftData> values) {
                if (this.s2CGetDataBuilder_ == null) {
                    ensureS2CGetDataIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.s2CGetData_);
                    onChanged();
                } else {
                    this.s2CGetDataBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearS2CGetData() {
                if (this.s2CGetDataBuilder_ == null) {
                    this.s2CGetData_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFF7;
                    onChanged();
                } else {
                    this.s2CGetDataBuilder_.clear();
                }
                return this;
            }

            public Builder removeS2CGetData(int index) {
                if (this.s2CGetDataBuilder_ == null) {
                    ensureS2CGetDataIsMutable();
                    this.s2CGetData_.remove(index);
                    onChanged();
                } else {
                    this.s2CGetDataBuilder_.remove(index);
                }
                return this;
            }

            public VipHandler.VipGetGiftData.Builder getS2CGetDataBuilder(int index) {
                return (VipHandler.VipGetGiftData.Builder) getS2CGetDataFieldBuilder().getBuilder(index);
            }

            public VipHandler.VipGetGiftDataOrBuilder getS2CGetDataOrBuilder(int index) {
                if (this.s2CGetDataBuilder_ == null) return this.s2CGetData_.get(index);
                return (VipHandler.VipGetGiftDataOrBuilder) this.s2CGetDataBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends VipHandler.VipGetGiftDataOrBuilder> getS2CGetDataOrBuilderList() {
                if (this.s2CGetDataBuilder_ != null) return this.s2CGetDataBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.s2CGetData_);
            }

            public VipHandler.VipGetGiftData.Builder addS2CGetDataBuilder() {
                return (VipHandler.VipGetGiftData.Builder) getS2CGetDataFieldBuilder().addBuilder(VipHandler.VipGetGiftData.getDefaultInstance());
            }

            public VipHandler.VipGetGiftData.Builder addS2CGetDataBuilder(int index) {
                return (VipHandler.VipGetGiftData.Builder) getS2CGetDataFieldBuilder().addBuilder(index, VipHandler.VipGetGiftData.getDefaultInstance());
            }

            public List<VipHandler.VipGetGiftData.Builder> getS2CGetDataBuilderList() {
                return getS2CGetDataFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<VipHandler.VipGetGiftData, VipHandler.VipGetGiftData.Builder, VipHandler.VipGetGiftDataOrBuilder> getS2CGetDataFieldBuilder() {
                if (this.s2CGetDataBuilder_ == null) {
                    this.s2CGetDataBuilder_ = new RepeatedFieldBuilder(this.s2CGetData_, ((this.bitField0_ & 0x8) == 8), getParentForChildren(), isClean());
                    this.s2CGetData_ = null;
                }
                return this.s2CGetDataBuilder_;
            }

            private void ensureS2CBuyDataIsMutable() {
                if ((this.bitField0_ & 0x10) != 16) {
                    this.s2CBuyData_ = new ArrayList<>(this.s2CBuyData_);
                    this.bitField0_ |= 0x10;
                }
            }

            public List<VipHandler.VipBuyGiftData> getS2CBuyDataList() {
                if (this.s2CBuyDataBuilder_ == null) return Collections.unmodifiableList(this.s2CBuyData_);
                return this.s2CBuyDataBuilder_.getMessageList();
            }

            public int getS2CBuyDataCount() {
                if (this.s2CBuyDataBuilder_ == null) return this.s2CBuyData_.size();
                return this.s2CBuyDataBuilder_.getCount();
            }

            public VipHandler.VipBuyGiftData getS2CBuyData(int index) {
                if (this.s2CBuyDataBuilder_ == null) return this.s2CBuyData_.get(index);
                return (VipHandler.VipBuyGiftData) this.s2CBuyDataBuilder_.getMessage(index);
            }

            public Builder setS2CBuyData(int index, VipHandler.VipBuyGiftData value) {
                if (this.s2CBuyDataBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureS2CBuyDataIsMutable();
                    this.s2CBuyData_.set(index, value);
                    onChanged();
                } else {
                    this.s2CBuyDataBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setS2CBuyData(int index, VipHandler.VipBuyGiftData.Builder builderForValue) {
                if (this.s2CBuyDataBuilder_ == null) {
                    ensureS2CBuyDataIsMutable();
                    this.s2CBuyData_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CBuyDataBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addS2CBuyData(VipHandler.VipBuyGiftData value) {
                if (this.s2CBuyDataBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureS2CBuyDataIsMutable();
                    this.s2CBuyData_.add(value);
                    onChanged();
                } else {
                    this.s2CBuyDataBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addS2CBuyData(int index, VipHandler.VipBuyGiftData value) {
                if (this.s2CBuyDataBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureS2CBuyDataIsMutable();
                    this.s2CBuyData_.add(index, value);
                    onChanged();
                } else {
                    this.s2CBuyDataBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addS2CBuyData(VipHandler.VipBuyGiftData.Builder builderForValue) {
                if (this.s2CBuyDataBuilder_ == null) {
                    ensureS2CBuyDataIsMutable();
                    this.s2CBuyData_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.s2CBuyDataBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addS2CBuyData(int index, VipHandler.VipBuyGiftData.Builder builderForValue) {
                if (this.s2CBuyDataBuilder_ == null) {
                    ensureS2CBuyDataIsMutable();
                    this.s2CBuyData_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CBuyDataBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllS2CBuyData(Iterable<? extends VipHandler.VipBuyGiftData> values) {
                if (this.s2CBuyDataBuilder_ == null) {
                    ensureS2CBuyDataIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.s2CBuyData_);
                    onChanged();
                } else {
                    this.s2CBuyDataBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearS2CBuyData() {
                if (this.s2CBuyDataBuilder_ == null) {
                    this.s2CBuyData_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFEF;
                    onChanged();
                } else {
                    this.s2CBuyDataBuilder_.clear();
                }
                return this;
            }

            public Builder removeS2CBuyData(int index) {
                if (this.s2CBuyDataBuilder_ == null) {
                    ensureS2CBuyDataIsMutable();
                    this.s2CBuyData_.remove(index);
                    onChanged();
                } else {
                    this.s2CBuyDataBuilder_.remove(index);
                }
                return this;
            }

            public VipHandler.VipBuyGiftData.Builder getS2CBuyDataBuilder(int index) {
                return (VipHandler.VipBuyGiftData.Builder) getS2CBuyDataFieldBuilder().getBuilder(index);
            }

            public VipHandler.VipBuyGiftDataOrBuilder getS2CBuyDataOrBuilder(int index) {
                if (this.s2CBuyDataBuilder_ == null) return this.s2CBuyData_.get(index);
                return (VipHandler.VipBuyGiftDataOrBuilder) this.s2CBuyDataBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends VipHandler.VipBuyGiftDataOrBuilder> getS2CBuyDataOrBuilderList() {
                if (this.s2CBuyDataBuilder_ != null) return this.s2CBuyDataBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.s2CBuyData_);
            }

            public VipHandler.VipBuyGiftData.Builder addS2CBuyDataBuilder() {
                return (VipHandler.VipBuyGiftData.Builder) getS2CBuyDataFieldBuilder().addBuilder(VipHandler.VipBuyGiftData.getDefaultInstance());
            }

            public VipHandler.VipBuyGiftData.Builder addS2CBuyDataBuilder(int index) {
                return (VipHandler.VipBuyGiftData.Builder) getS2CBuyDataFieldBuilder().addBuilder(index, VipHandler.VipBuyGiftData.getDefaultInstance());
            }

            public List<VipHandler.VipBuyGiftData.Builder> getS2CBuyDataBuilderList() {
                return getS2CBuyDataFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<VipHandler.VipBuyGiftData, VipHandler.VipBuyGiftData.Builder, VipHandler.VipBuyGiftDataOrBuilder> getS2CBuyDataFieldBuilder() {
                if (this.s2CBuyDataBuilder_ == null) {
                    this.s2CBuyDataBuilder_ = new RepeatedFieldBuilder(this.s2CBuyData_, ((this.bitField0_ & 0x10) == 16), getParentForChildren(), isClean());
                    this.s2CBuyData_ = null;
                }
                return this.s2CBuyDataBuilder_;
            }
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }


    static {
        String[] descriptorData = {"\n\020vipHandler.proto\022\013pomelo.area\"\f\n\nVipRequest\")\n\013VipGiftInfo\022\f\n\004type\030\001 \002(\005\022\f\n\004flag\030\002 \002(\005\"9\n\016VipGetGiftData\022'\n\005datas\030\001 \003(\0132\030.pomelo.area.VipGiftInfo\"9\n\016VipBuyGiftData\022\020\n\bvipLevel\030\001 \002(\005\022\025\n\rdailyBuyCount\030\002 \002(\005\"q\n\013VipResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022'\n\005datas\030\003 \003(\0132\030.pomelo.area.VipGiftInfo\022\026\n\016s2c_remainTime\030\004 \001(\003\"*\n\026GetEveryDayGiftRequest\022\020\n\bc2s_type\030\001 \002(\005\"<\n\027GetEveryDayGiftResponse\022\020\n\bs2c_", "code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\".\n\026BuyEveryDayGiftRequest\022\024\n\fc2s_vipLevel\030\001 \002(\005\"<\n\027BuyEveryDayGiftResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"M\n\021BuyVipCardRequest\022\022\n\nc2s_typeId\030\001 \002(\005\022\022\n\nc2s_itemId\030\002 \002(\005\022\020\n\bc2s_type\030\003 \002(\005\"°\001\n\022BuyVipCardResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\023\n\013s2c_vipTime\030\003 \001(\t\0220\n\013s2c_getData\030\004 \003(\0132\033.pomelo.area.VipGetGiftData\0220\n\013s2c_buyData\030\005 \003(\0132\033.pomelo.area.VipBuyGiftData2ñ\002\n\n", "vipHandler\022C\n\016vipInfoRequest\022\027.pomelo.area.VipRequest\032\030.pomelo.area.VipResponse\022c\n\026getEveryDayGiftRequest\022#.pomelo.area.GetEveryDayGiftRequest\032$.pomelo.area.GetEveryDayGiftResponse\022c\n\026buyEveryDayGiftRequest\022#.pomelo.area.BuyEveryDayGiftRequest\032$.pomelo.area.BuyEveryDayGiftResponse\022T\n\021buyVipCardRequest\022\036.pomelo.area.BuyVipCardRequest\032\037.pomelo.area.BuyVipCardResponse"};


        Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root) {
                VipHandler.descriptor = root;
                return null;
            }
        };

        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[0], assigner);
    }


    private static final Descriptors.Descriptor internal_static_pomelo_area_VipRequest_descriptor = getDescriptor().getMessageTypes().get(0);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_VipRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_VipRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_area_VipGiftInfo_descriptor = getDescriptor().getMessageTypes().get(1);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_VipGiftInfo_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_VipGiftInfo_descriptor, new String[]{"Type", "Flag"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_VipGetGiftData_descriptor = getDescriptor().getMessageTypes().get(2);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_VipGetGiftData_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_VipGetGiftData_descriptor, new String[]{"Datas"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_VipBuyGiftData_descriptor = getDescriptor().getMessageTypes().get(3);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_VipBuyGiftData_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_VipBuyGiftData_descriptor, new String[]{"VipLevel", "DailyBuyCount"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_VipResponse_descriptor = getDescriptor().getMessageTypes().get(4);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_VipResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_VipResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "Datas", "S2CRemainTime"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetEveryDayGiftRequest_descriptor = getDescriptor().getMessageTypes().get(5);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetEveryDayGiftRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetEveryDayGiftRequest_descriptor, new String[]{"C2SType"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetEveryDayGiftResponse_descriptor = getDescriptor().getMessageTypes().get(6);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetEveryDayGiftResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetEveryDayGiftResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_BuyEveryDayGiftRequest_descriptor = getDescriptor().getMessageTypes().get(7);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_BuyEveryDayGiftRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_BuyEveryDayGiftRequest_descriptor, new String[]{"C2SVipLevel"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_BuyEveryDayGiftResponse_descriptor = getDescriptor().getMessageTypes().get(8);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_BuyEveryDayGiftResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_BuyEveryDayGiftResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_BuyVipCardRequest_descriptor = getDescriptor().getMessageTypes().get(9);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_BuyVipCardRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_BuyVipCardRequest_descriptor, new String[]{"C2STypeId", "C2SItemId", "C2SType"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_BuyVipCardResponse_descriptor = getDescriptor().getMessageTypes().get(10);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_BuyVipCardResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_BuyVipCardResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CVipTime", "S2CGetData", "S2CBuyData"});
    private static Descriptors.FileDescriptor descriptor;

    public static interface BuyVipCardResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasS2CVipTime();

        String getS2CVipTime();

        ByteString getS2CVipTimeBytes();

        List<VipHandler.VipGetGiftData> getS2CGetDataList();

        VipHandler.VipGetGiftData getS2CGetData(int param1Int);

        int getS2CGetDataCount();

        List<? extends VipHandler.VipGetGiftDataOrBuilder> getS2CGetDataOrBuilderList();

        VipHandler.VipGetGiftDataOrBuilder getS2CGetDataOrBuilder(int param1Int);

        List<VipHandler.VipBuyGiftData> getS2CBuyDataList();

        VipHandler.VipBuyGiftData getS2CBuyData(int param1Int);

        int getS2CBuyDataCount();

        List<? extends VipHandler.VipBuyGiftDataOrBuilder> getS2CBuyDataOrBuilderList();

        VipHandler.VipBuyGiftDataOrBuilder getS2CBuyDataOrBuilder(int param1Int);
    }

    public static interface BuyVipCardRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2STypeId();

        int getC2STypeId();

        boolean hasC2SItemId();

        int getC2SItemId();

        boolean hasC2SType();

        int getC2SType();
    }

    public static interface BuyEveryDayGiftResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface BuyEveryDayGiftRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2SVipLevel();

        int getC2SVipLevel();
    }

    public static interface GetEveryDayGiftResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface GetEveryDayGiftRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2SType();

        int getC2SType();
    }

    public static interface VipResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        List<VipHandler.VipGiftInfo> getDatasList();

        VipHandler.VipGiftInfo getDatas(int param1Int);

        int getDatasCount();

        List<? extends VipHandler.VipGiftInfoOrBuilder> getDatasOrBuilderList();

        VipHandler.VipGiftInfoOrBuilder getDatasOrBuilder(int param1Int);

        boolean hasS2CRemainTime();

        long getS2CRemainTime();
    }

    public static interface VipBuyGiftDataOrBuilder extends MessageOrBuilder {
        boolean hasVipLevel();

        int getVipLevel();

        boolean hasDailyBuyCount();

        int getDailyBuyCount();
    }

    public static interface VipGetGiftDataOrBuilder extends MessageOrBuilder {
        List<VipHandler.VipGiftInfo> getDatasList();

        VipHandler.VipGiftInfo getDatas(int param1Int);

        int getDatasCount();

        List<? extends VipHandler.VipGiftInfoOrBuilder> getDatasOrBuilderList();

        VipHandler.VipGiftInfoOrBuilder getDatasOrBuilder(int param1Int);
    }

    public static interface VipGiftInfoOrBuilder extends MessageOrBuilder {
        boolean hasType();

        int getType();

        boolean hasFlag();

        int getFlag();
    }

    public static interface VipRequestOrBuilder extends MessageOrBuilder {
    }
}


