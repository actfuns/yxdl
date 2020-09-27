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


public final class ResourceHandler {
    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static final class Npc
            extends GeneratedMessage
            implements NpcOrBuilder {
        private static final Npc defaultInstance = new Npc(true);
        private final UnknownFieldSet unknownFields;

        private Npc(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Npc(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Npc getDefaultInstance() {
            return defaultInstance;
        }

        public Npc getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Npc(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.templateId_ = input.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.id_ = input.readUInt32();
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
            return ResourceHandler.internal_static_pomelo_area_Npc_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ResourceHandler.internal_static_pomelo_area_Npc_fieldAccessorTable.ensureFieldAccessorsInitialized(Npc.class, Builder.class);
        }

        public static Parser<Npc> PARSER = (Parser<Npc>) new AbstractParser<Npc>() {
            public ResourceHandler.Npc parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ResourceHandler.Npc(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int TEMPLATEID_FIELD_NUMBER = 1;
        private int templateId_;
        public static final int ID_FIELD_NUMBER = 2;
        private int id_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<Npc> getParserForType() {
            return PARSER;
        }

        public boolean hasTemplateId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getTemplateId() {
            return this.templateId_;
        }

        public boolean hasId() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public int getId() {
            return this.id_;
        }

        private void initFields() {
            this.templateId_ = 0;
            this.id_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasTemplateId()) {
                this.memoizedIsInitialized = 0;
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
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.templateId_);
            if ((this.bitField0_ & 0x2) == 2) output.writeUInt32(2, this.id_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.templateId_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeUInt32Size(2, this.id_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static Npc parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Npc) PARSER.parseFrom(data);
        }

        public static Npc parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Npc) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Npc parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Npc) PARSER.parseFrom(data);
        }

        public static Npc parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Npc) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Npc parseFrom(InputStream input) throws IOException {
            return (Npc) PARSER.parseFrom(input);
        }

        public static Npc parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Npc) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Npc parseDelimitedFrom(InputStream input) throws IOException {
            return (Npc) PARSER.parseDelimitedFrom(input);
        }

