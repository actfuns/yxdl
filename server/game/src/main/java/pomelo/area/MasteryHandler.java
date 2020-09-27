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


public final class MasteryHandler {
    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static final class Mastery
            extends GeneratedMessage
            implements MasteryOrBuilder {
        private static final Mastery defaultInstance = new Mastery(true);
        private final UnknownFieldSet unknownFields;

        private Mastery(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Mastery(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Mastery getDefaultInstance() {
            return defaultInstance;
        }

        public Mastery getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Mastery(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString bs;
                    Common.AttributeBase.Builder builder;
                    ItemOuterClass.MiniItem.Builder subBuilder;
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        case 8:
                            this.bitField0_ |= 0x1;
                            this.pos_ = input.readInt32();
                            break;
                        case 18:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x2;
                            this.name_ = bs;
                            break;
                        case 26:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x4;
                            this.icon_ = bs;
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.level_ = input.readInt32();
                            break;
                        case 40:
                            this.bitField0_ |= 0x10;
                            this.maxLevel_ = input.readInt32();
                            break;
                        case 50:
                            builder = null;
                            if ((this.bitField0_ & 0x20) == 32) builder = this.attributes_.toBuilder();
                            this.attributes_ = (Common.AttributeBase) input.readMessage(Common.AttributeBase.PARSER, extensionRegistry);
                            if (builder != null) {
                                builder.mergeFrom(this.attributes_);
                                this.attributes_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 0x20;
                            break;
                        case 58:
                            subBuilder = null;
                            if ((this.bitField0_ & 0x40) == 64) subBuilder = this.material_.toBuilder();
                            this.material_ = (ItemOuterClass.MiniItem) input.readMessage(ItemOuterClass.MiniItem.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.material_);
                                this.material_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 0x40;
                            break;
                        case 64:
                            this.bitField0_ |= 0x80;
                            this.isActive_ = input.readInt32();
                            break;
                        case 72:
                            this.bitField0_ |= 0x100;
                            this.magicNum_ = input.readInt32();
                            break;
                        case 80:
                            this.bitField0_ |= 0x200;
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
            return MasteryHandler.internal_static_pomelo_area_Mastery_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MasteryHandler.internal_static_pomelo_area_Mastery_fieldAccessorTable.ensureFieldAccessorsInitialized(Mastery.class, Builder.class);
        }

        public static Parser<Mastery> PARSER = (Parser<Mastery>) new AbstractParser<Mastery>() {
            public MasteryHandler.Mastery parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MasteryHandler.Mastery(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int POS_FIELD_NUMBER = 1;
        private int pos_;
        public static final int NAME_FIELD_NUMBER = 2;
        private Object name_;
        public static final int ICON_FIELD_NUMBER = 3;
        private Object icon_;
        public static final int LEVEL_FIELD_NUMBER = 4;
        private int level_;
        public static final int MAXLEVEL_FIELD_NUMBER = 5;
        private int maxLevel_;
        public static final int ATTRIBUTES_FIELD_NUMBER = 6;
        private Common.AttributeBase attributes_;
        public static final int MATERIAL_FIELD_NUMBER = 7;
        private ItemOuterClass.MiniItem material_;
        public static final int ISACTIVE_FIELD_NUMBER = 8;
        private int isActive_;
        public static final int MAGICNUM_FIELD_NUMBER = 9;
        private int magicNum_;
        public static final int ID_FIELD_NUMBER = 10;
        private int id_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<Mastery> getParserForType() {
            return PARSER;
        }

        public boolean hasPos() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getPos() {
            return this.pos_;
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

        static {
            defaultInstance.initFields();
        }


        public boolean hasIcon() {
            return ((this.bitField0_ & 0x4) == 4);
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


        public boolean hasLevel() {
            return ((this.bitField0_ & 0x8) == 8);
        }


        public int getLevel() {
            return this.level_;
        }


        public boolean hasMaxLevel() {
            return ((this.bitField0_ & 0x10) == 16);
        }


        public int getMaxLevel() {
            return this.maxLevel_;
        }


        public boolean hasAttributes() {
            return ((this.bitField0_ & 0x20) == 32);
        }


        public Common.AttributeBase getAttributes() {
            return this.attributes_;
        }


        public Common.AttributeBaseOrBuilder getAttributesOrBuilder() {
            return (Common.AttributeBaseOrBuilder) this.attributes_;
        }


        public boolean hasMaterial() {
            return ((this.bitField0_ & 0x40) == 64);
        }


        public ItemOuterClass.MiniItem getMaterial() {
            return this.material_;
        }


        public ItemOuterClass.MiniItemOrBuilder getMaterialOrBuilder() {
            return (ItemOuterClass.MiniItemOrBuilder) this.material_;
        }


        public boolean hasIsActive() {
            return ((this.bitField0_ & 0x80) == 128);
        }


        public int getIsActive() {
            return this.isActive_;
        }


        public boolean hasMagicNum() {
            return ((this.bitField0_ & 0x100) == 256);
        }


        public int getMagicNum() {
            return this.magicNum_;
        }


        public boolean hasId() {
            return ((this.bitField0_ & 0x200) == 512);
        }


        public int getId() {
            return this.id_;
        }


        private void initFields() {
            this.pos_ = 0;
            this.name_ = "";
            this.icon_ = "";
            this.level_ = 0;
            this.maxLevel_ = 0;
            this.attributes_ = Common.AttributeBase.getDefaultInstance();
            this.material_ = ItemOuterClass.MiniItem.getDefaultInstance();
            this.isActive_ = 0;
            this.magicNum_ = 0;
            this.id_ = 0;
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasPos()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (hasAttributes() && !getAttributes().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (hasMaterial() && !getMaterial().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeInt32(1, this.pos_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeBytes(2, getNameBytes());
            }
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeBytes(3, getIconBytes());
            }
            if ((this.bitField0_ & 0x8) == 8) {
                output.writeInt32(4, this.level_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                output.writeInt32(5, this.maxLevel_);
            }
            if ((this.bitField0_ & 0x20) == 32) {
                output.writeMessage(6, (MessageLite) this.attributes_);
            }
            if ((this.bitField0_ & 0x40) == 64) {
                output.writeMessage(7, (MessageLite) this.material_);
            }
            if ((this.bitField0_ & 0x80) == 128) {
                output.writeInt32(8, this.isActive_);
            }
            if ((this.bitField0_ & 0x100) == 256) {
                output.writeInt32(9, this.magicNum_);
            }
            if ((this.bitField0_ & 0x200) == 512) {
                output.writeInt32(10, this.id_);
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
                size += CodedOutputStream.computeInt32Size(1, this.pos_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeBytesSize(2, getNameBytes());
            }
            if ((this.bitField0_ & 0x4) == 4) {
                size += CodedOutputStream.computeBytesSize(3, getIconBytes());
            }
            if ((this.bitField0_ & 0x8) == 8) {
                size += CodedOutputStream.computeInt32Size(4, this.level_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                size += CodedOutputStream.computeInt32Size(5, this.maxLevel_);
            }
            if ((this.bitField0_ & 0x20) == 32) {
                size += CodedOutputStream.computeMessageSize(6, (MessageLite) this.attributes_);
            }
            if ((this.bitField0_ & 0x40) == 64) {
                size += CodedOutputStream.computeMessageSize(7, (MessageLite) this.material_);
            }
            if ((this.bitField0_ & 0x80) == 128) {
                size += CodedOutputStream.computeInt32Size(8, this.isActive_);
            }
            if ((this.bitField0_ & 0x100) == 256) {
                size += CodedOutputStream.computeInt32Size(9, this.magicNum_);
            }
            if ((this.bitField0_ & 0x200) == 512) {
                size += CodedOutputStream.computeInt32Size(10, this.id_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static Mastery parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Mastery) PARSER.parseFrom(data);
        }


        public static Mastery parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Mastery) PARSER.parseFrom(data, extensionRegistry);
        }


        public static Mastery parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Mastery) PARSER.parseFrom(data);
        }


        public static Mastery parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Mastery) PARSER.parseFrom(data, extensionRegistry);
        }


        public static Mastery parseFrom(InputStream input) throws IOException {
            return (Mastery) PARSER.parseFrom(input);
        }


        public static Mastery parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Mastery) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Mastery parseDelimitedFrom(InputStream input) throws IOException {
            return (Mastery) PARSER.parseDelimitedFrom(input);
        }


        public static Mastery parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Mastery) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static Mastery parseFrom(CodedInputStream input) throws IOException {
            return (Mastery) PARSER.parseFrom(input);
        }


        public static Mastery parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Mastery) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(Mastery prototype) {
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
                implements MasteryHandler.MasteryOrBuilder {
            private int bitField0_;


            private int pos_;


            private Object name_;


            private Object icon_;


            private int level_;


            private int maxLevel_;


            private Common.AttributeBase attributes_;


            private SingleFieldBuilder<Common.AttributeBase, Common.AttributeBase.Builder, Common.AttributeBaseOrBuilder> attributesBuilder_;


            private ItemOuterClass.MiniItem material_;


            private SingleFieldBuilder<ItemOuterClass.MiniItem, ItemOuterClass.MiniItem.Builder, ItemOuterClass.MiniItemOrBuilder> materialBuilder_;


            private int isActive_;


            private int magicNum_;


            private int id_;


            public static final Descriptors.Descriptor getDescriptor() {
                return MasteryHandler.internal_static_pomelo_area_Mastery_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MasteryHandler.internal_static_pomelo_area_Mastery_fieldAccessorTable.ensureFieldAccessorsInitialized(MasteryHandler.Mastery.class, Builder.class);
            }


            private Builder() {
                this.name_ = "";
                this.icon_ = "";
                this.attributes_ = Common.AttributeBase.getDefaultInstance();
                this.material_ = ItemOuterClass.MiniItem.getDefaultInstance();
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.name_ = "";
                this.icon_ = "";
                this.attributes_ = Common.AttributeBase.getDefaultInstance();
                this.material_ = ItemOuterClass.MiniItem.getDefaultInstance();
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (MasteryHandler.Mastery.alwaysUseFieldBuilders) {
                    getAttributesFieldBuilder();
                    getMaterialFieldBuilder();
                }
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.pos_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.name_ = "";
                this.bitField0_ &= 0xFFFFFFFD;
                this.icon_ = "";
                this.bitField0_ &= 0xFFFFFFFB;
                this.level_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                this.maxLevel_ = 0;
                this.bitField0_ &= 0xFFFFFFEF;
                if (this.attributesBuilder_ == null) {
                    this.attributes_ = Common.AttributeBase.getDefaultInstance();
                } else {
                    this.attributesBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFDF;
                if (this.materialBuilder_ == null) {
                    this.material_ = ItemOuterClass.MiniItem.getDefaultInstance();
                } else {
                    this.materialBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFBF;
                this.isActive_ = 0;
                this.bitField0_ &= 0xFFFFFF7F;
                this.magicNum_ = 0;
                this.bitField0_ &= 0xFFFFFEFF;
                this.id_ = 0;
                this.bitField0_ &= 0xFFFFFDFF;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return MasteryHandler.internal_static_pomelo_area_Mastery_descriptor;
            }


            public MasteryHandler.Mastery getDefaultInstanceForType() {
                return MasteryHandler.Mastery.getDefaultInstance();
            }


            public MasteryHandler.Mastery build() {
                MasteryHandler.Mastery result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public MasteryHandler.Mastery buildPartial() {
                MasteryHandler.Mastery result = new MasteryHandler.Mastery(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.pos_ = this.pos_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.name_ = this.name_;
                if ((from_bitField0_ & 0x4) == 4) {
                    to_bitField0_ |= 0x4;
                }
                result.icon_ = this.icon_;
                if ((from_bitField0_ & 0x8) == 8) {
                    to_bitField0_ |= 0x8;
                }
                result.level_ = this.level_;
                if ((from_bitField0_ & 0x10) == 16) {
                    to_bitField0_ |= 0x10;
                }
                result.maxLevel_ = this.maxLevel_;
                if ((from_bitField0_ & 0x20) == 32) {
                    to_bitField0_ |= 0x20;
                }
                if (this.attributesBuilder_ == null) {
                    result.attributes_ = this.attributes_;
                } else {
                    result.attributes_ = (Common.AttributeBase) this.attributesBuilder_.build();
                }
                if ((from_bitField0_ & 0x40) == 64) {
                    to_bitField0_ |= 0x40;
                }
                if (this.materialBuilder_ == null) {
                    result.material_ = this.material_;
                } else {
                    result.material_ = (ItemOuterClass.MiniItem) this.materialBuilder_.build();
                }
                if ((from_bitField0_ & 0x80) == 128) {
                    to_bitField0_ |= 0x80;
                }
                result.isActive_ = this.isActive_;
                if ((from_bitField0_ & 0x100) == 256) {
                    to_bitField0_ |= 0x100;
                }
                result.magicNum_ = this.magicNum_;
                if ((from_bitField0_ & 0x200) == 512) {
                    to_bitField0_ |= 0x200;
                }
                result.id_ = this.id_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof MasteryHandler.Mastery) {
                    return mergeFrom((MasteryHandler.Mastery) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(MasteryHandler.Mastery other) {
                if (other == MasteryHandler.Mastery.getDefaultInstance()) {
                    return this;
                }
                if (other.hasPos()) {
                    setPos(other.getPos());
                }
                if (other.hasName()) {
                    this.bitField0_ |= 0x2;
                    this.name_ = other.name_;
                    onChanged();
                }
                if (other.hasIcon()) {
                    this.bitField0_ |= 0x4;
                    this.icon_ = other.icon_;
                    onChanged();
                }
                if (other.hasLevel()) {
                    setLevel(other.getLevel());
                }
                if (other.hasMaxLevel()) {
                    setMaxLevel(other.getMaxLevel());
                }
                if (other.hasAttributes()) {
                    mergeAttributes(other.getAttributes());
                }
                if (other.hasMaterial()) {
                    mergeMaterial(other.getMaterial());
                }
                if (other.hasIsActive()) {
                    setIsActive(other.getIsActive());
                }
                if (other.hasMagicNum()) {
                    setMagicNum(other.getMagicNum());
                }
                if (other.hasId()) {
                    setId(other.getId());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasPos()) {
                    return false;
                }
                if (hasAttributes() && !getAttributes().isInitialized()) {
                    return false;
                }
                if (hasMaterial() && !getMaterial().isInitialized()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                MasteryHandler.Mastery parsedMessage = null;
                try {
                    parsedMessage = (MasteryHandler.Mastery) MasteryHandler.Mastery.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MasteryHandler.Mastery) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasPos() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public int getPos() {
                return this.pos_;
            }


            public Builder setPos(int value) {
                this.bitField0_ |= 0x1;
                this.pos_ = value;
                onChanged();
                return this;
            }


            public Builder clearPos() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.pos_ = 0;
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
                this.name_ = MasteryHandler.Mastery.getDefaultInstance().getName();
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


            public boolean hasIcon() {
                return ((this.bitField0_ & 0x4) == 4);
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
                this.bitField0_ |= 0x4;
                this.icon_ = value;
                onChanged();
                return this;
            }


            public Builder clearIcon() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.icon_ = MasteryHandler.Mastery.getDefaultInstance().getIcon();
                onChanged();
                return this;
            }


            public Builder setIconBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x4;
                this.icon_ = value;
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


            public boolean hasMaxLevel() {
                return ((this.bitField0_ & 0x10) == 16);
            }


            public int getMaxLevel() {
                return this.maxLevel_;
            }


            public Builder setMaxLevel(int value) {
                this.bitField0_ |= 0x10;
                this.maxLevel_ = value;
                onChanged();
                return this;
            }


            public Builder clearMaxLevel() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.maxLevel_ = 0;
                onChanged();
                return this;
            }


            public boolean hasAttributes() {
                return ((this.bitField0_ & 0x20) == 32);
            }


            public Common.AttributeBase getAttributes() {
                if (this.attributesBuilder_ == null) {
                    return this.attributes_;
                }
                return (Common.AttributeBase) this.attributesBuilder_.getMessage();
            }


            public Builder setAttributes(Common.AttributeBase value) {
                if (this.attributesBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.attributes_ = value;
                    onChanged();
                } else {
                    this.attributesBuilder_.setMessage((GeneratedMessage) value);
                }
                this.bitField0_ |= 0x20;
                return this;
            }


            public Builder setAttributes(Common.AttributeBase.Builder builderForValue) {
                if (this.attributesBuilder_ == null) {
                    this.attributes_ = builderForValue.build();
                    onChanged();
                } else {
                    this.attributesBuilder_.setMessage((GeneratedMessage) builderForValue.build());
                }
                this.bitField0_ |= 0x20;
                return this;
            }


            public Builder mergeAttributes(Common.AttributeBase value) {
                if (this.attributesBuilder_ == null) {
                    if ((this.bitField0_ & 0x20) == 32 && this.attributes_ != Common.AttributeBase.getDefaultInstance()) {
                        this.attributes_ = Common.AttributeBase.newBuilder(this.attributes_).mergeFrom(value).buildPartial();
                    } else {
                        this.attributes_ = value;
                    }
                    onChanged();
                } else {
                    this.attributesBuilder_.mergeFrom((GeneratedMessage) value);
                }
                this.bitField0_ |= 0x20;
                return this;
            }


            public Builder clearAttributes() {
                if (this.attributesBuilder_ == null) {
                    this.attributes_ = Common.AttributeBase.getDefaultInstance();
                    onChanged();
                } else {
                    this.attributesBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFDF;
                return this;
            }


            public Common.AttributeBase.Builder getAttributesBuilder() {
                this.bitField0_ |= 0x20;
                onChanged();
                return (Common.AttributeBase.Builder) getAttributesFieldBuilder().getBuilder();
            }


            public Common.AttributeBaseOrBuilder getAttributesOrBuilder() {
                if (this.attributesBuilder_ != null) {
                    return (Common.AttributeBaseOrBuilder) this.attributesBuilder_.getMessageOrBuilder();
                }
                return (Common.AttributeBaseOrBuilder) this.attributes_;
            }


            private SingleFieldBuilder<Common.AttributeBase, Common.AttributeBase.Builder, Common.AttributeBaseOrBuilder> getAttributesFieldBuilder() {
                if (this.attributesBuilder_ == null) {
                    this.attributesBuilder_ = new SingleFieldBuilder((GeneratedMessage) getAttributes(), getParentForChildren(), isClean());
                    this.attributes_ = null;
                }
                return this.attributesBuilder_;
            }


            public boolean hasMaterial() {
                return ((this.bitField0_ & 0x40) == 64);
            }


            public ItemOuterClass.MiniItem getMaterial() {
                if (this.materialBuilder_ == null) {
                    return this.material_;
                }
                return (ItemOuterClass.MiniItem) this.materialBuilder_.getMessage();
            }


            public Builder setMaterial(ItemOuterClass.MiniItem value) {
                if (this.materialBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.material_ = value;
                    onChanged();
                } else {
                    this.materialBuilder_.setMessage((GeneratedMessage) value);
                }
                this.bitField0_ |= 0x40;
                return this;
            }


            public Builder setMaterial(ItemOuterClass.MiniItem.Builder builderForValue) {
                if (this.materialBuilder_ == null) {
                    this.material_ = builderForValue.build();
                    onChanged();
                } else {
                    this.materialBuilder_.setMessage((GeneratedMessage) builderForValue.build());
                }
                this.bitField0_ |= 0x40;
                return this;
            }


            public Builder mergeMaterial(ItemOuterClass.MiniItem value) {
                if (this.materialBuilder_ == null) {
                    if ((this.bitField0_ & 0x40) == 64 && this.material_ != ItemOuterClass.MiniItem.getDefaultInstance()) {
                        this.material_ = ItemOuterClass.MiniItem.newBuilder(this.material_).mergeFrom(value).buildPartial();
                    } else {
                        this.material_ = value;
                    }
                    onChanged();
                } else {
                    this.materialBuilder_.mergeFrom((GeneratedMessage) value);
                }
                this.bitField0_ |= 0x40;
                return this;
            }


            public Builder clearMaterial() {
                if (this.materialBuilder_ == null) {
                    this.material_ = ItemOuterClass.MiniItem.getDefaultInstance();
                    onChanged();
                } else {
                    this.materialBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFBF;
                return this;
            }


            public ItemOuterClass.MiniItem.Builder getMaterialBuilder() {
                this.bitField0_ |= 0x40;
                onChanged();
                return (ItemOuterClass.MiniItem.Builder) getMaterialFieldBuilder().getBuilder();
            }


            public ItemOuterClass.MiniItemOrBuilder getMaterialOrBuilder() {
                if (this.materialBuilder_ != null) {
                    return (ItemOuterClass.MiniItemOrBuilder) this.materialBuilder_.getMessageOrBuilder();
                }
                return (ItemOuterClass.MiniItemOrBuilder) this.material_;
            }


            private SingleFieldBuilder<ItemOuterClass.MiniItem, ItemOuterClass.MiniItem.Builder, ItemOuterClass.MiniItemOrBuilder> getMaterialFieldBuilder() {
                if (this.materialBuilder_ == null) {
                    this.materialBuilder_ = new SingleFieldBuilder((GeneratedMessage) getMaterial(), getParentForChildren(), isClean());
                    this.material_ = null;
                }
                return this.materialBuilder_;
            }


            public boolean hasIsActive() {
                return ((this.bitField0_ & 0x80) == 128);
            }


            public int getIsActive() {
                return this.isActive_;
            }


            public Builder setIsActive(int value) {
                this.bitField0_ |= 0x80;
                this.isActive_ = value;
                onChanged();
                return this;
            }


            public Builder clearIsActive() {
                this.bitField0_ &= 0xFFFFFF7F;
                this.isActive_ = 0;
                onChanged();
                return this;
            }


            public boolean hasMagicNum() {
                return ((this.bitField0_ & 0x100) == 256);
            }


            public int getMagicNum() {
                return this.magicNum_;
            }


            public Builder setMagicNum(int value) {
                this.bitField0_ |= 0x100;
                this.magicNum_ = value;
                onChanged();
                return this;
            }


            public Builder clearMagicNum() {
                this.bitField0_ &= 0xFFFFFEFF;
                this.magicNum_ = 0;
                onChanged();
                return this;
            }


            public boolean hasId() {
                return ((this.bitField0_ & 0x200) == 512);
            }


            public int getId() {
                return this.id_;
            }


            public Builder setId(int value) {
                this.bitField0_ |= 0x200;
                this.id_ = value;
                onChanged();
                return this;
            }


            public Builder clearId() {
                this.bitField0_ &= 0xFFFFFDFF;
                this.id_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class AllMastery
            extends GeneratedMessage
            implements AllMasteryOrBuilder {
        private static final AllMastery defaultInstance = new AllMastery(true);
        private final UnknownFieldSet unknownFields;

        private AllMastery(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private AllMastery(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static AllMastery getDefaultInstance() {
            return defaultInstance;
        }

        public AllMastery getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AllMastery(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            if ((mutable_bitField0_ & 0x1) != 1) {
                                this.masterys_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x1;
                            }
                            this.masterys_.add(input.readMessage(MasteryHandler.Mastery.PARSER, extensionRegistry));
                            break;
                        case 18:
                            subBuilder = null;
                            if ((this.bitField0_ & 0x1) == 1) subBuilder = this.ring_.toBuilder();
                            this.ring_ = (ItemOuterClass.MiniItem) input.readMessage(ItemOuterClass.MiniItem.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.ring_);
                                this.ring_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 0x1;
                            break;
                        case 26:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x2;
                            this.needRingName_ = bs;
                            break;
                        case 32:
                            this.bitField0_ |= 0x4;
                            this.needPlayerLevel_ = input.readInt32();
                            break;
                        case 40:
                            this.bitField0_ |= 0x8;
                            this.needPlayerUpLevel_ = input.readInt32();
                            break;
                        case 48:
                            this.bitField0_ |= 0x10;
                            this.costMagicNum_ = input.readInt32();
                            break;
                        case 56:
                            this.bitField0_ |= 0x20;
                            this.curMagicNum_ = input.readInt32();
                            break;
                        case 64:
                            this.bitField0_ |= 0x40;
                            this.ringLevel_ = input.readInt32();
                            break;
                        case 72:
                            this.bitField0_ |= 0x80;
                            this.canGet_ = input.readInt32();
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x1) == 1) this.masterys_ = Collections.unmodifiableList(this.masterys_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MasteryHandler.internal_static_pomelo_area_AllMastery_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MasteryHandler.internal_static_pomelo_area_AllMastery_fieldAccessorTable.ensureFieldAccessorsInitialized(AllMastery.class, Builder.class);
        }

        public static Parser<AllMastery> PARSER = (Parser<AllMastery>) new AbstractParser<AllMastery>() {
            public MasteryHandler.AllMastery parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MasteryHandler.AllMastery(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int MASTERYS_FIELD_NUMBER = 1;
        private List<MasteryHandler.Mastery> masterys_;
        public static final int RING_FIELD_NUMBER = 2;
        private ItemOuterClass.MiniItem ring_;
        public static final int NEEDRINGNAME_FIELD_NUMBER = 3;
        private Object needRingName_;
        public static final int NEEDPLAYERLEVEL_FIELD_NUMBER = 4;
        private int needPlayerLevel_;
        public static final int NEEDPLAYERUPLEVEL_FIELD_NUMBER = 5;
        private int needPlayerUpLevel_;
        public static final int COSTMAGICNUM_FIELD_NUMBER = 6;
        private int costMagicNum_;
        public static final int CURMAGICNUM_FIELD_NUMBER = 7;
        private int curMagicNum_;
        public static final int RINGLEVEL_FIELD_NUMBER = 8;
        private int ringLevel_;
        public static final int CANGET_FIELD_NUMBER = 9;
        private int canGet_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<AllMastery> getParserForType() {
            return PARSER;
        }

        public List<MasteryHandler.Mastery> getMasterysList() {
            return this.masterys_;
        }

        public List<? extends MasteryHandler.MasteryOrBuilder> getMasterysOrBuilderList() {
            return (List) this.masterys_;
        }

        public int getMasterysCount() {
            return this.masterys_.size();
        }

        public MasteryHandler.Mastery getMasterys(int index) {
            return this.masterys_.get(index);
        }

        public MasteryHandler.MasteryOrBuilder getMasterysOrBuilder(int index) {
            return this.masterys_.get(index);
        }

        public boolean hasRing() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public ItemOuterClass.MiniItem getRing() {
            return this.ring_;
        }

        public ItemOuterClass.MiniItemOrBuilder getRingOrBuilder() {
            return (ItemOuterClass.MiniItemOrBuilder) this.ring_;
        }

        public boolean hasNeedRingName() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public String getNeedRingName() {
            Object ref = this.needRingName_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.needRingName_ = s;
            return s;
        }

        public ByteString getNeedRingNameBytes() {
            Object ref = this.needRingName_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.needRingName_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasNeedPlayerLevel() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getNeedPlayerLevel() {
            return this.needPlayerLevel_;
        }

        public boolean hasNeedPlayerUpLevel() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public int getNeedPlayerUpLevel() {
            return this.needPlayerUpLevel_;
        }

        public boolean hasCostMagicNum() {
            return ((this.bitField0_ & 0x10) == 16);
        }

        public int getCostMagicNum() {
            return this.costMagicNum_;
        }

        public boolean hasCurMagicNum() {
            return ((this.bitField0_ & 0x20) == 32);
        }

        public int getCurMagicNum() {
            return this.curMagicNum_;
        }

        public boolean hasRingLevel() {
            return ((this.bitField0_ & 0x40) == 64);
        }

        public int getRingLevel() {
            return this.ringLevel_;
        }

        public boolean hasCanGet() {
            return ((this.bitField0_ & 0x80) == 128);
        }

        public int getCanGet() {
            return this.canGet_;
        }

        private void initFields() {
            this.masterys_ = Collections.emptyList();
            this.ring_ = ItemOuterClass.MiniItem.getDefaultInstance();
            this.needRingName_ = "";
            this.needPlayerLevel_ = 0;
            this.needPlayerUpLevel_ = 0;
            this.costMagicNum_ = 0;
            this.curMagicNum_ = 0;
            this.ringLevel_ = 0;
            this.canGet_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            for (int i = 0; i < getMasterysCount(); i++) {
                if (!getMasterys(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            if (hasRing() && !getRing().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        static {
            defaultInstance.initFields();
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            for (int i = 0; i < this.masterys_.size(); i++)
                output.writeMessage(1, (MessageLite) this.masterys_.get(i));
            if ((this.bitField0_ & 0x1) == 1)
                output.writeMessage(2, (MessageLite) this.ring_);
            if ((this.bitField0_ & 0x2) == 2)
                output.writeBytes(3, getNeedRingNameBytes());
            if ((this.bitField0_ & 0x4) == 4)
                output.writeInt32(4, this.needPlayerLevel_);
            if ((this.bitField0_ & 0x8) == 8)
                output.writeInt32(5, this.needPlayerUpLevel_);
            if ((this.bitField0_ & 0x10) == 16)
                output.writeInt32(6, this.costMagicNum_);
            if ((this.bitField0_ & 0x20) == 32)
                output.writeInt32(7, this.curMagicNum_);
            if ((this.bitField0_ & 0x40) == 64)
                output.writeInt32(8, this.ringLevel_);
            if ((this.bitField0_ & 0x80) == 128)
                output.writeInt32(9, this.canGet_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1)
                return size;
            size = 0;
            for (int i = 0; i < this.masterys_.size(); i++)
                size += CodedOutputStream.computeMessageSize(1, (MessageLite) this.masterys_.get(i));
            if ((this.bitField0_ & 0x1) == 1)
                size += CodedOutputStream.computeMessageSize(2, (MessageLite) this.ring_);
            if ((this.bitField0_ & 0x2) == 2)
                size += CodedOutputStream.computeBytesSize(3, getNeedRingNameBytes());
            if ((this.bitField0_ & 0x4) == 4)
                size += CodedOutputStream.computeInt32Size(4, this.needPlayerLevel_);
            if ((this.bitField0_ & 0x8) == 8)
                size += CodedOutputStream.computeInt32Size(5, this.needPlayerUpLevel_);
            if ((this.bitField0_ & 0x10) == 16)
                size += CodedOutputStream.computeInt32Size(6, this.costMagicNum_);
            if ((this.bitField0_ & 0x20) == 32)
                size += CodedOutputStream.computeInt32Size(7, this.curMagicNum_);
            if ((this.bitField0_ & 0x40) == 64)
                size += CodedOutputStream.computeInt32Size(8, this.ringLevel_);
            if ((this.bitField0_ & 0x80) == 128)
                size += CodedOutputStream.computeInt32Size(9, this.canGet_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static AllMastery parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (AllMastery) PARSER.parseFrom(data);
        }

        public static AllMastery parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AllMastery) PARSER.parseFrom(data, extensionRegistry);
        }

        public static AllMastery parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (AllMastery) PARSER.parseFrom(data);
        }

        public static AllMastery parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AllMastery) PARSER.parseFrom(data, extensionRegistry);
        }

        public static AllMastery parseFrom(InputStream input) throws IOException {
            return (AllMastery) PARSER.parseFrom(input);
        }

        public static AllMastery parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AllMastery) PARSER.parseFrom(input, extensionRegistry);
        }

        public static AllMastery parseDelimitedFrom(InputStream input) throws IOException {
            return (AllMastery) PARSER.parseDelimitedFrom(input);
        }

        public static AllMastery parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AllMastery) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static AllMastery parseFrom(CodedInputStream input) throws IOException {
            return (AllMastery) PARSER.parseFrom(input);
        }

        public static AllMastery parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AllMastery) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(AllMastery prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements MasteryHandler.AllMasteryOrBuilder {
            private int bitField0_;
            private List<MasteryHandler.Mastery> masterys_;
            private RepeatedFieldBuilder<MasteryHandler.Mastery, MasteryHandler.Mastery.Builder, MasteryHandler.MasteryOrBuilder> masterysBuilder_;
            private ItemOuterClass.MiniItem ring_;
            private SingleFieldBuilder<ItemOuterClass.MiniItem, ItemOuterClass.MiniItem.Builder, ItemOuterClass.MiniItemOrBuilder> ringBuilder_;
            private Object needRingName_;
            private int needPlayerLevel_;
            private int needPlayerUpLevel_;
            private int costMagicNum_;
            private int curMagicNum_;
            private int ringLevel_;
            private int canGet_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MasteryHandler.internal_static_pomelo_area_AllMastery_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MasteryHandler.internal_static_pomelo_area_AllMastery_fieldAccessorTable.ensureFieldAccessorsInitialized(MasteryHandler.AllMastery.class, Builder.class);
            }

            private Builder() {
                this.masterys_ = Collections.emptyList();
                this.ring_ = ItemOuterClass.MiniItem.getDefaultInstance();
                this.needRingName_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.masterys_ = Collections.emptyList();
                this.ring_ = ItemOuterClass.MiniItem.getDefaultInstance();
                this.needRingName_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MasteryHandler.AllMastery.alwaysUseFieldBuilders) {
                    getMasterysFieldBuilder();
                    getRingFieldBuilder();
                }
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                if (this.masterysBuilder_ == null) {
                    this.masterys_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFE;
                } else {
                    this.masterysBuilder_.clear();
                }
                if (this.ringBuilder_ == null) {
                    this.ring_ = ItemOuterClass.MiniItem.getDefaultInstance();
                } else {
                    this.ringBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFD;
                this.needRingName_ = "";
                this.bitField0_ &= 0xFFFFFFFB;
                this.needPlayerLevel_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                this.needPlayerUpLevel_ = 0;
                this.bitField0_ &= 0xFFFFFFEF;
                this.costMagicNum_ = 0;
                this.bitField0_ &= 0xFFFFFFDF;
                this.curMagicNum_ = 0;
                this.bitField0_ &= 0xFFFFFFBF;
                this.ringLevel_ = 0;
                this.bitField0_ &= 0xFFFFFF7F;
                this.canGet_ = 0;
                this.bitField0_ &= 0xFFFFFEFF;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return MasteryHandler.internal_static_pomelo_area_AllMastery_descriptor;
            }

            public MasteryHandler.AllMastery getDefaultInstanceForType() {
                return MasteryHandler.AllMastery.getDefaultInstance();
            }

            public MasteryHandler.AllMastery build() {
                MasteryHandler.AllMastery result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public MasteryHandler.AllMastery buildPartial() {
                MasteryHandler.AllMastery result = new MasteryHandler.AllMastery(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if (this.masterysBuilder_ == null) {
                    if ((this.bitField0_ & 0x1) == 1) {
                        this.masterys_ = Collections.unmodifiableList(this.masterys_);
                        this.bitField0_ &= 0xFFFFFFFE;
                    }
                    result.masterys_ = this.masterys_;
                } else {
                    result.masterys_ = this.masterysBuilder_.build();
                }
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x1;
                if (this.ringBuilder_ == null) {
                    result.ring_ = this.ring_;
                } else {
                    result.ring_ = (ItemOuterClass.MiniItem) this.ringBuilder_.build();
                }
                if ((from_bitField0_ & 0x4) == 4)
                    to_bitField0_ |= 0x2;
                result.needRingName_ = this.needRingName_;
                if ((from_bitField0_ & 0x8) == 8)
                    to_bitField0_ |= 0x4;
                result.needPlayerLevel_ = this.needPlayerLevel_;
                if ((from_bitField0_ & 0x10) == 16)
                    to_bitField0_ |= 0x8;
                result.needPlayerUpLevel_ = this.needPlayerUpLevel_;
                if ((from_bitField0_ & 0x20) == 32)
                    to_bitField0_ |= 0x10;
                result.costMagicNum_ = this.costMagicNum_;
                if ((from_bitField0_ & 0x40) == 64)
                    to_bitField0_ |= 0x20;
                result.curMagicNum_ = this.curMagicNum_;
                if ((from_bitField0_ & 0x80) == 128)
                    to_bitField0_ |= 0x40;
                result.ringLevel_ = this.ringLevel_;
                if ((from_bitField0_ & 0x100) == 256)
                    to_bitField0_ |= 0x80;
                result.canGet_ = this.canGet_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof MasteryHandler.AllMastery)
                    return mergeFrom((MasteryHandler.AllMastery) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MasteryHandler.AllMastery other) {
                if (other == MasteryHandler.AllMastery.getDefaultInstance())
                    return this;
                if (this.masterysBuilder_ == null) {
                    if (!other.masterys_.isEmpty()) {
                        if (this.masterys_.isEmpty()) {
                            this.masterys_ = other.masterys_;
                            this.bitField0_ &= 0xFFFFFFFE;
                        } else {
                            ensureMasterysIsMutable();
                            this.masterys_.addAll(other.masterys_);
                        }
                        onChanged();
                    }
                } else if (!other.masterys_.isEmpty()) {
                    if (this.masterysBuilder_.isEmpty()) {
                        this.masterysBuilder_.dispose();
                        this.masterysBuilder_ = null;
                        this.masterys_ = other.masterys_;
                        this.bitField0_ &= 0xFFFFFFFE;
                        this.masterysBuilder_ = MasteryHandler.AllMastery.alwaysUseFieldBuilders ? getMasterysFieldBuilder() : null;
                    } else {
                        this.masterysBuilder_.addAllMessages(other.masterys_);
                    }
                }
                if (other.hasRing())
                    mergeRing(other.getRing());
                if (other.hasNeedRingName()) {
                    this.bitField0_ |= 0x4;
                    this.needRingName_ = other.needRingName_;
                    onChanged();
                }
                if (other.hasNeedPlayerLevel())
                    setNeedPlayerLevel(other.getNeedPlayerLevel());
                if (other.hasNeedPlayerUpLevel())
                    setNeedPlayerUpLevel(other.getNeedPlayerUpLevel());
                if (other.hasCostMagicNum())
                    setCostMagicNum(other.getCostMagicNum());
                if (other.hasCurMagicNum())
                    setCurMagicNum(other.getCurMagicNum());
                if (other.hasRingLevel())
                    setRingLevel(other.getRingLevel());
                if (other.hasCanGet())
                    setCanGet(other.getCanGet());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                for (int i = 0; i < getMasterysCount(); i++) {
                    if (!getMasterys(i).isInitialized())
                        return false;
                }
                if (hasRing() && !getRing().isInitialized())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                MasteryHandler.AllMastery parsedMessage = null;
                try {
                    parsedMessage = (MasteryHandler.AllMastery) MasteryHandler.AllMastery.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MasteryHandler.AllMastery) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null)
                        mergeFrom(parsedMessage);
                }
                return this;
            }

            private void ensureMasterysIsMutable() {
                if ((this.bitField0_ & 0x1) != 1) {
                    this.masterys_ = new ArrayList<>(this.masterys_);
                    this.bitField0_ |= 0x1;
                }
            }

            public List<MasteryHandler.Mastery> getMasterysList() {
                if (this.masterysBuilder_ == null)
                    return Collections.unmodifiableList(this.masterys_);
                return this.masterysBuilder_.getMessageList();
            }

            public int getMasterysCount() {
                if (this.masterysBuilder_ == null)
                    return this.masterys_.size();
                return this.masterysBuilder_.getCount();
            }

            public MasteryHandler.Mastery getMasterys(int index) {
                if (this.masterysBuilder_ == null)
                    return this.masterys_.get(index);
                return (MasteryHandler.Mastery) this.masterysBuilder_.getMessage(index);
            }

            public Builder setMasterys(int index, MasteryHandler.Mastery value) {
                if (this.masterysBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureMasterysIsMutable();
                    this.masterys_.set(index, value);
                    onChanged();
                } else {
                    this.masterysBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setMasterys(int index, MasteryHandler.Mastery.Builder builderForValue) {
                if (this.masterysBuilder_ == null) {
                    ensureMasterysIsMutable();
                    this.masterys_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.masterysBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addMasterys(MasteryHandler.Mastery value) {
                if (this.masterysBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureMasterysIsMutable();
                    this.masterys_.add(value);
                    onChanged();
                } else {
                    this.masterysBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addMasterys(int index, MasteryHandler.Mastery value) {
                if (this.masterysBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureMasterysIsMutable();
                    this.masterys_.add(index, value);
                    onChanged();
                } else {
                    this.masterysBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addMasterys(MasteryHandler.Mastery.Builder builderForValue) {
                if (this.masterysBuilder_ == null) {
                    ensureMasterysIsMutable();
                    this.masterys_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.masterysBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addMasterys(int index, MasteryHandler.Mastery.Builder builderForValue) {
                if (this.masterysBuilder_ == null) {
                    ensureMasterysIsMutable();
                    this.masterys_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.masterysBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllMasterys(Iterable<? extends MasteryHandler.Mastery> values) {
                if (this.masterysBuilder_ == null) {
                    ensureMasterysIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.masterys_);
                    onChanged();
                } else {
                    this.masterysBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearMasterys() {
                if (this.masterysBuilder_ == null) {
                    this.masterys_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFE;
                    onChanged();
                } else {
                    this.masterysBuilder_.clear();
                }
                return this;
            }

            public Builder removeMasterys(int index) {
                if (this.masterysBuilder_ == null) {
                    ensureMasterysIsMutable();
                    this.masterys_.remove(index);
                    onChanged();
                } else {
                    this.masterysBuilder_.remove(index);
                }
                return this;
            }

            public MasteryHandler.Mastery.Builder getMasterysBuilder(int index) {
                return (MasteryHandler.Mastery.Builder) getMasterysFieldBuilder().getBuilder(index);
            }

            public MasteryHandler.MasteryOrBuilder getMasterysOrBuilder(int index) {
                if (this.masterysBuilder_ == null)
                    return this.masterys_.get(index);
                return (MasteryHandler.MasteryOrBuilder) this.masterysBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends MasteryHandler.MasteryOrBuilder> getMasterysOrBuilderList() {
                if (this.masterysBuilder_ != null)
                    return this.masterysBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.masterys_);
            }

            public MasteryHandler.Mastery.Builder addMasterysBuilder() {
                return (MasteryHandler.Mastery.Builder) getMasterysFieldBuilder().addBuilder(MasteryHandler.Mastery.getDefaultInstance());
            }

            public MasteryHandler.Mastery.Builder addMasterysBuilder(int index) {
                return (MasteryHandler.Mastery.Builder) getMasterysFieldBuilder().addBuilder(index, MasteryHandler.Mastery.getDefaultInstance());
            }

            public List<MasteryHandler.Mastery.Builder> getMasterysBuilderList() {
                return getMasterysFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<MasteryHandler.Mastery, MasteryHandler.Mastery.Builder, MasteryHandler.MasteryOrBuilder> getMasterysFieldBuilder() {
                if (this.masterysBuilder_ == null) {
                    this.masterysBuilder_ = new RepeatedFieldBuilder(this.masterys_, ((this.bitField0_ & 0x1) == 1), getParentForChildren(), isClean());
                    this.masterys_ = null;
                }
                return this.masterysBuilder_;
            }

            public boolean hasRing() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public ItemOuterClass.MiniItem getRing() {
                if (this.ringBuilder_ == null)
                    return this.ring_;
                return (ItemOuterClass.MiniItem) this.ringBuilder_.getMessage();
            }

            public Builder setRing(ItemOuterClass.MiniItem value) {
                if (this.ringBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    this.ring_ = value;
                    onChanged();
                } else {
                    this.ringBuilder_.setMessage((GeneratedMessage) value);
                }
                this.bitField0_ |= 0x2;
                return this;
            }

            public Builder setRing(ItemOuterClass.MiniItem.Builder builderForValue) {
                if (this.ringBuilder_ == null) {
                    this.ring_ = builderForValue.build();
                    onChanged();
                } else {
                    this.ringBuilder_.setMessage((GeneratedMessage) builderForValue.build());
                }
                this.bitField0_ |= 0x2;
                return this;
            }

            public Builder mergeRing(ItemOuterClass.MiniItem value) {
                if (this.ringBuilder_ == null) {
                    if ((this.bitField0_ & 0x2) == 2 && this.ring_ != ItemOuterClass.MiniItem.getDefaultInstance()) {
                        this.ring_ = ItemOuterClass.MiniItem.newBuilder(this.ring_).mergeFrom(value).buildPartial();
                    } else {
                        this.ring_ = value;
                    }
                    onChanged();
                } else {
                    this.ringBuilder_.mergeFrom((GeneratedMessage) value);
                }
                this.bitField0_ |= 0x2;
                return this;
            }

            public Builder clearRing() {
                if (this.ringBuilder_ == null) {
                    this.ring_ = ItemOuterClass.MiniItem.getDefaultInstance();
                    onChanged();
                } else {
                    this.ringBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            public ItemOuterClass.MiniItem.Builder getRingBuilder() {
                this.bitField0_ |= 0x2;
                onChanged();
                return (ItemOuterClass.MiniItem.Builder) getRingFieldBuilder().getBuilder();
            }

            public ItemOuterClass.MiniItemOrBuilder getRingOrBuilder() {
                if (this.ringBuilder_ != null)
                    return (ItemOuterClass.MiniItemOrBuilder) this.ringBuilder_.getMessageOrBuilder();
                return (ItemOuterClass.MiniItemOrBuilder) this.ring_;
            }

            private SingleFieldBuilder<ItemOuterClass.MiniItem, ItemOuterClass.MiniItem.Builder, ItemOuterClass.MiniItemOrBuilder> getRingFieldBuilder() {
                if (this.ringBuilder_ == null) {
                    this.ringBuilder_ = new SingleFieldBuilder((GeneratedMessage) getRing(), getParentForChildren(), isClean());
                    this.ring_ = null;
                }
                return this.ringBuilder_;
            }

            public boolean hasNeedRingName() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public String getNeedRingName() {
                Object ref = this.needRingName_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.needRingName_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getNeedRingNameBytes() {
                Object ref = this.needRingName_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.needRingName_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setNeedRingName(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x4;
                this.needRingName_ = value;
                onChanged();
                return this;
            }

            public Builder clearNeedRingName() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.needRingName_ = MasteryHandler.AllMastery.getDefaultInstance().getNeedRingName();
                onChanged();
                return this;
            }

            public Builder setNeedRingNameBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x4;
                this.needRingName_ = value;
                onChanged();
                return this;
            }

            public boolean hasNeedPlayerLevel() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public int getNeedPlayerLevel() {
                return this.needPlayerLevel_;
            }

            public Builder setNeedPlayerLevel(int value) {
                this.bitField0_ |= 0x8;
                this.needPlayerLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearNeedPlayerLevel() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.needPlayerLevel_ = 0;
                onChanged();
                return this;
            }

            public boolean hasNeedPlayerUpLevel() {
                return ((this.bitField0_ & 0x10) == 16);
            }

            public int getNeedPlayerUpLevel() {
                return this.needPlayerUpLevel_;
            }

            public Builder setNeedPlayerUpLevel(int value) {
                this.bitField0_ |= 0x10;
                this.needPlayerUpLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearNeedPlayerUpLevel() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.needPlayerUpLevel_ = 0;
                onChanged();
                return this;
            }

            public boolean hasCostMagicNum() {
                return ((this.bitField0_ & 0x20) == 32);
            }

            public int getCostMagicNum() {
                return this.costMagicNum_;
            }

            public Builder setCostMagicNum(int value) {
                this.bitField0_ |= 0x20;
                this.costMagicNum_ = value;
                onChanged();
                return this;
            }

            public Builder clearCostMagicNum() {
                this.bitField0_ &= 0xFFFFFFDF;
                this.costMagicNum_ = 0;
                onChanged();
                return this;
            }

            public boolean hasCurMagicNum() {
                return ((this.bitField0_ & 0x40) == 64);
            }

            public int getCurMagicNum() {
                return this.curMagicNum_;
            }

            public Builder setCurMagicNum(int value) {
                this.bitField0_ |= 0x40;
                this.curMagicNum_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurMagicNum() {
                this.bitField0_ &= 0xFFFFFFBF;
                this.curMagicNum_ = 0;
                onChanged();
                return this;
            }

            public boolean hasRingLevel() {
                return ((this.bitField0_ & 0x80) == 128);
            }

            public int getRingLevel() {
                return this.ringLevel_;
            }

            public Builder setRingLevel(int value) {
                this.bitField0_ |= 0x80;
                this.ringLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearRingLevel() {
                this.bitField0_ &= 0xFFFFFF7F;
                this.ringLevel_ = 0;
                onChanged();
                return this;
            }

            public boolean hasCanGet() {
                return ((this.bitField0_ & 0x100) == 256);
            }

            public int getCanGet() {
                return this.canGet_;
            }

            public Builder setCanGet(int value) {
                this.bitField0_ |= 0x100;
                this.canGet_ = value;
                onChanged();
                return this;
            }

            public Builder clearCanGet() {
                this.bitField0_ &= 0xFFFFFEFF;
                this.canGet_ = 0;
                onChanged();
                return this;
            }
        }
    }

    public static final class GetMasteryInfoRequest extends GeneratedMessage implements GetMasteryInfoRequestOrBuilder {
        private static final GetMasteryInfoRequest defaultInstance = new GetMasteryInfoRequest(true);
        private final UnknownFieldSet unknownFields;

        private GetMasteryInfoRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetMasteryInfoRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetMasteryInfoRequest getDefaultInstance() {
            return defaultInstance;
        }

        public GetMasteryInfoRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetMasteryInfoRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return MasteryHandler.internal_static_pomelo_area_GetMasteryInfoRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MasteryHandler.internal_static_pomelo_area_GetMasteryInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetMasteryInfoRequest.class, Builder.class);
        }

        public static Parser<GetMasteryInfoRequest> PARSER = (Parser<GetMasteryInfoRequest>) new AbstractParser<GetMasteryInfoRequest>() {
            public MasteryHandler.GetMasteryInfoRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MasteryHandler.GetMasteryInfoRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetMasteryInfoRequest> getParserForType() {
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

        public static GetMasteryInfoRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetMasteryInfoRequest) PARSER.parseFrom(data);
        }

        public static GetMasteryInfoRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetMasteryInfoRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetMasteryInfoRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetMasteryInfoRequest) PARSER.parseFrom(data);
        }

        public static GetMasteryInfoRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetMasteryInfoRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetMasteryInfoRequest parseFrom(InputStream input) throws IOException {
            return (GetMasteryInfoRequest) PARSER.parseFrom(input);
        }

        public static GetMasteryInfoRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetMasteryInfoRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static GetMasteryInfoRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (GetMasteryInfoRequest) PARSER.parseDelimitedFrom(input);
        }

        public static GetMasteryInfoRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetMasteryInfoRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static GetMasteryInfoRequest parseFrom(CodedInputStream input) throws IOException {
            return (GetMasteryInfoRequest) PARSER.parseFrom(input);
        }

        public static GetMasteryInfoRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetMasteryInfoRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(GetMasteryInfoRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements MasteryHandler.GetMasteryInfoRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return MasteryHandler.internal_static_pomelo_area_GetMasteryInfoRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MasteryHandler.internal_static_pomelo_area_GetMasteryInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(MasteryHandler.GetMasteryInfoRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MasteryHandler.GetMasteryInfoRequest.alwaysUseFieldBuilders) ;
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
                return MasteryHandler.internal_static_pomelo_area_GetMasteryInfoRequest_descriptor;
            }

            public MasteryHandler.GetMasteryInfoRequest getDefaultInstanceForType() {
                return MasteryHandler.GetMasteryInfoRequest.getDefaultInstance();
            }

            public MasteryHandler.GetMasteryInfoRequest build() {
                MasteryHandler.GetMasteryInfoRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public MasteryHandler.GetMasteryInfoRequest buildPartial() {
                MasteryHandler.GetMasteryInfoRequest result = new MasteryHandler.GetMasteryInfoRequest(this);
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof MasteryHandler.GetMasteryInfoRequest)
                    return mergeFrom((MasteryHandler.GetMasteryInfoRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MasteryHandler.GetMasteryInfoRequest other) {
                if (other == MasteryHandler.GetMasteryInfoRequest.getDefaultInstance()) return this;
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                MasteryHandler.GetMasteryInfoRequest parsedMessage = null;
                try {
                    parsedMessage = (MasteryHandler.GetMasteryInfoRequest) MasteryHandler.GetMasteryInfoRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MasteryHandler.GetMasteryInfoRequest) e.getUnfinishedMessage();
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


    public static final class GetMasteryInfoResponse
            extends GeneratedMessage
            implements GetMasteryInfoResponseOrBuilder {
        private static final GetMasteryInfoResponse defaultInstance = new GetMasteryInfoResponse(true);
        private final UnknownFieldSet unknownFields;

        private GetMasteryInfoResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetMasteryInfoResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetMasteryInfoResponse getDefaultInstance() {
            return defaultInstance;
        }

        public GetMasteryInfoResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetMasteryInfoResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString bs;
                    MasteryHandler.AllMastery.Builder subBuilder;
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
                            if ((this.bitField0_ & 0x4) == 4) subBuilder = this.s2CMastery_.toBuilder();
                            this.s2CMastery_ = (MasteryHandler.AllMastery) input.readMessage(MasteryHandler.AllMastery.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.s2CMastery_);
                                this.s2CMastery_ = subBuilder.buildPartial();
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
            return MasteryHandler.internal_static_pomelo_area_GetMasteryInfoResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MasteryHandler.internal_static_pomelo_area_GetMasteryInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetMasteryInfoResponse.class, Builder.class);
        }

        public static Parser<GetMasteryInfoResponse> PARSER = (Parser<GetMasteryInfoResponse>) new AbstractParser<GetMasteryInfoResponse>() {
            public MasteryHandler.GetMasteryInfoResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MasteryHandler.GetMasteryInfoResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_MASTERY_FIELD_NUMBER = 3;
        private MasteryHandler.AllMastery s2CMastery_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetMasteryInfoResponse> getParserForType() {
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

        public boolean hasS2CMastery() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public MasteryHandler.AllMastery getS2CMastery() {
            return this.s2CMastery_;
        }

        public MasteryHandler.AllMasteryOrBuilder getS2CMasteryOrBuilder() {
            return this.s2CMastery_;
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CMastery_ = MasteryHandler.AllMastery.getDefaultInstance();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasS2CCode()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (hasS2CMastery() && !getS2CMastery().isInitialized()) {
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
            if ((this.bitField0_ & 0x4) == 4) output.writeMessage(3, (MessageLite) this.s2CMastery_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeBytesSize(2, getS2CMsgBytes());
            if ((this.bitField0_ & 0x4) == 4)
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.s2CMastery_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static GetMasteryInfoResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetMasteryInfoResponse) PARSER.parseFrom(data);
        }

        public static GetMasteryInfoResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetMasteryInfoResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetMasteryInfoResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetMasteryInfoResponse) PARSER.parseFrom(data);
        }

        public static GetMasteryInfoResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetMasteryInfoResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetMasteryInfoResponse parseFrom(InputStream input) throws IOException {
            return (GetMasteryInfoResponse) PARSER.parseFrom(input);
        }

        public static GetMasteryInfoResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetMasteryInfoResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static GetMasteryInfoResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (GetMasteryInfoResponse) PARSER.parseDelimitedFrom(input);
        }

        public static GetMasteryInfoResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetMasteryInfoResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static GetMasteryInfoResponse parseFrom(CodedInputStream input) throws IOException {
            return (GetMasteryInfoResponse) PARSER.parseFrom(input);
        }

        public static GetMasteryInfoResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetMasteryInfoResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(GetMasteryInfoResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements MasteryHandler.GetMasteryInfoResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private MasteryHandler.AllMastery s2CMastery_;
            private SingleFieldBuilder<MasteryHandler.AllMastery, MasteryHandler.AllMastery.Builder, MasteryHandler.AllMasteryOrBuilder> s2CMasteryBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MasteryHandler.internal_static_pomelo_area_GetMasteryInfoResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MasteryHandler.internal_static_pomelo_area_GetMasteryInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(MasteryHandler.GetMasteryInfoResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.s2CMastery_ = MasteryHandler.AllMastery.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CMastery_ = MasteryHandler.AllMastery.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MasteryHandler.GetMasteryInfoResponse.alwaysUseFieldBuilders) getS2CMasteryFieldBuilder();
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
                if (this.s2CMasteryBuilder_ == null) {
                    this.s2CMastery_ = MasteryHandler.AllMastery.getDefaultInstance();
                } else {
                    this.s2CMasteryBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return MasteryHandler.internal_static_pomelo_area_GetMasteryInfoResponse_descriptor;
            }

            public MasteryHandler.GetMasteryInfoResponse getDefaultInstanceForType() {
                return MasteryHandler.GetMasteryInfoResponse.getDefaultInstance();
            }

            public MasteryHandler.GetMasteryInfoResponse build() {
                MasteryHandler.GetMasteryInfoResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public MasteryHandler.GetMasteryInfoResponse buildPartial() {
                MasteryHandler.GetMasteryInfoResponse result = new MasteryHandler.GetMasteryInfoResponse(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.s2CMsg_ = this.s2CMsg_;
                if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;
                if (this.s2CMasteryBuilder_ == null) {
                    result.s2CMastery_ = this.s2CMastery_;
                } else {
                    result.s2CMastery_ = (MasteryHandler.AllMastery) this.s2CMasteryBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof MasteryHandler.GetMasteryInfoResponse)
                    return mergeFrom((MasteryHandler.GetMasteryInfoResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MasteryHandler.GetMasteryInfoResponse other) {
                if (other == MasteryHandler.GetMasteryInfoResponse.getDefaultInstance()) return this;
                if (other.hasS2CCode()) setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (other.hasS2CMastery()) mergeS2CMastery(other.getS2CMastery());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode()) return false;
                if (hasS2CMastery() && !getS2CMastery().isInitialized()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                MasteryHandler.GetMasteryInfoResponse parsedMessage = null;
                try {
                    parsedMessage = (MasteryHandler.GetMasteryInfoResponse) MasteryHandler.GetMasteryInfoResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MasteryHandler.GetMasteryInfoResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = MasteryHandler.GetMasteryInfoResponse.getDefaultInstance().getS2CMsg();
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

            public boolean hasS2CMastery() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public MasteryHandler.AllMastery getS2CMastery() {
                if (this.s2CMasteryBuilder_ == null) return this.s2CMastery_;
                return (MasteryHandler.AllMastery) this.s2CMasteryBuilder_.getMessage();
            }

            public Builder setS2CMastery(MasteryHandler.AllMastery value) {
                if (this.s2CMasteryBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    this.s2CMastery_ = value;
                    onChanged();
                } else {
                    this.s2CMasteryBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder setS2CMastery(MasteryHandler.AllMastery.Builder builderForValue) {
                if (this.s2CMasteryBuilder_ == null) {
                    this.s2CMastery_ = builderForValue.build();
                    onChanged();
                } else {
                    this.s2CMasteryBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder mergeS2CMastery(MasteryHandler.AllMastery value) {
                if (this.s2CMasteryBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4 && this.s2CMastery_ != MasteryHandler.AllMastery.getDefaultInstance()) {
                        this.s2CMastery_ = MasteryHandler.AllMastery.newBuilder(this.s2CMastery_).mergeFrom(value).buildPartial();
                    } else {
                        this.s2CMastery_ = value;
                    }
                    onChanged();
                } else {
                    this.s2CMasteryBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder clearS2CMastery() {
                if (this.s2CMasteryBuilder_ == null) {
                    this.s2CMastery_ = MasteryHandler.AllMastery.getDefaultInstance();
                    onChanged();
                } else {
                    this.s2CMasteryBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public MasteryHandler.AllMastery.Builder getS2CMasteryBuilder() {
                this.bitField0_ |= 0x4;
                onChanged();
                return (MasteryHandler.AllMastery.Builder) getS2CMasteryFieldBuilder().getBuilder();
            }

            public MasteryHandler.AllMasteryOrBuilder getS2CMasteryOrBuilder() {
                if (this.s2CMasteryBuilder_ != null)
                    return (MasteryHandler.AllMasteryOrBuilder) this.s2CMasteryBuilder_.getMessageOrBuilder();
                return this.s2CMastery_;
            }

            private SingleFieldBuilder<MasteryHandler.AllMastery, MasteryHandler.AllMastery.Builder, MasteryHandler.AllMasteryOrBuilder> getS2CMasteryFieldBuilder() {
                if (this.s2CMasteryBuilder_ == null) {
                    this.s2CMasteryBuilder_ = new SingleFieldBuilder(getS2CMastery(), getParentForChildren(), isClean());
                    this.s2CMastery_ = null;
                }
                return this.s2CMasteryBuilder_;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class ActiveMasteryRequest
            extends GeneratedMessage
            implements ActiveMasteryRequestOrBuilder {
        private static final ActiveMasteryRequest defaultInstance = new ActiveMasteryRequest(true);
        private final UnknownFieldSet unknownFields;

        private ActiveMasteryRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private ActiveMasteryRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static ActiveMasteryRequest getDefaultInstance() {
            return defaultInstance;
        }

        public ActiveMasteryRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ActiveMasteryRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.c2SPos_ = input.readInt32();
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
            return MasteryHandler.internal_static_pomelo_area_ActiveMasteryRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MasteryHandler.internal_static_pomelo_area_ActiveMasteryRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ActiveMasteryRequest.class, Builder.class);
        }

        public static Parser<ActiveMasteryRequest> PARSER = (Parser<ActiveMasteryRequest>) new AbstractParser<ActiveMasteryRequest>() {
            public MasteryHandler.ActiveMasteryRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MasteryHandler.ActiveMasteryRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_POS_FIELD_NUMBER = 1;
        private int c2SPos_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<ActiveMasteryRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasC2SPos() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getC2SPos() {
            return this.c2SPos_;
        }

        private void initFields() {
            this.c2SPos_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasC2SPos()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.c2SPos_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.c2SPos_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static ActiveMasteryRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ActiveMasteryRequest) PARSER.parseFrom(data);
        }

        public static ActiveMasteryRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ActiveMasteryRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static ActiveMasteryRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ActiveMasteryRequest) PARSER.parseFrom(data);
        }

        public static ActiveMasteryRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ActiveMasteryRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static ActiveMasteryRequest parseFrom(InputStream input) throws IOException {
            return (ActiveMasteryRequest) PARSER.parseFrom(input);
        }

        public static ActiveMasteryRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ActiveMasteryRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static ActiveMasteryRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (ActiveMasteryRequest) PARSER.parseDelimitedFrom(input);
        }

        public static ActiveMasteryRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ActiveMasteryRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static ActiveMasteryRequest parseFrom(CodedInputStream input) throws IOException {
            return (ActiveMasteryRequest) PARSER.parseFrom(input);
        }

        public static ActiveMasteryRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ActiveMasteryRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(ActiveMasteryRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements MasteryHandler.ActiveMasteryRequestOrBuilder {
            private int bitField0_;
            private int c2SPos_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MasteryHandler.internal_static_pomelo_area_ActiveMasteryRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MasteryHandler.internal_static_pomelo_area_ActiveMasteryRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(MasteryHandler.ActiveMasteryRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MasteryHandler.ActiveMasteryRequest.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.c2SPos_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return MasteryHandler.internal_static_pomelo_area_ActiveMasteryRequest_descriptor;
            }

            public MasteryHandler.ActiveMasteryRequest getDefaultInstanceForType() {
                return MasteryHandler.ActiveMasteryRequest.getDefaultInstance();
            }

            public MasteryHandler.ActiveMasteryRequest build() {
                MasteryHandler.ActiveMasteryRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public MasteryHandler.ActiveMasteryRequest buildPartial() {
                MasteryHandler.ActiveMasteryRequest result = new MasteryHandler.ActiveMasteryRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.c2SPos_ = this.c2SPos_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof MasteryHandler.ActiveMasteryRequest)
                    return mergeFrom((MasteryHandler.ActiveMasteryRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MasteryHandler.ActiveMasteryRequest other) {
                if (other == MasteryHandler.ActiveMasteryRequest.getDefaultInstance()) return this;
                if (other.hasC2SPos()) setC2SPos(other.getC2SPos());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasC2SPos()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                MasteryHandler.ActiveMasteryRequest parsedMessage = null;
                try {
                    parsedMessage = (MasteryHandler.ActiveMasteryRequest) MasteryHandler.ActiveMasteryRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MasteryHandler.ActiveMasteryRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasC2SPos() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getC2SPos() {
                return this.c2SPos_;
            }

            public Builder setC2SPos(int value) {
                this.bitField0_ |= 0x1;
                this.c2SPos_ = value;
                onChanged();
                return this;
            }

            public Builder clearC2SPos() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SPos_ = 0;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class ActiveMasteryResponse
            extends GeneratedMessage
            implements ActiveMasteryResponseOrBuilder {
        private static final ActiveMasteryResponse defaultInstance = new ActiveMasteryResponse(true);
        private final UnknownFieldSet unknownFields;

        private ActiveMasteryResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private ActiveMasteryResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static ActiveMasteryResponse getDefaultInstance() {
            return defaultInstance;
        }

        public ActiveMasteryResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ActiveMasteryResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString bs;
                    MasteryHandler.AllMastery.Builder subBuilder;
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
                            this.s2CData_ = (MasteryHandler.AllMastery) input.readMessage(MasteryHandler.AllMastery.PARSER, extensionRegistry);
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
            return MasteryHandler.internal_static_pomelo_area_ActiveMasteryResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MasteryHandler.internal_static_pomelo_area_ActiveMasteryResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ActiveMasteryResponse.class, Builder.class);
        }

        public static Parser<ActiveMasteryResponse> PARSER = (Parser<ActiveMasteryResponse>) new AbstractParser<ActiveMasteryResponse>() {
            public MasteryHandler.ActiveMasteryResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MasteryHandler.ActiveMasteryResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_DATA_FIELD_NUMBER = 3;
        private MasteryHandler.AllMastery s2CData_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<ActiveMasteryResponse> getParserForType() {
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

        public MasteryHandler.AllMastery getS2CData() {
            return this.s2CData_;
        }

        public MasteryHandler.AllMasteryOrBuilder getS2CDataOrBuilder() {
            return this.s2CData_;
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CData_ = MasteryHandler.AllMastery.getDefaultInstance();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
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

        public static ActiveMasteryResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ActiveMasteryResponse) PARSER.parseFrom(data);
        }

        public static ActiveMasteryResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ActiveMasteryResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static ActiveMasteryResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ActiveMasteryResponse) PARSER.parseFrom(data);
        }

        public static ActiveMasteryResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ActiveMasteryResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static ActiveMasteryResponse parseFrom(InputStream input) throws IOException {
            return (ActiveMasteryResponse) PARSER.parseFrom(input);
        }

        public static ActiveMasteryResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ActiveMasteryResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static ActiveMasteryResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (ActiveMasteryResponse) PARSER.parseDelimitedFrom(input);
        }

        public static ActiveMasteryResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ActiveMasteryResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static ActiveMasteryResponse parseFrom(CodedInputStream input) throws IOException {
            return (ActiveMasteryResponse) PARSER.parseFrom(input);
        }

        public static ActiveMasteryResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ActiveMasteryResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(ActiveMasteryResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements MasteryHandler.ActiveMasteryResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private MasteryHandler.AllMastery s2CData_;
            private SingleFieldBuilder<MasteryHandler.AllMastery, MasteryHandler.AllMastery.Builder, MasteryHandler.AllMasteryOrBuilder> s2CDataBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MasteryHandler.internal_static_pomelo_area_ActiveMasteryResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MasteryHandler.internal_static_pomelo_area_ActiveMasteryResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(MasteryHandler.ActiveMasteryResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.s2CData_ = MasteryHandler.AllMastery.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CData_ = MasteryHandler.AllMastery.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MasteryHandler.ActiveMasteryResponse.alwaysUseFieldBuilders) getS2CDataFieldBuilder();
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
                    this.s2CData_ = MasteryHandler.AllMastery.getDefaultInstance();
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
                return MasteryHandler.internal_static_pomelo_area_ActiveMasteryResponse_descriptor;
            }

            public MasteryHandler.ActiveMasteryResponse getDefaultInstanceForType() {
                return MasteryHandler.ActiveMasteryResponse.getDefaultInstance();
            }

            public MasteryHandler.ActiveMasteryResponse build() {
                MasteryHandler.ActiveMasteryResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public MasteryHandler.ActiveMasteryResponse buildPartial() {
                MasteryHandler.ActiveMasteryResponse result = new MasteryHandler.ActiveMasteryResponse(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.s2CMsg_ = this.s2CMsg_;
                if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;
                if (this.s2CDataBuilder_ == null) {
                    result.s2CData_ = this.s2CData_;
                } else {
                    result.s2CData_ = (MasteryHandler.AllMastery) this.s2CDataBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof MasteryHandler.ActiveMasteryResponse)
                    return mergeFrom((MasteryHandler.ActiveMasteryResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MasteryHandler.ActiveMasteryResponse other) {
                if (other == MasteryHandler.ActiveMasteryResponse.getDefaultInstance()) return this;
                if (other.hasS2CCode()) setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (other.hasS2CData()) mergeS2CData(other.getS2CData());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode()) return false;
                if (hasS2CData() && !getS2CData().isInitialized()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                MasteryHandler.ActiveMasteryResponse parsedMessage = null;
                try {
                    parsedMessage = (MasteryHandler.ActiveMasteryResponse) MasteryHandler.ActiveMasteryResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MasteryHandler.ActiveMasteryResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = MasteryHandler.ActiveMasteryResponse.getDefaultInstance().getS2CMsg();
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

            public boolean hasS2CData() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public MasteryHandler.AllMastery getS2CData() {
                if (this.s2CDataBuilder_ == null) return this.s2CData_;
                return (MasteryHandler.AllMastery) this.s2CDataBuilder_.getMessage();
            }

            public Builder setS2CData(MasteryHandler.AllMastery value) {
                if (this.s2CDataBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    this.s2CData_ = value;
                    onChanged();
                } else {
                    this.s2CDataBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder setS2CData(MasteryHandler.AllMastery.Builder builderForValue) {
                if (this.s2CDataBuilder_ == null) {
                    this.s2CData_ = builderForValue.build();
                    onChanged();
                } else {
                    this.s2CDataBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder mergeS2CData(MasteryHandler.AllMastery value) {
                if (this.s2CDataBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4 && this.s2CData_ != MasteryHandler.AllMastery.getDefaultInstance()) {
                        this.s2CData_ = MasteryHandler.AllMastery.newBuilder(this.s2CData_).mergeFrom(value).buildPartial();
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
                    this.s2CData_ = MasteryHandler.AllMastery.getDefaultInstance();
                    onChanged();
                } else {
                    this.s2CDataBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public MasteryHandler.AllMastery.Builder getS2CDataBuilder() {
                this.bitField0_ |= 0x4;
                onChanged();
                return (MasteryHandler.AllMastery.Builder) getS2CDataFieldBuilder().getBuilder();
            }

            public MasteryHandler.AllMasteryOrBuilder getS2CDataOrBuilder() {
                if (this.s2CDataBuilder_ != null)
                    return (MasteryHandler.AllMasteryOrBuilder) this.s2CDataBuilder_.getMessageOrBuilder();
                return this.s2CData_;
            }

            private SingleFieldBuilder<MasteryHandler.AllMastery, MasteryHandler.AllMastery.Builder, MasteryHandler.AllMasteryOrBuilder> getS2CDataFieldBuilder() {
                if (this.s2CDataBuilder_ == null) {
                    this.s2CDataBuilder_ = new SingleFieldBuilder(getS2CData(), getParentForChildren(), isClean());
                    this.s2CData_ = null;
                }
                return this.s2CDataBuilder_;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class GetRingRequest
            extends GeneratedMessage
            implements GetRingRequestOrBuilder {
        private static final GetRingRequest defaultInstance = new GetRingRequest(true);
        private final UnknownFieldSet unknownFields;

        private GetRingRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetRingRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetRingRequest getDefaultInstance() {
            return defaultInstance;
        }

        public GetRingRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetRingRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.c2SRingId_ = bs;
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
            return MasteryHandler.internal_static_pomelo_area_GetRingRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MasteryHandler.internal_static_pomelo_area_GetRingRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(GetRingRequest.class, Builder.class);
        }

        public static Parser<GetRingRequest> PARSER = (Parser<GetRingRequest>) new AbstractParser<GetRingRequest>() {
            public MasteryHandler.GetRingRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MasteryHandler.GetRingRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_RINGID_FIELD_NUMBER = 1;
        private Object c2SRingId_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetRingRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasC2SRingId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public String getC2SRingId() {
            Object ref = this.c2SRingId_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.c2SRingId_ = s;
            return s;
        }

        public ByteString getC2SRingIdBytes() {
            Object ref = this.c2SRingId_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.c2SRingId_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        private void initFields() {
            this.c2SRingId_ = "";
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasC2SRingId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeBytes(1, getC2SRingIdBytes());
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeBytesSize(1, getC2SRingIdBytes());
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static GetRingRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetRingRequest) PARSER.parseFrom(data);
        }

        public static GetRingRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetRingRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetRingRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetRingRequest) PARSER.parseFrom(data);
        }

        public static GetRingRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetRingRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetRingRequest parseFrom(InputStream input) throws IOException {
            return (GetRingRequest) PARSER.parseFrom(input);
        }

        public static GetRingRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetRingRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static GetRingRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (GetRingRequest) PARSER.parseDelimitedFrom(input);
        }

        public static GetRingRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetRingRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static GetRingRequest parseFrom(CodedInputStream input) throws IOException {
            return (GetRingRequest) PARSER.parseFrom(input);
        }

        public static GetRingRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetRingRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(GetRingRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements MasteryHandler.GetRingRequestOrBuilder {
            private int bitField0_;
            private Object c2SRingId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MasteryHandler.internal_static_pomelo_area_GetRingRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MasteryHandler.internal_static_pomelo_area_GetRingRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(MasteryHandler.GetRingRequest.class, Builder.class);
            }

            private Builder() {
                this.c2SRingId_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.c2SRingId_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MasteryHandler.GetRingRequest.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.c2SRingId_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return MasteryHandler.internal_static_pomelo_area_GetRingRequest_descriptor;
            }

            public MasteryHandler.GetRingRequest getDefaultInstanceForType() {
                return MasteryHandler.GetRingRequest.getDefaultInstance();
            }

            public MasteryHandler.GetRingRequest build() {
                MasteryHandler.GetRingRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public MasteryHandler.GetRingRequest buildPartial() {
                MasteryHandler.GetRingRequest result = new MasteryHandler.GetRingRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.c2SRingId_ = this.c2SRingId_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof MasteryHandler.GetRingRequest)
                    return mergeFrom((MasteryHandler.GetRingRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MasteryHandler.GetRingRequest other) {
                if (other == MasteryHandler.GetRingRequest.getDefaultInstance()) return this;
                if (other.hasC2SRingId()) {
                    this.bitField0_ |= 0x1;
                    this.c2SRingId_ = other.c2SRingId_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasC2SRingId()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                MasteryHandler.GetRingRequest parsedMessage = null;
                try {
                    parsedMessage = (MasteryHandler.GetRingRequest) MasteryHandler.GetRingRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MasteryHandler.GetRingRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasC2SRingId() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public String getC2SRingId() {
                Object ref = this.c2SRingId_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) this.c2SRingId_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getC2SRingIdBytes() {
                Object ref = this.c2SRingId_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.c2SRingId_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setC2SRingId(String value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.c2SRingId_ = value;
                onChanged();
                return this;
            }

            public Builder clearC2SRingId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SRingId_ = MasteryHandler.GetRingRequest.getDefaultInstance().getC2SRingId();
                onChanged();
                return this;
            }

            public Builder setC2SRingIdBytes(ByteString value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.c2SRingId_ = value;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class GetRingResponse
            extends GeneratedMessage
            implements GetRingResponseOrBuilder {
        private static final GetRingResponse defaultInstance = new GetRingResponse(true);
        private final UnknownFieldSet unknownFields;

        private GetRingResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetRingResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetRingResponse getDefaultInstance() {
            return defaultInstance;
        }

        public GetRingResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetRingResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString bs;
                    MasteryHandler.AllMastery.Builder subBuilder;
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
                            this.s2CData_ = (MasteryHandler.AllMastery) input.readMessage(MasteryHandler.AllMastery.PARSER, extensionRegistry);
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
            return MasteryHandler.internal_static_pomelo_area_GetRingResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MasteryHandler.internal_static_pomelo_area_GetRingResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetRingResponse.class, Builder.class);
        }

        public static Parser<GetRingResponse> PARSER = (Parser<GetRingResponse>) new AbstractParser<GetRingResponse>() {
            public MasteryHandler.GetRingResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MasteryHandler.GetRingResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_DATA_FIELD_NUMBER = 3;
        private MasteryHandler.AllMastery s2CData_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetRingResponse> getParserForType() {
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

        public MasteryHandler.AllMastery getS2CData() {
            return this.s2CData_;
        }

        public MasteryHandler.AllMasteryOrBuilder getS2CDataOrBuilder() {
            return this.s2CData_;
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CData_ = MasteryHandler.AllMastery.getDefaultInstance();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
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

        public static GetRingResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetRingResponse) PARSER.parseFrom(data);
        }

        public static GetRingResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetRingResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetRingResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetRingResponse) PARSER.parseFrom(data);
        }

        public static GetRingResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetRingResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetRingResponse parseFrom(InputStream input) throws IOException {
            return (GetRingResponse) PARSER.parseFrom(input);
        }

        public static GetRingResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetRingResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static GetRingResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (GetRingResponse) PARSER.parseDelimitedFrom(input);
        }

        public static GetRingResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetRingResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static GetRingResponse parseFrom(CodedInputStream input) throws IOException {
            return (GetRingResponse) PARSER.parseFrom(input);
        }

        public static GetRingResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetRingResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(GetRingResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements MasteryHandler.GetRingResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private MasteryHandler.AllMastery s2CData_;
            private SingleFieldBuilder<MasteryHandler.AllMastery, MasteryHandler.AllMastery.Builder, MasteryHandler.AllMasteryOrBuilder> s2CDataBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MasteryHandler.internal_static_pomelo_area_GetRingResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MasteryHandler.internal_static_pomelo_area_GetRingResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(MasteryHandler.GetRingResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.s2CData_ = MasteryHandler.AllMastery.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CData_ = MasteryHandler.AllMastery.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MasteryHandler.GetRingResponse.alwaysUseFieldBuilders) getS2CDataFieldBuilder();
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
                    this.s2CData_ = MasteryHandler.AllMastery.getDefaultInstance();
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
                return MasteryHandler.internal_static_pomelo_area_GetRingResponse_descriptor;
            }

            public MasteryHandler.GetRingResponse getDefaultInstanceForType() {
                return MasteryHandler.GetRingResponse.getDefaultInstance();
            }

            public MasteryHandler.GetRingResponse build() {
                MasteryHandler.GetRingResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public MasteryHandler.GetRingResponse buildPartial() {
                MasteryHandler.GetRingResponse result = new MasteryHandler.GetRingResponse(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.s2CMsg_ = this.s2CMsg_;
                if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;
                if (this.s2CDataBuilder_ == null) {
                    result.s2CData_ = this.s2CData_;
                } else {
                    result.s2CData_ = (MasteryHandler.AllMastery) this.s2CDataBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof MasteryHandler.GetRingResponse)
                    return mergeFrom((MasteryHandler.GetRingResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MasteryHandler.GetRingResponse other) {
                if (other == MasteryHandler.GetRingResponse.getDefaultInstance()) return this;
                if (other.hasS2CCode()) setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (other.hasS2CData()) mergeS2CData(other.getS2CData());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode()) return false;
                if (hasS2CData() && !getS2CData().isInitialized()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                MasteryHandler.GetRingResponse parsedMessage = null;
                try {
                    parsedMessage = (MasteryHandler.GetRingResponse) MasteryHandler.GetRingResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MasteryHandler.GetRingResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = MasteryHandler.GetRingResponse.getDefaultInstance().getS2CMsg();
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

            public boolean hasS2CData() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public MasteryHandler.AllMastery getS2CData() {
                if (this.s2CDataBuilder_ == null) return this.s2CData_;
                return (MasteryHandler.AllMastery) this.s2CDataBuilder_.getMessage();
            }

            public Builder setS2CData(MasteryHandler.AllMastery value) {
                if (this.s2CDataBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    this.s2CData_ = value;
                    onChanged();
                } else {
                    this.s2CDataBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder setS2CData(MasteryHandler.AllMastery.Builder builderForValue) {
                if (this.s2CDataBuilder_ == null) {
                    this.s2CData_ = builderForValue.build();
                    onChanged();
                } else {
                    this.s2CDataBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x4;
                return this;
            }

            public Builder mergeS2CData(MasteryHandler.AllMastery value) {
                if (this.s2CDataBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4 && this.s2CData_ != MasteryHandler.AllMastery.getDefaultInstance()) {
                        this.s2CData_ = MasteryHandler.AllMastery.newBuilder(this.s2CData_).mergeFrom(value).buildPartial();
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
                    this.s2CData_ = MasteryHandler.AllMastery.getDefaultInstance();
                    onChanged();
                } else {
                    this.s2CDataBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public MasteryHandler.AllMastery.Builder getS2CDataBuilder() {
                this.bitField0_ |= 0x4;
                onChanged();
                return (MasteryHandler.AllMastery.Builder) getS2CDataFieldBuilder().getBuilder();
            }

            public MasteryHandler.AllMasteryOrBuilder getS2CDataOrBuilder() {
                if (this.s2CDataBuilder_ != null)
                    return (MasteryHandler.AllMasteryOrBuilder) this.s2CDataBuilder_.getMessageOrBuilder();
                return this.s2CData_;
            }

            private SingleFieldBuilder<MasteryHandler.AllMastery, MasteryHandler.AllMastery.Builder, MasteryHandler.AllMasteryOrBuilder> getS2CDataFieldBuilder() {
                if (this.s2CDataBuilder_ == null) {
                    this.s2CDataBuilder_ = new SingleFieldBuilder(getS2CData(), getParentForChildren(), isClean());
                    this.s2CData_ = null;
                }
                return this.s2CDataBuilder_;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class MasteryRing
            extends GeneratedMessage
            implements MasteryRingOrBuilder {
        private static final MasteryRing defaultInstance = new MasteryRing(true);
        private final UnknownFieldSet unknownFields;

        private MasteryRing(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private MasteryRing(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static MasteryRing getDefaultInstance() {
            return defaultInstance;
        }

        public MasteryRing getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MasteryRing(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            if ((this.bitField0_ & 0x1) == 1) subBuilder = this.ring_.toBuilder();
                            this.ring_ = (ItemOuterClass.MiniItem) input.readMessage(ItemOuterClass.MiniItem.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.ring_);
                                this.ring_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 0x1;
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.needPlayerLevel_ = input.readInt32();
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.needPlayerUpLevel_ = input.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.costMagicNum_ = input.readInt32();
                            break;
                        case 42:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x10;
                            this.needRingName_ = bs;
                            break;
                        case 48:
                            this.bitField0_ |= 0x20;
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
            return MasteryHandler.internal_static_pomelo_area_MasteryRing_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MasteryHandler.internal_static_pomelo_area_MasteryRing_fieldAccessorTable.ensureFieldAccessorsInitialized(MasteryRing.class, Builder.class);
        }

        public static Parser<MasteryRing> PARSER = (Parser<MasteryRing>) new AbstractParser<MasteryRing>() {
            public MasteryHandler.MasteryRing parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MasteryHandler.MasteryRing(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int RING_FIELD_NUMBER = 1;
        private ItemOuterClass.MiniItem ring_;
        public static final int NEEDPLAYERLEVEL_FIELD_NUMBER = 2;
        private int needPlayerLevel_;
        public static final int NEEDPLAYERUPLEVEL_FIELD_NUMBER = 3;
        private int needPlayerUpLevel_;
        public static final int COSTMAGICNUM_FIELD_NUMBER = 4;
        private int costMagicNum_;
        public static final int NEEDRINGNAME_FIELD_NUMBER = 5;
        private Object needRingName_;
        public static final int ISGET_FIELD_NUMBER = 6;
        private int isGet_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<MasteryRing> getParserForType() {
            return PARSER;
        }

        public boolean hasRing() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public ItemOuterClass.MiniItem getRing() {
            return this.ring_;
        }

        public ItemOuterClass.MiniItemOrBuilder getRingOrBuilder() {
            return (ItemOuterClass.MiniItemOrBuilder) this.ring_;
        }

        public boolean hasNeedPlayerLevel() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        static {
            defaultInstance.initFields();
        }

        public int getNeedPlayerLevel() {
            return this.needPlayerLevel_;
        }

        public boolean hasNeedPlayerUpLevel() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getNeedPlayerUpLevel() {
            return this.needPlayerUpLevel_;
        }

        public boolean hasCostMagicNum() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public int getCostMagicNum() {
            return this.costMagicNum_;
        }

        public boolean hasNeedRingName() {
            return ((this.bitField0_ & 0x10) == 16);
        }

        public String getNeedRingName() {
            Object ref = this.needRingName_;
            if (ref instanceof String)
                return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8())
                this.needRingName_ = s;
            return s;
        }

        public ByteString getNeedRingNameBytes() {
            Object ref = this.needRingName_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.needRingName_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasIsGet() {
            return ((this.bitField0_ & 0x20) == 32);
        }

        public int getIsGet() {
            return this.isGet_;
        }

        private void initFields() {
            this.ring_ = ItemOuterClass.MiniItem.getDefaultInstance();
            this.needPlayerLevel_ = 0;
            this.needPlayerUpLevel_ = 0;
            this.costMagicNum_ = 0;
            this.needRingName_ = "";
            this.isGet_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1)
                return true;
            if (isInitialized == 0)
                return false;
            if (!hasRing()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!getRing().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1)
                output.writeMessage(1, (MessageLite) this.ring_);
            if ((this.bitField0_ & 0x2) == 2)
                output.writeInt32(2, this.needPlayerLevel_);
            if ((this.bitField0_ & 0x4) == 4)
                output.writeInt32(3, this.needPlayerUpLevel_);
            if ((this.bitField0_ & 0x8) == 8)
                output.writeInt32(4, this.costMagicNum_);
            if ((this.bitField0_ & 0x10) == 16)
                output.writeBytes(5, getNeedRingNameBytes());
            if ((this.bitField0_ & 0x20) == 32)
                output.writeInt32(6, this.isGet_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1)
                return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1)
                size += CodedOutputStream.computeMessageSize(1, (MessageLite) this.ring_);
            if ((this.bitField0_ & 0x2) == 2)
                size += CodedOutputStream.computeInt32Size(2, this.needPlayerLevel_);
            if ((this.bitField0_ & 0x4) == 4)
                size += CodedOutputStream.computeInt32Size(3, this.needPlayerUpLevel_);
            if ((this.bitField0_ & 0x8) == 8)
                size += CodedOutputStream.computeInt32Size(4, this.costMagicNum_);
            if ((this.bitField0_ & 0x10) == 16)
                size += CodedOutputStream.computeBytesSize(5, getNeedRingNameBytes());
            if ((this.bitField0_ & 0x20) == 32)
                size += CodedOutputStream.computeInt32Size(6, this.isGet_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static MasteryRing parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (MasteryRing) PARSER.parseFrom(data);
        }

        public static MasteryRing parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MasteryRing) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MasteryRing parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (MasteryRing) PARSER.parseFrom(data);
        }

        public static MasteryRing parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MasteryRing) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MasteryRing parseFrom(InputStream input) throws IOException {
            return (MasteryRing) PARSER.parseFrom(input);
        }

        public static MasteryRing parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MasteryRing) PARSER.parseFrom(input, extensionRegistry);
        }

        public static MasteryRing parseDelimitedFrom(InputStream input) throws IOException {
            return (MasteryRing) PARSER.parseDelimitedFrom(input);
        }

        public static MasteryRing parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MasteryRing) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static MasteryRing parseFrom(CodedInputStream input) throws IOException {
            return (MasteryRing) PARSER.parseFrom(input);
        }

        public static MasteryRing parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MasteryRing) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(MasteryRing prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements MasteryHandler.MasteryRingOrBuilder {
            private int bitField0_;
            private ItemOuterClass.MiniItem ring_;
            private SingleFieldBuilder<ItemOuterClass.MiniItem, ItemOuterClass.MiniItem.Builder, ItemOuterClass.MiniItemOrBuilder> ringBuilder_;
            private int needPlayerLevel_;
            private int needPlayerUpLevel_;
            private int costMagicNum_;
            private Object needRingName_;
            private int isGet_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MasteryHandler.internal_static_pomelo_area_MasteryRing_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MasteryHandler.internal_static_pomelo_area_MasteryRing_fieldAccessorTable.ensureFieldAccessorsInitialized(MasteryHandler.MasteryRing.class, Builder.class);
            }

            private Builder() {
                this.ring_ = ItemOuterClass.MiniItem.getDefaultInstance();
                this.needRingName_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.ring_ = ItemOuterClass.MiniItem.getDefaultInstance();
                this.needRingName_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MasteryHandler.MasteryRing.alwaysUseFieldBuilders)
                    getRingFieldBuilder();
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                if (this.ringBuilder_ == null) {
                    this.ring_ = ItemOuterClass.MiniItem.getDefaultInstance();
                } else {
                    this.ringBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFE;
                this.needPlayerLevel_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                this.needPlayerUpLevel_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.costMagicNum_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                this.needRingName_ = "";
                this.bitField0_ &= 0xFFFFFFEF;
                this.isGet_ = 0;
                this.bitField0_ &= 0xFFFFFFDF;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return MasteryHandler.internal_static_pomelo_area_MasteryRing_descriptor;
            }

            public MasteryHandler.MasteryRing getDefaultInstanceForType() {
                return MasteryHandler.MasteryRing.getDefaultInstance();
            }

            public MasteryHandler.MasteryRing build() {
                MasteryHandler.MasteryRing result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public MasteryHandler.MasteryRing buildPartial() {
                MasteryHandler.MasteryRing result = new MasteryHandler.MasteryRing(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                if (this.ringBuilder_ == null) {
                    result.ring_ = this.ring_;
                } else {
                    result.ring_ = (ItemOuterClass.MiniItem) this.ringBuilder_.build();
                }
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.needPlayerLevel_ = this.needPlayerLevel_;
                if ((from_bitField0_ & 0x4) == 4)
                    to_bitField0_ |= 0x4;
                result.needPlayerUpLevel_ = this.needPlayerUpLevel_;
                if ((from_bitField0_ & 0x8) == 8)
                    to_bitField0_ |= 0x8;
                result.costMagicNum_ = this.costMagicNum_;
                if ((from_bitField0_ & 0x10) == 16)
                    to_bitField0_ |= 0x10;
                result.needRingName_ = this.needRingName_;
                if ((from_bitField0_ & 0x20) == 32)
                    to_bitField0_ |= 0x20;
                result.isGet_ = this.isGet_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof MasteryHandler.MasteryRing)
                    return mergeFrom((MasteryHandler.MasteryRing) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MasteryHandler.MasteryRing other) {
                if (other == MasteryHandler.MasteryRing.getDefaultInstance())
                    return this;
                if (other.hasRing())
                    mergeRing(other.getRing());
                if (other.hasNeedPlayerLevel())
                    setNeedPlayerLevel(other.getNeedPlayerLevel());
                if (other.hasNeedPlayerUpLevel())
                    setNeedPlayerUpLevel(other.getNeedPlayerUpLevel());
                if (other.hasCostMagicNum())
                    setCostMagicNum(other.getCostMagicNum());
                if (other.hasNeedRingName()) {
                    this.bitField0_ |= 0x10;
                    this.needRingName_ = other.needRingName_;
                    onChanged();
                }
                if (other.hasIsGet())
                    setIsGet(other.getIsGet());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasRing())
                    return false;
                if (!getRing().isInitialized())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                MasteryHandler.MasteryRing parsedMessage = null;
                try {
                    parsedMessage = (MasteryHandler.MasteryRing) MasteryHandler.MasteryRing.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MasteryHandler.MasteryRing) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null)
                        mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasRing() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public ItemOuterClass.MiniItem getRing() {
                if (this.ringBuilder_ == null)
                    return this.ring_;
                return (ItemOuterClass.MiniItem) this.ringBuilder_.getMessage();
            }

            public Builder setRing(ItemOuterClass.MiniItem value) {
                if (this.ringBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    this.ring_ = value;
                    onChanged();
                } else {
                    this.ringBuilder_.setMessage((GeneratedMessage) value);
                }
                this.bitField0_ |= 0x1;
                return this;
            }

            public Builder setRing(ItemOuterClass.MiniItem.Builder builderForValue) {
                if (this.ringBuilder_ == null) {
                    this.ring_ = builderForValue.build();
                    onChanged();
                } else {
                    this.ringBuilder_.setMessage((GeneratedMessage) builderForValue.build());
                }
                this.bitField0_ |= 0x1;
                return this;
            }

            public Builder mergeRing(ItemOuterClass.MiniItem value) {
                if (this.ringBuilder_ == null) {
                    if ((this.bitField0_ & 0x1) == 1 && this.ring_ != ItemOuterClass.MiniItem.getDefaultInstance()) {
                        this.ring_ = ItemOuterClass.MiniItem.newBuilder(this.ring_).mergeFrom(value).buildPartial();
                    } else {
                        this.ring_ = value;
                    }
                    onChanged();
                } else {
                    this.ringBuilder_.mergeFrom((GeneratedMessage) value);
                }
                this.bitField0_ |= 0x1;
                return this;
            }

            public Builder clearRing() {
                if (this.ringBuilder_ == null) {
                    this.ring_ = ItemOuterClass.MiniItem.getDefaultInstance();
                    onChanged();
                } else {
                    this.ringBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            public ItemOuterClass.MiniItem.Builder getRingBuilder() {
                this.bitField0_ |= 0x1;
                onChanged();
                return (ItemOuterClass.MiniItem.Builder) getRingFieldBuilder().getBuilder();
            }

            public ItemOuterClass.MiniItemOrBuilder getRingOrBuilder() {
                if (this.ringBuilder_ != null)
                    return (ItemOuterClass.MiniItemOrBuilder) this.ringBuilder_.getMessageOrBuilder();
                return (ItemOuterClass.MiniItemOrBuilder) this.ring_;
            }

            private SingleFieldBuilder<ItemOuterClass.MiniItem, ItemOuterClass.MiniItem.Builder, ItemOuterClass.MiniItemOrBuilder> getRingFieldBuilder() {
                if (this.ringBuilder_ == null) {
                    this.ringBuilder_ = new SingleFieldBuilder((GeneratedMessage) getRing(), getParentForChildren(), isClean());
                    this.ring_ = null;
                }
                return this.ringBuilder_;
            }

            public boolean hasNeedPlayerLevel() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getNeedPlayerLevel() {
                return this.needPlayerLevel_;
            }

            public Builder setNeedPlayerLevel(int value) {
                this.bitField0_ |= 0x2;
                this.needPlayerLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearNeedPlayerLevel() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.needPlayerLevel_ = 0;
                onChanged();
                return this;
            }

            public boolean hasNeedPlayerUpLevel() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public int getNeedPlayerUpLevel() {
                return this.needPlayerUpLevel_;
            }

            public Builder setNeedPlayerUpLevel(int value) {
                this.bitField0_ |= 0x4;
                this.needPlayerUpLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearNeedPlayerUpLevel() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.needPlayerUpLevel_ = 0;
                onChanged();
                return this;
            }

            public boolean hasCostMagicNum() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public int getCostMagicNum() {
                return this.costMagicNum_;
            }

            public Builder setCostMagicNum(int value) {
                this.bitField0_ |= 0x8;
                this.costMagicNum_ = value;
                onChanged();
                return this;
            }

            public Builder clearCostMagicNum() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.costMagicNum_ = 0;
                onChanged();
                return this;
            }

            public boolean hasNeedRingName() {
                return ((this.bitField0_ & 0x10) == 16);
            }

            public String getNeedRingName() {
                Object ref = this.needRingName_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.needRingName_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getNeedRingNameBytes() {
                Object ref = this.needRingName_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.needRingName_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setNeedRingName(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x10;
                this.needRingName_ = value;
                onChanged();
                return this;
            }

            public Builder clearNeedRingName() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.needRingName_ = MasteryHandler.MasteryRing.getDefaultInstance().getNeedRingName();
                onChanged();
                return this;
            }

            public Builder setNeedRingNameBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x10;
                this.needRingName_ = value;
                onChanged();
                return this;
            }

            public boolean hasIsGet() {
                return ((this.bitField0_ & 0x20) == 32);
            }

            public int getIsGet() {
                return this.isGet_;
            }

            public Builder setIsGet(int value) {
                this.bitField0_ |= 0x20;
                this.isGet_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsGet() {
                this.bitField0_ &= 0xFFFFFFDF;
                this.isGet_ = 0;
                onChanged();
                return this;
            }
        }
    }

    public static final class MasteryRingRequest extends GeneratedMessage implements MasteryRingRequestOrBuilder {
        private static final MasteryRingRequest defaultInstance = new MasteryRingRequest(true);
        private final UnknownFieldSet unknownFields;

        private MasteryRingRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private MasteryRingRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static MasteryRingRequest getDefaultInstance() {
            return defaultInstance;
        }

        public MasteryRingRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MasteryRingRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return MasteryHandler.internal_static_pomelo_area_MasteryRingRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MasteryHandler.internal_static_pomelo_area_MasteryRingRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(MasteryRingRequest.class, Builder.class);
        }

        public static Parser<MasteryRingRequest> PARSER = (Parser<MasteryRingRequest>) new AbstractParser<MasteryRingRequest>() {
            public MasteryHandler.MasteryRingRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MasteryHandler.MasteryRingRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<MasteryRingRequest> getParserForType() {
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

        public static MasteryRingRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (MasteryRingRequest) PARSER.parseFrom(data);
        }

        public static MasteryRingRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MasteryRingRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MasteryRingRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (MasteryRingRequest) PARSER.parseFrom(data);
        }

        public static MasteryRingRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MasteryRingRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MasteryRingRequest parseFrom(InputStream input) throws IOException {
            return (MasteryRingRequest) PARSER.parseFrom(input);
        }

        public static MasteryRingRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MasteryRingRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static MasteryRingRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (MasteryRingRequest) PARSER.parseDelimitedFrom(input);
        }

        public static MasteryRingRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MasteryRingRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static MasteryRingRequest parseFrom(CodedInputStream input) throws IOException {
            return (MasteryRingRequest) PARSER.parseFrom(input);
        }

        public static MasteryRingRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MasteryRingRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(MasteryRingRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements MasteryHandler.MasteryRingRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return MasteryHandler.internal_static_pomelo_area_MasteryRingRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MasteryHandler.internal_static_pomelo_area_MasteryRingRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(MasteryHandler.MasteryRingRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MasteryHandler.MasteryRingRequest.alwaysUseFieldBuilders) ;
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
                return MasteryHandler.internal_static_pomelo_area_MasteryRingRequest_descriptor;
            }

            public MasteryHandler.MasteryRingRequest getDefaultInstanceForType() {
                return MasteryHandler.MasteryRingRequest.getDefaultInstance();
            }

            public MasteryHandler.MasteryRingRequest build() {
                MasteryHandler.MasteryRingRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public MasteryHandler.MasteryRingRequest buildPartial() {
                MasteryHandler.MasteryRingRequest result = new MasteryHandler.MasteryRingRequest(this);
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof MasteryHandler.MasteryRingRequest)
                    return mergeFrom((MasteryHandler.MasteryRingRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MasteryHandler.MasteryRingRequest other) {
                if (other == MasteryHandler.MasteryRingRequest.getDefaultInstance()) return this;
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                MasteryHandler.MasteryRingRequest parsedMessage = null;
                try {
                    parsedMessage = (MasteryHandler.MasteryRingRequest) MasteryHandler.MasteryRingRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MasteryHandler.MasteryRingRequest) e.getUnfinishedMessage();
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


    public static final class MasteryRingResponse
            extends GeneratedMessage
            implements MasteryRingResponseOrBuilder {
        private static final MasteryRingResponse defaultInstance = new MasteryRingResponse(true);
        private final UnknownFieldSet unknownFields;

        private MasteryRingResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private MasteryRingResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static MasteryRingResponse getDefaultInstance() {
            return defaultInstance;
        }

        public MasteryRingResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MasteryRingResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.s2CRing_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x4;
                            }
                            this.s2CRing_.add(input.readMessage(MasteryHandler.MasteryRing.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x4) == 4) this.s2CRing_ = Collections.unmodifiableList(this.s2CRing_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MasteryHandler.internal_static_pomelo_area_MasteryRingResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MasteryHandler.internal_static_pomelo_area_MasteryRingResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(MasteryRingResponse.class, Builder.class);
        }

        public static Parser<MasteryRingResponse> PARSER = (Parser<MasteryRingResponse>) new AbstractParser<MasteryRingResponse>() {
            public MasteryHandler.MasteryRingResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MasteryHandler.MasteryRingResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_RING_FIELD_NUMBER = 3;
        private List<MasteryHandler.MasteryRing> s2CRing_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<MasteryRingResponse> getParserForType() {
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

        public List<MasteryHandler.MasteryRing> getS2CRingList() {
            return this.s2CRing_;
        }

        public List<? extends MasteryHandler.MasteryRingOrBuilder> getS2CRingOrBuilderList() {
            return (List) this.s2CRing_;
        }

        public int getS2CRingCount() {
            return this.s2CRing_.size();
        }

        public MasteryHandler.MasteryRing getS2CRing(int index) {
            return this.s2CRing_.get(index);
        }

        public MasteryHandler.MasteryRingOrBuilder getS2CRingOrBuilder(int index) {
            return this.s2CRing_.get(index);
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CRing_ = Collections.emptyList();
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
            for (int i = 0; i < getS2CRingCount(); i++) {
                if (!getS2CRing(i).isInitialized()) {
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
            for (int i = 0; i < this.s2CRing_.size(); i++)
                output.writeMessage(3, (MessageLite) this.s2CRing_.get(i));
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
            for (int i = 0; i < this.s2CRing_.size(); i++)
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.s2CRing_.get(i));
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static MasteryRingResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (MasteryRingResponse) PARSER.parseFrom(data);
        }

        public static MasteryRingResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MasteryRingResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MasteryRingResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (MasteryRingResponse) PARSER.parseFrom(data);
        }

        public static MasteryRingResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MasteryRingResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MasteryRingResponse parseFrom(InputStream input) throws IOException {
            return (MasteryRingResponse) PARSER.parseFrom(input);
        }

        public static MasteryRingResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MasteryRingResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static MasteryRingResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (MasteryRingResponse) PARSER.parseDelimitedFrom(input);
        }

        public static MasteryRingResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MasteryRingResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static MasteryRingResponse parseFrom(CodedInputStream input) throws IOException {
            return (MasteryRingResponse) PARSER.parseFrom(input);
        }

        public static MasteryRingResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MasteryRingResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(MasteryRingResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements MasteryHandler.MasteryRingResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private List<MasteryHandler.MasteryRing> s2CRing_;
            private RepeatedFieldBuilder<MasteryHandler.MasteryRing, MasteryHandler.MasteryRing.Builder, MasteryHandler.MasteryRingOrBuilder> s2CRingBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MasteryHandler.internal_static_pomelo_area_MasteryRingResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MasteryHandler.internal_static_pomelo_area_MasteryRingResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(MasteryHandler.MasteryRingResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.s2CRing_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CRing_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MasteryHandler.MasteryRingResponse.alwaysUseFieldBuilders)
                    getS2CRingFieldBuilder();
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
                if (this.s2CRingBuilder_ == null) {
                    this.s2CRing_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                } else {
                    this.s2CRingBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return MasteryHandler.internal_static_pomelo_area_MasteryRingResponse_descriptor;
            }

            public MasteryHandler.MasteryRingResponse getDefaultInstanceForType() {
                return MasteryHandler.MasteryRingResponse.getDefaultInstance();
            }

            public MasteryHandler.MasteryRingResponse build() {
                MasteryHandler.MasteryRingResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public MasteryHandler.MasteryRingResponse buildPartial() {
                MasteryHandler.MasteryRingResponse result = new MasteryHandler.MasteryRingResponse(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.s2CMsg_ = this.s2CMsg_;
                if (this.s2CRingBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4) {
                        this.s2CRing_ = Collections.unmodifiableList(this.s2CRing_);
                        this.bitField0_ &= 0xFFFFFFFB;
                    }
                    result.s2CRing_ = this.s2CRing_;
                } else {
                    result.s2CRing_ = this.s2CRingBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof MasteryHandler.MasteryRingResponse)
                    return mergeFrom((MasteryHandler.MasteryRingResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MasteryHandler.MasteryRingResponse other) {
                if (other == MasteryHandler.MasteryRingResponse.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (this.s2CRingBuilder_ == null) {
                    if (!other.s2CRing_.isEmpty()) {
                        if (this.s2CRing_.isEmpty()) {
                            this.s2CRing_ = other.s2CRing_;
                            this.bitField0_ &= 0xFFFFFFFB;
                        } else {
                            ensureS2CRingIsMutable();
                            this.s2CRing_.addAll(other.s2CRing_);
                        }
                        onChanged();
                    }
                } else if (!other.s2CRing_.isEmpty()) {
                    if (this.s2CRingBuilder_.isEmpty()) {
                        this.s2CRingBuilder_.dispose();
                        this.s2CRingBuilder_ = null;
                        this.s2CRing_ = other.s2CRing_;
                        this.bitField0_ &= 0xFFFFFFFB;
                        this.s2CRingBuilder_ = MasteryHandler.MasteryRingResponse.alwaysUseFieldBuilders ? getS2CRingFieldBuilder() : null;
                    } else {
                        this.s2CRingBuilder_.addAllMessages(other.s2CRing_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode())
                    return false;
                for (int i = 0; i < getS2CRingCount(); i++) {
                    if (!getS2CRing(i).isInitialized())
                        return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                MasteryHandler.MasteryRingResponse parsedMessage = null;
                try {
                    parsedMessage = (MasteryHandler.MasteryRingResponse) MasteryHandler.MasteryRingResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MasteryHandler.MasteryRingResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = MasteryHandler.MasteryRingResponse.getDefaultInstance().getS2CMsg();
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

            private void ensureS2CRingIsMutable() {
                if ((this.bitField0_ & 0x4) != 4) {
                    this.s2CRing_ = new ArrayList<>(this.s2CRing_);
                    this.bitField0_ |= 0x4;
                }
            }

            public List<MasteryHandler.MasteryRing> getS2CRingList() {
                if (this.s2CRingBuilder_ == null)
                    return Collections.unmodifiableList(this.s2CRing_);
                return this.s2CRingBuilder_.getMessageList();
            }

            public int getS2CRingCount() {
                if (this.s2CRingBuilder_ == null)
                    return this.s2CRing_.size();
                return this.s2CRingBuilder_.getCount();
            }

            public MasteryHandler.MasteryRing getS2CRing(int index) {
                if (this.s2CRingBuilder_ == null)
                    return this.s2CRing_.get(index);
                return (MasteryHandler.MasteryRing) this.s2CRingBuilder_.getMessage(index);
            }

            public Builder setS2CRing(int index, MasteryHandler.MasteryRing value) {
                if (this.s2CRingBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CRingIsMutable();
                    this.s2CRing_.set(index, value);
                    onChanged();
                } else {
                    this.s2CRingBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setS2CRing(int index, MasteryHandler.MasteryRing.Builder builderForValue) {
                if (this.s2CRingBuilder_ == null) {
                    ensureS2CRingIsMutable();
                    this.s2CRing_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CRingBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addS2CRing(MasteryHandler.MasteryRing value) {
                if (this.s2CRingBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CRingIsMutable();
                    this.s2CRing_.add(value);
                    onChanged();
                } else {
                    this.s2CRingBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addS2CRing(int index, MasteryHandler.MasteryRing value) {
                if (this.s2CRingBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CRingIsMutable();
                    this.s2CRing_.add(index, value);
                    onChanged();
                } else {
                    this.s2CRingBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addS2CRing(MasteryHandler.MasteryRing.Builder builderForValue) {
                if (this.s2CRingBuilder_ == null) {
                    ensureS2CRingIsMutable();
                    this.s2CRing_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.s2CRingBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addS2CRing(int index, MasteryHandler.MasteryRing.Builder builderForValue) {
                if (this.s2CRingBuilder_ == null) {
                    ensureS2CRingIsMutable();
                    this.s2CRing_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CRingBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllS2CRing(Iterable<? extends MasteryHandler.MasteryRing> values) {
                if (this.s2CRingBuilder_ == null) {
                    ensureS2CRingIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.s2CRing_);
                    onChanged();
                } else {
                    this.s2CRingBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearS2CRing() {
                if (this.s2CRingBuilder_ == null) {
                    this.s2CRing_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                    onChanged();
                } else {
                    this.s2CRingBuilder_.clear();
                }
                return this;
            }

            public Builder removeS2CRing(int index) {
                if (this.s2CRingBuilder_ == null) {
                    ensureS2CRingIsMutable();
                    this.s2CRing_.remove(index);
                    onChanged();
                } else {
                    this.s2CRingBuilder_.remove(index);
                }
                return this;
            }

            public MasteryHandler.MasteryRing.Builder getS2CRingBuilder(int index) {
                return (MasteryHandler.MasteryRing.Builder) getS2CRingFieldBuilder().getBuilder(index);
            }

            public MasteryHandler.MasteryRingOrBuilder getS2CRingOrBuilder(int index) {
                if (this.s2CRingBuilder_ == null)
                    return this.s2CRing_.get(index);
                return (MasteryHandler.MasteryRingOrBuilder) this.s2CRingBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends MasteryHandler.MasteryRingOrBuilder> getS2CRingOrBuilderList() {
                if (this.s2CRingBuilder_ != null)
                    return this.s2CRingBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.s2CRing_);
            }

            public MasteryHandler.MasteryRing.Builder addS2CRingBuilder() {
                return (MasteryHandler.MasteryRing.Builder) getS2CRingFieldBuilder().addBuilder(MasteryHandler.MasteryRing.getDefaultInstance());
            }

            public MasteryHandler.MasteryRing.Builder addS2CRingBuilder(int index) {
                return (MasteryHandler.MasteryRing.Builder) getS2CRingFieldBuilder().addBuilder(index, MasteryHandler.MasteryRing.getDefaultInstance());
            }

            public List<MasteryHandler.MasteryRing.Builder> getS2CRingBuilderList() {
                return getS2CRingFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<MasteryHandler.MasteryRing, MasteryHandler.MasteryRing.Builder, MasteryHandler.MasteryRingOrBuilder> getS2CRingFieldBuilder() {
                if (this.s2CRingBuilder_ == null) {
                    this.s2CRingBuilder_ = new RepeatedFieldBuilder(this.s2CRing_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
                    this.s2CRing_ = null;
                }
                return this.s2CRingBuilder_;
            }
        }
    }

    public static final class MasteryDeliverRequest extends GeneratedMessage implements MasteryDeliverRequestOrBuilder {
        private static final MasteryDeliverRequest defaultInstance = new MasteryDeliverRequest(true);
        private final UnknownFieldSet unknownFields;

        private MasteryDeliverRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private MasteryDeliverRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static MasteryDeliverRequest getDefaultInstance() {
            return defaultInstance;
        }

        public MasteryDeliverRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MasteryDeliverRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.c2SPos_ = input.readInt32();
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
            return MasteryHandler.internal_static_pomelo_area_MasteryDeliverRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MasteryHandler.internal_static_pomelo_area_MasteryDeliverRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(MasteryDeliverRequest.class, Builder.class);
        }

        public static Parser<MasteryDeliverRequest> PARSER = (Parser<MasteryDeliverRequest>) new AbstractParser<MasteryDeliverRequest>() {
            public MasteryHandler.MasteryDeliverRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MasteryHandler.MasteryDeliverRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_POS_FIELD_NUMBER = 1;
        private int c2SPos_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<MasteryDeliverRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasC2SPos() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getC2SPos() {
            return this.c2SPos_;
        }

        private void initFields() {
            this.c2SPos_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasC2SPos()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.c2SPos_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.c2SPos_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static MasteryDeliverRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (MasteryDeliverRequest) PARSER.parseFrom(data);
        }

        public static MasteryDeliverRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MasteryDeliverRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MasteryDeliverRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (MasteryDeliverRequest) PARSER.parseFrom(data);
        }

        public static MasteryDeliverRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MasteryDeliverRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MasteryDeliverRequest parseFrom(InputStream input) throws IOException {
            return (MasteryDeliverRequest) PARSER.parseFrom(input);
        }

        public static MasteryDeliverRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MasteryDeliverRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static MasteryDeliverRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (MasteryDeliverRequest) PARSER.parseDelimitedFrom(input);
        }

        public static MasteryDeliverRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MasteryDeliverRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static MasteryDeliverRequest parseFrom(CodedInputStream input) throws IOException {
            return (MasteryDeliverRequest) PARSER.parseFrom(input);
        }

        public static MasteryDeliverRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MasteryDeliverRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(MasteryDeliverRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements MasteryHandler.MasteryDeliverRequestOrBuilder {
            private int bitField0_;
            private int c2SPos_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MasteryHandler.internal_static_pomelo_area_MasteryDeliverRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MasteryHandler.internal_static_pomelo_area_MasteryDeliverRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(MasteryHandler.MasteryDeliverRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MasteryHandler.MasteryDeliverRequest.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.c2SPos_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return MasteryHandler.internal_static_pomelo_area_MasteryDeliverRequest_descriptor;
            }

            public MasteryHandler.MasteryDeliverRequest getDefaultInstanceForType() {
                return MasteryHandler.MasteryDeliverRequest.getDefaultInstance();
            }

            public MasteryHandler.MasteryDeliverRequest build() {
                MasteryHandler.MasteryDeliverRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public MasteryHandler.MasteryDeliverRequest buildPartial() {
                MasteryHandler.MasteryDeliverRequest result = new MasteryHandler.MasteryDeliverRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.c2SPos_ = this.c2SPos_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof MasteryHandler.MasteryDeliverRequest)
                    return mergeFrom((MasteryHandler.MasteryDeliverRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MasteryHandler.MasteryDeliverRequest other) {
                if (other == MasteryHandler.MasteryDeliverRequest.getDefaultInstance()) return this;
                if (other.hasC2SPos()) setC2SPos(other.getC2SPos());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasC2SPos()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                MasteryHandler.MasteryDeliverRequest parsedMessage = null;
                try {
                    parsedMessage = (MasteryHandler.MasteryDeliverRequest) MasteryHandler.MasteryDeliverRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MasteryHandler.MasteryDeliverRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasC2SPos() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getC2SPos() {
                return this.c2SPos_;
            }

            public Builder setC2SPos(int value) {
                this.bitField0_ |= 0x1;
                this.c2SPos_ = value;
                onChanged();
                return this;
            }

            public Builder clearC2SPos() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SPos_ = 0;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }
    }


    public static final class MasteryDeliverResponse
            extends GeneratedMessage
            implements MasteryDeliverResponseOrBuilder {
        private static final MasteryDeliverResponse defaultInstance = new MasteryDeliverResponse(true);
        private final UnknownFieldSet unknownFields;

        private MasteryDeliverResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private MasteryDeliverResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static MasteryDeliverResponse getDefaultInstance() {
            return defaultInstance;
        }

        public MasteryDeliverResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MasteryDeliverResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return MasteryHandler.internal_static_pomelo_area_MasteryDeliverResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MasteryHandler.internal_static_pomelo_area_MasteryDeliverResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(MasteryDeliverResponse.class, Builder.class);
        }

        public static Parser<MasteryDeliverResponse> PARSER = (Parser<MasteryDeliverResponse>) new AbstractParser<MasteryDeliverResponse>() {
            public MasteryHandler.MasteryDeliverResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MasteryHandler.MasteryDeliverResponse(input, extensionRegistry);
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

        public Parser<MasteryDeliverResponse> getParserForType() {
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

        public static MasteryDeliverResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (MasteryDeliverResponse) PARSER.parseFrom(data);
        }

        public static MasteryDeliverResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MasteryDeliverResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MasteryDeliverResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (MasteryDeliverResponse) PARSER.parseFrom(data);
        }

        public static MasteryDeliverResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MasteryDeliverResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MasteryDeliverResponse parseFrom(InputStream input) throws IOException {
            return (MasteryDeliverResponse) PARSER.parseFrom(input);
        }

        public static MasteryDeliverResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MasteryDeliverResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static MasteryDeliverResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (MasteryDeliverResponse) PARSER.parseDelimitedFrom(input);
        }

        public static MasteryDeliverResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MasteryDeliverResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static MasteryDeliverResponse parseFrom(CodedInputStream input) throws IOException {
            return (MasteryDeliverResponse) PARSER.parseFrom(input);
        }

        public static MasteryDeliverResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MasteryDeliverResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(MasteryDeliverResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements MasteryHandler.MasteryDeliverResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MasteryHandler.internal_static_pomelo_area_MasteryDeliverResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MasteryHandler.internal_static_pomelo_area_MasteryDeliverResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(MasteryHandler.MasteryDeliverResponse.class, Builder.class);
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
                if (MasteryHandler.MasteryDeliverResponse.alwaysUseFieldBuilders) ;
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
                return MasteryHandler.internal_static_pomelo_area_MasteryDeliverResponse_descriptor;
            }

            public MasteryHandler.MasteryDeliverResponse getDefaultInstanceForType() {
                return MasteryHandler.MasteryDeliverResponse.getDefaultInstance();
            }

            public MasteryHandler.MasteryDeliverResponse build() {
                MasteryHandler.MasteryDeliverResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public MasteryHandler.MasteryDeliverResponse buildPartial() {
                MasteryHandler.MasteryDeliverResponse result = new MasteryHandler.MasteryDeliverResponse(this);
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
                if (other instanceof MasteryHandler.MasteryDeliverResponse)
                    return mergeFrom((MasteryHandler.MasteryDeliverResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MasteryHandler.MasteryDeliverResponse other) {
                if (other == MasteryHandler.MasteryDeliverResponse.getDefaultInstance()) return this;
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
                MasteryHandler.MasteryDeliverResponse parsedMessage = null;
                try {
                    parsedMessage = (MasteryHandler.MasteryDeliverResponse) MasteryHandler.MasteryDeliverResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (MasteryHandler.MasteryDeliverResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = MasteryHandler.MasteryDeliverResponse.getDefaultInstance().getS2CMsg();
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


    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }


    static {
        String[] descriptorData = {"\n\024masteryHandler.proto\022\013pomelo.area\032\fcommon.proto\032\nitem.proto\"×\001\n\007Mastery\022\013\n\003pos\030\001 \002(\005\022\f\n\004name\030\002 \001(\t\022\f\n\004icon\030\003 \001(\t\022\r\n\005level\030\004 \001(\005\022\020\n\bmaxLevel\030\005 \001(\005\022)\n\nattributes\030\006 \001(\0132\025.pomelo.AttributeBase\022'\n\bmaterial\030\007 \001(\0132\025.pomelo.item.MiniItem\022\020\n\bisActive\030\b \001(\005\022\020\n\bmagicNum\030\t \001(\005\022\n\n\002id\030\n \001(\005\"ñ\001\n\nAllMastery\022&\n\bmasterys\030\001 \003(\0132\024.pomelo.area.Mastery\022#\n\004ring\030\002 \001(\0132\025.pomelo.item.MiniItem\022\024\n\fneedRingName\030\003 \001(\t\022\027\n\017nee", "dPlayerLevel\030\004 \001(\005\022\031\n\021needPlayerUpLevel\030\005 \001(\005\022\024\n\fcostMagicNum\030\006 \001(\005\022\023\n\013curMagicNum\030\007 \001(\005\022\021\n\tringLevel\030\b \001(\005\022\016\n\006canGet\030\t \001(\005\"\027\n\025GetMasteryInfoRequest\"i\n\026GetMasteryInfoResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022,\n\013s2c_mastery\030\003 \001(\0132\027.pomelo.area.AllMastery\"'\n\024ActiveMasteryRequest\022\017\n\007c2s_pos\030\001 \002(\005\"e\n\025ActiveMasteryResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022)\n\bs2c_data\030\003 \001(\0132\027.pomelo.area.AllMastery\"", "$\n\016GetRingRequest\022\022\n\nc2s_ringId\030\001 \002(\t\"_\n\017GetRingResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022)\n\bs2c_data\030\003 \001(\0132\027.pomelo.area.AllMastery\"¡\001\n\013MasteryRing\022#\n\004ring\030\001 \002(\0132\025.pomelo.item.MiniItem\022\027\n\017needPlayerLevel\030\002 \001(\005\022\031\n\021needPlayerUpLevel\030\003 \001(\005\022\024\n\fcostMagicNum\030\004 \001(\005\022\024\n\fneedRingName\030\005 \001(\t\022\r\n\005isGet\030\006 \001(\005\"\024\n\022MasteryRingRequest\"d\n\023MasteryRingResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022*\n\bs2c_ring\030\003 \003(\0132\030.p", "omelo.area.MasteryRing\"(\n\025MasteryDeliverRequest\022\017\n\007c2s_pos\030\001 \002(\005\";\n\026MasteryDeliverResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t2Ù\003\n\016masteryHandler\022`\n\025getMasteryInfoRequest\022\".pomelo.area.GetMasteryInfoRequest\032#.pomelo.area.GetMasteryInfoResponse\022]\n\024activeMasteryRequest\022!.pomelo.area.ActiveMasteryRequest\032\".pomelo.area.ActiveMasteryResponse\022K\n\016getRingRequest\022\033.pomelo.area.GetRingRequest\032\034.pomelo.area.G", "etRingResponse\022W\n\022masteryRingRequest\022\037.pomelo.area.MasteryRingRequest\032 .pomelo.area.MasteryRingResponse\022`\n\025masteryDeliverRequest\022\".pomelo.area.MasteryDeliverRequest\032#.pomelo.area.MasteryDeliverResponse"};


        Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root) {
                MasteryHandler.descriptor = root;
                return null;
            }
        };

        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[]{

                Common.getDescriptor(),
                ItemOuterClass.getDescriptor()}, assigner);
    }

    private static final Descriptors.Descriptor internal_static_pomelo_area_Mastery_descriptor = getDescriptor().getMessageTypes().get(0);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_Mastery_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_Mastery_descriptor, new String[]{"Pos", "Name", "Icon", "Level", "MaxLevel", "Attributes", "Material", "IsActive", "MagicNum", "Id"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_AllMastery_descriptor = getDescriptor().getMessageTypes().get(1);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_AllMastery_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_AllMastery_descriptor, new String[]{"Masterys", "Ring", "NeedRingName", "NeedPlayerLevel", "NeedPlayerUpLevel", "CostMagicNum", "CurMagicNum", "RingLevel", "CanGet"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetMasteryInfoRequest_descriptor = getDescriptor().getMessageTypes().get(2);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetMasteryInfoRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetMasteryInfoRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetMasteryInfoResponse_descriptor = getDescriptor().getMessageTypes().get(3);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetMasteryInfoResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetMasteryInfoResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CMastery"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_ActiveMasteryRequest_descriptor = getDescriptor().getMessageTypes().get(4);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ActiveMasteryRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ActiveMasteryRequest_descriptor, new String[]{"C2SPos"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_ActiveMasteryResponse_descriptor = getDescriptor().getMessageTypes().get(5);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_ActiveMasteryResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_ActiveMasteryResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CData"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetRingRequest_descriptor = getDescriptor().getMessageTypes().get(6);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetRingRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetRingRequest_descriptor, new String[]{"C2SRingId"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetRingResponse_descriptor = getDescriptor().getMessageTypes().get(7);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetRingResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetRingResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CData"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_MasteryRing_descriptor = getDescriptor().getMessageTypes().get(8);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_MasteryRing_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_MasteryRing_descriptor, new String[]{"Ring", "NeedPlayerLevel", "NeedPlayerUpLevel", "CostMagicNum", "NeedRingName", "IsGet"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_MasteryRingRequest_descriptor = getDescriptor().getMessageTypes().get(9);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_MasteryRingRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_MasteryRingRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_area_MasteryRingResponse_descriptor = getDescriptor().getMessageTypes().get(10);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_MasteryRingResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_MasteryRingResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CRing"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_MasteryDeliverRequest_descriptor = getDescriptor().getMessageTypes().get(11);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_MasteryDeliverRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_MasteryDeliverRequest_descriptor, new String[]{"C2SPos"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_MasteryDeliverResponse_descriptor = getDescriptor().getMessageTypes().get(12);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_MasteryDeliverResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_MasteryDeliverResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});
    private static Descriptors.FileDescriptor descriptor;

    static {
        Common.getDescriptor();
        ItemOuterClass.getDescriptor();
    }

    public static interface MasteryDeliverResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface MasteryDeliverRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2SPos();

        int getC2SPos();
    }

    public static interface MasteryRingResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        List<MasteryHandler.MasteryRing> getS2CRingList();

        MasteryHandler.MasteryRing getS2CRing(int param1Int);

        int getS2CRingCount();

        List<? extends MasteryHandler.MasteryRingOrBuilder> getS2CRingOrBuilderList();

        MasteryHandler.MasteryRingOrBuilder getS2CRingOrBuilder(int param1Int);
    }

    public static interface MasteryRingRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface MasteryRingOrBuilder extends MessageOrBuilder {
        boolean hasRing();

        ItemOuterClass.MiniItem getRing();

        ItemOuterClass.MiniItemOrBuilder getRingOrBuilder();

        boolean hasNeedPlayerLevel();

        int getNeedPlayerLevel();

        boolean hasNeedPlayerUpLevel();

        int getNeedPlayerUpLevel();

        boolean hasCostMagicNum();

        int getCostMagicNum();

        boolean hasNeedRingName();

        String getNeedRingName();

        ByteString getNeedRingNameBytes();

        boolean hasIsGet();

        int getIsGet();
    }

    public static interface GetRingResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasS2CData();

        MasteryHandler.AllMastery getS2CData();

        MasteryHandler.AllMasteryOrBuilder getS2CDataOrBuilder();
    }

    public static interface GetRingRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2SRingId();

        String getC2SRingId();

        ByteString getC2SRingIdBytes();
    }

    public static interface ActiveMasteryResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasS2CData();

        MasteryHandler.AllMastery getS2CData();

        MasteryHandler.AllMasteryOrBuilder getS2CDataOrBuilder();
    }

    public static interface ActiveMasteryRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2SPos();

        int getC2SPos();
    }

    public static interface GetMasteryInfoResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasS2CMastery();

        MasteryHandler.AllMastery getS2CMastery();

        MasteryHandler.AllMasteryOrBuilder getS2CMasteryOrBuilder();
    }

    public static interface GetMasteryInfoRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface AllMasteryOrBuilder extends MessageOrBuilder {
        List<MasteryHandler.Mastery> getMasterysList();

        MasteryHandler.Mastery getMasterys(int param1Int);

        int getMasterysCount();

        List<? extends MasteryHandler.MasteryOrBuilder> getMasterysOrBuilderList();

        MasteryHandler.MasteryOrBuilder getMasterysOrBuilder(int param1Int);

        boolean hasRing();

        ItemOuterClass.MiniItem getRing();

        ItemOuterClass.MiniItemOrBuilder getRingOrBuilder();

        boolean hasNeedRingName();

        String getNeedRingName();

        ByteString getNeedRingNameBytes();

        boolean hasNeedPlayerLevel();

        int getNeedPlayerLevel();

        boolean hasNeedPlayerUpLevel();

        int getNeedPlayerUpLevel();

        boolean hasCostMagicNum();

        int getCostMagicNum();

        boolean hasCurMagicNum();

        int getCurMagicNum();

        boolean hasRingLevel();

        int getRingLevel();

        boolean hasCanGet();

        int getCanGet();
    }

    public static interface MasteryOrBuilder extends MessageOrBuilder {
        boolean hasPos();

        int getPos();

        boolean hasName();

        String getName();

        ByteString getNameBytes();

        boolean hasIcon();

        String getIcon();

        ByteString getIconBytes();

        boolean hasLevel();

        int getLevel();

        boolean hasMaxLevel();

        int getMaxLevel();

        boolean hasAttributes();

        Common.AttributeBase getAttributes();

        Common.AttributeBaseOrBuilder getAttributesOrBuilder();

        boolean hasMaterial();

        ItemOuterClass.MiniItem getMaterial();

        ItemOuterClass.MiniItemOrBuilder getMaterialOrBuilder();

        boolean hasIsActive();

        int getIsActive();

        boolean hasMagicNum();

        int getMagicNum();

        boolean hasId();

        int getId();
    }
}


