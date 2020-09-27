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


public final class MedalHandler {
    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static final class MedalData
            extends GeneratedMessage
            implements MedalDataOrBuilder {
        private final UnknownFieldSet unknownFields;

        private MedalData(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private MedalData(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static MedalData getDefaultInstance() {
            return defaultInstance;
        }

        public MedalData getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MedalData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        case 10:
                            subBuilder = null;
                            if ((this.bitField0_ & 0x1) == 1)
                                subBuilder = this.medal_.toBuilder();
                            this.medal_ = (ItemOuterClass.MiniItem) input.readMessage(ItemOuterClass.MiniItem.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.medal_);
                                this.medal_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 0x1;
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.ifMax_ = input.readInt32();
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.needPrestige_ = input.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.needGold_ = input.readInt32();
                            break;
                        case 40:
                            this.bitField0_ |= 0x10;
                            this.needDiamond_ = input.readInt32();
                            break;
                        case 50:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x20;
                            this.nextTitleName_ = bs;
                            break;
                        case 58:
                            if ((mutable_bitField0_ & 0x40) != 64) {
                                this.attrs_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x40;
                            }
                            this.attrs_.add(input.readMessage(Common.AttributeBase.PARSER, extensionRegistry));
                            break;
                        case 64:
                            this.bitField0_ |= 0x40;
                            this.flag_ = input.readInt32();
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x40) == 64)
                    this.attrs_ = Collections.unmodifiableList(this.attrs_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MedalHandler.internal_static_pomelo_area_MedalData_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MedalHandler.internal_static_pomelo_area_MedalData_fieldAccessorTable.ensureFieldAccessorsInitialized(MedalData.class, Builder.class);
        }

        public static Parser<MedalData> PARSER = (Parser<MedalData>) new AbstractParser<MedalData>() {
            public MedalHandler.MedalData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MedalHandler.MedalData(input, extensionRegistry);
            }
        };

        private int bitField0_;
        public static final int MEDAL_FIELD_NUMBER = 1;
        private ItemOuterClass.MiniItem medal_;
        public static final int IFMAX_FIELD_NUMBER = 2;
        private int ifMax_;
        public static final int NEEDPRESTIGE_FIELD_NUMBER = 3;
        private int needPrestige_;
        public static final int NEEDGOLD_FIELD_NUMBER = 4;
        private int needGold_;
        public static final int NEEDDIAMOND_FIELD_NUMBER = 5;
        private int needDiamond_;
        public static final int NEXTTITLENAME_FIELD_NUMBER = 6;
        private Object nextTitleName_;
        public static final int ATTRS_FIELD_NUMBER = 7;
        private List<Common.AttributeBase> attrs_;
        public static final int FLAG_FIELD_NUMBER = 8;
        private int flag_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<MedalData> getParserForType() {
            return PARSER;
        }

        public boolean hasMedal() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        private static final MedalData defaultInstance = new MedalData(true);

        public ItemOuterClass.MiniItem getMedal() {
            return this.medal_;
        }

        public ItemOuterClass.MiniItemOrBuilder getMedalOrBuilder() {
            return (ItemOuterClass.MiniItemOrBuilder) this.medal_;
        }

        public boolean hasIfMax() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public int getIfMax() {
            return this.ifMax_;
        }

        public boolean hasNeedPrestige() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getNeedPrestige() {
            return this.needPrestige_;
        }

        public boolean hasNeedGold() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public int getNeedGold() {
            return this.needGold_;
        }

        public boolean hasNeedDiamond() {
            return ((this.bitField0_ & 0x10) == 16);
        }

        public int getNeedDiamond() {
            return this.needDiamond_;
        }

        public boolean hasNextTitleName() {
            return ((this.bitField0_ & 0x20) == 32);
        }

        public String getNextTitleName() {
            Object ref = this.nextTitleName_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.nextTitleName_ = s;
            return s;
        }

        public ByteString getNextTitleNameBytes() {
            Object ref = this.nextTitleName_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.nextTitleName_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public List<Common.AttributeBase> getAttrsList() {
            return this.attrs_;
        }

        public List<? extends Common.AttributeBaseOrBuilder> getAttrsOrBuilderList() {
            return (List) this.attrs_;
        }

        public int getAttrsCount() {
            return this.attrs_.size();
        }

        public Common.AttributeBase getAttrs(int index) {
            return this.attrs_.get(index);
        }

        public Common.AttributeBaseOrBuilder getAttrsOrBuilder(int index) {
            return (Common.AttributeBaseOrBuilder) this.attrs_.get(index);
        }

        public boolean hasFlag() {
            return ((this.bitField0_ & 0x40) == 64);
        }

        public int getFlag() {
            return this.flag_;
        }

        private void initFields() {
            this.medal_ = ItemOuterClass.MiniItem.getDefaultInstance();
            this.ifMax_ = 0;
            this.needPrestige_ = 0;
            this.needGold_ = 0;
            this.needDiamond_ = 0;
            this.nextTitleName_ = "";
            this.attrs_ = Collections.emptyList();
            this.flag_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (hasMedal() && !getMedal().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (int i = 0; i < getAttrsCount(); i++) {
                if (!getAttrs(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeMessage(1, (MessageLite) this.medal_);
            if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.ifMax_);
            if ((this.bitField0_ & 0x4) == 4) output.writeInt32(3, this.needPrestige_);
            if ((this.bitField0_ & 0x8) == 8) output.writeInt32(4, this.needGold_);
            if ((this.bitField0_ & 0x10) == 16) output.writeInt32(5, this.needDiamond_);
            if ((this.bitField0_ & 0x20) == 32) output.writeBytes(6, getNextTitleNameBytes());
            for (int i = 0; i < this.attrs_.size(); i++) output.writeMessage(7, (MessageLite) this.attrs_.get(i));
            if ((this.bitField0_ & 0x40) == 64) output.writeInt32(8, this.flag_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1)
                size += CodedOutputStream.computeMessageSize(1, (MessageLite) this.medal_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(2, this.ifMax_);
            if ((this.bitField0_ & 0x4) == 4) size += CodedOutputStream.computeInt32Size(3, this.needPrestige_);
            if ((this.bitField0_ & 0x8) == 8) size += CodedOutputStream.computeInt32Size(4, this.needGold_);
            if ((this.bitField0_ & 0x10) == 16) size += CodedOutputStream.computeInt32Size(5, this.needDiamond_);
            if ((this.bitField0_ & 0x20) == 32) size += CodedOutputStream.computeBytesSize(6, getNextTitleNameBytes());
            for (int i = 0; i < this.attrs_.size(); i++)
                size += CodedOutputStream.computeMessageSize(7, (MessageLite) this.attrs_.get(i));
            if ((this.bitField0_ & 0x40) == 64) size += CodedOutputStream.computeInt32Size(8, this.flag_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static MedalData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (MedalData) PARSER.parseFrom(data);
        }

        public static MedalData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MedalData) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MedalData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (MedalData) PARSER.parseFrom(data);
        }

        public static MedalData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MedalData) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MedalData parseFrom(InputStream input) throws IOException {
            return (MedalData) PARSER.parseFrom(input);
        }

        public static MedalData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MedalData) PARSER.parseFrom(input, extensionRegistry);
        }

        public static MedalData parseDelimitedFrom(InputStream input) throws IOException {
            return (MedalData) PARSER.parseDelimitedFrom(input);
        }

        public static MedalData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MedalData) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static MedalData parseFrom(CodedInputStream input) throws IOException {
            return (MedalData) PARSER.parseFrom(input);
        }

