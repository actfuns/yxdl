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


public final class InteractHandler {
    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static final class InteractRequest
            extends GeneratedMessage
            implements InteractRequestOrBuilder {
        private static final InteractRequest defaultInstance = new InteractRequest(true);
        private final UnknownFieldSet unknownFields;

        private InteractRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private InteractRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static InteractRequest getDefaultInstance() {
            return defaultInstance;
        }

        public InteractRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private InteractRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.c2SPlayerId_ = bs;
                            break;
                        case 26:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x4;
                            this.c2SPlayerName_ = bs;
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
            return InteractHandler.internal_static_pomelo_area_InteractRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return InteractHandler.internal_static_pomelo_area_InteractRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(InteractRequest.class, Builder.class);
        }

        public static Parser<InteractRequest> PARSER = (Parser<InteractRequest>) new AbstractParser<InteractRequest>() {
            public InteractHandler.InteractRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new InteractHandler.InteractRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_ID_FIELD_NUMBER = 1;
        private int c2SId_;
        public static final int C2S_PLAYERID_FIELD_NUMBER = 2;
        private Object c2SPlayerId_;
        public static final int C2S_PLAYERNAME_FIELD_NUMBER = 3;
        private Object c2SPlayerName_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<InteractRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasC2SId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getC2SId() {
            return this.c2SId_;
        }

        public boolean hasC2SPlayerId() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public String getC2SPlayerId() {
            Object ref = this.c2SPlayerId_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.c2SPlayerId_ = s;
            return s;
        }

        static {
            defaultInstance.initFields();
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


        public boolean hasC2SPlayerName() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public String getC2SPlayerName() {
            Object ref = this.c2SPlayerName_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.c2SPlayerName_ = s;
            }
            return s;
        }


        public ByteString getC2SPlayerNameBytes() {
            Object ref = this.c2SPlayerName_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.c2SPlayerName_ = b;
                return b;
            }
            return (ByteString) ref;
        }


        private void initFields() {
            this.c2SId_ = 0;
            this.c2SPlayerId_ = "";
            this.c2SPlayerName_ = "";
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
            if (!hasC2SPlayerId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasC2SPlayerName()) {
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
                output.writeBytes(2, getC2SPlayerIdBytes());
            }
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeBytes(3, getC2SPlayerNameBytes());
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
                size += CodedOutputStream.computeBytesSize(2, getC2SPlayerIdBytes());
            }
            if ((this.bitField0_ & 0x4) == 4) {
                size += CodedOutputStream.computeBytesSize(3, getC2SPlayerNameBytes());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static InteractRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (InteractRequest) PARSER.parseFrom(data);
        }


        public static InteractRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (InteractRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static InteractRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (InteractRequest) PARSER.parseFrom(data);
        }