        public static Npc parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Npc) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Npc parseFrom(CodedInputStream input) throws IOException {
            return (Npc) PARSER.parseFrom(input);
        }

        public static Npc parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Npc) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Npc prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements ResourceHandler.NpcOrBuilder {
            private int bitField0_;
            private int templateId_;
            private int id_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ResourceHandler.internal_static_pomelo_area_Npc_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return ResourceHandler.internal_static_pomelo_area_Npc_fieldAccessorTable.ensureFieldAccessorsInitialized(ResourceHandler.Npc.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ResourceHandler.Npc.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.templateId_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.id_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return ResourceHandler.internal_static_pomelo_area_Npc_descriptor;
            }

            public ResourceHandler.Npc getDefaultInstanceForType() {
                return ResourceHandler.Npc.getDefaultInstance();
            }

            public ResourceHandler.Npc build() {
                ResourceHandler.Npc result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public ResourceHandler.Npc buildPartial() {
                ResourceHandler.Npc result = new ResourceHandler.Npc(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.templateId_ = this.templateId_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.id_ = this.id_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof ResourceHandler.Npc) return mergeFrom((ResourceHandler.Npc) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ResourceHandler.Npc other) {
                if (other == ResourceHandler.Npc.getDefaultInstance()) return this;
                if (other.hasTemplateId()) setTemplateId(other.getTemplateId());
                if (other.hasId()) setId(other.getId());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasTemplateId()) return false;
                if (!hasId()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                ResourceHandler.Npc parsedMessage = null;
                try {
                    parsedMessage = (ResourceHandler.Npc) ResourceHandler.Npc.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (ResourceHandler.Npc) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasTemplateId() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getTemplateId() {
                return this.templateId_;
            }

            public Builder setTemplateId(int value) {
                this.bitField0_ |= 0x1;
                this.templateId_ = value;
                onChanged();
                return this;
            }

            public Builder clearTemplateId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.templateId_ = 0;
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
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class QueryAreaDataRequest
            extends GeneratedMessage
            implements QueryAreaDataRequestOrBuilder {
        private static final QueryAreaDataRequest defaultInstance = new QueryAreaDataRequest(true);
        private final UnknownFieldSet unknownFields;

        private QueryAreaDataRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private QueryAreaDataRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static QueryAreaDataRequest getDefaultInstance() {
            return defaultInstance;
        }

        public QueryAreaDataRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private QueryAreaDataRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return ResourceHandler.internal_static_pomelo_area_QueryAreaDataRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ResourceHandler.internal_static_pomelo_area_QueryAreaDataRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(QueryAreaDataRequest.class, Builder.class);
        }

        public static Parser<QueryAreaDataRequest> PARSER = (Parser<QueryAreaDataRequest>) new AbstractParser<QueryAreaDataRequest>() {
            public ResourceHandler.QueryAreaDataRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ResourceHandler.QueryAreaDataRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<QueryAreaDataRequest> getParserForType() {
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

        public static QueryAreaDataRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (QueryAreaDataRequest) PARSER.parseFrom(data);
        }

        public static QueryAreaDataRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (QueryAreaDataRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static QueryAreaDataRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (QueryAreaDataRequest) PARSER.parseFrom(data);
        }

        public static QueryAreaDataRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (QueryAreaDataRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static QueryAreaDataRequest parseFrom(InputStream input) throws IOException {
            return (QueryAreaDataRequest) PARSER.parseFrom(input);
        }

        public static QueryAreaDataRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QueryAreaDataRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static QueryAreaDataRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (QueryAreaDataRequest) PARSER.parseDelimitedFrom(input);
        }

        public static QueryAreaDataRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QueryAreaDataRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static QueryAreaDataRequest parseFrom(CodedInputStream input) throws IOException {
            return (QueryAreaDataRequest) PARSER.parseFrom(input);
        }

        public static QueryAreaDataRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QueryAreaDataRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(QueryAreaDataRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements ResourceHandler.QueryAreaDataRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return ResourceHandler.internal_static_pomelo_area_QueryAreaDataRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return ResourceHandler.internal_static_pomelo_area_QueryAreaDataRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ResourceHandler.QueryAreaDataRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ResourceHandler.QueryAreaDataRequest.alwaysUseFieldBuilders) ;
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
                return ResourceHandler.internal_static_pomelo_area_QueryAreaDataRequest_descriptor;
            }

            public ResourceHandler.QueryAreaDataRequest getDefaultInstanceForType() {
                return ResourceHandler.QueryAreaDataRequest.getDefaultInstance();
            }

            public ResourceHandler.QueryAreaDataRequest build() {
                ResourceHandler.QueryAreaDataRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public ResourceHandler.QueryAreaDataRequest buildPartial() {
                ResourceHandler.QueryAreaDataRequest result = new ResourceHandler.QueryAreaDataRequest(this);
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof ResourceHandler.QueryAreaDataRequest)
                    return mergeFrom((ResourceHandler.QueryAreaDataRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ResourceHandler.QueryAreaDataRequest other) {
                if (other == ResourceHandler.QueryAreaDataRequest.getDefaultInstance()) return this;
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                ResourceHandler.QueryAreaDataRequest parsedMessage = null;
                try {
                    parsedMessage = (ResourceHandler.QueryAreaDataRequest) ResourceHandler.QueryAreaDataRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (ResourceHandler.QueryAreaDataRequest) e.getUnfinishedMessage();
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


    public static final class QueryAreaDataResponse
            extends GeneratedMessage
            implements QueryAreaDataResponseOrBuilder {
        private static final QueryAreaDataResponse defaultInstance = new QueryAreaDataResponse(true);
        private final UnknownFieldSet unknownFields;

        private QueryAreaDataResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private QueryAreaDataResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static QueryAreaDataResponse getDefaultInstance() {
            return defaultInstance;
        }

        public QueryAreaDataResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private QueryAreaDataResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.s2CNpcs_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x4;
                            }
                            this.s2CNpcs_.add(input.readMessage(ResourceHandler.Npc.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x4) == 4) this.s2CNpcs_ = Collections.unmodifiableList(this.s2CNpcs_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ResourceHandler.internal_static_pomelo_area_QueryAreaDataResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ResourceHandler.internal_static_pomelo_area_QueryAreaDataResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(QueryAreaDataResponse.class, Builder.class);
        }

        public static Parser<QueryAreaDataResponse> PARSER = (Parser<QueryAreaDataResponse>) new AbstractParser<QueryAreaDataResponse>() {
            public ResourceHandler.QueryAreaDataResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ResourceHandler.QueryAreaDataResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_NPCS_FIELD_NUMBER = 3;
        private List<ResourceHandler.Npc> s2CNpcs_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<QueryAreaDataResponse> getParserForType() {
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

        public List<ResourceHandler.Npc> getS2CNpcsList() {
            return this.s2CNpcs_;
        }

        public List<? extends ResourceHandler.NpcOrBuilder> getS2CNpcsOrBuilderList() {
            return (List) this.s2CNpcs_;
        }

        public int getS2CNpcsCount() {
            return this.s2CNpcs_.size();
        }

        public ResourceHandler.Npc getS2CNpcs(int index) {
            return this.s2CNpcs_.get(index);
        }

        public ResourceHandler.NpcOrBuilder getS2CNpcsOrBuilder(int index) {
            return this.s2CNpcs_.get(index);
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CNpcs_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasS2CCode()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (int i = 0; i < getS2CNpcsCount(); i++) {
                if (!getS2CNpcs(i).isInitialized()) {
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
            for (int i = 0; i < this.s2CNpcs_.size(); i++) output.writeMessage(3, (MessageLite) this.s2CNpcs_.get(i));
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());
            for (int i = 0; i < this.s2CNpcs_.size(); i++)
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.s2CNpcs_.get(i));
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static QueryAreaDataResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (QueryAreaDataResponse) PARSER.parseFrom(data);
        }

        public static QueryAreaDataResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (QueryAreaDataResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static QueryAreaDataResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (QueryAreaDataResponse) PARSER.parseFrom(data);
        }

        static {
            defaultInstance.initFields();
        }

        public static QueryAreaDataResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (QueryAreaDataResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static QueryAreaDataResponse parseFrom(InputStream input) throws IOException {
            return (QueryAreaDataResponse) PARSER.parseFrom(input);
        }

        public static QueryAreaDataResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QueryAreaDataResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static QueryAreaDataResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (QueryAreaDataResponse) PARSER.parseDelimitedFrom(input);
        }

        public static QueryAreaDataResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QueryAreaDataResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static QueryAreaDataResponse parseFrom(CodedInputStream input) throws IOException {
            return (QueryAreaDataResponse) PARSER.parseFrom(input);
        }

        public static QueryAreaDataResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QueryAreaDataResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(QueryAreaDataResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements ResourceHandler.QueryAreaDataResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private List<ResourceHandler.Npc> s2CNpcs_;
            private RepeatedFieldBuilder<ResourceHandler.Npc, ResourceHandler.Npc.Builder, ResourceHandler.NpcOrBuilder> s2CNpcsBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ResourceHandler.internal_static_pomelo_area_QueryAreaDataResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return ResourceHandler.internal_static_pomelo_area_QueryAreaDataResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ResourceHandler.QueryAreaDataResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.s2CNpcs_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CNpcs_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ResourceHandler.QueryAreaDataResponse.alwaysUseFieldBuilders) getS2CNpcsFieldBuilder();
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
                if (this.s2CNpcsBuilder_ == null) {
                    this.s2CNpcs_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                } else {
                    this.s2CNpcsBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return ResourceHandler.internal_static_pomelo_area_QueryAreaDataResponse_descriptor;
            }

            public ResourceHandler.QueryAreaDataResponse getDefaultInstanceForType() {
                return ResourceHandler.QueryAreaDataResponse.getDefaultInstance();
            }

            public ResourceHandler.QueryAreaDataResponse build() {
                ResourceHandler.QueryAreaDataResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public ResourceHandler.QueryAreaDataResponse buildPartial() {
                ResourceHandler.QueryAreaDataResponse result = new ResourceHandler.QueryAreaDataResponse(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.s2CMsg_ = this.s2CMsg_;
                if (this.s2CNpcsBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4) {
                        this.s2CNpcs_ = Collections.unmodifiableList(this.s2CNpcs_);
                        this.bitField0_ &= 0xFFFFFFFB;
                    }
                    result.s2CNpcs_ = this.s2CNpcs_;
                } else {
                    result.s2CNpcs_ = this.s2CNpcsBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof ResourceHandler.QueryAreaDataResponse)
                    return mergeFrom((ResourceHandler.QueryAreaDataResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ResourceHandler.QueryAreaDataResponse other) {
                if (other == ResourceHandler.QueryAreaDataResponse.getDefaultInstance()) return this;
                if (other.hasS2CCode()) setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (this.s2CNpcsBuilder_ == null) {
                    if (!other.s2CNpcs_.isEmpty()) {
                        if (this.s2CNpcs_.isEmpty()) {
                            this.s2CNpcs_ = other.s2CNpcs_;
                            this.bitField0_ &= 0xFFFFFFFB;
                        } else {
                            ensureS2CNpcsIsMutable();
                            this.s2CNpcs_.addAll(other.s2CNpcs_);
                        }
                        onChanged();
                    }
                } else if (!other.s2CNpcs_.isEmpty()) {
                    if (this.s2CNpcsBuilder_.isEmpty()) {
                        this.s2CNpcsBuilder_.dispose();
                        this.s2CNpcsBuilder_ = null;
                        this.s2CNpcs_ = other.s2CNpcs_;
                        this.bitField0_ &= 0xFFFFFFFB;
                        this.s2CNpcsBuilder_ = ResourceHandler.QueryAreaDataResponse.alwaysUseFieldBuilders ? getS2CNpcsFieldBuilder() : null;
                    } else {
                        this.s2CNpcsBuilder_.addAllMessages(other.s2CNpcs_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode()) return false;
                for (int i = 0; i < getS2CNpcsCount(); i++) {
                    if (!getS2CNpcs(i).isInitialized()) return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                ResourceHandler.QueryAreaDataResponse parsedMessage = null;
                try {
                    parsedMessage = (ResourceHandler.QueryAreaDataResponse) ResourceHandler.QueryAreaDataResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (ResourceHandler.QueryAreaDataResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = ResourceHandler.QueryAreaDataResponse.getDefaultInstance().getS2CMsg();
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

            private void ensureS2CNpcsIsMutable() {
                if ((this.bitField0_ & 0x4) != 4) {
                    this.s2CNpcs_ = new ArrayList<>(this.s2CNpcs_);
                    this.bitField0_ |= 0x4;
                }
            }

            public List<ResourceHandler.Npc> getS2CNpcsList() {
                if (this.s2CNpcsBuilder_ == null) return Collections.unmodifiableList(this.s2CNpcs_);
                return this.s2CNpcsBuilder_.getMessageList();
            }

            public int getS2CNpcsCount() {
                if (this.s2CNpcsBuilder_ == null) return this.s2CNpcs_.size();
                return this.s2CNpcsBuilder_.getCount();
            }

            public ResourceHandler.Npc getS2CNpcs(int index) {
                if (this.s2CNpcsBuilder_ == null) return this.s2CNpcs_.get(index);
                return (ResourceHandler.Npc) this.s2CNpcsBuilder_.getMessage(index);
            }

            public Builder setS2CNpcs(int index, ResourceHandler.Npc value) {
                if (this.s2CNpcsBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureS2CNpcsIsMutable();
                    this.s2CNpcs_.set(index, value);
                    onChanged();
                } else {
                    this.s2CNpcsBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setS2CNpcs(int index, ResourceHandler.Npc.Builder builderForValue) {
                if (this.s2CNpcsBuilder_ == null) {
                    ensureS2CNpcsIsMutable();
                    this.s2CNpcs_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CNpcsBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addS2CNpcs(ResourceHandler.Npc value) {
                if (this.s2CNpcsBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureS2CNpcsIsMutable();
                    this.s2CNpcs_.add(value);
                    onChanged();
                } else {
                    this.s2CNpcsBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addS2CNpcs(int index, ResourceHandler.Npc value) {
                if (this.s2CNpcsBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureS2CNpcsIsMutable();
                    this.s2CNpcs_.add(index, value);
                    onChanged();
                } else {
                    this.s2CNpcsBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addS2CNpcs(ResourceHandler.Npc.Builder builderForValue) {
                if (this.s2CNpcsBuilder_ == null) {
                    ensureS2CNpcsIsMutable();
                    this.s2CNpcs_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.s2CNpcsBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addS2CNpcs(int index, ResourceHandler.Npc.Builder builderForValue) {
                if (this.s2CNpcsBuilder_ == null) {
                    ensureS2CNpcsIsMutable();
                    this.s2CNpcs_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CNpcsBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllS2CNpcs(Iterable<? extends ResourceHandler.Npc> values) {
                if (this.s2CNpcsBuilder_ == null) {
                    ensureS2CNpcsIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.s2CNpcs_);
                    onChanged();
                } else {
                    this.s2CNpcsBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearS2CNpcs() {
                if (this.s2CNpcsBuilder_ == null) {
                    this.s2CNpcs_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                    onChanged();
                } else {
                    this.s2CNpcsBuilder_.clear();
                }
                return this;
            }

            public Builder removeS2CNpcs(int index) {
                if (this.s2CNpcsBuilder_ == null) {
                    ensureS2CNpcsIsMutable();
                    this.s2CNpcs_.remove(index);
                    onChanged();
                } else {
                    this.s2CNpcsBuilder_.remove(index);
                }
                return this;
            }

            public ResourceHandler.Npc.Builder getS2CNpcsBuilder(int index) {
                return (ResourceHandler.Npc.Builder) getS2CNpcsFieldBuilder().getBuilder(index);
            }

            public ResourceHandler.NpcOrBuilder getS2CNpcsOrBuilder(int index) {
                if (this.s2CNpcsBuilder_ == null) return this.s2CNpcs_.get(index);
                return (ResourceHandler.NpcOrBuilder) this.s2CNpcsBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends ResourceHandler.NpcOrBuilder> getS2CNpcsOrBuilderList() {
                if (this.s2CNpcsBuilder_ != null) return this.s2CNpcsBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.s2CNpcs_);
            }

            public ResourceHandler.Npc.Builder addS2CNpcsBuilder() {
                return (ResourceHandler.Npc.Builder) getS2CNpcsFieldBuilder().addBuilder(ResourceHandler.Npc.getDefaultInstance());
            }

            public ResourceHandler.Npc.Builder addS2CNpcsBuilder(int index) {
                return (ResourceHandler.Npc.Builder) getS2CNpcsFieldBuilder().addBuilder(index, ResourceHandler.Npc.getDefaultInstance());
            }

            public List<ResourceHandler.Npc.Builder> getS2CNpcsBuilderList() {
                return getS2CNpcsFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<ResourceHandler.Npc, ResourceHandler.Npc.Builder, ResourceHandler.NpcOrBuilder> getS2CNpcsFieldBuilder() {
                if (this.s2CNpcsBuilder_ == null) {
                    this.s2CNpcsBuilder_ = new RepeatedFieldBuilder(this.s2CNpcs_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
                    this.s2CNpcs_ = null;
                }
                return this.s2CNpcsBuilder_;
            }
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }


    static {
        String[] descriptorData = {"\n\025resourceHandler.proto\022\013pomelo.area\"%\n\003Npc\022\022\n\ntemplateId\030\001 \002(\005\022\n\n\002id\030\002 \002(\r\"\026\n\024QueryAreaDataRequest\"^\n\025QueryAreaDataResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\"\n\bs2c_npcs\030\003 \003(\0132\020.pomelo.area.Npc2p\n\017resourceHandler\022]\n\024queryAreaDataRequest\022!.pomelo.area.QueryAreaDataRequest\032\".pomelo.area.QueryAreaDataResponse"};


        Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root) {
                ResourceHandler.descriptor = root;
                return null;
            }
        };

        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[0], assigner);
    }


    private static final Descriptors.Descriptor internal_static_pomelo_area_Npc_descriptor = getDescriptor().getMessageTypes().get(0);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_Npc_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_Npc_descriptor, new String[]{"TemplateId", "Id"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_QueryAreaDataRequest_descriptor = getDescriptor().getMessageTypes().get(1);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_QueryAreaDataRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_QueryAreaDataRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_area_QueryAreaDataResponse_descriptor = getDescriptor().getMessageTypes().get(2);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_QueryAreaDataResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_QueryAreaDataResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CNpcs"});
    private static Descriptors.FileDescriptor descriptor;

    public static interface QueryAreaDataResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        List<ResourceHandler.Npc> getS2CNpcsList();

        ResourceHandler.Npc getS2CNpcs(int param1Int);

        int getS2CNpcsCount();

        List<? extends ResourceHandler.NpcOrBuilder> getS2CNpcsOrBuilderList();

        ResourceHandler.NpcOrBuilder getS2CNpcsOrBuilder(int param1Int);
    }

    public static interface QueryAreaDataRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface NpcOrBuilder extends MessageOrBuilder {
        boolean hasTemplateId();

        int getTemplateId();

        boolean hasId();

        int getId();
    }
}


