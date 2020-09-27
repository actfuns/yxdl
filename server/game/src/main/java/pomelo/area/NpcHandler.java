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
import com.google.protobuf.UnknownFieldSet;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;


public final class NpcHandler {
    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static final class RecoverByNpcRequest
            extends GeneratedMessage
            implements RecoverByNpcRequestOrBuilder {
        private static final RecoverByNpcRequest defaultInstance = new RecoverByNpcRequest(true);
        private final UnknownFieldSet unknownFields;

        private RecoverByNpcRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private RecoverByNpcRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static RecoverByNpcRequest getDefaultInstance() {
            return defaultInstance;
        }

        public RecoverByNpcRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private RecoverByNpcRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.npcObjId_ = bs;
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
            return NpcHandler.internal_static_pomelo_area_RecoverByNpcRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return NpcHandler.internal_static_pomelo_area_RecoverByNpcRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(RecoverByNpcRequest.class, Builder.class);
        }

        public static Parser<RecoverByNpcRequest> PARSER = (Parser<RecoverByNpcRequest>) new AbstractParser<RecoverByNpcRequest>() {
            public NpcHandler.RecoverByNpcRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new NpcHandler.RecoverByNpcRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int NPCOBJID_FIELD_NUMBER = 1;
        private Object npcObjId_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<RecoverByNpcRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasNpcObjId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public String getNpcObjId() {
            Object ref = this.npcObjId_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.npcObjId_ = s;
            return s;
        }

        public ByteString getNpcObjIdBytes() {
            Object ref = this.npcObjId_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.npcObjId_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        static {
            defaultInstance.initFields();
        }


        private void initFields() {
            this.npcObjId_ = "";
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasNpcObjId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeBytes(1, getNpcObjIdBytes());
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
                size += CodedOutputStream.computeBytesSize(1, getNpcObjIdBytes());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static RecoverByNpcRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (RecoverByNpcRequest) PARSER.parseFrom(data);
        }


        public static RecoverByNpcRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (RecoverByNpcRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static RecoverByNpcRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (RecoverByNpcRequest) PARSER.parseFrom(data);
        }


        public static RecoverByNpcRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (RecoverByNpcRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static RecoverByNpcRequest parseFrom(InputStream input) throws IOException {
            return (RecoverByNpcRequest) PARSER.parseFrom(input);
        }


        public static RecoverByNpcRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RecoverByNpcRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static RecoverByNpcRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (RecoverByNpcRequest) PARSER.parseDelimitedFrom(input);
        }


        public static RecoverByNpcRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RecoverByNpcRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static RecoverByNpcRequest parseFrom(CodedInputStream input) throws IOException {
            return (RecoverByNpcRequest) PARSER.parseFrom(input);
        }


        public static RecoverByNpcRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RecoverByNpcRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(RecoverByNpcRequest prototype) {
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
                implements NpcHandler.RecoverByNpcRequestOrBuilder {
            private int bitField0_;


            private Object npcObjId_;


            public static final Descriptors.Descriptor getDescriptor() {
                return NpcHandler.internal_static_pomelo_area_RecoverByNpcRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return NpcHandler.internal_static_pomelo_area_RecoverByNpcRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(NpcHandler.RecoverByNpcRequest.class, Builder.class);
            }


            private Builder() {
                this.npcObjId_ = "";
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.npcObjId_ = "";
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (NpcHandler.RecoverByNpcRequest.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.npcObjId_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return NpcHandler.internal_static_pomelo_area_RecoverByNpcRequest_descriptor;
            }


            public NpcHandler.RecoverByNpcRequest getDefaultInstanceForType() {
                return NpcHandler.RecoverByNpcRequest.getDefaultInstance();
            }


            public NpcHandler.RecoverByNpcRequest build() {
                NpcHandler.RecoverByNpcRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public NpcHandler.RecoverByNpcRequest buildPartial() {
                NpcHandler.RecoverByNpcRequest result = new NpcHandler.RecoverByNpcRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.npcObjId_ = this.npcObjId_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof NpcHandler.RecoverByNpcRequest) {
                    return mergeFrom((NpcHandler.RecoverByNpcRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(NpcHandler.RecoverByNpcRequest other) {
                if (other == NpcHandler.RecoverByNpcRequest.getDefaultInstance()) {
                    return this;
                }
                if (other.hasNpcObjId()) {
                    this.bitField0_ |= 0x1;
                    this.npcObjId_ = other.npcObjId_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasNpcObjId()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                NpcHandler.RecoverByNpcRequest parsedMessage = null;
                try {
                    parsedMessage = (NpcHandler.RecoverByNpcRequest) NpcHandler.RecoverByNpcRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (NpcHandler.RecoverByNpcRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasNpcObjId() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public String getNpcObjId() {
                Object ref = this.npcObjId_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.npcObjId_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }


            public ByteString getNpcObjIdBytes() {
                Object ref = this.npcObjId_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.npcObjId_ = b;
                    return b;
                }
                return (ByteString) ref;
            }


            public Builder setNpcObjId(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x1;
                this.npcObjId_ = value;
                onChanged();
                return this;
            }


            public Builder clearNpcObjId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.npcObjId_ = NpcHandler.RecoverByNpcRequest.getDefaultInstance().getNpcObjId();
                onChanged();
                return this;
            }


            public Builder setNpcObjIdBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x1;
                this.npcObjId_ = value;
                onChanged();
                return this;
            }
        }
    }


    public static final class RecoverByNpcResponse
            extends GeneratedMessage
            implements RecoverByNpcResponseOrBuilder {
        private static final RecoverByNpcResponse defaultInstance = new RecoverByNpcResponse(true);
        private final UnknownFieldSet unknownFields;

        private RecoverByNpcResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private RecoverByNpcResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static RecoverByNpcResponse getDefaultInstance() {
            return defaultInstance;
        }

        public RecoverByNpcResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private RecoverByNpcResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return NpcHandler.internal_static_pomelo_area_RecoverByNpcResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return NpcHandler.internal_static_pomelo_area_RecoverByNpcResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(RecoverByNpcResponse.class, Builder.class);
        }

        public static Parser<RecoverByNpcResponse> PARSER = (Parser<RecoverByNpcResponse>) new AbstractParser<RecoverByNpcResponse>() {
            public NpcHandler.RecoverByNpcResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new NpcHandler.RecoverByNpcResponse(input, extensionRegistry);
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

        public Parser<RecoverByNpcResponse> getParserForType() {
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

        public static RecoverByNpcResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (RecoverByNpcResponse) PARSER.parseFrom(data);
        }

        public static RecoverByNpcResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (RecoverByNpcResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static RecoverByNpcResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (RecoverByNpcResponse) PARSER.parseFrom(data);
        }

        public static RecoverByNpcResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (RecoverByNpcResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static RecoverByNpcResponse parseFrom(InputStream input) throws IOException {
            return (RecoverByNpcResponse) PARSER.parseFrom(input);
        }

        public static RecoverByNpcResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RecoverByNpcResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static RecoverByNpcResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (RecoverByNpcResponse) PARSER.parseDelimitedFrom(input);
        }

        public static RecoverByNpcResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RecoverByNpcResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static RecoverByNpcResponse parseFrom(CodedInputStream input) throws IOException {
            return (RecoverByNpcResponse) PARSER.parseFrom(input);
        }

        public static RecoverByNpcResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RecoverByNpcResponse) PARSER.parseFrom(input, extensionRegistry);
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

        public static Builder newBuilder(RecoverByNpcResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements NpcHandler.RecoverByNpcResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;

            public static final Descriptors.Descriptor getDescriptor() {
                return NpcHandler.internal_static_pomelo_area_RecoverByNpcResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return NpcHandler.internal_static_pomelo_area_RecoverByNpcResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(NpcHandler.RecoverByNpcResponse.class, Builder.class);
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
                if (NpcHandler.RecoverByNpcResponse.alwaysUseFieldBuilders) ;
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
                return NpcHandler.internal_static_pomelo_area_RecoverByNpcResponse_descriptor;
            }

            public NpcHandler.RecoverByNpcResponse getDefaultInstanceForType() {
                return NpcHandler.RecoverByNpcResponse.getDefaultInstance();
            }

            public NpcHandler.RecoverByNpcResponse build() {
                NpcHandler.RecoverByNpcResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public NpcHandler.RecoverByNpcResponse buildPartial() {
                NpcHandler.RecoverByNpcResponse result = new NpcHandler.RecoverByNpcResponse(this);
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
                if (other instanceof NpcHandler.RecoverByNpcResponse)
                    return mergeFrom((NpcHandler.RecoverByNpcResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(NpcHandler.RecoverByNpcResponse other) {
                if (other == NpcHandler.RecoverByNpcResponse.getDefaultInstance()) return this;
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
                NpcHandler.RecoverByNpcResponse parsedMessage = null;
                try {
                    parsedMessage = (NpcHandler.RecoverByNpcResponse) NpcHandler.RecoverByNpcResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (NpcHandler.RecoverByNpcResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = NpcHandler.RecoverByNpcResponse.getDefaultInstance().getS2CMsg();
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
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }


    static {
        String[] descriptorData = {"\n\020npcHandler.proto\022\013pomelo.area\"'\n\023RecoverByNpcRequest\022\020\n\bnpcObjId\030\001 \002(\t\"9\n\024RecoverByNpcResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t2h\n\nnpcHandler\022Z\n\023recoverByNpcRequest\022 .pomelo.area.RecoverByNpcRequest\032!.pomelo.area.RecoverByNpcResponse"};


        Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root) {
                NpcHandler.descriptor = root;
                return null;
            }
        };

        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[0], assigner);
    }


    private static final Descriptors.Descriptor internal_static_pomelo_area_RecoverByNpcRequest_descriptor = getDescriptor().getMessageTypes().get(0);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_RecoverByNpcRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_RecoverByNpcRequest_descriptor, new String[]{"NpcObjId"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_RecoverByNpcResponse_descriptor = getDescriptor().getMessageTypes().get(1);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_RecoverByNpcResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_RecoverByNpcResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});
    private static Descriptors.FileDescriptor descriptor;

    public static interface RecoverByNpcResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface RecoverByNpcRequestOrBuilder extends MessageOrBuilder {
        boolean hasNpcObjId();

        String getNpcObjId();

        ByteString getNpcObjIdBytes();
    }
}


