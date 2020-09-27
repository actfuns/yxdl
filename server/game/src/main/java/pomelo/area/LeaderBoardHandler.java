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
import com.google.protobuf.SingleFieldBuilder;
import com.google.protobuf.UnknownFieldSet;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import pomelo.Common;


public final class LeaderBoardHandler {
    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static final class LeaderBoardData
            extends GeneratedMessage
            implements LeaderBoardDataOrBuilder {
        private final UnknownFieldSet unknownFields;

        private LeaderBoardData(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private LeaderBoardData(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static LeaderBoardData getDefaultInstance() {
            return defaultInstance;
        }

        public LeaderBoardData getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private LeaderBoardData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.contents_ = (LazyStringList) new LazyStringArrayList();
                                mutable_bitField0_ |= 0x1;
                            }
                            this.contents_.add(bs);
                            break;
                        case 18:
                            if ((mutable_bitField0_ & 0x2) != 2) {
                                this.avatars_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x2;
                            }
                            this.avatars_.add(input.readMessage(Common.Avatar.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x1) == 1)
                    this.contents_ = this.contents_.getUnmodifiableView();
                if ((mutable_bitField0_ & 0x2) == 2)
                    this.avatars_ = Collections.unmodifiableList(this.avatars_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LeaderBoardHandler.internal_static_pomelo_area_LeaderBoardData_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return LeaderBoardHandler.internal_static_pomelo_area_LeaderBoardData_fieldAccessorTable.ensureFieldAccessorsInitialized(LeaderBoardData.class, Builder.class);
        }

        public static Parser<LeaderBoardData> PARSER = (Parser<LeaderBoardData>) new AbstractParser<LeaderBoardData>() {
            public LeaderBoardHandler.LeaderBoardData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new LeaderBoardHandler.LeaderBoardData(input, extensionRegistry);
            }
        };

        public static final int CONTENTS_FIELD_NUMBER = 1;
        private LazyStringList contents_;
        public static final int AVATARS_FIELD_NUMBER = 2;
        private List<Common.Avatar> avatars_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<LeaderBoardData> getParserForType() {
            return PARSER;
        }

        public ProtocolStringList getContentsList() {
            return (ProtocolStringList) this.contents_;
        }

        public int getContentsCount() {
            return this.contents_.size();
        }

        public String getContents(int index) {
            return (String) this.contents_.get(index);
        }

        public ByteString getContentsBytes(int index) {
            return this.contents_.getByteString(index);
        }

        public List<Common.Avatar> getAvatarsList() {
            return this.avatars_;
        }

        public List<? extends Common.AvatarOrBuilder> getAvatarsOrBuilderList() {
            return (List) this.avatars_;
        }

        public int getAvatarsCount() {
            return this.avatars_.size();
        }

        public Common.Avatar getAvatars(int index) {
            return this.avatars_.get(index);
        }

        public Common.AvatarOrBuilder getAvatarsOrBuilder(int index) {
            return (Common.AvatarOrBuilder) this.avatars_.get(index);
        }

        private void initFields() {
            this.contents_ = LazyStringArrayList.EMPTY;
            this.avatars_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1)
                return true;
            if (isInitialized == 0)
                return false;
            for (int i = 0; i < getAvatarsCount(); i++) {
                if (!getAvatars(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            int i;
            for (i = 0; i < this.contents_.size(); i++)
                output.writeBytes(1, this.contents_.getByteString(i));
            for (i = 0; i < this.avatars_.size(); i++)
                output.writeMessage(2, (MessageLite) this.avatars_.get(i));
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1)
                return size;
            size = 0;
            int dataSize = 0;
            for (int j = 0; j < this.contents_.size(); j++)
                dataSize += CodedOutputStream.computeBytesSizeNoTag(this.contents_.getByteString(j));
            size += dataSize;
            size += 1 * getContentsList().size();
            for (int i = 0; i < this.avatars_.size(); i++)
                size += CodedOutputStream.computeMessageSize(2, (MessageLite) this.avatars_.get(i));
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static LeaderBoardData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (LeaderBoardData) PARSER.parseFrom(data);
        }

        public static LeaderBoardData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (LeaderBoardData) PARSER.parseFrom(data, extensionRegistry);
        }

        public static LeaderBoardData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (LeaderBoardData) PARSER.parseFrom(data);
        }

