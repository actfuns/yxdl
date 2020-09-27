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


public final class OnlineGiftHandler {
    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static final class GetGiftInfoRequest
            extends GeneratedMessage
            implements GetGiftInfoRequestOrBuilder {
        private static final GetGiftInfoRequest defaultInstance = new GetGiftInfoRequest(true);
        private final UnknownFieldSet unknownFields;

        private GetGiftInfoRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetGiftInfoRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetGiftInfoRequest getDefaultInstance() {
            return defaultInstance;
        }

        public GetGiftInfoRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetGiftInfoRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return OnlineGiftHandler.internal_static_pomelo_area_GetGiftInfoRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return OnlineGiftHandler.internal_static_pomelo_area_GetGiftInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetGiftInfoRequest.class, Builder.class);
        }

        public static Parser<GetGiftInfoRequest> PARSER = (Parser<GetGiftInfoRequest>) new AbstractParser<GetGiftInfoRequest>() {
            public OnlineGiftHandler.GetGiftInfoRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new OnlineGiftHandler.GetGiftInfoRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetGiftInfoRequest> getParserForType() {
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

        public static GetGiftInfoRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetGiftInfoRequest) PARSER.parseFrom(data);
        }

        public static GetGiftInfoRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetGiftInfoRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetGiftInfoRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetGiftInfoRequest) PARSER.parseFrom(data);
        }

        public static GetGiftInfoRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetGiftInfoRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetGiftInfoRequest parseFrom(InputStream input) throws IOException {
            return (GetGiftInfoRequest) PARSER.parseFrom(input);
        }

        public static GetGiftInfoRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetGiftInfoRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static GetGiftInfoRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (GetGiftInfoRequest) PARSER.parseDelimitedFrom(input);
        }

        public static GetGiftInfoRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetGiftInfoRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static GetGiftInfoRequest parseFrom(CodedInputStream input) throws IOException {
            return (GetGiftInfoRequest) PARSER.parseFrom(input);
        }

        public static GetGiftInfoRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetGiftInfoRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(GetGiftInfoRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements OnlineGiftHandler.GetGiftInfoRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return OnlineGiftHandler.internal_static_pomelo_area_GetGiftInfoRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return OnlineGiftHandler.internal_static_pomelo_area_GetGiftInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(OnlineGiftHandler.GetGiftInfoRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (OnlineGiftHandler.GetGiftInfoRequest.alwaysUseFieldBuilders) ;
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
                return OnlineGiftHandler.internal_static_pomelo_area_GetGiftInfoRequest_descriptor;
            }

            public OnlineGiftHandler.GetGiftInfoRequest getDefaultInstanceForType() {
                return OnlineGiftHandler.GetGiftInfoRequest.getDefaultInstance();
            }

            public OnlineGiftHandler.GetGiftInfoRequest build() {
                OnlineGiftHandler.GetGiftInfoRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public OnlineGiftHandler.GetGiftInfoRequest buildPartial() {
                OnlineGiftHandler.GetGiftInfoRequest result = new OnlineGiftHandler.GetGiftInfoRequest(this);
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof OnlineGiftHandler.GetGiftInfoRequest)
                    return mergeFrom((OnlineGiftHandler.GetGiftInfoRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(OnlineGiftHandler.GetGiftInfoRequest other) {
                if (other == OnlineGiftHandler.GetGiftInfoRequest.getDefaultInstance()) return this;
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                OnlineGiftHandler.GetGiftInfoRequest parsedMessage = null;
                try {
                    parsedMessage = (OnlineGiftHandler.GetGiftInfoRequest) OnlineGiftHandler.GetGiftInfoRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (OnlineGiftHandler.GetGiftInfoRequest) e.getUnfinishedMessage();
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


    public static final class GetOnlineTimeRequest
            extends GeneratedMessage
            implements GetOnlineTimeRequestOrBuilder {
        private static final GetOnlineTimeRequest defaultInstance = new GetOnlineTimeRequest(true);
        private final UnknownFieldSet unknownFields;

        private GetOnlineTimeRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetOnlineTimeRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetOnlineTimeRequest getDefaultInstance() {
            return defaultInstance;
        }

        public GetOnlineTimeRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetOnlineTimeRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return OnlineGiftHandler.internal_static_pomelo_area_GetOnlineTimeRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return OnlineGiftHandler.internal_static_pomelo_area_GetOnlineTimeRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetOnlineTimeRequest.class, Builder.class);
        }

        public static Parser<GetOnlineTimeRequest> PARSER = (Parser<GetOnlineTimeRequest>) new AbstractParser<GetOnlineTimeRequest>() {
            public OnlineGiftHandler.GetOnlineTimeRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new OnlineGiftHandler.GetOnlineTimeRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetOnlineTimeRequest> getParserForType() {
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

        public static GetOnlineTimeRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetOnlineTimeRequest) PARSER.parseFrom(data);
        }

        public static GetOnlineTimeRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetOnlineTimeRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetOnlineTimeRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetOnlineTimeRequest) PARSER.parseFrom(data);
        }

        public static GetOnlineTimeRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetOnlineTimeRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetOnlineTimeRequest parseFrom(InputStream input) throws IOException {
            return (GetOnlineTimeRequest) PARSER.parseFrom(input);
        }

        public static GetOnlineTimeRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetOnlineTimeRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static GetOnlineTimeRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (GetOnlineTimeRequest) PARSER.parseDelimitedFrom(input);
        }

        public static GetOnlineTimeRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetOnlineTimeRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static GetOnlineTimeRequest parseFrom(CodedInputStream input) throws IOException {
            return (GetOnlineTimeRequest) PARSER.parseFrom(input);
        }

        public static GetOnlineTimeRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetOnlineTimeRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(GetOnlineTimeRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements OnlineGiftHandler.GetOnlineTimeRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return OnlineGiftHandler.internal_static_pomelo_area_GetOnlineTimeRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return OnlineGiftHandler.internal_static_pomelo_area_GetOnlineTimeRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(OnlineGiftHandler.GetOnlineTimeRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (OnlineGiftHandler.GetOnlineTimeRequest.alwaysUseFieldBuilders) ;
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
                return OnlineGiftHandler.internal_static_pomelo_area_GetOnlineTimeRequest_descriptor;
            }

            public OnlineGiftHandler.GetOnlineTimeRequest getDefaultInstanceForType() {
                return OnlineGiftHandler.GetOnlineTimeRequest.getDefaultInstance();
            }

            public OnlineGiftHandler.GetOnlineTimeRequest build() {
                OnlineGiftHandler.GetOnlineTimeRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public OnlineGiftHandler.GetOnlineTimeRequest buildPartial() {
                OnlineGiftHandler.GetOnlineTimeRequest result = new OnlineGiftHandler.GetOnlineTimeRequest(this);
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof OnlineGiftHandler.GetOnlineTimeRequest)
                    return mergeFrom((OnlineGiftHandler.GetOnlineTimeRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(OnlineGiftHandler.GetOnlineTimeRequest other) {
                if (other == OnlineGiftHandler.GetOnlineTimeRequest.getDefaultInstance()) return this;
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                OnlineGiftHandler.GetOnlineTimeRequest parsedMessage = null;
                try {
                    parsedMessage = (OnlineGiftHandler.GetOnlineTimeRequest) OnlineGiftHandler.GetOnlineTimeRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (OnlineGiftHandler.GetOnlineTimeRequest) e.getUnfinishedMessage();
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


    public static final class ReceiveGiftRequest
            extends GeneratedMessage
            implements ReceiveGiftRequestOrBuilder {
        private static final ReceiveGiftRequest defaultInstance = new ReceiveGiftRequest(true);
        private final UnknownFieldSet unknownFields;

        private ReceiveGiftRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private ReceiveGiftRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static ReceiveGiftRequest getDefaultInstance() {
            return defaultInstance;
        }

        public ReceiveGiftRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ReceiveGiftRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return OnlineGiftHandler.internal_static_pomelo_area_ReceiveGiftRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return OnlineGiftHandler.internal_static_pomelo_area_ReceiveGiftRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ReceiveGiftRequest.class, Builder.class);
        }

        public static Parser<ReceiveGiftRequest> PARSER = (Parser<ReceiveGiftRequest>) new AbstractParser<ReceiveGiftRequest>() {
            public OnlineGiftHandler.ReceiveGiftRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new OnlineGiftHandler.ReceiveGiftRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_ID_FIELD_NUMBER = 1;
        private int c2SId_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<ReceiveGiftRequest> getParserForType() {
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


        public static ReceiveGiftRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ReceiveGiftRequest) PARSER.parseFrom(data);
        }


        public static ReceiveGiftRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ReceiveGiftRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static ReceiveGiftRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ReceiveGiftRequest) PARSER.parseFrom(data);
        }


        public static ReceiveGiftRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ReceiveGiftRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static ReceiveGiftRequest parseFrom(InputStream input) throws IOException {
            return (ReceiveGiftRequest) PARSER.parseFrom(input);
        }


        public static ReceiveGiftRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReceiveGiftRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static ReceiveGiftRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (ReceiveGiftRequest) PARSER.parseDelimitedFrom(input);
        }


        public static ReceiveGiftRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReceiveGiftRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static ReceiveGiftRequest parseFrom(CodedInputStream input) throws IOException {
            return (ReceiveGiftRequest) PARSER.parseFrom(input);
        }


        public static ReceiveGiftRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReceiveGiftRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(ReceiveGiftRequest prototype) {
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
                implements OnlineGiftHandler.ReceiveGiftRequestOrBuilder {
            private int bitField0_;


            private int c2SId_;


            public static final Descriptors.Descriptor getDescriptor() {
                return OnlineGiftHandler.internal_static_pomelo_area_ReceiveGiftRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return OnlineGiftHandler.internal_static_pomelo_area_ReceiveGiftRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(OnlineGiftHandler.ReceiveGiftRequest.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (OnlineGiftHandler.ReceiveGiftRequest.alwaysUseFieldBuilders) ;
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
                return OnlineGiftHandler.internal_static_pomelo_area_ReceiveGiftRequest_descriptor;
            }


            public OnlineGiftHandler.ReceiveGiftRequest getDefaultInstanceForType() {
                return OnlineGiftHandler.ReceiveGiftRequest.getDefaultInstance();
            }


            public OnlineGiftHandler.ReceiveGiftRequest build() {
                OnlineGiftHandler.ReceiveGiftRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public OnlineGiftHandler.ReceiveGiftRequest buildPartial() {
                OnlineGiftHandler.ReceiveGiftRequest result = new OnlineGiftHandler.ReceiveGiftRequest(this);
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
                if (other instanceof OnlineGiftHandler.ReceiveGiftRequest) {
                    return mergeFrom((OnlineGiftHandler.ReceiveGiftRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(OnlineGiftHandler.ReceiveGiftRequest other) {
                if (other == OnlineGiftHandler.ReceiveGiftRequest.getDefaultInstance()) {
                    return this;
                }
                if (other.hasC2SId()) {
                    setC2SId(other.getC2SId());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                OnlineGiftHandler.ReceiveGiftRequest parsedMessage = null;
                try {
                    parsedMessage = (OnlineGiftHandler.ReceiveGiftRequest) OnlineGiftHandler.ReceiveGiftRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (OnlineGiftHandler.ReceiveGiftRequest) e.getUnfinishedMessage();
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


    public static final class GiftInfo
            extends GeneratedMessage
            implements GiftInfoOrBuilder {
        private static final GiftInfo defaultInstance = new GiftInfo(true);
        private final UnknownFieldSet unknownFields;

        private GiftInfo(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GiftInfo(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GiftInfo getDefaultInstance() {
            return defaultInstance;
        }

        public GiftInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GiftInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.time_ = input.readInt32();
                            break;
                        case 26:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x4;
                            this.name_ = bs;
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.state_ = input.readInt32();
                            break;
                        case 42:
                            if ((mutable_bitField0_ & 0x10) != 16) {
                                this.item_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x10;
                            }
                            this.item_.add(input.readMessage(ItemOuterClass.MiniItem.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x10) == 16) this.item_ = Collections.unmodifiableList(this.item_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return OnlineGiftHandler.internal_static_pomelo_area_GiftInfo_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return OnlineGiftHandler.internal_static_pomelo_area_GiftInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(GiftInfo.class, Builder.class);
        }

        public static Parser<GiftInfo> PARSER = (Parser<GiftInfo>) new AbstractParser<GiftInfo>() {
            public OnlineGiftHandler.GiftInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new OnlineGiftHandler.GiftInfo(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int ID_FIELD_NUMBER = 1;
        private int id_;
        public static final int TIME_FIELD_NUMBER = 2;
        private int time_;
        public static final int NAME_FIELD_NUMBER = 3;
        private Object name_;
        public static final int STATE_FIELD_NUMBER = 4;
        private int state_;
        public static final int ITEM_FIELD_NUMBER = 5;
        private List<ItemOuterClass.MiniItem> item_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GiftInfo> getParserForType() {
            return PARSER;
        }

        public boolean hasId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getId() {
            return this.id_;
        }

        public boolean hasTime() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public int getTime() {
            return this.time_;
        }

        public boolean hasName() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        static {
            defaultInstance.initFields();
        }


        public String getName() {
            Object ref = this.name_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.name_ = s;
            }
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


        public boolean hasState() {
            return ((this.bitField0_ & 0x8) == 8);
        }


        public int getState() {
            return this.state_;
        }


        public List<ItemOuterClass.MiniItem> getItemList() {
            return this.item_;
        }


        public List<? extends ItemOuterClass.MiniItemOrBuilder> getItemOrBuilderList() {
            return (List) this.item_;
        }


        public int getItemCount() {
            return this.item_.size();
        }


        public ItemOuterClass.MiniItem getItem(int index) {
            return this.item_.get(index);
        }


        public ItemOuterClass.MiniItemOrBuilder getItemOrBuilder(int index) {
            return (ItemOuterClass.MiniItemOrBuilder) this.item_.get(index);
        }


        private void initFields() {
            this.id_ = 0;
            this.time_ = 0;
            this.name_ = "";
            this.state_ = 0;
            this.item_ = Collections.emptyList();
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            for (int i = 0; i < getItemCount(); i++) {
                if (!getItem(i).isInitialized()) {
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
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeInt32(2, this.time_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeBytes(3, getNameBytes());
            }
            if ((this.bitField0_ & 0x8) == 8) {
                output.writeInt32(4, this.state_);
            }
            for (int i = 0; i < this.item_.size(); i++) {
                output.writeMessage(5, (MessageLite) this.item_.get(i));
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
                size += CodedOutputStream.computeInt32Size(2, this.time_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                size += CodedOutputStream.computeBytesSize(3, getNameBytes());
            }
            if ((this.bitField0_ & 0x8) == 8) {
                size += CodedOutputStream.computeInt32Size(4, this.state_);
            }
            for (int i = 0; i < this.item_.size(); i++) {
                size += CodedOutputStream.computeMessageSize(5, (MessageLite) this.item_.get(i));
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static GiftInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GiftInfo) PARSER.parseFrom(data);
        }


        public static GiftInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GiftInfo) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GiftInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GiftInfo) PARSER.parseFrom(data);
        }


        public static GiftInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GiftInfo) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GiftInfo parseFrom(InputStream input) throws IOException {
            return (GiftInfo) PARSER.parseFrom(input);
        }


        public static GiftInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GiftInfo) PARSER.parseFrom(input, extensionRegistry);
        }


        public static GiftInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (GiftInfo) PARSER.parseDelimitedFrom(input);
        }


        public static GiftInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GiftInfo) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static GiftInfo parseFrom(CodedInputStream input) throws IOException {
            return (GiftInfo) PARSER.parseFrom(input);
        }


        public static GiftInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GiftInfo) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(GiftInfo prototype) {
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
                implements OnlineGiftHandler.GiftInfoOrBuilder {
            private int bitField0_;


            private int id_;


            private int time_;


            private Object name_;


            private int state_;


            private List<ItemOuterClass.MiniItem> item_;


            private RepeatedFieldBuilder<ItemOuterClass.MiniItem, ItemOuterClass.MiniItem.Builder, ItemOuterClass.MiniItemOrBuilder> itemBuilder_;


            public static final Descriptors.Descriptor getDescriptor() {
                return OnlineGiftHandler.internal_static_pomelo_area_GiftInfo_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return OnlineGiftHandler.internal_static_pomelo_area_GiftInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(OnlineGiftHandler.GiftInfo.class, Builder.class);
            }


            private Builder() {
                this.name_ = "";
                this.item_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.name_ = "";
                this.item_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (OnlineGiftHandler.GiftInfo.alwaysUseFieldBuilders) {
                    getItemFieldBuilder();
                }
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.id_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.time_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                this.name_ = "";
                this.bitField0_ &= 0xFFFFFFFB;
                this.state_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                if (this.itemBuilder_ == null) {
                    this.item_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFEF;
                } else {
                    this.itemBuilder_.clear();
                }
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return OnlineGiftHandler.internal_static_pomelo_area_GiftInfo_descriptor;
            }


            public OnlineGiftHandler.GiftInfo getDefaultInstanceForType() {
                return OnlineGiftHandler.GiftInfo.getDefaultInstance();
            }


            public OnlineGiftHandler.GiftInfo build() {
                OnlineGiftHandler.GiftInfo result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public OnlineGiftHandler.GiftInfo buildPartial() {
                OnlineGiftHandler.GiftInfo result = new OnlineGiftHandler.GiftInfo(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.id_ = this.id_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.time_ = this.time_;
                if ((from_bitField0_ & 0x4) == 4) {
                    to_bitField0_ |= 0x4;
                }
                result.name_ = this.name_;
                if ((from_bitField0_ & 0x8) == 8) {
                    to_bitField0_ |= 0x8;
                }
                result.state_ = this.state_;
                if (this.itemBuilder_ == null) {
                    if ((this.bitField0_ & 0x10) == 16) {
                        this.item_ = Collections.unmodifiableList(this.item_);
                        this.bitField0_ &= 0xFFFFFFEF;
                    }
                    result.item_ = this.item_;
                } else {
                    result.item_ = this.itemBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof OnlineGiftHandler.GiftInfo) {
                    return mergeFrom((OnlineGiftHandler.GiftInfo) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(OnlineGiftHandler.GiftInfo other) {
                if (other == OnlineGiftHandler.GiftInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.hasId()) {
                    setId(other.getId());
                }
                if (other.hasTime()) {
                    setTime(other.getTime());
                }
                if (other.hasName()) {
                    this.bitField0_ |= 0x4;
                    this.name_ = other.name_;
                    onChanged();
                }
                if (other.hasState()) {
                    setState(other.getState());
                }
                if (this.itemBuilder_ == null) {
                    if (!other.item_.isEmpty()) {
                        if (this.item_.isEmpty()) {
                            this.item_ = other.item_;
                            this.bitField0_ &= 0xFFFFFFEF;
                        } else {
                            ensureItemIsMutable();
                            this.item_.addAll(other.item_);
                        }
                        onChanged();
                    }
                } else if (!other.item_.isEmpty()) {
                    if (this.itemBuilder_.isEmpty()) {
                        this.itemBuilder_.dispose();
                        this.itemBuilder_ = null;
                        this.item_ = other.item_;
                        this.bitField0_ &= 0xFFFFFFEF;
                        this.itemBuilder_ = OnlineGiftHandler.GiftInfo.alwaysUseFieldBuilders ? getItemFieldBuilder() : null;
                    } else {
                        this.itemBuilder_.addAllMessages(other.item_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                for (int i = 0; i < getItemCount(); i++) {
                    if (!getItem(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                OnlineGiftHandler.GiftInfo parsedMessage = null;
                try {
                    parsedMessage = (OnlineGiftHandler.GiftInfo) OnlineGiftHandler.GiftInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (OnlineGiftHandler.GiftInfo) e.getUnfinishedMessage();
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


            public boolean hasName() {
                return ((this.bitField0_ & 0x4) == 4);
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
                this.bitField0_ |= 0x4;
                this.name_ = value;
                onChanged();
                return this;
            }


            public Builder clearName() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.name_ = OnlineGiftHandler.GiftInfo.getDefaultInstance().getName();
                onChanged();
                return this;
            }


            public Builder setNameBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x4;
                this.name_ = value;
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


            private void ensureItemIsMutable() {
                if ((this.bitField0_ & 0x10) != 16) {
                    this.item_ = new ArrayList<>(this.item_);
                    this.bitField0_ |= 0x10;
                }
            }


            public List<ItemOuterClass.MiniItem> getItemList() {
                if (this.itemBuilder_ == null) {
                    return Collections.unmodifiableList(this.item_);
                }
                return this.itemBuilder_.getMessageList();
            }


            public int getItemCount() {
                if (this.itemBuilder_ == null) {
                    return this.item_.size();
                }
                return this.itemBuilder_.getCount();
            }


            public ItemOuterClass.MiniItem getItem(int index) {
                if (this.itemBuilder_ == null) {
                    return this.item_.get(index);
                }
                return (ItemOuterClass.MiniItem) this.itemBuilder_.getMessage(index);
            }


            public Builder setItem(int index, ItemOuterClass.MiniItem value) {
                if (this.itemBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureItemIsMutable();
                    this.item_.set(index, value);
                    onChanged();
                } else {
                    this.itemBuilder_.setMessage(index, (GeneratedMessage) value);
                }
                return this;
            }


            public Builder setItem(int index, ItemOuterClass.MiniItem.Builder builderForValue) {
                if (this.itemBuilder_ == null) {
                    ensureItemIsMutable();
                    this.item_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.itemBuilder_.setMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }


            public Builder addItem(ItemOuterClass.MiniItem value) {
                if (this.itemBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureItemIsMutable();
                    this.item_.add(value);
                    onChanged();
                } else {
                    this.itemBuilder_.addMessage((GeneratedMessage) value);
                }
                return this;
            }


            public Builder addItem(int index, ItemOuterClass.MiniItem value) {
                if (this.itemBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureItemIsMutable();
                    this.item_.add(index, value);
                    onChanged();
                } else {
                    this.itemBuilder_.addMessage(index, (GeneratedMessage) value);
                }
                return this;
            }


            public Builder addItem(ItemOuterClass.MiniItem.Builder builderForValue) {
                if (this.itemBuilder_ == null) {
                    ensureItemIsMutable();
                    this.item_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.itemBuilder_.addMessage((GeneratedMessage) builderForValue.build());
                }
                return this;
            }


            public Builder addItem(int index, ItemOuterClass.MiniItem.Builder builderForValue) {
                if (this.itemBuilder_ == null) {
                    ensureItemIsMutable();
                    this.item_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.itemBuilder_.addMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }


            public Builder addAllItem(Iterable<? extends ItemOuterClass.MiniItem> values) {
                if (this.itemBuilder_ == null) {
                    ensureItemIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.item_);
                    onChanged();
                } else {
                    this.itemBuilder_.addAllMessages(values);
                }
                return this;
            }


            public Builder clearItem() {
                if (this.itemBuilder_ == null) {
                    this.item_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFEF;
                    onChanged();
                } else {
                    this.itemBuilder_.clear();
                }
                return this;
            }


            public Builder removeItem(int index) {
                if (this.itemBuilder_ == null) {
                    ensureItemIsMutable();
                    this.item_.remove(index);
                    onChanged();
                } else {
                    this.itemBuilder_.remove(index);
                }
                return this;
            }


            public ItemOuterClass.MiniItem.Builder getItemBuilder(int index) {
                return (ItemOuterClass.MiniItem.Builder) getItemFieldBuilder().getBuilder(index);
            }


            public ItemOuterClass.MiniItemOrBuilder getItemOrBuilder(int index) {
                if (this.itemBuilder_ == null) {
                    return (ItemOuterClass.MiniItemOrBuilder) this.item_.get(index);
                }
                return (ItemOuterClass.MiniItemOrBuilder) this.itemBuilder_.getMessageOrBuilder(index);
            }


            public List<? extends ItemOuterClass.MiniItemOrBuilder> getItemOrBuilderList() {
                if (this.itemBuilder_ != null) {
                    return this.itemBuilder_.getMessageOrBuilderList();
                }
                return (List) Collections.unmodifiableList(this.item_);
            }


            public ItemOuterClass.MiniItem.Builder addItemBuilder() {
                return (ItemOuterClass.MiniItem.Builder) getItemFieldBuilder().addBuilder((GeneratedMessage) ItemOuterClass.MiniItem.getDefaultInstance());
            }


            public ItemOuterClass.MiniItem.Builder addItemBuilder(int index) {
                return (ItemOuterClass.MiniItem.Builder) getItemFieldBuilder().addBuilder(index, (GeneratedMessage) ItemOuterClass.MiniItem.getDefaultInstance());
            }


            public List<ItemOuterClass.MiniItem.Builder> getItemBuilderList() {
                return getItemFieldBuilder().getBuilderList();
            }


            private RepeatedFieldBuilder<ItemOuterClass.MiniItem, ItemOuterClass.MiniItem.Builder, ItemOuterClass.MiniItemOrBuilder> getItemFieldBuilder() {
                if (this.itemBuilder_ == null) {
                    this.itemBuilder_ = new RepeatedFieldBuilder(this.item_, ((this.bitField0_ & 0x10) == 16), getParentForChildren(), isClean());
                    this.item_ = null;
                }
                return this.itemBuilder_;
            }
        }
    }


    public static final class OnlineGift
            extends GeneratedMessage
            implements OnlineGiftOrBuilder {
        private static final OnlineGift defaultInstance = new OnlineGift(true);
        private final UnknownFieldSet unknownFields;

        private OnlineGift(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private OnlineGift(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static OnlineGift getDefaultInstance() {
            return defaultInstance;
        }

        public OnlineGift getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private OnlineGift(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.onlineTime_ = input.readInt32();
                            break;
                        case 18:
                            if ((mutable_bitField0_ & 0x2) != 2) {
                                this.giftList_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x2;
                            }
                            this.giftList_.add(input.readMessage(OnlineGiftHandler.GiftInfo.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x2) == 2) this.giftList_ = Collections.unmodifiableList(this.giftList_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return OnlineGiftHandler.internal_static_pomelo_area_OnlineGift_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return OnlineGiftHandler.internal_static_pomelo_area_OnlineGift_fieldAccessorTable.ensureFieldAccessorsInitialized(OnlineGift.class, Builder.class);
        }

        public static Parser<OnlineGift> PARSER = (Parser<OnlineGift>) new AbstractParser<OnlineGift>() {
            public OnlineGiftHandler.OnlineGift parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new OnlineGiftHandler.OnlineGift(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int ONLINETIME_FIELD_NUMBER = 1;
        private int onlineTime_;
        public static final int GIFTLIST_FIELD_NUMBER = 2;
        private List<OnlineGiftHandler.GiftInfo> giftList_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<OnlineGift> getParserForType() {
            return PARSER;
        }

        public boolean hasOnlineTime() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getOnlineTime() {
            return this.onlineTime_;
        }

        public List<OnlineGiftHandler.GiftInfo> getGiftListList() {
            return this.giftList_;
        }

        public List<? extends OnlineGiftHandler.GiftInfoOrBuilder> getGiftListOrBuilderList() {
            return (List) this.giftList_;
        }

        static {
            defaultInstance.initFields();
        }


        public int getGiftListCount() {
            return this.giftList_.size();
        }


        public OnlineGiftHandler.GiftInfo getGiftList(int index) {
            return this.giftList_.get(index);
        }


        public OnlineGiftHandler.GiftInfoOrBuilder getGiftListOrBuilder(int index) {
            return this.giftList_.get(index);
        }


        private void initFields() {
            this.onlineTime_ = 0;
            this.giftList_ = Collections.emptyList();
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            for (int i = 0; i < getGiftListCount(); i++) {
                if (!getGiftList(i).isInitialized()) {
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
                output.writeInt32(1, this.onlineTime_);
            }
            for (int i = 0; i < this.giftList_.size(); i++) {
                output.writeMessage(2, (MessageLite) this.giftList_.get(i));
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
                size += CodedOutputStream.computeInt32Size(1, this.onlineTime_);
            }
            for (int i = 0; i < this.giftList_.size(); i++) {
                size += CodedOutputStream.computeMessageSize(2, (MessageLite) this.giftList_.get(i));
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static OnlineGift parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (OnlineGift) PARSER.parseFrom(data);
        }


        public static OnlineGift parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (OnlineGift) PARSER.parseFrom(data, extensionRegistry);
        }


        public static OnlineGift parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (OnlineGift) PARSER.parseFrom(data);
        }


        public static OnlineGift parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (OnlineGift) PARSER.parseFrom(data, extensionRegistry);
        }


        public static OnlineGift parseFrom(InputStream input) throws IOException {
            return (OnlineGift) PARSER.parseFrom(input);
        }


        public static OnlineGift parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OnlineGift) PARSER.parseFrom(input, extensionRegistry);
        }


        public static OnlineGift parseDelimitedFrom(InputStream input) throws IOException {
            return (OnlineGift) PARSER.parseDelimitedFrom(input);
        }


        public static OnlineGift parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OnlineGift) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static OnlineGift parseFrom(CodedInputStream input) throws IOException {
            return (OnlineGift) PARSER.parseFrom(input);
        }


        public static OnlineGift parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OnlineGift) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(OnlineGift prototype) {
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
                implements OnlineGiftHandler.OnlineGiftOrBuilder {
            private int bitField0_;


            private int onlineTime_;


            private List<OnlineGiftHandler.GiftInfo> giftList_;


            private RepeatedFieldBuilder<OnlineGiftHandler.GiftInfo, OnlineGiftHandler.GiftInfo.Builder, OnlineGiftHandler.GiftInfoOrBuilder> giftListBuilder_;


            public static final Descriptors.Descriptor getDescriptor() {
                return OnlineGiftHandler.internal_static_pomelo_area_OnlineGift_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return OnlineGiftHandler.internal_static_pomelo_area_OnlineGift_fieldAccessorTable.ensureFieldAccessorsInitialized(OnlineGiftHandler.OnlineGift.class, Builder.class);
            }


            private Builder() {
                this.giftList_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.giftList_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (OnlineGiftHandler.OnlineGift.alwaysUseFieldBuilders) {
                    getGiftListFieldBuilder();
                }
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.onlineTime_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                if (this.giftListBuilder_ == null) {
                    this.giftList_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFD;
                } else {
                    this.giftListBuilder_.clear();
                }
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return OnlineGiftHandler.internal_static_pomelo_area_OnlineGift_descriptor;
            }


            public OnlineGiftHandler.OnlineGift getDefaultInstanceForType() {
                return OnlineGiftHandler.OnlineGift.getDefaultInstance();
            }


            public OnlineGiftHandler.OnlineGift build() {
                OnlineGiftHandler.OnlineGift result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public OnlineGiftHandler.OnlineGift buildPartial() {
                OnlineGiftHandler.OnlineGift result = new OnlineGiftHandler.OnlineGift(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.onlineTime_ = this.onlineTime_;
                if (this.giftListBuilder_ == null) {
                    if ((this.bitField0_ & 0x2) == 2) {
                        this.giftList_ = Collections.unmodifiableList(this.giftList_);
                        this.bitField0_ &= 0xFFFFFFFD;
                    }
                    result.giftList_ = this.giftList_;
                } else {
                    result.giftList_ = this.giftListBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof OnlineGiftHandler.OnlineGift) {
                    return mergeFrom((OnlineGiftHandler.OnlineGift) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(OnlineGiftHandler.OnlineGift other) {
                if (other == OnlineGiftHandler.OnlineGift.getDefaultInstance()) {
                    return this;
                }
                if (other.hasOnlineTime()) {
                    setOnlineTime(other.getOnlineTime());
                }
                if (this.giftListBuilder_ == null) {
                    if (!other.giftList_.isEmpty()) {
                        if (this.giftList_.isEmpty()) {
                            this.giftList_ = other.giftList_;
                            this.bitField0_ &= 0xFFFFFFFD;
                        } else {
                            ensureGiftListIsMutable();
                            this.giftList_.addAll(other.giftList_);
                        }
                        onChanged();
                    }
                } else if (!other.giftList_.isEmpty()) {
                    if (this.giftListBuilder_.isEmpty()) {
                        this.giftListBuilder_.dispose();
                        this.giftListBuilder_ = null;
                        this.giftList_ = other.giftList_;
                        this.bitField0_ &= 0xFFFFFFFD;
                        this.giftListBuilder_ = OnlineGiftHandler.OnlineGift.alwaysUseFieldBuilders ? getGiftListFieldBuilder() : null;
                    } else {
                        this.giftListBuilder_.addAllMessages(other.giftList_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                for (int i = 0; i < getGiftListCount(); i++) {
                    if (!getGiftList(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                OnlineGiftHandler.OnlineGift parsedMessage = null;
                try {
                    parsedMessage = (OnlineGiftHandler.OnlineGift) OnlineGiftHandler.OnlineGift.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (OnlineGiftHandler.OnlineGift) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasOnlineTime() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public int getOnlineTime() {
                return this.onlineTime_;
            }


            public Builder setOnlineTime(int value) {
                this.bitField0_ |= 0x1;
                this.onlineTime_ = value;
                onChanged();
                return this;
            }


            public Builder clearOnlineTime() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.onlineTime_ = 0;
                onChanged();
                return this;
            }


            private void ensureGiftListIsMutable() {
                if ((this.bitField0_ & 0x2) != 2) {
                    this.giftList_ = new ArrayList<>(this.giftList_);
                    this.bitField0_ |= 0x2;
                }
            }


            public List<OnlineGiftHandler.GiftInfo> getGiftListList() {
                if (this.giftListBuilder_ == null) {
                    return Collections.unmodifiableList(this.giftList_);
                }
                return this.giftListBuilder_.getMessageList();
            }


            public int getGiftListCount() {
                if (this.giftListBuilder_ == null) {
                    return this.giftList_.size();
                }
                return this.giftListBuilder_.getCount();
            }


            public OnlineGiftHandler.GiftInfo getGiftList(int index) {
                if (this.giftListBuilder_ == null) {
                    return this.giftList_.get(index);
                }
                return (OnlineGiftHandler.GiftInfo) this.giftListBuilder_.getMessage(index);
            }


            public Builder setGiftList(int index, OnlineGiftHandler.GiftInfo value) {
                if (this.giftListBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureGiftListIsMutable();
                    this.giftList_.set(index, value);
                    onChanged();
                } else {
                    this.giftListBuilder_.setMessage(index, value);
                }
                return this;
            }


            public Builder setGiftList(int index, OnlineGiftHandler.GiftInfo.Builder builderForValue) {
                if (this.giftListBuilder_ == null) {
                    ensureGiftListIsMutable();
                    this.giftList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.giftListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }


            public Builder addGiftList(OnlineGiftHandler.GiftInfo value) {
                if (this.giftListBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureGiftListIsMutable();
                    this.giftList_.add(value);
                    onChanged();
                } else {
                    this.giftListBuilder_.addMessage(value);
                }
                return this;
            }


            public Builder addGiftList(int index, OnlineGiftHandler.GiftInfo value) {
                if (this.giftListBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureGiftListIsMutable();
                    this.giftList_.add(index, value);
                    onChanged();
                } else {
                    this.giftListBuilder_.addMessage(index, value);
                }
                return this;
            }


            public Builder addGiftList(OnlineGiftHandler.GiftInfo.Builder builderForValue) {
                if (this.giftListBuilder_ == null) {
                    ensureGiftListIsMutable();
                    this.giftList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.giftListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }


            public Builder addGiftList(int index, OnlineGiftHandler.GiftInfo.Builder builderForValue) {
                if (this.giftListBuilder_ == null) {
                    ensureGiftListIsMutable();
                    this.giftList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.giftListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }


            public Builder addAllGiftList(Iterable<? extends OnlineGiftHandler.GiftInfo> values) {
                if (this.giftListBuilder_ == null) {
                    ensureGiftListIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.giftList_);
                    onChanged();
                } else {
                    this.giftListBuilder_.addAllMessages(values);
                }
                return this;
            }


            public Builder clearGiftList() {
                if (this.giftListBuilder_ == null) {
                    this.giftList_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFD;
                    onChanged();
                } else {
                    this.giftListBuilder_.clear();
                }
                return this;
            }


            public Builder removeGiftList(int index) {
                if (this.giftListBuilder_ == null) {
                    ensureGiftListIsMutable();
                    this.giftList_.remove(index);
                    onChanged();
                } else {
                    this.giftListBuilder_.remove(index);
                }
                return this;
            }


            public OnlineGiftHandler.GiftInfo.Builder getGiftListBuilder(int index) {
                return (OnlineGiftHandler.GiftInfo.Builder) getGiftListFieldBuilder().getBuilder(index);
            }


            public OnlineGiftHandler.GiftInfoOrBuilder getGiftListOrBuilder(int index) {
                if (this.giftListBuilder_ == null) {
                    return this.giftList_.get(index);
                }
                return (OnlineGiftHandler.GiftInfoOrBuilder) this.giftListBuilder_.getMessageOrBuilder(index);
            }


            public List<? extends OnlineGiftHandler.GiftInfoOrBuilder> getGiftListOrBuilderList() {
                if (this.giftListBuilder_ != null) {
                    return this.giftListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList((List) this.giftList_);
            }


            public OnlineGiftHandler.GiftInfo.Builder addGiftListBuilder() {
                return (OnlineGiftHandler.GiftInfo.Builder) getGiftListFieldBuilder().addBuilder(OnlineGiftHandler.GiftInfo.getDefaultInstance());
            }


            public OnlineGiftHandler.GiftInfo.Builder addGiftListBuilder(int index) {
                return (OnlineGiftHandler.GiftInfo.Builder) getGiftListFieldBuilder().addBuilder(index, OnlineGiftHandler.GiftInfo.getDefaultInstance());
            }


            public List<OnlineGiftHandler.GiftInfo.Builder> getGiftListBuilderList() {
                return getGiftListFieldBuilder().getBuilderList();
            }


            private RepeatedFieldBuilder<OnlineGiftHandler.GiftInfo, OnlineGiftHandler.GiftInfo.Builder, OnlineGiftHandler.GiftInfoOrBuilder> getGiftListFieldBuilder() {
                if (this.giftListBuilder_ == null) {
                    this.giftListBuilder_ = new RepeatedFieldBuilder(this.giftList_, ((this.bitField0_ & 0x2) == 2), getParentForChildren(), isClean());
                    this.giftList_ = null;
                }
                return this.giftListBuilder_;
            }
        }
    }


    public static final class GetGiftInfoResponse
            extends GeneratedMessage
            implements GetGiftInfoResponseOrBuilder {
        private static final GetGiftInfoResponse defaultInstance = new GetGiftInfoResponse(true);
        private final UnknownFieldSet unknownFields;

        private GetGiftInfoResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetGiftInfoResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetGiftInfoResponse getDefaultInstance() {
            return defaultInstance;
        }

        public GetGiftInfoResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetGiftInfoResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString bs;
                    OnlineGiftHandler.OnlineGift.Builder subBuilder;
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
                            if ((this.bitField0_ & 0x4) == 4) subBuilder = this.s2CGift_.toBuilder();
                            this.s2CGift_ = (OnlineGiftHandler.OnlineGift) input.readMessage(OnlineGiftHandler.OnlineGift.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.s2CGift_);
                                this.s2CGift_ = subBuilder.buildPartial();
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
            return OnlineGiftHandler.internal_static_pomelo_area_GetGiftInfoResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return OnlineGiftHandler.internal_static_pomelo_area_GetGiftInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetGiftInfoResponse.class, Builder.class);
        }

        public static Parser<GetGiftInfoResponse> PARSER = (Parser<GetGiftInfoResponse>) new AbstractParser<GetGiftInfoResponse>() {
            public OnlineGiftHandler.GetGiftInfoResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new OnlineGiftHandler.GetGiftInfoResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_GIFT_FIELD_NUMBER = 3;
        private OnlineGiftHandler.OnlineGift s2CGift_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetGiftInfoResponse> getParserForType() {
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


        public boolean hasS2CGift() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public OnlineGiftHandler.OnlineGift getS2CGift() {
            return this.s2CGift_;
        }


        public OnlineGiftHandler.OnlineGiftOrBuilder getS2CGiftOrBuilder() {
            return this.s2CGift_;
        }


        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CGift_ = OnlineGiftHandler.OnlineGift.getDefaultInstance();
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
            if (hasS2CGift() && !getS2CGift().isInitialized()) {
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
                output.writeMessage(3, (MessageLite) this.s2CGift_);
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
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.s2CGift_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static GetGiftInfoResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetGiftInfoResponse) PARSER.parseFrom(data);
        }


        public static GetGiftInfoResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetGiftInfoResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetGiftInfoResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetGiftInfoResponse) PARSER.parseFrom(data);
        }


        public static GetGiftInfoResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetGiftInfoResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetGiftInfoResponse parseFrom(InputStream input) throws IOException {
            return (GetGiftInfoResponse) PARSER.parseFrom(input);
        }


        public static GetGiftInfoResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetGiftInfoResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static GetGiftInfoResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (GetGiftInfoResponse) PARSER.parseDelimitedFrom(input);
        }


        public static GetGiftInfoResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetGiftInfoResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static GetGiftInfoResponse parseFrom(CodedInputStream input) throws IOException {
            return (GetGiftInfoResponse) PARSER.parseFrom(input);
        }


        public static GetGiftInfoResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetGiftInfoResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(GetGiftInfoResponse prototype) {
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
                implements OnlineGiftHandler.GetGiftInfoResponseOrBuilder {
            private int bitField0_;


            private int s2CCode_;


            private Object s2CMsg_;


            private OnlineGiftHandler.OnlineGift s2CGift_;


            private SingleFieldBuilder<OnlineGiftHandler.OnlineGift, OnlineGiftHandler.OnlineGift.Builder, OnlineGiftHandler.OnlineGiftOrBuilder> s2CGiftBuilder_;


            public static final Descriptors.Descriptor getDescriptor() {
                return OnlineGiftHandler.internal_static_pomelo_area_GetGiftInfoResponse_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return OnlineGiftHandler.internal_static_pomelo_area_GetGiftInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(OnlineGiftHandler.GetGiftInfoResponse.class, Builder.class);
            }


            private Builder() {
                this.s2CMsg_ = "";
                this.s2CGift_ = OnlineGiftHandler.OnlineGift.getDefaultInstance();
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CGift_ = OnlineGiftHandler.OnlineGift.getDefaultInstance();
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (OnlineGiftHandler.GetGiftInfoResponse.alwaysUseFieldBuilders) {
                    getS2CGiftFieldBuilder();
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
                if (this.s2CGiftBuilder_ == null) {
                    this.s2CGift_ = OnlineGiftHandler.OnlineGift.getDefaultInstance();
                } else {
                    this.s2CGiftBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return OnlineGiftHandler.internal_static_pomelo_area_GetGiftInfoResponse_descriptor;
            }


            public OnlineGiftHandler.GetGiftInfoResponse getDefaultInstanceForType() {
                return OnlineGiftHandler.GetGiftInfoResponse.getDefaultInstance();
            }


            public OnlineGiftHandler.GetGiftInfoResponse build() {
                OnlineGiftHandler.GetGiftInfoResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public OnlineGiftHandler.GetGiftInfoResponse buildPartial() {
                OnlineGiftHandler.GetGiftInfoResponse result = new OnlineGiftHandler.GetGiftInfoResponse(this);
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
                if (this.s2CGiftBuilder_ == null) {
                    result.s2CGift_ = this.s2CGift_;
                } else {
                    result.s2CGift_ = (OnlineGiftHandler.OnlineGift) this.s2CGiftBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof OnlineGiftHandler.GetGiftInfoResponse) {
                    return mergeFrom((OnlineGiftHandler.GetGiftInfoResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(OnlineGiftHandler.GetGiftInfoResponse other) {
                if (other == OnlineGiftHandler.GetGiftInfoResponse.getDefaultInstance()) {
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
                if (other.hasS2CGift()) {
                    mergeS2CGift(other.getS2CGift());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasS2CCode()) {
                    return false;
                }
                if (hasS2CGift() && !getS2CGift().isInitialized()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                OnlineGiftHandler.GetGiftInfoResponse parsedMessage = null;
                try {
                    parsedMessage = (OnlineGiftHandler.GetGiftInfoResponse) OnlineGiftHandler.GetGiftInfoResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (OnlineGiftHandler.GetGiftInfoResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = OnlineGiftHandler.GetGiftInfoResponse.getDefaultInstance().getS2CMsg();
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


            public boolean hasS2CGift() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public OnlineGiftHandler.OnlineGift getS2CGift() {
                if (this.s2CGiftBuilder_ == null) {
                    return this.s2CGift_;
                }
                return (OnlineGiftHandler.OnlineGift) this.s2CGiftBuilder_.getMessage();
            }


            public Builder setS2CGift(OnlineGiftHandler.OnlineGift value) {
                if (this.s2CGiftBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.s2CGift_ = value;
                    onChanged();
                } else {
                    this.s2CGiftBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }


            public Builder setS2CGift(OnlineGiftHandler.OnlineGift.Builder builderForValue) {
                if (this.s2CGiftBuilder_ == null) {
                    this.s2CGift_ = builderForValue.build();
                    onChanged();
                } else {
                    this.s2CGiftBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x4;
                return this;
            }


            public Builder mergeS2CGift(OnlineGiftHandler.OnlineGift value) {
                if (this.s2CGiftBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4 && this.s2CGift_ != OnlineGiftHandler.OnlineGift.getDefaultInstance()) {
                        this.s2CGift_ = OnlineGiftHandler.OnlineGift.newBuilder(this.s2CGift_).mergeFrom(value).buildPartial();
                    } else {
                        this.s2CGift_ = value;
                    }
                    onChanged();
                } else {
                    this.s2CGiftBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }


            public Builder clearS2CGift() {
                if (this.s2CGiftBuilder_ == null) {
                    this.s2CGift_ = OnlineGiftHandler.OnlineGift.getDefaultInstance();
                    onChanged();
                } else {
                    this.s2CGiftBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }


            public OnlineGiftHandler.OnlineGift.Builder getS2CGiftBuilder() {
                this.bitField0_ |= 0x4;
                onChanged();
                return (OnlineGiftHandler.OnlineGift.Builder) getS2CGiftFieldBuilder().getBuilder();
            }


            public OnlineGiftHandler.OnlineGiftOrBuilder getS2CGiftOrBuilder() {
                if (this.s2CGiftBuilder_ != null) {
                    return (OnlineGiftHandler.OnlineGiftOrBuilder) this.s2CGiftBuilder_.getMessageOrBuilder();
                }
                return this.s2CGift_;
            }


            private SingleFieldBuilder<OnlineGiftHandler.OnlineGift, OnlineGiftHandler.OnlineGift.Builder, OnlineGiftHandler.OnlineGiftOrBuilder> getS2CGiftFieldBuilder() {
                if (this.s2CGiftBuilder_ == null) {
                    this.s2CGiftBuilder_ = new SingleFieldBuilder(getS2CGift(), getParentForChildren(), isClean());
                    this.s2CGift_ = null;
                }
                return this.s2CGiftBuilder_;
            }
        }
    }


    public static final class GetOnlineTimeResponse
            extends GeneratedMessage
            implements GetOnlineTimeResponseOrBuilder {
        private static final GetOnlineTimeResponse defaultInstance = new GetOnlineTimeResponse(true);
        private final UnknownFieldSet unknownFields;

        private GetOnlineTimeResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetOnlineTimeResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetOnlineTimeResponse getDefaultInstance() {
            return defaultInstance;
        }

        public GetOnlineTimeResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetOnlineTimeResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.s2COnlineTime_ = input.readInt32();
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
            return OnlineGiftHandler.internal_static_pomelo_area_GetOnlineTimeResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return OnlineGiftHandler.internal_static_pomelo_area_GetOnlineTimeResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetOnlineTimeResponse.class, Builder.class);
        }

        public static Parser<GetOnlineTimeResponse> PARSER = (Parser<GetOnlineTimeResponse>) new AbstractParser<GetOnlineTimeResponse>() {
            public OnlineGiftHandler.GetOnlineTimeResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new OnlineGiftHandler.GetOnlineTimeResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_ONLINETIME_FIELD_NUMBER = 3;
        private int s2COnlineTime_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetOnlineTimeResponse> getParserForType() {
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


        public boolean hasS2COnlineTime() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public int getS2COnlineTime() {
            return this.s2COnlineTime_;
        }


        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2COnlineTime_ = 0;
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
                output.writeInt32(3, this.s2COnlineTime_);
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
                size += CodedOutputStream.computeInt32Size(3, this.s2COnlineTime_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static GetOnlineTimeResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetOnlineTimeResponse) PARSER.parseFrom(data);
        }


        public static GetOnlineTimeResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetOnlineTimeResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetOnlineTimeResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetOnlineTimeResponse) PARSER.parseFrom(data);
        }


        public static GetOnlineTimeResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetOnlineTimeResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetOnlineTimeResponse parseFrom(InputStream input) throws IOException {
            return (GetOnlineTimeResponse) PARSER.parseFrom(input);
        }


        public static GetOnlineTimeResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetOnlineTimeResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static GetOnlineTimeResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (GetOnlineTimeResponse) PARSER.parseDelimitedFrom(input);
        }


        public static GetOnlineTimeResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetOnlineTimeResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static GetOnlineTimeResponse parseFrom(CodedInputStream input) throws IOException {
            return (GetOnlineTimeResponse) PARSER.parseFrom(input);
        }


        public static GetOnlineTimeResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetOnlineTimeResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(GetOnlineTimeResponse prototype) {
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
                implements OnlineGiftHandler.GetOnlineTimeResponseOrBuilder {
            private int bitField0_;


            private int s2CCode_;


            private Object s2CMsg_;


            private int s2COnlineTime_;


            public static final Descriptors.Descriptor getDescriptor() {
                return OnlineGiftHandler.internal_static_pomelo_area_GetOnlineTimeResponse_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return OnlineGiftHandler.internal_static_pomelo_area_GetOnlineTimeResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(OnlineGiftHandler.GetOnlineTimeResponse.class, Builder.class);
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
                if (OnlineGiftHandler.GetOnlineTimeResponse.alwaysUseFieldBuilders) ;
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
                this.s2COnlineTime_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return OnlineGiftHandler.internal_static_pomelo_area_GetOnlineTimeResponse_descriptor;
            }


            public OnlineGiftHandler.GetOnlineTimeResponse getDefaultInstanceForType() {
                return OnlineGiftHandler.GetOnlineTimeResponse.getDefaultInstance();
            }


            public OnlineGiftHandler.GetOnlineTimeResponse build() {
                OnlineGiftHandler.GetOnlineTimeResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public OnlineGiftHandler.GetOnlineTimeResponse buildPartial() {
                OnlineGiftHandler.GetOnlineTimeResponse result = new OnlineGiftHandler.GetOnlineTimeResponse(this);
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
                result.s2COnlineTime_ = this.s2COnlineTime_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof OnlineGiftHandler.GetOnlineTimeResponse) {
                    return mergeFrom((OnlineGiftHandler.GetOnlineTimeResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(OnlineGiftHandler.GetOnlineTimeResponse other) {
                if (other == OnlineGiftHandler.GetOnlineTimeResponse.getDefaultInstance()) {
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
                if (other.hasS2COnlineTime()) {
                    setS2COnlineTime(other.getS2COnlineTime());
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
                OnlineGiftHandler.GetOnlineTimeResponse parsedMessage = null;
                try {
                    parsedMessage = (OnlineGiftHandler.GetOnlineTimeResponse) OnlineGiftHandler.GetOnlineTimeResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (OnlineGiftHandler.GetOnlineTimeResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = OnlineGiftHandler.GetOnlineTimeResponse.getDefaultInstance().getS2CMsg();
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


            public boolean hasS2COnlineTime() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public int getS2COnlineTime() {
                return this.s2COnlineTime_;
            }


            public Builder setS2COnlineTime(int value) {
                this.bitField0_ |= 0x4;
                this.s2COnlineTime_ = value;
                onChanged();
                return this;
            }


            public Builder clearS2COnlineTime() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.s2COnlineTime_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class ReceiveGiftResponse
            extends GeneratedMessage
            implements ReceiveGiftResponseOrBuilder {
        private static final ReceiveGiftResponse defaultInstance = new ReceiveGiftResponse(true);
        private final UnknownFieldSet unknownFields;

        private ReceiveGiftResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private ReceiveGiftResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static ReceiveGiftResponse getDefaultInstance() {
            return defaultInstance;
        }

        public ReceiveGiftResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ReceiveGiftResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString bs;
                    OnlineGiftHandler.OnlineGift.Builder subBuilder;
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
                            if ((this.bitField0_ & 0x4) == 4) subBuilder = this.s2CGift_.toBuilder();
                            this.s2CGift_ = (OnlineGiftHandler.OnlineGift) input.readMessage(OnlineGiftHandler.OnlineGift.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.s2CGift_);
                                this.s2CGift_ = subBuilder.buildPartial();
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
            return OnlineGiftHandler.internal_static_pomelo_area_ReceiveGiftResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return OnlineGiftHandler.internal_static_pomelo_area_ReceiveGiftResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ReceiveGiftResponse.class, Builder.class);
        }

        public static Parser<ReceiveGiftResponse> PARSER = (Parser<ReceiveGiftResponse>) new AbstractParser<ReceiveGiftResponse>() {
            public OnlineGiftHandler.ReceiveGiftResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new OnlineGiftHandler.ReceiveGiftResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_GIFT_FIELD_NUMBER = 3;
        private OnlineGiftHandler.OnlineGift s2CGift_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<ReceiveGiftResponse> getParserForType() {
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


        public boolean hasS2CGift() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public OnlineGiftHandler.OnlineGift getS2CGift() {
            return this.s2CGift_;
        }


        public OnlineGiftHandler.OnlineGiftOrBuilder getS2CGiftOrBuilder() {
            return this.s2CGift_;
        }


        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CGift_ = OnlineGiftHandler.OnlineGift.getDefaultInstance();
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
            if (hasS2CGift() && !getS2CGift().isInitialized()) {
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
                output.writeMessage(3, (MessageLite) this.s2CGift_);
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
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.s2CGift_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static ReceiveGiftResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ReceiveGiftResponse) PARSER.parseFrom(data);
        }


        public static ReceiveGiftResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ReceiveGiftResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static ReceiveGiftResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ReceiveGiftResponse) PARSER.parseFrom(data);
        }


        public static ReceiveGiftResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ReceiveGiftResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static ReceiveGiftResponse parseFrom(InputStream input) throws IOException {
            return (ReceiveGiftResponse) PARSER.parseFrom(input);
        }


        public static ReceiveGiftResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReceiveGiftResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static ReceiveGiftResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (ReceiveGiftResponse) PARSER.parseDelimitedFrom(input);
        }


        public static ReceiveGiftResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReceiveGiftResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static ReceiveGiftResponse parseFrom(CodedInputStream input) throws IOException {
            return (ReceiveGiftResponse) PARSER.parseFrom(input);
        }


        public static ReceiveGiftResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReceiveGiftResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(ReceiveGiftResponse prototype) {
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
                implements OnlineGiftHandler.ReceiveGiftResponseOrBuilder {
            private int bitField0_;


            private int s2CCode_;


            private Object s2CMsg_;


            private OnlineGiftHandler.OnlineGift s2CGift_;


            private SingleFieldBuilder<OnlineGiftHandler.OnlineGift, OnlineGiftHandler.OnlineGift.Builder, OnlineGiftHandler.OnlineGiftOrBuilder> s2CGiftBuilder_;


            public static final Descriptors.Descriptor getDescriptor() {
                return OnlineGiftHandler.internal_static_pomelo_area_ReceiveGiftResponse_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return OnlineGiftHandler.internal_static_pomelo_area_ReceiveGiftResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(OnlineGiftHandler.ReceiveGiftResponse.class, Builder.class);
            }


            private Builder() {
                this.s2CMsg_ = "";
                this.s2CGift_ = OnlineGiftHandler.OnlineGift.getDefaultInstance();
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CGift_ = OnlineGiftHandler.OnlineGift.getDefaultInstance();
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (OnlineGiftHandler.ReceiveGiftResponse.alwaysUseFieldBuilders) {
                    getS2CGiftFieldBuilder();
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
                if (this.s2CGiftBuilder_ == null) {
                    this.s2CGift_ = OnlineGiftHandler.OnlineGift.getDefaultInstance();
                } else {
                    this.s2CGiftBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return OnlineGiftHandler.internal_static_pomelo_area_ReceiveGiftResponse_descriptor;
            }


            public OnlineGiftHandler.ReceiveGiftResponse getDefaultInstanceForType() {
                return OnlineGiftHandler.ReceiveGiftResponse.getDefaultInstance();
            }


            public OnlineGiftHandler.ReceiveGiftResponse build() {
                OnlineGiftHandler.ReceiveGiftResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public OnlineGiftHandler.ReceiveGiftResponse buildPartial() {
                OnlineGiftHandler.ReceiveGiftResponse result = new OnlineGiftHandler.ReceiveGiftResponse(this);
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
                if (this.s2CGiftBuilder_ == null) {
                    result.s2CGift_ = this.s2CGift_;
                } else {
                    result.s2CGift_ = (OnlineGiftHandler.OnlineGift) this.s2CGiftBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof OnlineGiftHandler.ReceiveGiftResponse) {
                    return mergeFrom((OnlineGiftHandler.ReceiveGiftResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(OnlineGiftHandler.ReceiveGiftResponse other) {
                if (other == OnlineGiftHandler.ReceiveGiftResponse.getDefaultInstance()) {
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
                if (other.hasS2CGift()) {
                    mergeS2CGift(other.getS2CGift());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasS2CCode()) {
                    return false;
                }
                if (hasS2CGift() && !getS2CGift().isInitialized()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                OnlineGiftHandler.ReceiveGiftResponse parsedMessage = null;
                try {
                    parsedMessage = (OnlineGiftHandler.ReceiveGiftResponse) OnlineGiftHandler.ReceiveGiftResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (OnlineGiftHandler.ReceiveGiftResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = OnlineGiftHandler.ReceiveGiftResponse.getDefaultInstance().getS2CMsg();
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


            public boolean hasS2CGift() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public OnlineGiftHandler.OnlineGift getS2CGift() {
                if (this.s2CGiftBuilder_ == null) {
                    return this.s2CGift_;
                }
                return (OnlineGiftHandler.OnlineGift) this.s2CGiftBuilder_.getMessage();
            }


            public Builder setS2CGift(OnlineGiftHandler.OnlineGift value) {
                if (this.s2CGiftBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.s2CGift_ = value;
                    onChanged();
                } else {
                    this.s2CGiftBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }


            public Builder setS2CGift(OnlineGiftHandler.OnlineGift.Builder builderForValue) {
                if (this.s2CGiftBuilder_ == null) {
                    this.s2CGift_ = builderForValue.build();
                    onChanged();
                } else {
                    this.s2CGiftBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x4;
                return this;
            }


            public Builder mergeS2CGift(OnlineGiftHandler.OnlineGift value) {
                if (this.s2CGiftBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4 && this.s2CGift_ != OnlineGiftHandler.OnlineGift.getDefaultInstance()) {
                        this.s2CGift_ = OnlineGiftHandler.OnlineGift.newBuilder(this.s2CGift_).mergeFrom(value).buildPartial();
                    } else {
                        this.s2CGift_ = value;
                    }
                    onChanged();
                } else {
                    this.s2CGiftBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }


            public Builder clearS2CGift() {
                if (this.s2CGiftBuilder_ == null) {
                    this.s2CGift_ = OnlineGiftHandler.OnlineGift.getDefaultInstance();
                    onChanged();
                } else {
                    this.s2CGiftBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }


            public OnlineGiftHandler.OnlineGift.Builder getS2CGiftBuilder() {
                this.bitField0_ |= 0x4;
                onChanged();
                return (OnlineGiftHandler.OnlineGift.Builder) getS2CGiftFieldBuilder().getBuilder();
            }


            public OnlineGiftHandler.OnlineGiftOrBuilder getS2CGiftOrBuilder() {
                if (this.s2CGiftBuilder_ != null) {
                    return (OnlineGiftHandler.OnlineGiftOrBuilder) this.s2CGiftBuilder_.getMessageOrBuilder();
                }
                return this.s2CGift_;
            }


            private SingleFieldBuilder<OnlineGiftHandler.OnlineGift, OnlineGiftHandler.OnlineGift.Builder, OnlineGiftHandler.OnlineGiftOrBuilder> getS2CGiftFieldBuilder() {
                if (this.s2CGiftBuilder_ == null) {
                    this.s2CGiftBuilder_ = new SingleFieldBuilder(getS2CGift(), getParentForChildren(), isClean());
                    this.s2CGift_ = null;
                }
                return this.s2CGiftBuilder_;
            }
        }
    }


    public static final class GiftInfoPush
            extends GeneratedMessage
            implements GiftInfoPushOrBuilder {
        private static final GiftInfoPush defaultInstance = new GiftInfoPush(true);
        private final UnknownFieldSet unknownFields;

        private GiftInfoPush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GiftInfoPush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GiftInfoPush getDefaultInstance() {
            return defaultInstance;
        }

        public GiftInfoPush getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GiftInfoPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString bs;
                    OnlineGiftHandler.OnlineGift.Builder subBuilder;
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
                            if ((this.bitField0_ & 0x4) == 4) subBuilder = this.s2CGift_.toBuilder();
                            this.s2CGift_ = (OnlineGiftHandler.OnlineGift) input.readMessage(OnlineGiftHandler.OnlineGift.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.s2CGift_);
                                this.s2CGift_ = subBuilder.buildPartial();
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
            return OnlineGiftHandler.internal_static_pomelo_area_GiftInfoPush_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return OnlineGiftHandler.internal_static_pomelo_area_GiftInfoPush_fieldAccessorTable.ensureFieldAccessorsInitialized(GiftInfoPush.class, Builder.class);
        }

        public static Parser<GiftInfoPush> PARSER = (Parser<GiftInfoPush>) new AbstractParser<GiftInfoPush>() {
            public OnlineGiftHandler.GiftInfoPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new OnlineGiftHandler.GiftInfoPush(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_GIFT_FIELD_NUMBER = 3;
        private OnlineGiftHandler.OnlineGift s2CGift_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GiftInfoPush> getParserForType() {
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

        public boolean hasS2CGift() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public OnlineGiftHandler.OnlineGift getS2CGift() {
            return this.s2CGift_;
        }

        public OnlineGiftHandler.OnlineGiftOrBuilder getS2CGiftOrBuilder() {
            return this.s2CGift_;
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CGift_ = OnlineGiftHandler.OnlineGift.getDefaultInstance();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasS2CCode()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (hasS2CGift() && !getS2CGift().isInitialized()) {
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
            if ((this.bitField0_ & 0x4) == 4) output.writeMessage(3, (MessageLite) this.s2CGift_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());
            if ((this.bitField0_ & 0x4) == 4)
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.s2CGift_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static GiftInfoPush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GiftInfoPush) PARSER.parseFrom(data);
        }

        public static GiftInfoPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GiftInfoPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GiftInfoPush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GiftInfoPush) PARSER.parseFrom(data);
        }

        public static GiftInfoPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GiftInfoPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GiftInfoPush parseFrom(InputStream input) throws IOException {
            return (GiftInfoPush) PARSER.parseFrom(input);
        }

        public static GiftInfoPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GiftInfoPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static GiftInfoPush parseDelimitedFrom(InputStream input) throws IOException {
            return (GiftInfoPush) PARSER.parseDelimitedFrom(input);
        }

        public static GiftInfoPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GiftInfoPush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static GiftInfoPush parseFrom(CodedInputStream input) throws IOException {
            return (GiftInfoPush) PARSER.parseFrom(input);
        }

        public static GiftInfoPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GiftInfoPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(GiftInfoPush prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        static {
            defaultInstance.initFields();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements OnlineGiftHandler.GiftInfoPushOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private OnlineGiftHandler.OnlineGift s2CGift_;
            private SingleFieldBuilder<OnlineGiftHandler.OnlineGift, OnlineGiftHandler.OnlineGift.Builder, OnlineGiftHandler.OnlineGiftOrBuilder> s2CGiftBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return OnlineGiftHandler.internal_static_pomelo_area_GiftInfoPush_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return OnlineGiftHandler.internal_static_pomelo_area_GiftInfoPush_fieldAccessorTable.ensureFieldAccessorsInitialized(OnlineGiftHandler.GiftInfoPush.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.s2CGift_ = OnlineGiftHandler.OnlineGift.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CGift_ = OnlineGiftHandler.OnlineGift.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (OnlineGiftHandler.GiftInfoPush.alwaysUseFieldBuilders) getS2CGiftFieldBuilder();
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
                if (this.s2CGiftBuilder_ == null) {
                    this.s2CGift_ = OnlineGiftHandler.OnlineGift.getDefaultInstance();
                } else {
                    this.s2CGiftBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return OnlineGiftHandler.internal_static_pomelo_area_GiftInfoPush_descriptor;
            }

            public OnlineGiftHandler.GiftInfoPush getDefaultInstanceForType() {
                return OnlineGiftHandler.GiftInfoPush.getDefaultInstance();
            }

            public OnlineGiftHandler.GiftInfoPush build() {
                OnlineGiftHandler.GiftInfoPush result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public OnlineGiftHandler.GiftInfoPush buildPartial() {
                OnlineGiftHandler.GiftInfoPush result = new OnlineGiftHandler.GiftInfoPush(this);
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
                if (this.s2CGiftBuilder_ == null) {
                    result.s2CGift_ = this.s2CGift_;
                } else {
                    result.s2CGift_ = (OnlineGiftHandler.OnlineGift) this.s2CGiftBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof OnlineGiftHandler.GiftInfoPush)
                    return mergeFrom((OnlineGiftHandler.GiftInfoPush) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(OnlineGiftHandler.GiftInfoPush other) {
                if (other == OnlineGiftHandler.GiftInfoPush.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (other.hasS2CGift())
                    mergeS2CGift(other.getS2CGift());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode())
                    return false;
                if (hasS2CGift() && !getS2CGift().isInitialized())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                OnlineGiftHandler.GiftInfoPush parsedMessage = null;
                try {
                    parsedMessage = (OnlineGiftHandler.GiftInfoPush) OnlineGiftHandler.GiftInfoPush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (OnlineGiftHandler.GiftInfoPush) e.getUnfinishedMessage();
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
                this.s2CMsg_ = OnlineGiftHandler.GiftInfoPush.getDefaultInstance().getS2CMsg();
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

            public boolean hasS2CGift() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public OnlineGiftHandler.OnlineGift getS2CGift() {
                if (this.s2CGiftBuilder_ == null)
                    return this.s2CGift_;
                return (OnlineGiftHandler.OnlineGift) this.s2CGiftBuilder_.getMessage();
            }

            public Builder setS2CGift(OnlineGiftHandler.OnlineGift value) {
                if (this.s2CGiftBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    this.s2CGift_ = value;
                    onChanged();
                } else {
                    this.s2CGiftBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder setS2CGift(OnlineGiftHandler.OnlineGift.Builder builderForValue) {
                if (this.s2CGiftBuilder_ == null) {
                    this.s2CGift_ = builderForValue.build();
                    onChanged();
                } else {
                    this.s2CGiftBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder mergeS2CGift(OnlineGiftHandler.OnlineGift value) {
                if (this.s2CGiftBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4 && this.s2CGift_ != OnlineGiftHandler.OnlineGift.getDefaultInstance()) {
                        this.s2CGift_ = OnlineGiftHandler.OnlineGift.newBuilder(this.s2CGift_).mergeFrom(value).buildPartial();
                    } else {
                        this.s2CGift_ = value;
                    }
                    onChanged();
                } else {
                    this.s2CGiftBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder clearS2CGift() {
                if (this.s2CGiftBuilder_ == null) {
                    this.s2CGift_ = OnlineGiftHandler.OnlineGift.getDefaultInstance();
                    onChanged();
                } else {
                    this.s2CGiftBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public OnlineGiftHandler.OnlineGift.Builder getS2CGiftBuilder() {
                this.bitField0_ |= 0x4;
                onChanged();
                return (OnlineGiftHandler.OnlineGift.Builder) getS2CGiftFieldBuilder().getBuilder();
            }

            public OnlineGiftHandler.OnlineGiftOrBuilder getS2CGiftOrBuilder() {
                if (this.s2CGiftBuilder_ != null)
                    return (OnlineGiftHandler.OnlineGiftOrBuilder) this.s2CGiftBuilder_.getMessageOrBuilder();
                return this.s2CGift_;
            }

            private SingleFieldBuilder<OnlineGiftHandler.OnlineGift, OnlineGiftHandler.OnlineGift.Builder, OnlineGiftHandler.OnlineGiftOrBuilder> getS2CGiftFieldBuilder() {
                if (this.s2CGiftBuilder_ == null) {
                    this.s2CGiftBuilder_ = new SingleFieldBuilder(getS2CGift(), getParentForChildren(), isClean());
                    this.s2CGift_ = null;
                }
                return this.s2CGiftBuilder_;
            }
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }


    static {
        String[] descriptorData = {"\n\027onlineGiftHandler.proto\022\013pomelo.area\032\fcommon.proto\032\nitem.proto\"\024\n\022GetGiftInfoRequest\"\026\n\024GetOnlineTimeRequest\"$\n\022ReceiveGiftRequest\022\016\n\006c2s_id\030\001 \001(\005\"f\n\bGiftInfo\022\n\n\002id\030\001 \001(\005\022\f\n\004time\030\002 \001(\005\022\f\n\004name\030\003 \001(\t\022\r\n\005state\030\004 \001(\005\022#\n\004item\030\005 \003(\0132\025.pomelo.item.MiniItem\"I\n\nOnlineGift\022\022\n\nonlineTime\030\001 \001(\005\022'\n\bgiftList\030\002 \003(\0132\025.pomelo.area.GiftInfo\"c\n\023GetGiftInfoResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022)\n\bs2c_gift\030\003 ", "\001(\0132\027.pomelo.area.OnlineGift\"R\n\025GetOnlineTimeResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\026\n\016s2c_onlineTime\030\003 \001(\005\"c\n\023ReceiveGiftResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022)\n\bs2c_gift\030\003 \001(\0132\027.pomelo.area.OnlineGift\"\\\n\fGiftInfoPush\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022)\n\bs2c_gift\030\003 \001(\0132\027.pomelo.area.OnlineGift2¤\002\n\021onlineGiftHandler\022W\n\022getGiftInfoRequest\022\037.pomelo.area.GetGiftInfoRequest\032 .pomelo.area.G", "etGiftInfoResponse\022]\n\024getOnlineTimeRequest\022!.pomelo.area.GetOnlineTimeRequest\032\".pomelo.area.GetOnlineTimeResponse\022W\n\022receiveGiftRequest\022\037.pomelo.area.ReceiveGiftRequest\032 .pomelo.area.ReceiveGiftResponse2I\n\016onlineGiftPush\0227\n\fgiftInfoPush\022\031.pomelo.area.GiftInfoPush\032\f.pomelo.Void"};


        Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root) {
                OnlineGiftHandler.descriptor = root;
                return null;
            }
        };

        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[]{

                Common.getDescriptor(),
                ItemOuterClass.getDescriptor()}, assigner);
    }

    private static final Descriptors.Descriptor internal_static_pomelo_area_GetGiftInfoRequest_descriptor = getDescriptor().getMessageTypes().get(0);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetGiftInfoRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetGiftInfoRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetOnlineTimeRequest_descriptor = getDescriptor().getMessageTypes().get(1);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetOnlineTimeRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetOnlineTimeRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_area_ReceiveGiftRequest_descriptor = getDescriptor().getMessageTypes().get(2);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ReceiveGiftRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ReceiveGiftRequest_descriptor, new String[]{"C2SId"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GiftInfo_descriptor = getDescriptor().getMessageTypes().get(3);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GiftInfo_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GiftInfo_descriptor, new String[]{"Id", "Time", "Name", "State", "Item"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_OnlineGift_descriptor = getDescriptor().getMessageTypes().get(4);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_OnlineGift_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_OnlineGift_descriptor, new String[]{"OnlineTime", "GiftList"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetGiftInfoResponse_descriptor = getDescriptor().getMessageTypes().get(5);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetGiftInfoResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetGiftInfoResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CGift"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetOnlineTimeResponse_descriptor = getDescriptor().getMessageTypes().get(6);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetOnlineTimeResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetOnlineTimeResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2COnlineTime"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_ReceiveGiftResponse_descriptor = getDescriptor().getMessageTypes().get(7);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ReceiveGiftResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ReceiveGiftResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CGift"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GiftInfoPush_descriptor = getDescriptor().getMessageTypes().get(8);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GiftInfoPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GiftInfoPush_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CGift"});
    private static Descriptors.FileDescriptor descriptor;

    static {
        Common.getDescriptor();
        ItemOuterClass.getDescriptor();
    }

    public static interface GiftInfoPushOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasS2CGift();

        OnlineGiftHandler.OnlineGift getS2CGift();

        OnlineGiftHandler.OnlineGiftOrBuilder getS2CGiftOrBuilder();
    }

    public static interface ReceiveGiftResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasS2CGift();

        OnlineGiftHandler.OnlineGift getS2CGift();

        OnlineGiftHandler.OnlineGiftOrBuilder getS2CGiftOrBuilder();
    }

    public static interface GetOnlineTimeResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasS2COnlineTime();

        int getS2COnlineTime();
    }

    public static interface GetGiftInfoResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasS2CGift();

        OnlineGiftHandler.OnlineGift getS2CGift();

        OnlineGiftHandler.OnlineGiftOrBuilder getS2CGiftOrBuilder();
    }

    public static interface OnlineGiftOrBuilder extends MessageOrBuilder {
        boolean hasOnlineTime();

        int getOnlineTime();

        List<OnlineGiftHandler.GiftInfo> getGiftListList();

        OnlineGiftHandler.GiftInfo getGiftList(int param1Int);

        int getGiftListCount();

        List<? extends OnlineGiftHandler.GiftInfoOrBuilder> getGiftListOrBuilderList();

        OnlineGiftHandler.GiftInfoOrBuilder getGiftListOrBuilder(int param1Int);
    }

    public static interface GiftInfoOrBuilder extends MessageOrBuilder {
        boolean hasId();

        int getId();

        boolean hasTime();

        int getTime();

        boolean hasName();

        String getName();

        ByteString getNameBytes();

        boolean hasState();

        int getState();

        List<ItemOuterClass.MiniItem> getItemList();

        ItemOuterClass.MiniItem getItem(int param1Int);

        int getItemCount();

        List<? extends ItemOuterClass.MiniItemOrBuilder> getItemOrBuilderList();

        ItemOuterClass.MiniItemOrBuilder getItemOrBuilder(int param1Int);
    }

    public static interface ReceiveGiftRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2SId();

        int getC2SId();
    }

    public static interface GetOnlineTimeRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface GetGiftInfoRequestOrBuilder extends MessageOrBuilder {
    }
}


