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


public final class SoloHandler {
    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static final class RankItem
            extends GeneratedMessage
            implements RankItemOrBuilder {
        private final UnknownFieldSet unknownFields;

        private RankItem(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private RankItem(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static RankItem getDefaultInstance() {
            return defaultInstance;
        }

        public RankItem getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private RankItem(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.rank_ = input.readInt32();
                            break;
                        case 18:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x2;
                            this.playerId_ = bs;
                            break;
                        case 26:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x4;
                            this.name_ = bs;
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.pro_ = input.readInt32();
                            break;
                        case 40:
                            this.bitField0_ |= 0x10;
                            this.level_ = input.readInt32();
                            break;
                        case 48:
                            this.bitField0_ |= 0x20;
                            this.score_ = input.readInt32();
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
            return SoloHandler.internal_static_pomelo_area_RankItem_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return SoloHandler.internal_static_pomelo_area_RankItem_fieldAccessorTable.ensureFieldAccessorsInitialized(RankItem.class, Builder.class);
        }

        public static Parser<RankItem> PARSER = (Parser<RankItem>) new AbstractParser<RankItem>() {
            public SoloHandler.RankItem parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SoloHandler.RankItem(input, extensionRegistry);
            }
        };

        private int bitField0_;
        public static final int RANK_FIELD_NUMBER = 1;
        private int rank_;
        public static final int PLAYERID_FIELD_NUMBER = 2;
        private Object playerId_;
        public static final int NAME_FIELD_NUMBER = 3;
        private Object name_;
        public static final int PRO_FIELD_NUMBER = 4;
        private int pro_;
        public static final int LEVEL_FIELD_NUMBER = 5;
        private int level_;
        public static final int SCORE_FIELD_NUMBER = 6;
        private int score_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<RankItem> getParserForType() {
            return PARSER;
        }

        public boolean hasRank() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getRank() {
            return this.rank_;
        }

        public boolean hasPlayerId() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public String getPlayerId() {
            Object ref = this.playerId_;
            if (ref instanceof String)
                return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8())
                this.playerId_ = s;
            return s;
        }

        public ByteString getPlayerIdBytes() {
            Object ref = this.playerId_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.playerId_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasName() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public String getName() {
            Object ref = this.name_;
            if (ref instanceof String)
                return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8())
                this.name_ = s;
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

        public boolean hasPro() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public int getPro() {
            return this.pro_;
        }

        public boolean hasLevel() {
            return ((this.bitField0_ & 0x10) == 16);
        }

        public int getLevel() {
            return this.level_;
        }

        public boolean hasScore() {
            return ((this.bitField0_ & 0x20) == 32);
        }

        public int getScore() {
            return this.score_;
        }

        private void initFields() {
            this.rank_ = 0;
            this.playerId_ = "";
            this.name_ = "";
            this.pro_ = 0;
            this.level_ = 0;
            this.score_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1)
                return true;
            if (isInitialized == 0)
                return false;
            if (!hasRank()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasPlayerId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasName()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasPro()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasLevel()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1)
                output.writeInt32(1, this.rank_);
            if ((this.bitField0_ & 0x2) == 2)
                output.writeBytes(2, getPlayerIdBytes());
            if ((this.bitField0_ & 0x4) == 4)
                output.writeBytes(3, getNameBytes());
            if ((this.bitField0_ & 0x8) == 8)
                output.writeInt32(4, this.pro_);
            if ((this.bitField0_ & 0x10) == 16)
                output.writeInt32(5, this.level_);
            if ((this.bitField0_ & 0x20) == 32)
                output.writeInt32(6, this.score_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1)
                return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1)
                size += CodedOutputStream.computeInt32Size(1, this.rank_);
            if ((this.bitField0_ & 0x2) == 2)
                size += CodedOutputStream.computeBytesSize(2, getPlayerIdBytes());
            if ((this.bitField0_ & 0x4) == 4)
                size += CodedOutputStream.computeBytesSize(3, getNameBytes());
            if ((this.bitField0_ & 0x8) == 8)
                size += CodedOutputStream.computeInt32Size(4, this.pro_);
            if ((this.bitField0_ & 0x10) == 16)
                size += CodedOutputStream.computeInt32Size(5, this.level_);
            if ((this.bitField0_ & 0x20) == 32)
                size += CodedOutputStream.computeInt32Size(6, this.score_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static RankItem parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (RankItem) PARSER.parseFrom(data);
        }

        private static final RankItem defaultInstance = new RankItem(true);

        public static RankItem parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (RankItem) PARSER.parseFrom(data, extensionRegistry);
        }

        public static RankItem parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (RankItem) PARSER.parseFrom(data);
        }

        public static RankItem parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (RankItem) PARSER.parseFrom(data, extensionRegistry);
        }

        public static RankItem parseFrom(InputStream input) throws IOException {
            return (RankItem) PARSER.parseFrom(input);
        }

        public static RankItem parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RankItem) PARSER.parseFrom(input, extensionRegistry);
        }

        public static RankItem parseDelimitedFrom(InputStream input) throws IOException {
            return (RankItem) PARSER.parseDelimitedFrom(input);
        }

        public static RankItem parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RankItem) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static RankItem parseFrom(CodedInputStream input) throws IOException {
            return (RankItem) PARSER.parseFrom(input);
        }

        public static RankItem parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RankItem) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(RankItem prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements SoloHandler.RankItemOrBuilder {
            private int bitField0_;
            private int rank_;
            private Object playerId_;
            private Object name_;
            private int pro_;
            private int level_;
            private int score_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SoloHandler.internal_static_pomelo_area_RankItem_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return SoloHandler.internal_static_pomelo_area_RankItem_fieldAccessorTable.ensureFieldAccessorsInitialized(SoloHandler.RankItem.class, Builder.class);
            }

            private Builder() {
                this.playerId_ = "";
                this.name_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.playerId_ = "";
                this.name_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SoloHandler.RankItem.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.rank_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.playerId_ = "";
                this.bitField0_ &= 0xFFFFFFFD;
                this.name_ = "";
                this.bitField0_ &= 0xFFFFFFFB;
                this.pro_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                this.level_ = 0;
                this.bitField0_ &= 0xFFFFFFEF;
                this.score_ = 0;
                this.bitField0_ &= 0xFFFFFFDF;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return SoloHandler.internal_static_pomelo_area_RankItem_descriptor;
            }

            public SoloHandler.RankItem getDefaultInstanceForType() {
                return SoloHandler.RankItem.getDefaultInstance();
            }

            public SoloHandler.RankItem build() {
                SoloHandler.RankItem result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public SoloHandler.RankItem buildPartial() {
                SoloHandler.RankItem result = new SoloHandler.RankItem(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.rank_ = this.rank_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.playerId_ = this.playerId_;
                if ((from_bitField0_ & 0x4) == 4) to_bitField0_ |= 0x4;
                result.name_ = this.name_;
                if ((from_bitField0_ & 0x8) == 8) to_bitField0_ |= 0x8;
                result.pro_ = this.pro_;
                if ((from_bitField0_ & 0x10) == 16) to_bitField0_ |= 0x10;
                result.level_ = this.level_;
                if ((from_bitField0_ & 0x20) == 32) to_bitField0_ |= 0x20;
                result.score_ = this.score_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof SoloHandler.RankItem) return mergeFrom((SoloHandler.RankItem) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SoloHandler.RankItem other) {
                if (other == SoloHandler.RankItem.getDefaultInstance()) return this;
                if (other.hasRank()) setRank(other.getRank());
                if (other.hasPlayerId()) {
                    this.bitField0_ |= 0x2;
                    this.playerId_ = other.playerId_;
                    onChanged();
                }
                if (other.hasName()) {
                    this.bitField0_ |= 0x4;
                    this.name_ = other.name_;
                    onChanged();
                }
                if (other.hasPro()) setPro(other.getPro());
                if (other.hasLevel()) setLevel(other.getLevel());
                if (other.hasScore()) setScore(other.getScore());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasRank()) return false;
                if (!hasPlayerId()) return false;
                if (!hasName()) return false;
                if (!hasPro()) return false;
                if (!hasLevel()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                SoloHandler.RankItem parsedMessage = null;
                try {
                    parsedMessage = (SoloHandler.RankItem) SoloHandler.RankItem.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SoloHandler.RankItem) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasRank() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getRank() {
                return this.rank_;
            }

            public Builder setRank(int value) {
                this.bitField0_ |= 0x1;
                this.rank_ = value;
                onChanged();
                return this;
            }

            public Builder clearRank() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.rank_ = 0;
                onChanged();
                return this;
            }

            public boolean hasPlayerId() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public String getPlayerId() {
                Object ref = this.playerId_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) this.playerId_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getPlayerIdBytes() {
                Object ref = this.playerId_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.playerId_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setPlayerId(String value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x2;
                this.playerId_ = value;
                onChanged();
                return this;
            }

            public Builder clearPlayerId() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.playerId_ = SoloHandler.RankItem.getDefaultInstance().getPlayerId();
                onChanged();
                return this;
            }

            public Builder setPlayerIdBytes(ByteString value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x2;
                this.playerId_ = value;
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
                this.bitField0_ |= 0x4;
                this.name_ = value;
                onChanged();
                return this;
            }

            public Builder clearName() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.name_ = SoloHandler.RankItem.getDefaultInstance().getName();
                onChanged();
                return this;
            }

            public Builder setNameBytes(ByteString value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x4;
                this.name_ = value;
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

            public boolean hasLevel() {
                return ((this.bitField0_ & 0x10) == 16);
            }

            public int getLevel() {
                return this.level_;
            }

            public Builder setLevel(int value) {
                this.bitField0_ |= 0x10;
                this.level_ = value;
                onChanged();
                return this;
            }

            public Builder clearLevel() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.level_ = 0;
                onChanged();
                return this;
            }

            public boolean hasScore() {
                return ((this.bitField0_ & 0x20) == 32);
            }

            public int getScore() {
                return this.score_;
            }

            public Builder setScore(int value) {
                this.bitField0_ |= 0x20;
                this.score_ = value;
                onChanged();
                return this;
            }

            public Builder clearScore() {
                this.bitField0_ &= 0xFFFFFFDF;
                this.score_ = 0;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class MyInfo
            extends GeneratedMessage
            implements MyInfoOrBuilder {
        private static final MyInfo defaultInstance = new MyInfo(true);
        private final UnknownFieldSet unknownFields;

        private MyInfo(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private MyInfo(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static MyInfo getDefaultInstance() {
            return defaultInstance;
        }

        public MyInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MyInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.rank_ = input.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.score_ = input.readInt32();
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.maxContWinTimes_ = input.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.maxContLoseTimes_ = input.readInt32();
                            break;
                        case 40:
                            this.bitField0_ |= 0x10;
                            this.battleTimes_ = input.readInt32();
                            break;
                        case 48:
                            this.bitField0_ |= 0x20;
                            this.winTotalTimes_ = input.readInt32();
                            break;
                        case 56:
                            this.bitField0_ |= 0x40;
                            this.loseTotalTimes_ = input.readInt32();
                            break;
                        case 66:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x80;
                            this.seasonEndTime_ = bs;
                            break;
                        case 72:
                            this.bitField0_ |= 0x100;
                            this.myToken_ = input.readInt32();
                            break;
                        case 80:
                            this.bitField0_ |= 0x200;
                            this.todayToken_ = input.readInt32();
                            break;
                        case 88:
                            this.bitField0_ |= 0x400;
                            this.maxToken_ = input.readInt32();
                            break;
                        case 96:
                            this.bitField0_ |= 0x800;
                            this.avgMatchTime_ = input.readInt32();
                            break;
                        case 104:
                            this.bitField0_ |= 0x1000;
                            this.startJoinTime_ = input.readInt32();
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
            return SoloHandler.internal_static_pomelo_area_MyInfo_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return SoloHandler.internal_static_pomelo_area_MyInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(MyInfo.class, Builder.class);
        }

        public static Parser<MyInfo> PARSER = (Parser<MyInfo>) new AbstractParser<MyInfo>() {
            public SoloHandler.MyInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SoloHandler.MyInfo(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int RANK_FIELD_NUMBER = 1;
        private int rank_;
        public static final int SCORE_FIELD_NUMBER = 2;
        private int score_;
        public static final int MAXCONTWINTIMES_FIELD_NUMBER = 3;
        private int maxContWinTimes_;
        public static final int MAXCONTLOSETIMES_FIELD_NUMBER = 4;
        private int maxContLoseTimes_;
        public static final int BATTLETIMES_FIELD_NUMBER = 5;
        private int battleTimes_;
        public static final int WINTOTALTIMES_FIELD_NUMBER = 6;
        private int winTotalTimes_;
        public static final int LOSETOTALTIMES_FIELD_NUMBER = 7;
        private int loseTotalTimes_;
        public static final int SEASONENDTIME_FIELD_NUMBER = 8;
        private Object seasonEndTime_;
        public static final int MYTOKEN_FIELD_NUMBER = 9;
        private int myToken_;
        public static final int TODAYTOKEN_FIELD_NUMBER = 10;
        private int todayToken_;
        public static final int MAXTOKEN_FIELD_NUMBER = 11;
        private int maxToken_;
        public static final int AVGMATCHTIME_FIELD_NUMBER = 12;
        private int avgMatchTime_;
        public static final int STARTJOINTIME_FIELD_NUMBER = 13;
        private int startJoinTime_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<MyInfo> getParserForType() {
            return PARSER;
        }

        public boolean hasRank() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getRank() {
            return this.rank_;
        }

        public boolean hasScore() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        static {
            defaultInstance.initFields();
        }

        public int getScore() {
            return this.score_;
        }

        public boolean hasMaxContWinTimes() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getMaxContWinTimes() {
            return this.maxContWinTimes_;
        }

        public boolean hasMaxContLoseTimes() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public int getMaxContLoseTimes() {
            return this.maxContLoseTimes_;
        }

        public boolean hasBattleTimes() {
            return ((this.bitField0_ & 0x10) == 16);
        }

        public int getBattleTimes() {
            return this.battleTimes_;
        }

        public boolean hasWinTotalTimes() {
            return ((this.bitField0_ & 0x20) == 32);
        }

        public int getWinTotalTimes() {
            return this.winTotalTimes_;
        }

        public boolean hasLoseTotalTimes() {
            return ((this.bitField0_ & 0x40) == 64);
        }

        public int getLoseTotalTimes() {
            return this.loseTotalTimes_;
        }

        public boolean hasSeasonEndTime() {
            return ((this.bitField0_ & 0x80) == 128);
        }

        public String getSeasonEndTime() {
            Object ref = this.seasonEndTime_;
            if (ref instanceof String)
                return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8())
                this.seasonEndTime_ = s;
            return s;
        }

        public ByteString getSeasonEndTimeBytes() {
            Object ref = this.seasonEndTime_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.seasonEndTime_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasMyToken() {
            return ((this.bitField0_ & 0x100) == 256);
        }

        public int getMyToken() {
            return this.myToken_;
        }

        public boolean hasTodayToken() {
            return ((this.bitField0_ & 0x200) == 512);
        }

        public int getTodayToken() {
            return this.todayToken_;
        }

        public boolean hasMaxToken() {
            return ((this.bitField0_ & 0x400) == 1024);
        }

        public int getMaxToken() {
            return this.maxToken_;
        }

        public boolean hasAvgMatchTime() {
            return ((this.bitField0_ & 0x800) == 2048);
        }

        public int getAvgMatchTime() {
            return this.avgMatchTime_;
        }

        public boolean hasStartJoinTime() {
            return ((this.bitField0_ & 0x1000) == 4096);
        }

        public int getStartJoinTime() {
            return this.startJoinTime_;
        }

        private void initFields() {
            this.rank_ = 0;
            this.score_ = 0;
            this.maxContWinTimes_ = 0;
            this.maxContLoseTimes_ = 0;
            this.battleTimes_ = 0;
            this.winTotalTimes_ = 0;
            this.loseTotalTimes_ = 0;
            this.seasonEndTime_ = "";
            this.myToken_ = 0;
            this.todayToken_ = 0;
            this.maxToken_ = 0;
            this.avgMatchTime_ = 0;
            this.startJoinTime_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1)
                return true;
            if (isInitialized == 0)
                return false;
            if (!hasRank()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasScore()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasMaxContWinTimes()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasMaxContLoseTimes()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasBattleTimes()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasWinTotalTimes()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasLoseTotalTimes()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasSeasonEndTime()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasMyToken()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasTodayToken()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasMaxToken()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1)
                output.writeInt32(1, this.rank_);
            if ((this.bitField0_ & 0x2) == 2)
                output.writeInt32(2, this.score_);
            if ((this.bitField0_ & 0x4) == 4)
                output.writeInt32(3, this.maxContWinTimes_);
            if ((this.bitField0_ & 0x8) == 8)
                output.writeInt32(4, this.maxContLoseTimes_);
            if ((this.bitField0_ & 0x10) == 16)
                output.writeInt32(5, this.battleTimes_);
            if ((this.bitField0_ & 0x20) == 32)
                output.writeInt32(6, this.winTotalTimes_);
            if ((this.bitField0_ & 0x40) == 64)
                output.writeInt32(7, this.loseTotalTimes_);
            if ((this.bitField0_ & 0x80) == 128)
                output.writeBytes(8, getSeasonEndTimeBytes());
            if ((this.bitField0_ & 0x100) == 256)
                output.writeInt32(9, this.myToken_);
            if ((this.bitField0_ & 0x200) == 512)
                output.writeInt32(10, this.todayToken_);
            if ((this.bitField0_ & 0x400) == 1024)
                output.writeInt32(11, this.maxToken_);
            if ((this.bitField0_ & 0x800) == 2048)
                output.writeInt32(12, this.avgMatchTime_);
            if ((this.bitField0_ & 0x1000) == 4096)
                output.writeInt32(13, this.startJoinTime_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1)
                return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1)
                size += CodedOutputStream.computeInt32Size(1, this.rank_);
            if ((this.bitField0_ & 0x2) == 2)
                size += CodedOutputStream.computeInt32Size(2, this.score_);
            if ((this.bitField0_ & 0x4) == 4)
                size += CodedOutputStream.computeInt32Size(3, this.maxContWinTimes_);
            if ((this.bitField0_ & 0x8) == 8)
                size += CodedOutputStream.computeInt32Size(4, this.maxContLoseTimes_);
            if ((this.bitField0_ & 0x10) == 16)
                size += CodedOutputStream.computeInt32Size(5, this.battleTimes_);
            if ((this.bitField0_ & 0x20) == 32)
                size += CodedOutputStream.computeInt32Size(6, this.winTotalTimes_);
            if ((this.bitField0_ & 0x40) == 64)
                size += CodedOutputStream.computeInt32Size(7, this.loseTotalTimes_);
            if ((this.bitField0_ & 0x80) == 128)
                size += CodedOutputStream.computeBytesSize(8, getSeasonEndTimeBytes());
            if ((this.bitField0_ & 0x100) == 256)
                size += CodedOutputStream.computeInt32Size(9, this.myToken_);
            if ((this.bitField0_ & 0x200) == 512)
                size += CodedOutputStream.computeInt32Size(10, this.todayToken_);
            if ((this.bitField0_ & 0x400) == 1024)
                size += CodedOutputStream.computeInt32Size(11, this.maxToken_);
            if ((this.bitField0_ & 0x800) == 2048)
                size += CodedOutputStream.computeInt32Size(12, this.avgMatchTime_);
            if ((this.bitField0_ & 0x1000) == 4096)
                size += CodedOutputStream.computeInt32Size(13, this.startJoinTime_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static MyInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (MyInfo) PARSER.parseFrom(data);
        }

        public static MyInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MyInfo) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MyInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (MyInfo) PARSER.parseFrom(data);
        }

        public static MyInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MyInfo) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MyInfo parseFrom(InputStream input) throws IOException {
            return (MyInfo) PARSER.parseFrom(input);
        }

        public static MyInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MyInfo) PARSER.parseFrom(input, extensionRegistry);
        }

        public static MyInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (MyInfo) PARSER.parseDelimitedFrom(input);
        }

        public static MyInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MyInfo) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static MyInfo parseFrom(CodedInputStream input) throws IOException {
            return (MyInfo) PARSER.parseFrom(input);
        }

        public static MyInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MyInfo) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(MyInfo prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements SoloHandler.MyInfoOrBuilder {
            private int bitField0_;
            private int rank_;
            private int score_;
            private int maxContWinTimes_;
            private int maxContLoseTimes_;
            private int battleTimes_;
            private int winTotalTimes_;
            private int loseTotalTimes_;
            private Object seasonEndTime_;
            private int myToken_;
            private int todayToken_;
            private int maxToken_;
            private int avgMatchTime_;
            private int startJoinTime_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SoloHandler.internal_static_pomelo_area_MyInfo_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return SoloHandler.internal_static_pomelo_area_MyInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SoloHandler.MyInfo.class, Builder.class);
            }

            private Builder() {
                this.seasonEndTime_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.seasonEndTime_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SoloHandler.MyInfo.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.rank_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.score_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                this.maxContWinTimes_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.maxContLoseTimes_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                this.battleTimes_ = 0;
                this.bitField0_ &= 0xFFFFFFEF;
                this.winTotalTimes_ = 0;
                this.bitField0_ &= 0xFFFFFFDF;
                this.loseTotalTimes_ = 0;
                this.bitField0_ &= 0xFFFFFFBF;
                this.seasonEndTime_ = "";
                this.bitField0_ &= 0xFFFFFF7F;
                this.myToken_ = 0;
                this.bitField0_ &= 0xFFFFFEFF;
                this.todayToken_ = 0;
                this.bitField0_ &= 0xFFFFFDFF;
                this.maxToken_ = 0;
                this.bitField0_ &= 0xFFFFFBFF;
                this.avgMatchTime_ = 0;
                this.bitField0_ &= 0xFFFFF7FF;
                this.startJoinTime_ = 0;
                this.bitField0_ &= 0xFFFFEFFF;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return SoloHandler.internal_static_pomelo_area_MyInfo_descriptor;
            }

            public SoloHandler.MyInfo getDefaultInstanceForType() {
                return SoloHandler.MyInfo.getDefaultInstance();
            }

            public SoloHandler.MyInfo build() {
                SoloHandler.MyInfo result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public SoloHandler.MyInfo buildPartial() {
                SoloHandler.MyInfo result = new SoloHandler.MyInfo(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.rank_ = this.rank_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.score_ = this.score_;
                if ((from_bitField0_ & 0x4) == 4)
                    to_bitField0_ |= 0x4;
                result.maxContWinTimes_ = this.maxContWinTimes_;
                if ((from_bitField0_ & 0x8) == 8)
                    to_bitField0_ |= 0x8;
                result.maxContLoseTimes_ = this.maxContLoseTimes_;
                if ((from_bitField0_ & 0x10) == 16)
                    to_bitField0_ |= 0x10;
                result.battleTimes_ = this.battleTimes_;
                if ((from_bitField0_ & 0x20) == 32)
                    to_bitField0_ |= 0x20;
                result.winTotalTimes_ = this.winTotalTimes_;
                if ((from_bitField0_ & 0x40) == 64)
                    to_bitField0_ |= 0x40;
                result.loseTotalTimes_ = this.loseTotalTimes_;
                if ((from_bitField0_ & 0x80) == 128)
                    to_bitField0_ |= 0x80;
                result.seasonEndTime_ = this.seasonEndTime_;
                if ((from_bitField0_ & 0x100) == 256)
                    to_bitField0_ |= 0x100;
                result.myToken_ = this.myToken_;
                if ((from_bitField0_ & 0x200) == 512)
                    to_bitField0_ |= 0x200;
                result.todayToken_ = this.todayToken_;
                if ((from_bitField0_ & 0x400) == 1024)
                    to_bitField0_ |= 0x400;
                result.maxToken_ = this.maxToken_;
                if ((from_bitField0_ & 0x800) == 2048)
                    to_bitField0_ |= 0x800;
                result.avgMatchTime_ = this.avgMatchTime_;
                if ((from_bitField0_ & 0x1000) == 4096)
                    to_bitField0_ |= 0x1000;
                result.startJoinTime_ = this.startJoinTime_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof SoloHandler.MyInfo)
                    return mergeFrom((SoloHandler.MyInfo) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SoloHandler.MyInfo other) {
                if (other == SoloHandler.MyInfo.getDefaultInstance())
                    return this;
                if (other.hasRank())
                    setRank(other.getRank());
                if (other.hasScore())
                    setScore(other.getScore());
                if (other.hasMaxContWinTimes())
                    setMaxContWinTimes(other.getMaxContWinTimes());
                if (other.hasMaxContLoseTimes())
                    setMaxContLoseTimes(other.getMaxContLoseTimes());
                if (other.hasBattleTimes())
                    setBattleTimes(other.getBattleTimes());
                if (other.hasWinTotalTimes())
                    setWinTotalTimes(other.getWinTotalTimes());
                if (other.hasLoseTotalTimes())
                    setLoseTotalTimes(other.getLoseTotalTimes());
                if (other.hasSeasonEndTime()) {
                    this.bitField0_ |= 0x80;
                    this.seasonEndTime_ = other.seasonEndTime_;
                    onChanged();
                }
                if (other.hasMyToken())
                    setMyToken(other.getMyToken());
                if (other.hasTodayToken())
                    setTodayToken(other.getTodayToken());
                if (other.hasMaxToken())
                    setMaxToken(other.getMaxToken());
                if (other.hasAvgMatchTime())
                    setAvgMatchTime(other.getAvgMatchTime());
                if (other.hasStartJoinTime())
                    setStartJoinTime(other.getStartJoinTime());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasRank())
                    return false;
                if (!hasScore())
                    return false;
                if (!hasMaxContWinTimes())
                    return false;
                if (!hasMaxContLoseTimes())
                    return false;
                if (!hasBattleTimes())
                    return false;
                if (!hasWinTotalTimes())
                    return false;
                if (!hasLoseTotalTimes())
                    return false;
                if (!hasSeasonEndTime())
                    return false;
                if (!hasMyToken())
                    return false;
                if (!hasTodayToken())
                    return false;
                if (!hasMaxToken())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                SoloHandler.MyInfo parsedMessage = null;
                try {
                    parsedMessage = (SoloHandler.MyInfo) SoloHandler.MyInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SoloHandler.MyInfo) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null)
                        mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasRank() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getRank() {
                return this.rank_;
            }

            public Builder setRank(int value) {
                this.bitField0_ |= 0x1;
                this.rank_ = value;
                onChanged();
                return this;
            }

            public Builder clearRank() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.rank_ = 0;
                onChanged();
                return this;
            }

            public boolean hasScore() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getScore() {
                return this.score_;
            }

            public Builder setScore(int value) {
                this.bitField0_ |= 0x2;
                this.score_ = value;
                onChanged();
                return this;
            }

            public Builder clearScore() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.score_ = 0;
                onChanged();
                return this;
            }

            public boolean hasMaxContWinTimes() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public int getMaxContWinTimes() {
                return this.maxContWinTimes_;
            }

            public Builder setMaxContWinTimes(int value) {
                this.bitField0_ |= 0x4;
                this.maxContWinTimes_ = value;
                onChanged();
                return this;
            }

            public Builder clearMaxContWinTimes() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.maxContWinTimes_ = 0;
                onChanged();
                return this;
            }

            public boolean hasMaxContLoseTimes() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public int getMaxContLoseTimes() {
                return this.maxContLoseTimes_;
            }

            public Builder setMaxContLoseTimes(int value) {
                this.bitField0_ |= 0x8;
                this.maxContLoseTimes_ = value;
                onChanged();
                return this;
            }

            public Builder clearMaxContLoseTimes() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.maxContLoseTimes_ = 0;
                onChanged();
                return this;
            }

            public boolean hasBattleTimes() {
                return ((this.bitField0_ & 0x10) == 16);
            }

            public int getBattleTimes() {
                return this.battleTimes_;
            }

            public Builder setBattleTimes(int value) {
                this.bitField0_ |= 0x10;
                this.battleTimes_ = value;
                onChanged();
                return this;
            }

            public Builder clearBattleTimes() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.battleTimes_ = 0;
                onChanged();
                return this;
            }

            public boolean hasWinTotalTimes() {
                return ((this.bitField0_ & 0x20) == 32);
            }

            public int getWinTotalTimes() {
                return this.winTotalTimes_;
            }

            public Builder setWinTotalTimes(int value) {
                this.bitField0_ |= 0x20;
                this.winTotalTimes_ = value;
                onChanged();
                return this;
            }

            public Builder clearWinTotalTimes() {
                this.bitField0_ &= 0xFFFFFFDF;
                this.winTotalTimes_ = 0;
                onChanged();
                return this;
            }

            public boolean hasLoseTotalTimes() {
                return ((this.bitField0_ & 0x40) == 64);
            }

            public int getLoseTotalTimes() {
                return this.loseTotalTimes_;
            }

            public Builder setLoseTotalTimes(int value) {
                this.bitField0_ |= 0x40;
                this.loseTotalTimes_ = value;
                onChanged();
                return this;
            }

            public Builder clearLoseTotalTimes() {
                this.bitField0_ &= 0xFFFFFFBF;
                this.loseTotalTimes_ = 0;
                onChanged();
                return this;
            }

            public boolean hasSeasonEndTime() {
                return ((this.bitField0_ & 0x80) == 128);
            }

            public String getSeasonEndTime() {
                Object ref = this.seasonEndTime_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.seasonEndTime_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getSeasonEndTimeBytes() {
                Object ref = this.seasonEndTime_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.seasonEndTime_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setSeasonEndTime(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x80;
                this.seasonEndTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearSeasonEndTime() {
                this.bitField0_ &= 0xFFFFFF7F;
                this.seasonEndTime_ = SoloHandler.MyInfo.getDefaultInstance().getSeasonEndTime();
                onChanged();
                return this;
            }

            public Builder setSeasonEndTimeBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x80;
                this.seasonEndTime_ = value;
                onChanged();
                return this;
            }

            public boolean hasMyToken() {
                return ((this.bitField0_ & 0x100) == 256);
            }

            public int getMyToken() {
                return this.myToken_;
            }

            public Builder setMyToken(int value) {
                this.bitField0_ |= 0x100;
                this.myToken_ = value;
                onChanged();
                return this;
            }

            public Builder clearMyToken() {
                this.bitField0_ &= 0xFFFFFEFF;
                this.myToken_ = 0;
                onChanged();
                return this;
            }

            public boolean hasTodayToken() {
                return ((this.bitField0_ & 0x200) == 512);
            }

            public int getTodayToken() {
                return this.todayToken_;
            }

            public Builder setTodayToken(int value) {
                this.bitField0_ |= 0x200;
                this.todayToken_ = value;
                onChanged();
                return this;
            }

            public Builder clearTodayToken() {
                this.bitField0_ &= 0xFFFFFDFF;
                this.todayToken_ = 0;
                onChanged();
                return this;
            }

            public boolean hasMaxToken() {
                return ((this.bitField0_ & 0x400) == 1024);
            }

            public int getMaxToken() {
                return this.maxToken_;
            }

            public Builder setMaxToken(int value) {
                this.bitField0_ |= 0x400;
                this.maxToken_ = value;
                onChanged();
                return this;
            }

            public Builder clearMaxToken() {
                this.bitField0_ &= 0xFFFFFBFF;
                this.maxToken_ = 0;
                onChanged();
                return this;
            }

            public boolean hasAvgMatchTime() {
                return ((this.bitField0_ & 0x800) == 2048);
            }

            public int getAvgMatchTime() {
                return this.avgMatchTime_;
            }

            public Builder setAvgMatchTime(int value) {
                this.bitField0_ |= 0x800;
                this.avgMatchTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearAvgMatchTime() {
                this.bitField0_ &= 0xFFFFF7FF;
                this.avgMatchTime_ = 0;
                onChanged();
                return this;
            }

            public boolean hasStartJoinTime() {
                return ((this.bitField0_ & 0x1000) == 4096);
            }

            public int getStartJoinTime() {
                return this.startJoinTime_;
            }

            public Builder setStartJoinTime(int value) {
                this.bitField0_ |= 0x1000;
                this.startJoinTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearStartJoinTime() {
                this.bitField0_ &= 0xFFFFEFFF;
                this.startJoinTime_ = 0;
                onChanged();
                return this;
            }
        }
    }

    public static final class RankReward extends GeneratedMessage implements RankRewardOrBuilder {
        private static final RankReward defaultInstance = new RankReward(true);
        private final UnknownFieldSet unknownFields;

        private RankReward(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private RankReward(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static RankReward getDefaultInstance() {
            return defaultInstance;
        }

        public RankReward getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private RankReward(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.rankId_ = input.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.status_ = input.readInt32();
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
            return SoloHandler.internal_static_pomelo_area_RankReward_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return SoloHandler.internal_static_pomelo_area_RankReward_fieldAccessorTable.ensureFieldAccessorsInitialized(RankReward.class, Builder.class);
        }

        public static Parser<RankReward> PARSER = (Parser<RankReward>) new AbstractParser<RankReward>() {
            public SoloHandler.RankReward parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SoloHandler.RankReward(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int RANKID_FIELD_NUMBER = 1;
        private int rankId_;
        public static final int STATUS_FIELD_NUMBER = 2;
        private int status_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<RankReward> getParserForType() {
            return PARSER;
        }

        public boolean hasRankId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getRankId() {
            return this.rankId_;
        }

        public boolean hasStatus() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public int getStatus() {
            return this.status_;
        }

        private void initFields() {
            this.rankId_ = 0;
            this.status_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasRankId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasStatus()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.rankId_);
            if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.status_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.rankId_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(2, this.status_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static RankReward parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (RankReward) PARSER.parseFrom(data);
        }

        public static RankReward parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (RankReward) PARSER.parseFrom(data, extensionRegistry);
        }

        public static RankReward parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (RankReward) PARSER.parseFrom(data);
        }

        public static RankReward parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (RankReward) PARSER.parseFrom(data, extensionRegistry);
        }

        public static RankReward parseFrom(InputStream input) throws IOException {
            return (RankReward) PARSER.parseFrom(input);
        }

        public static RankReward parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RankReward) PARSER.parseFrom(input, extensionRegistry);
        }

        public static RankReward parseDelimitedFrom(InputStream input) throws IOException {
            return (RankReward) PARSER.parseDelimitedFrom(input);
        }

        public static RankReward parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RankReward) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static RankReward parseFrom(CodedInputStream input) throws IOException {
            return (RankReward) PARSER.parseFrom(input);
        }

        public static RankReward parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RankReward) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(RankReward prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements SoloHandler.RankRewardOrBuilder {
            private int bitField0_;
            private int rankId_;
            private int status_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SoloHandler.internal_static_pomelo_area_RankReward_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return SoloHandler.internal_static_pomelo_area_RankReward_fieldAccessorTable.ensureFieldAccessorsInitialized(SoloHandler.RankReward.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SoloHandler.RankReward.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.rankId_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.status_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return SoloHandler.internal_static_pomelo_area_RankReward_descriptor;
            }

            public SoloHandler.RankReward getDefaultInstanceForType() {
                return SoloHandler.RankReward.getDefaultInstance();
            }

            public SoloHandler.RankReward build() {
                SoloHandler.RankReward result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public SoloHandler.RankReward buildPartial() {
                SoloHandler.RankReward result = new SoloHandler.RankReward(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.rankId_ = this.rankId_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.status_ = this.status_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof SoloHandler.RankReward) return mergeFrom((SoloHandler.RankReward) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SoloHandler.RankReward other) {
                if (other == SoloHandler.RankReward.getDefaultInstance()) return this;
                if (other.hasRankId()) setRankId(other.getRankId());
                if (other.hasStatus()) setStatus(other.getStatus());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasRankId()) return false;
                if (!hasStatus()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                SoloHandler.RankReward parsedMessage = null;
                try {
                    parsedMessage = (SoloHandler.RankReward) SoloHandler.RankReward.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SoloHandler.RankReward) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasRankId() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getRankId() {
                return this.rankId_;
            }

            public Builder setRankId(int value) {
                this.bitField0_ |= 0x1;
                this.rankId_ = value;
                onChanged();
                return this;
            }

            public Builder clearRankId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.rankId_ = 0;
                onChanged();
                return this;
            }

            public boolean hasStatus() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getStatus() {
                return this.status_;
            }

            public Builder setStatus(int value) {
                this.bitField0_ |= 0x2;
                this.status_ = value;
                onChanged();
                return this;
            }

            public Builder clearStatus() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.status_ = 0;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }
    }


    public static final class SoloInfoRequest
            extends GeneratedMessage
            implements SoloInfoRequestOrBuilder {
        private static final SoloInfoRequest defaultInstance = new SoloInfoRequest(true);
        private final UnknownFieldSet unknownFields;

        private SoloInfoRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private SoloInfoRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static SoloInfoRequest getDefaultInstance() {
            return defaultInstance;
        }

        public SoloInfoRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SoloInfoRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return SoloHandler.internal_static_pomelo_area_SoloInfoRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return SoloHandler.internal_static_pomelo_area_SoloInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(SoloInfoRequest.class, Builder.class);
        }

        public static Parser<SoloInfoRequest> PARSER = (Parser<SoloInfoRequest>) new AbstractParser<SoloInfoRequest>() {
            public SoloHandler.SoloInfoRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SoloHandler.SoloInfoRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<SoloInfoRequest> getParserForType() {
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

        public static SoloInfoRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (SoloInfoRequest) PARSER.parseFrom(data);
        }

        public static SoloInfoRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SoloInfoRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static SoloInfoRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (SoloInfoRequest) PARSER.parseFrom(data);
        }

        public static SoloInfoRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SoloInfoRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static SoloInfoRequest parseFrom(InputStream input) throws IOException {
            return (SoloInfoRequest) PARSER.parseFrom(input);
        }

        public static SoloInfoRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SoloInfoRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static SoloInfoRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (SoloInfoRequest) PARSER.parseDelimitedFrom(input);
        }

        public static SoloInfoRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SoloInfoRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static SoloInfoRequest parseFrom(CodedInputStream input) throws IOException {
            return (SoloInfoRequest) PARSER.parseFrom(input);
        }

        public static SoloInfoRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SoloInfoRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(SoloInfoRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements SoloHandler.SoloInfoRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return SoloHandler.internal_static_pomelo_area_SoloInfoRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return SoloHandler.internal_static_pomelo_area_SoloInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(SoloHandler.SoloInfoRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SoloHandler.SoloInfoRequest.alwaysUseFieldBuilders) ;
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
                return SoloHandler.internal_static_pomelo_area_SoloInfoRequest_descriptor;
            }

            public SoloHandler.SoloInfoRequest getDefaultInstanceForType() {
                return SoloHandler.SoloInfoRequest.getDefaultInstance();
            }

            public SoloHandler.SoloInfoRequest build() {
                SoloHandler.SoloInfoRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public SoloHandler.SoloInfoRequest buildPartial() {
                SoloHandler.SoloInfoRequest result = new SoloHandler.SoloInfoRequest(this);
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof SoloHandler.SoloInfoRequest) return mergeFrom((SoloHandler.SoloInfoRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SoloHandler.SoloInfoRequest other) {
                if (other == SoloHandler.SoloInfoRequest.getDefaultInstance()) return this;
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                SoloHandler.SoloInfoRequest parsedMessage = null;
                try {
                    parsedMessage = (SoloHandler.SoloInfoRequest) SoloHandler.SoloInfoRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SoloHandler.SoloInfoRequest) e.getUnfinishedMessage();
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


    public static final class SoloInfoResponse
            extends GeneratedMessage
            implements SoloInfoResponseOrBuilder {
        private static final SoloInfoResponse defaultInstance = new SoloInfoResponse(true);
        private final UnknownFieldSet unknownFields;

        private SoloInfoResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private SoloInfoResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static SoloInfoResponse getDefaultInstance() {
            return defaultInstance;
        }

        public SoloInfoResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SoloInfoResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    ByteString bs;
                    SoloHandler.MyInfo.Builder subBuilder;
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
                            if ((this.bitField0_ & 0x4) == 4) subBuilder = this.s2CMyInfo_.toBuilder();
                            this.s2CMyInfo_ = (SoloHandler.MyInfo) input.readMessage(SoloHandler.MyInfo.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.s2CMyInfo_);
                                this.s2CMyInfo_ = subBuilder.buildPartial();
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
            return SoloHandler.internal_static_pomelo_area_SoloInfoResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return SoloHandler.internal_static_pomelo_area_SoloInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(SoloInfoResponse.class, Builder.class);
        }

        public static Parser<SoloInfoResponse> PARSER = (Parser<SoloInfoResponse>) new AbstractParser<SoloInfoResponse>() {
            public SoloHandler.SoloInfoResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SoloHandler.SoloInfoResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_MYINFO_FIELD_NUMBER = 3;
        private SoloHandler.MyInfo s2CMyInfo_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<SoloInfoResponse> getParserForType() {
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


        public boolean hasS2CMyInfo() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public SoloHandler.MyInfo getS2CMyInfo() {
            return this.s2CMyInfo_;
        }


        public SoloHandler.MyInfoOrBuilder getS2CMyInfoOrBuilder() {
            return this.s2CMyInfo_;
        }


        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CMyInfo_ = SoloHandler.MyInfo.getDefaultInstance();
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
            if (hasS2CMyInfo() && !getS2CMyInfo().isInitialized()) {
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
                output.writeMessage(3, (MessageLite) this.s2CMyInfo_);
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
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.s2CMyInfo_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static SoloInfoResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (SoloInfoResponse) PARSER.parseFrom(data);
        }


        public static SoloInfoResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SoloInfoResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static SoloInfoResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (SoloInfoResponse) PARSER.parseFrom(data);
        }


        public static SoloInfoResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SoloInfoResponse) PARSER.parseFrom(data, extensionRegistry);
        }


        public static SoloInfoResponse parseFrom(InputStream input) throws IOException {
            return (SoloInfoResponse) PARSER.parseFrom(input);
        }


        public static SoloInfoResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SoloInfoResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static SoloInfoResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (SoloInfoResponse) PARSER.parseDelimitedFrom(input);
        }


        public static SoloInfoResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SoloInfoResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static SoloInfoResponse parseFrom(CodedInputStream input) throws IOException {
            return (SoloInfoResponse) PARSER.parseFrom(input);
        }


        public static SoloInfoResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SoloInfoResponse) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(SoloInfoResponse prototype) {
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
                implements SoloHandler.SoloInfoResponseOrBuilder {
            private int bitField0_;


            private int s2CCode_;


            private Object s2CMsg_;


            private SoloHandler.MyInfo s2CMyInfo_;


            private SingleFieldBuilder<SoloHandler.MyInfo, SoloHandler.MyInfo.Builder, SoloHandler.MyInfoOrBuilder> s2CMyInfoBuilder_;


            public static final Descriptors.Descriptor getDescriptor() {
                return SoloHandler.internal_static_pomelo_area_SoloInfoResponse_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return SoloHandler.internal_static_pomelo_area_SoloInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(SoloHandler.SoloInfoResponse.class, Builder.class);
            }


            private Builder() {
                this.s2CMsg_ = "";
                this.s2CMyInfo_ = SoloHandler.MyInfo.getDefaultInstance();
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CMyInfo_ = SoloHandler.MyInfo.getDefaultInstance();
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (SoloHandler.SoloInfoResponse.alwaysUseFieldBuilders) {
                    getS2CMyInfoFieldBuilder();
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
                if (this.s2CMyInfoBuilder_ == null) {
                    this.s2CMyInfo_ = SoloHandler.MyInfo.getDefaultInstance();
                } else {
                    this.s2CMyInfoBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return SoloHandler.internal_static_pomelo_area_SoloInfoResponse_descriptor;
            }


            public SoloHandler.SoloInfoResponse getDefaultInstanceForType() {
                return SoloHandler.SoloInfoResponse.getDefaultInstance();
            }


            public SoloHandler.SoloInfoResponse build() {
                SoloHandler.SoloInfoResponse result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public SoloHandler.SoloInfoResponse buildPartial() {
                SoloHandler.SoloInfoResponse result = new SoloHandler.SoloInfoResponse(this);
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
                if (this.s2CMyInfoBuilder_ == null) {
                    result.s2CMyInfo_ = this.s2CMyInfo_;
                } else {
                    result.s2CMyInfo_ = (SoloHandler.MyInfo) this.s2CMyInfoBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof SoloHandler.SoloInfoResponse) {
                    return mergeFrom((SoloHandler.SoloInfoResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(SoloHandler.SoloInfoResponse other) {
                if (other == SoloHandler.SoloInfoResponse.getDefaultInstance()) {
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
                if (other.hasS2CMyInfo()) {
                    mergeS2CMyInfo(other.getS2CMyInfo());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasS2CCode()) {
                    return false;
                }
                if (hasS2CMyInfo() && !getS2CMyInfo().isInitialized()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                SoloHandler.SoloInfoResponse parsedMessage = null;
                try {
                    parsedMessage = (SoloHandler.SoloInfoResponse) SoloHandler.SoloInfoResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SoloHandler.SoloInfoResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = SoloHandler.SoloInfoResponse.getDefaultInstance().getS2CMsg();
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


            public boolean hasS2CMyInfo() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public SoloHandler.MyInfo getS2CMyInfo() {
                if (this.s2CMyInfoBuilder_ == null) {
                    return this.s2CMyInfo_;
                }
                return (SoloHandler.MyInfo) this.s2CMyInfoBuilder_.getMessage();
            }


            public Builder setS2CMyInfo(SoloHandler.MyInfo value) {
                if (this.s2CMyInfoBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.s2CMyInfo_ = value;
                    onChanged();
                } else {
                    this.s2CMyInfoBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }


            public Builder setS2CMyInfo(SoloHandler.MyInfo.Builder builderForValue) {
                if (this.s2CMyInfoBuilder_ == null) {
                    this.s2CMyInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.s2CMyInfoBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x4;
                return this;
            }


            public Builder mergeS2CMyInfo(SoloHandler.MyInfo value) {
                if (this.s2CMyInfoBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4 && this.s2CMyInfo_ != SoloHandler.MyInfo.getDefaultInstance()) {
                        this.s2CMyInfo_ = SoloHandler.MyInfo.newBuilder(this.s2CMyInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.s2CMyInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.s2CMyInfoBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x4;
                return this;
            }


            public Builder clearS2CMyInfo() {
                if (this.s2CMyInfoBuilder_ == null) {
                    this.s2CMyInfo_ = SoloHandler.MyInfo.getDefaultInstance();
                    onChanged();
                } else {
                    this.s2CMyInfoBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }


            public SoloHandler.MyInfo.Builder getS2CMyInfoBuilder() {
                this.bitField0_ |= 0x4;
                onChanged();
                return (SoloHandler.MyInfo.Builder) getS2CMyInfoFieldBuilder().getBuilder();
            }


            public SoloHandler.MyInfoOrBuilder getS2CMyInfoOrBuilder() {
                if (this.s2CMyInfoBuilder_ != null) {
                    return (SoloHandler.MyInfoOrBuilder) this.s2CMyInfoBuilder_.getMessageOrBuilder();
                }
                return this.s2CMyInfo_;
            }


            private SingleFieldBuilder<SoloHandler.MyInfo, SoloHandler.MyInfo.Builder, SoloHandler.MyInfoOrBuilder> getS2CMyInfoFieldBuilder() {
                if (this.s2CMyInfoBuilder_ == null) {
                    this.s2CMyInfoBuilder_ = new SingleFieldBuilder(getS2CMyInfo(), getParentForChildren(), isClean());
                    this.s2CMyInfo_ = null;
                }
                return this.s2CMyInfoBuilder_;
            }
        }
    }


    public static final class NewsInfo
            extends GeneratedMessage
            implements NewsInfoOrBuilder {
        private static final NewsInfo defaultInstance = new NewsInfo(true);
        private final UnknownFieldSet unknownFields;

        private NewsInfo(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private NewsInfo(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static NewsInfo getDefaultInstance() {
            return defaultInstance;
        }

        public NewsInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private NewsInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.date_ = bs;
                            break;
                        case 18:
                            bs = input.readBytes();
                            if ((mutable_bitField0_ & 0x2) != 2) {
                                this.message_ = (LazyStringList) new LazyStringArrayList();
                                mutable_bitField0_ |= 0x2;
                            }
                            this.message_.add(bs);
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x2) == 2) this.message_ = this.message_.getUnmodifiableView();
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SoloHandler.internal_static_pomelo_area_NewsInfo_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return SoloHandler.internal_static_pomelo_area_NewsInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(NewsInfo.class, Builder.class);
        }

        public static Parser<NewsInfo> PARSER = (Parser<NewsInfo>) new AbstractParser<NewsInfo>() {
            public SoloHandler.NewsInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SoloHandler.NewsInfo(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int DATE_FIELD_NUMBER = 1;
        private Object date_;
        public static final int MESSAGE_FIELD_NUMBER = 2;
        private LazyStringList message_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<NewsInfo> getParserForType() {
            return PARSER;
        }

        public boolean hasDate() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public String getDate() {
            Object ref = this.date_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.date_ = s;
            return s;
        }

        public ByteString getDateBytes() {
            Object ref = this.date_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.date_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public ProtocolStringList getMessageList() {
            return (ProtocolStringList) this.message_;
        }

        static {
            defaultInstance.initFields();
        }

        public int getMessageCount() {
            return this.message_.size();
        }

        public String getMessage(int index) {
            return (String) this.message_.get(index);
        }

        public ByteString getMessageBytes(int index) {
            return this.message_.getByteString(index);
        }

        private void initFields() {
            this.date_ = "";
            this.message_ = LazyStringArrayList.EMPTY;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1)
                return true;
            if (isInitialized == 0)
                return false;
            if (!hasDate()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1)
                output.writeBytes(1, getDateBytes());
            for (int i = 0; i < this.message_.size(); i++)
                output.writeBytes(2, this.message_.getByteString(i));
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1)
                return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1)
                size += CodedOutputStream.computeBytesSize(1, getDateBytes());
            int dataSize = 0;
            for (int i = 0; i < this.message_.size(); i++)
                dataSize += CodedOutputStream.computeBytesSizeNoTag(this.message_.getByteString(i));
            size += dataSize;
            size += 1 * getMessageList().size();
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static NewsInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (NewsInfo) PARSER.parseFrom(data);
        }

        public static NewsInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (NewsInfo) PARSER.parseFrom(data, extensionRegistry);
        }

        public static NewsInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (NewsInfo) PARSER.parseFrom(data);
        }

        public static NewsInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (NewsInfo) PARSER.parseFrom(data, extensionRegistry);
        }

        public static NewsInfo parseFrom(InputStream input) throws IOException {
            return (NewsInfo) PARSER.parseFrom(input);
        }

        public static NewsInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (NewsInfo) PARSER.parseFrom(input, extensionRegistry);
        }

        public static NewsInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (NewsInfo) PARSER.parseDelimitedFrom(input);
        }

        public static NewsInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (NewsInfo) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static NewsInfo parseFrom(CodedInputStream input) throws IOException {
            return (NewsInfo) PARSER.parseFrom(input);
        }

        public static NewsInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (NewsInfo) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(NewsInfo prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements SoloHandler.NewsInfoOrBuilder {
            private int bitField0_;
            private Object date_;
            private LazyStringList message_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SoloHandler.internal_static_pomelo_area_NewsInfo_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return SoloHandler.internal_static_pomelo_area_NewsInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SoloHandler.NewsInfo.class, Builder.class);
            }

            private Builder() {
                this.date_ = "";
                this.message_ = LazyStringArrayList.EMPTY;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.date_ = "";
                this.message_ = LazyStringArrayList.EMPTY;
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SoloHandler.NewsInfo.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.date_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                this.message_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return SoloHandler.internal_static_pomelo_area_NewsInfo_descriptor;
            }

            public SoloHandler.NewsInfo getDefaultInstanceForType() {
                return SoloHandler.NewsInfo.getDefaultInstance();
            }

            public SoloHandler.NewsInfo build() {
                SoloHandler.NewsInfo result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public SoloHandler.NewsInfo buildPartial() {
                SoloHandler.NewsInfo result = new SoloHandler.NewsInfo(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.date_ = this.date_;
                if ((this.bitField0_ & 0x2) == 2) {
                    this.message_ = this.message_.getUnmodifiableView();
                    this.bitField0_ &= 0xFFFFFFFD;
                }
                result.message_ = this.message_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof SoloHandler.NewsInfo)
                    return mergeFrom((SoloHandler.NewsInfo) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SoloHandler.NewsInfo other) {
                if (other == SoloHandler.NewsInfo.getDefaultInstance())
                    return this;
                if (other.hasDate()) {
                    this.bitField0_ |= 0x1;
                    this.date_ = other.date_;
                    onChanged();
                }
                if (!other.message_.isEmpty()) {
                    if (this.message_.isEmpty()) {
                        this.message_ = other.message_;
                        this.bitField0_ &= 0xFFFFFFFD;
                    } else {
                        ensureMessageIsMutable();
                        this.message_.addAll((Collection) other.message_);
                    }
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasDate())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                SoloHandler.NewsInfo parsedMessage = null;
                try {
                    parsedMessage = (SoloHandler.NewsInfo) SoloHandler.NewsInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SoloHandler.NewsInfo) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null)
                        mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasDate() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public String getDate() {
                Object ref = this.date_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.date_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getDateBytes() {
                Object ref = this.date_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.date_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setDate(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.date_ = value;
                onChanged();
                return this;
            }

            public Builder clearDate() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.date_ = SoloHandler.NewsInfo.getDefaultInstance().getDate();
                onChanged();
                return this;
            }

            public Builder setDateBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.date_ = value;
                onChanged();
                return this;
            }

            private void ensureMessageIsMutable() {
                if ((this.bitField0_ & 0x2) != 2) {
                    this.message_ = (LazyStringList) new LazyStringArrayList(this.message_);
                    this.bitField0_ |= 0x2;
                }
            }

            public ProtocolStringList getMessageList() {
                return (ProtocolStringList) this.message_.getUnmodifiableView();
            }

            public int getMessageCount() {
                return this.message_.size();
            }

            public String getMessage(int index) {
                return (String) this.message_.get(index);
            }

            public ByteString getMessageBytes(int index) {
                return this.message_.getByteString(index);
            }

            public Builder setMessage(int index, String value) {
                if (value == null)
                    throw new NullPointerException();
                ensureMessageIsMutable();
                this.message_.set(index, value);
                onChanged();
                return this;
            }

            public Builder addMessage(String value) {
                if (value == null)
                    throw new NullPointerException();
                ensureMessageIsMutable();
                this.message_.add(value);
                onChanged();
                return this;
            }

            public Builder addAllMessage(Iterable<String> values) {
                ensureMessageIsMutable();
                AbstractMessageLite.Builder.addAll(values, (Collection) this.message_);
                onChanged();
                return this;
            }

            public Builder clearMessage() {
                this.message_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= 0xFFFFFFFD;
                onChanged();
                return this;
            }

            public Builder addMessageBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                ensureMessageIsMutable();
                this.message_.add(value);
                onChanged();
                return this;
            }
        }
    }

    public static final class NewsInfoRequest extends GeneratedMessage implements NewsInfoRequestOrBuilder {
        private static final NewsInfoRequest defaultInstance = new NewsInfoRequest(true);
        private final UnknownFieldSet unknownFields;

        private NewsInfoRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private NewsInfoRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static NewsInfoRequest getDefaultInstance() {
            return defaultInstance;
        }

        public NewsInfoRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private NewsInfoRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return SoloHandler.internal_static_pomelo_area_NewsInfoRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return SoloHandler.internal_static_pomelo_area_NewsInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(NewsInfoRequest.class, Builder.class);
        }

        public static Parser<NewsInfoRequest> PARSER = (Parser<NewsInfoRequest>) new AbstractParser<NewsInfoRequest>() {
            public SoloHandler.NewsInfoRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SoloHandler.NewsInfoRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<NewsInfoRequest> getParserForType() {
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

        public static NewsInfoRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (NewsInfoRequest) PARSER.parseFrom(data);
        }

        public static NewsInfoRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (NewsInfoRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static NewsInfoRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (NewsInfoRequest) PARSER.parseFrom(data);
        }

        public static NewsInfoRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (NewsInfoRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static NewsInfoRequest parseFrom(InputStream input) throws IOException {
            return (NewsInfoRequest) PARSER.parseFrom(input);
        }

        public static NewsInfoRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (NewsInfoRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static NewsInfoRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (NewsInfoRequest) PARSER.parseDelimitedFrom(input);
        }

        public static NewsInfoRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (NewsInfoRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static NewsInfoRequest parseFrom(CodedInputStream input) throws IOException {
            return (NewsInfoRequest) PARSER.parseFrom(input);
        }

        public static NewsInfoRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (NewsInfoRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(NewsInfoRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements SoloHandler.NewsInfoRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return SoloHandler.internal_static_pomelo_area_NewsInfoRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return SoloHandler.internal_static_pomelo_area_NewsInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(SoloHandler.NewsInfoRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SoloHandler.NewsInfoRequest.alwaysUseFieldBuilders) ;
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
                return SoloHandler.internal_static_pomelo_area_NewsInfoRequest_descriptor;
            }

            public SoloHandler.NewsInfoRequest getDefaultInstanceForType() {
                return SoloHandler.NewsInfoRequest.getDefaultInstance();
            }

            public SoloHandler.NewsInfoRequest build() {
                SoloHandler.NewsInfoRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public SoloHandler.NewsInfoRequest buildPartial() {
                SoloHandler.NewsInfoRequest result = new SoloHandler.NewsInfoRequest(this);
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof SoloHandler.NewsInfoRequest) return mergeFrom((SoloHandler.NewsInfoRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SoloHandler.NewsInfoRequest other) {
                if (other == SoloHandler.NewsInfoRequest.getDefaultInstance()) return this;
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                SoloHandler.NewsInfoRequest parsedMessage = null;
                try {
                    parsedMessage = (SoloHandler.NewsInfoRequest) SoloHandler.NewsInfoRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SoloHandler.NewsInfoRequest) e.getUnfinishedMessage();
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


    public static final class NewsInfoResponse
            extends GeneratedMessage
            implements NewsInfoResponseOrBuilder {
        private static final NewsInfoResponse defaultInstance = new NewsInfoResponse(true);
        private final UnknownFieldSet unknownFields;

        private NewsInfoResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private NewsInfoResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static NewsInfoResponse getDefaultInstance() {
            return defaultInstance;
        }

        public NewsInfoResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private NewsInfoResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.s2CSoloMessages_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x4;
                            }
                            this.s2CSoloMessages_.add(input.readMessage(SoloHandler.NewsInfo.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x4) == 4)
                    this.s2CSoloMessages_ = Collections.unmodifiableList(this.s2CSoloMessages_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SoloHandler.internal_static_pomelo_area_NewsInfoResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return SoloHandler.internal_static_pomelo_area_NewsInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(NewsInfoResponse.class, Builder.class);
        }

        public static Parser<NewsInfoResponse> PARSER = (Parser<NewsInfoResponse>) new AbstractParser<NewsInfoResponse>() {
            public SoloHandler.NewsInfoResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SoloHandler.NewsInfoResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_SOLOMESSAGES_FIELD_NUMBER = 3;
        private List<SoloHandler.NewsInfo> s2CSoloMessages_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<NewsInfoResponse> getParserForType() {
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

        public List<SoloHandler.NewsInfo> getS2CSoloMessagesList() {
            return this.s2CSoloMessages_;
        }

        public List<? extends SoloHandler.NewsInfoOrBuilder> getS2CSoloMessagesOrBuilderList() {
            return (List) this.s2CSoloMessages_;
        }

        public int getS2CSoloMessagesCount() {
            return this.s2CSoloMessages_.size();
        }

        public SoloHandler.NewsInfo getS2CSoloMessages(int index) {
            return this.s2CSoloMessages_.get(index);
        }

        public SoloHandler.NewsInfoOrBuilder getS2CSoloMessagesOrBuilder(int index) {
            return this.s2CSoloMessages_.get(index);
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CSoloMessages_ = Collections.emptyList();
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
            for (int i = 0; i < getS2CSoloMessagesCount(); i++) {
                if (!getS2CSoloMessages(i).isInitialized()) {
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
            for (int i = 0; i < this.s2CSoloMessages_.size(); i++)
                output.writeMessage(3, (MessageLite) this.s2CSoloMessages_.get(i));
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
            for (int i = 0; i < this.s2CSoloMessages_.size(); i++)
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.s2CSoloMessages_.get(i));
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static NewsInfoResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (NewsInfoResponse) PARSER.parseFrom(data);
        }

        public static NewsInfoResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (NewsInfoResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static NewsInfoResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (NewsInfoResponse) PARSER.parseFrom(data);
        }

        public static NewsInfoResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (NewsInfoResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static NewsInfoResponse parseFrom(InputStream input) throws IOException {
            return (NewsInfoResponse) PARSER.parseFrom(input);
        }

        public static NewsInfoResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (NewsInfoResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static NewsInfoResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (NewsInfoResponse) PARSER.parseDelimitedFrom(input);
        }

        public static NewsInfoResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (NewsInfoResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static NewsInfoResponse parseFrom(CodedInputStream input) throws IOException {
            return (NewsInfoResponse) PARSER.parseFrom(input);
        }

        public static NewsInfoResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (NewsInfoResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(NewsInfoResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements SoloHandler.NewsInfoResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private List<SoloHandler.NewsInfo> s2CSoloMessages_;
            private RepeatedFieldBuilder<SoloHandler.NewsInfo, SoloHandler.NewsInfo.Builder, SoloHandler.NewsInfoOrBuilder> s2CSoloMessagesBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SoloHandler.internal_static_pomelo_area_NewsInfoResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return SoloHandler.internal_static_pomelo_area_NewsInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(SoloHandler.NewsInfoResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.s2CSoloMessages_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CSoloMessages_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SoloHandler.NewsInfoResponse.alwaysUseFieldBuilders)
                    getS2CSoloMessagesFieldBuilder();
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
                if (this.s2CSoloMessagesBuilder_ == null) {
                    this.s2CSoloMessages_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                } else {
                    this.s2CSoloMessagesBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return SoloHandler.internal_static_pomelo_area_NewsInfoResponse_descriptor;
            }

            public SoloHandler.NewsInfoResponse getDefaultInstanceForType() {
                return SoloHandler.NewsInfoResponse.getDefaultInstance();
            }

            public SoloHandler.NewsInfoResponse build() {
                SoloHandler.NewsInfoResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public SoloHandler.NewsInfoResponse buildPartial() {
                SoloHandler.NewsInfoResponse result = new SoloHandler.NewsInfoResponse(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.s2CMsg_ = this.s2CMsg_;
                if (this.s2CSoloMessagesBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4) {
                        this.s2CSoloMessages_ = Collections.unmodifiableList(this.s2CSoloMessages_);
                        this.bitField0_ &= 0xFFFFFFFB;
                    }
                    result.s2CSoloMessages_ = this.s2CSoloMessages_;
                } else {
                    result.s2CSoloMessages_ = this.s2CSoloMessagesBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof SoloHandler.NewsInfoResponse)
                    return mergeFrom((SoloHandler.NewsInfoResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SoloHandler.NewsInfoResponse other) {
                if (other == SoloHandler.NewsInfoResponse.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (this.s2CSoloMessagesBuilder_ == null) {
                    if (!other.s2CSoloMessages_.isEmpty()) {
                        if (this.s2CSoloMessages_.isEmpty()) {
                            this.s2CSoloMessages_ = other.s2CSoloMessages_;
                            this.bitField0_ &= 0xFFFFFFFB;
                        } else {
                            ensureS2CSoloMessagesIsMutable();
                            this.s2CSoloMessages_.addAll(other.s2CSoloMessages_);
                        }
                        onChanged();
                    }
                } else if (!other.s2CSoloMessages_.isEmpty()) {
                    if (this.s2CSoloMessagesBuilder_.isEmpty()) {
                        this.s2CSoloMessagesBuilder_.dispose();
                        this.s2CSoloMessagesBuilder_ = null;
                        this.s2CSoloMessages_ = other.s2CSoloMessages_;
                        this.bitField0_ &= 0xFFFFFFFB;
                        this.s2CSoloMessagesBuilder_ = SoloHandler.NewsInfoResponse.alwaysUseFieldBuilders ? getS2CSoloMessagesFieldBuilder() : null;
                    } else {
                        this.s2CSoloMessagesBuilder_.addAllMessages(other.s2CSoloMessages_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode())
                    return false;
                for (int i = 0; i < getS2CSoloMessagesCount(); i++) {
                    if (!getS2CSoloMessages(i).isInitialized())
                        return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                SoloHandler.NewsInfoResponse parsedMessage = null;
                try {
                    parsedMessage = (SoloHandler.NewsInfoResponse) SoloHandler.NewsInfoResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SoloHandler.NewsInfoResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = SoloHandler.NewsInfoResponse.getDefaultInstance().getS2CMsg();
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

            private void ensureS2CSoloMessagesIsMutable() {
                if ((this.bitField0_ & 0x4) != 4) {
                    this.s2CSoloMessages_ = new ArrayList<>(this.s2CSoloMessages_);
                    this.bitField0_ |= 0x4;
                }
            }

            public List<SoloHandler.NewsInfo> getS2CSoloMessagesList() {
                if (this.s2CSoloMessagesBuilder_ == null)
                    return Collections.unmodifiableList(this.s2CSoloMessages_);
                return this.s2CSoloMessagesBuilder_.getMessageList();
            }

            public int getS2CSoloMessagesCount() {
                if (this.s2CSoloMessagesBuilder_ == null)
                    return this.s2CSoloMessages_.size();
                return this.s2CSoloMessagesBuilder_.getCount();
            }

            public SoloHandler.NewsInfo getS2CSoloMessages(int index) {
                if (this.s2CSoloMessagesBuilder_ == null)
                    return this.s2CSoloMessages_.get(index);
                return (SoloHandler.NewsInfo) this.s2CSoloMessagesBuilder_.getMessage(index);
            }

            public Builder setS2CSoloMessages(int index, SoloHandler.NewsInfo value) {
                if (this.s2CSoloMessagesBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CSoloMessagesIsMutable();
                    this.s2CSoloMessages_.set(index, value);
                    onChanged();
                } else {
                    this.s2CSoloMessagesBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setS2CSoloMessages(int index, SoloHandler.NewsInfo.Builder builderForValue) {
                if (this.s2CSoloMessagesBuilder_ == null) {
                    ensureS2CSoloMessagesIsMutable();
                    this.s2CSoloMessages_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CSoloMessagesBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addS2CSoloMessages(SoloHandler.NewsInfo value) {
                if (this.s2CSoloMessagesBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CSoloMessagesIsMutable();
                    this.s2CSoloMessages_.add(value);
                    onChanged();
                } else {
                    this.s2CSoloMessagesBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addS2CSoloMessages(int index, SoloHandler.NewsInfo value) {
                if (this.s2CSoloMessagesBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CSoloMessagesIsMutable();
                    this.s2CSoloMessages_.add(index, value);
                    onChanged();
                } else {
                    this.s2CSoloMessagesBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addS2CSoloMessages(SoloHandler.NewsInfo.Builder builderForValue) {
                if (this.s2CSoloMessagesBuilder_ == null) {
                    ensureS2CSoloMessagesIsMutable();
                    this.s2CSoloMessages_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.s2CSoloMessagesBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addS2CSoloMessages(int index, SoloHandler.NewsInfo.Builder builderForValue) {
                if (this.s2CSoloMessagesBuilder_ == null) {
                    ensureS2CSoloMessagesIsMutable();
                    this.s2CSoloMessages_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CSoloMessagesBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllS2CSoloMessages(Iterable<? extends SoloHandler.NewsInfo> values) {
                if (this.s2CSoloMessagesBuilder_ == null) {
                    ensureS2CSoloMessagesIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.s2CSoloMessages_);
                    onChanged();
                } else {
                    this.s2CSoloMessagesBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearS2CSoloMessages() {
                if (this.s2CSoloMessagesBuilder_ == null) {
                    this.s2CSoloMessages_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                    onChanged();
                } else {
                    this.s2CSoloMessagesBuilder_.clear();
                }
                return this;
            }

            public Builder removeS2CSoloMessages(int index) {
                if (this.s2CSoloMessagesBuilder_ == null) {
                    ensureS2CSoloMessagesIsMutable();
                    this.s2CSoloMessages_.remove(index);
                    onChanged();
                } else {
                    this.s2CSoloMessagesBuilder_.remove(index);
                }
                return this;
            }

            public SoloHandler.NewsInfo.Builder getS2CSoloMessagesBuilder(int index) {
                return (SoloHandler.NewsInfo.Builder) getS2CSoloMessagesFieldBuilder().getBuilder(index);
            }

            public SoloHandler.NewsInfoOrBuilder getS2CSoloMessagesOrBuilder(int index) {
                if (this.s2CSoloMessagesBuilder_ == null)
                    return this.s2CSoloMessages_.get(index);
                return (SoloHandler.NewsInfoOrBuilder) this.s2CSoloMessagesBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends SoloHandler.NewsInfoOrBuilder> getS2CSoloMessagesOrBuilderList() {
                if (this.s2CSoloMessagesBuilder_ != null)
                    return this.s2CSoloMessagesBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.s2CSoloMessages_);
            }

            public SoloHandler.NewsInfo.Builder addS2CSoloMessagesBuilder() {
                return (SoloHandler.NewsInfo.Builder) getS2CSoloMessagesFieldBuilder().addBuilder(SoloHandler.NewsInfo.getDefaultInstance());
            }

            public SoloHandler.NewsInfo.Builder addS2CSoloMessagesBuilder(int index) {
                return (SoloHandler.NewsInfo.Builder) getS2CSoloMessagesFieldBuilder().addBuilder(index, SoloHandler.NewsInfo.getDefaultInstance());
            }

            public List<SoloHandler.NewsInfo.Builder> getS2CSoloMessagesBuilderList() {
                return getS2CSoloMessagesFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<SoloHandler.NewsInfo, SoloHandler.NewsInfo.Builder, SoloHandler.NewsInfoOrBuilder> getS2CSoloMessagesFieldBuilder() {
                if (this.s2CSoloMessagesBuilder_ == null) {
                    this.s2CSoloMessagesBuilder_ = new RepeatedFieldBuilder(this.s2CSoloMessages_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
                    this.s2CSoloMessages_ = null;
                }
                return this.s2CSoloMessagesBuilder_;
            }
        }
    }

    public static final class BattleRecordRequest extends GeneratedMessage implements BattleRecordRequestOrBuilder {
        private static final BattleRecordRequest defaultInstance = new BattleRecordRequest(true);
        private final UnknownFieldSet unknownFields;

        private BattleRecordRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private BattleRecordRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static BattleRecordRequest getDefaultInstance() {
            return defaultInstance;
        }

        public BattleRecordRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BattleRecordRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return SoloHandler.internal_static_pomelo_area_BattleRecordRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return SoloHandler.internal_static_pomelo_area_BattleRecordRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(BattleRecordRequest.class, Builder.class);
        }

        public static Parser<BattleRecordRequest> PARSER = (Parser<BattleRecordRequest>) new AbstractParser<BattleRecordRequest>() {
            public SoloHandler.BattleRecordRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SoloHandler.BattleRecordRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<BattleRecordRequest> getParserForType() {
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

        public static BattleRecordRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (BattleRecordRequest) PARSER.parseFrom(data);
        }

        public static BattleRecordRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BattleRecordRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static BattleRecordRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (BattleRecordRequest) PARSER.parseFrom(data);
        }

        public static BattleRecordRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BattleRecordRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static BattleRecordRequest parseFrom(InputStream input) throws IOException {
            return (BattleRecordRequest) PARSER.parseFrom(input);
        }

        public static BattleRecordRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BattleRecordRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static BattleRecordRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (BattleRecordRequest) PARSER.parseDelimitedFrom(input);
        }

        public static BattleRecordRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BattleRecordRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static BattleRecordRequest parseFrom(CodedInputStream input) throws IOException {
            return (BattleRecordRequest) PARSER.parseFrom(input);
        }

        public static BattleRecordRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BattleRecordRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(BattleRecordRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements SoloHandler.BattleRecordRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return SoloHandler.internal_static_pomelo_area_BattleRecordRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return SoloHandler.internal_static_pomelo_area_BattleRecordRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(SoloHandler.BattleRecordRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SoloHandler.BattleRecordRequest.alwaysUseFieldBuilders) ;
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
                return SoloHandler.internal_static_pomelo_area_BattleRecordRequest_descriptor;
            }

            public SoloHandler.BattleRecordRequest getDefaultInstanceForType() {
                return SoloHandler.BattleRecordRequest.getDefaultInstance();
            }

            public SoloHandler.BattleRecordRequest build() {
                SoloHandler.BattleRecordRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public SoloHandler.BattleRecordRequest buildPartial() {
                SoloHandler.BattleRecordRequest result = new SoloHandler.BattleRecordRequest(this);
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof SoloHandler.BattleRecordRequest)
                    return mergeFrom((SoloHandler.BattleRecordRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SoloHandler.BattleRecordRequest other) {
                if (other == SoloHandler.BattleRecordRequest.getDefaultInstance()) return this;
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                SoloHandler.BattleRecordRequest parsedMessage = null;
                try {
                    parsedMessage = (SoloHandler.BattleRecordRequest) SoloHandler.BattleRecordRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SoloHandler.BattleRecordRequest) e.getUnfinishedMessage();
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


    public static final class BattleRecord
            extends GeneratedMessage
            implements BattleRecordOrBuilder {
        private static final BattleRecord defaultInstance = new BattleRecord(true);
        private final UnknownFieldSet unknownFields;

        private BattleRecord(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private BattleRecord(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static BattleRecord getDefaultInstance() {
            return defaultInstance;
        }

        public BattleRecord getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BattleRecord(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.result_ = input.readInt32();
                            break;
                        case 18:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x2;
                            this.battleTime_ = bs;
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.score_ = input.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.scoreChange_ = input.readInt32();
                            break;
                        case 42:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x10;
                            this.vsName_ = bs;
                            break;
                        case 50:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x20;
                            this.vsGuildName_ = bs;
                            break;
                        case 56:
                            this.bitField0_ |= 0x40;
                            this.vsPro_ = input.readInt32();
                            break;
                        case 64:
                            this.bitField0_ |= 0x80;
                            this.vsScore_ = input.readInt32();
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
            return SoloHandler.internal_static_pomelo_area_BattleRecord_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return SoloHandler.internal_static_pomelo_area_BattleRecord_fieldAccessorTable.ensureFieldAccessorsInitialized(BattleRecord.class, Builder.class);
        }

        public static Parser<BattleRecord> PARSER = (Parser<BattleRecord>) new AbstractParser<BattleRecord>() {
            public SoloHandler.BattleRecord parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SoloHandler.BattleRecord(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int RESULT_FIELD_NUMBER = 1;
        private int result_;
        public static final int BATTLETIME_FIELD_NUMBER = 2;
        private Object battleTime_;
        public static final int SCORE_FIELD_NUMBER = 3;
        private int score_;
        public static final int SCORECHANGE_FIELD_NUMBER = 4;
        private int scoreChange_;
        public static final int VSNAME_FIELD_NUMBER = 5;
        private Object vsName_;
        public static final int VSGUILDNAME_FIELD_NUMBER = 6;
        private Object vsGuildName_;
        public static final int VSPRO_FIELD_NUMBER = 7;
        private int vsPro_;
        public static final int VSSCORE_FIELD_NUMBER = 8;
        private int vsScore_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<BattleRecord> getParserForType() {
            return PARSER;
        }

        public boolean hasResult() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getResult() {
            return this.result_;
        }

        public boolean hasBattleTime() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public String getBattleTime() {
            Object ref = this.battleTime_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.battleTime_ = s;
            return s;
        }

        static {
            defaultInstance.initFields();
        }


        public ByteString getBattleTimeBytes() {
            Object ref = this.battleTime_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.battleTime_ = b;
                return b;
            }
            return (ByteString) ref;
        }


        public boolean hasScore() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public int getScore() {
            return this.score_;
        }


        public boolean hasScoreChange() {
            return ((this.bitField0_ & 0x8) == 8);
        }


        public int getScoreChange() {
            return this.scoreChange_;
        }


        public boolean hasVsName() {
            return ((this.bitField0_ & 0x10) == 16);
        }


        public String getVsName() {
            Object ref = this.vsName_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.vsName_ = s;
            }
            return s;
        }


        public ByteString getVsNameBytes() {
            Object ref = this.vsName_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.vsName_ = b;
                return b;
            }
            return (ByteString) ref;
        }


        public boolean hasVsGuildName() {
            return ((this.bitField0_ & 0x20) == 32);
        }


        public String getVsGuildName() {
            Object ref = this.vsGuildName_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.vsGuildName_ = s;
            }
            return s;
        }


        public ByteString getVsGuildNameBytes() {
            Object ref = this.vsGuildName_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.vsGuildName_ = b;
                return b;
            }
            return (ByteString) ref;
        }


        public boolean hasVsPro() {
            return ((this.bitField0_ & 0x40) == 64);
        }


        public int getVsPro() {
            return this.vsPro_;
        }


        public boolean hasVsScore() {
            return ((this.bitField0_ & 0x80) == 128);
        }


        public int getVsScore() {
            return this.vsScore_;
        }


        private void initFields() {
            this.result_ = 0;
            this.battleTime_ = "";
            this.score_ = 0;
            this.scoreChange_ = 0;
            this.vsName_ = "";
            this.vsGuildName_ = "";
            this.vsPro_ = 0;
            this.vsScore_ = 0;
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasResult()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasBattleTime()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasScore()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasScoreChange()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasVsName()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasVsGuildName()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasVsPro()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasVsScore()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeInt32(1, this.result_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeBytes(2, getBattleTimeBytes());
            }
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeInt32(3, this.score_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                output.writeInt32(4, this.scoreChange_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                output.writeBytes(5, getVsNameBytes());
            }
            if ((this.bitField0_ & 0x20) == 32) {
                output.writeBytes(6, getVsGuildNameBytes());
            }
            if ((this.bitField0_ & 0x40) == 64) {
                output.writeInt32(7, this.vsPro_);
            }
            if ((this.bitField0_ & 0x80) == 128) {
                output.writeInt32(8, this.vsScore_);
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
                size += CodedOutputStream.computeInt32Size(1, this.result_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeBytesSize(2, getBattleTimeBytes());
            }
            if ((this.bitField0_ & 0x4) == 4) {
                size += CodedOutputStream.computeInt32Size(3, this.score_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                size += CodedOutputStream.computeInt32Size(4, this.scoreChange_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                size += CodedOutputStream.computeBytesSize(5, getVsNameBytes());
            }
            if ((this.bitField0_ & 0x20) == 32) {
                size += CodedOutputStream.computeBytesSize(6, getVsGuildNameBytes());
            }
            if ((this.bitField0_ & 0x40) == 64) {
                size += CodedOutputStream.computeInt32Size(7, this.vsPro_);
            }
            if ((this.bitField0_ & 0x80) == 128) {
                size += CodedOutputStream.computeInt32Size(8, this.vsScore_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static BattleRecord parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (BattleRecord) PARSER.parseFrom(data);
        }


        public static BattleRecord parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BattleRecord) PARSER.parseFrom(data, extensionRegistry);
        }


        public static BattleRecord parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (BattleRecord) PARSER.parseFrom(data);
        }


        public static BattleRecord parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BattleRecord) PARSER.parseFrom(data, extensionRegistry);
        }


        public static BattleRecord parseFrom(InputStream input) throws IOException {
            return (BattleRecord) PARSER.parseFrom(input);
        }


        public static BattleRecord parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BattleRecord) PARSER.parseFrom(input, extensionRegistry);
        }


        public static BattleRecord parseDelimitedFrom(InputStream input) throws IOException {
            return (BattleRecord) PARSER.parseDelimitedFrom(input);
        }


        public static BattleRecord parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BattleRecord) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static BattleRecord parseFrom(CodedInputStream input) throws IOException {
            return (BattleRecord) PARSER.parseFrom(input);
        }


        public static BattleRecord parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BattleRecord) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(BattleRecord prototype) {
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
                implements SoloHandler.BattleRecordOrBuilder {
            private int bitField0_;


            private int result_;


            private Object battleTime_;


            private int score_;


            private int scoreChange_;


            private Object vsName_;


            private Object vsGuildName_;


            private int vsPro_;


            private int vsScore_;


            public static final Descriptors.Descriptor getDescriptor() {
                return SoloHandler.internal_static_pomelo_area_BattleRecord_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return SoloHandler.internal_static_pomelo_area_BattleRecord_fieldAccessorTable.ensureFieldAccessorsInitialized(SoloHandler.BattleRecord.class, Builder.class);
            }


            private Builder() {
                this.battleTime_ = "";
                this.vsName_ = "";
                this.vsGuildName_ = "";
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.battleTime_ = "";
                this.vsName_ = "";
                this.vsGuildName_ = "";
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (SoloHandler.BattleRecord.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.result_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.battleTime_ = "";
                this.bitField0_ &= 0xFFFFFFFD;
                this.score_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.scoreChange_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                this.vsName_ = "";
                this.bitField0_ &= 0xFFFFFFEF;
                this.vsGuildName_ = "";
                this.bitField0_ &= 0xFFFFFFDF;
                this.vsPro_ = 0;
                this.bitField0_ &= 0xFFFFFFBF;
                this.vsScore_ = 0;
                this.bitField0_ &= 0xFFFFFF7F;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return SoloHandler.internal_static_pomelo_area_BattleRecord_descriptor;
            }


            public SoloHandler.BattleRecord getDefaultInstanceForType() {
                return SoloHandler.BattleRecord.getDefaultInstance();
            }


            public SoloHandler.BattleRecord build() {
                SoloHandler.BattleRecord result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public SoloHandler.BattleRecord buildPartial() {
                SoloHandler.BattleRecord result = new SoloHandler.BattleRecord(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.result_ = this.result_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.battleTime_ = this.battleTime_;
                if ((from_bitField0_ & 0x4) == 4) {
                    to_bitField0_ |= 0x4;
                }
                result.score_ = this.score_;
                if ((from_bitField0_ & 0x8) == 8) {
                    to_bitField0_ |= 0x8;
                }
                result.scoreChange_ = this.scoreChange_;
                if ((from_bitField0_ & 0x10) == 16) {
                    to_bitField0_ |= 0x10;
                }
                result.vsName_ = this.vsName_;
                if ((from_bitField0_ & 0x20) == 32) {
                    to_bitField0_ |= 0x20;
                }
                result.vsGuildName_ = this.vsGuildName_;
                if ((from_bitField0_ & 0x40) == 64) {
                    to_bitField0_ |= 0x40;
                }
                result.vsPro_ = this.vsPro_;
                if ((from_bitField0_ & 0x80) == 128) {
                    to_bitField0_ |= 0x80;
                }
                result.vsScore_ = this.vsScore_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof SoloHandler.BattleRecord) {
                    return mergeFrom((SoloHandler.BattleRecord) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(SoloHandler.BattleRecord other) {
                if (other == SoloHandler.BattleRecord.getDefaultInstance()) {
                    return this;
                }
                if (other.hasResult()) {
                    setResult(other.getResult());
                }
                if (other.hasBattleTime()) {
                    this.bitField0_ |= 0x2;
                    this.battleTime_ = other.battleTime_;
                    onChanged();
                }
                if (other.hasScore()) {
                    setScore(other.getScore());
                }
                if (other.hasScoreChange()) {
                    setScoreChange(other.getScoreChange());
                }
                if (other.hasVsName()) {
                    this.bitField0_ |= 0x10;
                    this.vsName_ = other.vsName_;
                    onChanged();
                }
                if (other.hasVsGuildName()) {
                    this.bitField0_ |= 0x20;
                    this.vsGuildName_ = other.vsGuildName_;
                    onChanged();
                }
                if (other.hasVsPro()) {
                    setVsPro(other.getVsPro());
                }
                if (other.hasVsScore()) {
                    setVsScore(other.getVsScore());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasResult()) {
                    return false;
                }
                if (!hasBattleTime()) {
                    return false;
                }
                if (!hasScore()) {
                    return false;
                }
                if (!hasScoreChange()) {
                    return false;
                }
                if (!hasVsName()) {
                    return false;
                }
                if (!hasVsGuildName()) {
                    return false;
                }
                if (!hasVsPro()) {
                    return false;
                }
                if (!hasVsScore()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                SoloHandler.BattleRecord parsedMessage = null;
                try {
                    parsedMessage = (SoloHandler.BattleRecord) SoloHandler.BattleRecord.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SoloHandler.BattleRecord) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasResult() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public int getResult() {
                return this.result_;
            }


            public Builder setResult(int value) {
                this.bitField0_ |= 0x1;
                this.result_ = value;
                onChanged();
                return this;
            }


            public Builder clearResult() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.result_ = 0;
                onChanged();
                return this;
            }


            public boolean hasBattleTime() {
                return ((this.bitField0_ & 0x2) == 2);
            }


            public String getBattleTime() {
                Object ref = this.battleTime_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.battleTime_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }


            public ByteString getBattleTimeBytes() {
                Object ref = this.battleTime_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.battleTime_ = b;
                    return b;
                }
                return (ByteString) ref;
            }


            public Builder setBattleTime(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x2;
                this.battleTime_ = value;
                onChanged();
                return this;
            }


            public Builder clearBattleTime() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.battleTime_ = SoloHandler.BattleRecord.getDefaultInstance().getBattleTime();
                onChanged();
                return this;
            }


            public Builder setBattleTimeBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x2;
                this.battleTime_ = value;
                onChanged();
                return this;
            }


            public boolean hasScore() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public int getScore() {
                return this.score_;
            }


            public Builder setScore(int value) {
                this.bitField0_ |= 0x4;
                this.score_ = value;
                onChanged();
                return this;
            }


            public Builder clearScore() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.score_ = 0;
                onChanged();
                return this;
            }


            public boolean hasScoreChange() {
                return ((this.bitField0_ & 0x8) == 8);
            }


            public int getScoreChange() {
                return this.scoreChange_;
            }


            public Builder setScoreChange(int value) {
                this.bitField0_ |= 0x8;
                this.scoreChange_ = value;
                onChanged();
                return this;
            }


            public Builder clearScoreChange() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.scoreChange_ = 0;
                onChanged();
                return this;
            }


            public boolean hasVsName() {
                return ((this.bitField0_ & 0x10) == 16);
            }


            public String getVsName() {
                Object ref = this.vsName_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.vsName_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }


            public ByteString getVsNameBytes() {
                Object ref = this.vsName_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.vsName_ = b;
                    return b;
                }
                return (ByteString) ref;
            }


            public Builder setVsName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x10;
                this.vsName_ = value;
                onChanged();
                return this;
            }


            public Builder clearVsName() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.vsName_ = SoloHandler.BattleRecord.getDefaultInstance().getVsName();
                onChanged();
                return this;
            }


            public Builder setVsNameBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x10;
                this.vsName_ = value;
                onChanged();
                return this;
            }


            public boolean hasVsGuildName() {
                return ((this.bitField0_ & 0x20) == 32);
            }


            public String getVsGuildName() {
                Object ref = this.vsGuildName_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.vsGuildName_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }


            public ByteString getVsGuildNameBytes() {
                Object ref = this.vsGuildName_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.vsGuildName_ = b;
                    return b;
                }
                return (ByteString) ref;
            }


            public Builder setVsGuildName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x20;
                this.vsGuildName_ = value;
                onChanged();
                return this;
            }


            public Builder clearVsGuildName() {
                this.bitField0_ &= 0xFFFFFFDF;
                this.vsGuildName_ = SoloHandler.BattleRecord.getDefaultInstance().getVsGuildName();
                onChanged();
                return this;
            }


            public Builder setVsGuildNameBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x20;
                this.vsGuildName_ = value;
                onChanged();
                return this;
            }


            public boolean hasVsPro() {
                return ((this.bitField0_ & 0x40) == 64);
            }


            public int getVsPro() {
                return this.vsPro_;
            }


            public Builder setVsPro(int value) {
                this.bitField0_ |= 0x40;
                this.vsPro_ = value;
                onChanged();
                return this;
            }


            public Builder clearVsPro() {
                this.bitField0_ &= 0xFFFFFFBF;
                this.vsPro_ = 0;
                onChanged();
                return this;
            }


            public boolean hasVsScore() {
                return ((this.bitField0_ & 0x80) == 128);
            }


            public int getVsScore() {
                return this.vsScore_;
            }


            public Builder setVsScore(int value) {
                this.bitField0_ |= 0x80;
                this.vsScore_ = value;
                onChanged();
                return this;
            }


            public Builder clearVsScore() {
                this.bitField0_ &= 0xFFFFFF7F;
                this.vsScore_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class BattleRecordResponse
            extends GeneratedMessage
            implements BattleRecordResponseOrBuilder {
        private static final BattleRecordResponse defaultInstance = new BattleRecordResponse(true);
        private final UnknownFieldSet unknownFields;

        private BattleRecordResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private BattleRecordResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static BattleRecordResponse getDefaultInstance() {
            return defaultInstance;
        }

        public BattleRecordResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BattleRecordResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.s2CCanglang_ = input.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.s2CYixian_ = input.readInt32();
                            break;
                        case 40:
                            this.bitField0_ |= 0x10;
                            this.s2CYujian_ = input.readInt32();
                            break;
                        case 48:
                            this.bitField0_ |= 0x20;
                            this.s2CLinghu_ = input.readInt32();
                            break;
                        case 56:
                            this.bitField0_ |= 0x40;
                            this.s2CShenjian_ = input.readInt32();
                            break;
                        case 66:
                            if ((mutable_bitField0_ & 0x80) != 128) {
                                this.s2CBatttleList_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x80;
                            }
                            this.s2CBatttleList_.add(input.readMessage(SoloHandler.BattleRecord.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x80) == 128)
                    this.s2CBatttleList_ = Collections.unmodifiableList(this.s2CBatttleList_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SoloHandler.internal_static_pomelo_area_BattleRecordResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return SoloHandler.internal_static_pomelo_area_BattleRecordResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(BattleRecordResponse.class, Builder.class);
        }

        public static Parser<BattleRecordResponse> PARSER = (Parser<BattleRecordResponse>) new AbstractParser<BattleRecordResponse>() {
            public SoloHandler.BattleRecordResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SoloHandler.BattleRecordResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_CANGLANG_FIELD_NUMBER = 3;
        private int s2CCanglang_;
        public static final int S2C_YIXIAN_FIELD_NUMBER = 4;
        private int s2CYixian_;
        public static final int S2C_YUJIAN_FIELD_NUMBER = 5;
        private int s2CYujian_;
        public static final int S2C_LINGHU_FIELD_NUMBER = 6;
        private int s2CLinghu_;
        public static final int S2C_SHENJIAN_FIELD_NUMBER = 7;
        private int s2CShenjian_;
        public static final int S2C_BATTTLELIST_FIELD_NUMBER = 8;
        private List<SoloHandler.BattleRecord> s2CBatttleList_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<BattleRecordResponse> getParserForType() {
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

        public boolean hasS2CCanglang() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getS2CCanglang() {
            return this.s2CCanglang_;
        }

        public boolean hasS2CYixian() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public int getS2CYixian() {
            return this.s2CYixian_;
        }

        public boolean hasS2CYujian() {
            return ((this.bitField0_ & 0x10) == 16);
        }

        public int getS2CYujian() {
            return this.s2CYujian_;
        }

        public boolean hasS2CLinghu() {
            return ((this.bitField0_ & 0x20) == 32);
        }

        public int getS2CLinghu() {
            return this.s2CLinghu_;
        }

        public boolean hasS2CShenjian() {
            return ((this.bitField0_ & 0x40) == 64);
        }

        public int getS2CShenjian() {
            return this.s2CShenjian_;
        }

        public List<SoloHandler.BattleRecord> getS2CBatttleListList() {
            return this.s2CBatttleList_;
        }

        public List<? extends SoloHandler.BattleRecordOrBuilder> getS2CBatttleListOrBuilderList() {
            return (List) this.s2CBatttleList_;
        }

        public int getS2CBatttleListCount() {
            return this.s2CBatttleList_.size();
        }

        public SoloHandler.BattleRecord getS2CBatttleList(int index) {
            return this.s2CBatttleList_.get(index);
        }

        public SoloHandler.BattleRecordOrBuilder getS2CBatttleListOrBuilder(int index) {
            return this.s2CBatttleList_.get(index);
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CCanglang_ = 0;
            this.s2CYixian_ = 0;
            this.s2CYujian_ = 0;
            this.s2CLinghu_ = 0;
            this.s2CShenjian_ = 0;
            this.s2CBatttleList_ = Collections.emptyList();
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
            for (int i = 0; i < getS2CBatttleListCount(); i++) {
                if (!getS2CBatttleList(i).isInitialized()) {
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
            if ((this.bitField0_ & 0x4) == 4)
                output.writeInt32(3, this.s2CCanglang_);
            if ((this.bitField0_ & 0x8) == 8)
                output.writeInt32(4, this.s2CYixian_);
            if ((this.bitField0_ & 0x10) == 16)
                output.writeInt32(5, this.s2CYujian_);
            if ((this.bitField0_ & 0x20) == 32)
                output.writeInt32(6, this.s2CLinghu_);
            if ((this.bitField0_ & 0x40) == 64)
                output.writeInt32(7, this.s2CShenjian_);
            for (int i = 0; i < this.s2CBatttleList_.size(); i++)
                output.writeMessage(8, (MessageLite) this.s2CBatttleList_.get(i));
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
                size += CodedOutputStream.computeInt32Size(3, this.s2CCanglang_);
            if ((this.bitField0_ & 0x8) == 8)
                size += CodedOutputStream.computeInt32Size(4, this.s2CYixian_);
            if ((this.bitField0_ & 0x10) == 16)
                size += CodedOutputStream.computeInt32Size(5, this.s2CYujian_);
            if ((this.bitField0_ & 0x20) == 32)
                size += CodedOutputStream.computeInt32Size(6, this.s2CLinghu_);
            if ((this.bitField0_ & 0x40) == 64)
                size += CodedOutputStream.computeInt32Size(7, this.s2CShenjian_);
            for (int i = 0; i < this.s2CBatttleList_.size(); i++)
                size += CodedOutputStream.computeMessageSize(8, (MessageLite) this.s2CBatttleList_.get(i));
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static BattleRecordResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (BattleRecordResponse) PARSER.parseFrom(data);
        }

        public static BattleRecordResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BattleRecordResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static BattleRecordResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (BattleRecordResponse) PARSER.parseFrom(data);
        }

        public static BattleRecordResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BattleRecordResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static BattleRecordResponse parseFrom(InputStream input) throws IOException {
            return (BattleRecordResponse) PARSER.parseFrom(input);
        }

        public static BattleRecordResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BattleRecordResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static BattleRecordResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (BattleRecordResponse) PARSER.parseDelimitedFrom(input);
        }

        public static BattleRecordResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BattleRecordResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static BattleRecordResponse parseFrom(CodedInputStream input) throws IOException {
            return (BattleRecordResponse) PARSER.parseFrom(input);
        }

        public static BattleRecordResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BattleRecordResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(BattleRecordResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements SoloHandler.BattleRecordResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private int s2CCanglang_;
            private int s2CYixian_;
            private int s2CYujian_;
            private int s2CLinghu_;
            private int s2CShenjian_;
            private List<SoloHandler.BattleRecord> s2CBatttleList_;
            private RepeatedFieldBuilder<SoloHandler.BattleRecord, SoloHandler.BattleRecord.Builder, SoloHandler.BattleRecordOrBuilder> s2CBatttleListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SoloHandler.internal_static_pomelo_area_BattleRecordResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return SoloHandler.internal_static_pomelo_area_BattleRecordResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(SoloHandler.BattleRecordResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.s2CBatttleList_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CBatttleList_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SoloHandler.BattleRecordResponse.alwaysUseFieldBuilders)
                    getS2CBatttleListFieldBuilder();
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
                this.s2CCanglang_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.s2CYixian_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                this.s2CYujian_ = 0;
                this.bitField0_ &= 0xFFFFFFEF;
                this.s2CLinghu_ = 0;
                this.bitField0_ &= 0xFFFFFFDF;
                this.s2CShenjian_ = 0;
                this.bitField0_ &= 0xFFFFFFBF;
                if (this.s2CBatttleListBuilder_ == null) {
                    this.s2CBatttleList_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFF7F;
                } else {
                    this.s2CBatttleListBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return SoloHandler.internal_static_pomelo_area_BattleRecordResponse_descriptor;
            }

            public SoloHandler.BattleRecordResponse getDefaultInstanceForType() {
                return SoloHandler.BattleRecordResponse.getDefaultInstance();
            }

            public SoloHandler.BattleRecordResponse build() {
                SoloHandler.BattleRecordResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public SoloHandler.BattleRecordResponse buildPartial() {
                SoloHandler.BattleRecordResponse result = new SoloHandler.BattleRecordResponse(this);
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
                result.s2CCanglang_ = this.s2CCanglang_;
                if ((from_bitField0_ & 0x8) == 8)
                    to_bitField0_ |= 0x8;
                result.s2CYixian_ = this.s2CYixian_;
                if ((from_bitField0_ & 0x10) == 16)
                    to_bitField0_ |= 0x10;
                result.s2CYujian_ = this.s2CYujian_;
                if ((from_bitField0_ & 0x20) == 32)
                    to_bitField0_ |= 0x20;
                result.s2CLinghu_ = this.s2CLinghu_;
                if ((from_bitField0_ & 0x40) == 64)
                    to_bitField0_ |= 0x40;
                result.s2CShenjian_ = this.s2CShenjian_;
                if (this.s2CBatttleListBuilder_ == null) {
                    if ((this.bitField0_ & 0x80) == 128) {
                        this.s2CBatttleList_ = Collections.unmodifiableList(this.s2CBatttleList_);
                        this.bitField0_ &= 0xFFFFFF7F;
                    }
                    result.s2CBatttleList_ = this.s2CBatttleList_;
                } else {
                    result.s2CBatttleList_ = this.s2CBatttleListBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof SoloHandler.BattleRecordResponse)
                    return mergeFrom((SoloHandler.BattleRecordResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SoloHandler.BattleRecordResponse other) {
                if (other == SoloHandler.BattleRecordResponse.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (other.hasS2CCanglang())
                    setS2CCanglang(other.getS2CCanglang());
                if (other.hasS2CYixian())
                    setS2CYixian(other.getS2CYixian());
                if (other.hasS2CYujian())
                    setS2CYujian(other.getS2CYujian());
                if (other.hasS2CLinghu())
                    setS2CLinghu(other.getS2CLinghu());
                if (other.hasS2CShenjian())
                    setS2CShenjian(other.getS2CShenjian());
                if (this.s2CBatttleListBuilder_ == null) {
                    if (!other.s2CBatttleList_.isEmpty()) {
                        if (this.s2CBatttleList_.isEmpty()) {
                            this.s2CBatttleList_ = other.s2CBatttleList_;
                            this.bitField0_ &= 0xFFFFFF7F;
                        } else {
                            ensureS2CBatttleListIsMutable();
                            this.s2CBatttleList_.addAll(other.s2CBatttleList_);
                        }
                        onChanged();
                    }
                } else if (!other.s2CBatttleList_.isEmpty()) {
                    if (this.s2CBatttleListBuilder_.isEmpty()) {
                        this.s2CBatttleListBuilder_.dispose();
                        this.s2CBatttleListBuilder_ = null;
                        this.s2CBatttleList_ = other.s2CBatttleList_;
                        this.bitField0_ &= 0xFFFFFF7F;
                        this.s2CBatttleListBuilder_ = SoloHandler.BattleRecordResponse.alwaysUseFieldBuilders ? getS2CBatttleListFieldBuilder() : null;
                    } else {
                        this.s2CBatttleListBuilder_.addAllMessages(other.s2CBatttleList_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode())
                    return false;
                for (int i = 0; i < getS2CBatttleListCount(); i++) {
                    if (!getS2CBatttleList(i).isInitialized())
                        return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                SoloHandler.BattleRecordResponse parsedMessage = null;
                try {
                    parsedMessage = (SoloHandler.BattleRecordResponse) SoloHandler.BattleRecordResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SoloHandler.BattleRecordResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = SoloHandler.BattleRecordResponse.getDefaultInstance().getS2CMsg();
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

            public boolean hasS2CCanglang() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public int getS2CCanglang() {
                return this.s2CCanglang_;
            }

            public Builder setS2CCanglang(int value) {
                this.bitField0_ |= 0x4;
                this.s2CCanglang_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CCanglang() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.s2CCanglang_ = 0;
                onChanged();
                return this;
            }

            public boolean hasS2CYixian() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public int getS2CYixian() {
                return this.s2CYixian_;
            }

            public Builder setS2CYixian(int value) {
                this.bitField0_ |= 0x8;
                this.s2CYixian_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CYixian() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.s2CYixian_ = 0;
                onChanged();
                return this;
            }

            public boolean hasS2CYujian() {
                return ((this.bitField0_ & 0x10) == 16);
            }

            public int getS2CYujian() {
                return this.s2CYujian_;
            }

            public Builder setS2CYujian(int value) {
                this.bitField0_ |= 0x10;
                this.s2CYujian_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CYujian() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.s2CYujian_ = 0;
                onChanged();
                return this;
            }

            public boolean hasS2CLinghu() {
                return ((this.bitField0_ & 0x20) == 32);
            }

            public int getS2CLinghu() {
                return this.s2CLinghu_;
            }

            public Builder setS2CLinghu(int value) {
                this.bitField0_ |= 0x20;
                this.s2CLinghu_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CLinghu() {
                this.bitField0_ &= 0xFFFFFFDF;
                this.s2CLinghu_ = 0;
                onChanged();
                return this;
            }

            public boolean hasS2CShenjian() {
                return ((this.bitField0_ & 0x40) == 64);
            }

            public int getS2CShenjian() {
                return this.s2CShenjian_;
            }

            public Builder setS2CShenjian(int value) {
                this.bitField0_ |= 0x40;
                this.s2CShenjian_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CShenjian() {
                this.bitField0_ &= 0xFFFFFFBF;
                this.s2CShenjian_ = 0;
                onChanged();
                return this;
            }

            private void ensureS2CBatttleListIsMutable() {
                if ((this.bitField0_ & 0x80) != 128) {
                    this.s2CBatttleList_ = new ArrayList<>(this.s2CBatttleList_);
                    this.bitField0_ |= 0x80;
                }
            }

            public List<SoloHandler.BattleRecord> getS2CBatttleListList() {
                if (this.s2CBatttleListBuilder_ == null)
                    return Collections.unmodifiableList(this.s2CBatttleList_);
                return this.s2CBatttleListBuilder_.getMessageList();
            }

            public int getS2CBatttleListCount() {
                if (this.s2CBatttleListBuilder_ == null)
                    return this.s2CBatttleList_.size();
                return this.s2CBatttleListBuilder_.getCount();
            }

            public SoloHandler.BattleRecord getS2CBatttleList(int index) {
                if (this.s2CBatttleListBuilder_ == null)
                    return this.s2CBatttleList_.get(index);
                return (SoloHandler.BattleRecord) this.s2CBatttleListBuilder_.getMessage(index);
            }

            public Builder setS2CBatttleList(int index, SoloHandler.BattleRecord value) {
                if (this.s2CBatttleListBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CBatttleListIsMutable();
                    this.s2CBatttleList_.set(index, value);
                    onChanged();
                } else {
                    this.s2CBatttleListBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setS2CBatttleList(int index, SoloHandler.BattleRecord.Builder builderForValue) {
                if (this.s2CBatttleListBuilder_ == null) {
                    ensureS2CBatttleListIsMutable();
                    this.s2CBatttleList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CBatttleListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addS2CBatttleList(SoloHandler.BattleRecord value) {
                if (this.s2CBatttleListBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CBatttleListIsMutable();
                    this.s2CBatttleList_.add(value);
                    onChanged();
                } else {
                    this.s2CBatttleListBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addS2CBatttleList(int index, SoloHandler.BattleRecord value) {
                if (this.s2CBatttleListBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CBatttleListIsMutable();
                    this.s2CBatttleList_.add(index, value);
                    onChanged();
                } else {
                    this.s2CBatttleListBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addS2CBatttleList(SoloHandler.BattleRecord.Builder builderForValue) {
                if (this.s2CBatttleListBuilder_ == null) {
                    ensureS2CBatttleListIsMutable();
                    this.s2CBatttleList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.s2CBatttleListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addS2CBatttleList(int index, SoloHandler.BattleRecord.Builder builderForValue) {
                if (this.s2CBatttleListBuilder_ == null) {
                    ensureS2CBatttleListIsMutable();
                    this.s2CBatttleList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CBatttleListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllS2CBatttleList(Iterable<? extends SoloHandler.BattleRecord> values) {
                if (this.s2CBatttleListBuilder_ == null) {
                    ensureS2CBatttleListIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.s2CBatttleList_);
                    onChanged();
                } else {
                    this.s2CBatttleListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearS2CBatttleList() {
                if (this.s2CBatttleListBuilder_ == null) {
                    this.s2CBatttleList_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFF7F;
                    onChanged();
                } else {
                    this.s2CBatttleListBuilder_.clear();
                }
                return this;
            }

            public Builder removeS2CBatttleList(int index) {
                if (this.s2CBatttleListBuilder_ == null) {
                    ensureS2CBatttleListIsMutable();
                    this.s2CBatttleList_.remove(index);
                    onChanged();
                } else {
                    this.s2CBatttleListBuilder_.remove(index);
                }
                return this;
            }

            public SoloHandler.BattleRecord.Builder getS2CBatttleListBuilder(int index) {
                return (SoloHandler.BattleRecord.Builder) getS2CBatttleListFieldBuilder().getBuilder(index);
            }

            public SoloHandler.BattleRecordOrBuilder getS2CBatttleListOrBuilder(int index) {
                if (this.s2CBatttleListBuilder_ == null)
                    return this.s2CBatttleList_.get(index);
                return (SoloHandler.BattleRecordOrBuilder) this.s2CBatttleListBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends SoloHandler.BattleRecordOrBuilder> getS2CBatttleListOrBuilderList() {
                if (this.s2CBatttleListBuilder_ != null)
                    return this.s2CBatttleListBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.s2CBatttleList_);
            }

            public SoloHandler.BattleRecord.Builder addS2CBatttleListBuilder() {
                return (SoloHandler.BattleRecord.Builder) getS2CBatttleListFieldBuilder().addBuilder(SoloHandler.BattleRecord.getDefaultInstance());
            }

            public SoloHandler.BattleRecord.Builder addS2CBatttleListBuilder(int index) {
                return (SoloHandler.BattleRecord.Builder) getS2CBatttleListFieldBuilder().addBuilder(index, SoloHandler.BattleRecord.getDefaultInstance());
            }

            public List<SoloHandler.BattleRecord.Builder> getS2CBatttleListBuilderList() {
                return getS2CBatttleListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<SoloHandler.BattleRecord, SoloHandler.BattleRecord.Builder, SoloHandler.BattleRecordOrBuilder> getS2CBatttleListFieldBuilder() {
                if (this.s2CBatttleListBuilder_ == null) {
                    this.s2CBatttleListBuilder_ = new RepeatedFieldBuilder(this.s2CBatttleList_, ((this.bitField0_ & 0x80) == 128), getParentForChildren(), isClean());
                    this.s2CBatttleList_ = null;
                }
                return this.s2CBatttleListBuilder_;
            }
        }
    }

    public static final class RewardInfoRequest extends GeneratedMessage implements RewardInfoRequestOrBuilder {
        private static final RewardInfoRequest defaultInstance = new RewardInfoRequest(true);
        private final UnknownFieldSet unknownFields;

        private RewardInfoRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private RewardInfoRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static RewardInfoRequest getDefaultInstance() {
            return defaultInstance;
        }

        public RewardInfoRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private RewardInfoRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return SoloHandler.internal_static_pomelo_area_RewardInfoRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return SoloHandler.internal_static_pomelo_area_RewardInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(RewardInfoRequest.class, Builder.class);
        }

        public static Parser<RewardInfoRequest> PARSER = (Parser<RewardInfoRequest>) new AbstractParser<RewardInfoRequest>() {
            public SoloHandler.RewardInfoRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SoloHandler.RewardInfoRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<RewardInfoRequest> getParserForType() {
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

        public static RewardInfoRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (RewardInfoRequest) PARSER.parseFrom(data);
        }

        public static RewardInfoRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (RewardInfoRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static RewardInfoRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (RewardInfoRequest) PARSER.parseFrom(data);
        }

        public static RewardInfoRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (RewardInfoRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static RewardInfoRequest parseFrom(InputStream input) throws IOException {
            return (RewardInfoRequest) PARSER.parseFrom(input);
        }

        public static RewardInfoRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RewardInfoRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static RewardInfoRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (RewardInfoRequest) PARSER.parseDelimitedFrom(input);
        }

        public static RewardInfoRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RewardInfoRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static RewardInfoRequest parseFrom(CodedInputStream input) throws IOException {
            return (RewardInfoRequest) PARSER.parseFrom(input);
        }

        public static RewardInfoRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RewardInfoRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(RewardInfoRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements SoloHandler.RewardInfoRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return SoloHandler.internal_static_pomelo_area_RewardInfoRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return SoloHandler.internal_static_pomelo_area_RewardInfoRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(SoloHandler.RewardInfoRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SoloHandler.RewardInfoRequest.alwaysUseFieldBuilders) ;
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
                return SoloHandler.internal_static_pomelo_area_RewardInfoRequest_descriptor;
            }

            public SoloHandler.RewardInfoRequest getDefaultInstanceForType() {
                return SoloHandler.RewardInfoRequest.getDefaultInstance();
            }

            public SoloHandler.RewardInfoRequest build() {
                SoloHandler.RewardInfoRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public SoloHandler.RewardInfoRequest buildPartial() {
                SoloHandler.RewardInfoRequest result = new SoloHandler.RewardInfoRequest(this);
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof SoloHandler.RewardInfoRequest)
                    return mergeFrom((SoloHandler.RewardInfoRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SoloHandler.RewardInfoRequest other) {
                if (other == SoloHandler.RewardInfoRequest.getDefaultInstance()) return this;
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                SoloHandler.RewardInfoRequest parsedMessage = null;
                try {
                    parsedMessage = (SoloHandler.RewardInfoRequest) SoloHandler.RewardInfoRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SoloHandler.RewardInfoRequest) e.getUnfinishedMessage();
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


    public static final class DailyRewardItem
            extends GeneratedMessage
            implements DailyRewardItemOrBuilder {
        private static final DailyRewardItem defaultInstance = new DailyRewardItem(true);
        private final UnknownFieldSet unknownFields;

        private DailyRewardItem(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private DailyRewardItem(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static DailyRewardItem getDefaultInstance() {
            return defaultInstance;
        }

        public DailyRewardItem getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DailyRewardItem(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.itemCode_ = bs;
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.itemNum_ = input.readInt32();
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
            return SoloHandler.internal_static_pomelo_area_DailyRewardItem_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return SoloHandler.internal_static_pomelo_area_DailyRewardItem_fieldAccessorTable.ensureFieldAccessorsInitialized(DailyRewardItem.class, Builder.class);
        }

        public static Parser<DailyRewardItem> PARSER = (Parser<DailyRewardItem>) new AbstractParser<DailyRewardItem>() {
            public SoloHandler.DailyRewardItem parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SoloHandler.DailyRewardItem(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int ITEMCODE_FIELD_NUMBER = 1;
        private Object itemCode_;
        public static final int ITEMNUM_FIELD_NUMBER = 2;
        private int itemNum_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<DailyRewardItem> getParserForType() {
            return PARSER;
        }

        public boolean hasItemCode() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public String getItemCode() {
            Object ref = this.itemCode_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.itemCode_ = s;
            return s;
        }

        public ByteString getItemCodeBytes() {
            Object ref = this.itemCode_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.itemCode_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasItemNum() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public int getItemNum() {
            return this.itemNum_;
        }

        private void initFields() {
            this.itemCode_ = "";
            this.itemNum_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasItemCode()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasItemNum()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeBytes(1, getItemCodeBytes());
            if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.itemNum_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeBytesSize(1, getItemCodeBytes());
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(2, this.itemNum_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static DailyRewardItem parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (DailyRewardItem) PARSER.parseFrom(data);
        }

        public static DailyRewardItem parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DailyRewardItem) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DailyRewardItem parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (DailyRewardItem) PARSER.parseFrom(data);
        }

        public static DailyRewardItem parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DailyRewardItem) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DailyRewardItem parseFrom(InputStream input) throws IOException {
            return (DailyRewardItem) PARSER.parseFrom(input);
        }

        public static DailyRewardItem parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DailyRewardItem) PARSER.parseFrom(input, extensionRegistry);
        }

        public static DailyRewardItem parseDelimitedFrom(InputStream input) throws IOException {
            return (DailyRewardItem) PARSER.parseDelimitedFrom(input);
        }

        public static DailyRewardItem parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DailyRewardItem) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static DailyRewardItem parseFrom(CodedInputStream input) throws IOException {
            return (DailyRewardItem) PARSER.parseFrom(input);
        }

        public static DailyRewardItem parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DailyRewardItem) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(DailyRewardItem prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements SoloHandler.DailyRewardItemOrBuilder {
            private int bitField0_;
            private Object itemCode_;
            private int itemNum_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SoloHandler.internal_static_pomelo_area_DailyRewardItem_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return SoloHandler.internal_static_pomelo_area_DailyRewardItem_fieldAccessorTable.ensureFieldAccessorsInitialized(SoloHandler.DailyRewardItem.class, Builder.class);
            }

            private Builder() {
                this.itemCode_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.itemCode_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SoloHandler.DailyRewardItem.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.itemCode_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                this.itemNum_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return SoloHandler.internal_static_pomelo_area_DailyRewardItem_descriptor;
            }

            public SoloHandler.DailyRewardItem getDefaultInstanceForType() {
                return SoloHandler.DailyRewardItem.getDefaultInstance();
            }

            public SoloHandler.DailyRewardItem build() {
                SoloHandler.DailyRewardItem result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public SoloHandler.DailyRewardItem buildPartial() {
                SoloHandler.DailyRewardItem result = new SoloHandler.DailyRewardItem(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.itemCode_ = this.itemCode_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.itemNum_ = this.itemNum_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof SoloHandler.DailyRewardItem) return mergeFrom((SoloHandler.DailyRewardItem) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SoloHandler.DailyRewardItem other) {
                if (other == SoloHandler.DailyRewardItem.getDefaultInstance()) return this;
                if (other.hasItemCode()) {
                    this.bitField0_ |= 0x1;
                    this.itemCode_ = other.itemCode_;
                    onChanged();
                }
                if (other.hasItemNum()) setItemNum(other.getItemNum());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasItemCode()) return false;
                if (!hasItemNum()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                SoloHandler.DailyRewardItem parsedMessage = null;
                try {
                    parsedMessage = (SoloHandler.DailyRewardItem) SoloHandler.DailyRewardItem.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SoloHandler.DailyRewardItem) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasItemCode() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public String getItemCode() {
                Object ref = this.itemCode_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) this.itemCode_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getItemCodeBytes() {
                Object ref = this.itemCode_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.itemCode_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setItemCode(String value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.itemCode_ = value;
                onChanged();
                return this;
            }

            public Builder clearItemCode() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.itemCode_ = SoloHandler.DailyRewardItem.getDefaultInstance().getItemCode();
                onChanged();
                return this;
            }

            public Builder setItemCodeBytes(ByteString value) {
                if (value == null) throw new NullPointerException();
                this.bitField0_ |= 0x1;
                this.itemCode_ = value;
                onChanged();
                return this;
            }

            public boolean hasItemNum() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getItemNum() {
                return this.itemNum_;
            }

            public Builder setItemNum(int value) {
                this.bitField0_ |= 0x2;
                this.itemNum_ = value;
                onChanged();
                return this;
            }

            public Builder clearItemNum() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.itemNum_ = 0;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class SoloDailyReward
            extends GeneratedMessage
            implements SoloDailyRewardOrBuilder {
        private final UnknownFieldSet unknownFields;


        private SoloDailyReward(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }


        private SoloDailyReward(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }


        public static SoloDailyReward getDefaultInstance() {
            return defaultInstance;
        }


        public SoloDailyReward getDefaultInstanceForType() {
            return defaultInstance;
        }


        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }


        private SoloDailyReward(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.rankId_ = input.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.status_ = input.readInt32();
                            break;
                        case 26:
                            if ((mutable_bitField0_ & 0x4) != 4) {
                                this.items_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x4;
                            }
                            this.items_.add(input.readMessage(SoloHandler.DailyRewardItem.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x4) == 4) {
                    this.items_ = Collections.unmodifiableList(this.items_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }


        public static final Descriptors.Descriptor getDescriptor() {
            return SoloHandler.internal_static_pomelo_area_SoloDailyReward_descriptor;
        }


        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return SoloHandler.internal_static_pomelo_area_SoloDailyReward_fieldAccessorTable.ensureFieldAccessorsInitialized(SoloDailyReward.class, Builder.class);
        }


        public static Parser<SoloDailyReward> PARSER = (Parser<SoloDailyReward>) new AbstractParser<SoloDailyReward>() {
            public SoloHandler.SoloDailyReward parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SoloHandler.SoloDailyReward(input, extensionRegistry);
            }
        };


        private int bitField0_;


        public static final int RANKID_FIELD_NUMBER = 1;


        private int rankId_;


        public static final int STATUS_FIELD_NUMBER = 2;


        private int status_;


        public static final int ITEMS_FIELD_NUMBER = 3;


        private List<SoloHandler.DailyRewardItem> items_;


        private byte memoizedIsInitialized;


        private int memoizedSerializedSize;


        private static final long serialVersionUID = 0L;


        public Parser<SoloDailyReward> getParserForType() {
            return PARSER;
        }


        public boolean hasRankId() {
            return ((this.bitField0_ & 0x1) == 1);
        }


        public int getRankId() {
            return this.rankId_;
        }


        public boolean hasStatus() {
            return ((this.bitField0_ & 0x2) == 2);
        }


        public int getStatus() {
            return this.status_;
        }


        public List<SoloHandler.DailyRewardItem> getItemsList() {
            return this.items_;
        }


        public List<? extends SoloHandler.DailyRewardItemOrBuilder> getItemsOrBuilderList() {
            return (List) this.items_;
        }


        public int getItemsCount() {
            return this.items_.size();
        }


        public SoloHandler.DailyRewardItem getItems(int index) {
            return this.items_.get(index);
        }


        public SoloHandler.DailyRewardItemOrBuilder getItemsOrBuilder(int index) {
            return this.items_.get(index);
        }


        private void initFields() {
            this.rankId_ = 0;
            this.status_ = 0;
            this.items_ = Collections.emptyList();
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasRankId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasStatus()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (int i = 0; i < getItemsCount(); i++) {
                if (!getItems(i).isInitialized()) {
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
                output.writeInt32(1, this.rankId_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeInt32(2, this.status_);
            }
            for (int i = 0; i < this.items_.size(); i++) {
                output.writeMessage(3, (MessageLite) this.items_.get(i));
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
                size += CodedOutputStream.computeInt32Size(1, this.rankId_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeInt32Size(2, this.status_);
            }
            for (int i = 0; i < this.items_.size(); i++) {
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.items_.get(i));
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static SoloDailyReward parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (SoloDailyReward) PARSER.parseFrom(data);
        }


        public static SoloDailyReward parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SoloDailyReward) PARSER.parseFrom(data, extensionRegistry);
        }


        public static SoloDailyReward parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (SoloDailyReward) PARSER.parseFrom(data);
        }


        public static SoloDailyReward parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SoloDailyReward) PARSER.parseFrom(data, extensionRegistry);
        }


        private static final SoloDailyReward defaultInstance = new SoloDailyReward(true);

        public static SoloDailyReward parseFrom(InputStream input) throws IOException {
            return (SoloDailyReward) PARSER.parseFrom(input);
        }

        public static SoloDailyReward parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SoloDailyReward) PARSER.parseFrom(input, extensionRegistry);
        }

        public static SoloDailyReward parseDelimitedFrom(InputStream input) throws IOException {
            return (SoloDailyReward) PARSER.parseDelimitedFrom(input);
        }

        public static SoloDailyReward parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SoloDailyReward) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static SoloDailyReward parseFrom(CodedInputStream input) throws IOException {
            return (SoloDailyReward) PARSER.parseFrom(input);
        }

        public static SoloDailyReward parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SoloDailyReward) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(SoloDailyReward prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements SoloHandler.SoloDailyRewardOrBuilder {
            private int bitField0_;
            private int rankId_;
            private int status_;
            private List<SoloHandler.DailyRewardItem> items_;
            private RepeatedFieldBuilder<SoloHandler.DailyRewardItem, SoloHandler.DailyRewardItem.Builder, SoloHandler.DailyRewardItemOrBuilder> itemsBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SoloHandler.internal_static_pomelo_area_SoloDailyReward_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return SoloHandler.internal_static_pomelo_area_SoloDailyReward_fieldAccessorTable.ensureFieldAccessorsInitialized(SoloHandler.SoloDailyReward.class, Builder.class);
            }

            private Builder() {
                this.items_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.items_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SoloHandler.SoloDailyReward.alwaysUseFieldBuilders) getItemsFieldBuilder();
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.rankId_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.status_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                if (this.itemsBuilder_ == null) {
                    this.items_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                } else {
                    this.itemsBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return SoloHandler.internal_static_pomelo_area_SoloDailyReward_descriptor;
            }

            public SoloHandler.SoloDailyReward getDefaultInstanceForType() {
                return SoloHandler.SoloDailyReward.getDefaultInstance();
            }

            public SoloHandler.SoloDailyReward build() {
                SoloHandler.SoloDailyReward result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public SoloHandler.SoloDailyReward buildPartial() {
                SoloHandler.SoloDailyReward result = new SoloHandler.SoloDailyReward(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.rankId_ = this.rankId_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.status_ = this.status_;
                if (this.itemsBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4) {
                        this.items_ = Collections.unmodifiableList(this.items_);
                        this.bitField0_ &= 0xFFFFFFFB;
                    }
                    result.items_ = this.items_;
                } else {
                    result.items_ = this.itemsBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof SoloHandler.SoloDailyReward) return mergeFrom((SoloHandler.SoloDailyReward) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SoloHandler.SoloDailyReward other) {
                if (other == SoloHandler.SoloDailyReward.getDefaultInstance()) return this;
                if (other.hasRankId()) setRankId(other.getRankId());
                if (other.hasStatus()) setStatus(other.getStatus());
                if (this.itemsBuilder_ == null) {
                    if (!other.items_.isEmpty()) {
                        if (this.items_.isEmpty()) {
                            this.items_ = other.items_;
                            this.bitField0_ &= 0xFFFFFFFB;
                        } else {
                            ensureItemsIsMutable();
                            this.items_.addAll(other.items_);
                        }
                        onChanged();
                    }
                } else if (!other.items_.isEmpty()) {
                    if (this.itemsBuilder_.isEmpty()) {
                        this.itemsBuilder_.dispose();
                        this.itemsBuilder_ = null;
                        this.items_ = other.items_;
                        this.bitField0_ &= 0xFFFFFFFB;
                        this.itemsBuilder_ = SoloHandler.SoloDailyReward.alwaysUseFieldBuilders ? getItemsFieldBuilder() : null;
                    } else {
                        this.itemsBuilder_.addAllMessages(other.items_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasRankId()) return false;
                if (!hasStatus()) return false;
                for (int i = 0; i < getItemsCount(); i++) {
                    if (!getItems(i).isInitialized()) return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                SoloHandler.SoloDailyReward parsedMessage = null;
                try {
                    parsedMessage = (SoloHandler.SoloDailyReward) SoloHandler.SoloDailyReward.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SoloHandler.SoloDailyReward) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasRankId() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getRankId() {
                return this.rankId_;
            }

            public Builder setRankId(int value) {
                this.bitField0_ |= 0x1;
                this.rankId_ = value;
                onChanged();
                return this;
            }

            public Builder clearRankId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.rankId_ = 0;
                onChanged();
                return this;
            }

            public boolean hasStatus() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getStatus() {
                return this.status_;
            }

            public Builder setStatus(int value) {
                this.bitField0_ |= 0x2;
                this.status_ = value;
                onChanged();
                return this;
            }

            public Builder clearStatus() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.status_ = 0;
                onChanged();
                return this;
            }

            private void ensureItemsIsMutable() {
                if ((this.bitField0_ & 0x4) != 4) {
                    this.items_ = new ArrayList<>(this.items_);
                    this.bitField0_ |= 0x4;
                }
            }

            public List<SoloHandler.DailyRewardItem> getItemsList() {
                if (this.itemsBuilder_ == null) return Collections.unmodifiableList(this.items_);
                return this.itemsBuilder_.getMessageList();
            }

            public int getItemsCount() {
                if (this.itemsBuilder_ == null) return this.items_.size();
                return this.itemsBuilder_.getCount();
            }

            public SoloHandler.DailyRewardItem getItems(int index) {
                if (this.itemsBuilder_ == null) return this.items_.get(index);
                return (SoloHandler.DailyRewardItem) this.itemsBuilder_.getMessage(index);
            }

            public Builder setItems(int index, SoloHandler.DailyRewardItem value) {
                if (this.itemsBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureItemsIsMutable();
                    this.items_.set(index, value);
                    onChanged();
                } else {
                    this.itemsBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setItems(int index, SoloHandler.DailyRewardItem.Builder builderForValue) {
                if (this.itemsBuilder_ == null) {
                    ensureItemsIsMutable();
                    this.items_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.itemsBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addItems(SoloHandler.DailyRewardItem value) {
                if (this.itemsBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureItemsIsMutable();
                    this.items_.add(value);
                    onChanged();
                } else {
                    this.itemsBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addItems(int index, SoloHandler.DailyRewardItem value) {
                if (this.itemsBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    ensureItemsIsMutable();
                    this.items_.add(index, value);
                    onChanged();
                } else {
                    this.itemsBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addItems(SoloHandler.DailyRewardItem.Builder builderForValue) {
                if (this.itemsBuilder_ == null) {
                    ensureItemsIsMutable();
                    this.items_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.itemsBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addItems(int index, SoloHandler.DailyRewardItem.Builder builderForValue) {
                if (this.itemsBuilder_ == null) {
                    ensureItemsIsMutable();
                    this.items_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.itemsBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllItems(Iterable<? extends SoloHandler.DailyRewardItem> values) {
                if (this.itemsBuilder_ == null) {
                    ensureItemsIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.items_);
                    onChanged();
                } else {
                    this.itemsBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearItems() {
                if (this.itemsBuilder_ == null) {
                    this.items_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                    onChanged();
                } else {
                    this.itemsBuilder_.clear();
                }
                return this;
            }

            public Builder removeItems(int index) {
                if (this.itemsBuilder_ == null) {
                    ensureItemsIsMutable();
                    this.items_.remove(index);
                    onChanged();
                } else {
                    this.itemsBuilder_.remove(index);
                }
                return this;
            }

            public SoloHandler.DailyRewardItem.Builder getItemsBuilder(int index) {
                return (SoloHandler.DailyRewardItem.Builder) getItemsFieldBuilder().getBuilder(index);
            }

            public SoloHandler.DailyRewardItemOrBuilder getItemsOrBuilder(int index) {
                if (this.itemsBuilder_ == null) return this.items_.get(index);
                return (SoloHandler.DailyRewardItemOrBuilder) this.itemsBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends SoloHandler.DailyRewardItemOrBuilder> getItemsOrBuilderList() {
                if (this.itemsBuilder_ != null) return this.itemsBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.items_);
            }

            public SoloHandler.DailyRewardItem.Builder addItemsBuilder() {
                return (SoloHandler.DailyRewardItem.Builder) getItemsFieldBuilder().addBuilder(SoloHandler.DailyRewardItem.getDefaultInstance());
            }

            public SoloHandler.DailyRewardItem.Builder addItemsBuilder(int index) {
                return (SoloHandler.DailyRewardItem.Builder) getItemsFieldBuilder().addBuilder(index, SoloHandler.DailyRewardItem.getDefaultInstance());
            }

            public List<SoloHandler.DailyRewardItem.Builder> getItemsBuilderList() {
                return getItemsFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<SoloHandler.DailyRewardItem, SoloHandler.DailyRewardItem.Builder, SoloHandler.DailyRewardItemOrBuilder> getItemsFieldBuilder() {
                if (this.itemsBuilder_ == null) {
                    this.itemsBuilder_ = new RepeatedFieldBuilder(this.items_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
                    this.items_ = null;
                }
                return this.itemsBuilder_;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class RewardInfoResponse
            extends GeneratedMessage
            implements RewardInfoResponseOrBuilder {
        private static final RewardInfoResponse defaultInstance = new RewardInfoResponse(true);
        private final UnknownFieldSet unknownFields;

        private RewardInfoResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private RewardInfoResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static RewardInfoResponse getDefaultInstance() {
            return defaultInstance;
        }

        public RewardInfoResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private RewardInfoResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.s2CRankRewards_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x4;
                            }
                            this.s2CRankRewards_.add(input.readMessage(SoloHandler.RankReward.PARSER, extensionRegistry));
                            break;
                        case 32:
                            this.bitField0_ |= 0x4;
                            this.s2CCurrRank_ = input.readInt32();
                            break;
                        case 42:
                            if ((mutable_bitField0_ & 0x10) != 16) {
                                this.s2CDailyRewards_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x10;
                            }
                            this.s2CDailyRewards_.add(input.readMessage(SoloHandler.SoloDailyReward.PARSER, extensionRegistry));
                            break;
                        case 48:
                            this.bitField0_ |= 0x8;
                            this.s2CDailyBattleTimes_ = input.readInt32();
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x4) == 4)
                    this.s2CRankRewards_ = Collections.unmodifiableList(this.s2CRankRewards_);
                if ((mutable_bitField0_ & 0x10) == 16)
                    this.s2CDailyRewards_ = Collections.unmodifiableList(this.s2CDailyRewards_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SoloHandler.internal_static_pomelo_area_RewardInfoResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return SoloHandler.internal_static_pomelo_area_RewardInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(RewardInfoResponse.class, Builder.class);
        }

        public static Parser<RewardInfoResponse> PARSER = (Parser<RewardInfoResponse>) new AbstractParser<RewardInfoResponse>() {
            public SoloHandler.RewardInfoResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SoloHandler.RewardInfoResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_RANKREWARDS_FIELD_NUMBER = 3;
        private List<SoloHandler.RankReward> s2CRankRewards_;
        public static final int S2C_CURRRANK_FIELD_NUMBER = 4;
        private int s2CCurrRank_;
        public static final int S2C_DAILYREWARDS_FIELD_NUMBER = 5;
        private List<SoloHandler.SoloDailyReward> s2CDailyRewards_;
        public static final int S2C_DAILYBATTLETIMES_FIELD_NUMBER = 6;
        private int s2CDailyBattleTimes_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<RewardInfoResponse> getParserForType() {
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

        public List<SoloHandler.RankReward> getS2CRankRewardsList() {
            return this.s2CRankRewards_;
        }

        static {
            defaultInstance.initFields();
        }

        public List<? extends SoloHandler.RankRewardOrBuilder> getS2CRankRewardsOrBuilderList() {
            return (List) this.s2CRankRewards_;
        }

        public int getS2CRankRewardsCount() {
            return this.s2CRankRewards_.size();
        }

        public SoloHandler.RankReward getS2CRankRewards(int index) {
            return this.s2CRankRewards_.get(index);
        }

        public SoloHandler.RankRewardOrBuilder getS2CRankRewardsOrBuilder(int index) {
            return this.s2CRankRewards_.get(index);
        }

        public boolean hasS2CCurrRank() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getS2CCurrRank() {
            return this.s2CCurrRank_;
        }

        public List<SoloHandler.SoloDailyReward> getS2CDailyRewardsList() {
            return this.s2CDailyRewards_;
        }

        public List<? extends SoloHandler.SoloDailyRewardOrBuilder> getS2CDailyRewardsOrBuilderList() {
            return (List) this.s2CDailyRewards_;
        }

        public int getS2CDailyRewardsCount() {
            return this.s2CDailyRewards_.size();
        }

        public SoloHandler.SoloDailyReward getS2CDailyRewards(int index) {
            return this.s2CDailyRewards_.get(index);
        }

        public SoloHandler.SoloDailyRewardOrBuilder getS2CDailyRewardsOrBuilder(int index) {
            return this.s2CDailyRewards_.get(index);
        }

        public boolean hasS2CDailyBattleTimes() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public int getS2CDailyBattleTimes() {
            return this.s2CDailyBattleTimes_;
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CRankRewards_ = Collections.emptyList();
            this.s2CCurrRank_ = 0;
            this.s2CDailyRewards_ = Collections.emptyList();
            this.s2CDailyBattleTimes_ = 0;
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
            int i;
            for (i = 0; i < getS2CRankRewardsCount(); i++) {
                if (!getS2CRankRewards(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (i = 0; i < getS2CDailyRewardsCount(); i++) {
                if (!getS2CDailyRewards(i).isInitialized()) {
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
            int i;
            for (i = 0; i < this.s2CRankRewards_.size(); i++)
                output.writeMessage(3, (MessageLite) this.s2CRankRewards_.get(i));
            if ((this.bitField0_ & 0x4) == 4)
                output.writeInt32(4, this.s2CCurrRank_);
            for (i = 0; i < this.s2CDailyRewards_.size(); i++)
                output.writeMessage(5, (MessageLite) this.s2CDailyRewards_.get(i));
            if ((this.bitField0_ & 0x8) == 8)
                output.writeInt32(6, this.s2CDailyBattleTimes_);
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
            for (i = 0; i < this.s2CRankRewards_.size(); i++)
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.s2CRankRewards_.get(i));
            if ((this.bitField0_ & 0x4) == 4)
                size += CodedOutputStream.computeInt32Size(4, this.s2CCurrRank_);
            for (i = 0; i < this.s2CDailyRewards_.size(); i++)
                size += CodedOutputStream.computeMessageSize(5, (MessageLite) this.s2CDailyRewards_.get(i));
            if ((this.bitField0_ & 0x8) == 8)
                size += CodedOutputStream.computeInt32Size(6, this.s2CDailyBattleTimes_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static RewardInfoResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (RewardInfoResponse) PARSER.parseFrom(data);
        }

        public static RewardInfoResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (RewardInfoResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static RewardInfoResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (RewardInfoResponse) PARSER.parseFrom(data);
        }

        public static RewardInfoResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (RewardInfoResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static RewardInfoResponse parseFrom(InputStream input) throws IOException {
            return (RewardInfoResponse) PARSER.parseFrom(input);
        }

        public static RewardInfoResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RewardInfoResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static RewardInfoResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (RewardInfoResponse) PARSER.parseDelimitedFrom(input);
        }

        public static RewardInfoResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RewardInfoResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static RewardInfoResponse parseFrom(CodedInputStream input) throws IOException {
            return (RewardInfoResponse) PARSER.parseFrom(input);
        }

        public static RewardInfoResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RewardInfoResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(RewardInfoResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements SoloHandler.RewardInfoResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private List<SoloHandler.RankReward> s2CRankRewards_;
            private RepeatedFieldBuilder<SoloHandler.RankReward, SoloHandler.RankReward.Builder, SoloHandler.RankRewardOrBuilder> s2CRankRewardsBuilder_;
            private int s2CCurrRank_;
            private List<SoloHandler.SoloDailyReward> s2CDailyRewards_;
            private RepeatedFieldBuilder<SoloHandler.SoloDailyReward, SoloHandler.SoloDailyReward.Builder, SoloHandler.SoloDailyRewardOrBuilder> s2CDailyRewardsBuilder_;
            private int s2CDailyBattleTimes_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SoloHandler.internal_static_pomelo_area_RewardInfoResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return SoloHandler.internal_static_pomelo_area_RewardInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(SoloHandler.RewardInfoResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.s2CRankRewards_ = Collections.emptyList();
                this.s2CDailyRewards_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CRankRewards_ = Collections.emptyList();
                this.s2CDailyRewards_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SoloHandler.RewardInfoResponse.alwaysUseFieldBuilders) {
                    getS2CRankRewardsFieldBuilder();
                    getS2CDailyRewardsFieldBuilder();
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
                if (this.s2CRankRewardsBuilder_ == null) {
                    this.s2CRankRewards_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                } else {
                    this.s2CRankRewardsBuilder_.clear();
                }
                this.s2CCurrRank_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                if (this.s2CDailyRewardsBuilder_ == null) {
                    this.s2CDailyRewards_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFEF;
                } else {
                    this.s2CDailyRewardsBuilder_.clear();
                }
                this.s2CDailyBattleTimes_ = 0;
                this.bitField0_ &= 0xFFFFFFDF;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return SoloHandler.internal_static_pomelo_area_RewardInfoResponse_descriptor;
            }

            public SoloHandler.RewardInfoResponse getDefaultInstanceForType() {
                return SoloHandler.RewardInfoResponse.getDefaultInstance();
            }

            public SoloHandler.RewardInfoResponse build() {
                SoloHandler.RewardInfoResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public SoloHandler.RewardInfoResponse buildPartial() {
                SoloHandler.RewardInfoResponse result = new SoloHandler.RewardInfoResponse(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.s2CMsg_ = this.s2CMsg_;
                if (this.s2CRankRewardsBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4) {
                        this.s2CRankRewards_ = Collections.unmodifiableList(this.s2CRankRewards_);
                        this.bitField0_ &= 0xFFFFFFFB;
                    }
                    result.s2CRankRewards_ = this.s2CRankRewards_;
                } else {
                    result.s2CRankRewards_ = this.s2CRankRewardsBuilder_.build();
                }
                if ((from_bitField0_ & 0x8) == 8)
                    to_bitField0_ |= 0x4;
                result.s2CCurrRank_ = this.s2CCurrRank_;
                if (this.s2CDailyRewardsBuilder_ == null) {
                    if ((this.bitField0_ & 0x10) == 16) {
                        this.s2CDailyRewards_ = Collections.unmodifiableList(this.s2CDailyRewards_);
                        this.bitField0_ &= 0xFFFFFFEF;
                    }
                    result.s2CDailyRewards_ = this.s2CDailyRewards_;
                } else {
                    result.s2CDailyRewards_ = this.s2CDailyRewardsBuilder_.build();
                }
                if ((from_bitField0_ & 0x20) == 32)
                    to_bitField0_ |= 0x8;
                result.s2CDailyBattleTimes_ = this.s2CDailyBattleTimes_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof SoloHandler.RewardInfoResponse)
                    return mergeFrom((SoloHandler.RewardInfoResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SoloHandler.RewardInfoResponse other) {
                if (other == SoloHandler.RewardInfoResponse.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (this.s2CRankRewardsBuilder_ == null) {
                    if (!other.s2CRankRewards_.isEmpty()) {
                        if (this.s2CRankRewards_.isEmpty()) {
                            this.s2CRankRewards_ = other.s2CRankRewards_;
                            this.bitField0_ &= 0xFFFFFFFB;
                        } else {
                            ensureS2CRankRewardsIsMutable();
                            this.s2CRankRewards_.addAll(other.s2CRankRewards_);
                        }
                        onChanged();
                    }
                } else if (!other.s2CRankRewards_.isEmpty()) {
                    if (this.s2CRankRewardsBuilder_.isEmpty()) {
                        this.s2CRankRewardsBuilder_.dispose();
                        this.s2CRankRewardsBuilder_ = null;
                        this.s2CRankRewards_ = other.s2CRankRewards_;
                        this.bitField0_ &= 0xFFFFFFFB;
                        this.s2CRankRewardsBuilder_ = SoloHandler.RewardInfoResponse.alwaysUseFieldBuilders ? getS2CRankRewardsFieldBuilder() : null;
                    } else {
                        this.s2CRankRewardsBuilder_.addAllMessages(other.s2CRankRewards_);
                    }
                }
                if (other.hasS2CCurrRank())
                    setS2CCurrRank(other.getS2CCurrRank());
                if (this.s2CDailyRewardsBuilder_ == null) {
                    if (!other.s2CDailyRewards_.isEmpty()) {
                        if (this.s2CDailyRewards_.isEmpty()) {
                            this.s2CDailyRewards_ = other.s2CDailyRewards_;
                            this.bitField0_ &= 0xFFFFFFEF;
                        } else {
                            ensureS2CDailyRewardsIsMutable();
                            this.s2CDailyRewards_.addAll(other.s2CDailyRewards_);
                        }
                        onChanged();
                    }
                } else if (!other.s2CDailyRewards_.isEmpty()) {
                    if (this.s2CDailyRewardsBuilder_.isEmpty()) {
                        this.s2CDailyRewardsBuilder_.dispose();
                        this.s2CDailyRewardsBuilder_ = null;
                        this.s2CDailyRewards_ = other.s2CDailyRewards_;
                        this.bitField0_ &= 0xFFFFFFEF;
                        this.s2CDailyRewardsBuilder_ = SoloHandler.RewardInfoResponse.alwaysUseFieldBuilders ? getS2CDailyRewardsFieldBuilder() : null;
                    } else {
                        this.s2CDailyRewardsBuilder_.addAllMessages(other.s2CDailyRewards_);
                    }
                }
                if (other.hasS2CDailyBattleTimes())
                    setS2CDailyBattleTimes(other.getS2CDailyBattleTimes());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode())
                    return false;
                int i;
                for (i = 0; i < getS2CRankRewardsCount(); i++) {
                    if (!getS2CRankRewards(i).isInitialized())
                        return false;
                }
                for (i = 0; i < getS2CDailyRewardsCount(); i++) {
                    if (!getS2CDailyRewards(i).isInitialized())
                        return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                SoloHandler.RewardInfoResponse parsedMessage = null;
                try {
                    parsedMessage = (SoloHandler.RewardInfoResponse) SoloHandler.RewardInfoResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SoloHandler.RewardInfoResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = SoloHandler.RewardInfoResponse.getDefaultInstance().getS2CMsg();
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

            private void ensureS2CRankRewardsIsMutable() {
                if ((this.bitField0_ & 0x4) != 4) {
                    this.s2CRankRewards_ = new ArrayList<>(this.s2CRankRewards_);
                    this.bitField0_ |= 0x4;
                }
            }

            public List<SoloHandler.RankReward> getS2CRankRewardsList() {
                if (this.s2CRankRewardsBuilder_ == null)
                    return Collections.unmodifiableList(this.s2CRankRewards_);
                return this.s2CRankRewardsBuilder_.getMessageList();
            }

            public int getS2CRankRewardsCount() {
                if (this.s2CRankRewardsBuilder_ == null)
                    return this.s2CRankRewards_.size();
                return this.s2CRankRewardsBuilder_.getCount();
            }

            public SoloHandler.RankReward getS2CRankRewards(int index) {
                if (this.s2CRankRewardsBuilder_ == null)
                    return this.s2CRankRewards_.get(index);
                return (SoloHandler.RankReward) this.s2CRankRewardsBuilder_.getMessage(index);
            }

            public Builder setS2CRankRewards(int index, SoloHandler.RankReward value) {
                if (this.s2CRankRewardsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CRankRewardsIsMutable();
                    this.s2CRankRewards_.set(index, value);
                    onChanged();
                } else {
                    this.s2CRankRewardsBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setS2CRankRewards(int index, SoloHandler.RankReward.Builder builderForValue) {
                if (this.s2CRankRewardsBuilder_ == null) {
                    ensureS2CRankRewardsIsMutable();
                    this.s2CRankRewards_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CRankRewardsBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addS2CRankRewards(SoloHandler.RankReward value) {
                if (this.s2CRankRewardsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CRankRewardsIsMutable();
                    this.s2CRankRewards_.add(value);
                    onChanged();
                } else {
                    this.s2CRankRewardsBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addS2CRankRewards(int index, SoloHandler.RankReward value) {
                if (this.s2CRankRewardsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CRankRewardsIsMutable();
                    this.s2CRankRewards_.add(index, value);
                    onChanged();
                } else {
                    this.s2CRankRewardsBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addS2CRankRewards(SoloHandler.RankReward.Builder builderForValue) {
                if (this.s2CRankRewardsBuilder_ == null) {
                    ensureS2CRankRewardsIsMutable();
                    this.s2CRankRewards_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.s2CRankRewardsBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addS2CRankRewards(int index, SoloHandler.RankReward.Builder builderForValue) {
                if (this.s2CRankRewardsBuilder_ == null) {
                    ensureS2CRankRewardsIsMutable();
                    this.s2CRankRewards_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CRankRewardsBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllS2CRankRewards(Iterable<? extends SoloHandler.RankReward> values) {
                if (this.s2CRankRewardsBuilder_ == null) {
                    ensureS2CRankRewardsIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.s2CRankRewards_);
                    onChanged();
                } else {
                    this.s2CRankRewardsBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearS2CRankRewards() {
                if (this.s2CRankRewardsBuilder_ == null) {
                    this.s2CRankRewards_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                    onChanged();
                } else {
                    this.s2CRankRewardsBuilder_.clear();
                }
                return this;
            }

            public Builder removeS2CRankRewards(int index) {
                if (this.s2CRankRewardsBuilder_ == null) {
                    ensureS2CRankRewardsIsMutable();
                    this.s2CRankRewards_.remove(index);
                    onChanged();
                } else {
                    this.s2CRankRewardsBuilder_.remove(index);
                }
                return this;
            }

            public SoloHandler.RankReward.Builder getS2CRankRewardsBuilder(int index) {
                return (SoloHandler.RankReward.Builder) getS2CRankRewardsFieldBuilder().getBuilder(index);
            }

            public SoloHandler.RankRewardOrBuilder getS2CRankRewardsOrBuilder(int index) {
                if (this.s2CRankRewardsBuilder_ == null)
                    return this.s2CRankRewards_.get(index);
                return (SoloHandler.RankRewardOrBuilder) this.s2CRankRewardsBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends SoloHandler.RankRewardOrBuilder> getS2CRankRewardsOrBuilderList() {
                if (this.s2CRankRewardsBuilder_ != null)
                    return this.s2CRankRewardsBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.s2CRankRewards_);
            }

            public SoloHandler.RankReward.Builder addS2CRankRewardsBuilder() {
                return (SoloHandler.RankReward.Builder) getS2CRankRewardsFieldBuilder().addBuilder(SoloHandler.RankReward.getDefaultInstance());
            }

            public SoloHandler.RankReward.Builder addS2CRankRewardsBuilder(int index) {
                return (SoloHandler.RankReward.Builder) getS2CRankRewardsFieldBuilder().addBuilder(index, SoloHandler.RankReward.getDefaultInstance());
            }

            public List<SoloHandler.RankReward.Builder> getS2CRankRewardsBuilderList() {
                return getS2CRankRewardsFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<SoloHandler.RankReward, SoloHandler.RankReward.Builder, SoloHandler.RankRewardOrBuilder> getS2CRankRewardsFieldBuilder() {
                if (this.s2CRankRewardsBuilder_ == null) {
                    this.s2CRankRewardsBuilder_ = new RepeatedFieldBuilder(this.s2CRankRewards_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
                    this.s2CRankRewards_ = null;
                }
                return this.s2CRankRewardsBuilder_;
            }

            public boolean hasS2CCurrRank() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public int getS2CCurrRank() {
                return this.s2CCurrRank_;
            }

            public Builder setS2CCurrRank(int value) {
                this.bitField0_ |= 0x8;
                this.s2CCurrRank_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CCurrRank() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.s2CCurrRank_ = 0;
                onChanged();
                return this;
            }

            private void ensureS2CDailyRewardsIsMutable() {
                if ((this.bitField0_ & 0x10) != 16) {
                    this.s2CDailyRewards_ = new ArrayList<>(this.s2CDailyRewards_);
                    this.bitField0_ |= 0x10;
                }
            }

            public List<SoloHandler.SoloDailyReward> getS2CDailyRewardsList() {
                if (this.s2CDailyRewardsBuilder_ == null)
                    return Collections.unmodifiableList(this.s2CDailyRewards_);
                return this.s2CDailyRewardsBuilder_.getMessageList();
            }

            public int getS2CDailyRewardsCount() {
                if (this.s2CDailyRewardsBuilder_ == null)
                    return this.s2CDailyRewards_.size();
                return this.s2CDailyRewardsBuilder_.getCount();
            }

            public SoloHandler.SoloDailyReward getS2CDailyRewards(int index) {
                if (this.s2CDailyRewardsBuilder_ == null)
                    return this.s2CDailyRewards_.get(index);
                return (SoloHandler.SoloDailyReward) this.s2CDailyRewardsBuilder_.getMessage(index);
            }

            public Builder setS2CDailyRewards(int index, SoloHandler.SoloDailyReward value) {
                if (this.s2CDailyRewardsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CDailyRewardsIsMutable();
                    this.s2CDailyRewards_.set(index, value);
                    onChanged();
                } else {
                    this.s2CDailyRewardsBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setS2CDailyRewards(int index, SoloHandler.SoloDailyReward.Builder builderForValue) {
                if (this.s2CDailyRewardsBuilder_ == null) {
                    ensureS2CDailyRewardsIsMutable();
                    this.s2CDailyRewards_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CDailyRewardsBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addS2CDailyRewards(SoloHandler.SoloDailyReward value) {
                if (this.s2CDailyRewardsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CDailyRewardsIsMutable();
                    this.s2CDailyRewards_.add(value);
                    onChanged();
                } else {
                    this.s2CDailyRewardsBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addS2CDailyRewards(int index, SoloHandler.SoloDailyReward value) {
                if (this.s2CDailyRewardsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CDailyRewardsIsMutable();
                    this.s2CDailyRewards_.add(index, value);
                    onChanged();
                } else {
                    this.s2CDailyRewardsBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addS2CDailyRewards(SoloHandler.SoloDailyReward.Builder builderForValue) {
                if (this.s2CDailyRewardsBuilder_ == null) {
                    ensureS2CDailyRewardsIsMutable();
                    this.s2CDailyRewards_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.s2CDailyRewardsBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addS2CDailyRewards(int index, SoloHandler.SoloDailyReward.Builder builderForValue) {
                if (this.s2CDailyRewardsBuilder_ == null) {
                    ensureS2CDailyRewardsIsMutable();
                    this.s2CDailyRewards_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CDailyRewardsBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllS2CDailyRewards(Iterable<? extends SoloHandler.SoloDailyReward> values) {
                if (this.s2CDailyRewardsBuilder_ == null) {
                    ensureS2CDailyRewardsIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.s2CDailyRewards_);
                    onChanged();
                } else {
                    this.s2CDailyRewardsBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearS2CDailyRewards() {
                if (this.s2CDailyRewardsBuilder_ == null) {
                    this.s2CDailyRewards_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFEF;
                    onChanged();
                } else {
                    this.s2CDailyRewardsBuilder_.clear();
                }
                return this;
            }

            public Builder removeS2CDailyRewards(int index) {
                if (this.s2CDailyRewardsBuilder_ == null) {
                    ensureS2CDailyRewardsIsMutable();
                    this.s2CDailyRewards_.remove(index);
                    onChanged();
                } else {
                    this.s2CDailyRewardsBuilder_.remove(index);
                }
                return this;
            }

            public SoloHandler.SoloDailyReward.Builder getS2CDailyRewardsBuilder(int index) {
                return (SoloHandler.SoloDailyReward.Builder) getS2CDailyRewardsFieldBuilder().getBuilder(index);
            }

            public SoloHandler.SoloDailyRewardOrBuilder getS2CDailyRewardsOrBuilder(int index) {
                if (this.s2CDailyRewardsBuilder_ == null)
                    return this.s2CDailyRewards_.get(index);
                return (SoloHandler.SoloDailyRewardOrBuilder) this.s2CDailyRewardsBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends SoloHandler.SoloDailyRewardOrBuilder> getS2CDailyRewardsOrBuilderList() {
                if (this.s2CDailyRewardsBuilder_ != null)
                    return this.s2CDailyRewardsBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.s2CDailyRewards_);
            }

            public SoloHandler.SoloDailyReward.Builder addS2CDailyRewardsBuilder() {
                return (SoloHandler.SoloDailyReward.Builder) getS2CDailyRewardsFieldBuilder().addBuilder(SoloHandler.SoloDailyReward.getDefaultInstance());
            }

            public SoloHandler.SoloDailyReward.Builder addS2CDailyRewardsBuilder(int index) {
                return (SoloHandler.SoloDailyReward.Builder) getS2CDailyRewardsFieldBuilder().addBuilder(index, SoloHandler.SoloDailyReward.getDefaultInstance());
            }

            public List<SoloHandler.SoloDailyReward.Builder> getS2CDailyRewardsBuilderList() {
                return getS2CDailyRewardsFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<SoloHandler.SoloDailyReward, SoloHandler.SoloDailyReward.Builder, SoloHandler.SoloDailyRewardOrBuilder> getS2CDailyRewardsFieldBuilder() {
                if (this.s2CDailyRewardsBuilder_ == null) {
                    this.s2CDailyRewardsBuilder_ = new RepeatedFieldBuilder(this.s2CDailyRewards_, ((this.bitField0_ & 0x10) == 16), getParentForChildren(), isClean());
                    this.s2CDailyRewards_ = null;
                }
                return this.s2CDailyRewardsBuilder_;
            }

            public boolean hasS2CDailyBattleTimes() {
                return ((this.bitField0_ & 0x20) == 32);
            }

            public int getS2CDailyBattleTimes() {
                return this.s2CDailyBattleTimes_;
            }

            public Builder setS2CDailyBattleTimes(int value) {
                this.bitField0_ |= 0x20;
                this.s2CDailyBattleTimes_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CDailyBattleTimes() {
                this.bitField0_ &= 0xFFFFFFDF;
                this.s2CDailyBattleTimes_ = 0;
                onChanged();
                return this;
            }
        }
    }

    public static final class DrawRankRewardRequest extends GeneratedMessage implements DrawRankRewardRequestOrBuilder {
        private static final DrawRankRewardRequest defaultInstance = new DrawRankRewardRequest(true);
        private final UnknownFieldSet unknownFields;

        private DrawRankRewardRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private DrawRankRewardRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static DrawRankRewardRequest getDefaultInstance() {
            return defaultInstance;
        }

        public DrawRankRewardRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DrawRankRewardRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.c2SRankId_ = input.readInt32();
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
            return SoloHandler.internal_static_pomelo_area_DrawRankRewardRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return SoloHandler.internal_static_pomelo_area_DrawRankRewardRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(DrawRankRewardRequest.class, Builder.class);
        }

        public static Parser<DrawRankRewardRequest> PARSER = (Parser<DrawRankRewardRequest>) new AbstractParser<DrawRankRewardRequest>() {
            public SoloHandler.DrawRankRewardRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SoloHandler.DrawRankRewardRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_RANKID_FIELD_NUMBER = 1;
        private int c2SRankId_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<DrawRankRewardRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasC2SRankId() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getC2SRankId() {
            return this.c2SRankId_;
        }

        private void initFields() {
            this.c2SRankId_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasC2SRankId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.c2SRankId_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.c2SRankId_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static DrawRankRewardRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (DrawRankRewardRequest) PARSER.parseFrom(data);
        }

        public static DrawRankRewardRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DrawRankRewardRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DrawRankRewardRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (DrawRankRewardRequest) PARSER.parseFrom(data);
        }

        public static DrawRankRewardRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DrawRankRewardRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DrawRankRewardRequest parseFrom(InputStream input) throws IOException {
            return (DrawRankRewardRequest) PARSER.parseFrom(input);
        }

        public static DrawRankRewardRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DrawRankRewardRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static DrawRankRewardRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (DrawRankRewardRequest) PARSER.parseDelimitedFrom(input);
        }

        public static DrawRankRewardRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DrawRankRewardRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static DrawRankRewardRequest parseFrom(CodedInputStream input) throws IOException {
            return (DrawRankRewardRequest) PARSER.parseFrom(input);
        }

        public static DrawRankRewardRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DrawRankRewardRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(DrawRankRewardRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements SoloHandler.DrawRankRewardRequestOrBuilder {
            private int bitField0_;
            private int c2SRankId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SoloHandler.internal_static_pomelo_area_DrawRankRewardRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return SoloHandler.internal_static_pomelo_area_DrawRankRewardRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(SoloHandler.DrawRankRewardRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SoloHandler.DrawRankRewardRequest.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.c2SRankId_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return SoloHandler.internal_static_pomelo_area_DrawRankRewardRequest_descriptor;
            }

            public SoloHandler.DrawRankRewardRequest getDefaultInstanceForType() {
                return SoloHandler.DrawRankRewardRequest.getDefaultInstance();
            }

            public SoloHandler.DrawRankRewardRequest build() {
                SoloHandler.DrawRankRewardRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public SoloHandler.DrawRankRewardRequest buildPartial() {
                SoloHandler.DrawRankRewardRequest result = new SoloHandler.DrawRankRewardRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.c2SRankId_ = this.c2SRankId_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof SoloHandler.DrawRankRewardRequest)
                    return mergeFrom((SoloHandler.DrawRankRewardRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SoloHandler.DrawRankRewardRequest other) {
                if (other == SoloHandler.DrawRankRewardRequest.getDefaultInstance()) return this;
                if (other.hasC2SRankId()) setC2SRankId(other.getC2SRankId());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasC2SRankId()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                SoloHandler.DrawRankRewardRequest parsedMessage = null;
                try {
                    parsedMessage = (SoloHandler.DrawRankRewardRequest) SoloHandler.DrawRankRewardRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SoloHandler.DrawRankRewardRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasC2SRankId() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getC2SRankId() {
                return this.c2SRankId_;
            }

            public Builder setC2SRankId(int value) {
                this.bitField0_ |= 0x1;
                this.c2SRankId_ = value;
                onChanged();
                return this;
            }

            public Builder clearC2SRankId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SRankId_ = 0;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }
    }


    public static final class DrawRankRewardResponse
            extends GeneratedMessage
            implements DrawRankRewardResponseOrBuilder {
        private static final DrawRankRewardResponse defaultInstance = new DrawRankRewardResponse(true);
        private final UnknownFieldSet unknownFields;

        private DrawRankRewardResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private DrawRankRewardResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static DrawRankRewardResponse getDefaultInstance() {
            return defaultInstance;
        }

        public DrawRankRewardResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DrawRankRewardResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return SoloHandler.internal_static_pomelo_area_DrawRankRewardResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return SoloHandler.internal_static_pomelo_area_DrawRankRewardResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(DrawRankRewardResponse.class, Builder.class);
        }

        public static Parser<DrawRankRewardResponse> PARSER = (Parser<DrawRankRewardResponse>) new AbstractParser<DrawRankRewardResponse>() {
            public SoloHandler.DrawRankRewardResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SoloHandler.DrawRankRewardResponse(input, extensionRegistry);
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

        public Parser<DrawRankRewardResponse> getParserForType() {
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

        public static DrawRankRewardResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (DrawRankRewardResponse) PARSER.parseFrom(data);
        }

        public static DrawRankRewardResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DrawRankRewardResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DrawRankRewardResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (DrawRankRewardResponse) PARSER.parseFrom(data);
        }

        public static DrawRankRewardResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DrawRankRewardResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DrawRankRewardResponse parseFrom(InputStream input) throws IOException {
            return (DrawRankRewardResponse) PARSER.parseFrom(input);
        }

        public static DrawRankRewardResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DrawRankRewardResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static DrawRankRewardResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (DrawRankRewardResponse) PARSER.parseDelimitedFrom(input);
        }

        public static DrawRankRewardResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DrawRankRewardResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static DrawRankRewardResponse parseFrom(CodedInputStream input) throws IOException {
            return (DrawRankRewardResponse) PARSER.parseFrom(input);
        }

        public static DrawRankRewardResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DrawRankRewardResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(DrawRankRewardResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements SoloHandler.DrawRankRewardResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SoloHandler.internal_static_pomelo_area_DrawRankRewardResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return SoloHandler.internal_static_pomelo_area_DrawRankRewardResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(SoloHandler.DrawRankRewardResponse.class, Builder.class);
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
                if (SoloHandler.DrawRankRewardResponse.alwaysUseFieldBuilders) ;
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
                return SoloHandler.internal_static_pomelo_area_DrawRankRewardResponse_descriptor;
            }

            public SoloHandler.DrawRankRewardResponse getDefaultInstanceForType() {
                return SoloHandler.DrawRankRewardResponse.getDefaultInstance();
            }

            public SoloHandler.DrawRankRewardResponse build() {
                SoloHandler.DrawRankRewardResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public SoloHandler.DrawRankRewardResponse buildPartial() {
                SoloHandler.DrawRankRewardResponse result = new SoloHandler.DrawRankRewardResponse(this);
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
                if (other instanceof SoloHandler.DrawRankRewardResponse)
                    return mergeFrom((SoloHandler.DrawRankRewardResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SoloHandler.DrawRankRewardResponse other) {
                if (other == SoloHandler.DrawRankRewardResponse.getDefaultInstance()) return this;
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
                SoloHandler.DrawRankRewardResponse parsedMessage = null;
                try {
                    parsedMessage = (SoloHandler.DrawRankRewardResponse) SoloHandler.DrawRankRewardResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SoloHandler.DrawRankRewardResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = SoloHandler.DrawRankRewardResponse.getDefaultInstance().getS2CMsg();
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


    public static final class DrawDailyRewardRequest
            extends GeneratedMessage
            implements DrawDailyRewardRequestOrBuilder {
        private static final DrawDailyRewardRequest defaultInstance = new DrawDailyRewardRequest(true);
        private final UnknownFieldSet unknownFields;

        private DrawDailyRewardRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private DrawDailyRewardRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static DrawDailyRewardRequest getDefaultInstance() {
            return defaultInstance;
        }

        public DrawDailyRewardRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DrawDailyRewardRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.c2SIndex_ = input.readInt32();
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
            return SoloHandler.internal_static_pomelo_area_DrawDailyRewardRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return SoloHandler.internal_static_pomelo_area_DrawDailyRewardRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(DrawDailyRewardRequest.class, Builder.class);
        }

        public static Parser<DrawDailyRewardRequest> PARSER = (Parser<DrawDailyRewardRequest>) new AbstractParser<DrawDailyRewardRequest>() {
            public SoloHandler.DrawDailyRewardRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SoloHandler.DrawDailyRewardRequest(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int C2S_INDEX_FIELD_NUMBER = 1;
        private int c2SIndex_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<DrawDailyRewardRequest> getParserForType() {
            return PARSER;
        }

        public boolean hasC2SIndex() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getC2SIndex() {
            return this.c2SIndex_;
        }

        private void initFields() {
            this.c2SIndex_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasC2SIndex()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.c2SIndex_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.c2SIndex_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static DrawDailyRewardRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (DrawDailyRewardRequest) PARSER.parseFrom(data);
        }

        public static DrawDailyRewardRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DrawDailyRewardRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DrawDailyRewardRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (DrawDailyRewardRequest) PARSER.parseFrom(data);
        }

        public static DrawDailyRewardRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DrawDailyRewardRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DrawDailyRewardRequest parseFrom(InputStream input) throws IOException {
            return (DrawDailyRewardRequest) PARSER.parseFrom(input);
        }

        public static DrawDailyRewardRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DrawDailyRewardRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static DrawDailyRewardRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (DrawDailyRewardRequest) PARSER.parseDelimitedFrom(input);
        }

        public static DrawDailyRewardRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DrawDailyRewardRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static DrawDailyRewardRequest parseFrom(CodedInputStream input) throws IOException {
            return (DrawDailyRewardRequest) PARSER.parseFrom(input);
        }

        public static DrawDailyRewardRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DrawDailyRewardRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(DrawDailyRewardRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements SoloHandler.DrawDailyRewardRequestOrBuilder {
            private int bitField0_;
            private int c2SIndex_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SoloHandler.internal_static_pomelo_area_DrawDailyRewardRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return SoloHandler.internal_static_pomelo_area_DrawDailyRewardRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(SoloHandler.DrawDailyRewardRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SoloHandler.DrawDailyRewardRequest.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.c2SIndex_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return SoloHandler.internal_static_pomelo_area_DrawDailyRewardRequest_descriptor;
            }

            public SoloHandler.DrawDailyRewardRequest getDefaultInstanceForType() {
                return SoloHandler.DrawDailyRewardRequest.getDefaultInstance();
            }

            public SoloHandler.DrawDailyRewardRequest build() {
                SoloHandler.DrawDailyRewardRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public SoloHandler.DrawDailyRewardRequest buildPartial() {
                SoloHandler.DrawDailyRewardRequest result = new SoloHandler.DrawDailyRewardRequest(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.c2SIndex_ = this.c2SIndex_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof SoloHandler.DrawDailyRewardRequest)
                    return mergeFrom((SoloHandler.DrawDailyRewardRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SoloHandler.DrawDailyRewardRequest other) {
                if (other == SoloHandler.DrawDailyRewardRequest.getDefaultInstance()) return this;
                if (other.hasC2SIndex()) setC2SIndex(other.getC2SIndex());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasC2SIndex()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                SoloHandler.DrawDailyRewardRequest parsedMessage = null;
                try {
                    parsedMessage = (SoloHandler.DrawDailyRewardRequest) SoloHandler.DrawDailyRewardRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SoloHandler.DrawDailyRewardRequest) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) mergeFrom(parsedMessage);
                }
                return this;
            }

            public boolean hasC2SIndex() {
                return ((this.bitField0_ & 0x1) == 1);
            }

            public int getC2SIndex() {
                return this.c2SIndex_;
            }

            public Builder setC2SIndex(int value) {
                this.bitField0_ |= 0x1;
                this.c2SIndex_ = value;
                onChanged();
                return this;
            }

            public Builder clearC2SIndex() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.c2SIndex_ = 0;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class DrawDailyRewardResponse
            extends GeneratedMessage
            implements DrawDailyRewardResponseOrBuilder {
        private static final DrawDailyRewardResponse defaultInstance = new DrawDailyRewardResponse(true);
        private final UnknownFieldSet unknownFields;

        private DrawDailyRewardResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private DrawDailyRewardResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static DrawDailyRewardResponse getDefaultInstance() {
            return defaultInstance;
        }

        public DrawDailyRewardResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DrawDailyRewardResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.s2CDailyRewardItems_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x4;
                            }
                            this.s2CDailyRewardItems_.add(input.readMessage(SoloHandler.DailyRewardItem.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x4) == 4)
                    this.s2CDailyRewardItems_ = Collections.unmodifiableList(this.s2CDailyRewardItems_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SoloHandler.internal_static_pomelo_area_DrawDailyRewardResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return SoloHandler.internal_static_pomelo_area_DrawDailyRewardResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(DrawDailyRewardResponse.class, Builder.class);
        }

        public static Parser<DrawDailyRewardResponse> PARSER = (Parser<DrawDailyRewardResponse>) new AbstractParser<DrawDailyRewardResponse>() {
            public SoloHandler.DrawDailyRewardResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SoloHandler.DrawDailyRewardResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_DAILYREWARDITEMS_FIELD_NUMBER = 3;
        private List<SoloHandler.DailyRewardItem> s2CDailyRewardItems_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<DrawDailyRewardResponse> getParserForType() {
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

        public List<SoloHandler.DailyRewardItem> getS2CDailyRewardItemsList() {
            return this.s2CDailyRewardItems_;
        }

        public List<? extends SoloHandler.DailyRewardItemOrBuilder> getS2CDailyRewardItemsOrBuilderList() {
            return (List) this.s2CDailyRewardItems_;
        }

        public int getS2CDailyRewardItemsCount() {
            return this.s2CDailyRewardItems_.size();
        }

        public SoloHandler.DailyRewardItem getS2CDailyRewardItems(int index) {
            return this.s2CDailyRewardItems_.get(index);
        }

        public SoloHandler.DailyRewardItemOrBuilder getS2CDailyRewardItemsOrBuilder(int index) {
            return this.s2CDailyRewardItems_.get(index);
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CDailyRewardItems_ = Collections.emptyList();
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
            for (int i = 0; i < getS2CDailyRewardItemsCount(); i++) {
                if (!getS2CDailyRewardItems(i).isInitialized()) {
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
            for (int i = 0; i < this.s2CDailyRewardItems_.size(); i++)
                output.writeMessage(3, (MessageLite) this.s2CDailyRewardItems_.get(i));
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
            for (int i = 0; i < this.s2CDailyRewardItems_.size(); i++)
                size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.s2CDailyRewardItems_.get(i));
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static DrawDailyRewardResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (DrawDailyRewardResponse) PARSER.parseFrom(data);
        }

        public static DrawDailyRewardResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DrawDailyRewardResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DrawDailyRewardResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (DrawDailyRewardResponse) PARSER.parseFrom(data);
        }

        public static DrawDailyRewardResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DrawDailyRewardResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static DrawDailyRewardResponse parseFrom(InputStream input) throws IOException {
            return (DrawDailyRewardResponse) PARSER.parseFrom(input);
        }

        public static DrawDailyRewardResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DrawDailyRewardResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static DrawDailyRewardResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (DrawDailyRewardResponse) PARSER.parseDelimitedFrom(input);
        }

        public static DrawDailyRewardResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DrawDailyRewardResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static DrawDailyRewardResponse parseFrom(CodedInputStream input) throws IOException {
            return (DrawDailyRewardResponse) PARSER.parseFrom(input);
        }

        public static DrawDailyRewardResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DrawDailyRewardResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(DrawDailyRewardResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements SoloHandler.DrawDailyRewardResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private List<SoloHandler.DailyRewardItem> s2CDailyRewardItems_;
            private RepeatedFieldBuilder<SoloHandler.DailyRewardItem, SoloHandler.DailyRewardItem.Builder, SoloHandler.DailyRewardItemOrBuilder> s2CDailyRewardItemsBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SoloHandler.internal_static_pomelo_area_DrawDailyRewardResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return SoloHandler.internal_static_pomelo_area_DrawDailyRewardResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(SoloHandler.DrawDailyRewardResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CMsg_ = "";
                this.s2CDailyRewardItems_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CMsg_ = "";
                this.s2CDailyRewardItems_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SoloHandler.DrawDailyRewardResponse.alwaysUseFieldBuilders)
                    getS2CDailyRewardItemsFieldBuilder();
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
                if (this.s2CDailyRewardItemsBuilder_ == null) {
                    this.s2CDailyRewardItems_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                } else {
                    this.s2CDailyRewardItemsBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return SoloHandler.internal_static_pomelo_area_DrawDailyRewardResponse_descriptor;
            }

            public SoloHandler.DrawDailyRewardResponse getDefaultInstanceForType() {
                return SoloHandler.DrawDailyRewardResponse.getDefaultInstance();
            }

            public SoloHandler.DrawDailyRewardResponse build() {
                SoloHandler.DrawDailyRewardResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public SoloHandler.DrawDailyRewardResponse buildPartial() {
                SoloHandler.DrawDailyRewardResponse result = new SoloHandler.DrawDailyRewardResponse(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.s2CMsg_ = this.s2CMsg_;
                if (this.s2CDailyRewardItemsBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4) {
                        this.s2CDailyRewardItems_ = Collections.unmodifiableList(this.s2CDailyRewardItems_);
                        this.bitField0_ &= 0xFFFFFFFB;
                    }
                    result.s2CDailyRewardItems_ = this.s2CDailyRewardItems_;
                } else {
                    result.s2CDailyRewardItems_ = this.s2CDailyRewardItemsBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof SoloHandler.DrawDailyRewardResponse)
                    return mergeFrom((SoloHandler.DrawDailyRewardResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SoloHandler.DrawDailyRewardResponse other) {
                if (other == SoloHandler.DrawDailyRewardResponse.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (this.s2CDailyRewardItemsBuilder_ == null) {
                    if (!other.s2CDailyRewardItems_.isEmpty()) {
                        if (this.s2CDailyRewardItems_.isEmpty()) {
                            this.s2CDailyRewardItems_ = other.s2CDailyRewardItems_;
                            this.bitField0_ &= 0xFFFFFFFB;
                        } else {
                            ensureS2CDailyRewardItemsIsMutable();
                            this.s2CDailyRewardItems_.addAll(other.s2CDailyRewardItems_);
                        }
                        onChanged();
                    }
                } else if (!other.s2CDailyRewardItems_.isEmpty()) {
                    if (this.s2CDailyRewardItemsBuilder_.isEmpty()) {
                        this.s2CDailyRewardItemsBuilder_.dispose();
                        this.s2CDailyRewardItemsBuilder_ = null;
                        this.s2CDailyRewardItems_ = other.s2CDailyRewardItems_;
                        this.bitField0_ &= 0xFFFFFFFB;
                        this.s2CDailyRewardItemsBuilder_ = SoloHandler.DrawDailyRewardResponse.alwaysUseFieldBuilders ? getS2CDailyRewardItemsFieldBuilder() : null;
                    } else {
                        this.s2CDailyRewardItemsBuilder_.addAllMessages(other.s2CDailyRewardItems_);
                    }
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode())
                    return false;
                for (int i = 0; i < getS2CDailyRewardItemsCount(); i++) {
                    if (!getS2CDailyRewardItems(i).isInitialized())
                        return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                SoloHandler.DrawDailyRewardResponse parsedMessage = null;
                try {
                    parsedMessage = (SoloHandler.DrawDailyRewardResponse) SoloHandler.DrawDailyRewardResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SoloHandler.DrawDailyRewardResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = SoloHandler.DrawDailyRewardResponse.getDefaultInstance().getS2CMsg();
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

            private void ensureS2CDailyRewardItemsIsMutable() {
                if ((this.bitField0_ & 0x4) != 4) {
                    this.s2CDailyRewardItems_ = new ArrayList<>(this.s2CDailyRewardItems_);
                    this.bitField0_ |= 0x4;
                }
            }

            public List<SoloHandler.DailyRewardItem> getS2CDailyRewardItemsList() {
                if (this.s2CDailyRewardItemsBuilder_ == null)
                    return Collections.unmodifiableList(this.s2CDailyRewardItems_);
                return this.s2CDailyRewardItemsBuilder_.getMessageList();
            }

            public int getS2CDailyRewardItemsCount() {
                if (this.s2CDailyRewardItemsBuilder_ == null)
                    return this.s2CDailyRewardItems_.size();
                return this.s2CDailyRewardItemsBuilder_.getCount();
            }

            public SoloHandler.DailyRewardItem getS2CDailyRewardItems(int index) {
                if (this.s2CDailyRewardItemsBuilder_ == null)
                    return this.s2CDailyRewardItems_.get(index);
                return (SoloHandler.DailyRewardItem) this.s2CDailyRewardItemsBuilder_.getMessage(index);
            }

            public Builder setS2CDailyRewardItems(int index, SoloHandler.DailyRewardItem value) {
                if (this.s2CDailyRewardItemsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CDailyRewardItemsIsMutable();
                    this.s2CDailyRewardItems_.set(index, value);
                    onChanged();
                } else {
                    this.s2CDailyRewardItemsBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setS2CDailyRewardItems(int index, SoloHandler.DailyRewardItem.Builder builderForValue) {
                if (this.s2CDailyRewardItemsBuilder_ == null) {
                    ensureS2CDailyRewardItemsIsMutable();
                    this.s2CDailyRewardItems_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CDailyRewardItemsBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addS2CDailyRewardItems(SoloHandler.DailyRewardItem value) {
                if (this.s2CDailyRewardItemsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CDailyRewardItemsIsMutable();
                    this.s2CDailyRewardItems_.add(value);
                    onChanged();
                } else {
                    this.s2CDailyRewardItemsBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addS2CDailyRewardItems(int index, SoloHandler.DailyRewardItem value) {
                if (this.s2CDailyRewardItemsBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureS2CDailyRewardItemsIsMutable();
                    this.s2CDailyRewardItems_.add(index, value);
                    onChanged();
                } else {
                    this.s2CDailyRewardItemsBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addS2CDailyRewardItems(SoloHandler.DailyRewardItem.Builder builderForValue) {
                if (this.s2CDailyRewardItemsBuilder_ == null) {
                    ensureS2CDailyRewardItemsIsMutable();
                    this.s2CDailyRewardItems_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.s2CDailyRewardItemsBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addS2CDailyRewardItems(int index, SoloHandler.DailyRewardItem.Builder builderForValue) {
                if (this.s2CDailyRewardItemsBuilder_ == null) {
                    ensureS2CDailyRewardItemsIsMutable();
                    this.s2CDailyRewardItems_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CDailyRewardItemsBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllS2CDailyRewardItems(Iterable<? extends SoloHandler.DailyRewardItem> values) {
                if (this.s2CDailyRewardItemsBuilder_ == null) {
                    ensureS2CDailyRewardItemsIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.s2CDailyRewardItems_);
                    onChanged();
                } else {
                    this.s2CDailyRewardItemsBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearS2CDailyRewardItems() {
                if (this.s2CDailyRewardItemsBuilder_ == null) {
                    this.s2CDailyRewardItems_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                    onChanged();
                } else {
                    this.s2CDailyRewardItemsBuilder_.clear();
                }
                return this;
            }

            public Builder removeS2CDailyRewardItems(int index) {
                if (this.s2CDailyRewardItemsBuilder_ == null) {
                    ensureS2CDailyRewardItemsIsMutable();
                    this.s2CDailyRewardItems_.remove(index);
                    onChanged();
                } else {
                    this.s2CDailyRewardItemsBuilder_.remove(index);
                }
                return this;
            }

            public SoloHandler.DailyRewardItem.Builder getS2CDailyRewardItemsBuilder(int index) {
                return (SoloHandler.DailyRewardItem.Builder) getS2CDailyRewardItemsFieldBuilder().getBuilder(index);
            }

            public SoloHandler.DailyRewardItemOrBuilder getS2CDailyRewardItemsOrBuilder(int index) {
                if (this.s2CDailyRewardItemsBuilder_ == null)
                    return this.s2CDailyRewardItems_.get(index);
                return (SoloHandler.DailyRewardItemOrBuilder) this.s2CDailyRewardItemsBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends SoloHandler.DailyRewardItemOrBuilder> getS2CDailyRewardItemsOrBuilderList() {
                if (this.s2CDailyRewardItemsBuilder_ != null)
                    return this.s2CDailyRewardItemsBuilder_.getMessageOrBuilderList();
                return Collections.unmodifiableList((List) this.s2CDailyRewardItems_);
            }

            public SoloHandler.DailyRewardItem.Builder addS2CDailyRewardItemsBuilder() {
                return (SoloHandler.DailyRewardItem.Builder) getS2CDailyRewardItemsFieldBuilder().addBuilder(SoloHandler.DailyRewardItem.getDefaultInstance());
            }

            public SoloHandler.DailyRewardItem.Builder addS2CDailyRewardItemsBuilder(int index) {
                return (SoloHandler.DailyRewardItem.Builder) getS2CDailyRewardItemsFieldBuilder().addBuilder(index, SoloHandler.DailyRewardItem.getDefaultInstance());
            }

            public List<SoloHandler.DailyRewardItem.Builder> getS2CDailyRewardItemsBuilderList() {
                return getS2CDailyRewardItemsFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<SoloHandler.DailyRewardItem, SoloHandler.DailyRewardItem.Builder, SoloHandler.DailyRewardItemOrBuilder> getS2CDailyRewardItemsFieldBuilder() {
                if (this.s2CDailyRewardItemsBuilder_ == null) {
                    this.s2CDailyRewardItemsBuilder_ = new RepeatedFieldBuilder(this.s2CDailyRewardItems_, ((this.bitField0_ & 0x4) == 4), getParentForChildren(), isClean());
                    this.s2CDailyRewardItems_ = null;
                }
                return this.s2CDailyRewardItemsBuilder_;
            }
        }
    }

    public static final class JoinSoloRequest extends GeneratedMessage implements JoinSoloRequestOrBuilder {
        private static final JoinSoloRequest defaultInstance = new JoinSoloRequest(true);
        private final UnknownFieldSet unknownFields;

        private JoinSoloRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private JoinSoloRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static JoinSoloRequest getDefaultInstance() {
            return defaultInstance;
        }

        public JoinSoloRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private JoinSoloRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return SoloHandler.internal_static_pomelo_area_JoinSoloRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return SoloHandler.internal_static_pomelo_area_JoinSoloRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(JoinSoloRequest.class, Builder.class);
        }

        public static Parser<JoinSoloRequest> PARSER = (Parser<JoinSoloRequest>) new AbstractParser<JoinSoloRequest>() {
            public SoloHandler.JoinSoloRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SoloHandler.JoinSoloRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<JoinSoloRequest> getParserForType() {
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

        public static JoinSoloRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (JoinSoloRequest) PARSER.parseFrom(data);
        }

        public static JoinSoloRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (JoinSoloRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static JoinSoloRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (JoinSoloRequest) PARSER.parseFrom(data);
        }

        public static JoinSoloRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (JoinSoloRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static JoinSoloRequest parseFrom(InputStream input) throws IOException {
            return (JoinSoloRequest) PARSER.parseFrom(input);
        }

        public static JoinSoloRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (JoinSoloRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static JoinSoloRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (JoinSoloRequest) PARSER.parseDelimitedFrom(input);
        }

        public static JoinSoloRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (JoinSoloRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static JoinSoloRequest parseFrom(CodedInputStream input) throws IOException {
            return (JoinSoloRequest) PARSER.parseFrom(input);
        }

        public static JoinSoloRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (JoinSoloRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(JoinSoloRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements SoloHandler.JoinSoloRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return SoloHandler.internal_static_pomelo_area_JoinSoloRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return SoloHandler.internal_static_pomelo_area_JoinSoloRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(SoloHandler.JoinSoloRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SoloHandler.JoinSoloRequest.alwaysUseFieldBuilders) ;
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
                return SoloHandler.internal_static_pomelo_area_JoinSoloRequest_descriptor;
            }

            public SoloHandler.JoinSoloRequest getDefaultInstanceForType() {
                return SoloHandler.JoinSoloRequest.getDefaultInstance();
            }

            public SoloHandler.JoinSoloRequest build() {
                SoloHandler.JoinSoloRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public SoloHandler.JoinSoloRequest buildPartial() {
                SoloHandler.JoinSoloRequest result = new SoloHandler.JoinSoloRequest(this);
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof SoloHandler.JoinSoloRequest) return mergeFrom((SoloHandler.JoinSoloRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SoloHandler.JoinSoloRequest other) {
                if (other == SoloHandler.JoinSoloRequest.getDefaultInstance()) return this;
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                SoloHandler.JoinSoloRequest parsedMessage = null;
                try {
                    parsedMessage = (SoloHandler.JoinSoloRequest) SoloHandler.JoinSoloRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SoloHandler.JoinSoloRequest) e.getUnfinishedMessage();
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


    public static final class JoinSoloResponse
            extends GeneratedMessage
            implements JoinSoloResponseOrBuilder {
        private static final JoinSoloResponse defaultInstance = new JoinSoloResponse(true);
        private final UnknownFieldSet unknownFields;

        private JoinSoloResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private JoinSoloResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static JoinSoloResponse getDefaultInstance() {
            return defaultInstance;
        }

        public JoinSoloResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private JoinSoloResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.s2CAvgMatchTime_ = input.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.s2CStartJoinTime_ = input.readInt32();
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
            return SoloHandler.internal_static_pomelo_area_JoinSoloResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return SoloHandler.internal_static_pomelo_area_JoinSoloResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(JoinSoloResponse.class, Builder.class);
        }

        public static Parser<JoinSoloResponse> PARSER = (Parser<JoinSoloResponse>) new AbstractParser<JoinSoloResponse>() {
            public SoloHandler.JoinSoloResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SoloHandler.JoinSoloResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_AVGMATCHTIME_FIELD_NUMBER = 3;
        private int s2CAvgMatchTime_;
        public static final int S2C_STARTJOINTIME_FIELD_NUMBER = 4;
        private int s2CStartJoinTime_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<JoinSoloResponse> getParserForType() {
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

        public boolean hasS2CAvgMatchTime() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getS2CAvgMatchTime() {
            return this.s2CAvgMatchTime_;
        }

        public boolean hasS2CStartJoinTime() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public int getS2CStartJoinTime() {
            return this.s2CStartJoinTime_;
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CAvgMatchTime_ = 0;
            this.s2CStartJoinTime_ = 0;
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
                output.writeInt32(3, this.s2CAvgMatchTime_);
            if ((this.bitField0_ & 0x8) == 8)
                output.writeInt32(4, this.s2CStartJoinTime_);
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
                size += CodedOutputStream.computeInt32Size(3, this.s2CAvgMatchTime_);
            if ((this.bitField0_ & 0x8) == 8)
                size += CodedOutputStream.computeInt32Size(4, this.s2CStartJoinTime_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static JoinSoloResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (JoinSoloResponse) PARSER.parseFrom(data);
        }

        public static JoinSoloResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (JoinSoloResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static JoinSoloResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (JoinSoloResponse) PARSER.parseFrom(data);
        }

        public static JoinSoloResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (JoinSoloResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static JoinSoloResponse parseFrom(InputStream input) throws IOException {
            return (JoinSoloResponse) PARSER.parseFrom(input);
        }

        public static JoinSoloResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (JoinSoloResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static JoinSoloResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (JoinSoloResponse) PARSER.parseDelimitedFrom(input);
        }

        public static JoinSoloResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (JoinSoloResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static JoinSoloResponse parseFrom(CodedInputStream input) throws IOException {
            return (JoinSoloResponse) PARSER.parseFrom(input);
        }

        public static JoinSoloResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (JoinSoloResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(JoinSoloResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements SoloHandler.JoinSoloResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private int s2CAvgMatchTime_;
            private int s2CStartJoinTime_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SoloHandler.internal_static_pomelo_area_JoinSoloResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return SoloHandler.internal_static_pomelo_area_JoinSoloResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(SoloHandler.JoinSoloResponse.class, Builder.class);
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
                if (SoloHandler.JoinSoloResponse.alwaysUseFieldBuilders) ;
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
                this.s2CAvgMatchTime_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.s2CStartJoinTime_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return SoloHandler.internal_static_pomelo_area_JoinSoloResponse_descriptor;
            }

            public SoloHandler.JoinSoloResponse getDefaultInstanceForType() {
                return SoloHandler.JoinSoloResponse.getDefaultInstance();
            }

            public SoloHandler.JoinSoloResponse build() {
                SoloHandler.JoinSoloResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public SoloHandler.JoinSoloResponse buildPartial() {
                SoloHandler.JoinSoloResponse result = new SoloHandler.JoinSoloResponse(this);
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
                result.s2CAvgMatchTime_ = this.s2CAvgMatchTime_;
                if ((from_bitField0_ & 0x8) == 8)
                    to_bitField0_ |= 0x8;
                result.s2CStartJoinTime_ = this.s2CStartJoinTime_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof SoloHandler.JoinSoloResponse)
                    return mergeFrom((SoloHandler.JoinSoloResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SoloHandler.JoinSoloResponse other) {
                if (other == SoloHandler.JoinSoloResponse.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (other.hasS2CAvgMatchTime())
                    setS2CAvgMatchTime(other.getS2CAvgMatchTime());
                if (other.hasS2CStartJoinTime())
                    setS2CStartJoinTime(other.getS2CStartJoinTime());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                SoloHandler.JoinSoloResponse parsedMessage = null;
                try {
                    parsedMessage = (SoloHandler.JoinSoloResponse) SoloHandler.JoinSoloResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SoloHandler.JoinSoloResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = SoloHandler.JoinSoloResponse.getDefaultInstance().getS2CMsg();
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

            public boolean hasS2CAvgMatchTime() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public int getS2CAvgMatchTime() {
                return this.s2CAvgMatchTime_;
            }

            public Builder setS2CAvgMatchTime(int value) {
                this.bitField0_ |= 0x4;
                this.s2CAvgMatchTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CAvgMatchTime() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.s2CAvgMatchTime_ = 0;
                onChanged();
                return this;
            }

            public boolean hasS2CStartJoinTime() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public int getS2CStartJoinTime() {
                return this.s2CStartJoinTime_;
            }

            public Builder setS2CStartJoinTime(int value) {
                this.bitField0_ |= 0x8;
                this.s2CStartJoinTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CStartJoinTime() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.s2CStartJoinTime_ = 0;
                onChanged();
                return this;
            }
        }
    }

    public static final class JoinSoloBattleRequest extends GeneratedMessage implements JoinSoloBattleRequestOrBuilder {
        private static final JoinSoloBattleRequest defaultInstance = new JoinSoloBattleRequest(true);
        private final UnknownFieldSet unknownFields;

        private JoinSoloBattleRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private JoinSoloBattleRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static JoinSoloBattleRequest getDefaultInstance() {
            return defaultInstance;
        }

        public JoinSoloBattleRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private JoinSoloBattleRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return SoloHandler.internal_static_pomelo_area_JoinSoloBattleRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return SoloHandler.internal_static_pomelo_area_JoinSoloBattleRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(JoinSoloBattleRequest.class, Builder.class);
        }

        public static Parser<JoinSoloBattleRequest> PARSER = (Parser<JoinSoloBattleRequest>) new AbstractParser<JoinSoloBattleRequest>() {
            public SoloHandler.JoinSoloBattleRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SoloHandler.JoinSoloBattleRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<JoinSoloBattleRequest> getParserForType() {
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

        public static JoinSoloBattleRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (JoinSoloBattleRequest) PARSER.parseFrom(data);
        }

        public static JoinSoloBattleRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (JoinSoloBattleRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static JoinSoloBattleRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (JoinSoloBattleRequest) PARSER.parseFrom(data);
        }

        public static JoinSoloBattleRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (JoinSoloBattleRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static JoinSoloBattleRequest parseFrom(InputStream input) throws IOException {
            return (JoinSoloBattleRequest) PARSER.parseFrom(input);
        }

        public static JoinSoloBattleRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (JoinSoloBattleRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static JoinSoloBattleRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (JoinSoloBattleRequest) PARSER.parseDelimitedFrom(input);
        }

        public static JoinSoloBattleRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (JoinSoloBattleRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static JoinSoloBattleRequest parseFrom(CodedInputStream input) throws IOException {
            return (JoinSoloBattleRequest) PARSER.parseFrom(input);
        }

        public static JoinSoloBattleRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (JoinSoloBattleRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(JoinSoloBattleRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements SoloHandler.JoinSoloBattleRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return SoloHandler.internal_static_pomelo_area_JoinSoloBattleRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return SoloHandler.internal_static_pomelo_area_JoinSoloBattleRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(SoloHandler.JoinSoloBattleRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SoloHandler.JoinSoloBattleRequest.alwaysUseFieldBuilders) ;
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
                return SoloHandler.internal_static_pomelo_area_JoinSoloBattleRequest_descriptor;
            }

            public SoloHandler.JoinSoloBattleRequest getDefaultInstanceForType() {
                return SoloHandler.JoinSoloBattleRequest.getDefaultInstance();
            }

            public SoloHandler.JoinSoloBattleRequest build() {
                SoloHandler.JoinSoloBattleRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public SoloHandler.JoinSoloBattleRequest buildPartial() {
                SoloHandler.JoinSoloBattleRequest result = new SoloHandler.JoinSoloBattleRequest(this);
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof SoloHandler.JoinSoloBattleRequest)
                    return mergeFrom((SoloHandler.JoinSoloBattleRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SoloHandler.JoinSoloBattleRequest other) {
                if (other == SoloHandler.JoinSoloBattleRequest.getDefaultInstance()) return this;
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                SoloHandler.JoinSoloBattleRequest parsedMessage = null;
                try {
                    parsedMessage = (SoloHandler.JoinSoloBattleRequest) SoloHandler.JoinSoloBattleRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SoloHandler.JoinSoloBattleRequest) e.getUnfinishedMessage();
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


    public static final class JoinSoloBattleResponse
            extends GeneratedMessage
            implements JoinSoloBattleResponseOrBuilder {
        private static final JoinSoloBattleResponse defaultInstance = new JoinSoloBattleResponse(true);
        private final UnknownFieldSet unknownFields;

        private JoinSoloBattleResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private JoinSoloBattleResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static JoinSoloBattleResponse getDefaultInstance() {
            return defaultInstance;
        }

        public JoinSoloBattleResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private JoinSoloBattleResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return SoloHandler.internal_static_pomelo_area_JoinSoloBattleResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return SoloHandler.internal_static_pomelo_area_JoinSoloBattleResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(JoinSoloBattleResponse.class, Builder.class);
        }

        public static Parser<JoinSoloBattleResponse> PARSER = (Parser<JoinSoloBattleResponse>) new AbstractParser<JoinSoloBattleResponse>() {
            public SoloHandler.JoinSoloBattleResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SoloHandler.JoinSoloBattleResponse(input, extensionRegistry);
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

        public Parser<JoinSoloBattleResponse> getParserForType() {
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

        public static JoinSoloBattleResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (JoinSoloBattleResponse) PARSER.parseFrom(data);
        }

        public static JoinSoloBattleResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (JoinSoloBattleResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static JoinSoloBattleResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (JoinSoloBattleResponse) PARSER.parseFrom(data);
        }

        public static JoinSoloBattleResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (JoinSoloBattleResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static JoinSoloBattleResponse parseFrom(InputStream input) throws IOException {
            return (JoinSoloBattleResponse) PARSER.parseFrom(input);
        }

        public static JoinSoloBattleResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (JoinSoloBattleResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static JoinSoloBattleResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (JoinSoloBattleResponse) PARSER.parseDelimitedFrom(input);
        }

        public static JoinSoloBattleResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (JoinSoloBattleResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static JoinSoloBattleResponse parseFrom(CodedInputStream input) throws IOException {
            return (JoinSoloBattleResponse) PARSER.parseFrom(input);
        }

        public static JoinSoloBattleResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (JoinSoloBattleResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(JoinSoloBattleResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements SoloHandler.JoinSoloBattleResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SoloHandler.internal_static_pomelo_area_JoinSoloBattleResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return SoloHandler.internal_static_pomelo_area_JoinSoloBattleResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(SoloHandler.JoinSoloBattleResponse.class, Builder.class);
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
                if (SoloHandler.JoinSoloBattleResponse.alwaysUseFieldBuilders) ;
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
                return SoloHandler.internal_static_pomelo_area_JoinSoloBattleResponse_descriptor;
            }

            public SoloHandler.JoinSoloBattleResponse getDefaultInstanceForType() {
                return SoloHandler.JoinSoloBattleResponse.getDefaultInstance();
            }

            public SoloHandler.JoinSoloBattleResponse build() {
                SoloHandler.JoinSoloBattleResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public SoloHandler.JoinSoloBattleResponse buildPartial() {
                SoloHandler.JoinSoloBattleResponse result = new SoloHandler.JoinSoloBattleResponse(this);
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
                if (other instanceof SoloHandler.JoinSoloBattleResponse)
                    return mergeFrom((SoloHandler.JoinSoloBattleResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SoloHandler.JoinSoloBattleResponse other) {
                if (other == SoloHandler.JoinSoloBattleResponse.getDefaultInstance()) return this;
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
                SoloHandler.JoinSoloBattleResponse parsedMessage = null;
                try {
                    parsedMessage = (SoloHandler.JoinSoloBattleResponse) SoloHandler.JoinSoloBattleResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SoloHandler.JoinSoloBattleResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = SoloHandler.JoinSoloBattleResponse.getDefaultInstance().getS2CMsg();
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


    public static final class QuitSoloRequest
            extends GeneratedMessage
            implements QuitSoloRequestOrBuilder {
        private static final QuitSoloRequest defaultInstance = new QuitSoloRequest(true);
        private final UnknownFieldSet unknownFields;

        private QuitSoloRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private QuitSoloRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static QuitSoloRequest getDefaultInstance() {
            return defaultInstance;
        }

        public QuitSoloRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private QuitSoloRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return SoloHandler.internal_static_pomelo_area_QuitSoloRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return SoloHandler.internal_static_pomelo_area_QuitSoloRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(QuitSoloRequest.class, Builder.class);
        }

        public static Parser<QuitSoloRequest> PARSER = (Parser<QuitSoloRequest>) new AbstractParser<QuitSoloRequest>() {
            public SoloHandler.QuitSoloRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SoloHandler.QuitSoloRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<QuitSoloRequest> getParserForType() {
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

        public static QuitSoloRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (QuitSoloRequest) PARSER.parseFrom(data);
        }

        public static QuitSoloRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (QuitSoloRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static QuitSoloRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (QuitSoloRequest) PARSER.parseFrom(data);
        }

        public static QuitSoloRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (QuitSoloRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static QuitSoloRequest parseFrom(InputStream input) throws IOException {
            return (QuitSoloRequest) PARSER.parseFrom(input);
        }

        public static QuitSoloRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QuitSoloRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static QuitSoloRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (QuitSoloRequest) PARSER.parseDelimitedFrom(input);
        }

        public static QuitSoloRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QuitSoloRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static QuitSoloRequest parseFrom(CodedInputStream input) throws IOException {
            return (QuitSoloRequest) PARSER.parseFrom(input);
        }

        public static QuitSoloRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QuitSoloRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(QuitSoloRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements SoloHandler.QuitSoloRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return SoloHandler.internal_static_pomelo_area_QuitSoloRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return SoloHandler.internal_static_pomelo_area_QuitSoloRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(SoloHandler.QuitSoloRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SoloHandler.QuitSoloRequest.alwaysUseFieldBuilders) ;
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
                return SoloHandler.internal_static_pomelo_area_QuitSoloRequest_descriptor;
            }

            public SoloHandler.QuitSoloRequest getDefaultInstanceForType() {
                return SoloHandler.QuitSoloRequest.getDefaultInstance();
            }

            public SoloHandler.QuitSoloRequest build() {
                SoloHandler.QuitSoloRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public SoloHandler.QuitSoloRequest buildPartial() {
                SoloHandler.QuitSoloRequest result = new SoloHandler.QuitSoloRequest(this);
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof SoloHandler.QuitSoloRequest) return mergeFrom((SoloHandler.QuitSoloRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SoloHandler.QuitSoloRequest other) {
                if (other == SoloHandler.QuitSoloRequest.getDefaultInstance()) return this;
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                SoloHandler.QuitSoloRequest parsedMessage = null;
                try {
                    parsedMessage = (SoloHandler.QuitSoloRequest) SoloHandler.QuitSoloRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SoloHandler.QuitSoloRequest) e.getUnfinishedMessage();
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


    public static final class QuitSoloResponse
            extends GeneratedMessage
            implements QuitSoloResponseOrBuilder {
        private static final QuitSoloResponse defaultInstance = new QuitSoloResponse(true);
        private final UnknownFieldSet unknownFields;

        private QuitSoloResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private QuitSoloResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static QuitSoloResponse getDefaultInstance() {
            return defaultInstance;
        }

        public QuitSoloResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private QuitSoloResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return SoloHandler.internal_static_pomelo_area_QuitSoloResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return SoloHandler.internal_static_pomelo_area_QuitSoloResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(QuitSoloResponse.class, Builder.class);
        }

        public static Parser<QuitSoloResponse> PARSER = (Parser<QuitSoloResponse>) new AbstractParser<QuitSoloResponse>() {
            public SoloHandler.QuitSoloResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SoloHandler.QuitSoloResponse(input, extensionRegistry);
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

        public Parser<QuitSoloResponse> getParserForType() {
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

        public static QuitSoloResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (QuitSoloResponse) PARSER.parseFrom(data);
        }

        public static QuitSoloResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (QuitSoloResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static QuitSoloResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (QuitSoloResponse) PARSER.parseFrom(data);
        }

        public static QuitSoloResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (QuitSoloResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static QuitSoloResponse parseFrom(InputStream input) throws IOException {
            return (QuitSoloResponse) PARSER.parseFrom(input);
        }

        public static QuitSoloResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QuitSoloResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static QuitSoloResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (QuitSoloResponse) PARSER.parseDelimitedFrom(input);
        }

        public static QuitSoloResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QuitSoloResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static QuitSoloResponse parseFrom(CodedInputStream input) throws IOException {
            return (QuitSoloResponse) PARSER.parseFrom(input);
        }

        public static QuitSoloResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QuitSoloResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(QuitSoloResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements SoloHandler.QuitSoloResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SoloHandler.internal_static_pomelo_area_QuitSoloResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return SoloHandler.internal_static_pomelo_area_QuitSoloResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(SoloHandler.QuitSoloResponse.class, Builder.class);
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
                if (SoloHandler.QuitSoloResponse.alwaysUseFieldBuilders) ;
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
                return SoloHandler.internal_static_pomelo_area_QuitSoloResponse_descriptor;
            }

            public SoloHandler.QuitSoloResponse getDefaultInstanceForType() {
                return SoloHandler.QuitSoloResponse.getDefaultInstance();
            }

            public SoloHandler.QuitSoloResponse build() {
                SoloHandler.QuitSoloResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public SoloHandler.QuitSoloResponse buildPartial() {
                SoloHandler.QuitSoloResponse result = new SoloHandler.QuitSoloResponse(this);
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
                if (other instanceof SoloHandler.QuitSoloResponse)
                    return mergeFrom((SoloHandler.QuitSoloResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SoloHandler.QuitSoloResponse other) {
                if (other == SoloHandler.QuitSoloResponse.getDefaultInstance()) return this;
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
                SoloHandler.QuitSoloResponse parsedMessage = null;
                try {
                    parsedMessage = (SoloHandler.QuitSoloResponse) SoloHandler.QuitSoloResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SoloHandler.QuitSoloResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = SoloHandler.QuitSoloResponse.getDefaultInstance().getS2CMsg();
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


    public static final class QueryRewardRequest
            extends GeneratedMessage
            implements QueryRewardRequestOrBuilder {
        private static final QueryRewardRequest defaultInstance = new QueryRewardRequest(true);
        private final UnknownFieldSet unknownFields;

        private QueryRewardRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private QueryRewardRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static QueryRewardRequest getDefaultInstance() {
            return defaultInstance;
        }

        public QueryRewardRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private QueryRewardRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return SoloHandler.internal_static_pomelo_area_QueryRewardRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return SoloHandler.internal_static_pomelo_area_QueryRewardRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(QueryRewardRequest.class, Builder.class);
        }

        public static Parser<QueryRewardRequest> PARSER = (Parser<QueryRewardRequest>) new AbstractParser<QueryRewardRequest>() {
            public SoloHandler.QueryRewardRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SoloHandler.QueryRewardRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<QueryRewardRequest> getParserForType() {
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

        public static QueryRewardRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (QueryRewardRequest) PARSER.parseFrom(data);
        }

        public static QueryRewardRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (QueryRewardRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static QueryRewardRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (QueryRewardRequest) PARSER.parseFrom(data);
        }

        public static QueryRewardRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (QueryRewardRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static QueryRewardRequest parseFrom(InputStream input) throws IOException {
            return (QueryRewardRequest) PARSER.parseFrom(input);
        }

        public static QueryRewardRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QueryRewardRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static QueryRewardRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (QueryRewardRequest) PARSER.parseDelimitedFrom(input);
        }

        public static QueryRewardRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QueryRewardRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static QueryRewardRequest parseFrom(CodedInputStream input) throws IOException {
            return (QueryRewardRequest) PARSER.parseFrom(input);
        }

        public static QueryRewardRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QueryRewardRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(QueryRewardRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements SoloHandler.QueryRewardRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return SoloHandler.internal_static_pomelo_area_QueryRewardRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return SoloHandler.internal_static_pomelo_area_QueryRewardRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(SoloHandler.QueryRewardRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SoloHandler.QueryRewardRequest.alwaysUseFieldBuilders) ;
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
                return SoloHandler.internal_static_pomelo_area_QueryRewardRequest_descriptor;
            }

            public SoloHandler.QueryRewardRequest getDefaultInstanceForType() {
                return SoloHandler.QueryRewardRequest.getDefaultInstance();
            }

            public SoloHandler.QueryRewardRequest build() {
                SoloHandler.QueryRewardRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public SoloHandler.QueryRewardRequest buildPartial() {
                SoloHandler.QueryRewardRequest result = new SoloHandler.QueryRewardRequest(this);
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof SoloHandler.QueryRewardRequest)
                    return mergeFrom((SoloHandler.QueryRewardRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SoloHandler.QueryRewardRequest other) {
                if (other == SoloHandler.QueryRewardRequest.getDefaultInstance()) return this;
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                SoloHandler.QueryRewardRequest parsedMessage = null;
                try {
                    parsedMessage = (SoloHandler.QueryRewardRequest) SoloHandler.QueryRewardRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SoloHandler.QueryRewardRequest) e.getUnfinishedMessage();
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


    public static final class QueryRewardResponse
            extends GeneratedMessage
            implements QueryRewardResponseOrBuilder {
        private static final QueryRewardResponse defaultInstance = new QueryRewardResponse(true);
        private final UnknownFieldSet unknownFields;

        private QueryRewardResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private QueryRewardResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static QueryRewardResponse getDefaultInstance() {
            return defaultInstance;
        }

        public QueryRewardResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private QueryRewardResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.s2CHasReward_ = input.readInt32();
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
            return SoloHandler.internal_static_pomelo_area_QueryRewardResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return SoloHandler.internal_static_pomelo_area_QueryRewardResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(QueryRewardResponse.class, Builder.class);
        }

        public static Parser<QueryRewardResponse> PARSER = (Parser<QueryRewardResponse>) new AbstractParser<QueryRewardResponse>() {
            public SoloHandler.QueryRewardResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SoloHandler.QueryRewardResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_MSG_FIELD_NUMBER = 2;
        private Object s2CMsg_;
        public static final int S2C_HASREWARD_FIELD_NUMBER = 3;
        private int s2CHasReward_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<QueryRewardResponse> getParserForType() {
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

        public boolean hasS2CHasReward() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getS2CHasReward() {
            return this.s2CHasReward_;
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CMsg_ = "";
            this.s2CHasReward_ = 0;
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
                output.writeInt32(3, this.s2CHasReward_);
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
                size += CodedOutputStream.computeInt32Size(3, this.s2CHasReward_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static QueryRewardResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (QueryRewardResponse) PARSER.parseFrom(data);
        }

        public static QueryRewardResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (QueryRewardResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static QueryRewardResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (QueryRewardResponse) PARSER.parseFrom(data);
        }

        public static QueryRewardResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (QueryRewardResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static QueryRewardResponse parseFrom(InputStream input) throws IOException {
            return (QueryRewardResponse) PARSER.parseFrom(input);
        }

        public static QueryRewardResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QueryRewardResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static QueryRewardResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (QueryRewardResponse) PARSER.parseDelimitedFrom(input);
        }

        public static QueryRewardResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QueryRewardResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static QueryRewardResponse parseFrom(CodedInputStream input) throws IOException {
            return (QueryRewardResponse) PARSER.parseFrom(input);
        }

        public static QueryRewardResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QueryRewardResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(QueryRewardResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements SoloHandler.QueryRewardResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;
            private int s2CHasReward_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SoloHandler.internal_static_pomelo_area_QueryRewardResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return SoloHandler.internal_static_pomelo_area_QueryRewardResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(SoloHandler.QueryRewardResponse.class, Builder.class);
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
                if (SoloHandler.QueryRewardResponse.alwaysUseFieldBuilders) ;
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
                this.s2CHasReward_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return SoloHandler.internal_static_pomelo_area_QueryRewardResponse_descriptor;
            }

            public SoloHandler.QueryRewardResponse getDefaultInstanceForType() {
                return SoloHandler.QueryRewardResponse.getDefaultInstance();
            }

            public SoloHandler.QueryRewardResponse build() {
                SoloHandler.QueryRewardResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public SoloHandler.QueryRewardResponse buildPartial() {
                SoloHandler.QueryRewardResponse result = new SoloHandler.QueryRewardResponse(this);
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
                result.s2CHasReward_ = this.s2CHasReward_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof SoloHandler.QueryRewardResponse)
                    return mergeFrom((SoloHandler.QueryRewardResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SoloHandler.QueryRewardResponse other) {
                if (other == SoloHandler.QueryRewardResponse.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x2;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                if (other.hasS2CHasReward())
                    setS2CHasReward(other.getS2CHasReward());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                SoloHandler.QueryRewardResponse parsedMessage = null;
                try {
                    parsedMessage = (SoloHandler.QueryRewardResponse) SoloHandler.QueryRewardResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SoloHandler.QueryRewardResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = SoloHandler.QueryRewardResponse.getDefaultInstance().getS2CMsg();
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

            public boolean hasS2CHasReward() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public int getS2CHasReward() {
                return this.s2CHasReward_;
            }

            public Builder setS2CHasReward(int value) {
                this.bitField0_ |= 0x4;
                this.s2CHasReward_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CHasReward() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.s2CHasReward_ = 0;
                onChanged();
                return this;
            }
        }
    }

    public static final class LeaveSoloAreaRequest extends GeneratedMessage implements LeaveSoloAreaRequestOrBuilder {
        private static final LeaveSoloAreaRequest defaultInstance = new LeaveSoloAreaRequest(true);
        private final UnknownFieldSet unknownFields;

        private LeaveSoloAreaRequest(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private LeaveSoloAreaRequest(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static LeaveSoloAreaRequest getDefaultInstance() {
            return defaultInstance;
        }

        public LeaveSoloAreaRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private LeaveSoloAreaRequest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return SoloHandler.internal_static_pomelo_area_LeaveSoloAreaRequest_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return SoloHandler.internal_static_pomelo_area_LeaveSoloAreaRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(LeaveSoloAreaRequest.class, Builder.class);
        }

        public static Parser<LeaveSoloAreaRequest> PARSER = (Parser<LeaveSoloAreaRequest>) new AbstractParser<LeaveSoloAreaRequest>() {
            public SoloHandler.LeaveSoloAreaRequest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SoloHandler.LeaveSoloAreaRequest(input, extensionRegistry);
            }
        };
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<LeaveSoloAreaRequest> getParserForType() {
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

        public static LeaveSoloAreaRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (LeaveSoloAreaRequest) PARSER.parseFrom(data);
        }

        public static LeaveSoloAreaRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (LeaveSoloAreaRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static LeaveSoloAreaRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (LeaveSoloAreaRequest) PARSER.parseFrom(data);
        }

        public static LeaveSoloAreaRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (LeaveSoloAreaRequest) PARSER.parseFrom(data, extensionRegistry);
        }

        public static LeaveSoloAreaRequest parseFrom(InputStream input) throws IOException {
            return (LeaveSoloAreaRequest) PARSER.parseFrom(input);
        }

        public static LeaveSoloAreaRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LeaveSoloAreaRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static LeaveSoloAreaRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (LeaveSoloAreaRequest) PARSER.parseDelimitedFrom(input);
        }

        public static LeaveSoloAreaRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LeaveSoloAreaRequest) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static LeaveSoloAreaRequest parseFrom(CodedInputStream input) throws IOException {
            return (LeaveSoloAreaRequest) PARSER.parseFrom(input);
        }

        public static LeaveSoloAreaRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LeaveSoloAreaRequest) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(LeaveSoloAreaRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements SoloHandler.LeaveSoloAreaRequestOrBuilder {
            public static final Descriptors.Descriptor getDescriptor() {
                return SoloHandler.internal_static_pomelo_area_LeaveSoloAreaRequest_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return SoloHandler.internal_static_pomelo_area_LeaveSoloAreaRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(SoloHandler.LeaveSoloAreaRequest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SoloHandler.LeaveSoloAreaRequest.alwaysUseFieldBuilders) ;
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
                return SoloHandler.internal_static_pomelo_area_LeaveSoloAreaRequest_descriptor;
            }

            public SoloHandler.LeaveSoloAreaRequest getDefaultInstanceForType() {
                return SoloHandler.LeaveSoloAreaRequest.getDefaultInstance();
            }

            public SoloHandler.LeaveSoloAreaRequest build() {
                SoloHandler.LeaveSoloAreaRequest result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public SoloHandler.LeaveSoloAreaRequest buildPartial() {
                SoloHandler.LeaveSoloAreaRequest result = new SoloHandler.LeaveSoloAreaRequest(this);
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof SoloHandler.LeaveSoloAreaRequest)
                    return mergeFrom((SoloHandler.LeaveSoloAreaRequest) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SoloHandler.LeaveSoloAreaRequest other) {
                if (other == SoloHandler.LeaveSoloAreaRequest.getDefaultInstance()) return this;
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                SoloHandler.LeaveSoloAreaRequest parsedMessage = null;
                try {
                    parsedMessage = (SoloHandler.LeaveSoloAreaRequest) SoloHandler.LeaveSoloAreaRequest.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SoloHandler.LeaveSoloAreaRequest) e.getUnfinishedMessage();
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


    public static final class LeaveSoloAreaResponse
            extends GeneratedMessage
            implements LeaveSoloAreaResponseOrBuilder {
        private static final LeaveSoloAreaResponse defaultInstance = new LeaveSoloAreaResponse(true);
        private final UnknownFieldSet unknownFields;

        private LeaveSoloAreaResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private LeaveSoloAreaResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static LeaveSoloAreaResponse getDefaultInstance() {
            return defaultInstance;
        }

        public LeaveSoloAreaResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private LeaveSoloAreaResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return SoloHandler.internal_static_pomelo_area_LeaveSoloAreaResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return SoloHandler.internal_static_pomelo_area_LeaveSoloAreaResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(LeaveSoloAreaResponse.class, Builder.class);
        }

        public static Parser<LeaveSoloAreaResponse> PARSER = (Parser<LeaveSoloAreaResponse>) new AbstractParser<LeaveSoloAreaResponse>() {
            public SoloHandler.LeaveSoloAreaResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SoloHandler.LeaveSoloAreaResponse(input, extensionRegistry);
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

        public Parser<LeaveSoloAreaResponse> getParserForType() {
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

        public static LeaveSoloAreaResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (LeaveSoloAreaResponse) PARSER.parseFrom(data);
        }

        public static LeaveSoloAreaResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (LeaveSoloAreaResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static LeaveSoloAreaResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (LeaveSoloAreaResponse) PARSER.parseFrom(data);
        }

        public static LeaveSoloAreaResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (LeaveSoloAreaResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static LeaveSoloAreaResponse parseFrom(InputStream input) throws IOException {
            return (LeaveSoloAreaResponse) PARSER.parseFrom(input);
        }

        public static LeaveSoloAreaResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LeaveSoloAreaResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static LeaveSoloAreaResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (LeaveSoloAreaResponse) PARSER.parseDelimitedFrom(input);
        }

        public static LeaveSoloAreaResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LeaveSoloAreaResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static LeaveSoloAreaResponse parseFrom(CodedInputStream input) throws IOException {
            return (LeaveSoloAreaResponse) PARSER.parseFrom(input);
        }

        public static LeaveSoloAreaResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LeaveSoloAreaResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(LeaveSoloAreaResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements SoloHandler.LeaveSoloAreaResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CMsg_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SoloHandler.internal_static_pomelo_area_LeaveSoloAreaResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return SoloHandler.internal_static_pomelo_area_LeaveSoloAreaResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(SoloHandler.LeaveSoloAreaResponse.class, Builder.class);
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
                if (SoloHandler.LeaveSoloAreaResponse.alwaysUseFieldBuilders) ;
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
                return SoloHandler.internal_static_pomelo_area_LeaveSoloAreaResponse_descriptor;
            }

            public SoloHandler.LeaveSoloAreaResponse getDefaultInstanceForType() {
                return SoloHandler.LeaveSoloAreaResponse.getDefaultInstance();
            }

            public SoloHandler.LeaveSoloAreaResponse build() {
                SoloHandler.LeaveSoloAreaResponse result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public SoloHandler.LeaveSoloAreaResponse buildPartial() {
                SoloHandler.LeaveSoloAreaResponse result = new SoloHandler.LeaveSoloAreaResponse(this);
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
                if (other instanceof SoloHandler.LeaveSoloAreaResponse)
                    return mergeFrom((SoloHandler.LeaveSoloAreaResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SoloHandler.LeaveSoloAreaResponse other) {
                if (other == SoloHandler.LeaveSoloAreaResponse.getDefaultInstance()) return this;
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
                SoloHandler.LeaveSoloAreaResponse parsedMessage = null;
                try {
                    parsedMessage = (SoloHandler.LeaveSoloAreaResponse) SoloHandler.LeaveSoloAreaResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SoloHandler.LeaveSoloAreaResponse) e.getUnfinishedMessage();
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
                this.s2CMsg_ = SoloHandler.LeaveSoloAreaResponse.getDefaultInstance().getS2CMsg();
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


    public static final class OnSoloMatchedPush
            extends GeneratedMessage
            implements OnSoloMatchedPushOrBuilder {
        private static final OnSoloMatchedPush defaultInstance = new OnSoloMatchedPush(true);
        private final UnknownFieldSet unknownFields;

        private OnSoloMatchedPush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private OnSoloMatchedPush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static OnSoloMatchedPush getDefaultInstance() {
            return defaultInstance;
        }

        public OnSoloMatchedPush getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private OnSoloMatchedPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.s2CVsPlayerName_ = bs;
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.s2CVsPlayerPro_ = input.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.s2CVsPlayerLevel_ = input.readInt32();
                            break;
                        case 42:
                            if ((mutable_bitField0_ & 0x10) != 16) {
                                this.s2CVsPlayerAvatars_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x10;
                            }
                            this.s2CVsPlayerAvatars_.add(input.readMessage(Common.Avatar.PARSER, extensionRegistry));
                            break;
                        case 48:
                            this.bitField0_ |= 0x10;
                            this.s2CWaitResponseTimeSec_ = input.readInt32();
                            break;
                        case 56:
                            this.bitField0_ |= 0x20;
                            this.s2CIsRobot_ = input.readInt32();
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x10) == 16)
                    this.s2CVsPlayerAvatars_ = Collections.unmodifiableList(this.s2CVsPlayerAvatars_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SoloHandler.internal_static_pomelo_area_OnSoloMatchedPush_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return SoloHandler.internal_static_pomelo_area_OnSoloMatchedPush_fieldAccessorTable.ensureFieldAccessorsInitialized(OnSoloMatchedPush.class, Builder.class);
        }

        public static Parser<OnSoloMatchedPush> PARSER = (Parser<OnSoloMatchedPush>) new AbstractParser<OnSoloMatchedPush>() {
            public SoloHandler.OnSoloMatchedPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SoloHandler.OnSoloMatchedPush(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_VSPLAYERNAME_FIELD_NUMBER = 2;
        private Object s2CVsPlayerName_;
        public static final int S2C_VSPLAYERPRO_FIELD_NUMBER = 3;
        private int s2CVsPlayerPro_;
        public static final int S2C_VSPLAYERLEVEL_FIELD_NUMBER = 4;
        private int s2CVsPlayerLevel_;
        public static final int S2C_VSPLAYERAVATARS_FIELD_NUMBER = 5;
        private List<Common.Avatar> s2CVsPlayerAvatars_;
        public static final int S2C_WAITRESPONSETIMESEC_FIELD_NUMBER = 6;
        private int s2CWaitResponseTimeSec_;
        public static final int S2C_ISROBOT_FIELD_NUMBER = 7;
        private int s2CIsRobot_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<OnSoloMatchedPush> getParserForType() {
            return PARSER;
        }

        public boolean hasS2CCode() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getS2CCode() {
            return this.s2CCode_;
        }

        public boolean hasS2CVsPlayerName() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public String getS2CVsPlayerName() {
            Object ref = this.s2CVsPlayerName_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.s2CVsPlayerName_ = s;
            return s;
        }

        public ByteString getS2CVsPlayerNameBytes() {
            Object ref = this.s2CVsPlayerName_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.s2CVsPlayerName_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        static {
            defaultInstance.initFields();
        }


        public boolean hasS2CVsPlayerPro() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public int getS2CVsPlayerPro() {
            return this.s2CVsPlayerPro_;
        }


        public boolean hasS2CVsPlayerLevel() {
            return ((this.bitField0_ & 0x8) == 8);
        }


        public int getS2CVsPlayerLevel() {
            return this.s2CVsPlayerLevel_;
        }


        public List<Common.Avatar> getS2CVsPlayerAvatarsList() {
            return this.s2CVsPlayerAvatars_;
        }


        public List<? extends Common.AvatarOrBuilder> getS2CVsPlayerAvatarsOrBuilderList() {
            return (List) this.s2CVsPlayerAvatars_;
        }


        public int getS2CVsPlayerAvatarsCount() {
            return this.s2CVsPlayerAvatars_.size();
        }


        public Common.Avatar getS2CVsPlayerAvatars(int index) {
            return this.s2CVsPlayerAvatars_.get(index);
        }


        public Common.AvatarOrBuilder getS2CVsPlayerAvatarsOrBuilder(int index) {
            return (Common.AvatarOrBuilder) this.s2CVsPlayerAvatars_.get(index);
        }


        public boolean hasS2CWaitResponseTimeSec() {
            return ((this.bitField0_ & 0x10) == 16);
        }


        public int getS2CWaitResponseTimeSec() {
            return this.s2CWaitResponseTimeSec_;
        }


        public boolean hasS2CIsRobot() {
            return ((this.bitField0_ & 0x20) == 32);
        }


        public int getS2CIsRobot() {
            return this.s2CIsRobot_;
        }


        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CVsPlayerName_ = "";
            this.s2CVsPlayerPro_ = 0;
            this.s2CVsPlayerLevel_ = 0;
            this.s2CVsPlayerAvatars_ = Collections.emptyList();
            this.s2CWaitResponseTimeSec_ = 0;
            this.s2CIsRobot_ = 0;
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
            if (!hasS2CVsPlayerName()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasS2CVsPlayerPro()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasS2CVsPlayerLevel()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasS2CWaitResponseTimeSec()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (int i = 0; i < getS2CVsPlayerAvatarsCount(); i++) {
                if (!getS2CVsPlayerAvatars(i).isInitialized()) {
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
                output.writeBytes(2, getS2CVsPlayerNameBytes());
            }
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeInt32(3, this.s2CVsPlayerPro_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                output.writeInt32(4, this.s2CVsPlayerLevel_);
            }
            for (int i = 0; i < this.s2CVsPlayerAvatars_.size(); i++) {
                output.writeMessage(5, (MessageLite) this.s2CVsPlayerAvatars_.get(i));
            }
            if ((this.bitField0_ & 0x10) == 16) {
                output.writeInt32(6, this.s2CWaitResponseTimeSec_);
            }
            if ((this.bitField0_ & 0x20) == 32) {
                output.writeInt32(7, this.s2CIsRobot_);
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
                size += CodedOutputStream.computeBytesSize(2, getS2CVsPlayerNameBytes());
            }
            if ((this.bitField0_ & 0x4) == 4) {
                size += CodedOutputStream.computeInt32Size(3, this.s2CVsPlayerPro_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                size += CodedOutputStream.computeInt32Size(4, this.s2CVsPlayerLevel_);
            }
            for (int i = 0; i < this.s2CVsPlayerAvatars_.size(); i++) {
                size += CodedOutputStream.computeMessageSize(5, (MessageLite) this.s2CVsPlayerAvatars_.get(i));
            }
            if ((this.bitField0_ & 0x10) == 16) {
                size += CodedOutputStream.computeInt32Size(6, this.s2CWaitResponseTimeSec_);
            }
            if ((this.bitField0_ & 0x20) == 32) {
                size += CodedOutputStream.computeInt32Size(7, this.s2CIsRobot_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static OnSoloMatchedPush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (OnSoloMatchedPush) PARSER.parseFrom(data);
        }


        public static OnSoloMatchedPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (OnSoloMatchedPush) PARSER.parseFrom(data, extensionRegistry);
        }


        public static OnSoloMatchedPush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (OnSoloMatchedPush) PARSER.parseFrom(data);
        }


        public static OnSoloMatchedPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (OnSoloMatchedPush) PARSER.parseFrom(data, extensionRegistry);
        }


        public static OnSoloMatchedPush parseFrom(InputStream input) throws IOException {
            return (OnSoloMatchedPush) PARSER.parseFrom(input);
        }


        public static OnSoloMatchedPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OnSoloMatchedPush) PARSER.parseFrom(input, extensionRegistry);
        }


        public static OnSoloMatchedPush parseDelimitedFrom(InputStream input) throws IOException {
            return (OnSoloMatchedPush) PARSER.parseDelimitedFrom(input);
        }


        public static OnSoloMatchedPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OnSoloMatchedPush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static OnSoloMatchedPush parseFrom(CodedInputStream input) throws IOException {
            return (OnSoloMatchedPush) PARSER.parseFrom(input);
        }


        public static OnSoloMatchedPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OnSoloMatchedPush) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(OnSoloMatchedPush prototype) {
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
                implements SoloHandler.OnSoloMatchedPushOrBuilder {
            private int bitField0_;


            private int s2CCode_;


            private Object s2CVsPlayerName_;


            private int s2CVsPlayerPro_;


            private int s2CVsPlayerLevel_;


            private List<Common.Avatar> s2CVsPlayerAvatars_;


            private RepeatedFieldBuilder<Common.Avatar, Common.Avatar.Builder, Common.AvatarOrBuilder> s2CVsPlayerAvatarsBuilder_;


            private int s2CWaitResponseTimeSec_;


            private int s2CIsRobot_;


            public static final Descriptors.Descriptor getDescriptor() {
                return SoloHandler.internal_static_pomelo_area_OnSoloMatchedPush_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return SoloHandler.internal_static_pomelo_area_OnSoloMatchedPush_fieldAccessorTable.ensureFieldAccessorsInitialized(SoloHandler.OnSoloMatchedPush.class, Builder.class);
            }


            private Builder() {
                this.s2CVsPlayerName_ = "";
                this.s2CVsPlayerAvatars_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CVsPlayerName_ = "";
                this.s2CVsPlayerAvatars_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (SoloHandler.OnSoloMatchedPush.alwaysUseFieldBuilders) {
                    getS2CVsPlayerAvatarsFieldBuilder();
                }
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.s2CCode_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.s2CVsPlayerName_ = "";
                this.bitField0_ &= 0xFFFFFFFD;
                this.s2CVsPlayerPro_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.s2CVsPlayerLevel_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                if (this.s2CVsPlayerAvatarsBuilder_ == null) {
                    this.s2CVsPlayerAvatars_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFEF;
                } else {
                    this.s2CVsPlayerAvatarsBuilder_.clear();
                }
                this.s2CWaitResponseTimeSec_ = 0;
                this.bitField0_ &= 0xFFFFFFDF;
                this.s2CIsRobot_ = 0;
                this.bitField0_ &= 0xFFFFFFBF;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return SoloHandler.internal_static_pomelo_area_OnSoloMatchedPush_descriptor;
            }


            public SoloHandler.OnSoloMatchedPush getDefaultInstanceForType() {
                return SoloHandler.OnSoloMatchedPush.getDefaultInstance();
            }


            public SoloHandler.OnSoloMatchedPush build() {
                SoloHandler.OnSoloMatchedPush result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public SoloHandler.OnSoloMatchedPush buildPartial() {
                SoloHandler.OnSoloMatchedPush result = new SoloHandler.OnSoloMatchedPush(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.s2CVsPlayerName_ = this.s2CVsPlayerName_;
                if ((from_bitField0_ & 0x4) == 4) {
                    to_bitField0_ |= 0x4;
                }
                result.s2CVsPlayerPro_ = this.s2CVsPlayerPro_;
                if ((from_bitField0_ & 0x8) == 8) {
                    to_bitField0_ |= 0x8;
                }
                result.s2CVsPlayerLevel_ = this.s2CVsPlayerLevel_;
                if (this.s2CVsPlayerAvatarsBuilder_ == null) {
                    if ((this.bitField0_ & 0x10) == 16) {
                        this.s2CVsPlayerAvatars_ = Collections.unmodifiableList(this.s2CVsPlayerAvatars_);
                        this.bitField0_ &= 0xFFFFFFEF;
                    }
                    result.s2CVsPlayerAvatars_ = this.s2CVsPlayerAvatars_;
                } else {
                    result.s2CVsPlayerAvatars_ = this.s2CVsPlayerAvatarsBuilder_.build();
                }
                if ((from_bitField0_ & 0x20) == 32) {
                    to_bitField0_ |= 0x10;
                }
                result.s2CWaitResponseTimeSec_ = this.s2CWaitResponseTimeSec_;
                if ((from_bitField0_ & 0x40) == 64) {
                    to_bitField0_ |= 0x20;
                }
                result.s2CIsRobot_ = this.s2CIsRobot_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof SoloHandler.OnSoloMatchedPush) {
                    return mergeFrom((SoloHandler.OnSoloMatchedPush) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(SoloHandler.OnSoloMatchedPush other) {
                if (other == SoloHandler.OnSoloMatchedPush.getDefaultInstance()) {
                    return this;
                }
                if (other.hasS2CCode()) {
                    setS2CCode(other.getS2CCode());
                }
                if (other.hasS2CVsPlayerName()) {
                    this.bitField0_ |= 0x2;
                    this.s2CVsPlayerName_ = other.s2CVsPlayerName_;
                    onChanged();
                }
                if (other.hasS2CVsPlayerPro()) {
                    setS2CVsPlayerPro(other.getS2CVsPlayerPro());
                }
                if (other.hasS2CVsPlayerLevel()) {
                    setS2CVsPlayerLevel(other.getS2CVsPlayerLevel());
                }
                if (this.s2CVsPlayerAvatarsBuilder_ == null) {
                    if (!other.s2CVsPlayerAvatars_.isEmpty()) {
                        if (this.s2CVsPlayerAvatars_.isEmpty()) {
                            this.s2CVsPlayerAvatars_ = other.s2CVsPlayerAvatars_;
                            this.bitField0_ &= 0xFFFFFFEF;
                        } else {
                            ensureS2CVsPlayerAvatarsIsMutable();
                            this.s2CVsPlayerAvatars_.addAll(other.s2CVsPlayerAvatars_);
                        }
                        onChanged();
                    }
                } else if (!other.s2CVsPlayerAvatars_.isEmpty()) {
                    if (this.s2CVsPlayerAvatarsBuilder_.isEmpty()) {
                        this.s2CVsPlayerAvatarsBuilder_.dispose();
                        this.s2CVsPlayerAvatarsBuilder_ = null;
                        this.s2CVsPlayerAvatars_ = other.s2CVsPlayerAvatars_;
                        this.bitField0_ &= 0xFFFFFFEF;
                        this.s2CVsPlayerAvatarsBuilder_ = SoloHandler.OnSoloMatchedPush.alwaysUseFieldBuilders ? getS2CVsPlayerAvatarsFieldBuilder() : null;
                    } else {
                        this.s2CVsPlayerAvatarsBuilder_.addAllMessages(other.s2CVsPlayerAvatars_);
                    }
                }
                if (other.hasS2CWaitResponseTimeSec()) {
                    setS2CWaitResponseTimeSec(other.getS2CWaitResponseTimeSec());
                }
                if (other.hasS2CIsRobot()) {
                    setS2CIsRobot(other.getS2CIsRobot());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasS2CCode()) {
                    return false;
                }
                if (!hasS2CVsPlayerName()) {
                    return false;
                }
                if (!hasS2CVsPlayerPro()) {
                    return false;
                }
                if (!hasS2CVsPlayerLevel()) {
                    return false;
                }
                if (!hasS2CWaitResponseTimeSec()) {
                    return false;
                }
                for (int i = 0; i < getS2CVsPlayerAvatarsCount(); i++) {
                    if (!getS2CVsPlayerAvatars(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                SoloHandler.OnSoloMatchedPush parsedMessage = null;
                try {
                    parsedMessage = (SoloHandler.OnSoloMatchedPush) SoloHandler.OnSoloMatchedPush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SoloHandler.OnSoloMatchedPush) e.getUnfinishedMessage();
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


            public boolean hasS2CVsPlayerName() {
                return ((this.bitField0_ & 0x2) == 2);
            }


            public String getS2CVsPlayerName() {
                Object ref = this.s2CVsPlayerName_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.s2CVsPlayerName_ = s;
                    }
                    return s;
                }
                return (String) ref;
            }


            public ByteString getS2CVsPlayerNameBytes() {
                Object ref = this.s2CVsPlayerName_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.s2CVsPlayerName_ = b;
                    return b;
                }
                return (ByteString) ref;
            }


            public Builder setS2CVsPlayerName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x2;
                this.s2CVsPlayerName_ = value;
                onChanged();
                return this;
            }


            public Builder clearS2CVsPlayerName() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.s2CVsPlayerName_ = SoloHandler.OnSoloMatchedPush.getDefaultInstance().getS2CVsPlayerName();
                onChanged();
                return this;
            }


            public Builder setS2CVsPlayerNameBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x2;
                this.s2CVsPlayerName_ = value;
                onChanged();
                return this;
            }


            public boolean hasS2CVsPlayerPro() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public int getS2CVsPlayerPro() {
                return this.s2CVsPlayerPro_;
            }


            public Builder setS2CVsPlayerPro(int value) {
                this.bitField0_ |= 0x4;
                this.s2CVsPlayerPro_ = value;
                onChanged();
                return this;
            }


            public Builder clearS2CVsPlayerPro() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.s2CVsPlayerPro_ = 0;
                onChanged();
                return this;
            }


            public boolean hasS2CVsPlayerLevel() {
                return ((this.bitField0_ & 0x8) == 8);
            }


            public int getS2CVsPlayerLevel() {
                return this.s2CVsPlayerLevel_;
            }


            public Builder setS2CVsPlayerLevel(int value) {
                this.bitField0_ |= 0x8;
                this.s2CVsPlayerLevel_ = value;
                onChanged();
                return this;
            }


            public Builder clearS2CVsPlayerLevel() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.s2CVsPlayerLevel_ = 0;
                onChanged();
                return this;
            }


            private void ensureS2CVsPlayerAvatarsIsMutable() {
                if ((this.bitField0_ & 0x10) != 16) {
                    this.s2CVsPlayerAvatars_ = new ArrayList<>(this.s2CVsPlayerAvatars_);
                    this.bitField0_ |= 0x10;
                }
            }


            public List<Common.Avatar> getS2CVsPlayerAvatarsList() {
                if (this.s2CVsPlayerAvatarsBuilder_ == null) {
                    return Collections.unmodifiableList(this.s2CVsPlayerAvatars_);
                }
                return this.s2CVsPlayerAvatarsBuilder_.getMessageList();
            }


            public int getS2CVsPlayerAvatarsCount() {
                if (this.s2CVsPlayerAvatarsBuilder_ == null) {
                    return this.s2CVsPlayerAvatars_.size();
                }
                return this.s2CVsPlayerAvatarsBuilder_.getCount();
            }


            public Common.Avatar getS2CVsPlayerAvatars(int index) {
                if (this.s2CVsPlayerAvatarsBuilder_ == null) {
                    return this.s2CVsPlayerAvatars_.get(index);
                }
                return (Common.Avatar) this.s2CVsPlayerAvatarsBuilder_.getMessage(index);
            }


            public Builder setS2CVsPlayerAvatars(int index, Common.Avatar value) {
                if (this.s2CVsPlayerAvatarsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureS2CVsPlayerAvatarsIsMutable();
                    this.s2CVsPlayerAvatars_.set(index, value);
                    onChanged();
                } else {
                    this.s2CVsPlayerAvatarsBuilder_.setMessage(index, (GeneratedMessage) value);
                }
                return this;
            }


            public Builder setS2CVsPlayerAvatars(int index, Common.Avatar.Builder builderForValue) {
                if (this.s2CVsPlayerAvatarsBuilder_ == null) {
                    ensureS2CVsPlayerAvatarsIsMutable();
                    this.s2CVsPlayerAvatars_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CVsPlayerAvatarsBuilder_.setMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }


            public Builder addS2CVsPlayerAvatars(Common.Avatar value) {
                if (this.s2CVsPlayerAvatarsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureS2CVsPlayerAvatarsIsMutable();
                    this.s2CVsPlayerAvatars_.add(value);
                    onChanged();
                } else {
                    this.s2CVsPlayerAvatarsBuilder_.addMessage((GeneratedMessage) value);
                }
                return this;
            }


            public Builder addS2CVsPlayerAvatars(int index, Common.Avatar value) {
                if (this.s2CVsPlayerAvatarsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureS2CVsPlayerAvatarsIsMutable();
                    this.s2CVsPlayerAvatars_.add(index, value);
                    onChanged();
                } else {
                    this.s2CVsPlayerAvatarsBuilder_.addMessage(index, (GeneratedMessage) value);
                }
                return this;
            }


            public Builder addS2CVsPlayerAvatars(Common.Avatar.Builder builderForValue) {
                if (this.s2CVsPlayerAvatarsBuilder_ == null) {
                    ensureS2CVsPlayerAvatarsIsMutable();
                    this.s2CVsPlayerAvatars_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.s2CVsPlayerAvatarsBuilder_.addMessage((GeneratedMessage) builderForValue.build());
                }
                return this;
            }


            public Builder addS2CVsPlayerAvatars(int index, Common.Avatar.Builder builderForValue) {
                if (this.s2CVsPlayerAvatarsBuilder_ == null) {
                    ensureS2CVsPlayerAvatarsIsMutable();
                    this.s2CVsPlayerAvatars_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.s2CVsPlayerAvatarsBuilder_.addMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }


            public Builder addAllS2CVsPlayerAvatars(Iterable<? extends Common.Avatar> values) {
                if (this.s2CVsPlayerAvatarsBuilder_ == null) {
                    ensureS2CVsPlayerAvatarsIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.s2CVsPlayerAvatars_);
                    onChanged();
                } else {
                    this.s2CVsPlayerAvatarsBuilder_.addAllMessages(values);
                }
                return this;
            }


            public Builder clearS2CVsPlayerAvatars() {
                if (this.s2CVsPlayerAvatarsBuilder_ == null) {
                    this.s2CVsPlayerAvatars_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFEF;
                    onChanged();
                } else {
                    this.s2CVsPlayerAvatarsBuilder_.clear();
                }
                return this;
            }


            public Builder removeS2CVsPlayerAvatars(int index) {
                if (this.s2CVsPlayerAvatarsBuilder_ == null) {
                    ensureS2CVsPlayerAvatarsIsMutable();
                    this.s2CVsPlayerAvatars_.remove(index);
                    onChanged();
                } else {
                    this.s2CVsPlayerAvatarsBuilder_.remove(index);
                }
                return this;
            }


            public Common.Avatar.Builder getS2CVsPlayerAvatarsBuilder(int index) {
                return (Common.Avatar.Builder) getS2CVsPlayerAvatarsFieldBuilder().getBuilder(index);
            }


            public Common.AvatarOrBuilder getS2CVsPlayerAvatarsOrBuilder(int index) {
                if (this.s2CVsPlayerAvatarsBuilder_ == null) {
                    return (Common.AvatarOrBuilder) this.s2CVsPlayerAvatars_.get(index);
                }
                return (Common.AvatarOrBuilder) this.s2CVsPlayerAvatarsBuilder_.getMessageOrBuilder(index);
            }


            public List<? extends Common.AvatarOrBuilder> getS2CVsPlayerAvatarsOrBuilderList() {
                if (this.s2CVsPlayerAvatarsBuilder_ != null) {
                    return this.s2CVsPlayerAvatarsBuilder_.getMessageOrBuilderList();
                }
                return (List) Collections.unmodifiableList(this.s2CVsPlayerAvatars_);
            }


            public Common.Avatar.Builder addS2CVsPlayerAvatarsBuilder() {
                return (Common.Avatar.Builder) getS2CVsPlayerAvatarsFieldBuilder().addBuilder((GeneratedMessage) Common.Avatar.getDefaultInstance());
            }


            public Common.Avatar.Builder addS2CVsPlayerAvatarsBuilder(int index) {
                return (Common.Avatar.Builder) getS2CVsPlayerAvatarsFieldBuilder().addBuilder(index, (GeneratedMessage) Common.Avatar.getDefaultInstance());
            }


            public List<Common.Avatar.Builder> getS2CVsPlayerAvatarsBuilderList() {
                return getS2CVsPlayerAvatarsFieldBuilder().getBuilderList();
            }


            private RepeatedFieldBuilder<Common.Avatar, Common.Avatar.Builder, Common.AvatarOrBuilder> getS2CVsPlayerAvatarsFieldBuilder() {
                if (this.s2CVsPlayerAvatarsBuilder_ == null) {
                    this.s2CVsPlayerAvatarsBuilder_ = new RepeatedFieldBuilder(this.s2CVsPlayerAvatars_, ((this.bitField0_ & 0x10) == 16), getParentForChildren(), isClean());
                    this.s2CVsPlayerAvatars_ = null;
                }
                return this.s2CVsPlayerAvatarsBuilder_;
            }


            public boolean hasS2CWaitResponseTimeSec() {
                return ((this.bitField0_ & 0x20) == 32);
            }


            public int getS2CWaitResponseTimeSec() {
                return this.s2CWaitResponseTimeSec_;
            }


            public Builder setS2CWaitResponseTimeSec(int value) {
                this.bitField0_ |= 0x20;
                this.s2CWaitResponseTimeSec_ = value;
                onChanged();
                return this;
            }


            public Builder clearS2CWaitResponseTimeSec() {
                this.bitField0_ &= 0xFFFFFFDF;
                this.s2CWaitResponseTimeSec_ = 0;
                onChanged();
                return this;
            }


            public boolean hasS2CIsRobot() {
                return ((this.bitField0_ & 0x40) == 64);
            }


            public int getS2CIsRobot() {
                return this.s2CIsRobot_;
            }


            public Builder setS2CIsRobot(int value) {
                this.bitField0_ |= 0x40;
                this.s2CIsRobot_ = value;
                onChanged();
                return this;
            }


            public Builder clearS2CIsRobot() {
                this.bitField0_ &= 0xFFFFFFBF;
                this.s2CIsRobot_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class GetRivalInfoResponse
            extends GeneratedMessage
            implements GetRivalInfoResponseOrBuilder {
        private static final GetRivalInfoResponse defaultInstance = new GetRivalInfoResponse(true);
        private final UnknownFieldSet unknownFields;

        private GetRivalInfoResponse(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GetRivalInfoResponse(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GetRivalInfoResponse getDefaultInstance() {
            return defaultInstance;
        }

        public GetRivalInfoResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetRivalInfoResponse(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.s2CVsPlayerName_ = bs;
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.s2CVsPlayerPro_ = input.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.s2CVsPlayerLevel_ = input.readInt32();
                            break;
                        case 42:
                            bs = input.readBytes();
                            this.bitField0_ |= 0x10;
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
            return SoloHandler.internal_static_pomelo_area_GetRivalInfoResponse_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return SoloHandler.internal_static_pomelo_area_GetRivalInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(GetRivalInfoResponse.class, Builder.class);
        }

        public static Parser<GetRivalInfoResponse> PARSER = (Parser<GetRivalInfoResponse>) new AbstractParser<GetRivalInfoResponse>() {
            public SoloHandler.GetRivalInfoResponse parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SoloHandler.GetRivalInfoResponse(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_VSPLAYERNAME_FIELD_NUMBER = 2;
        private Object s2CVsPlayerName_;
        public static final int S2C_VSPLAYERPRO_FIELD_NUMBER = 3;
        private int s2CVsPlayerPro_;
        public static final int S2C_VSPLAYERLEVEL_FIELD_NUMBER = 4;
        private int s2CVsPlayerLevel_;
        public static final int S2C_MSG_FIELD_NUMBER = 5;
        private Object s2CMsg_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GetRivalInfoResponse> getParserForType() {
            return PARSER;
        }

        public boolean hasS2CCode() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getS2CCode() {
            return this.s2CCode_;
        }

        public boolean hasS2CVsPlayerName() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public String getS2CVsPlayerName() {
            Object ref = this.s2CVsPlayerName_;
            if (ref instanceof String) return (String) ref;
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) this.s2CVsPlayerName_ = s;
            return s;
        }

        static {
            defaultInstance.initFields();
        }

        public ByteString getS2CVsPlayerNameBytes() {
            Object ref = this.s2CVsPlayerName_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.s2CVsPlayerName_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasS2CVsPlayerPro() {
            return ((this.bitField0_ & 0x4) == 4);
        }

        public int getS2CVsPlayerPro() {
            return this.s2CVsPlayerPro_;
        }

        public boolean hasS2CVsPlayerLevel() {
            return ((this.bitField0_ & 0x8) == 8);
        }

        public int getS2CVsPlayerLevel() {
            return this.s2CVsPlayerLevel_;
        }

        public boolean hasS2CMsg() {
            return ((this.bitField0_ & 0x10) == 16);
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
            this.s2CVsPlayerName_ = "";
            this.s2CVsPlayerPro_ = 0;
            this.s2CVsPlayerLevel_ = 0;
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
            if (!hasS2CVsPlayerName()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasS2CVsPlayerPro()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasS2CVsPlayerLevel()) {
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
                output.writeBytes(2, getS2CVsPlayerNameBytes());
            if ((this.bitField0_ & 0x4) == 4)
                output.writeInt32(3, this.s2CVsPlayerPro_);
            if ((this.bitField0_ & 0x8) == 8)
                output.writeInt32(4, this.s2CVsPlayerLevel_);
            if ((this.bitField0_ & 0x10) == 16)
                output.writeBytes(5, getS2CMsgBytes());
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
                size += CodedOutputStream.computeBytesSize(2, getS2CVsPlayerNameBytes());
            if ((this.bitField0_ & 0x4) == 4)
                size += CodedOutputStream.computeInt32Size(3, this.s2CVsPlayerPro_);
            if ((this.bitField0_ & 0x8) == 8)
                size += CodedOutputStream.computeInt32Size(4, this.s2CVsPlayerLevel_);
            if ((this.bitField0_ & 0x10) == 16)
                size += CodedOutputStream.computeBytesSize(5, getS2CMsgBytes());
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static GetRivalInfoResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetRivalInfoResponse) PARSER.parseFrom(data);
        }

        public static GetRivalInfoResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetRivalInfoResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetRivalInfoResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetRivalInfoResponse) PARSER.parseFrom(data);
        }

        public static GetRivalInfoResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetRivalInfoResponse) PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetRivalInfoResponse parseFrom(InputStream input) throws IOException {
            return (GetRivalInfoResponse) PARSER.parseFrom(input);
        }

        public static GetRivalInfoResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetRivalInfoResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static GetRivalInfoResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (GetRivalInfoResponse) PARSER.parseDelimitedFrom(input);
        }

        public static GetRivalInfoResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetRivalInfoResponse) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static GetRivalInfoResponse parseFrom(CodedInputStream input) throws IOException {
            return (GetRivalInfoResponse) PARSER.parseFrom(input);
        }

        public static GetRivalInfoResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetRivalInfoResponse) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(GetRivalInfoResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements SoloHandler.GetRivalInfoResponseOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private Object s2CVsPlayerName_;
            private int s2CVsPlayerPro_;
            private int s2CVsPlayerLevel_;
            private Object s2CMsg_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SoloHandler.internal_static_pomelo_area_GetRivalInfoResponse_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return SoloHandler.internal_static_pomelo_area_GetRivalInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(SoloHandler.GetRivalInfoResponse.class, Builder.class);
            }

            private Builder() {
                this.s2CVsPlayerName_ = "";
                this.s2CMsg_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CVsPlayerName_ = "";
                this.s2CMsg_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SoloHandler.GetRivalInfoResponse.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.s2CCode_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.s2CVsPlayerName_ = "";
                this.bitField0_ &= 0xFFFFFFFD;
                this.s2CVsPlayerPro_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.s2CVsPlayerLevel_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                this.s2CMsg_ = "";
                this.bitField0_ &= 0xFFFFFFEF;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return SoloHandler.internal_static_pomelo_area_GetRivalInfoResponse_descriptor;
            }

            public SoloHandler.GetRivalInfoResponse getDefaultInstanceForType() {
                return SoloHandler.GetRivalInfoResponse.getDefaultInstance();
            }

            public SoloHandler.GetRivalInfoResponse build() {
                SoloHandler.GetRivalInfoResponse result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public SoloHandler.GetRivalInfoResponse buildPartial() {
                SoloHandler.GetRivalInfoResponse result = new SoloHandler.GetRivalInfoResponse(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2)
                    to_bitField0_ |= 0x2;
                result.s2CVsPlayerName_ = this.s2CVsPlayerName_;
                if ((from_bitField0_ & 0x4) == 4)
                    to_bitField0_ |= 0x4;
                result.s2CVsPlayerPro_ = this.s2CVsPlayerPro_;
                if ((from_bitField0_ & 0x8) == 8)
                    to_bitField0_ |= 0x8;
                result.s2CVsPlayerLevel_ = this.s2CVsPlayerLevel_;
                if ((from_bitField0_ & 0x10) == 16)
                    to_bitField0_ |= 0x10;
                result.s2CMsg_ = this.s2CMsg_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof SoloHandler.GetRivalInfoResponse)
                    return mergeFrom((SoloHandler.GetRivalInfoResponse) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SoloHandler.GetRivalInfoResponse other) {
                if (other == SoloHandler.GetRivalInfoResponse.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (other.hasS2CVsPlayerName()) {
                    this.bitField0_ |= 0x2;
                    this.s2CVsPlayerName_ = other.s2CVsPlayerName_;
                    onChanged();
                }
                if (other.hasS2CVsPlayerPro())
                    setS2CVsPlayerPro(other.getS2CVsPlayerPro());
                if (other.hasS2CVsPlayerLevel())
                    setS2CVsPlayerLevel(other.getS2CVsPlayerLevel());
                if (other.hasS2CMsg()) {
                    this.bitField0_ |= 0x10;
                    this.s2CMsg_ = other.s2CMsg_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode())
                    return false;
                if (!hasS2CVsPlayerName())
                    return false;
                if (!hasS2CVsPlayerPro())
                    return false;
                if (!hasS2CVsPlayerLevel())
                    return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                SoloHandler.GetRivalInfoResponse parsedMessage = null;
                try {
                    parsedMessage = (SoloHandler.GetRivalInfoResponse) SoloHandler.GetRivalInfoResponse.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SoloHandler.GetRivalInfoResponse) e.getUnfinishedMessage();
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

            public boolean hasS2CVsPlayerName() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public String getS2CVsPlayerName() {
                Object ref = this.s2CVsPlayerName_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8())
                        this.s2CVsPlayerName_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getS2CVsPlayerNameBytes() {
                Object ref = this.s2CVsPlayerName_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.s2CVsPlayerName_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setS2CVsPlayerName(String value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x2;
                this.s2CVsPlayerName_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CVsPlayerName() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.s2CVsPlayerName_ = SoloHandler.GetRivalInfoResponse.getDefaultInstance().getS2CVsPlayerName();
                onChanged();
                return this;
            }

            public Builder setS2CVsPlayerNameBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x2;
                this.s2CVsPlayerName_ = value;
                onChanged();
                return this;
            }

            public boolean hasS2CVsPlayerPro() {
                return ((this.bitField0_ & 0x4) == 4);
            }

            public int getS2CVsPlayerPro() {
                return this.s2CVsPlayerPro_;
            }

            public Builder setS2CVsPlayerPro(int value) {
                this.bitField0_ |= 0x4;
                this.s2CVsPlayerPro_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CVsPlayerPro() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.s2CVsPlayerPro_ = 0;
                onChanged();
                return this;
            }

            public boolean hasS2CVsPlayerLevel() {
                return ((this.bitField0_ & 0x8) == 8);
            }

            public int getS2CVsPlayerLevel() {
                return this.s2CVsPlayerLevel_;
            }

            public Builder setS2CVsPlayerLevel(int value) {
                this.bitField0_ |= 0x8;
                this.s2CVsPlayerLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CVsPlayerLevel() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.s2CVsPlayerLevel_ = 0;
                onChanged();
                return this;
            }

            public boolean hasS2CMsg() {
                return ((this.bitField0_ & 0x10) == 16);
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
                this.bitField0_ |= 0x10;
                this.s2CMsg_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CMsg() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.s2CMsg_ = SoloHandler.GetRivalInfoResponse.getDefaultInstance().getS2CMsg();
                onChanged();
                return this;
            }

            public Builder setS2CMsgBytes(ByteString value) {
                if (value == null)
                    throw new NullPointerException();
                this.bitField0_ |= 0x10;
                this.s2CMsg_ = value;
                onChanged();
                return this;
            }
        }
    }

    public static final class OnNewRewardPush extends GeneratedMessage implements OnNewRewardPushOrBuilder {
        private static final OnNewRewardPush defaultInstance = new OnNewRewardPush(true);
        private final UnknownFieldSet unknownFields;

        private OnNewRewardPush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private OnNewRewardPush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static OnNewRewardPush getDefaultInstance() {
            return defaultInstance;
        }

        public OnNewRewardPush getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private OnNewRewardPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return SoloHandler.internal_static_pomelo_area_OnNewRewardPush_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return SoloHandler.internal_static_pomelo_area_OnNewRewardPush_fieldAccessorTable.ensureFieldAccessorsInitialized(OnNewRewardPush.class, Builder.class);
        }

        public static Parser<OnNewRewardPush> PARSER = (Parser<OnNewRewardPush>) new AbstractParser<OnNewRewardPush>() {
            public SoloHandler.OnNewRewardPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SoloHandler.OnNewRewardPush(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<OnNewRewardPush> getParserForType() {
            return PARSER;
        }

        public boolean hasS2CCode() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getS2CCode() {
            return this.s2CCode_;
        }

        private void initFields() {
            this.s2CCode_ = 0;
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
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static OnNewRewardPush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (OnNewRewardPush) PARSER.parseFrom(data);
        }

        public static OnNewRewardPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (OnNewRewardPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static OnNewRewardPush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (OnNewRewardPush) PARSER.parseFrom(data);
        }

        public static OnNewRewardPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (OnNewRewardPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static OnNewRewardPush parseFrom(InputStream input) throws IOException {
            return (OnNewRewardPush) PARSER.parseFrom(input);
        }

        public static OnNewRewardPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OnNewRewardPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static OnNewRewardPush parseDelimitedFrom(InputStream input) throws IOException {
            return (OnNewRewardPush) PARSER.parseDelimitedFrom(input);
        }

        public static OnNewRewardPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OnNewRewardPush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static OnNewRewardPush parseFrom(CodedInputStream input) throws IOException {
            return (OnNewRewardPush) PARSER.parseFrom(input);
        }

        public static OnNewRewardPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OnNewRewardPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(OnNewRewardPush prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements SoloHandler.OnNewRewardPushOrBuilder {
            private int bitField0_;
            private int s2CCode_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SoloHandler.internal_static_pomelo_area_OnNewRewardPush_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return SoloHandler.internal_static_pomelo_area_OnNewRewardPush_fieldAccessorTable.ensureFieldAccessorsInitialized(SoloHandler.OnNewRewardPush.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SoloHandler.OnNewRewardPush.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.s2CCode_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return SoloHandler.internal_static_pomelo_area_OnNewRewardPush_descriptor;
            }

            public SoloHandler.OnNewRewardPush getDefaultInstanceForType() {
                return SoloHandler.OnNewRewardPush.getDefaultInstance();
            }

            public SoloHandler.OnNewRewardPush build() {
                SoloHandler.OnNewRewardPush result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public SoloHandler.OnNewRewardPush buildPartial() {
                SoloHandler.OnNewRewardPush result = new SoloHandler.OnNewRewardPush(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof SoloHandler.OnNewRewardPush) return mergeFrom((SoloHandler.OnNewRewardPush) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SoloHandler.OnNewRewardPush other) {
                if (other == SoloHandler.OnNewRewardPush.getDefaultInstance()) return this;
                if (other.hasS2CCode()) setS2CCode(other.getS2CCode());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                SoloHandler.OnNewRewardPush parsedMessage = null;
                try {
                    parsedMessage = (SoloHandler.OnNewRewardPush) SoloHandler.OnNewRewardPush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SoloHandler.OnNewRewardPush) e.getUnfinishedMessage();
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
        }

        static {
            defaultInstance.initFields();
        }
    }


    public static final class OnFightPointPush
            extends GeneratedMessage
            implements OnFightPointPushOrBuilder {
        private static final OnFightPointPush defaultInstance = new OnFightPointPush(true);
        private final UnknownFieldSet unknownFields;

        private OnFightPointPush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private OnFightPointPush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static OnFightPointPush getDefaultInstance() {
            return defaultInstance;
        }

        public OnFightPointPush getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private OnFightPointPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.s2CFightPoint_ = input.readInt32();
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
            return SoloHandler.internal_static_pomelo_area_OnFightPointPush_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return SoloHandler.internal_static_pomelo_area_OnFightPointPush_fieldAccessorTable.ensureFieldAccessorsInitialized(OnFightPointPush.class, Builder.class);
        }

        public static Parser<OnFightPointPush> PARSER = (Parser<OnFightPointPush>) new AbstractParser<OnFightPointPush>() {
            public SoloHandler.OnFightPointPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SoloHandler.OnFightPointPush(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_FIGHTPOINT_FIELD_NUMBER = 2;
        private int s2CFightPoint_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<OnFightPointPush> getParserForType() {
            return PARSER;
        }

        public boolean hasS2CCode() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getS2CCode() {
            return this.s2CCode_;
        }

        public boolean hasS2CFightPoint() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public int getS2CFightPoint() {
            return this.s2CFightPoint_;
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CFightPoint_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasS2CCode()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasS2CFightPoint()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2) output.writeInt32(2, this.s2CFightPoint_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2) size += CodedOutputStream.computeInt32Size(2, this.s2CFightPoint_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static OnFightPointPush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (OnFightPointPush) PARSER.parseFrom(data);
        }

        public static OnFightPointPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (OnFightPointPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static OnFightPointPush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (OnFightPointPush) PARSER.parseFrom(data);
        }

        public static OnFightPointPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (OnFightPointPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static OnFightPointPush parseFrom(InputStream input) throws IOException {
            return (OnFightPointPush) PARSER.parseFrom(input);
        }

        public static OnFightPointPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OnFightPointPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static OnFightPointPush parseDelimitedFrom(InputStream input) throws IOException {
            return (OnFightPointPush) PARSER.parseDelimitedFrom(input);
        }

        public static OnFightPointPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OnFightPointPush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static OnFightPointPush parseFrom(CodedInputStream input) throws IOException {
            return (OnFightPointPush) PARSER.parseFrom(input);
        }

        public static OnFightPointPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OnFightPointPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(OnFightPointPush prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements SoloHandler.OnFightPointPushOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private int s2CFightPoint_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SoloHandler.internal_static_pomelo_area_OnFightPointPush_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return SoloHandler.internal_static_pomelo_area_OnFightPointPush_fieldAccessorTable.ensureFieldAccessorsInitialized(SoloHandler.OnFightPointPush.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SoloHandler.OnFightPointPush.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.s2CCode_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.s2CFightPoint_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return SoloHandler.internal_static_pomelo_area_OnFightPointPush_descriptor;
            }

            public SoloHandler.OnFightPointPush getDefaultInstanceForType() {
                return SoloHandler.OnFightPointPush.getDefaultInstance();
            }

            public SoloHandler.OnFightPointPush build() {
                SoloHandler.OnFightPointPush result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public SoloHandler.OnFightPointPush buildPartial() {
                SoloHandler.OnFightPointPush result = new SoloHandler.OnFightPointPush(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                result.s2CFightPoint_ = this.s2CFightPoint_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof SoloHandler.OnFightPointPush)
                    return mergeFrom((SoloHandler.OnFightPointPush) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SoloHandler.OnFightPointPush other) {
                if (other == SoloHandler.OnFightPointPush.getDefaultInstance()) return this;
                if (other.hasS2CCode()) setS2CCode(other.getS2CCode());
                if (other.hasS2CFightPoint()) setS2CFightPoint(other.getS2CFightPoint());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode()) return false;
                if (!hasS2CFightPoint()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                SoloHandler.OnFightPointPush parsedMessage = null;
                try {
                    parsedMessage = (SoloHandler.OnFightPointPush) SoloHandler.OnFightPointPush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SoloHandler.OnFightPointPush) e.getUnfinishedMessage();
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

            public boolean hasS2CFightPoint() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public int getS2CFightPoint() {
                return this.s2CFightPoint_;
            }

            public Builder setS2CFightPoint(int value) {
                this.bitField0_ |= 0x2;
                this.s2CFightPoint_ = value;
                onChanged();
                return this;
            }

            public Builder clearS2CFightPoint() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.s2CFightPoint_ = 0;
                onChanged();
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class RoundResult
            extends GeneratedMessage
            implements RoundResultOrBuilder {
        private static final RoundResult defaultInstance = new RoundResult(true);
        private final UnknownFieldSet unknownFields;

        private RoundResult(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private RoundResult(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static RoundResult getDefaultInstance() {
            return defaultInstance;
        }

        public RoundResult getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private RoundResult(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.result_ = input.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.myWinTimes_ = input.readInt32();
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.vsWinTimes_ = input.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.leftTime_ = input.readInt32();
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
            return SoloHandler.internal_static_pomelo_area_RoundResult_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return SoloHandler.internal_static_pomelo_area_RoundResult_fieldAccessorTable.ensureFieldAccessorsInitialized(RoundResult.class, Builder.class);
        }

        public static Parser<RoundResult> PARSER = (Parser<RoundResult>) new AbstractParser<RoundResult>() {
            public SoloHandler.RoundResult parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SoloHandler.RoundResult(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int RESULT_FIELD_NUMBER = 1;
        private int result_;
        public static final int MYWINTIMES_FIELD_NUMBER = 2;
        private int myWinTimes_;
        public static final int VSWINTIMES_FIELD_NUMBER = 3;
        private int vsWinTimes_;
        public static final int LEFTTIME_FIELD_NUMBER = 4;
        private int leftTime_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<RoundResult> getParserForType() {
            return PARSER;
        }

        public boolean hasResult() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getResult() {
            return this.result_;
        }

        public boolean hasMyWinTimes() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        static {
            defaultInstance.initFields();
        }


        public int getMyWinTimes() {
            return this.myWinTimes_;
        }


        public boolean hasVsWinTimes() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public int getVsWinTimes() {
            return this.vsWinTimes_;
        }


        public boolean hasLeftTime() {
            return ((this.bitField0_ & 0x8) == 8);
        }


        public int getLeftTime() {
            return this.leftTime_;
        }


        private void initFields() {
            this.result_ = 0;
            this.myWinTimes_ = 0;
            this.vsWinTimes_ = 0;
            this.leftTime_ = 0;
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasResult()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasMyWinTimes()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasVsWinTimes()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasLeftTime()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeInt32(1, this.result_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeInt32(2, this.myWinTimes_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeInt32(3, this.vsWinTimes_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                output.writeInt32(4, this.leftTime_);
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
                size += CodedOutputStream.computeInt32Size(1, this.result_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeInt32Size(2, this.myWinTimes_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                size += CodedOutputStream.computeInt32Size(3, this.vsWinTimes_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                size += CodedOutputStream.computeInt32Size(4, this.leftTime_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static RoundResult parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (RoundResult) PARSER.parseFrom(data);
        }


        public static RoundResult parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (RoundResult) PARSER.parseFrom(data, extensionRegistry);
        }


        public static RoundResult parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (RoundResult) PARSER.parseFrom(data);
        }


        public static RoundResult parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (RoundResult) PARSER.parseFrom(data, extensionRegistry);
        }


        public static RoundResult parseFrom(InputStream input) throws IOException {
            return (RoundResult) PARSER.parseFrom(input);
        }


        public static RoundResult parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RoundResult) PARSER.parseFrom(input, extensionRegistry);
        }


        public static RoundResult parseDelimitedFrom(InputStream input) throws IOException {
            return (RoundResult) PARSER.parseDelimitedFrom(input);
        }


        public static RoundResult parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RoundResult) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static RoundResult parseFrom(CodedInputStream input) throws IOException {
            return (RoundResult) PARSER.parseFrom(input);
        }


        public static RoundResult parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RoundResult) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(RoundResult prototype) {
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
                implements SoloHandler.RoundResultOrBuilder {
            private int bitField0_;


            private int result_;


            private int myWinTimes_;


            private int vsWinTimes_;


            private int leftTime_;


            public static final Descriptors.Descriptor getDescriptor() {
                return SoloHandler.internal_static_pomelo_area_RoundResult_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return SoloHandler.internal_static_pomelo_area_RoundResult_fieldAccessorTable.ensureFieldAccessorsInitialized(SoloHandler.RoundResult.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (SoloHandler.RoundResult.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.result_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.myWinTimes_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                this.vsWinTimes_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.leftTime_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return SoloHandler.internal_static_pomelo_area_RoundResult_descriptor;
            }


            public SoloHandler.RoundResult getDefaultInstanceForType() {
                return SoloHandler.RoundResult.getDefaultInstance();
            }


            public SoloHandler.RoundResult build() {
                SoloHandler.RoundResult result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public SoloHandler.RoundResult buildPartial() {
                SoloHandler.RoundResult result = new SoloHandler.RoundResult(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.result_ = this.result_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.myWinTimes_ = this.myWinTimes_;
                if ((from_bitField0_ & 0x4) == 4) {
                    to_bitField0_ |= 0x4;
                }
                result.vsWinTimes_ = this.vsWinTimes_;
                if ((from_bitField0_ & 0x8) == 8) {
                    to_bitField0_ |= 0x8;
                }
                result.leftTime_ = this.leftTime_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof SoloHandler.RoundResult) {
                    return mergeFrom((SoloHandler.RoundResult) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(SoloHandler.RoundResult other) {
                if (other == SoloHandler.RoundResult.getDefaultInstance()) {
                    return this;
                }
                if (other.hasResult()) {
                    setResult(other.getResult());
                }
                if (other.hasMyWinTimes()) {
                    setMyWinTimes(other.getMyWinTimes());
                }
                if (other.hasVsWinTimes()) {
                    setVsWinTimes(other.getVsWinTimes());
                }
                if (other.hasLeftTime()) {
                    setLeftTime(other.getLeftTime());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasResult()) {
                    return false;
                }
                if (!hasMyWinTimes()) {
                    return false;
                }
                if (!hasVsWinTimes()) {
                    return false;
                }
                if (!hasLeftTime()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                SoloHandler.RoundResult parsedMessage = null;
                try {
                    parsedMessage = (SoloHandler.RoundResult) SoloHandler.RoundResult.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SoloHandler.RoundResult) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasResult() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public int getResult() {
                return this.result_;
            }


            public Builder setResult(int value) {
                this.bitField0_ |= 0x1;
                this.result_ = value;
                onChanged();
                return this;
            }


            public Builder clearResult() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.result_ = 0;
                onChanged();
                return this;
            }


            public boolean hasMyWinTimes() {
                return ((this.bitField0_ & 0x2) == 2);
            }


            public int getMyWinTimes() {
                return this.myWinTimes_;
            }


            public Builder setMyWinTimes(int value) {
                this.bitField0_ |= 0x2;
                this.myWinTimes_ = value;
                onChanged();
                return this;
            }


            public Builder clearMyWinTimes() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.myWinTimes_ = 0;
                onChanged();
                return this;
            }


            public boolean hasVsWinTimes() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public int getVsWinTimes() {
                return this.vsWinTimes_;
            }


            public Builder setVsWinTimes(int value) {
                this.bitField0_ |= 0x4;
                this.vsWinTimes_ = value;
                onChanged();
                return this;
            }


            public Builder clearVsWinTimes() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.vsWinTimes_ = 0;
                onChanged();
                return this;
            }


            public boolean hasLeftTime() {
                return ((this.bitField0_ & 0x8) == 8);
            }


            public int getLeftTime() {
                return this.leftTime_;
            }


            public Builder setLeftTime(int value) {
                this.bitField0_ |= 0x8;
                this.leftTime_ = value;
                onChanged();
                return this;
            }


            public Builder clearLeftTime() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.leftTime_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class OnRoundEndPush
            extends GeneratedMessage
            implements OnRoundEndPushOrBuilder {
        private static final OnRoundEndPush defaultInstance = new OnRoundEndPush(true);
        private final UnknownFieldSet unknownFields;

        private OnRoundEndPush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private OnRoundEndPush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static OnRoundEndPush getDefaultInstance() {
            return defaultInstance;
        }

        public OnRoundEndPush getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private OnRoundEndPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    SoloHandler.RoundResult.Builder subBuilder;
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
                            subBuilder = null;
                            if ((this.bitField0_ & 0x2) == 2) subBuilder = this.s2CRoundResult_.toBuilder();
                            this.s2CRoundResult_ = (SoloHandler.RoundResult) input.readMessage(SoloHandler.RoundResult.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.s2CRoundResult_);
                                this.s2CRoundResult_ = subBuilder.buildPartial();
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
            return SoloHandler.internal_static_pomelo_area_OnRoundEndPush_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return SoloHandler.internal_static_pomelo_area_OnRoundEndPush_fieldAccessorTable.ensureFieldAccessorsInitialized(OnRoundEndPush.class, Builder.class);
        }

        public static Parser<OnRoundEndPush> PARSER = (Parser<OnRoundEndPush>) new AbstractParser<OnRoundEndPush>() {
            public SoloHandler.OnRoundEndPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SoloHandler.OnRoundEndPush(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_ROUNDRESULT_FIELD_NUMBER = 2;
        private SoloHandler.RoundResult s2CRoundResult_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<OnRoundEndPush> getParserForType() {
            return PARSER;
        }

        public boolean hasS2CCode() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getS2CCode() {
            return this.s2CCode_;
        }

        public boolean hasS2CRoundResult() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        public SoloHandler.RoundResult getS2CRoundResult() {
            return this.s2CRoundResult_;
        }

        public SoloHandler.RoundResultOrBuilder getS2CRoundResultOrBuilder() {
            return this.s2CRoundResult_;
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CRoundResult_ = SoloHandler.RoundResult.getDefaultInstance();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;
            if (!hasS2CCode()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasS2CRoundResult()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!getS2CRoundResult().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) output.writeInt32(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2) output.writeMessage(2, (MessageLite) this.s2CRoundResult_);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            if ((this.bitField0_ & 0x2) == 2)
                size += CodedOutputStream.computeMessageSize(2, (MessageLite) this.s2CRoundResult_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static OnRoundEndPush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (OnRoundEndPush) PARSER.parseFrom(data);
        }

        public static OnRoundEndPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (OnRoundEndPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static OnRoundEndPush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (OnRoundEndPush) PARSER.parseFrom(data);
        }

        public static OnRoundEndPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (OnRoundEndPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static OnRoundEndPush parseFrom(InputStream input) throws IOException {
            return (OnRoundEndPush) PARSER.parseFrom(input);
        }

        public static OnRoundEndPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OnRoundEndPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static OnRoundEndPush parseDelimitedFrom(InputStream input) throws IOException {
            return (OnRoundEndPush) PARSER.parseDelimitedFrom(input);
        }

        public static OnRoundEndPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OnRoundEndPush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static OnRoundEndPush parseFrom(CodedInputStream input) throws IOException {
            return (OnRoundEndPush) PARSER.parseFrom(input);
        }

        public static OnRoundEndPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OnRoundEndPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(OnRoundEndPush prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements SoloHandler.OnRoundEndPushOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private SoloHandler.RoundResult s2CRoundResult_;
            private SingleFieldBuilder<SoloHandler.RoundResult, SoloHandler.RoundResult.Builder, SoloHandler.RoundResultOrBuilder> s2CRoundResultBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SoloHandler.internal_static_pomelo_area_OnRoundEndPush_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return SoloHandler.internal_static_pomelo_area_OnRoundEndPush_fieldAccessorTable.ensureFieldAccessorsInitialized(SoloHandler.OnRoundEndPush.class, Builder.class);
            }

            private Builder() {
                this.s2CRoundResult_ = SoloHandler.RoundResult.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CRoundResult_ = SoloHandler.RoundResult.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SoloHandler.OnRoundEndPush.alwaysUseFieldBuilders) getS2CRoundResultFieldBuilder();
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.s2CCode_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                if (this.s2CRoundResultBuilder_ == null) {
                    this.s2CRoundResult_ = SoloHandler.RoundResult.getDefaultInstance();
                } else {
                    this.s2CRoundResultBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return SoloHandler.internal_static_pomelo_area_OnRoundEndPush_descriptor;
            }

            public SoloHandler.OnRoundEndPush getDefaultInstanceForType() {
                return SoloHandler.OnRoundEndPush.getDefaultInstance();
            }

            public SoloHandler.OnRoundEndPush build() {
                SoloHandler.OnRoundEndPush result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public SoloHandler.OnRoundEndPush buildPartial() {
                SoloHandler.OnRoundEndPush result = new SoloHandler.OnRoundEndPush(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2) to_bitField0_ |= 0x2;
                if (this.s2CRoundResultBuilder_ == null) {
                    result.s2CRoundResult_ = this.s2CRoundResult_;
                } else {
                    result.s2CRoundResult_ = (SoloHandler.RoundResult) this.s2CRoundResultBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof SoloHandler.OnRoundEndPush) return mergeFrom((SoloHandler.OnRoundEndPush) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SoloHandler.OnRoundEndPush other) {
                if (other == SoloHandler.OnRoundEndPush.getDefaultInstance()) return this;
                if (other.hasS2CCode()) setS2CCode(other.getS2CCode());
                if (other.hasS2CRoundResult()) mergeS2CRoundResult(other.getS2CRoundResult());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode()) return false;
                if (!hasS2CRoundResult()) return false;
                if (!getS2CRoundResult().isInitialized()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                SoloHandler.OnRoundEndPush parsedMessage = null;
                try {
                    parsedMessage = (SoloHandler.OnRoundEndPush) SoloHandler.OnRoundEndPush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SoloHandler.OnRoundEndPush) e.getUnfinishedMessage();
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

            public boolean hasS2CRoundResult() {
                return ((this.bitField0_ & 0x2) == 2);
            }

            public SoloHandler.RoundResult getS2CRoundResult() {
                if (this.s2CRoundResultBuilder_ == null) return this.s2CRoundResult_;
                return (SoloHandler.RoundResult) this.s2CRoundResultBuilder_.getMessage();
            }

            public Builder setS2CRoundResult(SoloHandler.RoundResult value) {
                if (this.s2CRoundResultBuilder_ == null) {
                    if (value == null) throw new NullPointerException();
                    this.s2CRoundResult_ = value;
                    onChanged();
                } else {
                    this.s2CRoundResultBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x2;
                return this;
            }

            public Builder setS2CRoundResult(SoloHandler.RoundResult.Builder builderForValue) {
                if (this.s2CRoundResultBuilder_ == null) {
                    this.s2CRoundResult_ = builderForValue.build();
                    onChanged();
                } else {
                    this.s2CRoundResultBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x2;
                return this;
            }

            public Builder mergeS2CRoundResult(SoloHandler.RoundResult value) {
                if (this.s2CRoundResultBuilder_ == null) {
                    if ((this.bitField0_ & 0x2) == 2 && this.s2CRoundResult_ != SoloHandler.RoundResult.getDefaultInstance()) {
                        this.s2CRoundResult_ = SoloHandler.RoundResult.newBuilder(this.s2CRoundResult_).mergeFrom(value).buildPartial();
                    } else {
                        this.s2CRoundResult_ = value;
                    }
                    onChanged();
                } else {
                    this.s2CRoundResultBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x2;
                return this;
            }

            public Builder clearS2CRoundResult() {
                if (this.s2CRoundResultBuilder_ == null) {
                    this.s2CRoundResult_ = SoloHandler.RoundResult.getDefaultInstance();
                    onChanged();
                } else {
                    this.s2CRoundResultBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            public SoloHandler.RoundResult.Builder getS2CRoundResultBuilder() {
                this.bitField0_ |= 0x2;
                onChanged();
                return (SoloHandler.RoundResult.Builder) getS2CRoundResultFieldBuilder().getBuilder();
            }

            public SoloHandler.RoundResultOrBuilder getS2CRoundResultOrBuilder() {
                if (this.s2CRoundResultBuilder_ != null)
                    return (SoloHandler.RoundResultOrBuilder) this.s2CRoundResultBuilder_.getMessageOrBuilder();
                return this.s2CRoundResult_;
            }

            private SingleFieldBuilder<SoloHandler.RoundResult, SoloHandler.RoundResult.Builder, SoloHandler.RoundResultOrBuilder> getS2CRoundResultFieldBuilder() {
                if (this.s2CRoundResultBuilder_ == null) {
                    this.s2CRoundResultBuilder_ = new SingleFieldBuilder(getS2CRoundResult(), getParentForChildren(), isClean());
                    this.s2CRoundResult_ = null;
                }
                return this.s2CRoundResultBuilder_;
            }
        }

        static {
            defaultInstance.initFields();
        }

    }


    public static final class GameResult
            extends GeneratedMessage
            implements GameResultOrBuilder {
        private static final GameResult defaultInstance = new GameResult(true);
        private final UnknownFieldSet unknownFields;

        private GameResult(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private GameResult(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static GameResult getDefaultInstance() {
            return defaultInstance;
        }

        public GameResult getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GameResult(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.result_ = input.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 0x2;
                            this.newScore_ = input.readInt32();
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.currScore_ = input.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.tokenChange_ = input.readInt32();
                            break;
                        case 40:
                            this.bitField0_ |= 0x10;
                            this.rankChange_ = input.readInt32();
                            break;
                        case 48:
                            this.bitField0_ |= 0x20;
                            this.currentRank_ = input.readInt32();
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
            return SoloHandler.internal_static_pomelo_area_GameResult_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return SoloHandler.internal_static_pomelo_area_GameResult_fieldAccessorTable.ensureFieldAccessorsInitialized(GameResult.class, Builder.class);
        }

        public static Parser<GameResult> PARSER = (Parser<GameResult>) new AbstractParser<GameResult>() {
            public SoloHandler.GameResult parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SoloHandler.GameResult(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int RESULT_FIELD_NUMBER = 1;
        private int result_;
        public static final int NEWSCORE_FIELD_NUMBER = 2;
        private int newScore_;
        public static final int CURRSCORE_FIELD_NUMBER = 3;
        private int currScore_;
        public static final int TOKENCHANGE_FIELD_NUMBER = 4;
        private int tokenChange_;
        public static final int RANKCHANGE_FIELD_NUMBER = 5;
        private int rankChange_;
        public static final int CURRENTRANK_FIELD_NUMBER = 6;
        private int currentRank_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<GameResult> getParserForType() {
            return PARSER;
        }

        public boolean hasResult() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getResult() {
            return this.result_;
        }

        public boolean hasNewScore() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        static {
            defaultInstance.initFields();
        }


        public int getNewScore() {
            return this.newScore_;
        }


        public boolean hasCurrScore() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public int getCurrScore() {
            return this.currScore_;
        }


        public boolean hasTokenChange() {
            return ((this.bitField0_ & 0x8) == 8);
        }


        public int getTokenChange() {
            return this.tokenChange_;
        }


        public boolean hasRankChange() {
            return ((this.bitField0_ & 0x10) == 16);
        }


        public int getRankChange() {
            return this.rankChange_;
        }


        public boolean hasCurrentRank() {
            return ((this.bitField0_ & 0x20) == 32);
        }


        public int getCurrentRank() {
            return this.currentRank_;
        }


        private void initFields() {
            this.result_ = 0;
            this.newScore_ = 0;
            this.currScore_ = 0;
            this.tokenChange_ = 0;
            this.rankChange_ = 0;
            this.currentRank_ = 0;
        }


        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!hasResult()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasNewScore()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasCurrScore()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasTokenChange()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasRankChange()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasCurrentRank()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }


        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeInt32(1, this.result_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeInt32(2, this.newScore_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeInt32(3, this.currScore_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                output.writeInt32(4, this.tokenChange_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                output.writeInt32(5, this.rankChange_);
            }
            if ((this.bitField0_ & 0x20) == 32) {
                output.writeInt32(6, this.currentRank_);
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
                size += CodedOutputStream.computeInt32Size(1, this.result_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size += CodedOutputStream.computeInt32Size(2, this.newScore_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                size += CodedOutputStream.computeInt32Size(3, this.currScore_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                size += CodedOutputStream.computeInt32Size(4, this.tokenChange_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                size += CodedOutputStream.computeInt32Size(5, this.rankChange_);
            }
            if ((this.bitField0_ & 0x20) == 32) {
                size += CodedOutputStream.computeInt32Size(6, this.currentRank_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static GameResult parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GameResult) PARSER.parseFrom(data);
        }


        public static GameResult parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GameResult) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GameResult parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GameResult) PARSER.parseFrom(data);
        }


        public static GameResult parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GameResult) PARSER.parseFrom(data, extensionRegistry);
        }


        public static GameResult parseFrom(InputStream input) throws IOException {
            return (GameResult) PARSER.parseFrom(input);
        }


        public static GameResult parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GameResult) PARSER.parseFrom(input, extensionRegistry);
        }


        public static GameResult parseDelimitedFrom(InputStream input) throws IOException {
            return (GameResult) PARSER.parseDelimitedFrom(input);
        }


        public static GameResult parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GameResult) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static GameResult parseFrom(CodedInputStream input) throws IOException {
            return (GameResult) PARSER.parseFrom(input);
        }


        public static GameResult parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GameResult) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(GameResult prototype) {
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
                implements SoloHandler.GameResultOrBuilder {
            private int bitField0_;


            private int result_;


            private int newScore_;


            private int currScore_;


            private int tokenChange_;


            private int rankChange_;


            private int currentRank_;


            public static final Descriptors.Descriptor getDescriptor() {
                return SoloHandler.internal_static_pomelo_area_GameResult_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return SoloHandler.internal_static_pomelo_area_GameResult_fieldAccessorTable.ensureFieldAccessorsInitialized(SoloHandler.GameResult.class, Builder.class);
            }


            private Builder() {
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (SoloHandler.GameResult.alwaysUseFieldBuilders) ;
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.result_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.newScore_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                this.currScore_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.tokenChange_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                this.rankChange_ = 0;
                this.bitField0_ &= 0xFFFFFFEF;
                this.currentRank_ = 0;
                this.bitField0_ &= 0xFFFFFFDF;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return SoloHandler.internal_static_pomelo_area_GameResult_descriptor;
            }


            public SoloHandler.GameResult getDefaultInstanceForType() {
                return SoloHandler.GameResult.getDefaultInstance();
            }


            public SoloHandler.GameResult build() {
                SoloHandler.GameResult result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public SoloHandler.GameResult buildPartial() {
                SoloHandler.GameResult result = new SoloHandler.GameResult(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.result_ = this.result_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                result.newScore_ = this.newScore_;
                if ((from_bitField0_ & 0x4) == 4) {
                    to_bitField0_ |= 0x4;
                }
                result.currScore_ = this.currScore_;
                if ((from_bitField0_ & 0x8) == 8) {
                    to_bitField0_ |= 0x8;
                }
                result.tokenChange_ = this.tokenChange_;
                if ((from_bitField0_ & 0x10) == 16) {
                    to_bitField0_ |= 0x10;
                }
                result.rankChange_ = this.rankChange_;
                if ((from_bitField0_ & 0x20) == 32) {
                    to_bitField0_ |= 0x20;
                }
                result.currentRank_ = this.currentRank_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof SoloHandler.GameResult) {
                    return mergeFrom((SoloHandler.GameResult) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(SoloHandler.GameResult other) {
                if (other == SoloHandler.GameResult.getDefaultInstance()) {
                    return this;
                }
                if (other.hasResult()) {
                    setResult(other.getResult());
                }
                if (other.hasNewScore()) {
                    setNewScore(other.getNewScore());
                }
                if (other.hasCurrScore()) {
                    setCurrScore(other.getCurrScore());
                }
                if (other.hasTokenChange()) {
                    setTokenChange(other.getTokenChange());
                }
                if (other.hasRankChange()) {
                    setRankChange(other.getRankChange());
                }
                if (other.hasCurrentRank()) {
                    setCurrentRank(other.getCurrentRank());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasResult()) {
                    return false;
                }
                if (!hasNewScore()) {
                    return false;
                }
                if (!hasCurrScore()) {
                    return false;
                }
                if (!hasTokenChange()) {
                    return false;
                }
                if (!hasRankChange()) {
                    return false;
                }
                if (!hasCurrentRank()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                SoloHandler.GameResult parsedMessage = null;
                try {
                    parsedMessage = (SoloHandler.GameResult) SoloHandler.GameResult.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SoloHandler.GameResult) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }


            public boolean hasResult() {
                return ((this.bitField0_ & 0x1) == 1);
            }


            public int getResult() {
                return this.result_;
            }


            public Builder setResult(int value) {
                this.bitField0_ |= 0x1;
                this.result_ = value;
                onChanged();
                return this;
            }


            public Builder clearResult() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.result_ = 0;
                onChanged();
                return this;
            }


            public boolean hasNewScore() {
                return ((this.bitField0_ & 0x2) == 2);
            }


            public int getNewScore() {
                return this.newScore_;
            }


            public Builder setNewScore(int value) {
                this.bitField0_ |= 0x2;
                this.newScore_ = value;
                onChanged();
                return this;
            }


            public Builder clearNewScore() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.newScore_ = 0;
                onChanged();
                return this;
            }


            public boolean hasCurrScore() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public int getCurrScore() {
                return this.currScore_;
            }


            public Builder setCurrScore(int value) {
                this.bitField0_ |= 0x4;
                this.currScore_ = value;
                onChanged();
                return this;
            }


            public Builder clearCurrScore() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.currScore_ = 0;
                onChanged();
                return this;
            }


            public boolean hasTokenChange() {
                return ((this.bitField0_ & 0x8) == 8);
            }


            public int getTokenChange() {
                return this.tokenChange_;
            }


            public Builder setTokenChange(int value) {
                this.bitField0_ |= 0x8;
                this.tokenChange_ = value;
                onChanged();
                return this;
            }


            public Builder clearTokenChange() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.tokenChange_ = 0;
                onChanged();
                return this;
            }


            public boolean hasRankChange() {
                return ((this.bitField0_ & 0x10) == 16);
            }


            public int getRankChange() {
                return this.rankChange_;
            }


            public Builder setRankChange(int value) {
                this.bitField0_ |= 0x10;
                this.rankChange_ = value;
                onChanged();
                return this;
            }


            public Builder clearRankChange() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.rankChange_ = 0;
                onChanged();
                return this;
            }


            public boolean hasCurrentRank() {
                return ((this.bitField0_ & 0x20) == 32);
            }


            public int getCurrentRank() {
                return this.currentRank_;
            }


            public Builder setCurrentRank(int value) {
                this.bitField0_ |= 0x20;
                this.currentRank_ = value;
                onChanged();
                return this;
            }


            public Builder clearCurrentRank() {
                this.bitField0_ &= 0xFFFFFFDF;
                this.currentRank_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class OnGameEndPush
            extends GeneratedMessage
            implements OnGameEndPushOrBuilder {
        private static final OnGameEndPush defaultInstance = new OnGameEndPush(true);
        private final UnknownFieldSet unknownFields;

        private OnGameEndPush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private OnGameEndPush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static OnGameEndPush getDefaultInstance() {
            return defaultInstance;
        }

        public OnGameEndPush getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private OnGameEndPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    SoloHandler.GameResult.Builder subBuilder;
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
                            subBuilder = null;
                            if ((this.bitField0_ & 0x2) == 2) subBuilder = this.s2CGameResult_.toBuilder();
                            this.s2CGameResult_ = (SoloHandler.GameResult) input.readMessage(SoloHandler.GameResult.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.s2CGameResult_);
                                this.s2CGameResult_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 0x2;
                            break;
                        case 24:
                            this.bitField0_ |= 0x4;
                            this.s2CGameOverTime_ = input.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 0x8;
                            this.dailyBattleTimes_ = input.readInt32();
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
            return SoloHandler.internal_static_pomelo_area_OnGameEndPush_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return SoloHandler.internal_static_pomelo_area_OnGameEndPush_fieldAccessorTable.ensureFieldAccessorsInitialized(OnGameEndPush.class, Builder.class);
        }

        public static Parser<OnGameEndPush> PARSER = (Parser<OnGameEndPush>) new AbstractParser<OnGameEndPush>() {
            public SoloHandler.OnGameEndPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SoloHandler.OnGameEndPush(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int S2C_GAMERESULT_FIELD_NUMBER = 2;
        private SoloHandler.GameResult s2CGameResult_;
        public static final int S2C_GAMEOVERTIME_FIELD_NUMBER = 3;
        private int s2CGameOverTime_;
        public static final int DAILYBATTLETIMES_FIELD_NUMBER = 4;
        private int dailyBattleTimes_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<OnGameEndPush> getParserForType() {
            return PARSER;
        }

        public boolean hasS2CCode() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getS2CCode() {
            return this.s2CCode_;
        }

        public boolean hasS2CGameResult() {
            return ((this.bitField0_ & 0x2) == 2);
        }

        static {
            defaultInstance.initFields();
        }


        public SoloHandler.GameResult getS2CGameResult() {
            return this.s2CGameResult_;
        }


        public SoloHandler.GameResultOrBuilder getS2CGameResultOrBuilder() {
            return this.s2CGameResult_;
        }


        public boolean hasS2CGameOverTime() {
            return ((this.bitField0_ & 0x4) == 4);
        }


        public int getS2CGameOverTime() {
            return this.s2CGameOverTime_;
        }


        public boolean hasDailyBattleTimes() {
            return ((this.bitField0_ & 0x8) == 8);
        }


        public int getDailyBattleTimes() {
            return this.dailyBattleTimes_;
        }


        private void initFields() {
            this.s2CCode_ = 0;
            this.s2CGameResult_ = SoloHandler.GameResult.getDefaultInstance();
            this.s2CGameOverTime_ = 0;
            this.dailyBattleTimes_ = 0;
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
            if (!hasS2CGameResult()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasS2CGameOverTime()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!getS2CGameResult().isInitialized()) {
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
                output.writeMessage(2, (MessageLite) this.s2CGameResult_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeInt32(3, this.s2CGameOverTime_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                output.writeInt32(4, this.dailyBattleTimes_);
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
                size += CodedOutputStream.computeMessageSize(2, (MessageLite) this.s2CGameResult_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                size += CodedOutputStream.computeInt32Size(3, this.s2CGameOverTime_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                size += CodedOutputStream.computeInt32Size(4, this.dailyBattleTimes_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }


        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }


        public static OnGameEndPush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (OnGameEndPush) PARSER.parseFrom(data);
        }


        public static OnGameEndPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (OnGameEndPush) PARSER.parseFrom(data, extensionRegistry);
        }


        public static OnGameEndPush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (OnGameEndPush) PARSER.parseFrom(data);
        }


        public static OnGameEndPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (OnGameEndPush) PARSER.parseFrom(data, extensionRegistry);
        }


        public static OnGameEndPush parseFrom(InputStream input) throws IOException {
            return (OnGameEndPush) PARSER.parseFrom(input);
        }


        public static OnGameEndPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OnGameEndPush) PARSER.parseFrom(input, extensionRegistry);
        }


        public static OnGameEndPush parseDelimitedFrom(InputStream input) throws IOException {
            return (OnGameEndPush) PARSER.parseDelimitedFrom(input);
        }


        public static OnGameEndPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OnGameEndPush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }


        public static OnGameEndPush parseFrom(CodedInputStream input) throws IOException {
            return (OnGameEndPush) PARSER.parseFrom(input);
        }


        public static OnGameEndPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OnGameEndPush) PARSER.parseFrom(input, extensionRegistry);
        }


        public static Builder newBuilder() {
            return Builder.create();
        }


        public Builder newBuilderForType() {
            return newBuilder();
        }


        public static Builder newBuilder(OnGameEndPush prototype) {
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
                implements SoloHandler.OnGameEndPushOrBuilder {
            private int bitField0_;


            private int s2CCode_;


            private SoloHandler.GameResult s2CGameResult_;


            private SingleFieldBuilder<SoloHandler.GameResult, SoloHandler.GameResult.Builder, SoloHandler.GameResultOrBuilder> s2CGameResultBuilder_;


            private int s2CGameOverTime_;


            private int dailyBattleTimes_;


            public static final Descriptors.Descriptor getDescriptor() {
                return SoloHandler.internal_static_pomelo_area_OnGameEndPush_descriptor;
            }


            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return SoloHandler.internal_static_pomelo_area_OnGameEndPush_fieldAccessorTable.ensureFieldAccessorsInitialized(SoloHandler.OnGameEndPush.class, Builder.class);
            }


            private Builder() {
                this.s2CGameResult_ = SoloHandler.GameResult.getDefaultInstance();
                maybeForceBuilderInitialization();
            }


            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.s2CGameResult_ = SoloHandler.GameResult.getDefaultInstance();
                maybeForceBuilderInitialization();
            }


            private void maybeForceBuilderInitialization() {
                if (SoloHandler.OnGameEndPush.alwaysUseFieldBuilders) {
                    getS2CGameResultFieldBuilder();
                }
            }


            private static Builder create() {
                return new Builder();
            }


            public Builder clear() {
                super.clear();
                this.s2CCode_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                if (this.s2CGameResultBuilder_ == null) {
                    this.s2CGameResult_ = SoloHandler.GameResult.getDefaultInstance();
                } else {
                    this.s2CGameResultBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFD;
                this.s2CGameOverTime_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.dailyBattleTimes_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }


            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }


            public Descriptors.Descriptor getDescriptorForType() {
                return SoloHandler.internal_static_pomelo_area_OnGameEndPush_descriptor;
            }


            public SoloHandler.OnGameEndPush getDefaultInstanceForType() {
                return SoloHandler.OnGameEndPush.getDefaultInstance();
            }


            public SoloHandler.OnGameEndPush build() {
                SoloHandler.OnGameEndPush result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }


            public SoloHandler.OnGameEndPush buildPartial() {
                SoloHandler.OnGameEndPush result = new SoloHandler.OnGameEndPush(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 0x1;
                }
                result.s2CCode_ = this.s2CCode_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 0x2;
                }
                if (this.s2CGameResultBuilder_ == null) {
                    result.s2CGameResult_ = this.s2CGameResult_;
                } else {
                    result.s2CGameResult_ = (SoloHandler.GameResult) this.s2CGameResultBuilder_.build();
                }
                if ((from_bitField0_ & 0x4) == 4) {
                    to_bitField0_ |= 0x4;
                }
                result.s2CGameOverTime_ = this.s2CGameOverTime_;
                if ((from_bitField0_ & 0x8) == 8) {
                    to_bitField0_ |= 0x8;
                }
                result.dailyBattleTimes_ = this.dailyBattleTimes_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }


            public Builder mergeFrom(Message other) {
                if (other instanceof SoloHandler.OnGameEndPush) {
                    return mergeFrom((SoloHandler.OnGameEndPush) other);
                }
                super.mergeFrom(other);
                return this;
            }


            public Builder mergeFrom(SoloHandler.OnGameEndPush other) {
                if (other == SoloHandler.OnGameEndPush.getDefaultInstance()) {
                    return this;
                }
                if (other.hasS2CCode()) {
                    setS2CCode(other.getS2CCode());
                }
                if (other.hasS2CGameResult()) {
                    mergeS2CGameResult(other.getS2CGameResult());
                }
                if (other.hasS2CGameOverTime()) {
                    setS2CGameOverTime(other.getS2CGameOverTime());
                }
                if (other.hasDailyBattleTimes()) {
                    setDailyBattleTimes(other.getDailyBattleTimes());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }


            public final boolean isInitialized() {
                if (!hasS2CCode()) {
                    return false;
                }
                if (!hasS2CGameResult()) {
                    return false;
                }
                if (!hasS2CGameOverTime()) {
                    return false;
                }
                if (!getS2CGameResult().isInitialized()) {
                    return false;
                }
                return true;
            }


            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                SoloHandler.OnGameEndPush parsedMessage = null;
                try {
                    parsedMessage = (SoloHandler.OnGameEndPush) SoloHandler.OnGameEndPush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SoloHandler.OnGameEndPush) e.getUnfinishedMessage();
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


            public boolean hasS2CGameResult() {
                return ((this.bitField0_ & 0x2) == 2);
            }


            public SoloHandler.GameResult getS2CGameResult() {
                if (this.s2CGameResultBuilder_ == null) {
                    return this.s2CGameResult_;
                }
                return (SoloHandler.GameResult) this.s2CGameResultBuilder_.getMessage();
            }


            public Builder setS2CGameResult(SoloHandler.GameResult value) {
                if (this.s2CGameResultBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.s2CGameResult_ = value;
                    onChanged();
                } else {
                    this.s2CGameResultBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x2;
                return this;
            }


            public Builder setS2CGameResult(SoloHandler.GameResult.Builder builderForValue) {
                if (this.s2CGameResultBuilder_ == null) {
                    this.s2CGameResult_ = builderForValue.build();
                    onChanged();
                } else {
                    this.s2CGameResultBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x2;
                return this;
            }


            public Builder mergeS2CGameResult(SoloHandler.GameResult value) {
                if (this.s2CGameResultBuilder_ == null) {
                    if ((this.bitField0_ & 0x2) == 2 && this.s2CGameResult_ != SoloHandler.GameResult.getDefaultInstance()) {
                        this.s2CGameResult_ = SoloHandler.GameResult.newBuilder(this.s2CGameResult_).mergeFrom(value).buildPartial();
                    } else {
                        this.s2CGameResult_ = value;
                    }
                    onChanged();
                } else {
                    this.s2CGameResultBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 0x2;
                return this;
            }


            public Builder clearS2CGameResult() {
                if (this.s2CGameResultBuilder_ == null) {
                    this.s2CGameResult_ = SoloHandler.GameResult.getDefaultInstance();
                    onChanged();
                } else {
                    this.s2CGameResultBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }


            public SoloHandler.GameResult.Builder getS2CGameResultBuilder() {
                this.bitField0_ |= 0x2;
                onChanged();
                return (SoloHandler.GameResult.Builder) getS2CGameResultFieldBuilder().getBuilder();
            }


            public SoloHandler.GameResultOrBuilder getS2CGameResultOrBuilder() {
                if (this.s2CGameResultBuilder_ != null) {
                    return (SoloHandler.GameResultOrBuilder) this.s2CGameResultBuilder_.getMessageOrBuilder();
                }
                return this.s2CGameResult_;
            }


            private SingleFieldBuilder<SoloHandler.GameResult, SoloHandler.GameResult.Builder, SoloHandler.GameResultOrBuilder> getS2CGameResultFieldBuilder() {
                if (this.s2CGameResultBuilder_ == null) {
                    this.s2CGameResultBuilder_ = new SingleFieldBuilder(getS2CGameResult(), getParentForChildren(), isClean());
                    this.s2CGameResult_ = null;
                }
                return this.s2CGameResultBuilder_;
            }


            public boolean hasS2CGameOverTime() {
                return ((this.bitField0_ & 0x4) == 4);
            }


            public int getS2CGameOverTime() {
                return this.s2CGameOverTime_;
            }


            public Builder setS2CGameOverTime(int value) {
                this.bitField0_ |= 0x4;
                this.s2CGameOverTime_ = value;
                onChanged();
                return this;
            }


            public Builder clearS2CGameOverTime() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.s2CGameOverTime_ = 0;
                onChanged();
                return this;
            }


            public boolean hasDailyBattleTimes() {
                return ((this.bitField0_ & 0x8) == 8);
            }


            public int getDailyBattleTimes() {
                return this.dailyBattleTimes_;
            }


            public Builder setDailyBattleTimes(int value) {
                this.bitField0_ |= 0x8;
                this.dailyBattleTimes_ = value;
                onChanged();
                return this;
            }


            public Builder clearDailyBattleTimes() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.dailyBattleTimes_ = 0;
                onChanged();
                return this;
            }
        }
    }


    public static final class LeftSoloTimePush
            extends GeneratedMessage
            implements LeftSoloTimePushOrBuilder {
        private static final LeftSoloTimePush defaultInstance = new LeftSoloTimePush(true);
        private final UnknownFieldSet unknownFields;

        private LeftSoloTimePush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private LeftSoloTimePush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static LeftSoloTimePush getDefaultInstance() {
            return defaultInstance;
        }

        public LeftSoloTimePush getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private LeftSoloTimePush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.openList_ = new ArrayList<>();
                                mutable_bitField0_ |= 0x2;
                            }
                            this.openList_.add(input.readMessage(Common.OpenTimeInfo.PARSER, extensionRegistry));
                            break;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw (new InvalidProtocolBufferException(e.getMessage())).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x2) == 2) this.openList_ = Collections.unmodifiableList(this.openList_);
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SoloHandler.internal_static_pomelo_area_LeftSoloTimePush_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return SoloHandler.internal_static_pomelo_area_LeftSoloTimePush_fieldAccessorTable.ensureFieldAccessorsInitialized(LeftSoloTimePush.class, Builder.class);
        }

        public static Parser<LeftSoloTimePush> PARSER = (Parser<LeftSoloTimePush>) new AbstractParser<LeftSoloTimePush>() {
            public SoloHandler.LeftSoloTimePush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SoloHandler.LeftSoloTimePush(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        public static final int OPENLIST_FIELD_NUMBER = 2;
        private List<Common.OpenTimeInfo> openList_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<LeftSoloTimePush> getParserForType() {
            return PARSER;
        }

        public boolean hasS2CCode() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getS2CCode() {
            return this.s2CCode_;
        }

        public List<Common.OpenTimeInfo> getOpenListList() {
            return this.openList_;
        }

        public List<? extends Common.OpenTimeInfoOrBuilder> getOpenListOrBuilderList() {
            return (List) this.openList_;
        }

        static {
            defaultInstance.initFields();
        }

        public int getOpenListCount() {
            return this.openList_.size();
        }

        public Common.OpenTimeInfo getOpenList(int index) {
            return this.openList_.get(index);
        }

        public Common.OpenTimeInfoOrBuilder getOpenListOrBuilder(int index) {
            return (Common.OpenTimeInfoOrBuilder) this.openList_.get(index);
        }

        private void initFields() {
            this.s2CCode_ = 0;
            this.openList_ = Collections.emptyList();
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
            for (int i = 0; i < this.openList_.size(); i++)
                output.writeMessage(2, (MessageLite) this.openList_.get(i));
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1)
                return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1)
                size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            for (int i = 0; i < this.openList_.size(); i++)
                size += CodedOutputStream.computeMessageSize(2, (MessageLite) this.openList_.get(i));
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static LeftSoloTimePush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (LeftSoloTimePush) PARSER.parseFrom(data);
        }

        public static LeftSoloTimePush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (LeftSoloTimePush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static LeftSoloTimePush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (LeftSoloTimePush) PARSER.parseFrom(data);
        }

        public static LeftSoloTimePush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (LeftSoloTimePush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static LeftSoloTimePush parseFrom(InputStream input) throws IOException {
            return (LeftSoloTimePush) PARSER.parseFrom(input);
        }

        public static LeftSoloTimePush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LeftSoloTimePush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static LeftSoloTimePush parseDelimitedFrom(InputStream input) throws IOException {
            return (LeftSoloTimePush) PARSER.parseDelimitedFrom(input);
        }

        public static LeftSoloTimePush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LeftSoloTimePush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static LeftSoloTimePush parseFrom(CodedInputStream input) throws IOException {
            return (LeftSoloTimePush) PARSER.parseFrom(input);
        }

        public static LeftSoloTimePush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LeftSoloTimePush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(LeftSoloTimePush prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements SoloHandler.LeftSoloTimePushOrBuilder {
            private int bitField0_;
            private int s2CCode_;
            private List<Common.OpenTimeInfo> openList_;
            private RepeatedFieldBuilder<Common.OpenTimeInfo, Common.OpenTimeInfo.Builder, Common.OpenTimeInfoOrBuilder> openListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SoloHandler.internal_static_pomelo_area_LeftSoloTimePush_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return SoloHandler.internal_static_pomelo_area_LeftSoloTimePush_fieldAccessorTable.ensureFieldAccessorsInitialized(SoloHandler.LeftSoloTimePush.class, Builder.class);
            }

            private Builder() {
                this.openList_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.openList_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SoloHandler.LeftSoloTimePush.alwaysUseFieldBuilders)
                    getOpenListFieldBuilder();
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.s2CCode_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                if (this.openListBuilder_ == null) {
                    this.openList_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFD;
                } else {
                    this.openListBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return SoloHandler.internal_static_pomelo_area_LeftSoloTimePush_descriptor;
            }

            public SoloHandler.LeftSoloTimePush getDefaultInstanceForType() {
                return SoloHandler.LeftSoloTimePush.getDefaultInstance();
            }

            public SoloHandler.LeftSoloTimePush build() {
                SoloHandler.LeftSoloTimePush result = buildPartial();
                if (!result.isInitialized())
                    throw newUninitializedMessageException(result);
                return result;
            }

            public SoloHandler.LeftSoloTimePush buildPartial() {
                SoloHandler.LeftSoloTimePush result = new SoloHandler.LeftSoloTimePush(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1)
                    to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                if (this.openListBuilder_ == null) {
                    if ((this.bitField0_ & 0x2) == 2) {
                        this.openList_ = Collections.unmodifiableList(this.openList_);
                        this.bitField0_ &= 0xFFFFFFFD;
                    }
                    result.openList_ = this.openList_;
                } else {
                    result.openList_ = this.openListBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof SoloHandler.LeftSoloTimePush)
                    return mergeFrom((SoloHandler.LeftSoloTimePush) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SoloHandler.LeftSoloTimePush other) {
                if (other == SoloHandler.LeftSoloTimePush.getDefaultInstance())
                    return this;
                if (other.hasS2CCode())
                    setS2CCode(other.getS2CCode());
                if (this.openListBuilder_ == null) {
                    if (!other.openList_.isEmpty()) {
                        if (this.openList_.isEmpty()) {
                            this.openList_ = other.openList_;
                            this.bitField0_ &= 0xFFFFFFFD;
                        } else {
                            ensureOpenListIsMutable();
                            this.openList_.addAll(other.openList_);
                        }
                        onChanged();
                    }
                } else if (!other.openList_.isEmpty()) {
                    if (this.openListBuilder_.isEmpty()) {
                        this.openListBuilder_.dispose();
                        this.openListBuilder_ = null;
                        this.openList_ = other.openList_;
                        this.bitField0_ &= 0xFFFFFFFD;
                        this.openListBuilder_ = SoloHandler.LeftSoloTimePush.alwaysUseFieldBuilders ? getOpenListFieldBuilder() : null;
                    } else {
                        this.openListBuilder_.addAllMessages(other.openList_);
                    }
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
                SoloHandler.LeftSoloTimePush parsedMessage = null;
                try {
                    parsedMessage = (SoloHandler.LeftSoloTimePush) SoloHandler.LeftSoloTimePush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SoloHandler.LeftSoloTimePush) e.getUnfinishedMessage();
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

            private void ensureOpenListIsMutable() {
                if ((this.bitField0_ & 0x2) != 2) {
                    this.openList_ = new ArrayList<>(this.openList_);
                    this.bitField0_ |= 0x2;
                }
            }

            public List<Common.OpenTimeInfo> getOpenListList() {
                if (this.openListBuilder_ == null)
                    return Collections.unmodifiableList(this.openList_);
                return this.openListBuilder_.getMessageList();
            }

            public int getOpenListCount() {
                if (this.openListBuilder_ == null)
                    return this.openList_.size();
                return this.openListBuilder_.getCount();
            }

            public Common.OpenTimeInfo getOpenList(int index) {
                if (this.openListBuilder_ == null)
                    return this.openList_.get(index);
                return (Common.OpenTimeInfo) this.openListBuilder_.getMessage(index);
            }

            public Builder setOpenList(int index, Common.OpenTimeInfo value) {
                if (this.openListBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureOpenListIsMutable();
                    this.openList_.set(index, value);
                    onChanged();
                } else {
                    this.openListBuilder_.setMessage(index, (GeneratedMessage) value);
                }
                return this;
            }

            public Builder setOpenList(int index, Common.OpenTimeInfo.Builder builderForValue) {
                if (this.openListBuilder_ == null) {
                    ensureOpenListIsMutable();
                    this.openList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.openListBuilder_.setMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addOpenList(Common.OpenTimeInfo value) {
                if (this.openListBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureOpenListIsMutable();
                    this.openList_.add(value);
                    onChanged();
                } else {
                    this.openListBuilder_.addMessage((GeneratedMessage) value);
                }
                return this;
            }

            public Builder addOpenList(int index, Common.OpenTimeInfo value) {
                if (this.openListBuilder_ == null) {
                    if (value == null)
                        throw new NullPointerException();
                    ensureOpenListIsMutable();
                    this.openList_.add(index, value);
                    onChanged();
                } else {
                    this.openListBuilder_.addMessage(index, (GeneratedMessage) value);
                }
                return this;
            }

            public Builder addOpenList(Common.OpenTimeInfo.Builder builderForValue) {
                if (this.openListBuilder_ == null) {
                    ensureOpenListIsMutable();
                    this.openList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.openListBuilder_.addMessage((GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addOpenList(int index, Common.OpenTimeInfo.Builder builderForValue) {
                if (this.openListBuilder_ == null) {
                    ensureOpenListIsMutable();
                    this.openList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.openListBuilder_.addMessage(index, (GeneratedMessage) builderForValue.build());
                }
                return this;
            }

            public Builder addAllOpenList(Iterable<? extends Common.OpenTimeInfo> values) {
                if (this.openListBuilder_ == null) {
                    ensureOpenListIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.openList_);
                    onChanged();
                } else {
                    this.openListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearOpenList() {
                if (this.openListBuilder_ == null) {
                    this.openList_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFD;
                    onChanged();
                } else {
                    this.openListBuilder_.clear();
                }
                return this;
            }

            public Builder removeOpenList(int index) {
                if (this.openListBuilder_ == null) {
                    ensureOpenListIsMutable();
                    this.openList_.remove(index);
                    onChanged();
                } else {
                    this.openListBuilder_.remove(index);
                }
                return this;
            }

            public Common.OpenTimeInfo.Builder getOpenListBuilder(int index) {
                return (Common.OpenTimeInfo.Builder) getOpenListFieldBuilder().getBuilder(index);
            }

            public Common.OpenTimeInfoOrBuilder getOpenListOrBuilder(int index) {
                if (this.openListBuilder_ == null)
                    return (Common.OpenTimeInfoOrBuilder) this.openList_.get(index);
                return (Common.OpenTimeInfoOrBuilder) this.openListBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends Common.OpenTimeInfoOrBuilder> getOpenListOrBuilderList() {
                if (this.openListBuilder_ != null)
                    return this.openListBuilder_.getMessageOrBuilderList();
                return (List) Collections.unmodifiableList(this.openList_);
            }

            public Common.OpenTimeInfo.Builder addOpenListBuilder() {
                return (Common.OpenTimeInfo.Builder) getOpenListFieldBuilder().addBuilder((GeneratedMessage) Common.OpenTimeInfo.getDefaultInstance());
            }

            public Common.OpenTimeInfo.Builder addOpenListBuilder(int index) {
                return (Common.OpenTimeInfo.Builder) getOpenListFieldBuilder().addBuilder(index, (GeneratedMessage) Common.OpenTimeInfo.getDefaultInstance());
            }

            public List<Common.OpenTimeInfo.Builder> getOpenListBuilderList() {
                return getOpenListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<Common.OpenTimeInfo, Common.OpenTimeInfo.Builder, Common.OpenTimeInfoOrBuilder> getOpenListFieldBuilder() {
                if (this.openListBuilder_ == null) {
                    this.openListBuilder_ = new RepeatedFieldBuilder(this.openList_, ((this.bitField0_ & 0x2) == 2), getParentForChildren(), isClean());
                    this.openList_ = null;
                }
                return this.openListBuilder_;
            }
        }
    }

    public static final class CancelMatchPush extends GeneratedMessage implements CancelMatchPushOrBuilder {
        private static final CancelMatchPush defaultInstance = new CancelMatchPush(true);
        private final UnknownFieldSet unknownFields;

        private CancelMatchPush(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private CancelMatchPush(boolean noInit) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static CancelMatchPush getDefaultInstance() {
            return defaultInstance;
        }

        public CancelMatchPush getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CancelMatchPush(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return SoloHandler.internal_static_pomelo_area_CancelMatchPush_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return SoloHandler.internal_static_pomelo_area_CancelMatchPush_fieldAccessorTable.ensureFieldAccessorsInitialized(CancelMatchPush.class, Builder.class);
        }

        public static Parser<CancelMatchPush> PARSER = (Parser<CancelMatchPush>) new AbstractParser<CancelMatchPush>() {
            public SoloHandler.CancelMatchPush parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SoloHandler.CancelMatchPush(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int S2C_CODE_FIELD_NUMBER = 1;
        private int s2CCode_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private static final long serialVersionUID = 0L;

        public Parser<CancelMatchPush> getParserForType() {
            return PARSER;
        }

        public boolean hasS2CCode() {
            return ((this.bitField0_ & 0x1) == 1);
        }

        public int getS2CCode() {
            return this.s2CCode_;
        }

        private void initFields() {
            this.s2CCode_ = 0;
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
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) return size;
            size = 0;
            if ((this.bitField0_ & 0x1) == 1) size += CodedOutputStream.computeInt32Size(1, this.s2CCode_);
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static CancelMatchPush parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (CancelMatchPush) PARSER.parseFrom(data);
        }

        public static CancelMatchPush parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (CancelMatchPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static CancelMatchPush parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (CancelMatchPush) PARSER.parseFrom(data);
        }

        public static CancelMatchPush parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (CancelMatchPush) PARSER.parseFrom(data, extensionRegistry);
        }

        public static CancelMatchPush parseFrom(InputStream input) throws IOException {
            return (CancelMatchPush) PARSER.parseFrom(input);
        }

        public static CancelMatchPush parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CancelMatchPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static CancelMatchPush parseDelimitedFrom(InputStream input) throws IOException {
            return (CancelMatchPush) PARSER.parseDelimitedFrom(input);
        }

        public static CancelMatchPush parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CancelMatchPush) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static CancelMatchPush parseFrom(CodedInputStream input) throws IOException {
            return (CancelMatchPush) PARSER.parseFrom(input);
        }

        public static CancelMatchPush parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CancelMatchPush) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CancelMatchPush prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements SoloHandler.CancelMatchPushOrBuilder {
            private int bitField0_;
            private int s2CCode_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SoloHandler.internal_static_pomelo_area_CancelMatchPush_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return SoloHandler.internal_static_pomelo_area_CancelMatchPush_fieldAccessorTable.ensureFieldAccessorsInitialized(SoloHandler.CancelMatchPush.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SoloHandler.CancelMatchPush.alwaysUseFieldBuilders) ;
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.s2CCode_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return SoloHandler.internal_static_pomelo_area_CancelMatchPush_descriptor;
            }

            public SoloHandler.CancelMatchPush getDefaultInstanceForType() {
                return SoloHandler.CancelMatchPush.getDefaultInstance();
            }

            public SoloHandler.CancelMatchPush build() {
                SoloHandler.CancelMatchPush result = buildPartial();
                if (!result.isInitialized()) throw newUninitializedMessageException(result);
                return result;
            }

            public SoloHandler.CancelMatchPush buildPartial() {
                SoloHandler.CancelMatchPush result = new SoloHandler.CancelMatchPush(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) to_bitField0_ |= 0x1;
                result.s2CCode_ = this.s2CCode_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof SoloHandler.CancelMatchPush) return mergeFrom((SoloHandler.CancelMatchPush) other);
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SoloHandler.CancelMatchPush other) {
                if (other == SoloHandler.CancelMatchPush.getDefaultInstance()) return this;
                if (other.hasS2CCode()) setS2CCode(other.getS2CCode());
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasS2CCode()) return false;
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                SoloHandler.CancelMatchPush parsedMessage = null;
                try {
                    parsedMessage = (SoloHandler.CancelMatchPush) SoloHandler.CancelMatchPush.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SoloHandler.CancelMatchPush) e.getUnfinishedMessage();
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
        }

        static {
            defaultInstance.initFields();
        }
    }


    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }


    static {
        String[] descriptorData = {"\n\021soloHandler.proto\022\013pomelo.area\032\fcommon.proto\"c\n\bRankItem\022\f\n\004rank\030\001 \002(\005\022\020\n\bplayerId\030\002 \002(\t\022\f\n\004name\030\003 \002(\t\022\013\n\003pro\030\004 \002(\005\022\r\n\005level\030\005 \002(\005\022\r\n\005score\030\006 \001(\005\"\002\n\006MyInfo\022\f\n\004rank\030\001 \002(\005\022\r\n\005score\030\002 \002(\005\022\027\n\017maxContWinTimes\030\003 \002(\005\022\030\n\020maxContLoseTimes\030\004 \002(\005\022\023\n\013battleTimes\030\005 \002(\005\022\025\n\rwinTotalTimes\030\006 \002(\005\022\026\n\016loseTotalTimes\030\007 \002(\005\022\025\n\rseasonEndTime\030\b \002(\t\022\017\n\007myToken\030\t \002(\005\022\022\n\ntodayToken\030\n \002(\005\022\020\n\bmaxToken\030\013 \002(\005\022\024\n\favgMatchTime", "\030\f \001(\005\022\025\n\rstartJoinTime\030\r \001(\005\",\n\nRankReward\022\016\n\006rankId\030\001 \002(\005\022\016\n\006status\030\002 \002(\005\"\021\n\017SoloInfoRequest\"^\n\020SoloInfoResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022'\n\ns2c_myInfo\030\003 \001(\0132\023.pomelo.area.MyInfo\")\n\bNewsInfo\022\f\n\004date\030\001 \002(\t\022\017\n\007message\030\002 \003(\t\"\021\n\017NewsInfoRequest\"f\n\020NewsInfoResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022/\n\020s2c_soloMessages\030\003 \003(\0132\025.pomelo.area.NewsInfo\"\025\n\023BattleRecordRequest\"\001\n\fBattleRecord\022\016\n\006", "result\030\001 \002(\005\022\022\n\nbattleTime\030\002 \002(\t\022\r\n\005score\030\003 \002(\005\022\023\n\013scoreChange\030\004 \002(\005\022\016\n\006vsName\030\005 \002(\t\022\023\n\013vsGuildName\030\006 \002(\t\022\r\n\005vsPro\030\007 \002(\005\022\017\n\007vsScore\030\b \002(\005\"Õ\001\n\024BattleRecordResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\024\n\fs2c_canglang\030\003 \001(\005\022\022\n\ns2c_yixian\030\004 \001(\005\022\022\n\ns2c_yujian\030\005 \001(\005\022\022\n\ns2c_linghu\030\006 \001(\005\022\024\n\fs2c_shenjian\030\007 \001(\005\0222\n\017s2c_batttleList\030\b \003(\0132\031.pomelo.area.BattleRecord\"\023\n\021RewardInfoRequest\"4\n\017DailyRewardItem\022\020\n\bite", "mCode\030\001 \002(\t\022\017\n\007itemNum\030\002 \002(\005\"^\n\017SoloDailyReward\022\016\n\006rankId\030\001 \002(\005\022\016\n\006status\030\002 \002(\005\022+\n\005items\030\003 \003(\0132\034.pomelo.area.DailyRewardItem\"Õ\001\n\022RewardInfoResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\0220\n\017s2c_rankRewards\030\003 \003(\0132\027.pomelo.area.RankReward\022\024\n\fs2c_currRank\030\004 \001(\005\0226\n\020s2c_dailyRewards\030\005 \003(\0132\034.pomelo.area.SoloDailyReward\022\034\n\024s2c_dailyBattleTimes\030\006 \001(\005\"+\n\025DrawRankRewardRequest\022\022\n\nc2s_rankId\030\001 \002(\005\";\n\026DrawRankRew", "ardResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"+\n\026DrawDailyRewardRequest\022\021\n\tc2s_index\030\001 \002(\005\"x\n\027DrawDailyRewardResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022:\n\024s2c_dailyRewardItems\030\003 \003(\0132\034.pomelo.area.DailyRewardItem\"\021\n\017JoinSoloRequest\"j\n\020JoinSoloResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\030\n\020s2c_avgMatchTime\030\003 \001(\005\022\031\n\021s2c_startJoinTime\030\004 \001(\005\"\027\n\025JoinSoloBattleRequest\";\n\026JoinSoloBattleResponse\022\020\n\bs2c_c", "ode\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"\021\n\017QuitSoloRequest\"5\n\020QuitSoloResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"\024\n\022QueryRewardRequest\"O\n\023QueryRewardResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\022\025\n\rs2c_hasReward\030\003 \001(\005\"\026\n\024LeaveSoloAreaRequest\":\n\025LeaveSoloAreaResponse\022\020\n\bs2c_code\030\001 \002(\005\022\017\n\007s2c_msg\030\002 \001(\t\"Ö\001\n\021OnSoloMatchedPush\022\020\n\bs2c_code\030\001 \002(\005\022\030\n\020s2c_vsPlayerName\030\002 \002(\t\022\027\n\017s2c_vsPlayerPro\030\003 \002(\005\022\031\n\021s2c_vsPlayerLevel\030", "\004 \002(\005\022+\n\023s2c_vsPlayerAvatars\030\005 \003(\0132\016.pomelo.Avatar\022\037\n\027s2c_waitResponseTimeSec\030\006 \002(\005\022\023\n\013s2c_isRobot\030\007 \001(\005\"\001\n\024GetRivalInfoResponse\022\020\n\bs2c_code\030\001 \002(\005\022\030\n\020s2c_vsPlayerName\030\002 \002(\t\022\027\n\017s2c_vsPlayerPro\030\003 \002(\005\022\031\n\021s2c_vsPlayerLevel\030\004 \002(\005\022\017\n\007s2c_msg\030\005 \001(\t\"#\n\017OnNewRewardPush\022\020\n\bs2c_code\030\001 \002(\005\"<\n\020OnFightPointPush\022\020\n\bs2c_code\030\001 \002(\005\022\026\n\016s2c_fightPoint\030\002 \002(\005\"W\n\013RoundResult\022\016\n\006result\030\001 \002(\005\022\022\n\nmyWinTimes\030\002 \002(\005\022\022\n\nvsWi", "nTimes\030\003 \002(\005\022\020\n\bleftTime\030\004 \002(\005\"U\n\016OnRoundEndPush\022\020\n\bs2c_code\030\001 \002(\005\0221\n\017s2c_roundResult\030\002 \002(\0132\030.pomelo.area.RoundResult\"\n\nGameResult\022\016\n\006result\030\001 \002(\005\022\020\n\bnewScore\030\002 \002(\005\022\021\n\tcurrScore\030\003 \002(\005\022\023\n\013tokenChange\030\004 \002(\005\022\022\n\nrankChange\030\005 \002(\005\022\023\n\013currentRank\030\006 \002(\005\"\001\n\rOnGameEndPush\022\020\n\bs2c_code\030\001 \002(\005\022/\n\016s2c_gameResult\030\002 \002(\0132\027.pomelo.area.GameResult\022\030\n\020s2c_gameOverTime\030\003 \002(\005\022\030\n\020dailyBattleTimes\030\004 \001(\005\"L\n\020LeftSoloTimeP", "ush\022\020\n\bs2c_code\030\001 \002(\005\022&\n\bopenList\030\002 \003(\0132\024.pomelo.OpenTimeInfo\"#\n\017CancelMatchPush\022\020\n\bs2c_code\030\001 \002(\0052¨\b\n\013soloHandler\022N\n\017soloInfoRequest\022\034.pomelo.area.SoloInfoRequest\032\035.pomelo.area.SoloInfoResponse\022T\n\021rewardInfoRequest\022\036.pomelo.area.RewardInfoRequest\032\037.pomelo.area.RewardInfoResponse\022`\n\025drawRankRewardRequest\022\".pomelo.area.DrawRankRewardRequest\032#.pomelo.area.DrawRankRewardResponse\022c\n\026drawDailyRewardReq", "uest\022#.pomelo.area.DrawDailyRewardRequest\032$.pomelo.area.DrawDailyRewardResponse\022N\n\017joinSoloRequest\022\034.pomelo.area.JoinSoloRequest\032\035.pomelo.area.JoinSoloResponse\022`\n\025joinSoloBattleRequest\022\".pomelo.area.JoinSoloBattleRequest\032#.pomelo.area.JoinSoloBattleResponse\022N\n\017quitSoloRequest\022\034.pomelo.area.QuitSoloRequest\032\035.pomelo.area.QuitSoloResponse\022W\n\022queryRewardRequest\022\037.pomelo.area.QueryRewardRequest\032 .pomel", "o.area.QueryRewardResponse\022]\n\024leaveSoloAreaRequest\022!.pomelo.area.LeaveSoloAreaRequest\032\".pomelo.area.LeaveSoloAreaResponse\022N\n\017newsInfoRequest\022\034.pomelo.area.NewsInfoRequest\032\035.pomelo.area.NewsInfoResponse\022Z\n\023battleRecordRequest\022 .pomelo.area.BattleRecordRequest\032!.pomelo.area.BattleRecordResponse\022F\n\023getRivalInfoRequest\022\f.pomelo.Void\032!.pomelo.area.GetRivalInfoResponse2Å\003\n\bsoloPush\022A\n\021onSoloMatchedPush\022", "\036.pomelo.area.OnSoloMatchedPush\032\f.pomelo.Void\022=\n\017onNewRewardPush\022\034.pomelo.area.OnNewRewardPush\032\f.pomelo.Void\022?\n\020onFightPointPush\022\035.pomelo.area.OnFightPointPush\032\f.pomelo.Void\022;\n\016onRoundEndPush\022\033.pomelo.area.OnRoundEndPush\032\f.pomelo.Void\0229\n\ronGameEndPush\022\032.pomelo.area.OnGameEndPush\032\f.pomelo.Void\022?\n\020leftSoloTimePush\022\035.pomelo.area.LeftSoloTimePush\032\f.pomelo.Void\022=\n\017cancelMatchPush\022\034.pomelo.area.CancelMa", "tchPush\032\f.pomelo.Void"};


        Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root) {
                SoloHandler.descriptor = root;
                return null;
            }
        };

        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[]{

                Common.getDescriptor()}, assigner);
    }

    private static final Descriptors.Descriptor internal_static_pomelo_area_RankItem_descriptor = getDescriptor().getMessageTypes().get(0);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_RankItem_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_RankItem_descriptor, new String[]{"Rank", "PlayerId", "Name", "Pro", "Level", "Score"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_MyInfo_descriptor = getDescriptor().getMessageTypes().get(1);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_MyInfo_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_MyInfo_descriptor, new String[]{"Rank", "Score", "MaxContWinTimes", "MaxContLoseTimes", "BattleTimes", "WinTotalTimes", "LoseTotalTimes", "SeasonEndTime", "MyToken", "TodayToken", "MaxToken", "AvgMatchTime", "StartJoinTime"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_RankReward_descriptor = getDescriptor().getMessageTypes().get(2);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_RankReward_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_RankReward_descriptor, new String[]{"RankId", "Status"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_SoloInfoRequest_descriptor = getDescriptor().getMessageTypes().get(3);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_SoloInfoRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_SoloInfoRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_area_SoloInfoResponse_descriptor = getDescriptor().getMessageTypes().get(4);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_SoloInfoResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_SoloInfoResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CMyInfo"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_NewsInfo_descriptor = getDescriptor().getMessageTypes().get(5);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_NewsInfo_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_NewsInfo_descriptor, new String[]{"Date", "Message"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_NewsInfoRequest_descriptor = getDescriptor().getMessageTypes().get(6);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_NewsInfoRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_NewsInfoRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_area_NewsInfoResponse_descriptor = getDescriptor().getMessageTypes().get(7);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_NewsInfoResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_NewsInfoResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CSoloMessages"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_BattleRecordRequest_descriptor = getDescriptor().getMessageTypes().get(8);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_BattleRecordRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_BattleRecordRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_area_BattleRecord_descriptor = getDescriptor().getMessageTypes().get(9);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_BattleRecord_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_BattleRecord_descriptor, new String[]{"Result", "BattleTime", "Score", "ScoreChange", "VsName", "VsGuildName", "VsPro", "VsScore"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_BattleRecordResponse_descriptor = getDescriptor().getMessageTypes().get(10);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_BattleRecordResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_BattleRecordResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CCanglang", "S2CYixian", "S2CYujian", "S2CLinghu", "S2CShenjian", "S2CBatttleList"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_RewardInfoRequest_descriptor = getDescriptor().getMessageTypes().get(11);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_RewardInfoRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_RewardInfoRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_area_DailyRewardItem_descriptor = getDescriptor().getMessageTypes().get(12);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_DailyRewardItem_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_DailyRewardItem_descriptor, new String[]{"ItemCode", "ItemNum"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_SoloDailyReward_descriptor = getDescriptor().getMessageTypes().get(13);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_SoloDailyReward_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_SoloDailyReward_descriptor, new String[]{"RankId", "Status", "Items"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_RewardInfoResponse_descriptor = getDescriptor().getMessageTypes().get(14);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_RewardInfoResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_RewardInfoResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CRankRewards", "S2CCurrRank", "S2CDailyRewards", "S2CDailyBattleTimes"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_DrawRankRewardRequest_descriptor = getDescriptor().getMessageTypes().get(15);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_DrawRankRewardRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_DrawRankRewardRequest_descriptor, new String[]{"C2SRankId"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_DrawRankRewardResponse_descriptor = getDescriptor().getMessageTypes().get(16);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_DrawRankRewardResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_DrawRankRewardResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_DrawDailyRewardRequest_descriptor = getDescriptor().getMessageTypes().get(17);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_DrawDailyRewardRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_DrawDailyRewardRequest_descriptor, new String[]{"C2SIndex"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_DrawDailyRewardResponse_descriptor = getDescriptor().getMessageTypes().get(18);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_DrawDailyRewardResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_DrawDailyRewardResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CDailyRewardItems"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_JoinSoloRequest_descriptor = getDescriptor().getMessageTypes().get(19);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_JoinSoloRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_JoinSoloRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_area_JoinSoloResponse_descriptor = getDescriptor().getMessageTypes().get(20);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_JoinSoloResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_JoinSoloResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CAvgMatchTime", "S2CStartJoinTime"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_JoinSoloBattleRequest_descriptor = getDescriptor().getMessageTypes().get(21);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_JoinSoloBattleRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_JoinSoloBattleRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_area_JoinSoloBattleResponse_descriptor = getDescriptor().getMessageTypes().get(22);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_JoinSoloBattleResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_JoinSoloBattleResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_QuitSoloRequest_descriptor = getDescriptor().getMessageTypes().get(23);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_QuitSoloRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_QuitSoloRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_area_QuitSoloResponse_descriptor = getDescriptor().getMessageTypes().get(24);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_QuitSoloResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_QuitSoloResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_QueryRewardRequest_descriptor = getDescriptor().getMessageTypes().get(25);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_QueryRewardRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_QueryRewardRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_area_QueryRewardResponse_descriptor = getDescriptor().getMessageTypes().get(26);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_QueryRewardResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_QueryRewardResponse_descriptor, new String[]{"S2CCode", "S2CMsg", "S2CHasReward"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_LeaveSoloAreaRequest_descriptor = getDescriptor().getMessageTypes().get(27);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_LeaveSoloAreaRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_LeaveSoloAreaRequest_descriptor, new String[0]);


    private static final Descriptors.Descriptor internal_static_pomelo_area_LeaveSoloAreaResponse_descriptor = getDescriptor().getMessageTypes().get(28);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_LeaveSoloAreaResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_LeaveSoloAreaResponse_descriptor, new String[]{"S2CCode", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_OnSoloMatchedPush_descriptor = getDescriptor().getMessageTypes().get(29);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_OnSoloMatchedPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_OnSoloMatchedPush_descriptor, new String[]{"S2CCode", "S2CVsPlayerName", "S2CVsPlayerPro", "S2CVsPlayerLevel", "S2CVsPlayerAvatars", "S2CWaitResponseTimeSec", "S2CIsRobot"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GetRivalInfoResponse_descriptor = getDescriptor().getMessageTypes().get(30);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GetRivalInfoResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GetRivalInfoResponse_descriptor, new String[]{"S2CCode", "S2CVsPlayerName", "S2CVsPlayerPro", "S2CVsPlayerLevel", "S2CMsg"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_OnNewRewardPush_descriptor = getDescriptor().getMessageTypes().get(31);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_OnNewRewardPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_OnNewRewardPush_descriptor, new String[]{"S2CCode"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_OnFightPointPush_descriptor = getDescriptor().getMessageTypes().get(32);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_OnFightPointPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_OnFightPointPush_descriptor, new String[]{"S2CCode", "S2CFightPoint"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_RoundResult_descriptor = getDescriptor().getMessageTypes().get(33);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_RoundResult_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_RoundResult_descriptor, new String[]{"Result", "MyWinTimes", "VsWinTimes", "LeftTime"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_OnRoundEndPush_descriptor = getDescriptor().getMessageTypes().get(34);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_OnRoundEndPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_OnRoundEndPush_descriptor, new String[]{"S2CCode", "S2CRoundResult"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_GameResult_descriptor = getDescriptor().getMessageTypes().get(35);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_GameResult_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_GameResult_descriptor, new String[]{"Result", "NewScore", "CurrScore", "TokenChange", "RankChange", "CurrentRank"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_OnGameEndPush_descriptor = getDescriptor().getMessageTypes().get(36);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_OnGameEndPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_OnGameEndPush_descriptor, new String[]{"S2CCode", "S2CGameResult", "S2CGameOverTime", "DailyBattleTimes"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_LeftSoloTimePush_descriptor = getDescriptor().getMessageTypes().get(37);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_LeftSoloTimePush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_LeftSoloTimePush_descriptor, new String[]{"S2CCode", "OpenList"});


    private static final Descriptors.Descriptor internal_static_pomelo_area_CancelMatchPush_descriptor = getDescriptor().getMessageTypes().get(38);
    private static GeneratedMessage.FieldAccessorTable internal_static_pomelo_area_CancelMatchPush_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(internal_static_pomelo_area_CancelMatchPush_descriptor, new String[]{"S2CCode"});
    private static Descriptors.FileDescriptor descriptor;

    static {
        Common.getDescriptor();
    }

    public static interface CancelMatchPushOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();
    }

    public static interface LeftSoloTimePushOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        List<Common.OpenTimeInfo> getOpenListList();

        Common.OpenTimeInfo getOpenList(int param1Int);

        int getOpenListCount();

        List<? extends Common.OpenTimeInfoOrBuilder> getOpenListOrBuilderList();

        Common.OpenTimeInfoOrBuilder getOpenListOrBuilder(int param1Int);
    }

    public static interface OnGameEndPushOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CGameResult();

        SoloHandler.GameResult getS2CGameResult();

        SoloHandler.GameResultOrBuilder getS2CGameResultOrBuilder();

        boolean hasS2CGameOverTime();

        int getS2CGameOverTime();

        boolean hasDailyBattleTimes();

        int getDailyBattleTimes();
    }

    public static interface GameResultOrBuilder extends MessageOrBuilder {
        boolean hasResult();

        int getResult();

        boolean hasNewScore();

        int getNewScore();

        boolean hasCurrScore();

        int getCurrScore();

        boolean hasTokenChange();

        int getTokenChange();

        boolean hasRankChange();

        int getRankChange();

        boolean hasCurrentRank();

        int getCurrentRank();
    }

    public static interface OnRoundEndPushOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CRoundResult();

        SoloHandler.RoundResult getS2CRoundResult();

        SoloHandler.RoundResultOrBuilder getS2CRoundResultOrBuilder();
    }

    public static interface RoundResultOrBuilder extends MessageOrBuilder {
        boolean hasResult();

        int getResult();

        boolean hasMyWinTimes();

        int getMyWinTimes();

        boolean hasVsWinTimes();

        int getVsWinTimes();

        boolean hasLeftTime();

        int getLeftTime();
    }

    public static interface OnFightPointPushOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CFightPoint();

        int getS2CFightPoint();
    }

    public static interface OnNewRewardPushOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();
    }

    public static interface GetRivalInfoResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CVsPlayerName();

        String getS2CVsPlayerName();

        ByteString getS2CVsPlayerNameBytes();

        boolean hasS2CVsPlayerPro();

        int getS2CVsPlayerPro();

        boolean hasS2CVsPlayerLevel();

        int getS2CVsPlayerLevel();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface OnSoloMatchedPushOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CVsPlayerName();

        String getS2CVsPlayerName();

        ByteString getS2CVsPlayerNameBytes();

        boolean hasS2CVsPlayerPro();

        int getS2CVsPlayerPro();

        boolean hasS2CVsPlayerLevel();

        int getS2CVsPlayerLevel();

        List<Common.Avatar> getS2CVsPlayerAvatarsList();

        Common.Avatar getS2CVsPlayerAvatars(int param1Int);

        int getS2CVsPlayerAvatarsCount();

        List<? extends Common.AvatarOrBuilder> getS2CVsPlayerAvatarsOrBuilderList();

        Common.AvatarOrBuilder getS2CVsPlayerAvatarsOrBuilder(int param1Int);

        boolean hasS2CWaitResponseTimeSec();

        int getS2CWaitResponseTimeSec();

        boolean hasS2CIsRobot();

        int getS2CIsRobot();
    }

    public static interface LeaveSoloAreaResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface LeaveSoloAreaRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface QueryRewardResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasS2CHasReward();

        int getS2CHasReward();
    }

    public static interface QueryRewardRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface QuitSoloResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface QuitSoloRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface JoinSoloBattleResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface JoinSoloBattleRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface JoinSoloResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasS2CAvgMatchTime();

        int getS2CAvgMatchTime();

        boolean hasS2CStartJoinTime();

        int getS2CStartJoinTime();
    }

    public static interface JoinSoloRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface DrawDailyRewardResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        List<SoloHandler.DailyRewardItem> getS2CDailyRewardItemsList();

        SoloHandler.DailyRewardItem getS2CDailyRewardItems(int param1Int);

        int getS2CDailyRewardItemsCount();

        List<? extends SoloHandler.DailyRewardItemOrBuilder> getS2CDailyRewardItemsOrBuilderList();

        SoloHandler.DailyRewardItemOrBuilder getS2CDailyRewardItemsOrBuilder(int param1Int);
    }

    public static interface DrawDailyRewardRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2SIndex();

        int getC2SIndex();
    }

    public static interface DrawRankRewardResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();
    }

    public static interface DrawRankRewardRequestOrBuilder extends MessageOrBuilder {
        boolean hasC2SRankId();

        int getC2SRankId();
    }

    public static interface RewardInfoResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        List<SoloHandler.RankReward> getS2CRankRewardsList();

        SoloHandler.RankReward getS2CRankRewards(int param1Int);

        int getS2CRankRewardsCount();

        List<? extends SoloHandler.RankRewardOrBuilder> getS2CRankRewardsOrBuilderList();

        SoloHandler.RankRewardOrBuilder getS2CRankRewardsOrBuilder(int param1Int);

        boolean hasS2CCurrRank();

        int getS2CCurrRank();

        List<SoloHandler.SoloDailyReward> getS2CDailyRewardsList();

        SoloHandler.SoloDailyReward getS2CDailyRewards(int param1Int);

        int getS2CDailyRewardsCount();

        List<? extends SoloHandler.SoloDailyRewardOrBuilder> getS2CDailyRewardsOrBuilderList();

        SoloHandler.SoloDailyRewardOrBuilder getS2CDailyRewardsOrBuilder(int param1Int);

        boolean hasS2CDailyBattleTimes();

        int getS2CDailyBattleTimes();
    }

    public static interface SoloDailyRewardOrBuilder extends MessageOrBuilder {
        boolean hasRankId();

        int getRankId();

        boolean hasStatus();

        int getStatus();

        List<SoloHandler.DailyRewardItem> getItemsList();

        SoloHandler.DailyRewardItem getItems(int param1Int);

        int getItemsCount();

        List<? extends SoloHandler.DailyRewardItemOrBuilder> getItemsOrBuilderList();

        SoloHandler.DailyRewardItemOrBuilder getItemsOrBuilder(int param1Int);
    }

    public static interface DailyRewardItemOrBuilder extends MessageOrBuilder {
        boolean hasItemCode();

        String getItemCode();

        ByteString getItemCodeBytes();

        boolean hasItemNum();

        int getItemNum();
    }

    public static interface RewardInfoRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface BattleRecordResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasS2CCanglang();

        int getS2CCanglang();

        boolean hasS2CYixian();

        int getS2CYixian();

        boolean hasS2CYujian();

        int getS2CYujian();

        boolean hasS2CLinghu();

        int getS2CLinghu();

        boolean hasS2CShenjian();

        int getS2CShenjian();

        List<SoloHandler.BattleRecord> getS2CBatttleListList();

        SoloHandler.BattleRecord getS2CBatttleList(int param1Int);

        int getS2CBatttleListCount();

        List<? extends SoloHandler.BattleRecordOrBuilder> getS2CBatttleListOrBuilderList();

        SoloHandler.BattleRecordOrBuilder getS2CBatttleListOrBuilder(int param1Int);
    }

    public static interface BattleRecordOrBuilder extends MessageOrBuilder {
        boolean hasResult();

        int getResult();

        boolean hasBattleTime();

        String getBattleTime();

        ByteString getBattleTimeBytes();

        boolean hasScore();

        int getScore();

        boolean hasScoreChange();

        int getScoreChange();

        boolean hasVsName();

        String getVsName();

        ByteString getVsNameBytes();

        boolean hasVsGuildName();

        String getVsGuildName();

        ByteString getVsGuildNameBytes();

        boolean hasVsPro();

        int getVsPro();

        boolean hasVsScore();

        int getVsScore();
    }

    public static interface BattleRecordRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface NewsInfoResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        List<SoloHandler.NewsInfo> getS2CSoloMessagesList();

        SoloHandler.NewsInfo getS2CSoloMessages(int param1Int);

        int getS2CSoloMessagesCount();

        List<? extends SoloHandler.NewsInfoOrBuilder> getS2CSoloMessagesOrBuilderList();

        SoloHandler.NewsInfoOrBuilder getS2CSoloMessagesOrBuilder(int param1Int);
    }

    public static interface NewsInfoRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface NewsInfoOrBuilder extends MessageOrBuilder {
        boolean hasDate();

        String getDate();

        ByteString getDateBytes();

        ProtocolStringList getMessageList();

        int getMessageCount();

        String getMessage(int param1Int);

        ByteString getMessageBytes(int param1Int);
    }

    public static interface SoloInfoResponseOrBuilder extends MessageOrBuilder {
        boolean hasS2CCode();

        int getS2CCode();

        boolean hasS2CMsg();

        String getS2CMsg();

        ByteString getS2CMsgBytes();

        boolean hasS2CMyInfo();

        SoloHandler.MyInfo getS2CMyInfo();

        SoloHandler.MyInfoOrBuilder getS2CMyInfoOrBuilder();
    }

    public static interface SoloInfoRequestOrBuilder extends MessageOrBuilder {
    }

    public static interface RankRewardOrBuilder extends MessageOrBuilder {
        boolean hasRankId();

        int getRankId();

        boolean hasStatus();

        int getStatus();
    }

    public static interface MyInfoOrBuilder extends MessageOrBuilder {
        boolean hasRank();

        int getRank();

        boolean hasScore();

        int getScore();

        boolean hasMaxContWinTimes();

        int getMaxContWinTimes();

        boolean hasMaxContLoseTimes();

        int getMaxContLoseTimes();

        boolean hasBattleTimes();

        int getBattleTimes();

        boolean hasWinTotalTimes();

        int getWinTotalTimes();

        boolean hasLoseTotalTimes();

        int getLoseTotalTimes();

        boolean hasSeasonEndTime();

        String getSeasonEndTime();

        ByteString getSeasonEndTimeBytes();

        boolean hasMyToken();

        int getMyToken();

        boolean hasTodayToken();

        int getTodayToken();

        boolean hasMaxToken();

        int getMaxToken();

        boolean hasAvgMatchTime();

        int getAvgMatchTime();

        boolean hasStartJoinTime();

        int getStartJoinTime();
    }

    public static interface RankItemOrBuilder extends MessageOrBuilder {
        boolean hasRank();

        int getRank();

        boolean hasPlayerId();

        String getPlayerId();

        ByteString getPlayerIdBytes();

        boolean hasName();

        String getName();

        ByteString getNameBytes();

        boolean hasPro();

        int getPro();

        boolean hasLevel();

        int getLevel();

        boolean hasScore();

        int getScore();
    }
}


