package pomelo.rich;

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


public final class RichHandler {
    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static final class Reward
            extends GeneratedMessage
            implements RewardOrBuilder {
        private static final Reward defaultInstance = new Reward(true);
        private final UnknownFieldSet unknownFields;

        private Reward(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Reward(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Reward getDefaultInstance() {
            return defaultInstance;
        }

        public Reward getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Reward(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.code_ = bs;
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.groupCount_ = input.readInt32();
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
            return RichHandler.internal_static_pomelo_rich_Reward_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return RichHandler.internal_static_pomelo_rich_Reward_fieldAccessorTable.ensureFieldAccessorsInitialized(Reward.class, Builder.class);
        }

        public static Parser<Reward> PARSER = (Parser<Reward>) new AbstractParser<Reward>() {
            public RichHandler.Reward parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new RichHandler.Reward(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int CODE_FIELD_NUMBER = 1;
        private Object code_;
        public static final int GROUPCOUNT_FIELD_NUMBER = 2;
        private int groupCount_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<Reward> getParserForType() {
            return PARSER;
        }

        public boolean hasCode() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public String getCode() {
            Object ref = this.code_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.code_ = s;
            return s;
        }

        public ByteString getCodeBytes() {
            Object ref = this.code_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.code_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasGroupCount() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public int getGroupCount() {
            return this.groupCount_;
        }

        private void initFields() {
            this.code_ = "";
            this.groupCount_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasCode()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasGroupCount()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeBytes(1, getCodeBytes());
            if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.groupCount_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeBytesSize(1, getCodeBytes());
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(2, this.groupCount_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static Reward parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Reward) PARSER.parseFrom(data);
        }

        public static Reward parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Reward) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Reward parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Reward) PARSER.parseFrom(data);
        }

        public static Reward parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Reward) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Reward parseFrom(InputStream input) throws IOException {
            return (Reward) PARSER.parseFrom(input);
        }

        public static Reward parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Reward) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Reward parseDelimitedFrom(InputStream input) throws IOException {
            return (Reward) PARSER.parseDelimitedFrom(input);
        }

        public static Reward parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Reward) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Reward parseFrom(CodedInputStream input) throws IOException {
            return (Reward) PARSER.parseFrom(input);
        }

