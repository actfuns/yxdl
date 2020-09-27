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

import pomelo.item.ItemOuterClass;


public final class SaleHandler {
    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static final class BuyItem
            extends GeneratedMessage
            implements BuyItemOrBuilder {
        private final UnknownFieldSet unknownFields;

        private BuyItem(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private BuyItem(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static BuyItem getDefaultInstance() {
            return defaultInstance;
        }

        public BuyItem getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BuyItem(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString bs;
                    ItemOuterClass.MiniItem.Builder subBuilder;
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        case 8:
                            this.bitField0_ |= 0x1;
                            this.typeId_ = input.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.itemId_ = input.readInt32();
                            break;
                        case 26:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x4;
                            this.itemShowName_ = bs;
                            break;
                        case 34:
                            subBuilder = null;
                            if ((this.bitField0_ & 0x8) == 8)
                                subBuilder = this.item_.toBuilder();
                            this.item_ = (ItemOuterClass.MiniItem) input.readMessage(ItemOuterClass.MiniItem.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.item_);
                                this.item_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 0x8;
                            break;
                        case 40:
                            this.bitField0_ |= 0x10;
                            this.moneyType_ = input.readInt32();
                            break;
                        case 48:
                            this.bitField0_ |= 0x20;
                            this.needMoney_ = input.readInt32();
                            break;
                        case 56:
                            this.bitField0_ |= 0x40;
                            this.maxGroupCount_ = input.readInt32();
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
            return SaleHandler.internal_static_pomelo_area_BuyItem_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return SaleHandler.internal_static_pomelo_area_BuyItem_fieldAccessorTable.ensureFieldAccessorsInitialized(BuyItem.class, Builder.class);
        }

        public static Parser<BuyItem> PARSER = (Parser<BuyItem>) new AbstractParser<BuyItem>() {
            public SaleHandler.BuyItem parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SaleHandler.BuyItem(input, extensionRegistry);
            }
        };

        private int bitField0_;
        public static final int TYPEID_FIELD_NUMBER = 1;
        private int typeId_;
        public static final int ITEMID_FIELD_NUMBER = 2;
        private int itemId_;
        public static final int ITEMSHOWNAME_FIELD_NUMBER = 3;
        private Object itemShowName_;
        private static final BuyItem defaultInstance = new BuyItem(true);
        public static final int ITEM_FIELD_NUMBER = 4;
        private ItemOuterClass.MiniItem item_;
        public static final int MONEYTYPE_FIELD_NUMBER = 5;
        private int moneyType_;
        public static final int NEEDMONEY_FIELD_NUMBER = 6;
        private int needMoney_;
        public static final int MAXGROUPCOUNT_FIELD_NUMBER = 7;
        private int maxGroupCount_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<BuyItem> getParserForType() {
            return PARSER;
        }

        public boolean hasTypeId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getTypeId() {
            return this.typeId_;
        }

        public boolean hasItemId() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public int getItemId() {
            return this.itemId_;
        }

        static {
            defaultInstance.initFields();
        }

        public boolean hasItemShowName() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public String getItemShowName() {
            Object ref = this.itemShowName_;
            if (ref instanceof String)
                return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8())
                this.itemShowName_ = s;
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

        public boolean hasItem() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public ItemOuterClass.MiniItem getItem() {
            return this.item_;
        }

        public ItemOuterClass.MiniItemOrBuilder getItemOrBuilder() {
            return (ItemOuterClass.MiniItemOrBuilder) this.item_;
        }

        public boolean hasMoneyType() {
            return ((this.bitField0_ & 0x10) == 16);
        }

        public int getMoneyType() {
            return this.moneyType_;
        }

        public boolean hasNeedMoney() {
            return ((this.bitField0_ & 0x20) == 32);
        }

        public int getNeedMoney() {
            return this.needMoney_;
        }

        public boolean hasMaxGroupCount() {
            return ((this.bitField0_ & 0x40) == 64);
        }

        public int getMaxGroupCount() {
            return this.maxGroupCount_;
        }

        private void initFields() {
            this.typeId_ = 0;
            this.itemId_ = 0;
            this.itemShowName_ = "";
            this.item_ = ItemOuterClass.MiniItem.getDefaultInstance();
            this.moneyType_ = 0;
            this.needMoney_ = 0;
            this.maxGroupCount_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1)
                return true;
            if (isInitialized == 0)
                return false;
            if (hasItem() && !getItem().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1)
                output.writeInt32(1, this.typeId_);
            if ((this.bitField0_ & 0x2) == 2)
                output.writeInt32(2, this.itemId_);
            if ((this.bitField0_ & 0x4) == 4)
                output.writeBytes(3, getItemShowNameBytes());
            if ((this.bitField0_ & 0x8) == 8)
                output.writeMessage(4, (MessageLite) this.item_);
            if ((this.bitField0_ & 0x10) == 16)
                output.writeInt32(5, this.moneyType_);
            if ((this.bitField0_ & 0x20) == 32)
                output.writeInt32(6, this.needMoney_);
            if ((this.bitField0_ & 0x40) == 64)
                output.writeInt32(7, this.maxGroupCount_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1)
                return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1)
                size += CodedOutputStream.computeInt32Size(1, this.typeId_);
            if ((this.bitField0_ & 0x2) == 2)
                size += CodedOutputStream.computeInt32Size(2, this.itemId_);
            if ((this.bitField0_ & 0x4) == 4)
                size += CodedOutputStream.computeBytesSize(3, getItemShowNameBytes());
            if ((this.bitField0_ & 0x8) == 8)
                size += CodedOutputStream.computeMessageSize(4, (MessageLite) this.item_);
            if ((this.bitField0_ & 0x10) == 16)
                size += CodedOutputStream.computeInt32Size(5, this.moneyType_);
            if ((this.bitField0_ & 0x20) == 32)
                size += CodedOutputStream.computeInt32Size(6, this.needMoney_);
            if ((this.bitField0_ & 0x40) == 64)
                size += CodedOutputStream.computeInt32Size(7, this.maxGroupCount_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static BuyItem parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (BuyItem) PARSER.parseFrom(data);
        }

        public static BuyItem parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BuyItem) PARSER.parseFrom(data, extensionRegistry);
        }

        public static BuyItem parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (BuyItem) PARSER.parseFrom(data);
        }

        public static BuyItem parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BuyItem) PARSER.parseFrom(data, extensionRegistry);
        }

        public static BuyItem parseFrom(InputStream input) throws IOException {
            return (BuyItem) PARSER.parseFrom(input);
        }

        public static BuyItem parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuyItem) PARSER.parseFrom(input, extensionRegistry);
        }

        public static BuyItem parseDelimitedFrom(InputStream input) throws IOException {
            return (BuyItem) PARSER.parseDelimitedFrom(input);
        }

        public static BuyItem parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuyItem) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static BuyItem parseFrom(CodedInputStream input) throws IOException {
            return (BuyItem) PARSER.parseFrom(input);
        }

        public static BuyItem parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuyItem) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(BuyItem prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements SaleHandler.BuyItemOrBuilder {
            private int bitField0_;
            private int typeId_;
            private int itemId_;
            private Object itemShowName_;
            private ItemOuterClass.MiniItem item_;
            private SingleFieldBuilder<ItemOuterClass.MiniItem, ItemOuterClass.MiniItem.Builder, ItemOuterClass.MiniItemOrBuilder> itemBuilder_;
            private int moneyType_;
            private int needMoney_;
            private int maxGroupCount_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SaleHandler.internal_static_pomelo_area_BuyItem_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return SaleHandler.internal_static_pomelo_area_BuyItem_fieldAccessorTable.ensureFieldAccessorsInitialized(SaleHandler.BuyItem.class, Builder.class);
            }

            private Builder() {
                this.itemShowName_ = "";
                this.item_ = ItemOuterClass.MiniItem.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.itemShowName_ = "";
                this.item_ = ItemOuterClass.MiniItem.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SaleHandler.BuyItem.alwaysUseFieldBuilders)
                    getItemFieldBuilder();
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.typeId_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.itemId_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                this.itemShowName_ = "";
                this.bitField0_ &= 0xFFFFFFFB;
                if (this.itemBuilder_ == null) {
                    this.item_ = ItemOuterClass.MiniItem.getDefaultInstance();
                } else {
                    this.itemBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFF7;
                this.moneyType_ = 0;
                this.bitField0_ &= 0xFFFFFFEF;
                this.needMoney_ = 0;
                this.bitField0_ &= 0xFFFFFFDF;
                this.maxGroupCount_ = 0;
                this.bitField0_ &= 0xFFFFFFBF;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return SaleHandler.internal_static_pomelo_area_BuyItem_descriptor;
            }

            public SaleHandler.BuyItem getDefaultInstanceForType() {
                return SaleHandler.BuyItem.getDefaultInstance();
            }

            public SaleHandler.BuyItem build() {
                SaleHandler.BuyItem result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public SaleHandler.BuyItem buildPartial() {
                SaleHandler.BuyItem result = new SaleHandler.BuyItem(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.typeId_ = this.typeId_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.itemId_ = this.itemId_;
                if ((from_bitField0_ & 0x4) == 4)
                    to_bitField0_ |= 0x4;
                result.itemShowName_ = this.itemShowName_;
                if ((from_bitField0_ & 0x8) == 8)
                    to_bitField0_ |= 0x8;
                if (this.itemBuilder_ == null) {
                    result.item_ = this.item_;
                } else {
                    result.item_ = (ItemOuterClass.MiniItem) this.itemBuilder_.build();
                }
                if ((from_bitField0_ & 0x10) == 16)
                    to_bitField0_ |= 0x10;
                result.moneyType_ = this.moneyType_;
                if ((from_bitField0_ & 0x20) == 32)
                    to_bitField0_ |= 0x20;
                result.needMoney_ = this.needMoney_;
                if ((from_bitField0_ & 0x40) == 64)
                    to_bitField0_ |= 0x40;
                result.maxGroupCount_ = this.maxGroupCount_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof SaleHandler.BuyItem)
                    return mergeFrom((SaleHandler.BuyItem) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SaleHandler.BuyItem other) {
                if (other == SaleHandler.BuyItem.getDefaultInstance())
                    return this;
                if (other.hasTypeId())
                    setTypeId(other.getTypeId());
                if (other.hasItemId())
                    setItemId(other.getItemId());
                if (other.hasItemShowName()) {
                    this.bitField0_ |= 0x4;
                    this.itemShowName_ = other.itemShowName_;
                    onChanged();
                }
                if (other.hasItem())
                    mergeItem(other.getItem());
                if (other.hasMoneyType())
                    setMoneyType(other.getMoneyType());
                if (other.hasNeedMoney())
                    setNeedMoney(other.getNeedMoney());
                if (other.hasMaxGroupCount())
                    setMaxGroupCount(other.getMaxGroupCount());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (hasItem() && !getItem().isInitialized())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                SaleHandler.BuyItem parsedMessage = null;
                try {
                    parsedMessage = (SaleHandler.BuyItem) SaleHandler.BuyItem.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SaleHandler.BuyItem) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null)
                        mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasTypeId() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getTypeId() {
                return this.typeId_;
            }

            public Builder setTypeId(int value) {
                this.bitField0_ |= 0x1;
                this.typeId_ = value;
                onChanged();
                return this;
            }

            public Builder clearTypeId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.typeId_ = 0;
                onChanged();
                return this;
            }

            public boolean hasItemId() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getItemId() {
                return this.itemId_;
            }

            public Builder setItemId(int value) {
                this.bitField0_ |= 0x2;
                this.itemId_ = value;
                onChanged();
                return this;
            }

            public Builder clearItemId() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.itemId_ = 0;
                onChanged();
                return this;
            }

            public boolean hasItemShowName() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public String getItemShowName() {
                Object ref = this.itemShowName_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.itemShowName_ = s;
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
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x4;
                this.itemShowName_ = value;
                onChanged();
                return this;
            }

            public Builder clearItemShowName() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.itemShowName_ = SaleHandler.BuyItem.getDefaultInstance().getItemShowName();
                onChanged();
                return this;
            }

            public Builder setItemShowNameBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x4;
                this.itemShowName_ = value;
                onChanged();
                return this;
            }

            public boolean hasItem() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public ItemOuterClass.MiniItem getItem() {
                if (this.itemBuilder_ == null)
                    return this.item_;
                return (ItemOuterClass.MiniItem) this.itemBuilder_.getMessage();
            }

            public Builder setItem(ItemOuterClass.MiniItem value) {
                if (this.itemBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    this.item_ = value;
                    onChanged();
                } else {
                    this.itemBuilder_.setMessage((GeneratedMessage) value);
                }
                this.bitField0_ |= 0x8;
                return this;
            }

            public Builder setItem(ItemOuterClass.MiniItem.Builder builderForValue) {
                if (this.itemBuilder_ == null) {
                    this.item_ = builderForValue.build();
                    onChanged();
                } else {
                    this.itemBuilder_.setMessage((GeneratedMessage) builderForValue.build());
                }
                this.bitField0_ |= 0x8;
                return this;
            }

            public Builder mergeItem(ItemOuterClass.MiniItem value) {
                if (this.itemBuilder_ == null) {
                    if ((this.bitField0_ & 0x8) == 8 && this.item_ != ItemOuterClass.MiniItem.getDefaultInstance()) {
                        this.item_ = ItemOuterClass.MiniItem.newBuilder(this.item_).mergeFrom(value).buildPartial();
                    } else {
                        this.item_ = value;
                    }
                    onChanged();
                } else {
                    this.itemBuilder_.mergeFrom((GeneratedMessage) value);
                }
                this.bitField0_ |= 0x8;
                return this;
            }

            public Builder clearItem() {
                if (this.itemBuilder_ == null) {
                    this.item_ = ItemOuterClass.MiniItem.getDefaultInstance();
                    onChanged();
                } else {
                    this.itemBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }

            public ItemOuterClass.MiniItem.Builder getItemBuilder() {
                this.bitField0_ |= 0x8;
                onChanged();
                return (ItemOuterClass.MiniItem.Builder) getItemFieldBuilder().getBuilder();
            }

            public ItemOuterClass.MiniItemOrBuilder getItemOrBuilder() {
                if (this.itemBuilder_ != null)
                    return (ItemOuterClass.MiniItemOrBuilder) this.itemBuilder_.getMessageOrBuilder();
                return (ItemOuterClass.MiniItemOrBuilder) this.item_;
            }

            private SingleFieldBuilder<ItemOuterClass.MiniItem, ItemOuterClass.MiniItem.Builder, ItemOuterClass.MiniItemOrBuilder> getItemFieldBuilder() {
                if (this.itemBuilder_ == null) {
                    this.itemBuilder_ = new SingleFieldBuilder((GeneratedMessage) getItem(), getParentForChildren(), isClean());
                    this.item_ = null;
                }
                return this.itemBuilder_;
            }

            public boolean hasMoneyType() {
                return ((this.bitField0_ & 0x10) == 16);
            }

            public int getMoneyType() {
                return this.moneyType_;
            }

            public Builder setMoneyType(int value) {
                this.bitField0_ |= 0x10;
                this.moneyType_ = value;
                onChanged();
                return this;
            }

            public Builder clearMoneyType() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.moneyType_ = 0;
                onChanged();
                return this;
            }

            public boolean hasNeedMoney() {
                return ((this.bitField0_ & 0x20) == 32);
            }

            public int getNeedMoney() {
                return this.needMoney_;
            }

            public Builder setNeedMoney(int value) {
                this.bitField0_ |= 0x20;
                this.needMoney_ = value;
                onChanged();
                return this;
            }

            public Builder clearNeedMoney() {
                this.bitField0_ &= 0xFFFFFFDF;
                this.needMoney_ = 0;
                onChanged();
                return this;
            }

            public boolean hasMaxGroupCount() {
                return ((this.bitField0_ & 0x40) == 64);
            }

            public int getMaxGroupCount() {
                return this.maxGroupCount_;
            }

            public Builder setMaxGroupCount(int value) {
                this.bitField0_ |= 0x40;
                this.maxGroupCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearMaxGroupCount() {
                this.bitField0_ &= 0xFFFFFFBF;
                this.maxGroupCount_ = 0;
                onChanged();
                return this;
            }
        }
    }

    public static final class SellGrid extends GeneratedMessage implements SellGridOrBuilder {
        private static final SellGrid defaultInstance = new SellGrid(true);
        private final UnknownFieldSet unknownFields;

        private SellGrid(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private SellGrid(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static SellGrid getDefaultInstance() {
            return defaultInstance;
        }

        public SellGrid getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SellGrid(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.index_ = input.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.num_ = input.readInt32();
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
            return SaleHandler.internal_static_pomelo_area_SellGrid_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return SaleHandler.internal_static_pomelo_area_SellGrid_fieldAccessorTable.ensureFieldAccessorsInitialized(SellGrid.class, Builder.class);
        }

        public static Parser<SellGrid> PARSER = (Parser<SellGrid>) new AbstractParser<SellGrid>() {
            public SaleHandler.SellGrid parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SaleHandler.SellGrid(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int INDEX_FIELD_NUMBER = 1;
        private int index_;
        public static final int NUM_FIELD_NUMBER = 2;
        private int num_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<SellGrid> getParserForType() {
            return PARSER;
        }

        public boolean hasIndex() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getIndex() {
            return this.index_;
        }

        public boolean hasNum() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        static {
            defaultInstance.initFields();
        }


        public int getNum() {
            return this.num_;
        }


        private void initFields() {
            this.index_ = 0;
            this.num_ = 0;
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasIndex()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasNum()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeInt32(1, this.index_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeInt32(2, this.num_);
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
                size += CodedOutputStream.computeInt32Size(1, this.index_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeInt32Size(2, this.num_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static SellGrid parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (SellGrid) PARSER.parseFrom(data);
        }


        public static SellGrid parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SellGrid) PARSER.parseFrom(data, extensionRegistry);
        }


        public static SellGrid parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (SellGrid) PARSER.parseFrom(data);
        }


        public static SellGrid parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SellGrid) PARSER.parseFrom(data, extensionRegistry);
        }


        public static SellGrid parseFrom(InputStream input) throws IOException {
            return (SellGrid) PARSER.parseFrom(input);
        }


        public static SellGrid parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SellGrid) PARSER.parseFrom(input, extensionRegistry);
        }


        public static SellGrid parseDelimitedFrom(InputStream input) throws IOException {
            return (SellGrid) PARSER.parseDelimitedFrom(input);
        }


        public static SellGrid parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SellGrid) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static SellGrid parseFrom(CodedInputStream input) throws IOException {
            return (SellGrid) PARSER.parseFrom(input);
        }


        public static SellGrid parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SellGrid) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(SellGrid prototype) {
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
                implements SaleHandler.SellGridOrBuilder {
            private int bitField0_;


            private int index_;


            private int num_;


            public static final Descriptors.Descriptor getDescriptor() {
                return SaleHandler.internal_static_pomelo_area_SellGrid_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return SaleHandler.internal_static_pomelo_area_SellGrid_fieldAccessorTable.ensureFieldAccessorsInitialized(SaleHandler.SellGrid.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (SaleHandler.SellGrid.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.index_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.num_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return SaleHandler.internal_static_pomelo_area_SellGrid_descriptor;
            }


            public SaleHandler.SellGrid getDefaultInstanceForType() {
                return SaleHandler.SellGrid.getDefaultInstance();
            }


            public SaleHandler.SellGrid build() {
                SaleHandler.SellGrid result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public SaleHandler.SellGrid buildPartial() {
                SaleHandler.SellGrid result = new SaleHandler.SellGrid(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.index_ = this.index_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.num_ = this.num_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof SaleHandler.SellGrid) {
                    return mergeFrom((SaleHandler.SellGrid) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(SaleHandler.SellGrid other) {
                if (other == SaleHandler.SellGrid.getDefaultInstance()) {
                    return this;
                }
                if (other.hasIndex()) {
                    setIndex(other.getIndex());
                }
                if (other.hasNum()) {
                    setNum(other.getNum());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasIndex()) {
                    return false;
                }
                if (!hasNum()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                SaleHandler.SellGrid parsedMessage = null;
                try {
                    parsedMessage = (SaleHandler.SellGrid) SaleHandler.SellGrid.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SaleHandler.SellGrid) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasIndex() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public int getIndex() {
                return this.index_;
            }


            public Builder setIndex(int value) {
                this.bitField0_ |= 0x1;
                this.index_ = value;
                onChanged();
                return this;
            }


            public Builder clearIndex() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.index_ = 0;
                onChanged();
                return this;
            }


            public boolean hasNum() {
                return ((this.bitField0_ & 0x2) == 2);
            }


            public int getNum() {
                return this.num_;
            }


            public Builder setNum(int value) {
                this.bitField0_ |= 0x2;
                this.num_ = value;
                onChanged();
                return this;
            }


            public Builder clearNum() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.num_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class BuyPageRequest
            extends GeneratedMessage
            implements BuyPageRequestOrBuilder {
        private static final BuyPageRequest defaultInstance = new BuyPageRequest(true);
        private final UnknownFieldSet unknownFields;

        private BuyPageRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private BuyPageRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static BuyPageRequest getDefaultInstance() {
            return defaultInstance;
        }

        public BuyPageRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BuyPageRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int length, limit, tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        case 8:
                            if ((mutable_bitField0_ & 0x1) != 1) {
                                this.c2SSellIndex_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x1;
                            }
                            this.c2SSellIndex_.add(Integer.valueOf(input.readInt32()));
                            break;
                        case 10:
                            length = input.readRawVarint32();
                            limit = input.pushLimit(length);
                            if ((mutable_bitField0_ & 0x1) != 1 && input.getBytesUntilLimit() > 0) {
                                this.c2SSellIndex_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x1;
                            }
                            while (input.getBytesUntilLimit() > 0)
                                this.c2SSellIndex_.add(Integer.valueOf(input.readInt32()));
                            input.popLimit(limit);
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x1) == 1)
                    this.c2SSellIndex_ = Collections.unmodifiableList(this.c2SSellIndex_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SaleHandler.internal_static_pomelo_area_BuyPageRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return SaleHandler.internal_static_pomelo_area_BuyPageRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(BuyPageRequest.class, Builder.class);
        }

        public static Parser<BuyPageRequest> PARSER = (Parser<BuyPageRequest>) new AbstractParser<BuyPageRequest>() {
            public SaleHandler.BuyPageRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SaleHandler.BuyPageRequest(input, extensionRegistry);
            }
        };
        public static final int C2S_SELLINDEX_FIELD_NUMBER = 1;
        private List<Integer> c2SSellIndex_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<BuyPageRequest> getParserForType() {
            return PARSER;
        }

        public List<Integer> getC2SSellIndexList() {
            return this.c2SSellIndex_;
        }

        public int getC2SSellIndexCount() {
            return this.c2SSellIndex_.size();
        }

        public int getC2SSellIndex(int index) {
            return ((Integer) this.c2SSellIndex_.get(index)).intValue();
        }

        private void initFields() {
            this.c2SSellIndex_ = Collections.emptyList();
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
            for (int i = 0; i < this.c2SSellIndex_.size(); i++) {
                output.writeInt32(1, ((Integer) this.c2SSellIndex_.get(i)).intValue());
            }
            getUnknownFields().writeTo(output);
        }


        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            int dataSize = 0;
            for (int i = 0; i < this.c2SSellIndex_.size(); i++) {
                dataSize += CodedOutputStream.computeInt32SizeNoTag(((Integer) this.c2SSellIndex_.get(i)).intValue());
            }
            size += dataSize;
            size += 1 * getC2SSellIndexList().size();
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static BuyPageRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (BuyPageRequest) PARSER.parseFrom(data);
        }


        public static BuyPageRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BuyPageRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static BuyPageRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (BuyPageRequest) PARSER.parseFrom(data);
        }


        public static BuyPageRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BuyPageRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static BuyPageRequest parseFrom(InputStream input) throws IOException {
            return (BuyPageRequest) PARSER.parseFrom(input);
        }


        public static BuyPageRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuyPageRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static BuyPageRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (BuyPageRequest) PARSER.parseDelimitedFrom(input);
        }


        public static BuyPageRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuyPageRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static BuyPageRequest parseFrom(CodedInputStream input) throws IOException {
            return (BuyPageRequest) PARSER.parseFrom(input);
        }


        public static BuyPageRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuyPageRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(BuyPageRequest prototype) {
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
                implements SaleHandler.BuyPageRequestOrBuilder {
            private int bitField0_;


            private List<Integer> c2SSellIndex_;


            public static final Descriptors.Descriptor getDescriptor() {
                return SaleHandler.internal_static_pomelo_area_BuyPageRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return SaleHandler.internal_static_pomelo_area_BuyPageRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(SaleHandler.BuyPageRequest.class, Builder.class);
            }


            private Builder() {
                this.c2SSellIndex_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.c2SSellIndex_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (SaleHandler.BuyPageRequest.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.c2SSellIndex_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return SaleHandler.internal_static_pomelo_area_BuyPageRequest_descriptor;
            }


            public SaleHandler.BuyPageRequest getDefaultInstanceForType() {
                return SaleHandler.BuyPageRequest.getDefaultInstance();
            }


            public SaleHandler.BuyPageRequest build() {
                SaleHandler.BuyPageRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public SaleHandler.BuyPageRequest buildPartial() {
                SaleHandler.BuyPageRequest result = new SaleHandler.BuyPageRequest(this);
                int from_bitField0_ = this.bitField0_;
                if ((this.bitField0_ & 0x1) == 1) {
                    this.c2SSellIndex_ = Collections.unmodifiableList(this.c2SSellIndex_);
                    this.bitField0_ &= 0xFFFFFFFE;
                }
                result.c2SSellIndex_ = this.c2SSellIndex_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof SaleHandler.BuyPageRequest) {
                    return mergeFrom((SaleHandler.BuyPageRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(SaleHandler.BuyPageRequest other) {
                if (other == SaleHandler.BuyPageRequest.getDefaultInstance()) {
                    return this;
                }
                if (!other.c2SSellIndex_.isEmpty()) {
                    if (this.c2SSellIndex_.isEmpty()) {
                        this.c2SSellIndex_ = other.c2SSellIndex_;
                        this.bitField0_ &= 0xFFFFFFFE;
                    } else {
                        ensureC2SSellIndexIsMutable();
                        this.c2SSellIndex_.addAll(other.c2SSellIndex_);
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
                SaleHandler.BuyPageRequest parsedMessage = null;
                try {
                    parsedMessage = (SaleHandler.BuyPageRequest) SaleHandler.BuyPageRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SaleHandler.BuyPageRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            private void ensureC2SSellIndexIsMutable() {
                if ((this.bitField0_ & 0x1) != 1) {
                    this.c2SSellIndex_ = new ArrayList<>(this.c2SSellIndex_);
                    this.bitField0_ |= 0x1;
                }
            }


            public List<Integer> getC2SSellIndexList() {
                return Collections.unmodifiableList(this.c2SSellIndex_);
            }


            public int getC2SSellIndexCount() {
                return this.c2SSellIndex_.size();
            }


            public int getC2SSellIndex(int index) {
                return ((Integer) this.c2SSellIndex_.get(index)).intValue();
            }


            public Builder setC2SSellIndex(int index, int value) {
                ensureC2SSellIndexIsMutable();
                this.c2SSellIndex_.set(index, Integer.valueOf(value));
                onChanged();
                return this;
            }


            public Builder addC2SSellIndex(int value) {
                ensureC2SSellIndexIsMutable();
                this.c2SSellIndex_.add(Integer.valueOf(value));
                onChanged();
                return this;
            }


            public Builder addAllC2SSellIndex(Iterable<? extends Integer> values) {
                ensureC2SSellIndexIsMutable();
                AbstractMessageLite.Builder.addAll(values, this.c2SSellIndex_);
                onChanged();
                return this;
            }


            public Builder clearC2SSellIndex() {
                this.c2SSellIndex_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFFE;
                onChanged();
                return this;
            }
        }
    }


    public static final class BuyPageResponse
            extends GeneratedMessage
            implements BuyPageResponseOrBuilder {
        private static final BuyPageResponse defaultInstance = new BuyPageResponse(true);
        private final UnknownFieldSet unknownFields;

        private BuyPageResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private BuyPageResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static BuyPageResponse getDefaultInstance() {
            return defaultInstance;
        }

        public BuyPageResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BuyPageResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.s2CBuyItems_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x4;
                            }
                            this.s2CBuyItems_.add(input.readMessage(SaleHandler.BuyItem.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x4) == 4)
                    this.s2CBuyItems_ = Collections.unmodifiableList(this.s2CBuyItems_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SaleHandler.internal_static_pomelo_area_BuyPageResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return SaleHandler.internal_static_pomelo_area_BuyPageResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(BuyPageResponse.class, Builder.class);
        }

        public static Parser<BuyPageResponse> PARSER = (Parser<BuyPageResponse>) new AbstractParser<BuyPageResponse>() {
            public SaleHandler.BuyPageResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SaleHandler.BuyPageResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;

        static {
            defaultInstance.initFields();
        }


        public static final int S2C_MSG_FIELD_NUMBER = 2;

        private Object s2CMsg_;

        public static final int S2C_BUYITEMS_FIELD_NUMBER = 3;

        private List<SaleHandler.BuyItem> s2CBuyItems_;

        private byte memoizedIsInitialized;

        private int memoizedSerializedSize;

        private static final long serialVersionUID = 0L;


        public Parser<BuyPageResponse> getParserForType() {
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


        public List<SaleHandler.BuyItem> getS2CBuyItemsList() {
            return this.s2CBuyItems_;
        }


        public List<? extends SaleHandler.BuyItemOrBuilder> getS2CBuyItemsOrBuilderList() {
            return (List) this.s2CBuyItems_;
        }


        public int getS2CBuyItemsCount() {
            return this.s2CBuyItems_.size();
        }


        public SaleHandler.BuyItem getS2CBuyItems(int index) {
            return this.s2CBuyItems_.get(index);
        }


        public SaleHandler.BuyItemOrBuilder getS2CBuyItemsOrBuilder(int index) {
            return this.s2CBuyItems_.get(index);
        }


        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CBuyItems_ = Collections.emptyList();
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
            for (int i = 0; i < getS2CBuyItemsCount(); i++) {
                if (!getS2CBuyItems(i).isInitialized()) {
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
            for (int i = 0; i < this.s2CBuyItems_.size(); i++) {
                output.writeMessage(3, (MessageLite) this.s2CBuyItems_.get(i));
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
            for (int i = 0; i < this.s2CBuyItems_.size(); i++) {
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.s2CBuyItems_.get(i));
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static BuyPageResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (BuyPageResponse) PARSER.parseFrom(data);
        }


        public static BuyPageResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BuyPageResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static BuyPageResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (BuyPageResponse) PARSER.parseFrom(data);
        }


        public static BuyPageResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BuyPageResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static BuyPageResponse parseFrom(InputStream input) throws IOException {
            return (BuyPageResponse) PARSER.parseFrom(input);
        }


        public static BuyPageResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuyPageResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static BuyPageResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (BuyPageResponse) PARSER.parseDelimitedFrom(input);
        }


        public static BuyPageResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuyPageResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static BuyPageResponse parseFrom(CodedInputStream input) throws IOException {
            return (BuyPageResponse) PARSER.parseFrom(input);
        }


        public static BuyPageResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuyPageResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(BuyPageResponse prototype) {
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
                implements SaleHandler.BuyPageResponseOrBuilder {
            private int bitField0_;

            private int s2CCode_;

            private Object s2CMsg_;

            private List<SaleHandler.BuyItem> s2CBuyItems_;

            private RepeatedFieldBuilder<SaleHandler.BuyItem, SaleHandler.BuyItem.Builder, SaleHandler.BuyItemOrBuilder> s2CBuyItemsBuilder_;


            public static final Descriptors.Descriptor getDescriptor() {
                return SaleHandler.internal_static_pomelo_area_BuyPageResponse_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return SaleHandler.internal_static_pomelo_area_BuyPageResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(SaleHandler.BuyPageResponse.class, Builder.class);
            }


            private Builder() {
                this.s2CMsg_ = "";
                this.s2CBuyItems_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CBuyItems_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (SaleHandler.BuyPageResponse.alwaysUseFieldBuilders) {
                    getS2CBuyItemsFieldBuilder();
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
                if (this.s2CBuyItemsBuilder_ == null) {
                    this.s2CBuyItems_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                } else {
                    this.s2CBuyItemsBuilder_.clear();
                }
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return SaleHandler.internal_static_pomelo_area_BuyPageResponse_descriptor;
            }

            public SaleHandler.BuyPageResponse getDefaultInstanceForType() {
                return SaleHandler.BuyPageResponse.getDefaultInstance();
            }

            public SaleHandler.BuyPageResponse build() {
                SaleHandler.BuyPageResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public SaleHandler.BuyPageResponse buildPartial() {
                SaleHandler.BuyPageResponse result = new SaleHandler.BuyPageResponse(this);
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
                if (this.s2CBuyItemsBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4) {
                        this.s2CBuyItems_ = Collections.unmodifiableList(this.s2CBuyItems_);
                        this.bitField0_ &= 0xFFFFFFFB;
                    }
                    result.s2CBuyItems_ = this.s2CBuyItems_;
                } else {
                    result.s2CBuyItems_ = this.s2CBuyItemsBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof SaleHandler.BuyPageResponse) {
                    return mergeFrom((SaleHandler.BuyPageResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SaleHandler.BuyPageResponse other) {
                if (other == SaleHandler.BuyPageResponse.getDefaultInstance()) {
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
                if (this.s2CBuyItemsBuilder_ == null) {
                    if (!other.s2CBuyItems_.isEmpty()) {
                        if (this.s2CBuyItems_.isEmpty()) {
                            this.s2CBuyItems_ = other.s2CBuyItems_;
                            this.bitField0_ &= 0xFFFFFFFB;
                        } else {
                            ensureS2CBuyItemsIsMutable();
                            this.s2CBuyItems_.addAll(other.s2CBuyItems_);
                        }
                        onChanged();
                    }
                } else if (!other.s2CBuyItems_.isEmpty()) {
                    if (this.s2CBuyItemsBuilder_.isEmpty()) {
                        this.s2CBuyItemsBuilder_.dispose();
                        this.s2CBuyItemsBuilder_ = null;
                        this.s2CBuyItems_ = other.s2CBuyItems_;
                        this.bitField0_ &= 0xFFFFFFFB;
                        this.s2CBuyItemsBuilder_ = SaleHandler.BuyPageResponse.alwaysUseFieldBuilders ? getS2CBuyItemsFieldBuilder() : null;
                    } else {
                        this.s2CBuyItemsBuilder_.addAllMessages(other.s2CBuyItems_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode()) {
                    return false;
                }
                for (int i = 0; i < getS2CBuyItemsCount(); i++) {
                    if (!getS2CBuyItems(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                SaleHandler.BuyPageResponse parsedMessage = null;
                try {
                    parsedMessage = (SaleHandler.BuyPageResponse) SaleHandler.BuyPageResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SaleHandler.BuyPageResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = SaleHandler.BuyPageResponse.getDefaultInstance().getS2CMsg();
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

            private void ensureS2CBuyItemsIsMutable() {
                if ((this.bitField0_ & 0x4) != 4) {
                    this.s2CBuyItems_ = new ArrayList<>(this.s2CBuyItems_);
                    this.bitField0_ |= 0x4;
                }
            }

            public List<SaleHandler.BuyItem> getS2CBuyItemsList() {
                if (this.s2CBuyItemsBuilder_ == null) {
                    return Collections.unmodifiableList(this.s2CBuyItems_);
                }
                return this.s2CBuyItemsBuilder_.getMessageList();
            }

            public int getS2CBuyItemsCount() {
                if (this.s2CBuyItemsBuilder_ == null) {
                    return this.s2CBuyItems_.size();
                }
                return this.s2CBuyItemsBuilder_.getCount();
            }

            public SaleHandler.BuyItem getS2CBuyItems(int index) {
                if (this.s2CBuyItemsBuilder_ == null) {
                    return this.s2CBuyItems_.get(index);
                }
                return (SaleHandler.BuyItem) this.s2CBuyItemsBuilder_.getMessage(index);
            }

            public Builder setS2CBuyItems(int index, SaleHandler.BuyItem value) {
                if (this.s2CBuyItemsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureS2CBuyItemsIsMutable();
                    this.s2CBuyItems_.set(index, value);
                    onChanged();
                } else {
                    this.s2CBuyItemsBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setS2CBuyItems(int index, SaleHandler.BuyItem.Builder builderForValue) {
                if (this.s2CBuyItemsBuilder_ == null) {
                    ensureS2CBuyItemsIsMutable();
                    this.s2CBuyItems_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CBuyItemsBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addS2CBuyItems(SaleHandler.BuyItem value) {
                if (this.s2CBuyItemsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureS2CBuyItemsIsMutable();
                    this.s2CBuyItems_.add(value);
                    onChanged();
                } else {
                    this.s2CBuyItemsBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addS2CBuyItems(int index, SaleHandler.BuyItem value) {
                if (this.s2CBuyItemsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureS2CBuyItemsIsMutable();
                    this.s2CBuyItems_.add(index, value);
                    onChanged();
                } else {
                    this.s2CBuyItemsBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addS2CBuyItems(SaleHandler.BuyItem.Builder builderForValue) {
                if (this.s2CBuyItemsBuilder_ == null) {
                    ensureS2CBuyItemsIsMutable();
                    this.s2CBuyItems_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.s2CBuyItemsBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addS2CBuyItems(int index, SaleHandler.BuyItem.Builder builderForValue) {
                if (this.s2CBuyItemsBuilder_ == null) {
                    ensureS2CBuyItemsIsMutable();
                    this.s2CBuyItems_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CBuyItemsBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllS2CBuyItems(Iterable<? extends SaleHandler.BuyItem> values) {
                if (this.s2CBuyItemsBuilder_ == null) {
                    ensureS2CBuyItemsIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.s2CBuyItems_);
                    onChanged();
                } else {
                    this.s2CBuyItemsBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearS2CBuyItems() {
                if (this.s2CBuyItemsBuilder_ == null) {
                    this.s2CBuyItems_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                    onChanged();
                } else {
                    this.s2CBuyItemsBuilder_.clear();
                }
                return this;
            }

            public Builder removeS2CBuyItems(int index) {
                if (this.s2CBuyItemsBuilder_ == null) {
                    ensureS2CBuyItemsIsMutable();
                    this.s2CBuyItems_.remove(index);
                    onChanged();
                } else {
                    this.s2CBuyItemsBuilder_.remove(index);
                }
                return this;
            }

            public SaleHandler.BuyItem.Builder getS2CBuyItemsBuilder(int index) {
                return (SaleHandler.BuyItem.Builder) getS2CBuyItemsFieldBuilder().getBuilder(index);
            }

            public SaleHandler.BuyItemOrBuilder getS2CBuyItemsOrBuilder(int index) {
                if (this.s2CBuyItemsBuilder_ == null) {
                    return this.s2CBuyItems_.get(index);
                }
                return (SaleHandler.BuyItemOrBuilder) this.s2CBuyItemsBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends SaleHandler.BuyItemOrBuilder> getS2CBuyItemsOrBuilderList() {
                if (this.s2CBuyItemsBuilder_ != null) {
                    return this.s2CBuyItemsBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList((List) this.s2CBuyItems_);
            }

            public SaleHandler.BuyItem.Builder addS2CBuyItemsBuilder() {
                return (SaleHandler.BuyItem.Builder) getS2CBuyItemsFieldBuilder().addBuilder(SaleHandler.BuyItem.getDefaultInstance());
            }

            public SaleHandler.BuyItem.Builder addS2CBuyItemsBuilder(int index) {
                return (SaleHandler.BuyItem.Builder) getS2CBuyItemsFieldBuilder().addBuilder(index, SaleHandler.BuyItem.getDefaultInstance());
            }

            public List<SaleHandler.BuyItem.Builder> getS2CBuyItemsBuilderList() {
                return getS2CBuyItemsFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<SaleHandler.BuyItem, SaleHandler.BuyItem.Builder, SaleHandler.BuyItemOrBuilder> getS2CBuyItemsFieldBuilder() {
                if (this.s2CBuyItemsBuilder_ == null) {
                    this.s2CBuyItemsBuilder_ = new RepeatedFieldBuilder(this.s2CBuyItems_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
                    this.s2CBuyItems_ = null;
                }
                return this.s2CBuyItemsBuilder_;
            }
        }
    }

    public static final class BuyItemRequest
            extends GeneratedMessage
            implements BuyItemRequestOrBuilder {
        private static final BuyItemRequest defaultInstance = new BuyItemRequest(true);
        private final UnknownFieldSet unknownFields;

        private BuyItemRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private BuyItemRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static BuyItemRequest getDefaultInstance() {
            return defaultInstance;
        }

        public BuyItemRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BuyItemRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.c2STypeId_ = input.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.c2SItemId_ = input.readInt32();
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.c2SNum_ = input.readInt32();
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
            return SaleHandler.internal_static_pomelo_area_BuyItemRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return SaleHandler.internal_static_pomelo_area_BuyItemRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(BuyItemRequest.class, Builder.class);
        }

        public static Parser<BuyItemRequest> PARSER = (Parser<BuyItemRequest>) new AbstractParser<BuyItemRequest>() {
            public SaleHandler.BuyItemRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SaleHandler.BuyItemRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_TYPEID_FIELD_NUMBER = 1;
        private int c2STypeId_;
        public static final int C2S_ITEMID_FIELD_NUMBER = 2;
        private int c2SItemId_;
        public static final int C2S_NUM_FIELD_NUMBER = 3;
        private int c2SNum_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<BuyItemRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasC2STypeId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getC2STypeId() {
            return this.c2STypeId_;
        }

        public boolean hasC2SItemId() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        static {
            defaultInstance.initFields();
        }


        public int getC2SItemId() {
            return this.c2SItemId_;
        }


        public boolean hasC2SNum() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public int getC2SNum() {
            return this.c2SNum_;
        }


        private void initFields() {
            this.c2STypeId_ = 0;
            this.c2SItemId_ = 0;
            this.c2SNum_ = 0;
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasC2STypeId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasC2SItemId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasC2SNum()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeInt32(1, this.c2STypeId_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeInt32(2, this.c2SItemId_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeInt32(3, this.c2SNum_);
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
                size += CodedOutputStream.computeInt32Size(1, this.c2STypeId_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeInt32Size(2, this.c2SItemId_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                size += CodedOutputStream.computeInt32Size(3, this.c2SNum_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static BuyItemRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (BuyItemRequest) PARSER.parseFrom(data);
        }


        public static BuyItemRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BuyItemRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static BuyItemRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (BuyItemRequest) PARSER.parseFrom(data);
        }


        public static BuyItemRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BuyItemRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static BuyItemRequest parseFrom(InputStream input) throws IOException {
            return (BuyItemRequest) PARSER.parseFrom(input);
        }


        public static BuyItemRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuyItemRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static BuyItemRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (BuyItemRequest) PARSER.parseDelimitedFrom(input);
        }


        public static BuyItemRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuyItemRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static BuyItemRequest parseFrom(CodedInputStream input) throws IOException {
            return (BuyItemRequest) PARSER.parseFrom(input);
        }


        public static BuyItemRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuyItemRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(BuyItemRequest prototype) {
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
                implements SaleHandler.BuyItemRequestOrBuilder {
            private int bitField0_;


            private int c2STypeId_;


            private int c2SItemId_;


            private int c2SNum_;


            public static final Descriptors.Descriptor getDescriptor() {
                return SaleHandler.internal_static_pomelo_area_BuyItemRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return SaleHandler.internal_static_pomelo_area_BuyItemRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(SaleHandler.BuyItemRequest.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (SaleHandler.BuyItemRequest.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.c2STypeId_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SItemId_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                this.c2SNum_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return SaleHandler.internal_static_pomelo_area_BuyItemRequest_descriptor;
            }


            public SaleHandler.BuyItemRequest getDefaultInstanceForType() {
                return SaleHandler.BuyItemRequest.getDefaultInstance();
            }


            public SaleHandler.BuyItemRequest build() {
                SaleHandler.BuyItemRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public SaleHandler.BuyItemRequest buildPartial() {
                SaleHandler.BuyItemRequest result = new SaleHandler.BuyItemRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.c2STypeId_ = this.c2STypeId_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.c2SItemId_ = this.c2SItemId_;
                if ((from_bitField0_ & 0x4) == 4) {
                    to_bitField0_ |= 0x4;
                }
                result.c2SNum_ = this.c2SNum_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof SaleHandler.BuyItemRequest) {
                    return mergeFrom((SaleHandler.BuyItemRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(SaleHandler.BuyItemRequest other) {
                if (other == SaleHandler.BuyItemRequest.getDefaultInstance()) {
                    return this;
                }
                if (other.hasC2STypeId()) {
                    setC2STypeId(other.getC2STypeId());
                }
                if (other.hasC2SItemId()) {
                    setC2SItemId(other.getC2SItemId());
                }
                if (other.hasC2SNum()) {
                    setC2SNum(other.getC2SNum());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasC2STypeId()) {
                    return false;
                }
                if (!hasC2SItemId()) {
                    return false;
                }
                if (!hasC2SNum()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                SaleHandler.BuyItemRequest parsedMessage = null;
                try {
                    parsedMessage = (SaleHandler.BuyItemRequest) SaleHandler.BuyItemRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SaleHandler.BuyItemRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasC2STypeId() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public int getC2STypeId() {
                return this.c2STypeId_;
            }


            public Builder setC2STypeId(int value) {
                this.bitField0_ |= 0x1;
                this.c2STypeId_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2STypeId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2STypeId_ = 0;
                onChanged();
                return this;
            }


            public boolean hasC2SItemId() {
                return ((this.bitField0_ & 0x2) == 2);
            }


            public int getC2SItemId() {
                return this.c2SItemId_;
            }


            public Builder setC2SItemId(int value) {
                this.bitField0_ |= 0x2;
                this.c2SItemId_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SItemId() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.c2SItemId_ = 0;
                onChanged();
                return this;
            }


            public boolean hasC2SNum() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public int getC2SNum() {
                return this.c2SNum_;
            }


            public Builder setC2SNum(int value) {
                this.bitField0_ |= 0x4;
                this.c2SNum_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SNum() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.c2SNum_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class BuyItemResponse
            extends GeneratedMessage
            implements BuyItemResponseOrBuilder {
        private static final BuyItemResponse defaultInstance = new BuyItemResponse(true);
        private final UnknownFieldSet unknownFields;

        private BuyItemResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private BuyItemResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static BuyItemResponse getDefaultInstance() {
            return defaultInstance;
        }

        public BuyItemResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BuyItemResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return SaleHandler.internal_static_pomelo_area_BuyItemResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return SaleHandler.internal_static_pomelo_area_BuyItemResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(BuyItemResponse.class, Builder.class);
        }

        public static Parser<BuyItemResponse> PARSER = (Parser<BuyItemResponse>) new AbstractParser<BuyItemResponse>() {
            public SaleHandler.BuyItemResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SaleHandler.BuyItemResponse(input, extensionRegistry);
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

        public Parser<BuyItemResponse> getParserForType() {
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


        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
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
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static BuyItemResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (BuyItemResponse) PARSER.parseFrom(data);
        }


        public static BuyItemResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BuyItemResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static BuyItemResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (BuyItemResponse) PARSER.parseFrom(data);
        }


        public static BuyItemResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BuyItemResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static BuyItemResponse parseFrom(InputStream input) throws IOException {
            return (BuyItemResponse) PARSER.parseFrom(input);
        }


        public static BuyItemResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuyItemResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static BuyItemResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (BuyItemResponse) PARSER.parseDelimitedFrom(input);
        }


        public static BuyItemResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuyItemResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static BuyItemResponse parseFrom(CodedInputStream input) throws IOException {
            return (BuyItemResponse) PARSER.parseFrom(input);
        }


        public static BuyItemResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuyItemResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(BuyItemResponse prototype) {
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
                implements SaleHandler.BuyItemResponseOrBuilder {
            private int bitField0_;


            private int s2CCode_;


            private Object s2CMsg_;


            public static final Descriptors.Descriptor getDescriptor() {
                return SaleHandler.internal_static_pomelo_area_BuyItemResponse_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return SaleHandler.internal_static_pomelo_area_BuyItemResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(SaleHandler.BuyItemResponse.class, Builder.class);
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
                if (SaleHandler.BuyItemResponse.alwaysUseFieldBuilders) ;
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
                return SaleHandler.internal_static_pomelo_area_BuyItemResponse_descriptor;
            }


            public SaleHandler.BuyItemResponse getDefaultInstanceForType() {
                return SaleHandler.BuyItemResponse.getDefaultInstance();
            }


            public SaleHandler.BuyItemResponse build() {
                SaleHandler.BuyItemResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public SaleHandler.BuyItemResponse buildPartial() {
                SaleHandler.BuyItemResponse result = new SaleHandler.BuyItemResponse(this);
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
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof SaleHandler.BuyItemResponse) {
                    return mergeFrom((SaleHandler.BuyItemResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(SaleHandler.BuyItemResponse other) {
                if (other == SaleHandler.BuyItemResponse.getDefaultInstance()) {
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
                SaleHandler.BuyItemResponse parsedMessage = null;
                try {
                    parsedMessage = (SaleHandler.BuyItemResponse) SaleHandler.BuyItemResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SaleHandler.BuyItemResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = SaleHandler.BuyItemResponse.getDefaultInstance().getS2CMsg();
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
        }
    }


    public static final class AutoBuyItemByCodeRequest
            extends GeneratedMessage
            implements AutoBuyItemByCodeRequestOrBuilder {
        private static final AutoBuyItemByCodeRequest defaultInstance = new AutoBuyItemByCodeRequest(true);
        private final UnknownFieldSet unknownFields;

        private AutoBuyItemByCodeRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private AutoBuyItemByCodeRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static AutoBuyItemByCodeRequest getDefaultInstance() {
            return defaultInstance;
        }

        public AutoBuyItemByCodeRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AutoBuyItemByCodeRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int length;
                    ByteString bs;
                    int limit, tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        case 8:
                            if ((mutable_bitField0_ & 0x1) != 1) {
                                this.c2STypeId_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x1;
                            }
                            this.c2STypeId_.add(Integer.valueOf(input.readInt32()));
                            break;
                        case 10:
                            length = input.readRawVarint32();
                            limit = input.pushLimit(length);
                            if ((mutable_bitField0_ & 0x1) != 1 && input.getBytesUntilLimit() > 0) {
                                this.c2STypeId_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x1;
                            }
                            while (input.getBytesUntilLimit() > 0)
                                this.c2STypeId_.add(Integer.valueOf(input.readInt32()));
                            input.popLimit(limit);
                            break;
                        case 18:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x1;
                            this.c2SItemCode_ = bs;
                            break;
                        case 24:
                            this.bitField0_ |= 0x2;
                            this.c2SNum_ = input.readInt32();
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x1) == 1) this.c2STypeId_ = Collections.unmodifiableList(this.c2STypeId_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SaleHandler.internal_static_pomelo_area_AutoBuyItemByCodeRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return SaleHandler.internal_static_pomelo_area_AutoBuyItemByCodeRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(AutoBuyItemByCodeRequest.class, Builder.class);
        }

        public static Parser<AutoBuyItemByCodeRequest> PARSER = (Parser<AutoBuyItemByCodeRequest>) new AbstractParser<AutoBuyItemByCodeRequest>() {
            public SaleHandler.AutoBuyItemByCodeRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SaleHandler.AutoBuyItemByCodeRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_TYPEID_FIELD_NUMBER = 1;
        private List<Integer> c2STypeId_;
        public static final int C2S_ITEMCODE_FIELD_NUMBER = 2;
        private Object c2SItemCode_;
        public static final int C2S_NUM_FIELD_NUMBER = 3;
        private int c2SNum_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<AutoBuyItemByCodeRequest> getParserForType() {
            return PARSER;
        }

        public List<Integer> getC2STypeIdList() {
            return this.c2STypeId_;
        }

        public int getC2STypeIdCount() {
            return this.c2STypeId_.size();
        }

        public int getC2STypeId(int index) {
            return ((Integer) this.c2STypeId_.get(index)).intValue();
        }

        public boolean hasC2SItemCode() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        static {
            defaultInstance.initFields();
        }


        public String getC2SItemCode() {
            Object ref = this.c2SItemCode_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.c2SItemCode_ = s;
            }
            return s;
        }


        public ByteString getC2SItemCodeBytes() {
            Object ref = this.c2SItemCode_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.c2SItemCode_ = b;
                return b;
            }
            return (ByteString) ref;
        }


        public boolean hasC2SNum() {
            return ((this.bitField0_ & 0x2) == 2);
        }


        public int getC2SNum() {
            return this.c2SNum_;
        }


        private void initFields() {
            this.c2STypeId_ = Collections.emptyList();
            this.c2SItemCode_ = "";
            this.c2SNum_ = 0;
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasC2SItemCode()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasC2SNum()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            for (int i = 0; i < this.c2STypeId_.size(); i++) {
                output.writeInt32(1, ((Integer) this.c2STypeId_.get(i)).intValue());
            }
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeBytes(2, getC2SItemCodeBytes());
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeInt32(3, this.c2SNum_);
            }
            getUnknownFields().writeTo(output);
        }


        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            int dataSize = 0;
            for (int i = 0; i < this.c2STypeId_.size(); i++) {
                dataSize += CodedOutputStream.computeInt32SizeNoTag(((Integer) this.c2STypeId_.get(i)).intValue());
            }
            size += dataSize;
            size += 1 * getC2STypeIdList().size();
            if ((this.bitField0_ & 0x1) == 1) {
                size += CodedOutputStream.computeBytesSize(2, getC2SItemCodeBytes());
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeInt32Size(3, this.c2SNum_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static AutoBuyItemByCodeRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (AutoBuyItemByCodeRequest) PARSER.parseFrom(data);
        }


        public static AutoBuyItemByCodeRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AutoBuyItemByCodeRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static AutoBuyItemByCodeRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (AutoBuyItemByCodeRequest) PARSER.parseFrom(data);
        }


        public static AutoBuyItemByCodeRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AutoBuyItemByCodeRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static AutoBuyItemByCodeRequest parseFrom(InputStream input) throws IOException {
            return (AutoBuyItemByCodeRequest) PARSER.parseFrom(input);
        }


        public static AutoBuyItemByCodeRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AutoBuyItemByCodeRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static AutoBuyItemByCodeRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (AutoBuyItemByCodeRequest) PARSER.parseDelimitedFrom(input);
        }


        public static AutoBuyItemByCodeRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AutoBuyItemByCodeRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static AutoBuyItemByCodeRequest parseFrom(CodedInputStream input) throws IOException {
            return (AutoBuyItemByCodeRequest) PARSER.parseFrom(input);
        }


        public static AutoBuyItemByCodeRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AutoBuyItemByCodeRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(AutoBuyItemByCodeRequest prototype) {
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
                implements SaleHandler.AutoBuyItemByCodeRequestOrBuilder {
            private int bitField0_;


            private List<Integer> c2STypeId_;


            private Object c2SItemCode_;


            private int c2SNum_;


            public static final Descriptors.Descriptor getDescriptor() {
                return SaleHandler.internal_static_pomelo_area_AutoBuyItemByCodeRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return SaleHandler.internal_static_pomelo_area_AutoBuyItemByCodeRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(SaleHandler.AutoBuyItemByCodeRequest.class, Builder.class);
            }


            private Builder() {
                this.c2STypeId_ = Collections.emptyList();
                this.c2SItemCode_ = "";
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.c2STypeId_ = Collections.emptyList();
                this.c2SItemCode_ = "";
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (SaleHandler.AutoBuyItemByCodeRequest.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.c2STypeId_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SItemCode_ = "";
                this.bitField0_ &= 0xFFFFFFFD;
                this.c2SNum_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return SaleHandler.internal_static_pomelo_area_AutoBuyItemByCodeRequest_descriptor;
            }


            public SaleHandler.AutoBuyItemByCodeRequest getDefaultInstanceForType() {
                return SaleHandler.AutoBuyItemByCodeRequest.getDefaultInstance();
            }


            public SaleHandler.AutoBuyItemByCodeRequest build() {
                SaleHandler.AutoBuyItemByCodeRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public SaleHandler.AutoBuyItemByCodeRequest buildPartial() {
                SaleHandler.AutoBuyItemByCodeRequest result = new SaleHandler.AutoBuyItemByCodeRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((this.bitField0_ & 0x1) == 1) {
                    this.c2STypeId_ = Collections.unmodifiableList(this.c2STypeId_);
                    this.bitField0_ &= 0xFFFFFFFE;
                }
                result.c2STypeId_ = this.c2STypeId_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x1;
                }
                result.c2SItemCode_ = this.c2SItemCode_;
                if ((from_bitField0_ & 0x4) == 4) {
                    to_bitField0_ |= 0x2;
                }
                result.c2SNum_ = this.c2SNum_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof SaleHandler.AutoBuyItemByCodeRequest) {
                    return mergeFrom((SaleHandler.AutoBuyItemByCodeRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(SaleHandler.AutoBuyItemByCodeRequest other) {
                if (other == SaleHandler.AutoBuyItemByCodeRequest.getDefaultInstance()) {
                    return this;
                }
                if (!other.c2STypeId_.isEmpty()) {
                    if (this.c2STypeId_.isEmpty()) {
                        this.c2STypeId_ = other.c2STypeId_;
                        this.bitField0_ &= 0xFFFFFFFE;
                    } else {
                        ensureC2STypeIdIsMutable();
                        this.c2STypeId_.addAll(other.c2STypeId_);
                    }
                    onChanged();
                }
                if (other.hasC2SItemCode()) {
                    this.bitField0_ |= 0x2;
                    this.c2SItemCode_ = other.c2SItemCode_;
                    onChanged();
                }
                if (other.hasC2SNum()) {
                    setC2SNum(other.getC2SNum());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasC2SItemCode()) {
                    return false;
                }
                if (!hasC2SNum()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                SaleHandler.AutoBuyItemByCodeRequest parsedMessage = null;
                try {
                    parsedMessage = (SaleHandler.AutoBuyItemByCodeRequest) SaleHandler.AutoBuyItemByCodeRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SaleHandler.AutoBuyItemByCodeRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            private void ensureC2STypeIdIsMutable() {
                if ((this.bitField0_ & 0x1) != 1) {
                    this.c2STypeId_ = new ArrayList<>(this.c2STypeId_);
                    this.bitField0_ |= 0x1;
                }
            }


            public List<Integer> getC2STypeIdList() {
                return Collections.unmodifiableList(this.c2STypeId_);
            }


            public int getC2STypeIdCount() {
                return this.c2STypeId_.size();
            }


            public int getC2STypeId(int index) {
                return ((Integer) this.c2STypeId_.get(index)).intValue();
            }


            public Builder setC2STypeId(int index, int value) {
                ensureC2STypeIdIsMutable();
                this.c2STypeId_.set(index, Integer.valueOf(value));
                onChanged();
                return this;
            }


            public Builder addC2STypeId(int value) {
                ensureC2STypeIdIsMutable();
                this.c2STypeId_.add(Integer.valueOf(value));
                onChanged();
                return this;
            }


            public Builder addAllC2STypeId(Iterable<? extends Integer> values) {
                ensureC2STypeIdIsMutable();
                AbstractMessageLite.Builder.addAll(values, this.c2STypeId_);
                onChanged();
                return this;
            }


            public Builder clearC2STypeId() {
                this.c2STypeId_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFFE;
                onChanged();
                return this;
            }


            public boolean hasC2SItemCode() {
                return ((this.bitField0_ & 0x2) == 2);
            }


            public String getC2SItemCode() {
                Object ref = this.c2SItemCode_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.c2SItemCode_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }


            public ByteString getC2SItemCodeBytes() {
                Object ref = this.c2SItemCode_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.c2SItemCode_ = b;
                    return b;
                }
                return (ByteString) ref;
            }


            public Builder setC2SItemCode(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x2;
                this.c2SItemCode_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SItemCode() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.c2SItemCode_ = SaleHandler.AutoBuyItemByCodeRequest.getDefaultInstance().getC2SItemCode();
                onChanged();
                return this;
            }


            public Builder setC2SItemCodeBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x2;
                this.c2SItemCode_ = value;
                onChanged();
                return this;
            }


            public boolean hasC2SNum() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public int getC2SNum() {
                return this.c2SNum_;
            }


            public Builder setC2SNum(int value) {
                this.bitField0_ |= 0x4;
                this.c2SNum_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SNum() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.c2SNum_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class AutoBuyItemByCodeResponse
            extends GeneratedMessage
            implements AutoBuyItemByCodeResponseOrBuilder {
        private static final AutoBuyItemByCodeResponse defaultInstance = new AutoBuyItemByCodeResponse(true);
        private final UnknownFieldSet unknownFields;

        private AutoBuyItemByCodeResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private AutoBuyItemByCodeResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static AutoBuyItemByCodeResponse getDefaultInstance() {
            return defaultInstance;
        }

        public AutoBuyItemByCodeResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AutoBuyItemByCodeResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.s2CNotEnoughGold_ = input.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.s2CNeedGold_ = input.readInt32();
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
            return SaleHandler.internal_static_pomelo_area_AutoBuyItemByCodeResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return SaleHandler.internal_static_pomelo_area_AutoBuyItemByCodeResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(AutoBuyItemByCodeResponse.class, Builder.class);
        }

        public static Parser<AutoBuyItemByCodeResponse> PARSER = (Parser<AutoBuyItemByCodeResponse>) new AbstractParser<AutoBuyItemByCodeResponse>() {
            public SaleHandler.AutoBuyItemByCodeResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SaleHandler.AutoBuyItemByCodeResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_NOTENOUGHGOLD_FIELD_NUMBER = 3;
        private int s2CNotEnoughGold_;
        public static final int S2C_NEEDGOLD_FIELD_NUMBER = 4;
        private int s2CNeedGold_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<AutoBuyItemByCodeResponse> getParserForType() {
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


        public boolean hasS2CNotEnoughGold() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public int getS2CNotEnoughGold() {
            return this.s2CNotEnoughGold_;
        }


        public boolean hasS2CNeedGold() {
            return ((this.bitField0_ & 0x8) == 8);
        }


        public int getS2CNeedGold() {
            return this.s2CNeedGold_;
        }


        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CNotEnoughGold_ = 0;
            this.s2CNeedGold_ = 0;
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
                output.writeInt32(3, this.s2CNotEnoughGold_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                output.writeInt32(4, this.s2CNeedGold_);
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
                size += CodedOutputStream.computeInt32Size(3, this.s2CNotEnoughGold_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                size += CodedOutputStream.computeInt32Size(4, this.s2CNeedGold_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static AutoBuyItemByCodeResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (AutoBuyItemByCodeResponse) PARSER.parseFrom(data);
        }


        public static AutoBuyItemByCodeResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AutoBuyItemByCodeResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static AutoBuyItemByCodeResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (AutoBuyItemByCodeResponse) PARSER.parseFrom(data);
        }


        public static AutoBuyItemByCodeResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AutoBuyItemByCodeResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static AutoBuyItemByCodeResponse parseFrom(InputStream input) throws IOException {
            return (AutoBuyItemByCodeResponse) PARSER.parseFrom(input);
        }


        public static AutoBuyItemByCodeResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AutoBuyItemByCodeResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static AutoBuyItemByCodeResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (AutoBuyItemByCodeResponse) PARSER.parseDelimitedFrom(input);
        }


        public static AutoBuyItemByCodeResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AutoBuyItemByCodeResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static AutoBuyItemByCodeResponse parseFrom(CodedInputStream input) throws IOException {
            return (AutoBuyItemByCodeResponse) PARSER.parseFrom(input);
        }


        public static AutoBuyItemByCodeResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AutoBuyItemByCodeResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(AutoBuyItemByCodeResponse prototype) {
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
                implements SaleHandler.AutoBuyItemByCodeResponseOrBuilder {
            private int bitField0_;


            private int s2CCode_;


            private Object s2CMsg_;


            private int s2CNotEnoughGold_;


            private int s2CNeedGold_;


            public static final Descriptors.Descriptor getDescriptor() {
                return SaleHandler.internal_static_pomelo_area_AutoBuyItemByCodeResponse_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return SaleHandler.internal_static_pomelo_area_AutoBuyItemByCodeResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(SaleHandler.AutoBuyItemByCodeResponse.class, Builder.class);
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
                if (SaleHandler.AutoBuyItemByCodeResponse.alwaysUseFieldBuilders) ;
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
                this.s2CNotEnoughGold_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.s2CNeedGold_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return SaleHandler.internal_static_pomelo_area_AutoBuyItemByCodeResponse_descriptor;
            }


            public SaleHandler.AutoBuyItemByCodeResponse getDefaultInstanceForType() {
                return SaleHandler.AutoBuyItemByCodeResponse.getDefaultInstance();
            }


            public SaleHandler.AutoBuyItemByCodeResponse build() {
                SaleHandler.AutoBuyItemByCodeResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public SaleHandler.AutoBuyItemByCodeResponse buildPartial() {
                SaleHandler.AutoBuyItemByCodeResponse result = new SaleHandler.AutoBuyItemByCodeResponse(this);
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
                result.s2CNotEnoughGold_ = this.s2CNotEnoughGold_;
                if ((from_bitField0_ & 0x8) == 8) {
                    to_bitField0_ |= 0x8;
                }
                result.s2CNeedGold_ = this.s2CNeedGold_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof SaleHandler.AutoBuyItemByCodeResponse) {
                    return mergeFrom((SaleHandler.AutoBuyItemByCodeResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(SaleHandler.AutoBuyItemByCodeResponse other) {
                if (other == SaleHandler.AutoBuyItemByCodeResponse.getDefaultInstance()) {
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
                if (other.hasS2CNotEnoughGold()) {
                    setS2CNotEnoughGold(other.getS2CNotEnoughGold());
                }
                if (other.hasS2CNeedGold()) {
                    setS2CNeedGold(other.getS2CNeedGold());
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
                SaleHandler.AutoBuyItemByCodeResponse parsedMessage = null;
                try {
                    parsedMessage = (SaleHandler.AutoBuyItemByCodeResponse) SaleHandler.AutoBuyItemByCodeResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SaleHandler.AutoBuyItemByCodeResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = SaleHandler.AutoBuyItemByCodeResponse.getDefaultInstance().getS2CMsg();
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


            public boolean hasS2CNotEnoughGold() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public int getS2CNotEnoughGold() {
                return this.s2CNotEnoughGold_;
            }


            public Builder setS2CNotEnoughGold(int value) {
                this.bitField0_ |= 0x4;
                this.s2CNotEnoughGold_ = value;
                onChanged();
                return this;
            }


            public Builder clearS2CNotEnoughGold() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.s2CNotEnoughGold_ = 0;
                onChanged();
                return this;
            }


            public boolean hasS2CNeedGold() {
                return ((this.bitField0_ & 0x8) == 8);
            }


            public int getS2CNeedGold() {
                return this.s2CNeedGold_;
            }


            public Builder setS2CNeedGold(int value) {
                this.bitField0_ |= 0x8;
                this.s2CNeedGold_ = value;
                onChanged();
                return this;
            }


            public Builder clearS2CNeedGold() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.s2CNeedGold_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class SellItemsRequest
            extends GeneratedMessage
            implements SellItemsRequestOrBuilder {
        private static final SellItemsRequest defaultInstance = new SellItemsRequest(true);
        private final UnknownFieldSet unknownFields;

        private SellItemsRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private SellItemsRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static SellItemsRequest getDefaultInstance() {
            return defaultInstance;
        }

        public SellItemsRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SellItemsRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.c2SSellGrids_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x1;
                            }
                            this.c2SSellGrids_.add(input.readMessage(SaleHandler.SellGrid.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x1) == 1)
                    this.c2SSellGrids_ = Collections.unmodifiableList(this.c2SSellGrids_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SaleHandler.internal_static_pomelo_area_SellItemsRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return SaleHandler.internal_static_pomelo_area_SellItemsRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(SellItemsRequest.class, Builder.class);
        }

        public static Parser<SellItemsRequest> PARSER = (Parser<SellItemsRequest>) new AbstractParser<SellItemsRequest>() {
            public SaleHandler.SellItemsRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SaleHandler.SellItemsRequest(input, extensionRegistry);
            }
        };
        public static final int C2S_SELLGRIDS_FIELD_NUMBER = 1;
        private List<SaleHandler.SellGrid> c2SSellGrids_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<SellItemsRequest> getParserForType() {
            return PARSER;
        }

        public List<SaleHandler.SellGrid> getC2SSellGridsList() {
            return this.c2SSellGrids_;
        }

        public List<? extends SaleHandler.SellGridOrBuilder> getC2SSellGridsOrBuilderList() {
            return (List) this.c2SSellGrids_;
        }

        public int getC2SSellGridsCount() {
            return this.c2SSellGrids_.size();
        }

        public SaleHandler.SellGrid getC2SSellGrids(int index) {
            return this.c2SSellGrids_.get(index);
        }

        public SaleHandler.SellGridOrBuilder getC2SSellGridsOrBuilder(int index) {
            return this.c2SSellGrids_.get(index);
        }

        static {
            defaultInstance.initFields();
        }


        private void initFields() {
            this.c2SSellGrids_ = Collections.emptyList();
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            for (int i = 0; i < getC2SSellGridsCount(); i++) {
                if (!getC2SSellGrids(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            for (int i = 0; i < this.c2SSellGrids_.size(); i++) {
                output.writeMessage(1, (MessageLite) this.c2SSellGrids_.get(i));
            }
            getUnknownFields().writeTo(output);
        }


        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            for (int i = 0; i < this.c2SSellGrids_.size(); i++) {
                size += CodedOutputStream.computeMessageSize(1, (MessageLite) this.c2SSellGrids_.get(i));
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static SellItemsRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (SellItemsRequest) PARSER.parseFrom(data);
        }


        public static SellItemsRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SellItemsRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static SellItemsRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (SellItemsRequest) PARSER.parseFrom(data);
        }


        public static SellItemsRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SellItemsRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static SellItemsRequest parseFrom(InputStream input) throws IOException {
            return (SellItemsRequest) PARSER.parseFrom(input);
        }


        public static SellItemsRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SellItemsRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static SellItemsRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (SellItemsRequest) PARSER.parseDelimitedFrom(input);
        }


        public static SellItemsRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SellItemsRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static SellItemsRequest parseFrom(CodedInputStream input) throws IOException {
            return (SellItemsRequest) PARSER.parseFrom(input);
        }


        public static SellItemsRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SellItemsRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(SellItemsRequest prototype) {
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
                implements SaleHandler.SellItemsRequestOrBuilder {
            private int bitField0_;


            private List<SaleHandler.SellGrid> c2SSellGrids_;


            private RepeatedFieldBuilder<SaleHandler.SellGrid, SaleHandler.SellGrid.Builder, SaleHandler.SellGridOrBuilder> c2SSellGridsBuilder_;


            public static final Descriptors.Descriptor getDescriptor() {
                return SaleHandler.internal_static_pomelo_area_SellItemsRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return SaleHandler.internal_static_pomelo_area_SellItemsRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(SaleHandler.SellItemsRequest.class, Builder.class);
            }


            private Builder() {
                this.c2SSellGrids_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.c2SSellGrids_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (SaleHandler.SellItemsRequest.alwaysUseFieldBuilders) {
                    getC2SSellGridsFieldBuilder();
                }
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                if (this.c2SSellGridsBuilder_ == null) {
                    this.c2SSellGrids_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFE;
                } else {
                    this.c2SSellGridsBuilder_.clear();
                }
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return SaleHandler.internal_static_pomelo_area_SellItemsRequest_descriptor;
            }


            public SaleHandler.SellItemsRequest getDefaultInstanceForType() {
                return SaleHandler.SellItemsRequest.getDefaultInstance();
            }


            public SaleHandler.SellItemsRequest build() {
                SaleHandler.SellItemsRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public SaleHandler.SellItemsRequest buildPartial() {
                SaleHandler.SellItemsRequest result = new SaleHandler.SellItemsRequest(this);
                int from_bitField0_ = this.bitField0_;
                if (this.c2SSellGridsBuilder_ == null) {
                    if ((this.bitField0_ & 0x1) == 1) {
                        this.c2SSellGrids_ = Collections.unmodifiableList(this.c2SSellGrids_);
                        this.bitField0_ &= 0xFFFFFFFE;
                    }
                    result.c2SSellGrids_ = this.c2SSellGrids_;
                } else {
                    result.c2SSellGrids_ = this.c2SSellGridsBuilder_.build();
                }
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof SaleHandler.SellItemsRequest) {
                    return mergeFrom((SaleHandler.SellItemsRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(SaleHandler.SellItemsRequest other) {
                if (other == SaleHandler.SellItemsRequest.getDefaultInstance()) {
                    return this;
                }
                if (this.c2SSellGridsBuilder_ == null) {
                    if (!other.c2SSellGrids_.isEmpty()) {
                        if (this.c2SSellGrids_.isEmpty()) {
                            this.c2SSellGrids_ = other.c2SSellGrids_;
                            this.bitField0_ &= 0xFFFFFFFE;
                        } else {
                            ensureC2SSellGridsIsMutable();
                            this.c2SSellGrids_.addAll(other.c2SSellGrids_);
                        }
                        onChanged();
                    }
                } else if (!other.c2SSellGrids_.isEmpty()) {
                    if (this.c2SSellGridsBuilder_.isEmpty()) {
                        this.c2SSellGridsBuilder_.dispose();
                        this.c2SSellGridsBuilder_ = null;
                        this.c2SSellGrids_ = other.c2SSellGrids_;
                        this.bitField0_ &= 0xFFFFFFFE;
                        this.c2SSellGridsBuilder_ = SaleHandler.SellItemsRequest.alwaysUseFieldBuilders ? getC2SSellGridsFieldBuilder() : null;
                    } else {
                        this.c2SSellGridsBuilder_.addAllMessages(other.c2SSellGrids_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                for (int i = 0; i < getC2SSellGridsCount(); i++) {
                    if (!getC2SSellGrids(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                SaleHandler.SellItemsRequest parsedMessage = null;
                try {
                    parsedMessage = (SaleHandler.SellItemsRequest) SaleHandler.SellItemsRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SaleHandler.SellItemsRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            private void ensureC2SSellGridsIsMutable() {
                if ((this.bitField0_ & 0x1) != 1) {
                    this.c2SSellGrids_ = new ArrayList<>(this.c2SSellGrids_);
                    this.bitField0_ |= 0x1;
                }
            }


            public List<SaleHandler.SellGrid> getC2SSellGridsList() {
                if (this.c2SSellGridsBuilder_ == null) {
                    return Collections.unmodifiableList(this.c2SSellGrids_);
                }
                return this.c2SSellGridsBuilder_.getMessageList();
            }


            public int getC2SSellGridsCount() {
                if (this.c2SSellGridsBuilder_ == null) {
                    return this.c2SSellGrids_.size();
                }
                return this.c2SSellGridsBuilder_.getCount();
            }


            public SaleHandler.SellGrid getC2SSellGrids(int index) {
                if (this.c2SSellGridsBuilder_ == null) {
                    return this.c2SSellGrids_.get(index);
                }
                return (SaleHandler.SellGrid) this.c2SSellGridsBuilder_.getMessage(index);
            }


            public Builder setC2SSellGrids(int index, SaleHandler.SellGrid value) {
                if (this.c2SSellGridsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureC2SSellGridsIsMutable();
                    this.c2SSellGrids_.set(index, value);
                    onChanged();
                } else {
                    this.c2SSellGridsBuilder_.setMessage(index, value);
                }
                return this;
            }


            public Builder setC2SSellGrids(int index, SaleHandler.SellGrid.Builder builderForValue) {
                if (this.c2SSellGridsBuilder_ == null) {
                    ensureC2SSellGridsIsMutable();
                    this.c2SSellGrids_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.c2SSellGridsBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }


            public Builder addC2SSellGrids(SaleHandler.SellGrid value) {
                if (this.c2SSellGridsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureC2SSellGridsIsMutable();
                    this.c2SSellGrids_.add(value);
                    onChanged();
                } else {
                    this.c2SSellGridsBuilder_.addMessage(value);
                }
                return this;
            }


            public Builder addC2SSellGrids(int index, SaleHandler.SellGrid value) {
                if (this.c2SSellGridsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureC2SSellGridsIsMutable();
                    this.c2SSellGrids_.add(index, value);
                    onChanged();
                } else {
                    this.c2SSellGridsBuilder_.addMessage(index, value);
                }
                return this;
            }


            public Builder addC2SSellGrids(SaleHandler.SellGrid.Builder builderForValue) {
                if (this.c2SSellGridsBuilder_ == null) {
                    ensureC2SSellGridsIsMutable();
                    this.c2SSellGrids_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.c2SSellGridsBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }


            public Builder addC2SSellGrids(int index, SaleHandler.SellGrid.Builder builderForValue) {
                if (this.c2SSellGridsBuilder_ == null) {
                    ensureC2SSellGridsIsMutable();
                    this.c2SSellGrids_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.c2SSellGridsBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }


            public Builder addAllC2SSellGrids(Iterable<? extends SaleHandler.SellGrid> values) {
                if (this.c2SSellGridsBuilder_ == null) {
                    ensureC2SSellGridsIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.c2SSellGrids_);
                    onChanged();
                } else {
                    this.c2SSellGridsBuilder_.addAllMessages(values);
                }
                return this;
            }


            public Builder clearC2SSellGrids() {
                if (this.c2SSellGridsBuilder_ == null) {
                    this.c2SSellGrids_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFE;
                    onChanged();
                } else {
                    this.c2SSellGridsBuilder_.clear();
                }
                return this;
            }


            public Builder removeC2SSellGrids(int index) {
                if (this.c2SSellGridsBuilder_ == null) {
                    ensureC2SSellGridsIsMutable();
                    this.c2SSellGrids_.remove(index);
                    onChanged();
                } else {
                    this.c2SSellGridsBuilder_.remove(index);
                }
                return this;
            }


            public SaleHandler.SellGrid.Builder getC2SSellGridsBuilder(int index) {
                return (SaleHandler.SellGrid.Builder) getC2SSellGridsFieldBuilder().getBuilder(index);
            }


            public SaleHandler.SellGridOrBuilder getC2SSellGridsOrBuilder(int index) {
                if (this.c2SSellGridsBuilder_ == null) {
                    return this.c2SSellGrids_.get(index);
                }
                return (SaleHandler.SellGridOrBuilder) this.c2SSellGridsBuilder_.getMessageOrBuilder(index);
            }


            public List<? extends SaleHandler.SellGridOrBuilder> getC2SSellGridsOrBuilderList() {
                if (this.c2SSellGridsBuilder_ != null) {
                    return this.c2SSellGridsBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList((List) this.c2SSellGrids_);
            }


            public SaleHandler.SellGrid.Builder addC2SSellGridsBuilder() {
                return (SaleHandler.SellGrid.Builder) getC2SSellGridsFieldBuilder().addBuilder(SaleHandler.SellGrid.getDefaultInstance());
            }


            public SaleHandler.SellGrid.Builder addC2SSellGridsBuilder(int index) {
                return (SaleHandler.SellGrid.Builder) getC2SSellGridsFieldBuilder().addBuilder(index, SaleHandler.SellGrid.getDefaultInstance());
            }


            public List<SaleHandler.SellGrid.Builder> getC2SSellGridsBuilderList() {
                return getC2SSellGridsFieldBuilder().getBuilderList();
            }


            private RepeatedFieldBuilder<SaleHandler.SellGrid, SaleHandler.SellGrid.Builder, SaleHandler.SellGridOrBuilder> getC2SSellGridsFieldBuilder() {
                if (this.c2SSellGridsBuilder_ == null) {
                    this.c2SSellGridsBuilder_ = new RepeatedFieldBuilder(this.c2SSellGrids_, ((this.bitField0_ & 0x1) == 1), getParentForChildren(), isClean());
                    this.c2SSellGrids_ = null;
                }
                return this.c2SSellGridsBuilder_;
            }
        }
    }


    public static final class SellItemsResponse
            extends GeneratedMessage
            implements SellItemsResponseOrBuilder {
        private static final SellItemsResponse defaultInstance = new SellItemsResponse(true);
        private final UnknownFieldSet unknownFields;

        private SellItemsResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private SellItemsResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static SellItemsResponse getDefaultInstance() {
            return defaultInstance;
        }

        public SellItemsResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SellItemsResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return SaleHandler.internal_static_pomelo_area_SellItemsResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return SaleHandler.internal_static_pomelo_area_SellItemsResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(SellItemsResponse.class, Builder.class);
        }

        public static Parser<SellItemsResponse> PARSER = (Parser<SellItemsResponse>) new AbstractParser<SellItemsResponse>() {
            public SaleHandler.SellItemsResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SaleHandler.SellItemsResponse(input, extensionRegistry);
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

        public Parser<SellItemsResponse> getParserForType() {
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


        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
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
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static SellItemsResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (SellItemsResponse) PARSER.parseFrom(data);
        }


        public static SellItemsResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SellItemsResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static SellItemsResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (SellItemsResponse) PARSER.parseFrom(data);
        }


        public static SellItemsResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SellItemsResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static SellItemsResponse parseFrom(InputStream input) throws IOException {
            return (SellItemsResponse) PARSER.parseFrom(input);
        }


        public static SellItemsResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SellItemsResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static SellItemsResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (SellItemsResponse) PARSER.parseDelimitedFrom(input);
        }


        public static SellItemsResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SellItemsResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static SellItemsResponse parseFrom(CodedInputStream input) throws IOException {
            return (SellItemsResponse) PARSER.parseFrom(input);
        }


        public static SellItemsResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SellItemsResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(SellItemsResponse prototype) {
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
                implements SaleHandler.SellItemsResponseOrBuilder {
            private int bitField0_;


            private int s2CCode_;


            private Object s2CMsg_;


            public static final Descriptors.Descriptor getDescriptor() {
                return SaleHandler.internal_static_pomelo_area_SellItemsResponse_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return SaleHandler.internal_static_pomelo_area_SellItemsResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(SaleHandler.SellItemsResponse.class, Builder.class);
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
                if (SaleHandler.SellItemsResponse.alwaysUseFieldBuilders) ;
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
                return SaleHandler.internal_static_pomelo_area_SellItemsResponse_descriptor;
            }


            public SaleHandler.SellItemsResponse getDefaultInstanceForType() {
                return SaleHandler.SellItemsResponse.getDefaultInstance();
            }


            public SaleHandler.SellItemsResponse build() {
                SaleHandler.SellItemsResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public SaleHandler.SellItemsResponse buildPartial() {
                SaleHandler.SellItemsResponse result = new SaleHandler.SellItemsResponse(this);
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
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof SaleHandler.SellItemsResponse) {
                    return mergeFrom((SaleHandler.SellItemsResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(SaleHandler.SellItemsResponse other) {
                if (other == SaleHandler.SellItemsResponse.getDefaultInstance()) {
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
                SaleHandler.SellItemsResponse parsedMessage = null;
                try {
                    parsedMessage = (SaleHandler.SellItemsResponse) SaleHandler.SellItemsResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SaleHandler.SellItemsResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = SaleHandler.SellItemsResponse.getDefaultInstance().getS2CMsg();
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
        }
    }


    public static final class RebuyItemRequest
            extends GeneratedMessage
            implements RebuyItemRequestOrBuilder {
        private static final RebuyItemRequest defaultInstance = new RebuyItemRequest(true);
        private final UnknownFieldSet unknownFields;

        private RebuyItemRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private RebuyItemRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static RebuyItemRequest getDefaultInstance() {
            return defaultInstance;
        }

        public RebuyItemRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private RebuyItemRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.c2SGridIndex_ = input.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.c2SNum_ = input.readInt32();
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
            return SaleHandler.internal_static_pomelo_area_RebuyItemRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return SaleHandler.internal_static_pomelo_area_RebuyItemRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(RebuyItemRequest.class, Builder.class);
        }

        public static Parser<RebuyItemRequest> PARSER = (Parser<RebuyItemRequest>) new AbstractParser<RebuyItemRequest>() {
            public SaleHandler.RebuyItemRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SaleHandler.RebuyItemRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_GRIDINDEX_FIELD_NUMBER = 1;
        private int c2SGridIndex_;
        public static final int C2S_NUM_FIELD_NUMBER = 2;
        private int c2SNum_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<RebuyItemRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasC2SGridIndex() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getC2SGridIndex() {
            return this.c2SGridIndex_;
        }

        public boolean hasC2SNum() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        static {
            defaultInstance.initFields();
        }


        public int getC2SNum() {
            return this.c2SNum_;
        }


        private void initFields() {
            this.c2SGridIndex_ = 0;
            this.c2SNum_ = 0;
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasC2SGridIndex()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasC2SNum()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeInt32(1, this.c2SGridIndex_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeInt32(2, this.c2SNum_);
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
                size += CodedOutputStream.computeInt32Size(1, this.c2SGridIndex_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeInt32Size(2, this.c2SNum_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static RebuyItemRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (RebuyItemRequest) PARSER.parseFrom(data);
        }


        public static RebuyItemRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (RebuyItemRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static RebuyItemRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (RebuyItemRequest) PARSER.parseFrom(data);
        }


        public static RebuyItemRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (RebuyItemRequest) PARSER.parseFrom(data, extensionRegistry);
        }


        public static RebuyItemRequest parseFrom(InputStream input) throws IOException {
            return (RebuyItemRequest) PARSER.parseFrom(input);
        }


        public static RebuyItemRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RebuyItemRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static RebuyItemRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (RebuyItemRequest) PARSER.parseDelimitedFrom(input);
        }


        public static RebuyItemRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RebuyItemRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static RebuyItemRequest parseFrom(CodedInputStream input) throws IOException {
            return (RebuyItemRequest) PARSER.parseFrom(input);
        }


        public static RebuyItemRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RebuyItemRequest) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(RebuyItemRequest prototype) {
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
                implements SaleHandler.RebuyItemRequestOrBuilder {
            private int bitField0_;

            private int c2SGridIndex_;

            private int c2SNum_;


            public static final Descriptors.Descriptor getDescriptor() {
                return SaleHandler.internal_static_pomelo_area_RebuyItemRequest_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return SaleHandler.internal_static_pomelo_area_RebuyItemRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(SaleHandler.RebuyItemRequest.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (SaleHandler.RebuyItemRequest.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.c2SGridIndex_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SNum_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return SaleHandler.internal_static_pomelo_area_RebuyItemRequest_descriptor;
            }


            public SaleHandler.RebuyItemRequest getDefaultInstanceForType() {
                return SaleHandler.RebuyItemRequest.getDefaultInstance();
            }


            public SaleHandler.RebuyItemRequest build() {
                SaleHandler.RebuyItemRequest result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public SaleHandler.RebuyItemRequest buildPartial() {
                SaleHandler.RebuyItemRequest result = new SaleHandler.RebuyItemRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.c2SGridIndex_ = this.c2SGridIndex_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.c2SNum_ = this.c2SNum_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof SaleHandler.RebuyItemRequest) {
                    return mergeFrom((SaleHandler.RebuyItemRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(SaleHandler.RebuyItemRequest other) {
                if (other == SaleHandler.RebuyItemRequest.getDefaultInstance()) {
                    return this;
                }
                if (other.hasC2SGridIndex()) {
                    setC2SGridIndex(other.getC2SGridIndex());
                }
                if (other.hasC2SNum()) {
                    setC2SNum(other.getC2SNum());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasC2SGridIndex()) {
                    return false;
                }
                if (!hasC2SNum()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                SaleHandler.RebuyItemRequest parsedMessage = null;
                try {
                    parsedMessage = (SaleHandler.RebuyItemRequest) SaleHandler.RebuyItemRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SaleHandler.RebuyItemRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasC2SGridIndex() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public int getC2SGridIndex() {
                return this.c2SGridIndex_;
            }


            public Builder setC2SGridIndex(int value) {
                this.bitField0_ |= 0x1;
                this.c2SGridIndex_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SGridIndex() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SGridIndex_ = 0;
                onChanged();
                return this;
            }


            public boolean hasC2SNum() {
                return ((this.bitField0_ & 0x2) == 2);
            }


            public int getC2SNum() {
                return this.c2SNum_;
            }


            public Builder setC2SNum(int value) {
                this.bitField0_ |= 0x2;
                this.c2SNum_ = value;
                onChanged();
                return this;
            }


            public Builder clearC2SNum() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.c2SNum_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class RebuyItemResponse
            extends GeneratedMessage
            implements RebuyItemResponseOrBuilder {
        private final UnknownFieldSet unknownFields;


        private RebuyItemResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }


        private RebuyItemResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }


        public static RebuyItemResponse getDefaultInstance() {
            return defaultInstance;
        }


        public RebuyItemResponse getDefaultInstanceForType() {
            return defaultInstance;
        }


        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }


        private RebuyItemResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return SaleHandler.internal_static_pomelo_area_RebuyItemResponse_descriptor;
        }


        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return SaleHandler.internal_static_pomelo_area_RebuyItemResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(RebuyItemResponse.class, Builder.class);
        }


        public static Parser<RebuyItemResponse> PARSER = (Parser<RebuyItemResponse>) new AbstractParser<RebuyItemResponse>() {
            public SaleHandler.RebuyItemResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SaleHandler.RebuyItemResponse(input, extensionRegistry);
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


        public Parser<RebuyItemResponse> getParserForType() {
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


        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
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
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static RebuyItemResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (RebuyItemResponse) PARSER.parseFrom(data);
        }

        private static final RebuyItemResponse defaultInstance = new RebuyItemResponse(true);

        public static RebuyItemResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (RebuyItemResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static RebuyItemResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (RebuyItemResponse) PARSER.parseFrom(data);
        }

        public static RebuyItemResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (RebuyItemResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static RebuyItemResponse parseFrom(InputStream input) throws IOException {
            return (RebuyItemResponse) PARSER.parseFrom(input);
        }

        public static RebuyItemResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RebuyItemResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static RebuyItemResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (RebuyItemResponse) PARSER.parseDelimitedFrom(input);
        }

        public static RebuyItemResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RebuyItemResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static RebuyItemResponse parseFrom(CodedInputStream input) throws IOException {
            return (RebuyItemResponse) PARSER.parseFrom(input);
        }

        public static RebuyItemResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RebuyItemResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(RebuyItemResponse prototype) {
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

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements SaleHandler.RebuyItemResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SaleHandler.internal_static_pomelo_area_RebuyItemResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return SaleHandler.internal_static_pomelo_area_RebuyItemResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(SaleHandler.RebuyItemResponse.class, Builder.class);
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
                if (SaleHandler.RebuyItemResponse.alwaysUseFieldBuilders) ;
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
                return SaleHandler.internal_static_pomelo_area_RebuyItemResponse_descriptor;
            }

            public SaleHandler.RebuyItemResponse getDefaultInstanceForType() {
                return SaleHandler.RebuyItemResponse.getDefaultInstance();
            }

            public SaleHandler.RebuyItemResponse build() {
                SaleHandler.RebuyItemResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public SaleHandler.RebuyItemResponse buildPartial() {
                SaleHandler.RebuyItemResponse result = new SaleHandler.RebuyItemResponse(this);
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
                if (other instanceof SaleHandler.RebuyItemResponse)
                    return mergeFrom((SaleHandler.RebuyItemResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SaleHandler.RebuyItemResponse other) {
                if (other == SaleHandler.RebuyItemResponse.getDefaultInstance())
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
                SaleHandler.RebuyItemResponse parsedMessage = null;
                try {
                    parsedMessage = (SaleHandler.RebuyItemResponse) SaleHandler.RebuyItemResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SaleHandler.RebuyItemResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = SaleHandler.RebuyItemResponse.getDefaultInstance().getS2CMsg();
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

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }


    static {
        String[] descriptorData = {"\n\021saleHandler.proto\022\013pomelo.area\032\nitem.proto\"¡\001\n\007BuyItem\022\016\n\006typeId\030\001 \001(\005\022\016\n\006itemId\030\002 \001(\005\022\024\n\fitemShowName\030\003 \001(\t\022#\n\004item\030\004 \001(\0132\025.pomelo.item.MiniItem\022\021\n\tmoneyType\030\005 \001(\005\022\021\n\tneedMoney\030\006 \001(\005\022\025\n\rmaxGroupCount\030\007 \001(\005\"&\n\bSellGrid\022\r\n\005index\030\001 \002(\005\022\013\n\003num\030\002 \002(\005\"'\n\016BuyPageRequest\022\025\n\rc2s_sellIndex\030\001 \003(\005\"`\n\017BuyPageResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022*\n\fs2c_buyItems\030\003 \003(\0132\024.pomelo.area.BuyItem\"I\n\016BuyItemRe", "quest\022\022\n\nc2s_typeId\030\001 \002(\005\022\022\n\nc2s_itemId\030\002 \002(\005\022\017\n\007c2s_num\030\003 \002(\005\"4\n\017BuyItemResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"U\n\030AutoBuyItemByCodeRequest\022\022\n\nc2s_typeId\030\001 \003(\005\022\024\n\fc2s_itemCode\030\002 \002(\t\022\017\n\007c2s_num\030\003 \002(\005\"o\n\031AutoBuyItemByCodeResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\031\n\021s2c_notEnoughGold\030\003 \001(\005\022\024\n\fs2c_needGold\030\004 \001(\005\"@\n\020SellItemsRequest\022,\n\rc2s_sellGrids\030\001 \003(\0132\025.pomelo.area.SellGrid\"6\n\021SellItemsRespo", "nse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\":\n\020RebuyItemRequest\022\025\n\rc2s_gridIndex\030\001 \002(\005\022\017\n\007c2s_num\030\002 \002(\005\"6\n\021RebuyItemResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t2¸\003\n\013saleHandler\022K\n\016buyPageRequest\022\033.pomelo.area.BuyPageRequest\032\034.pomelo.area.BuyPageResponse\022K\n\016buyItemRequest\022\033.pomelo.area.BuyItemRequest\032\034.pomelo.area.BuyItemResponse\022i\n\030autoBuyItemByCodeRequest\022%.pomelo.area.AutoBuyItemByCodeRequest\032&.pomelo", ".area.AutoBuyItemByCodeResponse\022Q\n\020sellItemsRequest\022\035.pomelo.area.SellItemsRequest\032\036.pomelo.area.SellItemsResponse\022Q\n\020rebuyItemRequest\022\035.pomelo.area.RebuyItemRequest\032\036.pomelo.area.RebuyItemResponse"};


        Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root) {
                SaleHandler.descriptor = root;
                return null;
            }
        };

        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[]{

                ItemOuterClass.getDescriptor()}, assigner);
    }

    private static final Descriptors.Descriptor internal_static_pomelo_area_BuyItem_descriptor = getDescriptor().getMessageTypes().get(0);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_BuyItem_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_BuyItem_descriptor, new String[]{"TypeId", "ItemId", "ItemShowName", "Item", "MoneyType", "NeedMoney", "MaxGroupCount"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_SellGrid_descriptor = getDescriptor().getMessageTypes().get(1);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_SellGrid_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_SellGrid_descriptor, new String[]{"Index", "Num"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_BuyPageRequest_descriptor = getDescriptor().getMessageTypes().get(2);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_BuyPageRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_BuyPageRequest_descriptor, new String[]{"C2SSellIndex"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_BuyPageResponse_descriptor = getDescriptor().getMessageTypes().get(3);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_BuyPageResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_BuyPageResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CBuyItems"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_BuyItemRequest_descriptor = getDescriptor().getMessageTypes().get(4);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_BuyItemRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_BuyItemRequest_descriptor, new String[]{"C2STypeId", "C2SItemId", "C2SNum"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_BuyItemResponse_descriptor = getDescriptor().getMessageTypes().get(5);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_BuyItemResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_BuyItemResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_AutoBuyItemByCodeRequest_descriptor = getDescriptor().getMessageTypes().get(6);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_AutoBuyItemByCodeRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_AutoBuyItemByCodeRequest_descriptor, new String[]{"C2STypeId", "C2SItemCode", "C2SNum"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_AutoBuyItemByCodeResponse_descriptor = getDescriptor().getMessageTypes().get(7);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_AutoBuyItemByCodeResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_AutoBuyItemByCodeResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CNotEnoughGold", "S2CNeedGold"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_SellItemsRequest_descriptor = getDescriptor().getMessageTypes().get(8);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_SellItemsRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_SellItemsRequest_descriptor, new String[]{"C2SSellGrids"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_SellItemsResponse_descriptor = getDescriptor().getMessageTypes().get(9);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_SellItemsResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_SellItemsResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_RebuyItemRequest_descriptor = getDescriptor().getMessageTypes().get(10);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_RebuyItemRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_RebuyItemRequest_descriptor, new String[]{"C2SGridIndex", "C2SNum"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_RebuyItemResponse_descriptor = getDescriptor().getMessageTypes().get(11);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_RebuyItemResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_RebuyItemResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});
    private static Descriptors.FileDescriptor descriptor;

    static {
        ItemOuterClass.getDescriptor();
    }

    public static interface RebuyItemResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface RebuyItemRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2SGridIndex();

        int getC2SGridIndex();

        boolean hasC2SNum();

        int getC2SNum();
    }

    public static interface SellItemsResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface SellItemsRequestOrBuilder extends MessageOrBuilder {
        List<SaleHandler.SellGrid> getC2SSellGridsList();

        SaleHandler.SellGrid getC2SSellGrids(int param1Int);

        int getC2SSellGridsCount();

        List<? extends SaleHandler.SellGridOrBuilder> getC2SSellGridsOrBuilderList();

        SaleHandler.SellGridOrBuilder getC2SSellGridsOrBuilder(int param1Int);
    }

    public static interface AutoBuyItemByCodeResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasS2CNotEnoughGold();

        int getS2CNotEnoughGold();

        boolean hasS2CNeedGold();

        int getS2CNeedGold();
    }

    public static interface AutoBuyItemByCodeRequestOrBuilder extends MessageOrBuilder {
        List<Integer> getC2STypeIdList();

        int getC2STypeIdCount();

        int getC2STypeId(int param1Int);

        boolean hasC2SItemCode();

        String getC2SItemCode();

        ByteString getC2SItemCodeBytes();

        boolean hasC2SNum();

        int getC2SNum();
    }

    public static interface BuyItemResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface BuyItemRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2STypeId();

        int getC2STypeId();

        boolean hasC2SItemId();

        int getC2SItemId();

        boolean hasC2SNum();

        int getC2SNum();
    }

    public static interface BuyPageResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        List<SaleHandler.BuyItem> getS2CBuyItemsList();

        SaleHandler.BuyItem getS2CBuyItems(int param1Int);

        int getS2CBuyItemsCount();

        List<? extends SaleHandler.BuyItemOrBuilder> getS2CBuyItemsOrBuilderList();

        SaleHandler.BuyItemOrBuilder getS2CBuyItemsOrBuilder(int param1Int);
    }

    public static interface BuyPageRequestOrBuilder extends MessageOrBuilder {
        List<Integer> getC2SSellIndexList();

        int getC2SSellIndexCount();

        int getC2SSellIndex(int param1Int);
    }

    public static interface SellGridOrBuilder extends MessageOrBuilder {
        boolean hasIndex();

        int getIndex();

        boolean hasNum();

        int getNum();
    }

    public static interface BuyItemOrBuilder extends MessageOrBuilder {
        boolean hasTypeId();

        int getTypeId();

        boolean hasItemId();

        int getItemId();

        boolean hasItemShowName();

        String getItemShowName();

        ByteString getItemShowNameBytes();

        boolean hasItem();

        ItemOuterClass.MiniItem getItem();

        ItemOuterClass.MiniItemOrBuilder getItemOrBuilder();

        boolean hasMoneyType();

        int getMoneyType();

        boolean hasNeedMoney();

        int getNeedMoney();

        boolean hasMaxGroupCount();

        int getMaxGroupCount();
    }
}