        public static InteractRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (InteractRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static InteractRequest parseFrom(InputStream input) throws IOException {
            return (InteractRequest) PARSER.parseFrom(input);
        }


        public static InteractRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (InteractRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static InteractRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (InteractRequest) PARSER.parseDelimitedFrom(input);
        }


        public static InteractRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (InteractRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static InteractRequest parseFrom(CodedInputStream input) throws IOException {
            return (InteractRequest) PARSER.parseFrom(input);
        }


        public static InteractRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (InteractRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(InteractRequest prototype) {
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
                implements InteractHandler.InteractRequestOrBuilder {
            private int bitField0_;


            private int c2SId_;


            private Object c2SPlayerId_;


            private Object c2SPlayerName_;


            public static final Descriptors.Descriptor getDescriptor() {
                return InteractHandler.internal_static_pomelo_area_InteractRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return InteractHandler.internal_static_pomelo_area_InteractRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(InteractHandler.InteractRequest.class, Builder.class);
            }


            private Builder() {
                this.c2SPlayerId_ = "";
                this.c2SPlayerName_ = "";
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.c2SPlayerId_ = "";
                this.c2SPlayerName_ = "";
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (InteractHandler.InteractRequest.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.c2SId_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SPlayerId_ = "";
                this.bitField0_ &= 0xFFFFFFFD;
                this.c2SPlayerName_ = "";
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return InteractHandler.internal_static_pomelo_area_InteractRequest_descriptor;
            }


            public InteractHandler.InteractRequest getDefaultInstanceForType() {
                return InteractHandler.InteractRequest.getDefaultInstance();
            }


            public InteractHandler.InteractRequest build() {
                InteractHandler.InteractRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public InteractHandler.InteractRequest buildPartial() {
                InteractHandler.InteractRequest result = new InteractHandler.InteractRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.c2SId_ = this.c2SId_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.c2SPlayerId_ = this.c2SPlayerId_;
                if ((from_bitField0_ & 0x4) == 4) {
                    to_bitField0_ |= 0x4;
                }
                result.c2SPlayerName_ = this.c2SPlayerName_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof InteractHandler.InteractRequest) {
                    return mergeFrom((InteractHandler.InteractRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(InteractHandler.InteractRequest other) {
                if (other == InteractHandler.InteractRequest.getDefaultInstance()) {
                    return this;
                }
                if (other.hasC2SId()) {
                    setC2SId(other.getC2SId());
                }
                if (other.hasC2SPlayerId()) {
                    this.bitField0_ |= 0x2;
                    this.c2SPlayerId_ = other.c2SPlayerId_;
                    onChanged();
                }
                if (other.hasC2SPlayerName()) {
                    this.bitField0_ |= 0x4;
                    this.c2SPlayerName_ = other.c2SPlayerName_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasC2SId()) {
                    return false;
                }
                if (!hasC2SPlayerId()) {
                    return false;
                }
                if (!hasC2SPlayerName()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                InteractHandler.InteractRequest parsedMessage = null;
                try {
                    parsedMessage = (InteractHandler.InteractRequest) InteractHandler.InteractRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (InteractHandler.InteractRequest) e.getUnfinishedMessage();
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


            public boolean hasC2SPlayerId() {
                return ((this.bitField0_ & 0x2) == 2);
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
                this.bitField0_ |= 0x2;
                this.c2SPlayerId_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SPlayerId() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.c2SPlayerId_ = InteractHandler.InteractRequest.getDefaultInstance().getC2SPlayerId();
                onChanged();
                return this;
            }


            public Builder setC2SPlayerIdBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x2;
                this.c2SPlayerId_ = value;
                onChanged();
                return this;
            }


            public boolean hasC2SPlayerName() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public String getC2SPlayerName() {
                Object ref = this.c2SPlayerName_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.c2SPlayerName_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }


            public ByteString getC2SPlayerNameBytes() {
                Object ref = this.c2SPlayerName_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.c2SPlayerName_ = b;
                    return b;
                }
                return (ByteString) ref;
            }


            public Builder setC2SPlayerName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x4;
                this.c2SPlayerName_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SPlayerName() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.c2SPlayerName_ = InteractHandler.InteractRequest.getDefaultInstance().getC2SPlayerName();
                onChanged();
                return this;
            }


            public Builder setC2SPlayerNameBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x4;
                this.c2SPlayerName_ = value;
                onChanged();
                return this;
            }
        }
    }


    public static final class InteractResponse
            extends GeneratedMessage
            implements InteractResponseOrBuilder {
        private static final InteractResponse defaultInstance = new InteractResponse(true);
        private final UnknownFieldSet unknownFields;

        private InteractResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private InteractResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static InteractResponse getDefaultInstance() {
            return defaultInstance;
        }

        public InteractResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private InteractResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return InteractHandler.internal_static_pomelo_area_InteractResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return InteractHandler.internal_static_pomelo_area_InteractResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(InteractResponse.class, Builder.class);
        }

        public static Parser<InteractResponse> PARSER = (Parser<InteractResponse>) new AbstractParser<InteractResponse>() {
            public InteractHandler.InteractResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new InteractHandler.InteractResponse(input, extensionRegistry);
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

        public Parser<InteractResponse> getParserForType() {
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

        public static InteractResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (InteractResponse) PARSER.parseFrom(data);
        }

        public static InteractResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (InteractResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static InteractResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (InteractResponse) PARSER.parseFrom(data);
        }

        public static InteractResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (InteractResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static InteractResponse parseFrom(InputStream input) throws IOException {
            return (InteractResponse) PARSER.parseFrom(input);
        }

        public static InteractResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (InteractResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static InteractResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (InteractResponse) PARSER.parseDelimitedFrom(input);
        }

        public static InteractResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (InteractResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static InteractResponse parseFrom(CodedInputStream input) throws IOException {
            return (InteractResponse) PARSER.parseFrom(input);
        }

        public static InteractResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (InteractResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(InteractResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements InteractHandler.InteractResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;

            public static final Descriptors.Descriptor getDescriptor() {
                return InteractHandler.internal_static_pomelo_area_InteractResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return InteractHandler.internal_static_pomelo_area_InteractResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(InteractHandler.InteractResponse.class, Builder.class);
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
                if (InteractHandler.InteractResponse.alwaysUseFieldBuilders) ;
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
                return InteractHandler.internal_static_pomelo_area_InteractResponse_descriptor;
            }

            public InteractHandler.InteractResponse getDefaultInstanceForType() {
                return InteractHandler.InteractResponse.getDefaultInstance();
            }

            public InteractHandler.InteractResponse build() {
                InteractHandler.InteractResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public InteractHandler.InteractResponse buildPartial() {
                InteractHandler.InteractResponse result = new InteractHandler.InteractResponse(this);
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
                if (other instanceof InteractHandler.InteractResponse)
                    return mergeFrom((InteractHandler.InteractResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(InteractHandler.InteractResponse other) {
                if (other == InteractHandler.InteractResponse.getDefaultInstance())
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
                InteractHandler.InteractResponse parsedMessage = null;
                try {
                    parsedMessage = (InteractHandler.InteractResponse) InteractHandler.InteractResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (InteractHandler.InteractResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = InteractHandler.InteractResponse.getDefaultInstance().getS2CMsg();
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

    public static final class InteractConfigRequest extends GeneratedMessage implements InteractConfigRequestOrBuilder {
        private static final InteractConfigRequest defaultInstance = new InteractConfigRequest(true);
        private final UnknownFieldSet unknownFields;

        private InteractConfigRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private InteractConfigRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static InteractConfigRequest getDefaultInstance() {
            return defaultInstance;
        }

        public InteractConfigRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private InteractConfigRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return InteractHandler.internal_static_pomelo_area_InteractConfigRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return InteractHandler.internal_static_pomelo_area_InteractConfigRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(InteractConfigRequest.class, Builder.class);
        }

        public static Parser<InteractConfigRequest> PARSER = (Parser<InteractConfigRequest>) new AbstractParser<InteractConfigRequest>() {
            public InteractHandler.InteractConfigRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new InteractHandler.InteractConfigRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<InteractConfigRequest> getParserForType() {
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


        public static InteractConfigRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (InteractConfigRequest) PARSER.parseFrom(data);
        }


        public static InteractConfigRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (InteractConfigRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static InteractConfigRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (InteractConfigRequest) PARSER.parseFrom(data);
        }


        public static InteractConfigRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (InteractConfigRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static InteractConfigRequest parseFrom(InputStream input) throws IOException {
            return (InteractConfigRequest) PARSER.parseFrom(input);
        }


        public static InteractConfigRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (InteractConfigRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static InteractConfigRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (InteractConfigRequest) PARSER.parseDelimitedFrom(input);
        }


        public static InteractConfigRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (InteractConfigRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static InteractConfigRequest parseFrom(CodedInputStream input) throws IOException {
            return (InteractConfigRequest) PARSER.parseFrom(input);
        }


        public static InteractConfigRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (InteractConfigRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(InteractConfigRequest prototype) {
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
                implements InteractHandler.InteractConfigRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return InteractHandler.internal_static_pomelo_area_InteractConfigRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return InteractHandler.internal_static_pomelo_area_InteractConfigRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(InteractHandler.InteractConfigRequest.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (InteractHandler.InteractConfigRequest.alwaysUseFieldBuilders) ;
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
                return InteractHandler.internal_static_pomelo_area_InteractConfigRequest_descriptor;
            }


            public InteractHandler.InteractConfigRequest getDefaultInstanceForType() {
                return InteractHandler.InteractConfigRequest.getDefaultInstance();
            }


            public InteractHandler.InteractConfigRequest build() {
                InteractHandler.InteractConfigRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public InteractHandler.InteractConfigRequest buildPartial() {
                InteractHandler.InteractConfigRequest result = new InteractHandler.InteractConfigRequest(this);
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof InteractHandler.InteractConfigRequest) {
                    return mergeFrom((InteractHandler.InteractConfigRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(InteractHandler.InteractConfigRequest other) {
                if (other == InteractHandler.InteractConfigRequest.getDefaultInstance()) {
                    return this;
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                InteractHandler.InteractConfigRequest parsedMessage = null;
                try {
                    parsedMessage = (InteractHandler.InteractConfigRequest) InteractHandler.InteractConfigRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (InteractHandler.InteractConfigRequest) e.getUnfinishedMessage();
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


    public static final class InteractConfig
            extends GeneratedMessage
            implements InteractConfigOrBuilder {
        private static final InteractConfig defaultInstance = new InteractConfig(true);
        private final UnknownFieldSet unknownFields;

        private InteractConfig(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private InteractConfig(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static InteractConfig getDefaultInstance() {
            return defaultInstance;
        }

        public InteractConfig getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private InteractConfig(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            bs = input.readBytes();
                            this.bitField0_ |= 0x2;
                            this.name_ = bs;
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.type_ = input.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.charm_ = input.readInt32();
                            break;
                        case 40:
                            this.bitField0_ |= 0x10;
                            this.gold_ = input.readInt32();
                            break;
                        case 48:
                            this.bitField0_ |= 0x20;
                            this.diamond_ = input.readInt32();
                            break;
                        case 58:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x40;
                            this.show_ = bs;
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
            return InteractHandler.internal_static_pomelo_area_InteractConfig_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return InteractHandler.internal_static_pomelo_area_InteractConfig_fieldAccessorTable.ensureFieldAccessorsInitialized(InteractConfig.class, Builder.class);
        }

        public static Parser<InteractConfig> PARSER = (Parser<InteractConfig>) new AbstractParser<InteractConfig>() {
            public InteractHandler.InteractConfig parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new InteractHandler.InteractConfig(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int ID_FIELD_NUMBER = 1;
        private int id_;
        public static final int NAME_FIELD_NUMBER = 2;
        private Object name_;
        public static final int TYPE_FIELD_NUMBER = 3;
        private int type_;
        public static final int CHARM_FIELD_NUMBER = 4;
        private int charm_;
        public static final int GOLD_FIELD_NUMBER = 5;
        private int gold_;
        public static final int DIAMOND_FIELD_NUMBER = 6;
        private int diamond_;
        public static final int SHOW_FIELD_NUMBER = 7;
        private Object show_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<InteractConfig> getParserForType() {
            return PARSER;
        }

        public boolean hasId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getId() {
            return this.id_;
        }

        public boolean hasName() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public String getName() {
            Object ref = this.name_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.name_ = s;
            return s;
        }

        static {
            defaultInstance.initFields();
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


        public boolean hasType() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public int getType() {
            return this.type_;
        }


        public boolean hasCharm() {
            return ((this.bitField0_ & 0x8) == 8);
        }


        public int getCharm() {
            return this.charm_;
        }


        public boolean hasGold() {
            return ((this.bitField0_ & 0x10) == 16);
        }


        public int getGold() {
            return this.gold_;
        }


        public boolean hasDiamond() {
            return ((this.bitField0_ & 0x20) == 32);
        }


        public int getDiamond() {
            return this.diamond_;
        }


        public boolean hasShow() {
            return ((this.bitField0_ & 0x40) == 64);
        }


        public String getShow() {
            Object ref = this.show_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.show_ = s;
            }
            return s;
        }


        public ByteString getShowBytes() {
            Object ref = this.show_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.show_ = b;
                return b;
            }
            return (ByteString) ref;
        }


        private void initFields() {
            this.id_ = 0;
            this.name_ = "";
            this.type_ = 0;
            this.charm_ = 0;
            this.gold_ = 0;
            this.diamond_ = 0;
            this.show_ = "";
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
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeBytes(2, getNameBytes());
            }
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeInt32(3, this.type_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                output.writeInt32(4, this.charm_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                output.writeInt32(5, this.gold_);
            }
            if ((this.bitField0_ & 0x20) == 32) {
                output.writeInt32(6, this.diamond_);
            }
            if ((this.bitField0_ & 0x40) == 64) {
                output.writeBytes(7, getShowBytes());
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
                size += CodedOutputStream.computeBytesSize(2, getNameBytes());
            }
            if ((this.bitField0_ & 0x4) == 4) {
                size += CodedOutputStream.computeInt32Size(3, this.type_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                size += CodedOutputStream.computeInt32Size(4, this.charm_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                size += CodedOutputStream.computeInt32Size(5, this.gold_);
            }
            if ((this.bitField0_ & 0x20) == 32) {
                size += CodedOutputStream.computeInt32Size(6, this.diamond_);
            }
            if ((this.bitField0_ & 0x40) == 64) {
                size += CodedOutputStream.computeBytesSize(7, getShowBytes());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static InteractConfig parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (InteractConfig) PARSER.parseFrom(data);
        }


        public static InteractConfig parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (InteractConfig) PARSER.parseFrom(data, extensionRegistry);
        }


        public static InteractConfig parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (InteractConfig) PARSER.parseFrom(data);
        }


        public static InteractConfig parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (InteractConfig) PARSER.parseFrom(data, extensionRegistry);
        }


        public static InteractConfig parseFrom(InputStream input) throws IOException {
            return (InteractConfig) PARSER.parseFrom(input);
        }


        public static InteractConfig parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (InteractConfig) PARSER.parseFrom(input, extensionRegistry);
        }


        public static InteractConfig parseDelimitedFrom(InputStream input) throws IOException {
            return (InteractConfig) PARSER.parseDelimitedFrom(input);
        }


        public static InteractConfig parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (InteractConfig) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static InteractConfig parseFrom(CodedInputStream input) throws IOException {
            return (InteractConfig) PARSER.parseFrom(input);
        }


        public static InteractConfig parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (InteractConfig) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(InteractConfig prototype) {
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
                implements InteractHandler.InteractConfigOrBuilder {
            private int bitField0_;


            private int id_;


            private Object name_;


            private int type_;


            private int charm_;


            private int gold_;


            private int diamond_;


            private Object show_;


            public static final Descriptors.Descriptor getDescriptor() {
                return InteractHandler.internal_static_pomelo_area_InteractConfig_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return InteractHandler.internal_static_pomelo_area_InteractConfig_fieldAccessorTable.ensureFieldAccessorsInitialized(InteractHandler.InteractConfig.class, Builder.class);
            }


            private Builder() {
                this.name_ = "";
                this.show_ = "";
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.name_ = "";
                this.show_ = "";
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (InteractHandler.InteractConfig.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.id_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.name_ = "";
                this.bitField0_ &= 0xFFFFFFFD;
                this.type_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.charm_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                this.gold_ = 0;
                this.bitField0_ &= 0xFFFFFFEF;
                this.diamond_ = 0;
                this.bitField0_ &= 0xFFFFFFDF;
                this.show_ = "";
                this.bitField0_ &= 0xFFFFFFBF;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return InteractHandler.internal_static_pomelo_area_InteractConfig_descriptor;
            }


            public InteractHandler.InteractConfig getDefaultInstanceForType() {
                return InteractHandler.InteractConfig.getDefaultInstance();
            }


            public InteractHandler.InteractConfig build() {
                InteractHandler.InteractConfig result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public InteractHandler.InteractConfig buildPartial() {
                InteractHandler.InteractConfig result = new InteractHandler.InteractConfig(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.id_ = this.id_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.name_ = this.name_;
                if ((from_bitField0_ & 0x4) == 4) {
                    to_bitField0_ |= 0x4;
                }
                result.type_ = this.type_;
                if ((from_bitField0_ & 0x8) == 8) {
                    to_bitField0_ |= 0x8;
                }
                result.charm_ = this.charm_;
                if ((from_bitField0_ & 0x10) == 16) {
                    to_bitField0_ |= 0x10;
                }
                result.gold_ = this.gold_;
                if ((from_bitField0_ & 0x20) == 32) {
                    to_bitField0_ |= 0x20;
                }
                result.diamond_ = this.diamond_;
                if ((from_bitField0_ & 0x40) == 64) {
                    to_bitField0_ |= 0x40;
                }
                result.show_ = this.show_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof InteractHandler.InteractConfig) {
                    return mergeFrom((InteractHandler.InteractConfig) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(InteractHandler.InteractConfig other) {
                if (other == InteractHandler.InteractConfig.getDefaultInstance()) {
                    return this;
                }
                if (other.hasId()) {
                    setId(other.getId());
                }
                if (other.hasName()) {
                    this.bitField0_ |= 0x2;
                    this.name_ = other.name_;
                    onChanged();
                }
                if (other.hasType()) {
                    setType(other.getType());
                }
                if (other.hasCharm()) {
                    setCharm(other.getCharm());
                }
                if (other.hasGold()) {
                    setGold(other.getGold());
                }
                if (other.hasDiamond()) {
                    setDiamond(other.getDiamond());
                }
                if (other.hasShow()) {
                    this.bitField0_ |= 0x40;
                    this.show_ = other.show_;
                    onChanged();
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
                InteractHandler.InteractConfig parsedMessage = null;
                try {
                    parsedMessage = (InteractHandler.InteractConfig) InteractHandler.InteractConfig.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (InteractHandler.InteractConfig) e.getUnfinishedMessage();
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


            public boolean hasName() {
                return ((this.bitField0_ & 0x2) == 2);
            }


            public String getName() {
                Object ref = this.name_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.name_ = s;
                    }
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
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x2;
                this.name_ = value;
                onChanged();
                return this;
            }


            public Builder clearName() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.name_ = InteractHandler.InteractConfig.getDefaultInstance().getName();
                onChanged();
                return this;
            }


            public Builder setNameBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x2;
                this.name_ = value;
                onChanged();
                return this;
            }


            public boolean hasType() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public int getType() {
                return this.type_;
            }


            public Builder setType(int value) {
                this.bitField0_ |= 0x4;
                this.type_ = value;
                onChanged();
                return this;
            }


            public Builder clearType() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.type_ = 0;
                onChanged();
                return this;
            }


            public boolean hasCharm() {
                return ((this.bitField0_ & 0x8) == 8);
            }


            public int getCharm() {
                return this.charm_;
            }


            public Builder setCharm(int value) {
                this.bitField0_ |= 0x8;
                this.charm_ = value;
                onChanged();
                return this;
            }


            public Builder clearCharm() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.charm_ = 0;
                onChanged();
                return this;
            }


            public boolean hasGold() {
                return ((this.bitField0_ & 0x10) == 16);
            }


            public int getGold() {
                return this.gold_;
            }


            public Builder setGold(int value) {
                this.bitField0_ |= 0x10;
                this.gold_ = value;
                onChanged();
                return this;
            }


            public Builder clearGold() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.gold_ = 0;
                onChanged();
                return this;
            }


            public boolean hasDiamond() {
                return ((this.bitField0_ & 0x20) == 32);
            }


            public int getDiamond() {
                return this.diamond_;
            }


            public Builder setDiamond(int value) {
                this.bitField0_ |= 0x20;
                this.diamond_ = value;
                onChanged();
                return this;
            }


            public Builder clearDiamond() {
                this.bitField0_ &= 0xFFFFFFDF;
                this.diamond_ = 0;
                onChanged();
                return this;
            }


            public boolean hasShow() {
                return ((this.bitField0_ & 0x40) == 64);
            }


            public String getShow() {
                Object ref = this.show_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.show_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }


            public ByteString getShowBytes() {
                Object ref = this.show_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.show_ = b;
                    return b;
                }
                return (ByteString) ref;
            }


            public Builder setShow(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x40;
                this.show_ = value;
                onChanged();
                return this;
            }


            public Builder clearShow() {
                this.bitField0_ &= 0xFFFFFFBF;
                this.show_ = InteractHandler.InteractConfig.getDefaultInstance().getShow();
                onChanged();
                return this;
            }


            public Builder setShowBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x40;
                this.show_ = value;
                onChanged();
                return this;
            }
        }
    }


    public static final class InteractConfigResponse
            extends GeneratedMessage
            implements InteractConfigResponseOrBuilder {
        private static final InteractConfigResponse defaultInstance = new InteractConfigResponse(true);
        private final UnknownFieldSet unknownFields;

        private InteractConfigResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private InteractConfigResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static InteractConfigResponse getDefaultInstance() {
            return defaultInstance;
        }

        public InteractConfigResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private InteractConfigResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.s2CData_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x4;
                            }
                            this.s2CData_.add(input.readMessage(InteractHandler.InteractConfig.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x4) == 4) this.s2CData_ = Collections.unmodifiableList(this.s2CData_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return InteractHandler.internal_static_pomelo_area_InteractConfigResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return InteractHandler.internal_static_pomelo_area_InteractConfigResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(InteractConfigResponse.class, Builder.class);
        }

        public static Parser<InteractConfigResponse> PARSER = (Parser<InteractConfigResponse>) new AbstractParser<InteractConfigResponse>() {
            public InteractHandler.InteractConfigResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new InteractHandler.InteractConfigResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_DATA_FIELD_NUMBER = 3;
        private List<InteractHandler.InteractConfig> s2CData_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<InteractConfigResponse> getParserForType() {
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

        public List<InteractHandler.InteractConfig> getS2CDataList() {
            return this.s2CData_;
        }

        public List<? extends InteractHandler.InteractConfigOrBuilder> getS2CDataOrBuilderList() {
            return (List) this.s2CData_;
        }

        public int getS2CDataCount() {
            return this.s2CData_.size();
        }

        public InteractHandler.InteractConfig getS2CData(int index) {
            return this.s2CData_.get(index);
        }

        public InteractHandler.InteractConfigOrBuilder getS2CDataOrBuilder(int index) {
            return this.s2CData_.get(index);
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CData_ = Collections.emptyList();
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
            if ((this.bitField0_ & 0x1) == 1)
                output.writeInt32(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2)
                output.writeBytes(2, getS2CMsgBytes());
            for (int i = 0; i < this.s2CData_.size(); i++)
                output.writeMessage(3, (MessageLite) this.s2CData_.get(i));
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
            for (int i = 0; i < this.s2CData_.size(); i++)
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.s2CData_.get(i));
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static InteractConfigResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (InteractConfigResponse) PARSER.parseFrom(data);
        }

        public static InteractConfigResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (InteractConfigResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static InteractConfigResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (InteractConfigResponse) PARSER.parseFrom(data);
        }

        public static InteractConfigResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (InteractConfigResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static InteractConfigResponse parseFrom(InputStream input) throws IOException {
            return (InteractConfigResponse) PARSER.parseFrom(input);
        }

        public static InteractConfigResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (InteractConfigResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static InteractConfigResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (InteractConfigResponse) PARSER.parseDelimitedFrom(input);
        }

        public static InteractConfigResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (InteractConfigResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static InteractConfigResponse parseFrom(CodedInputStream input) throws IOException {
            return (InteractConfigResponse) PARSER.parseFrom(input);
        }

        public static InteractConfigResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (InteractConfigResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(InteractConfigResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements InteractHandler.InteractConfigResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private List<InteractHandler.InteractConfig> s2CData_;
            private RepeatedFieldBuilder<InteractHandler.InteractConfig, InteractHandler.InteractConfig.Builder, InteractHandler.InteractConfigOrBuilder> s2CDataBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return InteractHandler.internal_static_pomelo_area_InteractConfigResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return InteractHandler.internal_static_pomelo_area_InteractConfigResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(InteractHandler.InteractConfigResponse.class, Builder.class);
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
                if (InteractHandler.InteractConfigResponse.alwaysUseFieldBuilders)
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
                    this.s2CData_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                } else {
                    this.s2CDataBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return InteractHandler.internal_static_pomelo_area_InteractConfigResponse_descriptor;
            }

            public InteractHandler.InteractConfigResponse getDefaultInstanceForType() {
                return InteractHandler.InteractConfigResponse.getDefaultInstance();
            }

            public InteractHandler.InteractConfigResponse build() {
                InteractHandler.InteractConfigResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public InteractHandler.InteractConfigResponse buildPartial() {
                InteractHandler.InteractConfigResponse result = new InteractHandler.InteractConfigResponse(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.s2CMsg_ = this.s2CMsg_;
                if (this.s2CDataBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4) {
                        this.s2CData_ = Collections.unmodifiableList(this.s2CData_);
                        this.bitField0_ &= 0xFFFFFFFB;
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
                if (other instanceof InteractHandler.InteractConfigResponse)
                    return mergeFrom((InteractHandler.InteractConfigResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(InteractHandler.InteractConfigResponse other) {
                if (other == InteractHandler.InteractConfigResponse.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (this.s2CDataBuilder_ == null) {
                    if (!other.s2CData_.isEmpty()) {
                        if (this.s2CData_.isEmpty()) {
                            this.s2CData_ = other.s2CData_;
                            this.bitField0_ &= 0xFFFFFFFB;
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
                        this.bitField0_ &= 0xFFFFFFFB;
                        this.s2CDataBuilder_ = InteractHandler.InteractConfigResponse.alwaysUseFieldBuilders ? getS2CDataFieldBuilder() : null;
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
                InteractHandler.InteractConfigResponse parsedMessage = null;
                try {
                    parsedMessage = (InteractHandler.InteractConfigResponse) InteractHandler.InteractConfigResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (InteractHandler.InteractConfigResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = InteractHandler.InteractConfigResponse.getDefaultInstance().getS2CMsg();
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

            private void ensureS2CDataIsMutable() {
                if ((this.bitField0_ & 0x4) != 4) {
                    this.s2CData_ = new ArrayList<>(this.s2CData_);
                    this.bitField0_ |= 0x4;
                }
            }

            public List<InteractHandler.InteractConfig> getS2CDataList() {
                if (this.s2CDataBuilder_ == null)
                    return Collections.unmodifiableList(this.s2CData_);
                return this.s2CDataBuilder_.getMessageList();
            }

            public int getS2CDataCount() {
                if (this.s2CDataBuilder_ == null)
                    return this.s2CData_.size();
                return this.s2CDataBuilder_.getCount();
            }

            public InteractHandler.InteractConfig getS2CData(int index) {
                if (this.s2CDataBuilder_ == null)
                    return this.s2CData_.get(index);
                return (InteractHandler.InteractConfig) this.s2CDataBuilder_.getMessage(index);
            }

            public Builder setS2CData(int index, InteractHandler.InteractConfig value) {
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

            public Builder setS2CData(int index, InteractHandler.InteractConfig.Builder builderForValue) {
                if (this.s2CDataBuilder_ == null) {
                    ensureS2CDataIsMutable();
                    this.s2CData_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CDataBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addS2CData(InteractHandler.InteractConfig value) {
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

            public Builder addS2CData(int index, InteractHandler.InteractConfig value) {
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

            public Builder addS2CData(InteractHandler.InteractConfig.Builder builderForValue) {
                if (this.s2CDataBuilder_ == null) {
                    ensureS2CDataIsMutable();
                    this.s2CData_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.s2CDataBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addS2CData(int index, InteractHandler.InteractConfig.Builder builderForValue) {
                if (this.s2CDataBuilder_ == null) {
                    ensureS2CDataIsMutable();
                    this.s2CData_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CDataBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllS2CData(Iterable<? extends InteractHandler.InteractConfig> values) {
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
                    this.bitField0_ &= 0xFFFFFFFB;
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

            public InteractHandler.InteractConfig.Builder getS2CDataBuilder(int index) {
                return (InteractHandler.InteractConfig.Builder) getS2CDataFieldBuilder().getBuilder(index);
            }

            public InteractHandler.InteractConfigOrBuilder getS2CDataOrBuilder(int index) {
                if (this.s2CDataBuilder_ == null)
                    return this.s2CData_.get(index);
                return (InteractHandler.InteractConfigOrBuilder) this.s2CDataBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends InteractHandler.InteractConfigOrBuilder> getS2CDataOrBuilderList() {
                if (this.s2CDataBuilder_ != null)
                    return this.s2CDataBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.s2CData_);
            }

            public InteractHandler.InteractConfig.Builder addS2CDataBuilder() {
                return (InteractHandler.InteractConfig.Builder) getS2CDataFieldBuilder().addBuilder(InteractHandler.InteractConfig.getDefaultInstance());
            }

            public InteractHandler.InteractConfig.Builder addS2CDataBuilder(int index) {
                return (InteractHandler.InteractConfig.Builder) getS2CDataFieldBuilder().addBuilder(index, InteractHandler.InteractConfig.getDefaultInstance());
            }

            public List<InteractHandler.InteractConfig.Builder> getS2CDataBuilderList() {
                return getS2CDataFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<InteractHandler.InteractConfig, InteractHandler.InteractConfig.Builder, InteractHandler.InteractConfigOrBuilder> getS2CDataFieldBuilder() {
                if (this.s2CDataBuilder_ == null) {
                    this.s2CDataBuilder_ = new RepeatedFieldBuilder(this.s2CData_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
                    this.s2CData_ = null;
                }
                return this.s2CDataBuilder_;
            }
        }
    }

    public static final class InteractTimesRequest extends GeneratedMessage implements InteractTimesRequestOrBuilder {
        private static final InteractTimesRequest defaultInstance = new InteractTimesRequest(true);
        private final UnknownFieldSet unknownFields;

        private InteractTimesRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private InteractTimesRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static InteractTimesRequest getDefaultInstance() {
            return defaultInstance;
        }

        public InteractTimesRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private InteractTimesRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return InteractHandler.internal_static_pomelo_area_InteractTimesRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return InteractHandler.internal_static_pomelo_area_InteractTimesRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(InteractTimesRequest.class, Builder.class);
        }

        public static Parser<InteractTimesRequest> PARSER = (Parser<InteractTimesRequest>) new AbstractParser<InteractTimesRequest>() {
            public InteractHandler.InteractTimesRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new InteractHandler.InteractTimesRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<InteractTimesRequest> getParserForType() {
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


        public static InteractTimesRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (InteractTimesRequest) PARSER.parseFrom(data);
        }


        public static InteractTimesRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (InteractTimesRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static InteractTimesRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (InteractTimesRequest) PARSER.parseFrom(data);
        }


        public static InteractTimesRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (InteractTimesRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static InteractTimesRequest parseFrom(InputStream input) throws IOException {
            return (InteractTimesRequest) PARSER.parseFrom(input);
        }


        public static InteractTimesRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (InteractTimesRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static InteractTimesRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (InteractTimesRequest) PARSER.parseDelimitedFrom(input);
        }


        public static InteractTimesRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (InteractTimesRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static InteractTimesRequest parseFrom(CodedInputStream input) throws IOException {
            return (InteractTimesRequest) PARSER.parseFrom(input);
        }


        public static InteractTimesRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (InteractTimesRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(InteractTimesRequest prototype) {
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
                implements InteractHandler.InteractTimesRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return InteractHandler.internal_static_pomelo_area_InteractTimesRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return InteractHandler.internal_static_pomelo_area_InteractTimesRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(InteractHandler.InteractTimesRequest.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (InteractHandler.InteractTimesRequest.alwaysUseFieldBuilders) ;
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
                return InteractHandler.internal_static_pomelo_area_InteractTimesRequest_descriptor;
            }


            public InteractHandler.InteractTimesRequest getDefaultInstanceForType() {
                return InteractHandler.InteractTimesRequest.getDefaultInstance();
            }


            public InteractHandler.InteractTimesRequest build() {
                InteractHandler.InteractTimesRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public InteractHandler.InteractTimesRequest buildPartial() {
                InteractHandler.InteractTimesRequest result = new InteractHandler.InteractTimesRequest(this);
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof InteractHandler.InteractTimesRequest) {
                    return mergeFrom((InteractHandler.InteractTimesRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(InteractHandler.InteractTimesRequest other) {
                if (other == InteractHandler.InteractTimesRequest.getDefaultInstance()) {
                    return this;
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                InteractHandler.InteractTimesRequest parsedMessage = null;
                try {
                    parsedMessage = (InteractHandler.InteractTimesRequest) InteractHandler.InteractTimesRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (InteractHandler.InteractTimesRequest) e.getUnfinishedMessage();
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


    public static final class InteractTimes
            extends GeneratedMessage
            implements InteractTimesOrBuilder {
        private static final InteractTimes defaultInstance = new InteractTimes(true);
        private final UnknownFieldSet unknownFields;

        private InteractTimes(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private InteractTimes(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static InteractTimes getDefaultInstance() {
            return defaultInstance;
        }

        public InteractTimes getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private InteractTimes(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.times_ = input.readInt32();
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
            return InteractHandler.internal_static_pomelo_area_InteractTimes_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return InteractHandler.internal_static_pomelo_area_InteractTimes_fieldAccessorTable.ensureFieldAccessorsInitialized(InteractTimes.class, Builder.class);
        }

        public static Parser<InteractTimes> PARSER = (Parser<InteractTimes>) new AbstractParser<InteractTimes>() {
            public InteractHandler.InteractTimes parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new InteractHandler.InteractTimes(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int TYPE_FIELD_NUMBER = 1;
        private int type_;
        public static final int TIMES_FIELD_NUMBER = 2;
        private int times_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<InteractTimes> getParserForType() {
            return PARSER;
        }

        public boolean hasType() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getType() {
            return this.type_;
        }

        public boolean hasTimes() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        static {
            defaultInstance.initFields();
        }


        public int getTimes() {
            return this.times_;
        }


        private void initFields() {
            this.type_ = 0;
            this.times_ = 0;
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasType()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeInt32(1, this.type_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeInt32(2, this.times_);
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
                size += CodedOutputStream.computeInt32Size(1, this.type_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeInt32Size(2, this.times_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static InteractTimes parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (InteractTimes) PARSER.parseFrom(data);
        }


        public static InteractTimes parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (InteractTimes) PARSER.parseFrom(data, extensionRegistry);
        }


        public static InteractTimes parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (InteractTimes) PARSER.parseFrom(data);
        }


        public static InteractTimes parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (InteractTimes) PARSER.parseFrom(data, extensionRegistry);
        }


        public static InteractTimes parseFrom(InputStream input) throws IOException {
            return (InteractTimes) PARSER.parseFrom(input);
        }


        public static InteractTimes parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (InteractTimes) PARSER.parseFrom(input, extensionRegistry);
        }


        public static InteractTimes parseDelimitedFrom(InputStream input) throws IOException {
            return (InteractTimes) PARSER.parseDelimitedFrom(input);
        }


        public static InteractTimes parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (InteractTimes) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static InteractTimes parseFrom(CodedInputStream input) throws IOException {
            return (InteractTimes) PARSER.parseFrom(input);
        }


        public static InteractTimes parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (InteractTimes) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(InteractTimes prototype) {
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
                implements InteractHandler.InteractTimesOrBuilder {
            private int bitField0_;


            private int type_;


            private int times_;


            public static final Descriptors.Descriptor getDescriptor() {
                return InteractHandler.internal_static_pomelo_area_InteractTimes_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return InteractHandler.internal_static_pomelo_area_InteractTimes_fieldAccessorTable.ensureFieldAccessorsInitialized(InteractHandler.InteractTimes.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (InteractHandler.InteractTimes.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.type_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.times_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return InteractHandler.internal_static_pomelo_area_InteractTimes_descriptor;
            }


            public InteractHandler.InteractTimes getDefaultInstanceForType() {
                return InteractHandler.InteractTimes.getDefaultInstance();
            }


            public InteractHandler.InteractTimes build() {
                InteractHandler.InteractTimes result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public InteractHandler.InteractTimes buildPartial() {
                InteractHandler.InteractTimes result = new InteractHandler.InteractTimes(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.type_ = this.type_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.times_ = this.times_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof InteractHandler.InteractTimes) {
                    return mergeFrom((InteractHandler.InteractTimes) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(InteractHandler.InteractTimes other) {
                if (other == InteractHandler.InteractTimes.getDefaultInstance()) {
                    return this;
                }
                if (other.hasType()) {
                    setType(other.getType());
                }
                if (other.hasTimes()) {
                    setTimes(other.getTimes());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasType()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                InteractHandler.InteractTimes parsedMessage = null;
                try {
                    parsedMessage = (InteractHandler.InteractTimes) InteractHandler.InteractTimes.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (InteractHandler.InteractTimes) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
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


            public boolean hasTimes() {
                return ((this.bitField0_ & 0x2) == 2);
            }


            public int getTimes() {
                return this.times_;
            }


            public Builder setTimes(int value) {
                this.bitField0_ |= 0x2;
                this.times_ = value;
                onChanged();
                return this;
            }


            public Builder clearTimes() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.times_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class InteractTimesResponse
            extends GeneratedMessage
            implements InteractTimesResponseOrBuilder {
        private static final InteractTimesResponse defaultInstance = new InteractTimesResponse(true);
        private final UnknownFieldSet unknownFields;

        private InteractTimesResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private InteractTimesResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static InteractTimesResponse getDefaultInstance() {
            return defaultInstance;
        }

        public InteractTimesResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private InteractTimesResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.s2CData_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x4;
                            }
                            this.s2CData_.add(input.readMessage(InteractHandler.InteractTimes.PARSER, extensionRegistry));
                            break;
                        case 32:
                            this.bitField0_ |= 0x4;
                            this.s2CCharm_ = input.readInt32();
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x4) == 4) this.s2CData_ = Collections.unmodifiableList(this.s2CData_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return InteractHandler.internal_static_pomelo_area_InteractTimesResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return InteractHandler.internal_static_pomelo_area_InteractTimesResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(InteractTimesResponse.class, Builder.class);
        }

        public static Parser<InteractTimesResponse> PARSER = (Parser<InteractTimesResponse>) new AbstractParser<InteractTimesResponse>() {
            public InteractHandler.InteractTimesResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new InteractHandler.InteractTimesResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_DATA_FIELD_NUMBER = 3;
        private List<InteractHandler.InteractTimes> s2CData_;
        public static final int S2C_CHARM_FIELD_NUMBER = 4;
        private int s2CCharm_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<InteractTimesResponse> getParserForType() {
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


        public List<InteractHandler.InteractTimes> getS2CDataList() {
            return this.s2CData_;
        }


        public List<? extends InteractHandler.InteractTimesOrBuilder> getS2CDataOrBuilderList() {
            return (List) this.s2CData_;
        }


        public int getS2CDataCount() {
            return this.s2CData_.size();
        }


        public InteractHandler.InteractTimes getS2CData(int index) {
            return this.s2CData_.get(index);
        }


        public InteractHandler.InteractTimesOrBuilder getS2CDataOrBuilder(int index) {
            return this.s2CData_.get(index);
        }


        public boolean hasS2CCharm() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public int getS2CCharm() {
            return this.s2CCharm_;
        }


        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CData_ = Collections.emptyList();
            this.s2CCharm_ = 0;
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
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeInt32(1, this.s2CCode_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeBytes(2, getS2CMsgBytes());
            }
            for (int i = 0; i < this.s2CData_.size(); i++) {
                output.writeMessage(3, (MessageLite) this.s2CData_.get(i));
            }
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeInt32(4, this.s2CCharm_);
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
            for (int i = 0; i < this.s2CData_.size(); i++) {
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.s2CData_.get(i));
            }
            if ((this.bitField0_ & 0x4) == 4) {
                size += CodedOutputStream.computeInt32Size(4, this.s2CCharm_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static InteractTimesResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (InteractTimesResponse) PARSER.parseFrom(data);
        }


        public static InteractTimesResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (InteractTimesResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static InteractTimesResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (InteractTimesResponse) PARSER.parseFrom(data);
        }


        public static InteractTimesResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (InteractTimesResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static InteractTimesResponse parseFrom(InputStream input) throws IOException {
            return (InteractTimesResponse) PARSER.parseFrom(input);
        }


        public static InteractTimesResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (InteractTimesResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static InteractTimesResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (InteractTimesResponse) PARSER.parseDelimitedFrom(input);
        }


        public static InteractTimesResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (InteractTimesResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static InteractTimesResponse parseFrom(CodedInputStream input) throws IOException {
            return (InteractTimesResponse) PARSER.parseFrom(input);
        }


        public static InteractTimesResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (InteractTimesResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(InteractTimesResponse prototype) {
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
                implements InteractHandler.InteractTimesResponseOrBuilder {
            private int bitField0_;


            private int s2CCode_;


            private Object s2CMsg_;


            private List<InteractHandler.InteractTimes> s2CData_;


            private RepeatedFieldBuilder<InteractHandler.InteractTimes, InteractHandler.InteractTimes.Builder, InteractHandler.InteractTimesOrBuilder> s2CDataBuilder_;


            private int s2CCharm_;


            public static final Descriptors.Descriptor getDescriptor() {
                return InteractHandler.internal_static_pomelo_area_InteractTimesResponse_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return InteractHandler.internal_static_pomelo_area_InteractTimesResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(InteractHandler.InteractTimesResponse.class, Builder.class);
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
                if (InteractHandler.InteractTimesResponse.alwaysUseFieldBuilders) {
                    getS2CDataFieldBuilder();
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
                if (this.s2CDataBuilder_ == null) {
                    this.s2CData_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                } else {
                    this.s2CDataBuilder_.clear();
                }
                this.s2CCharm_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return InteractHandler.internal_static_pomelo_area_InteractTimesResponse_descriptor;
            }


            public InteractHandler.InteractTimesResponse getDefaultInstanceForType() {
                return InteractHandler.InteractTimesResponse.getDefaultInstance();
            }


            public InteractHandler.InteractTimesResponse build() {
                InteractHandler.InteractTimesResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public InteractHandler.InteractTimesResponse buildPartial() {
                InteractHandler.InteractTimesResponse result = new InteractHandler.InteractTimesResponse(this);
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
                if (this.s2CDataBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4) {
                        this.s2CData_ = Collections.unmodifiableList(this.s2CData_);
                        this.bitField0_ &= 0xFFFFFFFB;
                    }
                    result.s2CData_ = this.s2CData_;
                } else {
                    result.s2CData_ = this.s2CDataBuilder_.build();
                }
                if ((from_bitField0_ & 0x8) == 8) {
                    to_bitField0_ |= 0x4;
                }
                result.s2CCharm_ = this.s2CCharm_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof InteractHandler.InteractTimesResponse) {
                    return mergeFrom((InteractHandler.InteractTimesResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(InteractHandler.InteractTimesResponse other) {
                if (other == InteractHandler.InteractTimesResponse.getDefaultInstance()) {
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
                if (this.s2CDataBuilder_ == null) {
                    if (!other.s2CData_.isEmpty()) {
                        if (this.s2CData_.isEmpty()) {
                            this.s2CData_ = other.s2CData_;
                            this.bitField0_ &= 0xFFFFFFFB;
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
                        this.bitField0_ &= 0xFFFFFFFB;
                        this.s2CDataBuilder_ = InteractHandler.InteractTimesResponse.alwaysUseFieldBuilders ? getS2CDataFieldBuilder() : null;
                    } else {
                        this.s2CDataBuilder_.addAllMessages(other.s2CData_);
                    }
                }
                if (other.hasS2CCharm()) {
                    setS2CCharm(other.getS2CCharm());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasS2CCode()) {
                    return false;
                }
                for (int i = 0; i < getS2CDataCount(); i++) {
                    if (!getS2CData(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                InteractHandler.InteractTimesResponse parsedMessage = null;
                try {
                    parsedMessage = (InteractHandler.InteractTimesResponse) InteractHandler.InteractTimesResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (InteractHandler.InteractTimesResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = InteractHandler.InteractTimesResponse.getDefaultInstance().getS2CMsg();
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


            private void ensureS2CDataIsMutable() {
                if ((this.bitField0_ & 0x4) != 4) {
                    this.s2CData_ = new ArrayList<>(this.s2CData_);
                    this.bitField0_ |= 0x4;
                }
            }


            public List<InteractHandler.InteractTimes> getS2CDataList() {
                if (this.s2CDataBuilder_ == null) {
                    return Collections.unmodifiableList(this.s2CData_);
                }
                return this.s2CDataBuilder_.getMessageList();
            }


            public int getS2CDataCount() {
                if (this.s2CDataBuilder_ == null) {
                    return this.s2CData_.size();
                }
                return this.s2CDataBuilder_.getCount();
            }


            public InteractHandler.InteractTimes getS2CData(int index) {
                if (this.s2CDataBuilder_ == null) {
                    return this.s2CData_.get(index);
                }
                return (InteractHandler.InteractTimes) this.s2CDataBuilder_.getMessage(index);
            }


            public Builder setS2CData(int index, InteractHandler.InteractTimes value) {
                if (this.s2CDataBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureS2CDataIsMutable();
                    this.s2CData_.set(index, value);
                    onChanged();
                } else {
                    this.s2CDataBuilder_.setMessage(index, value);
                }
                return this;
            }


            public Builder setS2CData(int index, InteractHandler.InteractTimes.Builder builderForValue) {
                if (this.s2CDataBuilder_ == null) {
                    ensureS2CDataIsMutable();
                    this.s2CData_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CDataBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }


            public Builder addS2CData(InteractHandler.InteractTimes value) {
                if (this.s2CDataBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureS2CDataIsMutable();
                    this.s2CData_.add(value);
                    onChanged();
                } else {
                    this.s2CDataBuilder_.addMessage(value);
                }
                return this;
            }


            public Builder addS2CData(int index, InteractHandler.InteractTimes value) {
                if (this.s2CDataBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureS2CDataIsMutable();
                    this.s2CData_.add(index, value);
                    onChanged();
                } else {
                    this.s2CDataBuilder_.addMessage(index, value);
                }
                return this;
            }


            public Builder addS2CData(InteractHandler.InteractTimes.Builder builderForValue) {
                if (this.s2CDataBuilder_ == null) {
                    ensureS2CDataIsMutable();
                    this.s2CData_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.s2CDataBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }


            public Builder addS2CData(int index, InteractHandler.InteractTimes.Builder builderForValue) {
                if (this.s2CDataBuilder_ == null) {
                    ensureS2CDataIsMutable();
                    this.s2CData_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CDataBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }


            public Builder addAllS2CData(Iterable<? extends InteractHandler.InteractTimes> values) {
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
                    this.bitField0_ &= 0xFFFFFFFB;
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


            public InteractHandler.InteractTimes.Builder getS2CDataBuilder(int index) {
                return (InteractHandler.InteractTimes.Builder) getS2CDataFieldBuilder().getBuilder(index);
            }


            public InteractHandler.InteractTimesOrBuilder getS2CDataOrBuilder(int index) {
                if (this.s2CDataBuilder_ == null) {
                    return this.s2CData_.get(index);
                }
                return (InteractHandler.InteractTimesOrBuilder) this.s2CDataBuilder_.getMessageOrBuilder(index);
            }


            public List<? extends InteractHandler.InteractTimesOrBuilder> getS2CDataOrBuilderList() {
                if (this.s2CDataBuilder_ != null) {
                    return this.s2CDataBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList((List) this.s2CData_);
            }


            public InteractHandler.InteractTimes.Builder addS2CDataBuilder() {
                return (InteractHandler.InteractTimes.Builder) getS2CDataFieldBuilder().addBuilder(InteractHandler.InteractTimes.getDefaultInstance());
            }


            public InteractHandler.InteractTimes.Builder addS2CDataBuilder(int index) {
                return (InteractHandler.InteractTimes.Builder) getS2CDataFieldBuilder().addBuilder(index, InteractHandler.InteractTimes.getDefaultInstance());
            }


            public List<InteractHandler.InteractTimes.Builder> getS2CDataBuilderList() {
                return getS2CDataFieldBuilder().getBuilderList();
            }


            private RepeatedFieldBuilder<InteractHandler.InteractTimes, InteractHandler.InteractTimes.Builder, InteractHandler.InteractTimesOrBuilder> getS2CDataFieldBuilder() {
                if (this.s2CDataBuilder_ == null) {
                    this.s2CDataBuilder_ = new RepeatedFieldBuilder(this.s2CData_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
                    this.s2CData_ = null;
                }
                return this.s2CDataBuilder_;
            }


            public boolean hasS2CCharm() {
                return ((this.bitField0_ & 0x8) == 8);
            }


            public int getS2CCharm() {
                return this.s2CCharm_;
            }


            public Builder setS2CCharm(int value) {
                this.bitField0_ |= 0x8;
                this.s2CCharm_ = value;
                onChanged();
                return this;
            }


            public Builder clearS2CCharm() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.s2CCharm_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class ReceiveInteractPush
            extends GeneratedMessage
            implements ReceiveInteractPushOrBuilder {
        private final UnknownFieldSet unknownFields;


        private ReceiveInteractPush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }


        private ReceiveInteractPush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }


        public static ReceiveInteractPush getDefaultInstance() {
            return defaultInstance;
        }


        public ReceiveInteractPush getDefaultInstanceForType() {
            return defaultInstance;
        }


        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }


        private ReceiveInteractPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.id_ = input.readInt32();
                            break;
                        case 26:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x4;
                            this.sendPlayerName_ = bs;
                            break;
                        case 34:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x8;
                            this.show_ = bs;
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
            return InteractHandler.internal_static_pomelo_area_ReceiveInteractPush_descriptor;
        }


        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return InteractHandler.internal_static_pomelo_area_ReceiveInteractPush_fieldAccessorTable.ensureFieldAccessorsInitialized(ReceiveInteractPush.class, Builder.class);
        }


        public static Parser<ReceiveInteractPush> PARSER = (Parser<ReceiveInteractPush>) new AbstractParser<ReceiveInteractPush>() {
            public InteractHandler.ReceiveInteractPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new InteractHandler.ReceiveInteractPush(input, extensionRegistry);
            }
        };


        private int bitField0_;

        public static final int S2C_CODE_FIELD_NUMBER = 1;

        private int s2CCode_;

        public static final int ID_FIELD_NUMBER = 2;

        private int id_;

        public static final int SENDPLAYERNAME_FIELD_NUMBER = 3;

        private Object sendPlayerName_;

        public static final int SHOW_FIELD_NUMBER = 4;

        private Object show_;

        private byte memoizedIsInitialized;

        private int memoizedSerializedSize;

        private static final long serialVersionUID = 0L;


        public Parser<ReceiveInteractPush> getParserForType() {
            return PARSER;
        }


        public boolean hasS2CCode() {
            return ((this.bitField0_ & 0x1) == 1);
        }


        private static final ReceiveInteractPush defaultInstance = new ReceiveInteractPush(true);

        public int getS2CCode() {
            return this.s2CCode_;
        }

        public boolean hasId() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public int getId() {
            return this.id_;
        }

        public boolean hasSendPlayerName() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public String getSendPlayerName() {
            Object ref = this.sendPlayerName_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.sendPlayerName_ = s;
            return s;
        }

        public ByteString getSendPlayerNameBytes() {
            Object ref = this.sendPlayerName_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.sendPlayerName_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasShow() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public String getShow() {
            Object ref = this.show_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.show_ = s;
            return s;
        }

        public ByteString getShowBytes() {
            Object ref = this.show_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.show_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.id_ = 0;
            this.sendPlayerName_ = "";
            this.show_ = "";
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
            if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.id_);
            if ((this.bitField0_ & 0x4) == 4) output.writeBytes(3, getSendPlayerNameBytes());
            if ((this.bitField0_ & 0x8) == 8) output.writeBytes(4, getShowBytes());
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(2, this.id_);
            if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeBytesSize(3, getSendPlayerNameBytes());
            if ((this.bitField0_ & 0x8) == 8) size += CodedOutputStream.computeBytesSize(4, getShowBytes());
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static ReceiveInteractPush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ReceiveInteractPush) PARSER.parseFrom(data);
        }

        public static ReceiveInteractPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ReceiveInteractPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static ReceiveInteractPush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ReceiveInteractPush) PARSER.parseFrom(data);
        }

        public static ReceiveInteractPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ReceiveInteractPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static ReceiveInteractPush parseFrom(InputStream input) throws IOException {
            return (ReceiveInteractPush) PARSER.parseFrom(input);
        }

        public static ReceiveInteractPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReceiveInteractPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static ReceiveInteractPush parseDelimitedFrom(InputStream input) throws IOException {
            return (ReceiveInteractPush) PARSER.parseDelimitedFrom(input);
        }

        public static ReceiveInteractPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReceiveInteractPush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static ReceiveInteractPush parseFrom(CodedInputStream input) throws IOException {
            return (ReceiveInteractPush) PARSER.parseFrom(input);
        }

        public static ReceiveInteractPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReceiveInteractPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(ReceiveInteractPush prototype) {
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

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements InteractHandler.ReceiveInteractPushOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private int id_;
            private Object sendPlayerName_;
            private Object show_;

            public static final Descriptors.Descriptor getDescriptor() {
                return InteractHandler.internal_static_pomelo_area_ReceiveInteractPush_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return InteractHandler.internal_static_pomelo_area_ReceiveInteractPush_fieldAccessorTable.ensureFieldAccessorsInitialized(InteractHandler.ReceiveInteractPush.class, Builder.class);
            }

            private Builder() {
                this.sendPlayerName_ = "";
                this.show_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.sendPlayerName_ = "";
                this.show_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (InteractHandler.ReceiveInteractPush.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.s2CCode_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.id_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                this.sendPlayerName_ = "";
                this.bitField0_ &= 0xFFFFFFFB;
                this.show_ = "";
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return InteractHandler.internal_static_pomelo_area_ReceiveInteractPush_descriptor;
            }

            public InteractHandler.ReceiveInteractPush getDefaultInstanceForType() {
                return InteractHandler.ReceiveInteractPush.getDefaultInstance();
            }

            public InteractHandler.ReceiveInteractPush build() {
                InteractHandler.ReceiveInteractPush result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public InteractHandler.ReceiveInteractPush buildPartial() {
                InteractHandler.ReceiveInteractPush result = new InteractHandler.ReceiveInteractPush(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.id_ = this.id_;
                if ((from_bitField0_ & 0x4) == 4)
                    to_bitField0_ |= 0x4;
                result.sendPlayerName_ = this.sendPlayerName_;
                if ((from_bitField0_ & 0x8) == 8)
                    to_bitField0_ |= 0x8;
                result.show_ = this.show_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof InteractHandler.ReceiveInteractPush)
                    return mergeFrom((InteractHandler.ReceiveInteractPush) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(InteractHandler.ReceiveInteractPush other) {
                if (other == InteractHandler.ReceiveInteractPush.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasId())
                    setId(other.getId());
                if (other.hasSendPlayerName()) {
                    this.bitField0_ |= 0x4;
                    this.sendPlayerName_ = other.sendPlayerName_;
                    onChanged();
                }
                if (other.hasShow()) {
                    this.bitField0_ |= 0x8;
                    this.show_ = other.show_;
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
                InteractHandler.ReceiveInteractPush parsedMessage = null;
                try {
                    parsedMessage = (InteractHandler.ReceiveInteractPush) InteractHandler.ReceiveInteractPush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (InteractHandler.ReceiveInteractPush) e.getUnfinishedMessage();
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

            public boolean hasId() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getId() {
                return this.id_;
            }

            public Builder setId(int value) {
                this.bitField0_ |= 0x2;
                this.id_ = value;
                onChanged();
                return this;
            }

            public Builder clearId() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.id_ = 0;
                onChanged();
                return this;
            }

            public boolean hasSendPlayerName() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public String getSendPlayerName() {
                Object ref = this.sendPlayerName_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.sendPlayerName_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getSendPlayerNameBytes() {
                Object ref = this.sendPlayerName_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.sendPlayerName_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setSendPlayerName(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x4;
                this.sendPlayerName_ = value;
                onChanged();
                return this;
            }

            public Builder clearSendPlayerName() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.sendPlayerName_ = InteractHandler.ReceiveInteractPush.getDefaultInstance().getSendPlayerName();
                onChanged();
                return this;
            }

            public Builder setSendPlayerNameBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x4;
                this.sendPlayerName_ = value;
                onChanged();
                return this;
            }

            public boolean hasShow() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public String getShow() {
                Object ref = this.show_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.show_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getShowBytes() {
                Object ref = this.show_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.show_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setShow(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x8;
                this.show_ = value;
                onChanged();
                return this;
            }

            public Builder clearShow() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.show_ = InteractHandler.ReceiveInteractPush.getDefaultInstance().getShow();
                onChanged();
                return this;
            }

            public Builder setShowBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x8;
                this.show_ = value;
                onChanged();
                return this;
            }
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }


    static {
        String[] descriptorData = {"\n\025interactHandler.proto\022\013pomelo.area\032\fcommon.proto\"O\n\017InteractRequest\022\016\n\006c2s_id\030\001 \002(\005\022\024\n\fc2s_playerId\030\002 \002(\t\022\026\n\016c2s_playerName\030\003 \002(\t\"5\n\020InteractResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"\027\n\025InteractConfigRequest\"t\n\016InteractConfig\022\n\n\002id\030\001 \002(\005\022\f\n\004name\030\002 \001(\t\022\f\n\004type\030\003 \001(\005\022\r\n\005charm\030\004 \001(\005\022\f\n\004gold\030\005 \001(\005\022\017\n\007diamond\030\006 \001(\005\022\f\n\004show\030\007 \001(\t\"j\n\026InteractConfigResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022-\n\bs2c_da", "ta\030\003 \003(\0132\033.pomelo.area.InteractConfig\"\026\n\024InteractTimesRequest\",\n\rInteractTimes\022\f\n\004type\030\001 \002(\005\022\r\n\005times\030\002 \001(\005\"{\n\025InteractTimesResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022,\n\bs2c_data\030\003 \003(\0132\032.pomelo.area.InteractTimes\022\021\n\ts2c_charm\030\004 \001(\005\"Y\n\023ReceiveInteractPush\022\020\n\bs2c_code\030\001 \002(\005\022\n\n\002id\030\002 \001(\005\022\026\n\016sendPlayerName\030\003 \001(\t\022\f\n\004show\030\004 \001(\t2¢\002\n\017interactHandler\022N\n\017interactRequest\022\034.pomelo.area.InteractRequest\032\035.pomel", "o.area.InteractResponse\022`\n\025interactConfigRequest\022\".pomelo.area.InteractConfigRequest\032#.pomelo.area.InteractConfigResponse\022]\n\024interactTimesRequest\022!.pomelo.area.InteractTimesRequest\032\".pomelo.area.InteractTimesResponse2U\n\finteractPush\022E\n\023receiveInteractPush\022 .pomelo.area.ReceiveInteractPush\032\f.pomelo.Void"};


        Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root) {
                InteractHandler.descriptor = root;
                return null;
            }
        };

        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[]{

                Common.getDescriptor()}, assigner);
    }

    private static final Descriptors.Descriptor internal_static_pomelo_area_InteractRequest_descriptor = getDescriptor().getMessageTypes().get(0);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_InteractRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_InteractRequest_descriptor, new String[]{"C2SId", "C2SPlayerId", "C2SPlayerName"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_InteractResponse_descriptor = getDescriptor().getMessageTypes().get(1);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_InteractResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_InteractResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_InteractConfigRequest_descriptor = getDescriptor().getMessageTypes().get(2);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_InteractConfigRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_InteractConfigRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_area_InteractConfig_descriptor = getDescriptor().getMessageTypes().get(3);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_InteractConfig_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_InteractConfig_descriptor, new String[]{"Id", "Name", "Type", "Charm", "Gold", "Diamond", "Show"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_InteractConfigResponse_descriptor = getDescriptor().getMessageTypes().get(4);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_InteractConfigResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_InteractConfigResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CData"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_InteractTimesRequest_descriptor = getDescriptor().getMessageTypes().get(5);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_InteractTimesRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_InteractTimesRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_area_InteractTimes_descriptor = getDescriptor().getMessageTypes().get(6);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_InteractTimes_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_InteractTimes_descriptor, new String[]{"Type", "Times"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_InteractTimesResponse_descriptor = getDescriptor().getMessageTypes().get(7);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_InteractTimesResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_InteractTimesResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CData", "S2CCharm"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_ReceiveInteractPush_descriptor = getDescriptor().getMessageTypes().get(8);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ReceiveInteractPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ReceiveInteractPush_descriptor, new String[]{"S2CCode", "Id", "SendPlayerName", "Show"});
    private static Descriptors.FileDescriptor descriptor;

    static {
        Common.getDescriptor();
    }

    public static interface ReceiveInteractPushOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasId();

        int getId();

        boolean hasSendPlayerName();

        String getSendPlayerName();

        ByteString getSendPlayerNameBytes();

        boolean hasShow();

        String getShow();

        ByteString getShowBytes();
    }

    public static interface InteractTimesResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        List<InteractHandler.InteractTimes> getS2CDataList();

        InteractHandler.InteractTimes getS2CData(int param1Int);

        int getS2CDataCount();

        List<? extends InteractHandler.InteractTimesOrBuilder> getS2CDataOrBuilderList();

        InteractHandler.InteractTimesOrBuilder getS2CDataOrBuilder(int param1Int);

        boolean hasS2CCharm();

        int getS2CCharm();
    }

    public static interface InteractTimesOrBuilder extends MessageOrBuilder {
        boolean hasType();

        int getType();

        boolean hasTimes();

        int getTimes();
    }

    public static interface InteractTimesRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface InteractConfigResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        List<InteractHandler.InteractConfig> getS2CDataList();

        InteractHandler.InteractConfig getS2CData(int param1Int);

        int getS2CDataCount();

        List<? extends InteractHandler.InteractConfigOrBuilder> getS2CDataOrBuilderList();

        InteractHandler.InteractConfigOrBuilder getS2CDataOrBuilder(int param1Int);
    }

    public static interface InteractConfigOrBuilder extends MessageOrBuilder {
        boolean hasId();

        int getId();

        boolean hasName();

        String getName();

        ByteString getNameBytes();

        boolean hasType();

        int getType();

        boolean hasCharm();

        int getCharm();

        boolean hasGold();

        int getGold();

        boolean hasDiamond();

        int getDiamond();

        boolean hasShow();

        String getShow();

        ByteString getShowBytes();
    }

    public static interface InteractConfigRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface InteractResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface InteractRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2SId();

        int getC2SId();

        boolean hasC2SPlayerId();

        String getC2SPlayerId();

        ByteString getC2SPlayerIdBytes();

        boolean hasC2SPlayerName();

        String getC2SPlayerName();

        ByteString getC2SPlayerNameBytes();
    }
}


