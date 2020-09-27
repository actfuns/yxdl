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
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.RepeatedFieldBuilder;
import com.google.protobuf.UnknownFieldSet;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import pomelo.Common;
import pomelo.item.ItemOuterClass;


public final class MailHandler {
    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static final class MailGetAllRequest
            extends GeneratedMessage
            implements MailGetAllRequestOrBuilder {
        private static final MailGetAllRequest defaultInstance = new MailGetAllRequest(true);
        private final UnknownFieldSet unknownFields;

        private MailGetAllRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private MailGetAllRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static MailGetAllRequest getDefaultInstance() {
            return defaultInstance;
        }

        public MailGetAllRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MailGetAllRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return MailHandler.internal_static_pomelo_area_MailGetAllRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MailHandler.internal_static_pomelo_area_MailGetAllRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(MailGetAllRequest.class, Builder.class);
        }

        public static Parser<MailGetAllRequest> PARSER = (Parser<MailGetAllRequest>) new AbstractParser<MailGetAllRequest>() {
            public MailHandler.MailGetAllRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MailHandler.MailGetAllRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<MailGetAllRequest> getParserForType() {
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

        public static MailGetAllRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (MailGetAllRequest) PARSER.parseFrom(data);
        }

        public static MailGetAllRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MailGetAllRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MailGetAllRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (MailGetAllRequest) PARSER.parseFrom(data);
        }

        public static MailGetAllRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MailGetAllRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MailGetAllRequest parseFrom(InputStream input) throws IOException {
            return (MailGetAllRequest) PARSER.parseFrom(input);
        }

