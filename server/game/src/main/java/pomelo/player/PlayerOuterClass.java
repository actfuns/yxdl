package pomelo.player;

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
import pomelo.item.ItemOuterClass;
import pomelo.task.TaskOuterClass;


public final class PlayerOuterClass {
    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static final class PlayerBasic
            extends GeneratedMessage
            implements PlayerBasicOrBuilder {
        private static final PlayerBasic defaultInstance = new PlayerBasic(true);
        private final UnknownFieldSet unknownFields;

        private PlayerBasic(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private PlayerBasic(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static PlayerBasic getDefaultInstance() {
            return defaultInstance;
        }

        public PlayerBasic getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PlayerBasic(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        case 18:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x2;
                            this.name_ = bs;
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.level_ = input.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.pro_ = input.readInt32();
                            break;
                        case 40:
                            this.bitField0_ |= 0x10;
                            this.upLevel_ = input.readInt32();
                            break;
                        case 50:
                            if ((mutable_bitField0_ & 0x20) != 32) {
                                this.avatars_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x20;
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
                if ((mutable_bitField0_ & 0x20) == 32) this.avatars_ = Collections.unmodifiableList(this.avatars_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return PlayerOuterClass.internal_static_pomelo_player_PlayerBasic_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return PlayerOuterClass.internal_static_pomelo_player_PlayerBasic_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerBasic.class, Builder.class);
        }

        public static Parser<PlayerBasic> PARSER = (Parser<PlayerBasic>) new AbstractParser<PlayerBasic>() {
            public PlayerOuterClass.PlayerBasic parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PlayerOuterClass.PlayerBasic(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int ID_FIELD_NUMBER = 1;
        private Object id_;
        public static final int NAME_FIELD_NUMBER = 2;
        private Object name_;
        public static final int LEVEL_FIELD_NUMBER = 3;
        private int level_;
        public static final int PRO_FIELD_NUMBER = 4;
        private int pro_;
        public static final int UPLEVEL_FIELD_NUMBER = 5;
        private int upLevel_;
        public static final int AVATARS_FIELD_NUMBER = 6;
        private List<Common.Avatar> avatars_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<PlayerBasic> getParserForType() {
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

        public ByteString getNameBytes() {
            Object ref = this.name_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.name_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasLevel() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getLevel() {
            return this.level_;
        }

        public boolean hasPro() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public int getPro() {
            return this.pro_;
        }

        public boolean hasUpLevel() {
            return ((this.bitField0_ & 0x10) == 16);
        }

        public int getUpLevel() {
            return this.upLevel_;
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
            this.id_ = "";
            this.name_ = "";
            this.level_ = 0;
            this.pro_ = 0;
            this.upLevel_ = 0;
            this.avatars_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasId()) {
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
            if ((this.bitField0_ & 0x1) == 1) output.writeBytes(1, getIdBytes());
            if ((this.bitField0_ & 0x2) == 2) output.writeBytes(2, getNameBytes());
            if ((this.bitField0_ & 0x4) == 4) output.writeInt32(3, this.level_);
            if ((this.bitField0_ & 0x8) == 8) output.writeInt32(4, this.pro_);
            if ((this.bitField0_ & 0x10) == 16) output.writeInt32(5, this.upLevel_);
            for (int i = 0; i < this.avatars_.size(); i++) output.writeMessage(6, (MessageLite) this.avatars_.get(i));
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeBytesSize(1, getIdBytes());
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getNameBytes());
            if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeInt32Size(3, this.level_);
            if ((this.bitField0_ & 0x8) == 8) size += CodedOutputStream.computeInt32Size(4, this.pro_);
            if ((this.bitField0_ & 0x10) == 16) size += CodedOutputStream.computeInt32Size(5, this.upLevel_);
            for (int i = 0; i < this.avatars_.size(); i++)
                size += CodedOutputStream.computeMessageSize(6, (MessageLite) this.avatars_.get(i));
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static PlayerBasic parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (PlayerBasic) PARSER.parseFrom(data);
        }

        public static PlayerBasic parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (PlayerBasic) PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerBasic parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (PlayerBasic) PARSER.parseFrom(data);
        }

        public static PlayerBasic parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (PlayerBasic) PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerBasic parseFrom(InputStream input) throws IOException {
            return (PlayerBasic) PARSER.parseFrom(input);
        }

        public static PlayerBasic parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerBasic) PARSER.parseFrom(input, extensionRegistry);
        }

        public static PlayerBasic parseDelimitedFrom(InputStream input) throws IOException {
            return (PlayerBasic) PARSER.parseDelimitedFrom(input);
        }

        public static PlayerBasic parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerBasic) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static PlayerBasic parseFrom(CodedInputStream input) throws IOException {
            return (PlayerBasic) PARSER.parseFrom(input);
        }

        public static PlayerBasic parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerBasic) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(PlayerBasic prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements PlayerOuterClass.PlayerBasicOrBuilder {
            private int bitField0_;
            private Object id_;
            private Object name_;
            private int level_;
            private int pro_;
            private int upLevel_;
            private List<Common.Avatar> avatars_;
            private RepeatedFieldBuilder<Common.Avatar, Common.Avatar.Builder, Common.AvatarOrBuilder> avatarsBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PlayerOuterClass.internal_static_pomelo_player_PlayerBasic_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PlayerOuterClass.internal_static_pomelo_player_PlayerBasic_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerOuterClass.PlayerBasic.class, Builder.class);
            }

            private Builder() {
                this.id_ = "";
                this.name_ = "";
                this.avatars_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.id_ = "";
                this.name_ = "";
                this.avatars_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PlayerOuterClass.PlayerBasic.alwaysUseFieldBuilders) getAvatarsFieldBuilder();
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.id_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                this.name_ = "";
                this.bitField0_ &= 0xFFFFFFFD;
                this.level_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.pro_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                this.upLevel_ = 0;
                this.bitField0_ &= 0xFFFFFFEF;
                if (this.avatarsBuilder_ == null) {
                    this.avatars_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFDF;
                } else {
                    this.avatarsBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return PlayerOuterClass.internal_static_pomelo_player_PlayerBasic_descriptor;
            }

            public PlayerOuterClass.PlayerBasic getDefaultInstanceForType() {
                return PlayerOuterClass.PlayerBasic.getDefaultInstance();
            }

            public PlayerOuterClass.PlayerBasic build() {
                PlayerOuterClass.PlayerBasic result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public PlayerOuterClass.PlayerBasic buildPartial() {
                PlayerOuterClass.PlayerBasic result = new PlayerOuterClass.PlayerBasic(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.id_ = this.id_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.name_ = this.name_;
                if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;
                result.level_ = this.level_;
                if ((from_bitField0_ & 0x8) == 8) to_bitField0_ |= 0x8;
                result.pro_ = this.pro_;
                if ((from_bitField0_ & 0x10) == 16) to_bitField0_ |= 0x10;
                result.upLevel_ = this.upLevel_;
                if (this.avatarsBuilder_ == null) {
                    if ((this.bitField0_ & 0x20) == 32) {
                        this.avatars_ = Collections.unmodifiableList(this.avatars_);
                        this.bitField0_ &= 0xFFFFFFDF;
                    }
                    result.avatars_ = this.avatars_;
                } else {
                    result.avatars_ = this.avatarsBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof PlayerOuterClass.PlayerBasic)
                    return mergeFrom((PlayerOuterClass.PlayerBasic) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PlayerOuterClass.PlayerBasic other) {
                if (other == PlayerOuterClass.PlayerBasic.getDefaultInstance()) return this;
                if (other.hasId()) {
                    this.bitField0_ |= 0x1;
                    this.id_ = other.id_;
                    onChanged();
                }
                if (other.hasName()) {
                    this.bitField0_ |= 0x2;
                    this.name_ = other.name_;
                    onChanged();
                }
                if (other.hasLevel()) setLevel(other.getLevel());
                if (other.hasPro()) setPro(other.getPro());
                if (other.hasUpLevel()) setUpLevel(other.getUpLevel());
                if (this.avatarsBuilder_ == null) {
                    if (!other.avatars_.isEmpty()) {
                        if (this.avatars_.isEmpty()) {
                            this.avatars_ = other.avatars_;
                            this.bitField0_ &= 0xFFFFFFDF;
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
                        this.bitField0_ &= 0xFFFFFFDF;
                        this.avatarsBuilder_ = PlayerOuterClass.PlayerBasic.alwaysUseFieldBuilders ? getAvatarsFieldBuilder() : null;
                    } else {
                        this.avatarsBuilder_.addAllMessages(other.avatars_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasId()) return false;
                for (int i = 0; i < getAvatarsCount(); i++) {
                    if (!getAvatars(i).isInitialized()) return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                PlayerOuterClass.PlayerBasic parsedMessage = null;
                try {
                    parsedMessage = (PlayerOuterClass.PlayerBasic) PlayerOuterClass.PlayerBasic.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (PlayerOuterClass.PlayerBasic) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
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
                    if (bs.isValidUtf8()) this.id_ = s;
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
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.id_ = value;
                onChanged();
                return this;
            }

            public Builder clearId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.id_ = PlayerOuterClass.PlayerBasic.getDefaultInstance().getId();
                onChanged();
                return this;
            }

            public Builder setIdBytes(ByteString value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.id_ = value;
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
                    if (bs.isValidUtf8()) this.name_ = s;
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
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x2;
                this.name_ = value;
                onChanged();
                return this;
            }

            public Builder clearName() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.name_ = PlayerOuterClass.PlayerBasic.getDefaultInstance().getName();
                onChanged();
                return this;
            }

            public Builder setNameBytes(ByteString value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x2;
                this.name_ = value;
                onChanged();
                return this;
            }

            public boolean hasLevel() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public int getLevel() {
                return this.level_;
            }

            public Builder setLevel(int value) {
                this.bitField0_ |= 0x4;
                this.level_ = value;
                onChanged();
                return this;
            }

            public Builder clearLevel() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.level_ = 0;
                onChanged();
                return this;
            }

            public boolean hasPro() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public int getPro() {
                return this.pro_;
            }

            public Builder setPro(int value) {
                this.bitField0_ |= 0x8;
                this.pro_ = value;
                onChanged();
                return this;
            }

            public Builder clearPro() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.pro_ = 0;
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

            private void ensureAvatarsIsMutable() {
                if ((this.bitField0_ & 0x20) != 32) {
                    this.avatars_ = new ArrayList<>(this.avatars_);
                    this.bitField0_ |= 0x20;
                }
            }

            public List<Common.Avatar> getAvatarsList() {
                if (this.avatarsBuilder_ == null) return Collections.unmodifiableList(this.avatars_);
                return this.avatarsBuilder_.getMessageList();
            }

            public int getAvatarsCount() {
                if (this.avatarsBuilder_ == null) return this.avatars_.size();
                return this.avatarsBuilder_.getCount();
            }

            public Common.Avatar getAvatars(int index) {
                if (this.avatarsBuilder_ == null) return this.avatars_.get(index);
                return (Common.Avatar) this.avatarsBuilder_.getMessage(index);
            }

            public Builder setAvatars(int index, Common.Avatar value) {
                if (this.avatarsBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
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
                    if (value == null) throw new NullPointerException();
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
                    if (value == null) throw new NullPointerException();
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
                    this.bitField0_ &= 0xFFFFFFDF;
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
                if (this.avatarsBuilder_ == null) return (Common.AvatarOrBuilder) this.avatars_.get(index);
                return (Common.AvatarOrBuilder) this.avatarsBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends Common.AvatarOrBuilder> getAvatarsOrBuilderList() {
                if (this.avatarsBuilder_ != null) return this.avatarsBuilder_.getMessageOrBuilderList();
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
                    this.avatarsBuilder_ = new RepeatedFieldBuilder(this.avatars_, ((this.bitField0_ & 0x20) == 32), getParentForChildren(), isClean());
                    this.avatars_ = null;
                }
                return this.avatarsBuilder_;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class Store
            extends GeneratedMessage
            implements StoreOrBuilder {
        private static final Store defaultInstance = new Store(true);
        private final UnknownFieldSet unknownFields;

        private Store(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Store(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Store getDefaultInstance() {
            return defaultInstance;
        }

        public Store getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Store(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.bagGrids_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x1;
                            }
                            this.bagGrids_.add(input.readMessage(ItemOuterClass.Grid.PARSER, extensionRegistry));
                            break;
                        case 16:
                            this.bitField0_ |= 0x1;
                            this.bagGridCount_ = input.readInt32();
                            break;
                        case 24:
                            this.bitField0_ |= 0x2;
                            this.bagTotalCount_ = input.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 0x4;
                            this.type_ = input.readInt32();
                            break;
                        case 40:
                            this.bitField0_ |= 0x8;
                            this.gridPrice_ = input.readInt32();
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x1) == 1) this.bagGrids_ = Collections.unmodifiableList(this.bagGrids_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return PlayerOuterClass.internal_static_pomelo_player_Store_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return PlayerOuterClass.internal_static_pomelo_player_Store_fieldAccessorTable.ensureFieldAccessorsInitialized(Store.class, Builder.class);
        }

        public static Parser<Store> PARSER = (Parser<Store>) new AbstractParser<Store>() {
            public PlayerOuterClass.Store parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PlayerOuterClass.Store(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int BAGGRIDS_FIELD_NUMBER = 1;
        private List<ItemOuterClass.Grid> bagGrids_;
        public static final int BAGGRIDCOUNT_FIELD_NUMBER = 2;
        private int bagGridCount_;
        public static final int BAGTOTALCOUNT_FIELD_NUMBER = 3;
        private int bagTotalCount_;
        public static final int TYPE_FIELD_NUMBER = 4;
        private int type_;
        public static final int GRIDPRICE_FIELD_NUMBER = 5;
        private int gridPrice_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<Store> getParserForType() {
            return PARSER;
        }

        public List<ItemOuterClass.Grid> getBagGridsList() {
            return this.bagGrids_;
        }

        public List<? extends ItemOuterClass.GridOrBuilder> getBagGridsOrBuilderList() {
            return (List) this.bagGrids_;
        }

        public int getBagGridsCount() {
            return this.bagGrids_.size();
        }

        public ItemOuterClass.Grid getBagGrids(int index) {
            return this.bagGrids_.get(index);
        }

        public ItemOuterClass.GridOrBuilder getBagGridsOrBuilder(int index) {
            return (ItemOuterClass.GridOrBuilder) this.bagGrids_.get(index);
        }

        public boolean hasBagGridCount() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getBagGridCount() {
            return this.bagGridCount_;
        }

        public boolean hasBagTotalCount() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public int getBagTotalCount() {
            return this.bagTotalCount_;
        }

        public boolean hasType() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getType() {
            return this.type_;
        }

        public boolean hasGridPrice() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public int getGridPrice() {
            return this.gridPrice_;
        }

        private void initFields() {
            this.bagGrids_ = Collections.emptyList();
            this.bagGridCount_ = 0;
            this.bagTotalCount_ = 0;
            this.type_ = 0;
            this.gridPrice_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            for (int i = 0; i < getBagGridsCount(); i++) {
                if (!getBagGrids(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            for (int i = 0; i < this.bagGrids_.size(); i++) output.writeMessage(1, (MessageLite) this.bagGrids_.get(i));
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(2, this.bagGridCount_);
            if ((this.bitField0_ & 0x2) == 2) output.writeInt32(3, this.bagTotalCount_);
            if ((this.bitField0_ & 0x4) == 4) output.writeInt32(4, this.type_);
            if ((this.bitField0_ & 0x8) == 8) output.writeInt32(5, this.gridPrice_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            for (int i = 0; i < this.bagGrids_.size(); i++)
                size += CodedOutputStream.computeMessageSize(1, (MessageLite) this.bagGrids_.get(i));
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(2, this.bagGridCount_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(3, this.bagTotalCount_);
            if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeInt32Size(4, this.type_);
            if ((this.bitField0_ & 0x8) == 8) size += CodedOutputStream.computeInt32Size(5, this.gridPrice_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static Store parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Store) PARSER.parseFrom(data);
        }

        public static Store parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Store) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Store parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Store) PARSER.parseFrom(data);
        }

        public static Store parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Store) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Store parseFrom(InputStream input) throws IOException {
            return (Store) PARSER.parseFrom(input);
        }

        public static Store parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Store) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Store parseDelimitedFrom(InputStream input) throws IOException {
            return (Store) PARSER.parseDelimitedFrom(input);
        }

        public static Store parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Store) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Store parseFrom(CodedInputStream input) throws IOException {
            return (Store) PARSER.parseFrom(input);
        }

        public static Store parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Store) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Store prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements PlayerOuterClass.StoreOrBuilder {
            private int bitField0_;
            private List<ItemOuterClass.Grid> bagGrids_;
            private RepeatedFieldBuilder<ItemOuterClass.Grid, ItemOuterClass.Grid.Builder, ItemOuterClass.GridOrBuilder> bagGridsBuilder_;
            private int bagGridCount_;
            private int bagTotalCount_;
            private int type_;
            private int gridPrice_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PlayerOuterClass.internal_static_pomelo_player_Store_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PlayerOuterClass.internal_static_pomelo_player_Store_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerOuterClass.Store.class, Builder.class);
            }

            private Builder() {
                this.bagGrids_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.bagGrids_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PlayerOuterClass.Store.alwaysUseFieldBuilders) getBagGridsFieldBuilder();
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                if (this.bagGridsBuilder_ == null) {
                    this.bagGrids_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFE;
                } else {
                    this.bagGridsBuilder_.clear();
                }
                this.bagGridCount_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                this.bagTotalCount_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.type_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                this.gridPrice_ = 0;
                this.bitField0_ &= 0xFFFFFFEF;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return PlayerOuterClass.internal_static_pomelo_player_Store_descriptor;
            }

            public PlayerOuterClass.Store getDefaultInstanceForType() {
                return PlayerOuterClass.Store.getDefaultInstance();
            }

            public PlayerOuterClass.Store build() {
                PlayerOuterClass.Store result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public PlayerOuterClass.Store buildPartial() {
                PlayerOuterClass.Store result = new PlayerOuterClass.Store(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if (this.bagGridsBuilder_ == null) {
                    if ((this.bitField0_ & 0x1) == 1) {
                        this.bagGrids_ = Collections.unmodifiableList(this.bagGrids_);
                        this.bitField0_ &= 0xFFFFFFFE;
                    }
                    result.bagGrids_ = this.bagGrids_;
                } else {
                    result.bagGrids_ = this.bagGridsBuilder_.build();
                }
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x1;
                result.bagGridCount_ = this.bagGridCount_;
                if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x2;
                result.bagTotalCount_ = this.bagTotalCount_;
                if ((from_bitField0_ & 0x8) == 8) to_bitField0_ |= 0x4;
                result.type_ = this.type_;
                if ((from_bitField0_ & 0x10) == 16) to_bitField0_ |= 0x8;
                result.gridPrice_ = this.gridPrice_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof PlayerOuterClass.Store) return mergeFrom((PlayerOuterClass.Store) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PlayerOuterClass.Store other) {
                if (other == PlayerOuterClass.Store.getDefaultInstance()) return this;
                if (this.bagGridsBuilder_ == null) {
                    if (!other.bagGrids_.isEmpty()) {
                        if (this.bagGrids_.isEmpty()) {
                            this.bagGrids_ = other.bagGrids_;
                            this.bitField0_ &= 0xFFFFFFFE;
                        } else {
                            ensureBagGridsIsMutable();
                            this.bagGrids_.addAll(other.bagGrids_);
                        }
                        onChanged();
                    }
                } else if (!other.bagGrids_.isEmpty()) {
                    if (this.bagGridsBuilder_.isEmpty()) {
                        this.bagGridsBuilder_.dispose();
                        this.bagGridsBuilder_ = null;
                        this.bagGrids_ = other.bagGrids_;
                        this.bitField0_ &= 0xFFFFFFFE;
                        this.bagGridsBuilder_ = PlayerOuterClass.Store.alwaysUseFieldBuilders ? getBagGridsFieldBuilder() : null;
                    } else {
                        this.bagGridsBuilder_.addAllMessages(other.bagGrids_);
                    }
                }
                if (other.hasBagGridCount()) setBagGridCount(other.getBagGridCount());
                if (other.hasBagTotalCount()) setBagTotalCount(other.getBagTotalCount());
                if (other.hasType()) setType(other.getType());
                if (other.hasGridPrice()) setGridPrice(other.getGridPrice());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                for (int i = 0; i < getBagGridsCount(); i++) {
                    if (!getBagGrids(i).isInitialized()) return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                PlayerOuterClass.Store parsedMessage = null;
                try {
                    parsedMessage = (PlayerOuterClass.Store) PlayerOuterClass.Store.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (PlayerOuterClass.Store) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            private void ensureBagGridsIsMutable() {
                if ((this.bitField0_ & 0x1) != 1) {
                    this.bagGrids_ = new ArrayList<>(this.bagGrids_);
                    this.bitField0_ |= 0x1;
                }
            }

            public List<ItemOuterClass.Grid> getBagGridsList() {
                if (this.bagGridsBuilder_ == null) return Collections.unmodifiableList(this.bagGrids_);
                return this.bagGridsBuilder_.getMessageList();
            }

            public int getBagGridsCount() {
                if (this.bagGridsBuilder_ == null) return this.bagGrids_.size();
                return this.bagGridsBuilder_.getCount();
            }

            public ItemOuterClass.Grid getBagGrids(int index) {
                if (this.bagGridsBuilder_ == null) return this.bagGrids_.get(index);
                return (ItemOuterClass.Grid) this.bagGridsBuilder_.getMessage(index);
            }

            public Builder setBagGrids(int index, ItemOuterClass.Grid value) {
                if (this.bagGridsBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureBagGridsIsMutable();
                    this.bagGrids_.set(index, value);
                    onChanged();
                } else {
                    this.bagGridsBuilder_.setMessage(index, (GeneratedMessage) value);
                }
                return this;
            }

            public Builder setBagGrids(int index, ItemOuterClass.Grid.Builder builderForValue) {
                if (this.bagGridsBuilder_ == null) {
                    ensureBagGridsIsMutable();
                    this.bagGrids_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.bagGridsBuilder_.setMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addBagGrids(ItemOuterClass.Grid value) {
                if (this.bagGridsBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureBagGridsIsMutable();
                    this.bagGrids_.add(value);
                    onChanged();
                } else {
                    this.bagGridsBuilder_.addMessage((GeneratedMessage) value);
                }
                return this;
            }

            public Builder addBagGrids(int index, ItemOuterClass.Grid value) {
                if (this.bagGridsBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureBagGridsIsMutable();
                    this.bagGrids_.add(index, value);
                    onChanged();
                } else {
                    this.bagGridsBuilder_.addMessage(index, (GeneratedMessage) value);
                }
                return this;
            }

            public Builder addBagGrids(ItemOuterClass.Grid.Builder builderForValue) {
                if (this.bagGridsBuilder_ == null) {
                    ensureBagGridsIsMutable();
                    this.bagGrids_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.bagGridsBuilder_.addMessage((GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addBagGrids(int index, ItemOuterClass.Grid.Builder builderForValue) {
                if (this.bagGridsBuilder_ == null) {
                    ensureBagGridsIsMutable();
                    this.bagGrids_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.bagGridsBuilder_.addMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addAllBagGrids(Iterable<? extends ItemOuterClass.Grid> values) {
                if (this.bagGridsBuilder_ == null) {
                    ensureBagGridsIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.bagGrids_);
                    onChanged();
                } else {
                    this.bagGridsBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearBagGrids() {
                if (this.bagGridsBuilder_ == null) {
                    this.bagGrids_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFE;
                    onChanged();
                } else {
                    this.bagGridsBuilder_.clear();
                }
                return this;
            }

            public Builder removeBagGrids(int index) {
                if (this.bagGridsBuilder_ == null) {
                    ensureBagGridsIsMutable();
                    this.bagGrids_.remove(index);
                    onChanged();
                } else {
                    this.bagGridsBuilder_.remove(index);
                }
                return this;
            }

            public ItemOuterClass.Grid.Builder getBagGridsBuilder(int index) {
                return (ItemOuterClass.Grid.Builder) getBagGridsFieldBuilder().getBuilder(index);
            }

            public ItemOuterClass.GridOrBuilder getBagGridsOrBuilder(int index) {
                if (this.bagGridsBuilder_ == null) return (ItemOuterClass.GridOrBuilder) this.bagGrids_.get(index);
                return (ItemOuterClass.GridOrBuilder) this.bagGridsBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends ItemOuterClass.GridOrBuilder> getBagGridsOrBuilderList() {
                if (this.bagGridsBuilder_ != null) return this.bagGridsBuilder_.getMessageOrBuilderList();
                return (List) Collections.unmodifiableList(this.bagGrids_);
            }

            public ItemOuterClass.Grid.Builder addBagGridsBuilder() {
                return (ItemOuterClass.Grid.Builder) getBagGridsFieldBuilder().addBuilder((GeneratedMessage) ItemOuterClass.Grid.getDefaultInstance());
            }

            public ItemOuterClass.Grid.Builder addBagGridsBuilder(int index) {
                return (ItemOuterClass.Grid.Builder) getBagGridsFieldBuilder().addBuilder(index, (GeneratedMessage) ItemOuterClass.Grid.getDefaultInstance());
            }

            public List<ItemOuterClass.Grid.Builder> getBagGridsBuilderList() {
                return getBagGridsFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<ItemOuterClass.Grid, ItemOuterClass.Grid.Builder, ItemOuterClass.GridOrBuilder> getBagGridsFieldBuilder() {
                if (this.bagGridsBuilder_ == null) {
                    this.bagGridsBuilder_ = new RepeatedFieldBuilder(this.bagGrids_, ((this.bitField0_ & 0x1) == 1), getParentForChildren(), isClean());
                    this.bagGrids_ = null;
                }
                return this.bagGridsBuilder_;
            }

            public boolean hasBagGridCount() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getBagGridCount() {
                return this.bagGridCount_;
            }

            public Builder setBagGridCount(int value) {
                this.bitField0_ |= 0x2;
                this.bagGridCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearBagGridCount() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.bagGridCount_ = 0;
                onChanged();
                return this;
            }

            public boolean hasBagTotalCount() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public int getBagTotalCount() {
                return this.bagTotalCount_;
            }

            public Builder setBagTotalCount(int value) {
                this.bitField0_ |= 0x4;
                this.bagTotalCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearBagTotalCount() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.bagTotalCount_ = 0;
                onChanged();
                return this;
            }

            public boolean hasType() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public int getType() {
                return this.type_;
            }

            public Builder setType(int value) {
                this.bitField0_ |= 0x8;
                this.type_ = value;
                onChanged();
                return this;
            }

            public Builder clearType() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.type_ = 0;
                onChanged();
                return this;
            }

            public boolean hasGridPrice() {
                return ((this.bitField0_ & 0x10) == 16);
            }

            public int getGridPrice() {
                return this.gridPrice_;
            }

            public Builder setGridPrice(int value) {
                this.bitField0_ |= 0x10;
                this.gridPrice_ = value;
                onChanged();
                return this;
            }

            public Builder clearGridPrice() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.gridPrice_ = 0;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class Stores
            extends GeneratedMessage
            implements StoresOrBuilder {
        private static final Stores defaultInstance = new Stores(true);
        private final UnknownFieldSet unknownFields;

        private Stores(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Stores(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Stores getDefaultInstance() {
            return defaultInstance;
        }

        public Stores getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Stores(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    PlayerOuterClass.Store.Builder subBuilder;
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        case 10:
                            subBuilder = null;
                            if ((this.bitField0_ & 0x1) == 1) subBuilder = this.bag_.toBuilder();
                            this.bag_ = (PlayerOuterClass.Store) input.readMessage(PlayerOuterClass.Store.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.bag_);
                                this.bag_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 0x1;
                            break;
                        case 18:
                            subBuilder = null;
                            if ((this.bitField0_ & 0x2) == 2) subBuilder = this.wareHouse_.toBuilder();
                            this.wareHouse_ = (PlayerOuterClass.Store) input.readMessage(PlayerOuterClass.Store.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.wareHouse_);
                                this.wareHouse_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 0x2;
                            break;
                        case 26:
                            subBuilder = null;
                            if ((this.bitField0_ & 0x4) == 4) subBuilder = this.recycle_.toBuilder();
                            this.recycle_ = (PlayerOuterClass.Store) input.readMessage(PlayerOuterClass.Store.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.recycle_);
                                this.recycle_ = subBuilder.buildPartial();
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
            return PlayerOuterClass.internal_static_pomelo_player_Stores_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return PlayerOuterClass.internal_static_pomelo_player_Stores_fieldAccessorTable.ensureFieldAccessorsInitialized(Stores.class, Builder.class);
        }

        public static Parser<Stores> PARSER = (Parser<Stores>) new AbstractParser<Stores>() {
            public PlayerOuterClass.Stores parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PlayerOuterClass.Stores(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int BAG_FIELD_NUMBER = 1;
        private PlayerOuterClass.Store bag_;
        public static final int WAREHOUSE_FIELD_NUMBER = 2;
        private PlayerOuterClass.Store wareHouse_;
        public static final int RECYCLE_FIELD_NUMBER = 3;
        private PlayerOuterClass.Store recycle_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<Stores> getParserForType() {
            return PARSER;
        }

        public boolean hasBag() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public PlayerOuterClass.Store getBag() {
            return this.bag_;
        }

        public PlayerOuterClass.StoreOrBuilder getBagOrBuilder() {
            return this.bag_;
        }

        public boolean hasWareHouse() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public PlayerOuterClass.Store getWareHouse() {
            return this.wareHouse_;
        }

        public PlayerOuterClass.StoreOrBuilder getWareHouseOrBuilder() {
            return this.wareHouse_;
        }

        public boolean hasRecycle() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public PlayerOuterClass.Store getRecycle() {
            return this.recycle_;
        }

        public PlayerOuterClass.StoreOrBuilder getRecycleOrBuilder() {
            return this.recycle_;
        }

        private void initFields() {
            this.bag_ = PlayerOuterClass.Store.getDefaultInstance();
            this.wareHouse_ = PlayerOuterClass.Store.getDefaultInstance();
            this.recycle_ = PlayerOuterClass.Store.getDefaultInstance();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (hasBag() && !getBag().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (hasWareHouse() && !getWareHouse().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (hasRecycle() && !getRecycle().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeMessage(1, (MessageLite) this.bag_);
            if ((this.bitField0_ & 0x2) == 2) output.writeMessage(2, (MessageLite) this.wareHouse_);
            if ((this.bitField0_ & 0x4) == 4) output.writeMessage(3, (MessageLite) this.recycle_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeMessageSize(1, (MessageLite) this.bag_);
            if ((this.bitField0_ & 0x2) == 2)
                size += CodedOutputStream.computeMessageSize(2, (MessageLite) this.wareHouse_);
            if ((this.bitField0_ & 0x4) == 4)
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.recycle_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static Stores parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Stores) PARSER.parseFrom(data);
        }

        public static Stores parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Stores) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Stores parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Stores) PARSER.parseFrom(data);
        }

        public static Stores parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Stores) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Stores parseFrom(InputStream input) throws IOException {
            return (Stores) PARSER.parseFrom(input);
        }

        public static Stores parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Stores) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Stores parseDelimitedFrom(InputStream input) throws IOException {
            return (Stores) PARSER.parseDelimitedFrom(input);
        }

        public static Stores parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Stores) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Stores parseFrom(CodedInputStream input) throws IOException {
            return (Stores) PARSER.parseFrom(input);
        }

        public static Stores parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Stores) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Stores prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements PlayerOuterClass.StoresOrBuilder {
            private int bitField0_;
            private PlayerOuterClass.Store bag_;
            private SingleFieldBuilder<PlayerOuterClass.Store, PlayerOuterClass.Store.Builder, PlayerOuterClass.StoreOrBuilder> bagBuilder_;
            private PlayerOuterClass.Store wareHouse_;
            private SingleFieldBuilder<PlayerOuterClass.Store, PlayerOuterClass.Store.Builder, PlayerOuterClass.StoreOrBuilder> wareHouseBuilder_;
            private PlayerOuterClass.Store recycle_;
            private SingleFieldBuilder<PlayerOuterClass.Store, PlayerOuterClass.Store.Builder, PlayerOuterClass.StoreOrBuilder> recycleBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PlayerOuterClass.internal_static_pomelo_player_Stores_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PlayerOuterClass.internal_static_pomelo_player_Stores_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerOuterClass.Stores.class, Builder.class);
            }

            private Builder() {
                this.bag_ = PlayerOuterClass.Store.getDefaultInstance();
                this.wareHouse_ = PlayerOuterClass.Store.getDefaultInstance();
                this.recycle_ = PlayerOuterClass.Store.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.bag_ = PlayerOuterClass.Store.getDefaultInstance();
                this.wareHouse_ = PlayerOuterClass.Store.getDefaultInstance();
                this.recycle_ = PlayerOuterClass.Store.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PlayerOuterClass.Stores.alwaysUseFieldBuilders) {
                    getBagFieldBuilder();
                    getWareHouseFieldBuilder();
                    getRecycleFieldBuilder();
                }
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                if (this.bagBuilder_ == null) {
                    this.bag_ = PlayerOuterClass.Store.getDefaultInstance();
                } else {
                    this.bagBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFE;
                if (this.wareHouseBuilder_ == null) {
                    this.wareHouse_ = PlayerOuterClass.Store.getDefaultInstance();
                } else {
                    this.wareHouseBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFD;
                if (this.recycleBuilder_ == null) {
                    this.recycle_ = PlayerOuterClass.Store.getDefaultInstance();
                } else {
                    this.recycleBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return PlayerOuterClass.internal_static_pomelo_player_Stores_descriptor;
            }

            public PlayerOuterClass.Stores getDefaultInstanceForType() {
                return PlayerOuterClass.Stores.getDefaultInstance();
            }

            public PlayerOuterClass.Stores build() {
                PlayerOuterClass.Stores result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public PlayerOuterClass.Stores buildPartial() {
                PlayerOuterClass.Stores result = new PlayerOuterClass.Stores(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                if (this.bagBuilder_ == null) {
                    result.bag_ = this.bag_;
                } else {
                    result.bag_ = (PlayerOuterClass.Store) this.bagBuilder_.build();
                }
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                if (this.wareHouseBuilder_ == null) {
                    result.wareHouse_ = this.wareHouse_;
                } else {
                    result.wareHouse_ = (PlayerOuterClass.Store) this.wareHouseBuilder_.build();
                }
                if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;
                if (this.recycleBuilder_ == null) {
                    result.recycle_ = this.recycle_;
                } else {
                    result.recycle_ = (PlayerOuterClass.Store) this.recycleBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof PlayerOuterClass.Stores) return mergeFrom((PlayerOuterClass.Stores) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PlayerOuterClass.Stores other) {
                if (other == PlayerOuterClass.Stores.getDefaultInstance()) return this;
                if (other.hasBag()) mergeBag(other.getBag());
                if (other.hasWareHouse()) mergeWareHouse(other.getWareHouse());
                if (other.hasRecycle()) mergeRecycle(other.getRecycle());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (hasBag() && !getBag().isInitialized()) return false;
                if (hasWareHouse() && !getWareHouse().isInitialized()) return false;
                if (hasRecycle() && !getRecycle().isInitialized()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                PlayerOuterClass.Stores parsedMessage = null;
                try {
                    parsedMessage = (PlayerOuterClass.Stores) PlayerOuterClass.Stores.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (PlayerOuterClass.Stores) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasBag() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public PlayerOuterClass.Store getBag() {
                if (this.bagBuilder_ == null) return this.bag_;
                return (PlayerOuterClass.Store) this.bagBuilder_.getMessage();
            }

            public Builder setBag(PlayerOuterClass.Store value) {
                if (this.bagBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    this.bag_ = value;
                    onChanged();
                } else {
                    this.bagBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x1;
                return this;
            }

            public Builder setBag(PlayerOuterClass.Store.Builder builderForValue) {
                if (this.bagBuilder_ == null) {
                    this.bag_ = builderForValue.build();
                    onChanged();
                } else {
                    this.bagBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x1;
                return this;
            }

            public Builder mergeBag(PlayerOuterClass.Store value) {
                if (this.bagBuilder_ == null) {
                    if ((this.bitField0_ & 0x1) == 1 && this.bag_ != PlayerOuterClass.Store.getDefaultInstance()) {
                        this.bag_ = PlayerOuterClass.Store.newBuilder(this.bag_).mergeFrom(value).buildPartial();
                    } else {
                        this.bag_ = value;
                    }
                    onChanged();
                } else {
                    this.bagBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x1;
                return this;
            }

            public Builder clearBag() {
                if (this.bagBuilder_ == null) {
                    this.bag_ = PlayerOuterClass.Store.getDefaultInstance();
                    onChanged();
                } else {
                    this.bagBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            public PlayerOuterClass.Store.Builder getBagBuilder() {
                this.bitField0_ |= 0x1;
                onChanged();
                return (PlayerOuterClass.Store.Builder) getBagFieldBuilder().getBuilder();
            }

            public PlayerOuterClass.StoreOrBuilder getBagOrBuilder() {
                if (this.bagBuilder_ != null)
                    return (PlayerOuterClass.StoreOrBuilder) this.bagBuilder_.getMessageOrBuilder();
                return this.bag_;
            }

            private SingleFieldBuilder<PlayerOuterClass.Store, PlayerOuterClass.Store.Builder, PlayerOuterClass.StoreOrBuilder> getBagFieldBuilder() {
                if (this.bagBuilder_ == null) {
                    this.bagBuilder_ = new SingleFieldBuilder(getBag(), getParentForChildren(), isClean());
                    this.bag_ = null;
                }
                return this.bagBuilder_;
            }

            public boolean hasWareHouse() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public PlayerOuterClass.Store getWareHouse() {
                if (this.wareHouseBuilder_ == null) return this.wareHouse_;
                return (PlayerOuterClass.Store) this.wareHouseBuilder_.getMessage();
            }

            public Builder setWareHouse(PlayerOuterClass.Store value) {
                if (this.wareHouseBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    this.wareHouse_ = value;
                    onChanged();
                } else {
                    this.wareHouseBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x2;
                return this;
            }

            public Builder setWareHouse(PlayerOuterClass.Store.Builder builderForValue) {
                if (this.wareHouseBuilder_ == null) {
                    this.wareHouse_ = builderForValue.build();
                    onChanged();
                } else {
                    this.wareHouseBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x2;
                return this;
            }

            public Builder mergeWareHouse(PlayerOuterClass.Store value) {
                if (this.wareHouseBuilder_ == null) {
                    if ((this.bitField0_ & 0x2) == 2 && this.wareHouse_ != PlayerOuterClass.Store.getDefaultInstance()) {
                        this.wareHouse_ = PlayerOuterClass.Store.newBuilder(this.wareHouse_).mergeFrom(value).buildPartial();
                    } else {
                        this.wareHouse_ = value;
                    }
                    onChanged();
                } else {
                    this.wareHouseBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x2;
                return this;
            }

            public Builder clearWareHouse() {
                if (this.wareHouseBuilder_ == null) {
                    this.wareHouse_ = PlayerOuterClass.Store.getDefaultInstance();
                    onChanged();
                } else {
                    this.wareHouseBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            public PlayerOuterClass.Store.Builder getWareHouseBuilder() {
                this.bitField0_ |= 0x2;
                onChanged();
                return (PlayerOuterClass.Store.Builder) getWareHouseFieldBuilder().getBuilder();
            }

            public PlayerOuterClass.StoreOrBuilder getWareHouseOrBuilder() {
                if (this.wareHouseBuilder_ != null)
                    return (PlayerOuterClass.StoreOrBuilder) this.wareHouseBuilder_.getMessageOrBuilder();
                return this.wareHouse_;
            }

            private SingleFieldBuilder<PlayerOuterClass.Store, PlayerOuterClass.Store.Builder, PlayerOuterClass.StoreOrBuilder> getWareHouseFieldBuilder() {
                if (this.wareHouseBuilder_ == null) {
                    this.wareHouseBuilder_ = new SingleFieldBuilder(getWareHouse(), getParentForChildren(), isClean());
                    this.wareHouse_ = null;
                }
                return this.wareHouseBuilder_;
            }

            public boolean hasRecycle() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public PlayerOuterClass.Store getRecycle() {
                if (this.recycleBuilder_ == null) return this.recycle_;
                return (PlayerOuterClass.Store) this.recycleBuilder_.getMessage();
            }

            public Builder setRecycle(PlayerOuterClass.Store value) {
                if (this.recycleBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    this.recycle_ = value;
                    onChanged();
                } else {
                    this.recycleBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder setRecycle(PlayerOuterClass.Store.Builder builderForValue) {
                if (this.recycleBuilder_ == null) {
                    this.recycle_ = builderForValue.build();
                    onChanged();
                } else {
                    this.recycleBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder mergeRecycle(PlayerOuterClass.Store value) {
                if (this.recycleBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4 && this.recycle_ != PlayerOuterClass.Store.getDefaultInstance()) {
                        this.recycle_ = PlayerOuterClass.Store.newBuilder(this.recycle_).mergeFrom(value).buildPartial();
                    } else {
                        this.recycle_ = value;
                    }
                    onChanged();
                } else {
                    this.recycleBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder clearRecycle() {
                if (this.recycleBuilder_ == null) {
                    this.recycle_ = PlayerOuterClass.Store.getDefaultInstance();
                    onChanged();
                } else {
                    this.recycleBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public PlayerOuterClass.Store.Builder getRecycleBuilder() {
                this.bitField0_ |= 0x4;
                onChanged();
                return (PlayerOuterClass.Store.Builder) getRecycleFieldBuilder().getBuilder();
            }

            public PlayerOuterClass.StoreOrBuilder getRecycleOrBuilder() {
                if (this.recycleBuilder_ != null)
                    return (PlayerOuterClass.StoreOrBuilder) this.recycleBuilder_.getMessageOrBuilder();
                return this.recycle_;
            }

            private SingleFieldBuilder<PlayerOuterClass.Store, PlayerOuterClass.Store.Builder, PlayerOuterClass.StoreOrBuilder> getRecycleFieldBuilder() {
                if (this.recycleBuilder_ == null) {
                    this.recycleBuilder_ = new SingleFieldBuilder(getRecycle(), getParentForChildren(), isClean());
                    this.recycle_ = null;
                }
                return this.recycleBuilder_;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class Equipments
            extends GeneratedMessage
            implements EquipmentsOrBuilder {
        private static final Equipments defaultInstance = new Equipments(true);
        private final UnknownFieldSet unknownFields;

        private Equipments(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Equipments(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Equipments getDefaultInstance() {
            return defaultInstance;
        }

        public Equipments getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Equipments(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.equips_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x1;
                            }
                            this.equips_.add(input.readMessage(ItemOuterClass.Grid.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x1) == 1) this.equips_ = Collections.unmodifiableList(this.equips_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return PlayerOuterClass.internal_static_pomelo_player_Equipments_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return PlayerOuterClass.internal_static_pomelo_player_Equipments_fieldAccessorTable.ensureFieldAccessorsInitialized(Equipments.class, Builder.class);
        }

        public static Parser<Equipments> PARSER = (Parser<Equipments>) new AbstractParser<Equipments>() {
            public PlayerOuterClass.Equipments parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PlayerOuterClass.Equipments(input, extensionRegistry);
            }
        };
        public static final int EQUIPS_FIELD_NUMBER = 1;
        private List<ItemOuterClass.Grid> equips_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<Equipments> getParserForType() {
            return PARSER;
        }

        public List<ItemOuterClass.Grid> getEquipsList() {
            return this.equips_;
        }

        public List<? extends ItemOuterClass.GridOrBuilder> getEquipsOrBuilderList() {
            return (List) this.equips_;
        }

        public int getEquipsCount() {
            return this.equips_.size();
        }

        public ItemOuterClass.Grid getEquips(int index) {
            return this.equips_.get(index);
        }

        public ItemOuterClass.GridOrBuilder getEquipsOrBuilder(int index) {
            return (ItemOuterClass.GridOrBuilder) this.equips_.get(index);
        }

        private void initFields() {
            this.equips_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            for (int i = 0; i < getEquipsCount(); i++) {
                if (!getEquips(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            for (int i = 0; i < this.equips_.size(); i++) output.writeMessage(1, (MessageLite) this.equips_.get(i));
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            for (int i = 0; i < this.equips_.size(); i++)
                size += CodedOutputStream.computeMessageSize(1, (MessageLite) this.equips_.get(i));
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static Equipments parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Equipments) PARSER.parseFrom(data);
        }

        public static Equipments parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Equipments) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Equipments parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Equipments) PARSER.parseFrom(data);
        }

        public static Equipments parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Equipments) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Equipments parseFrom(InputStream input) throws IOException {
            return (Equipments) PARSER.parseFrom(input);
        }

        public static Equipments parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Equipments) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Equipments parseDelimitedFrom(InputStream input) throws IOException {
            return (Equipments) PARSER.parseDelimitedFrom(input);
        }

        public static Equipments parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Equipments) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Equipments parseFrom(CodedInputStream input) throws IOException {
            return (Equipments) PARSER.parseFrom(input);
        }

        public static Equipments parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Equipments) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Equipments prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements PlayerOuterClass.EquipmentsOrBuilder {
            private int bitField0_;
            private List<ItemOuterClass.Grid> equips_;
            private RepeatedFieldBuilder<ItemOuterClass.Grid, ItemOuterClass.Grid.Builder, ItemOuterClass.GridOrBuilder> equipsBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PlayerOuterClass.internal_static_pomelo_player_Equipments_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PlayerOuterClass.internal_static_pomelo_player_Equipments_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerOuterClass.Equipments.class, Builder.class);
            }

            private Builder() {
                this.equips_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.equips_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PlayerOuterClass.Equipments.alwaysUseFieldBuilders) getEquipsFieldBuilder();
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                if (this.equipsBuilder_ == null) {
                    this.equips_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFE;
                } else {
                    this.equipsBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return PlayerOuterClass.internal_static_pomelo_player_Equipments_descriptor;
            }

            public PlayerOuterClass.Equipments getDefaultInstanceForType() {
                return PlayerOuterClass.Equipments.getDefaultInstance();
            }

            public PlayerOuterClass.Equipments build() {
                PlayerOuterClass.Equipments result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public PlayerOuterClass.Equipments buildPartial() {
                PlayerOuterClass.Equipments result = new PlayerOuterClass.Equipments(this);
                int from_bitField0_ = this.bitField0_;
                if (this.equipsBuilder_ == null) {
                    if ((this.bitField0_ & 0x1) == 1) {
                        this.equips_ = Collections.unmodifiableList(this.equips_);
                        this.bitField0_ &= 0xFFFFFFFE;
                    }
                    result.equips_ = this.equips_;
                } else {
                    result.equips_ = this.equipsBuilder_.build();
                }
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof PlayerOuterClass.Equipments) return mergeFrom((PlayerOuterClass.Equipments) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PlayerOuterClass.Equipments other) {
                if (other == PlayerOuterClass.Equipments.getDefaultInstance()) return this;
                if (this.equipsBuilder_ == null) {
                    if (!other.equips_.isEmpty()) {
                        if (this.equips_.isEmpty()) {
                            this.equips_ = other.equips_;
                            this.bitField0_ &= 0xFFFFFFFE;
                        } else {
                            ensureEquipsIsMutable();
                            this.equips_.addAll(other.equips_);
                        }
                        onChanged();
                    }
                } else if (!other.equips_.isEmpty()) {
                    if (this.equipsBuilder_.isEmpty()) {
                        this.equipsBuilder_.dispose();
                        this.equipsBuilder_ = null;
                        this.equips_ = other.equips_;
                        this.bitField0_ &= 0xFFFFFFFE;
                        this.equipsBuilder_ = PlayerOuterClass.Equipments.alwaysUseFieldBuilders ? getEquipsFieldBuilder() : null;
                    } else {
                        this.equipsBuilder_.addAllMessages(other.equips_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                for (int i = 0; i < getEquipsCount(); i++) {
                    if (!getEquips(i).isInitialized()) return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                PlayerOuterClass.Equipments parsedMessage = null;
                try {
                    parsedMessage = (PlayerOuterClass.Equipments) PlayerOuterClass.Equipments.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (PlayerOuterClass.Equipments) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            private void ensureEquipsIsMutable() {
                if ((this.bitField0_ & 0x1) != 1) {
                    this.equips_ = new ArrayList<>(this.equips_);
                    this.bitField0_ |= 0x1;
                }
            }

            public List<ItemOuterClass.Grid> getEquipsList() {
                if (this.equipsBuilder_ == null) return Collections.unmodifiableList(this.equips_);
                return this.equipsBuilder_.getMessageList();
            }

            public int getEquipsCount() {
                if (this.equipsBuilder_ == null) return this.equips_.size();
                return this.equipsBuilder_.getCount();
            }

            public ItemOuterClass.Grid getEquips(int index) {
                if (this.equipsBuilder_ == null) return this.equips_.get(index);
                return (ItemOuterClass.Grid) this.equipsBuilder_.getMessage(index);
            }

            public Builder setEquips(int index, ItemOuterClass.Grid value) {
                if (this.equipsBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureEquipsIsMutable();
                    this.equips_.set(index, value);
                    onChanged();
                } else {
                    this.equipsBuilder_.setMessage(index, (GeneratedMessage) value);
                }
                return this;
            }

            public Builder setEquips(int index, ItemOuterClass.Grid.Builder builderForValue) {
                if (this.equipsBuilder_ == null) {
                    ensureEquipsIsMutable();
                    this.equips_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.equipsBuilder_.setMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addEquips(ItemOuterClass.Grid value) {
                if (this.equipsBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureEquipsIsMutable();
                    this.equips_.add(value);
                    onChanged();
                } else {
                    this.equipsBuilder_.addMessage((GeneratedMessage) value);
                }
                return this;
            }

            public Builder addEquips(int index, ItemOuterClass.Grid value) {
                if (this.equipsBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureEquipsIsMutable();
                    this.equips_.add(index, value);
                    onChanged();
                } else {
                    this.equipsBuilder_.addMessage(index, (GeneratedMessage) value);
                }
                return this;
            }

            public Builder addEquips(ItemOuterClass.Grid.Builder builderForValue) {
                if (this.equipsBuilder_ == null) {
                    ensureEquipsIsMutable();
                    this.equips_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.equipsBuilder_.addMessage((GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addEquips(int index, ItemOuterClass.Grid.Builder builderForValue) {
                if (this.equipsBuilder_ == null) {
                    ensureEquipsIsMutable();
                    this.equips_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.equipsBuilder_.addMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addAllEquips(Iterable<? extends ItemOuterClass.Grid> values) {
                if (this.equipsBuilder_ == null) {
                    ensureEquipsIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.equips_);
                    onChanged();
                } else {
                    this.equipsBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearEquips() {
                if (this.equipsBuilder_ == null) {
                    this.equips_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFE;
                    onChanged();
                } else {
                    this.equipsBuilder_.clear();
                }
                return this;
            }

            public Builder removeEquips(int index) {
                if (this.equipsBuilder_ == null) {
                    ensureEquipsIsMutable();
                    this.equips_.remove(index);
                    onChanged();
                } else {
                    this.equipsBuilder_.remove(index);
                }
                return this;
            }

            public ItemOuterClass.Grid.Builder getEquipsBuilder(int index) {
                return (ItemOuterClass.Grid.Builder) getEquipsFieldBuilder().getBuilder(index);
            }

            public ItemOuterClass.GridOrBuilder getEquipsOrBuilder(int index) {
                if (this.equipsBuilder_ == null) return (ItemOuterClass.GridOrBuilder) this.equips_.get(index);
                return (ItemOuterClass.GridOrBuilder) this.equipsBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends ItemOuterClass.GridOrBuilder> getEquipsOrBuilderList() {
                if (this.equipsBuilder_ != null) return this.equipsBuilder_.getMessageOrBuilderList();
                return (List) Collections.unmodifiableList(this.equips_);
            }

            public ItemOuterClass.Grid.Builder addEquipsBuilder() {
                return (ItemOuterClass.Grid.Builder) getEquipsFieldBuilder().addBuilder((GeneratedMessage) ItemOuterClass.Grid.getDefaultInstance());
            }

            public ItemOuterClass.Grid.Builder addEquipsBuilder(int index) {
                return (ItemOuterClass.Grid.Builder) getEquipsFieldBuilder().addBuilder(index, (GeneratedMessage) ItemOuterClass.Grid.getDefaultInstance());
            }

            public List<ItemOuterClass.Grid.Builder> getEquipsBuilderList() {
                return getEquipsFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<ItemOuterClass.Grid, ItemOuterClass.Grid.Builder, ItemOuterClass.GridOrBuilder> getEquipsFieldBuilder() {
                if (this.equipsBuilder_ == null) {
                    this.equipsBuilder_ = new RepeatedFieldBuilder(this.equips_, ((this.bitField0_ & 0x1) == 1), getParentForChildren(), isClean());
                    this.equips_ = null;
                }
                return this.equipsBuilder_;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class OfflineBaseData
            extends GeneratedMessage
            implements OfflineBaseDataOrBuilder {
        private static final OfflineBaseData defaultInstance = new OfflineBaseData(true);
        private final UnknownFieldSet unknownFields;

        private OfflineBaseData(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private OfflineBaseData(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static OfflineBaseData getDefaultInstance() {
            return defaultInstance;
        }

        public OfflineBaseData getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private OfflineBaseData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.flag_ = input.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.areaId_ = input.readInt32();
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
            return PlayerOuterClass.internal_static_pomelo_player_OfflineBaseData_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return PlayerOuterClass.internal_static_pomelo_player_OfflineBaseData_fieldAccessorTable.ensureFieldAccessorsInitialized(OfflineBaseData.class, Builder.class);
        }

        public static Parser<OfflineBaseData> PARSER = (Parser<OfflineBaseData>) new AbstractParser<OfflineBaseData>() {
            public PlayerOuterClass.OfflineBaseData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PlayerOuterClass.OfflineBaseData(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int FLAG_FIELD_NUMBER = 1;
        private int flag_;
        public static final int AREAID_FIELD_NUMBER = 2;
        private int areaId_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<OfflineBaseData> getParserForType() {
            return PARSER;
        }

        public boolean hasFlag() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getFlag() {
            return this.flag_;
        }

        public boolean hasAreaId() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public int getAreaId() {
            return this.areaId_;
        }

        private void initFields() {
            this.flag_ = 0;
            this.areaId_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasFlag()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasAreaId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.flag_);
            if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.areaId_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.flag_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(2, this.areaId_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static OfflineBaseData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (OfflineBaseData) PARSER.parseFrom(data);
        }

        public static OfflineBaseData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (OfflineBaseData) PARSER.parseFrom(data, extensionRegistry);
        }

        public static OfflineBaseData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (OfflineBaseData) PARSER.parseFrom(data);
        }

        public static OfflineBaseData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (OfflineBaseData) PARSER.parseFrom(data, extensionRegistry);
        }

        public static OfflineBaseData parseFrom(InputStream input) throws IOException {
            return (OfflineBaseData) PARSER.parseFrom(input);
        }

        public static OfflineBaseData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OfflineBaseData) PARSER.parseFrom(input, extensionRegistry);
        }

        public static OfflineBaseData parseDelimitedFrom(InputStream input) throws IOException {
            return (OfflineBaseData) PARSER.parseDelimitedFrom(input);
        }

        public static OfflineBaseData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OfflineBaseData) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static OfflineBaseData parseFrom(CodedInputStream input) throws IOException {
            return (OfflineBaseData) PARSER.parseFrom(input);
        }

        public static OfflineBaseData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OfflineBaseData) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(OfflineBaseData prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements PlayerOuterClass.OfflineBaseDataOrBuilder {
            private int bitField0_;
            private int flag_;
            private int areaId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PlayerOuterClass.internal_static_pomelo_player_OfflineBaseData_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PlayerOuterClass.internal_static_pomelo_player_OfflineBaseData_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerOuterClass.OfflineBaseData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PlayerOuterClass.OfflineBaseData.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.flag_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.areaId_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return PlayerOuterClass.internal_static_pomelo_player_OfflineBaseData_descriptor;
            }

            public PlayerOuterClass.OfflineBaseData getDefaultInstanceForType() {
                return PlayerOuterClass.OfflineBaseData.getDefaultInstance();
            }

            public PlayerOuterClass.OfflineBaseData build() {
                PlayerOuterClass.OfflineBaseData result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public PlayerOuterClass.OfflineBaseData buildPartial() {
                PlayerOuterClass.OfflineBaseData result = new PlayerOuterClass.OfflineBaseData(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.flag_ = this.flag_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.areaId_ = this.areaId_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof PlayerOuterClass.OfflineBaseData)
                    return mergeFrom((PlayerOuterClass.OfflineBaseData) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PlayerOuterClass.OfflineBaseData other) {
                if (other == PlayerOuterClass.OfflineBaseData.getDefaultInstance()) return this;
                if (other.hasFlag()) setFlag(other.getFlag());
                if (other.hasAreaId()) setAreaId(other.getAreaId());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasFlag()) return false;
                if (!hasAreaId()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                PlayerOuterClass.OfflineBaseData parsedMessage = null;
                try {
                    parsedMessage = (PlayerOuterClass.OfflineBaseData) PlayerOuterClass.OfflineBaseData.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (PlayerOuterClass.OfflineBaseData) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasFlag() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getFlag() {
                return this.flag_;
            }

            public Builder setFlag(int value) {
                this.bitField0_ |= 0x1;
                this.flag_ = value;
                onChanged();
                return this;
            }

            public Builder clearFlag() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.flag_ = 0;
                onChanged();
                return this;
            }

            public boolean hasAreaId() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getAreaId() {
                return this.areaId_;
            }

            public Builder setAreaId(int value) {
                this.bitField0_ |= 0x2;
                this.areaId_ = value;
                onChanged();
                return this;
            }

            public Builder clearAreaId() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.areaId_ = 0;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class Attachment
            extends GeneratedMessage
            implements AttachmentOrBuilder {
        private static final Attachment defaultInstance = new Attachment(true);
        private final UnknownFieldSet unknownFields;

        private Attachment(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Attachment(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Attachment getDefaultInstance() {
            return defaultInstance;
        }

        public Attachment getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Attachment(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.icon_ = input.readInt32();
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.num_ = input.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.quality_ = input.readInt32();
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
            return PlayerOuterClass.internal_static_pomelo_player_Attachment_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return PlayerOuterClass.internal_static_pomelo_player_Attachment_fieldAccessorTable.ensureFieldAccessorsInitialized(Attachment.class, Builder.class);
        }

        public static Parser<Attachment> PARSER = (Parser<Attachment>) new AbstractParser<Attachment>() {
            public PlayerOuterClass.Attachment parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PlayerOuterClass.Attachment(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int TEMPLATEID_FIELD_NUMBER = 1;
        private int templateId_;
        public static final int ICON_FIELD_NUMBER = 2;
        private int icon_;
        public static final int NUM_FIELD_NUMBER = 3;
        private int num_;
        public static final int QUALITY_FIELD_NUMBER = 4;
        private int quality_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<Attachment> getParserForType() {
            return PARSER;
        }

        public boolean hasTemplateId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getTemplateId() {
            return this.templateId_;
        }

        public boolean hasIcon() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public int getIcon() {
            return this.icon_;
        }

        public boolean hasNum() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getNum() {
            return this.num_;
        }

        public boolean hasQuality() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public int getQuality() {
            return this.quality_;
        }

        private void initFields() {
            this.templateId_ = 0;
            this.icon_ = 0;
            this.num_ = 0;
            this.quality_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasTemplateId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasIcon()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasNum()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasQuality()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.templateId_);
            if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.icon_);
            if ((this.bitField0_ & 0x4) == 4) output.writeInt32(3, this.num_);
            if ((this.bitField0_ & 0x8) == 8) output.writeInt32(4, this.quality_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.templateId_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(2, this.icon_);
            if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeInt32Size(3, this.num_);
            if ((this.bitField0_ & 0x8) == 8) size += CodedOutputStream.computeInt32Size(4, this.quality_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static Attachment parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Attachment) PARSER.parseFrom(data);
        }

        public static Attachment parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Attachment) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Attachment parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Attachment) PARSER.parseFrom(data);
        }

        public static Attachment parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Attachment) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Attachment parseFrom(InputStream input) throws IOException {
            return (Attachment) PARSER.parseFrom(input);
        }

        public static Attachment parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Attachment) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Attachment parseDelimitedFrom(InputStream input) throws IOException {
            return (Attachment) PARSER.parseDelimitedFrom(input);
        }

        public static Attachment parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Attachment) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Attachment parseFrom(CodedInputStream input) throws IOException {
            return (Attachment) PARSER.parseFrom(input);
        }

        public static Attachment parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Attachment) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Attachment prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements PlayerOuterClass.AttachmentOrBuilder {
            private int bitField0_;
            private int templateId_;
            private int icon_;
            private int num_;
            private int quality_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PlayerOuterClass.internal_static_pomelo_player_Attachment_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PlayerOuterClass.internal_static_pomelo_player_Attachment_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerOuterClass.Attachment.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PlayerOuterClass.Attachment.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.templateId_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.icon_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                this.num_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.quality_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return PlayerOuterClass.internal_static_pomelo_player_Attachment_descriptor;
            }

            public PlayerOuterClass.Attachment getDefaultInstanceForType() {
                return PlayerOuterClass.Attachment.getDefaultInstance();
            }

            public PlayerOuterClass.Attachment build() {
                PlayerOuterClass.Attachment result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public PlayerOuterClass.Attachment buildPartial() {
                PlayerOuterClass.Attachment result = new PlayerOuterClass.Attachment(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.templateId_ = this.templateId_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.icon_ = this.icon_;
                if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;
                result.num_ = this.num_;
                if ((from_bitField0_ & 0x8) == 8) to_bitField0_ |= 0x8;
                result.quality_ = this.quality_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof PlayerOuterClass.Attachment) return mergeFrom((PlayerOuterClass.Attachment) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PlayerOuterClass.Attachment other) {
                if (other == PlayerOuterClass.Attachment.getDefaultInstance()) return this;
                if (other.hasTemplateId()) setTemplateId(other.getTemplateId());
                if (other.hasIcon()) setIcon(other.getIcon());
                if (other.hasNum()) setNum(other.getNum());
                if (other.hasQuality()) setQuality(other.getQuality());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasTemplateId()) return false;
                if (!hasIcon()) return false;
                if (!hasNum()) return false;
                if (!hasQuality()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                PlayerOuterClass.Attachment parsedMessage = null;
                try {
                    parsedMessage = (PlayerOuterClass.Attachment) PlayerOuterClass.Attachment.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (PlayerOuterClass.Attachment) e.getUnfinishedMessage();
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

            public boolean hasIcon() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getIcon() {
                return this.icon_;
            }

            public Builder setIcon(int value) {
                this.bitField0_ |= 0x2;
                this.icon_ = value;
                onChanged();
                return this;
            }

            public Builder clearIcon() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.icon_ = 0;
                onChanged();
                return this;
            }

            public boolean hasNum() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public int getNum() {
                return this.num_;
            }

            public Builder setNum(int value) {
                this.bitField0_ |= 0x4;
                this.num_ = value;
                onChanged();
                return this;
            }

            public Builder clearNum() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.num_ = 0;
                onChanged();
                return this;
            }

            public boolean hasQuality() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public int getQuality() {
                return this.quality_;
            }

            public Builder setQuality(int value) {
                this.bitField0_ |= 0x8;
                this.quality_ = value;
                onChanged();
                return this;
            }

            public Builder clearQuality() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.quality_ = 0;
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
                        case 8:
                            this.bitField0_ |= 0x1;
                            this.id_ = input.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.type_ = input.readInt32();
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.fromType_ = input.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.fromIcon_ = input.readInt32();
                            break;
                        case 42:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x10;
                            this.fromName_ = bs;
                            break;
                        case 50:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x20;
                            this.title_ = bs;
                            break;
                        case 58:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x40;
                            this.content_ = bs;
                            break;
                        case 66:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x80;
                            this.createDate_ = bs;
                            break;
                        case 72:
                            this.bitField0_ |= 0x100;
                            this.status_ = input.readInt32();
                            break;
                        case 82:
                            if ((mutable_bitField0_ & 0x200) != 512) {
                                this.attachment_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x200;
                            }
                            this.attachment_.add(input.readMessage(PlayerOuterClass.Attachment.PARSER, extensionRegistry));
                            break;
                        case 90:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x200;
                            this.timeStamp_ = bs;
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x200) == 512)
                    this.attachment_ = Collections.unmodifiableList(this.attachment_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return PlayerOuterClass.internal_static_pomelo_player_Mail_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return PlayerOuterClass.internal_static_pomelo_player_Mail_fieldAccessorTable.ensureFieldAccessorsInitialized(Mail.class, Builder.class);
        }

        public static Parser<Mail> PARSER = (Parser<Mail>) new AbstractParser<Mail>() {
            public PlayerOuterClass.Mail parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PlayerOuterClass.Mail(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int ID_FIELD_NUMBER = 1;
        private int id_;
        public static final int TYPE_FIELD_NUMBER = 2;
        private int type_;
        public static final int FROMTYPE_FIELD_NUMBER = 3;
        private int fromType_;
        public static final int FROMICON_FIELD_NUMBER = 4;
        private int fromIcon_;
        public static final int FROMNAME_FIELD_NUMBER = 5;
        private Object fromName_;
        public static final int TITLE_FIELD_NUMBER = 6;
        private Object title_;
        public static final int CONTENT_FIELD_NUMBER = 7;
        private Object content_;
        public static final int CREATEDATE_FIELD_NUMBER = 8;
        private Object createDate_;
        public static final int STATUS_FIELD_NUMBER = 9;
        private int status_;
        public static final int ATTACHMENT_FIELD_NUMBER = 10;
        private List<PlayerOuterClass.Attachment> attachment_;
        public static final int TIMESTAMP_FIELD_NUMBER = 11;
        private Object timeStamp_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<Mail> getParserForType() {
            return PARSER;
        }

        public boolean hasId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getId() {
            return this.id_;
        }

        public boolean hasType() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public int getType() {
            return this.type_;
        }

        public boolean hasFromType() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getFromType() {
            return this.fromType_;
        }

        public boolean hasFromIcon() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public int getFromIcon() {
            return this.fromIcon_;
        }

        public boolean hasFromName() {
            return ((this.bitField0_ & 0x10) == 16);
        }

        public String getFromName() {
            Object ref = this.fromName_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.fromName_ = s;
            return s;
        }

        public ByteString getFromNameBytes() {
            Object ref = this.fromName_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.fromName_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasTitle() {
            return ((this.bitField0_ & 0x20) == 32);
        }

        public String getTitle() {
            Object ref = this.title_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.title_ = s;
            return s;
        }

        public ByteString getTitleBytes() {
            Object ref = this.title_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.title_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasContent() {
            return ((this.bitField0_ & 0x40) == 64);
        }

        public String getContent() {
            Object ref = this.content_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.content_ = s;
            return s;
        }

        public ByteString getContentBytes() {
            Object ref = this.content_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.content_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasCreateDate() {
            return ((this.bitField0_ & 0x80) == 128);
        }

        public String getCreateDate() {
            Object ref = this.createDate_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.createDate_ = s;
            return s;
        }

        public ByteString getCreateDateBytes() {
            Object ref = this.createDate_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.createDate_ = b;
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

        public List<PlayerOuterClass.Attachment> getAttachmentList() {
            return this.attachment_;
        }

        public List<? extends PlayerOuterClass.AttachmentOrBuilder> getAttachmentOrBuilderList() {
            return (List) this.attachment_;
        }

        public int getAttachmentCount() {
            return this.attachment_.size();
        }

        public PlayerOuterClass.Attachment getAttachment(int index) {
            return this.attachment_.get(index);
        }

        public PlayerOuterClass.AttachmentOrBuilder getAttachmentOrBuilder(int index) {
            return this.attachment_.get(index);
        }

        public boolean hasTimeStamp() {
            return ((this.bitField0_ & 0x200) == 512);
        }

        public String getTimeStamp() {
            Object ref = this.timeStamp_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.timeStamp_ = s;
            return s;
        }

        public ByteString getTimeStampBytes() {
            Object ref = this.timeStamp_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.timeStamp_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        private void initFields() {
            this.id_ = 0;
            this.type_ = 0;
            this.fromType_ = 0;
            this.fromIcon_ = 0;
            this.fromName_ = "";
            this.title_ = "";
            this.content_ = "";
            this.createDate_ = "";
            this.status_ = 0;
            this.attachment_ = Collections.emptyList();
            this.timeStamp_ = "";
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasType()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasFromType()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasFromIcon()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasFromName()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasTitle()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasContent()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasCreateDate()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasStatus()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasTimeStamp()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (int i = 0; i < getAttachmentCount(); i++) {
                if (!getAttachment(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.id_);
            if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.type_);
            if ((this.bitField0_ & 0x4) == 4) output.writeInt32(3, this.fromType_);
            if ((this.bitField0_ & 0x8) == 8) output.writeInt32(4, this.fromIcon_);
            if ((this.bitField0_ & 0x10) == 16) output.writeBytes(5, getFromNameBytes());
            if ((this.bitField0_ & 0x20) == 32) output.writeBytes(6, getTitleBytes());
            if ((this.bitField0_ & 0x40) == 64) output.writeBytes(7, getContentBytes());
            if ((this.bitField0_ & 0x80) == 128) output.writeBytes(8, getCreateDateBytes());
            if ((this.bitField0_ & 0x100) == 256) output.writeInt32(9, this.status_);
            for (int i = 0; i < this.attachment_.size(); i++)
                output.writeMessage(10, (MessageLite) this.attachment_.get(i));
            if ((this.bitField0_ & 0x200) == 512) output.writeBytes(11, getTimeStampBytes());
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.id_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(2, this.type_);
            if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeInt32Size(3, this.fromType_);
            if ((this.bitField0_ & 0x8) == 8) size += CodedOutputStream.computeInt32Size(4, this.fromIcon_);
            if ((this.bitField0_ & 0x10) == 16) size += CodedOutputStream.computeBytesSize(5, getFromNameBytes());
            if ((this.bitField0_ & 0x20) == 32) size += CodedOutputStream.computeBytesSize(6, getTitleBytes());
            if ((this.bitField0_ & 0x40) == 64) size += CodedOutputStream.computeBytesSize(7, getContentBytes());
            if ((this.bitField0_ & 0x80) == 128) size += CodedOutputStream.computeBytesSize(8, getCreateDateBytes());
            if ((this.bitField0_ & 0x100) == 256) size += CodedOutputStream.computeInt32Size(9, this.status_);
            for (int i = 0; i < this.attachment_.size(); i++)
                size += CodedOutputStream.computeMessageSize(10, (MessageLite) this.attachment_.get(i));
            if ((this.bitField0_ & 0x200) == 512) size += CodedOutputStream.computeBytesSize(11, getTimeStampBytes());
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

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements PlayerOuterClass.MailOrBuilder {
            private int bitField0_;
            private int id_;
            private int type_;
            private int fromType_;
            private int fromIcon_;
            private Object fromName_;
            private Object title_;
            private Object content_;
            private Object createDate_;
            private int status_;
            private List<PlayerOuterClass.Attachment> attachment_;
            private RepeatedFieldBuilder<PlayerOuterClass.Attachment, PlayerOuterClass.Attachment.Builder, PlayerOuterClass.AttachmentOrBuilder> attachmentBuilder_;
            private Object timeStamp_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PlayerOuterClass.internal_static_pomelo_player_Mail_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PlayerOuterClass.internal_static_pomelo_player_Mail_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerOuterClass.Mail.class, Builder.class);
            }

            private Builder() {
                this.fromName_ = "";
                this.title_ = "";
                this.content_ = "";
                this.createDate_ = "";
                this.attachment_ = Collections.emptyList();
                this.timeStamp_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.fromName_ = "";
                this.title_ = "";
                this.content_ = "";
                this.createDate_ = "";
                this.attachment_ = Collections.emptyList();
                this.timeStamp_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PlayerOuterClass.Mail.alwaysUseFieldBuilders) getAttachmentFieldBuilder();
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.id_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.type_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                this.fromType_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.fromIcon_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                this.fromName_ = "";
                this.bitField0_ &= 0xFFFFFFEF;
                this.title_ = "";
                this.bitField0_ &= 0xFFFFFFDF;
                this.content_ = "";
                this.bitField0_ &= 0xFFFFFFBF;
                this.createDate_ = "";
                this.bitField0_ &= 0xFFFFFF7F;
                this.status_ = 0;
                this.bitField0_ &= 0xFFFFFEFF;
                if (this.attachmentBuilder_ == null) {
                    this.attachment_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFDFF;
                } else {
                    this.attachmentBuilder_.clear();
                }
                this.timeStamp_ = "";
                this.bitField0_ &= 0xFFFFFBFF;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return PlayerOuterClass.internal_static_pomelo_player_Mail_descriptor;
            }

            public PlayerOuterClass.Mail getDefaultInstanceForType() {
                return PlayerOuterClass.Mail.getDefaultInstance();
            }

            public PlayerOuterClass.Mail build() {
                PlayerOuterClass.Mail result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public PlayerOuterClass.Mail buildPartial() {
                PlayerOuterClass.Mail result = new PlayerOuterClass.Mail(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.id_ = this.id_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.type_ = this.type_;
                if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;
                result.fromType_ = this.fromType_;
                if ((from_bitField0_ & 0x8) == 8) to_bitField0_ |= 0x8;
                result.fromIcon_ = this.fromIcon_;
                if ((from_bitField0_ & 0x10) == 16) to_bitField0_ |= 0x10;
                result.fromName_ = this.fromName_;
                if ((from_bitField0_ & 0x20) == 32) to_bitField0_ |= 0x20;
                result.title_ = this.title_;
                if ((from_bitField0_ & 0x40) == 64) to_bitField0_ |= 0x40;
                result.content_ = this.content_;
                if ((from_bitField0_ & 0x80) == 128) to_bitField0_ |= 0x80;
                result.createDate_ = this.createDate_;
                if ((from_bitField0_ & 0x100) == 256) to_bitField0_ |= 0x100;
                result.status_ = this.status_;
                if (this.attachmentBuilder_ == null) {
                    if ((this.bitField0_ & 0x200) == 512) {
                        this.attachment_ = Collections.unmodifiableList(this.attachment_);
                        this.bitField0_ &= 0xFFFFFDFF;
                    }
                    result.attachment_ = this.attachment_;
                } else {
                    result.attachment_ = this.attachmentBuilder_.build();
                }
                if ((from_bitField0_ & 0x400) == 1024) to_bitField0_ |= 0x200;
                result.timeStamp_ = this.timeStamp_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof PlayerOuterClass.Mail) return mergeFrom((PlayerOuterClass.Mail) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PlayerOuterClass.Mail other) {
                if (other == PlayerOuterClass.Mail.getDefaultInstance()) return this;
                if (other.hasId()) setId(other.getId());
                if (other.hasType()) setType(other.getType());
                if (other.hasFromType()) setFromType(other.getFromType());
                if (other.hasFromIcon()) setFromIcon(other.getFromIcon());
                if (other.hasFromName()) {
                    this.bitField0_ |= 0x10;
                    this.fromName_ = other.fromName_;
                    onChanged();
                }
                if (other.hasTitle()) {
                    this.bitField0_ |= 0x20;
                    this.title_ = other.title_;
                    onChanged();
                }
                if (other.hasContent()) {
                    this.bitField0_ |= 0x40;
                    this.content_ = other.content_;
                    onChanged();
                }
                if (other.hasCreateDate()) {
                    this.bitField0_ |= 0x80;
                    this.createDate_ = other.createDate_;
                    onChanged();
                }
                if (other.hasStatus()) setStatus(other.getStatus());
                if (this.attachmentBuilder_ == null) {
                    if (!other.attachment_.isEmpty()) {
                        if (this.attachment_.isEmpty()) {
                            this.attachment_ = other.attachment_;
                            this.bitField0_ &= 0xFFFFFDFF;
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
                        this.bitField0_ &= 0xFFFFFDFF;
                        this.attachmentBuilder_ = PlayerOuterClass.Mail.alwaysUseFieldBuilders ? getAttachmentFieldBuilder() : null;
                    } else {
                        this.attachmentBuilder_.addAllMessages(other.attachment_);
                    }
                }
                if (other.hasTimeStamp()) {
                    this.bitField0_ |= 0x400;
                    this.timeStamp_ = other.timeStamp_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasId()) return false;
                if (!hasType()) return false;
                if (!hasFromType()) return false;
                if (!hasFromIcon()) return false;
                if (!hasFromName()) return false;
                if (!hasTitle()) return false;
                if (!hasContent()) return false;
                if (!hasCreateDate()) return false;
                if (!hasStatus()) return false;
                if (!hasTimeStamp()) return false;
                for (int i = 0; i < getAttachmentCount(); i++) {
                    if (!getAttachment(i).isInitialized()) return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                PlayerOuterClass.Mail parsedMessage = null;
                try {
                    parsedMessage = (PlayerOuterClass.Mail) PlayerOuterClass.Mail.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (PlayerOuterClass.Mail) e.getUnfinishedMessage();
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

            public boolean hasType() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getType() {
                return this.type_;
            }

            public Builder setType(int value) {
                this.bitField0_ |= 0x2;
                this.type_ = value;
                onChanged();
                return this;
            }

            public Builder clearType() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.type_ = 0;
                onChanged();
                return this;
            }

            public boolean hasFromType() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public int getFromType() {
                return this.fromType_;
            }

            public Builder setFromType(int value) {
                this.bitField0_ |= 0x4;
                this.fromType_ = value;
                onChanged();
                return this;
            }

            public Builder clearFromType() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.fromType_ = 0;
                onChanged();
                return this;
            }

            public boolean hasFromIcon() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public int getFromIcon() {
                return this.fromIcon_;
            }

            public Builder setFromIcon(int value) {
                this.bitField0_ |= 0x8;
                this.fromIcon_ = value;
                onChanged();
                return this;
            }

            public Builder clearFromIcon() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.fromIcon_ = 0;
                onChanged();
                return this;
            }

            public boolean hasFromName() {
                return ((this.bitField0_ & 0x10) == 16);
            }

            public String getFromName() {
                Object ref = this.fromName_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) this.fromName_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getFromNameBytes() {
                Object ref = this.fromName_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.fromName_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setFromName(String value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x10;
                this.fromName_ = value;
                onChanged();
                return this;
            }

            public Builder clearFromName() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.fromName_ = PlayerOuterClass.Mail.getDefaultInstance().getFromName();
                onChanged();
                return this;
            }

            public Builder setFromNameBytes(ByteString value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x10;
                this.fromName_ = value;
                onChanged();
                return this;
            }

            public boolean hasTitle() {
                return ((this.bitField0_ & 0x20) == 32);
            }

            public String getTitle() {
                Object ref = this.title_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) this.title_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getTitleBytes() {
                Object ref = this.title_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.title_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setTitle(String value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x20;
                this.title_ = value;
                onChanged();
                return this;
            }

            public Builder clearTitle() {
                this.bitField0_ &= 0xFFFFFFDF;
                this.title_ = PlayerOuterClass.Mail.getDefaultInstance().getTitle();
                onChanged();
                return this;
            }

            public Builder setTitleBytes(ByteString value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x20;
                this.title_ = value;
                onChanged();
                return this;
            }

            public boolean hasContent() {
                return ((this.bitField0_ & 0x40) == 64);
            }

            public String getContent() {
                Object ref = this.content_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) this.content_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getContentBytes() {
                Object ref = this.content_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.content_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setContent(String value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x40;
                this.content_ = value;
                onChanged();
                return this;
            }

            public Builder clearContent() {
                this.bitField0_ &= 0xFFFFFFBF;
                this.content_ = PlayerOuterClass.Mail.getDefaultInstance().getContent();
                onChanged();
                return this;
            }

            public Builder setContentBytes(ByteString value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x40;
                this.content_ = value;
                onChanged();
                return this;
            }

            public boolean hasCreateDate() {
                return ((this.bitField0_ & 0x80) == 128);
            }

            public String getCreateDate() {
                Object ref = this.createDate_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) this.createDate_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getCreateDateBytes() {
                Object ref = this.createDate_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.createDate_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setCreateDate(String value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x80;
                this.createDate_ = value;
                onChanged();
                return this;
            }

            public Builder clearCreateDate() {
                this.bitField0_ &= 0xFFFFFF7F;
                this.createDate_ = PlayerOuterClass.Mail.getDefaultInstance().getCreateDate();
                onChanged();
                return this;
            }

            public Builder setCreateDateBytes(ByteString value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x80;
                this.createDate_ = value;
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

            private void ensureAttachmentIsMutable() {
                if ((this.bitField0_ & 0x200) != 512) {
                    this.attachment_ = new ArrayList<>(this.attachment_);
                    this.bitField0_ |= 0x200;
                }
            }

            public List<PlayerOuterClass.Attachment> getAttachmentList() {
                if (this.attachmentBuilder_ == null) return Collections.unmodifiableList(this.attachment_);
                return this.attachmentBuilder_.getMessageList();
            }

            public int getAttachmentCount() {
                if (this.attachmentBuilder_ == null) return this.attachment_.size();
                return this.attachmentBuilder_.getCount();
            }

            public PlayerOuterClass.Attachment getAttachment(int index) {
                if (this.attachmentBuilder_ == null) return this.attachment_.get(index);
                return (PlayerOuterClass.Attachment) this.attachmentBuilder_.getMessage(index);
            }

            public Builder setAttachment(int index, PlayerOuterClass.Attachment value) {
                if (this.attachmentBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureAttachmentIsMutable();
                    this.attachment_.set(index, value);
                    onChanged();
                } else {
                    this.attachmentBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setAttachment(int index, PlayerOuterClass.Attachment.Builder builderForValue) {
                if (this.attachmentBuilder_ == null) {
                    ensureAttachmentIsMutable();
                    this.attachment_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.attachmentBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAttachment(PlayerOuterClass.Attachment value) {
                if (this.attachmentBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureAttachmentIsMutable();
                    this.attachment_.add(value);
                    onChanged();
                } else {
                    this.attachmentBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addAttachment(int index, PlayerOuterClass.Attachment value) {
                if (this.attachmentBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureAttachmentIsMutable();
                    this.attachment_.add(index, value);
                    onChanged();
                } else {
                    this.attachmentBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addAttachment(PlayerOuterClass.Attachment.Builder builderForValue) {
                if (this.attachmentBuilder_ == null) {
                    ensureAttachmentIsMutable();
                    this.attachment_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.attachmentBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addAttachment(int index, PlayerOuterClass.Attachment.Builder builderForValue) {
                if (this.attachmentBuilder_ == null) {
                    ensureAttachmentIsMutable();
                    this.attachment_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.attachmentBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllAttachment(Iterable<? extends PlayerOuterClass.Attachment> values) {
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
                    this.bitField0_ &= 0xFFFFFDFF;
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

            public PlayerOuterClass.Attachment.Builder getAttachmentBuilder(int index) {
                return (PlayerOuterClass.Attachment.Builder) getAttachmentFieldBuilder().getBuilder(index);
            }

            public PlayerOuterClass.AttachmentOrBuilder getAttachmentOrBuilder(int index) {
                if (this.attachmentBuilder_ == null) return this.attachment_.get(index);
                return (PlayerOuterClass.AttachmentOrBuilder) this.attachmentBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends PlayerOuterClass.AttachmentOrBuilder> getAttachmentOrBuilderList() {
                if (this.attachmentBuilder_ != null) return this.attachmentBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.attachment_);
            }

            public PlayerOuterClass.Attachment.Builder addAttachmentBuilder() {
                return (PlayerOuterClass.Attachment.Builder) getAttachmentFieldBuilder().addBuilder(PlayerOuterClass.Attachment.getDefaultInstance());
            }

            public PlayerOuterClass.Attachment.Builder addAttachmentBuilder(int index) {
                return (PlayerOuterClass.Attachment.Builder) getAttachmentFieldBuilder().addBuilder(index, PlayerOuterClass.Attachment.getDefaultInstance());
            }

            public List<PlayerOuterClass.Attachment.Builder> getAttachmentBuilderList() {
                return getAttachmentFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<PlayerOuterClass.Attachment, PlayerOuterClass.Attachment.Builder, PlayerOuterClass.AttachmentOrBuilder> getAttachmentFieldBuilder() {
                if (this.attachmentBuilder_ == null) {
                    this.attachmentBuilder_ = new RepeatedFieldBuilder(this.attachment_, ((this.bitField0_ & 0x200) == 512), getParentForChildren(), isClean());
                    this.attachment_ = null;
                }
                return this.attachmentBuilder_;
            }

            public boolean hasTimeStamp() {
                return ((this.bitField0_ & 0x400) == 1024);
            }

            public String getTimeStamp() {
                Object ref = this.timeStamp_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) this.timeStamp_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getTimeStampBytes() {
                Object ref = this.timeStamp_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.timeStamp_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setTimeStamp(String value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x400;
                this.timeStamp_ = value;
                onChanged();
                return this;
            }

            public Builder clearTimeStamp() {
                this.bitField0_ &= 0xFFFFFBFF;
                this.timeStamp_ = PlayerOuterClass.Mail.getDefaultInstance().getTimeStamp();
                onChanged();
                return this;
            }

            public Builder setTimeStampBytes(ByteString value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x400;
                this.timeStamp_ = value;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class SetData
            extends GeneratedMessage
            implements SetDataOrBuilder {
        private static final SetData defaultInstance = new SetData(true);
        private final UnknownFieldSet unknownFields;

        private SetData(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private SetData(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static SetData getDefaultInstance() {
            return defaultInstance;
        }

        public SetData getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SetData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.recvMailSet_ = input.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.teamInviteSet_ = input.readInt32();
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.recvStrangerMsgSet_ = input.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.recvAddFriendSet_ = input.readInt32();
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
            return PlayerOuterClass.internal_static_pomelo_player_SetData_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return PlayerOuterClass.internal_static_pomelo_player_SetData_fieldAccessorTable.ensureFieldAccessorsInitialized(SetData.class, Builder.class);
        }

        public static Parser<SetData> PARSER = (Parser<SetData>) new AbstractParser<SetData>() {
            public PlayerOuterClass.SetData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PlayerOuterClass.SetData(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int RECVMAILSET_FIELD_NUMBER = 1;
        private int recvMailSet_;
        public static final int TEAMINVITESET_FIELD_NUMBER = 2;
        private int teamInviteSet_;
        public static final int RECVSTRANGERMSGSET_FIELD_NUMBER = 3;
        private int recvStrangerMsgSet_;
        public static final int RECVADDFRIENDSET_FIELD_NUMBER = 4;
        private int recvAddFriendSet_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<SetData> getParserForType() {
            return PARSER;
        }

        public boolean hasRecvMailSet() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getRecvMailSet() {
            return this.recvMailSet_;
        }

        public boolean hasTeamInviteSet() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public int getTeamInviteSet() {
            return this.teamInviteSet_;
        }

        public boolean hasRecvStrangerMsgSet() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getRecvStrangerMsgSet() {
            return this.recvStrangerMsgSet_;
        }

        public boolean hasRecvAddFriendSet() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public int getRecvAddFriendSet() {
            return this.recvAddFriendSet_;
        }

        private void initFields() {
            this.recvMailSet_ = 0;
            this.teamInviteSet_ = 0;
            this.recvStrangerMsgSet_ = 0;
            this.recvAddFriendSet_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasRecvMailSet()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasTeamInviteSet()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasRecvStrangerMsgSet()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasRecvAddFriendSet()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.recvMailSet_);
            if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.teamInviteSet_);
            if ((this.bitField0_ & 0x4) == 4) output.writeInt32(3, this.recvStrangerMsgSet_);
            if ((this.bitField0_ & 0x8) == 8) output.writeInt32(4, this.recvAddFriendSet_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.recvMailSet_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(2, this.teamInviteSet_);
            if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeInt32Size(3, this.recvStrangerMsgSet_);
            if ((this.bitField0_ & 0x8) == 8) size += CodedOutputStream.computeInt32Size(4, this.recvAddFriendSet_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static SetData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (SetData) PARSER.parseFrom(data);
        }

        public static SetData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SetData) PARSER.parseFrom(data, extensionRegistry);
        }

        public static SetData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (SetData) PARSER.parseFrom(data);
        }

        public static SetData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SetData) PARSER.parseFrom(data, extensionRegistry);
        }

        public static SetData parseFrom(InputStream input) throws IOException {
            return (SetData) PARSER.parseFrom(input);
        }

        public static SetData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SetData) PARSER.parseFrom(input, extensionRegistry);
        }

        public static SetData parseDelimitedFrom(InputStream input) throws IOException {
            return (SetData) PARSER.parseDelimitedFrom(input);
        }

        public static SetData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SetData) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static SetData parseFrom(CodedInputStream input) throws IOException {
            return (SetData) PARSER.parseFrom(input);
        }

        public static SetData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SetData) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(SetData prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements PlayerOuterClass.SetDataOrBuilder {
            private int bitField0_;
            private int recvMailSet_;
            private int teamInviteSet_;
            private int recvStrangerMsgSet_;
            private int recvAddFriendSet_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PlayerOuterClass.internal_static_pomelo_player_SetData_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PlayerOuterClass.internal_static_pomelo_player_SetData_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerOuterClass.SetData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PlayerOuterClass.SetData.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.recvMailSet_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.teamInviteSet_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                this.recvStrangerMsgSet_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.recvAddFriendSet_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return PlayerOuterClass.internal_static_pomelo_player_SetData_descriptor;
            }

            public PlayerOuterClass.SetData getDefaultInstanceForType() {
                return PlayerOuterClass.SetData.getDefaultInstance();
            }

            public PlayerOuterClass.SetData build() {
                PlayerOuterClass.SetData result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public PlayerOuterClass.SetData buildPartial() {
                PlayerOuterClass.SetData result = new PlayerOuterClass.SetData(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.recvMailSet_ = this.recvMailSet_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.teamInviteSet_ = this.teamInviteSet_;
                if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;
                result.recvStrangerMsgSet_ = this.recvStrangerMsgSet_;
                if ((from_bitField0_ & 0x8) == 8) to_bitField0_ |= 0x8;
                result.recvAddFriendSet_ = this.recvAddFriendSet_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof PlayerOuterClass.SetData) return mergeFrom((PlayerOuterClass.SetData) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PlayerOuterClass.SetData other) {
                if (other == PlayerOuterClass.SetData.getDefaultInstance()) return this;
                if (other.hasRecvMailSet()) setRecvMailSet(other.getRecvMailSet());
                if (other.hasTeamInviteSet()) setTeamInviteSet(other.getTeamInviteSet());
                if (other.hasRecvStrangerMsgSet()) setRecvStrangerMsgSet(other.getRecvStrangerMsgSet());
                if (other.hasRecvAddFriendSet()) setRecvAddFriendSet(other.getRecvAddFriendSet());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasRecvMailSet()) return false;
                if (!hasTeamInviteSet()) return false;
                if (!hasRecvStrangerMsgSet()) return false;
                if (!hasRecvAddFriendSet()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                PlayerOuterClass.SetData parsedMessage = null;
                try {
                    parsedMessage = (PlayerOuterClass.SetData) PlayerOuterClass.SetData.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (PlayerOuterClass.SetData) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasRecvMailSet() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getRecvMailSet() {
                return this.recvMailSet_;
            }

            public Builder setRecvMailSet(int value) {
                this.bitField0_ |= 0x1;
                this.recvMailSet_ = value;
                onChanged();
                return this;
            }

            public Builder clearRecvMailSet() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.recvMailSet_ = 0;
                onChanged();
                return this;
            }

            public boolean hasTeamInviteSet() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getTeamInviteSet() {
                return this.teamInviteSet_;
            }

            public Builder setTeamInviteSet(int value) {
                this.bitField0_ |= 0x2;
                this.teamInviteSet_ = value;
                onChanged();
                return this;
            }

            public Builder clearTeamInviteSet() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.teamInviteSet_ = 0;
                onChanged();
                return this;
            }

            public boolean hasRecvStrangerMsgSet() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public int getRecvStrangerMsgSet() {
                return this.recvStrangerMsgSet_;
            }

            public Builder setRecvStrangerMsgSet(int value) {
                this.bitField0_ |= 0x4;
                this.recvStrangerMsgSet_ = value;
                onChanged();
                return this;
            }

            public Builder clearRecvStrangerMsgSet() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.recvStrangerMsgSet_ = 0;
                onChanged();
                return this;
            }

            public boolean hasRecvAddFriendSet() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public int getRecvAddFriendSet() {
                return this.recvAddFriendSet_;
            }

            public Builder setRecvAddFriendSet(int value) {
                this.bitField0_ |= 0x8;
                this.recvAddFriendSet_ = value;
                onChanged();
                return this;
            }

            public Builder clearRecvAddFriendSet() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.recvAddFriendSet_ = 0;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class HookSetData
            extends GeneratedMessage
            implements HookSetDataOrBuilder {
        private static final HookSetData defaultInstance = new HookSetData(true);
        private final UnknownFieldSet unknownFields;

        private HookSetData(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private HookSetData(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static HookSetData getDefaultInstance() {
            return defaultInstance;
        }

        public HookSetData getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private HookSetData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.hpPercent_ = input.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.mpPercent_ = input.readInt32();
                            break;
                        case 26:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x4;
                            this.hpItemCode_ = bs;
                            break;
                        case 34:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x8;
                            this.mpItemCode_ = bs;
                            break;
                        case 40:
                            this.bitField0_ |= 0x10;
                            this.pkSet_ = input.readInt32();
                            break;
                        case 48:
                            if ((mutable_bitField0_ & 0x20) != 32) {
                                this.meltQcolor_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x20;
                            }
                            this.meltQcolor_.add(Integer.valueOf(input.readInt32()));
                            break;
                        case 50:
                            length = input.readRawVarint32();
                            limit = input.pushLimit(length);
                            if ((mutable_bitField0_ & 0x20) != 32 && input.getBytesUntilLimit() > 0) {
                                this.meltQcolor_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x20;
                            }
                            while (input.getBytesUntilLimit() > 0)
                                this.meltQcolor_.add(Integer.valueOf(input.readInt32()));
                            input.popLimit(limit);
                            break;
                        case 56:
                            this.bitField0_ |= 0x20;
                            this.autoBuyHpItem_ = input.readInt32();
                            break;
                        case 64:
                            this.bitField0_ |= 0x40;
                            this.autoBuyMpItem_ = input.readInt32();
                            break;
                        case 72:
                            this.bitField0_ |= 0x80;
                            this.fieldMaphook_ = input.readInt32();
                            break;
                        case 80:
                            this.bitField0_ |= 0x100;
                            this.areaMaphook_ = input.readInt32();
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x20) == 32)
                    this.meltQcolor_ = Collections.unmodifiableList(this.meltQcolor_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return PlayerOuterClass.internal_static_pomelo_player_HookSetData_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return PlayerOuterClass.internal_static_pomelo_player_HookSetData_fieldAccessorTable.ensureFieldAccessorsInitialized(HookSetData.class, Builder.class);
        }

        public static Parser<HookSetData> PARSER = (Parser<HookSetData>) new AbstractParser<HookSetData>() {
            public PlayerOuterClass.HookSetData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PlayerOuterClass.HookSetData(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int HPPERCENT_FIELD_NUMBER = 1;
        private int hpPercent_;
        public static final int MPPERCENT_FIELD_NUMBER = 2;
        private int mpPercent_;
        public static final int HPITEMCODE_FIELD_NUMBER = 3;
        private Object hpItemCode_;
        public static final int MPITEMCODE_FIELD_NUMBER = 4;
        private Object mpItemCode_;
        public static final int PKSET_FIELD_NUMBER = 5;
        private int pkSet_;
        public static final int MELTQCOLOR_FIELD_NUMBER = 6;
        private List<Integer> meltQcolor_;
        public static final int AUTOBUYHPITEM_FIELD_NUMBER = 7;
        private int autoBuyHpItem_;
        public static final int AUTOBUYMPITEM_FIELD_NUMBER = 8;
        private int autoBuyMpItem_;
        public static final int FIELDMAPHOOK_FIELD_NUMBER = 9;
        private int fieldMaphook_;
        public static final int AREAMAPHOOK_FIELD_NUMBER = 10;
        private int areaMaphook_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<HookSetData> getParserForType() {
            return PARSER;
        }

        public boolean hasHpPercent() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getHpPercent() {
            return this.hpPercent_;
        }

        public boolean hasMpPercent() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public int getMpPercent() {
            return this.mpPercent_;
        }

        public boolean hasHpItemCode() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public String getHpItemCode() {
            Object ref = this.hpItemCode_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.hpItemCode_ = s;
            return s;
        }

        public ByteString getHpItemCodeBytes() {
            Object ref = this.hpItemCode_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.hpItemCode_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasMpItemCode() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public String getMpItemCode() {
            Object ref = this.mpItemCode_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.mpItemCode_ = s;
            return s;
        }

        public ByteString getMpItemCodeBytes() {
            Object ref = this.mpItemCode_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.mpItemCode_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasPkSet() {
            return ((this.bitField0_ & 0x10) == 16);
        }

        public int getPkSet() {
            return this.pkSet_;
        }

        public List<Integer> getMeltQcolorList() {
            return this.meltQcolor_;
        }

        public int getMeltQcolorCount() {
            return this.meltQcolor_.size();
        }

        public int getMeltQcolor(int index) {
            return ((Integer) this.meltQcolor_.get(index)).intValue();
        }

        public boolean hasAutoBuyHpItem() {
            return ((this.bitField0_ & 0x20) == 32);
        }

        public int getAutoBuyHpItem() {
            return this.autoBuyHpItem_;
        }

        public boolean hasAutoBuyMpItem() {
            return ((this.bitField0_ & 0x40) == 64);
        }

        public int getAutoBuyMpItem() {
            return this.autoBuyMpItem_;
        }

        public boolean hasFieldMaphook() {
            return ((this.bitField0_ & 0x80) == 128);
        }

        public int getFieldMaphook() {
            return this.fieldMaphook_;
        }

        public boolean hasAreaMaphook() {
            return ((this.bitField0_ & 0x100) == 256);
        }

        public int getAreaMaphook() {
            return this.areaMaphook_;
        }

        private void initFields() {
            this.hpPercent_ = 0;
            this.mpPercent_ = 0;
            this.hpItemCode_ = "";
            this.mpItemCode_ = "";
            this.pkSet_ = 0;
            this.meltQcolor_ = Collections.emptyList();
            this.autoBuyHpItem_ = 0;
            this.autoBuyMpItem_ = 0;
            this.fieldMaphook_ = 0;
            this.areaMaphook_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasHpPercent()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasMpPercent()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasHpItemCode()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasMpItemCode()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasPkSet()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasFieldMaphook()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasAreaMaphook()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.hpPercent_);
            if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.mpPercent_);
            if ((this.bitField0_ & 0x4) == 4) output.writeBytes(3, getHpItemCodeBytes());
            if ((this.bitField0_ & 0x8) == 8) output.writeBytes(4, getMpItemCodeBytes());
            if ((this.bitField0_ & 0x10) == 16) output.writeInt32(5, this.pkSet_);
            for (int i = 0; i < this.meltQcolor_.size(); i++)
                output.writeInt32(6, ((Integer) this.meltQcolor_.get(i)).intValue());
            if ((this.bitField0_ & 0x20) == 32) output.writeInt32(7, this.autoBuyHpItem_);
            if ((this.bitField0_ & 0x40) == 64) output.writeInt32(8, this.autoBuyMpItem_);
            if ((this.bitField0_ & 0x80) == 128) output.writeInt32(9, this.fieldMaphook_);
            if ((this.bitField0_ & 0x100) == 256) output.writeInt32(10, this.areaMaphook_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.hpPercent_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(2, this.mpPercent_);
            if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeBytesSize(3, getHpItemCodeBytes());
            if ((this.bitField0_ & 0x8) == 8) size += CodedOutputStream.computeBytesSize(4, getMpItemCodeBytes());
            if ((this.bitField0_ & 0x10) == 16) size += CodedOutputStream.computeInt32Size(5, this.pkSet_);
            int dataSize = 0;
            for (int i = 0; i < this.meltQcolor_.size(); i++)
                dataSize += CodedOutputStream.computeInt32SizeNoTag(((Integer) this.meltQcolor_.get(i)).intValue());
            size += dataSize;
            size += 1 * getMeltQcolorList().size();
            if ((this.bitField0_ & 0x20) == 32) size += CodedOutputStream.computeInt32Size(7, this.autoBuyHpItem_);
            if ((this.bitField0_ & 0x40) == 64) size += CodedOutputStream.computeInt32Size(8, this.autoBuyMpItem_);
            if ((this.bitField0_ & 0x80) == 128) size += CodedOutputStream.computeInt32Size(9, this.fieldMaphook_);
            if ((this.bitField0_ & 0x100) == 256) size += CodedOutputStream.computeInt32Size(10, this.areaMaphook_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static HookSetData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (HookSetData) PARSER.parseFrom(data);
        }

        public static HookSetData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (HookSetData) PARSER.parseFrom(data, extensionRegistry);
        }

        public static HookSetData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (HookSetData) PARSER.parseFrom(data);
        }

        public static HookSetData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (HookSetData) PARSER.parseFrom(data, extensionRegistry);
        }

        public static HookSetData parseFrom(InputStream input) throws IOException {
            return (HookSetData) PARSER.parseFrom(input);
        }

        public static HookSetData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HookSetData) PARSER.parseFrom(input, extensionRegistry);
        }

        public static HookSetData parseDelimitedFrom(InputStream input) throws IOException {
            return (HookSetData) PARSER.parseDelimitedFrom(input);
        }

        public static HookSetData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HookSetData) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static HookSetData parseFrom(CodedInputStream input) throws IOException {
            return (HookSetData) PARSER.parseFrom(input);
        }

        public static HookSetData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HookSetData) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(HookSetData prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements PlayerOuterClass.HookSetDataOrBuilder {
            private int bitField0_;
            private int hpPercent_;
            private int mpPercent_;
            private Object hpItemCode_;
            private Object mpItemCode_;
            private int pkSet_;
            private List<Integer> meltQcolor_;
            private int autoBuyHpItem_;
            private int autoBuyMpItem_;
            private int fieldMaphook_;
            private int areaMaphook_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PlayerOuterClass.internal_static_pomelo_player_HookSetData_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PlayerOuterClass.internal_static_pomelo_player_HookSetData_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerOuterClass.HookSetData.class, Builder.class);
            }

            private Builder() {
                this.hpItemCode_ = "";
                this.mpItemCode_ = "";
                this.meltQcolor_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.hpItemCode_ = "";
                this.mpItemCode_ = "";
                this.meltQcolor_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PlayerOuterClass.HookSetData.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.hpPercent_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.mpPercent_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                this.hpItemCode_ = "";
                this.bitField0_ &= 0xFFFFFFFB;
                this.mpItemCode_ = "";
                this.bitField0_ &= 0xFFFFFFF7;
                this.pkSet_ = 0;
                this.bitField0_ &= 0xFFFFFFEF;
                this.meltQcolor_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFDF;
                this.autoBuyHpItem_ = 0;
                this.bitField0_ &= 0xFFFFFFBF;
                this.autoBuyMpItem_ = 0;
                this.bitField0_ &= 0xFFFFFF7F;
                this.fieldMaphook_ = 0;
                this.bitField0_ &= 0xFFFFFEFF;
                this.areaMaphook_ = 0;
                this.bitField0_ &= 0xFFFFFDFF;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return PlayerOuterClass.internal_static_pomelo_player_HookSetData_descriptor;
            }

            public PlayerOuterClass.HookSetData getDefaultInstanceForType() {
                return PlayerOuterClass.HookSetData.getDefaultInstance();
            }

            public PlayerOuterClass.HookSetData build() {
                PlayerOuterClass.HookSetData result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public PlayerOuterClass.HookSetData buildPartial() {
                PlayerOuterClass.HookSetData result = new PlayerOuterClass.HookSetData(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.hpPercent_ = this.hpPercent_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.mpPercent_ = this.mpPercent_;
                if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;
                result.hpItemCode_ = this.hpItemCode_;
                if ((from_bitField0_ & 0x8) == 8) to_bitField0_ |= 0x8;
                result.mpItemCode_ = this.mpItemCode_;
                if ((from_bitField0_ & 0x10) == 16) to_bitField0_ |= 0x10;
                result.pkSet_ = this.pkSet_;
                if ((this.bitField0_ & 0x20) == 32) {
                    this.meltQcolor_ = Collections.unmodifiableList(this.meltQcolor_);
                    this.bitField0_ &= 0xFFFFFFDF;
                }
                result.meltQcolor_ = this.meltQcolor_;
                if ((from_bitField0_ & 0x40) == 64) to_bitField0_ |= 0x20;
                result.autoBuyHpItem_ = this.autoBuyHpItem_;
                if ((from_bitField0_ & 0x80) == 128) to_bitField0_ |= 0x40;
                result.autoBuyMpItem_ = this.autoBuyMpItem_;
                if ((from_bitField0_ & 0x100) == 256) to_bitField0_ |= 0x80;
                result.fieldMaphook_ = this.fieldMaphook_;
                if ((from_bitField0_ & 0x200) == 512) to_bitField0_ |= 0x100;
                result.areaMaphook_ = this.areaMaphook_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof PlayerOuterClass.HookSetData)
                    return mergeFrom((PlayerOuterClass.HookSetData) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PlayerOuterClass.HookSetData other) {
                if (other == PlayerOuterClass.HookSetData.getDefaultInstance()) return this;
                if (other.hasHpPercent()) setHpPercent(other.getHpPercent());
                if (other.hasMpPercent()) setMpPercent(other.getMpPercent());
                if (other.hasHpItemCode()) {
                    this.bitField0_ |= 0x4;
                    this.hpItemCode_ = other.hpItemCode_;
                    onChanged();
                }
                if (other.hasMpItemCode()) {
                    this.bitField0_ |= 0x8;
                    this.mpItemCode_ = other.mpItemCode_;
                    onChanged();
                }
                if (other.hasPkSet()) setPkSet(other.getPkSet());
                if (!other.meltQcolor_.isEmpty()) {
                    if (this.meltQcolor_.isEmpty()) {
                        this.meltQcolor_ = other.meltQcolor_;
                        this.bitField0_ &= 0xFFFFFFDF;
                    } else {
                        ensureMeltQcolorIsMutable();
                        this.meltQcolor_.addAll(other.meltQcolor_);
                    }
                    onChanged();
                }
                if (other.hasAutoBuyHpItem()) setAutoBuyHpItem(other.getAutoBuyHpItem());
                if (other.hasAutoBuyMpItem()) setAutoBuyMpItem(other.getAutoBuyMpItem());
                if (other.hasFieldMaphook()) setFieldMaphook(other.getFieldMaphook());
                if (other.hasAreaMaphook()) setAreaMaphook(other.getAreaMaphook());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasHpPercent()) return false;
                if (!hasMpPercent()) return false;
                if (!hasHpItemCode()) return false;
                if (!hasMpItemCode()) return false;
                if (!hasPkSet()) return false;
                if (!hasFieldMaphook()) return false;
                if (!hasAreaMaphook()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                PlayerOuterClass.HookSetData parsedMessage = null;
                try {
                    parsedMessage = (PlayerOuterClass.HookSetData) PlayerOuterClass.HookSetData.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (PlayerOuterClass.HookSetData) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasHpPercent() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getHpPercent() {
                return this.hpPercent_;
            }

            public Builder setHpPercent(int value) {
                this.bitField0_ |= 0x1;
                this.hpPercent_ = value;
                onChanged();
                return this;
            }

            public Builder clearHpPercent() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.hpPercent_ = 0;
                onChanged();
                return this;
            }

            public boolean hasMpPercent() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getMpPercent() {
                return this.mpPercent_;
            }

            public Builder setMpPercent(int value) {
                this.bitField0_ |= 0x2;
                this.mpPercent_ = value;
                onChanged();
                return this;
            }

            public Builder clearMpPercent() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.mpPercent_ = 0;
                onChanged();
                return this;
            }

            public boolean hasHpItemCode() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public String getHpItemCode() {
                Object ref = this.hpItemCode_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) this.hpItemCode_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getHpItemCodeBytes() {
                Object ref = this.hpItemCode_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.hpItemCode_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setHpItemCode(String value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x4;
                this.hpItemCode_ = value;
                onChanged();
                return this;
            }

            public Builder clearHpItemCode() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.hpItemCode_ = PlayerOuterClass.HookSetData.getDefaultInstance().getHpItemCode();
                onChanged();
                return this;
            }

            public Builder setHpItemCodeBytes(ByteString value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x4;
                this.hpItemCode_ = value;
                onChanged();
                return this;
            }

            public boolean hasMpItemCode() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public String getMpItemCode() {
                Object ref = this.mpItemCode_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) this.mpItemCode_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getMpItemCodeBytes() {
                Object ref = this.mpItemCode_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.mpItemCode_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setMpItemCode(String value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x8;
                this.mpItemCode_ = value;
                onChanged();
                return this;
            }

            public Builder clearMpItemCode() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.mpItemCode_ = PlayerOuterClass.HookSetData.getDefaultInstance().getMpItemCode();
                onChanged();
                return this;
            }

            public Builder setMpItemCodeBytes(ByteString value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x8;
                this.mpItemCode_ = value;
                onChanged();
                return this;
            }

            public boolean hasPkSet() {
                return ((this.bitField0_ & 0x10) == 16);
            }

            public int getPkSet() {
                return this.pkSet_;
            }

            public Builder setPkSet(int value) {
                this.bitField0_ |= 0x10;
                this.pkSet_ = value;
                onChanged();
                return this;
            }

            public Builder clearPkSet() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.pkSet_ = 0;
                onChanged();
                return this;
            }

            private void ensureMeltQcolorIsMutable() {
                if ((this.bitField0_ & 0x20) != 32) {
                    this.meltQcolor_ = new ArrayList<>(this.meltQcolor_);
                    this.bitField0_ |= 0x20;
                }
            }

            public List<Integer> getMeltQcolorList() {
                return Collections.unmodifiableList(this.meltQcolor_);
            }

            public int getMeltQcolorCount() {
                return this.meltQcolor_.size();
            }

            public int getMeltQcolor(int index) {
                return ((Integer) this.meltQcolor_.get(index)).intValue();
            }

            public Builder setMeltQcolor(int index, int value) {
                ensureMeltQcolorIsMutable();
                this.meltQcolor_.set(index, Integer.valueOf(value));
                onChanged();
                return this;
            }

            public Builder addMeltQcolor(int value) {
                ensureMeltQcolorIsMutable();
                this.meltQcolor_.add(Integer.valueOf(value));
                onChanged();
                return this;
            }

            public Builder addAllMeltQcolor(Iterable<? extends Integer> values) {
                ensureMeltQcolorIsMutable();
                AbstractMessageLite.Builder.addAll(values, this.meltQcolor_);
                onChanged();
                return this;
            }

            public Builder clearMeltQcolor() {
                this.meltQcolor_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFDF;
                onChanged();
                return this;
            }

            public boolean hasAutoBuyHpItem() {
                return ((this.bitField0_ & 0x40) == 64);
            }

            public int getAutoBuyHpItem() {
                return this.autoBuyHpItem_;
            }

            public Builder setAutoBuyHpItem(int value) {
                this.bitField0_ |= 0x40;
                this.autoBuyHpItem_ = value;
                onChanged();
                return this;
            }

            public Builder clearAutoBuyHpItem() {
                this.bitField0_ &= 0xFFFFFFBF;
                this.autoBuyHpItem_ = 0;
                onChanged();
                return this;
            }

            public boolean hasAutoBuyMpItem() {
                return ((this.bitField0_ & 0x80) == 128);
            }

            public int getAutoBuyMpItem() {
                return this.autoBuyMpItem_;
            }

            public Builder setAutoBuyMpItem(int value) {
                this.bitField0_ |= 0x80;
                this.autoBuyMpItem_ = value;
                onChanged();
                return this;
            }

            public Builder clearAutoBuyMpItem() {
                this.bitField0_ &= 0xFFFFFF7F;
                this.autoBuyMpItem_ = 0;
                onChanged();
                return this;
            }

            public boolean hasFieldMaphook() {
                return ((this.bitField0_ & 0x100) == 256);
            }

            public int getFieldMaphook() {
                return this.fieldMaphook_;
            }

            public Builder setFieldMaphook(int value) {
                this.bitField0_ |= 0x100;
                this.fieldMaphook_ = value;
                onChanged();
                return this;
            }

            public Builder clearFieldMaphook() {
                this.bitField0_ &= 0xFFFFFEFF;
                this.fieldMaphook_ = 0;
                onChanged();
                return this;
            }

            public boolean hasAreaMaphook() {
                return ((this.bitField0_ & 0x200) == 512);
            }

            public int getAreaMaphook() {
                return this.areaMaphook_;
            }

            public Builder setAreaMaphook(int value) {
                this.bitField0_ |= 0x200;
                this.areaMaphook_ = value;
                onChanged();
                return this;
            }

            public Builder clearAreaMaphook() {
                this.bitField0_ &= 0xFFFFFDFF;
                this.areaMaphook_ = 0;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class FunctionInfo
            extends GeneratedMessage
            implements FunctionInfoOrBuilder {
        private static final FunctionInfo defaultInstance = new FunctionInfo(true);
        private final UnknownFieldSet unknownFields;

        private FunctionInfo(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private FunctionInfo(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static FunctionInfo getDefaultInstance() {
            return defaultInstance;
        }

        public FunctionInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private FunctionInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.funcName_ = bs;
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.openFlag_ = input.readInt32();
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.playFlag_ = input.readInt32();
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
            return PlayerOuterClass.internal_static_pomelo_player_FunctionInfo_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return PlayerOuterClass.internal_static_pomelo_player_FunctionInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(FunctionInfo.class, Builder.class);
        }

        public static Parser<FunctionInfo> PARSER = (Parser<FunctionInfo>) new AbstractParser<FunctionInfo>() {
            public PlayerOuterClass.FunctionInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PlayerOuterClass.FunctionInfo(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int FUNCNAME_FIELD_NUMBER = 1;
        private Object funcName_;
        public static final int OPENFLAG_FIELD_NUMBER = 2;
        private int openFlag_;
        public static final int PLAYFLAG_FIELD_NUMBER = 3;
        private int playFlag_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<FunctionInfo> getParserForType() {
            return PARSER;
        }

        public boolean hasFuncName() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public String getFuncName() {
            Object ref = this.funcName_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.funcName_ = s;
            return s;
        }

        public ByteString getFuncNameBytes() {
            Object ref = this.funcName_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.funcName_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasOpenFlag() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public int getOpenFlag() {
            return this.openFlag_;
        }

        public boolean hasPlayFlag() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getPlayFlag() {
            return this.playFlag_;
        }

        private void initFields() {
            this.funcName_ = "";
            this.openFlag_ = 0;
            this.playFlag_ = 0;
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
            if ((this.bitField0_ & 0x1) == 1) output.writeBytes(1, getFuncNameBytes());
            if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.openFlag_);
            if ((this.bitField0_ & 0x4) == 4) output.writeInt32(3, this.playFlag_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeBytesSize(1, getFuncNameBytes());
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(2, this.openFlag_);
            if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeInt32Size(3, this.playFlag_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static FunctionInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (FunctionInfo) PARSER.parseFrom(data);
        }

        public static FunctionInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FunctionInfo) PARSER.parseFrom(data, extensionRegistry);
        }

        public static FunctionInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (FunctionInfo) PARSER.parseFrom(data);
        }

        public static FunctionInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FunctionInfo) PARSER.parseFrom(data, extensionRegistry);
        }

        public static FunctionInfo parseFrom(InputStream input) throws IOException {
            return (FunctionInfo) PARSER.parseFrom(input);
        }

        public static FunctionInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FunctionInfo) PARSER.parseFrom(input, extensionRegistry);
        }

        public static FunctionInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (FunctionInfo) PARSER.parseDelimitedFrom(input);
        }

        public static FunctionInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FunctionInfo) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static FunctionInfo parseFrom(CodedInputStream input) throws IOException {
            return (FunctionInfo) PARSER.parseFrom(input);
        }

        public static FunctionInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FunctionInfo) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(FunctionInfo prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements PlayerOuterClass.FunctionInfoOrBuilder {
            private int bitField0_;
            private Object funcName_;
            private int openFlag_;
            private int playFlag_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PlayerOuterClass.internal_static_pomelo_player_FunctionInfo_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PlayerOuterClass.internal_static_pomelo_player_FunctionInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerOuterClass.FunctionInfo.class, Builder.class);
            }

            private Builder() {
                this.funcName_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.funcName_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PlayerOuterClass.FunctionInfo.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.funcName_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                this.openFlag_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                this.playFlag_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return PlayerOuterClass.internal_static_pomelo_player_FunctionInfo_descriptor;
            }

            public PlayerOuterClass.FunctionInfo getDefaultInstanceForType() {
                return PlayerOuterClass.FunctionInfo.getDefaultInstance();
            }

            public PlayerOuterClass.FunctionInfo build() {
                PlayerOuterClass.FunctionInfo result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public PlayerOuterClass.FunctionInfo buildPartial() {
                PlayerOuterClass.FunctionInfo result = new PlayerOuterClass.FunctionInfo(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.funcName_ = this.funcName_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.openFlag_ = this.openFlag_;
                if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;
                result.playFlag_ = this.playFlag_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof PlayerOuterClass.FunctionInfo)
                    return mergeFrom((PlayerOuterClass.FunctionInfo) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PlayerOuterClass.FunctionInfo other) {
                if (other == PlayerOuterClass.FunctionInfo.getDefaultInstance()) return this;
                if (other.hasFuncName()) {
                    this.bitField0_ |= 0x1;
                    this.funcName_ = other.funcName_;
                    onChanged();
                }
                if (other.hasOpenFlag()) setOpenFlag(other.getOpenFlag());
                if (other.hasPlayFlag()) setPlayFlag(other.getPlayFlag());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                PlayerOuterClass.FunctionInfo parsedMessage = null;
                try {
                    parsedMessage = (PlayerOuterClass.FunctionInfo) PlayerOuterClass.FunctionInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (PlayerOuterClass.FunctionInfo) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasFuncName() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public String getFuncName() {
                Object ref = this.funcName_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) this.funcName_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getFuncNameBytes() {
                Object ref = this.funcName_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.funcName_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setFuncName(String value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.funcName_ = value;
                onChanged();
                return this;
            }

            public Builder clearFuncName() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.funcName_ = PlayerOuterClass.FunctionInfo.getDefaultInstance().getFuncName();
                onChanged();
                return this;
            }

            public Builder setFuncNameBytes(ByteString value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.funcName_ = value;
                onChanged();
                return this;
            }

            public boolean hasOpenFlag() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getOpenFlag() {
                return this.openFlag_;
            }

            public Builder setOpenFlag(int value) {
                this.bitField0_ |= 0x2;
                this.openFlag_ = value;
                onChanged();
                return this;
            }

            public Builder clearOpenFlag() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.openFlag_ = 0;
                onChanged();
                return this;
            }

            public boolean hasPlayFlag() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public int getPlayFlag() {
                return this.playFlag_;
            }

            public Builder setPlayFlag(int value) {
                this.bitField0_ |= 0x4;
                this.playFlag_ = value;
                onChanged();
                return this;
            }

            public Builder clearPlayFlag() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.playFlag_ = 0;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class Player
            extends GeneratedMessage
            implements PlayerOrBuilder {
        private static final Player defaultInstance = new Player(true);
        private final UnknownFieldSet unknownFields;

        private Player(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Player(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Player getDefaultInstance() {
            return defaultInstance;
        }

        public Player getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Player(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            int mutable_bitField1_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString byteString1;
                    PlayerOuterClass.Stores.Builder builder5;
                    PlayerOuterClass.Equipments.Builder builder4;
                    TaskOuterClass.Tasks.Builder builder3;
                    PlayerOuterClass.OfflineBaseData.Builder builder2;
                    PlayerOuterClass.SetData.Builder builder1;
                    ItemOuterClass.CountItems.Builder builder;
                    PlayerOuterClass.HookSetData.Builder subBuilder;
                    ByteString bs;
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        case 10:
                            byteString1 = input.readBytes();
                            this.bitField0_ |= 0x1;
                            this.id_ = byteString1;
                            break;
                        case 18:
                            byteString1 = input.readBytes();
                            this.bitField0_ |= 0x2;
                            this.uid_ = byteString1;
                            break;
                        case 26:
                            byteString1 = input.readBytes();
                            this.bitField0_ |= 0x4;
                            this.name_ = byteString1;
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.level_ = input.readInt32();
                            break;
                        case 40:
                            this.bitField0_ |= 0x10;
                            this.exp_ = input.readInt64();
                            break;
                        case 48:
                            this.bitField0_ |= 0x20;
                            this.pro_ = input.readInt32();
                            break;
                        case 56:
                            this.bitField0_ |= 0x40;
                            this.sp_ = input.readInt32();
                            break;
                        case 64:
                            this.bitField0_ |= 0x80;
                            this.upOrder_ = input.readInt32();
                            break;
                        case 72:
                            this.bitField0_ |= 0x100;
                            this.classExp_ = input.readInt32();
                            break;
                        case 104:
                            this.bitField0_ |= 0x200;
                            this.gold_ = input.readInt64();
                            break;
                        case 112:
                            this.bitField0_ |= 0x400;
                            this.diamond_ = input.readInt64();
                            break;
                        case 120:
                            this.bitField0_ |= 0x800;
                            this.energy_ = input.readInt32();
                            break;
                        case 128:
                            this.bitField0_ |= 0x1000;
                            this.vip_ = input.readInt32();
                            break;
                        case 136:
                            this.bitField0_ |= 0x2000;
                            this.areaId_ = input.readInt32();
                            break;
                        case 144:
                            this.bitField0_ |= 0x4000;
                            this.hp_ = input.readInt32();
                            break;
                        case 152:
                            this.bitField0_ |= 0x8000;
                            this.mp_ = input.readInt32();
                            break;
                        case 160:
                            this.bitField0_ |= 0x10000;
                            this.needExp_ = input.readInt32();
                            break;
                        case 168:
                            this.bitField0_ |= 0x20000;
                            this.fightPower_ = input.readInt32();
                            break;
                        case 178:
                            builder5 = null;
                            if ((this.bitField0_ & 0x40000) == 262144) builder5 = this.store_.toBuilder();
                            this.store_ = (PlayerOuterClass.Stores) input.readMessage(PlayerOuterClass.Stores.PARSER, extensionRegistry);
                            if (builder5 != null) {
                                builder5.mergeFrom(this.store_);
                                this.store_ = builder5.buildPartial();
                            }
                            this.bitField0_ |= 0x40000;
                            break;
                        case 186:
                            builder4 = null;
                            if ((this.bitField0_ & 0x80000) == 524288) builder4 = this.equipments_.toBuilder();
                            this.equipments_ = (PlayerOuterClass.Equipments) input.readMessage(PlayerOuterClass.Equipments.PARSER, extensionRegistry);
                            if (builder4 != null) {
                                builder4.mergeFrom(this.equipments_);
                                this.equipments_ = builder4.buildPartial();
                            }
                            this.bitField0_ |= 0x80000;
                            break;
                        case 194:
                            builder3 = null;
                            if ((this.bitField0_ & 0x100000) == 1048576) builder3 = this.tasks_.toBuilder();
                            this.tasks_ = (TaskOuterClass.Tasks) input.readMessage(TaskOuterClass.Tasks.PARSER, extensionRegistry);
                            if (builder3 != null) {
                                builder3.mergeFrom(this.tasks_);
                                this.tasks_ = builder3.buildPartial();
                            }
                            this.bitField0_ |= 0x100000;
                            break;
                        case 202:
                            builder2 = null;
                            if ((this.bitField0_ & 0x200000) == 2097152) builder2 = this.offlineBaseData_.toBuilder();
                            this.offlineBaseData_ = (PlayerOuterClass.OfflineBaseData) input.readMessage(PlayerOuterClass.OfflineBaseData.PARSER, extensionRegistry);
                            if (builder2 != null) {
                                builder2.mergeFrom(this.offlineBaseData_);
                                this.offlineBaseData_ = builder2.buildPartial();
                            }
                            this.bitField0_ |= 0x200000;
                            break;
                        case 218:
                            builder1 = null;
                            if ((this.bitField0_ & 0x400000) == 4194304) builder1 = this.setData_.toBuilder();
                            this.setData_ = (PlayerOuterClass.SetData) input.readMessage(PlayerOuterClass.SetData.PARSER, extensionRegistry);
                            if (builder1 != null) {
                                builder1.mergeFrom(this.setData_);
                                this.setData_ = builder1.buildPartial();
                            }
                            this.bitField0_ |= 0x400000;
                            break;
                        case 232:
                            this.bitField0_ |= 0x800000;
                            this.prestige_ = input.readInt32();
                            break;
                        case 240:
                            this.bitField0_ |= 0x1000000;
                            this.juewei_ = input.readInt32();
                            break;
                        case 250:
                            if ((mutable_bitField0_ & 0x2000000) != 33554432) {
                                this.skillKeys_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x2000000;
                            }
                            this.skillKeys_.add(input.readMessage(Common.SkillKeyStruct.PARSER, extensionRegistry));
                            break;
                        case 258:
                            builder = null;
                            if ((this.bitField0_ & 0x2000000) == 33554432) builder = this.countItems_.toBuilder();
                            this.countItems_ = (ItemOuterClass.CountItems) input.readMessage(ItemOuterClass.CountItems.PARSER, extensionRegistry);
                            if (builder != null) {
                                builder.mergeFrom(this.countItems_);
                                this.countItems_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 0x2000000;
                            break;
                        case 264:
                            this.bitField0_ |= 0x4000000;
                            this.ticket_ = input.readInt64();
                            break;
                        case 272:
                            this.bitField0_ |= 0x8000000;
                            this.friendly_ = input.readInt32();
                            break;
                        case 280:
                            this.bitField0_ |= 0x10000000;
                            this.upLevel_ = input.readInt32();
                            break;
                        case 288:
                            this.bitField0_ |= 0x20000000;
                            this.reqLevel_ = input.readInt32();
                            break;
                        case 296:
                            this.bitField0_ |= 0x40000000;
                            this.pkModel_ = input.readInt32();
                            break;
                        case 304:
                            this.bitField0_ |= Integer.MIN_VALUE;
                            this.pkValue_ = input.readInt32();
                            break;
                        case 314:
                            subBuilder = null;
                            if ((this.bitField1_ & 0x1) == 1) subBuilder = this.hookSetData_.toBuilder();
                            this.hookSetData_ = (PlayerOuterClass.HookSetData) input.readMessage(PlayerOuterClass.HookSetData.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.hookSetData_);
                                this.hookSetData_ = subBuilder.buildPartial();
                            }
                            this.bitField1_ |= 0x1;
                            break;
                        case 338:
                            bs = input.readBytes();
                            this.bitField1_ |= 0x2;
                            this.zoneId_ = bs;
                            break;
                        case 344:
                            this.bitField1_ |= 0x4;
                            this.solopoint_ = input.readInt32();
                            break;
                        case 352:
                            this.bitField1_ |= 0x8;
                            this.consumePoint_ = input.readInt32();
                            break;
                        case 360:
                            this.bitField1_ |= 0x10;
                            this.pawnGold_ = input.readInt32();
                            break;
                        case 368:
                            this.bitField1_ |= 0x20;
                            this.petPkModel_ = input.readInt32();
                            break;
                        case 376:
                            this.bitField1_ |= 0x40;
                            this.guildpoint_ = input.readInt32();
                            break;
                        case 386:
                            if ((mutable_bitField1_ & 0x100) != 256) {
                                this.functionList_ = new ArrayList<>();
                                mutable_bitField1_ |= 0x100;
                            }
                            this.functionList_.add(input.readMessage(PlayerOuterClass.FunctionInfo.PARSER, extensionRegistry));
                            break;
                        case 394:
                            if ((mutable_bitField1_ & 0x200) != 512) {
                                this.clientConfig_ = new ArrayList<>();
                                mutable_bitField1_ |= 0x200;
                            }
                            this.clientConfig_.add(input.readMessage(Common.KeyValueStruct.PARSER, extensionRegistry));
                            break;
                        case 402:
                            bs = input.readBytes();
                            this.bitField1_ |= 0x80;
                            this.fightingPetId_ = bs;
                            break;
                        case 408:
                            this.bitField1_ |= 0x100;
                            this.mapId_ = input.readInt32();
                            break;
                        case 418:
                            bs = input.readBytes();
                            this.bitField1_ |= 0x200;
                            this.instanceId_ = bs;
                            break;
                        case 424:
                            this.bitField1_ |= 0x400;
                            this.treasurePoint_ = input.readInt32();
                            break;
                        case 440:
                            this.bitField1_ |= 0x800;
                            this.payGiftData_ = input.readInt32();
                            break;
                        case 450:
                            bs = input.readBytes();
                            if ((mutable_bitField1_ & 0x8000) != 32768) {
                                this.blackList_ = (LazyStringList) new LazyStringArrayList();
                                mutable_bitField1_ |= 0x8000;
                            }
                            this.blackList_.add(bs);
                            break;
                        case 458:
                            if ((mutable_bitField1_ & 0x10000) != 65536) {
                                this.strengthPos_ = new ArrayList<>();
                                mutable_bitField1_ |= 0x10000;
                            }
                            this.strengthPos_.add(input.readMessage(ItemOuterClass.EquipGridStrengthInfo.PARSER, extensionRegistry));
                            break;
                        case 466:
                            bs = input.readBytes();
                            this.bitField1_ |= 0x1000;
                            this.guildId_ = bs;
                            break;
                        case 472:
                            this.bitField1_ |= 0x2000;
                            this.guildPro_ = input.readInt32();
                            break;
                        case 480:
                            this.bitField1_ |= 0x4000;
                            this.openMount_ = input.readInt32();
                            break;
                        case 490:
                            if ((mutable_bitField1_ & 0x100000) != 1048576) {
                                this.fashionInfo_ = new ArrayList<>();
                                mutable_bitField1_ |= 0x100000;
                            }
                            this.fashionInfo_.add(input.readMessage(ItemOuterClass.EquipFashionInfo.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x2000000) == 33554432)
                    this.skillKeys_ = Collections.unmodifiableList(this.skillKeys_);
                if ((mutable_bitField1_ & 0x100) == 256)
                    this.functionList_ = Collections.unmodifiableList(this.functionList_);
                if ((mutable_bitField1_ & 0x200) == 512)
                    this.clientConfig_ = Collections.unmodifiableList(this.clientConfig_);
                if ((mutable_bitField1_ & 0x8000) == 32768) this.blackList_ = this.blackList_.getUnmodifiableView();
                if ((mutable_bitField1_ & 0x10000) == 65536)
                    this.strengthPos_ = Collections.unmodifiableList(this.strengthPos_);
                if ((mutable_bitField1_ & 0x100000) == 1048576)
                    this.fashionInfo_ = Collections.unmodifiableList(this.fashionInfo_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return PlayerOuterClass.internal_static_pomelo_player_Player_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return PlayerOuterClass.internal_static_pomelo_player_Player_fieldAccessorTable.ensureFieldAccessorsInitialized(Player.class, Builder.class);
        }

        public static Parser<Player> PARSER = (Parser<Player>) new AbstractParser<Player>() {
            public PlayerOuterClass.Player parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PlayerOuterClass.Player(input, extensionRegistry);
            }
        };
        private int bitField0_;
        private int bitField1_;
        public static final int ID_FIELD_NUMBER = 1;
        private Object id_;
        public static final int UID_FIELD_NUMBER = 2;
        private Object uid_;
        public static final int NAME_FIELD_NUMBER = 3;
        private Object name_;
        public static final int LEVEL_FIELD_NUMBER = 4;
        private int level_;
        public static final int EXP_FIELD_NUMBER = 5;
        private long exp_;
        public static final int PRO_FIELD_NUMBER = 6;
        private int pro_;
        public static final int SP_FIELD_NUMBER = 7;
        private int sp_;
        public static final int UPORDER_FIELD_NUMBER = 8;
        private int upOrder_;
        public static final int CLASSEXP_FIELD_NUMBER = 9;
        private int classExp_;
        public static final int GOLD_FIELD_NUMBER = 13;
        private long gold_;
        public static final int DIAMOND_FIELD_NUMBER = 14;
        private long diamond_;
        public static final int ENERGY_FIELD_NUMBER = 15;
        private int energy_;
        public static final int VIP_FIELD_NUMBER = 16;
        private int vip_;
        public static final int AREAID_FIELD_NUMBER = 17;
        private int areaId_;
        public static final int HP_FIELD_NUMBER = 18;
        private int hp_;
        public static final int MP_FIELD_NUMBER = 19;
        private int mp_;
        public static final int NEEDEXP_FIELD_NUMBER = 20;
        private int needExp_;
        public static final int FIGHTPOWER_FIELD_NUMBER = 21;
        private int fightPower_;
        public static final int STORE_FIELD_NUMBER = 22;
        private PlayerOuterClass.Stores store_;
        public static final int EQUIPMENTS_FIELD_NUMBER = 23;
        private PlayerOuterClass.Equipments equipments_;
        public static final int TASKS_FIELD_NUMBER = 24;
        private TaskOuterClass.Tasks tasks_;
        public static final int OFFLINEBASEDATA_FIELD_NUMBER = 25;
        private PlayerOuterClass.OfflineBaseData offlineBaseData_;
        public static final int SETDATA_FIELD_NUMBER = 27;
        private PlayerOuterClass.SetData setData_;
        public static final int PRESTIGE_FIELD_NUMBER = 29;
        private int prestige_;
        public static final int JUEWEI_FIELD_NUMBER = 30;
        private int juewei_;
        public static final int SKILLKEYS_FIELD_NUMBER = 31;
        private List<Common.SkillKeyStruct> skillKeys_;
        public static final int COUNTITEMS_FIELD_NUMBER = 32;
        private ItemOuterClass.CountItems countItems_;
        public static final int TICKET_FIELD_NUMBER = 33;
        private long ticket_;
        public static final int FRIENDLY_FIELD_NUMBER = 34;
        private int friendly_;
        public static final int UPLEVEL_FIELD_NUMBER = 35;
        private int upLevel_;
        public static final int REQLEVEL_FIELD_NUMBER = 36;
        private int reqLevel_;
        public static final int PKMODEL_FIELD_NUMBER = 37;
        private int pkModel_;
        public static final int PKVALUE_FIELD_NUMBER = 38;
        private int pkValue_;
        public static final int HOOKSETDATA_FIELD_NUMBER = 39;
        private PlayerOuterClass.HookSetData hookSetData_;
        public static final int ZONEID_FIELD_NUMBER = 42;
        private Object zoneId_;
        public static final int SOLOPOINT_FIELD_NUMBER = 43;
        private int solopoint_;
        public static final int CONSUMEPOINT_FIELD_NUMBER = 44;
        private int consumePoint_;
        public static final int PAWNGOLD_FIELD_NUMBER = 45;
        private int pawnGold_;
        public static final int PETPKMODEL_FIELD_NUMBER = 46;
        private int petPkModel_;
        public static final int GUILDPOINT_FIELD_NUMBER = 47;
        private int guildpoint_;
        public static final int FUNCTIONLIST_FIELD_NUMBER = 48;
        private List<PlayerOuterClass.FunctionInfo> functionList_;
        public static final int CLIENTCONFIG_FIELD_NUMBER = 49;
        private List<Common.KeyValueStruct> clientConfig_;
        public static final int FIGHTINGPETID_FIELD_NUMBER = 50;
        private Object fightingPetId_;
        public static final int MAPID_FIELD_NUMBER = 51;
        private int mapId_;
        public static final int INSTANCEID_FIELD_NUMBER = 52;
        private Object instanceId_;
        public static final int TREASUREPOINT_FIELD_NUMBER = 53;
        private int treasurePoint_;
        public static final int PAYGIFTDATA_FIELD_NUMBER = 55;
        private int payGiftData_;
        public static final int BLACKLIST_FIELD_NUMBER = 56;
        private LazyStringList blackList_;
        public static final int STRENGTHPOS_FIELD_NUMBER = 57;
        private List<ItemOuterClass.EquipGridStrengthInfo> strengthPos_;
        public static final int GUILDID_FIELD_NUMBER = 58;
        private Object guildId_;
        public static final int GUILDPRO_FIELD_NUMBER = 59;
        private int guildPro_;
        public static final int OPENMOUNT_FIELD_NUMBER = 60;
        private int openMount_;
        public static final int FASHIONINFO_FIELD_NUMBER = 61;
        private List<ItemOuterClass.EquipFashionInfo> fashionInfo_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<Player> getParserForType() {
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

        public boolean hasUid() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public String getUid() {
            Object ref = this.uid_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.uid_ = s;
            return s;
        }

        public ByteString getUidBytes() {
            Object ref = this.uid_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.uid_ = b;
                return b;
            }
            return (ByteString) ref;
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

        public boolean hasLevel() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public int getLevel() {
            return this.level_;
        }

        public boolean hasExp() {
            return ((this.bitField0_ & 0x10) == 16);
        }

        public long getExp() {
            return this.exp_;
        }

        public boolean hasPro() {
            return ((this.bitField0_ & 0x20) == 32);
        }

        public int getPro() {
            return this.pro_;
        }

        public boolean hasSp() {
            return ((this.bitField0_ & 0x40) == 64);
        }

        public int getSp() {
            return this.sp_;
        }

        public boolean hasUpOrder() {
            return ((this.bitField0_ & 0x80) == 128);
        }

        static {
            defaultInstance.initFields();
        }

        public int getUpOrder() {
            return this.upOrder_;
        }

        public boolean hasClassExp() {
            return ((this.bitField0_ & 0x100) == 256);
        }

        public int getClassExp() {
            return this.classExp_;
        }

        public boolean hasGold() {
            return ((this.bitField0_ & 0x200) == 512);
        }

        public long getGold() {
            return this.gold_;
        }

        public boolean hasDiamond() {
            return ((this.bitField0_ & 0x400) == 1024);
        }

        public long getDiamond() {
            return this.diamond_;
        }

        public boolean hasEnergy() {
            return ((this.bitField0_ & 0x800) == 2048);
        }

        public int getEnergy() {
            return this.energy_;
        }

        public boolean hasVip() {
            return ((this.bitField0_ & 0x1000) == 4096);
        }

        public int getVip() {
            return this.vip_;
        }

        public boolean hasAreaId() {
            return ((this.bitField0_ & 0x2000) == 8192);
        }

        public int getAreaId() {
            return this.areaId_;
        }

        public boolean hasHp() {
            return ((this.bitField0_ & 0x4000) == 16384);
        }

        public int getHp() {
            return this.hp_;
        }

        public boolean hasMp() {
            return ((this.bitField0_ & 0x8000) == 32768);
        }

        public int getMp() {
            return this.mp_;
        }

        public boolean hasNeedExp() {
            return ((this.bitField0_ & 0x10000) == 65536);
        }

        public int getNeedExp() {
            return this.needExp_;
        }

        public boolean hasFightPower() {
            return ((this.bitField0_ & 0x20000) == 131072);
        }

        public int getFightPower() {
            return this.fightPower_;
        }

        public boolean hasStore() {
            return ((this.bitField0_ & 0x40000) == 262144);
        }

        public PlayerOuterClass.Stores getStore() {
            return this.store_;
        }

        public PlayerOuterClass.StoresOrBuilder getStoreOrBuilder() {
            return this.store_;
        }

        public boolean hasEquipments() {
            return ((this.bitField0_ & 0x80000) == 524288);
        }

        public PlayerOuterClass.Equipments getEquipments() {
            return this.equipments_;
        }

        public PlayerOuterClass.EquipmentsOrBuilder getEquipmentsOrBuilder() {
            return this.equipments_;
        }

        public boolean hasTasks() {
            return ((this.bitField0_ & 0x100000) == 1048576);
        }

        public TaskOuterClass.Tasks getTasks() {
            return this.tasks_;
        }

        public TaskOuterClass.TasksOrBuilder getTasksOrBuilder() {
            return (TaskOuterClass.TasksOrBuilder) this.tasks_;
        }

        public boolean hasOfflineBaseData() {
            return ((this.bitField0_ & 0x200000) == 2097152);
        }

        public PlayerOuterClass.OfflineBaseData getOfflineBaseData() {
            return this.offlineBaseData_;
        }

        public PlayerOuterClass.OfflineBaseDataOrBuilder getOfflineBaseDataOrBuilder() {
            return this.offlineBaseData_;
        }

        public boolean hasSetData() {
            return ((this.bitField0_ & 0x400000) == 4194304);
        }

        public PlayerOuterClass.SetData getSetData() {
            return this.setData_;
        }

        public PlayerOuterClass.SetDataOrBuilder getSetDataOrBuilder() {
            return this.setData_;
        }

        public boolean hasPrestige() {
            return ((this.bitField0_ & 0x800000) == 8388608);
        }

        public int getPrestige() {
            return this.prestige_;
        }

        public boolean hasJuewei() {
            return ((this.bitField0_ & 0x1000000) == 16777216);
        }

        public int getJuewei() {
            return this.juewei_;
        }

        public List<Common.SkillKeyStruct> getSkillKeysList() {
            return this.skillKeys_;
        }

        public List<? extends Common.SkillKeyStructOrBuilder> getSkillKeysOrBuilderList() {
            return (List) this.skillKeys_;
        }

        public int getSkillKeysCount() {
            return this.skillKeys_.size();
        }

        public Common.SkillKeyStruct getSkillKeys(int index) {
            return this.skillKeys_.get(index);
        }

        public Common.SkillKeyStructOrBuilder getSkillKeysOrBuilder(int index) {
            return (Common.SkillKeyStructOrBuilder) this.skillKeys_.get(index);
        }

        public boolean hasCountItems() {
            return ((this.bitField0_ & 0x2000000) == 33554432);
        }

        public ItemOuterClass.CountItems getCountItems() {
            return this.countItems_;
        }

        public ItemOuterClass.CountItemsOrBuilder getCountItemsOrBuilder() {
            return (ItemOuterClass.CountItemsOrBuilder) this.countItems_;
        }

        public boolean hasTicket() {
            return ((this.bitField0_ & 0x4000000) == 67108864);
        }

        public long getTicket() {
            return this.ticket_;
        }

        public boolean hasFriendly() {
            return ((this.bitField0_ & 0x8000000) == 134217728);
        }

        public int getFriendly() {
            return this.friendly_;
        }

        public boolean hasUpLevel() {
            return ((this.bitField0_ & 0x10000000) == 268435456);
        }

        public int getUpLevel() {
            return this.upLevel_;
        }

        public boolean hasReqLevel() {
            return ((this.bitField0_ & 0x20000000) == 536870912);
        }

        public int getReqLevel() {
            return this.reqLevel_;
        }

        public boolean hasPkModel() {
            return ((this.bitField0_ & 0x40000000) == 1073741824);
        }

        public int getPkModel() {
            return this.pkModel_;
        }

        public boolean hasPkValue() {
            return ((this.bitField0_ & Integer.MIN_VALUE) == Integer.MIN_VALUE);
        }

        public int getPkValue() {
            return this.pkValue_;
        }

        public boolean hasHookSetData() {
            return ((this.bitField1_ & 0x1) == 1);
        }

        public PlayerOuterClass.HookSetData getHookSetData() {
            return this.hookSetData_;
        }

        public PlayerOuterClass.HookSetDataOrBuilder getHookSetDataOrBuilder() {
            return this.hookSetData_;
        }

        public boolean hasZoneId() {
            return ((this.bitField1_ & 0x2) == 2);
        }

        public String getZoneId() {
            Object ref = this.zoneId_;
            if (ref instanceof String)
                return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8())
                this.zoneId_ = s;
            return s;
        }

        public ByteString getZoneIdBytes() {
            Object ref = this.zoneId_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.zoneId_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasSolopoint() {
            return ((this.bitField1_ & 0x4) == 4);
        }

        public int getSolopoint() {
            return this.solopoint_;
        }

        public boolean hasConsumePoint() {
            return ((this.bitField1_ & 0x8) == 8);
        }

        public int getConsumePoint() {
            return this.consumePoint_;
        }

        public boolean hasPawnGold() {
            return ((this.bitField1_ & 0x10) == 16);
        }

        public int getPawnGold() {
            return this.pawnGold_;
        }

        public boolean hasPetPkModel() {
            return ((this.bitField1_ & 0x20) == 32);
        }

        public int getPetPkModel() {
            return this.petPkModel_;
        }

        public boolean hasGuildpoint() {
            return ((this.bitField1_ & 0x40) == 64);
        }

        public int getGuildpoint() {
            return this.guildpoint_;
        }

        public List<PlayerOuterClass.FunctionInfo> getFunctionListList() {
            return this.functionList_;
        }

        public List<? extends PlayerOuterClass.FunctionInfoOrBuilder> getFunctionListOrBuilderList() {
            return (List) this.functionList_;
        }

        public int getFunctionListCount() {
            return this.functionList_.size();
        }

        public PlayerOuterClass.FunctionInfo getFunctionList(int index) {
            return this.functionList_.get(index);
        }

        public PlayerOuterClass.FunctionInfoOrBuilder getFunctionListOrBuilder(int index) {
            return this.functionList_.get(index);
        }

        public List<Common.KeyValueStruct> getClientConfigList() {
            return this.clientConfig_;
        }

        public List<? extends Common.KeyValueStructOrBuilder> getClientConfigOrBuilderList() {
            return (List) this.clientConfig_;
        }

        public int getClientConfigCount() {
            return this.clientConfig_.size();
        }

        public Common.KeyValueStruct getClientConfig(int index) {
            return this.clientConfig_.get(index);
        }

        public Common.KeyValueStructOrBuilder getClientConfigOrBuilder(int index) {
            return (Common.KeyValueStructOrBuilder) this.clientConfig_.get(index);
        }

        public boolean hasFightingPetId() {
            return ((this.bitField1_ & 0x80) == 128);
        }

        public String getFightingPetId() {
            Object ref = this.fightingPetId_;
            if (ref instanceof String)
                return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8())
                this.fightingPetId_ = s;
            return s;
        }

        public ByteString getFightingPetIdBytes() {
            Object ref = this.fightingPetId_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.fightingPetId_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasMapId() {
            return ((this.bitField1_ & 0x100) == 256);
        }

        public int getMapId() {
            return this.mapId_;
        }

        public boolean hasInstanceId() {
            return ((this.bitField1_ & 0x200) == 512);
        }

        public String getInstanceId() {
            Object ref = this.instanceId_;
            if (ref instanceof String)
                return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8())
                this.instanceId_ = s;
            return s;
        }

        public ByteString getInstanceIdBytes() {
            Object ref = this.instanceId_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.instanceId_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasTreasurePoint() {
            return ((this.bitField1_ & 0x400) == 1024);
        }

        public int getTreasurePoint() {
            return this.treasurePoint_;
        }

        public boolean hasPayGiftData() {
            return ((this.bitField1_ & 0x800) == 2048);
        }

        public int getPayGiftData() {
            return this.payGiftData_;
        }

        public ProtocolStringList getBlackListList() {
            return (ProtocolStringList) this.blackList_;
        }

        public int getBlackListCount() {
            return this.blackList_.size();
        }

        public String getBlackList(int index) {
            return (String) this.blackList_.get(index);
        }

        public ByteString getBlackListBytes(int index) {
            return this.blackList_.getByteString(index);
        }

        public List<ItemOuterClass.EquipGridStrengthInfo> getStrengthPosList() {
            return this.strengthPos_;
        }

        public List<? extends ItemOuterClass.EquipGridStrengthInfoOrBuilder> getStrengthPosOrBuilderList() {
            return (List) this.strengthPos_;
        }

        public int getStrengthPosCount() {
            return this.strengthPos_.size();
        }

        public ItemOuterClass.EquipGridStrengthInfo getStrengthPos(int index) {
            return this.strengthPos_.get(index);
        }

        public ItemOuterClass.EquipGridStrengthInfoOrBuilder getStrengthPosOrBuilder(int index) {
            return (ItemOuterClass.EquipGridStrengthInfoOrBuilder) this.strengthPos_.get(index);
        }

        public boolean hasGuildId() {
            return ((this.bitField1_ & 0x1000) == 4096);
        }

        public String getGuildId() {
            Object ref = this.guildId_;
            if (ref instanceof String)
                return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8())
                this.guildId_ = s;
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

        public boolean hasGuildPro() {
            return ((this.bitField1_ & 0x2000) == 8192);
        }

        public int getGuildPro() {
            return this.guildPro_;
        }

        public boolean hasOpenMount() {
            return ((this.bitField1_ & 0x4000) == 16384);
        }

        public int getOpenMount() {
            return this.openMount_;
        }

        public List<ItemOuterClass.EquipFashionInfo> getFashionInfoList() {
            return this.fashionInfo_;
        }

        public List<? extends ItemOuterClass.EquipFashionInfoOrBuilder> getFashionInfoOrBuilderList() {
            return (List) this.fashionInfo_;
        }

        public int getFashionInfoCount() {
            return this.fashionInfo_.size();
        }

        public ItemOuterClass.EquipFashionInfo getFashionInfo(int index) {
            return this.fashionInfo_.get(index);
        }

        public ItemOuterClass.EquipFashionInfoOrBuilder getFashionInfoOrBuilder(int index) {
            return (ItemOuterClass.EquipFashionInfoOrBuilder) this.fashionInfo_.get(index);
        }

        private void initFields() {
            this.id_ = "";
            this.uid_ = "";
            this.name_ = "";
            this.level_ = 0;
            this.exp_ = 0L;
            this.pro_ = 0;
            this.sp_ = 0;
            this.upOrder_ = 0;
            this.classExp_ = 0;
            this.gold_ = 0L;
            this.diamond_ = 0L;
            this.energy_ = 0;
            this.vip_ = 0;
            this.areaId_ = 0;
            this.hp_ = 0;
            this.mp_ = 0;
            this.needExp_ = 0;
            this.fightPower_ = 0;
            this.store_ = PlayerOuterClass.Stores.getDefaultInstance();
            this.equipments_ = PlayerOuterClass.Equipments.getDefaultInstance();
            this.tasks_ = TaskOuterClass.Tasks.getDefaultInstance();
            this.offlineBaseData_ = PlayerOuterClass.OfflineBaseData.getDefaultInstance();
            this.setData_ = PlayerOuterClass.SetData.getDefaultInstance();
            this.prestige_ = 0;
            this.juewei_ = 0;
            this.skillKeys_ = Collections.emptyList();
            this.countItems_ = ItemOuterClass.CountItems.getDefaultInstance();
            this.ticket_ = 0L;
            this.friendly_ = 0;
            this.upLevel_ = 0;
            this.reqLevel_ = 0;
            this.pkModel_ = 0;
            this.pkValue_ = 0;
            this.hookSetData_ = PlayerOuterClass.HookSetData.getDefaultInstance();
            this.zoneId_ = "";
            this.solopoint_ = 0;
            this.consumePoint_ = 0;
            this.pawnGold_ = 0;
            this.petPkModel_ = 0;
            this.guildpoint_ = 0;
            this.functionList_ = Collections.emptyList();
            this.clientConfig_ = Collections.emptyList();
            this.fightingPetId_ = "";
            this.mapId_ = 0;
            this.instanceId_ = "";
            this.treasurePoint_ = 0;
            this.payGiftData_ = 0;
            this.blackList_ = LazyStringArrayList.EMPTY;
            this.strengthPos_ = Collections.emptyList();
            this.guildId_ = "";
            this.guildPro_ = 0;
            this.openMount_ = 0;
            this.fashionInfo_ = Collections.emptyList();
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
            if (hasStore() && !getStore().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (hasEquipments() && !getEquipments().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (hasTasks() && !getTasks().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (hasOfflineBaseData() && !getOfflineBaseData().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (hasSetData() && !getSetData().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            int i;
            for (i = 0; i < getSkillKeysCount(); i++) {
                if (!getSkillKeys(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            if (hasCountItems() && !getCountItems().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (hasHookSetData() && !getHookSetData().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (i = 0; i < getClientConfigCount(); i++) {
                if (!getClientConfig(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (i = 0; i < getStrengthPosCount(); i++) {
                if (!getStrengthPos(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (i = 0; i < getFashionInfoCount(); i++) {
                if (!getFashionInfo(i).isInitialized()) {
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
                output.writeBytes(2, getUidBytes());
            if ((this.bitField0_ & 0x4) == 4)
                output.writeBytes(3, getNameBytes());
            if ((this.bitField0_ & 0x8) == 8)
                output.writeInt32(4, this.level_);
            if ((this.bitField0_ & 0x10) == 16)
                output.writeInt64(5, this.exp_);
            if ((this.bitField0_ & 0x20) == 32)
                output.writeInt32(6, this.pro_);
            if ((this.bitField0_ & 0x40) == 64)
                output.writeInt32(7, this.sp_);
            if ((this.bitField0_ & 0x80) == 128)
                output.writeInt32(8, this.upOrder_);
            if ((this.bitField0_ & 0x100) == 256)
                output.writeInt32(9, this.classExp_);
            if ((this.bitField0_ & 0x200) == 512)
                output.writeInt64(13, this.gold_);
            if ((this.bitField0_ & 0x400) == 1024)
                output.writeInt64(14, this.diamond_);
            if ((this.bitField0_ & 0x800) == 2048)
                output.writeInt32(15, this.energy_);
            if ((this.bitField0_ & 0x1000) == 4096)
                output.writeInt32(16, this.vip_);
            if ((this.bitField0_ & 0x2000) == 8192)
                output.writeInt32(17, this.areaId_);
            if ((this.bitField0_ & 0x4000) == 16384)
                output.writeInt32(18, this.hp_);
            if ((this.bitField0_ & 0x8000) == 32768)
                output.writeInt32(19, this.mp_);
            if ((this.bitField0_ & 0x10000) == 65536)
                output.writeInt32(20, this.needExp_);
            if ((this.bitField0_ & 0x20000) == 131072)
                output.writeInt32(21, this.fightPower_);
            if ((this.bitField0_ & 0x40000) == 262144)
                output.writeMessage(22, (MessageLite) this.store_);
            if ((this.bitField0_ & 0x80000) == 524288)
                output.writeMessage(23, (MessageLite) this.equipments_);
            if ((this.bitField0_ & 0x100000) == 1048576)
                output.writeMessage(24, (MessageLite) this.tasks_);
            if ((this.bitField0_ & 0x200000) == 2097152)
                output.writeMessage(25, (MessageLite) this.offlineBaseData_);
            if ((this.bitField0_ & 0x400000) == 4194304)
                output.writeMessage(27, (MessageLite) this.setData_);
            if ((this.bitField0_ & 0x800000) == 8388608)
                output.writeInt32(29, this.prestige_);
            if ((this.bitField0_ & 0x1000000) == 16777216)
                output.writeInt32(30, this.juewei_);
            int i;
            for (i = 0; i < this.skillKeys_.size(); i++)
                output.writeMessage(31, (MessageLite) this.skillKeys_.get(i));
            if ((this.bitField0_ & 0x2000000) == 33554432)
                output.writeMessage(32, (MessageLite) this.countItems_);
            if ((this.bitField0_ & 0x4000000) == 67108864)
                output.writeInt64(33, this.ticket_);
            if ((this.bitField0_ & 0x8000000) == 134217728)
                output.writeInt32(34, this.friendly_);
            if ((this.bitField0_ & 0x10000000) == 268435456)
                output.writeInt32(35, this.upLevel_);
            if ((this.bitField0_ & 0x20000000) == 536870912)
                output.writeInt32(36, this.reqLevel_);
            if ((this.bitField0_ & 0x40000000) == 1073741824)
                output.writeInt32(37, this.pkModel_);
            if ((this.bitField0_ & Integer.MIN_VALUE) == Integer.MIN_VALUE)
                output.writeInt32(38, this.pkValue_);
            if ((this.bitField1_ & 0x1) == 1)
                output.writeMessage(39, (MessageLite) this.hookSetData_);
            if ((this.bitField1_ & 0x2) == 2)
                output.writeBytes(42, getZoneIdBytes());
            if ((this.bitField1_ & 0x4) == 4)
                output.writeInt32(43, this.solopoint_);
            if ((this.bitField1_ & 0x8) == 8)
                output.writeInt32(44, this.consumePoint_);
            if ((this.bitField1_ & 0x10) == 16)
                output.writeInt32(45, this.pawnGold_);
            if ((this.bitField1_ & 0x20) == 32)
                output.writeInt32(46, this.petPkModel_);
            if ((this.bitField1_ & 0x40) == 64)
                output.writeInt32(47, this.guildpoint_);
            for (i = 0; i < this.functionList_.size(); i++)
                output.writeMessage(48, (MessageLite) this.functionList_.get(i));
            for (i = 0; i < this.clientConfig_.size(); i++)
                output.writeMessage(49, (MessageLite) this.clientConfig_.get(i));
            if ((this.bitField1_ & 0x80) == 128)
                output.writeBytes(50, getFightingPetIdBytes());
            if ((this.bitField1_ & 0x100) == 256)
                output.writeInt32(51, this.mapId_);
            if ((this.bitField1_ & 0x200) == 512)
                output.writeBytes(52, getInstanceIdBytes());
            if ((this.bitField1_ & 0x400) == 1024)
                output.writeInt32(53, this.treasurePoint_);
            if ((this.bitField1_ & 0x800) == 2048)
                output.writeInt32(55, this.payGiftData_);
            for (i = 0; i < this.blackList_.size(); i++)
                output.writeBytes(56, this.blackList_.getByteString(i));
            for (i = 0; i < this.strengthPos_.size(); i++)
                output.writeMessage(57, (MessageLite) this.strengthPos_.get(i));
            if ((this.bitField1_ & 0x1000) == 4096)
                output.writeBytes(58, getGuildIdBytes());
            if ((this.bitField1_ & 0x2000) == 8192)
                output.writeInt32(59, this.guildPro_);
            if ((this.bitField1_ & 0x4000) == 16384)
                output.writeInt32(60, this.openMount_);
            for (i = 0; i < this.fashionInfo_.size(); i++)
                output.writeMessage(61, (MessageLite) this.fashionInfo_.get(i));
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
                size += CodedOutputStream.computeBytesSize(2, getUidBytes());
            if ((this.bitField0_ & 0x4) == 4)
                size += CodedOutputStream.computeBytesSize(3, getNameBytes());
            if ((this.bitField0_ & 0x8) == 8)
                size += CodedOutputStream.computeInt32Size(4, this.level_);
            if ((this.bitField0_ & 0x10) == 16)
                size += CodedOutputStream.computeInt64Size(5, this.exp_);
            if ((this.bitField0_ & 0x20) == 32)
                size += CodedOutputStream.computeInt32Size(6, this.pro_);
            if ((this.bitField0_ & 0x40) == 64)
                size += CodedOutputStream.computeInt32Size(7, this.sp_);
            if ((this.bitField0_ & 0x80) == 128)
                size += CodedOutputStream.computeInt32Size(8, this.upOrder_);
            if ((this.bitField0_ & 0x100) == 256)
                size += CodedOutputStream.computeInt32Size(9, this.classExp_);
            if ((this.bitField0_ & 0x200) == 512)
                size += CodedOutputStream.computeInt64Size(13, this.gold_);
            if ((this.bitField0_ & 0x400) == 1024)
                size += CodedOutputStream.computeInt64Size(14, this.diamond_);
            if ((this.bitField0_ & 0x800) == 2048)
                size += CodedOutputStream.computeInt32Size(15, this.energy_);
            if ((this.bitField0_ & 0x1000) == 4096)
                size += CodedOutputStream.computeInt32Size(16, this.vip_);
            if ((this.bitField0_ & 0x2000) == 8192)
                size += CodedOutputStream.computeInt32Size(17, this.areaId_);
            if ((this.bitField0_ & 0x4000) == 16384)
                size += CodedOutputStream.computeInt32Size(18, this.hp_);
            if ((this.bitField0_ & 0x8000) == 32768)
                size += CodedOutputStream.computeInt32Size(19, this.mp_);
            if ((this.bitField0_ & 0x10000) == 65536)
                size += CodedOutputStream.computeInt32Size(20, this.needExp_);
            if ((this.bitField0_ & 0x20000) == 131072)
                size += CodedOutputStream.computeInt32Size(21, this.fightPower_);
            if ((this.bitField0_ & 0x40000) == 262144)
                size += CodedOutputStream.computeMessageSize(22, (MessageLite) this.store_);
            if ((this.bitField0_ & 0x80000) == 524288)
                size += CodedOutputStream.computeMessageSize(23, (MessageLite) this.equipments_);
            if ((this.bitField0_ & 0x100000) == 1048576)
                size += CodedOutputStream.computeMessageSize(24, (MessageLite) this.tasks_);
            if ((this.bitField0_ & 0x200000) == 2097152)
                size += CodedOutputStream.computeMessageSize(25, (MessageLite) this.offlineBaseData_);
            if ((this.bitField0_ & 0x400000) == 4194304)
                size += CodedOutputStream.computeMessageSize(27, (MessageLite) this.setData_);
            if ((this.bitField0_ & 0x800000) == 8388608)
                size += CodedOutputStream.computeInt32Size(29, this.prestige_);
            if ((this.bitField0_ & 0x1000000) == 16777216)
                size += CodedOutputStream.computeInt32Size(30, this.juewei_);
            int j;
            for (j = 0; j < this.skillKeys_.size(); j++)
                size += CodedOutputStream.computeMessageSize(31, (MessageLite) this.skillKeys_.get(j));
            if ((this.bitField0_ & 0x2000000) == 33554432)
                size += CodedOutputStream.computeMessageSize(32, (MessageLite) this.countItems_);
            if ((this.bitField0_ & 0x4000000) == 67108864)
                size += CodedOutputStream.computeInt64Size(33, this.ticket_);
            if ((this.bitField0_ & 0x8000000) == 134217728)
                size += CodedOutputStream.computeInt32Size(34, this.friendly_);
            if ((this.bitField0_ & 0x10000000) == 268435456)
                size += CodedOutputStream.computeInt32Size(35, this.upLevel_);
            if ((this.bitField0_ & 0x20000000) == 536870912)
                size += CodedOutputStream.computeInt32Size(36, this.reqLevel_);
            if ((this.bitField0_ & 0x40000000) == 1073741824)
                size += CodedOutputStream.computeInt32Size(37, this.pkModel_);
            if ((this.bitField0_ & Integer.MIN_VALUE) == Integer.MIN_VALUE)
                size += CodedOutputStream.computeInt32Size(38, this.pkValue_);
            if ((this.bitField1_ & 0x1) == 1)
                size += CodedOutputStream.computeMessageSize(39, (MessageLite) this.hookSetData_);
            if ((this.bitField1_ & 0x2) == 2)
                size += CodedOutputStream.computeBytesSize(42, getZoneIdBytes());
            if ((this.bitField1_ & 0x4) == 4)
                size += CodedOutputStream.computeInt32Size(43, this.solopoint_);
            if ((this.bitField1_ & 0x8) == 8)
                size += CodedOutputStream.computeInt32Size(44, this.consumePoint_);
            if ((this.bitField1_ & 0x10) == 16)
                size += CodedOutputStream.computeInt32Size(45, this.pawnGold_);
            if ((this.bitField1_ & 0x20) == 32)
                size += CodedOutputStream.computeInt32Size(46, this.petPkModel_);
            if ((this.bitField1_ & 0x40) == 64)
                size += CodedOutputStream.computeInt32Size(47, this.guildpoint_);
            for (j = 0; j < this.functionList_.size(); j++)
                size += CodedOutputStream.computeMessageSize(48, (MessageLite) this.functionList_.get(j));
            for (j = 0; j < this.clientConfig_.size(); j++)
                size += CodedOutputStream.computeMessageSize(49, (MessageLite) this.clientConfig_.get(j));
            if ((this.bitField1_ & 0x80) == 128)
                size += CodedOutputStream.computeBytesSize(50, getFightingPetIdBytes());
            if ((this.bitField1_ & 0x100) == 256)
                size += CodedOutputStream.computeInt32Size(51, this.mapId_);
            if ((this.bitField1_ & 0x200) == 512)
                size += CodedOutputStream.computeBytesSize(52, getInstanceIdBytes());
            if ((this.bitField1_ & 0x400) == 1024)
                size += CodedOutputStream.computeInt32Size(53, this.treasurePoint_);
            if ((this.bitField1_ & 0x800) == 2048)
                size += CodedOutputStream.computeInt32Size(55, this.payGiftData_);
            int dataSize = 0;
            for (int k = 0; k < this.blackList_.size(); k++)
                dataSize += CodedOutputStream.computeBytesSizeNoTag(this.blackList_.getByteString(k));
            size += dataSize;
            size += 2 * getBlackListList().size();
            int i;
            for (i = 0; i < this.strengthPos_.size(); i++)
                size += CodedOutputStream.computeMessageSize(57, (MessageLite) this.strengthPos_.get(i));
            if ((this.bitField1_ & 0x1000) == 4096)
                size += CodedOutputStream.computeBytesSize(58, getGuildIdBytes());
            if ((this.bitField1_ & 0x2000) == 8192)
                size += CodedOutputStream.computeInt32Size(59, this.guildPro_);
            if ((this.bitField1_ & 0x4000) == 16384)
                size += CodedOutputStream.computeInt32Size(60, this.openMount_);
            for (i = 0; i < this.fashionInfo_.size(); i++)
                size += CodedOutputStream.computeMessageSize(61, (MessageLite) this.fashionInfo_.get(i));
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static Player parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Player) PARSER.parseFrom(data);
        }

        public static Player parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Player) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Player parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Player) PARSER.parseFrom(data);
        }

        public static Player parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Player) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Player parseFrom(InputStream input) throws IOException {
            return (Player) PARSER.parseFrom(input);
        }

        public static Player parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Player) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Player parseDelimitedFrom(InputStream input) throws IOException {
            return (Player) PARSER.parseDelimitedFrom(input);
        }

        public static Player parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Player) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Player parseFrom(CodedInputStream input) throws IOException {
            return (Player) PARSER.parseFrom(input);
        }

        public static Player parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Player) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Player prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements PlayerOuterClass.PlayerOrBuilder {
            private int bitField0_;
            private int bitField1_;
            private Object id_;
            private Object uid_;
            private Object name_;
            private int level_;
            private long exp_;
            private int pro_;
            private int sp_;
            private int upOrder_;
            private int classExp_;
            private long gold_;
            private long diamond_;
            private int energy_;
            private int vip_;
            private int areaId_;
            private int hp_;
            private int mp_;
            private int needExp_;
            private int fightPower_;
            private PlayerOuterClass.Stores store_;
            private SingleFieldBuilder<PlayerOuterClass.Stores, PlayerOuterClass.Stores.Builder, PlayerOuterClass.StoresOrBuilder> storeBuilder_;
            private PlayerOuterClass.Equipments equipments_;
            private SingleFieldBuilder<PlayerOuterClass.Equipments, PlayerOuterClass.Equipments.Builder, PlayerOuterClass.EquipmentsOrBuilder> equipmentsBuilder_;
            private TaskOuterClass.Tasks tasks_;
            private SingleFieldBuilder<TaskOuterClass.Tasks, TaskOuterClass.Tasks.Builder, TaskOuterClass.TasksOrBuilder> tasksBuilder_;
            private PlayerOuterClass.OfflineBaseData offlineBaseData_;
            private SingleFieldBuilder<PlayerOuterClass.OfflineBaseData, PlayerOuterClass.OfflineBaseData.Builder, PlayerOuterClass.OfflineBaseDataOrBuilder> offlineBaseDataBuilder_;
            private PlayerOuterClass.SetData setData_;
            private SingleFieldBuilder<PlayerOuterClass.SetData, PlayerOuterClass.SetData.Builder, PlayerOuterClass.SetDataOrBuilder> setDataBuilder_;
            private int prestige_;
            private int juewei_;
            private List<Common.SkillKeyStruct> skillKeys_;
            private RepeatedFieldBuilder<Common.SkillKeyStruct, Common.SkillKeyStruct.Builder, Common.SkillKeyStructOrBuilder> skillKeysBuilder_;
            private ItemOuterClass.CountItems countItems_;
            private SingleFieldBuilder<ItemOuterClass.CountItems, ItemOuterClass.CountItems.Builder, ItemOuterClass.CountItemsOrBuilder> countItemsBuilder_;
            private long ticket_;
            private int friendly_;
            private int upLevel_;
            private int reqLevel_;
            private int pkModel_;
            private int pkValue_;
            private PlayerOuterClass.HookSetData hookSetData_;
            private SingleFieldBuilder<PlayerOuterClass.HookSetData, PlayerOuterClass.HookSetData.Builder, PlayerOuterClass.HookSetDataOrBuilder> hookSetDataBuilder_;
            private Object zoneId_;
            private int solopoint_;
            private int consumePoint_;
            private int pawnGold_;
            private int petPkModel_;
            private int guildpoint_;
            private List<PlayerOuterClass.FunctionInfo> functionList_;
            private RepeatedFieldBuilder<PlayerOuterClass.FunctionInfo, PlayerOuterClass.FunctionInfo.Builder, PlayerOuterClass.FunctionInfoOrBuilder> functionListBuilder_;
            private List<Common.KeyValueStruct> clientConfig_;
            private RepeatedFieldBuilder<Common.KeyValueStruct, Common.KeyValueStruct.Builder, Common.KeyValueStructOrBuilder> clientConfigBuilder_;
            private Object fightingPetId_;
            private int mapId_;
            private Object instanceId_;
            private int treasurePoint_;
            private int payGiftData_;
            private LazyStringList blackList_;
            private List<ItemOuterClass.EquipGridStrengthInfo> strengthPos_;
            private RepeatedFieldBuilder<ItemOuterClass.EquipGridStrengthInfo, ItemOuterClass.EquipGridStrengthInfo.Builder, ItemOuterClass.EquipGridStrengthInfoOrBuilder> strengthPosBuilder_;
            private Object guildId_;
            private int guildPro_;
            private int openMount_;
            private List<ItemOuterClass.EquipFashionInfo> fashionInfo_;
            private RepeatedFieldBuilder<ItemOuterClass.EquipFashionInfo, ItemOuterClass.EquipFashionInfo.Builder, ItemOuterClass.EquipFashionInfoOrBuilder> fashionInfoBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PlayerOuterClass.internal_static_pomelo_player_Player_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PlayerOuterClass.internal_static_pomelo_player_Player_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerOuterClass.Player.class, Builder.class);
            }

            private Builder() {
                this.id_ = "";
                this.uid_ = "";
                this.name_ = "";
                this.store_ = PlayerOuterClass.Stores.getDefaultInstance();
                this.equipments_ = PlayerOuterClass.Equipments.getDefaultInstance();
                this.tasks_ = TaskOuterClass.Tasks.getDefaultInstance();
                this.offlineBaseData_ = PlayerOuterClass.OfflineBaseData.getDefaultInstance();
                this.setData_ = PlayerOuterClass.SetData.getDefaultInstance();
                this.skillKeys_ = Collections.emptyList();
                this.countItems_ = ItemOuterClass.CountItems.getDefaultInstance();
                this.hookSetData_ = PlayerOuterClass.HookSetData.getDefaultInstance();
                this.zoneId_ = "";
                this.functionList_ = Collections.emptyList();
                this.clientConfig_ = Collections.emptyList();
                this.fightingPetId_ = "";
                this.instanceId_ = "";
                this.blackList_ = LazyStringArrayList.EMPTY;
                this.strengthPos_ = Collections.emptyList();
                this.guildId_ = "";
                this.fashionInfo_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.id_ = "";
                this.uid_ = "";
                this.name_ = "";
                this.store_ = PlayerOuterClass.Stores.getDefaultInstance();
                this.equipments_ = PlayerOuterClass.Equipments.getDefaultInstance();
                this.tasks_ = TaskOuterClass.Tasks.getDefaultInstance();
                this.offlineBaseData_ = PlayerOuterClass.OfflineBaseData.getDefaultInstance();
                this.setData_ = PlayerOuterClass.SetData.getDefaultInstance();
                this.skillKeys_ = Collections.emptyList();
                this.countItems_ = ItemOuterClass.CountItems.getDefaultInstance();
                this.hookSetData_ = PlayerOuterClass.HookSetData.getDefaultInstance();
                this.zoneId_ = "";
                this.functionList_ = Collections.emptyList();
                this.clientConfig_ = Collections.emptyList();
                this.fightingPetId_ = "";
                this.instanceId_ = "";
                this.blackList_ = LazyStringArrayList.EMPTY;
                this.strengthPos_ = Collections.emptyList();
                this.guildId_ = "";
                this.fashionInfo_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PlayerOuterClass.Player.alwaysUseFieldBuilders) {
                    getStoreFieldBuilder();
                    getEquipmentsFieldBuilder();
                    getTasksFieldBuilder();
                    getOfflineBaseDataFieldBuilder();
                    getSetDataFieldBuilder();
                    getSkillKeysFieldBuilder();
                    getCountItemsFieldBuilder();
                    getHookSetDataFieldBuilder();
                    getFunctionListFieldBuilder();
                    getClientConfigFieldBuilder();
                    getStrengthPosFieldBuilder();
                    getFashionInfoFieldBuilder();
                }
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.id_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                this.uid_ = "";
                this.bitField0_ &= 0xFFFFFFFD;
                this.name_ = "";
                this.bitField0_ &= 0xFFFFFFFB;
                this.level_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                this.exp_ = 0L;
                this.bitField0_ &= 0xFFFFFFEF;
                this.pro_ = 0;
                this.bitField0_ &= 0xFFFFFFDF;
                this.sp_ = 0;
                this.bitField0_ &= 0xFFFFFFBF;
                this.upOrder_ = 0;
                this.bitField0_ &= 0xFFFFFF7F;
                this.classExp_ = 0;
                this.bitField0_ &= 0xFFFFFEFF;
                this.gold_ = 0L;
                this.bitField0_ &= 0xFFFFFDFF;
                this.diamond_ = 0L;
                this.bitField0_ &= 0xFFFFFBFF;
                this.energy_ = 0;
                this.bitField0_ &= 0xFFFFF7FF;
                this.vip_ = 0;
                this.bitField0_ &= 0xFFFFEFFF;
                this.areaId_ = 0;
                this.bitField0_ &= 0xFFFFDFFF;
                this.hp_ = 0;
                this.bitField0_ &= 0xFFFFBFFF;
                this.mp_ = 0;
                this.bitField0_ &= 0xFFFF7FFF;
                this.needExp_ = 0;
                this.bitField0_ &= 0xFFFEFFFF;
                this.fightPower_ = 0;
                this.bitField0_ &= 0xFFFDFFFF;
                if (this.storeBuilder_ == null) {
                    this.store_ = PlayerOuterClass.Stores.getDefaultInstance();
                } else {
                    this.storeBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFBFFFF;
                if (this.equipmentsBuilder_ == null) {
                    this.equipments_ = PlayerOuterClass.Equipments.getDefaultInstance();
                } else {
                    this.equipmentsBuilder_.clear();
                }
                this.bitField0_ &= 0xFFF7FFFF;
                if (this.tasksBuilder_ == null) {
                    this.tasks_ = TaskOuterClass.Tasks.getDefaultInstance();
                } else {
                    this.tasksBuilder_.clear();
                }
                this.bitField0_ &= 0xFFEFFFFF;
                if (this.offlineBaseDataBuilder_ == null) {
                    this.offlineBaseData_ = PlayerOuterClass.OfflineBaseData.getDefaultInstance();
                } else {
                    this.offlineBaseDataBuilder_.clear();
                }
                this.bitField0_ &= 0xFFDFFFFF;
                if (this.setDataBuilder_ == null) {
                    this.setData_ = PlayerOuterClass.SetData.getDefaultInstance();
                } else {
                    this.setDataBuilder_.clear();
                }
                this.bitField0_ &= 0xFFBFFFFF;
                this.prestige_ = 0;
                this.bitField0_ &= 0xFF7FFFFF;
                this.juewei_ = 0;
                this.bitField0_ &= 0xFEFFFFFF;
                if (this.skillKeysBuilder_ == null) {
                    this.skillKeys_ = Collections.emptyList();
                    this.bitField0_ &= 0xFDFFFFFF;
                } else {
                    this.skillKeysBuilder_.clear();
                }
                if (this.countItemsBuilder_ == null) {
                    this.countItems_ = ItemOuterClass.CountItems.getDefaultInstance();
                } else {
                    this.countItemsBuilder_.clear();
                }
                this.bitField0_ &= 0xFBFFFFFF;
                this.ticket_ = 0L;
                this.bitField0_ &= 0xF7FFFFFF;
                this.friendly_ = 0;
                this.bitField0_ &= 0xEFFFFFFF;
                this.upLevel_ = 0;
                this.bitField0_ &= 0xDFFFFFFF;
                this.reqLevel_ = 0;
                this.bitField0_ &= 0xBFFFFFFF;
                this.pkModel_ = 0;
                this.bitField0_ &= Integer.MAX_VALUE;
                this.pkValue_ = 0;
                this.bitField1_ &= 0xFFFFFFFE;
                if (this.hookSetDataBuilder_ == null) {
                    this.hookSetData_ = PlayerOuterClass.HookSetData.getDefaultInstance();
                } else {
                    this.hookSetDataBuilder_.clear();
                }
                this.bitField1_ &= 0xFFFFFFFD;
                this.zoneId_ = "";
                this.bitField1_ &= 0xFFFFFFFB;
                this.solopoint_ = 0;
                this.bitField1_ &= 0xFFFFFFF7;
                this.consumePoint_ = 0;
                this.bitField1_ &= 0xFFFFFFEF;
                this.pawnGold_ = 0;
                this.bitField1_ &= 0xFFFFFFDF;
                this.petPkModel_ = 0;
                this.bitField1_ &= 0xFFFFFFBF;
                this.guildpoint_ = 0;
                this.bitField1_ &= 0xFFFFFF7F;
                if (this.functionListBuilder_ == null) {
                    this.functionList_ = Collections.emptyList();
                    this.bitField1_ &= 0xFFFFFEFF;
                } else {
                    this.functionListBuilder_.clear();
                }
                if (this.clientConfigBuilder_ == null) {
                    this.clientConfig_ = Collections.emptyList();
                    this.bitField1_ &= 0xFFFFFDFF;
                } else {
                    this.clientConfigBuilder_.clear();
                }
                this.fightingPetId_ = "";
                this.bitField1_ &= 0xFFFFFBFF;
                this.mapId_ = 0;
                this.bitField1_ &= 0xFFFFF7FF;
                this.instanceId_ = "";
                this.bitField1_ &= 0xFFFFEFFF;
                this.treasurePoint_ = 0;
                this.bitField1_ &= 0xFFFFDFFF;
                this.payGiftData_ = 0;
                this.bitField1_ &= 0xFFFFBFFF;
                this.blackList_ = LazyStringArrayList.EMPTY;
                this.bitField1_ &= 0xFFFF7FFF;
                if (this.strengthPosBuilder_ == null) {
                    this.strengthPos_ = Collections.emptyList();
                    this.bitField1_ &= 0xFFFEFFFF;
                } else {
                    this.strengthPosBuilder_.clear();
                }
                this.guildId_ = "";
                this.bitField1_ &= 0xFFFDFFFF;
                this.guildPro_ = 0;
                this.bitField1_ &= 0xFFFBFFFF;
                this.openMount_ = 0;
                this.bitField1_ &= 0xFFF7FFFF;
                if (this.fashionInfoBuilder_ == null) {
                    this.fashionInfo_ = Collections.emptyList();
                    this.bitField1_ &= 0xFFEFFFFF;
                } else {
                    this.fashionInfoBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return PlayerOuterClass.internal_static_pomelo_player_Player_descriptor;
            }

            public PlayerOuterClass.Player getDefaultInstanceForType() {
                return PlayerOuterClass.Player.getDefaultInstance();
            }

            public PlayerOuterClass.Player build() {
                PlayerOuterClass.Player result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public PlayerOuterClass.Player buildPartial() {
                PlayerOuterClass.Player result = new PlayerOuterClass.Player(this);
                int from_bitField0_ = this.bitField0_;
                int from_bitField1_ = this.bitField1_;
                int to_bitField0_ = 0;
                int to_bitField1_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.id_ = this.id_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.uid_ = this.uid_;
                if ((from_bitField0_ & 0x4) == 4)
                    to_bitField0_ |= 0x4;
                result.name_ = this.name_;
                if ((from_bitField0_ & 0x8) == 8)
                    to_bitField0_ |= 0x8;
                result.level_ = this.level_;
                if ((from_bitField0_ & 0x10) == 16)
                    to_bitField0_ |= 0x10;
                result.exp_ = this.exp_;
                if ((from_bitField0_ & 0x20) == 32)
                    to_bitField0_ |= 0x20;
                result.pro_ = this.pro_;
                if ((from_bitField0_ & 0x40) == 64)
                    to_bitField0_ |= 0x40;
                result.sp_ = this.sp_;
                if ((from_bitField0_ & 0x80) == 128)
                    to_bitField0_ |= 0x80;
                result.upOrder_ = this.upOrder_;
                if ((from_bitField0_ & 0x100) == 256)
                    to_bitField0_ |= 0x100;
                result.classExp_ = this.classExp_;
                if ((from_bitField0_ & 0x200) == 512)
                    to_bitField0_ |= 0x200;
                result.gold_ = this.gold_;
                if ((from_bitField0_ & 0x400) == 1024)
                    to_bitField0_ |= 0x400;
                result.diamond_ = this.diamond_;
                if ((from_bitField0_ & 0x800) == 2048)
                    to_bitField0_ |= 0x800;
                result.energy_ = this.energy_;
                if ((from_bitField0_ & 0x1000) == 4096)
                    to_bitField0_ |= 0x1000;
                result.vip_ = this.vip_;
                if ((from_bitField0_ & 0x2000) == 8192)
                    to_bitField0_ |= 0x2000;
                result.areaId_ = this.areaId_;
                if ((from_bitField0_ & 0x4000) == 16384)
                    to_bitField0_ |= 0x4000;
                result.hp_ = this.hp_;
                if ((from_bitField0_ & 0x8000) == 32768)
                    to_bitField0_ |= 0x8000;
                result.mp_ = this.mp_;
                if ((from_bitField0_ & 0x10000) == 65536)
                    to_bitField0_ |= 0x10000;
                result.needExp_ = this.needExp_;
                if ((from_bitField0_ & 0x20000) == 131072)
                    to_bitField0_ |= 0x20000;
                result.fightPower_ = this.fightPower_;
                if ((from_bitField0_ & 0x40000) == 262144)
                    to_bitField0_ |= 0x40000;
                if (this.storeBuilder_ == null) {
                    result.store_ = this.store_;
                } else {
                    result.store_ = (PlayerOuterClass.Stores) this.storeBuilder_.build();
                }
                if ((from_bitField0_ & 0x80000) == 524288)
                    to_bitField0_ |= 0x80000;
                if (this.equipmentsBuilder_ == null) {
                    result.equipments_ = this.equipments_;
                } else {
                    result.equipments_ = (PlayerOuterClass.Equipments) this.equipmentsBuilder_.build();
                }
                if ((from_bitField0_ & 0x100000) == 1048576)
                    to_bitField0_ |= 0x100000;
                if (this.tasksBuilder_ == null) {
                    result.tasks_ = this.tasks_;
                } else {
                    result.tasks_ = (TaskOuterClass.Tasks) this.tasksBuilder_.build();
                }
                if ((from_bitField0_ & 0x200000) == 2097152)
                    to_bitField0_ |= 0x200000;
                if (this.offlineBaseDataBuilder_ == null) {
                    result.offlineBaseData_ = this.offlineBaseData_;
                } else {
                    result.offlineBaseData_ = (PlayerOuterClass.OfflineBaseData) this.offlineBaseDataBuilder_.build();
                }
                if ((from_bitField0_ & 0x400000) == 4194304)
                    to_bitField0_ |= 0x400000;
                if (this.setDataBuilder_ == null) {
                    result.setData_ = this.setData_;
                } else {
                    result.setData_ = (PlayerOuterClass.SetData) this.setDataBuilder_.build();
                }
                if ((from_bitField0_ & 0x800000) == 8388608)
                    to_bitField0_ |= 0x800000;
                result.prestige_ = this.prestige_;
                if ((from_bitField0_ & 0x1000000) == 16777216)
                    to_bitField0_ |= 0x1000000;
                result.juewei_ = this.juewei_;
                if (this.skillKeysBuilder_ == null) {
                    if ((this.bitField0_ & 0x2000000) == 33554432) {
                        this.skillKeys_ = Collections.unmodifiableList(this.skillKeys_);
                        this.bitField0_ &= 0xFDFFFFFF;
                    }
                    result.skillKeys_ = this.skillKeys_;
                } else {
                    result.skillKeys_ = this.skillKeysBuilder_.build();
                }
                if ((from_bitField0_ & 0x4000000) == 67108864)
                    to_bitField0_ |= 0x2000000;
                if (this.countItemsBuilder_ == null) {
                    result.countItems_ = this.countItems_;
                } else {
                    result.countItems_ = (ItemOuterClass.CountItems) this.countItemsBuilder_.build();
                }
                if ((from_bitField0_ & 0x8000000) == 134217728)
                    to_bitField0_ |= 0x4000000;
                result.ticket_ = this.ticket_;
                if ((from_bitField0_ & 0x10000000) == 268435456)
                    to_bitField0_ |= 0x8000000;
                result.friendly_ = this.friendly_;
                if ((from_bitField0_ & 0x20000000) == 536870912)
                    to_bitField0_ |= 0x10000000;
                result.upLevel_ = this.upLevel_;
                if ((from_bitField0_ & 0x40000000) == 1073741824)
                    to_bitField0_ |= 0x20000000;
                result.reqLevel_ = this.reqLevel_;
                if ((from_bitField0_ & Integer.MIN_VALUE) == Integer.MIN_VALUE)
                    to_bitField0_ |= 0x40000000;
                result.pkModel_ = this.pkModel_;
                if ((from_bitField1_ & 0x1) == 1)
                    to_bitField0_ |= Integer.MIN_VALUE;
                result.pkValue_ = this.pkValue_;
                if ((from_bitField1_ & 0x2) == 2)
                    to_bitField1_ |= 0x1;
                if (this.hookSetDataBuilder_ == null) {
                    result.hookSetData_ = this.hookSetData_;
                } else {
                    result.hookSetData_ = (PlayerOuterClass.HookSetData) this.hookSetDataBuilder_.build();
                }
                if ((from_bitField1_ & 0x4) == 4)
                    to_bitField1_ |= 0x2;
                result.zoneId_ = this.zoneId_;
                if ((from_bitField1_ & 0x8) == 8)
                    to_bitField1_ |= 0x4;
                result.solopoint_ = this.solopoint_;
                if ((from_bitField1_ & 0x10) == 16)
                    to_bitField1_ |= 0x8;
                result.consumePoint_ = this.consumePoint_;
                if ((from_bitField1_ & 0x20) == 32)
                    to_bitField1_ |= 0x10;
                result.pawnGold_ = this.pawnGold_;
                if ((from_bitField1_ & 0x40) == 64)
                    to_bitField1_ |= 0x20;
                result.petPkModel_ = this.petPkModel_;
                if ((from_bitField1_ & 0x80) == 128)
                    to_bitField1_ |= 0x40;
                result.guildpoint_ = this.guildpoint_;
                if (this.functionListBuilder_ == null) {
                    if ((this.bitField1_ & 0x100) == 256) {
                        this.functionList_ = Collections.unmodifiableList(this.functionList_);
                        this.bitField1_ &= 0xFFFFFEFF;
                    }
                    result.functionList_ = this.functionList_;
                } else {
                    result.functionList_ = this.functionListBuilder_.build();
                }
                if (this.clientConfigBuilder_ == null) {
                    if ((this.bitField1_ & 0x200) == 512) {
                        this.clientConfig_ = Collections.unmodifiableList(this.clientConfig_);
                        this.bitField1_ &= 0xFFFFFDFF;
                    }
                    result.clientConfig_ = this.clientConfig_;
                } else {
                    result.clientConfig_ = this.clientConfigBuilder_.build();
                }
                if ((from_bitField1_ & 0x400) == 1024)
                    to_bitField1_ |= 0x80;
                result.fightingPetId_ = this.fightingPetId_;
                if ((from_bitField1_ & 0x800) == 2048)
                    to_bitField1_ |= 0x100;
                result.mapId_ = this.mapId_;
                if ((from_bitField1_ & 0x1000) == 4096)
                    to_bitField1_ |= 0x200;
                result.instanceId_ = this.instanceId_;
                if ((from_bitField1_ & 0x2000) == 8192)
                    to_bitField1_ |= 0x400;
                result.treasurePoint_ = this.treasurePoint_;
                if ((from_bitField1_ & 0x4000) == 16384)
                    to_bitField1_ |= 0x800;
                result.payGiftData_ = this.payGiftData_;
                if ((this.bitField1_ & 0x8000) == 32768) {
                    this.blackList_ = this.blackList_.getUnmodifiableView();
                    this.bitField1_ &= 0xFFFF7FFF;
                }
                result.blackList_ = this.blackList_;
                if (this.strengthPosBuilder_ == null) {
                    if ((this.bitField1_ & 0x10000) == 65536) {
                        this.strengthPos_ = Collections.unmodifiableList(this.strengthPos_);
                        this.bitField1_ &= 0xFFFEFFFF;
                    }
                    result.strengthPos_ = this.strengthPos_;
                } else {
                    result.strengthPos_ = this.strengthPosBuilder_.build();
                }
                if ((from_bitField1_ & 0x20000) == 131072)
                    to_bitField1_ |= 0x1000;
                result.guildId_ = this.guildId_;
                if ((from_bitField1_ & 0x40000) == 262144)
                    to_bitField1_ |= 0x2000;
                result.guildPro_ = this.guildPro_;
                if ((from_bitField1_ & 0x80000) == 524288)
                    to_bitField1_ |= 0x4000;
                result.openMount_ = this.openMount_;
                if (this.fashionInfoBuilder_ == null) {
                    if ((this.bitField1_ & 0x100000) == 1048576) {
                        this.fashionInfo_ = Collections.unmodifiableList(this.fashionInfo_);
                        this.bitField1_ &= 0xFFEFFFFF;
                    }
                    result.fashionInfo_ = this.fashionInfo_;
                } else {
                    result.fashionInfo_ = this.fashionInfoBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                result.bitField1_ = to_bitField1_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof PlayerOuterClass.Player)
                    return mergeFrom((PlayerOuterClass.Player) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PlayerOuterClass.Player other) {
                if (other == PlayerOuterClass.Player.getDefaultInstance())
                    return this;
                if (other.hasId()) {
                    this.bitField0_ |= 0x1;
                    this.id_ = other.id_;
                    onChanged();
                }
                if (other.hasUid()) {
                    this.bitField0_ |= 0x2;
                    this.uid_ = other.uid_;
                    onChanged();
                }
                if (other.hasName()) {
                    this.bitField0_ |= 0x4;
                    this.name_ = other.name_;
                    onChanged();
                }
                if (other.hasLevel())
                    setLevel(other.getLevel());
                if (other.hasExp())
                    setExp(other.getExp());
                if (other.hasPro())
                    setPro(other.getPro());
                if (other.hasSp())
                    setSp(other.getSp());
                if (other.hasUpOrder())
                    setUpOrder(other.getUpOrder());
                if (other.hasClassExp())
                    setClassExp(other.getClassExp());
                if (other.hasGold())
                    setGold(other.getGold());
                if (other.hasDiamond())
                    setDiamond(other.getDiamond());
                if (other.hasEnergy())
                    setEnergy(other.getEnergy());
                if (other.hasVip())
                    setVip(other.getVip());
                if (other.hasAreaId())
                    setAreaId(other.getAreaId());
                if (other.hasHp())
                    setHp(other.getHp());
                if (other.hasMp())
                    setMp(other.getMp());
                if (other.hasNeedExp())
                    setNeedExp(other.getNeedExp());
                if (other.hasFightPower())
                    setFightPower(other.getFightPower());
                if (other.hasStore())
                    mergeStore(other.getStore());
                if (other.hasEquipments())
                    mergeEquipments(other.getEquipments());
                if (other.hasTasks())
                    mergeTasks(other.getTasks());
                if (other.hasOfflineBaseData())
                    mergeOfflineBaseData(other.getOfflineBaseData());
                if (other.hasSetData())
                    mergeSetData(other.getSetData());
                if (other.hasPrestige())
                    setPrestige(other.getPrestige());
                if (other.hasJuewei())
                    setJuewei(other.getJuewei());
                if (this.skillKeysBuilder_ == null) {
                    if (!other.skillKeys_.isEmpty()) {
                        if (this.skillKeys_.isEmpty()) {
                            this.skillKeys_ = other.skillKeys_;
                            this.bitField0_ &= 0xFDFFFFFF;
                        } else {
                            ensureSkillKeysIsMutable();
                            this.skillKeys_.addAll(other.skillKeys_);
                        }
                        onChanged();
                    }
                } else if (!other.skillKeys_.isEmpty()) {
                    if (this.skillKeysBuilder_.isEmpty()) {
                        this.skillKeysBuilder_.dispose();
                        this.skillKeysBuilder_ = null;
                        this.skillKeys_ = other.skillKeys_;
                        this.bitField0_ &= 0xFDFFFFFF;
                        this.skillKeysBuilder_ = PlayerOuterClass.Player.alwaysUseFieldBuilders ? getSkillKeysFieldBuilder() : null;
                    } else {
                        this.skillKeysBuilder_.addAllMessages(other.skillKeys_);
                    }
                }
                if (other.hasCountItems())
                    mergeCountItems(other.getCountItems());
                if (other.hasTicket())
                    setTicket(other.getTicket());
                if (other.hasFriendly())
                    setFriendly(other.getFriendly());
                if (other.hasUpLevel())
                    setUpLevel(other.getUpLevel());
                if (other.hasReqLevel())
                    setReqLevel(other.getReqLevel());
                if (other.hasPkModel())
                    setPkModel(other.getPkModel());
                if (other.hasPkValue())
                    setPkValue(other.getPkValue());
                if (other.hasHookSetData())
                    mergeHookSetData(other.getHookSetData());
                if (other.hasZoneId()) {
                    this.bitField1_ |= 0x4;
                    this.zoneId_ = other.zoneId_;
                    onChanged();
                }
                if (other.hasSolopoint())
                    setSolopoint(other.getSolopoint());
                if (other.hasConsumePoint())
                    setConsumePoint(other.getConsumePoint());
                if (other.hasPawnGold())
                    setPawnGold(other.getPawnGold());
                if (other.hasPetPkModel())
                    setPetPkModel(other.getPetPkModel());
                if (other.hasGuildpoint())
                    setGuildpoint(other.getGuildpoint());
                if (this.functionListBuilder_ == null) {
                    if (!other.functionList_.isEmpty()) {
                        if (this.functionList_.isEmpty()) {
                            this.functionList_ = other.functionList_;
                            this.bitField1_ &= 0xFFFFFEFF;
                        } else {
                            ensureFunctionListIsMutable();
                            this.functionList_.addAll(other.functionList_);
                        }
                        onChanged();
                    }
                } else if (!other.functionList_.isEmpty()) {
                    if (this.functionListBuilder_.isEmpty()) {
                        this.functionListBuilder_.dispose();
                        this.functionListBuilder_ = null;
                        this.functionList_ = other.functionList_;
                        this.bitField1_ &= 0xFFFFFEFF;
                        this.functionListBuilder_ = PlayerOuterClass.Player.alwaysUseFieldBuilders ? getFunctionListFieldBuilder() : null;
                    } else {
                        this.functionListBuilder_.addAllMessages(other.functionList_);
                    }
                }
                if (this.clientConfigBuilder_ == null) {
                    if (!other.clientConfig_.isEmpty()) {
                        if (this.clientConfig_.isEmpty()) {
                            this.clientConfig_ = other.clientConfig_;
                            this.bitField1_ &= 0xFFFFFDFF;
                        } else {
                            ensureClientConfigIsMutable();
                            this.clientConfig_.addAll(other.clientConfig_);
                        }
                        onChanged();
                    }
                } else if (!other.clientConfig_.isEmpty()) {
                    if (this.clientConfigBuilder_.isEmpty()) {
                        this.clientConfigBuilder_.dispose();
                        this.clientConfigBuilder_ = null;
                        this.clientConfig_ = other.clientConfig_;
                        this.bitField1_ &= 0xFFFFFDFF;
                        this.clientConfigBuilder_ = PlayerOuterClass.Player.alwaysUseFieldBuilders ? getClientConfigFieldBuilder() : null;
                    } else {
                        this.clientConfigBuilder_.addAllMessages(other.clientConfig_);
                    }
                }
                if (other.hasFightingPetId()) {
                    this.bitField1_ |= 0x400;
                    this.fightingPetId_ = other.fightingPetId_;
                    onChanged();
                }
                if (other.hasMapId())
                    setMapId(other.getMapId());
                if (other.hasInstanceId()) {
                    this.bitField1_ |= 0x1000;
                    this.instanceId_ = other.instanceId_;
                    onChanged();
                }
                if (other.hasTreasurePoint())
                    setTreasurePoint(other.getTreasurePoint());
                if (other.hasPayGiftData())
                    setPayGiftData(other.getPayGiftData());
                if (!other.blackList_.isEmpty()) {
                    if (this.blackList_.isEmpty()) {
                        this.blackList_ = other.blackList_;
                        this.bitField1_ &= 0xFFFF7FFF;
                    } else {
                        ensureBlackListIsMutable();
                        this.blackList_.addAll((Collection) other.blackList_);
                    }
                    onChanged();
                }
                if (this.strengthPosBuilder_ == null) {
                    if (!other.strengthPos_.isEmpty()) {
                        if (this.strengthPos_.isEmpty()) {
                            this.strengthPos_ = other.strengthPos_;
                            this.bitField1_ &= 0xFFFEFFFF;
                        } else {
                            ensureStrengthPosIsMutable();
                            this.strengthPos_.addAll(other.strengthPos_);
                        }
                        onChanged();
                    }
                } else if (!other.strengthPos_.isEmpty()) {
                    if (this.strengthPosBuilder_.isEmpty()) {
                        this.strengthPosBuilder_.dispose();
                        this.strengthPosBuilder_ = null;
                        this.strengthPos_ = other.strengthPos_;
                        this.bitField1_ &= 0xFFFEFFFF;
                        this.strengthPosBuilder_ = PlayerOuterClass.Player.alwaysUseFieldBuilders ? getStrengthPosFieldBuilder() : null;
                    } else {
                        this.strengthPosBuilder_.addAllMessages(other.strengthPos_);
                    }
                }
                if (other.hasGuildId()) {
                    this.bitField1_ |= 0x20000;
                    this.guildId_ = other.guildId_;
                    onChanged();
                }
                if (other.hasGuildPro())
                    setGuildPro(other.getGuildPro());
                if (other.hasOpenMount())
                    setOpenMount(other.getOpenMount());
                if (this.fashionInfoBuilder_ == null) {
                    if (!other.fashionInfo_.isEmpty()) {
                        if (this.fashionInfo_.isEmpty()) {
                            this.fashionInfo_ = other.fashionInfo_;
                            this.bitField1_ &= 0xFFEFFFFF;
                        } else {
                            ensureFashionInfoIsMutable();
                            this.fashionInfo_.addAll(other.fashionInfo_);
                        }
                        onChanged();
                    }
                } else if (!other.fashionInfo_.isEmpty()) {
                    if (this.fashionInfoBuilder_.isEmpty()) {
                        this.fashionInfoBuilder_.dispose();
                        this.fashionInfoBuilder_ = null;
                        this.fashionInfo_ = other.fashionInfo_;
                        this.bitField1_ &= 0xFFEFFFFF;
                        this.fashionInfoBuilder_ = PlayerOuterClass.Player.alwaysUseFieldBuilders ? getFashionInfoFieldBuilder() : null;
                    } else {
                        this.fashionInfoBuilder_.addAllMessages(other.fashionInfo_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasId())
                    return false;
                if (hasStore() && !getStore().isInitialized())
                    return false;
                if (hasEquipments() && !getEquipments().isInitialized())
                    return false;
                if (hasTasks() && !getTasks().isInitialized())
                    return false;
                if (hasOfflineBaseData() && !getOfflineBaseData().isInitialized())
                    return false;
                if (hasSetData() && !getSetData().isInitialized())
                    return false;
                int i;
                for (i = 0; i < getSkillKeysCount(); i++) {
                    if (!getSkillKeys(i).isInitialized())
                        return false;
                }
                if (hasCountItems() && !getCountItems().isInitialized())
                    return false;
                if (hasHookSetData() && !getHookSetData().isInitialized())
                    return false;
                for (i = 0; i < getClientConfigCount(); i++) {
                    if (!getClientConfig(i).isInitialized())
                        return false;
                }
                for (i = 0; i < getStrengthPosCount(); i++) {
                    if (!getStrengthPos(i).isInitialized())
                        return false;
                }
                for (i = 0; i < getFashionInfoCount(); i++) {
                    if (!getFashionInfo(i).isInitialized())
                        return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                PlayerOuterClass.Player parsedMessage = null;
                try {
                    parsedMessage = (PlayerOuterClass.Player) PlayerOuterClass.Player.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (PlayerOuterClass.Player) e.getUnfinishedMessage();
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
                this.id_ = PlayerOuterClass.Player.getDefaultInstance().getId();
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

            public boolean hasUid() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public String getUid() {
                Object ref = this.uid_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.uid_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getUidBytes() {
                Object ref = this.uid_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.uid_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setUid(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x2;
                this.uid_ = value;
                onChanged();
                return this;
            }

            public Builder clearUid() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.uid_ = PlayerOuterClass.Player.getDefaultInstance().getUid();
                onChanged();
                return this;
            }

            public Builder setUidBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x2;
                this.uid_ = value;
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
                this.name_ = PlayerOuterClass.Player.getDefaultInstance().getName();
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

            public boolean hasExp() {
                return ((this.bitField0_ & 0x10) == 16);
            }

            public long getExp() {
                return this.exp_;
            }

            public Builder setExp(long value) {
                this.bitField0_ |= 0x10;
                this.exp_ = value;
                onChanged();
                return this;
            }

            public Builder clearExp() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.exp_ = 0L;
                onChanged();
                return this;
            }

            public boolean hasPro() {
                return ((this.bitField0_ & 0x20) == 32);
            }

            public int getPro() {
                return this.pro_;
            }

            public Builder setPro(int value) {
                this.bitField0_ |= 0x20;
                this.pro_ = value;
                onChanged();
                return this;
            }

            public Builder clearPro() {
                this.bitField0_ &= 0xFFFFFFDF;
                this.pro_ = 0;
                onChanged();
                return this;
            }

            public boolean hasSp() {
                return ((this.bitField0_ & 0x40) == 64);
            }

            public int getSp() {
                return this.sp_;
            }

            public Builder setSp(int value) {
                this.bitField0_ |= 0x40;
                this.sp_ = value;
                onChanged();
                return this;
            }

            public Builder clearSp() {
                this.bitField0_ &= 0xFFFFFFBF;
                this.sp_ = 0;
                onChanged();
                return this;
            }

            public boolean hasUpOrder() {
                return ((this.bitField0_ & 0x80) == 128);
            }

            public int getUpOrder() {
                return this.upOrder_;
            }

            public Builder setUpOrder(int value) {
                this.bitField0_ |= 0x80;
                this.upOrder_ = value;
                onChanged();
                return this;
            }

            public Builder clearUpOrder() {
                this.bitField0_ &= 0xFFFFFF7F;
                this.upOrder_ = 0;
                onChanged();
                return this;
            }

            public boolean hasClassExp() {
                return ((this.bitField0_ & 0x100) == 256);
            }

            public int getClassExp() {
                return this.classExp_;
            }

            public Builder setClassExp(int value) {
                this.bitField0_ |= 0x100;
                this.classExp_ = value;
                onChanged();
                return this;
            }

            public Builder clearClassExp() {
                this.bitField0_ &= 0xFFFFFEFF;
                this.classExp_ = 0;
                onChanged();
                return this;
            }

            public boolean hasGold() {
                return ((this.bitField0_ & 0x200) == 512);
            }

            public long getGold() {
                return this.gold_;
            }

            public Builder setGold(long value) {
                this.bitField0_ |= 0x200;
                this.gold_ = value;
                onChanged();
                return this;
            }

            public Builder clearGold() {
                this.bitField0_ &= 0xFFFFFDFF;
                this.gold_ = 0L;
                onChanged();
                return this;
            }

            public boolean hasDiamond() {
                return ((this.bitField0_ & 0x400) == 1024);
            }

            public long getDiamond() {
                return this.diamond_;
            }

            public Builder setDiamond(long value) {
                this.bitField0_ |= 0x400;
                this.diamond_ = value;
                onChanged();
                return this;
            }

            public Builder clearDiamond() {
                this.bitField0_ &= 0xFFFFFBFF;
                this.diamond_ = 0L;
                onChanged();
                return this;
            }

            public boolean hasEnergy() {
                return ((this.bitField0_ & 0x800) == 2048);
            }

            public int getEnergy() {
                return this.energy_;
            }

            public Builder setEnergy(int value) {
                this.bitField0_ |= 0x800;
                this.energy_ = value;
                onChanged();
                return this;
            }

            public Builder clearEnergy() {
                this.bitField0_ &= 0xFFFFF7FF;
                this.energy_ = 0;
                onChanged();
                return this;
            }

            public boolean hasVip() {
                return ((this.bitField0_ & 0x1000) == 4096);
            }

            public int getVip() {
                return this.vip_;
            }

            public Builder setVip(int value) {
                this.bitField0_ |= 0x1000;
                this.vip_ = value;
                onChanged();
                return this;
            }

            public Builder clearVip() {
                this.bitField0_ &= 0xFFFFEFFF;
                this.vip_ = 0;
                onChanged();
                return this;
            }

            public boolean hasAreaId() {
                return ((this.bitField0_ & 0x2000) == 8192);
            }

            public int getAreaId() {
                return this.areaId_;
            }

            public Builder setAreaId(int value) {
                this.bitField0_ |= 0x2000;
                this.areaId_ = value;
                onChanged();
                return this;
            }

            public Builder clearAreaId() {
                this.bitField0_ &= 0xFFFFDFFF;
                this.areaId_ = 0;
                onChanged();
                return this;
            }

            public boolean hasHp() {
                return ((this.bitField0_ & 0x4000) == 16384);
            }

            public int getHp() {
                return this.hp_;
            }

            public Builder setHp(int value) {
                this.bitField0_ |= 0x4000;
                this.hp_ = value;
                onChanged();
                return this;
            }

            public Builder clearHp() {
                this.bitField0_ &= 0xFFFFBFFF;
                this.hp_ = 0;
                onChanged();
                return this;
            }

            public boolean hasMp() {
                return ((this.bitField0_ & 0x8000) == 32768);
            }

            public int getMp() {
                return this.mp_;
            }

            public Builder setMp(int value) {
                this.bitField0_ |= 0x8000;
                this.mp_ = value;
                onChanged();
                return this;
            }

            public Builder clearMp() {
                this.bitField0_ &= 0xFFFF7FFF;
                this.mp_ = 0;
                onChanged();
                return this;
            }

            public boolean hasNeedExp() {
                return ((this.bitField0_ & 0x10000) == 65536);
            }

            public int getNeedExp() {
                return this.needExp_;
            }

            public Builder setNeedExp(int value) {
                this.bitField0_ |= 0x10000;
                this.needExp_ = value;
                onChanged();
                return this;
            }

            public Builder clearNeedExp() {
                this.bitField0_ &= 0xFFFEFFFF;
                this.needExp_ = 0;
                onChanged();
                return this;
            }

            public boolean hasFightPower() {
                return ((this.bitField0_ & 0x20000) == 131072);
            }

            public int getFightPower() {
                return this.fightPower_;
            }

            public Builder setFightPower(int value) {
                this.bitField0_ |= 0x20000;
                this.fightPower_ = value;
                onChanged();
                return this;
            }

            public Builder clearFightPower() {
                this.bitField0_ &= 0xFFFDFFFF;
                this.fightPower_ = 0;
                onChanged();
                return this;
            }

            public boolean hasStore() {
                return ((this.bitField0_ & 0x40000) == 262144);
            }

            public PlayerOuterClass.Stores getStore() {
                if (this.storeBuilder_ == null)
                    return this.store_;
                return (PlayerOuterClass.Stores) this.storeBuilder_.getMessage();
            }

            public Builder setStore(PlayerOuterClass.Stores value) {
                if (this.storeBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    this.store_ = value;
                    onChanged();
                } else {
                    this.storeBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x40000;
                return this;
            }

            public Builder setStore(PlayerOuterClass.Stores.Builder builderForValue) {
                if (this.storeBuilder_ == null) {
                    this.store_ = builderForValue.build();
                    onChanged();
                } else {
                    this.storeBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x40000;
                return this;
            }

            public Builder mergeStore(PlayerOuterClass.Stores value) {
                if (this.storeBuilder_ == null) {
                    if ((this.bitField0_ & 0x40000) == 262144 && this.store_ != PlayerOuterClass.Stores.getDefaultInstance()) {
                        this.store_ = PlayerOuterClass.Stores.newBuilder(this.store_).mergeFrom(value).buildPartial();
                    } else {
                        this.store_ = value;
                    }
                    onChanged();
                } else {
                    this.storeBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x40000;
                return this;
            }

            public Builder clearStore() {
                if (this.storeBuilder_ == null) {
                    this.store_ = PlayerOuterClass.Stores.getDefaultInstance();
                    onChanged();
                } else {
                    this.storeBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFBFFFF;
                return this;
            }

            public PlayerOuterClass.Stores.Builder getStoreBuilder() {
                this.bitField0_ |= 0x40000;
                onChanged();
                return (PlayerOuterClass.Stores.Builder) getStoreFieldBuilder().getBuilder();
            }

            public PlayerOuterClass.StoresOrBuilder getStoreOrBuilder() {
                if (this.storeBuilder_ != null)
                    return (PlayerOuterClass.StoresOrBuilder) this.storeBuilder_.getMessageOrBuilder();
                return this.store_;
            }

            private SingleFieldBuilder<PlayerOuterClass.Stores, PlayerOuterClass.Stores.Builder, PlayerOuterClass.StoresOrBuilder> getStoreFieldBuilder() {
                if (this.storeBuilder_ == null) {
                    this.storeBuilder_ = new SingleFieldBuilder(getStore(), getParentForChildren(), isClean());
                    this.store_ = null;
                }
                return this.storeBuilder_;
            }

            public boolean hasEquipments() {
                return ((this.bitField0_ & 0x80000) == 524288);
            }

            public PlayerOuterClass.Equipments getEquipments() {
                if (this.equipmentsBuilder_ == null)
                    return this.equipments_;
                return (PlayerOuterClass.Equipments) this.equipmentsBuilder_.getMessage();
            }

            public Builder setEquipments(PlayerOuterClass.Equipments value) {
                if (this.equipmentsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    this.equipments_ = value;
                    onChanged();
                } else {
                    this.equipmentsBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x80000;
                return this;
            }

            public Builder setEquipments(PlayerOuterClass.Equipments.Builder builderForValue) {
                if (this.equipmentsBuilder_ == null) {
                    this.equipments_ = builderForValue.build();
                    onChanged();
                } else {
                    this.equipmentsBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x80000;
                return this;
            }

            public Builder mergeEquipments(PlayerOuterClass.Equipments value) {
                if (this.equipmentsBuilder_ == null) {
                    if ((this.bitField0_ & 0x80000) == 524288 && this.equipments_ != PlayerOuterClass.Equipments.getDefaultInstance()) {
                        this.equipments_ = PlayerOuterClass.Equipments.newBuilder(this.equipments_).mergeFrom(value).buildPartial();
                    } else {
                        this.equipments_ = value;
                    }
                    onChanged();
                } else {
                    this.equipmentsBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x80000;
                return this;
            }

            public Builder clearEquipments() {
                if (this.equipmentsBuilder_ == null) {
                    this.equipments_ = PlayerOuterClass.Equipments.getDefaultInstance();
                    onChanged();
                } else {
                    this.equipmentsBuilder_.clear();
                }
                this.bitField0_ &= 0xFFF7FFFF;
                return this;
            }

            public PlayerOuterClass.Equipments.Builder getEquipmentsBuilder() {
                this.bitField0_ |= 0x80000;
                onChanged();
                return (PlayerOuterClass.Equipments.Builder) getEquipmentsFieldBuilder().getBuilder();
            }

            public PlayerOuterClass.EquipmentsOrBuilder getEquipmentsOrBuilder() {
                if (this.equipmentsBuilder_ != null)
                    return (PlayerOuterClass.EquipmentsOrBuilder) this.equipmentsBuilder_.getMessageOrBuilder();
                return this.equipments_;
            }

            private SingleFieldBuilder<PlayerOuterClass.Equipments, PlayerOuterClass.Equipments.Builder, PlayerOuterClass.EquipmentsOrBuilder> getEquipmentsFieldBuilder() {
                if (this.equipmentsBuilder_ == null) {
                    this.equipmentsBuilder_ = new SingleFieldBuilder(getEquipments(), getParentForChildren(), isClean());
                    this.equipments_ = null;
                }
                return this.equipmentsBuilder_;
            }

            public boolean hasTasks() {
                return ((this.bitField0_ & 0x100000) == 1048576);
            }

            public TaskOuterClass.Tasks getTasks() {
                if (this.tasksBuilder_ == null)
                    return this.tasks_;
                return (TaskOuterClass.Tasks) this.tasksBuilder_.getMessage();
            }

            public Builder setTasks(TaskOuterClass.Tasks value) {
                if (this.tasksBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    this.tasks_ = value;
                    onChanged();
                } else {
                    this.tasksBuilder_.setMessage((GeneratedMessage) value);
                }
                this.bitField0_ |= 0x100000;
                return this;
            }

            public Builder setTasks(TaskOuterClass.Tasks.Builder builderForValue) {
                if (this.tasksBuilder_ == null) {
                    this.tasks_ = builderForValue.build();
                    onChanged();
                } else {
                    this.tasksBuilder_.setMessage((GeneratedMessage) builderForValue.build());
                }
                this.bitField0_ |= 0x100000;
                return this;
            }

            public Builder mergeTasks(TaskOuterClass.Tasks value) {
                if (this.tasksBuilder_ == null) {
                    if ((this.bitField0_ & 0x100000) == 1048576 && this.tasks_ != TaskOuterClass.Tasks.getDefaultInstance()) {
                        this.tasks_ = TaskOuterClass.Tasks.newBuilder(this.tasks_).mergeFrom(value).buildPartial();
                    } else {
                        this.tasks_ = value;
                    }
                    onChanged();
                } else {
                    this.tasksBuilder_.mergeFrom((GeneratedMessage) value);
                }
                this.bitField0_ |= 0x100000;
                return this;
            }

            public Builder clearTasks() {
                if (this.tasksBuilder_ == null) {
                    this.tasks_ = TaskOuterClass.Tasks.getDefaultInstance();
                    onChanged();
                } else {
                    this.tasksBuilder_.clear();
                }
                this.bitField0_ &= 0xFFEFFFFF;
                return this;
            }

            public TaskOuterClass.Tasks.Builder getTasksBuilder() {
                this.bitField0_ |= 0x100000;
                onChanged();
                return (TaskOuterClass.Tasks.Builder) getTasksFieldBuilder().getBuilder();
            }

            public TaskOuterClass.TasksOrBuilder getTasksOrBuilder() {
                if (this.tasksBuilder_ != null)
                    return (TaskOuterClass.TasksOrBuilder) this.tasksBuilder_.getMessageOrBuilder();
                return (TaskOuterClass.TasksOrBuilder) this.tasks_;
            }

            private SingleFieldBuilder<TaskOuterClass.Tasks, TaskOuterClass.Tasks.Builder, TaskOuterClass.TasksOrBuilder> getTasksFieldBuilder() {
                if (this.tasksBuilder_ == null) {
                    this.tasksBuilder_ = new SingleFieldBuilder((GeneratedMessage) getTasks(), getParentForChildren(), isClean());
                    this.tasks_ = null;
                }
                return this.tasksBuilder_;
            }

            public boolean hasOfflineBaseData() {
                return ((this.bitField0_ & 0x200000) == 2097152);
            }

            public PlayerOuterClass.OfflineBaseData getOfflineBaseData() {
                if (this.offlineBaseDataBuilder_ == null)
                    return this.offlineBaseData_;
                return (PlayerOuterClass.OfflineBaseData) this.offlineBaseDataBuilder_.getMessage();
            }

            public Builder setOfflineBaseData(PlayerOuterClass.OfflineBaseData value) {
                if (this.offlineBaseDataBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    this.offlineBaseData_ = value;
                    onChanged();
                } else {
                    this.offlineBaseDataBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x200000;
                return this;
            }

            public Builder setOfflineBaseData(PlayerOuterClass.OfflineBaseData.Builder builderForValue) {
                if (this.offlineBaseDataBuilder_ == null) {
                    this.offlineBaseData_ = builderForValue.build();
                    onChanged();
                } else {
                    this.offlineBaseDataBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x200000;
                return this;
            }

            public Builder mergeOfflineBaseData(PlayerOuterClass.OfflineBaseData value) {
                if (this.offlineBaseDataBuilder_ == null) {
                    if ((this.bitField0_ & 0x200000) == 2097152 && this.offlineBaseData_ != PlayerOuterClass.OfflineBaseData.getDefaultInstance()) {
                        this.offlineBaseData_ = PlayerOuterClass.OfflineBaseData.newBuilder(this.offlineBaseData_).mergeFrom(value).buildPartial();
                    } else {
                        this.offlineBaseData_ = value;
                    }
                    onChanged();
                } else {
                    this.offlineBaseDataBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x200000;
                return this;
            }

            public Builder clearOfflineBaseData() {
                if (this.offlineBaseDataBuilder_ == null) {
                    this.offlineBaseData_ = PlayerOuterClass.OfflineBaseData.getDefaultInstance();
                    onChanged();
                } else {
                    this.offlineBaseDataBuilder_.clear();
                }
                this.bitField0_ &= 0xFFDFFFFF;
                return this;
            }

            public PlayerOuterClass.OfflineBaseData.Builder getOfflineBaseDataBuilder() {
                this.bitField0_ |= 0x200000;
                onChanged();
                return (PlayerOuterClass.OfflineBaseData.Builder) getOfflineBaseDataFieldBuilder().getBuilder();
            }

            public PlayerOuterClass.OfflineBaseDataOrBuilder getOfflineBaseDataOrBuilder() {
                if (this.offlineBaseDataBuilder_ != null)
                    return (PlayerOuterClass.OfflineBaseDataOrBuilder) this.offlineBaseDataBuilder_.getMessageOrBuilder();
                return this.offlineBaseData_;
            }

            private SingleFieldBuilder<PlayerOuterClass.OfflineBaseData, PlayerOuterClass.OfflineBaseData.Builder, PlayerOuterClass.OfflineBaseDataOrBuilder> getOfflineBaseDataFieldBuilder() {
                if (this.offlineBaseDataBuilder_ == null) {
                    this.offlineBaseDataBuilder_ = new SingleFieldBuilder(getOfflineBaseData(), getParentForChildren(), isClean());
                    this.offlineBaseData_ = null;
                }
                return this.offlineBaseDataBuilder_;
            }

            public boolean hasSetData() {
                return ((this.bitField0_ & 0x400000) == 4194304);
            }

            public PlayerOuterClass.SetData getSetData() {
                if (this.setDataBuilder_ == null)
                    return this.setData_;
                return (PlayerOuterClass.SetData) this.setDataBuilder_.getMessage();
            }

            public Builder setSetData(PlayerOuterClass.SetData value) {
                if (this.setDataBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    this.setData_ = value;
                    onChanged();
                } else {
                    this.setDataBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x400000;
                return this;
            }

            public Builder setSetData(PlayerOuterClass.SetData.Builder builderForValue) {
                if (this.setDataBuilder_ == null) {
                    this.setData_ = builderForValue.build();
                    onChanged();
                } else {
                    this.setDataBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x400000;
                return this;
            }

            public Builder mergeSetData(PlayerOuterClass.SetData value) {
                if (this.setDataBuilder_ == null) {
                    if ((this.bitField0_ & 0x400000) == 4194304 && this.setData_ != PlayerOuterClass.SetData.getDefaultInstance()) {
                        this.setData_ = PlayerOuterClass.SetData.newBuilder(this.setData_).mergeFrom(value).buildPartial();
                    } else {
                        this.setData_ = value;
                    }
                    onChanged();
                } else {
                    this.setDataBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x400000;
                return this;
            }

            public Builder clearSetData() {
                if (this.setDataBuilder_ == null) {
                    this.setData_ = PlayerOuterClass.SetData.getDefaultInstance();
                    onChanged();
                } else {
                    this.setDataBuilder_.clear();
                }
                this.bitField0_ &= 0xFFBFFFFF;
                return this;
            }

            public PlayerOuterClass.SetData.Builder getSetDataBuilder() {
                this.bitField0_ |= 0x400000;
                onChanged();
                return (PlayerOuterClass.SetData.Builder) getSetDataFieldBuilder().getBuilder();
            }

            public PlayerOuterClass.SetDataOrBuilder getSetDataOrBuilder() {
                if (this.setDataBuilder_ != null)
                    return (PlayerOuterClass.SetDataOrBuilder) this.setDataBuilder_.getMessageOrBuilder();
                return this.setData_;
            }

            private SingleFieldBuilder<PlayerOuterClass.SetData, PlayerOuterClass.SetData.Builder, PlayerOuterClass.SetDataOrBuilder> getSetDataFieldBuilder() {
                if (this.setDataBuilder_ == null) {
                    this.setDataBuilder_ = new SingleFieldBuilder(getSetData(), getParentForChildren(), isClean());
                    this.setData_ = null;
                }
                return this.setDataBuilder_;
            }

            public boolean hasPrestige() {
                return ((this.bitField0_ & 0x800000) == 8388608);
            }

            public int getPrestige() {
                return this.prestige_;
            }

            public Builder setPrestige(int value) {
                this.bitField0_ |= 0x800000;
                this.prestige_ = value;
                onChanged();
                return this;
            }

            public Builder clearPrestige() {
                this.bitField0_ &= 0xFF7FFFFF;
                this.prestige_ = 0;
                onChanged();
                return this;
            }

            public boolean hasJuewei() {
                return ((this.bitField0_ & 0x1000000) == 16777216);
            }

            public int getJuewei() {
                return this.juewei_;
            }

            public Builder setJuewei(int value) {
                this.bitField0_ |= 0x1000000;
                this.juewei_ = value;
                onChanged();
                return this;
            }

            public Builder clearJuewei() {
                this.bitField0_ &= 0xFEFFFFFF;
                this.juewei_ = 0;
                onChanged();
                return this;
            }

            private void ensureSkillKeysIsMutable() {
                if ((this.bitField0_ & 0x2000000) != 33554432) {
                    this.skillKeys_ = new ArrayList<>(this.skillKeys_);
                    this.bitField0_ |= 0x2000000;
                }
            }

            public List<Common.SkillKeyStruct> getSkillKeysList() {
                if (this.skillKeysBuilder_ == null)
                    return Collections.unmodifiableList(this.skillKeys_);
                return this.skillKeysBuilder_.getMessageList();
            }

            public int getSkillKeysCount() {
                if (this.skillKeysBuilder_ == null)
                    return this.skillKeys_.size();
                return this.skillKeysBuilder_.getCount();
            }

            public Common.SkillKeyStruct getSkillKeys(int index) {
                if (this.skillKeysBuilder_ == null)
                    return this.skillKeys_.get(index);
                return (Common.SkillKeyStruct) this.skillKeysBuilder_.getMessage(index);
            }

            public Builder setSkillKeys(int index, Common.SkillKeyStruct value) {
                if (this.skillKeysBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureSkillKeysIsMutable();
                    this.skillKeys_.set(index, value);
                    onChanged();
                } else {
                    this.skillKeysBuilder_.setMessage(index, (GeneratedMessage) value);
                }
                return this;
            }

            public Builder setSkillKeys(int index, Common.SkillKeyStruct.Builder builderForValue) {
                if (this.skillKeysBuilder_ == null) {
                    ensureSkillKeysIsMutable();
                    this.skillKeys_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.skillKeysBuilder_.setMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addSkillKeys(Common.SkillKeyStruct value) {
                if (this.skillKeysBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureSkillKeysIsMutable();
                    this.skillKeys_.add(value);
                    onChanged();
                } else {
                    this.skillKeysBuilder_.addMessage((GeneratedMessage) value);
                }
                return this;
            }

            public Builder addSkillKeys(int index, Common.SkillKeyStruct value) {
                if (this.skillKeysBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureSkillKeysIsMutable();
                    this.skillKeys_.add(index, value);
                    onChanged();
                } else {
                    this.skillKeysBuilder_.addMessage(index, (GeneratedMessage) value);
                }
                return this;
            }

            public Builder addSkillKeys(Common.SkillKeyStruct.Builder builderForValue) {
                if (this.skillKeysBuilder_ == null) {
                    ensureSkillKeysIsMutable();
                    this.skillKeys_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.skillKeysBuilder_.addMessage((GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addSkillKeys(int index, Common.SkillKeyStruct.Builder builderForValue) {
                if (this.skillKeysBuilder_ == null) {
                    ensureSkillKeysIsMutable();
                    this.skillKeys_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.skillKeysBuilder_.addMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addAllSkillKeys(Iterable<? extends Common.SkillKeyStruct> values) {
                if (this.skillKeysBuilder_ == null) {
                    ensureSkillKeysIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.skillKeys_);
                    onChanged();
                } else {
                    this.skillKeysBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearSkillKeys() {
                if (this.skillKeysBuilder_ == null) {
                    this.skillKeys_ = Collections.emptyList();
                    this.bitField0_ &= 0xFDFFFFFF;
                    onChanged();
                } else {
                    this.skillKeysBuilder_.clear();
                }
                return this;
            }

            public Builder removeSkillKeys(int index) {
                if (this.skillKeysBuilder_ == null) {
                    ensureSkillKeysIsMutable();
                    this.skillKeys_.remove(index);
                    onChanged();
                } else {
                    this.skillKeysBuilder_.remove(index);
                }
                return this;
            }

            public Common.SkillKeyStruct.Builder getSkillKeysBuilder(int index) {
                return (Common.SkillKeyStruct.Builder) getSkillKeysFieldBuilder().getBuilder(index);
            }

            public Common.SkillKeyStructOrBuilder getSkillKeysOrBuilder(int index) {
                if (this.skillKeysBuilder_ == null)
                    return (Common.SkillKeyStructOrBuilder) this.skillKeys_.get(index);
                return (Common.SkillKeyStructOrBuilder) this.skillKeysBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends Common.SkillKeyStructOrBuilder> getSkillKeysOrBuilderList() {
                if (this.skillKeysBuilder_ != null)
                    return this.skillKeysBuilder_.getMessageOrBuilderList();
                return (List) Collections.unmodifiableList(this.skillKeys_);
            }

            public Common.SkillKeyStruct.Builder addSkillKeysBuilder() {
                return (Common.SkillKeyStruct.Builder) getSkillKeysFieldBuilder().addBuilder((GeneratedMessage) Common.SkillKeyStruct.getDefaultInstance());
            }

            public Common.SkillKeyStruct.Builder addSkillKeysBuilder(int index) {
                return (Common.SkillKeyStruct.Builder) getSkillKeysFieldBuilder().addBuilder(index, (GeneratedMessage) Common.SkillKeyStruct.getDefaultInstance());
            }

            public List<Common.SkillKeyStruct.Builder> getSkillKeysBuilderList() {
                return getSkillKeysFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<Common.SkillKeyStruct, Common.SkillKeyStruct.Builder, Common.SkillKeyStructOrBuilder> getSkillKeysFieldBuilder() {
                if (this.skillKeysBuilder_ == null) {
                    this.skillKeysBuilder_ = new RepeatedFieldBuilder(this.skillKeys_, ((this.bitField0_ & 0x2000000) == 33554432), getParentForChildren(), isClean());
                    this.skillKeys_ = null;
                }
                return this.skillKeysBuilder_;
            }

            public boolean hasCountItems() {
                return ((this.bitField0_ & 0x4000000) == 67108864);
            }

            public ItemOuterClass.CountItems getCountItems() {
                if (this.countItemsBuilder_ == null)
                    return this.countItems_;
                return (ItemOuterClass.CountItems) this.countItemsBuilder_.getMessage();
            }

            public Builder setCountItems(ItemOuterClass.CountItems value) {
                if (this.countItemsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    this.countItems_ = value;
                    onChanged();
                } else {
                    this.countItemsBuilder_.setMessage((GeneratedMessage) value);
                }
                this.bitField0_ |= 0x4000000;
                return this;
            }

            public Builder setCountItems(ItemOuterClass.CountItems.Builder builderForValue) {
                if (this.countItemsBuilder_ == null) {
                    this.countItems_ = builderForValue.build();
                    onChanged();
                } else {
                    this.countItemsBuilder_.setMessage((GeneratedMessage) builderForValue.build());
                }
                this.bitField0_ |= 0x4000000;
                return this;
            }

            public Builder mergeCountItems(ItemOuterClass.CountItems value) {
                if (this.countItemsBuilder_ == null) {
                    if ((this.bitField0_ & 0x4000000) == 67108864 && this.countItems_ != ItemOuterClass.CountItems.getDefaultInstance()) {
                        this.countItems_ = ItemOuterClass.CountItems.newBuilder(this.countItems_).mergeFrom(value).buildPartial();
                    } else {
                        this.countItems_ = value;
                    }
                    onChanged();
                } else {
                    this.countItemsBuilder_.mergeFrom((GeneratedMessage) value);
                }
                this.bitField0_ |= 0x4000000;
                return this;
            }

            public Builder clearCountItems() {
                if (this.countItemsBuilder_ == null) {
                    this.countItems_ = ItemOuterClass.CountItems.getDefaultInstance();
                    onChanged();
                } else {
                    this.countItemsBuilder_.clear();
                }
                this.bitField0_ &= 0xFBFFFFFF;
                return this;
            }

            public ItemOuterClass.CountItems.Builder getCountItemsBuilder() {
                this.bitField0_ |= 0x4000000;
                onChanged();
                return (ItemOuterClass.CountItems.Builder) getCountItemsFieldBuilder().getBuilder();
            }

            public ItemOuterClass.CountItemsOrBuilder getCountItemsOrBuilder() {
                if (this.countItemsBuilder_ != null)
                    return (ItemOuterClass.CountItemsOrBuilder) this.countItemsBuilder_.getMessageOrBuilder();
                return (ItemOuterClass.CountItemsOrBuilder) this.countItems_;
            }

            private SingleFieldBuilder<ItemOuterClass.CountItems, ItemOuterClass.CountItems.Builder, ItemOuterClass.CountItemsOrBuilder> getCountItemsFieldBuilder() {
                if (this.countItemsBuilder_ == null) {
                    this.countItemsBuilder_ = new SingleFieldBuilder((GeneratedMessage) getCountItems(), getParentForChildren(), isClean());
                    this.countItems_ = null;
                }
                return this.countItemsBuilder_;
            }

            public boolean hasTicket() {
                return ((this.bitField0_ & 0x8000000) == 134217728);
            }

            public long getTicket() {
                return this.ticket_;
            }

            public Builder setTicket(long value) {
                this.bitField0_ |= 0x8000000;
                this.ticket_ = value;
                onChanged();
                return this;
            }

            public Builder clearTicket() {
                this.bitField0_ &= 0xF7FFFFFF;
                this.ticket_ = 0L;
                onChanged();
                return this;
            }

            public boolean hasFriendly() {
                return ((this.bitField0_ & 0x10000000) == 268435456);
            }

            public int getFriendly() {
                return this.friendly_;
            }

            public Builder setFriendly(int value) {
                this.bitField0_ |= 0x10000000;
                this.friendly_ = value;
                onChanged();
                return this;
            }

            public Builder clearFriendly() {
                this.bitField0_ &= 0xEFFFFFFF;
                this.friendly_ = 0;
                onChanged();
                return this;
            }

            public boolean hasUpLevel() {
                return ((this.bitField0_ & 0x20000000) == 536870912);
            }

            public int getUpLevel() {
                return this.upLevel_;
            }

            public Builder setUpLevel(int value) {
                this.bitField0_ |= 0x20000000;
                this.upLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearUpLevel() {
                this.bitField0_ &= 0xDFFFFFFF;
                this.upLevel_ = 0;
                onChanged();
                return this;
            }

            public boolean hasReqLevel() {
                return ((this.bitField0_ & 0x40000000) == 1073741824);
            }

            public int getReqLevel() {
                return this.reqLevel_;
            }

            public Builder setReqLevel(int value) {
                this.bitField0_ |= 0x40000000;
                this.reqLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearReqLevel() {
                this.bitField0_ &= 0xBFFFFFFF;
                this.reqLevel_ = 0;
                onChanged();
                return this;
            }

            public boolean hasPkModel() {
                return ((this.bitField0_ & Integer.MIN_VALUE) == Integer.MIN_VALUE);
            }

            public int getPkModel() {
                return this.pkModel_;
            }

            public Builder setPkModel(int value) {
                this.bitField0_ |= Integer.MIN_VALUE;
                this.pkModel_ = value;
                onChanged();
                return this;
            }

            public Builder clearPkModel() {
                this.bitField0_ &= Integer.MAX_VALUE;
                this.pkModel_ = 0;
                onChanged();
                return this;
            }

            public boolean hasPkValue() {
                return ((this.bitField1_ & 0x1) == 1);
            }

            public int getPkValue() {
                return this.pkValue_;
            }

            public Builder setPkValue(int value) {
                this.bitField1_ |= 0x1;
                this.pkValue_ = value;
                onChanged();
                return this;
            }

            public Builder clearPkValue() {
                this.bitField1_ &= 0xFFFFFFFE;
                this.pkValue_ = 0;
                onChanged();
                return this;
            }

            public boolean hasHookSetData() {
                return ((this.bitField1_ & 0x2) == 2);
            }

            public PlayerOuterClass.HookSetData getHookSetData() {
                if (this.hookSetDataBuilder_ == null)
                    return this.hookSetData_;
                return (PlayerOuterClass.HookSetData) this.hookSetDataBuilder_.getMessage();
            }

            public Builder setHookSetData(PlayerOuterClass.HookSetData value) {
                if (this.hookSetDataBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    this.hookSetData_ = value;
                    onChanged();
                } else {
                    this.hookSetDataBuilder_.setMessage(value);
                }
                this.bitField1_ |= 0x2;
                return this;
            }

            public Builder setHookSetData(PlayerOuterClass.HookSetData.Builder builderForValue) {
                if (this.hookSetDataBuilder_ == null) {
                    this.hookSetData_ = builderForValue.build();
                    onChanged();
                } else {
                    this.hookSetDataBuilder_.setMessage(builderForValue.build());
                }
                this.bitField1_ |= 0x2;
                return this;
            }

            public Builder mergeHookSetData(PlayerOuterClass.HookSetData value) {
                if (this.hookSetDataBuilder_ == null) {
                    if ((this.bitField1_ & 0x2) == 2 && this.hookSetData_ != PlayerOuterClass.HookSetData.getDefaultInstance()) {
                        this.hookSetData_ = PlayerOuterClass.HookSetData.newBuilder(this.hookSetData_).mergeFrom(value).buildPartial();
                    } else {
                        this.hookSetData_ = value;
                    }
                    onChanged();
                } else {
                    this.hookSetDataBuilder_.mergeFrom(value);
                }
                this.bitField1_ |= 0x2;
                return this;
            }

            public Builder clearHookSetData() {
                if (this.hookSetDataBuilder_ == null) {
                    this.hookSetData_ = PlayerOuterClass.HookSetData.getDefaultInstance();
                    onChanged();
                } else {
                    this.hookSetDataBuilder_.clear();
                }
                this.bitField1_ &= 0xFFFFFFFD;
                return this;
            }

            public PlayerOuterClass.HookSetData.Builder getHookSetDataBuilder() {
                this.bitField1_ |= 0x2;
                onChanged();
                return (PlayerOuterClass.HookSetData.Builder) getHookSetDataFieldBuilder().getBuilder();
            }

            public PlayerOuterClass.HookSetDataOrBuilder getHookSetDataOrBuilder() {
                if (this.hookSetDataBuilder_ != null)
                    return (PlayerOuterClass.HookSetDataOrBuilder) this.hookSetDataBuilder_.getMessageOrBuilder();
                return this.hookSetData_;
            }

            private SingleFieldBuilder<PlayerOuterClass.HookSetData, PlayerOuterClass.HookSetData.Builder, PlayerOuterClass.HookSetDataOrBuilder> getHookSetDataFieldBuilder() {
                if (this.hookSetDataBuilder_ == null) {
                    this.hookSetDataBuilder_ = new SingleFieldBuilder(getHookSetData(), getParentForChildren(), isClean());
                    this.hookSetData_ = null;
                }
                return this.hookSetDataBuilder_;
            }

            public boolean hasZoneId() {
                return ((this.bitField1_ & 0x4) == 4);
            }

            public String getZoneId() {
                Object ref = this.zoneId_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.zoneId_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getZoneIdBytes() {
                Object ref = this.zoneId_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.zoneId_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setZoneId(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField1_ |= 0x4;
                this.zoneId_ = value;
                onChanged();
                return this;
            }

            public Builder clearZoneId() {
                this.bitField1_ &= 0xFFFFFFFB;
                this.zoneId_ = PlayerOuterClass.Player.getDefaultInstance().getZoneId();
                onChanged();
                return this;
            }

            public Builder setZoneIdBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField1_ |= 0x4;
                this.zoneId_ = value;
                onChanged();
                return this;
            }

            public boolean hasSolopoint() {
                return ((this.bitField1_ & 0x8) == 8);
            }

            public int getSolopoint() {
                return this.solopoint_;
            }

            public Builder setSolopoint(int value) {
                this.bitField1_ |= 0x8;
                this.solopoint_ = value;
                onChanged();
                return this;
            }

            public Builder clearSolopoint() {
                this.bitField1_ &= 0xFFFFFFF7;
                this.solopoint_ = 0;
                onChanged();
                return this;
            }

            public boolean hasConsumePoint() {
                return ((this.bitField1_ & 0x10) == 16);
            }

            public int getConsumePoint() {
                return this.consumePoint_;
            }

            public Builder setConsumePoint(int value) {
                this.bitField1_ |= 0x10;
                this.consumePoint_ = value;
                onChanged();
                return this;
            }

            public Builder clearConsumePoint() {
                this.bitField1_ &= 0xFFFFFFEF;
                this.consumePoint_ = 0;
                onChanged();
                return this;
            }

            public boolean hasPawnGold() {
                return ((this.bitField1_ & 0x20) == 32);
            }

            public int getPawnGold() {
                return this.pawnGold_;
            }

            public Builder setPawnGold(int value) {
                this.bitField1_ |= 0x20;
                this.pawnGold_ = value;
                onChanged();
                return this;
            }

            public Builder clearPawnGold() {
                this.bitField1_ &= 0xFFFFFFDF;
                this.pawnGold_ = 0;
                onChanged();
                return this;
            }

            public boolean hasPetPkModel() {
                return ((this.bitField1_ & 0x40) == 64);
            }

            public int getPetPkModel() {
                return this.petPkModel_;
            }

            public Builder setPetPkModel(int value) {
                this.bitField1_ |= 0x40;
                this.petPkModel_ = value;
                onChanged();
                return this;
            }

            public Builder clearPetPkModel() {
                this.bitField1_ &= 0xFFFFFFBF;
                this.petPkModel_ = 0;
                onChanged();
                return this;
            }

            public boolean hasGuildpoint() {
                return ((this.bitField1_ & 0x80) == 128);
            }

            public int getGuildpoint() {
                return this.guildpoint_;
            }

            public Builder setGuildpoint(int value) {
                this.bitField1_ |= 0x80;
                this.guildpoint_ = value;
                onChanged();
                return this;
            }

            public Builder clearGuildpoint() {
                this.bitField1_ &= 0xFFFFFF7F;
                this.guildpoint_ = 0;
                onChanged();
                return this;
            }

            private void ensureFunctionListIsMutable() {
                if ((this.bitField1_ & 0x100) != 256) {
                    this.functionList_ = new ArrayList<>(this.functionList_);
                    this.bitField1_ |= 0x100;
                }
            }

            public List<PlayerOuterClass.FunctionInfo> getFunctionListList() {
                if (this.functionListBuilder_ == null)
                    return Collections.unmodifiableList(this.functionList_);
                return this.functionListBuilder_.getMessageList();
            }

            public int getFunctionListCount() {
                if (this.functionListBuilder_ == null)
                    return this.functionList_.size();
                return this.functionListBuilder_.getCount();
            }

            public PlayerOuterClass.FunctionInfo getFunctionList(int index) {
                if (this.functionListBuilder_ == null)
                    return this.functionList_.get(index);
                return (PlayerOuterClass.FunctionInfo) this.functionListBuilder_.getMessage(index);
            }

            public Builder setFunctionList(int index, PlayerOuterClass.FunctionInfo value) {
                if (this.functionListBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureFunctionListIsMutable();
                    this.functionList_.set(index, value);
                    onChanged();
                } else {
                    this.functionListBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setFunctionList(int index, PlayerOuterClass.FunctionInfo.Builder builderForValue) {
                if (this.functionListBuilder_ == null) {
                    ensureFunctionListIsMutable();
                    this.functionList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.functionListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addFunctionList(PlayerOuterClass.FunctionInfo value) {
                if (this.functionListBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureFunctionListIsMutable();
                    this.functionList_.add(value);
                    onChanged();
                } else {
                    this.functionListBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addFunctionList(int index, PlayerOuterClass.FunctionInfo value) {
                if (this.functionListBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureFunctionListIsMutable();
                    this.functionList_.add(index, value);
                    onChanged();
                } else {
                    this.functionListBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addFunctionList(PlayerOuterClass.FunctionInfo.Builder builderForValue) {
                if (this.functionListBuilder_ == null) {
                    ensureFunctionListIsMutable();
                    this.functionList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.functionListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addFunctionList(int index, PlayerOuterClass.FunctionInfo.Builder builderForValue) {
                if (this.functionListBuilder_ == null) {
                    ensureFunctionListIsMutable();
                    this.functionList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.functionListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllFunctionList(Iterable<? extends PlayerOuterClass.FunctionInfo> values) {
                if (this.functionListBuilder_ == null) {
                    ensureFunctionListIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.functionList_);
                    onChanged();
                } else {
                    this.functionListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearFunctionList() {
                if (this.functionListBuilder_ == null) {
                    this.functionList_ = Collections.emptyList();
                    this.bitField1_ &= 0xFFFFFEFF;
                    onChanged();
                } else {
                    this.functionListBuilder_.clear();
                }
                return this;
            }

            public Builder removeFunctionList(int index) {
                if (this.functionListBuilder_ == null) {
                    ensureFunctionListIsMutable();
                    this.functionList_.remove(index);
                    onChanged();
                } else {
                    this.functionListBuilder_.remove(index);
                }
                return this;
            }

            public PlayerOuterClass.FunctionInfo.Builder getFunctionListBuilder(int index) {
                return (PlayerOuterClass.FunctionInfo.Builder) getFunctionListFieldBuilder().getBuilder(index);
            }

            public PlayerOuterClass.FunctionInfoOrBuilder getFunctionListOrBuilder(int index) {
                if (this.functionListBuilder_ == null)
                    return this.functionList_.get(index);
                return (PlayerOuterClass.FunctionInfoOrBuilder) this.functionListBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends PlayerOuterClass.FunctionInfoOrBuilder> getFunctionListOrBuilderList() {
                if (this.functionListBuilder_ != null)
                    return this.functionListBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.functionList_);
            }

            public PlayerOuterClass.FunctionInfo.Builder addFunctionListBuilder() {
                return (PlayerOuterClass.FunctionInfo.Builder) getFunctionListFieldBuilder().addBuilder(PlayerOuterClass.FunctionInfo.getDefaultInstance());
            }

            public PlayerOuterClass.FunctionInfo.Builder addFunctionListBuilder(int index) {
                return (PlayerOuterClass.FunctionInfo.Builder) getFunctionListFieldBuilder().addBuilder(index, PlayerOuterClass.FunctionInfo.getDefaultInstance());
            }

            public List<PlayerOuterClass.FunctionInfo.Builder> getFunctionListBuilderList() {
                return getFunctionListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<PlayerOuterClass.FunctionInfo, PlayerOuterClass.FunctionInfo.Builder, PlayerOuterClass.FunctionInfoOrBuilder> getFunctionListFieldBuilder() {
                if (this.functionListBuilder_ == null) {
                    this.functionListBuilder_ = new RepeatedFieldBuilder(this.functionList_, ((this.bitField1_ & 0x100) == 256), getParentForChildren(), isClean());
                    this.functionList_ = null;
                }
                return this.functionListBuilder_;
            }

            private void ensureClientConfigIsMutable() {
                if ((this.bitField1_ & 0x200) != 512) {
                    this.clientConfig_ = new ArrayList<>(this.clientConfig_);
                    this.bitField1_ |= 0x200;
                }
            }

            public List<Common.KeyValueStruct> getClientConfigList() {
                if (this.clientConfigBuilder_ == null)
                    return Collections.unmodifiableList(this.clientConfig_);
                return this.clientConfigBuilder_.getMessageList();
            }

            public int getClientConfigCount() {
                if (this.clientConfigBuilder_ == null)
                    return this.clientConfig_.size();
                return this.clientConfigBuilder_.getCount();
            }

            public Common.KeyValueStruct getClientConfig(int index) {
                if (this.clientConfigBuilder_ == null)
                    return this.clientConfig_.get(index);
                return (Common.KeyValueStruct) this.clientConfigBuilder_.getMessage(index);
            }

            public Builder setClientConfig(int index, Common.KeyValueStruct value) {
                if (this.clientConfigBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureClientConfigIsMutable();
                    this.clientConfig_.set(index, value);
                    onChanged();
                } else {
                    this.clientConfigBuilder_.setMessage(index, (GeneratedMessage) value);
                }
                return this;
            }

            public Builder setClientConfig(int index, Common.KeyValueStruct.Builder builderForValue) {
                if (this.clientConfigBuilder_ == null) {
                    ensureClientConfigIsMutable();
                    this.clientConfig_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.clientConfigBuilder_.setMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addClientConfig(Common.KeyValueStruct value) {
                if (this.clientConfigBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureClientConfigIsMutable();
                    this.clientConfig_.add(value);
                    onChanged();
                } else {
                    this.clientConfigBuilder_.addMessage((GeneratedMessage) value);
                }
                return this;
            }

            public Builder addClientConfig(int index, Common.KeyValueStruct value) {
                if (this.clientConfigBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureClientConfigIsMutable();
                    this.clientConfig_.add(index, value);
                    onChanged();
                } else {
                    this.clientConfigBuilder_.addMessage(index, (GeneratedMessage) value);
                }
                return this;
            }

            public Builder addClientConfig(Common.KeyValueStruct.Builder builderForValue) {
                if (this.clientConfigBuilder_ == null) {
                    ensureClientConfigIsMutable();
                    this.clientConfig_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.clientConfigBuilder_.addMessage((GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addClientConfig(int index, Common.KeyValueStruct.Builder builderForValue) {
                if (this.clientConfigBuilder_ == null) {
                    ensureClientConfigIsMutable();
                    this.clientConfig_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.clientConfigBuilder_.addMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addAllClientConfig(Iterable<? extends Common.KeyValueStruct> values) {
                if (this.clientConfigBuilder_ == null) {
                    ensureClientConfigIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.clientConfig_);
                    onChanged();
                } else {
                    this.clientConfigBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearClientConfig() {
                if (this.clientConfigBuilder_ == null) {
                    this.clientConfig_ = Collections.emptyList();
                    this.bitField1_ &= 0xFFFFFDFF;
                    onChanged();
                } else {
                    this.clientConfigBuilder_.clear();
                }
                return this;
            }

            public Builder removeClientConfig(int index) {
                if (this.clientConfigBuilder_ == null) {
                    ensureClientConfigIsMutable();
                    this.clientConfig_.remove(index);
                    onChanged();
                } else {
                    this.clientConfigBuilder_.remove(index);
                }
                return this;
            }

            public Common.KeyValueStruct.Builder getClientConfigBuilder(int index) {
                return (Common.KeyValueStruct.Builder) getClientConfigFieldBuilder().getBuilder(index);
            }

            public Common.KeyValueStructOrBuilder getClientConfigOrBuilder(int index) {
                if (this.clientConfigBuilder_ == null)
                    return (Common.KeyValueStructOrBuilder) this.clientConfig_.get(index);
                return (Common.KeyValueStructOrBuilder) this.clientConfigBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends Common.KeyValueStructOrBuilder> getClientConfigOrBuilderList() {
                if (this.clientConfigBuilder_ != null)
                    return this.clientConfigBuilder_.getMessageOrBuilderList();
                return (List) Collections.unmodifiableList(this.clientConfig_);
            }

            public Common.KeyValueStruct.Builder addClientConfigBuilder() {
                return (Common.KeyValueStruct.Builder) getClientConfigFieldBuilder().addBuilder((GeneratedMessage) Common.KeyValueStruct.getDefaultInstance());
            }

            public Common.KeyValueStruct.Builder addClientConfigBuilder(int index) {
                return (Common.KeyValueStruct.Builder) getClientConfigFieldBuilder().addBuilder(index, (GeneratedMessage) Common.KeyValueStruct.getDefaultInstance());
            }

            public List<Common.KeyValueStruct.Builder> getClientConfigBuilderList() {
                return getClientConfigFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<Common.KeyValueStruct, Common.KeyValueStruct.Builder, Common.KeyValueStructOrBuilder> getClientConfigFieldBuilder() {
                if (this.clientConfigBuilder_ == null) {
                    this.clientConfigBuilder_ = new RepeatedFieldBuilder(this.clientConfig_, ((this.bitField1_ & 0x200) == 512), getParentForChildren(), isClean());
                    this.clientConfig_ = null;
                }
                return this.clientConfigBuilder_;
            }

            public boolean hasFightingPetId() {
                return ((this.bitField1_ & 0x400) == 1024);
            }

            public String getFightingPetId() {
                Object ref = this.fightingPetId_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.fightingPetId_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getFightingPetIdBytes() {
                Object ref = this.fightingPetId_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.fightingPetId_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setFightingPetId(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField1_ |= 0x400;
                this.fightingPetId_ = value;
                onChanged();
                return this;
            }

            public Builder clearFightingPetId() {
                this.bitField1_ &= 0xFFFFFBFF;
                this.fightingPetId_ = PlayerOuterClass.Player.getDefaultInstance().getFightingPetId();
                onChanged();
                return this;
            }

            public Builder setFightingPetIdBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField1_ |= 0x400;
                this.fightingPetId_ = value;
                onChanged();
                return this;
            }

            public boolean hasMapId() {
                return ((this.bitField1_ & 0x800) == 2048);
            }

            public int getMapId() {
                return this.mapId_;
            }

            public Builder setMapId(int value) {
                this.bitField1_ |= 0x800;
                this.mapId_ = value;
                onChanged();
                return this;
            }

            public Builder clearMapId() {
                this.bitField1_ &= 0xFFFFF7FF;
                this.mapId_ = 0;
                onChanged();
                return this;
            }

            public boolean hasInstanceId() {
                return ((this.bitField1_ & 0x1000) == 4096);
            }

            public String getInstanceId() {
                Object ref = this.instanceId_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.instanceId_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getInstanceIdBytes() {
                Object ref = this.instanceId_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.instanceId_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setInstanceId(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField1_ |= 0x1000;
                this.instanceId_ = value;
                onChanged();
                return this;
            }

            public Builder clearInstanceId() {
                this.bitField1_ &= 0xFFFFEFFF;
                this.instanceId_ = PlayerOuterClass.Player.getDefaultInstance().getInstanceId();
                onChanged();
                return this;
            }

            public Builder setInstanceIdBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField1_ |= 0x1000;
                this.instanceId_ = value;
                onChanged();
                return this;
            }

            public boolean hasTreasurePoint() {
                return ((this.bitField1_ & 0x2000) == 8192);
            }

            public int getTreasurePoint() {
                return this.treasurePoint_;
            }

            public Builder setTreasurePoint(int value) {
                this.bitField1_ |= 0x2000;
                this.treasurePoint_ = value;
                onChanged();
                return this;
            }

            public Builder clearTreasurePoint() {
                this.bitField1_ &= 0xFFFFDFFF;
                this.treasurePoint_ = 0;
                onChanged();
                return this;
            }

            public boolean hasPayGiftData() {
                return ((this.bitField1_ & 0x4000) == 16384);
            }

            public int getPayGiftData() {
                return this.payGiftData_;
            }

            public Builder setPayGiftData(int value) {
                this.bitField1_ |= 0x4000;
                this.payGiftData_ = value;
                onChanged();
                return this;
            }

            public Builder clearPayGiftData() {
                this.bitField1_ &= 0xFFFFBFFF;
                this.payGiftData_ = 0;
                onChanged();
                return this;
            }

            private void ensureBlackListIsMutable() {
                if ((this.bitField1_ & 0x8000) != 32768) {
                    this.blackList_ = (LazyStringList) new LazyStringArrayList(this.blackList_);
                    this.bitField1_ |= 0x8000;
                }
            }

            public ProtocolStringList getBlackListList() {
                return (ProtocolStringList) this.blackList_.getUnmodifiableView();
            }

            public int getBlackListCount() {
                return this.blackList_.size();
            }

            public String getBlackList(int index) {
                return (String) this.blackList_.get(index);
            }

            public ByteString getBlackListBytes(int index) {
                return this.blackList_.getByteString(index);
            }

            public Builder setBlackList(int index, String value) {
                if (value == null)
                    throw new NullPointerException();
                ensureBlackListIsMutable();
                this.blackList_.set(index, value);
                onChanged();
                return this;
            }

            public Builder addBlackList(String value) {
                if (value == null)
                    throw new NullPointerException();
                ensureBlackListIsMutable();
                this.blackList_.add(value);
                onChanged();
                return this;
            }

            public Builder addAllBlackList(Iterable<String> values) {
                ensureBlackListIsMutable();
                AbstractMessageLite.Builder.addAll(values, (Collection) this.blackList_);
                onChanged();
                return this;
            }

            public Builder clearBlackList() {
                this.blackList_ = LazyStringArrayList.EMPTY;
                this.bitField1_ &= 0xFFFF7FFF;
                onChanged();
                return this;
            }

            public Builder addBlackListBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                ensureBlackListIsMutable();
                this.blackList_.add(value);
                onChanged();
                return this;
            }

            private void ensureStrengthPosIsMutable() {
                if ((this.bitField1_ & 0x10000) != 65536) {
                    this.strengthPos_ = new ArrayList<>(this.strengthPos_);
                    this.bitField1_ |= 0x10000;
                }
            }

            public List<ItemOuterClass.EquipGridStrengthInfo> getStrengthPosList() {
                if (this.strengthPosBuilder_ == null)
                    return Collections.unmodifiableList(this.strengthPos_);
                return this.strengthPosBuilder_.getMessageList();
            }

            public int getStrengthPosCount() {
                if (this.strengthPosBuilder_ == null)
                    return this.strengthPos_.size();
                return this.strengthPosBuilder_.getCount();
            }

            public ItemOuterClass.EquipGridStrengthInfo getStrengthPos(int index) {
                if (this.strengthPosBuilder_ == null)
                    return this.strengthPos_.get(index);
                return (ItemOuterClass.EquipGridStrengthInfo) this.strengthPosBuilder_.getMessage(index);
            }

            public Builder setStrengthPos(int index, ItemOuterClass.EquipGridStrengthInfo value) {
                if (this.strengthPosBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureStrengthPosIsMutable();
                    this.strengthPos_.set(index, value);
                    onChanged();
                } else {
                    this.strengthPosBuilder_.setMessage(index, (GeneratedMessage) value);
                }
                return this;
            }

            public Builder setStrengthPos(int index, ItemOuterClass.EquipGridStrengthInfo.Builder builderForValue) {
                if (this.strengthPosBuilder_ == null) {
                    ensureStrengthPosIsMutable();
                    this.strengthPos_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.strengthPosBuilder_.setMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addStrengthPos(ItemOuterClass.EquipGridStrengthInfo value) {
                if (this.strengthPosBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureStrengthPosIsMutable();
                    this.strengthPos_.add(value);
                    onChanged();
                } else {
                    this.strengthPosBuilder_.addMessage((GeneratedMessage) value);
                }
                return this;
            }

            public Builder addStrengthPos(int index, ItemOuterClass.EquipGridStrengthInfo value) {
                if (this.strengthPosBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureStrengthPosIsMutable();
                    this.strengthPos_.add(index, value);
                    onChanged();
                } else {
                    this.strengthPosBuilder_.addMessage(index, (GeneratedMessage) value);
                }
                return this;
            }

            public Builder addStrengthPos(ItemOuterClass.EquipGridStrengthInfo.Builder builderForValue) {
                if (this.strengthPosBuilder_ == null) {
                    ensureStrengthPosIsMutable();
                    this.strengthPos_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.strengthPosBuilder_.addMessage((GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addStrengthPos(int index, ItemOuterClass.EquipGridStrengthInfo.Builder builderForValue) {
                if (this.strengthPosBuilder_ == null) {
                    ensureStrengthPosIsMutable();
                    this.strengthPos_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.strengthPosBuilder_.addMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addAllStrengthPos(Iterable<? extends ItemOuterClass.EquipGridStrengthInfo> values) {
                if (this.strengthPosBuilder_ == null) {
                    ensureStrengthPosIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.strengthPos_);
                    onChanged();
                } else {
                    this.strengthPosBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearStrengthPos() {
                if (this.strengthPosBuilder_ == null) {
                    this.strengthPos_ = Collections.emptyList();
                    this.bitField1_ &= 0xFFFEFFFF;
                    onChanged();
                } else {
                    this.strengthPosBuilder_.clear();
                }
                return this;
            }

            public Builder removeStrengthPos(int index) {
                if (this.strengthPosBuilder_ == null) {
                    ensureStrengthPosIsMutable();
                    this.strengthPos_.remove(index);
                    onChanged();
                } else {
                    this.strengthPosBuilder_.remove(index);
                }
                return this;
            }

            public ItemOuterClass.EquipGridStrengthInfo.Builder getStrengthPosBuilder(int index) {
                return (ItemOuterClass.EquipGridStrengthInfo.Builder) getStrengthPosFieldBuilder().getBuilder(index);
            }

            public ItemOuterClass.EquipGridStrengthInfoOrBuilder getStrengthPosOrBuilder(int index) {
                if (this.strengthPosBuilder_ == null)
                    return (ItemOuterClass.EquipGridStrengthInfoOrBuilder) this.strengthPos_.get(index);
                return (ItemOuterClass.EquipGridStrengthInfoOrBuilder) this.strengthPosBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends ItemOuterClass.EquipGridStrengthInfoOrBuilder> getStrengthPosOrBuilderList() {
                if (this.strengthPosBuilder_ != null)
                    return this.strengthPosBuilder_.getMessageOrBuilderList();
                return (List) Collections.unmodifiableList(this.strengthPos_);
            }

            public ItemOuterClass.EquipGridStrengthInfo.Builder addStrengthPosBuilder() {
                return (ItemOuterClass.EquipGridStrengthInfo.Builder) getStrengthPosFieldBuilder().addBuilder((GeneratedMessage) ItemOuterClass.EquipGridStrengthInfo.getDefaultInstance());
            }

            public ItemOuterClass.EquipGridStrengthInfo.Builder addStrengthPosBuilder(int index) {
                return (ItemOuterClass.EquipGridStrengthInfo.Builder) getStrengthPosFieldBuilder().addBuilder(index, (GeneratedMessage) ItemOuterClass.EquipGridStrengthInfo.getDefaultInstance());
            }

            public List<ItemOuterClass.EquipGridStrengthInfo.Builder> getStrengthPosBuilderList() {
                return getStrengthPosFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<ItemOuterClass.EquipGridStrengthInfo, ItemOuterClass.EquipGridStrengthInfo.Builder, ItemOuterClass.EquipGridStrengthInfoOrBuilder> getStrengthPosFieldBuilder() {
                if (this.strengthPosBuilder_ == null) {
                    this.strengthPosBuilder_ = new RepeatedFieldBuilder(this.strengthPos_, ((this.bitField1_ & 0x10000) == 65536), getParentForChildren(), isClean());
                    this.strengthPos_ = null;
                }
                return this.strengthPosBuilder_;
            }

            public boolean hasGuildId() {
                return ((this.bitField1_ & 0x20000) == 131072);
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
                this.bitField1_ |= 0x20000;
                this.guildId_ = value;
                onChanged();
                return this;
            }

            public Builder clearGuildId() {
                this.bitField1_ &= 0xFFFDFFFF;
                this.guildId_ = PlayerOuterClass.Player.getDefaultInstance().getGuildId();
                onChanged();
                return this;
            }

            public Builder setGuildIdBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField1_ |= 0x20000;
                this.guildId_ = value;
                onChanged();
                return this;
            }

            public boolean hasGuildPro() {
                return ((this.bitField1_ & 0x40000) == 262144);
            }

            public int getGuildPro() {
                return this.guildPro_;
            }

            public Builder setGuildPro(int value) {
                this.bitField1_ |= 0x40000;
                this.guildPro_ = value;
                onChanged();
                return this;
            }

            public Builder clearGuildPro() {
                this.bitField1_ &= 0xFFFBFFFF;
                this.guildPro_ = 0;
                onChanged();
                return this;
            }

            public boolean hasOpenMount() {
                return ((this.bitField1_ & 0x80000) == 524288);
            }

            public int getOpenMount() {
                return this.openMount_;
            }

            public Builder setOpenMount(int value) {
                this.bitField1_ |= 0x80000;
                this.openMount_ = value;
                onChanged();
                return this;
            }

            public Builder clearOpenMount() {
                this.bitField1_ &= 0xFFF7FFFF;
                this.openMount_ = 0;
                onChanged();
                return this;
            }

            private void ensureFashionInfoIsMutable() {
                if ((this.bitField1_ & 0x100000) != 1048576) {
                    this.fashionInfo_ = new ArrayList<>(this.fashionInfo_);
                    this.bitField1_ |= 0x100000;
                }
            }

            public List<ItemOuterClass.EquipFashionInfo> getFashionInfoList() {
                if (this.fashionInfoBuilder_ == null)
                    return Collections.unmodifiableList(this.fashionInfo_);
                return this.fashionInfoBuilder_.getMessageList();
            }

            public int getFashionInfoCount() {
                if (this.fashionInfoBuilder_ == null)
                    return this.fashionInfo_.size();
                return this.fashionInfoBuilder_.getCount();
            }

            public ItemOuterClass.EquipFashionInfo getFashionInfo(int index) {
                if (this.fashionInfoBuilder_ == null)
                    return this.fashionInfo_.get(index);
                return (ItemOuterClass.EquipFashionInfo) this.fashionInfoBuilder_.getMessage(index);
            }

            public Builder setFashionInfo(int index, ItemOuterClass.EquipFashionInfo value) {
                if (this.fashionInfoBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureFashionInfoIsMutable();
                    this.fashionInfo_.set(index, value);
                    onChanged();
                } else {
                    this.fashionInfoBuilder_.setMessage(index, (GeneratedMessage) value);
                }
                return this;
            }

            public Builder setFashionInfo(int index, ItemOuterClass.EquipFashionInfo.Builder builderForValue) {
                if (this.fashionInfoBuilder_ == null) {
                    ensureFashionInfoIsMutable();
                    this.fashionInfo_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.fashionInfoBuilder_.setMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addFashionInfo(ItemOuterClass.EquipFashionInfo value) {
                if (this.fashionInfoBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureFashionInfoIsMutable();
                    this.fashionInfo_.add(value);
                    onChanged();
                } else {
                    this.fashionInfoBuilder_.addMessage((GeneratedMessage) value);
                }
                return this;
            }

            public Builder addFashionInfo(int index, ItemOuterClass.EquipFashionInfo value) {
                if (this.fashionInfoBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureFashionInfoIsMutable();
                    this.fashionInfo_.add(index, value);
                    onChanged();
                } else {
                    this.fashionInfoBuilder_.addMessage(index, (GeneratedMessage) value);
                }
                return this;
            }

            public Builder addFashionInfo(ItemOuterClass.EquipFashionInfo.Builder builderForValue) {
                if (this.fashionInfoBuilder_ == null) {
                    ensureFashionInfoIsMutable();
                    this.fashionInfo_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.fashionInfoBuilder_.addMessage((GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addFashionInfo(int index, ItemOuterClass.EquipFashionInfo.Builder builderForValue) {
                if (this.fashionInfoBuilder_ == null) {
                    ensureFashionInfoIsMutable();
                    this.fashionInfo_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.fashionInfoBuilder_.addMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addAllFashionInfo(Iterable<? extends ItemOuterClass.EquipFashionInfo> values) {
                if (this.fashionInfoBuilder_ == null) {
                    ensureFashionInfoIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.fashionInfo_);
                    onChanged();
                } else {
                    this.fashionInfoBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearFashionInfo() {
                if (this.fashionInfoBuilder_ == null) {
                    this.fashionInfo_ = Collections.emptyList();
                    this.bitField1_ &= 0xFFEFFFFF;
                    onChanged();
                } else {
                    this.fashionInfoBuilder_.clear();
                }
                return this;
            }

            public Builder removeFashionInfo(int index) {
                if (this.fashionInfoBuilder_ == null) {
                    ensureFashionInfoIsMutable();
                    this.fashionInfo_.remove(index);
                    onChanged();
                } else {
                    this.fashionInfoBuilder_.remove(index);
                }
                return this;
            }

            public ItemOuterClass.EquipFashionInfo.Builder getFashionInfoBuilder(int index) {
                return (ItemOuterClass.EquipFashionInfo.Builder) getFashionInfoFieldBuilder().getBuilder(index);
            }

            public ItemOuterClass.EquipFashionInfoOrBuilder getFashionInfoOrBuilder(int index) {
                if (this.fashionInfoBuilder_ == null)
                    return (ItemOuterClass.EquipFashionInfoOrBuilder) this.fashionInfo_.get(index);
                return (ItemOuterClass.EquipFashionInfoOrBuilder) this.fashionInfoBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends ItemOuterClass.EquipFashionInfoOrBuilder> getFashionInfoOrBuilderList() {
                if (this.fashionInfoBuilder_ != null)
                    return this.fashionInfoBuilder_.getMessageOrBuilderList();
                return (List) Collections.unmodifiableList(this.fashionInfo_);
            }

            public ItemOuterClass.EquipFashionInfo.Builder addFashionInfoBuilder() {
                return (ItemOuterClass.EquipFashionInfo.Builder) getFashionInfoFieldBuilder().addBuilder((GeneratedMessage) ItemOuterClass.EquipFashionInfo.getDefaultInstance());
            }

            public ItemOuterClass.EquipFashionInfo.Builder addFashionInfoBuilder(int index) {
                return (ItemOuterClass.EquipFashionInfo.Builder) getFashionInfoFieldBuilder().addBuilder(index, (GeneratedMessage) ItemOuterClass.EquipFashionInfo.getDefaultInstance());
            }

            public List<ItemOuterClass.EquipFashionInfo.Builder> getFashionInfoBuilderList() {
                return getFashionInfoFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<ItemOuterClass.EquipFashionInfo, ItemOuterClass.EquipFashionInfo.Builder, ItemOuterClass.EquipFashionInfoOrBuilder> getFashionInfoFieldBuilder() {
                if (this.fashionInfoBuilder_ == null) {
                    this.fashionInfoBuilder_ = new RepeatedFieldBuilder(this.fashionInfo_, ((this.bitField1_ & 0x100000) == 1048576), getParentForChildren(), isClean());
                    this.fashionInfo_ = null;
                }
                return this.fashionInfoBuilder_;
            }
        }
    }

    public static final class LookUpPlayer extends GeneratedMessage implements LookUpPlayerOrBuilder {
        private static final LookUpPlayer defaultInstance = new LookUpPlayer(true);
        private final UnknownFieldSet unknownFields;

        private LookUpPlayer(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private LookUpPlayer(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static LookUpPlayer getDefaultInstance() {
            return defaultInstance;
        }

        public LookUpPlayer getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private LookUpPlayer(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.name_ = bs;
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.level_ = input.readInt32();
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.upLevel_ = input.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.pro_ = input.readInt32();
                            break;
                        case 40:
                            this.bitField0_ |= 0x10;
                            this.fightPower_ = input.readInt32();
                            break;
                        case 48:
                            this.bitField0_ |= 0x20;
                            this.fightPowerRank_ = input.readInt32();
                            break;
                        case 56:
                            this.bitField0_ |= 0x40;
                            this.juewei_ = input.readInt32();
                            break;
                        case 64:
                            this.bitField0_ |= 0x80;
                            this.titleId_ = input.readInt32();
                            break;
                        case 74:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x100;
                            this.guildName_ = bs;
                            break;
                        case 80:
                            this.bitField0_ |= 0x200;
                            this.guildJob_ = input.readInt32();
                            break;
                        case 90:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x400;
                            this.guildIcon_ = bs;
                            break;
                        case 98:
                            if ((mutable_bitField0_ & 0x800) != 2048) {
                                this.equipments_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x800;
                            }
                            this.equipments_.add(input.readMessage(ItemOuterClass.ItemDetail.PARSER, extensionRegistry));
                            break;
                        case 106:
                            if ((mutable_bitField0_ & 0x1000) != 4096) {
                                this.avatars_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x1000;
                            }
                            this.avatars_.add(input.readMessage(Common.Avatar.PARSER, extensionRegistry));
                            break;
                        case 114:
                            if ((mutable_bitField0_ & 0x2000) != 8192) {
                                this.attrs_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x2000;
                            }
                            this.attrs_.add(input.readMessage(Common.AttributeSimple.PARSER, extensionRegistry));
                            break;
                        case 120:
                            this.bitField0_ |= 0x800;
                            this.upOrder_ = input.readInt32();
                            break;
                        case 128:
                            this.bitField0_ |= 0x1000;
                            this.pkValue_ = input.readInt32();
                            break;
                        case 138:
                            if ((mutable_bitField0_ & 0x10000) != 65536) {
                                this.strengthPos_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x10000;
                            }
                            this.strengthPos_.add(input.readMessage(ItemOuterClass.EquipGridStrengthInfo.PARSER, extensionRegistry));
                            break;
                        case 144:
                            this.bitField0_ |= 0x2000;
                            this.exp_ = input.readInt64();
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x800) == 2048)
                    this.equipments_ = Collections.unmodifiableList(this.equipments_);
                if ((mutable_bitField0_ & 0x1000) == 4096) this.avatars_ = Collections.unmodifiableList(this.avatars_);
                if ((mutable_bitField0_ & 0x2000) == 8192) this.attrs_ = Collections.unmodifiableList(this.attrs_);
                if ((mutable_bitField0_ & 0x10000) == 65536)
                    this.strengthPos_ = Collections.unmodifiableList(this.strengthPos_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return PlayerOuterClass.internal_static_pomelo_player_LookUpPlayer_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return PlayerOuterClass.internal_static_pomelo_player_LookUpPlayer_fieldAccessorTable.ensureFieldAccessorsInitialized(LookUpPlayer.class, Builder.class);
        }

        public static Parser<LookUpPlayer> PARSER = (Parser<LookUpPlayer>) new AbstractParser<LookUpPlayer>() {
            public PlayerOuterClass.LookUpPlayer parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PlayerOuterClass.LookUpPlayer(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int NAME_FIELD_NUMBER = 1;
        private Object name_;
        public static final int LEVEL_FIELD_NUMBER = 2;
        private int level_;
        public static final int UPLEVEL_FIELD_NUMBER = 3;
        private int upLevel_;
        public static final int PRO_FIELD_NUMBER = 4;
        private int pro_;
        public static final int FIGHTPOWER_FIELD_NUMBER = 5;
        private int fightPower_;
        public static final int FIGHTPOWERRANK_FIELD_NUMBER = 6;
        private int fightPowerRank_;
        public static final int JUEWEI_FIELD_NUMBER = 7;
        private int juewei_;
        public static final int TITLEID_FIELD_NUMBER = 8;
        private int titleId_;
        public static final int GUILDNAME_FIELD_NUMBER = 9;
        private Object guildName_;
        public static final int GUILDJOB_FIELD_NUMBER = 10;
        private int guildJob_;
        public static final int GUILDICON_FIELD_NUMBER = 11;
        private Object guildIcon_;
        public static final int EQUIPMENTS_FIELD_NUMBER = 12;
        private List<ItemOuterClass.ItemDetail> equipments_;
        public static final int AVATARS_FIELD_NUMBER = 13;
        private List<Common.Avatar> avatars_;
        public static final int ATTRS_FIELD_NUMBER = 14;
        private List<Common.AttributeSimple> attrs_;
        public static final int UPORDER_FIELD_NUMBER = 15;
        private int upOrder_;
        public static final int PKVALUE_FIELD_NUMBER = 16;
        private int pkValue_;
        public static final int STRENGTHPOS_FIELD_NUMBER = 17;
        private List<ItemOuterClass.EquipGridStrengthInfo> strengthPos_;
        public static final int EXP_FIELD_NUMBER = 18;
        private long exp_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<LookUpPlayer> getParserForType() {
            return PARSER;
        }

        public boolean hasName() {
            return ((this.bitField0_ & 0x1) == 1);
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

        public boolean hasLevel() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public int getLevel() {
            return this.level_;
        }

        public boolean hasUpLevel() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getUpLevel() {
            return this.upLevel_;
        }

        public boolean hasPro() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public int getPro() {
            return this.pro_;
        }

        public boolean hasFightPower() {
            return ((this.bitField0_ & 0x10) == 16);
        }

        public int getFightPower() {
            return this.fightPower_;
        }

        public boolean hasFightPowerRank() {
            return ((this.bitField0_ & 0x20) == 32);
        }

        public int getFightPowerRank() {
            return this.fightPowerRank_;
        }

        public boolean hasJuewei() {
            return ((this.bitField0_ & 0x40) == 64);
        }

        public int getJuewei() {
            return this.juewei_;
        }

        public boolean hasTitleId() {
            return ((this.bitField0_ & 0x80) == 128);
        }

        public int getTitleId() {
            return this.titleId_;
        }

        public boolean hasGuildName() {
            return ((this.bitField0_ & 0x100) == 256);
        }

        public String getGuildName() {
            Object ref = this.guildName_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.guildName_ = s;
            return s;
        }

        public ByteString getGuildNameBytes() {
            Object ref = this.guildName_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.guildName_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasGuildJob() {
            return ((this.bitField0_ & 0x200) == 512);
        }

        public int getGuildJob() {
            return this.guildJob_;
        }

        public boolean hasGuildIcon() {
            return ((this.bitField0_ & 0x400) == 1024);
        }

        public String getGuildIcon() {
            Object ref = this.guildIcon_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.guildIcon_ = s;
            return s;
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

        public List<ItemOuterClass.ItemDetail> getEquipmentsList() {
            return this.equipments_;
        }

        public List<? extends ItemOuterClass.ItemDetailOrBuilder> getEquipmentsOrBuilderList() {
            return (List) this.equipments_;
        }

        public int getEquipmentsCount() {
            return this.equipments_.size();
        }

        public ItemOuterClass.ItemDetail getEquipments(int index) {
            return this.equipments_.get(index);
        }

        public ItemOuterClass.ItemDetailOrBuilder getEquipmentsOrBuilder(int index) {
            return (ItemOuterClass.ItemDetailOrBuilder) this.equipments_.get(index);
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

        public List<Common.AttributeSimple> getAttrsList() {
            return this.attrs_;
        }

        public List<? extends Common.AttributeSimpleOrBuilder> getAttrsOrBuilderList() {
            return (List) this.attrs_;
        }

        public int getAttrsCount() {
            return this.attrs_.size();
        }

        public Common.AttributeSimple getAttrs(int index) {
            return this.attrs_.get(index);
        }

        public Common.AttributeSimpleOrBuilder getAttrsOrBuilder(int index) {
            return (Common.AttributeSimpleOrBuilder) this.attrs_.get(index);
        }

        public boolean hasUpOrder() {
            return ((this.bitField0_ & 0x800) == 2048);
        }

        static {
            defaultInstance.initFields();
        }

        public int getUpOrder() {
            return this.upOrder_;
        }

        public boolean hasPkValue() {
            return ((this.bitField0_ & 0x1000) == 4096);
        }

        public int getPkValue() {
            return this.pkValue_;
        }

        public List<ItemOuterClass.EquipGridStrengthInfo> getStrengthPosList() {
            return this.strengthPos_;
        }

        public List<? extends ItemOuterClass.EquipGridStrengthInfoOrBuilder> getStrengthPosOrBuilderList() {
            return (List) this.strengthPos_;
        }

        public int getStrengthPosCount() {
            return this.strengthPos_.size();
        }

        public ItemOuterClass.EquipGridStrengthInfo getStrengthPos(int index) {
            return this.strengthPos_.get(index);
        }

        public ItemOuterClass.EquipGridStrengthInfoOrBuilder getStrengthPosOrBuilder(int index) {
            return (ItemOuterClass.EquipGridStrengthInfoOrBuilder) this.strengthPos_.get(index);
        }

        public boolean hasExp() {
            return ((this.bitField0_ & 0x2000) == 8192);
        }

        public long getExp() {
            return this.exp_;
        }

        private void initFields() {
            this.name_ = "";
            this.level_ = 0;
            this.upLevel_ = 0;
            this.pro_ = 0;
            this.fightPower_ = 0;
            this.fightPowerRank_ = 0;
            this.juewei_ = 0;
            this.titleId_ = 0;
            this.guildName_ = "";
            this.guildJob_ = 0;
            this.guildIcon_ = "";
            this.equipments_ = Collections.emptyList();
            this.avatars_ = Collections.emptyList();
            this.attrs_ = Collections.emptyList();
            this.upOrder_ = 0;
            this.pkValue_ = 0;
            this.strengthPos_ = Collections.emptyList();
            this.exp_ = 0L;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            int i;
            for (i = 0; i < getEquipmentsCount(); i++) {
                if (!getEquipments(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (i = 0; i < getAvatarsCount(); i++) {
                if (!getAvatars(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (i = 0; i < getAttrsCount(); i++) {
                if (!getAttrs(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (i = 0; i < getStrengthPosCount(); i++) {
                if (!getStrengthPos(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeBytes(1, getNameBytes());
            if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.level_);
            if ((this.bitField0_ & 0x4) == 4) output.writeInt32(3, this.upLevel_);
            if ((this.bitField0_ & 0x8) == 8) output.writeInt32(4, this.pro_);
            if ((this.bitField0_ & 0x10) == 16) output.writeInt32(5, this.fightPower_);
            if ((this.bitField0_ & 0x20) == 32) output.writeInt32(6, this.fightPowerRank_);
            if ((this.bitField0_ & 0x40) == 64) output.writeInt32(7, this.juewei_);
            if ((this.bitField0_ & 0x80) == 128) output.writeInt32(8, this.titleId_);
            if ((this.bitField0_ & 0x100) == 256) output.writeBytes(9, getGuildNameBytes());
            if ((this.bitField0_ & 0x200) == 512) output.writeInt32(10, this.guildJob_);
            if ((this.bitField0_ & 0x400) == 1024) output.writeBytes(11, getGuildIconBytes());
            int i;
            for (i = 0; i < this.equipments_.size(); i++)
                output.writeMessage(12, (MessageLite) this.equipments_.get(i));
            for (i = 0; i < this.avatars_.size(); i++) output.writeMessage(13, (MessageLite) this.avatars_.get(i));
            for (i = 0; i < this.attrs_.size(); i++) output.writeMessage(14, (MessageLite) this.attrs_.get(i));
            if ((this.bitField0_ & 0x800) == 2048) output.writeInt32(15, this.upOrder_);
            if ((this.bitField0_ & 0x1000) == 4096) output.writeInt32(16, this.pkValue_);
            for (i = 0; i < this.strengthPos_.size(); i++)
                output.writeMessage(17, (MessageLite) this.strengthPos_.get(i));
            if ((this.bitField0_ & 0x2000) == 8192) output.writeInt64(18, this.exp_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeBytesSize(1, getNameBytes());
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(2, this.level_);
            if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeInt32Size(3, this.upLevel_);
            if ((this.bitField0_ & 0x8) == 8) size += CodedOutputStream.computeInt32Size(4, this.pro_);
            if ((this.bitField0_ & 0x10) == 16) size += CodedOutputStream.computeInt32Size(5, this.fightPower_);
            if ((this.bitField0_ & 0x20) == 32) size += CodedOutputStream.computeInt32Size(6, this.fightPowerRank_);
            if ((this.bitField0_ & 0x40) == 64) size += CodedOutputStream.computeInt32Size(7, this.juewei_);
            if ((this.bitField0_ & 0x80) == 128) size += CodedOutputStream.computeInt32Size(8, this.titleId_);
            if ((this.bitField0_ & 0x100) == 256) size += CodedOutputStream.computeBytesSize(9, getGuildNameBytes());
            if ((this.bitField0_ & 0x200) == 512) size += CodedOutputStream.computeInt32Size(10, this.guildJob_);
            if ((this.bitField0_ & 0x400) == 1024) size += CodedOutputStream.computeBytesSize(11, getGuildIconBytes());
            int i;
            for (i = 0; i < this.equipments_.size(); i++)
                size += CodedOutputStream.computeMessageSize(12, (MessageLite) this.equipments_.get(i));
            for (i = 0; i < this.avatars_.size(); i++)
                size += CodedOutputStream.computeMessageSize(13, (MessageLite) this.avatars_.get(i));
            for (i = 0; i < this.attrs_.size(); i++)
                size += CodedOutputStream.computeMessageSize(14, (MessageLite) this.attrs_.get(i));
            if ((this.bitField0_ & 0x800) == 2048) size += CodedOutputStream.computeInt32Size(15, this.upOrder_);
            if ((this.bitField0_ & 0x1000) == 4096) size += CodedOutputStream.computeInt32Size(16, this.pkValue_);
            for (i = 0; i < this.strengthPos_.size(); i++)
                size += CodedOutputStream.computeMessageSize(17, (MessageLite) this.strengthPos_.get(i));
            if ((this.bitField0_ & 0x2000) == 8192) size += CodedOutputStream.computeInt64Size(18, this.exp_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static LookUpPlayer parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (LookUpPlayer) PARSER.parseFrom(data);
        }

        public static LookUpPlayer parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (LookUpPlayer) PARSER.parseFrom(data, extensionRegistry);
        }

        public static LookUpPlayer parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (LookUpPlayer) PARSER.parseFrom(data);
        }

        public static LookUpPlayer parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (LookUpPlayer) PARSER.parseFrom(data, extensionRegistry);
        }

        public static LookUpPlayer parseFrom(InputStream input) throws IOException {
            return (LookUpPlayer) PARSER.parseFrom(input);
        }

        public static LookUpPlayer parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LookUpPlayer) PARSER.parseFrom(input, extensionRegistry);
        }

        public static LookUpPlayer parseDelimitedFrom(InputStream input) throws IOException {
            return (LookUpPlayer) PARSER.parseDelimitedFrom(input);
        }

        public static LookUpPlayer parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LookUpPlayer) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static LookUpPlayer parseFrom(CodedInputStream input) throws IOException {
            return (LookUpPlayer) PARSER.parseFrom(input);
        }

        public static LookUpPlayer parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LookUpPlayer) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(LookUpPlayer prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements PlayerOuterClass.LookUpPlayerOrBuilder {
            private int bitField0_;
            private Object name_;
            private int level_;
            private int upLevel_;
            private int pro_;
            private int fightPower_;
            private int fightPowerRank_;
            private int juewei_;
            private int titleId_;
            private Object guildName_;
            private int guildJob_;
            private Object guildIcon_;
            private List<ItemOuterClass.ItemDetail> equipments_;
            private RepeatedFieldBuilder<ItemOuterClass.ItemDetail, ItemOuterClass.ItemDetail.Builder, ItemOuterClass.ItemDetailOrBuilder> equipmentsBuilder_;
            private List<Common.Avatar> avatars_;
            private RepeatedFieldBuilder<Common.Avatar, Common.Avatar.Builder, Common.AvatarOrBuilder> avatarsBuilder_;
            private List<Common.AttributeSimple> attrs_;
            private RepeatedFieldBuilder<Common.AttributeSimple, Common.AttributeSimple.Builder, Common.AttributeSimpleOrBuilder> attrsBuilder_;
            private int upOrder_;
            private int pkValue_;
            private List<ItemOuterClass.EquipGridStrengthInfo> strengthPos_;
            private RepeatedFieldBuilder<ItemOuterClass.EquipGridStrengthInfo, ItemOuterClass.EquipGridStrengthInfo.Builder, ItemOuterClass.EquipGridStrengthInfoOrBuilder> strengthPosBuilder_;
            private long exp_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PlayerOuterClass.internal_static_pomelo_player_LookUpPlayer_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PlayerOuterClass.internal_static_pomelo_player_LookUpPlayer_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerOuterClass.LookUpPlayer.class, Builder.class);
            }

            private Builder() {
                this.name_ = "";
                this.guildName_ = "";
                this.guildIcon_ = "";
                this.equipments_ = Collections.emptyList();
                this.avatars_ = Collections.emptyList();
                this.attrs_ = Collections.emptyList();
                this.strengthPos_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.name_ = "";
                this.guildName_ = "";
                this.guildIcon_ = "";
                this.equipments_ = Collections.emptyList();
                this.avatars_ = Collections.emptyList();
                this.attrs_ = Collections.emptyList();
                this.strengthPos_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PlayerOuterClass.LookUpPlayer.alwaysUseFieldBuilders) {
                    getEquipmentsFieldBuilder();
                    getAvatarsFieldBuilder();
                    getAttrsFieldBuilder();
                    getStrengthPosFieldBuilder();
                }
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.name_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                this.level_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                this.upLevel_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.pro_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                this.fightPower_ = 0;
                this.bitField0_ &= 0xFFFFFFEF;
                this.fightPowerRank_ = 0;
                this.bitField0_ &= 0xFFFFFFDF;
                this.juewei_ = 0;
                this.bitField0_ &= 0xFFFFFFBF;
                this.titleId_ = 0;
                this.bitField0_ &= 0xFFFFFF7F;
                this.guildName_ = "";
                this.bitField0_ &= 0xFFFFFEFF;
                this.guildJob_ = 0;
                this.bitField0_ &= 0xFFFFFDFF;
                this.guildIcon_ = "";
                this.bitField0_ &= 0xFFFFFBFF;
                if (this.equipmentsBuilder_ == null) {
                    this.equipments_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFF7FF;
                } else {
                    this.equipmentsBuilder_.clear();
                }
                if (this.avatarsBuilder_ == null) {
                    this.avatars_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFEFFF;
                } else {
                    this.avatarsBuilder_.clear();
                }
                if (this.attrsBuilder_ == null) {
                    this.attrs_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFDFFF;
                } else {
                    this.attrsBuilder_.clear();
                }
                this.upOrder_ = 0;
                this.bitField0_ &= 0xFFFFBFFF;
                this.pkValue_ = 0;
                this.bitField0_ &= 0xFFFF7FFF;
                if (this.strengthPosBuilder_ == null) {
                    this.strengthPos_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFEFFFF;
                } else {
                    this.strengthPosBuilder_.clear();
                }
                this.exp_ = 0L;
                this.bitField0_ &= 0xFFFDFFFF;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return PlayerOuterClass.internal_static_pomelo_player_LookUpPlayer_descriptor;
            }

            public PlayerOuterClass.LookUpPlayer getDefaultInstanceForType() {
                return PlayerOuterClass.LookUpPlayer.getDefaultInstance();
            }

            public PlayerOuterClass.LookUpPlayer build() {
                PlayerOuterClass.LookUpPlayer result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public PlayerOuterClass.LookUpPlayer buildPartial() {
                PlayerOuterClass.LookUpPlayer result = new PlayerOuterClass.LookUpPlayer(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.name_ = this.name_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.level_ = this.level_;
                if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;
                result.upLevel_ = this.upLevel_;
                if ((from_bitField0_ & 0x8) == 8) to_bitField0_ |= 0x8;
                result.pro_ = this.pro_;
                if ((from_bitField0_ & 0x10) == 16) to_bitField0_ |= 0x10;
                result.fightPower_ = this.fightPower_;
                if ((from_bitField0_ & 0x20) == 32) to_bitField0_ |= 0x20;
                result.fightPowerRank_ = this.fightPowerRank_;
                if ((from_bitField0_ & 0x40) == 64) to_bitField0_ |= 0x40;
                result.juewei_ = this.juewei_;
                if ((from_bitField0_ & 0x80) == 128) to_bitField0_ |= 0x80;
                result.titleId_ = this.titleId_;
                if ((from_bitField0_ & 0x100) == 256) to_bitField0_ |= 0x100;
                result.guildName_ = this.guildName_;
                if ((from_bitField0_ & 0x200) == 512) to_bitField0_ |= 0x200;
                result.guildJob_ = this.guildJob_;
                if ((from_bitField0_ & 0x400) == 1024) to_bitField0_ |= 0x400;
                result.guildIcon_ = this.guildIcon_;
                if (this.equipmentsBuilder_ == null) {
                    if ((this.bitField0_ & 0x800) == 2048) {
                        this.equipments_ = Collections.unmodifiableList(this.equipments_);
                        this.bitField0_ &= 0xFFFFF7FF;
                    }
                    result.equipments_ = this.equipments_;
                } else {
                    result.equipments_ = this.equipmentsBuilder_.build();
                }
                if (this.avatarsBuilder_ == null) {
                    if ((this.bitField0_ & 0x1000) == 4096) {
                        this.avatars_ = Collections.unmodifiableList(this.avatars_);
                        this.bitField0_ &= 0xFFFFEFFF;
                    }
                    result.avatars_ = this.avatars_;
                } else {
                    result.avatars_ = this.avatarsBuilder_.build();
                }
                if (this.attrsBuilder_ == null) {
                    if ((this.bitField0_ & 0x2000) == 8192) {
                        this.attrs_ = Collections.unmodifiableList(this.attrs_);
                        this.bitField0_ &= 0xFFFFDFFF;
                    }
                    result.attrs_ = this.attrs_;
                } else {
                    result.attrs_ = this.attrsBuilder_.build();
                }
                if ((from_bitField0_ & 0x4000) == 16384) to_bitField0_ |= 0x800;
                result.upOrder_ = this.upOrder_;
                if ((from_bitField0_ & 0x8000) == 32768) to_bitField0_ |= 0x1000;
                result.pkValue_ = this.pkValue_;
                if (this.strengthPosBuilder_ == null) {
                    if ((this.bitField0_ & 0x10000) == 65536) {
                        this.strengthPos_ = Collections.unmodifiableList(this.strengthPos_);
                        this.bitField0_ &= 0xFFFEFFFF;
                    }
                    result.strengthPos_ = this.strengthPos_;
                } else {
                    result.strengthPos_ = this.strengthPosBuilder_.build();
                }
                if ((from_bitField0_ & 0x20000) == 131072) to_bitField0_ |= 0x2000;
                result.exp_ = this.exp_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof PlayerOuterClass.LookUpPlayer)
                    return mergeFrom((PlayerOuterClass.LookUpPlayer) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PlayerOuterClass.LookUpPlayer other) {
                if (other == PlayerOuterClass.LookUpPlayer.getDefaultInstance()) return this;
                if (other.hasName()) {
                    this.bitField0_ |= 0x1;
                    this.name_ = other.name_;
                    onChanged();
                }
                if (other.hasLevel()) setLevel(other.getLevel());
                if (other.hasUpLevel()) setUpLevel(other.getUpLevel());
                if (other.hasPro()) setPro(other.getPro());
                if (other.hasFightPower()) setFightPower(other.getFightPower());
                if (other.hasFightPowerRank()) setFightPowerRank(other.getFightPowerRank());
                if (other.hasJuewei()) setJuewei(other.getJuewei());
                if (other.hasTitleId()) setTitleId(other.getTitleId());
                if (other.hasGuildName()) {
                    this.bitField0_ |= 0x100;
                    this.guildName_ = other.guildName_;
                    onChanged();
                }
                if (other.hasGuildJob()) setGuildJob(other.getGuildJob());
                if (other.hasGuildIcon()) {
                    this.bitField0_ |= 0x400;
                    this.guildIcon_ = other.guildIcon_;
                    onChanged();
                }
                if (this.equipmentsBuilder_ == null) {
                    if (!other.equipments_.isEmpty()) {
                        if (this.equipments_.isEmpty()) {
                            this.equipments_ = other.equipments_;
                            this.bitField0_ &= 0xFFFFF7FF;
                        } else {
                            ensureEquipmentsIsMutable();
                            this.equipments_.addAll(other.equipments_);
                        }
                        onChanged();
                    }
                } else if (!other.equipments_.isEmpty()) {
                    if (this.equipmentsBuilder_.isEmpty()) {
                        this.equipmentsBuilder_.dispose();
                        this.equipmentsBuilder_ = null;
                        this.equipments_ = other.equipments_;
                        this.bitField0_ &= 0xFFFFF7FF;
                        this.equipmentsBuilder_ = PlayerOuterClass.LookUpPlayer.alwaysUseFieldBuilders ? getEquipmentsFieldBuilder() : null;
                    } else {
                        this.equipmentsBuilder_.addAllMessages(other.equipments_);
                    }
                }
                if (this.avatarsBuilder_ == null) {
                    if (!other.avatars_.isEmpty()) {
                        if (this.avatars_.isEmpty()) {
                            this.avatars_ = other.avatars_;
                            this.bitField0_ &= 0xFFFFEFFF;
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
                        this.bitField0_ &= 0xFFFFEFFF;
                        this.avatarsBuilder_ = PlayerOuterClass.LookUpPlayer.alwaysUseFieldBuilders ? getAvatarsFieldBuilder() : null;
                    } else {
                        this.avatarsBuilder_.addAllMessages(other.avatars_);
                    }
                }
                if (this.attrsBuilder_ == null) {
                    if (!other.attrs_.isEmpty()) {
                        if (this.attrs_.isEmpty()) {
                            this.attrs_ = other.attrs_;
                            this.bitField0_ &= 0xFFFFDFFF;
                        } else {
                            ensureAttrsIsMutable();
                            this.attrs_.addAll(other.attrs_);
                        }
                        onChanged();
                    }
                } else if (!other.attrs_.isEmpty()) {
                    if (this.attrsBuilder_.isEmpty()) {
                        this.attrsBuilder_.dispose();
                        this.attrsBuilder_ = null;
                        this.attrs_ = other.attrs_;
                        this.bitField0_ &= 0xFFFFDFFF;
                        this.attrsBuilder_ = PlayerOuterClass.LookUpPlayer.alwaysUseFieldBuilders ? getAttrsFieldBuilder() : null;
                    } else {
                        this.attrsBuilder_.addAllMessages(other.attrs_);
                    }
                }
                if (other.hasUpOrder()) setUpOrder(other.getUpOrder());
                if (other.hasPkValue()) setPkValue(other.getPkValue());
                if (this.strengthPosBuilder_ == null) {
                    if (!other.strengthPos_.isEmpty()) {
                        if (this.strengthPos_.isEmpty()) {
                            this.strengthPos_ = other.strengthPos_;
                            this.bitField0_ &= 0xFFFEFFFF;
                        } else {
                            ensureStrengthPosIsMutable();
                            this.strengthPos_.addAll(other.strengthPos_);
                        }
                        onChanged();
                    }
                } else if (!other.strengthPos_.isEmpty()) {
                    if (this.strengthPosBuilder_.isEmpty()) {
                        this.strengthPosBuilder_.dispose();
                        this.strengthPosBuilder_ = null;
                        this.strengthPos_ = other.strengthPos_;
                        this.bitField0_ &= 0xFFFEFFFF;
                        this.strengthPosBuilder_ = PlayerOuterClass.LookUpPlayer.alwaysUseFieldBuilders ? getStrengthPosFieldBuilder() : null;
                    } else {
                        this.strengthPosBuilder_.addAllMessages(other.strengthPos_);
                    }
                }
                if (other.hasExp()) setExp(other.getExp());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                int i;
                for (i = 0; i < getEquipmentsCount(); i++) {
                    if (!getEquipments(i).isInitialized()) return false;
                }
                for (i = 0; i < getAvatarsCount(); i++) {
                    if (!getAvatars(i).isInitialized()) return false;
                }
                for (i = 0; i < getAttrsCount(); i++) {
                    if (!getAttrs(i).isInitialized()) return false;
                }
                for (i = 0; i < getStrengthPosCount(); i++) {
                    if (!getStrengthPos(i).isInitialized()) return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                PlayerOuterClass.LookUpPlayer parsedMessage = null;
                try {
                    parsedMessage = (PlayerOuterClass.LookUpPlayer) PlayerOuterClass.LookUpPlayer.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (PlayerOuterClass.LookUpPlayer) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasName() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public String getName() {
                Object ref = this.name_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) this.name_ = s;
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
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.name_ = value;
                onChanged();
                return this;
            }

            public Builder clearName() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.name_ = PlayerOuterClass.LookUpPlayer.getDefaultInstance().getName();
                onChanged();
                return this;
            }

            public Builder setNameBytes(ByteString value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.name_ = value;
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

            public boolean hasUpLevel() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public int getUpLevel() {
                return this.upLevel_;
            }

            public Builder setUpLevel(int value) {
                this.bitField0_ |= 0x4;
                this.upLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearUpLevel() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.upLevel_ = 0;
                onChanged();
                return this;
            }

            public boolean hasPro() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public int getPro() {
                return this.pro_;
            }

            public Builder setPro(int value) {
                this.bitField0_ |= 0x8;
                this.pro_ = value;
                onChanged();
                return this;
            }

            public Builder clearPro() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.pro_ = 0;
                onChanged();
                return this;
            }

            public boolean hasFightPower() {
                return ((this.bitField0_ & 0x10) == 16);
            }

            public int getFightPower() {
                return this.fightPower_;
            }

            public Builder setFightPower(int value) {
                this.bitField0_ |= 0x10;
                this.fightPower_ = value;
                onChanged();
                return this;
            }

            public Builder clearFightPower() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.fightPower_ = 0;
                onChanged();
                return this;
            }

            public boolean hasFightPowerRank() {
                return ((this.bitField0_ & 0x20) == 32);
            }

            public int getFightPowerRank() {
                return this.fightPowerRank_;
            }

            public Builder setFightPowerRank(int value) {
                this.bitField0_ |= 0x20;
                this.fightPowerRank_ = value;
                onChanged();
                return this;
            }

            public Builder clearFightPowerRank() {
                this.bitField0_ &= 0xFFFFFFDF;
                this.fightPowerRank_ = 0;
                onChanged();
                return this;
            }

            public boolean hasJuewei() {
                return ((this.bitField0_ & 0x40) == 64);
            }

            public int getJuewei() {
                return this.juewei_;
            }

            public Builder setJuewei(int value) {
                this.bitField0_ |= 0x40;
                this.juewei_ = value;
                onChanged();
                return this;
            }

            public Builder clearJuewei() {
                this.bitField0_ &= 0xFFFFFFBF;
                this.juewei_ = 0;
                onChanged();
                return this;
            }

            public boolean hasTitleId() {
                return ((this.bitField0_ & 0x80) == 128);
            }

            public int getTitleId() {
                return this.titleId_;
            }

            public Builder setTitleId(int value) {
                this.bitField0_ |= 0x80;
                this.titleId_ = value;
                onChanged();
                return this;
            }

            public Builder clearTitleId() {
                this.bitField0_ &= 0xFFFFFF7F;
                this.titleId_ = 0;
                onChanged();
                return this;
            }

            public boolean hasGuildName() {
                return ((this.bitField0_ & 0x100) == 256);
            }

            public String getGuildName() {
                Object ref = this.guildName_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) this.guildName_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getGuildNameBytes() {
                Object ref = this.guildName_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.guildName_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setGuildName(String value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x100;
                this.guildName_ = value;
                onChanged();
                return this;
            }

            public Builder clearGuildName() {
                this.bitField0_ &= 0xFFFFFEFF;
                this.guildName_ = PlayerOuterClass.LookUpPlayer.getDefaultInstance().getGuildName();
                onChanged();
                return this;
            }

            public Builder setGuildNameBytes(ByteString value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x100;
                this.guildName_ = value;
                onChanged();
                return this;
            }

            public boolean hasGuildJob() {
                return ((this.bitField0_ & 0x200) == 512);
            }

            public int getGuildJob() {
                return this.guildJob_;
            }

            public Builder setGuildJob(int value) {
                this.bitField0_ |= 0x200;
                this.guildJob_ = value;
                onChanged();
                return this;
            }

            public Builder clearGuildJob() {
                this.bitField0_ &= 0xFFFFFDFF;
                this.guildJob_ = 0;
                onChanged();
                return this;
            }

            public boolean hasGuildIcon() {
                return ((this.bitField0_ & 0x400) == 1024);
            }

            public String getGuildIcon() {
                Object ref = this.guildIcon_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) this.guildIcon_ = s;
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
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x400;
                this.guildIcon_ = value;
                onChanged();
                return this;
            }

            public Builder clearGuildIcon() {
                this.bitField0_ &= 0xFFFFFBFF;
                this.guildIcon_ = PlayerOuterClass.LookUpPlayer.getDefaultInstance().getGuildIcon();
                onChanged();
                return this;
            }

            public Builder setGuildIconBytes(ByteString value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x400;
                this.guildIcon_ = value;
                onChanged();
                return this;
            }

            private void ensureEquipmentsIsMutable() {
                if ((this.bitField0_ & 0x800) != 2048) {
                    this.equipments_ = new ArrayList<>(this.equipments_);
                    this.bitField0_ |= 0x800;
                }
            }

            public List<ItemOuterClass.ItemDetail> getEquipmentsList() {
                if (this.equipmentsBuilder_ == null) return Collections.unmodifiableList(this.equipments_);
                return this.equipmentsBuilder_.getMessageList();
            }

            public int getEquipmentsCount() {
                if (this.equipmentsBuilder_ == null) return this.equipments_.size();
                return this.equipmentsBuilder_.getCount();
            }

            public ItemOuterClass.ItemDetail getEquipments(int index) {
                if (this.equipmentsBuilder_ == null) return this.equipments_.get(index);
                return (ItemOuterClass.ItemDetail) this.equipmentsBuilder_.getMessage(index);
            }

            public Builder setEquipments(int index, ItemOuterClass.ItemDetail value) {
                if (this.equipmentsBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureEquipmentsIsMutable();
                    this.equipments_.set(index, value);
                    onChanged();
                } else {
                    this.equipmentsBuilder_.setMessage(index, (GeneratedMessage) value);
                }
                return this;
            }

            public Builder setEquipments(int index, ItemOuterClass.ItemDetail.Builder builderForValue) {
                if (this.equipmentsBuilder_ == null) {
                    ensureEquipmentsIsMutable();
                    this.equipments_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.equipmentsBuilder_.setMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addEquipments(ItemOuterClass.ItemDetail value) {
                if (this.equipmentsBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureEquipmentsIsMutable();
                    this.equipments_.add(value);
                    onChanged();
                } else {
                    this.equipmentsBuilder_.addMessage((GeneratedMessage) value);
                }
                return this;
            }

            public Builder addEquipments(int index, ItemOuterClass.ItemDetail value) {
                if (this.equipmentsBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureEquipmentsIsMutable();
                    this.equipments_.add(index, value);
                    onChanged();
                } else {
                    this.equipmentsBuilder_.addMessage(index, (GeneratedMessage) value);
                }
                return this;
            }

            public Builder addEquipments(ItemOuterClass.ItemDetail.Builder builderForValue) {
                if (this.equipmentsBuilder_ == null) {
                    ensureEquipmentsIsMutable();
                    this.equipments_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.equipmentsBuilder_.addMessage((GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addEquipments(int index, ItemOuterClass.ItemDetail.Builder builderForValue) {
                if (this.equipmentsBuilder_ == null) {
                    ensureEquipmentsIsMutable();
                    this.equipments_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.equipmentsBuilder_.addMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addAllEquipments(Iterable<? extends ItemOuterClass.ItemDetail> values) {
                if (this.equipmentsBuilder_ == null) {
                    ensureEquipmentsIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.equipments_);
                    onChanged();
                } else {
                    this.equipmentsBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearEquipments() {
                if (this.equipmentsBuilder_ == null) {
                    this.equipments_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFF7FF;
                    onChanged();
                } else {
                    this.equipmentsBuilder_.clear();
                }
                return this;
            }

            public Builder removeEquipments(int index) {
                if (this.equipmentsBuilder_ == null) {
                    ensureEquipmentsIsMutable();
                    this.equipments_.remove(index);
                    onChanged();
                } else {
                    this.equipmentsBuilder_.remove(index);
                }
                return this;
            }

            public ItemOuterClass.ItemDetail.Builder getEquipmentsBuilder(int index) {
                return (ItemOuterClass.ItemDetail.Builder) getEquipmentsFieldBuilder().getBuilder(index);
            }

            public ItemOuterClass.ItemDetailOrBuilder getEquipmentsOrBuilder(int index) {
                if (this.equipmentsBuilder_ == null)
                    return (ItemOuterClass.ItemDetailOrBuilder) this.equipments_.get(index);
                return (ItemOuterClass.ItemDetailOrBuilder) this.equipmentsBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends ItemOuterClass.ItemDetailOrBuilder> getEquipmentsOrBuilderList() {
                if (this.equipmentsBuilder_ != null) return this.equipmentsBuilder_.getMessageOrBuilderList();
                return (List) Collections.unmodifiableList(this.equipments_);
            }

            public ItemOuterClass.ItemDetail.Builder addEquipmentsBuilder() {
                return (ItemOuterClass.ItemDetail.Builder) getEquipmentsFieldBuilder().addBuilder((GeneratedMessage) ItemOuterClass.ItemDetail.getDefaultInstance());
            }

            public ItemOuterClass.ItemDetail.Builder addEquipmentsBuilder(int index) {
                return (ItemOuterClass.ItemDetail.Builder) getEquipmentsFieldBuilder().addBuilder(index, (GeneratedMessage) ItemOuterClass.ItemDetail.getDefaultInstance());
            }

            public List<ItemOuterClass.ItemDetail.Builder> getEquipmentsBuilderList() {
                return getEquipmentsFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<ItemOuterClass.ItemDetail, ItemOuterClass.ItemDetail.Builder, ItemOuterClass.ItemDetailOrBuilder> getEquipmentsFieldBuilder() {
                if (this.equipmentsBuilder_ == null) {
                    this.equipmentsBuilder_ = new RepeatedFieldBuilder(this.equipments_, ((this.bitField0_ & 0x800) == 2048), getParentForChildren(), isClean());
                    this.equipments_ = null;
                }
                return this.equipmentsBuilder_;
            }

            private void ensureAvatarsIsMutable() {
                if ((this.bitField0_ & 0x1000) != 4096) {
                    this.avatars_ = new ArrayList<>(this.avatars_);
                    this.bitField0_ |= 0x1000;
                }
            }

            public List<Common.Avatar> getAvatarsList() {
                if (this.avatarsBuilder_ == null) return Collections.unmodifiableList(this.avatars_);
                return this.avatarsBuilder_.getMessageList();
            }

            public int getAvatarsCount() {
                if (this.avatarsBuilder_ == null) return this.avatars_.size();
                return this.avatarsBuilder_.getCount();
            }

            public Common.Avatar getAvatars(int index) {
                if (this.avatarsBuilder_ == null) return this.avatars_.get(index);
                return (Common.Avatar) this.avatarsBuilder_.getMessage(index);
            }

            public Builder setAvatars(int index, Common.Avatar value) {
                if (this.avatarsBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
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
                    if (value == null) throw new NullPointerException();
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
                    if (value == null) throw new NullPointerException();
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
                    this.bitField0_ &= 0xFFFFEFFF;
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
                if (this.avatarsBuilder_ == null) return (Common.AvatarOrBuilder) this.avatars_.get(index);
                return (Common.AvatarOrBuilder) this.avatarsBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends Common.AvatarOrBuilder> getAvatarsOrBuilderList() {
                if (this.avatarsBuilder_ != null) return this.avatarsBuilder_.getMessageOrBuilderList();
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
                    this.avatarsBuilder_ = new RepeatedFieldBuilder(this.avatars_, ((this.bitField0_ & 0x1000) == 4096), getParentForChildren(), isClean());
                    this.avatars_ = null;
                }
                return this.avatarsBuilder_;
            }

            private void ensureAttrsIsMutable() {
                if ((this.bitField0_ & 0x2000) != 8192) {
                    this.attrs_ = new ArrayList<>(this.attrs_);
                    this.bitField0_ |= 0x2000;
                }
            }

            public List<Common.AttributeSimple> getAttrsList() {
                if (this.attrsBuilder_ == null) return Collections.unmodifiableList(this.attrs_);
                return this.attrsBuilder_.getMessageList();
            }

            public int getAttrsCount() {
                if (this.attrsBuilder_ == null) return this.attrs_.size();
                return this.attrsBuilder_.getCount();
            }

            public Common.AttributeSimple getAttrs(int index) {
                if (this.attrsBuilder_ == null) return this.attrs_.get(index);
                return (Common.AttributeSimple) this.attrsBuilder_.getMessage(index);
            }

            public Builder setAttrs(int index, Common.AttributeSimple value) {
                if (this.attrsBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureAttrsIsMutable();
                    this.attrs_.set(index, value);
                    onChanged();
                } else {
                    this.attrsBuilder_.setMessage(index, (GeneratedMessage) value);
                }
                return this;
            }

            public Builder setAttrs(int index, Common.AttributeSimple.Builder builderForValue) {
                if (this.attrsBuilder_ == null) {
                    ensureAttrsIsMutable();
                    this.attrs_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.attrsBuilder_.setMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addAttrs(Common.AttributeSimple value) {
                if (this.attrsBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureAttrsIsMutable();
                    this.attrs_.add(value);
                    onChanged();
                } else {
                    this.attrsBuilder_.addMessage((GeneratedMessage) value);
                }
                return this;
            }

            public Builder addAttrs(int index, Common.AttributeSimple value) {
                if (this.attrsBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureAttrsIsMutable();
                    this.attrs_.add(index, value);
                    onChanged();
                } else {
                    this.attrsBuilder_.addMessage(index, (GeneratedMessage) value);
                }
                return this;
            }

            public Builder addAttrs(Common.AttributeSimple.Builder builderForValue) {
                if (this.attrsBuilder_ == null) {
                    ensureAttrsIsMutable();
                    this.attrs_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.attrsBuilder_.addMessage((GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addAttrs(int index, Common.AttributeSimple.Builder builderForValue) {
                if (this.attrsBuilder_ == null) {
                    ensureAttrsIsMutable();
                    this.attrs_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.attrsBuilder_.addMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addAllAttrs(Iterable<? extends Common.AttributeSimple> values) {
                if (this.attrsBuilder_ == null) {
                    ensureAttrsIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.attrs_);
                    onChanged();
                } else {
                    this.attrsBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearAttrs() {
                if (this.attrsBuilder_ == null) {
                    this.attrs_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFDFFF;
                    onChanged();
                } else {
                    this.attrsBuilder_.clear();
                }
                return this;
            }

            public Builder removeAttrs(int index) {
                if (this.attrsBuilder_ == null) {
                    ensureAttrsIsMutable();
                    this.attrs_.remove(index);
                    onChanged();
                } else {
                    this.attrsBuilder_.remove(index);
                }
                return this;
            }

            public Common.AttributeSimple.Builder getAttrsBuilder(int index) {
                return (Common.AttributeSimple.Builder) getAttrsFieldBuilder().getBuilder(index);
            }

            public Common.AttributeSimpleOrBuilder getAttrsOrBuilder(int index) {
                if (this.attrsBuilder_ == null) return (Common.AttributeSimpleOrBuilder) this.attrs_.get(index);
                return (Common.AttributeSimpleOrBuilder) this.attrsBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends Common.AttributeSimpleOrBuilder> getAttrsOrBuilderList() {
                if (this.attrsBuilder_ != null) return this.attrsBuilder_.getMessageOrBuilderList();
                return (List) Collections.unmodifiableList(this.attrs_);
            }

            public Common.AttributeSimple.Builder addAttrsBuilder() {
                return (Common.AttributeSimple.Builder) getAttrsFieldBuilder().addBuilder((GeneratedMessage) Common.AttributeSimple.getDefaultInstance());
            }

            public Common.AttributeSimple.Builder addAttrsBuilder(int index) {
                return (Common.AttributeSimple.Builder) getAttrsFieldBuilder().addBuilder(index, (GeneratedMessage) Common.AttributeSimple.getDefaultInstance());
            }

            public List<Common.AttributeSimple.Builder> getAttrsBuilderList() {
                return getAttrsFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<Common.AttributeSimple, Common.AttributeSimple.Builder, Common.AttributeSimpleOrBuilder> getAttrsFieldBuilder() {
                if (this.attrsBuilder_ == null) {
                    this.attrsBuilder_ = new RepeatedFieldBuilder(this.attrs_, ((this.bitField0_ & 0x2000) == 8192), getParentForChildren(), isClean());
                    this.attrs_ = null;
                }
                return this.attrsBuilder_;
            }

            public boolean hasUpOrder() {
                return ((this.bitField0_ & 0x4000) == 16384);
            }

            public int getUpOrder() {
                return this.upOrder_;
            }

            public Builder setUpOrder(int value) {
                this.bitField0_ |= 0x4000;
                this.upOrder_ = value;
                onChanged();
                return this;
            }

            public Builder clearUpOrder() {
                this.bitField0_ &= 0xFFFFBFFF;
                this.upOrder_ = 0;
                onChanged();
                return this;
            }

            public boolean hasPkValue() {
                return ((this.bitField0_ & 0x8000) == 32768);
            }

            public int getPkValue() {
                return this.pkValue_;
            }

            public Builder setPkValue(int value) {
                this.bitField0_ |= 0x8000;
                this.pkValue_ = value;
                onChanged();
                return this;
            }

            public Builder clearPkValue() {
                this.bitField0_ &= 0xFFFF7FFF;
                this.pkValue_ = 0;
                onChanged();
                return this;
            }

            private void ensureStrengthPosIsMutable() {
                if ((this.bitField0_ & 0x10000) != 65536) {
                    this.strengthPos_ = new ArrayList<>(this.strengthPos_);
                    this.bitField0_ |= 0x10000;
                }
            }

            public List<ItemOuterClass.EquipGridStrengthInfo> getStrengthPosList() {
                if (this.strengthPosBuilder_ == null) return Collections.unmodifiableList(this.strengthPos_);
                return this.strengthPosBuilder_.getMessageList();
            }

            public int getStrengthPosCount() {
                if (this.strengthPosBuilder_ == null) return this.strengthPos_.size();
                return this.strengthPosBuilder_.getCount();
            }

            public ItemOuterClass.EquipGridStrengthInfo getStrengthPos(int index) {
                if (this.strengthPosBuilder_ == null) return this.strengthPos_.get(index);
                return (ItemOuterClass.EquipGridStrengthInfo) this.strengthPosBuilder_.getMessage(index);
            }

            public Builder setStrengthPos(int index, ItemOuterClass.EquipGridStrengthInfo value) {
                if (this.strengthPosBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureStrengthPosIsMutable();
                    this.strengthPos_.set(index, value);
                    onChanged();
                } else {
                    this.strengthPosBuilder_.setMessage(index, (GeneratedMessage) value);
                }
                return this;
            }

            public Builder setStrengthPos(int index, ItemOuterClass.EquipGridStrengthInfo.Builder builderForValue) {
                if (this.strengthPosBuilder_ == null) {
                    ensureStrengthPosIsMutable();
                    this.strengthPos_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.strengthPosBuilder_.setMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addStrengthPos(ItemOuterClass.EquipGridStrengthInfo value) {
                if (this.strengthPosBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureStrengthPosIsMutable();
                    this.strengthPos_.add(value);
                    onChanged();
                } else {
                    this.strengthPosBuilder_.addMessage((GeneratedMessage) value);
                }
                return this;
            }

            public Builder addStrengthPos(int index, ItemOuterClass.EquipGridStrengthInfo value) {
                if (this.strengthPosBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureStrengthPosIsMutable();
                    this.strengthPos_.add(index, value);
                    onChanged();
                } else {
                    this.strengthPosBuilder_.addMessage(index, (GeneratedMessage) value);
                }
                return this;
            }

            public Builder addStrengthPos(ItemOuterClass.EquipGridStrengthInfo.Builder builderForValue) {
                if (this.strengthPosBuilder_ == null) {
                    ensureStrengthPosIsMutable();
                    this.strengthPos_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.strengthPosBuilder_.addMessage((GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addStrengthPos(int index, ItemOuterClass.EquipGridStrengthInfo.Builder builderForValue) {
                if (this.strengthPosBuilder_ == null) {
                    ensureStrengthPosIsMutable();
                    this.strengthPos_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.strengthPosBuilder_.addMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addAllStrengthPos(Iterable<? extends ItemOuterClass.EquipGridStrengthInfo> values) {
                if (this.strengthPosBuilder_ == null) {
                    ensureStrengthPosIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.strengthPos_);
                    onChanged();
                } else {
                    this.strengthPosBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearStrengthPos() {
                if (this.strengthPosBuilder_ == null) {
                    this.strengthPos_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFEFFFF;
                    onChanged();
                } else {
                    this.strengthPosBuilder_.clear();
                }
                return this;
            }

            public Builder removeStrengthPos(int index) {
                if (this.strengthPosBuilder_ == null) {
                    ensureStrengthPosIsMutable();
                    this.strengthPos_.remove(index);
                    onChanged();
                } else {
                    this.strengthPosBuilder_.remove(index);
                }
                return this;
            }

            public ItemOuterClass.EquipGridStrengthInfo.Builder getStrengthPosBuilder(int index) {
                return (ItemOuterClass.EquipGridStrengthInfo.Builder) getStrengthPosFieldBuilder().getBuilder(index);
            }

            public ItemOuterClass.EquipGridStrengthInfoOrBuilder getStrengthPosOrBuilder(int index) {
                if (this.strengthPosBuilder_ == null)
                    return (ItemOuterClass.EquipGridStrengthInfoOrBuilder) this.strengthPos_.get(index);
                return (ItemOuterClass.EquipGridStrengthInfoOrBuilder) this.strengthPosBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends ItemOuterClass.EquipGridStrengthInfoOrBuilder> getStrengthPosOrBuilderList() {
                if (this.strengthPosBuilder_ != null) return this.strengthPosBuilder_.getMessageOrBuilderList();
                return (List) Collections.unmodifiableList(this.strengthPos_);
            }

            public ItemOuterClass.EquipGridStrengthInfo.Builder addStrengthPosBuilder() {
                return (ItemOuterClass.EquipGridStrengthInfo.Builder) getStrengthPosFieldBuilder().addBuilder((GeneratedMessage) ItemOuterClass.EquipGridStrengthInfo.getDefaultInstance());
            }

            public ItemOuterClass.EquipGridStrengthInfo.Builder addStrengthPosBuilder(int index) {
                return (ItemOuterClass.EquipGridStrengthInfo.Builder) getStrengthPosFieldBuilder().addBuilder(index, (GeneratedMessage) ItemOuterClass.EquipGridStrengthInfo.getDefaultInstance());
            }

            public List<ItemOuterClass.EquipGridStrengthInfo.Builder> getStrengthPosBuilderList() {
                return getStrengthPosFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<ItemOuterClass.EquipGridStrengthInfo, ItemOuterClass.EquipGridStrengthInfo.Builder, ItemOuterClass.EquipGridStrengthInfoOrBuilder> getStrengthPosFieldBuilder() {
                if (this.strengthPosBuilder_ == null) {
                    this.strengthPosBuilder_ = new RepeatedFieldBuilder(this.strengthPos_, ((this.bitField0_ & 0x10000) == 65536), getParentForChildren(), isClean());
                    this.strengthPos_ = null;
                }
                return this.strengthPosBuilder_;
            }

            public boolean hasExp() {
                return ((this.bitField0_ & 0x20000) == 131072);
            }

            public long getExp() {
                return this.exp_;
            }

            public Builder setExp(long value) {
                this.bitField0_ |= 0x20000;
                this.exp_ = value;
                onChanged();
                return this;
            }

            public Builder clearExp() {
                this.bitField0_ &= 0xFFFDFFFF;
                this.exp_ = 0L;
                onChanged();
                return this;
            }
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }


    static {
        String[] descriptorData = {"\n\fplayer.proto\022\rpomelo.player\032\fcommon.proto\032\ntask.proto\032\nitem.proto\"u\n\013PlayerBasic\022\n\n\002id\030\001 \002(\t\022\f\n\004name\030\002 \001(\t\022\r\n\005level\030\003 \001(\005\022\013\n\003pro\030\004 \001(\005\022\017\n\007upLevel\030\005 \001(\005\022\037\n\007avatars\030\006 \003(\0132\016.pomelo.Avatar\"z\n\005Store\022#\n\bbagGrids\030\001 \003(\0132\021.pomelo.item.Grid\022\024\n\fbagGridCount\030\002 \001(\005\022\025\n\rbagTotalCount\030\003 \001(\005\022\f\n\004type\030\004 \001(\005\022\021\n\tgridPrice\030\005 \001(\005\"{\n\006Stores\022!\n\003bag\030\001 \001(\0132\024.pomelo.player.Store\022'\n\twareHouse\030\002 \001(\0132\024.pomelo.player.Store\022%\n\007", "recycle\030\003 \001(\0132\024.pomelo.player.Store\"/\n\nEquipments\022!\n\006equips\030\001 \003(\0132\021.pomelo.item.Grid\"/\n\017OfflineBaseData\022\f\n\004flag\030\001 \002(\005\022\016\n\006areaId\030\002 \002(\005\"L\n\nAttachment\022\022\n\ntemplateId\030\001 \002(\005\022\f\n\004icon\030\002 \002(\005\022\013\n\003num\030\003 \002(\005\022\017\n\007quality\030\004 \002(\005\"Ü\001\n\004Mail\022\n\n\002id\030\001 \002(\005\022\f\n\004type\030\002 \002(\005\022\020\n\bfromType\030\003 \002(\005\022\020\n\bfromIcon\030\004 \002(\005\022\020\n\bfromName\030\005 \002(\t\022\r\n\005title\030\006 \002(\t\022\017\n\007content\030\007 \002(\t\022\022\n\ncreateDate\030\b \002(\t\022\016\n\006status\030\t \002(\005\022-\n\nattachment\030\n \003(\0132\031.pomelo.pl", "ayer.Attachment\022\021\n\ttimeStamp\030\013 \002(\t\"k\n\007SetData\022\023\n\013recvMailSet\030\001 \002(\005\022\025\n\rteamInviteSet\030\002 \002(\005\022\032\n\022recvStrangerMsgSet\030\003 \002(\005\022\030\n\020recvAddFriendSet\030\004 \002(\005\"×\001\n\013HookSetData\022\021\n\thpPercent\030\001 \002(\005\022\021\n\tmpPercent\030\002 \002(\005\022\022\n\nhpItemCode\030\003 \002(\t\022\022\n\nmpItemCode\030\004 \002(\t\022\r\n\005pkSet\030\005 \002(\005\022\022\n\nmeltQcolor\030\006 \003(\005\022\025\n\rautoBuyHpItem\030\007 \001(\005\022\025\n\rautoBuyMpItem\030\b \001(\005\022\024\n\ffieldMaphook\030\t \002(\005\022\023\n\013areaMaphook\030\n \002(\005\"D\n\fFunctionInfo\022\020\n\bfuncName\030\001 \001(\t\022\020\n\bo", "penFlag\030\002 \001(\005\022\020\n\bplayFlag\030\003 \001(\005\"ì\t\n\006Player\022\n\n\002id\030\001 \002(\t\022\013\n\003uid\030\002 \001(\t\022\f\n\004name\030\003 \001(\t\022\r\n\005level\030\004 \001(\005\022\013\n\003exp\030\005 \001(\003\022\013\n\003pro\030\006 \001(\005\022\n\n\002sp\030\007 \001(\005\022\017\n\007upOrder\030\b \001(\005\022\020\n\bclassExp\030\t \001(\005\022\f\n\004gold\030\r \001(\003\022\017\n\007diamond\030\016 \001(\003\022\016\n\006energy\030\017 \001(\005\022\013\n\003vip\030\020 \001(\005\022\016\n\006areaId\030\021 \001(\005\022\n\n\002hp\030\022 \001(\005\022\n\n\002mp\030\023 \001(\005\022\017\n\007needExp\030\024 \001(\005\022\022\n\nfightPower\030\025 \001(\005\022$\n\005store\030\026 \001(\0132\025.pomelo.player.Stores\022-\n\nequipments\030\027 \001(\0132\031.pomelo.player.Equipments\022!\n\005tasks", "\030\030 \001(\0132\022.pomelo.task.Tasks\0227\n\017offlineBaseData\030\031 \001(\0132\036.pomelo.player.OfflineBaseData\022'\n\007setData\030\033 \001(\0132\026.pomelo.player.SetData\022\020\n\bprestige\030\035 \001(\005\022\016\n\006juewei\030\036 \001(\005\022)\n\tskillKeys\030\037 \003(\0132\026.pomelo.SkillKeyStruct\022+\n\ncountItems\030  \001(\0132\027.pomelo.item.CountItems\022\016\n\006ticket\030! \001(\003\022\020\n\bfriendly\030\" \001(\005\022\017\n\007upLevel\030# \001(\005\022\020\n\breqLevel\030$ \001(\005\022\017\n\007pkModel\030% \001(\005\022\017\n\007pkValue\030& \001(\005\022/\n\013hookSetData\030' \001(\0132\032.pomelo.player.HookSetData\022\016", "\n\006zoneId\030* \001(\t\022\021\n\tsolopoint\030+ \001(\005\022\024\n\fconsumePoint\030, \001(\005\022\020\n\bpawnGold\030- \001(\005\022\022\n\npetPkModel\030. \001(\005\022\022\n\nguildpoint\030/ \001(\005\0221\n\ffunctionList\0300 \003(\0132\033.pomelo.player.FunctionInfo\022,\n\fclientConfig\0301 \003(\0132\026.pomelo.KeyValueStruct\022\025\n\rfightingPetId\0302 \001(\t\022\r\n\005mapId\0303 \001(\005\022\022\n\ninstanceId\0304 \001(\t\022\025\n\rtreasurePoint\0305 \001(\005\022\023\n\013payGiftData\0307 \001(\005\022\021\n\tblackList\0308 \003(\t\0227\n\013strengthPos\0309 \003(\0132\".pomelo.item.EquipGridStrengthInfo\022\017\n\007guildId\030", ": \001(\t\022\020\n\bguildPro\030; \001(\005\022\021\n\topenMount\030< \001(\005\0222\n\013fashionInfo\030= \003(\0132\035.pomelo.item.EquipFashionInfo\"¬\003\n\fLookUpPlayer\022\f\n\004name\030\001 \001(\t\022\r\n\005level\030\002 \001(\005\022\017\n\007upLevel\030\003 \001(\005\022\013\n\003pro\030\004 \001(\005\022\022\n\nfightPower\030\005 \001(\005\022\026\n\016fightPowerRank\030\006 \001(\005\022\016\n\006juewei\030\007 \001(\005\022\017\n\007titleId\030\b \001(\005\022\021\n\tguildName\030\t \001(\t\022\020\n\bguildJob\030\n \001(\005\022\021\n\tguildIcon\030\013 \001(\t\022+\n\nequipments\030\f \003(\0132\027.pomelo.item.ItemDetail\022\037\n\007avatars\030\r \003(\0132\016.pomelo.Avatar\022&\n\005attrs\030\016 \003(\0132\027.p", "omelo.AttributeSimple\022\017\n\007upOrder\030\017 \001(\005\022\017\n\007pkValue\030\020 \001(\005\0227\n\013strengthPos\030\021 \003(\0132\".pomelo.item.EquipGridStrengthInfo\022\013\n\003exp\030\022 \001(\003"};


        Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root) {
                PlayerOuterClass.descriptor = root;
                return null;
            }
        };

        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[]{

                Common.getDescriptor(),
                TaskOuterClass.getDescriptor(),
                ItemOuterClass.getDescriptor()}, assigner);
    }

    private static final Descriptors.Descriptor internal_static_pomelo_player_PlayerBasic_descriptor = getDescriptor().getMessageTypes().get(0);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_player_PlayerBasic_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_player_PlayerBasic_descriptor, new String[]{"Id", "Name", "Level", "Pro", "UpLevel", "Avatars"});


    private static final Descriptors.Descriptor internal_static_pomelo_player_Store_descriptor = getDescriptor().getMessageTypes().get(1);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_player_Store_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_player_Store_descriptor, new String[]{"BagGrids", "BagGridCount", "BagTotalCount", "Type", "GridPrice"});


    private static final Descriptors.Descriptor internal_static_pomelo_player_Stores_descriptor = getDescriptor().getMessageTypes().get(2);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_player_Stores_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_player_Stores_descriptor, new String[]{"Bag", "WareHouse", "Recycle"});


    private static final Descriptors.Descriptor internal_static_pomelo_player_Equipments_descriptor = getDescriptor().getMessageTypes().get(3);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_player_Equipments_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_player_Equipments_descriptor, new String[]{"Equips"});


    private static final Descriptors.Descriptor internal_static_pomelo_player_OfflineBaseData_descriptor = getDescriptor().getMessageTypes().get(4);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_player_OfflineBaseData_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_player_OfflineBaseData_descriptor, new String[]{"Flag", "AreaId"});


    private static final Descriptors.Descriptor internal_static_pomelo_player_Attachment_descriptor = getDescriptor().getMessageTypes().get(5);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_player_Attachment_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_player_Attachment_descriptor, new String[]{"TemplateId", "Icon", "Num", "Quality"});


    private static final Descriptors.Descriptor internal_static_pomelo_player_Mail_descriptor = getDescriptor().getMessageTypes().get(6);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_player_Mail_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_player_Mail_descriptor, new String[]{"Id", "Type", "FromType", "FromIcon", "FromName", "Title", "Content", "CreateDate", "Status", "Attachment", "TimeStamp"});


    private static final Descriptors.Descriptor internal_static_pomelo_player_SetData_descriptor = getDescriptor().getMessageTypes().get(7);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_player_SetData_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_player_SetData_descriptor, new String[]{"RecvMailSet", "TeamInviteSet", "RecvStrangerMsgSet", "RecvAddFriendSet"});


    private static final Descriptors.Descriptor internal_static_pomelo_player_HookSetData_descriptor = getDescriptor().getMessageTypes().get(8);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_player_HookSetData_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_player_HookSetData_descriptor, new String[]{"HpPercent", "MpPercent", "HpItemCode", "MpItemCode", "PkSet", "MeltQcolor", "AutoBuyHpItem", "AutoBuyMpItem", "FieldMaphook", "AreaMaphook"});


    private static final Descriptors.Descriptor internal_static_pomelo_player_FunctionInfo_descriptor = getDescriptor().getMessageTypes().get(9);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_player_FunctionInfo_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_player_FunctionInfo_descriptor, new String[]{"FuncName", "OpenFlag", "PlayFlag"});


    private static final Descriptors.Descriptor internal_static_pomelo_player_Player_descriptor = getDescriptor().getMessageTypes().get(10);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_player_Player_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_player_Player_descriptor, new String[]{"Id", "Uid", "Name", "Level", "Exp", "Pro", "Sp", "UpOrder", "ClassExp", "Gold", "Diamond", "Energy", "Vip", "AreaId", "Hp", "Mp", "NeedExp", "FightPower", "Store", "Equipments", "Tasks", "OfflineBaseData", "SetData", "Prestige", "Juewei", "SkillKeys", "CountItems", "Ticket", "Friendly", "UpLevel", "ReqLevel", "PkModel", "PkValue", "HookSetData", "ZoneId", "Solopoint", "ConsumePoint", "PawnGold", "PetPkModel", "Guildpoint", "FunctionList", "ClientConfig", "FightingPetId", "MapId", "InstanceId", "TreasurePoint", "PayGiftData", "BlackList", "StrengthPos", "GuildId", "GuildPro", "OpenMount", "FashionInfo"});


    private static final Descriptors.Descriptor internal_static_pomelo_player_LookUpPlayer_descriptor = getDescriptor().getMessageTypes().get(11);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_player_LookUpPlayer_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_player_LookUpPlayer_descriptor, new String[]{"Name", "Level", "UpLevel", "Pro", "FightPower", "FightPowerRank", "Juewei", "TitleId", "GuildName", "GuildJob", "GuildIcon", "Equipments", "Avatars", "Attrs", "UpOrder", "PkValue", "StrengthPos", "Exp"});
    private static Descriptors.FileDescriptor descriptor;

    static {
        Common.getDescriptor();
        TaskOuterClass.getDescriptor();
        ItemOuterClass.getDescriptor();
    }

    public static interface LookUpPlayerOrBuilder extends MessageOrBuilder {
        boolean hasName();

        String getName();

        ByteString getNameBytes();

        boolean hasLevel();

        int getLevel();

        boolean hasUpLevel();

        int getUpLevel();

        boolean hasPro();

        int getPro();

        boolean hasFightPower();

        int getFightPower();

        boolean hasFightPowerRank();

        int getFightPowerRank();

        boolean hasJuewei();

        int getJuewei();

        boolean hasTitleId();

        int getTitleId();

        boolean hasGuildName();

        String getGuildName();

        ByteString getGuildNameBytes();

        boolean hasGuildJob();

        int getGuildJob();

        boolean hasGuildIcon();

        String getGuildIcon();

        ByteString getGuildIconBytes();

        List<ItemOuterClass.ItemDetail> getEquipmentsList();

        ItemOuterClass.ItemDetail getEquipments(int param1Int);

        int getEquipmentsCount();

        List<? extends ItemOuterClass.ItemDetailOrBuilder> getEquipmentsOrBuilderList();

        ItemOuterClass.ItemDetailOrBuilder getEquipmentsOrBuilder(int param1Int);

        List<Common.Avatar> getAvatarsList();

        Common.Avatar getAvatars(int param1Int);

        int getAvatarsCount();

        List<? extends Common.AvatarOrBuilder> getAvatarsOrBuilderList();

        Common.AvatarOrBuilder getAvatarsOrBuilder(int param1Int);

        List<Common.AttributeSimple> getAttrsList();

        Common.AttributeSimple getAttrs(int param1Int);

        int getAttrsCount();

        List<? extends Common.AttributeSimpleOrBuilder> getAttrsOrBuilderList();

        Common.AttributeSimpleOrBuilder getAttrsOrBuilder(int param1Int);

        boolean hasUpOrder();

        int getUpOrder();

        boolean hasPkValue();

        int getPkValue();

        List<ItemOuterClass.EquipGridStrengthInfo> getStrengthPosList();

        ItemOuterClass.EquipGridStrengthInfo getStrengthPos(int param1Int);

        int getStrengthPosCount();

        List<? extends ItemOuterClass.EquipGridStrengthInfoOrBuilder> getStrengthPosOrBuilderList();

        ItemOuterClass.EquipGridStrengthInfoOrBuilder getStrengthPosOrBuilder(int param1Int);

        boolean hasExp();

        long getExp();
    }

    public static interface PlayerOrBuilder extends MessageOrBuilder {
        boolean hasId();

        String getId();

        ByteString getIdBytes();

        boolean hasUid();

        String getUid();

        ByteString getUidBytes();

        boolean hasName();

        String getName();

        ByteString getNameBytes();

        boolean hasLevel();

        int getLevel();

        boolean hasExp();

        long getExp();

        boolean hasPro();

        int getPro();

        boolean hasSp();

        int getSp();

        boolean hasUpOrder();

        int getUpOrder();

        boolean hasClassExp();

        int getClassExp();

        boolean hasGold();

        long getGold();

        boolean hasDiamond();

        long getDiamond();

        boolean hasEnergy();

        int getEnergy();

        boolean hasVip();

        int getVip();

        boolean hasAreaId();

        int getAreaId();

        boolean hasHp();

        int getHp();

        boolean hasMp();

        int getMp();

        boolean hasNeedExp();

        int getNeedExp();

        boolean hasFightPower();

        int getFightPower();

        boolean hasStore();

        PlayerOuterClass.Stores getStore();

        PlayerOuterClass.StoresOrBuilder getStoreOrBuilder();

        boolean hasEquipments();

        PlayerOuterClass.Equipments getEquipments();

        PlayerOuterClass.EquipmentsOrBuilder getEquipmentsOrBuilder();

        boolean hasTasks();

        TaskOuterClass.Tasks getTasks();

        TaskOuterClass.TasksOrBuilder getTasksOrBuilder();

        boolean hasOfflineBaseData();

        PlayerOuterClass.OfflineBaseData getOfflineBaseData();

        PlayerOuterClass.OfflineBaseDataOrBuilder getOfflineBaseDataOrBuilder();

        boolean hasSetData();

        PlayerOuterClass.SetData getSetData();

        PlayerOuterClass.SetDataOrBuilder getSetDataOrBuilder();

        boolean hasPrestige();

        int getPrestige();

        boolean hasJuewei();

        int getJuewei();

        List<Common.SkillKeyStruct> getSkillKeysList();

        Common.SkillKeyStruct getSkillKeys(int param1Int);

        int getSkillKeysCount();

        List<? extends Common.SkillKeyStructOrBuilder> getSkillKeysOrBuilderList();

        Common.SkillKeyStructOrBuilder getSkillKeysOrBuilder(int param1Int);

        boolean hasCountItems();

        ItemOuterClass.CountItems getCountItems();

        ItemOuterClass.CountItemsOrBuilder getCountItemsOrBuilder();

        boolean hasTicket();

        long getTicket();

        boolean hasFriendly();

        int getFriendly();

        boolean hasUpLevel();

        int getUpLevel();

        boolean hasReqLevel();

        int getReqLevel();

        boolean hasPkModel();

        int getPkModel();

        boolean hasPkValue();

        int getPkValue();

        boolean hasHookSetData();

        PlayerOuterClass.HookSetData getHookSetData();

        PlayerOuterClass.HookSetDataOrBuilder getHookSetDataOrBuilder();

        boolean hasZoneId();

        String getZoneId();

        ByteString getZoneIdBytes();

        boolean hasSolopoint();

        int getSolopoint();

        boolean hasConsumePoint();

        int getConsumePoint();

        boolean hasPawnGold();

        int getPawnGold();

        boolean hasPetPkModel();

        int getPetPkModel();

        boolean hasGuildpoint();

        int getGuildpoint();

        List<PlayerOuterClass.FunctionInfo> getFunctionListList();

        PlayerOuterClass.FunctionInfo getFunctionList(int param1Int);

        int getFunctionListCount();

        List<? extends PlayerOuterClass.FunctionInfoOrBuilder> getFunctionListOrBuilderList();

        PlayerOuterClass.FunctionInfoOrBuilder getFunctionListOrBuilder(int param1Int);

        List<Common.KeyValueStruct> getClientConfigList();

        Common.KeyValueStruct getClientConfig(int param1Int);

        int getClientConfigCount();

        List<? extends Common.KeyValueStructOrBuilder> getClientConfigOrBuilderList();

        Common.KeyValueStructOrBuilder getClientConfigOrBuilder(int param1Int);

        boolean hasFightingPetId();

        String getFightingPetId();

        ByteString getFightingPetIdBytes();

        boolean hasMapId();

        int getMapId();

        boolean hasInstanceId();

        String getInstanceId();

        ByteString getInstanceIdBytes();

        boolean hasTreasurePoint();

        int getTreasurePoint();

        boolean hasPayGiftData();

        int getPayGiftData();

        ProtocolStringList getBlackListList();

        int getBlackListCount();

        String getBlackList(int param1Int);

        ByteString getBlackListBytes(int param1Int);

        List<ItemOuterClass.EquipGridStrengthInfo> getStrengthPosList();

        ItemOuterClass.EquipGridStrengthInfo getStrengthPos(int param1Int);

        int getStrengthPosCount();

        List<? extends ItemOuterClass.EquipGridStrengthInfoOrBuilder> getStrengthPosOrBuilderList();

        ItemOuterClass.EquipGridStrengthInfoOrBuilder getStrengthPosOrBuilder(int param1Int);

        boolean hasGuildId();

        String getGuildId();

        ByteString getGuildIdBytes();

        boolean hasGuildPro();

        int getGuildPro();

        boolean hasOpenMount();

        int getOpenMount();

        List<ItemOuterClass.EquipFashionInfo> getFashionInfoList();

        ItemOuterClass.EquipFashionInfo getFashionInfo(int param1Int);

        int getFashionInfoCount();

        List<? extends ItemOuterClass.EquipFashionInfoOrBuilder> getFashionInfoOrBuilderList();

        ItemOuterClass.EquipFashionInfoOrBuilder getFashionInfoOrBuilder(int param1Int);
    }

    public static interface FunctionInfoOrBuilder extends MessageOrBuilder {
        boolean hasFuncName();

        String getFuncName();

        ByteString getFuncNameBytes();

        boolean hasOpenFlag();

        int getOpenFlag();

        boolean hasPlayFlag();

        int getPlayFlag();
    }

    public static interface HookSetDataOrBuilder extends MessageOrBuilder {
        boolean hasHpPercent();

        int getHpPercent();

        boolean hasMpPercent();

        int getMpPercent();

        boolean hasHpItemCode();

        String getHpItemCode();

        ByteString getHpItemCodeBytes();

        boolean hasMpItemCode();

        String getMpItemCode();

        ByteString getMpItemCodeBytes();

        boolean hasPkSet();

        int getPkSet();

        List<Integer> getMeltQcolorList();

        int getMeltQcolorCount();

        int getMeltQcolor(int param1Int);

        boolean hasAutoBuyHpItem();

        int getAutoBuyHpItem();

        boolean hasAutoBuyMpItem();

        int getAutoBuyMpItem();

        boolean hasFieldMaphook();

        int getFieldMaphook();

        boolean hasAreaMaphook();

        int getAreaMaphook();
    }

    public static interface SetDataOrBuilder extends MessageOrBuilder {
        boolean hasRecvMailSet();

        int getRecvMailSet();

        boolean hasTeamInviteSet();

        int getTeamInviteSet();

        boolean hasRecvStrangerMsgSet();

        int getRecvStrangerMsgSet();

        boolean hasRecvAddFriendSet();

        int getRecvAddFriendSet();
    }

    public static interface MailOrBuilder extends MessageOrBuilder {
        boolean hasId();

        int getId();

        boolean hasType();

        int getType();

        boolean hasFromType();

        int getFromType();

        boolean hasFromIcon();

        int getFromIcon();

        boolean hasFromName();

        String getFromName();

        ByteString getFromNameBytes();

        boolean hasTitle();

        String getTitle();

        ByteString getTitleBytes();

        boolean hasContent();

        String getContent();

        ByteString getContentBytes();

        boolean hasCreateDate();

        String getCreateDate();

        ByteString getCreateDateBytes();

        boolean hasStatus();

        int getStatus();

        List<PlayerOuterClass.Attachment> getAttachmentList();

        PlayerOuterClass.Attachment getAttachment(int param1Int);

        int getAttachmentCount();

        List<? extends PlayerOuterClass.AttachmentOrBuilder> getAttachmentOrBuilderList();

        PlayerOuterClass.AttachmentOrBuilder getAttachmentOrBuilder(int param1Int);

        boolean hasTimeStamp();

        String getTimeStamp();

        ByteString getTimeStampBytes();
    }

    public static interface AttachmentOrBuilder extends MessageOrBuilder {
        boolean hasTemplateId();

        int getTemplateId();

        boolean hasIcon();

        int getIcon();

        boolean hasNum();

        int getNum();

        boolean hasQuality();

        int getQuality();
    }

    public static interface OfflineBaseDataOrBuilder extends MessageOrBuilder {
        boolean hasFlag();

        int getFlag();

        boolean hasAreaId();

        int getAreaId();
    }

    public static interface EquipmentsOrBuilder extends MessageOrBuilder {
        List<ItemOuterClass.Grid> getEquipsList();

        ItemOuterClass.Grid getEquips(int param1Int);

        int getEquipsCount();

        List<? extends ItemOuterClass.GridOrBuilder> getEquipsOrBuilderList();

        ItemOuterClass.GridOrBuilder getEquipsOrBuilder(int param1Int);
    }

    public static interface StoresOrBuilder extends MessageOrBuilder {
        boolean hasBag();

        PlayerOuterClass.Store getBag();

        PlayerOuterClass.StoreOrBuilder getBagOrBuilder();

        boolean hasWareHouse();

        PlayerOuterClass.Store getWareHouse();

        PlayerOuterClass.StoreOrBuilder getWareHouseOrBuilder();

        boolean hasRecycle();

        PlayerOuterClass.Store getRecycle();

        PlayerOuterClass.StoreOrBuilder getRecycleOrBuilder();
    }

    public static interface StoreOrBuilder extends MessageOrBuilder {
        List<ItemOuterClass.Grid> getBagGridsList();

        ItemOuterClass.Grid getBagGrids(int param1Int);

        int getBagGridsCount();

        List<? extends ItemOuterClass.GridOrBuilder> getBagGridsOrBuilderList();

        ItemOuterClass.GridOrBuilder getBagGridsOrBuilder(int param1Int);

        boolean hasBagGridCount();

        int getBagGridCount();

        boolean hasBagTotalCount();

        int getBagTotalCount();

        boolean hasType();

        int getType();

        boolean hasGridPrice();

        int getGridPrice();
    }

    public static interface PlayerBasicOrBuilder extends MessageOrBuilder {
        boolean hasId();

        String getId();

        ByteString getIdBytes();

        boolean hasName();

        String getName();

        ByteString getNameBytes();

        boolean hasLevel();

        int getLevel();

        boolean hasPro();

        int getPro();

        boolean hasUpLevel();

        int getUpLevel();

        List<Common.Avatar> getAvatarsList();

        Common.Avatar getAvatars(int param1Int);

        int getAvatarsCount();

        List<? extends Common.AvatarOrBuilder> getAvatarsOrBuilderList();

        Common.AvatarOrBuilder getAvatarsOrBuilder(int param1Int);
    }
}


