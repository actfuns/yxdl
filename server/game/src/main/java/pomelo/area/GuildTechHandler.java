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


public final class GuildTechHandler {
    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static final class GetGuildTechInfoRequest
            extends GeneratedMessage
            implements GetGuildTechInfoRequestOrBuilder {
        private static final GetGuildTechInfoRequest defaultInstance = new GetGuildTechInfoRequest(true);
        private final UnknownFieldSet unknownFields;

        private GetGuildTechInfoRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetGuildTechInfoRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetGuildTechInfoRequest getDefaultInstance() {
            return defaultInstance;
        }

        public GetGuildTechInfoRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetGuildTechInfoRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return GuildTechHandler.internal_static_pomelo_area_GetGuildTechInfoRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return GuildTechHandler.internal_static_pomelo_area_GetGuildTechInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetGuildTechInfoRequest.class, Builder.class);
        }

        public static Parser<GetGuildTechInfoRequest> PARSER = (Parser<GetGuildTechInfoRequest>) new AbstractParser<GetGuildTechInfoRequest>() {
            public GuildTechHandler.GetGuildTechInfoRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GuildTechHandler.GetGuildTechInfoRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetGuildTechInfoRequest> getParserForType() {
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

        public static GetGuildTechInfoRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetGuildTechInfoRequest) PARSER.parseFrom(data);
        }

        public static GetGuildTechInfoRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetGuildTechInfoRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetGuildTechInfoRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetGuildTechInfoRequest) PARSER.parseFrom(data);
        }

        public static GetGuildTechInfoRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetGuildTechInfoRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetGuildTechInfoRequest parseFrom(InputStream input) throws IOException {
            return (GetGuildTechInfoRequest) PARSER.parseFrom(input);
        }

        public static GetGuildTechInfoRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetGuildTechInfoRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static GetGuildTechInfoRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (GetGuildTechInfoRequest) PARSER.parseDelimitedFrom(input);
        }

        public static GetGuildTechInfoRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetGuildTechInfoRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static GetGuildTechInfoRequest parseFrom(CodedInputStream input) throws IOException {
            return (GetGuildTechInfoRequest) PARSER.parseFrom(input);
        }

        public static GetGuildTechInfoRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetGuildTechInfoRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(GetGuildTechInfoRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements GuildTechHandler.GetGuildTechInfoRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return GuildTechHandler.internal_static_pomelo_area_GetGuildTechInfoRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return GuildTechHandler.internal_static_pomelo_area_GetGuildTechInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildTechHandler.GetGuildTechInfoRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GuildTechHandler.GetGuildTechInfoRequest.alwaysUseFieldBuilders) ;
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
                return GuildTechHandler.internal_static_pomelo_area_GetGuildTechInfoRequest_descriptor;
            }

            public GuildTechHandler.GetGuildTechInfoRequest getDefaultInstanceForType() {
                return GuildTechHandler.GetGuildTechInfoRequest.getDefaultInstance();
            }

            public GuildTechHandler.GetGuildTechInfoRequest build() {
                GuildTechHandler.GetGuildTechInfoRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public GuildTechHandler.GetGuildTechInfoRequest buildPartial() {
                GuildTechHandler.GetGuildTechInfoRequest result = new GuildTechHandler.GetGuildTechInfoRequest(this);
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof GuildTechHandler.GetGuildTechInfoRequest)
                    return mergeFrom((GuildTechHandler.GetGuildTechInfoRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GuildTechHandler.GetGuildTechInfoRequest other) {
                if (other == GuildTechHandler.GetGuildTechInfoRequest.getDefaultInstance()) return this;
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                GuildTechHandler.GetGuildTechInfoRequest parsedMessage = null;
                try {
                    parsedMessage = (GuildTechHandler.GetGuildTechInfoRequest) GuildTechHandler.GetGuildTechInfoRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (GuildTechHandler.GetGuildTechInfoRequest) e.getUnfinishedMessage();
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


    public static final class UpgradeGuildTechRequest
            extends GeneratedMessage
            implements UpgradeGuildTechRequestOrBuilder {
        private static final UpgradeGuildTechRequest defaultInstance = new UpgradeGuildTechRequest(true);
        private final UnknownFieldSet unknownFields;

        private UpgradeGuildTechRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private UpgradeGuildTechRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static UpgradeGuildTechRequest getDefaultInstance() {
            return defaultInstance;
        }

        public UpgradeGuildTechRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private UpgradeGuildTechRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return GuildTechHandler.internal_static_pomelo_area_UpgradeGuildTechRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return GuildTechHandler.internal_static_pomelo_area_UpgradeGuildTechRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(UpgradeGuildTechRequest.class, Builder.class);
        }

        public static Parser<UpgradeGuildTechRequest> PARSER = (Parser<UpgradeGuildTechRequest>) new AbstractParser<UpgradeGuildTechRequest>() {
            public GuildTechHandler.UpgradeGuildTechRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GuildTechHandler.UpgradeGuildTechRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<UpgradeGuildTechRequest> getParserForType() {
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

        public static UpgradeGuildTechRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (UpgradeGuildTechRequest) PARSER.parseFrom(data);
        }

        public static UpgradeGuildTechRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (UpgradeGuildTechRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static UpgradeGuildTechRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (UpgradeGuildTechRequest) PARSER.parseFrom(data);
        }

        public static UpgradeGuildTechRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (UpgradeGuildTechRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static UpgradeGuildTechRequest parseFrom(InputStream input) throws IOException {
            return (UpgradeGuildTechRequest) PARSER.parseFrom(input);
        }

        public static UpgradeGuildTechRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpgradeGuildTechRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static UpgradeGuildTechRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (UpgradeGuildTechRequest) PARSER.parseDelimitedFrom(input);
        }

        public static UpgradeGuildTechRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpgradeGuildTechRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static UpgradeGuildTechRequest parseFrom(CodedInputStream input) throws IOException {
            return (UpgradeGuildTechRequest) PARSER.parseFrom(input);
        }

        public static UpgradeGuildTechRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpgradeGuildTechRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(UpgradeGuildTechRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements GuildTechHandler.UpgradeGuildTechRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return GuildTechHandler.internal_static_pomelo_area_UpgradeGuildTechRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return GuildTechHandler.internal_static_pomelo_area_UpgradeGuildTechRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildTechHandler.UpgradeGuildTechRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GuildTechHandler.UpgradeGuildTechRequest.alwaysUseFieldBuilders) ;
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
                return GuildTechHandler.internal_static_pomelo_area_UpgradeGuildTechRequest_descriptor;
            }

            public GuildTechHandler.UpgradeGuildTechRequest getDefaultInstanceForType() {
                return GuildTechHandler.UpgradeGuildTechRequest.getDefaultInstance();
            }

            public GuildTechHandler.UpgradeGuildTechRequest build() {
                GuildTechHandler.UpgradeGuildTechRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public GuildTechHandler.UpgradeGuildTechRequest buildPartial() {
                GuildTechHandler.UpgradeGuildTechRequest result = new GuildTechHandler.UpgradeGuildTechRequest(this);
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof GuildTechHandler.UpgradeGuildTechRequest)
                    return mergeFrom((GuildTechHandler.UpgradeGuildTechRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GuildTechHandler.UpgradeGuildTechRequest other) {
                if (other == GuildTechHandler.UpgradeGuildTechRequest.getDefaultInstance()) return this;
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                GuildTechHandler.UpgradeGuildTechRequest parsedMessage = null;
                try {
                    parsedMessage = (GuildTechHandler.UpgradeGuildTechRequest) GuildTechHandler.UpgradeGuildTechRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (GuildTechHandler.UpgradeGuildTechRequest) e.getUnfinishedMessage();
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


    public static final class UpgradeGuildBuffRequest
            extends GeneratedMessage
            implements UpgradeGuildBuffRequestOrBuilder {
        private static final UpgradeGuildBuffRequest defaultInstance = new UpgradeGuildBuffRequest(true);
        private final UnknownFieldSet unknownFields;

        private UpgradeGuildBuffRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private UpgradeGuildBuffRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static UpgradeGuildBuffRequest getDefaultInstance() {
            return defaultInstance;
        }

        public UpgradeGuildBuffRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private UpgradeGuildBuffRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return GuildTechHandler.internal_static_pomelo_area_UpgradeGuildBuffRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return GuildTechHandler.internal_static_pomelo_area_UpgradeGuildBuffRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(UpgradeGuildBuffRequest.class, Builder.class);
        }

        public static Parser<UpgradeGuildBuffRequest> PARSER = (Parser<UpgradeGuildBuffRequest>) new AbstractParser<UpgradeGuildBuffRequest>() {
            public GuildTechHandler.UpgradeGuildBuffRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GuildTechHandler.UpgradeGuildBuffRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<UpgradeGuildBuffRequest> getParserForType() {
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

        public static UpgradeGuildBuffRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (UpgradeGuildBuffRequest) PARSER.parseFrom(data);
        }

        public static UpgradeGuildBuffRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (UpgradeGuildBuffRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static UpgradeGuildBuffRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (UpgradeGuildBuffRequest) PARSER.parseFrom(data);
        }

        public static UpgradeGuildBuffRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (UpgradeGuildBuffRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static UpgradeGuildBuffRequest parseFrom(InputStream input) throws IOException {
            return (UpgradeGuildBuffRequest) PARSER.parseFrom(input);
        }

        public static UpgradeGuildBuffRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpgradeGuildBuffRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static UpgradeGuildBuffRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (UpgradeGuildBuffRequest) PARSER.parseDelimitedFrom(input);
        }

        public static UpgradeGuildBuffRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpgradeGuildBuffRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static UpgradeGuildBuffRequest parseFrom(CodedInputStream input) throws IOException {
            return (UpgradeGuildBuffRequest) PARSER.parseFrom(input);
        }

        public static UpgradeGuildBuffRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpgradeGuildBuffRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(UpgradeGuildBuffRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements GuildTechHandler.UpgradeGuildBuffRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return GuildTechHandler.internal_static_pomelo_area_UpgradeGuildBuffRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return GuildTechHandler.internal_static_pomelo_area_UpgradeGuildBuffRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildTechHandler.UpgradeGuildBuffRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GuildTechHandler.UpgradeGuildBuffRequest.alwaysUseFieldBuilders) ;
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
                return GuildTechHandler.internal_static_pomelo_area_UpgradeGuildBuffRequest_descriptor;
            }

            public GuildTechHandler.UpgradeGuildBuffRequest getDefaultInstanceForType() {
                return GuildTechHandler.UpgradeGuildBuffRequest.getDefaultInstance();
            }

            public GuildTechHandler.UpgradeGuildBuffRequest build() {
                GuildTechHandler.UpgradeGuildBuffRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public GuildTechHandler.UpgradeGuildBuffRequest buildPartial() {
                GuildTechHandler.UpgradeGuildBuffRequest result = new GuildTechHandler.UpgradeGuildBuffRequest(this);
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof GuildTechHandler.UpgradeGuildBuffRequest)
                    return mergeFrom((GuildTechHandler.UpgradeGuildBuffRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GuildTechHandler.UpgradeGuildBuffRequest other) {
                if (other == GuildTechHandler.UpgradeGuildBuffRequest.getDefaultInstance()) return this;
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                GuildTechHandler.UpgradeGuildBuffRequest parsedMessage = null;
                try {
                    parsedMessage = (GuildTechHandler.UpgradeGuildBuffRequest) GuildTechHandler.UpgradeGuildBuffRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (GuildTechHandler.UpgradeGuildBuffRequest) e.getUnfinishedMessage();
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


    public static final class UpgradeGuildSkillRequest
            extends GeneratedMessage
            implements UpgradeGuildSkillRequestOrBuilder {
        private static final UpgradeGuildSkillRequest defaultInstance = new UpgradeGuildSkillRequest(true);
        private final UnknownFieldSet unknownFields;

        private UpgradeGuildSkillRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private UpgradeGuildSkillRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static UpgradeGuildSkillRequest getDefaultInstance() {
            return defaultInstance;
        }

        public UpgradeGuildSkillRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private UpgradeGuildSkillRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.skillId_ = input.readInt32();
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
            return GuildTechHandler.internal_static_pomelo_area_UpgradeGuildSkillRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return GuildTechHandler.internal_static_pomelo_area_UpgradeGuildSkillRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(UpgradeGuildSkillRequest.class, Builder.class);
        }

        public static Parser<UpgradeGuildSkillRequest> PARSER = (Parser<UpgradeGuildSkillRequest>) new AbstractParser<UpgradeGuildSkillRequest>() {
            public GuildTechHandler.UpgradeGuildSkillRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GuildTechHandler.UpgradeGuildSkillRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int SKILLID_FIELD_NUMBER = 1;
        private int skillId_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<UpgradeGuildSkillRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasSkillId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getSkillId() {
            return this.skillId_;
        }

        private void initFields() {
            this.skillId_ = 0;
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
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.skillId_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.skillId_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static UpgradeGuildSkillRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (UpgradeGuildSkillRequest) PARSER.parseFrom(data);
        }

        public static UpgradeGuildSkillRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (UpgradeGuildSkillRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static UpgradeGuildSkillRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (UpgradeGuildSkillRequest) PARSER.parseFrom(data);
        }

        public static UpgradeGuildSkillRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (UpgradeGuildSkillRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static UpgradeGuildSkillRequest parseFrom(InputStream input) throws IOException {
            return (UpgradeGuildSkillRequest) PARSER.parseFrom(input);
        }

        public static UpgradeGuildSkillRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpgradeGuildSkillRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static UpgradeGuildSkillRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (UpgradeGuildSkillRequest) PARSER.parseDelimitedFrom(input);
        }

        public static UpgradeGuildSkillRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpgradeGuildSkillRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static UpgradeGuildSkillRequest parseFrom(CodedInputStream input) throws IOException {
            return (UpgradeGuildSkillRequest) PARSER.parseFrom(input);
        }

        public static UpgradeGuildSkillRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpgradeGuildSkillRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(UpgradeGuildSkillRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements GuildTechHandler.UpgradeGuildSkillRequestOrBuilder {
            private int bitField0_;
            private int skillId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GuildTechHandler.internal_static_pomelo_area_UpgradeGuildSkillRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return GuildTechHandler.internal_static_pomelo_area_UpgradeGuildSkillRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildTechHandler.UpgradeGuildSkillRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GuildTechHandler.UpgradeGuildSkillRequest.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.skillId_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return GuildTechHandler.internal_static_pomelo_area_UpgradeGuildSkillRequest_descriptor;
            }

            public GuildTechHandler.UpgradeGuildSkillRequest getDefaultInstanceForType() {
                return GuildTechHandler.UpgradeGuildSkillRequest.getDefaultInstance();
            }

            public GuildTechHandler.UpgradeGuildSkillRequest build() {
                GuildTechHandler.UpgradeGuildSkillRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public GuildTechHandler.UpgradeGuildSkillRequest buildPartial() {
                GuildTechHandler.UpgradeGuildSkillRequest result = new GuildTechHandler.UpgradeGuildSkillRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.skillId_ = this.skillId_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof GuildTechHandler.UpgradeGuildSkillRequest)
                    return mergeFrom((GuildTechHandler.UpgradeGuildSkillRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GuildTechHandler.UpgradeGuildSkillRequest other) {
                if (other == GuildTechHandler.UpgradeGuildSkillRequest.getDefaultInstance()) return this;
                if (other.hasSkillId()) setSkillId(other.getSkillId());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                GuildTechHandler.UpgradeGuildSkillRequest parsedMessage = null;
                try {
                    parsedMessage = (GuildTechHandler.UpgradeGuildSkillRequest) GuildTechHandler.UpgradeGuildSkillRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (GuildTechHandler.UpgradeGuildSkillRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasSkillId() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getSkillId() {
                return this.skillId_;
            }

            public Builder setSkillId(int value) {
                this.bitField0_ |= 0x1;
                this.skillId_ = value;
                onChanged();
                return this;
            }

            public Builder clearSkillId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.skillId_ = 0;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class BuyGuildProductRequest
            extends GeneratedMessage
            implements BuyGuildProductRequestOrBuilder {
        private static final BuyGuildProductRequest defaultInstance = new BuyGuildProductRequest(true);
        private final UnknownFieldSet unknownFields;

        private BuyGuildProductRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private BuyGuildProductRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static BuyGuildProductRequest getDefaultInstance() {
            return defaultInstance;
        }

        public BuyGuildProductRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BuyGuildProductRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.productId_ = input.readInt32();
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
            return GuildTechHandler.internal_static_pomelo_area_BuyGuildProductRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return GuildTechHandler.internal_static_pomelo_area_BuyGuildProductRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(BuyGuildProductRequest.class, Builder.class);
        }

        public static Parser<BuyGuildProductRequest> PARSER = (Parser<BuyGuildProductRequest>) new AbstractParser<BuyGuildProductRequest>() {
            public GuildTechHandler.BuyGuildProductRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GuildTechHandler.BuyGuildProductRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int PRODUCTID_FIELD_NUMBER = 1;
        private int productId_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<BuyGuildProductRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasProductId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getProductId() {
            return this.productId_;
        }

        private void initFields() {
            this.productId_ = 0;
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
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.productId_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.productId_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static BuyGuildProductRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (BuyGuildProductRequest) PARSER.parseFrom(data);
        }

        public static BuyGuildProductRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BuyGuildProductRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static BuyGuildProductRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (BuyGuildProductRequest) PARSER.parseFrom(data);
        }

        public static BuyGuildProductRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BuyGuildProductRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static BuyGuildProductRequest parseFrom(InputStream input) throws IOException {
            return (BuyGuildProductRequest) PARSER.parseFrom(input);
        }

        public static BuyGuildProductRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuyGuildProductRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static BuyGuildProductRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (BuyGuildProductRequest) PARSER.parseDelimitedFrom(input);
        }

        public static BuyGuildProductRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuyGuildProductRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static BuyGuildProductRequest parseFrom(CodedInputStream input) throws IOException {
            return (BuyGuildProductRequest) PARSER.parseFrom(input);
        }

        public static BuyGuildProductRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuyGuildProductRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(BuyGuildProductRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements GuildTechHandler.BuyGuildProductRequestOrBuilder {
            private int bitField0_;
            private int productId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GuildTechHandler.internal_static_pomelo_area_BuyGuildProductRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return GuildTechHandler.internal_static_pomelo_area_BuyGuildProductRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildTechHandler.BuyGuildProductRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GuildTechHandler.BuyGuildProductRequest.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.productId_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return GuildTechHandler.internal_static_pomelo_area_BuyGuildProductRequest_descriptor;
            }

            public GuildTechHandler.BuyGuildProductRequest getDefaultInstanceForType() {
                return GuildTechHandler.BuyGuildProductRequest.getDefaultInstance();
            }

            public GuildTechHandler.BuyGuildProductRequest build() {
                GuildTechHandler.BuyGuildProductRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public GuildTechHandler.BuyGuildProductRequest buildPartial() {
                GuildTechHandler.BuyGuildProductRequest result = new GuildTechHandler.BuyGuildProductRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.productId_ = this.productId_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof GuildTechHandler.BuyGuildProductRequest)
                    return mergeFrom((GuildTechHandler.BuyGuildProductRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GuildTechHandler.BuyGuildProductRequest other) {
                if (other == GuildTechHandler.BuyGuildProductRequest.getDefaultInstance()) return this;
                if (other.hasProductId()) setProductId(other.getProductId());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                GuildTechHandler.BuyGuildProductRequest parsedMessage = null;
                try {
                    parsedMessage = (GuildTechHandler.BuyGuildProductRequest) GuildTechHandler.BuyGuildProductRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (GuildTechHandler.BuyGuildProductRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasProductId() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getProductId() {
                return this.productId_;
            }

            public Builder setProductId(int value) {
                this.bitField0_ |= 0x1;
                this.productId_ = value;
                onChanged();
                return this;
            }

            public Builder clearProductId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.productId_ = 0;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class GuildBuff
            extends GeneratedMessage
            implements GuildBuffOrBuilder {
        private static final GuildBuff defaultInstance = new GuildBuff(true);
        private final UnknownFieldSet unknownFields;

        private GuildBuff(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GuildBuff(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GuildBuff getDefaultInstance() {
            return defaultInstance;
        }

        public GuildBuff getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GuildBuff(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.level_ = input.readInt32();
                            break;
                        case 18:
                            if ((mutable_bitField0_ & 0x2) != 2) {
                                this.currentAttrs_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x2;
                            }
                            this.currentAttrs_.add(input.readMessage(Common.AttributeBase.PARSER, extensionRegistry));
                            break;
                        case 26:
                            if ((mutable_bitField0_ & 0x4) != 4) {
                                this.nextAttrs_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x4;
                            }
                            this.nextAttrs_.add(input.readMessage(Common.AttributeBase.PARSER, extensionRegistry));
                            break;
                        case 32:
                            this.bitField0_ |= 0x2;
                            this.needFund_ = input.readInt32();
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x2) == 2)
                    this.currentAttrs_ = Collections.unmodifiableList(this.currentAttrs_);
                if ((mutable_bitField0_ & 0x4) == 4) this.nextAttrs_ = Collections.unmodifiableList(this.nextAttrs_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GuildTechHandler.internal_static_pomelo_area_GuildBuff_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return GuildTechHandler.internal_static_pomelo_area_GuildBuff_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildBuff.class, Builder.class);
        }

        public static Parser<GuildBuff> PARSER = (Parser<GuildBuff>) new AbstractParser<GuildBuff>() {
            public GuildTechHandler.GuildBuff parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GuildTechHandler.GuildBuff(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int LEVEL_FIELD_NUMBER = 1;
        private int level_;
        public static final int CURRENTATTRS_FIELD_NUMBER = 2;
        private List<Common.AttributeBase> currentAttrs_;
        public static final int NEXTATTRS_FIELD_NUMBER = 3;
        private List<Common.AttributeBase> nextAttrs_;
        public static final int NEEDFUND_FIELD_NUMBER = 4;
        private int needFund_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GuildBuff> getParserForType() {
            return PARSER;
        }

        public boolean hasLevel() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getLevel() {
            return this.level_;
        }

        public List<Common.AttributeBase> getCurrentAttrsList() {
            return this.currentAttrs_;
        }

        public List<? extends Common.AttributeBaseOrBuilder> getCurrentAttrsOrBuilderList() {
            return (List) this.currentAttrs_;
        }

        public int getCurrentAttrsCount() {
            return this.currentAttrs_.size();
        }

        public Common.AttributeBase getCurrentAttrs(int index) {
            return this.currentAttrs_.get(index);
        }

        static {
            defaultInstance.initFields();
        }


        public Common.AttributeBaseOrBuilder getCurrentAttrsOrBuilder(int index) {
            return (Common.AttributeBaseOrBuilder) this.currentAttrs_.get(index);
        }


        public List<Common.AttributeBase> getNextAttrsList() {
            return this.nextAttrs_;
        }


        public List<? extends Common.AttributeBaseOrBuilder> getNextAttrsOrBuilderList() {
            return (List) this.nextAttrs_;
        }


        public int getNextAttrsCount() {
            return this.nextAttrs_.size();
        }


        public Common.AttributeBase getNextAttrs(int index) {
            return this.nextAttrs_.get(index);
        }


        public Common.AttributeBaseOrBuilder getNextAttrsOrBuilder(int index) {
            return (Common.AttributeBaseOrBuilder) this.nextAttrs_.get(index);
        }


        public boolean hasNeedFund() {
            return ((this.bitField0_ & 0x2) == 2);
        }


        public int getNeedFund() {
            return this.needFund_;
        }


        private void initFields() {
            this.level_ = 0;
            this.currentAttrs_ = Collections.emptyList();
            this.nextAttrs_ = Collections.emptyList();
            this.needFund_ = 0;
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
            for (i = 0; i < getCurrentAttrsCount(); i++) {
                if (!getCurrentAttrs(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (i = 0; i < getNextAttrsCount(); i++) {
                if (!getNextAttrs(i).isInitialized()) {
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
                output.writeInt32(1, this.level_);
            }
            int i;
            for (i = 0; i < this.currentAttrs_.size(); i++) {
                output.writeMessage(2, (MessageLite) this.currentAttrs_.get(i));
            }
            for (i = 0; i < this.nextAttrs_.size(); i++) {
                output.writeMessage(3, (MessageLite) this.nextAttrs_.get(i));
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeInt32(4, this.needFund_);
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
                size += CodedOutputStream.computeInt32Size(1, this.level_);
            }
            int i;
            for (i = 0; i < this.currentAttrs_.size(); i++) {
                size += CodedOutputStream.computeMessageSize(2, (MessageLite) this.currentAttrs_.get(i));
            }
            for (i = 0; i < this.nextAttrs_.size(); i++) {
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.nextAttrs_.get(i));
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeInt32Size(4, this.needFund_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static GuildBuff parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GuildBuff) PARSER.parseFrom(data);
        }


        public static GuildBuff parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GuildBuff) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GuildBuff parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GuildBuff) PARSER.parseFrom(data);
        }


        public static GuildBuff parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GuildBuff) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GuildBuff parseFrom(InputStream input) throws IOException {
            return (GuildBuff) PARSER.parseFrom(input);
        }


        public static GuildBuff parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GuildBuff) PARSER.parseFrom(input, extensionRegistry);
        }


        public static GuildBuff parseDelimitedFrom(InputStream input) throws IOException {
            return (GuildBuff) PARSER.parseDelimitedFrom(input);
        }


        public static GuildBuff parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GuildBuff) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static GuildBuff parseFrom(CodedInputStream input) throws IOException {
            return (GuildBuff) PARSER.parseFrom(input);
        }


        public static GuildBuff parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GuildBuff) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(GuildBuff prototype) {
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
                implements GuildTechHandler.GuildBuffOrBuilder {
            private int bitField0_;


            private int level_;


            private List<Common.AttributeBase> currentAttrs_;


            private RepeatedFieldBuilder<Common.AttributeBase, Common.AttributeBase.Builder, Common.AttributeBaseOrBuilder> currentAttrsBuilder_;


            private List<Common.AttributeBase> nextAttrs_;


            private RepeatedFieldBuilder<Common.AttributeBase, Common.AttributeBase.Builder, Common.AttributeBaseOrBuilder> nextAttrsBuilder_;


            private int needFund_;


            public static final Descriptors.Descriptor getDescriptor() {
                return GuildTechHandler.internal_static_pomelo_area_GuildBuff_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return GuildTechHandler.internal_static_pomelo_area_GuildBuff_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildTechHandler.GuildBuff.class, Builder.class);
            }


            private Builder() {
                this.currentAttrs_ = Collections.emptyList();
                this.nextAttrs_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.currentAttrs_ = Collections.emptyList();
                this.nextAttrs_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (GuildTechHandler.GuildBuff.alwaysUseFieldBuilders) {
                    getCurrentAttrsFieldBuilder();
                    getNextAttrsFieldBuilder();
                }
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.level_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                if (this.currentAttrsBuilder_ == null) {
                    this.currentAttrs_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFD;
                } else {
                    this.currentAttrsBuilder_.clear();
                }
                if (this.nextAttrsBuilder_ == null) {
                    this.nextAttrs_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                } else {
                    this.nextAttrsBuilder_.clear();
                }
                this.needFund_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return GuildTechHandler.internal_static_pomelo_area_GuildBuff_descriptor;
            }


            public GuildTechHandler.GuildBuff getDefaultInstanceForType() {
                return GuildTechHandler.GuildBuff.getDefaultInstance();
            }


            public GuildTechHandler.GuildBuff build() {
                GuildTechHandler.GuildBuff result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public GuildTechHandler.GuildBuff buildPartial() {
                GuildTechHandler.GuildBuff result = new GuildTechHandler.GuildBuff(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.level_ = this.level_;
                if (this.currentAttrsBuilder_ == null) {
                    if ((this.bitField0_ & 0x2) == 2) {
                        this.currentAttrs_ = Collections.unmodifiableList(this.currentAttrs_);
                        this.bitField0_ &= 0xFFFFFFFD;
                    }
                    result.currentAttrs_ = this.currentAttrs_;
                } else {
                    result.currentAttrs_ = this.currentAttrsBuilder_.build();
                }
                if (this.nextAttrsBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4) {
                        this.nextAttrs_ = Collections.unmodifiableList(this.nextAttrs_);
                        this.bitField0_ &= 0xFFFFFFFB;
                    }
                    result.nextAttrs_ = this.nextAttrs_;
                } else {
                    result.nextAttrs_ = this.nextAttrsBuilder_.build();
                }
                if ((from_bitField0_ & 0x8) == 8) {
                    to_bitField0_ |= 0x2;
                }
                result.needFund_ = this.needFund_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof GuildTechHandler.GuildBuff) {
                    return mergeFrom((GuildTechHandler.GuildBuff) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(GuildTechHandler.GuildBuff other) {
                if (other == GuildTechHandler.GuildBuff.getDefaultInstance()) {
                    return this;
                }
                if (other.hasLevel()) {
                    setLevel(other.getLevel());
                }
                if (this.currentAttrsBuilder_ == null) {
                    if (!other.currentAttrs_.isEmpty()) {
                        if (this.currentAttrs_.isEmpty()) {
                            this.currentAttrs_ = other.currentAttrs_;
                            this.bitField0_ &= 0xFFFFFFFD;
                        } else {
                            ensureCurrentAttrsIsMutable();
                            this.currentAttrs_.addAll(other.currentAttrs_);
                        }
                        onChanged();
                    }
                } else if (!other.currentAttrs_.isEmpty()) {
                    if (this.currentAttrsBuilder_.isEmpty()) {
                        this.currentAttrsBuilder_.dispose();
                        this.currentAttrsBuilder_ = null;
                        this.currentAttrs_ = other.currentAttrs_;
                        this.bitField0_ &= 0xFFFFFFFD;
                        this.currentAttrsBuilder_ = GuildTechHandler.GuildBuff.alwaysUseFieldBuilders ? getCurrentAttrsFieldBuilder() : null;
                    } else {
                        this.currentAttrsBuilder_.addAllMessages(other.currentAttrs_);
                    }
                }
                if (this.nextAttrsBuilder_ == null) {
                    if (!other.nextAttrs_.isEmpty()) {
                        if (this.nextAttrs_.isEmpty()) {
                            this.nextAttrs_ = other.nextAttrs_;
                            this.bitField0_ &= 0xFFFFFFFB;
                        } else {
                            ensureNextAttrsIsMutable();
                            this.nextAttrs_.addAll(other.nextAttrs_);
                        }
                        onChanged();
                    }
                } else if (!other.nextAttrs_.isEmpty()) {
                    if (this.nextAttrsBuilder_.isEmpty()) {
                        this.nextAttrsBuilder_.dispose();
                        this.nextAttrsBuilder_ = null;
                        this.nextAttrs_ = other.nextAttrs_;
                        this.bitField0_ &= 0xFFFFFFFB;
                        this.nextAttrsBuilder_ = GuildTechHandler.GuildBuff.alwaysUseFieldBuilders ? getNextAttrsFieldBuilder() : null;
                    } else {
                        this.nextAttrsBuilder_.addAllMessages(other.nextAttrs_);
                    }
                }
                if (other.hasNeedFund()) {
                    setNeedFund(other.getNeedFund());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                int i;
                for (i = 0; i < getCurrentAttrsCount(); i++) {
                    if (!getCurrentAttrs(i).isInitialized()) {
                        return false;
                    }
                }
                for (i = 0; i < getNextAttrsCount(); i++) {
                    if (!getNextAttrs(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                GuildTechHandler.GuildBuff parsedMessage = null;
                try {
                    parsedMessage = (GuildTechHandler.GuildBuff) GuildTechHandler.GuildBuff.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (GuildTechHandler.GuildBuff) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasLevel() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public int getLevel() {
                return this.level_;
            }


            public Builder setLevel(int value) {
                this.bitField0_ |= 0x1;
                this.level_ = value;
                onChanged();
                return this;
            }


            public Builder clearLevel() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.level_ = 0;
                onChanged();
                return this;
            }


            private void ensureCurrentAttrsIsMutable() {
                if ((this.bitField0_ & 0x2) != 2) {
                    this.currentAttrs_ = new ArrayList<>(this.currentAttrs_);
                    this.bitField0_ |= 0x2;
                }
            }


            public List<Common.AttributeBase> getCurrentAttrsList() {
                if (this.currentAttrsBuilder_ == null) {
                    return Collections.unmodifiableList(this.currentAttrs_);
                }
                return this.currentAttrsBuilder_.getMessageList();
            }


            public int getCurrentAttrsCount() {
                if (this.currentAttrsBuilder_ == null) {
                    return this.currentAttrs_.size();
                }
                return this.currentAttrsBuilder_.getCount();
            }


            public Common.AttributeBase getCurrentAttrs(int index) {
                if (this.currentAttrsBuilder_ == null) {
                    return this.currentAttrs_.get(index);
                }
                return (Common.AttributeBase) this.currentAttrsBuilder_.getMessage(index);
            }


            public Builder setCurrentAttrs(int index, Common.AttributeBase value) {
                if (this.currentAttrsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureCurrentAttrsIsMutable();
                    this.currentAttrs_.set(index, value);
                    onChanged();
                } else {
                    this.currentAttrsBuilder_.setMessage(index, (GeneratedMessage) value);
                }
                return this;
            }


            public Builder setCurrentAttrs(int index, Common.AttributeBase.Builder builderForValue) {
                if (this.currentAttrsBuilder_ == null) {
                    ensureCurrentAttrsIsMutable();
                    this.currentAttrs_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.currentAttrsBuilder_.setMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }


            public Builder addCurrentAttrs(Common.AttributeBase value) {
                if (this.currentAttrsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureCurrentAttrsIsMutable();
                    this.currentAttrs_.add(value);
                    onChanged();
                } else {
                    this.currentAttrsBuilder_.addMessage((GeneratedMessage) value);
                }
                return this;
            }


            public Builder addCurrentAttrs(int index, Common.AttributeBase value) {
                if (this.currentAttrsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureCurrentAttrsIsMutable();
                    this.currentAttrs_.add(index, value);
                    onChanged();
                } else {
                    this.currentAttrsBuilder_.addMessage(index, (GeneratedMessage) value);
                }
                return this;
            }


            public Builder addCurrentAttrs(Common.AttributeBase.Builder builderForValue) {
                if (this.currentAttrsBuilder_ == null) {
                    ensureCurrentAttrsIsMutable();
                    this.currentAttrs_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.currentAttrsBuilder_.addMessage((GeneratedMessage) builderForValue.build());
                }
                return this;
            }


            public Builder addCurrentAttrs(int index, Common.AttributeBase.Builder builderForValue) {
                if (this.currentAttrsBuilder_ == null) {
                    ensureCurrentAttrsIsMutable();
                    this.currentAttrs_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.currentAttrsBuilder_.addMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }


            public Builder addAllCurrentAttrs(Iterable<? extends Common.AttributeBase> values) {
                if (this.currentAttrsBuilder_ == null) {
                    ensureCurrentAttrsIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.currentAttrs_);
                    onChanged();
                } else {
                    this.currentAttrsBuilder_.addAllMessages(values);
                }
                return this;
            }


            public Builder clearCurrentAttrs() {
                if (this.currentAttrsBuilder_ == null) {
                    this.currentAttrs_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFD;
                    onChanged();
                } else {
                    this.currentAttrsBuilder_.clear();
                }
                return this;
            }


            public Builder removeCurrentAttrs(int index) {
                if (this.currentAttrsBuilder_ == null) {
                    ensureCurrentAttrsIsMutable();
                    this.currentAttrs_.remove(index);
                    onChanged();
                } else {
                    this.currentAttrsBuilder_.remove(index);
                }
                return this;
            }


            public Common.AttributeBase.Builder getCurrentAttrsBuilder(int index) {
                return (Common.AttributeBase.Builder) getCurrentAttrsFieldBuilder().getBuilder(index);
            }


            public Common.AttributeBaseOrBuilder getCurrentAttrsOrBuilder(int index) {
                if (this.currentAttrsBuilder_ == null) {
                    return (Common.AttributeBaseOrBuilder) this.currentAttrs_.get(index);
                }
                return (Common.AttributeBaseOrBuilder) this.currentAttrsBuilder_.getMessageOrBuilder(index);
            }


            public List<? extends Common.AttributeBaseOrBuilder> getCurrentAttrsOrBuilderList() {
                if (this.currentAttrsBuilder_ != null) {
                    return this.currentAttrsBuilder_.getMessageOrBuilderList();
                }
                return (List) Collections.unmodifiableList(this.currentAttrs_);
            }


            public Common.AttributeBase.Builder addCurrentAttrsBuilder() {
                return (Common.AttributeBase.Builder) getCurrentAttrsFieldBuilder().addBuilder((GeneratedMessage) Common.AttributeBase.getDefaultInstance());
            }


            public Common.AttributeBase.Builder addCurrentAttrsBuilder(int index) {
                return (Common.AttributeBase.Builder) getCurrentAttrsFieldBuilder().addBuilder(index, (GeneratedMessage) Common.AttributeBase.getDefaultInstance());
            }


            public List<Common.AttributeBase.Builder> getCurrentAttrsBuilderList() {
                return getCurrentAttrsFieldBuilder().getBuilderList();
            }


            private RepeatedFieldBuilder<Common.AttributeBase, Common.AttributeBase.Builder, Common.AttributeBaseOrBuilder> getCurrentAttrsFieldBuilder() {
                if (this.currentAttrsBuilder_ == null) {
                    this.currentAttrsBuilder_ = new RepeatedFieldBuilder(this.currentAttrs_, ((this.bitField0_ & 0x2) == 2), getParentForChildren(), isClean());
                    this.currentAttrs_ = null;
                }
                return this.currentAttrsBuilder_;
            }


            private void ensureNextAttrsIsMutable() {
                if ((this.bitField0_ & 0x4) != 4) {
                    this.nextAttrs_ = new ArrayList<>(this.nextAttrs_);
                    this.bitField0_ |= 0x4;
                }
            }


            public List<Common.AttributeBase> getNextAttrsList() {
                if (this.nextAttrsBuilder_ == null) {
                    return Collections.unmodifiableList(this.nextAttrs_);
                }
                return this.nextAttrsBuilder_.getMessageList();
            }


            public int getNextAttrsCount() {
                if (this.nextAttrsBuilder_ == null) {
                    return this.nextAttrs_.size();
                }
                return this.nextAttrsBuilder_.getCount();
            }


            public Common.AttributeBase getNextAttrs(int index) {
                if (this.nextAttrsBuilder_ == null) {
                    return this.nextAttrs_.get(index);
                }
                return (Common.AttributeBase) this.nextAttrsBuilder_.getMessage(index);
            }


            public Builder setNextAttrs(int index, Common.AttributeBase value) {
                if (this.nextAttrsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureNextAttrsIsMutable();
                    this.nextAttrs_.set(index, value);
                    onChanged();
                } else {
                    this.nextAttrsBuilder_.setMessage(index, (GeneratedMessage) value);
                }
                return this;
            }


            public Builder setNextAttrs(int index, Common.AttributeBase.Builder builderForValue) {
                if (this.nextAttrsBuilder_ == null) {
                    ensureNextAttrsIsMutable();
                    this.nextAttrs_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.nextAttrsBuilder_.setMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }


            public Builder addNextAttrs(Common.AttributeBase value) {
                if (this.nextAttrsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureNextAttrsIsMutable();
                    this.nextAttrs_.add(value);
                    onChanged();
                } else {
                    this.nextAttrsBuilder_.addMessage((GeneratedMessage) value);
                }
                return this;
            }


            public Builder addNextAttrs(int index, Common.AttributeBase value) {
                if (this.nextAttrsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureNextAttrsIsMutable();
                    this.nextAttrs_.add(index, value);
                    onChanged();
                } else {
                    this.nextAttrsBuilder_.addMessage(index, (GeneratedMessage) value);
                }
                return this;
            }


            public Builder addNextAttrs(Common.AttributeBase.Builder builderForValue) {
                if (this.nextAttrsBuilder_ == null) {
                    ensureNextAttrsIsMutable();
                    this.nextAttrs_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.nextAttrsBuilder_.addMessage((GeneratedMessage) builderForValue.build());
                }
                return this;
            }


            public Builder addNextAttrs(int index, Common.AttributeBase.Builder builderForValue) {
                if (this.nextAttrsBuilder_ == null) {
                    ensureNextAttrsIsMutable();
                    this.nextAttrs_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.nextAttrsBuilder_.addMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }


            public Builder addAllNextAttrs(Iterable<? extends Common.AttributeBase> values) {
                if (this.nextAttrsBuilder_ == null) {
                    ensureNextAttrsIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.nextAttrs_);
                    onChanged();
                } else {
                    this.nextAttrsBuilder_.addAllMessages(values);
                }
                return this;
            }


            public Builder clearNextAttrs() {
                if (this.nextAttrsBuilder_ == null) {
                    this.nextAttrs_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                    onChanged();
                } else {
                    this.nextAttrsBuilder_.clear();
                }
                return this;
            }


            public Builder removeNextAttrs(int index) {
                if (this.nextAttrsBuilder_ == null) {
                    ensureNextAttrsIsMutable();
                    this.nextAttrs_.remove(index);
                    onChanged();
                } else {
                    this.nextAttrsBuilder_.remove(index);
                }
                return this;
            }


            public Common.AttributeBase.Builder getNextAttrsBuilder(int index) {
                return (Common.AttributeBase.Builder) getNextAttrsFieldBuilder().getBuilder(index);
            }


            public Common.AttributeBaseOrBuilder getNextAttrsOrBuilder(int index) {
                if (this.nextAttrsBuilder_ == null) {
                    return (Common.AttributeBaseOrBuilder) this.nextAttrs_.get(index);
                }
                return (Common.AttributeBaseOrBuilder) this.nextAttrsBuilder_.getMessageOrBuilder(index);
            }


            public List<? extends Common.AttributeBaseOrBuilder> getNextAttrsOrBuilderList() {
                if (this.nextAttrsBuilder_ != null) {
                    return this.nextAttrsBuilder_.getMessageOrBuilderList();
                }
                return (List) Collections.unmodifiableList(this.nextAttrs_);
            }


            public Common.AttributeBase.Builder addNextAttrsBuilder() {
                return (Common.AttributeBase.Builder) getNextAttrsFieldBuilder().addBuilder((GeneratedMessage) Common.AttributeBase.getDefaultInstance());
            }


            public Common.AttributeBase.Builder addNextAttrsBuilder(int index) {
                return (Common.AttributeBase.Builder) getNextAttrsFieldBuilder().addBuilder(index, (GeneratedMessage) Common.AttributeBase.getDefaultInstance());
            }


            public List<Common.AttributeBase.Builder> getNextAttrsBuilderList() {
                return getNextAttrsFieldBuilder().getBuilderList();
            }


            private RepeatedFieldBuilder<Common.AttributeBase, Common.AttributeBase.Builder, Common.AttributeBaseOrBuilder> getNextAttrsFieldBuilder() {
                if (this.nextAttrsBuilder_ == null) {
                    this.nextAttrsBuilder_ = new RepeatedFieldBuilder(this.nextAttrs_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
                    this.nextAttrs_ = null;
                }
                return this.nextAttrsBuilder_;
            }


            public boolean hasNeedFund() {
                return ((this.bitField0_ & 0x8) == 8);
            }


            public int getNeedFund() {
                return this.needFund_;
            }


            public Builder setNeedFund(int value) {
                this.bitField0_ |= 0x8;
                this.needFund_ = value;
                onChanged();
                return this;
            }


            public Builder clearNeedFund() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.needFund_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class GuildSkill
            extends GeneratedMessage
            implements GuildSkillOrBuilder {
        private static final GuildSkill defaultInstance = new GuildSkill(true);
        private final UnknownFieldSet unknownFields;

        private GuildSkill(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GuildSkill(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GuildSkill getDefaultInstance() {
            return defaultInstance;
        }

        public GuildSkill getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GuildSkill(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.techName_ = bs;
                            break;
                        case 34:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x8;
                            this.techDes_ = bs;
                            break;
                        case 42:
                            if ((mutable_bitField0_ & 0x10) != 16) {
                                this.currentAttrs_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x10;
                            }
                            this.currentAttrs_.add(input.readMessage(Common.AttributeBase.PARSER, extensionRegistry));
                            break;
                        case 50:
                            if ((mutable_bitField0_ & 0x20) != 32) {
                                this.nextAttrs_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x20;
                            }
                            this.nextAttrs_.add(input.readMessage(Common.AttributeBase.PARSER, extensionRegistry));
                            break;
                        case 56:
                            this.bitField0_ |= 0x10;
                            this.needContribution_ = input.readInt32();
                            break;
                        case 64:
                            this.bitField0_ |= 0x20;
                            this.needGold_ = input.readInt32();
                            break;
                        case 72:
                            this.bitField0_ |= 0x40;
                            this.recommend_ = input.readInt32();
                            break;
                        case 82:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x80;
                            this.icon_ = bs;
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x10) == 16)
                    this.currentAttrs_ = Collections.unmodifiableList(this.currentAttrs_);
                if ((mutable_bitField0_ & 0x20) == 32) this.nextAttrs_ = Collections.unmodifiableList(this.nextAttrs_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GuildTechHandler.internal_static_pomelo_area_GuildSkill_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return GuildTechHandler.internal_static_pomelo_area_GuildSkill_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildSkill.class, Builder.class);
        }

        public static Parser<GuildSkill> PARSER = (Parser<GuildSkill>) new AbstractParser<GuildSkill>() {
            public GuildTechHandler.GuildSkill parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GuildTechHandler.GuildSkill(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int ID_FIELD_NUMBER = 1;
        private int id_;
        public static final int LEVEL_FIELD_NUMBER = 2;
        private int level_;
        public static final int TECHNAME_FIELD_NUMBER = 3;
        private Object techName_;
        public static final int TECHDES_FIELD_NUMBER = 4;
        private Object techDes_;
        public static final int CURRENTATTRS_FIELD_NUMBER = 5;
        private List<Common.AttributeBase> currentAttrs_;
        public static final int NEXTATTRS_FIELD_NUMBER = 6;
        private List<Common.AttributeBase> nextAttrs_;
        public static final int NEEDCONTRIBUTION_FIELD_NUMBER = 7;
        private int needContribution_;
        public static final int NEEDGOLD_FIELD_NUMBER = 8;
        private int needGold_;
        public static final int RECOMMEND_FIELD_NUMBER = 9;
        private int recommend_;
        public static final int ICON_FIELD_NUMBER = 10;
        private Object icon_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GuildSkill> getParserForType() {
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

        public boolean hasTechName() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public String getTechName() {
            Object ref = this.techName_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.techName_ = s;
            return s;
        }

        public ByteString getTechNameBytes() {
            Object ref = this.techName_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.techName_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        static {
            defaultInstance.initFields();
        }


        public boolean hasTechDes() {
            return ((this.bitField0_ & 0x8) == 8);
        }


        public String getTechDes() {
            Object ref = this.techDes_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.techDes_ = s;
            }
            return s;
        }


        public ByteString getTechDesBytes() {
            Object ref = this.techDes_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.techDes_ = b;
                return b;
            }
            return (ByteString) ref;
        }


        public List<Common.AttributeBase> getCurrentAttrsList() {
            return this.currentAttrs_;
        }


        public List<? extends Common.AttributeBaseOrBuilder> getCurrentAttrsOrBuilderList() {
            return (List) this.currentAttrs_;
        }


        public int getCurrentAttrsCount() {
            return this.currentAttrs_.size();
        }


        public Common.AttributeBase getCurrentAttrs(int index) {
            return this.currentAttrs_.get(index);
        }


        public Common.AttributeBaseOrBuilder getCurrentAttrsOrBuilder(int index) {
            return (Common.AttributeBaseOrBuilder) this.currentAttrs_.get(index);
        }


        public List<Common.AttributeBase> getNextAttrsList() {
            return this.nextAttrs_;
        }


        public List<? extends Common.AttributeBaseOrBuilder> getNextAttrsOrBuilderList() {
            return (List) this.nextAttrs_;
        }


        public int getNextAttrsCount() {
            return this.nextAttrs_.size();
        }


        public Common.AttributeBase getNextAttrs(int index) {
            return this.nextAttrs_.get(index);
        }


        public Common.AttributeBaseOrBuilder getNextAttrsOrBuilder(int index) {
            return (Common.AttributeBaseOrBuilder) this.nextAttrs_.get(index);
        }


        public boolean hasNeedContribution() {
            return ((this.bitField0_ & 0x10) == 16);
        }


        public int getNeedContribution() {
            return this.needContribution_;
        }


        public boolean hasNeedGold() {
            return ((this.bitField0_ & 0x20) == 32);
        }


        public int getNeedGold() {
            return this.needGold_;
        }


        public boolean hasRecommend() {
            return ((this.bitField0_ & 0x40) == 64);
        }


        public int getRecommend() {
            return this.recommend_;
        }


        public boolean hasIcon() {
            return ((this.bitField0_ & 0x80) == 128);
        }


        public String getIcon() {
            Object ref = this.icon_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.icon_ = s;
            }
            return s;
        }


        public ByteString getIconBytes() {
            Object ref = this.icon_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.icon_ = b;
                return b;
            }
            return (ByteString) ref;
        }


        private void initFields() {
            this.id_ = 0;
            this.level_ = 0;
            this.techName_ = "";
            this.techDes_ = "";
            this.currentAttrs_ = Collections.emptyList();
            this.nextAttrs_ = Collections.emptyList();
            this.needContribution_ = 0;
            this.needGold_ = 0;
            this.recommend_ = 0;
            this.icon_ = "";
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
            for (i = 0; i < getCurrentAttrsCount(); i++) {
                if (!getCurrentAttrs(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (i = 0; i < getNextAttrsCount(); i++) {
                if (!getNextAttrs(i).isInitialized()) {
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
                output.writeInt32(2, this.level_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeBytes(3, getTechNameBytes());
            }
            if ((this.bitField0_ & 0x8) == 8) {
                output.writeBytes(4, getTechDesBytes());
            }
            int i;
            for (i = 0; i < this.currentAttrs_.size(); i++) {
                output.writeMessage(5, (MessageLite) this.currentAttrs_.get(i));
            }
            for (i = 0; i < this.nextAttrs_.size(); i++) {
                output.writeMessage(6, (MessageLite) this.nextAttrs_.get(i));
            }
            if ((this.bitField0_ & 0x10) == 16) {
                output.writeInt32(7, this.needContribution_);
            }
            if ((this.bitField0_ & 0x20) == 32) {
                output.writeInt32(8, this.needGold_);
            }
            if ((this.bitField0_ & 0x40) == 64) {
                output.writeInt32(9, this.recommend_);
            }
            if ((this.bitField0_ & 0x80) == 128) {
                output.writeBytes(10, getIconBytes());
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
                size += CodedOutputStream.computeBytesSize(3, getTechNameBytes());
            }
            if ((this.bitField0_ & 0x8) == 8) {
                size += CodedOutputStream.computeBytesSize(4, getTechDesBytes());
            }
            int i;
            for (i = 0; i < this.currentAttrs_.size(); i++) {
                size += CodedOutputStream.computeMessageSize(5, (MessageLite) this.currentAttrs_.get(i));
            }
            for (i = 0; i < this.nextAttrs_.size(); i++) {
                size += CodedOutputStream.computeMessageSize(6, (MessageLite) this.nextAttrs_.get(i));
            }
            if ((this.bitField0_ & 0x10) == 16) {
                size += CodedOutputStream.computeInt32Size(7, this.needContribution_);
            }
            if ((this.bitField0_ & 0x20) == 32) {
                size += CodedOutputStream.computeInt32Size(8, this.needGold_);
            }
            if ((this.bitField0_ & 0x40) == 64) {
                size += CodedOutputStream.computeInt32Size(9, this.recommend_);
            }
            if ((this.bitField0_ & 0x80) == 128) {
                size += CodedOutputStream.computeBytesSize(10, getIconBytes());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static GuildSkill parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GuildSkill) PARSER.parseFrom(data);
        }


        public static GuildSkill parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GuildSkill) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GuildSkill parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GuildSkill) PARSER.parseFrom(data);
        }


        public static GuildSkill parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GuildSkill) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GuildSkill parseFrom(InputStream input) throws IOException {
            return (GuildSkill) PARSER.parseFrom(input);
        }


        public static GuildSkill parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GuildSkill) PARSER.parseFrom(input, extensionRegistry);
        }


        public static GuildSkill parseDelimitedFrom(InputStream input) throws IOException {
            return (GuildSkill) PARSER.parseDelimitedFrom(input);
        }


        public static GuildSkill parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GuildSkill) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static GuildSkill parseFrom(CodedInputStream input) throws IOException {
            return (GuildSkill) PARSER.parseFrom(input);
        }


        public static GuildSkill parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GuildSkill) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(GuildSkill prototype) {
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
                implements GuildTechHandler.GuildSkillOrBuilder {
            private int bitField0_;


            private int id_;


            private int level_;


            private Object techName_;


            private Object techDes_;


            private List<Common.AttributeBase> currentAttrs_;


            private RepeatedFieldBuilder<Common.AttributeBase, Common.AttributeBase.Builder, Common.AttributeBaseOrBuilder> currentAttrsBuilder_;


            private List<Common.AttributeBase> nextAttrs_;


            private RepeatedFieldBuilder<Common.AttributeBase, Common.AttributeBase.Builder, Common.AttributeBaseOrBuilder> nextAttrsBuilder_;


            private int needContribution_;


            private int needGold_;


            private int recommend_;


            private Object icon_;


            public static final Descriptors.Descriptor getDescriptor() {
                return GuildTechHandler.internal_static_pomelo_area_GuildSkill_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return GuildTechHandler.internal_static_pomelo_area_GuildSkill_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildTechHandler.GuildSkill.class, Builder.class);
            }


            private Builder() {
                this.techName_ = "";
                this.techDes_ = "";
                this.currentAttrs_ = Collections.emptyList();
                this.nextAttrs_ = Collections.emptyList();
                this.icon_ = "";
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.techName_ = "";
                this.techDes_ = "";
                this.currentAttrs_ = Collections.emptyList();
                this.nextAttrs_ = Collections.emptyList();
                this.icon_ = "";
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (GuildTechHandler.GuildSkill.alwaysUseFieldBuilders) {
                    getCurrentAttrsFieldBuilder();
                    getNextAttrsFieldBuilder();
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
                this.techName_ = "";
                this.bitField0_ &= 0xFFFFFFFB;
                this.techDes_ = "";
                this.bitField0_ &= 0xFFFFFFF7;
                if (this.currentAttrsBuilder_ == null) {
                    this.currentAttrs_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFEF;
                } else {
                    this.currentAttrsBuilder_.clear();
                }
                if (this.nextAttrsBuilder_ == null) {
                    this.nextAttrs_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFDF;
                } else {
                    this.nextAttrsBuilder_.clear();
                }
                this.needContribution_ = 0;
                this.bitField0_ &= 0xFFFFFFBF;
                this.needGold_ = 0;
                this.bitField0_ &= 0xFFFFFF7F;
                this.recommend_ = 0;
                this.bitField0_ &= 0xFFFFFEFF;
                this.icon_ = "";
                this.bitField0_ &= 0xFFFFFDFF;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return GuildTechHandler.internal_static_pomelo_area_GuildSkill_descriptor;
            }


            public GuildTechHandler.GuildSkill getDefaultInstanceForType() {
                return GuildTechHandler.GuildSkill.getDefaultInstance();
            }


            public GuildTechHandler.GuildSkill build() {
                GuildTechHandler.GuildSkill result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public GuildTechHandler.GuildSkill buildPartial() {
                GuildTechHandler.GuildSkill result = new GuildTechHandler.GuildSkill(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.id_ = this.id_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.level_ = this.level_;
                if ((from_bitField0_ & 0x4) == 4) {
                    to_bitField0_ |= 0x4;
                }
                result.techName_ = this.techName_;
                if ((from_bitField0_ & 0x8) == 8) {
                    to_bitField0_ |= 0x8;
                }
                result.techDes_ = this.techDes_;
                if (this.currentAttrsBuilder_ == null) {
                    if ((this.bitField0_ & 0x10) == 16) {
                        this.currentAttrs_ = Collections.unmodifiableList(this.currentAttrs_);
                        this.bitField0_ &= 0xFFFFFFEF;
                    }
                    result.currentAttrs_ = this.currentAttrs_;
                } else {
                    result.currentAttrs_ = this.currentAttrsBuilder_.build();
                }
                if (this.nextAttrsBuilder_ == null) {
                    if ((this.bitField0_ & 0x20) == 32) {
                        this.nextAttrs_ = Collections.unmodifiableList(this.nextAttrs_);
                        this.bitField0_ &= 0xFFFFFFDF;
                    }
                    result.nextAttrs_ = this.nextAttrs_;
                } else {
                    result.nextAttrs_ = this.nextAttrsBuilder_.build();
                }
                if ((from_bitField0_ & 0x40) == 64) {
                    to_bitField0_ |= 0x10;
                }
                result.needContribution_ = this.needContribution_;
                if ((from_bitField0_ & 0x80) == 128) {
                    to_bitField0_ |= 0x20;
                }
                result.needGold_ = this.needGold_;
                if ((from_bitField0_ & 0x100) == 256) {
                    to_bitField0_ |= 0x40;
                }
                result.recommend_ = this.recommend_;
                if ((from_bitField0_ & 0x200) == 512) {
                    to_bitField0_ |= 0x80;
                }
                result.icon_ = this.icon_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof GuildTechHandler.GuildSkill) {
                    return mergeFrom((GuildTechHandler.GuildSkill) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(GuildTechHandler.GuildSkill other) {
                if (other == GuildTechHandler.GuildSkill.getDefaultInstance()) {
                    return this;
                }
                if (other.hasId()) {
                    setId(other.getId());
                }
                if (other.hasLevel()) {
                    setLevel(other.getLevel());
                }
                if (other.hasTechName()) {
                    this.bitField0_ |= 0x4;
                    this.techName_ = other.techName_;
                    onChanged();
                }
                if (other.hasTechDes()) {
                    this.bitField0_ |= 0x8;
                    this.techDes_ = other.techDes_;
                    onChanged();
                }
                if (this.currentAttrsBuilder_ == null) {
                    if (!other.currentAttrs_.isEmpty()) {
                        if (this.currentAttrs_.isEmpty()) {
                            this.currentAttrs_ = other.currentAttrs_;
                            this.bitField0_ &= 0xFFFFFFEF;
                        } else {
                            ensureCurrentAttrsIsMutable();
                            this.currentAttrs_.addAll(other.currentAttrs_);
                        }
                        onChanged();
                    }
                } else if (!other.currentAttrs_.isEmpty()) {
                    if (this.currentAttrsBuilder_.isEmpty()) {
                        this.currentAttrsBuilder_.dispose();
                        this.currentAttrsBuilder_ = null;
                        this.currentAttrs_ = other.currentAttrs_;
                        this.bitField0_ &= 0xFFFFFFEF;
                        this.currentAttrsBuilder_ = GuildTechHandler.GuildSkill.alwaysUseFieldBuilders ? getCurrentAttrsFieldBuilder() : null;
                    } else {
                        this.currentAttrsBuilder_.addAllMessages(other.currentAttrs_);
                    }
                }
                if (this.nextAttrsBuilder_ == null) {
                    if (!other.nextAttrs_.isEmpty()) {
                        if (this.nextAttrs_.isEmpty()) {
                            this.nextAttrs_ = other.nextAttrs_;
                            this.bitField0_ &= 0xFFFFFFDF;
                        } else {
                            ensureNextAttrsIsMutable();
                            this.nextAttrs_.addAll(other.nextAttrs_);
                        }
                        onChanged();
                    }
                } else if (!other.nextAttrs_.isEmpty()) {
                    if (this.nextAttrsBuilder_.isEmpty()) {
                        this.nextAttrsBuilder_.dispose();
                        this.nextAttrsBuilder_ = null;
                        this.nextAttrs_ = other.nextAttrs_;
                        this.bitField0_ &= 0xFFFFFFDF;
                        this.nextAttrsBuilder_ = GuildTechHandler.GuildSkill.alwaysUseFieldBuilders ? getNextAttrsFieldBuilder() : null;
                    } else {
                        this.nextAttrsBuilder_.addAllMessages(other.nextAttrs_);
                    }
                }
                if (other.hasNeedContribution()) {
                    setNeedContribution(other.getNeedContribution());
                }
                if (other.hasNeedGold()) {
                    setNeedGold(other.getNeedGold());
                }
                if (other.hasRecommend()) {
                    setRecommend(other.getRecommend());
                }
                if (other.hasIcon()) {
                    this.bitField0_ |= 0x200;
                    this.icon_ = other.icon_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                int i;
                for (i = 0; i < getCurrentAttrsCount(); i++) {
                    if (!getCurrentAttrs(i).isInitialized()) {
                        return false;
                    }
                }
                for (i = 0; i < getNextAttrsCount(); i++) {
                    if (!getNextAttrs(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                GuildTechHandler.GuildSkill parsedMessage = null;
                try {
                    parsedMessage = (GuildTechHandler.GuildSkill) GuildTechHandler.GuildSkill.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (GuildTechHandler.GuildSkill) e.getUnfinishedMessage();
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


            public boolean hasTechName() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public String getTechName() {
                Object ref = this.techName_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.techName_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }


            public ByteString getTechNameBytes() {
                Object ref = this.techName_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.techName_ = b;
                    return b;
                }
                return (ByteString) ref;
            }


            public Builder setTechName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x4;
                this.techName_ = value;
                onChanged();
                return this;
            }


            public Builder clearTechName() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.techName_ = GuildTechHandler.GuildSkill.getDefaultInstance().getTechName();
                onChanged();
                return this;
            }


            public Builder setTechNameBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x4;
                this.techName_ = value;
                onChanged();
                return this;
            }


            public boolean hasTechDes() {
                return ((this.bitField0_ & 0x8) == 8);
            }


            public String getTechDes() {
                Object ref = this.techDes_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.techDes_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }


            public ByteString getTechDesBytes() {
                Object ref = this.techDes_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.techDes_ = b;
                    return b;
                }
                return (ByteString) ref;
            }


            public Builder setTechDes(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x8;
                this.techDes_ = value;
                onChanged();
                return this;
            }


            public Builder clearTechDes() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.techDes_ = GuildTechHandler.GuildSkill.getDefaultInstance().getTechDes();
                onChanged();
                return this;
            }


            public Builder setTechDesBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x8;
                this.techDes_ = value;
                onChanged();
                return this;
            }


            private void ensureCurrentAttrsIsMutable() {
                if ((this.bitField0_ & 0x10) != 16) {
                    this.currentAttrs_ = new ArrayList<>(this.currentAttrs_);
                    this.bitField0_ |= 0x10;
                }
            }


            public List<Common.AttributeBase> getCurrentAttrsList() {
                if (this.currentAttrsBuilder_ == null) {
                    return Collections.unmodifiableList(this.currentAttrs_);
                }
                return this.currentAttrsBuilder_.getMessageList();
            }


            public int getCurrentAttrsCount() {
                if (this.currentAttrsBuilder_ == null) {
                    return this.currentAttrs_.size();
                }
                return this.currentAttrsBuilder_.getCount();
            }


            public Common.AttributeBase getCurrentAttrs(int index) {
                if (this.currentAttrsBuilder_ == null) {
                    return this.currentAttrs_.get(index);
                }
                return (Common.AttributeBase) this.currentAttrsBuilder_.getMessage(index);
            }


            public Builder setCurrentAttrs(int index, Common.AttributeBase value) {
                if (this.currentAttrsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureCurrentAttrsIsMutable();
                    this.currentAttrs_.set(index, value);
                    onChanged();
                } else {
                    this.currentAttrsBuilder_.setMessage(index, (GeneratedMessage) value);
                }
                return this;
            }


            public Builder setCurrentAttrs(int index, Common.AttributeBase.Builder builderForValue) {
                if (this.currentAttrsBuilder_ == null) {
                    ensureCurrentAttrsIsMutable();
                    this.currentAttrs_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.currentAttrsBuilder_.setMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }


            public Builder addCurrentAttrs(Common.AttributeBase value) {
                if (this.currentAttrsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureCurrentAttrsIsMutable();
                    this.currentAttrs_.add(value);
                    onChanged();
                } else {
                    this.currentAttrsBuilder_.addMessage((GeneratedMessage) value);
                }
                return this;
            }


            public Builder addCurrentAttrs(int index, Common.AttributeBase value) {
                if (this.currentAttrsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureCurrentAttrsIsMutable();
                    this.currentAttrs_.add(index, value);
                    onChanged();
                } else {
                    this.currentAttrsBuilder_.addMessage(index, (GeneratedMessage) value);
                }
                return this;
            }


            public Builder addCurrentAttrs(Common.AttributeBase.Builder builderForValue) {
                if (this.currentAttrsBuilder_ == null) {
                    ensureCurrentAttrsIsMutable();
                    this.currentAttrs_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.currentAttrsBuilder_.addMessage((GeneratedMessage) builderForValue.build());
                }
                return this;
            }


            public Builder addCurrentAttrs(int index, Common.AttributeBase.Builder builderForValue) {
                if (this.currentAttrsBuilder_ == null) {
                    ensureCurrentAttrsIsMutable();
                    this.currentAttrs_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.currentAttrsBuilder_.addMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }


            public Builder addAllCurrentAttrs(Iterable<? extends Common.AttributeBase> values) {
                if (this.currentAttrsBuilder_ == null) {
                    ensureCurrentAttrsIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.currentAttrs_);
                    onChanged();
                } else {
                    this.currentAttrsBuilder_.addAllMessages(values);
                }
                return this;
            }


            public Builder clearCurrentAttrs() {
                if (this.currentAttrsBuilder_ == null) {
                    this.currentAttrs_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFEF;
                    onChanged();
                } else {
                    this.currentAttrsBuilder_.clear();
                }
                return this;
            }


            public Builder removeCurrentAttrs(int index) {
                if (this.currentAttrsBuilder_ == null) {
                    ensureCurrentAttrsIsMutable();
                    this.currentAttrs_.remove(index);
                    onChanged();
                } else {
                    this.currentAttrsBuilder_.remove(index);
                }
                return this;
            }


            public Common.AttributeBase.Builder getCurrentAttrsBuilder(int index) {
                return (Common.AttributeBase.Builder) getCurrentAttrsFieldBuilder().getBuilder(index);
            }


            public Common.AttributeBaseOrBuilder getCurrentAttrsOrBuilder(int index) {
                if (this.currentAttrsBuilder_ == null) {
                    return (Common.AttributeBaseOrBuilder) this.currentAttrs_.get(index);
                }
                return (Common.AttributeBaseOrBuilder) this.currentAttrsBuilder_.getMessageOrBuilder(index);
            }


            public List<? extends Common.AttributeBaseOrBuilder> getCurrentAttrsOrBuilderList() {
                if (this.currentAttrsBuilder_ != null) {
                    return this.currentAttrsBuilder_.getMessageOrBuilderList();
                }
                return (List) Collections.unmodifiableList(this.currentAttrs_);
            }


            public Common.AttributeBase.Builder addCurrentAttrsBuilder() {
                return (Common.AttributeBase.Builder) getCurrentAttrsFieldBuilder().addBuilder((GeneratedMessage) Common.AttributeBase.getDefaultInstance());
            }


            public Common.AttributeBase.Builder addCurrentAttrsBuilder(int index) {
                return (Common.AttributeBase.Builder) getCurrentAttrsFieldBuilder().addBuilder(index, (GeneratedMessage) Common.AttributeBase.getDefaultInstance());
            }


            public List<Common.AttributeBase.Builder> getCurrentAttrsBuilderList() {
                return getCurrentAttrsFieldBuilder().getBuilderList();
            }


            private RepeatedFieldBuilder<Common.AttributeBase, Common.AttributeBase.Builder, Common.AttributeBaseOrBuilder> getCurrentAttrsFieldBuilder() {
                if (this.currentAttrsBuilder_ == null) {
                    this.currentAttrsBuilder_ = new RepeatedFieldBuilder(this.currentAttrs_, ((this.bitField0_ & 0x10) == 16), getParentForChildren(), isClean());
                    this.currentAttrs_ = null;
                }
                return this.currentAttrsBuilder_;
            }


            private void ensureNextAttrsIsMutable() {
                if ((this.bitField0_ & 0x20) != 32) {
                    this.nextAttrs_ = new ArrayList<>(this.nextAttrs_);
                    this.bitField0_ |= 0x20;
                }
            }


            public List<Common.AttributeBase> getNextAttrsList() {
                if (this.nextAttrsBuilder_ == null) {
                    return Collections.unmodifiableList(this.nextAttrs_);
                }
                return this.nextAttrsBuilder_.getMessageList();
            }


            public int getNextAttrsCount() {
                if (this.nextAttrsBuilder_ == null) {
                    return this.nextAttrs_.size();
                }
                return this.nextAttrsBuilder_.getCount();
            }


            public Common.AttributeBase getNextAttrs(int index) {
                if (this.nextAttrsBuilder_ == null) {
                    return this.nextAttrs_.get(index);
                }
                return (Common.AttributeBase) this.nextAttrsBuilder_.getMessage(index);
            }


            public Builder setNextAttrs(int index, Common.AttributeBase value) {
                if (this.nextAttrsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureNextAttrsIsMutable();
                    this.nextAttrs_.set(index, value);
                    onChanged();
                } else {
                    this.nextAttrsBuilder_.setMessage(index, (GeneratedMessage) value);
                }
                return this;
            }


            public Builder setNextAttrs(int index, Common.AttributeBase.Builder builderForValue) {
                if (this.nextAttrsBuilder_ == null) {
                    ensureNextAttrsIsMutable();
                    this.nextAttrs_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.nextAttrsBuilder_.setMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }


            public Builder addNextAttrs(Common.AttributeBase value) {
                if (this.nextAttrsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureNextAttrsIsMutable();
                    this.nextAttrs_.add(value);
                    onChanged();
                } else {
                    this.nextAttrsBuilder_.addMessage((GeneratedMessage) value);
                }
                return this;
            }


            public Builder addNextAttrs(int index, Common.AttributeBase value) {
                if (this.nextAttrsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureNextAttrsIsMutable();
                    this.nextAttrs_.add(index, value);
                    onChanged();
                } else {
                    this.nextAttrsBuilder_.addMessage(index, (GeneratedMessage) value);
                }
                return this;
            }


            public Builder addNextAttrs(Common.AttributeBase.Builder builderForValue) {
                if (this.nextAttrsBuilder_ == null) {
                    ensureNextAttrsIsMutable();
                    this.nextAttrs_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.nextAttrsBuilder_.addMessage((GeneratedMessage) builderForValue.build());
                }
                return this;
            }


            public Builder addNextAttrs(int index, Common.AttributeBase.Builder builderForValue) {
                if (this.nextAttrsBuilder_ == null) {
                    ensureNextAttrsIsMutable();
                    this.nextAttrs_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.nextAttrsBuilder_.addMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }


            public Builder addAllNextAttrs(Iterable<? extends Common.AttributeBase> values) {
                if (this.nextAttrsBuilder_ == null) {
                    ensureNextAttrsIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.nextAttrs_);
                    onChanged();
                } else {
                    this.nextAttrsBuilder_.addAllMessages(values);
                }
                return this;
            }


            public Builder clearNextAttrs() {
                if (this.nextAttrsBuilder_ == null) {
                    this.nextAttrs_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFDF;
                    onChanged();
                } else {
                    this.nextAttrsBuilder_.clear();
                }
                return this;
            }


            public Builder removeNextAttrs(int index) {
                if (this.nextAttrsBuilder_ == null) {
                    ensureNextAttrsIsMutable();
                    this.nextAttrs_.remove(index);
                    onChanged();
                } else {
                    this.nextAttrsBuilder_.remove(index);
                }
                return this;
            }


            public Common.AttributeBase.Builder getNextAttrsBuilder(int index) {
                return (Common.AttributeBase.Builder) getNextAttrsFieldBuilder().getBuilder(index);
            }


            public Common.AttributeBaseOrBuilder getNextAttrsOrBuilder(int index) {
                if (this.nextAttrsBuilder_ == null) {
                    return (Common.AttributeBaseOrBuilder) this.nextAttrs_.get(index);
                }
                return (Common.AttributeBaseOrBuilder) this.nextAttrsBuilder_.getMessageOrBuilder(index);
            }


            public List<? extends Common.AttributeBaseOrBuilder> getNextAttrsOrBuilderList() {
                if (this.nextAttrsBuilder_ != null) {
                    return this.nextAttrsBuilder_.getMessageOrBuilderList();
                }
                return (List) Collections.unmodifiableList(this.nextAttrs_);
            }


            public Common.AttributeBase.Builder addNextAttrsBuilder() {
                return (Common.AttributeBase.Builder) getNextAttrsFieldBuilder().addBuilder((GeneratedMessage) Common.AttributeBase.getDefaultInstance());
            }


            public Common.AttributeBase.Builder addNextAttrsBuilder(int index) {
                return (Common.AttributeBase.Builder) getNextAttrsFieldBuilder().addBuilder(index, (GeneratedMessage) Common.AttributeBase.getDefaultInstance());
            }


            public List<Common.AttributeBase.Builder> getNextAttrsBuilderList() {
                return getNextAttrsFieldBuilder().getBuilderList();
            }


            private RepeatedFieldBuilder<Common.AttributeBase, Common.AttributeBase.Builder, Common.AttributeBaseOrBuilder> getNextAttrsFieldBuilder() {
                if (this.nextAttrsBuilder_ == null) {
                    this.nextAttrsBuilder_ = new RepeatedFieldBuilder(this.nextAttrs_, ((this.bitField0_ & 0x20) == 32), getParentForChildren(), isClean());
                    this.nextAttrs_ = null;
                }
                return this.nextAttrsBuilder_;
            }


            public boolean hasNeedContribution() {
                return ((this.bitField0_ & 0x40) == 64);
            }


            public int getNeedContribution() {
                return this.needContribution_;
            }


            public Builder setNeedContribution(int value) {
                this.bitField0_ |= 0x40;
                this.needContribution_ = value;
                onChanged();
                return this;
            }


            public Builder clearNeedContribution() {
                this.bitField0_ &= 0xFFFFFFBF;
                this.needContribution_ = 0;
                onChanged();
                return this;
            }


            public boolean hasNeedGold() {
                return ((this.bitField0_ & 0x80) == 128);
            }


            public int getNeedGold() {
                return this.needGold_;
            }


            public Builder setNeedGold(int value) {
                this.bitField0_ |= 0x80;
                this.needGold_ = value;
                onChanged();
                return this;
            }


            public Builder clearNeedGold() {
                this.bitField0_ &= 0xFFFFFF7F;
                this.needGold_ = 0;
                onChanged();
                return this;
            }


            public boolean hasRecommend() {
                return ((this.bitField0_ & 0x100) == 256);
            }


            public int getRecommend() {
                return this.recommend_;
            }


            public Builder setRecommend(int value) {
                this.bitField0_ |= 0x100;
                this.recommend_ = value;
                onChanged();
                return this;
            }


            public Builder clearRecommend() {
                this.bitField0_ &= 0xFFFFFEFF;
                this.recommend_ = 0;
                onChanged();
                return this;
            }


            public boolean hasIcon() {
                return ((this.bitField0_ & 0x200) == 512);
            }


            public String getIcon() {
                Object ref = this.icon_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.icon_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }


            public ByteString getIconBytes() {
                Object ref = this.icon_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.icon_ = b;
                    return b;
                }
                return (ByteString) ref;
            }


            public Builder setIcon(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x200;
                this.icon_ = value;
                onChanged();
                return this;
            }


            public Builder clearIcon() {
                this.bitField0_ &= 0xFFFFFDFF;
                this.icon_ = GuildTechHandler.GuildSkill.getDefaultInstance().getIcon();
                onChanged();
                return this;
            }


            public Builder setIconBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x200;
                this.icon_ = value;
                onChanged();
                return this;
            }
        }
    }


    public static final class GuildProduct
            extends GeneratedMessage
            implements GuildProductOrBuilder {
        private static final GuildProduct defaultInstance = new GuildProduct(true);
        private final UnknownFieldSet unknownFields;

        private GuildProduct(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GuildProduct(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GuildProduct getDefaultInstance() {
            return defaultInstance;
        }

        public GuildProduct getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GuildProduct(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ItemOuterClass.MiniItem.Builder subBuilder;
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
                            subBuilder = null;
                            if ((this.bitField0_ & 0x2) == 2) subBuilder = this.item_.toBuilder();
                            this.item_ = (ItemOuterClass.MiniItem) input.readMessage(ItemOuterClass.MiniItem.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.item_);
                                this.item_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 0x2;
                            break;
                        case 26:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x4;
                            this.itemShowName_ = bs;
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.level_ = input.readInt32();
                            break;
                        case 40:
                            this.bitField0_ |= 0x10;
                            this.upLevel_ = input.readInt32();
                            break;
                        case 48:
                            this.bitField0_ |= 0x20;
                            this.needJob_ = input.readInt32();
                            break;
                        case 56:
                            this.bitField0_ |= 0x40;
                            this.needContribution_ = input.readInt32();
                            break;
                        case 64:
                            this.bitField0_ |= 0x80;
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
            return GuildTechHandler.internal_static_pomelo_area_GuildProduct_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return GuildTechHandler.internal_static_pomelo_area_GuildProduct_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildProduct.class, Builder.class);
        }

        public static Parser<GuildProduct> PARSER = (Parser<GuildProduct>) new AbstractParser<GuildProduct>() {
            public GuildTechHandler.GuildProduct parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GuildTechHandler.GuildProduct(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int ID_FIELD_NUMBER = 1;
        private int id_;
        public static final int ITEM_FIELD_NUMBER = 2;
        private ItemOuterClass.MiniItem item_;
        public static final int ITEMSHOWNAME_FIELD_NUMBER = 3;
        private Object itemShowName_;
        public static final int LEVEL_FIELD_NUMBER = 4;
        private int level_;
        public static final int UPLEVEL_FIELD_NUMBER = 5;
        private int upLevel_;
        public static final int NEEDJOB_FIELD_NUMBER = 6;
        private int needJob_;
        public static final int NEEDCONTRIBUTION_FIELD_NUMBER = 7;
        private int needContribution_;
        public static final int STATE_FIELD_NUMBER = 8;
        private int state_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GuildProduct> getParserForType() {
            return PARSER;
        }

        public boolean hasId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getId() {
            return this.id_;
        }

        public boolean hasItem() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public ItemOuterClass.MiniItem getItem() {
            return this.item_;
        }

        static {
            defaultInstance.initFields();
        }


        public ItemOuterClass.MiniItemOrBuilder getItemOrBuilder() {
            return (ItemOuterClass.MiniItemOrBuilder) this.item_;
        }


        public boolean hasItemShowName() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public String getItemShowName() {
            Object ref = this.itemShowName_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.itemShowName_ = s;
            }
            return s;
        }


        public ByteString getItemShowNameBytes() {
            Object ref = this.itemShowName_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.itemShowName_ = b;
                return b;
            }
            return (ByteString) ref;
        }


        public boolean hasLevel() {
            return ((this.bitField0_ & 0x8) == 8);
        }


        public int getLevel() {
            return this.level_;
        }


        public boolean hasUpLevel() {
            return ((this.bitField0_ & 0x10) == 16);
        }


        public int getUpLevel() {
            return this.upLevel_;
        }


        public boolean hasNeedJob() {
            return ((this.bitField0_ & 0x20) == 32);
        }


        public int getNeedJob() {
            return this.needJob_;
        }


        public boolean hasNeedContribution() {
            return ((this.bitField0_ & 0x40) == 64);
        }


        public int getNeedContribution() {
            return this.needContribution_;
        }


        public boolean hasState() {
            return ((this.bitField0_ & 0x80) == 128);
        }


        public int getState() {
            return this.state_;
        }


        private void initFields() {
            this.id_ = 0;
            this.item_ = ItemOuterClass.MiniItem.getDefaultInstance();
            this.itemShowName_ = "";
            this.level_ = 0;
            this.upLevel_ = 0;
            this.needJob_ = 0;
            this.needContribution_ = 0;
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
            if (hasItem() && !getItem().isInitialized()) {
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
                output.writeMessage(2, (MessageLite) this.item_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeBytes(3, getItemShowNameBytes());
            }
            if ((this.bitField0_ & 0x8) == 8) {
                output.writeInt32(4, this.level_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                output.writeInt32(5, this.upLevel_);
            }
            if ((this.bitField0_ & 0x20) == 32) {
                output.writeInt32(6, this.needJob_);
            }
            if ((this.bitField0_ & 0x40) == 64) {
                output.writeInt32(7, this.needContribution_);
            }
            if ((this.bitField0_ & 0x80) == 128) {
                output.writeInt32(8, this.state_);
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
                size += CodedOutputStream.computeMessageSize(2, (MessageLite) this.item_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                size += CodedOutputStream.computeBytesSize(3, getItemShowNameBytes());
            }
            if ((this.bitField0_ & 0x8) == 8) {
                size += CodedOutputStream.computeInt32Size(4, this.level_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                size += CodedOutputStream.computeInt32Size(5, this.upLevel_);
            }
            if ((this.bitField0_ & 0x20) == 32) {
                size += CodedOutputStream.computeInt32Size(6, this.needJob_);
            }
            if ((this.bitField0_ & 0x40) == 64) {
                size += CodedOutputStream.computeInt32Size(7, this.needContribution_);
            }
            if ((this.bitField0_ & 0x80) == 128) {
                size += CodedOutputStream.computeInt32Size(8, this.state_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static GuildProduct parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GuildProduct) PARSER.parseFrom(data);
        }


        public static GuildProduct parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GuildProduct) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GuildProduct parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GuildProduct) PARSER.parseFrom(data);
        }


        public static GuildProduct parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GuildProduct) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GuildProduct parseFrom(InputStream input) throws IOException {
            return (GuildProduct) PARSER.parseFrom(input);
        }


        public static GuildProduct parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GuildProduct) PARSER.parseFrom(input, extensionRegistry);
        }


        public static GuildProduct parseDelimitedFrom(InputStream input) throws IOException {
            return (GuildProduct) PARSER.parseDelimitedFrom(input);
        }


        public static GuildProduct parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GuildProduct) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static GuildProduct parseFrom(CodedInputStream input) throws IOException {
            return (GuildProduct) PARSER.parseFrom(input);
        }


        public static GuildProduct parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GuildProduct) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(GuildProduct prototype) {
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
                implements GuildTechHandler.GuildProductOrBuilder {
            private int bitField0_;


            private int id_;


            private ItemOuterClass.MiniItem item_;


            private SingleFieldBuilder<ItemOuterClass.MiniItem, ItemOuterClass.MiniItem.Builder, ItemOuterClass.MiniItemOrBuilder> itemBuilder_;


            private Object itemShowName_;


            private int level_;


            private int upLevel_;


            private int needJob_;


            private int needContribution_;


            private int state_;


            public static final Descriptors.Descriptor getDescriptor() {
                return GuildTechHandler.internal_static_pomelo_area_GuildProduct_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return GuildTechHandler.internal_static_pomelo_area_GuildProduct_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildTechHandler.GuildProduct.class, Builder.class);
            }


            private Builder() {
                this.item_ = ItemOuterClass.MiniItem.getDefaultInstance();
                this.itemShowName_ = "";
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.item_ = ItemOuterClass.MiniItem.getDefaultInstance();
                this.itemShowName_ = "";
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (GuildTechHandler.GuildProduct.alwaysUseFieldBuilders) {
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
                if (this.itemBuilder_ == null) {
                    this.item_ = ItemOuterClass.MiniItem.getDefaultInstance();
                } else {
                    this.itemBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFD;
                this.itemShowName_ = "";
                this.bitField0_ &= 0xFFFFFFFB;
                this.level_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                this.upLevel_ = 0;
                this.bitField0_ &= 0xFFFFFFEF;
                this.needJob_ = 0;
                this.bitField0_ &= 0xFFFFFFDF;
                this.needContribution_ = 0;
                this.bitField0_ &= 0xFFFFFFBF;
                this.state_ = 0;
                this.bitField0_ &= 0xFFFFFF7F;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return GuildTechHandler.internal_static_pomelo_area_GuildProduct_descriptor;
            }


            public GuildTechHandler.GuildProduct getDefaultInstanceForType() {
                return GuildTechHandler.GuildProduct.getDefaultInstance();
            }


            public GuildTechHandler.GuildProduct build() {
                GuildTechHandler.GuildProduct result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public GuildTechHandler.GuildProduct buildPartial() {
                GuildTechHandler.GuildProduct result = new GuildTechHandler.GuildProduct(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.id_ = this.id_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                if (this.itemBuilder_ == null) {
                    result.item_ = this.item_;
                } else {
                    result.item_ = (ItemOuterClass.MiniItem) this.itemBuilder_.build();
                }
                if ((from_bitField0_ & 0x4) == 4) {
                    to_bitField0_ |= 0x4;
                }
                result.itemShowName_ = this.itemShowName_;
                if ((from_bitField0_ & 0x8) == 8) {
                    to_bitField0_ |= 0x8;
                }
                result.level_ = this.level_;
                if ((from_bitField0_ & 0x10) == 16) {
                    to_bitField0_ |= 0x10;
                }
                result.upLevel_ = this.upLevel_;
                if ((from_bitField0_ & 0x20) == 32) {
                    to_bitField0_ |= 0x20;
                }
                result.needJob_ = this.needJob_;
                if ((from_bitField0_ & 0x40) == 64) {
                    to_bitField0_ |= 0x40;
                }
                result.needContribution_ = this.needContribution_;
                if ((from_bitField0_ & 0x80) == 128) {
                    to_bitField0_ |= 0x80;
                }
                result.state_ = this.state_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof GuildTechHandler.GuildProduct) {
                    return mergeFrom((GuildTechHandler.GuildProduct) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(GuildTechHandler.GuildProduct other) {
                if (other == GuildTechHandler.GuildProduct.getDefaultInstance()) {
                    return this;
                }
                if (other.hasId()) {
                    setId(other.getId());
                }
                if (other.hasItem()) {
                    mergeItem(other.getItem());
                }
                if (other.hasItemShowName()) {
                    this.bitField0_ |= 0x4;
                    this.itemShowName_ = other.itemShowName_;
                    onChanged();
                }
                if (other.hasLevel()) {
                    setLevel(other.getLevel());
                }
                if (other.hasUpLevel()) {
                    setUpLevel(other.getUpLevel());
                }
                if (other.hasNeedJob()) {
                    setNeedJob(other.getNeedJob());
                }
                if (other.hasNeedContribution()) {
                    setNeedContribution(other.getNeedContribution());
                }
                if (other.hasState()) {
                    setState(other.getState());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (hasItem() && !getItem().isInitialized()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                GuildTechHandler.GuildProduct parsedMessage = null;
                try {
                    parsedMessage = (GuildTechHandler.GuildProduct) GuildTechHandler.GuildProduct.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (GuildTechHandler.GuildProduct) e.getUnfinishedMessage();
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


            public boolean hasItem() {
                return ((this.bitField0_ & 0x2) == 2);
            }


            public ItemOuterClass.MiniItem getItem() {
                if (this.itemBuilder_ == null) {
                    return this.item_;
                }
                return (ItemOuterClass.MiniItem) this.itemBuilder_.getMessage();
            }


            public Builder setItem(ItemOuterClass.MiniItem value) {
                if (this.itemBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.item_ = value;
                    onChanged();
                } else {
                    this.itemBuilder_.setMessage((GeneratedMessage) value);
                }
                this.bitField0_ |= 0x2;
                return this;
            }


            public Builder setItem(ItemOuterClass.MiniItem.Builder builderForValue) {
                if (this.itemBuilder_ == null) {
                    this.item_ = builderForValue.build();
                    onChanged();
                } else {
                    this.itemBuilder_.setMessage((GeneratedMessage) builderForValue.build());
                }
                this.bitField0_ |= 0x2;
                return this;
            }


            public Builder mergeItem(ItemOuterClass.MiniItem value) {
                if (this.itemBuilder_ == null) {
                    if ((this.bitField0_ & 0x2) == 2 && this.item_ != ItemOuterClass.MiniItem.getDefaultInstance()) {
                        this.item_ = ItemOuterClass.MiniItem.newBuilder(this.item_).mergeFrom(value).buildPartial();
                    } else {
                        this.item_ = value;
                    }
                    onChanged();
                } else {
                    this.itemBuilder_.mergeFrom((GeneratedMessage) value);
                }
                this.bitField0_ |= 0x2;
                return this;
            }


            public Builder clearItem() {
                if (this.itemBuilder_ == null) {
                    this.item_ = ItemOuterClass.MiniItem.getDefaultInstance();
                    onChanged();
                } else {
                    this.itemBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }


            public ItemOuterClass.MiniItem.Builder getItemBuilder() {
                this.bitField0_ |= 0x2;
                onChanged();
                return (ItemOuterClass.MiniItem.Builder) getItemFieldBuilder().getBuilder();
            }


            public ItemOuterClass.MiniItemOrBuilder getItemOrBuilder() {
                if (this.itemBuilder_ != null) {
                    return (ItemOuterClass.MiniItemOrBuilder) this.itemBuilder_.getMessageOrBuilder();
                }
                return (ItemOuterClass.MiniItemOrBuilder) this.item_;
            }


            private SingleFieldBuilder<ItemOuterClass.MiniItem, ItemOuterClass.MiniItem.Builder, ItemOuterClass.MiniItemOrBuilder> getItemFieldBuilder() {
                if (this.itemBuilder_ == null) {
                    this.itemBuilder_ = new SingleFieldBuilder((GeneratedMessage) getItem(), getParentForChildren(), isClean());
                    this.item_ = null;
                }
                return this.itemBuilder_;
            }


            public boolean hasItemShowName() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public String getItemShowName() {
                Object ref = this.itemShowName_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.itemShowName_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }


            public ByteString getItemShowNameBytes() {
                Object ref = this.itemShowName_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.itemShowName_ = b;
                    return b;
                }
                return (ByteString) ref;
            }


            public Builder setItemShowName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x4;
                this.itemShowName_ = value;
                onChanged();
                return this;
            }


            public Builder clearItemShowName() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.itemShowName_ = GuildTechHandler.GuildProduct.getDefaultInstance().getItemShowName();
                onChanged();
                return this;
            }


            public Builder setItemShowNameBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x4;
                this.itemShowName_ = value;
                onChanged();
                return this;
            }


            public boolean hasLevel() {
                return ((this.bitField0_ & 0x8) == 8);
            }


            public int getLevel() {
                return this.level_;
            }


            public Builder setLevel(int value) {
                this.bitField0_ |= 0x8;
                this.level_ = value;
                onChanged();
                return this;
            }


            public Builder clearLevel() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.level_ = 0;
                onChanged();
                return this;
            }


            public boolean hasUpLevel() {
                return ((this.bitField0_ & 0x10) == 16);
            }


            public int getUpLevel() {
                return this.upLevel_;
            }


            public Builder setUpLevel(int value) {
                this.bitField0_ |= 0x10;
                this.upLevel_ = value;
                onChanged();
                return this;
            }


            public Builder clearUpLevel() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.upLevel_ = 0;
                onChanged();
                return this;
            }


            public boolean hasNeedJob() {
                return ((this.bitField0_ & 0x20) == 32);
            }


            public int getNeedJob() {
                return this.needJob_;
            }


            public Builder setNeedJob(int value) {
                this.bitField0_ |= 0x20;
                this.needJob_ = value;
                onChanged();
                return this;
            }


            public Builder clearNeedJob() {
                this.bitField0_ &= 0xFFFFFFDF;
                this.needJob_ = 0;
                onChanged();
                return this;
            }


            public boolean hasNeedContribution() {
                return ((this.bitField0_ & 0x40) == 64);
            }


            public int getNeedContribution() {
                return this.needContribution_;
            }


            public Builder setNeedContribution(int value) {
                this.bitField0_ |= 0x40;
                this.needContribution_ = value;
                onChanged();
                return this;
            }


            public Builder clearNeedContribution() {
                this.bitField0_ &= 0xFFFFFFBF;
                this.needContribution_ = 0;
                onChanged();
                return this;
            }


            public boolean hasState() {
                return ((this.bitField0_ & 0x80) == 128);
            }


            public int getState() {
                return this.state_;
            }


            public Builder setState(int value) {
                this.bitField0_ |= 0x80;
                this.state_ = value;
                onChanged();
                return this;
            }


            public Builder clearState() {
                this.bitField0_ &= 0xFFFFFF7F;
                this.state_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class GuildTechInfo
            extends GeneratedMessage
            implements GuildTechInfoOrBuilder {
        private static final GuildTechInfo defaultInstance = new GuildTechInfo(true);
        private final UnknownFieldSet unknownFields;

        private GuildTechInfo(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GuildTechInfo(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GuildTechInfo getDefaultInstance() {
            return defaultInstance;
        }

        public GuildTechInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GuildTechInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    GuildTechHandler.GuildBuff.Builder subBuilder;
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        case 8:
                            this.bitField0_ |= 0x1;
                            this.level_ = input.readInt32();
                            break;
                        case 18:
                            subBuilder = null;
                            if ((this.bitField0_ & 0x2) == 2) subBuilder = this.buffInfo_.toBuilder();
                            this.buffInfo_ = (GuildTechHandler.GuildBuff) input.readMessage(GuildTechHandler.GuildBuff.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.buffInfo_);
                                this.buffInfo_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 0x2;
                            break;
                        case 26:
                            if ((mutable_bitField0_ & 0x4) != 4) {
                                this.skillList_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x4;
                            }
                            this.skillList_.add(input.readMessage(GuildTechHandler.GuildSkill.PARSER, extensionRegistry));
                            break;
                        case 34:
                            if ((mutable_bitField0_ & 0x8) != 8) {
                                this.productList_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x8;
                            }
                            this.productList_.add(input.readMessage(GuildTechHandler.GuildProduct.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x4) == 4) this.skillList_ = Collections.unmodifiableList(this.skillList_);
                if ((mutable_bitField0_ & 0x8) == 8)
                    this.productList_ = Collections.unmodifiableList(this.productList_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GuildTechHandler.internal_static_pomelo_area_GuildTechInfo_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return GuildTechHandler.internal_static_pomelo_area_GuildTechInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildTechInfo.class, Builder.class);
        }

        public static Parser<GuildTechInfo> PARSER = (Parser<GuildTechInfo>) new AbstractParser<GuildTechInfo>() {
            public GuildTechHandler.GuildTechInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GuildTechHandler.GuildTechInfo(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int LEVEL_FIELD_NUMBER = 1;
        private int level_;
        public static final int BUFFINFO_FIELD_NUMBER = 2;
        private GuildTechHandler.GuildBuff buffInfo_;
        public static final int SKILLLIST_FIELD_NUMBER = 3;
        private List<GuildTechHandler.GuildSkill> skillList_;
        public static final int PRODUCTLIST_FIELD_NUMBER = 4;
        private List<GuildTechHandler.GuildProduct> productList_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GuildTechInfo> getParserForType() {
            return PARSER;
        }

        public boolean hasLevel() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getLevel() {
            return this.level_;
        }

        public boolean hasBuffInfo() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public GuildTechHandler.GuildBuff getBuffInfo() {
            return this.buffInfo_;
        }

        public GuildTechHandler.GuildBuffOrBuilder getBuffInfoOrBuilder() {
            return this.buffInfo_;
        }

        public List<GuildTechHandler.GuildSkill> getSkillListList() {
            return this.skillList_;
        }

        static {
            defaultInstance.initFields();
        }


        public List<? extends GuildTechHandler.GuildSkillOrBuilder> getSkillListOrBuilderList() {
            return (List) this.skillList_;
        }


        public int getSkillListCount() {
            return this.skillList_.size();
        }


        public GuildTechHandler.GuildSkill getSkillList(int index) {
            return this.skillList_.get(index);
        }


        public GuildTechHandler.GuildSkillOrBuilder getSkillListOrBuilder(int index) {
            return this.skillList_.get(index);
        }


        public List<GuildTechHandler.GuildProduct> getProductListList() {
            return this.productList_;
        }


        public List<? extends GuildTechHandler.GuildProductOrBuilder> getProductListOrBuilderList() {
            return (List) this.productList_;
        }


        public int getProductListCount() {
            return this.productList_.size();
        }


        public GuildTechHandler.GuildProduct getProductList(int index) {
            return this.productList_.get(index);
        }


        public GuildTechHandler.GuildProductOrBuilder getProductListOrBuilder(int index) {
            return this.productList_.get(index);
        }


        private void initFields() {
            this.level_ = 0;
            this.buffInfo_ = GuildTechHandler.GuildBuff.getDefaultInstance();
            this.skillList_ = Collections.emptyList();
            this.productList_ = Collections.emptyList();
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (hasBuffInfo() && !getBuffInfo().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            int i;
            for (i = 0; i < getSkillListCount(); i++) {
                if (!getSkillList(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (i = 0; i < getProductListCount(); i++) {
                if (!getProductList(i).isInitialized()) {
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
                output.writeInt32(1, this.level_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeMessage(2, (MessageLite) this.buffInfo_);
            }
            int i;
            for (i = 0; i < this.skillList_.size(); i++) {
                output.writeMessage(3, (MessageLite) this.skillList_.get(i));
            }
            for (i = 0; i < this.productList_.size(); i++) {
                output.writeMessage(4, (MessageLite) this.productList_.get(i));
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
                size += CodedOutputStream.computeInt32Size(1, this.level_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeMessageSize(2, (MessageLite) this.buffInfo_);
            }
            int i;
            for (i = 0; i < this.skillList_.size(); i++) {
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.skillList_.get(i));
            }
            for (i = 0; i < this.productList_.size(); i++) {
                size += CodedOutputStream.computeMessageSize(4, (MessageLite) this.productList_.get(i));
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static GuildTechInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GuildTechInfo) PARSER.parseFrom(data);
        }


        public static GuildTechInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GuildTechInfo) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GuildTechInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GuildTechInfo) PARSER.parseFrom(data);
        }


        public static GuildTechInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GuildTechInfo) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GuildTechInfo parseFrom(InputStream input) throws IOException {
            return (GuildTechInfo) PARSER.parseFrom(input);
        }


        public static GuildTechInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GuildTechInfo) PARSER.parseFrom(input, extensionRegistry);
        }


        public static GuildTechInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (GuildTechInfo) PARSER.parseDelimitedFrom(input);
        }


        public static GuildTechInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GuildTechInfo) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static GuildTechInfo parseFrom(CodedInputStream input) throws IOException {
            return (GuildTechInfo) PARSER.parseFrom(input);
        }


        public static GuildTechInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GuildTechInfo) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(GuildTechInfo prototype) {
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
                implements GuildTechHandler.GuildTechInfoOrBuilder {
            private int bitField0_;

            private int level_;

            private GuildTechHandler.GuildBuff buffInfo_;

            private SingleFieldBuilder<GuildTechHandler.GuildBuff, GuildTechHandler.GuildBuff.Builder, GuildTechHandler.GuildBuffOrBuilder> buffInfoBuilder_;

            private List<GuildTechHandler.GuildSkill> skillList_;

            private RepeatedFieldBuilder<GuildTechHandler.GuildSkill, GuildTechHandler.GuildSkill.Builder, GuildTechHandler.GuildSkillOrBuilder> skillListBuilder_;

            private List<GuildTechHandler.GuildProduct> productList_;

            private RepeatedFieldBuilder<GuildTechHandler.GuildProduct, GuildTechHandler.GuildProduct.Builder, GuildTechHandler.GuildProductOrBuilder> productListBuilder_;


            public static final Descriptors.Descriptor getDescriptor() {
                return GuildTechHandler.internal_static_pomelo_area_GuildTechInfo_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return GuildTechHandler.internal_static_pomelo_area_GuildTechInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildTechHandler.GuildTechInfo.class, Builder.class);
            }


            private Builder() {
                this.buffInfo_ = GuildTechHandler.GuildBuff.getDefaultInstance();
                this.skillList_ = Collections.emptyList();
                this.productList_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.buffInfo_ = GuildTechHandler.GuildBuff.getDefaultInstance();
                this.skillList_ = Collections.emptyList();
                this.productList_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (GuildTechHandler.GuildTechInfo.alwaysUseFieldBuilders) {
                    getBuffInfoFieldBuilder();
                    getSkillListFieldBuilder();
                    getProductListFieldBuilder();
                }
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.level_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                if (this.buffInfoBuilder_ == null) {
                    this.buffInfo_ = GuildTechHandler.GuildBuff.getDefaultInstance();
                } else {
                    this.buffInfoBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFD;
                if (this.skillListBuilder_ == null) {
                    this.skillList_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                } else {
                    this.skillListBuilder_.clear();
                }
                if (this.productListBuilder_ == null) {
                    this.productList_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFF7;
                } else {
                    this.productListBuilder_.clear();
                }
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return GuildTechHandler.internal_static_pomelo_area_GuildTechInfo_descriptor;
            }


            public GuildTechHandler.GuildTechInfo getDefaultInstanceForType() {
                return GuildTechHandler.GuildTechInfo.getDefaultInstance();
            }


            public GuildTechHandler.GuildTechInfo build() {
                GuildTechHandler.GuildTechInfo result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public GuildTechHandler.GuildTechInfo buildPartial() {
                GuildTechHandler.GuildTechInfo result = new GuildTechHandler.GuildTechInfo(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.level_ = this.level_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                if (this.buffInfoBuilder_ == null) {
                    result.buffInfo_ = this.buffInfo_;
                } else {
                    result.buffInfo_ = (GuildTechHandler.GuildBuff) this.buffInfoBuilder_.build();
                }
                if (this.skillListBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4) {
                        this.skillList_ = Collections.unmodifiableList(this.skillList_);
                        this.bitField0_ &= 0xFFFFFFFB;
                    }
                    result.skillList_ = this.skillList_;
                } else {
                    result.skillList_ = this.skillListBuilder_.build();
                }
                if (this.productListBuilder_ == null) {
                    if ((this.bitField0_ & 0x8) == 8) {
                        this.productList_ = Collections.unmodifiableList(this.productList_);
                        this.bitField0_ &= 0xFFFFFFF7;
                    }
                    result.productList_ = this.productList_;
                } else {
                    result.productList_ = this.productListBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof GuildTechHandler.GuildTechInfo) {
                    return mergeFrom((GuildTechHandler.GuildTechInfo) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(GuildTechHandler.GuildTechInfo other) {
                if (other == GuildTechHandler.GuildTechInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.hasLevel()) {
                    setLevel(other.getLevel());
                }
                if (other.hasBuffInfo()) {
                    mergeBuffInfo(other.getBuffInfo());
                }
                if (this.skillListBuilder_ == null) {
                    if (!other.skillList_.isEmpty()) {
                        if (this.skillList_.isEmpty()) {
                            this.skillList_ = other.skillList_;
                            this.bitField0_ &= 0xFFFFFFFB;
                        } else {
                            ensureSkillListIsMutable();
                            this.skillList_.addAll(other.skillList_);
                        }
                        onChanged();
                    }
                } else if (!other.skillList_.isEmpty()) {
                    if (this.skillListBuilder_.isEmpty()) {
                        this.skillListBuilder_.dispose();
                        this.skillListBuilder_ = null;
                        this.skillList_ = other.skillList_;
                        this.bitField0_ &= 0xFFFFFFFB;
                        this.skillListBuilder_ = GuildTechHandler.GuildTechInfo.alwaysUseFieldBuilders ? getSkillListFieldBuilder() : null;
                    } else {
                        this.skillListBuilder_.addAllMessages(other.skillList_);
                    }
                }
                if (this.productListBuilder_ == null) {
                    if (!other.productList_.isEmpty()) {
                        if (this.productList_.isEmpty()) {
                            this.productList_ = other.productList_;
                            this.bitField0_ &= 0xFFFFFFF7;
                        } else {
                            ensureProductListIsMutable();
                            this.productList_.addAll(other.productList_);
                        }
                        onChanged();
                    }
                } else if (!other.productList_.isEmpty()) {
                    if (this.productListBuilder_.isEmpty()) {
                        this.productListBuilder_.dispose();
                        this.productListBuilder_ = null;
                        this.productList_ = other.productList_;
                        this.bitField0_ &= 0xFFFFFFF7;
                        this.productListBuilder_ = GuildTechHandler.GuildTechInfo.alwaysUseFieldBuilders ? getProductListFieldBuilder() : null;
                    } else {
                        this.productListBuilder_.addAllMessages(other.productList_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (hasBuffInfo() && !getBuffInfo().isInitialized()) {
                    return false;
                }
                int i;
                for (i = 0; i < getSkillListCount(); i++) {
                    if (!getSkillList(i).isInitialized()) {
                        return false;
                    }
                }
                for (i = 0; i < getProductListCount(); i++) {
                    if (!getProductList(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                GuildTechHandler.GuildTechInfo parsedMessage = null;
                try {
                    parsedMessage = (GuildTechHandler.GuildTechInfo) GuildTechHandler.GuildTechInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (GuildTechHandler.GuildTechInfo) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasLevel() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public int getLevel() {
                return this.level_;
            }


            public Builder setLevel(int value) {
                this.bitField0_ |= 0x1;
                this.level_ = value;
                onChanged();
                return this;
            }


            public Builder clearLevel() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.level_ = 0;
                onChanged();
                return this;
            }


            public boolean hasBuffInfo() {
                return ((this.bitField0_ & 0x2) == 2);
            }


            public GuildTechHandler.GuildBuff getBuffInfo() {
                if (this.buffInfoBuilder_ == null) {
                    return this.buffInfo_;
                }
                return (GuildTechHandler.GuildBuff) this.buffInfoBuilder_.getMessage();
            }


            public Builder setBuffInfo(GuildTechHandler.GuildBuff value) {
                if (this.buffInfoBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.buffInfo_ = value;
                    onChanged();
                } else {
                    this.buffInfoBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x2;
                return this;
            }


            public Builder setBuffInfo(GuildTechHandler.GuildBuff.Builder builderForValue) {
                if (this.buffInfoBuilder_ == null) {
                    this.buffInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.buffInfoBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x2;
                return this;
            }


            public Builder mergeBuffInfo(GuildTechHandler.GuildBuff value) {
                if (this.buffInfoBuilder_ == null) {
                    if ((this.bitField0_ & 0x2) == 2 && this.buffInfo_ != GuildTechHandler.GuildBuff.getDefaultInstance()) {
                        this.buffInfo_ = GuildTechHandler.GuildBuff.newBuilder(this.buffInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.buffInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.buffInfoBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x2;
                return this;
            }


            public Builder clearBuffInfo() {
                if (this.buffInfoBuilder_ == null) {
                    this.buffInfo_ = GuildTechHandler.GuildBuff.getDefaultInstance();
                    onChanged();
                } else {
                    this.buffInfoBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }


            public GuildTechHandler.GuildBuff.Builder getBuffInfoBuilder() {
                this.bitField0_ |= 0x2;
                onChanged();
                return (GuildTechHandler.GuildBuff.Builder) getBuffInfoFieldBuilder().getBuilder();
            }


            public GuildTechHandler.GuildBuffOrBuilder getBuffInfoOrBuilder() {
                if (this.buffInfoBuilder_ != null) {
                    return (GuildTechHandler.GuildBuffOrBuilder) this.buffInfoBuilder_.getMessageOrBuilder();
                }
                return this.buffInfo_;
            }


            private SingleFieldBuilder<GuildTechHandler.GuildBuff, GuildTechHandler.GuildBuff.Builder, GuildTechHandler.GuildBuffOrBuilder> getBuffInfoFieldBuilder() {
                if (this.buffInfoBuilder_ == null) {
                    this.buffInfoBuilder_ = new SingleFieldBuilder(getBuffInfo(), getParentForChildren(), isClean());
                    this.buffInfo_ = null;
                }
                return this.buffInfoBuilder_;
            }


            private void ensureSkillListIsMutable() {
                if ((this.bitField0_ & 0x4) != 4) {
                    this.skillList_ = new ArrayList<>(this.skillList_);
                    this.bitField0_ |= 0x4;
                }
            }


            public List<GuildTechHandler.GuildSkill> getSkillListList() {
                if (this.skillListBuilder_ == null) {
                    return Collections.unmodifiableList(this.skillList_);
                }
                return this.skillListBuilder_.getMessageList();
            }

            public int getSkillListCount() {
                if (this.skillListBuilder_ == null) {
                    return this.skillList_.size();
                }
                return this.skillListBuilder_.getCount();
            }

            public GuildTechHandler.GuildSkill getSkillList(int index) {
                if (this.skillListBuilder_ == null) {
                    return this.skillList_.get(index);
                }
                return (GuildTechHandler.GuildSkill) this.skillListBuilder_.getMessage(index);
            }

            public Builder setSkillList(int index, GuildTechHandler.GuildSkill value) {
                if (this.skillListBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureSkillListIsMutable();
                    this.skillList_.set(index, value);
                    onChanged();
                } else {
                    this.skillListBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setSkillList(int index, GuildTechHandler.GuildSkill.Builder builderForValue) {
                if (this.skillListBuilder_ == null) {
                    ensureSkillListIsMutable();
                    this.skillList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.skillListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addSkillList(GuildTechHandler.GuildSkill value) {
                if (this.skillListBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureSkillListIsMutable();
                    this.skillList_.add(value);
                    onChanged();
                } else {
                    this.skillListBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addSkillList(int index, GuildTechHandler.GuildSkill value) {
                if (this.skillListBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureSkillListIsMutable();
                    this.skillList_.add(index, value);
                    onChanged();
                } else {
                    this.skillListBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addSkillList(GuildTechHandler.GuildSkill.Builder builderForValue) {
                if (this.skillListBuilder_ == null) {
                    ensureSkillListIsMutable();
                    this.skillList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.skillListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addSkillList(int index, GuildTechHandler.GuildSkill.Builder builderForValue) {
                if (this.skillListBuilder_ == null) {
                    ensureSkillListIsMutable();
                    this.skillList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.skillListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllSkillList(Iterable<? extends GuildTechHandler.GuildSkill> values) {
                if (this.skillListBuilder_ == null) {
                    ensureSkillListIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.skillList_);
                    onChanged();
                } else {
                    this.skillListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearSkillList() {
                if (this.skillListBuilder_ == null) {
                    this.skillList_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                    onChanged();
                } else {
                    this.skillListBuilder_.clear();
                }
                return this;
            }

            public Builder removeSkillList(int index) {
                if (this.skillListBuilder_ == null) {
                    ensureSkillListIsMutable();
                    this.skillList_.remove(index);
                    onChanged();
                } else {
                    this.skillListBuilder_.remove(index);
                }
                return this;
            }

            public GuildTechHandler.GuildSkill.Builder getSkillListBuilder(int index) {
                return (GuildTechHandler.GuildSkill.Builder) getSkillListFieldBuilder().getBuilder(index);
            }

            public GuildTechHandler.GuildSkillOrBuilder getSkillListOrBuilder(int index) {
                if (this.skillListBuilder_ == null) {
                    return this.skillList_.get(index);
                }
                return (GuildTechHandler.GuildSkillOrBuilder) this.skillListBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends GuildTechHandler.GuildSkillOrBuilder> getSkillListOrBuilderList() {
                if (this.skillListBuilder_ != null) {
                    return this.skillListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList((List) this.skillList_);
            }

            public GuildTechHandler.GuildSkill.Builder addSkillListBuilder() {
                return (GuildTechHandler.GuildSkill.Builder) getSkillListFieldBuilder().addBuilder(GuildTechHandler.GuildSkill.getDefaultInstance());
            }

            public GuildTechHandler.GuildSkill.Builder addSkillListBuilder(int index) {
                return (GuildTechHandler.GuildSkill.Builder) getSkillListFieldBuilder().addBuilder(index, GuildTechHandler.GuildSkill.getDefaultInstance());
            }

            public List<GuildTechHandler.GuildSkill.Builder> getSkillListBuilderList() {
                return getSkillListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<GuildTechHandler.GuildSkill, GuildTechHandler.GuildSkill.Builder, GuildTechHandler.GuildSkillOrBuilder> getSkillListFieldBuilder() {
                if (this.skillListBuilder_ == null) {
                    this.skillListBuilder_ = new RepeatedFieldBuilder(this.skillList_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
                    this.skillList_ = null;
                }
                return this.skillListBuilder_;
            }

            private void ensureProductListIsMutable() {
                if ((this.bitField0_ & 0x8) != 8) {
                    this.productList_ = new ArrayList<>(this.productList_);
                    this.bitField0_ |= 0x8;
                }
            }

            public List<GuildTechHandler.GuildProduct> getProductListList() {
                if (this.productListBuilder_ == null) {
                    return Collections.unmodifiableList(this.productList_);
                }
                return this.productListBuilder_.getMessageList();
            }

            public int getProductListCount() {
                if (this.productListBuilder_ == null) {
                    return this.productList_.size();
                }
                return this.productListBuilder_.getCount();
            }

            public GuildTechHandler.GuildProduct getProductList(int index) {
                if (this.productListBuilder_ == null) {
                    return this.productList_.get(index);
                }
                return (GuildTechHandler.GuildProduct) this.productListBuilder_.getMessage(index);
            }

            public Builder setProductList(int index, GuildTechHandler.GuildProduct value) {
                if (this.productListBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureProductListIsMutable();
                    this.productList_.set(index, value);
                    onChanged();
                } else {
                    this.productListBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setProductList(int index, GuildTechHandler.GuildProduct.Builder builderForValue) {
                if (this.productListBuilder_ == null) {
                    ensureProductListIsMutable();
                    this.productList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.productListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addProductList(GuildTechHandler.GuildProduct value) {
                if (this.productListBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureProductListIsMutable();
                    this.productList_.add(value);
                    onChanged();
                } else {
                    this.productListBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addProductList(int index, GuildTechHandler.GuildProduct value) {
                if (this.productListBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureProductListIsMutable();
                    this.productList_.add(index, value);
                    onChanged();
                } else {
                    this.productListBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addProductList(GuildTechHandler.GuildProduct.Builder builderForValue) {
                if (this.productListBuilder_ == null) {
                    ensureProductListIsMutable();
                    this.productList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.productListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addProductList(int index, GuildTechHandler.GuildProduct.Builder builderForValue) {
                if (this.productListBuilder_ == null) {
                    ensureProductListIsMutable();
                    this.productList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.productListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllProductList(Iterable<? extends GuildTechHandler.GuildProduct> values) {
                if (this.productListBuilder_ == null) {
                    ensureProductListIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.productList_);
                    onChanged();
                } else {
                    this.productListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearProductList() {
                if (this.productListBuilder_ == null) {
                    this.productList_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFF7;
                    onChanged();
                } else {
                    this.productListBuilder_.clear();
                }
                return this;
            }

            public Builder removeProductList(int index) {
                if (this.productListBuilder_ == null) {
                    ensureProductListIsMutable();
                    this.productList_.remove(index);
                    onChanged();
                } else {
                    this.productListBuilder_.remove(index);
                }
                return this;
            }

            public GuildTechHandler.GuildProduct.Builder getProductListBuilder(int index) {
                return (GuildTechHandler.GuildProduct.Builder) getProductListFieldBuilder().getBuilder(index);
            }

            public GuildTechHandler.GuildProductOrBuilder getProductListOrBuilder(int index) {
                if (this.productListBuilder_ == null) {
                    return this.productList_.get(index);
                }
                return (GuildTechHandler.GuildProductOrBuilder) this.productListBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends GuildTechHandler.GuildProductOrBuilder> getProductListOrBuilderList() {
                if (this.productListBuilder_ != null) {
                    return this.productListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList((List) this.productList_);
            }

            public GuildTechHandler.GuildProduct.Builder addProductListBuilder() {
                return (GuildTechHandler.GuildProduct.Builder) getProductListFieldBuilder().addBuilder(GuildTechHandler.GuildProduct.getDefaultInstance());
            }

            public GuildTechHandler.GuildProduct.Builder addProductListBuilder(int index) {
                return (GuildTechHandler.GuildProduct.Builder) getProductListFieldBuilder().addBuilder(index, GuildTechHandler.GuildProduct.getDefaultInstance());
            }

            public List<GuildTechHandler.GuildProduct.Builder> getProductListBuilderList() {
                return getProductListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<GuildTechHandler.GuildProduct, GuildTechHandler.GuildProduct.Builder, GuildTechHandler.GuildProductOrBuilder> getProductListFieldBuilder() {
                if (this.productListBuilder_ == null) {
                    this.productListBuilder_ = new RepeatedFieldBuilder(this.productList_, ((this.bitField0_ & 0x8) == 8), getParentForChildren(), isClean());
                    this.productList_ = null;
                }
                return this.productListBuilder_;
            }
        }
    }

    public static final class GetGuildTechInfoResponse
            extends GeneratedMessage
            implements GetGuildTechInfoResponseOrBuilder {
        private static final GetGuildTechInfoResponse defaultInstance = new GetGuildTechInfoResponse(true);
        private final UnknownFieldSet unknownFields;

        private GetGuildTechInfoResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetGuildTechInfoResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetGuildTechInfoResponse getDefaultInstance() {
            return defaultInstance;
        }

        public GetGuildTechInfoResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetGuildTechInfoResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString bs;
                    GuildTechHandler.GuildTechInfo.Builder subBuilder;
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
                            if ((this.bitField0_ & 0x4) == 4) subBuilder = this.s2CTechInfo_.toBuilder();
                            this.s2CTechInfo_ = (GuildTechHandler.GuildTechInfo) input.readMessage(GuildTechHandler.GuildTechInfo.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.s2CTechInfo_);
                                this.s2CTechInfo_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 0x4;
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.s2CContribution_ = input.readInt32();
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
            return GuildTechHandler.internal_static_pomelo_area_GetGuildTechInfoResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return GuildTechHandler.internal_static_pomelo_area_GetGuildTechInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetGuildTechInfoResponse.class, Builder.class);
        }

        public static Parser<GetGuildTechInfoResponse> PARSER = (Parser<GetGuildTechInfoResponse>) new AbstractParser<GetGuildTechInfoResponse>() {
            public GuildTechHandler.GetGuildTechInfoResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GuildTechHandler.GetGuildTechInfoResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_TECHINFO_FIELD_NUMBER = 3;
        private GuildTechHandler.GuildTechInfo s2CTechInfo_;
        public static final int S2C_CONTRIBUTION_FIELD_NUMBER = 4;
        private int s2CContribution_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetGuildTechInfoResponse> getParserForType() {
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


        public boolean hasS2CTechInfo() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public GuildTechHandler.GuildTechInfo getS2CTechInfo() {
            return this.s2CTechInfo_;
        }


        public GuildTechHandler.GuildTechInfoOrBuilder getS2CTechInfoOrBuilder() {
            return this.s2CTechInfo_;
        }


        public boolean hasS2CContribution() {
            return ((this.bitField0_ & 0x8) == 8);
        }


        public int getS2CContribution() {
            return this.s2CContribution_;
        }


        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CTechInfo_ = GuildTechHandler.GuildTechInfo.getDefaultInstance();
            this.s2CContribution_ = 0;
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
            if (hasS2CTechInfo() && !getS2CTechInfo().isInitialized()) {
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
                output.writeMessage(3, (MessageLite) this.s2CTechInfo_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                output.writeInt32(4, this.s2CContribution_);
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
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.s2CTechInfo_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                size += CodedOutputStream.computeInt32Size(4, this.s2CContribution_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static GetGuildTechInfoResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetGuildTechInfoResponse) PARSER.parseFrom(data);
        }


        public static GetGuildTechInfoResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetGuildTechInfoResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetGuildTechInfoResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetGuildTechInfoResponse) PARSER.parseFrom(data);
        }


        public static GetGuildTechInfoResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetGuildTechInfoResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetGuildTechInfoResponse parseFrom(InputStream input) throws IOException {
            return (GetGuildTechInfoResponse) PARSER.parseFrom(input);
        }


        public static GetGuildTechInfoResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetGuildTechInfoResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static GetGuildTechInfoResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (GetGuildTechInfoResponse) PARSER.parseDelimitedFrom(input);
        }


        public static GetGuildTechInfoResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetGuildTechInfoResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static GetGuildTechInfoResponse parseFrom(CodedInputStream input) throws IOException {
            return (GetGuildTechInfoResponse) PARSER.parseFrom(input);
        }


        public static GetGuildTechInfoResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetGuildTechInfoResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(GetGuildTechInfoResponse prototype) {
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
                implements GuildTechHandler.GetGuildTechInfoResponseOrBuilder {
            private int bitField0_;


            private int s2CCode_;


            private Object s2CMsg_;


            private GuildTechHandler.GuildTechInfo s2CTechInfo_;


            private SingleFieldBuilder<GuildTechHandler.GuildTechInfo, GuildTechHandler.GuildTechInfo.Builder, GuildTechHandler.GuildTechInfoOrBuilder> s2CTechInfoBuilder_;


            private int s2CContribution_;


            public static final Descriptors.Descriptor getDescriptor() {
                return GuildTechHandler.internal_static_pomelo_area_GetGuildTechInfoResponse_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return GuildTechHandler.internal_static_pomelo_area_GetGuildTechInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildTechHandler.GetGuildTechInfoResponse.class, Builder.class);
            }


            private Builder() {
                this.s2CMsg_ = "";
                this.s2CTechInfo_ = GuildTechHandler.GuildTechInfo.getDefaultInstance();
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CTechInfo_ = GuildTechHandler.GuildTechInfo.getDefaultInstance();
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (GuildTechHandler.GetGuildTechInfoResponse.alwaysUseFieldBuilders) {
                    getS2CTechInfoFieldBuilder();
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
                if (this.s2CTechInfoBuilder_ == null) {
                    this.s2CTechInfo_ = GuildTechHandler.GuildTechInfo.getDefaultInstance();
                } else {
                    this.s2CTechInfoBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                this.s2CContribution_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return GuildTechHandler.internal_static_pomelo_area_GetGuildTechInfoResponse_descriptor;
            }


            public GuildTechHandler.GetGuildTechInfoResponse getDefaultInstanceForType() {
                return GuildTechHandler.GetGuildTechInfoResponse.getDefaultInstance();
            }


            public GuildTechHandler.GetGuildTechInfoResponse build() {
                GuildTechHandler.GetGuildTechInfoResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public GuildTechHandler.GetGuildTechInfoResponse buildPartial() {
                GuildTechHandler.GetGuildTechInfoResponse result = new GuildTechHandler.GetGuildTechInfoResponse(this);
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
                if (this.s2CTechInfoBuilder_ == null) {
                    result.s2CTechInfo_ = this.s2CTechInfo_;
                } else {
                    result.s2CTechInfo_ = (GuildTechHandler.GuildTechInfo) this.s2CTechInfoBuilder_.build();
                }
                if ((from_bitField0_ & 0x8) == 8) {
                    to_bitField0_ |= 0x8;
                }
                result.s2CContribution_ = this.s2CContribution_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof GuildTechHandler.GetGuildTechInfoResponse) {
                    return mergeFrom((GuildTechHandler.GetGuildTechInfoResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(GuildTechHandler.GetGuildTechInfoResponse other) {
                if (other == GuildTechHandler.GetGuildTechInfoResponse.getDefaultInstance()) {
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
                if (other.hasS2CTechInfo()) {
                    mergeS2CTechInfo(other.getS2CTechInfo());
                }
                if (other.hasS2CContribution()) {
                    setS2CContribution(other.getS2CContribution());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasS2CCode()) {
                    return false;
                }
                if (hasS2CTechInfo() && !getS2CTechInfo().isInitialized()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                GuildTechHandler.GetGuildTechInfoResponse parsedMessage = null;
                try {
                    parsedMessage = (GuildTechHandler.GetGuildTechInfoResponse) GuildTechHandler.GetGuildTechInfoResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (GuildTechHandler.GetGuildTechInfoResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = GuildTechHandler.GetGuildTechInfoResponse.getDefaultInstance().getS2CMsg();
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


            public boolean hasS2CTechInfo() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public GuildTechHandler.GuildTechInfo getS2CTechInfo() {
                if (this.s2CTechInfoBuilder_ == null) {
                    return this.s2CTechInfo_;
                }
                return (GuildTechHandler.GuildTechInfo) this.s2CTechInfoBuilder_.getMessage();
            }


            public Builder setS2CTechInfo(GuildTechHandler.GuildTechInfo value) {
                if (this.s2CTechInfoBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.s2CTechInfo_ = value;
                    onChanged();
                } else {
                    this.s2CTechInfoBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }


            public Builder setS2CTechInfo(GuildTechHandler.GuildTechInfo.Builder builderForValue) {
                if (this.s2CTechInfoBuilder_ == null) {
                    this.s2CTechInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.s2CTechInfoBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x4;
                return this;
            }


            public Builder mergeS2CTechInfo(GuildTechHandler.GuildTechInfo value) {
                if (this.s2CTechInfoBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4 && this.s2CTechInfo_ != GuildTechHandler.GuildTechInfo.getDefaultInstance()) {
                        this.s2CTechInfo_ = GuildTechHandler.GuildTechInfo.newBuilder(this.s2CTechInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.s2CTechInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.s2CTechInfoBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }


            public Builder clearS2CTechInfo() {
                if (this.s2CTechInfoBuilder_ == null) {
                    this.s2CTechInfo_ = GuildTechHandler.GuildTechInfo.getDefaultInstance();
                    onChanged();
                } else {
                    this.s2CTechInfoBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }


            public GuildTechHandler.GuildTechInfo.Builder getS2CTechInfoBuilder() {
                this.bitField0_ |= 0x4;
                onChanged();
                return (GuildTechHandler.GuildTechInfo.Builder) getS2CTechInfoFieldBuilder().getBuilder();
            }


            public GuildTechHandler.GuildTechInfoOrBuilder getS2CTechInfoOrBuilder() {
                if (this.s2CTechInfoBuilder_ != null) {
                    return (GuildTechHandler.GuildTechInfoOrBuilder) this.s2CTechInfoBuilder_.getMessageOrBuilder();
                }
                return this.s2CTechInfo_;
            }


            private SingleFieldBuilder<GuildTechHandler.GuildTechInfo, GuildTechHandler.GuildTechInfo.Builder, GuildTechHandler.GuildTechInfoOrBuilder> getS2CTechInfoFieldBuilder() {
                if (this.s2CTechInfoBuilder_ == null) {
                    this.s2CTechInfoBuilder_ = new SingleFieldBuilder(getS2CTechInfo(), getParentForChildren(), isClean());
                    this.s2CTechInfo_ = null;
                }
                return this.s2CTechInfoBuilder_;
            }


            public boolean hasS2CContribution() {
                return ((this.bitField0_ & 0x8) == 8);
            }


            public int getS2CContribution() {
                return this.s2CContribution_;
            }


            public Builder setS2CContribution(int value) {
                this.bitField0_ |= 0x8;
                this.s2CContribution_ = value;
                onChanged();
                return this;
            }


            public Builder clearS2CContribution() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.s2CContribution_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class UpgradeGuildTechResponse
            extends GeneratedMessage
            implements UpgradeGuildTechResponseOrBuilder {
        private static final UpgradeGuildTechResponse defaultInstance = new UpgradeGuildTechResponse(true);
        private final UnknownFieldSet unknownFields;

        private UpgradeGuildTechResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private UpgradeGuildTechResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static UpgradeGuildTechResponse getDefaultInstance() {
            return defaultInstance;
        }

        public UpgradeGuildTechResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private UpgradeGuildTechResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.s2CLevel_ = input.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.s2CFund_ = input.readInt32();
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
            return GuildTechHandler.internal_static_pomelo_area_UpgradeGuildTechResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return GuildTechHandler.internal_static_pomelo_area_UpgradeGuildTechResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(UpgradeGuildTechResponse.class, Builder.class);
        }

        public static Parser<UpgradeGuildTechResponse> PARSER = (Parser<UpgradeGuildTechResponse>) new AbstractParser<UpgradeGuildTechResponse>() {
            public GuildTechHandler.UpgradeGuildTechResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GuildTechHandler.UpgradeGuildTechResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_LEVEL_FIELD_NUMBER = 3;
        private int s2CLevel_;
        public static final int S2C_FUND_FIELD_NUMBER = 4;
        private int s2CFund_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<UpgradeGuildTechResponse> getParserForType() {
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


        public boolean hasS2CLevel() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public int getS2CLevel() {
            return this.s2CLevel_;
        }


        public boolean hasS2CFund() {
            return ((this.bitField0_ & 0x8) == 8);
        }


        public int getS2CFund() {
            return this.s2CFund_;
        }


        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CLevel_ = 0;
            this.s2CFund_ = 0;
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
                output.writeInt32(3, this.s2CLevel_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                output.writeInt32(4, this.s2CFund_);
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
                size += CodedOutputStream.computeInt32Size(3, this.s2CLevel_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                size += CodedOutputStream.computeInt32Size(4, this.s2CFund_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static UpgradeGuildTechResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (UpgradeGuildTechResponse) PARSER.parseFrom(data);
        }


        public static UpgradeGuildTechResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (UpgradeGuildTechResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static UpgradeGuildTechResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (UpgradeGuildTechResponse) PARSER.parseFrom(data);
        }


        public static UpgradeGuildTechResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (UpgradeGuildTechResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static UpgradeGuildTechResponse parseFrom(InputStream input) throws IOException {
            return (UpgradeGuildTechResponse) PARSER.parseFrom(input);
        }


        public static UpgradeGuildTechResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpgradeGuildTechResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static UpgradeGuildTechResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (UpgradeGuildTechResponse) PARSER.parseDelimitedFrom(input);
        }


        public static UpgradeGuildTechResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpgradeGuildTechResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static UpgradeGuildTechResponse parseFrom(CodedInputStream input) throws IOException {
            return (UpgradeGuildTechResponse) PARSER.parseFrom(input);
        }


        public static UpgradeGuildTechResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpgradeGuildTechResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(UpgradeGuildTechResponse prototype) {
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
                implements GuildTechHandler.UpgradeGuildTechResponseOrBuilder {
            private int bitField0_;


            private int s2CCode_;


            private Object s2CMsg_;


            private int s2CLevel_;


            private int s2CFund_;


            public static final Descriptors.Descriptor getDescriptor() {
                return GuildTechHandler.internal_static_pomelo_area_UpgradeGuildTechResponse_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return GuildTechHandler.internal_static_pomelo_area_UpgradeGuildTechResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildTechHandler.UpgradeGuildTechResponse.class, Builder.class);
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
                if (GuildTechHandler.UpgradeGuildTechResponse.alwaysUseFieldBuilders) ;
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
                this.s2CLevel_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.s2CFund_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return GuildTechHandler.internal_static_pomelo_area_UpgradeGuildTechResponse_descriptor;
            }


            public GuildTechHandler.UpgradeGuildTechResponse getDefaultInstanceForType() {
                return GuildTechHandler.UpgradeGuildTechResponse.getDefaultInstance();
            }


            public GuildTechHandler.UpgradeGuildTechResponse build() {
                GuildTechHandler.UpgradeGuildTechResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public GuildTechHandler.UpgradeGuildTechResponse buildPartial() {
                GuildTechHandler.UpgradeGuildTechResponse result = new GuildTechHandler.UpgradeGuildTechResponse(this);
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
                result.s2CLevel_ = this.s2CLevel_;
                if ((from_bitField0_ & 0x8) == 8) {
                    to_bitField0_ |= 0x8;
                }
                result.s2CFund_ = this.s2CFund_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof GuildTechHandler.UpgradeGuildTechResponse) {
                    return mergeFrom((GuildTechHandler.UpgradeGuildTechResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(GuildTechHandler.UpgradeGuildTechResponse other) {
                if (other == GuildTechHandler.UpgradeGuildTechResponse.getDefaultInstance()) {
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
                if (other.hasS2CLevel()) {
                    setS2CLevel(other.getS2CLevel());
                }
                if (other.hasS2CFund()) {
                    setS2CFund(other.getS2CFund());
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
                GuildTechHandler.UpgradeGuildTechResponse parsedMessage = null;
                try {
                    parsedMessage = (GuildTechHandler.UpgradeGuildTechResponse) GuildTechHandler.UpgradeGuildTechResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (GuildTechHandler.UpgradeGuildTechResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = GuildTechHandler.UpgradeGuildTechResponse.getDefaultInstance().getS2CMsg();
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


            public boolean hasS2CLevel() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public int getS2CLevel() {
                return this.s2CLevel_;
            }


            public Builder setS2CLevel(int value) {
                this.bitField0_ |= 0x4;
                this.s2CLevel_ = value;
                onChanged();
                return this;
            }


            public Builder clearS2CLevel() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.s2CLevel_ = 0;
                onChanged();
                return this;
            }


            public boolean hasS2CFund() {
                return ((this.bitField0_ & 0x8) == 8);
            }


            public int getS2CFund() {
                return this.s2CFund_;
            }


            public Builder setS2CFund(int value) {
                this.bitField0_ |= 0x8;
                this.s2CFund_ = value;
                onChanged();
                return this;
            }


            public Builder clearS2CFund() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.s2CFund_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class UpgradeGuildBuffResponse
            extends GeneratedMessage
            implements UpgradeGuildBuffResponseOrBuilder {
        private static final UpgradeGuildBuffResponse defaultInstance = new UpgradeGuildBuffResponse(true);
        private final UnknownFieldSet unknownFields;

        private UpgradeGuildBuffResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private UpgradeGuildBuffResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static UpgradeGuildBuffResponse getDefaultInstance() {
            return defaultInstance;
        }

        public UpgradeGuildBuffResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private UpgradeGuildBuffResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString bs;
                    GuildTechHandler.GuildBuff.Builder subBuilder;
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
                            if ((this.bitField0_ & 0x4) == 4) subBuilder = this.s2CBuffInfo_.toBuilder();
                            this.s2CBuffInfo_ = (GuildTechHandler.GuildBuff) input.readMessage(GuildTechHandler.GuildBuff.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.s2CBuffInfo_);
                                this.s2CBuffInfo_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 0x4;
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.s2CFund_ = input.readInt32();
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
            return GuildTechHandler.internal_static_pomelo_area_UpgradeGuildBuffResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return GuildTechHandler.internal_static_pomelo_area_UpgradeGuildBuffResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(UpgradeGuildBuffResponse.class, Builder.class);
        }

        public static Parser<UpgradeGuildBuffResponse> PARSER = (Parser<UpgradeGuildBuffResponse>) new AbstractParser<UpgradeGuildBuffResponse>() {
            public GuildTechHandler.UpgradeGuildBuffResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GuildTechHandler.UpgradeGuildBuffResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_BUFFINFO_FIELD_NUMBER = 3;
        private GuildTechHandler.GuildBuff s2CBuffInfo_;
        public static final int S2C_FUND_FIELD_NUMBER = 4;
        private int s2CFund_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<UpgradeGuildBuffResponse> getParserForType() {
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


        public boolean hasS2CBuffInfo() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public GuildTechHandler.GuildBuff getS2CBuffInfo() {
            return this.s2CBuffInfo_;
        }


        public GuildTechHandler.GuildBuffOrBuilder getS2CBuffInfoOrBuilder() {
            return this.s2CBuffInfo_;
        }


        public boolean hasS2CFund() {
            return ((this.bitField0_ & 0x8) == 8);
        }


        public int getS2CFund() {
            return this.s2CFund_;
        }


        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CBuffInfo_ = GuildTechHandler.GuildBuff.getDefaultInstance();
            this.s2CFund_ = 0;
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
            if (hasS2CBuffInfo() && !getS2CBuffInfo().isInitialized()) {
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
                output.writeMessage(3, (MessageLite) this.s2CBuffInfo_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                output.writeInt32(4, this.s2CFund_);
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
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.s2CBuffInfo_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                size += CodedOutputStream.computeInt32Size(4, this.s2CFund_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static UpgradeGuildBuffResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (UpgradeGuildBuffResponse) PARSER.parseFrom(data);
        }


        public static UpgradeGuildBuffResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (UpgradeGuildBuffResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static UpgradeGuildBuffResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (UpgradeGuildBuffResponse) PARSER.parseFrom(data);
        }


        public static UpgradeGuildBuffResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (UpgradeGuildBuffResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static UpgradeGuildBuffResponse parseFrom(InputStream input) throws IOException {
            return (UpgradeGuildBuffResponse) PARSER.parseFrom(input);
        }


        public static UpgradeGuildBuffResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpgradeGuildBuffResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static UpgradeGuildBuffResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (UpgradeGuildBuffResponse) PARSER.parseDelimitedFrom(input);
        }


        public static UpgradeGuildBuffResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpgradeGuildBuffResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static UpgradeGuildBuffResponse parseFrom(CodedInputStream input) throws IOException {
            return (UpgradeGuildBuffResponse) PARSER.parseFrom(input);
        }


        public static UpgradeGuildBuffResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpgradeGuildBuffResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(UpgradeGuildBuffResponse prototype) {
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
                implements GuildTechHandler.UpgradeGuildBuffResponseOrBuilder {
            private int bitField0_;


            private int s2CCode_;


            private Object s2CMsg_;


            private GuildTechHandler.GuildBuff s2CBuffInfo_;


            private SingleFieldBuilder<GuildTechHandler.GuildBuff, GuildTechHandler.GuildBuff.Builder, GuildTechHandler.GuildBuffOrBuilder> s2CBuffInfoBuilder_;


            private int s2CFund_;


            public static final Descriptors.Descriptor getDescriptor() {
                return GuildTechHandler.internal_static_pomelo_area_UpgradeGuildBuffResponse_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return GuildTechHandler.internal_static_pomelo_area_UpgradeGuildBuffResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildTechHandler.UpgradeGuildBuffResponse.class, Builder.class);
            }


            private Builder() {
                this.s2CMsg_ = "";
                this.s2CBuffInfo_ = GuildTechHandler.GuildBuff.getDefaultInstance();
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CBuffInfo_ = GuildTechHandler.GuildBuff.getDefaultInstance();
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (GuildTechHandler.UpgradeGuildBuffResponse.alwaysUseFieldBuilders) {
                    getS2CBuffInfoFieldBuilder();
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
                if (this.s2CBuffInfoBuilder_ == null) {
                    this.s2CBuffInfo_ = GuildTechHandler.GuildBuff.getDefaultInstance();
                } else {
                    this.s2CBuffInfoBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                this.s2CFund_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return GuildTechHandler.internal_static_pomelo_area_UpgradeGuildBuffResponse_descriptor;
            }


            public GuildTechHandler.UpgradeGuildBuffResponse getDefaultInstanceForType() {
                return GuildTechHandler.UpgradeGuildBuffResponse.getDefaultInstance();
            }


            public GuildTechHandler.UpgradeGuildBuffResponse build() {
                GuildTechHandler.UpgradeGuildBuffResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public GuildTechHandler.UpgradeGuildBuffResponse buildPartial() {
                GuildTechHandler.UpgradeGuildBuffResponse result = new GuildTechHandler.UpgradeGuildBuffResponse(this);
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
                if (this.s2CBuffInfoBuilder_ == null) {
                    result.s2CBuffInfo_ = this.s2CBuffInfo_;
                } else {
                    result.s2CBuffInfo_ = (GuildTechHandler.GuildBuff) this.s2CBuffInfoBuilder_.build();
                }
                if ((from_bitField0_ & 0x8) == 8) {
                    to_bitField0_ |= 0x8;
                }
                result.s2CFund_ = this.s2CFund_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof GuildTechHandler.UpgradeGuildBuffResponse) {
                    return mergeFrom((GuildTechHandler.UpgradeGuildBuffResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(GuildTechHandler.UpgradeGuildBuffResponse other) {
                if (other == GuildTechHandler.UpgradeGuildBuffResponse.getDefaultInstance()) {
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
                if (other.hasS2CBuffInfo()) {
                    mergeS2CBuffInfo(other.getS2CBuffInfo());
                }
                if (other.hasS2CFund()) {
                    setS2CFund(other.getS2CFund());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasS2CCode()) {
                    return false;
                }
                if (hasS2CBuffInfo() && !getS2CBuffInfo().isInitialized()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                GuildTechHandler.UpgradeGuildBuffResponse parsedMessage = null;
                try {
                    parsedMessage = (GuildTechHandler.UpgradeGuildBuffResponse) GuildTechHandler.UpgradeGuildBuffResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (GuildTechHandler.UpgradeGuildBuffResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = GuildTechHandler.UpgradeGuildBuffResponse.getDefaultInstance().getS2CMsg();
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


            public boolean hasS2CBuffInfo() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public GuildTechHandler.GuildBuff getS2CBuffInfo() {
                if (this.s2CBuffInfoBuilder_ == null) {
                    return this.s2CBuffInfo_;
                }
                return (GuildTechHandler.GuildBuff) this.s2CBuffInfoBuilder_.getMessage();
            }


            public Builder setS2CBuffInfo(GuildTechHandler.GuildBuff value) {
                if (this.s2CBuffInfoBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.s2CBuffInfo_ = value;
                    onChanged();
                } else {
                    this.s2CBuffInfoBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }


            public Builder setS2CBuffInfo(GuildTechHandler.GuildBuff.Builder builderForValue) {
                if (this.s2CBuffInfoBuilder_ == null) {
                    this.s2CBuffInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.s2CBuffInfoBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x4;
                return this;
            }


            public Builder mergeS2CBuffInfo(GuildTechHandler.GuildBuff value) {
                if (this.s2CBuffInfoBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4 && this.s2CBuffInfo_ != GuildTechHandler.GuildBuff.getDefaultInstance()) {
                        this.s2CBuffInfo_ = GuildTechHandler.GuildBuff.newBuilder(this.s2CBuffInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.s2CBuffInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.s2CBuffInfoBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }


            public Builder clearS2CBuffInfo() {
                if (this.s2CBuffInfoBuilder_ == null) {
                    this.s2CBuffInfo_ = GuildTechHandler.GuildBuff.getDefaultInstance();
                    onChanged();
                } else {
                    this.s2CBuffInfoBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }


            public GuildTechHandler.GuildBuff.Builder getS2CBuffInfoBuilder() {
                this.bitField0_ |= 0x4;
                onChanged();
                return (GuildTechHandler.GuildBuff.Builder) getS2CBuffInfoFieldBuilder().getBuilder();
            }


            public GuildTechHandler.GuildBuffOrBuilder getS2CBuffInfoOrBuilder() {
                if (this.s2CBuffInfoBuilder_ != null) {
                    return (GuildTechHandler.GuildBuffOrBuilder) this.s2CBuffInfoBuilder_.getMessageOrBuilder();
                }
                return this.s2CBuffInfo_;
            }


            private SingleFieldBuilder<GuildTechHandler.GuildBuff, GuildTechHandler.GuildBuff.Builder, GuildTechHandler.GuildBuffOrBuilder> getS2CBuffInfoFieldBuilder() {
                if (this.s2CBuffInfoBuilder_ == null) {
                    this.s2CBuffInfoBuilder_ = new SingleFieldBuilder(getS2CBuffInfo(), getParentForChildren(), isClean());
                    this.s2CBuffInfo_ = null;
                }
                return this.s2CBuffInfoBuilder_;
            }


            public boolean hasS2CFund() {
                return ((this.bitField0_ & 0x8) == 8);
            }


            public int getS2CFund() {
                return this.s2CFund_;
            }


            public Builder setS2CFund(int value) {
                this.bitField0_ |= 0x8;
                this.s2CFund_ = value;
                onChanged();
                return this;
            }


            public Builder clearS2CFund() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.s2CFund_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class UpgradeGuildSkillResponse
            extends GeneratedMessage
            implements UpgradeGuildSkillResponseOrBuilder {
        private static final UpgradeGuildSkillResponse defaultInstance = new UpgradeGuildSkillResponse(true);
        private final UnknownFieldSet unknownFields;

        private UpgradeGuildSkillResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private UpgradeGuildSkillResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static UpgradeGuildSkillResponse getDefaultInstance() {
            return defaultInstance;
        }

        public UpgradeGuildSkillResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private UpgradeGuildSkillResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString bs;
                    GuildTechHandler.GuildSkill.Builder subBuilder;
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
                            if ((this.bitField0_ & 0x4) == 4) subBuilder = this.s2CSkillInfo_.toBuilder();
                            this.s2CSkillInfo_ = (GuildTechHandler.GuildSkill) input.readMessage(GuildTechHandler.GuildSkill.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.s2CSkillInfo_);
                                this.s2CSkillInfo_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 0x4;
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.s2CContribution_ = input.readInt32();
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
            return GuildTechHandler.internal_static_pomelo_area_UpgradeGuildSkillResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return GuildTechHandler.internal_static_pomelo_area_UpgradeGuildSkillResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(UpgradeGuildSkillResponse.class, Builder.class);
        }

        public static Parser<UpgradeGuildSkillResponse> PARSER = (Parser<UpgradeGuildSkillResponse>) new AbstractParser<UpgradeGuildSkillResponse>() {
            public GuildTechHandler.UpgradeGuildSkillResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GuildTechHandler.UpgradeGuildSkillResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_SKILLINFO_FIELD_NUMBER = 3;
        private GuildTechHandler.GuildSkill s2CSkillInfo_;
        public static final int S2C_CONTRIBUTION_FIELD_NUMBER = 4;
        private int s2CContribution_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<UpgradeGuildSkillResponse> getParserForType() {
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


        public boolean hasS2CSkillInfo() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public GuildTechHandler.GuildSkill getS2CSkillInfo() {
            return this.s2CSkillInfo_;
        }


        public GuildTechHandler.GuildSkillOrBuilder getS2CSkillInfoOrBuilder() {
            return this.s2CSkillInfo_;
        }


        public boolean hasS2CContribution() {
            return ((this.bitField0_ & 0x8) == 8);
        }


        public int getS2CContribution() {
            return this.s2CContribution_;
        }


        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CSkillInfo_ = GuildTechHandler.GuildSkill.getDefaultInstance();
            this.s2CContribution_ = 0;
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
            if (hasS2CSkillInfo() && !getS2CSkillInfo().isInitialized()) {
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
                output.writeMessage(3, (MessageLite) this.s2CSkillInfo_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                output.writeInt32(4, this.s2CContribution_);
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
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.s2CSkillInfo_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                size += CodedOutputStream.computeInt32Size(4, this.s2CContribution_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static UpgradeGuildSkillResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (UpgradeGuildSkillResponse) PARSER.parseFrom(data);
        }


        public static UpgradeGuildSkillResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (UpgradeGuildSkillResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static UpgradeGuildSkillResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (UpgradeGuildSkillResponse) PARSER.parseFrom(data);
        }


        public static UpgradeGuildSkillResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (UpgradeGuildSkillResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static UpgradeGuildSkillResponse parseFrom(InputStream input) throws IOException {
            return (UpgradeGuildSkillResponse) PARSER.parseFrom(input);
        }


        public static UpgradeGuildSkillResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpgradeGuildSkillResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static UpgradeGuildSkillResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (UpgradeGuildSkillResponse) PARSER.parseDelimitedFrom(input);
        }


        public static UpgradeGuildSkillResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpgradeGuildSkillResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static UpgradeGuildSkillResponse parseFrom(CodedInputStream input) throws IOException {
            return (UpgradeGuildSkillResponse) PARSER.parseFrom(input);
        }


        public static UpgradeGuildSkillResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpgradeGuildSkillResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(UpgradeGuildSkillResponse prototype) {
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
                implements GuildTechHandler.UpgradeGuildSkillResponseOrBuilder {
            private int bitField0_;


            private int s2CCode_;


            private Object s2CMsg_;


            private GuildTechHandler.GuildSkill s2CSkillInfo_;


            private SingleFieldBuilder<GuildTechHandler.GuildSkill, GuildTechHandler.GuildSkill.Builder, GuildTechHandler.GuildSkillOrBuilder> s2CSkillInfoBuilder_;


            private int s2CContribution_;


            public static final Descriptors.Descriptor getDescriptor() {
                return GuildTechHandler.internal_static_pomelo_area_UpgradeGuildSkillResponse_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return GuildTechHandler.internal_static_pomelo_area_UpgradeGuildSkillResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildTechHandler.UpgradeGuildSkillResponse.class, Builder.class);
            }


            private Builder() {
                this.s2CMsg_ = "";
                this.s2CSkillInfo_ = GuildTechHandler.GuildSkill.getDefaultInstance();
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CSkillInfo_ = GuildTechHandler.GuildSkill.getDefaultInstance();
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (GuildTechHandler.UpgradeGuildSkillResponse.alwaysUseFieldBuilders) {
                    getS2CSkillInfoFieldBuilder();
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
                if (this.s2CSkillInfoBuilder_ == null) {
                    this.s2CSkillInfo_ = GuildTechHandler.GuildSkill.getDefaultInstance();
                } else {
                    this.s2CSkillInfoBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                this.s2CContribution_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return GuildTechHandler.internal_static_pomelo_area_UpgradeGuildSkillResponse_descriptor;
            }


            public GuildTechHandler.UpgradeGuildSkillResponse getDefaultInstanceForType() {
                return GuildTechHandler.UpgradeGuildSkillResponse.getDefaultInstance();
            }


            public GuildTechHandler.UpgradeGuildSkillResponse build() {
                GuildTechHandler.UpgradeGuildSkillResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public GuildTechHandler.UpgradeGuildSkillResponse buildPartial() {
                GuildTechHandler.UpgradeGuildSkillResponse result = new GuildTechHandler.UpgradeGuildSkillResponse(this);
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
                if (this.s2CSkillInfoBuilder_ == null) {
                    result.s2CSkillInfo_ = this.s2CSkillInfo_;
                } else {
                    result.s2CSkillInfo_ = (GuildTechHandler.GuildSkill) this.s2CSkillInfoBuilder_.build();
                }
                if ((from_bitField0_ & 0x8) == 8) {
                    to_bitField0_ |= 0x8;
                }
                result.s2CContribution_ = this.s2CContribution_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof GuildTechHandler.UpgradeGuildSkillResponse) {
                    return mergeFrom((GuildTechHandler.UpgradeGuildSkillResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(GuildTechHandler.UpgradeGuildSkillResponse other) {
                if (other == GuildTechHandler.UpgradeGuildSkillResponse.getDefaultInstance()) {
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
                if (other.hasS2CSkillInfo()) {
                    mergeS2CSkillInfo(other.getS2CSkillInfo());
                }
                if (other.hasS2CContribution()) {
                    setS2CContribution(other.getS2CContribution());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasS2CCode()) {
                    return false;
                }
                if (hasS2CSkillInfo() && !getS2CSkillInfo().isInitialized()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                GuildTechHandler.UpgradeGuildSkillResponse parsedMessage = null;
                try {
                    parsedMessage = (GuildTechHandler.UpgradeGuildSkillResponse) GuildTechHandler.UpgradeGuildSkillResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (GuildTechHandler.UpgradeGuildSkillResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = GuildTechHandler.UpgradeGuildSkillResponse.getDefaultInstance().getS2CMsg();
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


            public boolean hasS2CSkillInfo() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public GuildTechHandler.GuildSkill getS2CSkillInfo() {
                if (this.s2CSkillInfoBuilder_ == null) {
                    return this.s2CSkillInfo_;
                }
                return (GuildTechHandler.GuildSkill) this.s2CSkillInfoBuilder_.getMessage();
            }


            public Builder setS2CSkillInfo(GuildTechHandler.GuildSkill value) {
                if (this.s2CSkillInfoBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.s2CSkillInfo_ = value;
                    onChanged();
                } else {
                    this.s2CSkillInfoBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }


            public Builder setS2CSkillInfo(GuildTechHandler.GuildSkill.Builder builderForValue) {
                if (this.s2CSkillInfoBuilder_ == null) {
                    this.s2CSkillInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.s2CSkillInfoBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x4;
                return this;
            }


            public Builder mergeS2CSkillInfo(GuildTechHandler.GuildSkill value) {
                if (this.s2CSkillInfoBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4 && this.s2CSkillInfo_ != GuildTechHandler.GuildSkill.getDefaultInstance()) {
                        this.s2CSkillInfo_ = GuildTechHandler.GuildSkill.newBuilder(this.s2CSkillInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.s2CSkillInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.s2CSkillInfoBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }


            public Builder clearS2CSkillInfo() {
                if (this.s2CSkillInfoBuilder_ == null) {
                    this.s2CSkillInfo_ = GuildTechHandler.GuildSkill.getDefaultInstance();
                    onChanged();
                } else {
                    this.s2CSkillInfoBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }


            public GuildTechHandler.GuildSkill.Builder getS2CSkillInfoBuilder() {
                this.bitField0_ |= 0x4;
                onChanged();
                return (GuildTechHandler.GuildSkill.Builder) getS2CSkillInfoFieldBuilder().getBuilder();
            }


            public GuildTechHandler.GuildSkillOrBuilder getS2CSkillInfoOrBuilder() {
                if (this.s2CSkillInfoBuilder_ != null) {
                    return (GuildTechHandler.GuildSkillOrBuilder) this.s2CSkillInfoBuilder_.getMessageOrBuilder();
                }
                return this.s2CSkillInfo_;
            }


            private SingleFieldBuilder<GuildTechHandler.GuildSkill, GuildTechHandler.GuildSkill.Builder, GuildTechHandler.GuildSkillOrBuilder> getS2CSkillInfoFieldBuilder() {
                if (this.s2CSkillInfoBuilder_ == null) {
                    this.s2CSkillInfoBuilder_ = new SingleFieldBuilder(getS2CSkillInfo(), getParentForChildren(), isClean());
                    this.s2CSkillInfo_ = null;
                }
                return this.s2CSkillInfoBuilder_;
            }


            public boolean hasS2CContribution() {
                return ((this.bitField0_ & 0x8) == 8);
            }


            public int getS2CContribution() {
                return this.s2CContribution_;
            }


            public Builder setS2CContribution(int value) {
                this.bitField0_ |= 0x8;
                this.s2CContribution_ = value;
                onChanged();
                return this;
            }


            public Builder clearS2CContribution() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.s2CContribution_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class BuyGuildProductResponse
            extends GeneratedMessage
            implements BuyGuildProductResponseOrBuilder {
        private static final BuyGuildProductResponse defaultInstance = new BuyGuildProductResponse(true);
        private final UnknownFieldSet unknownFields;

        private BuyGuildProductResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private BuyGuildProductResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static BuyGuildProductResponse getDefaultInstance() {
            return defaultInstance;
        }

        public BuyGuildProductResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BuyGuildProductResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.s2CId_ = input.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.s2CState_ = input.readInt32();
                            break;
                        case 40:
                            this.bitField0_ |= 0x10;
                            this.s2CContribution_ = input.readInt32();
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
            return GuildTechHandler.internal_static_pomelo_area_BuyGuildProductResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return GuildTechHandler.internal_static_pomelo_area_BuyGuildProductResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(BuyGuildProductResponse.class, Builder.class);
        }

        public static Parser<BuyGuildProductResponse> PARSER = (Parser<BuyGuildProductResponse>) new AbstractParser<BuyGuildProductResponse>() {
            public GuildTechHandler.BuyGuildProductResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GuildTechHandler.BuyGuildProductResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_ID_FIELD_NUMBER = 3;
        private int s2CId_;
        public static final int S2C_STATE_FIELD_NUMBER = 4;
        private int s2CState_;
        public static final int S2C_CONTRIBUTION_FIELD_NUMBER = 5;
        private int s2CContribution_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<BuyGuildProductResponse> getParserForType() {
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


        public boolean hasS2CId() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public int getS2CId() {
            return this.s2CId_;
        }


        public boolean hasS2CState() {
            return ((this.bitField0_ & 0x8) == 8);
        }


        public int getS2CState() {
            return this.s2CState_;
        }


        public boolean hasS2CContribution() {
            return ((this.bitField0_ & 0x10) == 16);
        }


        public int getS2CContribution() {
            return this.s2CContribution_;
        }


        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CId_ = 0;
            this.s2CState_ = 0;
            this.s2CContribution_ = 0;
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
                output.writeInt32(3, this.s2CId_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                output.writeInt32(4, this.s2CState_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                output.writeInt32(5, this.s2CContribution_);
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
                size += CodedOutputStream.computeInt32Size(3, this.s2CId_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                size += CodedOutputStream.computeInt32Size(4, this.s2CState_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                size += CodedOutputStream.computeInt32Size(5, this.s2CContribution_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static BuyGuildProductResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (BuyGuildProductResponse) PARSER.parseFrom(data);
        }


        public static BuyGuildProductResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BuyGuildProductResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static BuyGuildProductResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (BuyGuildProductResponse) PARSER.parseFrom(data);
        }


        public static BuyGuildProductResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BuyGuildProductResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static BuyGuildProductResponse parseFrom(InputStream input) throws IOException {
            return (BuyGuildProductResponse) PARSER.parseFrom(input);
        }


        public static BuyGuildProductResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuyGuildProductResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static BuyGuildProductResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (BuyGuildProductResponse) PARSER.parseDelimitedFrom(input);
        }


        public static BuyGuildProductResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuyGuildProductResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static BuyGuildProductResponse parseFrom(CodedInputStream input) throws IOException {
            return (BuyGuildProductResponse) PARSER.parseFrom(input);
        }


        public static BuyGuildProductResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuyGuildProductResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(BuyGuildProductResponse prototype) {
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
                implements GuildTechHandler.BuyGuildProductResponseOrBuilder {
            private int bitField0_;


            private int s2CCode_;


            private Object s2CMsg_;


            private int s2CId_;


            private int s2CState_;


            private int s2CContribution_;


            public static final Descriptors.Descriptor getDescriptor() {
                return GuildTechHandler.internal_static_pomelo_area_BuyGuildProductResponse_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return GuildTechHandler.internal_static_pomelo_area_BuyGuildProductResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildTechHandler.BuyGuildProductResponse.class, Builder.class);
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
                if (GuildTechHandler.BuyGuildProductResponse.alwaysUseFieldBuilders) ;
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
                this.s2CId_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.s2CState_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                this.s2CContribution_ = 0;
                this.bitField0_ &= 0xFFFFFFEF;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return GuildTechHandler.internal_static_pomelo_area_BuyGuildProductResponse_descriptor;
            }


            public GuildTechHandler.BuyGuildProductResponse getDefaultInstanceForType() {
                return GuildTechHandler.BuyGuildProductResponse.getDefaultInstance();
            }


            public GuildTechHandler.BuyGuildProductResponse build() {
                GuildTechHandler.BuyGuildProductResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public GuildTechHandler.BuyGuildProductResponse buildPartial() {
                GuildTechHandler.BuyGuildProductResponse result = new GuildTechHandler.BuyGuildProductResponse(this);
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
                result.s2CId_ = this.s2CId_;
                if ((from_bitField0_ & 0x8) == 8) {
                    to_bitField0_ |= 0x8;
                }
                result.s2CState_ = this.s2CState_;
                if ((from_bitField0_ & 0x10) == 16) {
                    to_bitField0_ |= 0x10;
                }
                result.s2CContribution_ = this.s2CContribution_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof GuildTechHandler.BuyGuildProductResponse) {
                    return mergeFrom((GuildTechHandler.BuyGuildProductResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(GuildTechHandler.BuyGuildProductResponse other) {
                if (other == GuildTechHandler.BuyGuildProductResponse.getDefaultInstance()) {
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
                if (other.hasS2CId()) {
                    setS2CId(other.getS2CId());
                }
                if (other.hasS2CState()) {
                    setS2CState(other.getS2CState());
                }
                if (other.hasS2CContribution()) {
                    setS2CContribution(other.getS2CContribution());
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
                GuildTechHandler.BuyGuildProductResponse parsedMessage = null;
                try {
                    parsedMessage = (GuildTechHandler.BuyGuildProductResponse) GuildTechHandler.BuyGuildProductResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (GuildTechHandler.BuyGuildProductResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = GuildTechHandler.BuyGuildProductResponse.getDefaultInstance().getS2CMsg();
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


            public boolean hasS2CId() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public int getS2CId() {
                return this.s2CId_;
            }


            public Builder setS2CId(int value) {
                this.bitField0_ |= 0x4;
                this.s2CId_ = value;
                onChanged();
                return this;
            }


            public Builder clearS2CId() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.s2CId_ = 0;
                onChanged();
                return this;
            }


            public boolean hasS2CState() {
                return ((this.bitField0_ & 0x8) == 8);
            }


            public int getS2CState() {
                return this.s2CState_;
            }


            public Builder setS2CState(int value) {
                this.bitField0_ |= 0x8;
                this.s2CState_ = value;
                onChanged();
                return this;
            }


            public Builder clearS2CState() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.s2CState_ = 0;
                onChanged();
                return this;
            }


            public boolean hasS2CContribution() {
                return ((this.bitField0_ & 0x10) == 16);
            }


            public int getS2CContribution() {
                return this.s2CContribution_;
            }


            public Builder setS2CContribution(int value) {
                this.bitField0_ |= 0x10;
                this.s2CContribution_ = value;
                onChanged();
                return this;
            }


            public Builder clearS2CContribution() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.s2CContribution_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class GuildTechRefreshPush
            extends GeneratedMessage
            implements GuildTechRefreshPushOrBuilder {
        private static final GuildTechRefreshPush defaultInstance = new GuildTechRefreshPush(true);
        private final UnknownFieldSet unknownFields;

        private GuildTechRefreshPush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GuildTechRefreshPush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GuildTechRefreshPush getDefaultInstance() {
            return defaultInstance;
        }

        public GuildTechRefreshPush getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GuildTechRefreshPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.type_ = input.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.level_ = input.readInt32();
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
            return GuildTechHandler.internal_static_pomelo_area_GuildTechRefreshPush_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return GuildTechHandler.internal_static_pomelo_area_GuildTechRefreshPush_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildTechRefreshPush.class, Builder.class);
        }

        public static Parser<GuildTechRefreshPush> PARSER = (Parser<GuildTechRefreshPush>) new AbstractParser<GuildTechRefreshPush>() {
            public GuildTechHandler.GuildTechRefreshPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GuildTechHandler.GuildTechRefreshPush(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int TYPE_FIELD_NUMBER = 3;
        private int type_;
        public static final int LEVEL_FIELD_NUMBER = 4;
        private int level_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GuildTechRefreshPush> getParserForType() {
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

        public boolean hasType() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getType() {
            return this.type_;
        }

        public boolean hasLevel() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public int getLevel() {
            return this.level_;
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.type_ = 0;
            this.level_ = 0;
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
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2) output.writeBytes(2, getS2CMsgBytes());
            if ((this.bitField0_ & 0x4) == 4) output.writeInt32(3, this.type_);
            if ((this.bitField0_ & 0x8) == 8) output.writeInt32(4, this.level_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());
            if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeInt32Size(3, this.type_);
            if ((this.bitField0_ & 0x8) == 8) size += CodedOutputStream.computeInt32Size(4, this.level_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static GuildTechRefreshPush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GuildTechRefreshPush) PARSER.parseFrom(data);
        }

        public static GuildTechRefreshPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GuildTechRefreshPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GuildTechRefreshPush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GuildTechRefreshPush) PARSER.parseFrom(data);
        }

        static {
            defaultInstance.initFields();
        }

        public static GuildTechRefreshPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GuildTechRefreshPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GuildTechRefreshPush parseFrom(InputStream input) throws IOException {
            return (GuildTechRefreshPush) PARSER.parseFrom(input);
        }

        public static GuildTechRefreshPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GuildTechRefreshPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static GuildTechRefreshPush parseDelimitedFrom(InputStream input) throws IOException {
            return (GuildTechRefreshPush) PARSER.parseDelimitedFrom(input);
        }

        public static GuildTechRefreshPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GuildTechRefreshPush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static GuildTechRefreshPush parseFrom(CodedInputStream input) throws IOException {
            return (GuildTechRefreshPush) PARSER.parseFrom(input);
        }

        public static GuildTechRefreshPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GuildTechRefreshPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(GuildTechRefreshPush prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements GuildTechHandler.GuildTechRefreshPushOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private int type_;
            private int level_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GuildTechHandler.internal_static_pomelo_area_GuildTechRefreshPush_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return GuildTechHandler.internal_static_pomelo_area_GuildTechRefreshPush_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildTechHandler.GuildTechRefreshPush.class, Builder.class);
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
                if (GuildTechHandler.GuildTechRefreshPush.alwaysUseFieldBuilders) ;
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
                this.type_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.level_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return GuildTechHandler.internal_static_pomelo_area_GuildTechRefreshPush_descriptor;
            }

            public GuildTechHandler.GuildTechRefreshPush getDefaultInstanceForType() {
                return GuildTechHandler.GuildTechRefreshPush.getDefaultInstance();
            }

            public GuildTechHandler.GuildTechRefreshPush build() {
                GuildTechHandler.GuildTechRefreshPush result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public GuildTechHandler.GuildTechRefreshPush buildPartial() {
                GuildTechHandler.GuildTechRefreshPush result = new GuildTechHandler.GuildTechRefreshPush(this);
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
                result.type_ = this.type_;
                if ((from_bitField0_ & 0x8) == 8)
                    to_bitField0_ |= 0x8;
                result.level_ = this.level_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof GuildTechHandler.GuildTechRefreshPush)
                    return mergeFrom((GuildTechHandler.GuildTechRefreshPush) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GuildTechHandler.GuildTechRefreshPush other) {
                if (other == GuildTechHandler.GuildTechRefreshPush.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (other.hasType())
                    setType(other.getType());
                if (other.hasLevel())
                    setLevel(other.getLevel());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                GuildTechHandler.GuildTechRefreshPush parsedMessage = null;
                try {
                    parsedMessage = (GuildTechHandler.GuildTechRefreshPush) GuildTechHandler.GuildTechRefreshPush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (GuildTechHandler.GuildTechRefreshPush) e.getUnfinishedMessage();
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
                this.s2CMsg_ = GuildTechHandler.GuildTechRefreshPush.getDefaultInstance().getS2CMsg();
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

            public boolean hasLevel() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public int getLevel() {
                return this.level_;
            }

            public Builder setLevel(int value) {
                this.bitField0_ |= 0x8;
                this.level_ = value;
                onChanged();
                return this;
            }

            public Builder clearLevel() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.level_ = 0;
                onChanged();
                return this;
            }
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }


    static {
        String[] descriptorData = {"\n\026guildTechHandler.proto\022\013pomelo.area\032\nitem.proto\032\fcommon.proto\"\031\n\027GetGuildTechInfoRequest\"\031\n\027UpgradeGuildTechRequest\"\031\n\027UpgradeGuildBuffRequest\"+\n\030UpgradeGuildSkillRequest\022\017\n\007skillId\030\001 \001(\005\"+\n\026BuyGuildProductRequest\022\021\n\tproductId\030\001 \001(\005\"\001\n\tGuildBuff\022\r\n\005level\030\001 \001(\005\022+\n\fcurrentAttrs\030\002 \003(\0132\025.pomelo.AttributeBase\022(\n\tnextAttrs\030\003 \003(\0132\025.pomelo.AttributeBase\022\020\n\bneedFund\030\004 \001(\005\"î\001\n\nGuildSkill\022\n\n\002id\030\001 \001(\005\022\r\n\005l", "evel\030\002 \001(\005\022\020\n\btechName\030\003 \001(\t\022\017\n\007techDes\030\004 \001(\t\022+\n\fcurrentAttrs\030\005 \003(\0132\025.pomelo.AttributeBase\022(\n\tnextAttrs\030\006 \003(\0132\025.pomelo.AttributeBase\022\030\n\020needContribution\030\007 \001(\005\022\020\n\bneedGold\030\b \001(\005\022\021\n\trecommend\030\t \001(\005\022\f\n\004icon\030\n \001(\t\"¯\001\n\fGuildProduct\022\n\n\002id\030\001 \001(\005\022#\n\004item\030\002 \001(\0132\025.pomelo.item.MiniItem\022\024\n\fitemShowName\030\003 \001(\t\022\r\n\005level\030\004 \001(\005\022\017\n\007upLevel\030\005 \001(\005\022\017\n\007needJob\030\006 \001(\005\022\030\n\020needContribution\030\007 \001(\005\022\r\n\005state\030\b \001(\005\"¤\001\n\rGuildTec", "hInfo\022\r\n\005level\030\001 \001(\005\022(\n\bbuffInfo\030\002 \001(\0132\026.pomelo.area.GuildBuff\022*\n\tskillList\030\003 \003(\0132\027.pomelo.area.GuildSkill\022.\n\013productList\030\004 \003(\0132\031.pomelo.area.GuildProduct\"\001\n\030GetGuildTechInfoResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\0220\n\fs2c_techInfo\030\003 \001(\0132\032.pomelo.area.GuildTechInfo\022\030\n\020s2c_contribution\030\004 \001(\005\"b\n\030UpgradeGuildTechResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\021\n\ts2c_level\030\003 \001(\005\022\020\n\bs2c_fund\030\004 \001(\005\"}\n\030Up", "gradeGuildBuffResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022,\n\fs2c_buffInfo\030\003 \001(\0132\026.pomelo.area.GuildBuff\022\020\n\bs2c_fund\030\004 \001(\005\"\001\n\031UpgradeGuildSkillResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022.\n\rs2c_skillInfo\030\003 \001(\0132\027.pomelo.area.GuildSkill\022\030\n\020s2c_contribution\030\004 \001(\005\"y\n\027BuyGuildProductResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\016\n\006s2c_id\030\003 \001(\005\022\021\n\ts2c_state\030\004 \001(\005\022\030\n\020s2c_contribution\030\005 \001(\005\"V\n\024GuildTechRefr", "eshPush\022\020\n\bs2c_code\030\001 \001(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\f\n\004type\030\003 \001(\005\022\r\n\005level\030\004 \001(\0052\004\n\020guildTechHandler\022f\n\027getGuildTechInfoRequest\022$.pomelo.area.GetGuildTechInfoRequest\032%.pomelo.area.GetGuildTechInfoResponse\022f\n\027upgradeGuildTechRequest\022$.pomelo.area.UpgradeGuildTechRequest\032%.pomelo.area.UpgradeGuildTechResponse\022f\n\027upgradeGuildBuffRequest\022$.pomelo.area.UpgradeGuildBuffRequest\032%.pomelo.area.UpgradeGuildBuffResp", "onse\022i\n\030upgradeGuildSkillRequest\022%.pomelo.area.UpgradeGuildSkillRequest\032&.pomelo.area.UpgradeGuildSkillResponse\022c\n\026buyGuildProductRequest\022#.pomelo.area.BuyGuildProductRequest\032$.pomelo.area.BuyGuildProductResponse2X\n\rguildTechPush\022G\n\024guildTechRefreshPush\022!.pomelo.area.GuildTechRefreshPush\032\f.pomelo.Void"};


        Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root) {
                GuildTechHandler.descriptor = root;
                return null;
            }
        };

        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[]{

                ItemOuterClass.getDescriptor(),
                Common.getDescriptor()}, assigner);
    }

    private static final Descriptors.Descriptor internal_static_pomelo_area_GetGuildTechInfoRequest_descriptor = getDescriptor().getMessageTypes().get(0);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetGuildTechInfoRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetGuildTechInfoRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_area_UpgradeGuildTechRequest_descriptor = getDescriptor().getMessageTypes().get(1);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_UpgradeGuildTechRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_UpgradeGuildTechRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_area_UpgradeGuildBuffRequest_descriptor = getDescriptor().getMessageTypes().get(2);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_UpgradeGuildBuffRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_UpgradeGuildBuffRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_area_UpgradeGuildSkillRequest_descriptor = getDescriptor().getMessageTypes().get(3);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_UpgradeGuildSkillRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_UpgradeGuildSkillRequest_descriptor, new String[]{"SkillId"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_BuyGuildProductRequest_descriptor = getDescriptor().getMessageTypes().get(4);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_BuyGuildProductRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_BuyGuildProductRequest_descriptor, new String[]{"ProductId"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GuildBuff_descriptor = getDescriptor().getMessageTypes().get(5);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GuildBuff_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GuildBuff_descriptor, new String[]{"Level", "CurrentAttrs", "NextAttrs", "NeedFund"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GuildSkill_descriptor = getDescriptor().getMessageTypes().get(6);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GuildSkill_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GuildSkill_descriptor, new String[]{"Id", "Level", "TechName", "TechDes", "CurrentAttrs", "NextAttrs", "NeedContribution", "NeedGold", "Recommend", "Icon"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GuildProduct_descriptor = getDescriptor().getMessageTypes().get(7);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GuildProduct_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GuildProduct_descriptor, new String[]{"Id", "Item", "ItemShowName", "Level", "UpLevel", "NeedJob", "NeedContribution", "State"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GuildTechInfo_descriptor = getDescriptor().getMessageTypes().get(8);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GuildTechInfo_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GuildTechInfo_descriptor, new String[]{"Level", "BuffInfo", "SkillList", "ProductList"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetGuildTechInfoResponse_descriptor = getDescriptor().getMessageTypes().get(9);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetGuildTechInfoResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetGuildTechInfoResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CTechInfo", "S2CContribution"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_UpgradeGuildTechResponse_descriptor = getDescriptor().getMessageTypes().get(10);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_UpgradeGuildTechResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_UpgradeGuildTechResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CLevel", "S2CFund"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_UpgradeGuildBuffResponse_descriptor = getDescriptor().getMessageTypes().get(11);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_UpgradeGuildBuffResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_UpgradeGuildBuffResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CBuffInfo", "S2CFund"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_UpgradeGuildSkillResponse_descriptor = getDescriptor().getMessageTypes().get(12);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_UpgradeGuildSkillResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_UpgradeGuildSkillResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CSkillInfo", "S2CContribution"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_BuyGuildProductResponse_descriptor = getDescriptor().getMessageTypes().get(13);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_BuyGuildProductResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_BuyGuildProductResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CId", "S2CState", "S2CContribution"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GuildTechRefreshPush_descriptor = getDescriptor().getMessageTypes().get(14);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GuildTechRefreshPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GuildTechRefreshPush_descriptor, new String[]{"S2CCode", "S2CMsg", "Type", "Level"});
    private static Descriptors.FileDescriptor descriptor;

    static {
        ItemOuterClass.getDescriptor();
        Common.getDescriptor();
    }

    public static interface GuildTechRefreshPushOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasType();

        int getType();

        boolean hasLevel();

        int getLevel();
    }

    public static interface BuyGuildProductResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasS2CId();

        int getS2CId();

        boolean hasS2CState();

        int getS2CState();

        boolean hasS2CContribution();

        int getS2CContribution();
    }

    public static interface UpgradeGuildSkillResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasS2CSkillInfo();

        GuildTechHandler.GuildSkill getS2CSkillInfo();

        GuildTechHandler.GuildSkillOrBuilder getS2CSkillInfoOrBuilder();

        boolean hasS2CContribution();

        int getS2CContribution();
    }

    public static interface UpgradeGuildBuffResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasS2CBuffInfo();

        GuildTechHandler.GuildBuff getS2CBuffInfo();

        GuildTechHandler.GuildBuffOrBuilder getS2CBuffInfoOrBuilder();

        boolean hasS2CFund();

        int getS2CFund();
    }

    public static interface UpgradeGuildTechResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasS2CLevel();

        int getS2CLevel();

        boolean hasS2CFund();

        int getS2CFund();
    }

    public static interface GetGuildTechInfoResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasS2CTechInfo();

        GuildTechHandler.GuildTechInfo getS2CTechInfo();

        GuildTechHandler.GuildTechInfoOrBuilder getS2CTechInfoOrBuilder();

        boolean hasS2CContribution();

        int getS2CContribution();
    }

    public static interface GuildTechInfoOrBuilder extends MessageOrBuilder {
        boolean hasLevel();

        int getLevel();

        boolean hasBuffInfo();

        GuildTechHandler.GuildBuff getBuffInfo();

        GuildTechHandler.GuildBuffOrBuilder getBuffInfoOrBuilder();

        List<GuildTechHandler.GuildSkill> getSkillListList();

        GuildTechHandler.GuildSkill getSkillList(int param1Int);

        int getSkillListCount();

        List<? extends GuildTechHandler.GuildSkillOrBuilder> getSkillListOrBuilderList();

        GuildTechHandler.GuildSkillOrBuilder getSkillListOrBuilder(int param1Int);

        List<GuildTechHandler.GuildProduct> getProductListList();

        GuildTechHandler.GuildProduct getProductList(int param1Int);

        int getProductListCount();

        List<? extends GuildTechHandler.GuildProductOrBuilder> getProductListOrBuilderList();

        GuildTechHandler.GuildProductOrBuilder getProductListOrBuilder(int param1Int);
    }

    public static interface GuildProductOrBuilder extends MessageOrBuilder {
        boolean hasId();

        int getId();

        boolean hasItem();

        ItemOuterClass.MiniItem getItem();

        ItemOuterClass.MiniItemOrBuilder getItemOrBuilder();

        boolean hasItemShowName();

        String getItemShowName();

        ByteString getItemShowNameBytes();

        boolean hasLevel();

        int getLevel();

        boolean hasUpLevel();

        int getUpLevel();

        boolean hasNeedJob();

        int getNeedJob();

        boolean hasNeedContribution();

        int getNeedContribution();

        boolean hasState();

        int getState();
    }

    public static interface GuildSkillOrBuilder extends MessageOrBuilder {
        boolean hasId();

        int getId();

        boolean hasLevel();

        int getLevel();

        boolean hasTechName();

        String getTechName();

        ByteString getTechNameBytes();

        boolean hasTechDes();

        String getTechDes();

        ByteString getTechDesBytes();

        List<Common.AttributeBase> getCurrentAttrsList();

        Common.AttributeBase getCurrentAttrs(int param1Int);

        int getCurrentAttrsCount();

        List<? extends Common.AttributeBaseOrBuilder> getCurrentAttrsOrBuilderList();

        Common.AttributeBaseOrBuilder getCurrentAttrsOrBuilder(int param1Int);

        List<Common.AttributeBase> getNextAttrsList();

        Common.AttributeBase getNextAttrs(int param1Int);

        int getNextAttrsCount();

        List<? extends Common.AttributeBaseOrBuilder> getNextAttrsOrBuilderList();

        Common.AttributeBaseOrBuilder getNextAttrsOrBuilder(int param1Int);

        boolean hasNeedContribution();

        int getNeedContribution();

        boolean hasNeedGold();

        int getNeedGold();

        boolean hasRecommend();

        int getRecommend();

        boolean hasIcon();

        String getIcon();

        ByteString getIconBytes();
    }

    public static interface GuildBuffOrBuilder extends MessageOrBuilder {
        boolean hasLevel();

        int getLevel();

        List<Common.AttributeBase> getCurrentAttrsList();

        Common.AttributeBase getCurrentAttrs(int param1Int);

        int getCurrentAttrsCount();

        List<? extends Common.AttributeBaseOrBuilder> getCurrentAttrsOrBuilderList();

        Common.AttributeBaseOrBuilder getCurrentAttrsOrBuilder(int param1Int);

        List<Common.AttributeBase> getNextAttrsList();

        Common.AttributeBase getNextAttrs(int param1Int);

        int getNextAttrsCount();

        List<? extends Common.AttributeBaseOrBuilder> getNextAttrsOrBuilderList();

        Common.AttributeBaseOrBuilder getNextAttrsOrBuilder(int param1Int);

        boolean hasNeedFund();

        int getNeedFund();
    }

    public static interface BuyGuildProductRequestOrBuilder extends MessageOrBuilder {
        boolean hasProductId();

        int getProductId();
    }

    public static interface UpgradeGuildSkillRequestOrBuilder extends MessageOrBuilder {
        boolean hasSkillId();

        int getSkillId();
    }

    public static interface UpgradeGuildBuffRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface UpgradeGuildTechRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface GetGuildTechInfoRequestOrBuilder extends MessageOrBuilder {
    }
}