        public static MedalData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MedalData) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        static {
            defaultInstance.initFields();
        }

        public static Builder newBuilder(MedalData prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements MedalHandler.MedalDataOrBuilder {
            private int bitField0_;
            private ItemOuterClass.MiniItem medal_;
            private SingleFieldBuilder<ItemOuterClass.MiniItem, ItemOuterClass.MiniItem.Builder, ItemOuterClass.MiniItemOrBuilder> medalBuilder_;
            private int ifMax_;
            private int needPrestige_;
            private int needGold_;
            private int needDiamond_;
            private Object nextTitleName_;
            private List<Common.AttributeBase> attrs_;
            private RepeatedFieldBuilder<Common.AttributeBase, Common.AttributeBase.Builder, Common.AttributeBaseOrBuilder> attrsBuilder_;
            private int flag_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MedalHandler.internal_static_pomelo_area_MedalData_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MedalHandler.internal_static_pomelo_area_MedalData_fieldAccessorTable.ensureFieldAccessorsInitialized(MedalHandler.MedalData.class, Builder.class);
            }

            private Builder() {
                this.medal_ = ItemOuterClass.MiniItem.getDefaultInstance();
                this.nextTitleName_ = "";
                this.attrs_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.medal_ = ItemOuterClass.MiniItem.getDefaultInstance();
                this.nextTitleName_ = "";
                this.attrs_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MedalHandler.MedalData.alwaysUseFieldBuilders) {
                    getMedalFieldBuilder();
                    getAttrsFieldBuilder();
                }
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                if (this.medalBuilder_ == null) {
                    this.medal_ = ItemOuterClass.MiniItem.getDefaultInstance();
                } else {
                    this.medalBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFE;
                this.ifMax_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                this.needPrestige_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.needGold_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                this.needDiamond_ = 0;
                this.bitField0_ &= 0xFFFFFFEF;
                this.nextTitleName_ = "";
                this.bitField0_ &= 0xFFFFFFDF;
                if (this.attrsBuilder_ == null) {
                    this.attrs_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFBF;
                } else {
                    this.attrsBuilder_.clear();
                }
                this.flag_ = 0;
                this.bitField0_ &= 0xFFFFFF7F;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return MedalHandler.internal_static_pomelo_area_MedalData_descriptor;
            }

            public MedalHandler.MedalData getDefaultInstanceForType() {
                return MedalHandler.MedalData.getDefaultInstance();
            }

            public MedalHandler.MedalData build() {
                MedalHandler.MedalData result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public MedalHandler.MedalData buildPartial() {
                MedalHandler.MedalData result = new MedalHandler.MedalData(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                if (this.medalBuilder_ == null) {
                    result.medal_ = this.medal_;
                } else {
                    result.medal_ = (ItemOuterClass.MiniItem) this.medalBuilder_.build();
                }
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.ifMax_ = this.ifMax_;
                if ((from_bitField0_ & 0x4) == 4)
                    to_bitField0_ |= 0x4;
                result.needPrestige_ = this.needPrestige_;
                if ((from_bitField0_ & 0x8) == 8)
                    to_bitField0_ |= 0x8;
                result.needGold_ = this.needGold_;
                if ((from_bitField0_ & 0x10) == 16)
                    to_bitField0_ |= 0x10;
                result.needDiamond_ = this.needDiamond_;
                if ((from_bitField0_ & 0x20) == 32)
                    to_bitField0_ |= 0x20;
                result.nextTitleName_ = this.nextTitleName_;
                if (this.attrsBuilder_ == null) {
                    if ((this.bitField0_ & 0x40) == 64) {
                        this.attrs_ = Collections.unmodifiableList(this.attrs_);
                        this.bitField0_ &= 0xFFFFFFBF;
                    }
                    result.attrs_ = this.attrs_;
                } else {
                    result.attrs_ = this.attrsBuilder_.build();
                }
                if ((from_bitField0_ & 0x80) == 128)
                    to_bitField0_ |= 0x40;
                result.flag_ = this.flag_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof MedalHandler.MedalData)
                    return mergeFrom((MedalHandler.MedalData) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MedalHandler.MedalData other) {
                if (other == MedalHandler.MedalData.getDefaultInstance())
                    return this;
                if (other.hasMedal())
                    mergeMedal(other.getMedal());
                if (other.hasIfMax())
                    setIfMax(other.getIfMax());
                if (other.hasNeedPrestige())
                    setNeedPrestige(other.getNeedPrestige());
                if (other.hasNeedGold())
                    setNeedGold(other.getNeedGold());
                if (other.hasNeedDiamond())
                    setNeedDiamond(other.getNeedDiamond());
                if (other.hasNextTitleName()) {
                    this.bitField0_ |= 0x20;
                    this.nextTitleName_ = other.nextTitleName_;
                    onChanged();
                }
                if (this.attrsBuilder_ == null) {
                    if (!other.attrs_.isEmpty()) {
                        if (this.attrs_.isEmpty()) {
                            this.attrs_ = other.attrs_;
                            this.bitField0_ &= 0xFFFFFFBF;
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
                        this.bitField0_ &= 0xFFFFFFBF;
                        this.attrsBuilder_ = MedalHandler.MedalData.alwaysUseFieldBuilders ? getAttrsFieldBuilder() : null;
                    } else {
                        this.attrsBuilder_.addAllMessages(other.attrs_);
                    }
                }
                if (other.hasFlag())
                    setFlag(other.getFlag());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (hasMedal() && !getMedal().isInitialized())
                    return false;
                for (int i = 0; i < getAttrsCount(); i++) {
                    if (!getAttrs(i).isInitialized())
                        return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                MedalHandler.MedalData parsedMessage = null;
                try {
                    parsedMessage = (MedalHandler.MedalData) MedalHandler.MedalData.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MedalHandler.MedalData) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null)
                        mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasMedal() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public ItemOuterClass.MiniItem getMedal() {
                if (this.medalBuilder_ == null)
                    return this.medal_;
                return (ItemOuterClass.MiniItem) this.medalBuilder_.getMessage();
            }

            public Builder setMedal(ItemOuterClass.MiniItem value) {
                if (this.medalBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    this.medal_ = value;
                    onChanged();
                } else {
                    this.medalBuilder_.setMessage((GeneratedMessage) value);
                }
                this.bitField0_ |= 0x1;
                return this;
            }

            public Builder setMedal(ItemOuterClass.MiniItem.Builder builderForValue) {
                if (this.medalBuilder_ == null) {
                    this.medal_ = builderForValue.build();
                    onChanged();
                } else {
                    this.medalBuilder_.setMessage((GeneratedMessage) builderForValue.build());
                }
                this.bitField0_ |= 0x1;
                return this;
            }

            public Builder mergeMedal(ItemOuterClass.MiniItem value) {
                if (this.medalBuilder_ == null) {
                    if ((this.bitField0_ & 0x1) == 1 && this.medal_ != ItemOuterClass.MiniItem.getDefaultInstance()) {
                        this.medal_ = ItemOuterClass.MiniItem.newBuilder(this.medal_).mergeFrom(value).buildPartial();
                    } else {
                        this.medal_ = value;
                    }
                    onChanged();
                } else {
                    this.medalBuilder_.mergeFrom((GeneratedMessage) value);
                }
                this.bitField0_ |= 0x1;
                return this;
            }

            public Builder clearMedal() {
                if (this.medalBuilder_ == null) {
                    this.medal_ = ItemOuterClass.MiniItem.getDefaultInstance();
                    onChanged();
                } else {
                    this.medalBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            public ItemOuterClass.MiniItem.Builder getMedalBuilder() {
                this.bitField0_ |= 0x1;
                onChanged();
                return (ItemOuterClass.MiniItem.Builder) getMedalFieldBuilder().getBuilder();
            }

            public ItemOuterClass.MiniItemOrBuilder getMedalOrBuilder() {
                if (this.medalBuilder_ != null)
                    return (ItemOuterClass.MiniItemOrBuilder) this.medalBuilder_.getMessageOrBuilder();
                return (ItemOuterClass.MiniItemOrBuilder) this.medal_;
            }

            private SingleFieldBuilder<ItemOuterClass.MiniItem, ItemOuterClass.MiniItem.Builder, ItemOuterClass.MiniItemOrBuilder> getMedalFieldBuilder() {
                if (this.medalBuilder_ == null) {
                    this.medalBuilder_ = new SingleFieldBuilder((GeneratedMessage) getMedal(), getParentForChildren(), isClean());
                    this.medal_ = null;
                }
                return this.medalBuilder_;
            }

            public boolean hasIfMax() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getIfMax() {
                return this.ifMax_;
            }

            public Builder setIfMax(int value) {
                this.bitField0_ |= 0x2;
                this.ifMax_ = value;
                onChanged();
                return this;
            }

            public Builder clearIfMax() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.ifMax_ = 0;
                onChanged();
                return this;
            }

            public boolean hasNeedPrestige() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public int getNeedPrestige() {
                return this.needPrestige_;
            }

            public Builder setNeedPrestige(int value) {
                this.bitField0_ |= 0x4;
                this.needPrestige_ = value;
                onChanged();
                return this;
            }

            public Builder clearNeedPrestige() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.needPrestige_ = 0;
                onChanged();
                return this;
            }

            public boolean hasNeedGold() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public int getNeedGold() {
                return this.needGold_;
            }

            public Builder setNeedGold(int value) {
                this.bitField0_ |= 0x8;
                this.needGold_ = value;
                onChanged();
                return this;
            }

            public Builder clearNeedGold() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.needGold_ = 0;
                onChanged();
                return this;
            }

            public boolean hasNeedDiamond() {
                return ((this.bitField0_ & 0x10) == 16);
            }

            public int getNeedDiamond() {
                return this.needDiamond_;
            }

            public Builder setNeedDiamond(int value) {
                this.bitField0_ |= 0x10;
                this.needDiamond_ = value;
                onChanged();
                return this;
            }

            public Builder clearNeedDiamond() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.needDiamond_ = 0;
                onChanged();
                return this;
            }

            public boolean hasNextTitleName() {
                return ((this.bitField0_ & 0x20) == 32);
            }

            public String getNextTitleName() {
                Object ref = this.nextTitleName_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.nextTitleName_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getNextTitleNameBytes() {
                Object ref = this.nextTitleName_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.nextTitleName_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setNextTitleName(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x20;
                this.nextTitleName_ = value;
                onChanged();
                return this;
            }

            public Builder clearNextTitleName() {
                this.bitField0_ &= 0xFFFFFFDF;
                this.nextTitleName_ = MedalHandler.MedalData.getDefaultInstance().getNextTitleName();
                onChanged();
                return this;
            }

            public Builder setNextTitleNameBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x20;
                this.nextTitleName_ = value;
                onChanged();
                return this;
            }

            private void ensureAttrsIsMutable() {
                if ((this.bitField0_ & 0x40) != 64) {
                    this.attrs_ = new ArrayList<>(this.attrs_);
                    this.bitField0_ |= 0x40;
                }
            }

            public List<Common.AttributeBase> getAttrsList() {
                if (this.attrsBuilder_ == null)
                    return Collections.unmodifiableList(this.attrs_);
                return this.attrsBuilder_.getMessageList();
            }

            public int getAttrsCount() {
                if (this.attrsBuilder_ == null)
                    return this.attrs_.size();
                return this.attrsBuilder_.getCount();
            }

            public Common.AttributeBase getAttrs(int index) {
                if (this.attrsBuilder_ == null)
                    return this.attrs_.get(index);
                return (Common.AttributeBase) this.attrsBuilder_.getMessage(index);
            }

            public Builder setAttrs(int index, Common.AttributeBase value) {
                if (this.attrsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureAttrsIsMutable();
                    this.attrs_.set(index, value);
                    onChanged();
                } else {
                    this.attrsBuilder_.setMessage(index, (GeneratedMessage) value);
                }
                return this;
            }

            public Builder setAttrs(int index, Common.AttributeBase.Builder builderForValue) {
                if (this.attrsBuilder_ == null) {
                    ensureAttrsIsMutable();
                    this.attrs_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.attrsBuilder_.setMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addAttrs(Common.AttributeBase value) {
                if (this.attrsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureAttrsIsMutable();
                    this.attrs_.add(value);
                    onChanged();
                } else {
                    this.attrsBuilder_.addMessage((GeneratedMessage) value);
                }
                return this;
            }

            public Builder addAttrs(int index, Common.AttributeBase value) {
                if (this.attrsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureAttrsIsMutable();
                    this.attrs_.add(index, value);
                    onChanged();
                } else {
                    this.attrsBuilder_.addMessage(index, (GeneratedMessage) value);
                }
                return this;
            }

            public Builder addAttrs(Common.AttributeBase.Builder builderForValue) {
                if (this.attrsBuilder_ == null) {
                    ensureAttrsIsMutable();
                    this.attrs_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.attrsBuilder_.addMessage((GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addAttrs(int index, Common.AttributeBase.Builder builderForValue) {
                if (this.attrsBuilder_ == null) {
                    ensureAttrsIsMutable();
                    this.attrs_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.attrsBuilder_.addMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addAllAttrs(Iterable<? extends Common.AttributeBase> values) {
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
                    this.bitField0_ &= 0xFFFFFFBF;
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

            public Common.AttributeBase.Builder getAttrsBuilder(int index) {
                return (Common.AttributeBase.Builder) getAttrsFieldBuilder().getBuilder(index);
            }

            public Common.AttributeBaseOrBuilder getAttrsOrBuilder(int index) {
                if (this.attrsBuilder_ == null)
                    return (Common.AttributeBaseOrBuilder) this.attrs_.get(index);
                return (Common.AttributeBaseOrBuilder) this.attrsBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends Common.AttributeBaseOrBuilder> getAttrsOrBuilderList() {
                if (this.attrsBuilder_ != null)
                    return this.attrsBuilder_.getMessageOrBuilderList();
                return (List) Collections.unmodifiableList(this.attrs_);
            }

            public Common.AttributeBase.Builder addAttrsBuilder() {
                return (Common.AttributeBase.Builder) getAttrsFieldBuilder().addBuilder((GeneratedMessage) Common.AttributeBase.getDefaultInstance());
            }

            public Common.AttributeBase.Builder addAttrsBuilder(int index) {
                return (Common.AttributeBase.Builder) getAttrsFieldBuilder().addBuilder(index, (GeneratedMessage) Common.AttributeBase.getDefaultInstance());
            }

            public List<Common.AttributeBase.Builder> getAttrsBuilderList() {
                return getAttrsFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<Common.AttributeBase, Common.AttributeBase.Builder, Common.AttributeBaseOrBuilder> getAttrsFieldBuilder() {
                if (this.attrsBuilder_ == null) {
                    this.attrsBuilder_ = new RepeatedFieldBuilder(this.attrs_, ((this.bitField0_ & 0x40) == 64), getParentForChildren(), isClean());
                    this.attrs_ = null;
                }
                return this.attrsBuilder_;
            }

            public boolean hasFlag() {
                return ((this.bitField0_ & 0x80) == 128);
            }

            public int getFlag() {
                return this.flag_;
            }

            public Builder setFlag(int value) {
                this.bitField0_ |= 0x80;
                this.flag_ = value;
                onChanged();
                return this;
            }

            public Builder clearFlag() {
                this.bitField0_ &= 0xFFFFFF7F;
                this.flag_ = 0;
                onChanged();
                return this;
            }
        }
    }

    public static final class GetMedalInfoRequest extends GeneratedMessage implements GetMedalInfoRequestOrBuilder {
        private static final GetMedalInfoRequest defaultInstance = new GetMedalInfoRequest(true);
        private final UnknownFieldSet unknownFields;

        private GetMedalInfoRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetMedalInfoRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetMedalInfoRequest getDefaultInstance() {
            return defaultInstance;
        }

        public GetMedalInfoRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetMedalInfoRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return MedalHandler.internal_static_pomelo_area_GetMedalInfoRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MedalHandler.internal_static_pomelo_area_GetMedalInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetMedalInfoRequest.class, Builder.class);
        }

        public static Parser<GetMedalInfoRequest> PARSER = (Parser<GetMedalInfoRequest>) new AbstractParser<GetMedalInfoRequest>() {
            public MedalHandler.GetMedalInfoRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MedalHandler.GetMedalInfoRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetMedalInfoRequest> getParserForType() {
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

        public static GetMedalInfoRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetMedalInfoRequest) PARSER.parseFrom(data);
        }

        public static GetMedalInfoRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetMedalInfoRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetMedalInfoRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetMedalInfoRequest) PARSER.parseFrom(data);
        }

        public static GetMedalInfoRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetMedalInfoRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetMedalInfoRequest parseFrom(InputStream input) throws IOException {
            return (GetMedalInfoRequest) PARSER.parseFrom(input);
        }

        public static GetMedalInfoRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetMedalInfoRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static GetMedalInfoRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (GetMedalInfoRequest) PARSER.parseDelimitedFrom(input);
        }

        public static GetMedalInfoRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetMedalInfoRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static GetMedalInfoRequest parseFrom(CodedInputStream input) throws IOException {
            return (GetMedalInfoRequest) PARSER.parseFrom(input);
        }

        public static GetMedalInfoRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetMedalInfoRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(GetMedalInfoRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements MedalHandler.GetMedalInfoRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return MedalHandler.internal_static_pomelo_area_GetMedalInfoRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MedalHandler.internal_static_pomelo_area_GetMedalInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(MedalHandler.GetMedalInfoRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MedalHandler.GetMedalInfoRequest.alwaysUseFieldBuilders) ;
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
                return MedalHandler.internal_static_pomelo_area_GetMedalInfoRequest_descriptor;
            }

            public MedalHandler.GetMedalInfoRequest getDefaultInstanceForType() {
                return MedalHandler.GetMedalInfoRequest.getDefaultInstance();
            }

            public MedalHandler.GetMedalInfoRequest build() {
                MedalHandler.GetMedalInfoRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public MedalHandler.GetMedalInfoRequest buildPartial() {
                MedalHandler.GetMedalInfoRequest result = new MedalHandler.GetMedalInfoRequest(this);
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof MedalHandler.GetMedalInfoRequest)
                    return mergeFrom((MedalHandler.GetMedalInfoRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MedalHandler.GetMedalInfoRequest other) {
                if (other == MedalHandler.GetMedalInfoRequest.getDefaultInstance()) return this;
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                MedalHandler.GetMedalInfoRequest parsedMessage = null;
                try {
                    parsedMessage = (MedalHandler.GetMedalInfoRequest) MedalHandler.GetMedalInfoRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MedalHandler.GetMedalInfoRequest) e.getUnfinishedMessage();
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


    public static final class GetMedalInfoResponse
            extends GeneratedMessage
            implements GetMedalInfoResponseOrBuilder {
        private static final GetMedalInfoResponse defaultInstance = new GetMedalInfoResponse(true);
        private final UnknownFieldSet unknownFields;

        private GetMedalInfoResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetMedalInfoResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetMedalInfoResponse getDefaultInstance() {
            return defaultInstance;
        }

        public GetMedalInfoResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetMedalInfoResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString bs;
                    MedalHandler.MedalData.Builder subBuilder;
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
                            this.s2CData_ = (MedalHandler.MedalData) input.readMessage(MedalHandler.MedalData.PARSER, extensionRegistry);
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
            return MedalHandler.internal_static_pomelo_area_GetMedalInfoResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MedalHandler.internal_static_pomelo_area_GetMedalInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetMedalInfoResponse.class, Builder.class);
        }

        public static Parser<GetMedalInfoResponse> PARSER = (Parser<GetMedalInfoResponse>) new AbstractParser<GetMedalInfoResponse>() {
            public MedalHandler.GetMedalInfoResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MedalHandler.GetMedalInfoResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_DATA_FIELD_NUMBER = 3;
        private MedalHandler.MedalData s2CData_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetMedalInfoResponse> getParserForType() {
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


        public MedalHandler.MedalData getS2CData() {
            return this.s2CData_;
        }


        public MedalHandler.MedalDataOrBuilder getS2CDataOrBuilder() {
            return this.s2CData_;
        }


        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CData_ = MedalHandler.MedalData.getDefaultInstance();
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
            if (hasS2CData() && !getS2CData().isInitialized()) {
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
                output.writeMessage(3, (MessageLite) this.s2CData_);
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
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.s2CData_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static GetMedalInfoResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetMedalInfoResponse) PARSER.parseFrom(data);
        }


        public static GetMedalInfoResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetMedalInfoResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetMedalInfoResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetMedalInfoResponse) PARSER.parseFrom(data);
        }


        public static GetMedalInfoResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetMedalInfoResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetMedalInfoResponse parseFrom(InputStream input) throws IOException {
            return (GetMedalInfoResponse) PARSER.parseFrom(input);
        }


        public static GetMedalInfoResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetMedalInfoResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static GetMedalInfoResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (GetMedalInfoResponse) PARSER.parseDelimitedFrom(input);
        }


        public static GetMedalInfoResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetMedalInfoResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static GetMedalInfoResponse parseFrom(CodedInputStream input) throws IOException {
            return (GetMedalInfoResponse) PARSER.parseFrom(input);
        }


        public static GetMedalInfoResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetMedalInfoResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(GetMedalInfoResponse prototype) {
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
                implements MedalHandler.GetMedalInfoResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private MedalHandler.MedalData s2CData_;
            private SingleFieldBuilder<MedalHandler.MedalData, MedalHandler.MedalData.Builder, MedalHandler.MedalDataOrBuilder> s2CDataBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MedalHandler.internal_static_pomelo_area_GetMedalInfoResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MedalHandler.internal_static_pomelo_area_GetMedalInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(MedalHandler.GetMedalInfoResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.s2CData_ = MedalHandler.MedalData.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CData_ = MedalHandler.MedalData.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MedalHandler.GetMedalInfoResponse.alwaysUseFieldBuilders) {
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
                    this.s2CData_ = MedalHandler.MedalData.getDefaultInstance();
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
                return MedalHandler.internal_static_pomelo_area_GetMedalInfoResponse_descriptor;
            }

            public MedalHandler.GetMedalInfoResponse getDefaultInstanceForType() {
                return MedalHandler.GetMedalInfoResponse.getDefaultInstance();
            }

            public MedalHandler.GetMedalInfoResponse build() {
                MedalHandler.GetMedalInfoResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public MedalHandler.GetMedalInfoResponse buildPartial() {
                MedalHandler.GetMedalInfoResponse result = new MedalHandler.GetMedalInfoResponse(this);
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
                if (this.s2CDataBuilder_ == null) {
                    result.s2CData_ = this.s2CData_;
                } else {
                    result.s2CData_ = (MedalHandler.MedalData) this.s2CDataBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof MedalHandler.GetMedalInfoResponse) {
                    return mergeFrom((MedalHandler.GetMedalInfoResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MedalHandler.GetMedalInfoResponse other) {
                if (other == MedalHandler.GetMedalInfoResponse.getDefaultInstance()) {
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
                if (other.hasS2CData()) {
                    mergeS2CData(other.getS2CData());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode()) {
                    return false;
                }
                if (hasS2CData() && !getS2CData().isInitialized()) {
                    return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                MedalHandler.GetMedalInfoResponse parsedMessage = null;
                try {
                    parsedMessage = (MedalHandler.GetMedalInfoResponse) MedalHandler.GetMedalInfoResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MedalHandler.GetMedalInfoResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = MedalHandler.GetMedalInfoResponse.getDefaultInstance().getS2CMsg();
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

            public boolean hasS2CData() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public MedalHandler.MedalData getS2CData() {
                if (this.s2CDataBuilder_ == null) {
                    return this.s2CData_;
                }
                return (MedalHandler.MedalData) this.s2CDataBuilder_.getMessage();
            }

            public Builder setS2CData(MedalHandler.MedalData value) {
                if (this.s2CDataBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.s2CData_ = value;
                    onChanged();
                } else {
                    this.s2CDataBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder setS2CData(MedalHandler.MedalData.Builder builderForValue) {
                if (this.s2CDataBuilder_ == null) {
                    this.s2CData_ = builderForValue.build();
                    onChanged();
                } else {
                    this.s2CDataBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder mergeS2CData(MedalHandler.MedalData value) {
                if (this.s2CDataBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4 && this.s2CData_ != MedalHandler.MedalData.getDefaultInstance()) {
                        this.s2CData_ = MedalHandler.MedalData.newBuilder(this.s2CData_).mergeFrom(value).buildPartial();
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
                    this.s2CData_ = MedalHandler.MedalData.getDefaultInstance();
                    onChanged();
                } else {
                    this.s2CDataBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public MedalHandler.MedalData.Builder getS2CDataBuilder() {
                this.bitField0_ |= 0x4;
                onChanged();
                return (MedalHandler.MedalData.Builder) getS2CDataFieldBuilder().getBuilder();
            }

            public MedalHandler.MedalDataOrBuilder getS2CDataOrBuilder() {
                if (this.s2CDataBuilder_ != null) {
                    return (MedalHandler.MedalDataOrBuilder) this.s2CDataBuilder_.getMessageOrBuilder();
                }
                return this.s2CData_;
            }

            private SingleFieldBuilder<MedalHandler.MedalData, MedalHandler.MedalData.Builder, MedalHandler.MedalDataOrBuilder> getS2CDataFieldBuilder() {
                if (this.s2CDataBuilder_ == null) {
                    this.s2CDataBuilder_ = new SingleFieldBuilder(getS2CData(), getParentForChildren(), isClean());
                    this.s2CData_ = null;
                }
                return this.s2CDataBuilder_;
            }
        }
    }

    public static final class GainMedalRequest
            extends GeneratedMessage
            implements GainMedalRequestOrBuilder {
        private static final GainMedalRequest defaultInstance = new GainMedalRequest(true);
        private final UnknownFieldSet unknownFields;

        private GainMedalRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GainMedalRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GainMedalRequest getDefaultInstance() {
            return defaultInstance;
        }

        public GainMedalRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GainMedalRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return MedalHandler.internal_static_pomelo_area_GainMedalRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MedalHandler.internal_static_pomelo_area_GainMedalRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GainMedalRequest.class, Builder.class);
        }

        public static Parser<GainMedalRequest> PARSER = (Parser<GainMedalRequest>) new AbstractParser<GainMedalRequest>() {
            public MedalHandler.GainMedalRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MedalHandler.GainMedalRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_ID_FIELD_NUMBER = 1;
        private Object c2SId_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GainMedalRequest> getParserForType() {
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

        static {
            defaultInstance.initFields();
        }


        private void initFields() {
            this.c2SId_ = "";
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
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeBytes(1, getC2SIdBytes());
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
                size += CodedOutputStream.computeBytesSize(1, getC2SIdBytes());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static GainMedalRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GainMedalRequest) PARSER.parseFrom(data);
        }


        public static GainMedalRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GainMedalRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GainMedalRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GainMedalRequest) PARSER.parseFrom(data);
        }


        public static GainMedalRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GainMedalRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GainMedalRequest parseFrom(InputStream input) throws IOException {
            return (GainMedalRequest) PARSER.parseFrom(input);
        }


        public static GainMedalRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GainMedalRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static GainMedalRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (GainMedalRequest) PARSER.parseDelimitedFrom(input);
        }


        public static GainMedalRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GainMedalRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static GainMedalRequest parseFrom(CodedInputStream input) throws IOException {
            return (GainMedalRequest) PARSER.parseFrom(input);
        }


        public static GainMedalRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GainMedalRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(GainMedalRequest prototype) {
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
                implements MedalHandler.GainMedalRequestOrBuilder {
            private int bitField0_;


            private Object c2SId_;


            public static final Descriptors.Descriptor getDescriptor() {
                return MedalHandler.internal_static_pomelo_area_GainMedalRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MedalHandler.internal_static_pomelo_area_GainMedalRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(MedalHandler.GainMedalRequest.class, Builder.class);
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
                if (MedalHandler.GainMedalRequest.alwaysUseFieldBuilders) ;
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
                return MedalHandler.internal_static_pomelo_area_GainMedalRequest_descriptor;
            }


            public MedalHandler.GainMedalRequest getDefaultInstanceForType() {
                return MedalHandler.GainMedalRequest.getDefaultInstance();
            }


            public MedalHandler.GainMedalRequest build() {
                MedalHandler.GainMedalRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public MedalHandler.GainMedalRequest buildPartial() {
                MedalHandler.GainMedalRequest result = new MedalHandler.GainMedalRequest(this);
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
                if (other instanceof MedalHandler.GainMedalRequest) {
                    return mergeFrom((MedalHandler.GainMedalRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(MedalHandler.GainMedalRequest other) {
                if (other == MedalHandler.GainMedalRequest.getDefaultInstance()) {
                    return this;
                }
                if (other.hasC2SId()) {
                    this.bitField0_ |= 0x1;
                    this.c2SId_ = other.c2SId_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasC2SId()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                MedalHandler.GainMedalRequest parsedMessage = null;
                try {
                    parsedMessage = (MedalHandler.GainMedalRequest) MedalHandler.GainMedalRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MedalHandler.GainMedalRequest) e.getUnfinishedMessage();
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


            public String getC2SId() {
                Object ref = this.c2SId_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.c2SId_ = s;
                    }
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
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x1;
                this.c2SId_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SId_ = MedalHandler.GainMedalRequest.getDefaultInstance().getC2SId();
                onChanged();
                return this;
            }


            public Builder setC2SIdBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x1;
                this.c2SId_ = value;
                onChanged();
                return this;
            }
        }
    }


    public static final class GainMedalResponse
            extends GeneratedMessage
            implements GainMedalResponseOrBuilder {
        private static final GainMedalResponse defaultInstance = new GainMedalResponse(true);
        private final UnknownFieldSet unknownFields;

        private GainMedalResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GainMedalResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GainMedalResponse getDefaultInstance() {
            return defaultInstance;
        }

        public GainMedalResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GainMedalResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return MedalHandler.internal_static_pomelo_area_GainMedalResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MedalHandler.internal_static_pomelo_area_GainMedalResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GainMedalResponse.class, Builder.class);
        }

        public static Parser<GainMedalResponse> PARSER = (Parser<GainMedalResponse>) new AbstractParser<GainMedalResponse>() {
            public MedalHandler.GainMedalResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MedalHandler.GainMedalResponse(input, extensionRegistry);
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

        public Parser<GainMedalResponse> getParserForType() {
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

        public static GainMedalResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GainMedalResponse) PARSER.parseFrom(data);
        }

        public static GainMedalResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GainMedalResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GainMedalResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GainMedalResponse) PARSER.parseFrom(data);
        }

        public static GainMedalResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GainMedalResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GainMedalResponse parseFrom(InputStream input) throws IOException {
            return (GainMedalResponse) PARSER.parseFrom(input);
        }

        public static GainMedalResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GainMedalResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static GainMedalResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (GainMedalResponse) PARSER.parseDelimitedFrom(input);
        }

        public static GainMedalResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GainMedalResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static GainMedalResponse parseFrom(CodedInputStream input) throws IOException {
            return (GainMedalResponse) PARSER.parseFrom(input);
        }

        public static GainMedalResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GainMedalResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(GainMedalResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements MedalHandler.GainMedalResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MedalHandler.internal_static_pomelo_area_GainMedalResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MedalHandler.internal_static_pomelo_area_GainMedalResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(MedalHandler.GainMedalResponse.class, Builder.class);
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
                if (MedalHandler.GainMedalResponse.alwaysUseFieldBuilders) ;
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
                return MedalHandler.internal_static_pomelo_area_GainMedalResponse_descriptor;
            }

            public MedalHandler.GainMedalResponse getDefaultInstanceForType() {
                return MedalHandler.GainMedalResponse.getDefaultInstance();
            }

            public MedalHandler.GainMedalResponse build() {
                MedalHandler.GainMedalResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public MedalHandler.GainMedalResponse buildPartial() {
                MedalHandler.GainMedalResponse result = new MedalHandler.GainMedalResponse(this);
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
                if (other instanceof MedalHandler.GainMedalResponse)
                    return mergeFrom((MedalHandler.GainMedalResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MedalHandler.GainMedalResponse other) {
                if (other == MedalHandler.GainMedalResponse.getDefaultInstance())
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
                MedalHandler.GainMedalResponse parsedMessage = null;
                try {
                    parsedMessage = (MedalHandler.GainMedalResponse) MedalHandler.GainMedalResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MedalHandler.GainMedalResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = MedalHandler.GainMedalResponse.getDefaultInstance().getS2CMsg();
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

    public static final class MedalListRequest extends GeneratedMessage implements MedalListRequestOrBuilder {
        private static final MedalListRequest defaultInstance = new MedalListRequest(true);
        private final UnknownFieldSet unknownFields;

        private MedalListRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private MedalListRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static MedalListRequest getDefaultInstance() {
            return defaultInstance;
        }

        public MedalListRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MedalListRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return MedalHandler.internal_static_pomelo_area_MedalListRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MedalHandler.internal_static_pomelo_area_MedalListRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(MedalListRequest.class, Builder.class);
        }

        public static Parser<MedalListRequest> PARSER = (Parser<MedalListRequest>) new AbstractParser<MedalListRequest>() {
            public MedalHandler.MedalListRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MedalHandler.MedalListRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<MedalListRequest> getParserForType() {
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

        public static MedalListRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (MedalListRequest) PARSER.parseFrom(data);
        }

        public static MedalListRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MedalListRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MedalListRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (MedalListRequest) PARSER.parseFrom(data);
        }

        public static MedalListRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MedalListRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MedalListRequest parseFrom(InputStream input) throws IOException {
            return (MedalListRequest) PARSER.parseFrom(input);
        }

        public static MedalListRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MedalListRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static MedalListRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (MedalListRequest) PARSER.parseDelimitedFrom(input);
        }

        public static MedalListRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MedalListRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static MedalListRequest parseFrom(CodedInputStream input) throws IOException {
            return (MedalListRequest) PARSER.parseFrom(input);
        }

        public static MedalListRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MedalListRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(MedalListRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements MedalHandler.MedalListRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return MedalHandler.internal_static_pomelo_area_MedalListRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MedalHandler.internal_static_pomelo_area_MedalListRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(MedalHandler.MedalListRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MedalHandler.MedalListRequest.alwaysUseFieldBuilders) ;
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
                return MedalHandler.internal_static_pomelo_area_MedalListRequest_descriptor;
            }

            public MedalHandler.MedalListRequest getDefaultInstanceForType() {
                return MedalHandler.MedalListRequest.getDefaultInstance();
            }

            public MedalHandler.MedalListRequest build() {
                MedalHandler.MedalListRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public MedalHandler.MedalListRequest buildPartial() {
                MedalHandler.MedalListRequest result = new MedalHandler.MedalListRequest(this);
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof MedalHandler.MedalListRequest)
                    return mergeFrom((MedalHandler.MedalListRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MedalHandler.MedalListRequest other) {
                if (other == MedalHandler.MedalListRequest.getDefaultInstance()) return this;
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                MedalHandler.MedalListRequest parsedMessage = null;
                try {
                    parsedMessage = (MedalHandler.MedalListRequest) MedalHandler.MedalListRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MedalHandler.MedalListRequest) e.getUnfinishedMessage();
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


    public static final class MedalListInfo
            extends GeneratedMessage
            implements MedalListInfoOrBuilder {
        private final UnknownFieldSet unknownFields;


        private MedalListInfo(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }


        private MedalListInfo(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }


        public static MedalListInfo getDefaultInstance() {
            return defaultInstance;
        }


        public MedalListInfo getDefaultInstanceForType() {
            return defaultInstance;
        }


        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }


        private MedalListInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ItemOuterClass.MiniItem.Builder subBuilder;
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        case 10:
                            subBuilder = null;
                            if ((this.bitField0_ & 0x1) == 1) {
                                subBuilder = this.medal_.toBuilder();
                            }
                            this.medal_ = (ItemOuterClass.MiniItem) input.readMessage(ItemOuterClass.MiniItem.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.medal_);
                                this.medal_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 0x1;
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.isGet_ = input.readInt32();
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
            return MedalHandler.internal_static_pomelo_area_MedalListInfo_descriptor;
        }


        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MedalHandler.internal_static_pomelo_area_MedalListInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(MedalListInfo.class, Builder.class);
        }


        public static Parser<MedalListInfo> PARSER = (Parser<MedalListInfo>) new AbstractParser<MedalListInfo>() {
            public MedalHandler.MedalListInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MedalHandler.MedalListInfo(input, extensionRegistry);
            }
        };


        private int bitField0_;


        public static final int MEDAL_FIELD_NUMBER = 1;


        private ItemOuterClass.MiniItem medal_;


        public static final int ISGET_FIELD_NUMBER = 2;


        private int isGet_;


        private byte memoizedIsInitialized;


        private int memoizedSerializedSize;


        private static final long serialVersionUID = 0L;


        public Parser<MedalListInfo> getParserForType() {
            return PARSER;
        }


        public boolean hasMedal() {
            return ((this.bitField0_ & 0x1) == 1);
        }


        public ItemOuterClass.MiniItem getMedal() {
            return this.medal_;
        }


        public ItemOuterClass.MiniItemOrBuilder getMedalOrBuilder() {
            return (ItemOuterClass.MiniItemOrBuilder) this.medal_;
        }


        public boolean hasIsGet() {
            return ((this.bitField0_ & 0x2) == 2);
        }


        public int getIsGet() {
            return this.isGet_;
        }


        private void initFields() {
            this.medal_ = ItemOuterClass.MiniItem.getDefaultInstance();
            this.isGet_ = 0;
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasMedal()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasIsGet()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!getMedal().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeMessage(1, (MessageLite) this.medal_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeInt32(2, this.isGet_);
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
                size += CodedOutputStream.computeMessageSize(1, (MessageLite) this.medal_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeInt32Size(2, this.isGet_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static MedalListInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (MedalListInfo) PARSER.parseFrom(data);
        }


        public static MedalListInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MedalListInfo) PARSER.parseFrom(data, extensionRegistry);
        }


        public static MedalListInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (MedalListInfo) PARSER.parseFrom(data);
        }


        public static MedalListInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MedalListInfo) PARSER.parseFrom(data, extensionRegistry);
        }


        public static MedalListInfo parseFrom(InputStream input) throws IOException {
            return (MedalListInfo) PARSER.parseFrom(input);
        }


        private static final MedalListInfo defaultInstance = new MedalListInfo(true);

        public static MedalListInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MedalListInfo) PARSER.parseFrom(input, extensionRegistry);
        }

        public static MedalListInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (MedalListInfo) PARSER.parseDelimitedFrom(input);
        }

        public static MedalListInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MedalListInfo) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static MedalListInfo parseFrom(CodedInputStream input) throws IOException {
            return (MedalListInfo) PARSER.parseFrom(input);
        }

        public static MedalListInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MedalListInfo) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(MedalListInfo prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements MedalHandler.MedalListInfoOrBuilder {
            private int bitField0_;
            private ItemOuterClass.MiniItem medal_;
            private SingleFieldBuilder<ItemOuterClass.MiniItem, ItemOuterClass.MiniItem.Builder, ItemOuterClass.MiniItemOrBuilder> medalBuilder_;
            private int isGet_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MedalHandler.internal_static_pomelo_area_MedalListInfo_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MedalHandler.internal_static_pomelo_area_MedalListInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(MedalHandler.MedalListInfo.class, Builder.class);
            }

            private Builder() {
                this.medal_ = ItemOuterClass.MiniItem.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.medal_ = ItemOuterClass.MiniItem.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MedalHandler.MedalListInfo.alwaysUseFieldBuilders) getMedalFieldBuilder();
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                if (this.medalBuilder_ == null) {
                    this.medal_ = ItemOuterClass.MiniItem.getDefaultInstance();
                } else {
                    this.medalBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFE;
                this.isGet_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return MedalHandler.internal_static_pomelo_area_MedalListInfo_descriptor;
            }

            public MedalHandler.MedalListInfo getDefaultInstanceForType() {
                return MedalHandler.MedalListInfo.getDefaultInstance();
            }

            public MedalHandler.MedalListInfo build() {
                MedalHandler.MedalListInfo result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public MedalHandler.MedalListInfo buildPartial() {
                MedalHandler.MedalListInfo result = new MedalHandler.MedalListInfo(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                if (this.medalBuilder_ == null) {
                    result.medal_ = this.medal_;
                } else {
                    result.medal_ = (ItemOuterClass.MiniItem) this.medalBuilder_.build();
                }
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.isGet_ = this.isGet_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof MedalHandler.MedalListInfo) return mergeFrom((MedalHandler.MedalListInfo) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MedalHandler.MedalListInfo other) {
                if (other == MedalHandler.MedalListInfo.getDefaultInstance()) return this;
                if (other.hasMedal()) mergeMedal(other.getMedal());
                if (other.hasIsGet()) setIsGet(other.getIsGet());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasMedal()) return false;
                if (!hasIsGet()) return false;
                if (!getMedal().isInitialized()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                MedalHandler.MedalListInfo parsedMessage = null;
                try {
                    parsedMessage = (MedalHandler.MedalListInfo) MedalHandler.MedalListInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MedalHandler.MedalListInfo) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasMedal() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public ItemOuterClass.MiniItem getMedal() {
                if (this.medalBuilder_ == null) return this.medal_;
                return (ItemOuterClass.MiniItem) this.medalBuilder_.getMessage();
            }

            public Builder setMedal(ItemOuterClass.MiniItem value) {
                if (this.medalBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    this.medal_ = value;
                    onChanged();
                } else {
                    this.medalBuilder_.setMessage((GeneratedMessage) value);
                }
                this.bitField0_ |= 0x1;
                return this;
            }

            public Builder setMedal(ItemOuterClass.MiniItem.Builder builderForValue) {
                if (this.medalBuilder_ == null) {
                    this.medal_ = builderForValue.build();
                    onChanged();
                } else {
                    this.medalBuilder_.setMessage((GeneratedMessage) builderForValue.build());
                }
                this.bitField0_ |= 0x1;
                return this;
            }

            public Builder mergeMedal(ItemOuterClass.MiniItem value) {
                if (this.medalBuilder_ == null) {
                    if ((this.bitField0_ & 0x1) == 1 && this.medal_ != ItemOuterClass.MiniItem.getDefaultInstance()) {
                        this.medal_ = ItemOuterClass.MiniItem.newBuilder(this.medal_).mergeFrom(value).buildPartial();
                    } else {
                        this.medal_ = value;
                    }
                    onChanged();
                } else {
                    this.medalBuilder_.mergeFrom((GeneratedMessage) value);
                }
                this.bitField0_ |= 0x1;
                return this;
            }

            public Builder clearMedal() {
                if (this.medalBuilder_ == null) {
                    this.medal_ = ItemOuterClass.MiniItem.getDefaultInstance();
                    onChanged();
                } else {
                    this.medalBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            public ItemOuterClass.MiniItem.Builder getMedalBuilder() {
                this.bitField0_ |= 0x1;
                onChanged();
                return (ItemOuterClass.MiniItem.Builder) getMedalFieldBuilder().getBuilder();
            }

            public ItemOuterClass.MiniItemOrBuilder getMedalOrBuilder() {
                if (this.medalBuilder_ != null)
                    return (ItemOuterClass.MiniItemOrBuilder) this.medalBuilder_.getMessageOrBuilder();
                return (ItemOuterClass.MiniItemOrBuilder) this.medal_;
            }

            private SingleFieldBuilder<ItemOuterClass.MiniItem, ItemOuterClass.MiniItem.Builder, ItemOuterClass.MiniItemOrBuilder> getMedalFieldBuilder() {
                if (this.medalBuilder_ == null) {
                    this.medalBuilder_ = new SingleFieldBuilder((GeneratedMessage) getMedal(), getParentForChildren(), isClean());
                    this.medal_ = null;
                }
                return this.medalBuilder_;
            }

            public boolean hasIsGet() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getIsGet() {
                return this.isGet_;
            }

            public Builder setIsGet(int value) {
                this.bitField0_ |= 0x2;
                this.isGet_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsGet() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.isGet_ = 0;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class MedalListResponse
            extends GeneratedMessage
            implements MedalListResponseOrBuilder {
        private static final MedalListResponse defaultInstance = new MedalListResponse(true);
        private final UnknownFieldSet unknownFields;

        private MedalListResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private MedalListResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static MedalListResponse getDefaultInstance() {
            return defaultInstance;
        }

        public MedalListResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MedalListResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.s2CData_.add(input.readMessage(MedalHandler.MedalListInfo.PARSER, extensionRegistry));
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
            return MedalHandler.internal_static_pomelo_area_MedalListResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MedalHandler.internal_static_pomelo_area_MedalListResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(MedalListResponse.class, Builder.class);
        }

        public static Parser<MedalListResponse> PARSER = (Parser<MedalListResponse>) new AbstractParser<MedalListResponse>() {
            public MedalHandler.MedalListResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MedalHandler.MedalListResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_DATA_FIELD_NUMBER = 3;
        private List<MedalHandler.MedalListInfo> s2CData_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<MedalListResponse> getParserForType() {
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

        public List<MedalHandler.MedalListInfo> getS2CDataList() {
            return this.s2CData_;
        }

        public List<? extends MedalHandler.MedalListInfoOrBuilder> getS2CDataOrBuilderList() {
            return (List) this.s2CData_;
        }

        public int getS2CDataCount() {
            return this.s2CData_.size();
        }

        public MedalHandler.MedalListInfo getS2CData(int index) {
            return this.s2CData_.get(index);
        }

        public MedalHandler.MedalListInfoOrBuilder getS2CDataOrBuilder(int index) {
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

        public static MedalListResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (MedalListResponse) PARSER.parseFrom(data);
        }

        public static MedalListResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MedalListResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MedalListResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (MedalListResponse) PARSER.parseFrom(data);
        }

        public static MedalListResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MedalListResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MedalListResponse parseFrom(InputStream input) throws IOException {
            return (MedalListResponse) PARSER.parseFrom(input);
        }

        public static MedalListResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MedalListResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static MedalListResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (MedalListResponse) PARSER.parseDelimitedFrom(input);
        }

        public static MedalListResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MedalListResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static MedalListResponse parseFrom(CodedInputStream input) throws IOException {
            return (MedalListResponse) PARSER.parseFrom(input);
        }

        public static MedalListResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MedalListResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(MedalListResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements MedalHandler.MedalListResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private List<MedalHandler.MedalListInfo> s2CData_;
            private RepeatedFieldBuilder<MedalHandler.MedalListInfo, MedalHandler.MedalListInfo.Builder, MedalHandler.MedalListInfoOrBuilder> s2CDataBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MedalHandler.internal_static_pomelo_area_MedalListResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MedalHandler.internal_static_pomelo_area_MedalListResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(MedalHandler.MedalListResponse.class, Builder.class);
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
                if (MedalHandler.MedalListResponse.alwaysUseFieldBuilders)
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
                return MedalHandler.internal_static_pomelo_area_MedalListResponse_descriptor;
            }

            public MedalHandler.MedalListResponse getDefaultInstanceForType() {
                return MedalHandler.MedalListResponse.getDefaultInstance();
            }

            public MedalHandler.MedalListResponse build() {
                MedalHandler.MedalListResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public MedalHandler.MedalListResponse buildPartial() {
                MedalHandler.MedalListResponse result = new MedalHandler.MedalListResponse(this);
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
                if (other instanceof MedalHandler.MedalListResponse)
                    return mergeFrom((MedalHandler.MedalListResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MedalHandler.MedalListResponse other) {
                if (other == MedalHandler.MedalListResponse.getDefaultInstance())
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
                        this.s2CDataBuilder_ = MedalHandler.MedalListResponse.alwaysUseFieldBuilders ? getS2CDataFieldBuilder() : null;
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
                MedalHandler.MedalListResponse parsedMessage = null;
                try {
                    parsedMessage = (MedalHandler.MedalListResponse) MedalHandler.MedalListResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MedalHandler.MedalListResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = MedalHandler.MedalListResponse.getDefaultInstance().getS2CMsg();
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

            public List<MedalHandler.MedalListInfo> getS2CDataList() {
                if (this.s2CDataBuilder_ == null)
                    return Collections.unmodifiableList(this.s2CData_);
                return this.s2CDataBuilder_.getMessageList();
            }

            public int getS2CDataCount() {
                if (this.s2CDataBuilder_ == null)
                    return this.s2CData_.size();
                return this.s2CDataBuilder_.getCount();
            }

            public MedalHandler.MedalListInfo getS2CData(int index) {
                if (this.s2CDataBuilder_ == null)
                    return this.s2CData_.get(index);
                return (MedalHandler.MedalListInfo) this.s2CDataBuilder_.getMessage(index);
            }

            public Builder setS2CData(int index, MedalHandler.MedalListInfo value) {
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

            public Builder setS2CData(int index, MedalHandler.MedalListInfo.Builder builderForValue) {
                if (this.s2CDataBuilder_ == null) {
                    ensureS2CDataIsMutable();
                    this.s2CData_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CDataBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addS2CData(MedalHandler.MedalListInfo value) {
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

            public Builder addS2CData(int index, MedalHandler.MedalListInfo value) {
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

            public Builder addS2CData(MedalHandler.MedalListInfo.Builder builderForValue) {
                if (this.s2CDataBuilder_ == null) {
                    ensureS2CDataIsMutable();
                    this.s2CData_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.s2CDataBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addS2CData(int index, MedalHandler.MedalListInfo.Builder builderForValue) {
                if (this.s2CDataBuilder_ == null) {
                    ensureS2CDataIsMutable();
                    this.s2CData_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CDataBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllS2CData(Iterable<? extends MedalHandler.MedalListInfo> values) {
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

            public MedalHandler.MedalListInfo.Builder getS2CDataBuilder(int index) {
                return (MedalHandler.MedalListInfo.Builder) getS2CDataFieldBuilder().getBuilder(index);
            }

            public MedalHandler.MedalListInfoOrBuilder getS2CDataOrBuilder(int index) {
                if (this.s2CDataBuilder_ == null)
                    return this.s2CData_.get(index);
                return (MedalHandler.MedalListInfoOrBuilder) this.s2CDataBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends MedalHandler.MedalListInfoOrBuilder> getS2CDataOrBuilderList() {
                if (this.s2CDataBuilder_ != null)
                    return this.s2CDataBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.s2CData_);
            }

            public MedalHandler.MedalListInfo.Builder addS2CDataBuilder() {
                return (MedalHandler.MedalListInfo.Builder) getS2CDataFieldBuilder().addBuilder(MedalHandler.MedalListInfo.getDefaultInstance());
            }

            public MedalHandler.MedalListInfo.Builder addS2CDataBuilder(int index) {
                return (MedalHandler.MedalListInfo.Builder) getS2CDataFieldBuilder().addBuilder(index, MedalHandler.MedalListInfo.getDefaultInstance());
            }

            public List<MedalHandler.MedalListInfo.Builder> getS2CDataBuilderList() {
                return getS2CDataFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<MedalHandler.MedalListInfo, MedalHandler.MedalListInfo.Builder, MedalHandler.MedalListInfoOrBuilder> getS2CDataFieldBuilder() {
                if (this.s2CDataBuilder_ == null) {
                    this.s2CDataBuilder_ = new RepeatedFieldBuilder(this.s2CData_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
                    this.s2CData_ = null;
                }
                return this.s2CDataBuilder_;
            }
        }
    }

    public static final class GetMedalInfoByCodeRequest extends GeneratedMessage implements GetMedalInfoByCodeRequestOrBuilder {
        private static final GetMedalInfoByCodeRequest defaultInstance = new GetMedalInfoByCodeRequest(true);
        private final UnknownFieldSet unknownFields;

        private GetMedalInfoByCodeRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetMedalInfoByCodeRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetMedalInfoByCodeRequest getDefaultInstance() {
            return defaultInstance;
        }

        public GetMedalInfoByCodeRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetMedalInfoByCodeRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.c2SCode_ = bs;
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
            return MedalHandler.internal_static_pomelo_area_GetMedalInfoByCodeRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MedalHandler.internal_static_pomelo_area_GetMedalInfoByCodeRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetMedalInfoByCodeRequest.class, Builder.class);
        }

        public static Parser<GetMedalInfoByCodeRequest> PARSER = (Parser<GetMedalInfoByCodeRequest>) new AbstractParser<GetMedalInfoByCodeRequest>() {
            public MedalHandler.GetMedalInfoByCodeRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MedalHandler.GetMedalInfoByCodeRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_CODE_FIELD_NUMBER = 1;
        private Object c2SCode_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetMedalInfoByCodeRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasC2SCode() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public String getC2SCode() {
            Object ref = this.c2SCode_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.c2SCode_ = s;
            return s;
        }

        public ByteString getC2SCodeBytes() {
            Object ref = this.c2SCode_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.c2SCode_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        static {
            defaultInstance.initFields();
        }


        private void initFields() {
            this.c2SCode_ = "";
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasC2SCode()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeBytes(1, getC2SCodeBytes());
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
                size += CodedOutputStream.computeBytesSize(1, getC2SCodeBytes());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static GetMedalInfoByCodeRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetMedalInfoByCodeRequest) PARSER.parseFrom(data);
        }


        public static GetMedalInfoByCodeRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetMedalInfoByCodeRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetMedalInfoByCodeRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetMedalInfoByCodeRequest) PARSER.parseFrom(data);
        }


        public static GetMedalInfoByCodeRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetMedalInfoByCodeRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetMedalInfoByCodeRequest parseFrom(InputStream input) throws IOException {
            return (GetMedalInfoByCodeRequest) PARSER.parseFrom(input);
        }


        public static GetMedalInfoByCodeRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetMedalInfoByCodeRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static GetMedalInfoByCodeRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (GetMedalInfoByCodeRequest) PARSER.parseDelimitedFrom(input);
        }


        public static GetMedalInfoByCodeRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetMedalInfoByCodeRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static GetMedalInfoByCodeRequest parseFrom(CodedInputStream input) throws IOException {
            return (GetMedalInfoByCodeRequest) PARSER.parseFrom(input);
        }


        public static GetMedalInfoByCodeRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetMedalInfoByCodeRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(GetMedalInfoByCodeRequest prototype) {
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
                implements MedalHandler.GetMedalInfoByCodeRequestOrBuilder {
            private int bitField0_;


            private Object c2SCode_;


            public static final Descriptors.Descriptor getDescriptor() {
                return MedalHandler.internal_static_pomelo_area_GetMedalInfoByCodeRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MedalHandler.internal_static_pomelo_area_GetMedalInfoByCodeRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(MedalHandler.GetMedalInfoByCodeRequest.class, Builder.class);
            }


            private Builder() {
                this.c2SCode_ = "";
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.c2SCode_ = "";
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (MedalHandler.GetMedalInfoByCodeRequest.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.c2SCode_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return MedalHandler.internal_static_pomelo_area_GetMedalInfoByCodeRequest_descriptor;
            }


            public MedalHandler.GetMedalInfoByCodeRequest getDefaultInstanceForType() {
                return MedalHandler.GetMedalInfoByCodeRequest.getDefaultInstance();
            }


            public MedalHandler.GetMedalInfoByCodeRequest build() {
                MedalHandler.GetMedalInfoByCodeRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public MedalHandler.GetMedalInfoByCodeRequest buildPartial() {
                MedalHandler.GetMedalInfoByCodeRequest result = new MedalHandler.GetMedalInfoByCodeRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.c2SCode_ = this.c2SCode_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof MedalHandler.GetMedalInfoByCodeRequest) {
                    return mergeFrom((MedalHandler.GetMedalInfoByCodeRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(MedalHandler.GetMedalInfoByCodeRequest other) {
                if (other == MedalHandler.GetMedalInfoByCodeRequest.getDefaultInstance()) {
                    return this;
                }
                if (other.hasC2SCode()) {
                    this.bitField0_ |= 0x1;
                    this.c2SCode_ = other.c2SCode_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasC2SCode()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                MedalHandler.GetMedalInfoByCodeRequest parsedMessage = null;
                try {
                    parsedMessage = (MedalHandler.GetMedalInfoByCodeRequest) MedalHandler.GetMedalInfoByCodeRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MedalHandler.GetMedalInfoByCodeRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasC2SCode() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public String getC2SCode() {
                Object ref = this.c2SCode_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.c2SCode_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }


            public ByteString getC2SCodeBytes() {
                Object ref = this.c2SCode_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.c2SCode_ = b;
                    return b;
                }
                return (ByteString) ref;
            }


            public Builder setC2SCode(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x1;
                this.c2SCode_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SCode() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SCode_ = MedalHandler.GetMedalInfoByCodeRequest.getDefaultInstance().getC2SCode();
                onChanged();
                return this;
            }


            public Builder setC2SCodeBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x1;
                this.c2SCode_ = value;
                onChanged();
                return this;
            }
        }
    }


    public static final class GetMedalInfoByCodeResponse
            extends GeneratedMessage
            implements GetMedalInfoByCodeResponseOrBuilder {
        private static final GetMedalInfoByCodeResponse defaultInstance = new GetMedalInfoByCodeResponse(true);
        private final UnknownFieldSet unknownFields;

        private GetMedalInfoByCodeResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetMedalInfoByCodeResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetMedalInfoByCodeResponse getDefaultInstance() {
            return defaultInstance;
        }

        public GetMedalInfoByCodeResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetMedalInfoByCodeResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString bs;
                    MedalHandler.MedalData.Builder subBuilder;
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
                            this.s2CData_ = (MedalHandler.MedalData) input.readMessage(MedalHandler.MedalData.PARSER, extensionRegistry);
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
            return MedalHandler.internal_static_pomelo_area_GetMedalInfoByCodeResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MedalHandler.internal_static_pomelo_area_GetMedalInfoByCodeResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetMedalInfoByCodeResponse.class, Builder.class);
        }

        public static Parser<GetMedalInfoByCodeResponse> PARSER = (Parser<GetMedalInfoByCodeResponse>) new AbstractParser<GetMedalInfoByCodeResponse>() {
            public MedalHandler.GetMedalInfoByCodeResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MedalHandler.GetMedalInfoByCodeResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_DATA_FIELD_NUMBER = 3;
        private MedalHandler.MedalData s2CData_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetMedalInfoByCodeResponse> getParserForType() {
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


        public MedalHandler.MedalData getS2CData() {
            return this.s2CData_;
        }


        public MedalHandler.MedalDataOrBuilder getS2CDataOrBuilder() {
            return this.s2CData_;
        }


        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CData_ = MedalHandler.MedalData.getDefaultInstance();
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
            if (hasS2CData() && !getS2CData().isInitialized()) {
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
                output.writeMessage(3, (MessageLite) this.s2CData_);
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
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.s2CData_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static GetMedalInfoByCodeResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetMedalInfoByCodeResponse) PARSER.parseFrom(data);
        }


        public static GetMedalInfoByCodeResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetMedalInfoByCodeResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetMedalInfoByCodeResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetMedalInfoByCodeResponse) PARSER.parseFrom(data);
        }


        public static GetMedalInfoByCodeResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetMedalInfoByCodeResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GetMedalInfoByCodeResponse parseFrom(InputStream input) throws IOException {
            return (GetMedalInfoByCodeResponse) PARSER.parseFrom(input);
        }


        public static GetMedalInfoByCodeResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetMedalInfoByCodeResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static GetMedalInfoByCodeResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (GetMedalInfoByCodeResponse) PARSER.parseDelimitedFrom(input);
        }

        public static GetMedalInfoByCodeResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetMedalInfoByCodeResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static GetMedalInfoByCodeResponse parseFrom(CodedInputStream input) throws IOException {
            return (GetMedalInfoByCodeResponse) PARSER.parseFrom(input);
        }

        public static GetMedalInfoByCodeResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetMedalInfoByCodeResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(GetMedalInfoByCodeResponse prototype) {
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
                implements MedalHandler.GetMedalInfoByCodeResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private MedalHandler.MedalData s2CData_;
            private SingleFieldBuilder<MedalHandler.MedalData, MedalHandler.MedalData.Builder, MedalHandler.MedalDataOrBuilder> s2CDataBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MedalHandler.internal_static_pomelo_area_GetMedalInfoByCodeResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MedalHandler.internal_static_pomelo_area_GetMedalInfoByCodeResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(MedalHandler.GetMedalInfoByCodeResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.s2CData_ = MedalHandler.MedalData.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CData_ = MedalHandler.MedalData.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MedalHandler.GetMedalInfoByCodeResponse.alwaysUseFieldBuilders) {
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
                    this.s2CData_ = MedalHandler.MedalData.getDefaultInstance();
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
                return MedalHandler.internal_static_pomelo_area_GetMedalInfoByCodeResponse_descriptor;
            }

            public MedalHandler.GetMedalInfoByCodeResponse getDefaultInstanceForType() {
                return MedalHandler.GetMedalInfoByCodeResponse.getDefaultInstance();
            }

            public MedalHandler.GetMedalInfoByCodeResponse build() {
                MedalHandler.GetMedalInfoByCodeResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public MedalHandler.GetMedalInfoByCodeResponse buildPartial() {
                MedalHandler.GetMedalInfoByCodeResponse result = new MedalHandler.GetMedalInfoByCodeResponse(this);
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
                if (this.s2CDataBuilder_ == null) {
                    result.s2CData_ = this.s2CData_;
                } else {
                    result.s2CData_ = (MedalHandler.MedalData) this.s2CDataBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof MedalHandler.GetMedalInfoByCodeResponse) {
                    return mergeFrom((MedalHandler.GetMedalInfoByCodeResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MedalHandler.GetMedalInfoByCodeResponse other) {
                if (other == MedalHandler.GetMedalInfoByCodeResponse.getDefaultInstance()) {
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
                if (other.hasS2CData()) {
                    mergeS2CData(other.getS2CData());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode()) {
                    return false;
                }
                if (hasS2CData() && !getS2CData().isInitialized()) {
                    return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                MedalHandler.GetMedalInfoByCodeResponse parsedMessage = null;
                try {
                    parsedMessage = (MedalHandler.GetMedalInfoByCodeResponse) MedalHandler.GetMedalInfoByCodeResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MedalHandler.GetMedalInfoByCodeResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = MedalHandler.GetMedalInfoByCodeResponse.getDefaultInstance().getS2CMsg();
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

            public boolean hasS2CData() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public MedalHandler.MedalData getS2CData() {
                if (this.s2CDataBuilder_ == null) {
                    return this.s2CData_;
                }
                return (MedalHandler.MedalData) this.s2CDataBuilder_.getMessage();
            }

            public Builder setS2CData(MedalHandler.MedalData value) {
                if (this.s2CDataBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.s2CData_ = value;
                    onChanged();
                } else {
                    this.s2CDataBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder setS2CData(MedalHandler.MedalData.Builder builderForValue) {
                if (this.s2CDataBuilder_ == null) {
                    this.s2CData_ = builderForValue.build();
                    onChanged();
                } else {
                    this.s2CDataBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder mergeS2CData(MedalHandler.MedalData value) {
                if (this.s2CDataBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4 && this.s2CData_ != MedalHandler.MedalData.getDefaultInstance()) {
                        this.s2CData_ = MedalHandler.MedalData.newBuilder(this.s2CData_).mergeFrom(value).buildPartial();
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
                    this.s2CData_ = MedalHandler.MedalData.getDefaultInstance();
                    onChanged();
                } else {
                    this.s2CDataBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public MedalHandler.MedalData.Builder getS2CDataBuilder() {
                this.bitField0_ |= 0x4;
                onChanged();
                return (MedalHandler.MedalData.Builder) getS2CDataFieldBuilder().getBuilder();
            }

            public MedalHandler.MedalDataOrBuilder getS2CDataOrBuilder() {
                if (this.s2CDataBuilder_ != null) {
                    return (MedalHandler.MedalDataOrBuilder) this.s2CDataBuilder_.getMessageOrBuilder();
                }
                return this.s2CData_;
            }

            private SingleFieldBuilder<MedalHandler.MedalData, MedalHandler.MedalData.Builder, MedalHandler.MedalDataOrBuilder> getS2CDataFieldBuilder() {
                if (this.s2CDataBuilder_ == null) {
                    this.s2CDataBuilder_ = new SingleFieldBuilder(getS2CData(), getParentForChildren(), isClean());
                    this.s2CData_ = null;
                }
                return this.s2CDataBuilder_;
            }
        }
    }

    public static final class MedalTitleData
            extends GeneratedMessage
            implements MedalTitleDataOrBuilder {
        private final UnknownFieldSet unknownFields;

        private MedalTitleData(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private MedalTitleData(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static MedalTitleData getDefaultInstance() {
            return defaultInstance;
        }

        public MedalTitleData getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MedalTitleData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ItemOuterClass.MiniItem.Builder subBuilder;
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        case 8:
                            this.bitField0_ |= 0x1;
                            this.titleId_ = input.readInt32();
                            break;
                        case 18:
                            subBuilder = null;
                            if ((this.bitField0_ & 0x2) == 2) {
                                subBuilder = this.medal_.toBuilder();
                            }
                            this.medal_ = (ItemOuterClass.MiniItem) input.readMessage(ItemOuterClass.MiniItem.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.medal_);
                                this.medal_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 0x2;
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
            return MedalHandler.internal_static_pomelo_area_MedalTitleData_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MedalHandler.internal_static_pomelo_area_MedalTitleData_fieldAccessorTable.ensureFieldAccessorsInitialized(MedalTitleData.class, Builder.class);
        }

        public static Parser<MedalTitleData> PARSER = (Parser<MedalTitleData>) new AbstractParser<MedalTitleData>() {
            public MedalHandler.MedalTitleData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MedalHandler.MedalTitleData(input, extensionRegistry);
            }
        };

        private int bitField0_;
        public static final int TITLEID_FIELD_NUMBER = 1;
        private int titleId_;
        public static final int MEDAL_FIELD_NUMBER = 2;
        private ItemOuterClass.MiniItem medal_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<MedalTitleData> getParserForType() {
            return PARSER;
        }

        public boolean hasTitleId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getTitleId() {
            return this.titleId_;
        }

        public boolean hasMedal() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public ItemOuterClass.MiniItem getMedal() {
            return this.medal_;
        }

        private static final MedalTitleData defaultInstance = new MedalTitleData(true);

        public ItemOuterClass.MiniItemOrBuilder getMedalOrBuilder() {
            return (ItemOuterClass.MiniItemOrBuilder) this.medal_;
        }

        private void initFields() {
            this.titleId_ = 0;
            this.medal_ = ItemOuterClass.MiniItem.getDefaultInstance();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (hasMedal() && !getMedal().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.titleId_);
            if ((this.bitField0_ & 0x2) == 2) output.writeMessage(2, (MessageLite) this.medal_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.titleId_);
            if ((this.bitField0_ & 0x2) == 2)
                size += CodedOutputStream.computeMessageSize(2, (MessageLite) this.medal_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static MedalTitleData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (MedalTitleData) PARSER.parseFrom(data);
        }

        public static MedalTitleData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MedalTitleData) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MedalTitleData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (MedalTitleData) PARSER.parseFrom(data);
        }

        public static MedalTitleData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MedalTitleData) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MedalTitleData parseFrom(InputStream input) throws IOException {
            return (MedalTitleData) PARSER.parseFrom(input);
        }

        public static MedalTitleData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MedalTitleData) PARSER.parseFrom(input, extensionRegistry);
        }

        public static MedalTitleData parseDelimitedFrom(InputStream input) throws IOException {
            return (MedalTitleData) PARSER.parseDelimitedFrom(input);
        }

        public static MedalTitleData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MedalTitleData) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static MedalTitleData parseFrom(CodedInputStream input) throws IOException {
            return (MedalTitleData) PARSER.parseFrom(input);
        }

        public static MedalTitleData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MedalTitleData) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(MedalTitleData prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements MedalHandler.MedalTitleDataOrBuilder {
            private int bitField0_;
            private int titleId_;
            private ItemOuterClass.MiniItem medal_;
            private SingleFieldBuilder<ItemOuterClass.MiniItem, ItemOuterClass.MiniItem.Builder, ItemOuterClass.MiniItemOrBuilder> medalBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MedalHandler.internal_static_pomelo_area_MedalTitleData_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MedalHandler.internal_static_pomelo_area_MedalTitleData_fieldAccessorTable.ensureFieldAccessorsInitialized(MedalHandler.MedalTitleData.class, Builder.class);
            }

            private Builder() {
                this.medal_ = ItemOuterClass.MiniItem.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.medal_ = ItemOuterClass.MiniItem.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MedalHandler.MedalTitleData.alwaysUseFieldBuilders) getMedalFieldBuilder();
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.titleId_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                if (this.medalBuilder_ == null) {
                    this.medal_ = ItemOuterClass.MiniItem.getDefaultInstance();
                } else {
                    this.medalBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return MedalHandler.internal_static_pomelo_area_MedalTitleData_descriptor;
            }

            public MedalHandler.MedalTitleData getDefaultInstanceForType() {
                return MedalHandler.MedalTitleData.getDefaultInstance();
            }

            public MedalHandler.MedalTitleData build() {
                MedalHandler.MedalTitleData result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public MedalHandler.MedalTitleData buildPartial() {
                MedalHandler.MedalTitleData result = new MedalHandler.MedalTitleData(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.titleId_ = this.titleId_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                if (this.medalBuilder_ == null) {
                    result.medal_ = this.medal_;
                } else {
                    result.medal_ = (ItemOuterClass.MiniItem) this.medalBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof MedalHandler.MedalTitleData) return mergeFrom((MedalHandler.MedalTitleData) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MedalHandler.MedalTitleData other) {
                if (other == MedalHandler.MedalTitleData.getDefaultInstance()) return this;
                if (other.hasTitleId()) setTitleId(other.getTitleId());
                if (other.hasMedal()) mergeMedal(other.getMedal());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (hasMedal() && !getMedal().isInitialized()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                MedalHandler.MedalTitleData parsedMessage = null;
                try {
                    parsedMessage = (MedalHandler.MedalTitleData) MedalHandler.MedalTitleData.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MedalHandler.MedalTitleData) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasTitleId() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getTitleId() {
                return this.titleId_;
            }

            public Builder setTitleId(int value) {
                this.bitField0_ |= 0x1;
                this.titleId_ = value;
                onChanged();
                return this;
            }

            public Builder clearTitleId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.titleId_ = 0;
                onChanged();
                return this;
            }

            public boolean hasMedal() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public ItemOuterClass.MiniItem getMedal() {
                if (this.medalBuilder_ == null) return this.medal_;
                return (ItemOuterClass.MiniItem) this.medalBuilder_.getMessage();
            }

            public Builder setMedal(ItemOuterClass.MiniItem value) {
                if (this.medalBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    this.medal_ = value;
                    onChanged();
                } else {
                    this.medalBuilder_.setMessage((GeneratedMessage) value);
                }
                this.bitField0_ |= 0x2;
                return this;
            }

            public Builder setMedal(ItemOuterClass.MiniItem.Builder builderForValue) {
                if (this.medalBuilder_ == null) {
                    this.medal_ = builderForValue.build();
                    onChanged();
                } else {
                    this.medalBuilder_.setMessage((GeneratedMessage) builderForValue.build());
                }
                this.bitField0_ |= 0x2;
                return this;
            }

            public Builder mergeMedal(ItemOuterClass.MiniItem value) {
                if (this.medalBuilder_ == null) {
                    if ((this.bitField0_ & 0x2) == 2 && this.medal_ != ItemOuterClass.MiniItem.getDefaultInstance()) {
                        this.medal_ = ItemOuterClass.MiniItem.newBuilder(this.medal_).mergeFrom(value).buildPartial();
                    } else {
                        this.medal_ = value;
                    }
                    onChanged();
                } else {
                    this.medalBuilder_.mergeFrom((GeneratedMessage) value);
                }
                this.bitField0_ |= 0x2;
                return this;
            }

            public Builder clearMedal() {
                if (this.medalBuilder_ == null) {
                    this.medal_ = ItemOuterClass.MiniItem.getDefaultInstance();
                    onChanged();
                } else {
                    this.medalBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            public ItemOuterClass.MiniItem.Builder getMedalBuilder() {
                this.bitField0_ |= 0x2;
                onChanged();
                return (ItemOuterClass.MiniItem.Builder) getMedalFieldBuilder().getBuilder();
            }

            public ItemOuterClass.MiniItemOrBuilder getMedalOrBuilder() {
                if (this.medalBuilder_ != null)
                    return (ItemOuterClass.MiniItemOrBuilder) this.medalBuilder_.getMessageOrBuilder();
                return (ItemOuterClass.MiniItemOrBuilder) this.medal_;
            }

            private SingleFieldBuilder<ItemOuterClass.MiniItem, ItemOuterClass.MiniItem.Builder, ItemOuterClass.MiniItemOrBuilder> getMedalFieldBuilder() {
                if (this.medalBuilder_ == null) {
                    this.medalBuilder_ = new SingleFieldBuilder((GeneratedMessage) getMedal(), getParentForChildren(), isClean());
                    this.medal_ = null;
                }
                return this.medalBuilder_;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class MedalTitleChangePush
            extends GeneratedMessage
            implements MedalTitleChangePushOrBuilder {
        private static final MedalTitleChangePush defaultInstance = new MedalTitleChangePush(true);
        private final UnknownFieldSet unknownFields;

        private MedalTitleChangePush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private MedalTitleChangePush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static MedalTitleChangePush getDefaultInstance() {
            return defaultInstance;
        }

        public MedalTitleChangePush getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MedalTitleChangePush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.s2CData_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x2;
                            }
                            this.s2CData_.add(input.readMessage(MedalHandler.MedalTitleData.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x2) == 2) this.s2CData_ = Collections.unmodifiableList(this.s2CData_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MedalHandler.internal_static_pomelo_area_MedalTitleChangePush_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MedalHandler.internal_static_pomelo_area_MedalTitleChangePush_fieldAccessorTable.ensureFieldAccessorsInitialized(MedalTitleChangePush.class, Builder.class);
        }

        public static Parser<MedalTitleChangePush> PARSER = (Parser<MedalTitleChangePush>) new AbstractParser<MedalTitleChangePush>() {
            public MedalHandler.MedalTitleChangePush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MedalHandler.MedalTitleChangePush(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_DATA_FIELD_NUMBER = 2;
        private List<MedalHandler.MedalTitleData> s2CData_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<MedalTitleChangePush> getParserForType() {
            return PARSER;
        }

        public boolean hasS2CCode() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getS2CCode() {
            return this.s2CCode_;
        }

        public List<MedalHandler.MedalTitleData> getS2CDataList() {
            return this.s2CData_;
        }

        public List<? extends MedalHandler.MedalTitleDataOrBuilder> getS2CDataOrBuilderList() {
            return (List) this.s2CData_;
        }

        public int getS2CDataCount() {
            return this.s2CData_.size();
        }

        public MedalHandler.MedalTitleData getS2CData(int index) {
            return this.s2CData_.get(index);
        }

        public MedalHandler.MedalTitleDataOrBuilder getS2CDataOrBuilder(int index) {
            return this.s2CData_.get(index);
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CData_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
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
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.s2CCode_);
            for (int i = 0; i < this.s2CData_.size(); i++) output.writeMessage(2, (MessageLite) this.s2CData_.get(i));
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            for (int i = 0; i < this.s2CData_.size(); i++)
                size += CodedOutputStream.computeMessageSize(2, (MessageLite) this.s2CData_.get(i));
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static MedalTitleChangePush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (MedalTitleChangePush) PARSER.parseFrom(data);
        }

        public static MedalTitleChangePush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MedalTitleChangePush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MedalTitleChangePush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (MedalTitleChangePush) PARSER.parseFrom(data);
        }

        public static MedalTitleChangePush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MedalTitleChangePush) PARSER.parseFrom(data, extensionRegistry);
        }

        static {
            defaultInstance.initFields();
        }

        public static MedalTitleChangePush parseFrom(InputStream input) throws IOException {
            return (MedalTitleChangePush) PARSER.parseFrom(input);
        }

        public static MedalTitleChangePush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MedalTitleChangePush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static MedalTitleChangePush parseDelimitedFrom(InputStream input) throws IOException {
            return (MedalTitleChangePush) PARSER.parseDelimitedFrom(input);
        }

        public static MedalTitleChangePush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MedalTitleChangePush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static MedalTitleChangePush parseFrom(CodedInputStream input) throws IOException {
            return (MedalTitleChangePush) PARSER.parseFrom(input);
        }

        public static MedalTitleChangePush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MedalTitleChangePush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(MedalTitleChangePush prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements MedalHandler.MedalTitleChangePushOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private List<MedalHandler.MedalTitleData> s2CData_;
            private RepeatedFieldBuilder<MedalHandler.MedalTitleData, MedalHandler.MedalTitleData.Builder, MedalHandler.MedalTitleDataOrBuilder> s2CDataBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MedalHandler.internal_static_pomelo_area_MedalTitleChangePush_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MedalHandler.internal_static_pomelo_area_MedalTitleChangePush_fieldAccessorTable.ensureFieldAccessorsInitialized(MedalHandler.MedalTitleChangePush.class, Builder.class);
            }

            private Builder() {
                this.s2CData_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CData_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MedalHandler.MedalTitleChangePush.alwaysUseFieldBuilders)
                    getS2CDataFieldBuilder();
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.s2CCode_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                if (this.s2CDataBuilder_ == null) {
                    this.s2CData_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFD;
                } else {
                    this.s2CDataBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return MedalHandler.internal_static_pomelo_area_MedalTitleChangePush_descriptor;
            }

            public MedalHandler.MedalTitleChangePush getDefaultInstanceForType() {
                return MedalHandler.MedalTitleChangePush.getDefaultInstance();
            }

            public MedalHandler.MedalTitleChangePush build() {
                MedalHandler.MedalTitleChangePush result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public MedalHandler.MedalTitleChangePush buildPartial() {
                MedalHandler.MedalTitleChangePush result = new MedalHandler.MedalTitleChangePush(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if (this.s2CDataBuilder_ == null) {
                    if ((this.bitField0_ & 0x2) == 2) {
                        this.s2CData_ = Collections.unmodifiableList(this.s2CData_);
                        this.bitField0_ &= 0xFFFFFFFD;
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
                if (other instanceof MedalHandler.MedalTitleChangePush)
                    return mergeFrom((MedalHandler.MedalTitleChangePush) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MedalHandler.MedalTitleChangePush other) {
                if (other == MedalHandler.MedalTitleChangePush.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (this.s2CDataBuilder_ == null) {
                    if (!other.s2CData_.isEmpty()) {
                        if (this.s2CData_.isEmpty()) {
                            this.s2CData_ = other.s2CData_;
                            this.bitField0_ &= 0xFFFFFFFD;
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
                        this.bitField0_ &= 0xFFFFFFFD;
                        this.s2CDataBuilder_ = MedalHandler.MedalTitleChangePush.alwaysUseFieldBuilders ? getS2CDataFieldBuilder() : null;
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
                MedalHandler.MedalTitleChangePush parsedMessage = null;
                try {
                    parsedMessage = (MedalHandler.MedalTitleChangePush) MedalHandler.MedalTitleChangePush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MedalHandler.MedalTitleChangePush) e.getUnfinishedMessage();
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

            private void ensureS2CDataIsMutable() {
                if ((this.bitField0_ & 0x2) != 2) {
                    this.s2CData_ = new ArrayList<>(this.s2CData_);
                    this.bitField0_ |= 0x2;
                }
            }

            public List<MedalHandler.MedalTitleData> getS2CDataList() {
                if (this.s2CDataBuilder_ == null)
                    return Collections.unmodifiableList(this.s2CData_);
                return this.s2CDataBuilder_.getMessageList();
            }

            public int getS2CDataCount() {
                if (this.s2CDataBuilder_ == null)
                    return this.s2CData_.size();
                return this.s2CDataBuilder_.getCount();
            }

            public MedalHandler.MedalTitleData getS2CData(int index) {
                if (this.s2CDataBuilder_ == null)
                    return this.s2CData_.get(index);
                return (MedalHandler.MedalTitleData) this.s2CDataBuilder_.getMessage(index);
            }

            public Builder setS2CData(int index, MedalHandler.MedalTitleData value) {
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

            public Builder setS2CData(int index, MedalHandler.MedalTitleData.Builder builderForValue) {
                if (this.s2CDataBuilder_ == null) {
                    ensureS2CDataIsMutable();
                    this.s2CData_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CDataBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addS2CData(MedalHandler.MedalTitleData value) {
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

            public Builder addS2CData(int index, MedalHandler.MedalTitleData value) {
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

            public Builder addS2CData(MedalHandler.MedalTitleData.Builder builderForValue) {
                if (this.s2CDataBuilder_ == null) {
                    ensureS2CDataIsMutable();
                    this.s2CData_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.s2CDataBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addS2CData(int index, MedalHandler.MedalTitleData.Builder builderForValue) {
                if (this.s2CDataBuilder_ == null) {
                    ensureS2CDataIsMutable();
                    this.s2CData_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CDataBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllS2CData(Iterable<? extends MedalHandler.MedalTitleData> values) {
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
                    this.bitField0_ &= 0xFFFFFFFD;
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

            public MedalHandler.MedalTitleData.Builder getS2CDataBuilder(int index) {
                return (MedalHandler.MedalTitleData.Builder) getS2CDataFieldBuilder().getBuilder(index);
            }

            public MedalHandler.MedalTitleDataOrBuilder getS2CDataOrBuilder(int index) {
                if (this.s2CDataBuilder_ == null)
                    return this.s2CData_.get(index);
                return (MedalHandler.MedalTitleDataOrBuilder) this.s2CDataBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends MedalHandler.MedalTitleDataOrBuilder> getS2CDataOrBuilderList() {
                if (this.s2CDataBuilder_ != null)
                    return this.s2CDataBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.s2CData_);
            }

            public MedalHandler.MedalTitleData.Builder addS2CDataBuilder() {
                return (MedalHandler.MedalTitleData.Builder) getS2CDataFieldBuilder().addBuilder(MedalHandler.MedalTitleData.getDefaultInstance());
            }

            public MedalHandler.MedalTitleData.Builder addS2CDataBuilder(int index) {
                return (MedalHandler.MedalTitleData.Builder) getS2CDataFieldBuilder().addBuilder(index, MedalHandler.MedalTitleData.getDefaultInstance());
            }

            public List<MedalHandler.MedalTitleData.Builder> getS2CDataBuilderList() {
                return getS2CDataFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<MedalHandler.MedalTitleData, MedalHandler.MedalTitleData.Builder, MedalHandler.MedalTitleDataOrBuilder> getS2CDataFieldBuilder() {
                if (this.s2CDataBuilder_ == null) {
                    this.s2CDataBuilder_ = new RepeatedFieldBuilder(this.s2CData_, ((this.bitField0_ & 0x2) == 2), getParentForChildren(), isClean());
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
        String[] descriptorData = {"\n\022medalHandler.proto\022\013pomelo.area\032\fcommon.proto\032\nitem.proto\"È\001\n\tMedalData\022$\n\005medal\030\001 \001(\0132\025.pomelo.item.MiniItem\022\r\n\005ifMax\030\002 \001(\005\022\024\n\fneedPrestige\030\003 \001(\005\022\020\n\bneedGold\030\004 \001(\005\022\023\n\013needDiamond\030\005 \001(\005\022\025\n\rnextTitleName\030\006 \001(\t\022$\n\005attrs\030\007 \003(\0132\025.pomelo.AttributeBase\022\f\n\004flag\030\b \001(\005\"\025\n\023GetMedalInfoRequest\"c\n\024GetMedalInfoResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022(\n\bs2c_data\030\003 \001(\0132\026.pomelo.area.MedalData\"\"\n\020GainMedalR", "equest\022\016\n\006c2s_id\030\001 \002(\t\"6\n\021GainMedalResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"\022\n\020MedalListRequest\"D\n\rMedalListInfo\022$\n\005medal\030\001 \002(\0132\025.pomelo.item.MiniItem\022\r\n\005isGet\030\002 \002(\005\"d\n\021MedalListResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022,\n\bs2c_data\030\003 \003(\0132\032.pomelo.area.MedalListInfo\"-\n\031GetMedalInfoByCodeRequest\022\020\n\bc2s_code\030\001 \002(\t\"i\n\032GetMedalInfoByCodeResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022(\n\bs2c_data\030\003 \001(\013", "2\026.pomelo.area.MedalData\"G\n\016MedalTitleData\022\017\n\007titleId\030\001 \001(\005\022$\n\005medal\030\002 \001(\0132\025.pomelo.item.MiniItem\"W\n\024MedalTitleChangePush\022\020\n\bs2c_code\030\001 \002(\005\022-\n\bs2c_data\030\002 \003(\0132\033.pomelo.area.MedalTitleData2þ\002\n\fmedalHandler\022Z\n\023getMedalInfoRequest\022 .pomelo.area.GetMedalInfoRequest\032!.pomelo.area.GetMedalInfoResponse\022Q\n\020gainMedalRequest\022\035.pomelo.area.GainMedalRequest\032\036.pomelo.area.GainMedalResponse\022Q\n\020medalListRequest\022\035", ".pomelo.area.MedalListRequest\032\036.pomelo.area.MedalListResponse\022l\n\031getMedalInfoByCodeRequest\022&.pomelo.area.GetMedalInfoByCodeRequest\032'.pomelo.area.GetMedalInfoByCodeResponse2T\n\tmedalPush\022G\n\024medalTitleChangePush\022!.pomelo.area.MedalTitleChangePush\032\f.pomelo.Void"};


        Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root) {
                MedalHandler.descriptor = root;
                return null;
            }
        };

        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[]{

                Common.getDescriptor(),
                ItemOuterClass.getDescriptor()}, assigner);
    }

    private static final Descriptors.Descriptor internal_static_pomelo_area_MedalData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_MedalData_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_MedalData_descriptor, new String[]{"Medal", "IfMax", "NeedPrestige", "NeedGold", "NeedDiamond", "NextTitleName", "Attrs", "Flag"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetMedalInfoRequest_descriptor = getDescriptor().getMessageTypes().get(1);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetMedalInfoRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetMedalInfoRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetMedalInfoResponse_descriptor = getDescriptor().getMessageTypes().get(2);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetMedalInfoResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetMedalInfoResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CData"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GainMedalRequest_descriptor = getDescriptor().getMessageTypes().get(3);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GainMedalRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GainMedalRequest_descriptor, new String[]{"C2SId"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GainMedalResponse_descriptor = getDescriptor().getMessageTypes().get(4);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GainMedalResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GainMedalResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_MedalListRequest_descriptor = getDescriptor().getMessageTypes().get(5);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_MedalListRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_MedalListRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_area_MedalListInfo_descriptor = getDescriptor().getMessageTypes().get(6);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_MedalListInfo_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_MedalListInfo_descriptor, new String[]{"Medal", "IsGet"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_MedalListResponse_descriptor = getDescriptor().getMessageTypes().get(7);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_MedalListResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_MedalListResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CData"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetMedalInfoByCodeRequest_descriptor = getDescriptor().getMessageTypes().get(8);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetMedalInfoByCodeRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetMedalInfoByCodeRequest_descriptor, new String[]{"C2SCode"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetMedalInfoByCodeResponse_descriptor = getDescriptor().getMessageTypes().get(9);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetMedalInfoByCodeResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetMedalInfoByCodeResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CData"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_MedalTitleData_descriptor = getDescriptor().getMessageTypes().get(10);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_MedalTitleData_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_MedalTitleData_descriptor, new String[]{"TitleId", "Medal"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_MedalTitleChangePush_descriptor = getDescriptor().getMessageTypes().get(11);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_MedalTitleChangePush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_MedalTitleChangePush_descriptor, new String[]{"S2CCode", "S2CData"});
    private static Descriptors.FileDescriptor descriptor;

    static {
        Common.getDescriptor();
        ItemOuterClass.getDescriptor();
    }

    public static interface MedalTitleChangePushOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        List<MedalHandler.MedalTitleData> getS2CDataList();

        MedalHandler.MedalTitleData getS2CData(int param1Int);

        int getS2CDataCount();

        List<? extends MedalHandler.MedalTitleDataOrBuilder> getS2CDataOrBuilderList();

        MedalHandler.MedalTitleDataOrBuilder getS2CDataOrBuilder(int param1Int);
    }

    public static interface MedalTitleDataOrBuilder extends MessageOrBuilder {
        boolean hasTitleId();

        int getTitleId();

        boolean hasMedal();

        ItemOuterClass.MiniItem getMedal();

        ItemOuterClass.MiniItemOrBuilder getMedalOrBuilder();
    }

    public static interface GetMedalInfoByCodeResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasS2CData();

        MedalHandler.MedalData getS2CData();

        MedalHandler.MedalDataOrBuilder getS2CDataOrBuilder();
    }

    public static interface GetMedalInfoByCodeRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2SCode();

        String getC2SCode();

        ByteString getC2SCodeBytes();
    }

    public static interface MedalListResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        List<MedalHandler.MedalListInfo> getS2CDataList();

        MedalHandler.MedalListInfo getS2CData(int param1Int);

        int getS2CDataCount();

        List<? extends MedalHandler.MedalListInfoOrBuilder> getS2CDataOrBuilderList();

        MedalHandler.MedalListInfoOrBuilder getS2CDataOrBuilder(int param1Int);
    }

    public static interface MedalListInfoOrBuilder extends MessageOrBuilder {
        boolean hasMedal();

        ItemOuterClass.MiniItem getMedal();

        ItemOuterClass.MiniItemOrBuilder getMedalOrBuilder();

        boolean hasIsGet();

        int getIsGet();
    }

    public static interface MedalListRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface GainMedalResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface GainMedalRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2SId();

        String getC2SId();

        ByteString getC2SIdBytes();
    }

    public static interface GetMedalInfoResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasS2CData();

        MedalHandler.MedalData getS2CData();

        MedalHandler.MedalDataOrBuilder getS2CDataOrBuilder();
    }

    public static interface GetMedalInfoRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface MedalDataOrBuilder extends MessageOrBuilder {
        boolean hasMedal();

        ItemOuterClass.MiniItem getMedal();

        ItemOuterClass.MiniItemOrBuilder getMedalOrBuilder();

        boolean hasIfMax();

        int getIfMax();

        boolean hasNeedPrestige();

        int getNeedPrestige();

        boolean hasNeedGold();

        int getNeedGold();

        boolean hasNeedDiamond();

        int getNeedDiamond();

        boolean hasNextTitleName();

        String getNextTitleName();

        ByteString getNextTitleNameBytes();

        List<Common.AttributeBase> getAttrsList();

        Common.AttributeBase getAttrs(int param1Int);

        int getAttrsCount();

        List<? extends Common.AttributeBaseOrBuilder> getAttrsOrBuilderList();

        Common.AttributeBaseOrBuilder getAttrsOrBuilder(int param1Int);

        boolean hasFlag();

        int getFlag();
    }
}