        public static LeaderBoardData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (LeaderBoardData) PARSER.parseFrom(data, extensionRegistry);
        }

        public static LeaderBoardData parseFrom(InputStream input) throws IOException {
            return (LeaderBoardData) PARSER.parseFrom(input);
        }

        public static LeaderBoardData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LeaderBoardData) PARSER.parseFrom(input, extensionRegistry);
        }

        public static LeaderBoardData parseDelimitedFrom(InputStream input) throws IOException {
            return (LeaderBoardData) PARSER.parseDelimitedFrom(input);
        }

        public static LeaderBoardData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LeaderBoardData) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static LeaderBoardData parseFrom(CodedInputStream input) throws IOException {
            return (LeaderBoardData) PARSER.parseFrom(input);
        }

        public static LeaderBoardData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LeaderBoardData) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(LeaderBoardData prototype) {
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
                implements LeaderBoardHandler.LeaderBoardDataOrBuilder {
            private int bitField0_;
            private LazyStringList contents_;
            private List<Common.Avatar> avatars_;
            private RepeatedFieldBuilder<Common.Avatar, Common.Avatar.Builder, Common.AvatarOrBuilder> avatarsBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return LeaderBoardHandler.internal_static_pomelo_area_LeaderBoardData_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return LeaderBoardHandler.internal_static_pomelo_area_LeaderBoardData_fieldAccessorTable.ensureFieldAccessorsInitialized(LeaderBoardHandler.LeaderBoardData.class, Builder.class);
            }

            private Builder() {
                this.contents_ = LazyStringArrayList.EMPTY;
                this.avatars_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.contents_ = LazyStringArrayList.EMPTY;
                this.avatars_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (LeaderBoardHandler.LeaderBoardData.alwaysUseFieldBuilders)
                    getAvatarsFieldBuilder();
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.contents_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= 0xFFFFFFFE;
                if (this.avatarsBuilder_ == null) {
                    this.avatars_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFD;
                } else {
                    this.avatarsBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return LeaderBoardHandler.internal_static_pomelo_area_LeaderBoardData_descriptor;
            }

            public LeaderBoardHandler.LeaderBoardData getDefaultInstanceForType() {
                return LeaderBoardHandler.LeaderBoardData.getDefaultInstance();
            }

            public LeaderBoardHandler.LeaderBoardData build() {
                LeaderBoardHandler.LeaderBoardData result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public LeaderBoardHandler.LeaderBoardData buildPartial() {
                LeaderBoardHandler.LeaderBoardData result = new LeaderBoardHandler.LeaderBoardData(this);
                int from_bitField0_ = this.bitField0_;
                if ((this.bitField0_ & 0x1) == 1) {
                    this.contents_ = this.contents_.getUnmodifiableView();
                    this.bitField0_ &= 0xFFFFFFFE;
                }
                result.contents_ = this.contents_;
                if (this.avatarsBuilder_ == null) {
                    if ((this.bitField0_ & 0x2) == 2) {
                        this.avatars_ = Collections.unmodifiableList(this.avatars_);
                        this.bitField0_ &= 0xFFFFFFFD;
                    }
                    result.avatars_ = this.avatars_;
                } else {
                    result.avatars_ = this.avatarsBuilder_.build();
                }
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof LeaderBoardHandler.LeaderBoardData)
                    return mergeFrom((LeaderBoardHandler.LeaderBoardData) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(LeaderBoardHandler.LeaderBoardData other) {
                if (other == LeaderBoardHandler.LeaderBoardData.getDefaultInstance())
                    return this;
                if (!other.contents_.isEmpty()) {
                    if (this.contents_.isEmpty()) {
                        this.contents_ = other.contents_;
                        this.bitField0_ &= 0xFFFFFFFE;
                    } else {
                        ensureContentsIsMutable();
                        this.contents_.addAll((Collection) other.contents_);
                    }
                    onChanged();
                }
                if (this.avatarsBuilder_ == null) {
                    if (!other.avatars_.isEmpty()) {
                        if (this.avatars_.isEmpty()) {
                            this.avatars_ = other.avatars_;
                            this.bitField0_ &= 0xFFFFFFFD;
                        } else {
                            ensureAvatarsIsMutable();
                            this.avatars_.addAll(other.avatars_);
                        }
                        onChanged();
                    }
                } else if (!other.avatars_.isEmpty()) {
                    if (this.avatarsBuilder_.isEmpty()) {
                        this.avatarsBuilder_.dispose();
                        this.avatarsBuilder_ = null;
                        this.avatars_ = other.avatars_;
                        this.bitField0_ &= 0xFFFFFFFD;
                        this.avatarsBuilder_ = LeaderBoardHandler.LeaderBoardData.alwaysUseFieldBuilders ? getAvatarsFieldBuilder() : null;
                    } else {
                        this.avatarsBuilder_.addAllMessages(other.avatars_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                for (int i = 0; i < getAvatarsCount(); i++) {
                    if (!getAvatars(i).isInitialized())
                        return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                LeaderBoardHandler.LeaderBoardData parsedMessage = null;
                try {
                    parsedMessage = (LeaderBoardHandler.LeaderBoardData) LeaderBoardHandler.LeaderBoardData.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (LeaderBoardHandler.LeaderBoardData) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null)
                        mergeFrom(parsedMessage);
                }
                return this;
            }

            private void ensureContentsIsMutable() {
                if ((this.bitField0_ & 0x1) != 1) {
                    this.contents_ = (LazyStringList) new LazyStringArrayList(this.contents_);
                    this.bitField0_ |= 0x1;
                }
            }

            public ProtocolStringList getContentsList() {
                return (ProtocolStringList) this.contents_.getUnmodifiableView();
            }

            public int getContentsCount() {
                return this.contents_.size();
            }

            public String getContents(int index) {
                return (String) this.contents_.get(index);
            }

            public ByteString getContentsBytes(int index) {
                return this.contents_.getByteString(index);
            }

            public Builder setContents(int index, String value) {
                if (value == null)
                    throw new NullPointerException();
                ensureContentsIsMutable();
                this.contents_.set(index, value);
                onChanged();
                return this;
            }

            public Builder addContents(String value) {
                if (value == null)
                    throw new NullPointerException();
                ensureContentsIsMutable();
                this.contents_.add(value);
                onChanged();
                return this;
            }

            public Builder addAllContents(Iterable<String> values) {
                ensureContentsIsMutable();
                AbstractMessageLite.Builder.addAll(values, (Collection) this.contents_);
                onChanged();
                return this;
            }

            public Builder clearContents() {
                this.contents_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= 0xFFFFFFFE;
                onChanged();
                return this;
            }

            public Builder addContentsBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                ensureContentsIsMutable();
                this.contents_.add(value);
                onChanged();
                return this;
            }

            private void ensureAvatarsIsMutable() {
                if ((this.bitField0_ & 0x2) != 2) {
                    this.avatars_ = new ArrayList<>(this.avatars_);
                    this.bitField0_ |= 0x2;
                }
            }

            public List<Common.Avatar> getAvatarsList() {
                if (this.avatarsBuilder_ == null)
                    return Collections.unmodifiableList(this.avatars_);
                return this.avatarsBuilder_.getMessageList();
            }

            public int getAvatarsCount() {
                if (this.avatarsBuilder_ == null)
                    return this.avatars_.size();
                return this.avatarsBuilder_.getCount();
            }

            public Common.Avatar getAvatars(int index) {
                if (this.avatarsBuilder_ == null)
                    return this.avatars_.get(index);
                return (Common.Avatar) this.avatarsBuilder_.getMessage(index);
            }

            public Builder setAvatars(int index, Common.Avatar value) {
                if (this.avatarsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureAvatarsIsMutable();
                    this.avatars_.set(index, value);
                    onChanged();
                } else {
                    this.avatarsBuilder_.setMessage(index, (GeneratedMessage) value);
                }
                return this;
            }

            public Builder setAvatars(int index, Common.Avatar.Builder builderForValue) {
                if (this.avatarsBuilder_ == null) {
                    ensureAvatarsIsMutable();
                    this.avatars_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.avatarsBuilder_.setMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addAvatars(Common.Avatar value) {
                if (this.avatarsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureAvatarsIsMutable();
                    this.avatars_.add(value);
                    onChanged();
                } else {
                    this.avatarsBuilder_.addMessage((GeneratedMessage) value);
                }
                return this;
            }

            public Builder addAvatars(int index, Common.Avatar value) {
                if (this.avatarsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureAvatarsIsMutable();
                    this.avatars_.add(index, value);
                    onChanged();
                } else {
                    this.avatarsBuilder_.addMessage(index, (GeneratedMessage) value);
                }
                return this;
            }

            public Builder addAvatars(Common.Avatar.Builder builderForValue) {
                if (this.avatarsBuilder_ == null) {
                    ensureAvatarsIsMutable();
                    this.avatars_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.avatarsBuilder_.addMessage((GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addAvatars(int index, Common.Avatar.Builder builderForValue) {
                if (this.avatarsBuilder_ == null) {
                    ensureAvatarsIsMutable();
                    this.avatars_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.avatarsBuilder_.addMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addAllAvatars(Iterable<? extends Common.Avatar> values) {
                if (this.avatarsBuilder_ == null) {
                    ensureAvatarsIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.avatars_);
                    onChanged();
                } else {
                    this.avatarsBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearAvatars() {
                if (this.avatarsBuilder_ == null) {
                    this.avatars_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFD;
                    onChanged();
                } else {
                    this.avatarsBuilder_.clear();
                }
                return this;
            }

            public Builder removeAvatars(int index) {
                if (this.avatarsBuilder_ == null) {
                    ensureAvatarsIsMutable();
                    this.avatars_.remove(index);
                    onChanged();
                } else {
                    this.avatarsBuilder_.remove(index);
                }
                return this;
            }

            public Common.Avatar.Builder getAvatarsBuilder(int index) {
                return (Common.Avatar.Builder) getAvatarsFieldBuilder().getBuilder(index);
            }

            public Common.AvatarOrBuilder getAvatarsOrBuilder(int index) {
                if (this.avatarsBuilder_ == null)
                    return (Common.AvatarOrBuilder) this.avatars_.get(index);
                return (Common.AvatarOrBuilder) this.avatarsBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends Common.AvatarOrBuilder> getAvatarsOrBuilderList() {
                if (this.avatarsBuilder_ != null)
                    return this.avatarsBuilder_.getMessageOrBuilderList();
                return (List) Collections.unmodifiableList(this.avatars_);
            }

            public Common.Avatar.Builder addAvatarsBuilder() {
                return (Common.Avatar.Builder) getAvatarsFieldBuilder().addBuilder((GeneratedMessage) Common.Avatar.getDefaultInstance());
            }

            public Common.Avatar.Builder addAvatarsBuilder(int index) {
                return (Common.Avatar.Builder) getAvatarsFieldBuilder().addBuilder(index, (GeneratedMessage) Common.Avatar.getDefaultInstance());
            }

            public List<Common.Avatar.Builder> getAvatarsBuilderList() {
                return getAvatarsFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<Common.Avatar, Common.Avatar.Builder, Common.AvatarOrBuilder> getAvatarsFieldBuilder() {
                if (this.avatarsBuilder_ == null) {
                    this.avatarsBuilder_ = new RepeatedFieldBuilder(this.avatars_, ((this.bitField0_ & 0x2) == 2), getParentForChildren(), isClean());
                    this.avatars_ = null;
                }
                return this.avatarsBuilder_;
            }
        }

        private static final LeaderBoardData defaultInstance = new LeaderBoardData(true);

        static {
            defaultInstance.initFields();
        }
    }


    public static final class RankGuildInfo
            extends GeneratedMessage
            implements RankGuildInfoOrBuilder {
        private static final RankGuildInfo defaultInstance = new RankGuildInfo(true);
        private final UnknownFieldSet unknownFields;

        private RankGuildInfo(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private RankGuildInfo(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static RankGuildInfo getDefaultInstance() {
            return defaultInstance;
        }

        public RankGuildInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private RankGuildInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.guildId_ = bs;
                            break;
                        case 18:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x2;
                            this.guildIcon_ = bs;
                            break;
                        case 26:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x4;
                            this.guildMaster_ = bs;
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.guildLevel_ = input.readInt32();
                            break;
                        case 40:
                            this.bitField0_ |= 0x10;
                            this.curMember_ = input.readInt32();
                            break;
                        case 48:
                            this.bitField0_ |= 0x20;
                            this.maxMember_ = input.readInt32();
                            break;
                        case 56:
                            this.bitField0_ |= 0x40;
                            this.fund_ = input.readInt32();
                            break;
                        case 66:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x80;
                            this.notice_ = bs;
                            break;
                        case 72:
                            this.bitField0_ |= 0x100;
                            this.guildMasterPro_ = input.readInt32();
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
            return LeaderBoardHandler.internal_static_pomelo_area_RankGuildInfo_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return LeaderBoardHandler.internal_static_pomelo_area_RankGuildInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(RankGuildInfo.class, Builder.class);
        }

        public static Parser<RankGuildInfo> PARSER = (Parser<RankGuildInfo>) new AbstractParser<RankGuildInfo>() {
            public LeaderBoardHandler.RankGuildInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new LeaderBoardHandler.RankGuildInfo(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int GUILDID_FIELD_NUMBER = 1;
        private Object guildId_;
        public static final int GUILDICON_FIELD_NUMBER = 2;
        private Object guildIcon_;
        public static final int GUILDMASTER_FIELD_NUMBER = 3;
        private Object guildMaster_;
        public static final int GUILDLEVEL_FIELD_NUMBER = 4;
        private int guildLevel_;
        public static final int CURMEMBER_FIELD_NUMBER = 5;
        private int curMember_;
        public static final int MAXMEMBER_FIELD_NUMBER = 6;
        private int maxMember_;
        public static final int FUND_FIELD_NUMBER = 7;
        private int fund_;
        public static final int NOTICE_FIELD_NUMBER = 8;
        private Object notice_;
        public static final int GUILDMASTERPRO_FIELD_NUMBER = 9;
        private int guildMasterPro_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<RankGuildInfo> getParserForType() {
            return PARSER;
        }

        public boolean hasGuildId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public String getGuildId() {
            Object ref = this.guildId_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.guildId_ = s;
            return s;
        }

        public ByteString getGuildIdBytes() {
            Object ref = this.guildId_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.guildId_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasGuildIcon() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public String getGuildIcon() {
            Object ref = this.guildIcon_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.guildIcon_ = s;
            return s;
        }

        static {
            defaultInstance.initFields();
        }

        public ByteString getGuildIconBytes() {
            Object ref = this.guildIcon_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.guildIcon_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasGuildMaster() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public String getGuildMaster() {
            Object ref = this.guildMaster_;
            if (ref instanceof String)
                return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8())
                this.guildMaster_ = s;
            return s;
        }

        public ByteString getGuildMasterBytes() {
            Object ref = this.guildMaster_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.guildMaster_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasGuildLevel() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public int getGuildLevel() {
            return this.guildLevel_;
        }

        public boolean hasCurMember() {
            return ((this.bitField0_ & 0x10) == 16);
        }

        public int getCurMember() {
            return this.curMember_;
        }

        public boolean hasMaxMember() {
            return ((this.bitField0_ & 0x20) == 32);
        }

        public int getMaxMember() {
            return this.maxMember_;
        }

        public boolean hasFund() {
            return ((this.bitField0_ & 0x40) == 64);
        }

        public int getFund() {
            return this.fund_;
        }

        public boolean hasNotice() {
            return ((this.bitField0_ & 0x80) == 128);
        }

        public String getNotice() {
            Object ref = this.notice_;
            if (ref instanceof String)
                return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8())
                this.notice_ = s;
            return s;
        }

        public ByteString getNoticeBytes() {
            Object ref = this.notice_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.notice_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasGuildMasterPro() {
            return ((this.bitField0_ & 0x100) == 256);
        }

        public int getGuildMasterPro() {
            return this.guildMasterPro_;
        }

        private void initFields() {
            this.guildId_ = "";
            this.guildIcon_ = "";
            this.guildMaster_ = "";
            this.guildLevel_ = 0;
            this.curMember_ = 0;
            this.maxMember_ = 0;
            this.fund_ = 0;
            this.notice_ = "";
            this.guildMasterPro_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1)
                return true;
            if (isInitialized == 0)
                return false;
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1)
                output.writeBytes(1, getGuildIdBytes());
            if ((this.bitField0_ & 0x2) == 2)
                output.writeBytes(2, getGuildIconBytes());
            if ((this.bitField0_ & 0x4) == 4)
                output.writeBytes(3, getGuildMasterBytes());
            if ((this.bitField0_ & 0x8) == 8)
                output.writeInt32(4, this.guildLevel_);
            if ((this.bitField0_ & 0x10) == 16)
                output.writeInt32(5, this.curMember_);
            if ((this.bitField0_ & 0x20) == 32)
                output.writeInt32(6, this.maxMember_);
            if ((this.bitField0_ & 0x40) == 64)
                output.writeInt32(7, this.fund_);
            if ((this.bitField0_ & 0x80) == 128)
                output.writeBytes(8, getNoticeBytes());
            if ((this.bitField0_ & 0x100) == 256)
                output.writeInt32(9, this.guildMasterPro_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1)
                return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1)
                size += CodedOutputStream.computeBytesSize(1, getGuildIdBytes());
            if ((this.bitField0_ & 0x2) == 2)
                size += CodedOutputStream.computeBytesSize(2, getGuildIconBytes());
            if ((this.bitField0_ & 0x4) == 4)
                size += CodedOutputStream.computeBytesSize(3, getGuildMasterBytes());
            if ((this.bitField0_ & 0x8) == 8)
                size += CodedOutputStream.computeInt32Size(4, this.guildLevel_);
            if ((this.bitField0_ & 0x10) == 16)
                size += CodedOutputStream.computeInt32Size(5, this.curMember_);
            if ((this.bitField0_ & 0x20) == 32)
                size += CodedOutputStream.computeInt32Size(6, this.maxMember_);
            if ((this.bitField0_ & 0x40) == 64)
                size += CodedOutputStream.computeInt32Size(7, this.fund_);
            if ((this.bitField0_ & 0x80) == 128)
                size += CodedOutputStream.computeBytesSize(8, getNoticeBytes());
            if ((this.bitField0_ & 0x100) == 256)
                size += CodedOutputStream.computeInt32Size(9, this.guildMasterPro_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static RankGuildInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (RankGuildInfo) PARSER.parseFrom(data);
        }

        public static RankGuildInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (RankGuildInfo) PARSER.parseFrom(data, extensionRegistry);
        }

        public static RankGuildInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (RankGuildInfo) PARSER.parseFrom(data);
        }

        public static RankGuildInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (RankGuildInfo) PARSER.parseFrom(data, extensionRegistry);
        }

        public static RankGuildInfo parseFrom(InputStream input) throws IOException {
            return (RankGuildInfo) PARSER.parseFrom(input);
        }

        public static RankGuildInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RankGuildInfo) PARSER.parseFrom(input, extensionRegistry);
        }

        public static RankGuildInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (RankGuildInfo) PARSER.parseDelimitedFrom(input);
        }

        public static RankGuildInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RankGuildInfo) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static RankGuildInfo parseFrom(CodedInputStream input) throws IOException {
            return (RankGuildInfo) PARSER.parseFrom(input);
        }

        public static RankGuildInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RankGuildInfo) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(RankGuildInfo prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements LeaderBoardHandler.RankGuildInfoOrBuilder {
            private int bitField0_;
            private Object guildId_;
            private Object guildIcon_;
            private Object guildMaster_;
            private int guildLevel_;
            private int curMember_;
            private int maxMember_;
            private int fund_;
            private Object notice_;
            private int guildMasterPro_;

            public static final Descriptors.Descriptor getDescriptor() {
                return LeaderBoardHandler.internal_static_pomelo_area_RankGuildInfo_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return LeaderBoardHandler.internal_static_pomelo_area_RankGuildInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(LeaderBoardHandler.RankGuildInfo.class, Builder.class);
            }

            private Builder() {
                this.guildId_ = "";
                this.guildIcon_ = "";
                this.guildMaster_ = "";
                this.notice_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.guildId_ = "";
                this.guildIcon_ = "";
                this.guildMaster_ = "";
                this.notice_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (LeaderBoardHandler.RankGuildInfo.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.guildId_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                this.guildIcon_ = "";
                this.bitField0_ &= 0xFFFFFFFD;
                this.guildMaster_ = "";
                this.bitField0_ &= 0xFFFFFFFB;
                this.guildLevel_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                this.curMember_ = 0;
                this.bitField0_ &= 0xFFFFFFEF;
                this.maxMember_ = 0;
                this.bitField0_ &= 0xFFFFFFDF;
                this.fund_ = 0;
                this.bitField0_ &= 0xFFFFFFBF;
                this.notice_ = "";
                this.bitField0_ &= 0xFFFFFF7F;
                this.guildMasterPro_ = 0;
                this.bitField0_ &= 0xFFFFFEFF;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return LeaderBoardHandler.internal_static_pomelo_area_RankGuildInfo_descriptor;
            }

            public LeaderBoardHandler.RankGuildInfo getDefaultInstanceForType() {
                return LeaderBoardHandler.RankGuildInfo.getDefaultInstance();
            }

            public LeaderBoardHandler.RankGuildInfo build() {
                LeaderBoardHandler.RankGuildInfo result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public LeaderBoardHandler.RankGuildInfo buildPartial() {
                LeaderBoardHandler.RankGuildInfo result = new LeaderBoardHandler.RankGuildInfo(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.guildId_ = this.guildId_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.guildIcon_ = this.guildIcon_;
                if ((from_bitField0_ & 0x4) == 4)
                    to_bitField0_ |= 0x4;
                result.guildMaster_ = this.guildMaster_;
                if ((from_bitField0_ & 0x8) == 8)
                    to_bitField0_ |= 0x8;
                result.guildLevel_ = this.guildLevel_;
                if ((from_bitField0_ & 0x10) == 16)
                    to_bitField0_ |= 0x10;
                result.curMember_ = this.curMember_;
                if ((from_bitField0_ & 0x20) == 32)
                    to_bitField0_ |= 0x20;
                result.maxMember_ = this.maxMember_;
                if ((from_bitField0_ & 0x40) == 64)
                    to_bitField0_ |= 0x40;
                result.fund_ = this.fund_;
                if ((from_bitField0_ & 0x80) == 128)
                    to_bitField0_ |= 0x80;
                result.notice_ = this.notice_;
                if ((from_bitField0_ & 0x100) == 256)
                    to_bitField0_ |= 0x100;
                result.guildMasterPro_ = this.guildMasterPro_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof LeaderBoardHandler.RankGuildInfo)
                    return mergeFrom((LeaderBoardHandler.RankGuildInfo) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(LeaderBoardHandler.RankGuildInfo other) {
                if (other == LeaderBoardHandler.RankGuildInfo.getDefaultInstance())
                    return this;
                if (other.hasGuildId()) {
                    this.bitField0_ |= 0x1;
                    this.guildId_ = other.guildId_;
                    onChanged();
                }
                if (other.hasGuildIcon()) {
                    this.bitField0_ |= 0x2;
                    this.guildIcon_ = other.guildIcon_;
                    onChanged();
                }
                if (other.hasGuildMaster()) {
                    this.bitField0_ |= 0x4;
                    this.guildMaster_ = other.guildMaster_;
                    onChanged();
                }
                if (other.hasGuildLevel())
                    setGuildLevel(other.getGuildLevel());
                if (other.hasCurMember())
                    setCurMember(other.getCurMember());
                if (other.hasMaxMember())
                    setMaxMember(other.getMaxMember());
                if (other.hasFund())
                    setFund(other.getFund());
                if (other.hasNotice()) {
                    this.bitField0_ |= 0x80;
                    this.notice_ = other.notice_;
                    onChanged();
                }
                if (other.hasGuildMasterPro())
                    setGuildMasterPro(other.getGuildMasterPro());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                LeaderBoardHandler.RankGuildInfo parsedMessage = null;
                try {
                    parsedMessage = (LeaderBoardHandler.RankGuildInfo) LeaderBoardHandler.RankGuildInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (LeaderBoardHandler.RankGuildInfo) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null)
                        mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasGuildId() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public String getGuildId() {
                Object ref = this.guildId_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.guildId_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getGuildIdBytes() {
                Object ref = this.guildId_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.guildId_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setGuildId(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.guildId_ = value;
                onChanged();
                return this;
            }

            public Builder clearGuildId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.guildId_ = LeaderBoardHandler.RankGuildInfo.getDefaultInstance().getGuildId();
                onChanged();
                return this;
            }

            public Builder setGuildIdBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.guildId_ = value;
                onChanged();
                return this;
            }

            public boolean hasGuildIcon() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public String getGuildIcon() {
                Object ref = this.guildIcon_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.guildIcon_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getGuildIconBytes() {
                Object ref = this.guildIcon_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.guildIcon_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setGuildIcon(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x2;
                this.guildIcon_ = value;
                onChanged();
                return this;
            }

            public Builder clearGuildIcon() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.guildIcon_ = LeaderBoardHandler.RankGuildInfo.getDefaultInstance().getGuildIcon();
                onChanged();
                return this;
            }

            public Builder setGuildIconBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x2;
                this.guildIcon_ = value;
                onChanged();
                return this;
            }

            public boolean hasGuildMaster() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public String getGuildMaster() {
                Object ref = this.guildMaster_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.guildMaster_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getGuildMasterBytes() {
                Object ref = this.guildMaster_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.guildMaster_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setGuildMaster(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x4;
                this.guildMaster_ = value;
                onChanged();
                return this;
            }

            public Builder clearGuildMaster() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.guildMaster_ = LeaderBoardHandler.RankGuildInfo.getDefaultInstance().getGuildMaster();
                onChanged();
                return this;
            }

            public Builder setGuildMasterBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x4;
                this.guildMaster_ = value;
                onChanged();
                return this;
            }

            public boolean hasGuildLevel() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public int getGuildLevel() {
                return this.guildLevel_;
            }

            public Builder setGuildLevel(int value) {
                this.bitField0_ |= 0x8;
                this.guildLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearGuildLevel() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.guildLevel_ = 0;
                onChanged();
                return this;
            }

            public boolean hasCurMember() {
                return ((this.bitField0_ & 0x10) == 16);
            }

            public int getCurMember() {
                return this.curMember_;
            }

            public Builder setCurMember(int value) {
                this.bitField0_ |= 0x10;
                this.curMember_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurMember() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.curMember_ = 0;
                onChanged();
                return this;
            }

            public boolean hasMaxMember() {
                return ((this.bitField0_ & 0x20) == 32);
            }

            public int getMaxMember() {
                return this.maxMember_;
            }

            public Builder setMaxMember(int value) {
                this.bitField0_ |= 0x20;
                this.maxMember_ = value;
                onChanged();
                return this;
            }

            public Builder clearMaxMember() {
                this.bitField0_ &= 0xFFFFFFDF;
                this.maxMember_ = 0;
                onChanged();
                return this;
            }

            public boolean hasFund() {
                return ((this.bitField0_ & 0x40) == 64);
            }

            public int getFund() {
                return this.fund_;
            }

            public Builder setFund(int value) {
                this.bitField0_ |= 0x40;
                this.fund_ = value;
                onChanged();
                return this;
            }

            public Builder clearFund() {
                this.bitField0_ &= 0xFFFFFFBF;
                this.fund_ = 0;
                onChanged();
                return this;
            }

            public boolean hasNotice() {
                return ((this.bitField0_ & 0x80) == 128);
            }

            public String getNotice() {
                Object ref = this.notice_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.notice_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getNoticeBytes() {
                Object ref = this.notice_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.notice_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setNotice(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x80;
                this.notice_ = value;
                onChanged();
                return this;
            }

            public Builder clearNotice() {
                this.bitField0_ &= 0xFFFFFF7F;
                this.notice_ = LeaderBoardHandler.RankGuildInfo.getDefaultInstance().getNotice();
                onChanged();
                return this;
            }

            public Builder setNoticeBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x80;
                this.notice_ = value;
                onChanged();
                return this;
            }

            public boolean hasGuildMasterPro() {
                return ((this.bitField0_ & 0x100) == 256);
            }

            public int getGuildMasterPro() {
                return this.guildMasterPro_;
            }

            public Builder setGuildMasterPro(int value) {
                this.bitField0_ |= 0x100;
                this.guildMasterPro_ = value;
                onChanged();
                return this;
            }

            public Builder clearGuildMasterPro() {
                this.bitField0_ &= 0xFFFFFEFF;
                this.guildMasterPro_ = 0;
                onChanged();
                return this;
            }
        }
    }

    public static final class LeaderBoardRequest extends GeneratedMessage implements LeaderBoardRequestOrBuilder {
        private static final LeaderBoardRequest defaultInstance = new LeaderBoardRequest(true);
        private final UnknownFieldSet unknownFields;

        private LeaderBoardRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private LeaderBoardRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static LeaderBoardRequest getDefaultInstance() {
            return defaultInstance;
        }

        public LeaderBoardRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private LeaderBoardRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.c2SKind_ = input.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.c2SSeason_ = input.readInt32();
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
            return LeaderBoardHandler.internal_static_pomelo_area_LeaderBoardRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return LeaderBoardHandler.internal_static_pomelo_area_LeaderBoardRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(LeaderBoardRequest.class, Builder.class);
        }

        public static Parser<LeaderBoardRequest> PARSER = (Parser<LeaderBoardRequest>) new AbstractParser<LeaderBoardRequest>() {
            public LeaderBoardHandler.LeaderBoardRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new LeaderBoardHandler.LeaderBoardRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_KIND_FIELD_NUMBER = 1;
        private int c2SKind_;
        public static final int C2S_SEASON_FIELD_NUMBER = 2;
        private int c2SSeason_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<LeaderBoardRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasC2SKind() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getC2SKind() {
            return this.c2SKind_;
        }

        public boolean hasC2SSeason() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        static {
            defaultInstance.initFields();
        }


        public int getC2SSeason() {
            return this.c2SSeason_;
        }


        private void initFields() {
            this.c2SKind_ = 0;
            this.c2SSeason_ = 0;
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasC2SKind()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeInt32(1, this.c2SKind_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeInt32(2, this.c2SSeason_);
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
                size += CodedOutputStream.computeInt32Size(1, this.c2SKind_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeInt32Size(2, this.c2SSeason_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static LeaderBoardRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (LeaderBoardRequest) PARSER.parseFrom(data);
        }


        public static LeaderBoardRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (LeaderBoardRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static LeaderBoardRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (LeaderBoardRequest) PARSER.parseFrom(data);
        }


        public static LeaderBoardRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (LeaderBoardRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static LeaderBoardRequest parseFrom(InputStream input) throws IOException {
            return (LeaderBoardRequest) PARSER.parseFrom(input);
        }


        public static LeaderBoardRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LeaderBoardRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static LeaderBoardRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (LeaderBoardRequest) PARSER.parseDelimitedFrom(input);
        }


        public static LeaderBoardRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LeaderBoardRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static LeaderBoardRequest parseFrom(CodedInputStream input) throws IOException {
            return (LeaderBoardRequest) PARSER.parseFrom(input);
        }


        public static LeaderBoardRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LeaderBoardRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(LeaderBoardRequest prototype) {
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
                implements LeaderBoardHandler.LeaderBoardRequestOrBuilder {
            private int bitField0_;


            private int c2SKind_;


            private int c2SSeason_;


            public static final Descriptors.Descriptor getDescriptor() {
                return LeaderBoardHandler.internal_static_pomelo_area_LeaderBoardRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return LeaderBoardHandler.internal_static_pomelo_area_LeaderBoardRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(LeaderBoardHandler.LeaderBoardRequest.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (LeaderBoardHandler.LeaderBoardRequest.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.c2SKind_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SSeason_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return LeaderBoardHandler.internal_static_pomelo_area_LeaderBoardRequest_descriptor;
            }


            public LeaderBoardHandler.LeaderBoardRequest getDefaultInstanceForType() {
                return LeaderBoardHandler.LeaderBoardRequest.getDefaultInstance();
            }


            public LeaderBoardHandler.LeaderBoardRequest build() {
                LeaderBoardHandler.LeaderBoardRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public LeaderBoardHandler.LeaderBoardRequest buildPartial() {
                LeaderBoardHandler.LeaderBoardRequest result = new LeaderBoardHandler.LeaderBoardRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.c2SKind_ = this.c2SKind_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.c2SSeason_ = this.c2SSeason_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof LeaderBoardHandler.LeaderBoardRequest) {
                    return mergeFrom((LeaderBoardHandler.LeaderBoardRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(LeaderBoardHandler.LeaderBoardRequest other) {
                if (other == LeaderBoardHandler.LeaderBoardRequest.getDefaultInstance()) {
                    return this;
                }
                if (other.hasC2SKind()) {
                    setC2SKind(other.getC2SKind());
                }
                if (other.hasC2SSeason()) {
                    setC2SSeason(other.getC2SSeason());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasC2SKind()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                LeaderBoardHandler.LeaderBoardRequest parsedMessage = null;
                try {
                    parsedMessage = (LeaderBoardHandler.LeaderBoardRequest) LeaderBoardHandler.LeaderBoardRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (LeaderBoardHandler.LeaderBoardRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasC2SKind() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public int getC2SKind() {
                return this.c2SKind_;
            }


            public Builder setC2SKind(int value) {
                this.bitField0_ |= 0x1;
                this.c2SKind_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SKind() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SKind_ = 0;
                onChanged();
                return this;
            }


            public boolean hasC2SSeason() {
                return ((this.bitField0_ & 0x2) == 2);
            }


            public int getC2SSeason() {
                return this.c2SSeason_;
            }


            public Builder setC2SSeason(int value) {
                this.bitField0_ |= 0x2;
                this.c2SSeason_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SSeason() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.c2SSeason_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class LeaderBoardResponse
            extends GeneratedMessage
            implements LeaderBoardResponseOrBuilder {
        private static final LeaderBoardResponse defaultInstance = new LeaderBoardResponse(true);
        private final UnknownFieldSet unknownFields;

        private LeaderBoardResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private LeaderBoardResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static LeaderBoardResponse getDefaultInstance() {
            return defaultInstance;
        }

        public LeaderBoardResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private LeaderBoardResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString bs;
                    LeaderBoardHandler.LeaderBoardData.Builder subBuilder;
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
                                this.s2CLists_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x4;
                            }
                            this.s2CLists_.add(input.readMessage(LeaderBoardHandler.LeaderBoardData.PARSER, extensionRegistry));
                            break;
                        case 34:
                            subBuilder = null;
                            if ((this.bitField0_ & 0x4) == 4) subBuilder = this.s2CMyData_.toBuilder();
                            this.s2CMyData_ = (LeaderBoardHandler.LeaderBoardData) input.readMessage(LeaderBoardHandler.LeaderBoardData.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.s2CMyData_);
                                this.s2CMyData_ = subBuilder.buildPartial();
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
                if ((mutable_bitField0_ & 0x4) == 4) this.s2CLists_ = Collections.unmodifiableList(this.s2CLists_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LeaderBoardHandler.internal_static_pomelo_area_LeaderBoardResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return LeaderBoardHandler.internal_static_pomelo_area_LeaderBoardResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(LeaderBoardResponse.class, Builder.class);
        }

        public static Parser<LeaderBoardResponse> PARSER = (Parser<LeaderBoardResponse>) new AbstractParser<LeaderBoardResponse>() {
            public LeaderBoardHandler.LeaderBoardResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new LeaderBoardHandler.LeaderBoardResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_LISTS_FIELD_NUMBER = 3;
        private List<LeaderBoardHandler.LeaderBoardData> s2CLists_;
        public static final int S2C_MYDATA_FIELD_NUMBER = 4;
        private LeaderBoardHandler.LeaderBoardData s2CMyData_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<LeaderBoardResponse> getParserForType() {
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

        public List<LeaderBoardHandler.LeaderBoardData> getS2CListsList() {
            return this.s2CLists_;
        }

        public List<? extends LeaderBoardHandler.LeaderBoardDataOrBuilder> getS2CListsOrBuilderList() {
            return (List) this.s2CLists_;
        }

        public int getS2CListsCount() {
            return this.s2CLists_.size();
        }

        public LeaderBoardHandler.LeaderBoardData getS2CLists(int index) {
            return this.s2CLists_.get(index);
        }

        public LeaderBoardHandler.LeaderBoardDataOrBuilder getS2CListsOrBuilder(int index) {
            return this.s2CLists_.get(index);
        }

        public boolean hasS2CMyData() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public LeaderBoardHandler.LeaderBoardData getS2CMyData() {
            return this.s2CMyData_;
        }

        public LeaderBoardHandler.LeaderBoardDataOrBuilder getS2CMyDataOrBuilder() {
            return this.s2CMyData_;
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CLists_ = Collections.emptyList();
            this.s2CMyData_ = LeaderBoardHandler.LeaderBoardData.getDefaultInstance();
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
            for (int i = 0; i < getS2CListsCount(); i++) {
                if (!getS2CLists(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            if (hasS2CMyData() && !getS2CMyData().isInitialized()) {
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
            for (int i = 0; i < this.s2CLists_.size(); i++)
                output.writeMessage(3, (MessageLite) this.s2CLists_.get(i));
            if ((this.bitField0_ & 0x4) == 4)
                output.writeMessage(4, (MessageLite) this.s2CMyData_);
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
            for (int i = 0; i < this.s2CLists_.size(); i++)
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.s2CLists_.get(i));
            if ((this.bitField0_ & 0x4) == 4)
                size += CodedOutputStream.computeMessageSize(4, (MessageLite) this.s2CMyData_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static LeaderBoardResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (LeaderBoardResponse) PARSER.parseFrom(data);
        }

        public static LeaderBoardResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (LeaderBoardResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static LeaderBoardResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (LeaderBoardResponse) PARSER.parseFrom(data);
        }

        public static LeaderBoardResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (LeaderBoardResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static LeaderBoardResponse parseFrom(InputStream input) throws IOException {
            return (LeaderBoardResponse) PARSER.parseFrom(input);
        }

        public static LeaderBoardResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LeaderBoardResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static LeaderBoardResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (LeaderBoardResponse) PARSER.parseDelimitedFrom(input);
        }

        public static LeaderBoardResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LeaderBoardResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static LeaderBoardResponse parseFrom(CodedInputStream input) throws IOException {
            return (LeaderBoardResponse) PARSER.parseFrom(input);
        }

        public static LeaderBoardResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LeaderBoardResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(LeaderBoardResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements LeaderBoardHandler.LeaderBoardResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private List<LeaderBoardHandler.LeaderBoardData> s2CLists_;
            private RepeatedFieldBuilder<LeaderBoardHandler.LeaderBoardData, LeaderBoardHandler.LeaderBoardData.Builder, LeaderBoardHandler.LeaderBoardDataOrBuilder> s2CListsBuilder_;
            private LeaderBoardHandler.LeaderBoardData s2CMyData_;
            private SingleFieldBuilder<LeaderBoardHandler.LeaderBoardData, LeaderBoardHandler.LeaderBoardData.Builder, LeaderBoardHandler.LeaderBoardDataOrBuilder> s2CMyDataBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return LeaderBoardHandler.internal_static_pomelo_area_LeaderBoardResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return LeaderBoardHandler.internal_static_pomelo_area_LeaderBoardResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(LeaderBoardHandler.LeaderBoardResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.s2CLists_ = Collections.emptyList();
                this.s2CMyData_ = LeaderBoardHandler.LeaderBoardData.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CLists_ = Collections.emptyList();
                this.s2CMyData_ = LeaderBoardHandler.LeaderBoardData.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (LeaderBoardHandler.LeaderBoardResponse.alwaysUseFieldBuilders) {
                    getS2CListsFieldBuilder();
                    getS2CMyDataFieldBuilder();
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
                if (this.s2CListsBuilder_ == null) {
                    this.s2CLists_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                } else {
                    this.s2CListsBuilder_.clear();
                }
                if (this.s2CMyDataBuilder_ == null) {
                    this.s2CMyData_ = LeaderBoardHandler.LeaderBoardData.getDefaultInstance();
                } else {
                    this.s2CMyDataBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return LeaderBoardHandler.internal_static_pomelo_area_LeaderBoardResponse_descriptor;
            }

            public LeaderBoardHandler.LeaderBoardResponse getDefaultInstanceForType() {
                return LeaderBoardHandler.LeaderBoardResponse.getDefaultInstance();
            }

            public LeaderBoardHandler.LeaderBoardResponse build() {
                LeaderBoardHandler.LeaderBoardResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public LeaderBoardHandler.LeaderBoardResponse buildPartial() {
                LeaderBoardHandler.LeaderBoardResponse result = new LeaderBoardHandler.LeaderBoardResponse(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.s2CMsg_ = this.s2CMsg_;
                if (this.s2CListsBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4) {
                        this.s2CLists_ = Collections.unmodifiableList(this.s2CLists_);
                        this.bitField0_ &= 0xFFFFFFFB;
                    }
                    result.s2CLists_ = this.s2CLists_;
                } else {
                    result.s2CLists_ = this.s2CListsBuilder_.build();
                }
                if ((from_bitField0_ & 0x8) == 8)
                    to_bitField0_ |= 0x4;
                if (this.s2CMyDataBuilder_ == null) {
                    result.s2CMyData_ = this.s2CMyData_;
                } else {
                    result.s2CMyData_ = (LeaderBoardHandler.LeaderBoardData) this.s2CMyDataBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof LeaderBoardHandler.LeaderBoardResponse)
                    return mergeFrom((LeaderBoardHandler.LeaderBoardResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(LeaderBoardHandler.LeaderBoardResponse other) {
                if (other == LeaderBoardHandler.LeaderBoardResponse.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (this.s2CListsBuilder_ == null) {
                    if (!other.s2CLists_.isEmpty()) {
                        if (this.s2CLists_.isEmpty()) {
                            this.s2CLists_ = other.s2CLists_;
                            this.bitField0_ &= 0xFFFFFFFB;
                        } else {
                            ensureS2CListsIsMutable();
                            this.s2CLists_.addAll(other.s2CLists_);
                        }
                        onChanged();
                    }
                } else if (!other.s2CLists_.isEmpty()) {
                    if (this.s2CListsBuilder_.isEmpty()) {
                        this.s2CListsBuilder_.dispose();
                        this.s2CListsBuilder_ = null;
                        this.s2CLists_ = other.s2CLists_;
                        this.bitField0_ &= 0xFFFFFFFB;
                        this.s2CListsBuilder_ = LeaderBoardHandler.LeaderBoardResponse.alwaysUseFieldBuilders ? getS2CListsFieldBuilder() : null;
                    } else {
                        this.s2CListsBuilder_.addAllMessages(other.s2CLists_);
                    }
                }
                if (other.hasS2CMyData())
                    mergeS2CMyData(other.getS2CMyData());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode())
                    return false;
                for (int i = 0; i < getS2CListsCount(); i++) {
                    if (!getS2CLists(i).isInitialized())
                        return false;
                }
                if (hasS2CMyData() && !getS2CMyData().isInitialized())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                LeaderBoardHandler.LeaderBoardResponse parsedMessage = null;
                try {
                    parsedMessage = (LeaderBoardHandler.LeaderBoardResponse) LeaderBoardHandler.LeaderBoardResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (LeaderBoardHandler.LeaderBoardResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = LeaderBoardHandler.LeaderBoardResponse.getDefaultInstance().getS2CMsg();
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

            private void ensureS2CListsIsMutable() {
                if ((this.bitField0_ & 0x4) != 4) {
                    this.s2CLists_ = new ArrayList<>(this.s2CLists_);
                    this.bitField0_ |= 0x4;
                }
            }

            public List<LeaderBoardHandler.LeaderBoardData> getS2CListsList() {
                if (this.s2CListsBuilder_ == null)
                    return Collections.unmodifiableList(this.s2CLists_);
                return this.s2CListsBuilder_.getMessageList();
            }

            public int getS2CListsCount() {
                if (this.s2CListsBuilder_ == null)
                    return this.s2CLists_.size();
                return this.s2CListsBuilder_.getCount();
            }

            public LeaderBoardHandler.LeaderBoardData getS2CLists(int index) {
                if (this.s2CListsBuilder_ == null)
                    return this.s2CLists_.get(index);
                return (LeaderBoardHandler.LeaderBoardData) this.s2CListsBuilder_.getMessage(index);
            }

            public Builder setS2CLists(int index, LeaderBoardHandler.LeaderBoardData value) {
                if (this.s2CListsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CListsIsMutable();
                    this.s2CLists_.set(index, value);
                    onChanged();
                } else {
                    this.s2CListsBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setS2CLists(int index, LeaderBoardHandler.LeaderBoardData.Builder builderForValue) {
                if (this.s2CListsBuilder_ == null) {
                    ensureS2CListsIsMutable();
                    this.s2CLists_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CListsBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addS2CLists(LeaderBoardHandler.LeaderBoardData value) {
                if (this.s2CListsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CListsIsMutable();
                    this.s2CLists_.add(value);
                    onChanged();
                } else {
                    this.s2CListsBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addS2CLists(int index, LeaderBoardHandler.LeaderBoardData value) {
                if (this.s2CListsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CListsIsMutable();
                    this.s2CLists_.add(index, value);
                    onChanged();
                } else {
                    this.s2CListsBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addS2CLists(LeaderBoardHandler.LeaderBoardData.Builder builderForValue) {
                if (this.s2CListsBuilder_ == null) {
                    ensureS2CListsIsMutable();
                    this.s2CLists_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.s2CListsBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addS2CLists(int index, LeaderBoardHandler.LeaderBoardData.Builder builderForValue) {
                if (this.s2CListsBuilder_ == null) {
                    ensureS2CListsIsMutable();
                    this.s2CLists_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CListsBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllS2CLists(Iterable<? extends LeaderBoardHandler.LeaderBoardData> values) {
                if (this.s2CListsBuilder_ == null) {
                    ensureS2CListsIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.s2CLists_);
                    onChanged();
                } else {
                    this.s2CListsBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearS2CLists() {
                if (this.s2CListsBuilder_ == null) {
                    this.s2CLists_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                    onChanged();
                } else {
                    this.s2CListsBuilder_.clear();
                }
                return this;
            }

            public Builder removeS2CLists(int index) {
                if (this.s2CListsBuilder_ == null) {
                    ensureS2CListsIsMutable();
                    this.s2CLists_.remove(index);
                    onChanged();
                } else {
                    this.s2CListsBuilder_.remove(index);
                }
                return this;
            }

            public LeaderBoardHandler.LeaderBoardData.Builder getS2CListsBuilder(int index) {
                return (LeaderBoardHandler.LeaderBoardData.Builder) getS2CListsFieldBuilder().getBuilder(index);
            }

            public LeaderBoardHandler.LeaderBoardDataOrBuilder getS2CListsOrBuilder(int index) {
                if (this.s2CListsBuilder_ == null)
                    return this.s2CLists_.get(index);
                return (LeaderBoardHandler.LeaderBoardDataOrBuilder) this.s2CListsBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends LeaderBoardHandler.LeaderBoardDataOrBuilder> getS2CListsOrBuilderList() {
                if (this.s2CListsBuilder_ != null)
                    return this.s2CListsBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.s2CLists_);
            }

            public LeaderBoardHandler.LeaderBoardData.Builder addS2CListsBuilder() {
                return (LeaderBoardHandler.LeaderBoardData.Builder) getS2CListsFieldBuilder().addBuilder(LeaderBoardHandler.LeaderBoardData.getDefaultInstance());
            }

            public LeaderBoardHandler.LeaderBoardData.Builder addS2CListsBuilder(int index) {
                return (LeaderBoardHandler.LeaderBoardData.Builder) getS2CListsFieldBuilder().addBuilder(index, LeaderBoardHandler.LeaderBoardData.getDefaultInstance());
            }

            public List<LeaderBoardHandler.LeaderBoardData.Builder> getS2CListsBuilderList() {
                return getS2CListsFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<LeaderBoardHandler.LeaderBoardData, LeaderBoardHandler.LeaderBoardData.Builder, LeaderBoardHandler.LeaderBoardDataOrBuilder> getS2CListsFieldBuilder() {
                if (this.s2CListsBuilder_ == null) {
                    this.s2CListsBuilder_ = new RepeatedFieldBuilder(this.s2CLists_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
                    this.s2CLists_ = null;
                }
                return this.s2CListsBuilder_;
            }

            public boolean hasS2CMyData() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public LeaderBoardHandler.LeaderBoardData getS2CMyData() {
                if (this.s2CMyDataBuilder_ == null)
                    return this.s2CMyData_;
                return (LeaderBoardHandler.LeaderBoardData) this.s2CMyDataBuilder_.getMessage();
            }

            public Builder setS2CMyData(LeaderBoardHandler.LeaderBoardData value) {
                if (this.s2CMyDataBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    this.s2CMyData_ = value;
                    onChanged();
                } else {
                    this.s2CMyDataBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x8;
                return this;
            }

            public Builder setS2CMyData(LeaderBoardHandler.LeaderBoardData.Builder builderForValue) {
                if (this.s2CMyDataBuilder_ == null) {
                    this.s2CMyData_ = builderForValue.build();
                    onChanged();
                } else {
                    this.s2CMyDataBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x8;
                return this;
            }

            public Builder mergeS2CMyData(LeaderBoardHandler.LeaderBoardData value) {
                if (this.s2CMyDataBuilder_ == null) {
                    if ((this.bitField0_ & 0x8) == 8 && this.s2CMyData_ != LeaderBoardHandler.LeaderBoardData.getDefaultInstance()) {
                        this.s2CMyData_ = LeaderBoardHandler.LeaderBoardData.newBuilder(this.s2CMyData_).mergeFrom(value).buildPartial();
                    } else {
                        this.s2CMyData_ = value;
                    }
                    onChanged();
                } else {
                    this.s2CMyDataBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x8;
                return this;
            }

            public Builder clearS2CMyData() {
                if (this.s2CMyDataBuilder_ == null) {
                    this.s2CMyData_ = LeaderBoardHandler.LeaderBoardData.getDefaultInstance();
                    onChanged();
                } else {
                    this.s2CMyDataBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }

            public LeaderBoardHandler.LeaderBoardData.Builder getS2CMyDataBuilder() {
                this.bitField0_ |= 0x8;
                onChanged();
                return (LeaderBoardHandler.LeaderBoardData.Builder) getS2CMyDataFieldBuilder().getBuilder();
            }

            public LeaderBoardHandler.LeaderBoardDataOrBuilder getS2CMyDataOrBuilder() {
                if (this.s2CMyDataBuilder_ != null)
                    return (LeaderBoardHandler.LeaderBoardDataOrBuilder) this.s2CMyDataBuilder_.getMessageOrBuilder();
                return this.s2CMyData_;
            }

            private SingleFieldBuilder<LeaderBoardHandler.LeaderBoardData, LeaderBoardHandler.LeaderBoardData.Builder, LeaderBoardHandler.LeaderBoardDataOrBuilder> getS2CMyDataFieldBuilder() {
                if (this.s2CMyDataBuilder_ == null) {
                    this.s2CMyDataBuilder_ = new SingleFieldBuilder(getS2CMyData(), getParentForChildren(), isClean());
                    this.s2CMyData_ = null;
                }
                return this.s2CMyDataBuilder_;
            }
        }
    }

    public static final class GuildInfoRequest extends GeneratedMessage implements GuildInfoRequestOrBuilder {
        private static final GuildInfoRequest defaultInstance = new GuildInfoRequest(true);
        private final UnknownFieldSet unknownFields;

        private GuildInfoRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GuildInfoRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GuildInfoRequest getDefaultInstance() {
            return defaultInstance;
        }

        public GuildInfoRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GuildInfoRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.c2SGuildId_ = bs;
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
            return LeaderBoardHandler.internal_static_pomelo_area_GuildInfoRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return LeaderBoardHandler.internal_static_pomelo_area_GuildInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildInfoRequest.class, Builder.class);
        }

        public static Parser<GuildInfoRequest> PARSER = (Parser<GuildInfoRequest>) new AbstractParser<GuildInfoRequest>() {
            public LeaderBoardHandler.GuildInfoRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new LeaderBoardHandler.GuildInfoRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_GUILDID_FIELD_NUMBER = 1;
        private Object c2SGuildId_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GuildInfoRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasC2SGuildId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public String getC2SGuildId() {
            Object ref = this.c2SGuildId_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.c2SGuildId_ = s;
            return s;
        }

        public ByteString getC2SGuildIdBytes() {
            Object ref = this.c2SGuildId_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.c2SGuildId_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        static {
            defaultInstance.initFields();
        }


        private void initFields() {
            this.c2SGuildId_ = "";
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasC2SGuildId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeBytes(1, getC2SGuildIdBytes());
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
                size += CodedOutputStream.computeBytesSize(1, getC2SGuildIdBytes());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static GuildInfoRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GuildInfoRequest) PARSER.parseFrom(data);
        }


        public static GuildInfoRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GuildInfoRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GuildInfoRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GuildInfoRequest) PARSER.parseFrom(data);
        }


        public static GuildInfoRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GuildInfoRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GuildInfoRequest parseFrom(InputStream input) throws IOException {
            return (GuildInfoRequest) PARSER.parseFrom(input);
        }


        public static GuildInfoRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GuildInfoRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static GuildInfoRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (GuildInfoRequest) PARSER.parseDelimitedFrom(input);
        }


        public static GuildInfoRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GuildInfoRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static GuildInfoRequest parseFrom(CodedInputStream input) throws IOException {
            return (GuildInfoRequest) PARSER.parseFrom(input);
        }


        public static GuildInfoRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GuildInfoRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(GuildInfoRequest prototype) {
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
                implements LeaderBoardHandler.GuildInfoRequestOrBuilder {
            private int bitField0_;


            private Object c2SGuildId_;


            public static final Descriptors.Descriptor getDescriptor() {
                return LeaderBoardHandler.internal_static_pomelo_area_GuildInfoRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return LeaderBoardHandler.internal_static_pomelo_area_GuildInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(LeaderBoardHandler.GuildInfoRequest.class, Builder.class);
            }


            private Builder() {
                this.c2SGuildId_ = "";
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.c2SGuildId_ = "";
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (LeaderBoardHandler.GuildInfoRequest.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.c2SGuildId_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return LeaderBoardHandler.internal_static_pomelo_area_GuildInfoRequest_descriptor;
            }


            public LeaderBoardHandler.GuildInfoRequest getDefaultInstanceForType() {
                return LeaderBoardHandler.GuildInfoRequest.getDefaultInstance();
            }


            public LeaderBoardHandler.GuildInfoRequest build() {
                LeaderBoardHandler.GuildInfoRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public LeaderBoardHandler.GuildInfoRequest buildPartial() {
                LeaderBoardHandler.GuildInfoRequest result = new LeaderBoardHandler.GuildInfoRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.c2SGuildId_ = this.c2SGuildId_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof LeaderBoardHandler.GuildInfoRequest) {
                    return mergeFrom((LeaderBoardHandler.GuildInfoRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(LeaderBoardHandler.GuildInfoRequest other) {
                if (other == LeaderBoardHandler.GuildInfoRequest.getDefaultInstance()) {
                    return this;
                }
                if (other.hasC2SGuildId()) {
                    this.bitField0_ |= 0x1;
                    this.c2SGuildId_ = other.c2SGuildId_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasC2SGuildId()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                LeaderBoardHandler.GuildInfoRequest parsedMessage = null;
                try {
                    parsedMessage = (LeaderBoardHandler.GuildInfoRequest) LeaderBoardHandler.GuildInfoRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (LeaderBoardHandler.GuildInfoRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasC2SGuildId() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public String getC2SGuildId() {
                Object ref = this.c2SGuildId_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.c2SGuildId_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }


            public ByteString getC2SGuildIdBytes() {
                Object ref = this.c2SGuildId_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.c2SGuildId_ = b;
                    return b;
                }
                return (ByteString) ref;
            }


            public Builder setC2SGuildId(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x1;
                this.c2SGuildId_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SGuildId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SGuildId_ = LeaderBoardHandler.GuildInfoRequest.getDefaultInstance().getC2SGuildId();
                onChanged();
                return this;
            }


            public Builder setC2SGuildIdBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x1;
                this.c2SGuildId_ = value;
                onChanged();
                return this;
            }
        }
    }


    public static final class GuildInfoResponse
            extends GeneratedMessage
            implements GuildInfoResponseOrBuilder {
        private static final GuildInfoResponse defaultInstance = new GuildInfoResponse(true);
        private final UnknownFieldSet unknownFields;

        private GuildInfoResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GuildInfoResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GuildInfoResponse getDefaultInstance() {
            return defaultInstance;
        }

        public GuildInfoResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GuildInfoResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString bs;
                    LeaderBoardHandler.RankGuildInfo.Builder subBuilder;
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
                            if ((this.bitField0_ & 0x4) == 4) subBuilder = this.s2CData_.toBuilder();
                            this.s2CData_ = (LeaderBoardHandler.RankGuildInfo) input.readMessage(LeaderBoardHandler.RankGuildInfo.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.s2CData_);
                                this.s2CData_ = subBuilder.buildPartial();
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
            return LeaderBoardHandler.internal_static_pomelo_area_GuildInfoResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return LeaderBoardHandler.internal_static_pomelo_area_GuildInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GuildInfoResponse.class, Builder.class);
        }

        public static Parser<GuildInfoResponse> PARSER = (Parser<GuildInfoResponse>) new AbstractParser<GuildInfoResponse>() {
            public LeaderBoardHandler.GuildInfoResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new LeaderBoardHandler.GuildInfoResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_DATA_FIELD_NUMBER = 3;
        private LeaderBoardHandler.RankGuildInfo s2CData_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GuildInfoResponse> getParserForType() {
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

        public boolean hasS2CData() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public LeaderBoardHandler.RankGuildInfo getS2CData() {
            return this.s2CData_;
        }

        public LeaderBoardHandler.RankGuildInfoOrBuilder getS2CDataOrBuilder() {
            return this.s2CData_;
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CData_ = LeaderBoardHandler.RankGuildInfo.getDefaultInstance();
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
            if ((this.bitField0_ & 0x4) == 4)
                output.writeMessage(3, (MessageLite) this.s2CData_);
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
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.s2CData_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static GuildInfoResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GuildInfoResponse) PARSER.parseFrom(data);
        }

        public static GuildInfoResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GuildInfoResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GuildInfoResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GuildInfoResponse) PARSER.parseFrom(data);
        }

        public static GuildInfoResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GuildInfoResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GuildInfoResponse parseFrom(InputStream input) throws IOException {
            return (GuildInfoResponse) PARSER.parseFrom(input);
        }

        public static GuildInfoResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GuildInfoResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static GuildInfoResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (GuildInfoResponse) PARSER.parseDelimitedFrom(input);
        }

        public static GuildInfoResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GuildInfoResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static GuildInfoResponse parseFrom(CodedInputStream input) throws IOException {
            return (GuildInfoResponse) PARSER.parseFrom(input);
        }

        public static GuildInfoResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GuildInfoResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(GuildInfoResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements LeaderBoardHandler.GuildInfoResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private LeaderBoardHandler.RankGuildInfo s2CData_;
            private SingleFieldBuilder<LeaderBoardHandler.RankGuildInfo, LeaderBoardHandler.RankGuildInfo.Builder, LeaderBoardHandler.RankGuildInfoOrBuilder> s2CDataBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return LeaderBoardHandler.internal_static_pomelo_area_GuildInfoResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return LeaderBoardHandler.internal_static_pomelo_area_GuildInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(LeaderBoardHandler.GuildInfoResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.s2CData_ = LeaderBoardHandler.RankGuildInfo.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CData_ = LeaderBoardHandler.RankGuildInfo.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (LeaderBoardHandler.GuildInfoResponse.alwaysUseFieldBuilders)
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
                    this.s2CData_ = LeaderBoardHandler.RankGuildInfo.getDefaultInstance();
                } else {
                    this.s2CDataBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return LeaderBoardHandler.internal_static_pomelo_area_GuildInfoResponse_descriptor;
            }

            public LeaderBoardHandler.GuildInfoResponse getDefaultInstanceForType() {
                return LeaderBoardHandler.GuildInfoResponse.getDefaultInstance();
            }

            public LeaderBoardHandler.GuildInfoResponse build() {
                LeaderBoardHandler.GuildInfoResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public LeaderBoardHandler.GuildInfoResponse buildPartial() {
                LeaderBoardHandler.GuildInfoResponse result = new LeaderBoardHandler.GuildInfoResponse(this);
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
                if (this.s2CDataBuilder_ == null) {
                    result.s2CData_ = this.s2CData_;
                } else {
                    result.s2CData_ = (LeaderBoardHandler.RankGuildInfo) this.s2CDataBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof LeaderBoardHandler.GuildInfoResponse)
                    return mergeFrom((LeaderBoardHandler.GuildInfoResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(LeaderBoardHandler.GuildInfoResponse other) {
                if (other == LeaderBoardHandler.GuildInfoResponse.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (other.hasS2CData())
                    mergeS2CData(other.getS2CData());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                LeaderBoardHandler.GuildInfoResponse parsedMessage = null;
                try {
                    parsedMessage = (LeaderBoardHandler.GuildInfoResponse) LeaderBoardHandler.GuildInfoResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (LeaderBoardHandler.GuildInfoResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = LeaderBoardHandler.GuildInfoResponse.getDefaultInstance().getS2CMsg();
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

            public boolean hasS2CData() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public LeaderBoardHandler.RankGuildInfo getS2CData() {
                if (this.s2CDataBuilder_ == null)
                    return this.s2CData_;
                return (LeaderBoardHandler.RankGuildInfo) this.s2CDataBuilder_.getMessage();
            }

            public Builder setS2CData(LeaderBoardHandler.RankGuildInfo value) {
                if (this.s2CDataBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    this.s2CData_ = value;
                    onChanged();
                } else {
                    this.s2CDataBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder setS2CData(LeaderBoardHandler.RankGuildInfo.Builder builderForValue) {
                if (this.s2CDataBuilder_ == null) {
                    this.s2CData_ = builderForValue.build();
                    onChanged();
                } else {
                    this.s2CDataBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder mergeS2CData(LeaderBoardHandler.RankGuildInfo value) {
                if (this.s2CDataBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4 && this.s2CData_ != LeaderBoardHandler.RankGuildInfo.getDefaultInstance()) {
                        this.s2CData_ = LeaderBoardHandler.RankGuildInfo.newBuilder(this.s2CData_).mergeFrom(value).buildPartial();
                    } else {
                        this.s2CData_ = value;
                    }
                    onChanged();
                } else {
                    this.s2CDataBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder clearS2CData() {
                if (this.s2CDataBuilder_ == null) {
                    this.s2CData_ = LeaderBoardHandler.RankGuildInfo.getDefaultInstance();
                    onChanged();
                } else {
                    this.s2CDataBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public LeaderBoardHandler.RankGuildInfo.Builder getS2CDataBuilder() {
                this.bitField0_ |= 0x4;
                onChanged();
                return (LeaderBoardHandler.RankGuildInfo.Builder) getS2CDataFieldBuilder().getBuilder();
            }

            public LeaderBoardHandler.RankGuildInfoOrBuilder getS2CDataOrBuilder() {
                if (this.s2CDataBuilder_ != null)
                    return (LeaderBoardHandler.RankGuildInfoOrBuilder) this.s2CDataBuilder_.getMessageOrBuilder();
                return this.s2CData_;
            }

            private SingleFieldBuilder<LeaderBoardHandler.RankGuildInfo, LeaderBoardHandler.RankGuildInfo.Builder, LeaderBoardHandler.RankGuildInfoOrBuilder> getS2CDataFieldBuilder() {
                if (this.s2CDataBuilder_ == null) {
                    this.s2CDataBuilder_ = new SingleFieldBuilder(getS2CData(), getParentForChildren(), isClean());
                    this.s2CData_ = null;
                }
                return this.s2CDataBuilder_;
            }
        }
    }

    public static final class WorShipRequest extends GeneratedMessage implements WorShipRequestOrBuilder {
        private static final WorShipRequest defaultInstance = new WorShipRequest(true);
        private final UnknownFieldSet unknownFields;

        private WorShipRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private WorShipRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static WorShipRequest getDefaultInstance() {
            return defaultInstance;
        }

        public WorShipRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private WorShipRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return LeaderBoardHandler.internal_static_pomelo_area_WorShipRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return LeaderBoardHandler.internal_static_pomelo_area_WorShipRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(WorShipRequest.class, Builder.class);
        }

        public static Parser<WorShipRequest> PARSER = (Parser<WorShipRequest>) new AbstractParser<WorShipRequest>() {
            public LeaderBoardHandler.WorShipRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new LeaderBoardHandler.WorShipRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_TYPE_FIELD_NUMBER = 1;
        private int c2SType_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<WorShipRequest> getParserForType() {
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
                output.writeInt32(1, this.c2SType_);
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
                size += CodedOutputStream.computeInt32Size(1, this.c2SType_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static WorShipRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (WorShipRequest) PARSER.parseFrom(data);
        }


        public static WorShipRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (WorShipRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static WorShipRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (WorShipRequest) PARSER.parseFrom(data);
        }


        public static WorShipRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (WorShipRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static WorShipRequest parseFrom(InputStream input) throws IOException {
            return (WorShipRequest) PARSER.parseFrom(input);
        }


        public static WorShipRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WorShipRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static WorShipRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (WorShipRequest) PARSER.parseDelimitedFrom(input);
        }


        public static WorShipRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WorShipRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static WorShipRequest parseFrom(CodedInputStream input) throws IOException {
            return (WorShipRequest) PARSER.parseFrom(input);
        }


        public static WorShipRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WorShipRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(WorShipRequest prototype) {
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
                implements LeaderBoardHandler.WorShipRequestOrBuilder {
            private int bitField0_;


            private int c2SType_;


            public static final Descriptors.Descriptor getDescriptor() {
                return LeaderBoardHandler.internal_static_pomelo_area_WorShipRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return LeaderBoardHandler.internal_static_pomelo_area_WorShipRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(LeaderBoardHandler.WorShipRequest.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (LeaderBoardHandler.WorShipRequest.alwaysUseFieldBuilders) ;
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
                return LeaderBoardHandler.internal_static_pomelo_area_WorShipRequest_descriptor;
            }


            public LeaderBoardHandler.WorShipRequest getDefaultInstanceForType() {
                return LeaderBoardHandler.WorShipRequest.getDefaultInstance();
            }


            public LeaderBoardHandler.WorShipRequest build() {
                LeaderBoardHandler.WorShipRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public LeaderBoardHandler.WorShipRequest buildPartial() {
                LeaderBoardHandler.WorShipRequest result = new LeaderBoardHandler.WorShipRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.c2SType_ = this.c2SType_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof LeaderBoardHandler.WorShipRequest) {
                    return mergeFrom((LeaderBoardHandler.WorShipRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(LeaderBoardHandler.WorShipRequest other) {
                if (other == LeaderBoardHandler.WorShipRequest.getDefaultInstance()) {
                    return this;
                }
                if (other.hasC2SType()) {
                    setC2SType(other.getC2SType());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasC2SType()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                LeaderBoardHandler.WorShipRequest parsedMessage = null;
                try {
                    parsedMessage = (LeaderBoardHandler.WorShipRequest) LeaderBoardHandler.WorShipRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (LeaderBoardHandler.WorShipRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
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
    }


    public static final class WorShipResponse
            extends GeneratedMessage
            implements WorShipResponseOrBuilder {
        private static final WorShipResponse defaultInstance = new WorShipResponse(true);
        private final UnknownFieldSet unknownFields;

        private WorShipResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private WorShipResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static WorShipResponse getDefaultInstance() {
            return defaultInstance;
        }

        public WorShipResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private WorShipResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.s2CAwards_ = (LazyStringList) new LazyStringArrayList();
                                mutable_bitField0_ |= 0x4;
                            }
                            this.s2CAwards_.add(bs);
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x4) == 4) this.s2CAwards_ = this.s2CAwards_.getUnmodifiableView();
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LeaderBoardHandler.internal_static_pomelo_area_WorShipResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return LeaderBoardHandler.internal_static_pomelo_area_WorShipResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(WorShipResponse.class, Builder.class);
        }

        public static Parser<WorShipResponse> PARSER = (Parser<WorShipResponse>) new AbstractParser<WorShipResponse>() {
            public LeaderBoardHandler.WorShipResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new LeaderBoardHandler.WorShipResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_AWARDS_FIELD_NUMBER = 3;
        private LazyStringList s2CAwards_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<WorShipResponse> getParserForType() {
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

        public ProtocolStringList getS2CAwardsList() {
            return (ProtocolStringList) this.s2CAwards_;
        }

        public int getS2CAwardsCount() {
            return this.s2CAwards_.size();
        }

        public String getS2CAwards(int index) {
            return (String) this.s2CAwards_.get(index);
        }

        public ByteString getS2CAwardsBytes(int index) {
            return this.s2CAwards_.getByteString(index);
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CAwards_ = LazyStringArrayList.EMPTY;
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
            for (int i = 0; i < this.s2CAwards_.size(); i++)
                output.writeBytes(3, this.s2CAwards_.getByteString(i));
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
            int dataSize = 0;
            for (int i = 0; i < this.s2CAwards_.size(); i++)
                dataSize += CodedOutputStream.computeBytesSizeNoTag(this.s2CAwards_.getByteString(i));
            size += dataSize;
            size += 1 * getS2CAwardsList().size();
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static WorShipResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (WorShipResponse) PARSER.parseFrom(data);
        }

        public static WorShipResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (WorShipResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static WorShipResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (WorShipResponse) PARSER.parseFrom(data);
        }

        public static WorShipResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (WorShipResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static WorShipResponse parseFrom(InputStream input) throws IOException {
            return (WorShipResponse) PARSER.parseFrom(input);
        }

        public static WorShipResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WorShipResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static WorShipResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (WorShipResponse) PARSER.parseDelimitedFrom(input);
        }

        public static WorShipResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WorShipResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static WorShipResponse parseFrom(CodedInputStream input) throws IOException {
            return (WorShipResponse) PARSER.parseFrom(input);
        }

        public static WorShipResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WorShipResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(WorShipResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements LeaderBoardHandler.WorShipResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private LazyStringList s2CAwards_;

            public static final Descriptors.Descriptor getDescriptor() {
                return LeaderBoardHandler.internal_static_pomelo_area_WorShipResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return LeaderBoardHandler.internal_static_pomelo_area_WorShipResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(LeaderBoardHandler.WorShipResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.s2CAwards_ = LazyStringArrayList.EMPTY;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CAwards_ = LazyStringArrayList.EMPTY;
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (LeaderBoardHandler.WorShipResponse.alwaysUseFieldBuilders) ;
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
                this.s2CAwards_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return LeaderBoardHandler.internal_static_pomelo_area_WorShipResponse_descriptor;
            }

            public LeaderBoardHandler.WorShipResponse getDefaultInstanceForType() {
                return LeaderBoardHandler.WorShipResponse.getDefaultInstance();
            }

            public LeaderBoardHandler.WorShipResponse build() {
                LeaderBoardHandler.WorShipResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public LeaderBoardHandler.WorShipResponse buildPartial() {
                LeaderBoardHandler.WorShipResponse result = new LeaderBoardHandler.WorShipResponse(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.s2CMsg_ = this.s2CMsg_;
                if ((this.bitField0_ & 0x4) == 4) {
                    this.s2CAwards_ = this.s2CAwards_.getUnmodifiableView();
                    this.bitField0_ &= 0xFFFFFFFB;
                }
                result.s2CAwards_ = this.s2CAwards_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof LeaderBoardHandler.WorShipResponse)
                    return mergeFrom((LeaderBoardHandler.WorShipResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(LeaderBoardHandler.WorShipResponse other) {
                if (other == LeaderBoardHandler.WorShipResponse.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (!other.s2CAwards_.isEmpty()) {
                    if (this.s2CAwards_.isEmpty()) {
                        this.s2CAwards_ = other.s2CAwards_;
                        this.bitField0_ &= 0xFFFFFFFB;
                    } else {
                        ensureS2CAwardsIsMutable();
                        this.s2CAwards_.addAll((Collection) other.s2CAwards_);
                    }
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
                LeaderBoardHandler.WorShipResponse parsedMessage = null;
                try {
                    parsedMessage = (LeaderBoardHandler.WorShipResponse) LeaderBoardHandler.WorShipResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (LeaderBoardHandler.WorShipResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = LeaderBoardHandler.WorShipResponse.getDefaultInstance().getS2CMsg();
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

            private void ensureS2CAwardsIsMutable() {
                if ((this.bitField0_ & 0x4) != 4) {
                    this.s2CAwards_ = (LazyStringList) new LazyStringArrayList(this.s2CAwards_);
                    this.bitField0_ |= 0x4;
                }
            }

            public ProtocolStringList getS2CAwardsList() {
                return (ProtocolStringList) this.s2CAwards_.getUnmodifiableView();
            }

            public int getS2CAwardsCount() {
                return this.s2CAwards_.size();
            }

            public String getS2CAwards(int index) {
                return (String) this.s2CAwards_.get(index);
            }

            public ByteString getS2CAwardsBytes(int index) {
                return this.s2CAwards_.getByteString(index);
            }

            public Builder setS2CAwards(int index, String value) {
                if (value == null)
                    throw new NullPointerException();
                ensureS2CAwardsIsMutable();
                this.s2CAwards_.set(index, value);
                onChanged();
                return this;
            }

            public Builder addS2CAwards(String value) {
                if (value == null)
                    throw new NullPointerException();
                ensureS2CAwardsIsMutable();
                this.s2CAwards_.add(value);
                onChanged();
                return this;
            }

            public Builder addAllS2CAwards(Iterable<String> values) {
                ensureS2CAwardsIsMutable();
                AbstractMessageLite.Builder.addAll(values, (Collection) this.s2CAwards_);
                onChanged();
                return this;
            }

            public Builder clearS2CAwards() {
                this.s2CAwards_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= 0xFFFFFFFB;
                onChanged();
                return this;
            }

            public Builder addS2CAwardsBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                ensureS2CAwardsIsMutable();
                this.s2CAwards_.add(value);
                onChanged();
                return this;
            }
        }
    }

    public static final class WorldLevelInfoRequest extends GeneratedMessage implements WorldLevelInfoRequestOrBuilder {
        private static final WorldLevelInfoRequest defaultInstance = new WorldLevelInfoRequest(true);
        private final UnknownFieldSet unknownFields;

        private WorldLevelInfoRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private WorldLevelInfoRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static WorldLevelInfoRequest getDefaultInstance() {
            return defaultInstance;
        }

        public WorldLevelInfoRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private WorldLevelInfoRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return LeaderBoardHandler.internal_static_pomelo_area_WorldLevelInfoRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return LeaderBoardHandler.internal_static_pomelo_area_WorldLevelInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(WorldLevelInfoRequest.class, Builder.class);
        }

        public static Parser<WorldLevelInfoRequest> PARSER = (Parser<WorldLevelInfoRequest>) new AbstractParser<WorldLevelInfoRequest>() {
            public LeaderBoardHandler.WorldLevelInfoRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new LeaderBoardHandler.WorldLevelInfoRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<WorldLevelInfoRequest> getParserForType() {
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


        public static WorldLevelInfoRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (WorldLevelInfoRequest) PARSER.parseFrom(data);
        }


        public static WorldLevelInfoRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (WorldLevelInfoRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static WorldLevelInfoRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (WorldLevelInfoRequest) PARSER.parseFrom(data);
        }


        public static WorldLevelInfoRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (WorldLevelInfoRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static WorldLevelInfoRequest parseFrom(InputStream input) throws IOException {
            return (WorldLevelInfoRequest) PARSER.parseFrom(input);
        }


        public static WorldLevelInfoRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WorldLevelInfoRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static WorldLevelInfoRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (WorldLevelInfoRequest) PARSER.parseDelimitedFrom(input);
        }


        public static WorldLevelInfoRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WorldLevelInfoRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static WorldLevelInfoRequest parseFrom(CodedInputStream input) throws IOException {
            return (WorldLevelInfoRequest) PARSER.parseFrom(input);
        }


        public static WorldLevelInfoRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WorldLevelInfoRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(WorldLevelInfoRequest prototype) {
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
                implements LeaderBoardHandler.WorldLevelInfoRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return LeaderBoardHandler.internal_static_pomelo_area_WorldLevelInfoRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return LeaderBoardHandler.internal_static_pomelo_area_WorldLevelInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(LeaderBoardHandler.WorldLevelInfoRequest.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (LeaderBoardHandler.WorldLevelInfoRequest.alwaysUseFieldBuilders) ;
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
                return LeaderBoardHandler.internal_static_pomelo_area_WorldLevelInfoRequest_descriptor;
            }


            public LeaderBoardHandler.WorldLevelInfoRequest getDefaultInstanceForType() {
                return LeaderBoardHandler.WorldLevelInfoRequest.getDefaultInstance();
            }


            public LeaderBoardHandler.WorldLevelInfoRequest build() {
                LeaderBoardHandler.WorldLevelInfoRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public LeaderBoardHandler.WorldLevelInfoRequest buildPartial() {
                LeaderBoardHandler.WorldLevelInfoRequest result = new LeaderBoardHandler.WorldLevelInfoRequest(this);
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof LeaderBoardHandler.WorldLevelInfoRequest) {
                    return mergeFrom((LeaderBoardHandler.WorldLevelInfoRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(LeaderBoardHandler.WorldLevelInfoRequest other) {
                if (other == LeaderBoardHandler.WorldLevelInfoRequest.getDefaultInstance()) {
                    return this;
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                LeaderBoardHandler.WorldLevelInfoRequest parsedMessage = null;
                try {
                    parsedMessage = (LeaderBoardHandler.WorldLevelInfoRequest) LeaderBoardHandler.WorldLevelInfoRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (LeaderBoardHandler.WorldLevelInfoRequest) e.getUnfinishedMessage();
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


    public static final class WorldLevelInfo
            extends GeneratedMessage
            implements WorldLevelInfoOrBuilder {
        private static final WorldLevelInfo defaultInstance = new WorldLevelInfo(true);
        private final UnknownFieldSet unknownFields;

        private WorldLevelInfo(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private WorldLevelInfo(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static WorldLevelInfo getDefaultInstance() {
            return defaultInstance;
        }

        public WorldLevelInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private WorldLevelInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.worldLevelId_ = bs;
                            break;
                        case 18:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x2;
                            this.worldLevelName_ = bs;
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.worldLevel_ = input.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.worldUpLevel_ = input.readInt32();
                            break;
                        case 42:
                            if ((mutable_bitField0_ & 0x10) != 16) {
                                this.avatars_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x10;
                            }
                            this.avatars_.add(input.readMessage(Common.Avatar.PARSER, extensionRegistry));
                            break;
                        case 48:
                            this.bitField0_ |= 0x10;
                            this.addExp_ = input.readInt32();
                            break;
                        case 56:
                            this.bitField0_ |= 0x20;
                            this.worShipTimes_ = input.readInt32();
                            break;
                        case 64:
                            this.bitField0_ |= 0x40;
                            this.maxWorShipTimes_ = input.readInt32();
                            break;
                        case 72:
                            this.bitField0_ |= 0x80;
                            this.worldLevelPro_ = input.readInt32();
                            break;
                        case 82:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x100;
                            this.rank1StGuildName_ = bs;
                            break;
                        case 88:
                            this.bitField0_ |= 0x200;
                            this.rank1StFight_ = input.readInt32();
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x10) == 16) this.avatars_ = Collections.unmodifiableList(this.avatars_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LeaderBoardHandler.internal_static_pomelo_area_WorldLevelInfo_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return LeaderBoardHandler.internal_static_pomelo_area_WorldLevelInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(WorldLevelInfo.class, Builder.class);
        }

        public static Parser<WorldLevelInfo> PARSER = (Parser<WorldLevelInfo>) new AbstractParser<WorldLevelInfo>() {
            public LeaderBoardHandler.WorldLevelInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new LeaderBoardHandler.WorldLevelInfo(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int WORLDLEVELID_FIELD_NUMBER = 1;
        private Object worldLevelId_;
        public static final int WORLDLEVELNAME_FIELD_NUMBER = 2;
        private Object worldLevelName_;
        public static final int WORLDLEVEL_FIELD_NUMBER = 3;
        private int worldLevel_;
        public static final int WORLDUPLEVEL_FIELD_NUMBER = 4;
        private int worldUpLevel_;
        public static final int AVATARS_FIELD_NUMBER = 5;
        private List<Common.Avatar> avatars_;
        public static final int ADDEXP_FIELD_NUMBER = 6;
        private int addExp_;
        public static final int WORSHIPTIMES_FIELD_NUMBER = 7;
        private int worShipTimes_;
        public static final int MAXWORSHIPTIMES_FIELD_NUMBER = 8;
        private int maxWorShipTimes_;
        public static final int WORLDLEVELPRO_FIELD_NUMBER = 9;
        private int worldLevelPro_;
        public static final int RANK1STGUILDNAME_FIELD_NUMBER = 10;
        private Object rank1StGuildName_;
        public static final int RANK1STFIGHT_FIELD_NUMBER = 11;
        private int rank1StFight_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<WorldLevelInfo> getParserForType() {
            return PARSER;
        }

        public boolean hasWorldLevelId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public String getWorldLevelId() {
            Object ref = this.worldLevelId_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.worldLevelId_ = s;
            return s;
        }

        public ByteString getWorldLevelIdBytes() {
            Object ref = this.worldLevelId_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.worldLevelId_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasWorldLevelName() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public String getWorldLevelName() {
            Object ref = this.worldLevelName_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.worldLevelName_ = s;
            return s;
        }

        public ByteString getWorldLevelNameBytes() {
            Object ref = this.worldLevelName_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.worldLevelName_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        static {
            defaultInstance.initFields();
        }

        public boolean hasWorldLevel() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getWorldLevel() {
            return this.worldLevel_;
        }

        public boolean hasWorldUpLevel() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public int getWorldUpLevel() {
            return this.worldUpLevel_;
        }

        public List<Common.Avatar> getAvatarsList() {
            return this.avatars_;
        }

        public List<? extends Common.AvatarOrBuilder> getAvatarsOrBuilderList() {
            return (List) this.avatars_;
        }

        public int getAvatarsCount() {
            return this.avatars_.size();
        }

        public Common.Avatar getAvatars(int index) {
            return this.avatars_.get(index);
        }

        public Common.AvatarOrBuilder getAvatarsOrBuilder(int index) {
            return (Common.AvatarOrBuilder) this.avatars_.get(index);
        }

        public boolean hasAddExp() {
            return ((this.bitField0_ & 0x10) == 16);
        }

        public int getAddExp() {
            return this.addExp_;
        }

        public boolean hasWorShipTimes() {
            return ((this.bitField0_ & 0x20) == 32);
        }

        public int getWorShipTimes() {
            return this.worShipTimes_;
        }

        public boolean hasMaxWorShipTimes() {
            return ((this.bitField0_ & 0x40) == 64);
        }

        public int getMaxWorShipTimes() {
            return this.maxWorShipTimes_;
        }

        public boolean hasWorldLevelPro() {
            return ((this.bitField0_ & 0x80) == 128);
        }

        public int getWorldLevelPro() {
            return this.worldLevelPro_;
        }

        public boolean hasRank1StGuildName() {
            return ((this.bitField0_ & 0x100) == 256);
        }

        public String getRank1StGuildName() {
            Object ref = this.rank1StGuildName_;
            if (ref instanceof String)
                return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8())
                this.rank1StGuildName_ = s;
            return s;
        }

        public ByteString getRank1StGuildNameBytes() {
            Object ref = this.rank1StGuildName_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.rank1StGuildName_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasRank1StFight() {
            return ((this.bitField0_ & 0x200) == 512);
        }

        public int getRank1StFight() {
            return this.rank1StFight_;
        }

        private void initFields() {
            this.worldLevelId_ = "";
            this.worldLevelName_ = "";
            this.worldLevel_ = 0;
            this.worldUpLevel_ = 0;
            this.avatars_ = Collections.emptyList();
            this.addExp_ = 0;
            this.worShipTimes_ = 0;
            this.maxWorShipTimes_ = 0;
            this.worldLevelPro_ = 0;
            this.rank1StGuildName_ = "";
            this.rank1StFight_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1)
                return true;
            if (isInitialized == 0)
                return false;
            if (!hasWorldLevelId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasWorldLevelName()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasWorldLevel()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasWorldUpLevel()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasAddExp()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasWorShipTimes()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasMaxWorShipTimes()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasWorldLevelPro()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (int i = 0; i < getAvatarsCount(); i++) {
                if (!getAvatars(i).isInitialized()) {
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
                output.writeBytes(1, getWorldLevelIdBytes());
            if ((this.bitField0_ & 0x2) == 2)
                output.writeBytes(2, getWorldLevelNameBytes());
            if ((this.bitField0_ & 0x4) == 4)
                output.writeInt32(3, this.worldLevel_);
            if ((this.bitField0_ & 0x8) == 8)
                output.writeInt32(4, this.worldUpLevel_);
            for (int i = 0; i < this.avatars_.size(); i++)
                output.writeMessage(5, (MessageLite) this.avatars_.get(i));
            if ((this.bitField0_ & 0x10) == 16)
                output.writeInt32(6, this.addExp_);
            if ((this.bitField0_ & 0x20) == 32)
                output.writeInt32(7, this.worShipTimes_);
            if ((this.bitField0_ & 0x40) == 64)
                output.writeInt32(8, this.maxWorShipTimes_);
            if ((this.bitField0_ & 0x80) == 128)
                output.writeInt32(9, this.worldLevelPro_);
            if ((this.bitField0_ & 0x100) == 256)
                output.writeBytes(10, getRank1StGuildNameBytes());
            if ((this.bitField0_ & 0x200) == 512)
                output.writeInt32(11, this.rank1StFight_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1)
                return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1)
                size += CodedOutputStream.computeBytesSize(1, getWorldLevelIdBytes());
            if ((this.bitField0_ & 0x2) == 2)
                size += CodedOutputStream.computeBytesSize(2, getWorldLevelNameBytes());
            if ((this.bitField0_ & 0x4) == 4)
                size += CodedOutputStream.computeInt32Size(3, this.worldLevel_);
            if ((this.bitField0_ & 0x8) == 8)
                size += CodedOutputStream.computeInt32Size(4, this.worldUpLevel_);
            for (int i = 0; i < this.avatars_.size(); i++)
                size += CodedOutputStream.computeMessageSize(5, (MessageLite) this.avatars_.get(i));
            if ((this.bitField0_ & 0x10) == 16)
                size += CodedOutputStream.computeInt32Size(6, this.addExp_);
            if ((this.bitField0_ & 0x20) == 32)
                size += CodedOutputStream.computeInt32Size(7, this.worShipTimes_);
            if ((this.bitField0_ & 0x40) == 64)
                size += CodedOutputStream.computeInt32Size(8, this.maxWorShipTimes_);
            if ((this.bitField0_ & 0x80) == 128)
                size += CodedOutputStream.computeInt32Size(9, this.worldLevelPro_);
            if ((this.bitField0_ & 0x100) == 256)
                size += CodedOutputStream.computeBytesSize(10, getRank1StGuildNameBytes());
            if ((this.bitField0_ & 0x200) == 512)
                size += CodedOutputStream.computeInt32Size(11, this.rank1StFight_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static WorldLevelInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (WorldLevelInfo) PARSER.parseFrom(data);
        }

        public static WorldLevelInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (WorldLevelInfo) PARSER.parseFrom(data, extensionRegistry);
        }

        public static WorldLevelInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (WorldLevelInfo) PARSER.parseFrom(data);
        }

        public static WorldLevelInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (WorldLevelInfo) PARSER.parseFrom(data, extensionRegistry);
        }

        public static WorldLevelInfo parseFrom(InputStream input) throws IOException {
            return (WorldLevelInfo) PARSER.parseFrom(input);
        }

        public static WorldLevelInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WorldLevelInfo) PARSER.parseFrom(input, extensionRegistry);
        }

        public static WorldLevelInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (WorldLevelInfo) PARSER.parseDelimitedFrom(input);
        }

        public static WorldLevelInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WorldLevelInfo) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static WorldLevelInfo parseFrom(CodedInputStream input) throws IOException {
            return (WorldLevelInfo) PARSER.parseFrom(input);
        }

        public static WorldLevelInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WorldLevelInfo) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(WorldLevelInfo prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements LeaderBoardHandler.WorldLevelInfoOrBuilder {
            private int bitField0_;
            private Object worldLevelId_;
            private Object worldLevelName_;
            private int worldLevel_;
            private int worldUpLevel_;
            private List<Common.Avatar> avatars_;
            private RepeatedFieldBuilder<Common.Avatar, Common.Avatar.Builder, Common.AvatarOrBuilder> avatarsBuilder_;
            private int addExp_;
            private int worShipTimes_;
            private int maxWorShipTimes_;
            private int worldLevelPro_;
            private Object rank1StGuildName_;
            private int rank1StFight_;

            public static final Descriptors.Descriptor getDescriptor() {
                return LeaderBoardHandler.internal_static_pomelo_area_WorldLevelInfo_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return LeaderBoardHandler.internal_static_pomelo_area_WorldLevelInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(LeaderBoardHandler.WorldLevelInfo.class, Builder.class);
            }

            private Builder() {
                this.worldLevelId_ = "";
                this.worldLevelName_ = "";
                this.avatars_ = Collections.emptyList();
                this.rank1StGuildName_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.worldLevelId_ = "";
                this.worldLevelName_ = "";
                this.avatars_ = Collections.emptyList();
                this.rank1StGuildName_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (LeaderBoardHandler.WorldLevelInfo.alwaysUseFieldBuilders)
                    getAvatarsFieldBuilder();
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.worldLevelId_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                this.worldLevelName_ = "";
                this.bitField0_ &= 0xFFFFFFFD;
                this.worldLevel_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.worldUpLevel_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                if (this.avatarsBuilder_ == null) {
                    this.avatars_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFEF;
                } else {
                    this.avatarsBuilder_.clear();
                }
                this.addExp_ = 0;
                this.bitField0_ &= 0xFFFFFFDF;
                this.worShipTimes_ = 0;
                this.bitField0_ &= 0xFFFFFFBF;
                this.maxWorShipTimes_ = 0;
                this.bitField0_ &= 0xFFFFFF7F;
                this.worldLevelPro_ = 0;
                this.bitField0_ &= 0xFFFFFEFF;
                this.rank1StGuildName_ = "";
                this.bitField0_ &= 0xFFFFFDFF;
                this.rank1StFight_ = 0;
                this.bitField0_ &= 0xFFFFFBFF;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return LeaderBoardHandler.internal_static_pomelo_area_WorldLevelInfo_descriptor;
            }

            public LeaderBoardHandler.WorldLevelInfo getDefaultInstanceForType() {
                return LeaderBoardHandler.WorldLevelInfo.getDefaultInstance();
            }

            public LeaderBoardHandler.WorldLevelInfo build() {
                LeaderBoardHandler.WorldLevelInfo result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public LeaderBoardHandler.WorldLevelInfo buildPartial() {
                LeaderBoardHandler.WorldLevelInfo result = new LeaderBoardHandler.WorldLevelInfo(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.worldLevelId_ = this.worldLevelId_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.worldLevelName_ = this.worldLevelName_;
                if ((from_bitField0_ & 0x4) == 4)
                    to_bitField0_ |= 0x4;
                result.worldLevel_ = this.worldLevel_;
                if ((from_bitField0_ & 0x8) == 8)
                    to_bitField0_ |= 0x8;
                result.worldUpLevel_ = this.worldUpLevel_;
                if (this.avatarsBuilder_ == null) {
                    if ((this.bitField0_ & 0x10) == 16) {
                        this.avatars_ = Collections.unmodifiableList(this.avatars_);
                        this.bitField0_ &= 0xFFFFFFEF;
                    }
                    result.avatars_ = this.avatars_;
                } else {
                    result.avatars_ = this.avatarsBuilder_.build();
                }
                if ((from_bitField0_ & 0x20) == 32)
                    to_bitField0_ |= 0x10;
                result.addExp_ = this.addExp_;
                if ((from_bitField0_ & 0x40) == 64)
                    to_bitField0_ |= 0x20;
                result.worShipTimes_ = this.worShipTimes_;
                if ((from_bitField0_ & 0x80) == 128)
                    to_bitField0_ |= 0x40;
                result.maxWorShipTimes_ = this.maxWorShipTimes_;
                if ((from_bitField0_ & 0x100) == 256)
                    to_bitField0_ |= 0x80;
                result.worldLevelPro_ = this.worldLevelPro_;
                if ((from_bitField0_ & 0x200) == 512)
                    to_bitField0_ |= 0x100;
                result.rank1StGuildName_ = this.rank1StGuildName_;
                if ((from_bitField0_ & 0x400) == 1024)
                    to_bitField0_ |= 0x200;
                result.rank1StFight_ = this.rank1StFight_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof LeaderBoardHandler.WorldLevelInfo)
                    return mergeFrom((LeaderBoardHandler.WorldLevelInfo) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(LeaderBoardHandler.WorldLevelInfo other) {
                if (other == LeaderBoardHandler.WorldLevelInfo.getDefaultInstance())
                    return this;
                if (other.hasWorldLevelId()) {
                    this.bitField0_ |= 0x1;
                    this.worldLevelId_ = other.worldLevelId_;
                    onChanged();
                }
                if (other.hasWorldLevelName()) {
                    this.bitField0_ |= 0x2;
                    this.worldLevelName_ = other.worldLevelName_;
                    onChanged();
                }
                if (other.hasWorldLevel())
                    setWorldLevel(other.getWorldLevel());
                if (other.hasWorldUpLevel())
                    setWorldUpLevel(other.getWorldUpLevel());
                if (this.avatarsBuilder_ == null) {
                    if (!other.avatars_.isEmpty()) {
                        if (this.avatars_.isEmpty()) {
                            this.avatars_ = other.avatars_;
                            this.bitField0_ &= 0xFFFFFFEF;
                        } else {
                            ensureAvatarsIsMutable();
                            this.avatars_.addAll(other.avatars_);
                        }
                        onChanged();
                    }
                } else if (!other.avatars_.isEmpty()) {
                    if (this.avatarsBuilder_.isEmpty()) {
                        this.avatarsBuilder_.dispose();
                        this.avatarsBuilder_ = null;
                        this.avatars_ = other.avatars_;
                        this.bitField0_ &= 0xFFFFFFEF;
                        this.avatarsBuilder_ = LeaderBoardHandler.WorldLevelInfo.alwaysUseFieldBuilders ? getAvatarsFieldBuilder() : null;
                    } else {
                        this.avatarsBuilder_.addAllMessages(other.avatars_);
                    }
                }
                if (other.hasAddExp())
                    setAddExp(other.getAddExp());
                if (other.hasWorShipTimes())
                    setWorShipTimes(other.getWorShipTimes());
                if (other.hasMaxWorShipTimes())
                    setMaxWorShipTimes(other.getMaxWorShipTimes());
                if (other.hasWorldLevelPro())
                    setWorldLevelPro(other.getWorldLevelPro());
                if (other.hasRank1StGuildName()) {
                    this.bitField0_ |= 0x200;
                    this.rank1StGuildName_ = other.rank1StGuildName_;
                    onChanged();
                }
                if (other.hasRank1StFight())
                    setRank1StFight(other.getRank1StFight());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasWorldLevelId())
                    return false;
                if (!hasWorldLevelName())
                    return false;
                if (!hasWorldLevel())
                    return false;
                if (!hasWorldUpLevel())
                    return false;
                if (!hasAddExp())
                    return false;
                if (!hasWorShipTimes())
                    return false;
                if (!hasMaxWorShipTimes())
                    return false;
                if (!hasWorldLevelPro())
                    return false;
                for (int i = 0; i < getAvatarsCount(); i++) {
                    if (!getAvatars(i).isInitialized())
                        return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                LeaderBoardHandler.WorldLevelInfo parsedMessage = null;
                try {
                    parsedMessage = (LeaderBoardHandler.WorldLevelInfo) LeaderBoardHandler.WorldLevelInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (LeaderBoardHandler.WorldLevelInfo) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null)
                        mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasWorldLevelId() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public String getWorldLevelId() {
                Object ref = this.worldLevelId_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.worldLevelId_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getWorldLevelIdBytes() {
                Object ref = this.worldLevelId_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.worldLevelId_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setWorldLevelId(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.worldLevelId_ = value;
                onChanged();
                return this;
            }

            public Builder clearWorldLevelId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.worldLevelId_ = LeaderBoardHandler.WorldLevelInfo.getDefaultInstance().getWorldLevelId();
                onChanged();
                return this;
            }

            public Builder setWorldLevelIdBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.worldLevelId_ = value;
                onChanged();
                return this;
            }

            public boolean hasWorldLevelName() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public String getWorldLevelName() {
                Object ref = this.worldLevelName_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.worldLevelName_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getWorldLevelNameBytes() {
                Object ref = this.worldLevelName_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.worldLevelName_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setWorldLevelName(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x2;
                this.worldLevelName_ = value;
                onChanged();
                return this;
            }

            public Builder clearWorldLevelName() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.worldLevelName_ = LeaderBoardHandler.WorldLevelInfo.getDefaultInstance().getWorldLevelName();
                onChanged();
                return this;
            }

            public Builder setWorldLevelNameBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x2;
                this.worldLevelName_ = value;
                onChanged();
                return this;
            }

            public boolean hasWorldLevel() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public int getWorldLevel() {
                return this.worldLevel_;
            }

            public Builder setWorldLevel(int value) {
                this.bitField0_ |= 0x4;
                this.worldLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearWorldLevel() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.worldLevel_ = 0;
                onChanged();
                return this;
            }

            public boolean hasWorldUpLevel() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public int getWorldUpLevel() {
                return this.worldUpLevel_;
            }

            public Builder setWorldUpLevel(int value) {
                this.bitField0_ |= 0x8;
                this.worldUpLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearWorldUpLevel() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.worldUpLevel_ = 0;
                onChanged();
                return this;
            }

            private void ensureAvatarsIsMutable() {
                if ((this.bitField0_ & 0x10) != 16) {
                    this.avatars_ = new ArrayList<>(this.avatars_);
                    this.bitField0_ |= 0x10;
                }
            }

            public List<Common.Avatar> getAvatarsList() {
                if (this.avatarsBuilder_ == null)
                    return Collections.unmodifiableList(this.avatars_);
                return this.avatarsBuilder_.getMessageList();
            }

            public int getAvatarsCount() {
                if (this.avatarsBuilder_ == null)
                    return this.avatars_.size();
                return this.avatarsBuilder_.getCount();
            }

            public Common.Avatar getAvatars(int index) {
                if (this.avatarsBuilder_ == null)
                    return this.avatars_.get(index);
                return (Common.Avatar) this.avatarsBuilder_.getMessage(index);
            }

            public Builder setAvatars(int index, Common.Avatar value) {
                if (this.avatarsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureAvatarsIsMutable();
                    this.avatars_.set(index, value);
                    onChanged();
                } else {
                    this.avatarsBuilder_.setMessage(index, (GeneratedMessage) value);
                }
                return this;
            }

            public Builder setAvatars(int index, Common.Avatar.Builder builderForValue) {
                if (this.avatarsBuilder_ == null) {
                    ensureAvatarsIsMutable();
                    this.avatars_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.avatarsBuilder_.setMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addAvatars(Common.Avatar value) {
                if (this.avatarsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureAvatarsIsMutable();
                    this.avatars_.add(value);
                    onChanged();
                } else {
                    this.avatarsBuilder_.addMessage((GeneratedMessage) value);
                }
                return this;
            }

            public Builder addAvatars(int index, Common.Avatar value) {
                if (this.avatarsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureAvatarsIsMutable();
                    this.avatars_.add(index, value);
                    onChanged();
                } else {
                    this.avatarsBuilder_.addMessage(index, (GeneratedMessage) value);
                }
                return this;
            }

            public Builder addAvatars(Common.Avatar.Builder builderForValue) {
                if (this.avatarsBuilder_ == null) {
                    ensureAvatarsIsMutable();
                    this.avatars_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.avatarsBuilder_.addMessage((GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addAvatars(int index, Common.Avatar.Builder builderForValue) {
                if (this.avatarsBuilder_ == null) {
                    ensureAvatarsIsMutable();
                    this.avatars_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.avatarsBuilder_.addMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addAllAvatars(Iterable<? extends Common.Avatar> values) {
                if (this.avatarsBuilder_ == null) {
                    ensureAvatarsIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.avatars_);
                    onChanged();
                } else {
                    this.avatarsBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearAvatars() {
                if (this.avatarsBuilder_ == null) {
                    this.avatars_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFEF;
                    onChanged();
                } else {
                    this.avatarsBuilder_.clear();
                }
                return this;
            }

            public Builder removeAvatars(int index) {
                if (this.avatarsBuilder_ == null) {
                    ensureAvatarsIsMutable();
                    this.avatars_.remove(index);
                    onChanged();
                } else {
                    this.avatarsBuilder_.remove(index);
                }
                return this;
            }

            public Common.Avatar.Builder getAvatarsBuilder(int index) {
                return (Common.Avatar.Builder) getAvatarsFieldBuilder().getBuilder(index);
            }

            public Common.AvatarOrBuilder getAvatarsOrBuilder(int index) {
                if (this.avatarsBuilder_ == null)
                    return (Common.AvatarOrBuilder) this.avatars_.get(index);
                return (Common.AvatarOrBuilder) this.avatarsBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends Common.AvatarOrBuilder> getAvatarsOrBuilderList() {
                if (this.avatarsBuilder_ != null)
                    return this.avatarsBuilder_.getMessageOrBuilderList();
                return (List) Collections.unmodifiableList(this.avatars_);
            }

            public Common.Avatar.Builder addAvatarsBuilder() {
                return (Common.Avatar.Builder) getAvatarsFieldBuilder().addBuilder((GeneratedMessage) Common.Avatar.getDefaultInstance());
            }

            public Common.Avatar.Builder addAvatarsBuilder(int index) {
                return (Common.Avatar.Builder) getAvatarsFieldBuilder().addBuilder(index, (GeneratedMessage) Common.Avatar.getDefaultInstance());
            }

            public List<Common.Avatar.Builder> getAvatarsBuilderList() {
                return getAvatarsFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<Common.Avatar, Common.Avatar.Builder, Common.AvatarOrBuilder> getAvatarsFieldBuilder() {
                if (this.avatarsBuilder_ == null) {
                    this.avatarsBuilder_ = new RepeatedFieldBuilder(this.avatars_, ((this.bitField0_ & 0x10) == 16), getParentForChildren(), isClean());
                    this.avatars_ = null;
                }
                return this.avatarsBuilder_;
            }

            public boolean hasAddExp() {
                return ((this.bitField0_ & 0x20) == 32);
            }

            public int getAddExp() {
                return this.addExp_;
            }

            public Builder setAddExp(int value) {
                this.bitField0_ |= 0x20;
                this.addExp_ = value;
                onChanged();
                return this;
            }

            public Builder clearAddExp() {
                this.bitField0_ &= 0xFFFFFFDF;
                this.addExp_ = 0;
                onChanged();
                return this;
            }

            public boolean hasWorShipTimes() {
                return ((this.bitField0_ & 0x40) == 64);
            }

            public int getWorShipTimes() {
                return this.worShipTimes_;
            }

            public Builder setWorShipTimes(int value) {
                this.bitField0_ |= 0x40;
                this.worShipTimes_ = value;
                onChanged();
                return this;
            }

            public Builder clearWorShipTimes() {
                this.bitField0_ &= 0xFFFFFFBF;
                this.worShipTimes_ = 0;
                onChanged();
                return this;
            }

            public boolean hasMaxWorShipTimes() {
                return ((this.bitField0_ & 0x80) == 128);
            }

            public int getMaxWorShipTimes() {
                return this.maxWorShipTimes_;
            }

            public Builder setMaxWorShipTimes(int value) {
                this.bitField0_ |= 0x80;
                this.maxWorShipTimes_ = value;
                onChanged();
                return this;
            }

            public Builder clearMaxWorShipTimes() {
                this.bitField0_ &= 0xFFFFFF7F;
                this.maxWorShipTimes_ = 0;
                onChanged();
                return this;
            }

            public boolean hasWorldLevelPro() {
                return ((this.bitField0_ & 0x100) == 256);
            }

            public int getWorldLevelPro() {
                return this.worldLevelPro_;
            }

            public Builder setWorldLevelPro(int value) {
                this.bitField0_ |= 0x100;
                this.worldLevelPro_ = value;
                onChanged();
                return this;
            }

            public Builder clearWorldLevelPro() {
                this.bitField0_ &= 0xFFFFFEFF;
                this.worldLevelPro_ = 0;
                onChanged();
                return this;
            }

            public boolean hasRank1StGuildName() {
                return ((this.bitField0_ & 0x200) == 512);
            }

            public String getRank1StGuildName() {
                Object ref = this.rank1StGuildName_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.rank1StGuildName_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getRank1StGuildNameBytes() {
                Object ref = this.rank1StGuildName_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.rank1StGuildName_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setRank1StGuildName(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x200;
                this.rank1StGuildName_ = value;
                onChanged();
                return this;
            }

            public Builder clearRank1StGuildName() {
                this.bitField0_ &= 0xFFFFFDFF;
                this.rank1StGuildName_ = LeaderBoardHandler.WorldLevelInfo.getDefaultInstance().getRank1StGuildName();
                onChanged();
                return this;
            }

            public Builder setRank1StGuildNameBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x200;
                this.rank1StGuildName_ = value;
                onChanged();
                return this;
            }

            public boolean hasRank1StFight() {
                return ((this.bitField0_ & 0x400) == 1024);
            }

            public int getRank1StFight() {
                return this.rank1StFight_;
            }

            public Builder setRank1StFight(int value) {
                this.bitField0_ |= 0x400;
                this.rank1StFight_ = value;
                onChanged();
                return this;
            }

            public Builder clearRank1StFight() {
                this.bitField0_ &= 0xFFFFFBFF;
                this.rank1StFight_ = 0;
                onChanged();
                return this;
            }
        }
    }

    public static final class WorldLevelInfoResponse extends GeneratedMessage implements WorldLevelInfoResponseOrBuilder {
        private static final WorldLevelInfoResponse defaultInstance = new WorldLevelInfoResponse(true);
        private final UnknownFieldSet unknownFields;

        private WorldLevelInfoResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private WorldLevelInfoResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static WorldLevelInfoResponse getDefaultInstance() {
            return defaultInstance;
        }

        public WorldLevelInfoResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private WorldLevelInfoResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString bs;
                    LeaderBoardHandler.WorldLevelInfo.Builder subBuilder;
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
                            if ((this.bitField0_ & 0x4) == 4) subBuilder = this.s2CData_.toBuilder();
                            this.s2CData_ = (LeaderBoardHandler.WorldLevelInfo) input.readMessage(LeaderBoardHandler.WorldLevelInfo.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.s2CData_);
                                this.s2CData_ = subBuilder.buildPartial();
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
            return LeaderBoardHandler.internal_static_pomelo_area_WorldLevelInfoResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return LeaderBoardHandler.internal_static_pomelo_area_WorldLevelInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(WorldLevelInfoResponse.class, Builder.class);
        }

        public static Parser<WorldLevelInfoResponse> PARSER = (Parser<WorldLevelInfoResponse>) new AbstractParser<WorldLevelInfoResponse>() {
            public LeaderBoardHandler.WorldLevelInfoResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new LeaderBoardHandler.WorldLevelInfoResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_DATA_FIELD_NUMBER = 3;
        private LeaderBoardHandler.WorldLevelInfo s2CData_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<WorldLevelInfoResponse> getParserForType() {
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

        public boolean hasS2CData() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public LeaderBoardHandler.WorldLevelInfo getS2CData() {
            return this.s2CData_;
        }

        public LeaderBoardHandler.WorldLevelInfoOrBuilder getS2CDataOrBuilder() {
            return this.s2CData_;
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CData_ = LeaderBoardHandler.WorldLevelInfo.getDefaultInstance();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasS2CCode()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasS2CData()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!getS2CData().isInitialized()) {
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
            if ((this.bitField0_ & 0x4) == 4) output.writeMessage(3, (MessageLite) this.s2CData_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());
            if ((this.bitField0_ & 0x4) == 4)
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.s2CData_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static WorldLevelInfoResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (WorldLevelInfoResponse) PARSER.parseFrom(data);
        }

        public static WorldLevelInfoResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (WorldLevelInfoResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static WorldLevelInfoResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (WorldLevelInfoResponse) PARSER.parseFrom(data);
        }

        public static WorldLevelInfoResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (WorldLevelInfoResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static WorldLevelInfoResponse parseFrom(InputStream input) throws IOException {
            return (WorldLevelInfoResponse) PARSER.parseFrom(input);
        }

        public static WorldLevelInfoResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WorldLevelInfoResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static WorldLevelInfoResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (WorldLevelInfoResponse) PARSER.parseDelimitedFrom(input);
        }

        public static WorldLevelInfoResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WorldLevelInfoResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static WorldLevelInfoResponse parseFrom(CodedInputStream input) throws IOException {
            return (WorldLevelInfoResponse) PARSER.parseFrom(input);
        }

        public static WorldLevelInfoResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WorldLevelInfoResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(WorldLevelInfoResponse prototype) {
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

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements LeaderBoardHandler.WorldLevelInfoResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private LeaderBoardHandler.WorldLevelInfo s2CData_;
            private SingleFieldBuilder<LeaderBoardHandler.WorldLevelInfo, LeaderBoardHandler.WorldLevelInfo.Builder, LeaderBoardHandler.WorldLevelInfoOrBuilder> s2CDataBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return LeaderBoardHandler.internal_static_pomelo_area_WorldLevelInfoResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return LeaderBoardHandler.internal_static_pomelo_area_WorldLevelInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(LeaderBoardHandler.WorldLevelInfoResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.s2CData_ = LeaderBoardHandler.WorldLevelInfo.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CData_ = LeaderBoardHandler.WorldLevelInfo.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (LeaderBoardHandler.WorldLevelInfoResponse.alwaysUseFieldBuilders)
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
                    this.s2CData_ = LeaderBoardHandler.WorldLevelInfo.getDefaultInstance();
                } else {
                    this.s2CDataBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return LeaderBoardHandler.internal_static_pomelo_area_WorldLevelInfoResponse_descriptor;
            }

            public LeaderBoardHandler.WorldLevelInfoResponse getDefaultInstanceForType() {
                return LeaderBoardHandler.WorldLevelInfoResponse.getDefaultInstance();
            }

            public LeaderBoardHandler.WorldLevelInfoResponse build() {
                LeaderBoardHandler.WorldLevelInfoResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public LeaderBoardHandler.WorldLevelInfoResponse buildPartial() {
                LeaderBoardHandler.WorldLevelInfoResponse result = new LeaderBoardHandler.WorldLevelInfoResponse(this);
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
                if (this.s2CDataBuilder_ == null) {
                    result.s2CData_ = this.s2CData_;
                } else {
                    result.s2CData_ = (LeaderBoardHandler.WorldLevelInfo) this.s2CDataBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof LeaderBoardHandler.WorldLevelInfoResponse)
                    return mergeFrom((LeaderBoardHandler.WorldLevelInfoResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(LeaderBoardHandler.WorldLevelInfoResponse other) {
                if (other == LeaderBoardHandler.WorldLevelInfoResponse.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (other.hasS2CData())
                    mergeS2CData(other.getS2CData());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode())
                    return false;
                if (!hasS2CData())
                    return false;
                if (!getS2CData().isInitialized())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                LeaderBoardHandler.WorldLevelInfoResponse parsedMessage = null;
                try {
                    parsedMessage = (LeaderBoardHandler.WorldLevelInfoResponse) LeaderBoardHandler.WorldLevelInfoResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (LeaderBoardHandler.WorldLevelInfoResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = LeaderBoardHandler.WorldLevelInfoResponse.getDefaultInstance().getS2CMsg();
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

            public boolean hasS2CData() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public LeaderBoardHandler.WorldLevelInfo getS2CData() {
                if (this.s2CDataBuilder_ == null)
                    return this.s2CData_;
                return (LeaderBoardHandler.WorldLevelInfo) this.s2CDataBuilder_.getMessage();
            }

            public Builder setS2CData(LeaderBoardHandler.WorldLevelInfo value) {
                if (this.s2CDataBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    this.s2CData_ = value;
                    onChanged();
                } else {
                    this.s2CDataBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder setS2CData(LeaderBoardHandler.WorldLevelInfo.Builder builderForValue) {
                if (this.s2CDataBuilder_ == null) {
                    this.s2CData_ = builderForValue.build();
                    onChanged();
                } else {
                    this.s2CDataBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder mergeS2CData(LeaderBoardHandler.WorldLevelInfo value) {
                if (this.s2CDataBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4 && this.s2CData_ != LeaderBoardHandler.WorldLevelInfo.getDefaultInstance()) {
                        this.s2CData_ = LeaderBoardHandler.WorldLevelInfo.newBuilder(this.s2CData_).mergeFrom(value).buildPartial();
                    } else {
                        this.s2CData_ = value;
                    }
                    onChanged();
                } else {
                    this.s2CDataBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder clearS2CData() {
                if (this.s2CDataBuilder_ == null) {
                    this.s2CData_ = LeaderBoardHandler.WorldLevelInfo.getDefaultInstance();
                    onChanged();
                } else {
                    this.s2CDataBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public LeaderBoardHandler.WorldLevelInfo.Builder getS2CDataBuilder() {
                this.bitField0_ |= 0x4;
                onChanged();
                return (LeaderBoardHandler.WorldLevelInfo.Builder) getS2CDataFieldBuilder().getBuilder();
            }

            public LeaderBoardHandler.WorldLevelInfoOrBuilder getS2CDataOrBuilder() {
                if (this.s2CDataBuilder_ != null)
                    return (LeaderBoardHandler.WorldLevelInfoOrBuilder) this.s2CDataBuilder_.getMessageOrBuilder();
                return this.s2CData_;
            }

            private SingleFieldBuilder<LeaderBoardHandler.WorldLevelInfo, LeaderBoardHandler.WorldLevelInfo.Builder, LeaderBoardHandler.WorldLevelInfoOrBuilder> getS2CDataFieldBuilder() {
                if (this.s2CDataBuilder_ == null) {
                    this.s2CDataBuilder_ = new SingleFieldBuilder(getS2CData(), getParentForChildren(), isClean());
                    this.s2CData_ = null;
                }
                return this.s2CDataBuilder_;
            }
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }


    static {
        String[] descriptorData = {"\n\030leaderBoardHandler.proto\022\013pomelo.area\032\fcommon.proto\"D\n\017LeaderBoardData\022\020\n\bcontents\030\001 \003(\t\022\037\n\007avatars\030\002 \003(\0132\016.pomelo.Avatar\"¸\001\n\rRankGuildInfo\022\017\n\007guildId\030\001 \001(\t\022\021\n\tguildIcon\030\002 \001(\t\022\023\n\013guildMaster\030\003 \001(\t\022\022\n\nguildLevel\030\004 \001(\005\022\021\n\tcurMember\030\005 \001(\005\022\021\n\tmaxMember\030\006 \001(\005\022\f\n\004fund\030\007 \001(\005\022\016\n\006notice\030\b \001(\t\022\026\n\016guildMasterPro\030\t \001(\005\":\n\022LeaderBoardRequest\022\020\n\bc2s_kind\030\001 \002(\005\022\022\n\nc2s_season\030\002 \001(\005\"\001\n\023LeaderBoardResponse\022\020\n\bs2", "c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022/\n\ts2c_lists\030\003 \003(\0132\034.pomelo.area.LeaderBoardData\0220\n\ns2c_myData\030\004 \001(\0132\034.pomelo.area.LeaderBoardData\"'\n\020GuildInfoRequest\022\023\n\013c2s_guildId\030\001 \002(\t\"d\n\021GuildInfoResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022,\n\bs2c_data\030\003 \001(\0132\032.pomelo.area.RankGuildInfo\"\"\n\016WorShipRequest\022\020\n\bc2s_type\030\001 \002(\005\"H\n\017WorShipResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\022\n\ns2c_awards\030\003 \003(\t\"\027\n\025WorldLevelInfoR", "equest\"\002\n\016WorldLevelInfo\022\024\n\fworldLevelId\030\001 \002(\t\022\026\n\016worldLevelName\030\002 \002(\t\022\022\n\nworldLevel\030\003 \002(\005\022\024\n\fworldUpLevel\030\004 \002(\005\022\037\n\007avatars\030\005 \003(\0132\016.pomelo.Avatar\022\016\n\006addExp\030\006 \002(\005\022\024\n\fworShipTimes\030\007 \002(\005\022\027\n\017maxWorShipTimes\030\b \002(\005\022\025\n\rworldLevelPro\030\t \002(\005\022\030\n\020rank1stGuildName\030\n \001(\t\022\024\n\frank1stFight\030\013 \001(\005\"j\n\026WorldLevelInfoResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022-\n\bs2c_data\030\003 \002(\0132\033.pomelo.area.WorldLevelInfo2ï\002\n\022leaderB", "oardHandler\022W\n\022leaderBoardRequest\022\037.pomelo.area.LeaderBoardRequest\032 .pomelo.area.LeaderBoardResponse\022Q\n\020guildInfoRequest\022\035.pomelo.area.GuildInfoRequest\032\036.pomelo.area.GuildInfoResponse\022K\n\016worShipRequest\022\033.pomelo.area.WorShipRequest\032\034.pomelo.area.WorShipResponse\022`\n\025worldLevelInfoRequest\022\".pomelo.area.WorldLevelInfoRequest\032#.pomelo.area.WorldLevelInfoResponse"};


        Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root) {
                LeaderBoardHandler.descriptor = root;
                return null;
            }
        };

        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[]{

                Common.getDescriptor()}, assigner);
    }

    private static final Descriptors.Descriptor internal_static_pomelo_area_LeaderBoardData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_LeaderBoardData_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_LeaderBoardData_descriptor, new String[]{"Contents", "Avatars"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_RankGuildInfo_descriptor = getDescriptor().getMessageTypes().get(1);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_RankGuildInfo_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_RankGuildInfo_descriptor, new String[]{"GuildId", "GuildIcon", "GuildMaster", "GuildLevel", "CurMember", "MaxMember", "Fund", "Notice", "GuildMasterPro"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_LeaderBoardRequest_descriptor = getDescriptor().getMessageTypes().get(2);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_LeaderBoardRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_LeaderBoardRequest_descriptor, new String[]{"C2SKind", "C2SSeason"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_LeaderBoardResponse_descriptor = getDescriptor().getMessageTypes().get(3);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_LeaderBoardResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_LeaderBoardResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CLists", "S2CMyData"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GuildInfoRequest_descriptor = getDescriptor().getMessageTypes().get(4);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GuildInfoRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GuildInfoRequest_descriptor, new String[]{"C2SGuildId"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GuildInfoResponse_descriptor = getDescriptor().getMessageTypes().get(5);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GuildInfoResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GuildInfoResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CData"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_WorShipRequest_descriptor = getDescriptor().getMessageTypes().get(6);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_WorShipRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_WorShipRequest_descriptor, new String[]{"C2SType"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_WorShipResponse_descriptor = getDescriptor().getMessageTypes().get(7);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_WorShipResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_WorShipResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CAwards"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_WorldLevelInfoRequest_descriptor = getDescriptor().getMessageTypes().get(8);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_WorldLevelInfoRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_WorldLevelInfoRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_area_WorldLevelInfo_descriptor = getDescriptor().getMessageTypes().get(9);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_WorldLevelInfo_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_WorldLevelInfo_descriptor, new String[]{"WorldLevelId", "WorldLevelName", "WorldLevel", "WorldUpLevel", "Avatars", "AddExp", "WorShipTimes", "MaxWorShipTimes", "WorldLevelPro", "Rank1StGuildName", "Rank1StFight"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_WorldLevelInfoResponse_descriptor = getDescriptor().getMessageTypes().get(10);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_WorldLevelInfoResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_WorldLevelInfoResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CData"});
    private static Descriptors.FileDescriptor descriptor;

    static {
        Common.getDescriptor();
    }

    public static interface WorldLevelInfoResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasS2CData();

        LeaderBoardHandler.WorldLevelInfo getS2CData();

        LeaderBoardHandler.WorldLevelInfoOrBuilder getS2CDataOrBuilder();
    }

    public static interface WorldLevelInfoOrBuilder extends MessageOrBuilder {
        boolean hasWorldLevelId();

        String getWorldLevelId();

        ByteString getWorldLevelIdBytes();

        boolean hasWorldLevelName();

        String getWorldLevelName();

        ByteString getWorldLevelNameBytes();

        boolean hasWorldLevel();

        int getWorldLevel();

        boolean hasWorldUpLevel();

        int getWorldUpLevel();

        List<Common.Avatar> getAvatarsList();

        Common.Avatar getAvatars(int param1Int);

        int getAvatarsCount();

        List<? extends Common.AvatarOrBuilder> getAvatarsOrBuilderList();

        Common.AvatarOrBuilder getAvatarsOrBuilder(int param1Int);

        boolean hasAddExp();

        int getAddExp();

        boolean hasWorShipTimes();

        int getWorShipTimes();

        boolean hasMaxWorShipTimes();

        int getMaxWorShipTimes();

        boolean hasWorldLevelPro();

        int getWorldLevelPro();

        boolean hasRank1StGuildName();

        String getRank1StGuildName();

        ByteString getRank1StGuildNameBytes();

        boolean hasRank1StFight();

        int getRank1StFight();
    }

    public static interface WorldLevelInfoRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface WorShipResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        ProtocolStringList getS2CAwardsList();

        int getS2CAwardsCount();

        String getS2CAwards(int param1Int);

        ByteString getS2CAwardsBytes(int param1Int);
    }

    public static interface WorShipRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2SType();

        int getC2SType();
    }

    public static interface GuildInfoResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasS2CData();

        LeaderBoardHandler.RankGuildInfo getS2CData();

        LeaderBoardHandler.RankGuildInfoOrBuilder getS2CDataOrBuilder();
    }

    public static interface GuildInfoRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2SGuildId();

        String getC2SGuildId();

        ByteString getC2SGuildIdBytes();
    }

    public static interface LeaderBoardResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        List<LeaderBoardHandler.LeaderBoardData> getS2CListsList();

        LeaderBoardHandler.LeaderBoardData getS2CLists(int param1Int);

        int getS2CListsCount();

        List<? extends LeaderBoardHandler.LeaderBoardDataOrBuilder> getS2CListsOrBuilderList();

        LeaderBoardHandler.LeaderBoardDataOrBuilder getS2CListsOrBuilder(int param1Int);

        boolean hasS2CMyData();

        LeaderBoardHandler.LeaderBoardData getS2CMyData();

        LeaderBoardHandler.LeaderBoardDataOrBuilder getS2CMyDataOrBuilder();
    }

    public static interface LeaderBoardRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2SKind();

        int getC2SKind();

        boolean hasC2SSeason();

        int getC2SSeason();
    }

    public static interface RankGuildInfoOrBuilder extends MessageOrBuilder {
        boolean hasGuildId();

        String getGuildId();

        ByteString getGuildIdBytes();

        boolean hasGuildIcon();

        String getGuildIcon();

        ByteString getGuildIconBytes();

        boolean hasGuildMaster();

        String getGuildMaster();

        ByteString getGuildMasterBytes();

        boolean hasGuildLevel();

        int getGuildLevel();

        boolean hasCurMember();

        int getCurMember();

        boolean hasMaxMember();

        int getMaxMember();

        boolean hasFund();

        int getFund();

        boolean hasNotice();

        String getNotice();

        ByteString getNoticeBytes();

        boolean hasGuildMasterPro();

        int getGuildMasterPro();
    }

    public static interface LeaderBoardDataOrBuilder extends MessageOrBuilder {
        ProtocolStringList getContentsList();

        int getContentsCount();

        String getContents(int param1Int);

        ByteString getContentsBytes(int param1Int);

        List<Common.Avatar> getAvatarsList();

        Common.Avatar getAvatars(int param1Int);

        int getAvatarsCount();

        List<? extends Common.AvatarOrBuilder> getAvatarsOrBuilderList();

        Common.AvatarOrBuilder getAvatarsOrBuilder(int param1Int);
    }
}