        public static Reward parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Reward) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Reward prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements RichHandler.RewardOrBuilder {
            private int bitField0_;
            private Object code_;
            private int groupCount_;

            public static final Descriptors.Descriptor getDescriptor() {
                return RichHandler.internal_static_pomelo_rich_Reward_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return RichHandler.internal_static_pomelo_rich_Reward_fieldAccessorTable.ensureFieldAccessorsInitialized(RichHandler.Reward.class, Builder.class);
            }

            private Builder() {
                this.code_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.code_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (RichHandler.Reward.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.code_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                this.groupCount_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return RichHandler.internal_static_pomelo_rich_Reward_descriptor;
            }

            public RichHandler.Reward getDefaultInstanceForType() {
                return RichHandler.Reward.getDefaultInstance();
            }

            public RichHandler.Reward build() {
                RichHandler.Reward result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public RichHandler.Reward buildPartial() {
                RichHandler.Reward result = new RichHandler.Reward(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.code_ = this.code_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.groupCount_ = this.groupCount_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof RichHandler.Reward) return mergeFrom((RichHandler.Reward) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(RichHandler.Reward other) {
                if (other == RichHandler.Reward.getDefaultInstance()) return this;
                if (other.hasCode()) {
                    this.bitField0_ |= 0x1;
                    this.code_ = other.code_;
                    onChanged();
                }
                if (other.hasGroupCount()) setGroupCount(other.getGroupCount());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasCode()) return false;
                if (!hasGroupCount()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                RichHandler.Reward parsedMessage = null;
                try {
                    parsedMessage = (RichHandler.Reward) RichHandler.Reward.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (RichHandler.Reward) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasCode() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public String getCode() {
                Object ref = this.code_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) this.code_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getCodeBytes() {
                Object ref = this.code_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.code_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setCode(String value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.code_ = value;
                onChanged();
                return this;
            }

            public Builder clearCode() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.code_ = RichHandler.Reward.getDefaultInstance().getCode();
                onChanged();
                return this;
            }

            public Builder setCodeBytes(ByteString value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.code_ = value;
                onChanged();
                return this;
            }

            public boolean hasGroupCount() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getGroupCount() {
                return this.groupCount_;
            }

            public Builder setGroupCount(int value) {
                this.bitField0_ |= 0x2;
                this.groupCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearGroupCount() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.groupCount_ = 0;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class TurnReward
            extends GeneratedMessage
            implements TurnRewardOrBuilder {
        private static final TurnReward defaultInstance = new TurnReward(true);
        private final UnknownFieldSet unknownFields;

        private TurnReward(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private TurnReward(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static TurnReward getDefaultInstance() {
            return defaultInstance;
        }

        public TurnReward getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private TurnReward(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.turnId_ = input.readInt32();
                            break;
                        case 18:
                            if ((mutable_bitField0_ & 0x2) != 2) {
                                this.reward_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x2;
                            }
                            this.reward_.add(input.readMessage(RichHandler.Reward.PARSER, extensionRegistry));
                            break;
                        case 24:
                            this.bitField0_ |= 0x2;
                            this.state_ = input.readInt32();
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x2) == 2) this.reward_ = Collections.unmodifiableList(this.reward_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return RichHandler.internal_static_pomelo_rich_TurnReward_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return RichHandler.internal_static_pomelo_rich_TurnReward_fieldAccessorTable.ensureFieldAccessorsInitialized(TurnReward.class, Builder.class);
        }

        public static Parser<TurnReward> PARSER = (Parser<TurnReward>) new AbstractParser<TurnReward>() {
            public RichHandler.TurnReward parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new RichHandler.TurnReward(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int TURNID_FIELD_NUMBER = 1;
        private int turnId_;
        public static final int REWARD_FIELD_NUMBER = 2;
        private List<RichHandler.Reward> reward_;
        public static final int STATE_FIELD_NUMBER = 3;
        private int state_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<TurnReward> getParserForType() {
            return PARSER;
        }

        public boolean hasTurnId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getTurnId() {
            return this.turnId_;
        }

        public List<RichHandler.Reward> getRewardList() {
            return this.reward_;
        }

        public List<? extends RichHandler.RewardOrBuilder> getRewardOrBuilderList() {
            return (List) this.reward_;
        }

        public int getRewardCount() {
            return this.reward_.size();
        }

        public RichHandler.Reward getReward(int index) {
            return this.reward_.get(index);
        }

        public RichHandler.RewardOrBuilder getRewardOrBuilder(int index) {
            return this.reward_.get(index);
        }

        public boolean hasState() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public int getState() {
            return this.state_;
        }

        private void initFields() {
            this.turnId_ = 0;
            this.reward_ = Collections.emptyList();
            this.state_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasTurnId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasState()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (int i = 0; i < getRewardCount(); i++) {
                if (!getReward(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.turnId_);
            for (int i = 0; i < this.reward_.size(); i++) output.writeMessage(2, (MessageLite) this.reward_.get(i));
            if ((this.bitField0_ & 0x2) == 2) output.writeInt32(3, this.state_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.turnId_);
            for (int i = 0; i < this.reward_.size(); i++)
                size += CodedOutputStream.computeMessageSize(2, (MessageLite) this.reward_.get(i));
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(3, this.state_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static TurnReward parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (TurnReward) PARSER.parseFrom(data);
        }

        public static TurnReward parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (TurnReward) PARSER.parseFrom(data, extensionRegistry);
        }

        public static TurnReward parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (TurnReward) PARSER.parseFrom(data);
        }

        public static TurnReward parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (TurnReward) PARSER.parseFrom(data, extensionRegistry);
        }

        public static TurnReward parseFrom(InputStream input) throws IOException {
            return (TurnReward) PARSER.parseFrom(input);
        }

        public static TurnReward parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TurnReward) PARSER.parseFrom(input, extensionRegistry);
        }

        public static TurnReward parseDelimitedFrom(InputStream input) throws IOException {
            return (TurnReward) PARSER.parseDelimitedFrom(input);
        }

        public static TurnReward parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TurnReward) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static TurnReward parseFrom(CodedInputStream input) throws IOException {
            return (TurnReward) PARSER.parseFrom(input);
        }

        public static TurnReward parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TurnReward) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(TurnReward prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements RichHandler.TurnRewardOrBuilder {
            private int bitField0_;
            private int turnId_;
            private List<RichHandler.Reward> reward_;
            private RepeatedFieldBuilder<RichHandler.Reward, RichHandler.Reward.Builder, RichHandler.RewardOrBuilder> rewardBuilder_;
            private int state_;

            public static final Descriptors.Descriptor getDescriptor() {
                return RichHandler.internal_static_pomelo_rich_TurnReward_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return RichHandler.internal_static_pomelo_rich_TurnReward_fieldAccessorTable.ensureFieldAccessorsInitialized(RichHandler.TurnReward.class, Builder.class);
            }

            private Builder() {
                this.reward_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.reward_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (RichHandler.TurnReward.alwaysUseFieldBuilders) getRewardFieldBuilder();
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.turnId_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                if (this.rewardBuilder_ == null) {
                    this.reward_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFD;
                } else {
                    this.rewardBuilder_.clear();
                }
                this.state_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return RichHandler.internal_static_pomelo_rich_TurnReward_descriptor;
            }

            public RichHandler.TurnReward getDefaultInstanceForType() {
                return RichHandler.TurnReward.getDefaultInstance();
            }

            public RichHandler.TurnReward build() {
                RichHandler.TurnReward result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public RichHandler.TurnReward buildPartial() {
                RichHandler.TurnReward result = new RichHandler.TurnReward(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.turnId_ = this.turnId_;
                if (this.rewardBuilder_ == null) {
                    if ((this.bitField0_ & 0x2) == 2) {
                        this.reward_ = Collections.unmodifiableList(this.reward_);
                        this.bitField0_ &= 0xFFFFFFFD;
                    }
                    result.reward_ = this.reward_;
                } else {
                    result.reward_ = this.rewardBuilder_.build();
                }
                if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x2;
                result.state_ = this.state_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof RichHandler.TurnReward) return mergeFrom((RichHandler.TurnReward) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(RichHandler.TurnReward other) {
                if (other == RichHandler.TurnReward.getDefaultInstance()) return this;
                if (other.hasTurnId()) setTurnId(other.getTurnId());
                if (this.rewardBuilder_ == null) {
                    if (!other.reward_.isEmpty()) {
                        if (this.reward_.isEmpty()) {
                            this.reward_ = other.reward_;
                            this.bitField0_ &= 0xFFFFFFFD;
                        } else {
                            ensureRewardIsMutable();
                            this.reward_.addAll(other.reward_);
                        }
                        onChanged();
                    }
                } else if (!other.reward_.isEmpty()) {
                    if (this.rewardBuilder_.isEmpty()) {
                        this.rewardBuilder_.dispose();
                        this.rewardBuilder_ = null;
                        this.reward_ = other.reward_;
                        this.bitField0_ &= 0xFFFFFFFD;
                        this.rewardBuilder_ = RichHandler.TurnReward.alwaysUseFieldBuilders ? getRewardFieldBuilder() : null;
                    } else {
                        this.rewardBuilder_.addAllMessages(other.reward_);
                    }
                }
                if (other.hasState()) setState(other.getState());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasTurnId()) return false;
                if (!hasState()) return false;
                for (int i = 0; i < getRewardCount(); i++) {
                    if (!getReward(i).isInitialized()) return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                RichHandler.TurnReward parsedMessage = null;
                try {
                    parsedMessage = (RichHandler.TurnReward) RichHandler.TurnReward.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (RichHandler.TurnReward) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasTurnId() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getTurnId() {
                return this.turnId_;
            }

            public Builder setTurnId(int value) {
                this.bitField0_ |= 0x1;
                this.turnId_ = value;
                onChanged();
                return this;
            }

            public Builder clearTurnId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.turnId_ = 0;
                onChanged();
                return this;
            }

            private void ensureRewardIsMutable() {
                if ((this.bitField0_ & 0x2) != 2) {
                    this.reward_ = new ArrayList<>(this.reward_);
                    this.bitField0_ |= 0x2;
                }
            }

            public List<RichHandler.Reward> getRewardList() {
                if (this.rewardBuilder_ == null) return Collections.unmodifiableList(this.reward_);
                return this.rewardBuilder_.getMessageList();
            }

            public int getRewardCount() {
                if (this.rewardBuilder_ == null) return this.reward_.size();
                return this.rewardBuilder_.getCount();
            }

            public RichHandler.Reward getReward(int index) {
                if (this.rewardBuilder_ == null) return this.reward_.get(index);
                return (RichHandler.Reward) this.rewardBuilder_.getMessage(index);
            }

            public Builder setReward(int index, RichHandler.Reward value) {
                if (this.rewardBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureRewardIsMutable();
                    this.reward_.set(index, value);
                    onChanged();
                } else {
                    this.rewardBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setReward(int index, RichHandler.Reward.Builder builderForValue) {
                if (this.rewardBuilder_ == null) {
                    ensureRewardIsMutable();
                    this.reward_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.rewardBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addReward(RichHandler.Reward value) {
                if (this.rewardBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureRewardIsMutable();
                    this.reward_.add(value);
                    onChanged();
                } else {
                    this.rewardBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addReward(int index, RichHandler.Reward value) {
                if (this.rewardBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureRewardIsMutable();
                    this.reward_.add(index, value);
                    onChanged();
                } else {
                    this.rewardBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addReward(RichHandler.Reward.Builder builderForValue) {
                if (this.rewardBuilder_ == null) {
                    ensureRewardIsMutable();
                    this.reward_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.rewardBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addReward(int index, RichHandler.Reward.Builder builderForValue) {
                if (this.rewardBuilder_ == null) {
                    ensureRewardIsMutable();
                    this.reward_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.rewardBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllReward(Iterable<? extends RichHandler.Reward> values) {
                if (this.rewardBuilder_ == null) {
                    ensureRewardIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.reward_);
                    onChanged();
                } else {
                    this.rewardBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearReward() {
                if (this.rewardBuilder_ == null) {
                    this.reward_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFD;
                    onChanged();
                } else {
                    this.rewardBuilder_.clear();
                }
                return this;
            }

            public Builder removeReward(int index) {
                if (this.rewardBuilder_ == null) {
                    ensureRewardIsMutable();
                    this.reward_.remove(index);
                    onChanged();
                } else {
                    this.rewardBuilder_.remove(index);
                }
                return this;
            }

            public RichHandler.Reward.Builder getRewardBuilder(int index) {
                return (RichHandler.Reward.Builder) getRewardFieldBuilder().getBuilder(index);
            }

            public RichHandler.RewardOrBuilder getRewardOrBuilder(int index) {
                if (this.rewardBuilder_ == null) return this.reward_.get(index);
                return (RichHandler.RewardOrBuilder) this.rewardBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends RichHandler.RewardOrBuilder> getRewardOrBuilderList() {
                if (this.rewardBuilder_ != null) return this.rewardBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.reward_);
            }

            public RichHandler.Reward.Builder addRewardBuilder() {
                return (RichHandler.Reward.Builder) getRewardFieldBuilder().addBuilder(RichHandler.Reward.getDefaultInstance());
            }

            public RichHandler.Reward.Builder addRewardBuilder(int index) {
                return (RichHandler.Reward.Builder) getRewardFieldBuilder().addBuilder(index, RichHandler.Reward.getDefaultInstance());
            }

            public List<RichHandler.Reward.Builder> getRewardBuilderList() {
                return getRewardFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<RichHandler.Reward, RichHandler.Reward.Builder, RichHandler.RewardOrBuilder> getRewardFieldBuilder() {
                if (this.rewardBuilder_ == null) {
                    this.rewardBuilder_ = new RepeatedFieldBuilder(this.reward_, ((this.bitField0_ & 0x2) == 2), getParentForChildren(), isClean());
                    this.reward_ = null;
                }
                return this.rewardBuilder_;
            }

            public boolean hasState() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public int getState() {
                return this.state_;
            }

            public Builder setState(int value) {
                this.bitField0_ |= 0x4;
                this.state_ = value;
                onChanged();
                return this;
            }

            public Builder clearState() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.state_ = 0;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class TaskInfo
            extends GeneratedMessage
            implements TaskInfoOrBuilder {
        private static final TaskInfo defaultInstance = new TaskInfo(true);
        private final UnknownFieldSet unknownFields;

        private TaskInfo(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private TaskInfo(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static TaskInfo getDefaultInstance() {
            return defaultInstance;
        }

        public TaskInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private TaskInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.schName_ = bs;
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.finishedCount_ = input.readInt32();
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.maxCount_ = input.readInt32();
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
            return RichHandler.internal_static_pomelo_rich_TaskInfo_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return RichHandler.internal_static_pomelo_rich_TaskInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(TaskInfo.class, Builder.class);
        }

        public static Parser<TaskInfo> PARSER = (Parser<TaskInfo>) new AbstractParser<TaskInfo>() {
            public RichHandler.TaskInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new RichHandler.TaskInfo(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int SCHNAME_FIELD_NUMBER = 1;
        private Object schName_;
        public static final int FINISHEDCOUNT_FIELD_NUMBER = 2;
        private int finishedCount_;
        public static final int MAXCOUNT_FIELD_NUMBER = 3;
        private int maxCount_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<TaskInfo> getParserForType() {
            return PARSER;
        }

        public boolean hasSchName() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public String getSchName() {
            Object ref = this.schName_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.schName_ = s;
            return s;
        }

        public ByteString getSchNameBytes() {
            Object ref = this.schName_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.schName_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasFinishedCount() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public int getFinishedCount() {
            return this.finishedCount_;
        }

        public boolean hasMaxCount() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getMaxCount() {
            return this.maxCount_;
        }

        private void initFields() {
            this.schName_ = "";
            this.finishedCount_ = 0;
            this.maxCount_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasSchName()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasFinishedCount()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasMaxCount()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeBytes(1, getSchNameBytes());
            if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.finishedCount_);
            if ((this.bitField0_ & 0x4) == 4) output.writeInt32(3, this.maxCount_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeBytesSize(1, getSchNameBytes());
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(2, this.finishedCount_);
            if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeInt32Size(3, this.maxCount_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static TaskInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (TaskInfo) PARSER.parseFrom(data);
        }

        public static TaskInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (TaskInfo) PARSER.parseFrom(data, extensionRegistry);
        }

        public static TaskInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (TaskInfo) PARSER.parseFrom(data);
        }

        public static TaskInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (TaskInfo) PARSER.parseFrom(data, extensionRegistry);
        }

        public static TaskInfo parseFrom(InputStream input) throws IOException {
            return (TaskInfo) PARSER.parseFrom(input);
        }

        public static TaskInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TaskInfo) PARSER.parseFrom(input, extensionRegistry);
        }

        public static TaskInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (TaskInfo) PARSER.parseDelimitedFrom(input);
        }

        public static TaskInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TaskInfo) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static TaskInfo parseFrom(CodedInputStream input) throws IOException {
            return (TaskInfo) PARSER.parseFrom(input);
        }

        public static TaskInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TaskInfo) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(TaskInfo prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements RichHandler.TaskInfoOrBuilder {
            private int bitField0_;
            private Object schName_;
            private int finishedCount_;
            private int maxCount_;

            public static final Descriptors.Descriptor getDescriptor() {
                return RichHandler.internal_static_pomelo_rich_TaskInfo_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return RichHandler.internal_static_pomelo_rich_TaskInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(RichHandler.TaskInfo.class, Builder.class);
            }

            private Builder() {
                this.schName_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.schName_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (RichHandler.TaskInfo.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.schName_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                this.finishedCount_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                this.maxCount_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return RichHandler.internal_static_pomelo_rich_TaskInfo_descriptor;
            }

            public RichHandler.TaskInfo getDefaultInstanceForType() {
                return RichHandler.TaskInfo.getDefaultInstance();
            }

            public RichHandler.TaskInfo build() {
                RichHandler.TaskInfo result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public RichHandler.TaskInfo buildPartial() {
                RichHandler.TaskInfo result = new RichHandler.TaskInfo(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.schName_ = this.schName_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.finishedCount_ = this.finishedCount_;
                if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;
                result.maxCount_ = this.maxCount_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof RichHandler.TaskInfo) return mergeFrom((RichHandler.TaskInfo) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(RichHandler.TaskInfo other) {
                if (other == RichHandler.TaskInfo.getDefaultInstance()) return this;
                if (other.hasSchName()) {
                    this.bitField0_ |= 0x1;
                    this.schName_ = other.schName_;
                    onChanged();
                }
                if (other.hasFinishedCount()) setFinishedCount(other.getFinishedCount());
                if (other.hasMaxCount()) setMaxCount(other.getMaxCount());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasSchName()) return false;
                if (!hasFinishedCount()) return false;
                if (!hasMaxCount()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                RichHandler.TaskInfo parsedMessage = null;
                try {
                    parsedMessage = (RichHandler.TaskInfo) RichHandler.TaskInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (RichHandler.TaskInfo) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasSchName() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public String getSchName() {
                Object ref = this.schName_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) this.schName_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getSchNameBytes() {
                Object ref = this.schName_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.schName_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setSchName(String value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.schName_ = value;
                onChanged();
                return this;
            }

            public Builder clearSchName() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.schName_ = RichHandler.TaskInfo.getDefaultInstance().getSchName();
                onChanged();
                return this;
            }

            public Builder setSchNameBytes(ByteString value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.schName_ = value;
                onChanged();
                return this;
            }

            public boolean hasFinishedCount() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getFinishedCount() {
                return this.finishedCount_;
            }

            public Builder setFinishedCount(int value) {
                this.bitField0_ |= 0x2;
                this.finishedCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearFinishedCount() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.finishedCount_ = 0;
                onChanged();
                return this;
            }

            public boolean hasMaxCount() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public int getMaxCount() {
                return this.maxCount_;
            }

            public Builder setMaxCount(int value) {
                this.bitField0_ |= 0x4;
                this.maxCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearMaxCount() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.maxCount_ = 0;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class GetRichInfoRequest
            extends GeneratedMessage
            implements GetRichInfoRequestOrBuilder {
        private static final GetRichInfoRequest defaultInstance = new GetRichInfoRequest(true);
        private final UnknownFieldSet unknownFields;

        private GetRichInfoRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetRichInfoRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetRichInfoRequest getDefaultInstance() {
            return defaultInstance;
        }

        public GetRichInfoRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetRichInfoRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return RichHandler.internal_static_pomelo_rich_GetRichInfoRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return RichHandler.internal_static_pomelo_rich_GetRichInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetRichInfoRequest.class, Builder.class);
        }

        public static Parser<GetRichInfoRequest> PARSER = (Parser<GetRichInfoRequest>) new AbstractParser<GetRichInfoRequest>() {
            public RichHandler.GetRichInfoRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new RichHandler.GetRichInfoRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetRichInfoRequest> getParserForType() {
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

        public static GetRichInfoRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetRichInfoRequest) PARSER.parseFrom(data);
        }

        public static GetRichInfoRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetRichInfoRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetRichInfoRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetRichInfoRequest) PARSER.parseFrom(data);
        }

        public static GetRichInfoRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetRichInfoRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetRichInfoRequest parseFrom(InputStream input) throws IOException {
            return (GetRichInfoRequest) PARSER.parseFrom(input);
        }

        public static GetRichInfoRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetRichInfoRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static GetRichInfoRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (GetRichInfoRequest) PARSER.parseDelimitedFrom(input);
        }

        public static GetRichInfoRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetRichInfoRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static GetRichInfoRequest parseFrom(CodedInputStream input) throws IOException {
            return (GetRichInfoRequest) PARSER.parseFrom(input);
        }

        public static GetRichInfoRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetRichInfoRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(GetRichInfoRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements RichHandler.GetRichInfoRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return RichHandler.internal_static_pomelo_rich_GetRichInfoRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return RichHandler.internal_static_pomelo_rich_GetRichInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(RichHandler.GetRichInfoRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (RichHandler.GetRichInfoRequest.alwaysUseFieldBuilders) ;
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
                return RichHandler.internal_static_pomelo_rich_GetRichInfoRequest_descriptor;
            }

            public RichHandler.GetRichInfoRequest getDefaultInstanceForType() {
                return RichHandler.GetRichInfoRequest.getDefaultInstance();
            }

            public RichHandler.GetRichInfoRequest build() {
                RichHandler.GetRichInfoRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public RichHandler.GetRichInfoRequest buildPartial() {
                RichHandler.GetRichInfoRequest result = new RichHandler.GetRichInfoRequest(this);
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof RichHandler.GetRichInfoRequest)
                    return mergeFrom((RichHandler.GetRichInfoRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(RichHandler.GetRichInfoRequest other) {
                if (other == RichHandler.GetRichInfoRequest.getDefaultInstance()) return this;
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                RichHandler.GetRichInfoRequest parsedMessage = null;
                try {
                    parsedMessage = (RichHandler.GetRichInfoRequest) RichHandler.GetRichInfoRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (RichHandler.GetRichInfoRequest) e.getUnfinishedMessage();
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


    public static final class GetRichInfoResponse
            extends GeneratedMessage
            implements GetRichInfoResponseOrBuilder {
        private static final GetRichInfoResponse defaultInstance = new GetRichInfoResponse(true);
        private final UnknownFieldSet unknownFields;

        private GetRichInfoResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetRichInfoResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetRichInfoResponse getDefaultInstance() {
            return defaultInstance;
        }

        public GetRichInfoResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetRichInfoResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.turnReward_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x4;
                            }
                            this.turnReward_.add(input.readMessage(RichHandler.TurnReward.PARSER, extensionRegistry));
                            break;
                        case 34:
                            if ((mutable_bitField0_ & 0x8) != 8) {
                                this.taskInfo_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x8;
                            }
                            this.taskInfo_.add(input.readMessage(RichHandler.TaskInfo.PARSER, extensionRegistry));
                            break;
                        case 40:
                            this.bitField0_ |= 0x4;
                            this.currentStep_ = input.readInt32();
                            break;
                        case 48:
                            this.bitField0_ |= 0x8;
                            this.freeCount_ = input.readInt32();
                            break;
                        case 58:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x10;
                            this.startTimestamp_ = bs;
                            break;
                        case 66:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x20;
                            this.endTimestamp_ = bs;
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x4) == 4) this.turnReward_ = Collections.unmodifiableList(this.turnReward_);
                if ((mutable_bitField0_ & 0x8) == 8) this.taskInfo_ = Collections.unmodifiableList(this.taskInfo_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return RichHandler.internal_static_pomelo_rich_GetRichInfoResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return RichHandler.internal_static_pomelo_rich_GetRichInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetRichInfoResponse.class, Builder.class);
        }

        public static Parser<GetRichInfoResponse> PARSER = (Parser<GetRichInfoResponse>) new AbstractParser<GetRichInfoResponse>() {
            public RichHandler.GetRichInfoResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new RichHandler.GetRichInfoResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int TURNREWARD_FIELD_NUMBER = 3;
        private List<RichHandler.TurnReward> turnReward_;
        public static final int TASKINFO_FIELD_NUMBER = 4;
        private List<RichHandler.TaskInfo> taskInfo_;
        public static final int CURRENTSTEP_FIELD_NUMBER = 5;
        private int currentStep_;
        public static final int FREECOUNT_FIELD_NUMBER = 6;
        private int freeCount_;
        public static final int STARTTIMESTAMP_FIELD_NUMBER = 7;
        private Object startTimestamp_;
        public static final int ENDTIMESTAMP_FIELD_NUMBER = 8;
        private Object endTimestamp_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetRichInfoResponse> getParserForType() {
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

        public List<RichHandler.TurnReward> getTurnRewardList() {
            return this.turnReward_;
        }

        public List<? extends RichHandler.TurnRewardOrBuilder> getTurnRewardOrBuilderList() {
            return (List) this.turnReward_;
        }

        public int getTurnRewardCount() {
            return this.turnReward_.size();
        }

        public RichHandler.TurnReward getTurnReward(int index) {
            return this.turnReward_.get(index);
        }

        public RichHandler.TurnRewardOrBuilder getTurnRewardOrBuilder(int index) {
            return this.turnReward_.get(index);
        }

        public List<RichHandler.TaskInfo> getTaskInfoList() {
            return this.taskInfo_;
        }

        public List<? extends RichHandler.TaskInfoOrBuilder> getTaskInfoOrBuilderList() {
            return (List) this.taskInfo_;
        }

        public int getTaskInfoCount() {
            return this.taskInfo_.size();
        }

        public RichHandler.TaskInfo getTaskInfo(int index) {
            return this.taskInfo_.get(index);
        }

        public RichHandler.TaskInfoOrBuilder getTaskInfoOrBuilder(int index) {
            return this.taskInfo_.get(index);
        }

        public boolean hasCurrentStep() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getCurrentStep() {
            return this.currentStep_;
        }

        public boolean hasFreeCount() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public int getFreeCount() {
            return this.freeCount_;
        }

        public boolean hasStartTimestamp() {
            return ((this.bitField0_ & 0x10) == 16);
        }

        public String getStartTimestamp() {
            Object ref = this.startTimestamp_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.startTimestamp_ = s;
            return s;
        }

        public ByteString getStartTimestampBytes() {
            Object ref = this.startTimestamp_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.startTimestamp_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasEndTimestamp() {
            return ((this.bitField0_ & 0x20) == 32);
        }

        public String getEndTimestamp() {
            Object ref = this.endTimestamp_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.endTimestamp_ = s;
            return s;
        }

        public ByteString getEndTimestampBytes() {
            Object ref = this.endTimestamp_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.endTimestamp_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.turnReward_ = Collections.emptyList();
            this.taskInfo_ = Collections.emptyList();
            this.currentStep_ = 0;
            this.freeCount_ = 0;
            this.startTimestamp_ = "";
            this.endTimestamp_ = "";
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
            for (i = 0; i < getTurnRewardCount(); i++) {
                if (!getTurnReward(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (i = 0; i < getTaskInfoCount(); i++) {
                if (!getTaskInfo(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        static {
            defaultInstance.initFields();
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1)
                output.writeInt32(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2)
                output.writeBytes(2, getS2CMsgBytes());
            int i;
            for (i = 0; i < this.turnReward_.size(); i++)
                output.writeMessage(3, (MessageLite) this.turnReward_.get(i));
            for (i = 0; i < this.taskInfo_.size(); i++)
                output.writeMessage(4, (MessageLite) this.taskInfo_.get(i));
            if ((this.bitField0_ & 0x4) == 4)
                output.writeInt32(5, this.currentStep_);
            if ((this.bitField0_ & 0x8) == 8)
                output.writeInt32(6, this.freeCount_);
            if ((this.bitField0_ & 0x10) == 16)
                output.writeBytes(7, getStartTimestampBytes());
            if ((this.bitField0_ & 0x20) == 32)
                output.writeBytes(8, getEndTimestampBytes());
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
            int i;
            for (i = 0; i < this.turnReward_.size(); i++)
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.turnReward_.get(i));
            for (i = 0; i < this.taskInfo_.size(); i++)
                size += CodedOutputStream.computeMessageSize(4, (MessageLite) this.taskInfo_.get(i));
            if ((this.bitField0_ & 0x4) == 4)
                size += CodedOutputStream.computeInt32Size(5, this.currentStep_);
            if ((this.bitField0_ & 0x8) == 8)
                size += CodedOutputStream.computeInt32Size(6, this.freeCount_);
            if ((this.bitField0_ & 0x10) == 16)
                size += CodedOutputStream.computeBytesSize(7, getStartTimestampBytes());
            if ((this.bitField0_ & 0x20) == 32)
                size += CodedOutputStream.computeBytesSize(8, getEndTimestampBytes());
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static GetRichInfoResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetRichInfoResponse) PARSER.parseFrom(data);
        }

        public static GetRichInfoResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetRichInfoResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetRichInfoResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetRichInfoResponse) PARSER.parseFrom(data);
        }

        public static GetRichInfoResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetRichInfoResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetRichInfoResponse parseFrom(InputStream input) throws IOException {
            return (GetRichInfoResponse) PARSER.parseFrom(input);
        }

        public static GetRichInfoResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetRichInfoResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static GetRichInfoResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (GetRichInfoResponse) PARSER.parseDelimitedFrom(input);
        }

        public static GetRichInfoResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetRichInfoResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static GetRichInfoResponse parseFrom(CodedInputStream input) throws IOException {
            return (GetRichInfoResponse) PARSER.parseFrom(input);
        }

        public static GetRichInfoResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetRichInfoResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(GetRichInfoResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements RichHandler.GetRichInfoResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private List<RichHandler.TurnReward> turnReward_;
            private RepeatedFieldBuilder<RichHandler.TurnReward, RichHandler.TurnReward.Builder, RichHandler.TurnRewardOrBuilder> turnRewardBuilder_;
            private List<RichHandler.TaskInfo> taskInfo_;
            private RepeatedFieldBuilder<RichHandler.TaskInfo, RichHandler.TaskInfo.Builder, RichHandler.TaskInfoOrBuilder> taskInfoBuilder_;
            private int currentStep_;
            private int freeCount_;
            private Object startTimestamp_;
            private Object endTimestamp_;

            public static final Descriptors.Descriptor getDescriptor() {
                return RichHandler.internal_static_pomelo_rich_GetRichInfoResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return RichHandler.internal_static_pomelo_rich_GetRichInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(RichHandler.GetRichInfoResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.turnReward_ = Collections.emptyList();
                this.taskInfo_ = Collections.emptyList();
                this.startTimestamp_ = "";
                this.endTimestamp_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.turnReward_ = Collections.emptyList();
                this.taskInfo_ = Collections.emptyList();
                this.startTimestamp_ = "";
                this.endTimestamp_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (RichHandler.GetRichInfoResponse.alwaysUseFieldBuilders) {
                    getTurnRewardFieldBuilder();
                    getTaskInfoFieldBuilder();
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
                if (this.turnRewardBuilder_ == null) {
                    this.turnReward_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                } else {
                    this.turnRewardBuilder_.clear();
                }
                if (this.taskInfoBuilder_ == null) {
                    this.taskInfo_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFF7;
                } else {
                    this.taskInfoBuilder_.clear();
                }
                this.currentStep_ = 0;
                this.bitField0_ &= 0xFFFFFFEF;
                this.freeCount_ = 0;
                this.bitField0_ &= 0xFFFFFFDF;
                this.startTimestamp_ = "";
                this.bitField0_ &= 0xFFFFFFBF;
                this.endTimestamp_ = "";
                this.bitField0_ &= 0xFFFFFF7F;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return RichHandler.internal_static_pomelo_rich_GetRichInfoResponse_descriptor;
            }

            public RichHandler.GetRichInfoResponse getDefaultInstanceForType() {
                return RichHandler.GetRichInfoResponse.getDefaultInstance();
            }

            public RichHandler.GetRichInfoResponse build() {
                RichHandler.GetRichInfoResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public RichHandler.GetRichInfoResponse buildPartial() {
                RichHandler.GetRichInfoResponse result = new RichHandler.GetRichInfoResponse(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.s2CMsg_ = this.s2CMsg_;
                if (this.turnRewardBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4) {
                        this.turnReward_ = Collections.unmodifiableList(this.turnReward_);
                        this.bitField0_ &= 0xFFFFFFFB;
                    }
                    result.turnReward_ = this.turnReward_;
                } else {
                    result.turnReward_ = this.turnRewardBuilder_.build();
                }
                if (this.taskInfoBuilder_ == null) {
                    if ((this.bitField0_ & 0x8) == 8) {
                        this.taskInfo_ = Collections.unmodifiableList(this.taskInfo_);
                        this.bitField0_ &= 0xFFFFFFF7;
                    }
                    result.taskInfo_ = this.taskInfo_;
                } else {
                    result.taskInfo_ = this.taskInfoBuilder_.build();
                }
                if ((from_bitField0_ & 0x10) == 16)
                    to_bitField0_ |= 0x4;
                result.currentStep_ = this.currentStep_;
                if ((from_bitField0_ & 0x20) == 32)
                    to_bitField0_ |= 0x8;
                result.freeCount_ = this.freeCount_;
                if ((from_bitField0_ & 0x40) == 64)
                    to_bitField0_ |= 0x10;
                result.startTimestamp_ = this.startTimestamp_;
                if ((from_bitField0_ & 0x80) == 128)
                    to_bitField0_ |= 0x20;
                result.endTimestamp_ = this.endTimestamp_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof RichHandler.GetRichInfoResponse)
                    return mergeFrom((RichHandler.GetRichInfoResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(RichHandler.GetRichInfoResponse other) {
                if (other == RichHandler.GetRichInfoResponse.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (this.turnRewardBuilder_ == null) {
                    if (!other.turnReward_.isEmpty()) {
                        if (this.turnReward_.isEmpty()) {
                            this.turnReward_ = other.turnReward_;
                            this.bitField0_ &= 0xFFFFFFFB;
                        } else {
                            ensureTurnRewardIsMutable();
                            this.turnReward_.addAll(other.turnReward_);
                        }
                        onChanged();
                    }
                } else if (!other.turnReward_.isEmpty()) {
                    if (this.turnRewardBuilder_.isEmpty()) {
                        this.turnRewardBuilder_.dispose();
                        this.turnRewardBuilder_ = null;
                        this.turnReward_ = other.turnReward_;
                        this.bitField0_ &= 0xFFFFFFFB;
                        this.turnRewardBuilder_ = RichHandler.GetRichInfoResponse.alwaysUseFieldBuilders ? getTurnRewardFieldBuilder() : null;
                    } else {
                        this.turnRewardBuilder_.addAllMessages(other.turnReward_);
                    }
                }
                if (this.taskInfoBuilder_ == null) {
                    if (!other.taskInfo_.isEmpty()) {
                        if (this.taskInfo_.isEmpty()) {
                            this.taskInfo_ = other.taskInfo_;
                            this.bitField0_ &= 0xFFFFFFF7;
                        } else {
                            ensureTaskInfoIsMutable();
                            this.taskInfo_.addAll(other.taskInfo_);
                        }
                        onChanged();
                    }
                } else if (!other.taskInfo_.isEmpty()) {
                    if (this.taskInfoBuilder_.isEmpty()) {
                        this.taskInfoBuilder_.dispose();
                        this.taskInfoBuilder_ = null;
                        this.taskInfo_ = other.taskInfo_;
                        this.bitField0_ &= 0xFFFFFFF7;
                        this.taskInfoBuilder_ = RichHandler.GetRichInfoResponse.alwaysUseFieldBuilders ? getTaskInfoFieldBuilder() : null;
                    } else {
                        this.taskInfoBuilder_.addAllMessages(other.taskInfo_);
                    }
                }
                if (other.hasCurrentStep())
                    setCurrentStep(other.getCurrentStep());
                if (other.hasFreeCount())
                    setFreeCount(other.getFreeCount());
                if (other.hasStartTimestamp()) {
                    this.bitField0_ |= 0x40;
                    this.startTimestamp_ = other.startTimestamp_;
                    onChanged();
                }
                if (other.hasEndTimestamp()) {
                    this.bitField0_ |= 0x80;
                    this.endTimestamp_ = other.endTimestamp_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode())
                    return false;
                int i;
                for (i = 0; i < getTurnRewardCount(); i++) {
                    if (!getTurnReward(i).isInitialized())
                        return false;
                }
                for (i = 0; i < getTaskInfoCount(); i++) {
                    if (!getTaskInfo(i).isInitialized())
                        return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                RichHandler.GetRichInfoResponse parsedMessage = null;
                try {
                    parsedMessage = (RichHandler.GetRichInfoResponse) RichHandler.GetRichInfoResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (RichHandler.GetRichInfoResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = RichHandler.GetRichInfoResponse.getDefaultInstance().getS2CMsg();
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

            private void ensureTurnRewardIsMutable() {
                if ((this.bitField0_ & 0x4) != 4) {
                    this.turnReward_ = new ArrayList<>(this.turnReward_);
                    this.bitField0_ |= 0x4;
                }
            }

            public List<RichHandler.TurnReward> getTurnRewardList() {
                if (this.turnRewardBuilder_ == null)
                    return Collections.unmodifiableList(this.turnReward_);
                return this.turnRewardBuilder_.getMessageList();
            }

            public int getTurnRewardCount() {
                if (this.turnRewardBuilder_ == null)
                    return this.turnReward_.size();
                return this.turnRewardBuilder_.getCount();
            }

            public RichHandler.TurnReward getTurnReward(int index) {
                if (this.turnRewardBuilder_ == null)
                    return this.turnReward_.get(index);
                return (RichHandler.TurnReward) this.turnRewardBuilder_.getMessage(index);
            }

            public Builder setTurnReward(int index, RichHandler.TurnReward value) {
                if (this.turnRewardBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureTurnRewardIsMutable();
                    this.turnReward_.set(index, value);
                    onChanged();
                } else {
                    this.turnRewardBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setTurnReward(int index, RichHandler.TurnReward.Builder builderForValue) {
                if (this.turnRewardBuilder_ == null) {
                    ensureTurnRewardIsMutable();
                    this.turnReward_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.turnRewardBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addTurnReward(RichHandler.TurnReward value) {
                if (this.turnRewardBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureTurnRewardIsMutable();
                    this.turnReward_.add(value);
                    onChanged();
                } else {
                    this.turnRewardBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addTurnReward(int index, RichHandler.TurnReward value) {
                if (this.turnRewardBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureTurnRewardIsMutable();
                    this.turnReward_.add(index, value);
                    onChanged();
                } else {
                    this.turnRewardBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addTurnReward(RichHandler.TurnReward.Builder builderForValue) {
                if (this.turnRewardBuilder_ == null) {
                    ensureTurnRewardIsMutable();
                    this.turnReward_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.turnRewardBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addTurnReward(int index, RichHandler.TurnReward.Builder builderForValue) {
                if (this.turnRewardBuilder_ == null) {
                    ensureTurnRewardIsMutable();
                    this.turnReward_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.turnRewardBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllTurnReward(Iterable<? extends RichHandler.TurnReward> values) {
                if (this.turnRewardBuilder_ == null) {
                    ensureTurnRewardIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.turnReward_);
                    onChanged();
                } else {
                    this.turnRewardBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearTurnReward() {
                if (this.turnRewardBuilder_ == null) {
                    this.turnReward_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                    onChanged();
                } else {
                    this.turnRewardBuilder_.clear();
                }
                return this;
            }

            public Builder removeTurnReward(int index) {
                if (this.turnRewardBuilder_ == null) {
                    ensureTurnRewardIsMutable();
                    this.turnReward_.remove(index);
                    onChanged();
                } else {
                    this.turnRewardBuilder_.remove(index);
                }
                return this;
            }

            public RichHandler.TurnReward.Builder getTurnRewardBuilder(int index) {
                return (RichHandler.TurnReward.Builder) getTurnRewardFieldBuilder().getBuilder(index);
            }

            public RichHandler.TurnRewardOrBuilder getTurnRewardOrBuilder(int index) {
                if (this.turnRewardBuilder_ == null)
                    return this.turnReward_.get(index);
                return (RichHandler.TurnRewardOrBuilder) this.turnRewardBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends RichHandler.TurnRewardOrBuilder> getTurnRewardOrBuilderList() {
                if (this.turnRewardBuilder_ != null)
                    return this.turnRewardBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.turnReward_);
            }

            public RichHandler.TurnReward.Builder addTurnRewardBuilder() {
                return (RichHandler.TurnReward.Builder) getTurnRewardFieldBuilder().addBuilder(RichHandler.TurnReward.getDefaultInstance());
            }

            public RichHandler.TurnReward.Builder addTurnRewardBuilder(int index) {
                return (RichHandler.TurnReward.Builder) getTurnRewardFieldBuilder().addBuilder(index, RichHandler.TurnReward.getDefaultInstance());
            }

            public List<RichHandler.TurnReward.Builder> getTurnRewardBuilderList() {
                return getTurnRewardFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<RichHandler.TurnReward, RichHandler.TurnReward.Builder, RichHandler.TurnRewardOrBuilder> getTurnRewardFieldBuilder() {
                if (this.turnRewardBuilder_ == null) {
                    this.turnRewardBuilder_ = new RepeatedFieldBuilder(this.turnReward_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
                    this.turnReward_ = null;
                }
                return this.turnRewardBuilder_;
            }

            private void ensureTaskInfoIsMutable() {
                if ((this.bitField0_ & 0x8) != 8) {
                    this.taskInfo_ = new ArrayList<>(this.taskInfo_);
                    this.bitField0_ |= 0x8;
                }
            }

            public List<RichHandler.TaskInfo> getTaskInfoList() {
                if (this.taskInfoBuilder_ == null)
                    return Collections.unmodifiableList(this.taskInfo_);
                return this.taskInfoBuilder_.getMessageList();
            }

            public int getTaskInfoCount() {
                if (this.taskInfoBuilder_ == null)
                    return this.taskInfo_.size();
                return this.taskInfoBuilder_.getCount();
            }

            public RichHandler.TaskInfo getTaskInfo(int index) {
                if (this.taskInfoBuilder_ == null)
                    return this.taskInfo_.get(index);
                return (RichHandler.TaskInfo) this.taskInfoBuilder_.getMessage(index);
            }

            public Builder setTaskInfo(int index, RichHandler.TaskInfo value) {
                if (this.taskInfoBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureTaskInfoIsMutable();
                    this.taskInfo_.set(index, value);
                    onChanged();
                } else {
                    this.taskInfoBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setTaskInfo(int index, RichHandler.TaskInfo.Builder builderForValue) {
                if (this.taskInfoBuilder_ == null) {
                    ensureTaskInfoIsMutable();
                    this.taskInfo_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.taskInfoBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addTaskInfo(RichHandler.TaskInfo value) {
                if (this.taskInfoBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureTaskInfoIsMutable();
                    this.taskInfo_.add(value);
                    onChanged();
                } else {
                    this.taskInfoBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addTaskInfo(int index, RichHandler.TaskInfo value) {
                if (this.taskInfoBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureTaskInfoIsMutable();
                    this.taskInfo_.add(index, value);
                    onChanged();
                } else {
                    this.taskInfoBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addTaskInfo(RichHandler.TaskInfo.Builder builderForValue) {
                if (this.taskInfoBuilder_ == null) {
                    ensureTaskInfoIsMutable();
                    this.taskInfo_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.taskInfoBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addTaskInfo(int index, RichHandler.TaskInfo.Builder builderForValue) {
                if (this.taskInfoBuilder_ == null) {
                    ensureTaskInfoIsMutable();
                    this.taskInfo_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.taskInfoBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllTaskInfo(Iterable<? extends RichHandler.TaskInfo> values) {
                if (this.taskInfoBuilder_ == null) {
                    ensureTaskInfoIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.taskInfo_);
                    onChanged();
                } else {
                    this.taskInfoBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearTaskInfo() {
                if (this.taskInfoBuilder_ == null) {
                    this.taskInfo_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFF7;
                    onChanged();
                } else {
                    this.taskInfoBuilder_.clear();
                }
                return this;
            }

            public Builder removeTaskInfo(int index) {
                if (this.taskInfoBuilder_ == null) {
                    ensureTaskInfoIsMutable();
                    this.taskInfo_.remove(index);
                    onChanged();
                } else {
                    this.taskInfoBuilder_.remove(index);
                }
                return this;
            }

            public RichHandler.TaskInfo.Builder getTaskInfoBuilder(int index) {
                return (RichHandler.TaskInfo.Builder) getTaskInfoFieldBuilder().getBuilder(index);
            }

            public RichHandler.TaskInfoOrBuilder getTaskInfoOrBuilder(int index) {
                if (this.taskInfoBuilder_ == null)
                    return this.taskInfo_.get(index);
                return (RichHandler.TaskInfoOrBuilder) this.taskInfoBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends RichHandler.TaskInfoOrBuilder> getTaskInfoOrBuilderList() {
                if (this.taskInfoBuilder_ != null)
                    return this.taskInfoBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.taskInfo_);
            }

            public RichHandler.TaskInfo.Builder addTaskInfoBuilder() {
                return (RichHandler.TaskInfo.Builder) getTaskInfoFieldBuilder().addBuilder(RichHandler.TaskInfo.getDefaultInstance());
            }

            public RichHandler.TaskInfo.Builder addTaskInfoBuilder(int index) {
                return (RichHandler.TaskInfo.Builder) getTaskInfoFieldBuilder().addBuilder(index, RichHandler.TaskInfo.getDefaultInstance());
            }

            public List<RichHandler.TaskInfo.Builder> getTaskInfoBuilderList() {
                return getTaskInfoFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<RichHandler.TaskInfo, RichHandler.TaskInfo.Builder, RichHandler.TaskInfoOrBuilder> getTaskInfoFieldBuilder() {
                if (this.taskInfoBuilder_ == null) {
                    this.taskInfoBuilder_ = new RepeatedFieldBuilder(this.taskInfo_, ((this.bitField0_ & 0x8) == 8), getParentForChildren(), isClean());
                    this.taskInfo_ = null;
                }
                return this.taskInfoBuilder_;
            }

            public boolean hasCurrentStep() {
                return ((this.bitField0_ & 0x10) == 16);
            }

            public int getCurrentStep() {
                return this.currentStep_;
            }

            public Builder setCurrentStep(int value) {
                this.bitField0_ |= 0x10;
                this.currentStep_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurrentStep() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.currentStep_ = 0;
                onChanged();
                return this;
            }

            public boolean hasFreeCount() {
                return ((this.bitField0_ & 0x20) == 32);
            }

            public int getFreeCount() {
                return this.freeCount_;
            }

            public Builder setFreeCount(int value) {
                this.bitField0_ |= 0x20;
                this.freeCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearFreeCount() {
                this.bitField0_ &= 0xFFFFFFDF;
                this.freeCount_ = 0;
                onChanged();
                return this;
            }

            public boolean hasStartTimestamp() {
                return ((this.bitField0_ & 0x40) == 64);
            }

            public String getStartTimestamp() {
                Object ref = this.startTimestamp_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.startTimestamp_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getStartTimestampBytes() {
                Object ref = this.startTimestamp_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.startTimestamp_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setStartTimestamp(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x40;
                this.startTimestamp_ = value;
                onChanged();
                return this;
            }

            public Builder clearStartTimestamp() {
                this.bitField0_ &= 0xFFFFFFBF;
                this.startTimestamp_ = RichHandler.GetRichInfoResponse.getDefaultInstance().getStartTimestamp();
                onChanged();
                return this;
            }

            public Builder setStartTimestampBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x40;
                this.startTimestamp_ = value;
                onChanged();
                return this;
            }

            public boolean hasEndTimestamp() {
                return ((this.bitField0_ & 0x80) == 128);
            }

            public String getEndTimestamp() {
                Object ref = this.endTimestamp_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.endTimestamp_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getEndTimestampBytes() {
                Object ref = this.endTimestamp_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.endTimestamp_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setEndTimestamp(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x80;
                this.endTimestamp_ = value;
                onChanged();
                return this;
            }

            public Builder clearEndTimestamp() {
                this.bitField0_ &= 0xFFFFFF7F;
                this.endTimestamp_ = RichHandler.GetRichInfoResponse.getDefaultInstance().getEndTimestamp();
                onChanged();
                return this;
            }

            public Builder setEndTimestampBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x80;
                this.endTimestamp_ = value;
                onChanged();
                return this;
            }
        }
    }

    public static final class DiceRequest extends GeneratedMessage implements DiceRequestOrBuilder {
        private static final DiceRequest defaultInstance = new DiceRequest(true);
        private final UnknownFieldSet unknownFields;

        private DiceRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private DiceRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static DiceRequest getDefaultInstance() {
            return defaultInstance;
        }

        public DiceRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DiceRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return RichHandler.internal_static_pomelo_rich_DiceRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return RichHandler.internal_static_pomelo_rich_DiceRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(DiceRequest.class, Builder.class);
        }

        public static Parser<DiceRequest> PARSER = (Parser<DiceRequest>) new AbstractParser<DiceRequest>() {
            public RichHandler.DiceRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new RichHandler.DiceRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<DiceRequest> getParserForType() {
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

        public static DiceRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (DiceRequest) PARSER.parseFrom(data);
        }

        public static DiceRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DiceRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DiceRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (DiceRequest) PARSER.parseFrom(data);
        }

        public static DiceRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DiceRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DiceRequest parseFrom(InputStream input) throws IOException {
            return (DiceRequest) PARSER.parseFrom(input);
        }

        public static DiceRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DiceRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static DiceRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (DiceRequest) PARSER.parseDelimitedFrom(input);
        }

        public static DiceRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DiceRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static DiceRequest parseFrom(CodedInputStream input) throws IOException {
            return (DiceRequest) PARSER.parseFrom(input);
        }

        public static DiceRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DiceRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(DiceRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements RichHandler.DiceRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return RichHandler.internal_static_pomelo_rich_DiceRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return RichHandler.internal_static_pomelo_rich_DiceRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(RichHandler.DiceRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (RichHandler.DiceRequest.alwaysUseFieldBuilders) ;
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
                return RichHandler.internal_static_pomelo_rich_DiceRequest_descriptor;
            }

            public RichHandler.DiceRequest getDefaultInstanceForType() {
                return RichHandler.DiceRequest.getDefaultInstance();
            }

            public RichHandler.DiceRequest build() {
                RichHandler.DiceRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public RichHandler.DiceRequest buildPartial() {
                RichHandler.DiceRequest result = new RichHandler.DiceRequest(this);
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof RichHandler.DiceRequest) return mergeFrom((RichHandler.DiceRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(RichHandler.DiceRequest other) {
                if (other == RichHandler.DiceRequest.getDefaultInstance()) return this;
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                RichHandler.DiceRequest parsedMessage = null;
                try {
                    parsedMessage = (RichHandler.DiceRequest) RichHandler.DiceRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (RichHandler.DiceRequest) e.getUnfinishedMessage();
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


    public static final class DiceResponse
            extends GeneratedMessage
            implements DiceResponseOrBuilder {
        private static final DiceResponse defaultInstance = new DiceResponse(true);
        private final UnknownFieldSet unknownFields;

        private DiceResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private DiceResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static DiceResponse getDefaultInstance() {
            return defaultInstance;
        }

        public DiceResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DiceResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString bs;
                    RichHandler.Reward.Builder subBuilder;
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
                            this.step_ = input.readInt32();
                            break;
                        case 34:
                            subBuilder = null;
                            if ((this.bitField0_ & 0x8) == 8) subBuilder = this.reward_.toBuilder();
                            this.reward_ = (RichHandler.Reward) input.readMessage(RichHandler.Reward.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.reward_);
                                this.reward_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 0x8;
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
            return RichHandler.internal_static_pomelo_rich_DiceResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return RichHandler.internal_static_pomelo_rich_DiceResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(DiceResponse.class, Builder.class);
        }

        public static Parser<DiceResponse> PARSER = (Parser<DiceResponse>) new AbstractParser<DiceResponse>() {
            public RichHandler.DiceResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new RichHandler.DiceResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int STEP_FIELD_NUMBER = 3;
        private int step_;
        public static final int REWARD_FIELD_NUMBER = 4;
        private RichHandler.Reward reward_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<DiceResponse> getParserForType() {
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

        public boolean hasStep() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getStep() {
            return this.step_;
        }

        public boolean hasReward() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public RichHandler.Reward getReward() {
            return this.reward_;
        }

        public RichHandler.RewardOrBuilder getRewardOrBuilder() {
            return this.reward_;
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.step_ = 0;
            this.reward_ = RichHandler.Reward.getDefaultInstance();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasS2CCode()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (hasReward() && !getReward().isInitialized()) {
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
            if ((this.bitField0_ & 0x4) == 4) output.writeInt32(3, this.step_);
            if ((this.bitField0_ & 0x8) == 8) output.writeMessage(4, (MessageLite) this.reward_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());
            if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeInt32Size(3, this.step_);
            if ((this.bitField0_ & 0x8) == 8)
                size += CodedOutputStream.computeMessageSize(4, (MessageLite) this.reward_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static DiceResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (DiceResponse) PARSER.parseFrom(data);
        }

        public static DiceResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DiceResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DiceResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (DiceResponse) PARSER.parseFrom(data);
        }

        public static DiceResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DiceResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DiceResponse parseFrom(InputStream input) throws IOException {
            return (DiceResponse) PARSER.parseFrom(input);
        }

        public static DiceResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DiceResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static DiceResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (DiceResponse) PARSER.parseDelimitedFrom(input);
        }

        public static DiceResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DiceResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static DiceResponse parseFrom(CodedInputStream input) throws IOException {
            return (DiceResponse) PARSER.parseFrom(input);
        }

        public static DiceResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DiceResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(DiceResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements RichHandler.DiceResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private int step_;
            private RichHandler.Reward reward_;
            private SingleFieldBuilder<RichHandler.Reward, RichHandler.Reward.Builder, RichHandler.RewardOrBuilder> rewardBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return RichHandler.internal_static_pomelo_rich_DiceResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return RichHandler.internal_static_pomelo_rich_DiceResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(RichHandler.DiceResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.reward_ = RichHandler.Reward.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.reward_ = RichHandler.Reward.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (RichHandler.DiceResponse.alwaysUseFieldBuilders) getRewardFieldBuilder();
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
                this.step_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                if (this.rewardBuilder_ == null) {
                    this.reward_ = RichHandler.Reward.getDefaultInstance();
                } else {
                    this.rewardBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return RichHandler.internal_static_pomelo_rich_DiceResponse_descriptor;
            }

            public RichHandler.DiceResponse getDefaultInstanceForType() {
                return RichHandler.DiceResponse.getDefaultInstance();
            }

            public RichHandler.DiceResponse build() {
                RichHandler.DiceResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public RichHandler.DiceResponse buildPartial() {
                RichHandler.DiceResponse result = new RichHandler.DiceResponse(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.s2CMsg_ = this.s2CMsg_;
                if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;
                result.step_ = this.step_;
                if ((from_bitField0_ & 0x8) == 8) to_bitField0_ |= 0x8;
                if (this.rewardBuilder_ == null) {
                    result.reward_ = this.reward_;
                } else {
                    result.reward_ = (RichHandler.Reward) this.rewardBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof RichHandler.DiceResponse) return mergeFrom((RichHandler.DiceResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(RichHandler.DiceResponse other) {
                if (other == RichHandler.DiceResponse.getDefaultInstance()) return this;
                if (other.hasS2CCode()) setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (other.hasStep()) setStep(other.getStep());
                if (other.hasReward()) mergeReward(other.getReward());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode()) return false;
                if (hasReward() && !getReward().isInitialized()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                RichHandler.DiceResponse parsedMessage = null;
                try {
                    parsedMessage = (RichHandler.DiceResponse) RichHandler.DiceResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (RichHandler.DiceResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = RichHandler.DiceResponse.getDefaultInstance().getS2CMsg();
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

            public boolean hasStep() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public int getStep() {
                return this.step_;
            }

            public Builder setStep(int value) {
                this.bitField0_ |= 0x4;
                this.step_ = value;
                onChanged();
                return this;
            }

            public Builder clearStep() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.step_ = 0;
                onChanged();
                return this;
            }

            public boolean hasReward() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public RichHandler.Reward getReward() {
                if (this.rewardBuilder_ == null) return this.reward_;
                return (RichHandler.Reward) this.rewardBuilder_.getMessage();
            }

            public Builder setReward(RichHandler.Reward value) {
                if (this.rewardBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    this.reward_ = value;
                    onChanged();
                } else {
                    this.rewardBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x8;
                return this;
            }

            public Builder setReward(RichHandler.Reward.Builder builderForValue) {
                if (this.rewardBuilder_ == null) {
                    this.reward_ = builderForValue.build();
                    onChanged();
                } else {
                    this.rewardBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x8;
                return this;
            }

            public Builder mergeReward(RichHandler.Reward value) {
                if (this.rewardBuilder_ == null) {
                    if ((this.bitField0_ & 0x8) == 8 && this.reward_ != RichHandler.Reward.getDefaultInstance()) {
                        this.reward_ = RichHandler.Reward.newBuilder(this.reward_).mergeFrom(value).buildPartial();
                    } else {
                        this.reward_ = value;
                    }
                    onChanged();
                } else {
                    this.rewardBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x8;
                return this;
            }

            public Builder clearReward() {
                if (this.rewardBuilder_ == null) {
                    this.reward_ = RichHandler.Reward.getDefaultInstance();
                    onChanged();
                } else {
                    this.rewardBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }

            public RichHandler.Reward.Builder getRewardBuilder() {
                this.bitField0_ |= 0x8;
                onChanged();
                return (RichHandler.Reward.Builder) getRewardFieldBuilder().getBuilder();
            }

            public RichHandler.RewardOrBuilder getRewardOrBuilder() {
                if (this.rewardBuilder_ != null)
                    return (RichHandler.RewardOrBuilder) this.rewardBuilder_.getMessageOrBuilder();
                return this.reward_;
            }

            private SingleFieldBuilder<RichHandler.Reward, RichHandler.Reward.Builder, RichHandler.RewardOrBuilder> getRewardFieldBuilder() {
                if (this.rewardBuilder_ == null) {
                    this.rewardBuilder_ = new SingleFieldBuilder(getReward(), getParentForChildren(), isClean());
                    this.reward_ = null;
                }
                return this.rewardBuilder_;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class FetchTurnAwardRequest
            extends GeneratedMessage
            implements FetchTurnAwardRequestOrBuilder {
        private static final FetchTurnAwardRequest defaultInstance = new FetchTurnAwardRequest(true);
        private final UnknownFieldSet unknownFields;

        private FetchTurnAwardRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private FetchTurnAwardRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static FetchTurnAwardRequest getDefaultInstance() {
            return defaultInstance;
        }

        public FetchTurnAwardRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private FetchTurnAwardRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return RichHandler.internal_static_pomelo_rich_FetchTurnAwardRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return RichHandler.internal_static_pomelo_rich_FetchTurnAwardRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(FetchTurnAwardRequest.class, Builder.class);
        }

        public static Parser<FetchTurnAwardRequest> PARSER = (Parser<FetchTurnAwardRequest>) new AbstractParser<FetchTurnAwardRequest>() {
            public RichHandler.FetchTurnAwardRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new RichHandler.FetchTurnAwardRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int ID_FIELD_NUMBER = 1;
        private int id_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<FetchTurnAwardRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getId() {
            return this.id_;
        }

        private void initFields() {
            this.id_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.id_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.id_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static FetchTurnAwardRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (FetchTurnAwardRequest) PARSER.parseFrom(data);
        }

        public static FetchTurnAwardRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FetchTurnAwardRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static FetchTurnAwardRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (FetchTurnAwardRequest) PARSER.parseFrom(data);
        }

        public static FetchTurnAwardRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FetchTurnAwardRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static FetchTurnAwardRequest parseFrom(InputStream input) throws IOException {
            return (FetchTurnAwardRequest) PARSER.parseFrom(input);
        }

        public static FetchTurnAwardRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FetchTurnAwardRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static FetchTurnAwardRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (FetchTurnAwardRequest) PARSER.parseDelimitedFrom(input);
        }

        public static FetchTurnAwardRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FetchTurnAwardRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static FetchTurnAwardRequest parseFrom(CodedInputStream input) throws IOException {
            return (FetchTurnAwardRequest) PARSER.parseFrom(input);
        }

        public static FetchTurnAwardRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FetchTurnAwardRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(FetchTurnAwardRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements RichHandler.FetchTurnAwardRequestOrBuilder {
            private int bitField0_;
            private int id_;

            public static final Descriptors.Descriptor getDescriptor() {
                return RichHandler.internal_static_pomelo_rich_FetchTurnAwardRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return RichHandler.internal_static_pomelo_rich_FetchTurnAwardRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(RichHandler.FetchTurnAwardRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (RichHandler.FetchTurnAwardRequest.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.id_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return RichHandler.internal_static_pomelo_rich_FetchTurnAwardRequest_descriptor;
            }

            public RichHandler.FetchTurnAwardRequest getDefaultInstanceForType() {
                return RichHandler.FetchTurnAwardRequest.getDefaultInstance();
            }

            public RichHandler.FetchTurnAwardRequest build() {
                RichHandler.FetchTurnAwardRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public RichHandler.FetchTurnAwardRequest buildPartial() {
                RichHandler.FetchTurnAwardRequest result = new RichHandler.FetchTurnAwardRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.id_ = this.id_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof RichHandler.FetchTurnAwardRequest)
                    return mergeFrom((RichHandler.FetchTurnAwardRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(RichHandler.FetchTurnAwardRequest other) {
                if (other == RichHandler.FetchTurnAwardRequest.getDefaultInstance()) return this;
                if (other.hasId()) setId(other.getId());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasId()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                RichHandler.FetchTurnAwardRequest parsedMessage = null;
                try {
                    parsedMessage = (RichHandler.FetchTurnAwardRequest) RichHandler.FetchTurnAwardRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (RichHandler.FetchTurnAwardRequest) e.getUnfinishedMessage();
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
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class FetchTurnAwardResponse
            extends GeneratedMessage
            implements FetchTurnAwardResponseOrBuilder {
        private static final FetchTurnAwardResponse defaultInstance = new FetchTurnAwardResponse(true);
        private final UnknownFieldSet unknownFields;

        private FetchTurnAwardResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private FetchTurnAwardResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static FetchTurnAwardResponse getDefaultInstance() {
            return defaultInstance;
        }

        public FetchTurnAwardResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private FetchTurnAwardResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.reward_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x4;
                            }
                            this.reward_.add(input.readMessage(RichHandler.Reward.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x4) == 4) this.reward_ = Collections.unmodifiableList(this.reward_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return RichHandler.internal_static_pomelo_rich_FetchTurnAwardResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return RichHandler.internal_static_pomelo_rich_FetchTurnAwardResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(FetchTurnAwardResponse.class, Builder.class);
        }

        public static Parser<FetchTurnAwardResponse> PARSER = (Parser<FetchTurnAwardResponse>) new AbstractParser<FetchTurnAwardResponse>() {
            public RichHandler.FetchTurnAwardResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new RichHandler.FetchTurnAwardResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int REWARD_FIELD_NUMBER = 3;
        private List<RichHandler.Reward> reward_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<FetchTurnAwardResponse> getParserForType() {
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

        public List<RichHandler.Reward> getRewardList() {
            return this.reward_;
        }

        public List<? extends RichHandler.RewardOrBuilder> getRewardOrBuilderList() {
            return (List) this.reward_;
        }

        public int getRewardCount() {
            return this.reward_.size();
        }

        public RichHandler.Reward getReward(int index) {
            return this.reward_.get(index);
        }

        public RichHandler.RewardOrBuilder getRewardOrBuilder(int index) {
            return this.reward_.get(index);
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.reward_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasS2CCode()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (int i = 0; i < getRewardCount(); i++) {
                if (!getReward(i).isInitialized()) {
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
            for (int i = 0; i < this.reward_.size(); i++) output.writeMessage(3, (MessageLite) this.reward_.get(i));
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());
            for (int i = 0; i < this.reward_.size(); i++)
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.reward_.get(i));
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static FetchTurnAwardResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (FetchTurnAwardResponse) PARSER.parseFrom(data);
        }

        public static FetchTurnAwardResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FetchTurnAwardResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static FetchTurnAwardResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (FetchTurnAwardResponse) PARSER.parseFrom(data);
        }

        public static FetchTurnAwardResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FetchTurnAwardResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static FetchTurnAwardResponse parseFrom(InputStream input) throws IOException {
            return (FetchTurnAwardResponse) PARSER.parseFrom(input);
        }

        public static FetchTurnAwardResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FetchTurnAwardResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static FetchTurnAwardResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (FetchTurnAwardResponse) PARSER.parseDelimitedFrom(input);
        }

        public static FetchTurnAwardResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FetchTurnAwardResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static FetchTurnAwardResponse parseFrom(CodedInputStream input) throws IOException {
            return (FetchTurnAwardResponse) PARSER.parseFrom(input);
        }

        public static FetchTurnAwardResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FetchTurnAwardResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(FetchTurnAwardResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements RichHandler.FetchTurnAwardResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private List<RichHandler.Reward> reward_;
            private RepeatedFieldBuilder<RichHandler.Reward, RichHandler.Reward.Builder, RichHandler.RewardOrBuilder> rewardBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return RichHandler.internal_static_pomelo_rich_FetchTurnAwardResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return RichHandler.internal_static_pomelo_rich_FetchTurnAwardResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(RichHandler.FetchTurnAwardResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.reward_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.reward_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (RichHandler.FetchTurnAwardResponse.alwaysUseFieldBuilders) getRewardFieldBuilder();
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
                if (this.rewardBuilder_ == null) {
                    this.reward_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                } else {
                    this.rewardBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return RichHandler.internal_static_pomelo_rich_FetchTurnAwardResponse_descriptor;
            }

            public RichHandler.FetchTurnAwardResponse getDefaultInstanceForType() {
                return RichHandler.FetchTurnAwardResponse.getDefaultInstance();
            }

            public RichHandler.FetchTurnAwardResponse build() {
                RichHandler.FetchTurnAwardResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public RichHandler.FetchTurnAwardResponse buildPartial() {
                RichHandler.FetchTurnAwardResponse result = new RichHandler.FetchTurnAwardResponse(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.s2CMsg_ = this.s2CMsg_;
                if (this.rewardBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4) {
                        this.reward_ = Collections.unmodifiableList(this.reward_);
                        this.bitField0_ &= 0xFFFFFFFB;
                    }
                    result.reward_ = this.reward_;
                } else {
                    result.reward_ = this.rewardBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof RichHandler.FetchTurnAwardResponse)
                    return mergeFrom((RichHandler.FetchTurnAwardResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(RichHandler.FetchTurnAwardResponse other) {
                if (other == RichHandler.FetchTurnAwardResponse.getDefaultInstance()) return this;
                if (other.hasS2CCode()) setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (this.rewardBuilder_ == null) {
                    if (!other.reward_.isEmpty()) {
                        if (this.reward_.isEmpty()) {
                            this.reward_ = other.reward_;
                            this.bitField0_ &= 0xFFFFFFFB;
                        } else {
                            ensureRewardIsMutable();
                            this.reward_.addAll(other.reward_);
                        }
                        onChanged();
                    }
                } else if (!other.reward_.isEmpty()) {
                    if (this.rewardBuilder_.isEmpty()) {
                        this.rewardBuilder_.dispose();
                        this.rewardBuilder_ = null;
                        this.reward_ = other.reward_;
                        this.bitField0_ &= 0xFFFFFFFB;
                        this.rewardBuilder_ = RichHandler.FetchTurnAwardResponse.alwaysUseFieldBuilders ? getRewardFieldBuilder() : null;
                    } else {
                        this.rewardBuilder_.addAllMessages(other.reward_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode()) return false;
                for (int i = 0; i < getRewardCount(); i++) {
                    if (!getReward(i).isInitialized()) return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                RichHandler.FetchTurnAwardResponse parsedMessage = null;
                try {
                    parsedMessage = (RichHandler.FetchTurnAwardResponse) RichHandler.FetchTurnAwardResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (RichHandler.FetchTurnAwardResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = RichHandler.FetchTurnAwardResponse.getDefaultInstance().getS2CMsg();
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

            private void ensureRewardIsMutable() {
                if ((this.bitField0_ & 0x4) != 4) {
                    this.reward_ = new ArrayList<>(this.reward_);
                    this.bitField0_ |= 0x4;
                }
            }

            public List<RichHandler.Reward> getRewardList() {
                if (this.rewardBuilder_ == null) return Collections.unmodifiableList(this.reward_);
                return this.rewardBuilder_.getMessageList();
            }

            public int getRewardCount() {
                if (this.rewardBuilder_ == null) return this.reward_.size();
                return this.rewardBuilder_.getCount();
            }

            public RichHandler.Reward getReward(int index) {
                if (this.rewardBuilder_ == null) return this.reward_.get(index);
                return (RichHandler.Reward) this.rewardBuilder_.getMessage(index);
            }

            public Builder setReward(int index, RichHandler.Reward value) {
                if (this.rewardBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureRewardIsMutable();
                    this.reward_.set(index, value);
                    onChanged();
                } else {
                    this.rewardBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setReward(int index, RichHandler.Reward.Builder builderForValue) {
                if (this.rewardBuilder_ == null) {
                    ensureRewardIsMutable();
                    this.reward_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.rewardBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addReward(RichHandler.Reward value) {
                if (this.rewardBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureRewardIsMutable();
                    this.reward_.add(value);
                    onChanged();
                } else {
                    this.rewardBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addReward(int index, RichHandler.Reward value) {
                if (this.rewardBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureRewardIsMutable();
                    this.reward_.add(index, value);
                    onChanged();
                } else {
                    this.rewardBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addReward(RichHandler.Reward.Builder builderForValue) {
                if (this.rewardBuilder_ == null) {
                    ensureRewardIsMutable();
                    this.reward_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.rewardBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addReward(int index, RichHandler.Reward.Builder builderForValue) {
                if (this.rewardBuilder_ == null) {
                    ensureRewardIsMutable();
                    this.reward_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.rewardBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllReward(Iterable<? extends RichHandler.Reward> values) {
                if (this.rewardBuilder_ == null) {
                    ensureRewardIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.reward_);
                    onChanged();
                } else {
                    this.rewardBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearReward() {
                if (this.rewardBuilder_ == null) {
                    this.reward_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                    onChanged();
                } else {
                    this.rewardBuilder_.clear();
                }
                return this;
            }

            public Builder removeReward(int index) {
                if (this.rewardBuilder_ == null) {
                    ensureRewardIsMutable();
                    this.reward_.remove(index);
                    onChanged();
                } else {
                    this.rewardBuilder_.remove(index);
                }
                return this;
            }

            public RichHandler.Reward.Builder getRewardBuilder(int index) {
                return (RichHandler.Reward.Builder) getRewardFieldBuilder().getBuilder(index);
            }

            public RichHandler.RewardOrBuilder getRewardOrBuilder(int index) {
                if (this.rewardBuilder_ == null) return this.reward_.get(index);
                return (RichHandler.RewardOrBuilder) this.rewardBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends RichHandler.RewardOrBuilder> getRewardOrBuilderList() {
                if (this.rewardBuilder_ != null) return this.rewardBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.reward_);
            }

            public RichHandler.Reward.Builder addRewardBuilder() {
                return (RichHandler.Reward.Builder) getRewardFieldBuilder().addBuilder(RichHandler.Reward.getDefaultInstance());
            }

            public RichHandler.Reward.Builder addRewardBuilder(int index) {
                return (RichHandler.Reward.Builder) getRewardFieldBuilder().addBuilder(index, RichHandler.Reward.getDefaultInstance());
            }

            public List<RichHandler.Reward.Builder> getRewardBuilderList() {
                return getRewardFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<RichHandler.Reward, RichHandler.Reward.Builder, RichHandler.RewardOrBuilder> getRewardFieldBuilder() {
                if (this.rewardBuilder_ == null) {
                    this.rewardBuilder_ = new RepeatedFieldBuilder(this.reward_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
                    this.reward_ = null;
                }
                return this.rewardBuilder_;
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
        String[] descriptorData = {"\n\021richHandler.proto\022\013pomelo.rich\"*\n\006Reward\022\f\n\004code\030\001 \002(\t\022\022\n\ngroupCount\030\002 \002(\005\"P\n\nTurnReward\022\016\n\006turnId\030\001 \002(\005\022#\n\006reward\030\002 \003(\0132\023.pomelo.rich.Reward\022\r\n\005state\030\003 \002(\005\"D\n\bTaskInfo\022\017\n\007schName\030\001 \002(\t\022\025\n\rfinishedCount\030\002 \002(\005\022\020\n\bmaxCount\030\003 \002(\005\"\024\n\022GetRichInfoRequest\"ä\001\n\023GetRichInfoResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022+\n\nturnReward\030\003 \003(\0132\027.pomelo.rich.TurnReward\022'\n\btaskInfo\030\004 \003(\0132\025.pomelo.rich.TaskInfo\022\023\n\013c", "urrentStep\030\005 \001(\005\022\021\n\tfreeCount\030\006 \001(\005\022\026\n\016startTimestamp\030\007 \001(\t\022\024\n\fendTimestamp\030\b \001(\t\"\r\n\013DiceRequest\"d\n\fDiceResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\f\n\004step\030\003 \001(\005\022#\n\006reward\030\004 \001(\0132\023.pomelo.rich.Reward\"#\n\025FetchTurnAwardRequest\022\n\n\002id\030\001 \002(\005\"`\n\026FetchTurnAwardResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022#\n\006reward\030\003 \003(\0132\023.pomelo.rich.Reward2\002\n\013richHandler\022W\n\022getRichInfoRequest\022\037.pomelo.rich.GetRichInfoReq", "uest\032 .pomelo.rich.GetRichInfoResponse\022B\n\013diceRequest\022\030.pomelo.rich.DiceRequest\032\031.pomelo.rich.DiceResponse\022`\n\025fetchTurnAwardRequest\022\".pomelo.rich.FetchTurnAwardRequest\032#.pomelo.rich.FetchTurnAwardResponse"};


        Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root) {
                RichHandler.descriptor = root;
                return null;
            }
        };

        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[0], assigner);
    }


    private static final Descriptors.Descriptor internal_static_pomelo_rich_Reward_descriptor = getDescriptor().getMessageTypes().get(0);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_rich_Reward_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_rich_Reward_descriptor, new String[]{"Code", "GroupCount"});


    private static final Descriptors.Descriptor internal_static_pomelo_rich_TurnReward_descriptor = getDescriptor().getMessageTypes().get(1);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_rich_TurnReward_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_rich_TurnReward_descriptor, new String[]{"TurnId", "Reward", "State"});


    private static final Descriptors.Descriptor internal_static_pomelo_rich_TaskInfo_descriptor = getDescriptor().getMessageTypes().get(2);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_rich_TaskInfo_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_rich_TaskInfo_descriptor, new String[]{"SchName", "FinishedCount", "MaxCount"});


    private static final Descriptors.Descriptor internal_static_pomelo_rich_GetRichInfoRequest_descriptor = getDescriptor().getMessageTypes().get(3);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_rich_GetRichInfoRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_rich_GetRichInfoRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_rich_GetRichInfoResponse_descriptor = getDescriptor().getMessageTypes().get(4);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_rich_GetRichInfoResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_rich_GetRichInfoResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "TurnReward", "TaskInfo", "CurrentStep", "FreeCount", "StartTimestamp", "EndTimestamp"});


    private static final Descriptors.Descriptor internal_static_pomelo_rich_DiceRequest_descriptor = getDescriptor().getMessageTypes().get(5);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_rich_DiceRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_rich_DiceRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_rich_DiceResponse_descriptor = getDescriptor().getMessageTypes().get(6);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_rich_DiceResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_rich_DiceResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "Step", "Reward"});


    private static final Descriptors.Descriptor internal_static_pomelo_rich_FetchTurnAwardRequest_descriptor = getDescriptor().getMessageTypes().get(7);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_rich_FetchTurnAwardRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_rich_FetchTurnAwardRequest_descriptor, new String[]{"Id"});


    private static final Descriptors.Descriptor internal_static_pomelo_rich_FetchTurnAwardResponse_descriptor = getDescriptor().getMessageTypes().get(8);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_rich_FetchTurnAwardResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_rich_FetchTurnAwardResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "Reward"});
    private static Descriptors.FileDescriptor descriptor;

    public static interface FetchTurnAwardResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        List<RichHandler.Reward> getRewardList();

        RichHandler.Reward getReward(int param1Int);

        int getRewardCount();

        List<? extends RichHandler.RewardOrBuilder> getRewardOrBuilderList();

        RichHandler.RewardOrBuilder getRewardOrBuilder(int param1Int);
    }

    public static interface FetchTurnAwardRequestOrBuilder extends MessageOrBuilder {
        boolean hasId();

        int getId();
    }

    public static interface DiceResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasStep();

        int getStep();

        boolean hasReward();

        RichHandler.Reward getReward();

        RichHandler.RewardOrBuilder getRewardOrBuilder();
    }

    public static interface DiceRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface GetRichInfoResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        List<RichHandler.TurnReward> getTurnRewardList();

        RichHandler.TurnReward getTurnReward(int param1Int);

        int getTurnRewardCount();

        List<? extends RichHandler.TurnRewardOrBuilder> getTurnRewardOrBuilderList();

        RichHandler.TurnRewardOrBuilder getTurnRewardOrBuilder(int param1Int);

        List<RichHandler.TaskInfo> getTaskInfoList();

        RichHandler.TaskInfo getTaskInfo(int param1Int);

        int getTaskInfoCount();

        List<? extends RichHandler.TaskInfoOrBuilder> getTaskInfoOrBuilderList();

        RichHandler.TaskInfoOrBuilder getTaskInfoOrBuilder(int param1Int);

        boolean hasCurrentStep();

        int getCurrentStep();

        boolean hasFreeCount();

        int getFreeCount();

        boolean hasStartTimestamp();

        String getStartTimestamp();

        ByteString getStartTimestampBytes();

        boolean hasEndTimestamp();

        String getEndTimestamp();

        ByteString getEndTimestampBytes();
    }

    public static interface GetRichInfoRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface TaskInfoOrBuilder extends MessageOrBuilder {
        boolean hasSchName();

        String getSchName();

        ByteString getSchNameBytes();

        boolean hasFinishedCount();

        int getFinishedCount();

        boolean hasMaxCount();

        int getMaxCount();
    }

    public static interface TurnRewardOrBuilder extends MessageOrBuilder {
        boolean hasTurnId();

        int getTurnId();

        List<RichHandler.Reward> getRewardList();

        RichHandler.Reward getReward(int param1Int);

        int getRewardCount();

        List<? extends RichHandler.RewardOrBuilder> getRewardOrBuilderList();

        RichHandler.RewardOrBuilder getRewardOrBuilder(int param1Int);

        boolean hasState();

        int getState();
    }

    public static interface RewardOrBuilder extends MessageOrBuilder {
        boolean hasCode();

        String getCode();

        ByteString getCodeBytes();

        boolean hasGroupCount();

        int getGroupCount();
    }
}