        public static MailGetAllRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MailGetAllRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static MailGetAllRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (MailGetAllRequest) PARSER.parseDelimitedFrom(input);
        }

        public static MailGetAllRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MailGetAllRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static MailGetAllRequest parseFrom(CodedInputStream input) throws IOException {
            return (MailGetAllRequest) PARSER.parseFrom(input);
        }

        public static MailGetAllRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MailGetAllRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(MailGetAllRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements MailHandler.MailGetAllRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return MailHandler.internal_static_pomelo_area_MailGetAllRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MailHandler.internal_static_pomelo_area_MailGetAllRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(MailHandler.MailGetAllRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MailHandler.MailGetAllRequest.alwaysUseFieldBuilders) ;
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
                return MailHandler.internal_static_pomelo_area_MailGetAllRequest_descriptor;
            }

            public MailHandler.MailGetAllRequest getDefaultInstanceForType() {
                return MailHandler.MailGetAllRequest.getDefaultInstance();
            }

            public MailHandler.MailGetAllRequest build() {
                MailHandler.MailGetAllRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public MailHandler.MailGetAllRequest buildPartial() {
                MailHandler.MailGetAllRequest result = new MailHandler.MailGetAllRequest(this);
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof MailHandler.MailGetAllRequest)
                    return mergeFrom((MailHandler.MailGetAllRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MailHandler.MailGetAllRequest other) {
                if (other == MailHandler.MailGetAllRequest.getDefaultInstance()) return this;
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                MailHandler.MailGetAllRequest parsedMessage = null;
                try {
                    parsedMessage = (MailHandler.MailGetAllRequest) MailHandler.MailGetAllRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MailHandler.MailGetAllRequest) e.getUnfinishedMessage();
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


    public static final class MailReadNotify
            extends GeneratedMessage
            implements MailReadNotifyOrBuilder {
        private static final MailReadNotify defaultInstance = new MailReadNotify(true);
        private final UnknownFieldSet unknownFields;

        private MailReadNotify(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private MailReadNotify(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static MailReadNotify getDefaultInstance() {
            return defaultInstance;
        }

        public MailReadNotify getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MailReadNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            if ((mutable_bitField0_ & 0x1) != 1) {
                                this.c2SId_ = (LazyStringList) new LazyStringArrayList();
                                mutable_bitField0_ |= 0x1;
                            }
                            this.c2SId_.add(bs);
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x1) == 1) this.c2SId_ = this.c2SId_.getUnmodifiableView();
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MailHandler.internal_static_pomelo_area_MailReadNotify_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MailHandler.internal_static_pomelo_area_MailReadNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(MailReadNotify.class, Builder.class);
        }

        public static Parser<MailReadNotify> PARSER = (Parser<MailReadNotify>) new AbstractParser<MailReadNotify>() {
            public MailHandler.MailReadNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MailHandler.MailReadNotify(input, extensionRegistry);
            }
        };
        public static final int C2S_ID_FIELD_NUMBER = 1;
        private LazyStringList c2SId_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<MailReadNotify> getParserForType() {
            return PARSER;
        }

        public ProtocolStringList getC2SIdList() {
            return (ProtocolStringList) this.c2SId_;
        }

        public int getC2SIdCount() {
            return this.c2SId_.size();
        }

        public String getC2SId(int index) {
            return (String) this.c2SId_.get(index);
        }

        public ByteString getC2SIdBytes(int index) {
            return this.c2SId_.getByteString(index);
        }

        private void initFields() {
            this.c2SId_ = LazyStringArrayList.EMPTY;
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
            for (int i = 0; i < this.c2SId_.size(); i++) output.writeBytes(1, this.c2SId_.getByteString(i));
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            int dataSize = 0;
            for (int i = 0; i < this.c2SId_.size(); i++)
                dataSize += CodedOutputStream.computeBytesSizeNoTag(this.c2SId_.getByteString(i));
            size += dataSize;
            size += 1 * getC2SIdList().size();
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static MailReadNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (MailReadNotify) PARSER.parseFrom(data);
        }

        public static MailReadNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MailReadNotify) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MailReadNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (MailReadNotify) PARSER.parseFrom(data);
        }

        public static MailReadNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MailReadNotify) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MailReadNotify parseFrom(InputStream input) throws IOException {
            return (MailReadNotify) PARSER.parseFrom(input);
        }

        public static MailReadNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MailReadNotify) PARSER.parseFrom(input, extensionRegistry);
        }

        public static MailReadNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (MailReadNotify) PARSER.parseDelimitedFrom(input);
        }

        public static MailReadNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MailReadNotify) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static MailReadNotify parseFrom(CodedInputStream input) throws IOException {
            return (MailReadNotify) PARSER.parseFrom(input);
        }

        public static MailReadNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MailReadNotify) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(MailReadNotify prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements MailHandler.MailReadNotifyOrBuilder {
            private int bitField0_;
            private LazyStringList c2SId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MailHandler.internal_static_pomelo_area_MailReadNotify_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MailHandler.internal_static_pomelo_area_MailReadNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(MailHandler.MailReadNotify.class, Builder.class);
            }

            private Builder() {
                this.c2SId_ = LazyStringArrayList.EMPTY;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.c2SId_ = LazyStringArrayList.EMPTY;
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MailHandler.MailReadNotify.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.c2SId_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return MailHandler.internal_static_pomelo_area_MailReadNotify_descriptor;
            }

            public MailHandler.MailReadNotify getDefaultInstanceForType() {
                return MailHandler.MailReadNotify.getDefaultInstance();
            }

            public MailHandler.MailReadNotify build() {
                MailHandler.MailReadNotify result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public MailHandler.MailReadNotify buildPartial() {
                MailHandler.MailReadNotify result = new MailHandler.MailReadNotify(this);
                int from_bitField0_ = this.bitField0_;
                if ((this.bitField0_ & 0x1) == 1) {
                    this.c2SId_ = this.c2SId_.getUnmodifiableView();
                    this.bitField0_ &= 0xFFFFFFFE;
                }
                result.c2SId_ = this.c2SId_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof MailHandler.MailReadNotify) return mergeFrom((MailHandler.MailReadNotify) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MailHandler.MailReadNotify other) {
                if (other == MailHandler.MailReadNotify.getDefaultInstance()) return this;
                if (!other.c2SId_.isEmpty()) {
                    if (this.c2SId_.isEmpty()) {
                        this.c2SId_ = other.c2SId_;
                        this.bitField0_ &= 0xFFFFFFFE;
                    } else {
                        ensureC2SIdIsMutable();
                        this.c2SId_.addAll((Collection) other.c2SId_);
                    }
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                MailHandler.MailReadNotify parsedMessage = null;
                try {
                    parsedMessage = (MailHandler.MailReadNotify) MailHandler.MailReadNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MailHandler.MailReadNotify) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            private void ensureC2SIdIsMutable() {
                if ((this.bitField0_ & 0x1) != 1) {
                    this.c2SId_ = (LazyStringList) new LazyStringArrayList(this.c2SId_);
                    this.bitField0_ |= 0x1;
                }
            }

            public ProtocolStringList getC2SIdList() {
                return (ProtocolStringList) this.c2SId_.getUnmodifiableView();
            }

            public int getC2SIdCount() {
                return this.c2SId_.size();
            }

            public String getC2SId(int index) {
                return (String) this.c2SId_.get(index);
            }

            public ByteString getC2SIdBytes(int index) {
                return this.c2SId_.getByteString(index);
            }

            public Builder setC2SId(int index, String value) {
                if (value == null) throw new NullPointerException();
                ensureC2SIdIsMutable();
                this.c2SId_.set(index, value);
                onChanged();
                return this;
            }

            public Builder addC2SId(String value) {
                if (value == null) throw new NullPointerException();
                ensureC2SIdIsMutable();
                this.c2SId_.add(value);
                onChanged();
                return this;
            }

            public Builder addAllC2SId(Iterable<String> values) {
                ensureC2SIdIsMutable();
                AbstractMessageLite.Builder.addAll(values, (Collection) this.c2SId_);
                onChanged();
                return this;
            }

            public Builder clearC2SId() {
                this.c2SId_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= 0xFFFFFFFE;
                onChanged();
                return this;
            }

            public Builder addC2SIdBytes(ByteString value) {
                if (value == null) throw new NullPointerException();
                ensureC2SIdIsMutable();
                this.c2SId_.add(value);
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class MailSendMailRequest
            extends GeneratedMessage
            implements MailSendMailRequestOrBuilder {
        private static final MailSendMailRequest defaultInstance = new MailSendMailRequest(true);
        private final UnknownFieldSet unknownFields;

        private MailSendMailRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private MailSendMailRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static MailSendMailRequest getDefaultInstance() {
            return defaultInstance;
        }

        public MailSendMailRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MailSendMailRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.toPlayerId_ = bs;
                            break;
                        case 18:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x2;
                            this.mailTitle_ = bs;
                            break;
                        case 26:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x4;
                            this.mailText_ = bs;
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.mailRead_ = input.readInt32();
                            break;
                        case 42:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x10;
                            this.toPlayerName_ = bs;
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
            return MailHandler.internal_static_pomelo_area_MailSendMailRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MailHandler.internal_static_pomelo_area_MailSendMailRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(MailSendMailRequest.class, Builder.class);
        }

        public static Parser<MailSendMailRequest> PARSER = (Parser<MailSendMailRequest>) new AbstractParser<MailSendMailRequest>() {
            public MailHandler.MailSendMailRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MailHandler.MailSendMailRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int TOPLAYERID_FIELD_NUMBER = 1;
        private Object toPlayerId_;
        public static final int MAILTITLE_FIELD_NUMBER = 2;
        private Object mailTitle_;
        public static final int MAILTEXT_FIELD_NUMBER = 3;
        private Object mailText_;
        public static final int MAILREAD_FIELD_NUMBER = 4;
        private int mailRead_;
        public static final int TOPLAYERNAME_FIELD_NUMBER = 5;
        private Object toPlayerName_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<MailSendMailRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasToPlayerId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public String getToPlayerId() {
            Object ref = this.toPlayerId_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.toPlayerId_ = s;
            return s;
        }

        public ByteString getToPlayerIdBytes() {
            Object ref = this.toPlayerId_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.toPlayerId_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasMailTitle() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public String getMailTitle() {
            Object ref = this.mailTitle_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.mailTitle_ = s;
            return s;
        }

        static {
            defaultInstance.initFields();
        }

        public ByteString getMailTitleBytes() {
            Object ref = this.mailTitle_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.mailTitle_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasMailText() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public String getMailText() {
            Object ref = this.mailText_;
            if (ref instanceof String)
                return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8())
                this.mailText_ = s;
            return s;
        }

        public ByteString getMailTextBytes() {
            Object ref = this.mailText_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.mailText_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasMailRead() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public int getMailRead() {
            return this.mailRead_;
        }

        public boolean hasToPlayerName() {
            return ((this.bitField0_ & 0x10) == 16);
        }

        public String getToPlayerName() {
            Object ref = this.toPlayerName_;
            if (ref instanceof String)
                return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8())
                this.toPlayerName_ = s;
            return s;
        }

        public ByteString getToPlayerNameBytes() {
            Object ref = this.toPlayerName_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.toPlayerName_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        private void initFields() {
            this.toPlayerId_ = "";
            this.mailTitle_ = "";
            this.mailText_ = "";
            this.mailRead_ = 0;
            this.toPlayerName_ = "";
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1)
                return true;
            if (isInitialized == 0)
                return false;
            if (!hasToPlayerId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasMailTitle()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasMailText()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasMailRead()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1)
                output.writeBytes(1, getToPlayerIdBytes());
            if ((this.bitField0_ & 0x2) == 2)
                output.writeBytes(2, getMailTitleBytes());
            if ((this.bitField0_ & 0x4) == 4)
                output.writeBytes(3, getMailTextBytes());
            if ((this.bitField0_ & 0x8) == 8)
                output.writeInt32(4, this.mailRead_);
            if ((this.bitField0_ & 0x10) == 16)
                output.writeBytes(5, getToPlayerNameBytes());
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1)
                return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1)
                size += CodedOutputStream.computeBytesSize(1, getToPlayerIdBytes());
            if ((this.bitField0_ & 0x2) == 2)
                size += CodedOutputStream.computeBytesSize(2, getMailTitleBytes());
            if ((this.bitField0_ & 0x4) == 4)
                size += CodedOutputStream.computeBytesSize(3, getMailTextBytes());
            if ((this.bitField0_ & 0x8) == 8)
                size += CodedOutputStream.computeInt32Size(4, this.mailRead_);
            if ((this.bitField0_ & 0x10) == 16)
                size += CodedOutputStream.computeBytesSize(5, getToPlayerNameBytes());
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static MailSendMailRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (MailSendMailRequest) PARSER.parseFrom(data);
        }

        public static MailSendMailRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MailSendMailRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MailSendMailRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (MailSendMailRequest) PARSER.parseFrom(data);
        }

        public static MailSendMailRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MailSendMailRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MailSendMailRequest parseFrom(InputStream input) throws IOException {
            return (MailSendMailRequest) PARSER.parseFrom(input);
        }

        public static MailSendMailRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MailSendMailRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static MailSendMailRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (MailSendMailRequest) PARSER.parseDelimitedFrom(input);
        }

        public static MailSendMailRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MailSendMailRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static MailSendMailRequest parseFrom(CodedInputStream input) throws IOException {
            return (MailSendMailRequest) PARSER.parseFrom(input);
        }

        public static MailSendMailRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MailSendMailRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(MailSendMailRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements MailHandler.MailSendMailRequestOrBuilder {
            private int bitField0_;
            private Object toPlayerId_;
            private Object mailTitle_;
            private Object mailText_;
            private int mailRead_;
            private Object toPlayerName_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MailHandler.internal_static_pomelo_area_MailSendMailRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MailHandler.internal_static_pomelo_area_MailSendMailRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(MailHandler.MailSendMailRequest.class, Builder.class);
            }

            private Builder() {
                this.toPlayerId_ = "";
                this.mailTitle_ = "";
                this.mailText_ = "";
                this.toPlayerName_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.toPlayerId_ = "";
                this.mailTitle_ = "";
                this.mailText_ = "";
                this.toPlayerName_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MailHandler.MailSendMailRequest.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.toPlayerId_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                this.mailTitle_ = "";
                this.bitField0_ &= 0xFFFFFFFD;
                this.mailText_ = "";
                this.bitField0_ &= 0xFFFFFFFB;
                this.mailRead_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                this.toPlayerName_ = "";
                this.bitField0_ &= 0xFFFFFFEF;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return MailHandler.internal_static_pomelo_area_MailSendMailRequest_descriptor;
            }

            public MailHandler.MailSendMailRequest getDefaultInstanceForType() {
                return MailHandler.MailSendMailRequest.getDefaultInstance();
            }

            public MailHandler.MailSendMailRequest build() {
                MailHandler.MailSendMailRequest result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public MailHandler.MailSendMailRequest buildPartial() {
                MailHandler.MailSendMailRequest result = new MailHandler.MailSendMailRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.toPlayerId_ = this.toPlayerId_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.mailTitle_ = this.mailTitle_;
                if ((from_bitField0_ & 0x4) == 4)
                    to_bitField0_ |= 0x4;
                result.mailText_ = this.mailText_;
                if ((from_bitField0_ & 0x8) == 8)
                    to_bitField0_ |= 0x8;
                result.mailRead_ = this.mailRead_;
                if ((from_bitField0_ & 0x10) == 16)
                    to_bitField0_ |= 0x10;
                result.toPlayerName_ = this.toPlayerName_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof MailHandler.MailSendMailRequest)
                    return mergeFrom((MailHandler.MailSendMailRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MailHandler.MailSendMailRequest other) {
                if (other == MailHandler.MailSendMailRequest.getDefaultInstance())
                    return this;
                if (other.hasToPlayerId()) {
                    this.bitField0_ |= 0x1;
                    this.toPlayerId_ = other.toPlayerId_;
                    onChanged();
                }
                if (other.hasMailTitle()) {
                    this.bitField0_ |= 0x2;
                    this.mailTitle_ = other.mailTitle_;
                    onChanged();
                }
                if (other.hasMailText()) {
                    this.bitField0_ |= 0x4;
                    this.mailText_ = other.mailText_;
                    onChanged();
                }
                if (other.hasMailRead())
                    setMailRead(other.getMailRead());
                if (other.hasToPlayerName()) {
                    this.bitField0_ |= 0x10;
                    this.toPlayerName_ = other.toPlayerName_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasToPlayerId())
                    return false;
                if (!hasMailTitle())
                    return false;
                if (!hasMailText())
                    return false;
                if (!hasMailRead())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                MailHandler.MailSendMailRequest parsedMessage = null;
                try {
                    parsedMessage = (MailHandler.MailSendMailRequest) MailHandler.MailSendMailRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MailHandler.MailSendMailRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null)
                        mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasToPlayerId() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public String getToPlayerId() {
                Object ref = this.toPlayerId_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.toPlayerId_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getToPlayerIdBytes() {
                Object ref = this.toPlayerId_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.toPlayerId_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setToPlayerId(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.toPlayerId_ = value;
                onChanged();
                return this;
            }

            public Builder clearToPlayerId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.toPlayerId_ = MailHandler.MailSendMailRequest.getDefaultInstance().getToPlayerId();
                onChanged();
                return this;
            }

            public Builder setToPlayerIdBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.toPlayerId_ = value;
                onChanged();
                return this;
            }

            public boolean hasMailTitle() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public String getMailTitle() {
                Object ref = this.mailTitle_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.mailTitle_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getMailTitleBytes() {
                Object ref = this.mailTitle_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.mailTitle_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setMailTitle(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x2;
                this.mailTitle_ = value;
                onChanged();
                return this;
            }

            public Builder clearMailTitle() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.mailTitle_ = MailHandler.MailSendMailRequest.getDefaultInstance().getMailTitle();
                onChanged();
                return this;
            }

            public Builder setMailTitleBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x2;
                this.mailTitle_ = value;
                onChanged();
                return this;
            }

            public boolean hasMailText() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public String getMailText() {
                Object ref = this.mailText_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.mailText_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getMailTextBytes() {
                Object ref = this.mailText_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.mailText_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setMailText(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x4;
                this.mailText_ = value;
                onChanged();
                return this;
            }

            public Builder clearMailText() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.mailText_ = MailHandler.MailSendMailRequest.getDefaultInstance().getMailText();
                onChanged();
                return this;
            }

            public Builder setMailTextBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x4;
                this.mailText_ = value;
                onChanged();
                return this;
            }

            public boolean hasMailRead() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public int getMailRead() {
                return this.mailRead_;
            }

            public Builder setMailRead(int value) {
                this.bitField0_ |= 0x8;
                this.mailRead_ = value;
                onChanged();
                return this;
            }

            public Builder clearMailRead() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.mailRead_ = 0;
                onChanged();
                return this;
            }

            public boolean hasToPlayerName() {
                return ((this.bitField0_ & 0x10) == 16);
            }

            public String getToPlayerName() {
                Object ref = this.toPlayerName_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.toPlayerName_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getToPlayerNameBytes() {
                Object ref = this.toPlayerName_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.toPlayerName_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setToPlayerName(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x10;
                this.toPlayerName_ = value;
                onChanged();
                return this;
            }

            public Builder clearToPlayerName() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.toPlayerName_ = MailHandler.MailSendMailRequest.getDefaultInstance().getToPlayerName();
                onChanged();
                return this;
            }

            public Builder setToPlayerNameBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x10;
                this.toPlayerName_ = value;
                onChanged();
                return this;
            }
        }
    }

    public static final class MailGetAttachmentRequest extends GeneratedMessage implements MailGetAttachmentRequestOrBuilder {
        private static final MailGetAttachmentRequest defaultInstance = new MailGetAttachmentRequest(true);
        private final UnknownFieldSet unknownFields;

        private MailGetAttachmentRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private MailGetAttachmentRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static MailGetAttachmentRequest getDefaultInstance() {
            return defaultInstance;
        }

        public MailGetAttachmentRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MailGetAttachmentRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.c2SId_ = bs;
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
            return MailHandler.internal_static_pomelo_area_MailGetAttachmentRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MailHandler.internal_static_pomelo_area_MailGetAttachmentRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(MailGetAttachmentRequest.class, Builder.class);
        }

        public static Parser<MailGetAttachmentRequest> PARSER = (Parser<MailGetAttachmentRequest>) new AbstractParser<MailGetAttachmentRequest>() {
            public MailHandler.MailGetAttachmentRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MailHandler.MailGetAttachmentRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_ID_FIELD_NUMBER = 1;
        private Object c2SId_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<MailGetAttachmentRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasC2SId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public String getC2SId() {
            Object ref = this.c2SId_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.c2SId_ = s;
            return s;
        }

        public ByteString getC2SIdBytes() {
            Object ref = this.c2SId_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.c2SId_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        private void initFields() {
            this.c2SId_ = "";
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
            if ((this.bitField0_ & 0x1) == 1) output.writeBytes(1, getC2SIdBytes());
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeBytesSize(1, getC2SIdBytes());
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static MailGetAttachmentRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (MailGetAttachmentRequest) PARSER.parseFrom(data);
        }

        public static MailGetAttachmentRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MailGetAttachmentRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MailGetAttachmentRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (MailGetAttachmentRequest) PARSER.parseFrom(data);
        }

        public static MailGetAttachmentRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MailGetAttachmentRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MailGetAttachmentRequest parseFrom(InputStream input) throws IOException {
            return (MailGetAttachmentRequest) PARSER.parseFrom(input);
        }

        public static MailGetAttachmentRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MailGetAttachmentRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static MailGetAttachmentRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (MailGetAttachmentRequest) PARSER.parseDelimitedFrom(input);
        }

        public static MailGetAttachmentRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MailGetAttachmentRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static MailGetAttachmentRequest parseFrom(CodedInputStream input) throws IOException {
            return (MailGetAttachmentRequest) PARSER.parseFrom(input);
        }

        public static MailGetAttachmentRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MailGetAttachmentRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(MailGetAttachmentRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements MailHandler.MailGetAttachmentRequestOrBuilder {
            private int bitField0_;
            private Object c2SId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MailHandler.internal_static_pomelo_area_MailGetAttachmentRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MailHandler.internal_static_pomelo_area_MailGetAttachmentRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(MailHandler.MailGetAttachmentRequest.class, Builder.class);
            }

            private Builder() {
                this.c2SId_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.c2SId_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MailHandler.MailGetAttachmentRequest.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.c2SId_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return MailHandler.internal_static_pomelo_area_MailGetAttachmentRequest_descriptor;
            }

            public MailHandler.MailGetAttachmentRequest getDefaultInstanceForType() {
                return MailHandler.MailGetAttachmentRequest.getDefaultInstance();
            }

            public MailHandler.MailGetAttachmentRequest build() {
                MailHandler.MailGetAttachmentRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public MailHandler.MailGetAttachmentRequest buildPartial() {
                MailHandler.MailGetAttachmentRequest result = new MailHandler.MailGetAttachmentRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.c2SId_ = this.c2SId_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof MailHandler.MailGetAttachmentRequest)
                    return mergeFrom((MailHandler.MailGetAttachmentRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MailHandler.MailGetAttachmentRequest other) {
                if (other == MailHandler.MailGetAttachmentRequest.getDefaultInstance()) return this;
                if (other.hasC2SId()) {
                    this.bitField0_ |= 0x1;
                    this.c2SId_ = other.c2SId_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasC2SId()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                MailHandler.MailGetAttachmentRequest parsedMessage = null;
                try {
                    parsedMessage = (MailHandler.MailGetAttachmentRequest) MailHandler.MailGetAttachmentRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MailHandler.MailGetAttachmentRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasC2SId() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public String getC2SId() {
                Object ref = this.c2SId_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) this.c2SId_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getC2SIdBytes() {
                Object ref = this.c2SId_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.c2SId_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setC2SId(String value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.c2SId_ = value;
                onChanged();
                return this;
            }

            public Builder clearC2SId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SId_ = MailHandler.MailGetAttachmentRequest.getDefaultInstance().getC2SId();
                onChanged();
                return this;
            }

            public Builder setC2SIdBytes(ByteString value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.c2SId_ = value;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }
    }


    public static final class MailGetAttachmentOneKeyRequest
            extends GeneratedMessage
            implements MailGetAttachmentOneKeyRequestOrBuilder {
        private static final MailGetAttachmentOneKeyRequest defaultInstance = new MailGetAttachmentOneKeyRequest(true);
        private final UnknownFieldSet unknownFields;

        private MailGetAttachmentOneKeyRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private MailGetAttachmentOneKeyRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static MailGetAttachmentOneKeyRequest getDefaultInstance() {
            return defaultInstance;
        }

        public MailGetAttachmentOneKeyRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MailGetAttachmentOneKeyRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return MailHandler.internal_static_pomelo_area_MailGetAttachmentOneKeyRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MailHandler.internal_static_pomelo_area_MailGetAttachmentOneKeyRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(MailGetAttachmentOneKeyRequest.class, Builder.class);
        }

        public static Parser<MailGetAttachmentOneKeyRequest> PARSER = (Parser<MailGetAttachmentOneKeyRequest>) new AbstractParser<MailGetAttachmentOneKeyRequest>() {
            public MailHandler.MailGetAttachmentOneKeyRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MailHandler.MailGetAttachmentOneKeyRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<MailGetAttachmentOneKeyRequest> getParserForType() {
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

        public static MailGetAttachmentOneKeyRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (MailGetAttachmentOneKeyRequest) PARSER.parseFrom(data);
        }

        public static MailGetAttachmentOneKeyRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MailGetAttachmentOneKeyRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MailGetAttachmentOneKeyRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (MailGetAttachmentOneKeyRequest) PARSER.parseFrom(data);
        }

        public static MailGetAttachmentOneKeyRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MailGetAttachmentOneKeyRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MailGetAttachmentOneKeyRequest parseFrom(InputStream input) throws IOException {
            return (MailGetAttachmentOneKeyRequest) PARSER.parseFrom(input);
        }

        public static MailGetAttachmentOneKeyRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MailGetAttachmentOneKeyRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static MailGetAttachmentOneKeyRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (MailGetAttachmentOneKeyRequest) PARSER.parseDelimitedFrom(input);
        }

        public static MailGetAttachmentOneKeyRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MailGetAttachmentOneKeyRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static MailGetAttachmentOneKeyRequest parseFrom(CodedInputStream input) throws IOException {
            return (MailGetAttachmentOneKeyRequest) PARSER.parseFrom(input);
        }

        public static MailGetAttachmentOneKeyRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MailGetAttachmentOneKeyRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(MailGetAttachmentOneKeyRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements MailHandler.MailGetAttachmentOneKeyRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return MailHandler.internal_static_pomelo_area_MailGetAttachmentOneKeyRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MailHandler.internal_static_pomelo_area_MailGetAttachmentOneKeyRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(MailHandler.MailGetAttachmentOneKeyRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MailHandler.MailGetAttachmentOneKeyRequest.alwaysUseFieldBuilders) ;
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
                return MailHandler.internal_static_pomelo_area_MailGetAttachmentOneKeyRequest_descriptor;
            }

            public MailHandler.MailGetAttachmentOneKeyRequest getDefaultInstanceForType() {
                return MailHandler.MailGetAttachmentOneKeyRequest.getDefaultInstance();
            }

            public MailHandler.MailGetAttachmentOneKeyRequest build() {
                MailHandler.MailGetAttachmentOneKeyRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public MailHandler.MailGetAttachmentOneKeyRequest buildPartial() {
                MailHandler.MailGetAttachmentOneKeyRequest result = new MailHandler.MailGetAttachmentOneKeyRequest(this);
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof MailHandler.MailGetAttachmentOneKeyRequest)
                    return mergeFrom((MailHandler.MailGetAttachmentOneKeyRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MailHandler.MailGetAttachmentOneKeyRequest other) {
                if (other == MailHandler.MailGetAttachmentOneKeyRequest.getDefaultInstance()) return this;
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                MailHandler.MailGetAttachmentOneKeyRequest parsedMessage = null;
                try {
                    parsedMessage = (MailHandler.MailGetAttachmentOneKeyRequest) MailHandler.MailGetAttachmentOneKeyRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MailHandler.MailGetAttachmentOneKeyRequest) e.getUnfinishedMessage();
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


    public static final class MailDeleteRequest
            extends GeneratedMessage
            implements MailDeleteRequestOrBuilder {
        private static final MailDeleteRequest defaultInstance = new MailDeleteRequest(true);
        private final UnknownFieldSet unknownFields;

        private MailDeleteRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private MailDeleteRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static MailDeleteRequest getDefaultInstance() {
            return defaultInstance;
        }

        public MailDeleteRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MailDeleteRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.c2SId_ = bs;
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
            return MailHandler.internal_static_pomelo_area_MailDeleteRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MailHandler.internal_static_pomelo_area_MailDeleteRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(MailDeleteRequest.class, Builder.class);
        }

        public static Parser<MailDeleteRequest> PARSER = (Parser<MailDeleteRequest>) new AbstractParser<MailDeleteRequest>() {
            public MailHandler.MailDeleteRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MailHandler.MailDeleteRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_ID_FIELD_NUMBER = 1;
        private Object c2SId_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<MailDeleteRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasC2SId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public String getC2SId() {
            Object ref = this.c2SId_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.c2SId_ = s;
            return s;
        }

        public ByteString getC2SIdBytes() {
            Object ref = this.c2SId_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.c2SId_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        private void initFields() {
            this.c2SId_ = "";
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
            if ((this.bitField0_ & 0x1) == 1) output.writeBytes(1, getC2SIdBytes());
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeBytesSize(1, getC2SIdBytes());
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static MailDeleteRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (MailDeleteRequest) PARSER.parseFrom(data);
        }

        public static MailDeleteRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MailDeleteRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MailDeleteRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (MailDeleteRequest) PARSER.parseFrom(data);
        }

        public static MailDeleteRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MailDeleteRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MailDeleteRequest parseFrom(InputStream input) throws IOException {
            return (MailDeleteRequest) PARSER.parseFrom(input);
        }

        public static MailDeleteRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MailDeleteRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static MailDeleteRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (MailDeleteRequest) PARSER.parseDelimitedFrom(input);
        }

        public static MailDeleteRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MailDeleteRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static MailDeleteRequest parseFrom(CodedInputStream input) throws IOException {
            return (MailDeleteRequest) PARSER.parseFrom(input);
        }

        public static MailDeleteRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MailDeleteRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(MailDeleteRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements MailHandler.MailDeleteRequestOrBuilder {
            private int bitField0_;
            private Object c2SId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MailHandler.internal_static_pomelo_area_MailDeleteRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MailHandler.internal_static_pomelo_area_MailDeleteRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(MailHandler.MailDeleteRequest.class, Builder.class);
            }

            private Builder() {
                this.c2SId_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.c2SId_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MailHandler.MailDeleteRequest.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.c2SId_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return MailHandler.internal_static_pomelo_area_MailDeleteRequest_descriptor;
            }

            public MailHandler.MailDeleteRequest getDefaultInstanceForType() {
                return MailHandler.MailDeleteRequest.getDefaultInstance();
            }

            public MailHandler.MailDeleteRequest build() {
                MailHandler.MailDeleteRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public MailHandler.MailDeleteRequest buildPartial() {
                MailHandler.MailDeleteRequest result = new MailHandler.MailDeleteRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.c2SId_ = this.c2SId_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof MailHandler.MailDeleteRequest)
                    return mergeFrom((MailHandler.MailDeleteRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MailHandler.MailDeleteRequest other) {
                if (other == MailHandler.MailDeleteRequest.getDefaultInstance()) return this;
                if (other.hasC2SId()) {
                    this.bitField0_ |= 0x1;
                    this.c2SId_ = other.c2SId_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasC2SId()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                MailHandler.MailDeleteRequest parsedMessage = null;
                try {
                    parsedMessage = (MailHandler.MailDeleteRequest) MailHandler.MailDeleteRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MailHandler.MailDeleteRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasC2SId() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public String getC2SId() {
                Object ref = this.c2SId_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) this.c2SId_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getC2SIdBytes() {
                Object ref = this.c2SId_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.c2SId_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setC2SId(String value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.c2SId_ = value;
                onChanged();
                return this;
            }

            public Builder clearC2SId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SId_ = MailHandler.MailDeleteRequest.getDefaultInstance().getC2SId();
                onChanged();
                return this;
            }

            public Builder setC2SIdBytes(ByteString value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.c2SId_ = value;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class MailDeleteOneKeyRequest
            extends GeneratedMessage
            implements MailDeleteOneKeyRequestOrBuilder {
        private static final MailDeleteOneKeyRequest defaultInstance = new MailDeleteOneKeyRequest(true);
        private final UnknownFieldSet unknownFields;

        private MailDeleteOneKeyRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private MailDeleteOneKeyRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static MailDeleteOneKeyRequest getDefaultInstance() {
            return defaultInstance;
        }

        public MailDeleteOneKeyRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MailDeleteOneKeyRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return MailHandler.internal_static_pomelo_area_MailDeleteOneKeyRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MailHandler.internal_static_pomelo_area_MailDeleteOneKeyRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(MailDeleteOneKeyRequest.class, Builder.class);
        }

        public static Parser<MailDeleteOneKeyRequest> PARSER = (Parser<MailDeleteOneKeyRequest>) new AbstractParser<MailDeleteOneKeyRequest>() {
            public MailHandler.MailDeleteOneKeyRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MailHandler.MailDeleteOneKeyRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<MailDeleteOneKeyRequest> getParserForType() {
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

        public static MailDeleteOneKeyRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (MailDeleteOneKeyRequest) PARSER.parseFrom(data);
        }

        public static MailDeleteOneKeyRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MailDeleteOneKeyRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MailDeleteOneKeyRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (MailDeleteOneKeyRequest) PARSER.parseFrom(data);
        }

        public static MailDeleteOneKeyRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MailDeleteOneKeyRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MailDeleteOneKeyRequest parseFrom(InputStream input) throws IOException {
            return (MailDeleteOneKeyRequest) PARSER.parseFrom(input);
        }

        public static MailDeleteOneKeyRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MailDeleteOneKeyRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static MailDeleteOneKeyRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (MailDeleteOneKeyRequest) PARSER.parseDelimitedFrom(input);
        }

        public static MailDeleteOneKeyRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MailDeleteOneKeyRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static MailDeleteOneKeyRequest parseFrom(CodedInputStream input) throws IOException {
            return (MailDeleteOneKeyRequest) PARSER.parseFrom(input);
        }

        public static MailDeleteOneKeyRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MailDeleteOneKeyRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(MailDeleteOneKeyRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements MailHandler.MailDeleteOneKeyRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return MailHandler.internal_static_pomelo_area_MailDeleteOneKeyRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MailHandler.internal_static_pomelo_area_MailDeleteOneKeyRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(MailHandler.MailDeleteOneKeyRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MailHandler.MailDeleteOneKeyRequest.alwaysUseFieldBuilders) ;
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
                return MailHandler.internal_static_pomelo_area_MailDeleteOneKeyRequest_descriptor;
            }

            public MailHandler.MailDeleteOneKeyRequest getDefaultInstanceForType() {
                return MailHandler.MailDeleteOneKeyRequest.getDefaultInstance();
            }

            public MailHandler.MailDeleteOneKeyRequest build() {
                MailHandler.MailDeleteOneKeyRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public MailHandler.MailDeleteOneKeyRequest buildPartial() {
                MailHandler.MailDeleteOneKeyRequest result = new MailHandler.MailDeleteOneKeyRequest(this);
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof MailHandler.MailDeleteOneKeyRequest)
                    return mergeFrom((MailHandler.MailDeleteOneKeyRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MailHandler.MailDeleteOneKeyRequest other) {
                if (other == MailHandler.MailDeleteOneKeyRequest.getDefaultInstance()) return this;
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                MailHandler.MailDeleteOneKeyRequest parsedMessage = null;
                try {
                    parsedMessage = (MailHandler.MailDeleteOneKeyRequest) MailHandler.MailDeleteOneKeyRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MailHandler.MailDeleteOneKeyRequest) e.getUnfinishedMessage();
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


    public static final class MailSendTestNotify
            extends GeneratedMessage
            implements MailSendTestNotifyOrBuilder {
        private static final MailSendTestNotify defaultInstance = new MailSendTestNotify(true);
        private final UnknownFieldSet unknownFields;

        private MailSendTestNotify(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private MailSendTestNotify(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static MailSendTestNotify getDefaultInstance() {
            return defaultInstance;
        }

        public MailSendTestNotify getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MailSendTestNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.c2SMailId_ = input.readInt32();
                            break;
                        case 18:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x2;
                            this.c2STcCode_ = bs;
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
            return MailHandler.internal_static_pomelo_area_MailSendTestNotify_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MailHandler.internal_static_pomelo_area_MailSendTestNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(MailSendTestNotify.class, Builder.class);
        }

        public static Parser<MailSendTestNotify> PARSER = (Parser<MailSendTestNotify>) new AbstractParser<MailSendTestNotify>() {
            public MailHandler.MailSendTestNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MailHandler.MailSendTestNotify(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_MAILID_FIELD_NUMBER = 1;
        private int c2SMailId_;
        public static final int C2S_TCCODE_FIELD_NUMBER = 2;
        private Object c2STcCode_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<MailSendTestNotify> getParserForType() {
            return PARSER;
        }

        public boolean hasC2SMailId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getC2SMailId() {
            return this.c2SMailId_;
        }

        public boolean hasC2STcCode() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public String getC2STcCode() {
            Object ref = this.c2STcCode_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.c2STcCode_ = s;
            return s;
        }

        public ByteString getC2STcCodeBytes() {
            Object ref = this.c2STcCode_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.c2STcCode_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        private void initFields() {
            this.c2SMailId_ = 0;
            this.c2STcCode_ = "";
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasC2SMailId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasC2STcCode()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.c2SMailId_);
            if ((this.bitField0_ & 0x2) == 2) output.writeBytes(2, getC2STcCodeBytes());
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.c2SMailId_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getC2STcCodeBytes());
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static MailSendTestNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (MailSendTestNotify) PARSER.parseFrom(data);
        }

        public static MailSendTestNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MailSendTestNotify) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MailSendTestNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (MailSendTestNotify) PARSER.parseFrom(data);
        }

        public static MailSendTestNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MailSendTestNotify) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MailSendTestNotify parseFrom(InputStream input) throws IOException {
            return (MailSendTestNotify) PARSER.parseFrom(input);
        }

        public static MailSendTestNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MailSendTestNotify) PARSER.parseFrom(input, extensionRegistry);
        }

        public static MailSendTestNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (MailSendTestNotify) PARSER.parseDelimitedFrom(input);
        }

        public static MailSendTestNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MailSendTestNotify) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static MailSendTestNotify parseFrom(CodedInputStream input) throws IOException {
            return (MailSendTestNotify) PARSER.parseFrom(input);
        }

        public static MailSendTestNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MailSendTestNotify) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(MailSendTestNotify prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements MailHandler.MailSendTestNotifyOrBuilder {
            private int bitField0_;
            private int c2SMailId_;
            private Object c2STcCode_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MailHandler.internal_static_pomelo_area_MailSendTestNotify_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MailHandler.internal_static_pomelo_area_MailSendTestNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(MailHandler.MailSendTestNotify.class, Builder.class);
            }

            private Builder() {
                this.c2STcCode_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.c2STcCode_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MailHandler.MailSendTestNotify.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.c2SMailId_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2STcCode_ = "";
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return MailHandler.internal_static_pomelo_area_MailSendTestNotify_descriptor;
            }

            public MailHandler.MailSendTestNotify getDefaultInstanceForType() {
                return MailHandler.MailSendTestNotify.getDefaultInstance();
            }

            public MailHandler.MailSendTestNotify build() {
                MailHandler.MailSendTestNotify result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public MailHandler.MailSendTestNotify buildPartial() {
                MailHandler.MailSendTestNotify result = new MailHandler.MailSendTestNotify(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.c2SMailId_ = this.c2SMailId_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.c2STcCode_ = this.c2STcCode_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof MailHandler.MailSendTestNotify)
                    return mergeFrom((MailHandler.MailSendTestNotify) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MailHandler.MailSendTestNotify other) {
                if (other == MailHandler.MailSendTestNotify.getDefaultInstance()) return this;
                if (other.hasC2SMailId()) setC2SMailId(other.getC2SMailId());
                if (other.hasC2STcCode()) {
                    this.bitField0_ |= 0x2;
                    this.c2STcCode_ = other.c2STcCode_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasC2SMailId()) return false;
                if (!hasC2STcCode()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                MailHandler.MailSendTestNotify parsedMessage = null;
                try {
                    parsedMessage = (MailHandler.MailSendTestNotify) MailHandler.MailSendTestNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MailHandler.MailSendTestNotify) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasC2SMailId() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getC2SMailId() {
                return this.c2SMailId_;
            }

            public Builder setC2SMailId(int value) {
                this.bitField0_ |= 0x1;
                this.c2SMailId_ = value;
                onChanged();
                return this;
            }

            public Builder clearC2SMailId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SMailId_ = 0;
                onChanged();
                return this;
            }

            public boolean hasC2STcCode() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public String getC2STcCode() {
                Object ref = this.c2STcCode_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) this.c2STcCode_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getC2STcCodeBytes() {
                Object ref = this.c2STcCode_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.c2STcCode_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setC2STcCode(String value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x2;
                this.c2STcCode_ = value;
                onChanged();
                return this;
            }

            public Builder clearC2STcCode() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.c2STcCode_ = MailHandler.MailSendTestNotify.getDefaultInstance().getC2STcCode();
                onChanged();
                return this;
            }

            public Builder setC2STcCodeBytes(ByteString value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x2;
                this.c2STcCode_ = value;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class Mail
            extends GeneratedMessage
            implements MailOrBuilder {
        private static final Mail defaultInstance = new Mail(true);
        private final UnknownFieldSet unknownFields;

        private Mail(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Mail(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Mail getDefaultInstance() {
            return defaultInstance;
        }

        public Mail getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Mail(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.id_ = bs;
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.mailId_ = input.readInt32();
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.mailType_ = input.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.mailIcon_ = input.readInt32();
                            break;
                        case 42:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x10;
                            this.mailSender_ = bs;
                            break;
                        case 50:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x20;
                            this.mailTitle_ = bs;
                            break;
                        case 58:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x40;
                            this.mailText_ = bs;
                            break;
                        case 66:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x80;
                            this.createTime_ = bs;
                            break;
                        case 72:
                            this.bitField0_ |= 0x100;
                            this.status_ = input.readInt32();
                            break;
                        case 80:
                            this.bitField0_ |= 0x200;
                            this.mailRead_ = input.readInt32();
                            break;
                        case 88:
                            this.bitField0_ |= 0x400;
                            this.hadAttach_ = input.readInt32();
                            break;
                        case 98:
                            if ((mutable_bitField0_ & 0x800) != 2048) {
                                this.attachment_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x800;
                            }
                            this.attachment_.add(input.readMessage(ItemOuterClass.MiniItem.PARSER, extensionRegistry));
                            break;
                        case 106:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x800;
                            this.mailSenderId_ = bs;
                            break;
                        case 114:
                            if ((mutable_bitField0_ & 0x2000) != 8192) {
                                this.itemEar_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x2000;
                            }
                            this.itemEar_.add(input.readMessage(ItemOuterClass.EarItemDetail.PARSER, extensionRegistry));
                            break;
                        case 122:
                            if ((mutable_bitField0_ & 0x4000) != 16384) {
                                this.newAttachment_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x4000;
                            }
                            this.newAttachment_.add(input.readMessage(ItemOuterClass.ItemDetail.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x800) == 2048)
                    this.attachment_ = Collections.unmodifiableList(this.attachment_);
                if ((mutable_bitField0_ & 0x2000) == 8192) this.itemEar_ = Collections.unmodifiableList(this.itemEar_);
                if ((mutable_bitField0_ & 0x4000) == 16384)
                    this.newAttachment_ = Collections.unmodifiableList(this.newAttachment_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MailHandler.internal_static_pomelo_area_Mail_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MailHandler.internal_static_pomelo_area_Mail_fieldAccessorTable.ensureFieldAccessorsInitialized(Mail.class, Builder.class);
        }

        public static Parser<Mail> PARSER = (Parser<Mail>) new AbstractParser<Mail>() {
            public MailHandler.Mail parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MailHandler.Mail(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int ID_FIELD_NUMBER = 1;
        private Object id_;
        public static final int MAILID_FIELD_NUMBER = 2;
        private int mailId_;
        public static final int MAILTYPE_FIELD_NUMBER = 3;
        private int mailType_;
        public static final int MAILICON_FIELD_NUMBER = 4;
        private int mailIcon_;
        public static final int MAILSENDER_FIELD_NUMBER = 5;
        private Object mailSender_;
        public static final int MAILTITLE_FIELD_NUMBER = 6;
        private Object mailTitle_;
        public static final int MAILTEXT_FIELD_NUMBER = 7;
        private Object mailText_;
        public static final int CREATETIME_FIELD_NUMBER = 8;
        private Object createTime_;
        public static final int STATUS_FIELD_NUMBER = 9;
        private int status_;
        public static final int MAILREAD_FIELD_NUMBER = 10;
        private int mailRead_;
        public static final int HADATTACH_FIELD_NUMBER = 11;
        private int hadAttach_;
        public static final int ATTACHMENT_FIELD_NUMBER = 12;
        private List<ItemOuterClass.MiniItem> attachment_;
        public static final int MAILSENDERID_FIELD_NUMBER = 13;
        private Object mailSenderId_;
        public static final int ITEMEAR_FIELD_NUMBER = 14;
        private List<ItemOuterClass.EarItemDetail> itemEar_;
        public static final int NEWATTACHMENT_FIELD_NUMBER = 15;
        private List<ItemOuterClass.ItemDetail> newAttachment_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<Mail> getParserForType() {
            return PARSER;
        }

        public boolean hasId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public String getId() {
            Object ref = this.id_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.id_ = s;
            return s;
        }

        public ByteString getIdBytes() {
            Object ref = this.id_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.id_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasMailId() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public int getMailId() {
            return this.mailId_;
        }

        public boolean hasMailType() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getMailType() {
            return this.mailType_;
        }

        public boolean hasMailIcon() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public int getMailIcon() {
            return this.mailIcon_;
        }

        public boolean hasMailSender() {
            return ((this.bitField0_ & 0x10) == 16);
        }

        public String getMailSender() {
            Object ref = this.mailSender_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.mailSender_ = s;
            return s;
        }

        public ByteString getMailSenderBytes() {
            Object ref = this.mailSender_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.mailSender_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasMailTitle() {
            return ((this.bitField0_ & 0x20) == 32);
        }

        public String getMailTitle() {
            Object ref = this.mailTitle_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.mailTitle_ = s;
            return s;
        }

        public ByteString getMailTitleBytes() {
            Object ref = this.mailTitle_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.mailTitle_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasMailText() {
            return ((this.bitField0_ & 0x40) == 64);
        }

        public String getMailText() {
            Object ref = this.mailText_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.mailText_ = s;
            return s;
        }

        public ByteString getMailTextBytes() {
            Object ref = this.mailText_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.mailText_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasCreateTime() {
            return ((this.bitField0_ & 0x80) == 128);
        }

        public String getCreateTime() {
            Object ref = this.createTime_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.createTime_ = s;
            return s;
        }

        public ByteString getCreateTimeBytes() {
            Object ref = this.createTime_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.createTime_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasStatus() {
            return ((this.bitField0_ & 0x100) == 256);
        }

        public int getStatus() {
            return this.status_;
        }

        public boolean hasMailRead() {
            return ((this.bitField0_ & 0x200) == 512);
        }

        public int getMailRead() {
            return this.mailRead_;
        }

        public boolean hasHadAttach() {
            return ((this.bitField0_ & 0x400) == 1024);
        }

        public int getHadAttach() {
            return this.hadAttach_;
        }

        public List<ItemOuterClass.MiniItem> getAttachmentList() {
            return this.attachment_;
        }

        public List<? extends ItemOuterClass.MiniItemOrBuilder> getAttachmentOrBuilderList() {
            return (List) this.attachment_;
        }

        public int getAttachmentCount() {
            return this.attachment_.size();
        }

        public ItemOuterClass.MiniItem getAttachment(int index) {
            return this.attachment_.get(index);
        }

        public ItemOuterClass.MiniItemOrBuilder getAttachmentOrBuilder(int index) {
            return (ItemOuterClass.MiniItemOrBuilder) this.attachment_.get(index);
        }

        public boolean hasMailSenderId() {
            return ((this.bitField0_ & 0x800) == 2048);
        }

        public String getMailSenderId() {
            Object ref = this.mailSenderId_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.mailSenderId_ = s;
            return s;
        }

        public ByteString getMailSenderIdBytes() {
            Object ref = this.mailSenderId_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.mailSenderId_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public List<ItemOuterClass.EarItemDetail> getItemEarList() {
            return this.itemEar_;
        }

        public List<? extends ItemOuterClass.EarItemDetailOrBuilder> getItemEarOrBuilderList() {
            return (List) this.itemEar_;
        }

        public int getItemEarCount() {
            return this.itemEar_.size();
        }

        static {
            defaultInstance.initFields();
        }

        public ItemOuterClass.EarItemDetail getItemEar(int index) {
            return this.itemEar_.get(index);
        }

        public ItemOuterClass.EarItemDetailOrBuilder getItemEarOrBuilder(int index) {
            return (ItemOuterClass.EarItemDetailOrBuilder) this.itemEar_.get(index);
        }

        public List<ItemOuterClass.ItemDetail> getNewAttachmentList() {
            return this.newAttachment_;
        }

        public List<? extends ItemOuterClass.ItemDetailOrBuilder> getNewAttachmentOrBuilderList() {
            return (List) this.newAttachment_;
        }

        public int getNewAttachmentCount() {
            return this.newAttachment_.size();
        }

        public ItemOuterClass.ItemDetail getNewAttachment(int index) {
            return this.newAttachment_.get(index);
        }

        public ItemOuterClass.ItemDetailOrBuilder getNewAttachmentOrBuilder(int index) {
            return (ItemOuterClass.ItemDetailOrBuilder) this.newAttachment_.get(index);
        }

        private void initFields() {
            this.id_ = "";
            this.mailId_ = 0;
            this.mailType_ = 0;
            this.mailIcon_ = 0;
            this.mailSender_ = "";
            this.mailTitle_ = "";
            this.mailText_ = "";
            this.createTime_ = "";
            this.status_ = 0;
            this.mailRead_ = 0;
            this.hadAttach_ = 0;
            this.attachment_ = Collections.emptyList();
            this.mailSenderId_ = "";
            this.itemEar_ = Collections.emptyList();
            this.newAttachment_ = Collections.emptyList();
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
            if (!hasMailId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasMailType()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasMailIcon()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasMailSender()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasMailTitle()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasMailText()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasCreateTime()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasStatus()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasMailRead()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasHadAttach()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            int i;
            for (i = 0; i < getAttachmentCount(); i++) {
                if (!getAttachment(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (i = 0; i < getNewAttachmentCount(); i++) {
                if (!getNewAttachment(i).isInitialized()) {
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
                output.writeBytes(1, getIdBytes());
            if ((this.bitField0_ & 0x2) == 2)
                output.writeInt32(2, this.mailId_);
            if ((this.bitField0_ & 0x4) == 4)
                output.writeInt32(3, this.mailType_);
            if ((this.bitField0_ & 0x8) == 8)
                output.writeInt32(4, this.mailIcon_);
            if ((this.bitField0_ & 0x10) == 16)
                output.writeBytes(5, getMailSenderBytes());
            if ((this.bitField0_ & 0x20) == 32)
                output.writeBytes(6, getMailTitleBytes());
            if ((this.bitField0_ & 0x40) == 64)
                output.writeBytes(7, getMailTextBytes());
            if ((this.bitField0_ & 0x80) == 128)
                output.writeBytes(8, getCreateTimeBytes());
            if ((this.bitField0_ & 0x100) == 256)
                output.writeInt32(9, this.status_);
            if ((this.bitField0_ & 0x200) == 512)
                output.writeInt32(10, this.mailRead_);
            if ((this.bitField0_ & 0x400) == 1024)
                output.writeInt32(11, this.hadAttach_);
            int i;
            for (i = 0; i < this.attachment_.size(); i++)
                output.writeMessage(12, (MessageLite) this.attachment_.get(i));
            if ((this.bitField0_ & 0x800) == 2048)
                output.writeBytes(13, getMailSenderIdBytes());
            for (i = 0; i < this.itemEar_.size(); i++)
                output.writeMessage(14, (MessageLite) this.itemEar_.get(i));
            for (i = 0; i < this.newAttachment_.size(); i++)
                output.writeMessage(15, (MessageLite) this.newAttachment_.get(i));
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1)
                return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1)
                size += CodedOutputStream.computeBytesSize(1, getIdBytes());
            if ((this.bitField0_ & 0x2) == 2)
                size += CodedOutputStream.computeInt32Size(2, this.mailId_);
            if ((this.bitField0_ & 0x4) == 4)
                size += CodedOutputStream.computeInt32Size(3, this.mailType_);
            if ((this.bitField0_ & 0x8) == 8)
                size += CodedOutputStream.computeInt32Size(4, this.mailIcon_);
            if ((this.bitField0_ & 0x10) == 16)
                size += CodedOutputStream.computeBytesSize(5, getMailSenderBytes());
            if ((this.bitField0_ & 0x20) == 32)
                size += CodedOutputStream.computeBytesSize(6, getMailTitleBytes());
            if ((this.bitField0_ & 0x40) == 64)
                size += CodedOutputStream.computeBytesSize(7, getMailTextBytes());
            if ((this.bitField0_ & 0x80) == 128)
                size += CodedOutputStream.computeBytesSize(8, getCreateTimeBytes());
            if ((this.bitField0_ & 0x100) == 256)
                size += CodedOutputStream.computeInt32Size(9, this.status_);
            if ((this.bitField0_ & 0x200) == 512)
                size += CodedOutputStream.computeInt32Size(10, this.mailRead_);
            if ((this.bitField0_ & 0x400) == 1024)
                size += CodedOutputStream.computeInt32Size(11, this.hadAttach_);
            int i;
            for (i = 0; i < this.attachment_.size(); i++)
                size += CodedOutputStream.computeMessageSize(12, (MessageLite) this.attachment_.get(i));
            if ((this.bitField0_ & 0x800) == 2048)
                size += CodedOutputStream.computeBytesSize(13, getMailSenderIdBytes());
            for (i = 0; i < this.itemEar_.size(); i++)
                size += CodedOutputStream.computeMessageSize(14, (MessageLite) this.itemEar_.get(i));
            for (i = 0; i < this.newAttachment_.size(); i++)
                size += CodedOutputStream.computeMessageSize(15, (MessageLite) this.newAttachment_.get(i));
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static Mail parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Mail) PARSER.parseFrom(data);
        }

        public static Mail parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Mail) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Mail parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Mail) PARSER.parseFrom(data);
        }

        public static Mail parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Mail) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Mail parseFrom(InputStream input) throws IOException {
            return (Mail) PARSER.parseFrom(input);
        }

        public static Mail parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Mail) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Mail parseDelimitedFrom(InputStream input) throws IOException {
            return (Mail) PARSER.parseDelimitedFrom(input);
        }

        public static Mail parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Mail) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Mail parseFrom(CodedInputStream input) throws IOException {
            return (Mail) PARSER.parseFrom(input);
        }

        public static Mail parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Mail) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Mail prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements MailHandler.MailOrBuilder {
            private int bitField0_;
            private Object id_;
            private int mailId_;
            private int mailType_;
            private int mailIcon_;
            private Object mailSender_;
            private Object mailTitle_;
            private Object mailText_;
            private Object createTime_;
            private int status_;
            private int mailRead_;
            private int hadAttach_;
            private List<ItemOuterClass.MiniItem> attachment_;
            private RepeatedFieldBuilder<ItemOuterClass.MiniItem, ItemOuterClass.MiniItem.Builder, ItemOuterClass.MiniItemOrBuilder> attachmentBuilder_;
            private Object mailSenderId_;
            private List<ItemOuterClass.EarItemDetail> itemEar_;
            private RepeatedFieldBuilder<ItemOuterClass.EarItemDetail, ItemOuterClass.EarItemDetail.Builder, ItemOuterClass.EarItemDetailOrBuilder> itemEarBuilder_;
            private List<ItemOuterClass.ItemDetail> newAttachment_;
            private RepeatedFieldBuilder<ItemOuterClass.ItemDetail, ItemOuterClass.ItemDetail.Builder, ItemOuterClass.ItemDetailOrBuilder> newAttachmentBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MailHandler.internal_static_pomelo_area_Mail_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MailHandler.internal_static_pomelo_area_Mail_fieldAccessorTable.ensureFieldAccessorsInitialized(MailHandler.Mail.class, Builder.class);
            }

            private Builder() {
                this.id_ = "";
                this.mailSender_ = "";
                this.mailTitle_ = "";
                this.mailText_ = "";
                this.createTime_ = "";
                this.attachment_ = Collections.emptyList();
                this.mailSenderId_ = "";
                this.itemEar_ = Collections.emptyList();
                this.newAttachment_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.id_ = "";
                this.mailSender_ = "";
                this.mailTitle_ = "";
                this.mailText_ = "";
                this.createTime_ = "";
                this.attachment_ = Collections.emptyList();
                this.mailSenderId_ = "";
                this.itemEar_ = Collections.emptyList();
                this.newAttachment_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MailHandler.Mail.alwaysUseFieldBuilders) {
                    getAttachmentFieldBuilder();
                    getItemEarFieldBuilder();
                    getNewAttachmentFieldBuilder();
                }
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.id_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                this.mailId_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                this.mailType_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.mailIcon_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                this.mailSender_ = "";
                this.bitField0_ &= 0xFFFFFFEF;
                this.mailTitle_ = "";
                this.bitField0_ &= 0xFFFFFFDF;
                this.mailText_ = "";
                this.bitField0_ &= 0xFFFFFFBF;
                this.createTime_ = "";
                this.bitField0_ &= 0xFFFFFF7F;
                this.status_ = 0;
                this.bitField0_ &= 0xFFFFFEFF;
                this.mailRead_ = 0;
                this.bitField0_ &= 0xFFFFFDFF;
                this.hadAttach_ = 0;
                this.bitField0_ &= 0xFFFFFBFF;
                if (this.attachmentBuilder_ == null) {
                    this.attachment_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFF7FF;
                } else {
                    this.attachmentBuilder_.clear();
                }
                this.mailSenderId_ = "";
                this.bitField0_ &= 0xFFFFEFFF;
                if (this.itemEarBuilder_ == null) {
                    this.itemEar_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFDFFF;
                } else {
                    this.itemEarBuilder_.clear();
                }
                if (this.newAttachmentBuilder_ == null) {
                    this.newAttachment_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFBFFF;
                } else {
                    this.newAttachmentBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return MailHandler.internal_static_pomelo_area_Mail_descriptor;
            }

            public MailHandler.Mail getDefaultInstanceForType() {
                return MailHandler.Mail.getDefaultInstance();
            }

            public MailHandler.Mail build() {
                MailHandler.Mail result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public MailHandler.Mail buildPartial() {
                MailHandler.Mail result = new MailHandler.Mail(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.id_ = this.id_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.mailId_ = this.mailId_;
                if ((from_bitField0_ & 0x4) == 4)
                    to_bitField0_ |= 0x4;
                result.mailType_ = this.mailType_;
                if ((from_bitField0_ & 0x8) == 8)
                    to_bitField0_ |= 0x8;
                result.mailIcon_ = this.mailIcon_;
                if ((from_bitField0_ & 0x10) == 16)
                    to_bitField0_ |= 0x10;
                result.mailSender_ = this.mailSender_;
                if ((from_bitField0_ & 0x20) == 32)
                    to_bitField0_ |= 0x20;
                result.mailTitle_ = this.mailTitle_;
                if ((from_bitField0_ & 0x40) == 64)
                    to_bitField0_ |= 0x40;
                result.mailText_ = this.mailText_;
                if ((from_bitField0_ & 0x80) == 128)
                    to_bitField0_ |= 0x80;
                result.createTime_ = this.createTime_;
                if ((from_bitField0_ & 0x100) == 256)
                    to_bitField0_ |= 0x100;
                result.status_ = this.status_;
                if ((from_bitField0_ & 0x200) == 512)
                    to_bitField0_ |= 0x200;
                result.mailRead_ = this.mailRead_;
                if ((from_bitField0_ & 0x400) == 1024)
                    to_bitField0_ |= 0x400;
                result.hadAttach_ = this.hadAttach_;
                if (this.attachmentBuilder_ == null) {
                    if ((this.bitField0_ & 0x800) == 2048) {
                        this.attachment_ = Collections.unmodifiableList(this.attachment_);
                        this.bitField0_ &= 0xFFFFF7FF;
                    }
                    result.attachment_ = this.attachment_;
                } else {
                    result.attachment_ = this.attachmentBuilder_.build();
                }
                if ((from_bitField0_ & 0x1000) == 4096)
                    to_bitField0_ |= 0x800;
                result.mailSenderId_ = this.mailSenderId_;
                if (this.itemEarBuilder_ == null) {
                    if ((this.bitField0_ & 0x2000) == 8192) {
                        this.itemEar_ = Collections.unmodifiableList(this.itemEar_);
                        this.bitField0_ &= 0xFFFFDFFF;
                    }
                    result.itemEar_ = this.itemEar_;
                } else {
                    result.itemEar_ = this.itemEarBuilder_.build();
                }
                if (this.newAttachmentBuilder_ == null) {
                    if ((this.bitField0_ & 0x4000) == 16384) {
                        this.newAttachment_ = Collections.unmodifiableList(this.newAttachment_);
                        this.bitField0_ &= 0xFFFFBFFF;
                    }
                    result.newAttachment_ = this.newAttachment_;
                } else {
                    result.newAttachment_ = this.newAttachmentBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof MailHandler.Mail)
                    return mergeFrom((MailHandler.Mail) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MailHandler.Mail other) {
                if (other == MailHandler.Mail.getDefaultInstance())
                    return this;
                if (other.hasId()) {
                    this.bitField0_ |= 0x1;
                    this.id_ = other.id_;
                    onChanged();
                }
                if (other.hasMailId())
                    setMailId(other.getMailId());
                if (other.hasMailType())
                    setMailType(other.getMailType());
                if (other.hasMailIcon())
                    setMailIcon(other.getMailIcon());
                if (other.hasMailSender()) {
                    this.bitField0_ |= 0x10;
                    this.mailSender_ = other.mailSender_;
                    onChanged();
                }
                if (other.hasMailTitle()) {
                    this.bitField0_ |= 0x20;
                    this.mailTitle_ = other.mailTitle_;
                    onChanged();
                }
                if (other.hasMailText()) {
                    this.bitField0_ |= 0x40;
                    this.mailText_ = other.mailText_;
                    onChanged();
                }
                if (other.hasCreateTime()) {
                    this.bitField0_ |= 0x80;
                    this.createTime_ = other.createTime_;
                    onChanged();
                }
                if (other.hasStatus())
                    setStatus(other.getStatus());
                if (other.hasMailRead())
                    setMailRead(other.getMailRead());
                if (other.hasHadAttach())
                    setHadAttach(other.getHadAttach());
                if (this.attachmentBuilder_ == null) {
                    if (!other.attachment_.isEmpty()) {
                        if (this.attachment_.isEmpty()) {
                            this.attachment_ = other.attachment_;
                            this.bitField0_ &= 0xFFFFF7FF;
                        } else {
                            ensureAttachmentIsMutable();
                            this.attachment_.addAll(other.attachment_);
                        }
                        onChanged();
                    }
                } else if (!other.attachment_.isEmpty()) {
                    if (this.attachmentBuilder_.isEmpty()) {
                        this.attachmentBuilder_.dispose();
                        this.attachmentBuilder_ = null;
                        this.attachment_ = other.attachment_;
                        this.bitField0_ &= 0xFFFFF7FF;
                        this.attachmentBuilder_ = MailHandler.Mail.alwaysUseFieldBuilders ? getAttachmentFieldBuilder() : null;
                    } else {
                        this.attachmentBuilder_.addAllMessages(other.attachment_);
                    }
                }
                if (other.hasMailSenderId()) {
                    this.bitField0_ |= 0x1000;
                    this.mailSenderId_ = other.mailSenderId_;
                    onChanged();
                }
                if (this.itemEarBuilder_ == null) {
                    if (!other.itemEar_.isEmpty()) {
                        if (this.itemEar_.isEmpty()) {
                            this.itemEar_ = other.itemEar_;
                            this.bitField0_ &= 0xFFFFDFFF;
                        } else {
                            ensureItemEarIsMutable();
                            this.itemEar_.addAll(other.itemEar_);
                        }
                        onChanged();
                    }
                } else if (!other.itemEar_.isEmpty()) {
                    if (this.itemEarBuilder_.isEmpty()) {
                        this.itemEarBuilder_.dispose();
                        this.itemEarBuilder_ = null;
                        this.itemEar_ = other.itemEar_;
                        this.bitField0_ &= 0xFFFFDFFF;
                        this.itemEarBuilder_ = MailHandler.Mail.alwaysUseFieldBuilders ? getItemEarFieldBuilder() : null;
                    } else {
                        this.itemEarBuilder_.addAllMessages(other.itemEar_);
                    }
                }
                if (this.newAttachmentBuilder_ == null) {
                    if (!other.newAttachment_.isEmpty()) {
                        if (this.newAttachment_.isEmpty()) {
                            this.newAttachment_ = other.newAttachment_;
                            this.bitField0_ &= 0xFFFFBFFF;
                        } else {
                            ensureNewAttachmentIsMutable();
                            this.newAttachment_.addAll(other.newAttachment_);
                        }
                        onChanged();
                    }
                } else if (!other.newAttachment_.isEmpty()) {
                    if (this.newAttachmentBuilder_.isEmpty()) {
                        this.newAttachmentBuilder_.dispose();
                        this.newAttachmentBuilder_ = null;
                        this.newAttachment_ = other.newAttachment_;
                        this.bitField0_ &= 0xFFFFBFFF;
                        this.newAttachmentBuilder_ = MailHandler.Mail.alwaysUseFieldBuilders ? getNewAttachmentFieldBuilder() : null;
                    } else {
                        this.newAttachmentBuilder_.addAllMessages(other.newAttachment_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasId())
                    return false;
                if (!hasMailId())
                    return false;
                if (!hasMailType())
                    return false;
                if (!hasMailIcon())
                    return false;
                if (!hasMailSender())
                    return false;
                if (!hasMailTitle())
                    return false;
                if (!hasMailText())
                    return false;
                if (!hasCreateTime())
                    return false;
                if (!hasStatus())
                    return false;
                if (!hasMailRead())
                    return false;
                if (!hasHadAttach())
                    return false;
                int i;
                for (i = 0; i < getAttachmentCount(); i++) {
                    if (!getAttachment(i).isInitialized())
                        return false;
                }
                for (i = 0; i < getNewAttachmentCount(); i++) {
                    if (!getNewAttachment(i).isInitialized())
                        return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                MailHandler.Mail parsedMessage = null;
                try {
                    parsedMessage = (MailHandler.Mail) MailHandler.Mail.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MailHandler.Mail) e.getUnfinishedMessage();
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

            public String getId() {
                Object ref = this.id_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.id_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getIdBytes() {
                Object ref = this.id_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.id_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setId(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.id_ = value;
                onChanged();
                return this;
            }

            public Builder clearId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.id_ = MailHandler.Mail.getDefaultInstance().getId();
                onChanged();
                return this;
            }

            public Builder setIdBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.id_ = value;
                onChanged();
                return this;
            }

            public boolean hasMailId() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getMailId() {
                return this.mailId_;
            }

            public Builder setMailId(int value) {
                this.bitField0_ |= 0x2;
                this.mailId_ = value;
                onChanged();
                return this;
            }

            public Builder clearMailId() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.mailId_ = 0;
                onChanged();
                return this;
            }

            public boolean hasMailType() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public int getMailType() {
                return this.mailType_;
            }

            public Builder setMailType(int value) {
                this.bitField0_ |= 0x4;
                this.mailType_ = value;
                onChanged();
                return this;
            }

            public Builder clearMailType() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.mailType_ = 0;
                onChanged();
                return this;
            }

            public boolean hasMailIcon() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public int getMailIcon() {
                return this.mailIcon_;
            }

            public Builder setMailIcon(int value) {
                this.bitField0_ |= 0x8;
                this.mailIcon_ = value;
                onChanged();
                return this;
            }

            public Builder clearMailIcon() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.mailIcon_ = 0;
                onChanged();
                return this;
            }

            public boolean hasMailSender() {
                return ((this.bitField0_ & 0x10) == 16);
            }

            public String getMailSender() {
                Object ref = this.mailSender_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.mailSender_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getMailSenderBytes() {
                Object ref = this.mailSender_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.mailSender_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setMailSender(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x10;
                this.mailSender_ = value;
                onChanged();
                return this;
            }

            public Builder clearMailSender() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.mailSender_ = MailHandler.Mail.getDefaultInstance().getMailSender();
                onChanged();
                return this;
            }

            public Builder setMailSenderBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x10;
                this.mailSender_ = value;
                onChanged();
                return this;
            }

            public boolean hasMailTitle() {
                return ((this.bitField0_ & 0x20) == 32);
            }

            public String getMailTitle() {
                Object ref = this.mailTitle_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.mailTitle_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getMailTitleBytes() {
                Object ref = this.mailTitle_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.mailTitle_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setMailTitle(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x20;
                this.mailTitle_ = value;
                onChanged();
                return this;
            }

            public Builder clearMailTitle() {
                this.bitField0_ &= 0xFFFFFFDF;
                this.mailTitle_ = MailHandler.Mail.getDefaultInstance().getMailTitle();
                onChanged();
                return this;
            }

            public Builder setMailTitleBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x20;
                this.mailTitle_ = value;
                onChanged();
                return this;
            }

            public boolean hasMailText() {
                return ((this.bitField0_ & 0x40) == 64);
            }

            public String getMailText() {
                Object ref = this.mailText_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.mailText_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getMailTextBytes() {
                Object ref = this.mailText_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.mailText_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setMailText(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x40;
                this.mailText_ = value;
                onChanged();
                return this;
            }

            public Builder clearMailText() {
                this.bitField0_ &= 0xFFFFFFBF;
                this.mailText_ = MailHandler.Mail.getDefaultInstance().getMailText();
                onChanged();
                return this;
            }

            public Builder setMailTextBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x40;
                this.mailText_ = value;
                onChanged();
                return this;
            }

            public boolean hasCreateTime() {
                return ((this.bitField0_ & 0x80) == 128);
            }

            public String getCreateTime() {
                Object ref = this.createTime_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.createTime_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getCreateTimeBytes() {
                Object ref = this.createTime_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.createTime_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setCreateTime(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x80;
                this.createTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearCreateTime() {
                this.bitField0_ &= 0xFFFFFF7F;
                this.createTime_ = MailHandler.Mail.getDefaultInstance().getCreateTime();
                onChanged();
                return this;
            }

            public Builder setCreateTimeBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x80;
                this.createTime_ = value;
                onChanged();
                return this;
            }

            public boolean hasStatus() {
                return ((this.bitField0_ & 0x100) == 256);
            }

            public int getStatus() {
                return this.status_;
            }

            public Builder setStatus(int value) {
                this.bitField0_ |= 0x100;
                this.status_ = value;
                onChanged();
                return this;
            }

            public Builder clearStatus() {
                this.bitField0_ &= 0xFFFFFEFF;
                this.status_ = 0;
                onChanged();
                return this;
            }

            public boolean hasMailRead() {
                return ((this.bitField0_ & 0x200) == 512);
            }

            public int getMailRead() {
                return this.mailRead_;
            }

            public Builder setMailRead(int value) {
                this.bitField0_ |= 0x200;
                this.mailRead_ = value;
                onChanged();
                return this;
            }

            public Builder clearMailRead() {
                this.bitField0_ &= 0xFFFFFDFF;
                this.mailRead_ = 0;
                onChanged();
                return this;
            }

            public boolean hasHadAttach() {
                return ((this.bitField0_ & 0x400) == 1024);
            }

            public int getHadAttach() {
                return this.hadAttach_;
            }

            public Builder setHadAttach(int value) {
                this.bitField0_ |= 0x400;
                this.hadAttach_ = value;
                onChanged();
                return this;
            }

            public Builder clearHadAttach() {
                this.bitField0_ &= 0xFFFFFBFF;
                this.hadAttach_ = 0;
                onChanged();
                return this;
            }

            private void ensureAttachmentIsMutable() {
                if ((this.bitField0_ & 0x800) != 2048) {
                    this.attachment_ = new ArrayList<>(this.attachment_);
                    this.bitField0_ |= 0x800;
                }
            }

            public List<ItemOuterClass.MiniItem> getAttachmentList() {
                if (this.attachmentBuilder_ == null)
                    return Collections.unmodifiableList(this.attachment_);
                return this.attachmentBuilder_.getMessageList();
            }

            public int getAttachmentCount() {
                if (this.attachmentBuilder_ == null)
                    return this.attachment_.size();
                return this.attachmentBuilder_.getCount();
            }

            public ItemOuterClass.MiniItem getAttachment(int index) {
                if (this.attachmentBuilder_ == null)
                    return this.attachment_.get(index);
                return (ItemOuterClass.MiniItem) this.attachmentBuilder_.getMessage(index);
            }

            public Builder setAttachment(int index, ItemOuterClass.MiniItem value) {
                if (this.attachmentBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureAttachmentIsMutable();
                    this.attachment_.set(index, value);
                    onChanged();
                } else {
                    this.attachmentBuilder_.setMessage(index, (GeneratedMessage) value);
                }
                return this;
            }

            public Builder setAttachment(int index, ItemOuterClass.MiniItem.Builder builderForValue) {
                if (this.attachmentBuilder_ == null) {
                    ensureAttachmentIsMutable();
                    this.attachment_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.attachmentBuilder_.setMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addAttachment(ItemOuterClass.MiniItem value) {
                if (this.attachmentBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureAttachmentIsMutable();
                    this.attachment_.add(value);
                    onChanged();
                } else {
                    this.attachmentBuilder_.addMessage((GeneratedMessage) value);
                }
                return this;
            }

            public Builder addAttachment(int index, ItemOuterClass.MiniItem value) {
                if (this.attachmentBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureAttachmentIsMutable();
                    this.attachment_.add(index, value);
                    onChanged();
                } else {
                    this.attachmentBuilder_.addMessage(index, (GeneratedMessage) value);
                }
                return this;
            }

            public Builder addAttachment(ItemOuterClass.MiniItem.Builder builderForValue) {
                if (this.attachmentBuilder_ == null) {
                    ensureAttachmentIsMutable();
                    this.attachment_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.attachmentBuilder_.addMessage((GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addAttachment(int index, ItemOuterClass.MiniItem.Builder builderForValue) {
                if (this.attachmentBuilder_ == null) {
                    ensureAttachmentIsMutable();
                    this.attachment_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.attachmentBuilder_.addMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addAllAttachment(Iterable<? extends ItemOuterClass.MiniItem> values) {
                if (this.attachmentBuilder_ == null) {
                    ensureAttachmentIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.attachment_);
                    onChanged();
                } else {
                    this.attachmentBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearAttachment() {
                if (this.attachmentBuilder_ == null) {
                    this.attachment_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFF7FF;
                    onChanged();
                } else {
                    this.attachmentBuilder_.clear();
                }
                return this;
            }

            public Builder removeAttachment(int index) {
                if (this.attachmentBuilder_ == null) {
                    ensureAttachmentIsMutable();
                    this.attachment_.remove(index);
                    onChanged();
                } else {
                    this.attachmentBuilder_.remove(index);
                }
                return this;
            }

            public ItemOuterClass.MiniItem.Builder getAttachmentBuilder(int index) {
                return (ItemOuterClass.MiniItem.Builder) getAttachmentFieldBuilder().getBuilder(index);
            }

            public ItemOuterClass.MiniItemOrBuilder getAttachmentOrBuilder(int index) {
                if (this.attachmentBuilder_ == null)
                    return (ItemOuterClass.MiniItemOrBuilder) this.attachment_.get(index);
                return (ItemOuterClass.MiniItemOrBuilder) this.attachmentBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends ItemOuterClass.MiniItemOrBuilder> getAttachmentOrBuilderList() {
                if (this.attachmentBuilder_ != null)
                    return this.attachmentBuilder_.getMessageOrBuilderList();
                return (List) Collections.unmodifiableList(this.attachment_);
            }

            public ItemOuterClass.MiniItem.Builder addAttachmentBuilder() {
                return (ItemOuterClass.MiniItem.Builder) getAttachmentFieldBuilder().addBuilder((GeneratedMessage) ItemOuterClass.MiniItem.getDefaultInstance());
            }

            public ItemOuterClass.MiniItem.Builder addAttachmentBuilder(int index) {
                return (ItemOuterClass.MiniItem.Builder) getAttachmentFieldBuilder().addBuilder(index, (GeneratedMessage) ItemOuterClass.MiniItem.getDefaultInstance());
            }

            public List<ItemOuterClass.MiniItem.Builder> getAttachmentBuilderList() {
                return getAttachmentFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<ItemOuterClass.MiniItem, ItemOuterClass.MiniItem.Builder, ItemOuterClass.MiniItemOrBuilder> getAttachmentFieldBuilder() {
                if (this.attachmentBuilder_ == null) {
                    this.attachmentBuilder_ = new RepeatedFieldBuilder(this.attachment_, ((this.bitField0_ & 0x800) == 2048), getParentForChildren(), isClean());
                    this.attachment_ = null;
                }
                return this.attachmentBuilder_;
            }

            public boolean hasMailSenderId() {
                return ((this.bitField0_ & 0x1000) == 4096);
            }

            public String getMailSenderId() {
                Object ref = this.mailSenderId_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.mailSenderId_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getMailSenderIdBytes() {
                Object ref = this.mailSenderId_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.mailSenderId_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setMailSenderId(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x1000;
                this.mailSenderId_ = value;
                onChanged();
                return this;
            }

            public Builder clearMailSenderId() {
                this.bitField0_ &= 0xFFFFEFFF;
                this.mailSenderId_ = MailHandler.Mail.getDefaultInstance().getMailSenderId();
                onChanged();
                return this;
            }

            public Builder setMailSenderIdBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x1000;
                this.mailSenderId_ = value;
                onChanged();
                return this;
            }

            private void ensureItemEarIsMutable() {
                if ((this.bitField0_ & 0x2000) != 8192) {
                    this.itemEar_ = new ArrayList<>(this.itemEar_);
                    this.bitField0_ |= 0x2000;
                }
            }

            public List<ItemOuterClass.EarItemDetail> getItemEarList() {
                if (this.itemEarBuilder_ == null)
                    return Collections.unmodifiableList(this.itemEar_);
                return this.itemEarBuilder_.getMessageList();
            }

            public int getItemEarCount() {
                if (this.itemEarBuilder_ == null)
                    return this.itemEar_.size();
                return this.itemEarBuilder_.getCount();
            }

            public ItemOuterClass.EarItemDetail getItemEar(int index) {
                if (this.itemEarBuilder_ == null)
                    return this.itemEar_.get(index);
                return (ItemOuterClass.EarItemDetail) this.itemEarBuilder_.getMessage(index);
            }

            public Builder setItemEar(int index, ItemOuterClass.EarItemDetail value) {
                if (this.itemEarBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureItemEarIsMutable();
                    this.itemEar_.set(index, value);
                    onChanged();
                } else {
                    this.itemEarBuilder_.setMessage(index, (GeneratedMessage) value);
                }
                return this;
            }

            public Builder setItemEar(int index, ItemOuterClass.EarItemDetail.Builder builderForValue) {
                if (this.itemEarBuilder_ == null) {
                    ensureItemEarIsMutable();
                    this.itemEar_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.itemEarBuilder_.setMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addItemEar(ItemOuterClass.EarItemDetail value) {
                if (this.itemEarBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureItemEarIsMutable();
                    this.itemEar_.add(value);
                    onChanged();
                } else {
                    this.itemEarBuilder_.addMessage((GeneratedMessage) value);
                }
                return this;
            }

            public Builder addItemEar(int index, ItemOuterClass.EarItemDetail value) {
                if (this.itemEarBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureItemEarIsMutable();
                    this.itemEar_.add(index, value);
                    onChanged();
                } else {
                    this.itemEarBuilder_.addMessage(index, (GeneratedMessage) value);
                }
                return this;
            }

            public Builder addItemEar(ItemOuterClass.EarItemDetail.Builder builderForValue) {
                if (this.itemEarBuilder_ == null) {
                    ensureItemEarIsMutable();
                    this.itemEar_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.itemEarBuilder_.addMessage((GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addItemEar(int index, ItemOuterClass.EarItemDetail.Builder builderForValue) {
                if (this.itemEarBuilder_ == null) {
                    ensureItemEarIsMutable();
                    this.itemEar_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.itemEarBuilder_.addMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addAllItemEar(Iterable<? extends ItemOuterClass.EarItemDetail> values) {
                if (this.itemEarBuilder_ == null) {
                    ensureItemEarIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.itemEar_);
                    onChanged();
                } else {
                    this.itemEarBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearItemEar() {
                if (this.itemEarBuilder_ == null) {
                    this.itemEar_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFDFFF;
                    onChanged();
                } else {
                    this.itemEarBuilder_.clear();
                }
                return this;
            }

            public Builder removeItemEar(int index) {
                if (this.itemEarBuilder_ == null) {
                    ensureItemEarIsMutable();
                    this.itemEar_.remove(index);
                    onChanged();
                } else {
                    this.itemEarBuilder_.remove(index);
                }
                return this;
            }

            public ItemOuterClass.EarItemDetail.Builder getItemEarBuilder(int index) {
                return (ItemOuterClass.EarItemDetail.Builder) getItemEarFieldBuilder().getBuilder(index);
            }

            public ItemOuterClass.EarItemDetailOrBuilder getItemEarOrBuilder(int index) {
                if (this.itemEarBuilder_ == null)
                    return (ItemOuterClass.EarItemDetailOrBuilder) this.itemEar_.get(index);
                return (ItemOuterClass.EarItemDetailOrBuilder) this.itemEarBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends ItemOuterClass.EarItemDetailOrBuilder> getItemEarOrBuilderList() {
                if (this.itemEarBuilder_ != null)
                    return this.itemEarBuilder_.getMessageOrBuilderList();
                return (List) Collections.unmodifiableList(this.itemEar_);
            }

            public ItemOuterClass.EarItemDetail.Builder addItemEarBuilder() {
                return (ItemOuterClass.EarItemDetail.Builder) getItemEarFieldBuilder().addBuilder((GeneratedMessage) ItemOuterClass.EarItemDetail.getDefaultInstance());
            }

            public ItemOuterClass.EarItemDetail.Builder addItemEarBuilder(int index) {
                return (ItemOuterClass.EarItemDetail.Builder) getItemEarFieldBuilder().addBuilder(index, (GeneratedMessage) ItemOuterClass.EarItemDetail.getDefaultInstance());
            }

            public List<ItemOuterClass.EarItemDetail.Builder> getItemEarBuilderList() {
                return getItemEarFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<ItemOuterClass.EarItemDetail, ItemOuterClass.EarItemDetail.Builder, ItemOuterClass.EarItemDetailOrBuilder> getItemEarFieldBuilder() {
                if (this.itemEarBuilder_ == null) {
                    this.itemEarBuilder_ = new RepeatedFieldBuilder(this.itemEar_, ((this.bitField0_ & 0x2000) == 8192), getParentForChildren(), isClean());
                    this.itemEar_ = null;
                }
                return this.itemEarBuilder_;
            }

            private void ensureNewAttachmentIsMutable() {
                if ((this.bitField0_ & 0x4000) != 16384) {
                    this.newAttachment_ = new ArrayList<>(this.newAttachment_);
                    this.bitField0_ |= 0x4000;
                }
            }

            public List<ItemOuterClass.ItemDetail> getNewAttachmentList() {
                if (this.newAttachmentBuilder_ == null)
                    return Collections.unmodifiableList(this.newAttachment_);
                return this.newAttachmentBuilder_.getMessageList();
            }

            public int getNewAttachmentCount() {
                if (this.newAttachmentBuilder_ == null)
                    return this.newAttachment_.size();
                return this.newAttachmentBuilder_.getCount();
            }

            public ItemOuterClass.ItemDetail getNewAttachment(int index) {
                if (this.newAttachmentBuilder_ == null)
                    return this.newAttachment_.get(index);
                return (ItemOuterClass.ItemDetail) this.newAttachmentBuilder_.getMessage(index);
            }

            public Builder setNewAttachment(int index, ItemOuterClass.ItemDetail value) {
                if (this.newAttachmentBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureNewAttachmentIsMutable();
                    this.newAttachment_.set(index, value);
                    onChanged();
                } else {
                    this.newAttachmentBuilder_.setMessage(index, (GeneratedMessage) value);
                }
                return this;
            }

            public Builder setNewAttachment(int index, ItemOuterClass.ItemDetail.Builder builderForValue) {
                if (this.newAttachmentBuilder_ == null) {
                    ensureNewAttachmentIsMutable();
                    this.newAttachment_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.newAttachmentBuilder_.setMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addNewAttachment(ItemOuterClass.ItemDetail value) {
                if (this.newAttachmentBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureNewAttachmentIsMutable();
                    this.newAttachment_.add(value);
                    onChanged();
                } else {
                    this.newAttachmentBuilder_.addMessage((GeneratedMessage) value);
                }
                return this;
            }

            public Builder addNewAttachment(int index, ItemOuterClass.ItemDetail value) {
                if (this.newAttachmentBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureNewAttachmentIsMutable();
                    this.newAttachment_.add(index, value);
                    onChanged();
                } else {
                    this.newAttachmentBuilder_.addMessage(index, (GeneratedMessage) value);
                }
                return this;
            }

            public Builder addNewAttachment(ItemOuterClass.ItemDetail.Builder builderForValue) {
                if (this.newAttachmentBuilder_ == null) {
                    ensureNewAttachmentIsMutable();
                    this.newAttachment_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.newAttachmentBuilder_.addMessage((GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addNewAttachment(int index, ItemOuterClass.ItemDetail.Builder builderForValue) {
                if (this.newAttachmentBuilder_ == null) {
                    ensureNewAttachmentIsMutable();
                    this.newAttachment_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.newAttachmentBuilder_.addMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addAllNewAttachment(Iterable<? extends ItemOuterClass.ItemDetail> values) {
                if (this.newAttachmentBuilder_ == null) {
                    ensureNewAttachmentIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.newAttachment_);
                    onChanged();
                } else {
                    this.newAttachmentBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearNewAttachment() {
                if (this.newAttachmentBuilder_ == null) {
                    this.newAttachment_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFBFFF;
                    onChanged();
                } else {
                    this.newAttachmentBuilder_.clear();
                }
                return this;
            }

            public Builder removeNewAttachment(int index) {
                if (this.newAttachmentBuilder_ == null) {
                    ensureNewAttachmentIsMutable();
                    this.newAttachment_.remove(index);
                    onChanged();
                } else {
                    this.newAttachmentBuilder_.remove(index);
                }
                return this;
            }

            public ItemOuterClass.ItemDetail.Builder getNewAttachmentBuilder(int index) {
                return (ItemOuterClass.ItemDetail.Builder) getNewAttachmentFieldBuilder().getBuilder(index);
            }

            public ItemOuterClass.ItemDetailOrBuilder getNewAttachmentOrBuilder(int index) {
                if (this.newAttachmentBuilder_ == null)
                    return (ItemOuterClass.ItemDetailOrBuilder) this.newAttachment_.get(index);
                return (ItemOuterClass.ItemDetailOrBuilder) this.newAttachmentBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends ItemOuterClass.ItemDetailOrBuilder> getNewAttachmentOrBuilderList() {
                if (this.newAttachmentBuilder_ != null)
                    return this.newAttachmentBuilder_.getMessageOrBuilderList();
                return (List) Collections.unmodifiableList(this.newAttachment_);
            }

            public ItemOuterClass.ItemDetail.Builder addNewAttachmentBuilder() {
                return (ItemOuterClass.ItemDetail.Builder) getNewAttachmentFieldBuilder().addBuilder((GeneratedMessage) ItemOuterClass.ItemDetail.getDefaultInstance());
            }

            public ItemOuterClass.ItemDetail.Builder addNewAttachmentBuilder(int index) {
                return (ItemOuterClass.ItemDetail.Builder) getNewAttachmentFieldBuilder().addBuilder(index, (GeneratedMessage) ItemOuterClass.ItemDetail.getDefaultInstance());
            }

            public List<ItemOuterClass.ItemDetail.Builder> getNewAttachmentBuilderList() {
                return getNewAttachmentFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<ItemOuterClass.ItemDetail, ItemOuterClass.ItemDetail.Builder, ItemOuterClass.ItemDetailOrBuilder> getNewAttachmentFieldBuilder() {
                if (this.newAttachmentBuilder_ == null) {
                    this.newAttachmentBuilder_ = new RepeatedFieldBuilder(this.newAttachment_, ((this.bitField0_ & 0x4000) == 16384), getParentForChildren(), isClean());
                    this.newAttachment_ = null;
                }
                return this.newAttachmentBuilder_;
            }
        }
    }

    public static final class MailGetAllResponse extends GeneratedMessage implements MailGetAllResponseOrBuilder {
        private static final MailGetAllResponse defaultInstance = new MailGetAllResponse(true);
        private final UnknownFieldSet unknownFields;

        private MailGetAllResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private MailGetAllResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static MailGetAllResponse getDefaultInstance() {
            return defaultInstance;
        }

        public MailGetAllResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MailGetAllResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.mails_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x4;
                            }
                            this.mails_.add(input.readMessage(MailHandler.Mail.PARSER, extensionRegistry));
                            break;
                        case 32:
                            this.bitField0_ |= 0x4;
                            this.s2CMaxMailNum_ = input.readInt32();
                            break;
                        case 40:
                            this.bitField0_ |= 0x8;
                            this.s2CMaxWordNum_ = input.readInt32();
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x4) == 4) this.mails_ = Collections.unmodifiableList(this.mails_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MailHandler.internal_static_pomelo_area_MailGetAllResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MailHandler.internal_static_pomelo_area_MailGetAllResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(MailGetAllResponse.class, Builder.class);
        }

        public static Parser<MailGetAllResponse> PARSER = (Parser<MailGetAllResponse>) new AbstractParser<MailGetAllResponse>() {
            public MailHandler.MailGetAllResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MailHandler.MailGetAllResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int MAILS_FIELD_NUMBER = 3;
        private List<MailHandler.Mail> mails_;
        public static final int S2C_MAXMAILNUM_FIELD_NUMBER = 4;
        private int s2CMaxMailNum_;
        public static final int S2C_MAXWORDNUM_FIELD_NUMBER = 5;
        private int s2CMaxWordNum_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<MailGetAllResponse> getParserForType() {
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


        public List<MailHandler.Mail> getMailsList() {
            return this.mails_;
        }


        public List<? extends MailHandler.MailOrBuilder> getMailsOrBuilderList() {
            return (List) this.mails_;
        }


        public int getMailsCount() {
            return this.mails_.size();
        }


        public MailHandler.Mail getMails(int index) {
            return this.mails_.get(index);
        }


        public MailHandler.MailOrBuilder getMailsOrBuilder(int index) {
            return this.mails_.get(index);
        }


        public boolean hasS2CMaxMailNum() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public int getS2CMaxMailNum() {
            return this.s2CMaxMailNum_;
        }


        public boolean hasS2CMaxWordNum() {
            return ((this.bitField0_ & 0x8) == 8);
        }


        public int getS2CMaxWordNum() {
            return this.s2CMaxWordNum_;
        }


        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.mails_ = Collections.emptyList();
            this.s2CMaxMailNum_ = 0;
            this.s2CMaxWordNum_ = 0;
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
            if (!hasS2CMaxMailNum()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasS2CMaxWordNum()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (int i = 0; i < getMailsCount(); i++) {
                if (!getMails(i).isInitialized()) {
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
            for (int i = 0; i < this.mails_.size(); i++) {
                output.writeMessage(3, (MessageLite) this.mails_.get(i));
            }
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeInt32(4, this.s2CMaxMailNum_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                output.writeInt32(5, this.s2CMaxWordNum_);
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
            for (int i = 0; i < this.mails_.size(); i++) {
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.mails_.get(i));
            }
            if ((this.bitField0_ & 0x4) == 4) {
                size += CodedOutputStream.computeInt32Size(4, this.s2CMaxMailNum_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                size += CodedOutputStream.computeInt32Size(5, this.s2CMaxWordNum_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static MailGetAllResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (MailGetAllResponse) PARSER.parseFrom(data);
        }


        public static MailGetAllResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MailGetAllResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static MailGetAllResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (MailGetAllResponse) PARSER.parseFrom(data);
        }


        public static MailGetAllResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MailGetAllResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static MailGetAllResponse parseFrom(InputStream input) throws IOException {
            return (MailGetAllResponse) PARSER.parseFrom(input);
        }


        public static MailGetAllResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MailGetAllResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static MailGetAllResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (MailGetAllResponse) PARSER.parseDelimitedFrom(input);
        }


        public static MailGetAllResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MailGetAllResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static MailGetAllResponse parseFrom(CodedInputStream input) throws IOException {
            return (MailGetAllResponse) PARSER.parseFrom(input);
        }


        public static MailGetAllResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MailGetAllResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(MailGetAllResponse prototype) {
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
                implements MailHandler.MailGetAllResponseOrBuilder {
            private int bitField0_;

            private int s2CCode_;

            private Object s2CMsg_;

            private List<MailHandler.Mail> mails_;

            private RepeatedFieldBuilder<MailHandler.Mail, MailHandler.Mail.Builder, MailHandler.MailOrBuilder> mailsBuilder_;

            private int s2CMaxMailNum_;

            private int s2CMaxWordNum_;


            public static final Descriptors.Descriptor getDescriptor() {
                return MailHandler.internal_static_pomelo_area_MailGetAllResponse_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MailHandler.internal_static_pomelo_area_MailGetAllResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(MailHandler.MailGetAllResponse.class, Builder.class);
            }


            private Builder() {
                this.s2CMsg_ = "";
                this.mails_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.mails_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (MailHandler.MailGetAllResponse.alwaysUseFieldBuilders) {
                    getMailsFieldBuilder();
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
                if (this.mailsBuilder_ == null) {
                    this.mails_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                } else {
                    this.mailsBuilder_.clear();
                }
                this.s2CMaxMailNum_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                this.s2CMaxWordNum_ = 0;
                this.bitField0_ &= 0xFFFFFFEF;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return MailHandler.internal_static_pomelo_area_MailGetAllResponse_descriptor;
            }


            public MailHandler.MailGetAllResponse getDefaultInstanceForType() {
                return MailHandler.MailGetAllResponse.getDefaultInstance();
            }


            public MailHandler.MailGetAllResponse build() {
                MailHandler.MailGetAllResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public MailHandler.MailGetAllResponse buildPartial() {
                MailHandler.MailGetAllResponse result = new MailHandler.MailGetAllResponse(this);
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
                if (this.mailsBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4) {
                        this.mails_ = Collections.unmodifiableList(this.mails_);
                        this.bitField0_ &= 0xFFFFFFFB;
                    }
                    result.mails_ = this.mails_;
                } else {
                    result.mails_ = this.mailsBuilder_.build();
                }
                if ((from_bitField0_ & 0x8) == 8) {
                    to_bitField0_ |= 0x4;
                }
                result.s2CMaxMailNum_ = this.s2CMaxMailNum_;
                if ((from_bitField0_ & 0x10) == 16) {
                    to_bitField0_ |= 0x8;
                }
                result.s2CMaxWordNum_ = this.s2CMaxWordNum_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof MailHandler.MailGetAllResponse) {
                    return mergeFrom((MailHandler.MailGetAllResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(MailHandler.MailGetAllResponse other) {
                if (other == MailHandler.MailGetAllResponse.getDefaultInstance()) {
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
                if (this.mailsBuilder_ == null) {
                    if (!other.mails_.isEmpty()) {
                        if (this.mails_.isEmpty()) {
                            this.mails_ = other.mails_;
                            this.bitField0_ &= 0xFFFFFFFB;
                        } else {
                            ensureMailsIsMutable();
                            this.mails_.addAll(other.mails_);
                        }
                        onChanged();
                    }
                } else if (!other.mails_.isEmpty()) {
                    if (this.mailsBuilder_.isEmpty()) {
                        this.mailsBuilder_.dispose();
                        this.mailsBuilder_ = null;
                        this.mails_ = other.mails_;
                        this.bitField0_ &= 0xFFFFFFFB;
                        this.mailsBuilder_ = MailHandler.MailGetAllResponse.alwaysUseFieldBuilders ? getMailsFieldBuilder() : null;
                    } else {
                        this.mailsBuilder_.addAllMessages(other.mails_);
                    }
                }
                if (other.hasS2CMaxMailNum()) {
                    setS2CMaxMailNum(other.getS2CMaxMailNum());
                }
                if (other.hasS2CMaxWordNum()) {
                    setS2CMaxWordNum(other.getS2CMaxWordNum());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasS2CCode()) {
                    return false;
                }
                if (!hasS2CMaxMailNum()) {
                    return false;
                }
                if (!hasS2CMaxWordNum()) {
                    return false;
                }
                for (int i = 0; i < getMailsCount(); i++) {
                    if (!getMails(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                MailHandler.MailGetAllResponse parsedMessage = null;
                try {
                    parsedMessage = (MailHandler.MailGetAllResponse) MailHandler.MailGetAllResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MailHandler.MailGetAllResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = MailHandler.MailGetAllResponse.getDefaultInstance().getS2CMsg();
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


            private void ensureMailsIsMutable() {
                if ((this.bitField0_ & 0x4) != 4) {
                    this.mails_ = new ArrayList<>(this.mails_);
                    this.bitField0_ |= 0x4;
                }
            }


            public List<MailHandler.Mail> getMailsList() {
                if (this.mailsBuilder_ == null) {
                    return Collections.unmodifiableList(this.mails_);
                }
                return this.mailsBuilder_.getMessageList();
            }


            public int getMailsCount() {
                if (this.mailsBuilder_ == null) {
                    return this.mails_.size();
                }
                return this.mailsBuilder_.getCount();
            }


            public MailHandler.Mail getMails(int index) {
                if (this.mailsBuilder_ == null) {
                    return this.mails_.get(index);
                }
                return (MailHandler.Mail) this.mailsBuilder_.getMessage(index);
            }


            public Builder setMails(int index, MailHandler.Mail value) {
                if (this.mailsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureMailsIsMutable();
                    this.mails_.set(index, value);
                    onChanged();
                } else {
                    this.mailsBuilder_.setMessage(index, value);
                }
                return this;
            }


            public Builder setMails(int index, MailHandler.Mail.Builder builderForValue) {
                if (this.mailsBuilder_ == null) {
                    ensureMailsIsMutable();
                    this.mails_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.mailsBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }


            public Builder addMails(MailHandler.Mail value) {
                if (this.mailsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureMailsIsMutable();
                    this.mails_.add(value);
                    onChanged();
                } else {
                    this.mailsBuilder_.addMessage(value);
                }
                return this;
            }


            public Builder addMails(int index, MailHandler.Mail value) {
                if (this.mailsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureMailsIsMutable();
                    this.mails_.add(index, value);
                    onChanged();
                } else {
                    this.mailsBuilder_.addMessage(index, value);
                }
                return this;
            }


            public Builder addMails(MailHandler.Mail.Builder builderForValue) {
                if (this.mailsBuilder_ == null) {
                    ensureMailsIsMutable();
                    this.mails_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.mailsBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }


            public Builder addMails(int index, MailHandler.Mail.Builder builderForValue) {
                if (this.mailsBuilder_ == null) {
                    ensureMailsIsMutable();
                    this.mails_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.mailsBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }


            public Builder addAllMails(Iterable<? extends MailHandler.Mail> values) {
                if (this.mailsBuilder_ == null) {
                    ensureMailsIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.mails_);
                    onChanged();
                } else {
                    this.mailsBuilder_.addAllMessages(values);
                }
                return this;
            }


            public Builder clearMails() {
                if (this.mailsBuilder_ == null) {
                    this.mails_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                    onChanged();
                } else {
                    this.mailsBuilder_.clear();
                }
                return this;
            }


            public Builder removeMails(int index) {
                if (this.mailsBuilder_ == null) {
                    ensureMailsIsMutable();
                    this.mails_.remove(index);
                    onChanged();
                } else {
                    this.mailsBuilder_.remove(index);
                }
                return this;
            }


            public MailHandler.Mail.Builder getMailsBuilder(int index) {
                return (MailHandler.Mail.Builder) getMailsFieldBuilder().getBuilder(index);
            }


            public MailHandler.MailOrBuilder getMailsOrBuilder(int index) {
                if (this.mailsBuilder_ == null) {
                    return this.mails_.get(index);
                }
                return (MailHandler.MailOrBuilder) this.mailsBuilder_.getMessageOrBuilder(index);
            }


            public List<? extends MailHandler.MailOrBuilder> getMailsOrBuilderList() {
                if (this.mailsBuilder_ != null) {
                    return this.mailsBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList((List) this.mails_);
            }


            public MailHandler.Mail.Builder addMailsBuilder() {
                return (MailHandler.Mail.Builder) getMailsFieldBuilder().addBuilder(MailHandler.Mail.getDefaultInstance());
            }


            public MailHandler.Mail.Builder addMailsBuilder(int index) {
                return (MailHandler.Mail.Builder) getMailsFieldBuilder().addBuilder(index, MailHandler.Mail.getDefaultInstance());
            }


            public List<MailHandler.Mail.Builder> getMailsBuilderList() {
                return getMailsFieldBuilder().getBuilderList();
            }


            private RepeatedFieldBuilder<MailHandler.Mail, MailHandler.Mail.Builder, MailHandler.MailOrBuilder> getMailsFieldBuilder() {
                if (this.mailsBuilder_ == null) {
                    this.mailsBuilder_ = new RepeatedFieldBuilder(this.mails_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
                    this.mails_ = null;
                }
                return this.mailsBuilder_;
            }


            public boolean hasS2CMaxMailNum() {
                return ((this.bitField0_ & 0x8) == 8);
            }


            public int getS2CMaxMailNum() {
                return this.s2CMaxMailNum_;
            }


            public Builder setS2CMaxMailNum(int value) {
                this.bitField0_ |= 0x8;
                this.s2CMaxMailNum_ = value;
                onChanged();
                return this;
            }


            public Builder clearS2CMaxMailNum() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.s2CMaxMailNum_ = 0;
                onChanged();
                return this;
            }


            public boolean hasS2CMaxWordNum() {
                return ((this.bitField0_ & 0x10) == 16);
            }

            public int getS2CMaxWordNum() {
                return this.s2CMaxWordNum_;
            }

            public Builder setS2CMaxWordNum(int value) {
                this.bitField0_ |= 0x10;
                this.s2CMaxWordNum_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CMaxWordNum() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.s2CMaxWordNum_ = 0;
                onChanged();
                return this;
            }
        }
    }

    public static final class OnGetMailPush
            extends GeneratedMessage
            implements OnGetMailPushOrBuilder {
        private static final OnGetMailPush defaultInstance = new OnGetMailPush(true);
        private final UnknownFieldSet unknownFields;

        private OnGetMailPush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private OnGetMailPush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static OnGetMailPush getDefaultInstance() {
            return defaultInstance;
        }

        public OnGetMailPush getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private OnGetMailPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        case 18:
                            if ((mutable_bitField0_ & 0x2) != 2) {
                                this.mails_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x2;
                            }
                            this.mails_.add(input.readMessage(MailHandler.Mail.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x2) == 2) this.mails_ = Collections.unmodifiableList(this.mails_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MailHandler.internal_static_pomelo_area_OnGetMailPush_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MailHandler.internal_static_pomelo_area_OnGetMailPush_fieldAccessorTable.ensureFieldAccessorsInitialized(OnGetMailPush.class, Builder.class);
        }

        public static Parser<OnGetMailPush> PARSER = (Parser<OnGetMailPush>) new AbstractParser<OnGetMailPush>() {
            public MailHandler.OnGetMailPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MailHandler.OnGetMailPush(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int MAILS_FIELD_NUMBER = 2;
        private List<MailHandler.Mail> mails_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<OnGetMailPush> getParserForType() {
            return PARSER;
        }

        public boolean hasS2CCode() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getS2CCode() {
            return this.s2CCode_;
        }

        public List<MailHandler.Mail> getMailsList() {
            return this.mails_;
        }

        public List<? extends MailHandler.MailOrBuilder> getMailsOrBuilderList() {
            return (List) this.mails_;
        }

        public int getMailsCount() {
            return this.mails_.size();
        }

        public MailHandler.Mail getMails(int index) {
            return this.mails_.get(index);
        }

        public MailHandler.MailOrBuilder getMailsOrBuilder(int index) {
            return this.mails_.get(index);
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.mails_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasS2CCode()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (int i = 0; i < getMailsCount(); i++) {
                if (!getMails(i).isInitialized()) {
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
            for (int i = 0; i < this.mails_.size(); i++) output.writeMessage(2, (MessageLite) this.mails_.get(i));
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            for (int i = 0; i < this.mails_.size(); i++)
                size += CodedOutputStream.computeMessageSize(2, (MessageLite) this.mails_.get(i));
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static OnGetMailPush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (OnGetMailPush) PARSER.parseFrom(data);
        }

        public static OnGetMailPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (OnGetMailPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static OnGetMailPush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (OnGetMailPush) PARSER.parseFrom(data);
        }

        public static OnGetMailPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (OnGetMailPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static OnGetMailPush parseFrom(InputStream input) throws IOException {
            return (OnGetMailPush) PARSER.parseFrom(input);
        }

        public static OnGetMailPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OnGetMailPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static OnGetMailPush parseDelimitedFrom(InputStream input) throws IOException {
            return (OnGetMailPush) PARSER.parseDelimitedFrom(input);
        }

        public static OnGetMailPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OnGetMailPush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static OnGetMailPush parseFrom(CodedInputStream input) throws IOException {
            return (OnGetMailPush) PARSER.parseFrom(input);
        }

        public static OnGetMailPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OnGetMailPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(OnGetMailPush prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements MailHandler.OnGetMailPushOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private List<MailHandler.Mail> mails_;
            private RepeatedFieldBuilder<MailHandler.Mail, MailHandler.Mail.Builder, MailHandler.MailOrBuilder> mailsBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MailHandler.internal_static_pomelo_area_OnGetMailPush_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MailHandler.internal_static_pomelo_area_OnGetMailPush_fieldAccessorTable.ensureFieldAccessorsInitialized(MailHandler.OnGetMailPush.class, Builder.class);
            }

            private Builder() {
                this.mails_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.mails_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MailHandler.OnGetMailPush.alwaysUseFieldBuilders) getMailsFieldBuilder();
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.s2CCode_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                if (this.mailsBuilder_ == null) {
                    this.mails_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFD;
                } else {
                    this.mailsBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return MailHandler.internal_static_pomelo_area_OnGetMailPush_descriptor;
            }

            public MailHandler.OnGetMailPush getDefaultInstanceForType() {
                return MailHandler.OnGetMailPush.getDefaultInstance();
            }

            public MailHandler.OnGetMailPush build() {
                MailHandler.OnGetMailPush result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public MailHandler.OnGetMailPush buildPartial() {
                MailHandler.OnGetMailPush result = new MailHandler.OnGetMailPush(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if (this.mailsBuilder_ == null) {
                    if ((this.bitField0_ & 0x2) == 2) {
                        this.mails_ = Collections.unmodifiableList(this.mails_);
                        this.bitField0_ &= 0xFFFFFFFD;
                    }
                    result.mails_ = this.mails_;
                } else {
                    result.mails_ = this.mailsBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof MailHandler.OnGetMailPush) return mergeFrom((MailHandler.OnGetMailPush) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MailHandler.OnGetMailPush other) {
                if (other == MailHandler.OnGetMailPush.getDefaultInstance()) return this;
                if (other.hasS2CCode()) setS2CCode(other.getS2CCode());
                if (this.mailsBuilder_ == null) {
                    if (!other.mails_.isEmpty()) {
                        if (this.mails_.isEmpty()) {
                            this.mails_ = other.mails_;
                            this.bitField0_ &= 0xFFFFFFFD;
                        } else {
                            ensureMailsIsMutable();
                            this.mails_.addAll(other.mails_);
                        }
                        onChanged();
                    }
                } else if (!other.mails_.isEmpty()) {
                    if (this.mailsBuilder_.isEmpty()) {
                        this.mailsBuilder_.dispose();
                        this.mailsBuilder_ = null;
                        this.mails_ = other.mails_;
                        this.bitField0_ &= 0xFFFFFFFD;
                        this.mailsBuilder_ = MailHandler.OnGetMailPush.alwaysUseFieldBuilders ? getMailsFieldBuilder() : null;
                    } else {
                        this.mailsBuilder_.addAllMessages(other.mails_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode()) return false;
                for (int i = 0; i < getMailsCount(); i++) {
                    if (!getMails(i).isInitialized()) return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                MailHandler.OnGetMailPush parsedMessage = null;
                try {
                    parsedMessage = (MailHandler.OnGetMailPush) MailHandler.OnGetMailPush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MailHandler.OnGetMailPush) e.getUnfinishedMessage();
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

            private void ensureMailsIsMutable() {
                if ((this.bitField0_ & 0x2) != 2) {
                    this.mails_ = new ArrayList<>(this.mails_);
                    this.bitField0_ |= 0x2;
                }
            }

            public List<MailHandler.Mail> getMailsList() {
                if (this.mailsBuilder_ == null) return Collections.unmodifiableList(this.mails_);
                return this.mailsBuilder_.getMessageList();
            }

            public int getMailsCount() {
                if (this.mailsBuilder_ == null) return this.mails_.size();
                return this.mailsBuilder_.getCount();
            }

            public MailHandler.Mail getMails(int index) {
                if (this.mailsBuilder_ == null) return this.mails_.get(index);
                return (MailHandler.Mail) this.mailsBuilder_.getMessage(index);
            }

            public Builder setMails(int index, MailHandler.Mail value) {
                if (this.mailsBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureMailsIsMutable();
                    this.mails_.set(index, value);
                    onChanged();
                } else {
                    this.mailsBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setMails(int index, MailHandler.Mail.Builder builderForValue) {
                if (this.mailsBuilder_ == null) {
                    ensureMailsIsMutable();
                    this.mails_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.mailsBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addMails(MailHandler.Mail value) {
                if (this.mailsBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureMailsIsMutable();
                    this.mails_.add(value);
                    onChanged();
                } else {
                    this.mailsBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addMails(int index, MailHandler.Mail value) {
                if (this.mailsBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureMailsIsMutable();
                    this.mails_.add(index, value);
                    onChanged();
                } else {
                    this.mailsBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addMails(MailHandler.Mail.Builder builderForValue) {
                if (this.mailsBuilder_ == null) {
                    ensureMailsIsMutable();
                    this.mails_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.mailsBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addMails(int index, MailHandler.Mail.Builder builderForValue) {
                if (this.mailsBuilder_ == null) {
                    ensureMailsIsMutable();
                    this.mails_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.mailsBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllMails(Iterable<? extends MailHandler.Mail> values) {
                if (this.mailsBuilder_ == null) {
                    ensureMailsIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.mails_);
                    onChanged();
                } else {
                    this.mailsBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearMails() {
                if (this.mailsBuilder_ == null) {
                    this.mails_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFD;
                    onChanged();
                } else {
                    this.mailsBuilder_.clear();
                }
                return this;
            }

            public Builder removeMails(int index) {
                if (this.mailsBuilder_ == null) {
                    ensureMailsIsMutable();
                    this.mails_.remove(index);
                    onChanged();
                } else {
                    this.mailsBuilder_.remove(index);
                }
                return this;
            }

            public MailHandler.Mail.Builder getMailsBuilder(int index) {
                return (MailHandler.Mail.Builder) getMailsFieldBuilder().getBuilder(index);
            }

            public MailHandler.MailOrBuilder getMailsOrBuilder(int index) {
                if (this.mailsBuilder_ == null) return this.mails_.get(index);
                return (MailHandler.MailOrBuilder) this.mailsBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends MailHandler.MailOrBuilder> getMailsOrBuilderList() {
                if (this.mailsBuilder_ != null) return this.mailsBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.mails_);
            }

            public MailHandler.Mail.Builder addMailsBuilder() {
                return (MailHandler.Mail.Builder) getMailsFieldBuilder().addBuilder(MailHandler.Mail.getDefaultInstance());
            }

            public MailHandler.Mail.Builder addMailsBuilder(int index) {
                return (MailHandler.Mail.Builder) getMailsFieldBuilder().addBuilder(index, MailHandler.Mail.getDefaultInstance());
            }

            public List<MailHandler.Mail.Builder> getMailsBuilderList() {
                return getMailsFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<MailHandler.Mail, MailHandler.Mail.Builder, MailHandler.MailOrBuilder> getMailsFieldBuilder() {
                if (this.mailsBuilder_ == null) {
                    this.mailsBuilder_ = new RepeatedFieldBuilder(this.mails_, ((this.bitField0_ & 0x2) == 2), getParentForChildren(), isClean());
                    this.mails_ = null;
                }
                return this.mailsBuilder_;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class MailSendMailResponse
            extends GeneratedMessage
            implements MailSendMailResponseOrBuilder {
        private static final MailSendMailResponse defaultInstance = new MailSendMailResponse(true);
        private final UnknownFieldSet unknownFields;

        private MailSendMailResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private MailSendMailResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static MailSendMailResponse getDefaultInstance() {
            return defaultInstance;
        }

        public MailSendMailResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MailSendMailResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return MailHandler.internal_static_pomelo_area_MailSendMailResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MailHandler.internal_static_pomelo_area_MailSendMailResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(MailSendMailResponse.class, Builder.class);
        }

        public static Parser<MailSendMailResponse> PARSER = (Parser<MailSendMailResponse>) new AbstractParser<MailSendMailResponse>() {
            public MailHandler.MailSendMailResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MailHandler.MailSendMailResponse(input, extensionRegistry);
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

        public Parser<MailSendMailResponse> getParserForType() {
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

        public static MailSendMailResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (MailSendMailResponse) PARSER.parseFrom(data);
        }

        public static MailSendMailResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MailSendMailResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MailSendMailResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (MailSendMailResponse) PARSER.parseFrom(data);
        }

        public static MailSendMailResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MailSendMailResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MailSendMailResponse parseFrom(InputStream input) throws IOException {
            return (MailSendMailResponse) PARSER.parseFrom(input);
        }

        public static MailSendMailResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MailSendMailResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static MailSendMailResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (MailSendMailResponse) PARSER.parseDelimitedFrom(input);
        }

        public static MailSendMailResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MailSendMailResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static MailSendMailResponse parseFrom(CodedInputStream input) throws IOException {
            return (MailSendMailResponse) PARSER.parseFrom(input);
        }

        public static MailSendMailResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MailSendMailResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(MailSendMailResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements MailHandler.MailSendMailResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MailHandler.internal_static_pomelo_area_MailSendMailResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MailHandler.internal_static_pomelo_area_MailSendMailResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(MailHandler.MailSendMailResponse.class, Builder.class);
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
                if (MailHandler.MailSendMailResponse.alwaysUseFieldBuilders) ;
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
                return MailHandler.internal_static_pomelo_area_MailSendMailResponse_descriptor;
            }

            public MailHandler.MailSendMailResponse getDefaultInstanceForType() {
                return MailHandler.MailSendMailResponse.getDefaultInstance();
            }

            public MailHandler.MailSendMailResponse build() {
                MailHandler.MailSendMailResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public MailHandler.MailSendMailResponse buildPartial() {
                MailHandler.MailSendMailResponse result = new MailHandler.MailSendMailResponse(this);
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
                if (other instanceof MailHandler.MailSendMailResponse)
                    return mergeFrom((MailHandler.MailSendMailResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MailHandler.MailSendMailResponse other) {
                if (other == MailHandler.MailSendMailResponse.getDefaultInstance()) return this;
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
                MailHandler.MailSendMailResponse parsedMessage = null;
                try {
                    parsedMessage = (MailHandler.MailSendMailResponse) MailHandler.MailSendMailResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MailHandler.MailSendMailResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = MailHandler.MailSendMailResponse.getDefaultInstance().getS2CMsg();
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


    public static final class MailDeleteResponse
            extends GeneratedMessage
            implements MailDeleteResponseOrBuilder {
        private static final MailDeleteResponse defaultInstance = new MailDeleteResponse(true);
        private final UnknownFieldSet unknownFields;

        private MailDeleteResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private MailDeleteResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static MailDeleteResponse getDefaultInstance() {
            return defaultInstance;
        }

        public MailDeleteResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MailDeleteResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return MailHandler.internal_static_pomelo_area_MailDeleteResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MailHandler.internal_static_pomelo_area_MailDeleteResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(MailDeleteResponse.class, Builder.class);
        }

        public static Parser<MailDeleteResponse> PARSER = (Parser<MailDeleteResponse>) new AbstractParser<MailDeleteResponse>() {
            public MailHandler.MailDeleteResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MailHandler.MailDeleteResponse(input, extensionRegistry);
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

        public Parser<MailDeleteResponse> getParserForType() {
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

        public static MailDeleteResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (MailDeleteResponse) PARSER.parseFrom(data);
        }

        public static MailDeleteResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MailDeleteResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MailDeleteResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (MailDeleteResponse) PARSER.parseFrom(data);
        }

        public static MailDeleteResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MailDeleteResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MailDeleteResponse parseFrom(InputStream input) throws IOException {
            return (MailDeleteResponse) PARSER.parseFrom(input);
        }

        public static MailDeleteResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MailDeleteResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static MailDeleteResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (MailDeleteResponse) PARSER.parseDelimitedFrom(input);
        }

        public static MailDeleteResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MailDeleteResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static MailDeleteResponse parseFrom(CodedInputStream input) throws IOException {
            return (MailDeleteResponse) PARSER.parseFrom(input);
        }

        public static MailDeleteResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MailDeleteResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(MailDeleteResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements MailHandler.MailDeleteResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MailHandler.internal_static_pomelo_area_MailDeleteResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MailHandler.internal_static_pomelo_area_MailDeleteResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(MailHandler.MailDeleteResponse.class, Builder.class);
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
                if (MailHandler.MailDeleteResponse.alwaysUseFieldBuilders) ;
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
                return MailHandler.internal_static_pomelo_area_MailDeleteResponse_descriptor;
            }

            public MailHandler.MailDeleteResponse getDefaultInstanceForType() {
                return MailHandler.MailDeleteResponse.getDefaultInstance();
            }

            public MailHandler.MailDeleteResponse build() {
                MailHandler.MailDeleteResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public MailHandler.MailDeleteResponse buildPartial() {
                MailHandler.MailDeleteResponse result = new MailHandler.MailDeleteResponse(this);
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
                if (other instanceof MailHandler.MailDeleteResponse)
                    return mergeFrom((MailHandler.MailDeleteResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MailHandler.MailDeleteResponse other) {
                if (other == MailHandler.MailDeleteResponse.getDefaultInstance()) return this;
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
                MailHandler.MailDeleteResponse parsedMessage = null;
                try {
                    parsedMessage = (MailHandler.MailDeleteResponse) MailHandler.MailDeleteResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MailHandler.MailDeleteResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = MailHandler.MailDeleteResponse.getDefaultInstance().getS2CMsg();
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


    public static final class MailDeleteOneKeyResponse
            extends GeneratedMessage
            implements MailDeleteOneKeyResponseOrBuilder {
        private static final MailDeleteOneKeyResponse defaultInstance = new MailDeleteOneKeyResponse(true);
        private final UnknownFieldSet unknownFields;

        private MailDeleteOneKeyResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private MailDeleteOneKeyResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static MailDeleteOneKeyResponse getDefaultInstance() {
            return defaultInstance;
        }

        public MailDeleteOneKeyResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MailDeleteOneKeyResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            if ((mutable_bitField0_ & 0x4) != 4) {
                                this.s2CIds_ = (LazyStringList) new LazyStringArrayList();
                                mutable_bitField0_ |= 0x4;
                            }
                            this.s2CIds_.add(bs);
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x4) == 4) this.s2CIds_ = this.s2CIds_.getUnmodifiableView();
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MailHandler.internal_static_pomelo_area_MailDeleteOneKeyResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MailHandler.internal_static_pomelo_area_MailDeleteOneKeyResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(MailDeleteOneKeyResponse.class, Builder.class);
        }

        public static Parser<MailDeleteOneKeyResponse> PARSER = (Parser<MailDeleteOneKeyResponse>) new AbstractParser<MailDeleteOneKeyResponse>() {
            public MailHandler.MailDeleteOneKeyResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MailHandler.MailDeleteOneKeyResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_IDS_FIELD_NUMBER = 3;
        private LazyStringList s2CIds_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<MailDeleteOneKeyResponse> getParserForType() {
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

        public ProtocolStringList getS2CIdsList() {
            return (ProtocolStringList) this.s2CIds_;
        }

        public int getS2CIdsCount() {
            return this.s2CIds_.size();
        }

        public String getS2CIds(int index) {
            return (String) this.s2CIds_.get(index);
        }

        public ByteString getS2CIdsBytes(int index) {
            return this.s2CIds_.getByteString(index);
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CIds_ = LazyStringArrayList.EMPTY;
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
            for (int i = 0; i < this.s2CIds_.size(); i++) output.writeBytes(3, this.s2CIds_.getByteString(i));
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());
            int dataSize = 0;
            for (int i = 0; i < this.s2CIds_.size(); i++)
                dataSize += CodedOutputStream.computeBytesSizeNoTag(this.s2CIds_.getByteString(i));
            size += dataSize;
            size += 1 * getS2CIdsList().size();
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static MailDeleteOneKeyResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (MailDeleteOneKeyResponse) PARSER.parseFrom(data);
        }

        public static MailDeleteOneKeyResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MailDeleteOneKeyResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MailDeleteOneKeyResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (MailDeleteOneKeyResponse) PARSER.parseFrom(data);
        }

        public static MailDeleteOneKeyResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MailDeleteOneKeyResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MailDeleteOneKeyResponse parseFrom(InputStream input) throws IOException {
            return (MailDeleteOneKeyResponse) PARSER.parseFrom(input);
        }

        public static MailDeleteOneKeyResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MailDeleteOneKeyResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static MailDeleteOneKeyResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (MailDeleteOneKeyResponse) PARSER.parseDelimitedFrom(input);
        }

        public static MailDeleteOneKeyResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MailDeleteOneKeyResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static MailDeleteOneKeyResponse parseFrom(CodedInputStream input) throws IOException {
            return (MailDeleteOneKeyResponse) PARSER.parseFrom(input);
        }

        public static MailDeleteOneKeyResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MailDeleteOneKeyResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(MailDeleteOneKeyResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements MailHandler.MailDeleteOneKeyResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private LazyStringList s2CIds_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MailHandler.internal_static_pomelo_area_MailDeleteOneKeyResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MailHandler.internal_static_pomelo_area_MailDeleteOneKeyResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(MailHandler.MailDeleteOneKeyResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.s2CIds_ = LazyStringArrayList.EMPTY;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CIds_ = LazyStringArrayList.EMPTY;
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MailHandler.MailDeleteOneKeyResponse.alwaysUseFieldBuilders) ;
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
                this.s2CIds_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return MailHandler.internal_static_pomelo_area_MailDeleteOneKeyResponse_descriptor;
            }

            public MailHandler.MailDeleteOneKeyResponse getDefaultInstanceForType() {
                return MailHandler.MailDeleteOneKeyResponse.getDefaultInstance();
            }

            public MailHandler.MailDeleteOneKeyResponse build() {
                MailHandler.MailDeleteOneKeyResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public MailHandler.MailDeleteOneKeyResponse buildPartial() {
                MailHandler.MailDeleteOneKeyResponse result = new MailHandler.MailDeleteOneKeyResponse(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.s2CMsg_ = this.s2CMsg_;
                if ((this.bitField0_ & 0x4) == 4) {
                    this.s2CIds_ = this.s2CIds_.getUnmodifiableView();
                    this.bitField0_ &= 0xFFFFFFFB;
                }
                result.s2CIds_ = this.s2CIds_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof MailHandler.MailDeleteOneKeyResponse)
                    return mergeFrom((MailHandler.MailDeleteOneKeyResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MailHandler.MailDeleteOneKeyResponse other) {
                if (other == MailHandler.MailDeleteOneKeyResponse.getDefaultInstance()) return this;
                if (other.hasS2CCode()) setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (!other.s2CIds_.isEmpty()) {
                    if (this.s2CIds_.isEmpty()) {
                        this.s2CIds_ = other.s2CIds_;
                        this.bitField0_ &= 0xFFFFFFFB;
                    } else {
                        ensureS2CIdsIsMutable();
                        this.s2CIds_.addAll((Collection) other.s2CIds_);
                    }
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
                MailHandler.MailDeleteOneKeyResponse parsedMessage = null;
                try {
                    parsedMessage = (MailHandler.MailDeleteOneKeyResponse) MailHandler.MailDeleteOneKeyResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MailHandler.MailDeleteOneKeyResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = MailHandler.MailDeleteOneKeyResponse.getDefaultInstance().getS2CMsg();
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

            private void ensureS2CIdsIsMutable() {
                if ((this.bitField0_ & 0x4) != 4) {
                    this.s2CIds_ = (LazyStringList) new LazyStringArrayList(this.s2CIds_);
                    this.bitField0_ |= 0x4;
                }
            }

            public ProtocolStringList getS2CIdsList() {
                return (ProtocolStringList) this.s2CIds_.getUnmodifiableView();
            }

            public int getS2CIdsCount() {
                return this.s2CIds_.size();
            }

            public String getS2CIds(int index) {
                return (String) this.s2CIds_.get(index);
            }

            public ByteString getS2CIdsBytes(int index) {
                return this.s2CIds_.getByteString(index);
            }

            public Builder setS2CIds(int index, String value) {
                if (value == null) throw new NullPointerException();
                ensureS2CIdsIsMutable();
                this.s2CIds_.set(index, value);
                onChanged();
                return this;
            }

            public Builder addS2CIds(String value) {
                if (value == null) throw new NullPointerException();
                ensureS2CIdsIsMutable();
                this.s2CIds_.add(value);
                onChanged();
                return this;
            }

            public Builder addAllS2CIds(Iterable<String> values) {
                ensureS2CIdsIsMutable();
                AbstractMessageLite.Builder.addAll(values, (Collection) this.s2CIds_);
                onChanged();
                return this;
            }

            public Builder clearS2CIds() {
                this.s2CIds_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= 0xFFFFFFFB;
                onChanged();
                return this;
            }

            public Builder addS2CIdsBytes(ByteString value) {
                if (value == null) throw new NullPointerException();
                ensureS2CIdsIsMutable();
                this.s2CIds_.add(value);
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class MailGetAttachmentResponse
            extends GeneratedMessage
            implements MailGetAttachmentResponseOrBuilder {
        private static final MailGetAttachmentResponse defaultInstance = new MailGetAttachmentResponse(true);
        private final UnknownFieldSet unknownFields;

        private MailGetAttachmentResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private MailGetAttachmentResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static MailGetAttachmentResponse getDefaultInstance() {
            return defaultInstance;
        }

        public MailGetAttachmentResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MailGetAttachmentResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return MailHandler.internal_static_pomelo_area_MailGetAttachmentResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MailHandler.internal_static_pomelo_area_MailGetAttachmentResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(MailGetAttachmentResponse.class, Builder.class);
        }

        public static Parser<MailGetAttachmentResponse> PARSER = (Parser<MailGetAttachmentResponse>) new AbstractParser<MailGetAttachmentResponse>() {
            public MailHandler.MailGetAttachmentResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MailHandler.MailGetAttachmentResponse(input, extensionRegistry);
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

        public Parser<MailGetAttachmentResponse> getParserForType() {
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

        public static MailGetAttachmentResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (MailGetAttachmentResponse) PARSER.parseFrom(data);
        }

        public static MailGetAttachmentResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MailGetAttachmentResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MailGetAttachmentResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (MailGetAttachmentResponse) PARSER.parseFrom(data);
        }

        public static MailGetAttachmentResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MailGetAttachmentResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MailGetAttachmentResponse parseFrom(InputStream input) throws IOException {
            return (MailGetAttachmentResponse) PARSER.parseFrom(input);
        }

        public static MailGetAttachmentResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MailGetAttachmentResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static MailGetAttachmentResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (MailGetAttachmentResponse) PARSER.parseDelimitedFrom(input);
        }

        public static MailGetAttachmentResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MailGetAttachmentResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static MailGetAttachmentResponse parseFrom(CodedInputStream input) throws IOException {
            return (MailGetAttachmentResponse) PARSER.parseFrom(input);
        }

        public static MailGetAttachmentResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MailGetAttachmentResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(MailGetAttachmentResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements MailHandler.MailGetAttachmentResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MailHandler.internal_static_pomelo_area_MailGetAttachmentResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MailHandler.internal_static_pomelo_area_MailGetAttachmentResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(MailHandler.MailGetAttachmentResponse.class, Builder.class);
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
                if (MailHandler.MailGetAttachmentResponse.alwaysUseFieldBuilders) ;
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
                return MailHandler.internal_static_pomelo_area_MailGetAttachmentResponse_descriptor;
            }

            public MailHandler.MailGetAttachmentResponse getDefaultInstanceForType() {
                return MailHandler.MailGetAttachmentResponse.getDefaultInstance();
            }

            public MailHandler.MailGetAttachmentResponse build() {
                MailHandler.MailGetAttachmentResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public MailHandler.MailGetAttachmentResponse buildPartial() {
                MailHandler.MailGetAttachmentResponse result = new MailHandler.MailGetAttachmentResponse(this);
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
                if (other instanceof MailHandler.MailGetAttachmentResponse)
                    return mergeFrom((MailHandler.MailGetAttachmentResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MailHandler.MailGetAttachmentResponse other) {
                if (other == MailHandler.MailGetAttachmentResponse.getDefaultInstance()) return this;
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
                MailHandler.MailGetAttachmentResponse parsedMessage = null;
                try {
                    parsedMessage = (MailHandler.MailGetAttachmentResponse) MailHandler.MailGetAttachmentResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MailHandler.MailGetAttachmentResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = MailHandler.MailGetAttachmentResponse.getDefaultInstance().getS2CMsg();
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


    public static final class MailGetAttachmentOneKeyResponse
            extends GeneratedMessage
            implements MailGetAttachmentOneKeyResponseOrBuilder {
        private static final MailGetAttachmentOneKeyResponse defaultInstance = new MailGetAttachmentOneKeyResponse(true);
        private final UnknownFieldSet unknownFields;

        private MailGetAttachmentOneKeyResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private MailGetAttachmentOneKeyResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static MailGetAttachmentOneKeyResponse getDefaultInstance() {
            return defaultInstance;
        }

        public MailGetAttachmentOneKeyResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MailGetAttachmentOneKeyResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            if ((mutable_bitField0_ & 0x4) != 4) {
                                this.s2CIds_ = (LazyStringList) new LazyStringArrayList();
                                mutable_bitField0_ |= 0x4;
                            }
                            this.s2CIds_.add(bs);
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x4) == 4) this.s2CIds_ = this.s2CIds_.getUnmodifiableView();
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MailHandler.internal_static_pomelo_area_MailGetAttachmentOneKeyResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MailHandler.internal_static_pomelo_area_MailGetAttachmentOneKeyResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(MailGetAttachmentOneKeyResponse.class, Builder.class);
        }

        public static Parser<MailGetAttachmentOneKeyResponse> PARSER = (Parser<MailGetAttachmentOneKeyResponse>) new AbstractParser<MailGetAttachmentOneKeyResponse>() {
            public MailHandler.MailGetAttachmentOneKeyResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MailHandler.MailGetAttachmentOneKeyResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_IDS_FIELD_NUMBER = 3;
        private LazyStringList s2CIds_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<MailGetAttachmentOneKeyResponse> getParserForType() {
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

        public ProtocolStringList getS2CIdsList() {
            return (ProtocolStringList) this.s2CIds_;
        }

        public int getS2CIdsCount() {
            return this.s2CIds_.size();
        }

        public String getS2CIds(int index) {
            return (String) this.s2CIds_.get(index);
        }

        public ByteString getS2CIdsBytes(int index) {
            return this.s2CIds_.getByteString(index);
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CIds_ = LazyStringArrayList.EMPTY;
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
            for (int i = 0; i < this.s2CIds_.size(); i++) output.writeBytes(3, this.s2CIds_.getByteString(i));
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());
            int dataSize = 0;
            for (int i = 0; i < this.s2CIds_.size(); i++)
                dataSize += CodedOutputStream.computeBytesSizeNoTag(this.s2CIds_.getByteString(i));
            size += dataSize;
            size += 1 * getS2CIdsList().size();
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static MailGetAttachmentOneKeyResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (MailGetAttachmentOneKeyResponse) PARSER.parseFrom(data);
        }

        public static MailGetAttachmentOneKeyResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MailGetAttachmentOneKeyResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MailGetAttachmentOneKeyResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (MailGetAttachmentOneKeyResponse) PARSER.parseFrom(data);
        }

        public static MailGetAttachmentOneKeyResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MailGetAttachmentOneKeyResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MailGetAttachmentOneKeyResponse parseFrom(InputStream input) throws IOException {
            return (MailGetAttachmentOneKeyResponse) PARSER.parseFrom(input);
        }

        public static MailGetAttachmentOneKeyResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MailGetAttachmentOneKeyResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static MailGetAttachmentOneKeyResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (MailGetAttachmentOneKeyResponse) PARSER.parseDelimitedFrom(input);
        }

        public static MailGetAttachmentOneKeyResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MailGetAttachmentOneKeyResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static MailGetAttachmentOneKeyResponse parseFrom(CodedInputStream input) throws IOException {
            return (MailGetAttachmentOneKeyResponse) PARSER.parseFrom(input);
        }

        public static MailGetAttachmentOneKeyResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MailGetAttachmentOneKeyResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(MailGetAttachmentOneKeyResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements MailHandler.MailGetAttachmentOneKeyResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private LazyStringList s2CIds_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MailHandler.internal_static_pomelo_area_MailGetAttachmentOneKeyResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MailHandler.internal_static_pomelo_area_MailGetAttachmentOneKeyResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(MailHandler.MailGetAttachmentOneKeyResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.s2CIds_ = LazyStringArrayList.EMPTY;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CIds_ = LazyStringArrayList.EMPTY;
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MailHandler.MailGetAttachmentOneKeyResponse.alwaysUseFieldBuilders) ;
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
                this.s2CIds_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return MailHandler.internal_static_pomelo_area_MailGetAttachmentOneKeyResponse_descriptor;
            }

            public MailHandler.MailGetAttachmentOneKeyResponse getDefaultInstanceForType() {
                return MailHandler.MailGetAttachmentOneKeyResponse.getDefaultInstance();
            }

            public MailHandler.MailGetAttachmentOneKeyResponse build() {
                MailHandler.MailGetAttachmentOneKeyResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public MailHandler.MailGetAttachmentOneKeyResponse buildPartial() {
                MailHandler.MailGetAttachmentOneKeyResponse result = new MailHandler.MailGetAttachmentOneKeyResponse(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.s2CMsg_ = this.s2CMsg_;
                if ((this.bitField0_ & 0x4) == 4) {
                    this.s2CIds_ = this.s2CIds_.getUnmodifiableView();
                    this.bitField0_ &= 0xFFFFFFFB;
                }
                result.s2CIds_ = this.s2CIds_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof MailHandler.MailGetAttachmentOneKeyResponse)
                    return mergeFrom((MailHandler.MailGetAttachmentOneKeyResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MailHandler.MailGetAttachmentOneKeyResponse other) {
                if (other == MailHandler.MailGetAttachmentOneKeyResponse.getDefaultInstance()) return this;
                if (other.hasS2CCode()) setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (!other.s2CIds_.isEmpty()) {
                    if (this.s2CIds_.isEmpty()) {
                        this.s2CIds_ = other.s2CIds_;
                        this.bitField0_ &= 0xFFFFFFFB;
                    } else {
                        ensureS2CIdsIsMutable();
                        this.s2CIds_.addAll((Collection) other.s2CIds_);
                    }
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
                MailHandler.MailGetAttachmentOneKeyResponse parsedMessage = null;
                try {
                    parsedMessage = (MailHandler.MailGetAttachmentOneKeyResponse) MailHandler.MailGetAttachmentOneKeyResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MailHandler.MailGetAttachmentOneKeyResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = MailHandler.MailGetAttachmentOneKeyResponse.getDefaultInstance().getS2CMsg();
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

            private void ensureS2CIdsIsMutable() {
                if ((this.bitField0_ & 0x4) != 4) {
                    this.s2CIds_ = (LazyStringList) new LazyStringArrayList(this.s2CIds_);
                    this.bitField0_ |= 0x4;
                }
            }

            public ProtocolStringList getS2CIdsList() {
                return (ProtocolStringList) this.s2CIds_.getUnmodifiableView();
            }

            public int getS2CIdsCount() {
                return this.s2CIds_.size();
            }

            public String getS2CIds(int index) {
                return (String) this.s2CIds_.get(index);
            }

            public ByteString getS2CIdsBytes(int index) {
                return this.s2CIds_.getByteString(index);
            }

            public Builder setS2CIds(int index, String value) {
                if (value == null) throw new NullPointerException();
                ensureS2CIdsIsMutable();
                this.s2CIds_.set(index, value);
                onChanged();
                return this;
            }

            public Builder addS2CIds(String value) {
                if (value == null) throw new NullPointerException();
                ensureS2CIdsIsMutable();
                this.s2CIds_.add(value);
                onChanged();
                return this;
            }

            public Builder addAllS2CIds(Iterable<String> values) {
                ensureS2CIdsIsMutable();
                AbstractMessageLite.Builder.addAll(values, (Collection) this.s2CIds_);
                onChanged();
                return this;
            }

            public Builder clearS2CIds() {
                this.s2CIds_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= 0xFFFFFFFB;
                onChanged();
                return this;
            }

            public Builder addS2CIdsBytes(ByteString value) {
                if (value == null) throw new NullPointerException();
                ensureS2CIdsIsMutable();
                this.s2CIds_.add(value);
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }


    static {
        String[] descriptorData = {"\n\021mailHandler.proto\022\013pomelo.area\032\fcommon.proto\032\nitem.proto\"\023\n\021MailGetAllRequest\" \n\016MailReadNotify\022\016\n\006c2s_id\030\001 \003(\t\"v\n\023MailSendMailRequest\022\022\n\ntoPlayerId\030\001 \002(\t\022\021\n\tmailTitle\030\002 \002(\t\022\020\n\bmailText\030\003 \002(\t\022\020\n\bmailRead\030\004 \002(\005\022\024\n\ftoPlayerName\030\005 \001(\t\"*\n\030MailGetAttachmentRequest\022\016\n\006c2s_id\030\001 \002(\t\" \n\036MailGetAttachmentOneKeyRequest\"#\n\021MailDeleteRequest\022\016\n\006c2s_id\030\001 \002(\t\"\031\n\027MailDeleteOneKeyRequest\"<\n\022MailSendTestNotify\022\022\n", "\nc2s_mailId\030\001 \002(\005\022\022\n\nc2s_tcCode\030\002 \002(\t\"æ\002\n\004Mail\022\n\n\002id\030\001 \002(\t\022\016\n\006mailId\030\002 \002(\005\022\020\n\bmailType\030\003 \002(\005\022\020\n\bmailIcon\030\004 \002(\005\022\022\n\nmailSender\030\005 \002(\t\022\021\n\tmailTitle\030\006 \002(\t\022\020\n\bmailText\030\007 \002(\t\022\022\n\ncreateTime\030\b \002(\t\022\016\n\006status\030\t \002(\005\022\020\n\bmailRead\030\n \002(\005\022\021\n\thadAttach\030\013 \002(\005\022)\n\nattachment\030\f \003(\0132\025.pomelo.item.MiniItem\022\024\n\fmailSenderId\030\r \001(\t\022+\n\007itemEar\030\016 \003(\0132\032.pomelo.item.EarItemDetail\022.\n\rnewAttachment\030\017 \003(\0132\027.pomelo.item.ItemDetail\"", "\001\n\022MailGetAllResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022 \n\005mails\030\003 \003(\0132\021.pomelo.area.Mail\022\026\n\016s2c_maxMailNum\030\004 \002(\005\022\026\n\016s2c_maxWordNum\030\005 \002(\005\"C\n\rOnGetMailPush\022\020\n\bs2c_code\030\001 \002(\005\022 \n\005mails\030\002 \003(\0132\021.pomelo.area.Mail\"9\n\024MailSendMailResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"7\n\022MailDeleteResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"N\n\030MailDeleteOneKeyResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\017\n\007s2c_ids\030\003 ", "\003(\t\">\n\031MailGetAttachmentResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"U\n\037MailGetAttachmentOneKeyResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\017\n\007s2c_ids\030\003 \003(\t2ç\005\n\013mailHandler\022T\n\021mailGetAllRequest\022\036.pomelo.area.MailGetAllRequest\032\037.pomelo.area.MailGetAllResponse\022;\n\016mailReadNotify\022\033.pomelo.area.MailReadNotify\032\f.pomelo.Void\022Z\n\023mailSendMailRequest\022 .pomelo.area.MailSendMailRequest\032!.pomelo.area.MailSendMai", "lResponse\022T\n\021mailDeleteRequest\022\036.pomelo.area.MailDeleteRequest\032\037.pomelo.area.MailDeleteResponse\022f\n\027mailDeleteOneKeyRequest\022$.pomelo.area.MailDeleteOneKeyRequest\032%.pomelo.area.MailDeleteOneKeyResponse\022i\n\030mailGetAttachmentRequest\022%.pomelo.area.MailGetAttachmentRequest\032&.pomelo.area.MailGetAttachmentResponse\022{\n\036mailGetAttachmentOneKeyRequest\022+.pomelo.area.MailGetAttachmentOneKeyRequest\032,.pomelo.area.", "MailGetAttachmentOneKeyResponse\022C\n\022mailSendTestNotify\022\037.pomelo.area.MailSendTestNotify\032\f.pomelo.Void2E\n\bmailPush\0229\n\ronGetMailPush\022\032.pomelo.area.OnGetMailPush\032\f.pomelo.Void"};


        Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root) {
                MailHandler.descriptor = root;
                return null;
            }
        };

        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[]{

                Common.getDescriptor(),
                ItemOuterClass.getDescriptor()}, assigner);
    }

    private static final Descriptors.Descriptor internal_static_pomelo_area_MailGetAllRequest_descriptor = getDescriptor().getMessageTypes().get(0);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_MailGetAllRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_MailGetAllRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_area_MailReadNotify_descriptor = getDescriptor().getMessageTypes().get(1);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_MailReadNotify_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_MailReadNotify_descriptor, new String[]{"C2SId"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_MailSendMailRequest_descriptor = getDescriptor().getMessageTypes().get(2);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_MailSendMailRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_MailSendMailRequest_descriptor, new String[]{"ToPlayerId", "MailTitle", "MailText", "MailRead", "ToPlayerName"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_MailGetAttachmentRequest_descriptor = getDescriptor().getMessageTypes().get(3);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_MailGetAttachmentRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_MailGetAttachmentRequest_descriptor, new String[]{"C2SId"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_MailGetAttachmentOneKeyRequest_descriptor = getDescriptor().getMessageTypes().get(4);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_MailGetAttachmentOneKeyRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_MailGetAttachmentOneKeyRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_area_MailDeleteRequest_descriptor = getDescriptor().getMessageTypes().get(5);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_MailDeleteRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_MailDeleteRequest_descriptor, new String[]{"C2SId"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_MailDeleteOneKeyRequest_descriptor = getDescriptor().getMessageTypes().get(6);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_MailDeleteOneKeyRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_MailDeleteOneKeyRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_area_MailSendTestNotify_descriptor = getDescriptor().getMessageTypes().get(7);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_MailSendTestNotify_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_MailSendTestNotify_descriptor, new String[]{"C2SMailId", "C2STcCode"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_Mail_descriptor = getDescriptor().getMessageTypes().get(8);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_Mail_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_Mail_descriptor, new String[]{"Id", "MailId", "MailType", "MailIcon", "MailSender", "MailTitle", "MailText", "CreateTime", "Status", "MailRead", "HadAttach", "Attachment", "MailSenderId", "ItemEar", "NewAttachment"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_MailGetAllResponse_descriptor = getDescriptor().getMessageTypes().get(9);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_MailGetAllResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_MailGetAllResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "Mails", "S2CMaxMailNum", "S2CMaxWordNum"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_OnGetMailPush_descriptor = getDescriptor().getMessageTypes().get(10);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_OnGetMailPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_OnGetMailPush_descriptor, new String[]{"S2CCode", "Mails"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_MailSendMailResponse_descriptor = getDescriptor().getMessageTypes().get(11);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_MailSendMailResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_MailSendMailResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_MailDeleteResponse_descriptor = getDescriptor().getMessageTypes().get(12);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_MailDeleteResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_MailDeleteResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_MailDeleteOneKeyResponse_descriptor = getDescriptor().getMessageTypes().get(13);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_MailDeleteOneKeyResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_MailDeleteOneKeyResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CIds"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_MailGetAttachmentResponse_descriptor = getDescriptor().getMessageTypes().get(14);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_MailGetAttachmentResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_MailGetAttachmentResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_MailGetAttachmentOneKeyResponse_descriptor = getDescriptor().getMessageTypes().get(15);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_MailGetAttachmentOneKeyResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_MailGetAttachmentOneKeyResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CIds"});
    private static Descriptors.FileDescriptor descriptor;

    static {
        Common.getDescriptor();
        ItemOuterClass.getDescriptor();
    }

    public static interface MailGetAttachmentOneKeyResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        ProtocolStringList getS2CIdsList();

        int getS2CIdsCount();

        String getS2CIds(int param1Int);

        ByteString getS2CIdsBytes(int param1Int);
    }

    public static interface MailGetAttachmentResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface MailDeleteOneKeyResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        ProtocolStringList getS2CIdsList();

        int getS2CIdsCount();

        String getS2CIds(int param1Int);

        ByteString getS2CIdsBytes(int param1Int);
    }

    public static interface MailDeleteResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface MailSendMailResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface OnGetMailPushOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        List<MailHandler.Mail> getMailsList();

        MailHandler.Mail getMails(int param1Int);

        int getMailsCount();

        List<? extends MailHandler.MailOrBuilder> getMailsOrBuilderList();

        MailHandler.MailOrBuilder getMailsOrBuilder(int param1Int);
    }

    public static interface MailGetAllResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        List<MailHandler.Mail> getMailsList();

        MailHandler.Mail getMails(int param1Int);

        int getMailsCount();

        List<? extends MailHandler.MailOrBuilder> getMailsOrBuilderList();

        MailHandler.MailOrBuilder getMailsOrBuilder(int param1Int);

        boolean hasS2CMaxMailNum();

        int getS2CMaxMailNum();

        boolean hasS2CMaxWordNum();

        int getS2CMaxWordNum();
    }

    public static interface MailOrBuilder extends MessageOrBuilder {
        boolean hasId();

        String getId();

        ByteString getIdBytes();

        boolean hasMailId();

        int getMailId();

        boolean hasMailType();

        int getMailType();

        boolean hasMailIcon();

        int getMailIcon();

        boolean hasMailSender();

        String getMailSender();

        ByteString getMailSenderBytes();

        boolean hasMailTitle();

        String getMailTitle();

        ByteString getMailTitleBytes();

        boolean hasMailText();

        String getMailText();

        ByteString getMailTextBytes();

        boolean hasCreateTime();

        String getCreateTime();

        ByteString getCreateTimeBytes();

        boolean hasStatus();

        int getStatus();

        boolean hasMailRead();

        int getMailRead();

        boolean hasHadAttach();

        int getHadAttach();

        List<ItemOuterClass.MiniItem> getAttachmentList();

        ItemOuterClass.MiniItem getAttachment(int param1Int);

        int getAttachmentCount();

        List<? extends ItemOuterClass.MiniItemOrBuilder> getAttachmentOrBuilderList();

        ItemOuterClass.MiniItemOrBuilder getAttachmentOrBuilder(int param1Int);

        boolean hasMailSenderId();

        String getMailSenderId();

        ByteString getMailSenderIdBytes();

        List<ItemOuterClass.EarItemDetail> getItemEarList();

        ItemOuterClass.EarItemDetail getItemEar(int param1Int);

        int getItemEarCount();

        List<? extends ItemOuterClass.EarItemDetailOrBuilder> getItemEarOrBuilderList();

        ItemOuterClass.EarItemDetailOrBuilder getItemEarOrBuilder(int param1Int);

        List<ItemOuterClass.ItemDetail> getNewAttachmentList();

        ItemOuterClass.ItemDetail getNewAttachment(int param1Int);

        int getNewAttachmentCount();

        List<? extends ItemOuterClass.ItemDetailOrBuilder> getNewAttachmentOrBuilderList();

        ItemOuterClass.ItemDetailOrBuilder getNewAttachmentOrBuilder(int param1Int);
    }

    public static interface MailSendTestNotifyOrBuilder extends MessageOrBuilder {
        boolean hasC2SMailId();

        int getC2SMailId();

        boolean hasC2STcCode();

        String getC2STcCode();

        ByteString getC2STcCodeBytes();
    }

    public static interface MailDeleteOneKeyRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface MailDeleteRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2SId();

        String getC2SId();

        ByteString getC2SIdBytes();
    }

    public static interface MailGetAttachmentOneKeyRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface MailGetAttachmentRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2SId();

        String getC2SId();

        ByteString getC2SIdBytes();
    }

    public static interface MailSendMailRequestOrBuilder extends MessageOrBuilder {
        boolean hasToPlayerId();

        String getToPlayerId();

        ByteString getToPlayerIdBytes();

        boolean hasMailTitle();

        String getMailTitle();

        ByteString getMailTitleBytes();

        boolean hasMailText();

        String getMailText();

        ByteString getMailTextBytes();

        boolean hasMailRead();

        int getMailRead();

        boolean hasToPlayerName();

        String getToPlayerName();

        ByteString getToPlayerNameBytes();
    }

    public static interface MailReadNotifyOrBuilder extends MessageOrBuilder {
        ProtocolStringList getC2SIdList();

        int getC2SIdCount();

        String getC2SId(int param1Int);

        ByteString getC2SIdBytes(int param1Int);
    }

    public static interface MailGetAllRequestOrBuilder extends MessageOrBuilder {
    }
}


